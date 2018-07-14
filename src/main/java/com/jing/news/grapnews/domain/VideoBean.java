package com.jing.news.grapnews.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "video")
public class VideoBean {
    @Id
	private int voideoid;
	private int videoaddress;

	public int getVoideoid() {
		return voideoid;
	}

	public void setVoideoid(int voideoid) {
		this.voideoid = voideoid;
	}

	public int getVideoaddress() {
		return videoaddress;
	}

	public void setVideoaddress(int videoaddress) {
		this.videoaddress = videoaddress;
	}

}
