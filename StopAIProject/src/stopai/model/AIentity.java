/**
 * 
 */
package stopai.model;

/**
 * @author TCHUENTE
 *
 */
public class AIentity {

private	int xPost = 0;
private	int yPost = 0;
private int AInumber = 0;

public AIentity(int xPost, int yPost, int aInumber) {
	this.xPost = xPost;
	this.yPost = yPost;
	AInumber = aInumber;
}


public int getAInumber() {
	return AInumber;
}
public void setAInumber(int aInumber) {
	AInumber = aInumber;
}
public int getxPost() {
	return xPost;
}
public void setxPost(int xPost) {
	this.xPost = xPost;
}
public int getyPost() {
	return yPost;
}
public void setyPost(int yPost) {
	this.yPost = yPost;
}
	
	
}
