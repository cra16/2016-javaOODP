public class Place {
	private String[] placeName = {"학관 101호", "학관 104호", "채플"};
	private int[] maxSeat = {60, 80, 1000};
	private int placeNum;
	
	public Place(int placeNum){
		this.placeName = placeName;
	}

	public String getPlaceName() {
		return placeName[this.placeNum];
	}

	public int getMaxSeat() {
		return maxSeat[this.placeNum];
	}
}
