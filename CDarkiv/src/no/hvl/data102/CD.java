package no.hvl.data102;

public class CD {

	private int nr;
	private String artist;
	private String tittel;
	private int �r;
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
	
	public void set�r(int �r) {
		this.�r = �r;
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
	
	public int get�r() {
		return �r;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public String getPlateselskap() {
		return plateselskap;
	}
}
