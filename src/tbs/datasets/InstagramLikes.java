package tbs.datasets;

public class InstagramLikes {
	/*
	 * Raw data on the number of posts made to Instagram each day of the month, and the number of likes received.
	 */
	
	public static final int[] POSTS_PER_DAY = new int[] {
			11, 12, 12, 12, 18, 14, 12, 17, 17, 19, 19, 15, 17, 7, 11, 14, 20, 17, 13, 9, 13, 14, 16, 16, 10, 10, 19,
			19, 13
	};
	
	public static final int[] LIKES_PER_DAY = new int[] {
			159, 157, 162, 145, 238, 210, 189, 246, 263, 259, 292, 208, 253, 106, 145, 197, 286, 214, 177, 146, 172,
			201, 220, 218, 140, 135, 245, 269, 166
	};
	
	public static final int NUM_DATA = POSTS_PER_DAY.length;
}
