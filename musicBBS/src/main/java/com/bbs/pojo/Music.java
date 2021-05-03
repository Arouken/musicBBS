package com.bbs.pojo;

public class Music {

	private int musicID;
	private String musicName;
	private String musicSinger;
	//×¨¼­Ãû
    private String album;
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicSinger() {
		return musicSinger;
	}
	public void setMusicSinger(String musicSinger) {
		this.musicSinger = musicSinger;
	}
	
	public int getMusicID() {
		return musicID;
	}
	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
}
