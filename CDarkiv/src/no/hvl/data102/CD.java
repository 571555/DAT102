package no.hvl.data102;

public class CD {

	private int nr;
	private String artist;
	private String tittel;
	private int år;
	private Sjanger sjanger;
	private String plateselskap;
	
	
	
	public void setNr(int nr) {
		this.nr = nr;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public void setÅr(int år) {
		this.år = år;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	public void setPlatesleskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}
	
	public int getnr(){
		return nr;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public int getÅr() {
		return år;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public String getPlateselskap() {
		return plateselskap;
	}
}
