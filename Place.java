public class Place {
	private String[] placeName = new String[3];
	private int[] maxSeat = new int[3];
	private int[] currentNum = new int[3];
	private Seat[][] seat = new Seat[3][];
	
	public Place(){
		this.placeName[0] = "�а� 101ȣ";
		this.maxSeat[0] = 60;
		seat[0] = new Seat[this.maxSeat[0]];
		this.currentNum[0] = 0;
		
		this.placeName[1] = "�а� 104ȣ";
		this.maxSeat[1] = 80;
		seat[1] = new Seat[this.maxSeat[1]];
		this.currentNum[1] = 0;
		
		this.placeName[2] = "ä��";
		this.maxSeat[2] = 1000;
		seat[2] = new Seat[this.maxSeat[1]];
		this.currentNum[2] = 0;
	}
	
	public String getPlaceName(int place){
		return this.placeName[place];
	}
	
	public int getMaxSeat(int placeNum){
		return this.maxSeat[placeNum];
	}
	
	public void setCurrentNum(int place, int num){
		this.currentNum[place] = num;
	}
	
	public int getCurrentNum(int placeNum){
		return this.currentNum[placeNum];
	}
	
	public Seat[] getSeat(int placeNum){
		return this.seat[placeNum];
	}
}