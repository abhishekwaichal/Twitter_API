/**
 * 
 */
package com.tweet.domain;

/**
 * 
 * @author Abhishek
 * 
 * Follow:
 * Serves to hold 'follow' values from records retrieved from database table 'follow'.   
 * Part of MODEL  layer
 * 
 */
public class Follow {

	private Integer follower_id;

	private Integer following_id;


	public Follow(Integer follower_idIN, Integer following_idIN) {
		super();
			this.follower_id = follower_idIN;
			this.following_id = following_idIN;
}

	public Integer getFollowing() {
		return following_id;
	}


	public void setFollowing(Integer following_idIN) {
		this.following_id = following_idIN;
	}

	public Integer getFollower() {
		return follower_id;
	}


	public void setFollower(Integer follower_idIN) {
		this.follower_id = follower_idIN;
	}

	@Override
	public String toString() {
		return "Follow [following=" + following_id + ", follower=" + follower_id
				+ "]";
	}
	
}
