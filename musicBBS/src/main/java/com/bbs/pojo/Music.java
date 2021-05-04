package com.bbs.pojo;

public class Music {

	private int musicID;//歌曲ID
	private String musicName;//歌曲名
	private String musicOtherName;//别名，防止上传时同名覆盖
	private String singer;//歌手名
	private String album;//专辑名	
	private String musicImgName;//歌曲图片
	
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
