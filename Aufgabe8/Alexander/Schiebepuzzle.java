import java.util.Arrays;

public class Schiebepuzzle {
	int[][] field;
	int freeField = 15;
	
	public Schiebepuzzle(){
		int[][] tempField = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,-1}};
		field = tempField.clone();
	}
	
	public void schiebe(int i){
		WrongNumberException.check(i);
		if(istVerschiebbar(i)){
			int pos = positionOf(i);
			update(freeField, i);
			update(pos, -1);
			freeField = pos;
		}else{
			throw new WrongMoveException();
		}
	}
	
	private void update(int position, int value){
		int x = ((int)position/4);
		int y = position % 4;
		field[x][y] = value;
	}
	
	public boolean istVerschiebbar(int i){
		WrongNumberException.check(i);
		int position = positionOf(i);
		if(position + 4 == freeField || position -4 == freeField){
			return true;
		}else if((freeField == position+1)){
			return !((position+1)%4 == 0);
		}else if(freeField == position-1){
			return !((position)%4 == 0);
		}
		return false;
	}
	
	public void mische(){
		
	}
	
	private int positionOf(int i){
		int retval = 0;
		for(int[] row : field){
			for(int pos = 0;pos<4;pos++){
				if(row[pos] == i){
					return retval;
				}
				retval ++;
			}
		}
		return -1;
	}
	
	public String toString(){
		return Arrays.deepToString(field);
	}
}
