package com.bbs.pojo;

public class Music {

	private int musicID;//����ID
	private String musicName;//������
	private String musicOtherName;//��������ֹ�ϴ�ʱͬ������
	private String singer;//������
	private String album;//ר����	
	private String musicImgName;//����ͼƬ
	
    public String getMusicOtherName() {
		return musicOtherName;
	}
	public void setMusicOtherName(String musicOtherName) {
		this.musicOtherName = musicOtherName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
    
    
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
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
	public String getMusicImgName() {
		return musicImgName;
	}
	public void setMusicImgName(String musicImgName) {
		this.musicImgName = musicImgName;
	}
}
