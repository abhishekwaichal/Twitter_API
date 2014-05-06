/**
 * 
 */
package com.tweet.domain;

/**
 * @author Abhishek
 *
 */
public class Follow {

	User following;

	User follower;

	public Follow(User following, User follower) {
		super();
		this.following = following;
		this.follower = follower;
	}

	public User getFollowing() {
		return following;
	}

	public void setFollowing(User following) {
		this.following = following;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	@Override
	public String toString() {
		return "Follow [following=" + following + ", follower=" + follower
				+ "]";
	}
	
	
}
