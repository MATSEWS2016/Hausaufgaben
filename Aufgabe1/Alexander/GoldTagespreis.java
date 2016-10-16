public class GoldTagespreis {

    private static final String NO_PRICE = "kein Nachweis";

    private String datum;
    private String preis;

    public GoldTagespreis(String datum, String preis) {
        this.datum = datum;
        this.preis = preis.replaceAll("\\.", "").replaceAll(",", "\\.");
    }

    public String getDatum() {
        return datum;
    }

    public String getPreis() {
        if (preis.equals(NO_PRICE)) {
            return "-1";
        }
        return preis;
    }

    public String toString() {
        return "Datum: " + datum + "  Preis:" + preis;
    }

    public GoldTagespreis compare(GoldTagespreis com, boolean bigger) {
        double myPrice = Double.valueOf(getPreis());
        double hisPrice = Double.valueOf(com.getPreis());
        if (hisPrice == -1) {
            return this;
        }

        GoldTagespreis retval;
        if (bigger) {
            retval = myPrice > hisPrice ? this : com;
        }
        else{
            retval = myPrice < hisPrice ? this : com;
        }
        
        return retval;
    }
}
