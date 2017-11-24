package stopai.model;
import java.util.ArrayList;
import stopai.List_Iter_Col.Position;

/**
 * 
 */

/**
 * @author TCHUENTE
 * represents the edge object in
 * the graph his element will later
 * represent the relationship between 
 * two or more than two user
 *
 */
public class Edges<E> extends Node<E>{
    
	private ArrayList<Vertex<?>> VertexList = null;
	private Position<Edges<E>> currentPosition = null; // position of this edge in the EdgesCollection
	
	public Edges() {
		// TODO Auto-generated constructor stub
		VertexList = new ArrayList<Vertex<?>>();
		this.currentPosition = null;
	}
	
	
	
	/**
	 * @return the currentPosition
	 */
	public Position<Edges<E>> getCurrentPosition() {
		return currentPosition;
	}


	/**
	 * @param currentPosition the currentPosition to set
	 */
	public void setCurrentPosition(Position<Edges<E>> currentPosition) {
		this.currentPosition = currentPosition;
	}

	/**
	 * @return the vertexList
	 */
	public ArrayList<Vertex<?>> getVertexList() {
		return VertexList;
	}

	/**
	 * @param vertexList the vertexList to set
	 */
	public void setVertexList(ArrayList<Vertex<?>> vertexList) {
		VertexList = vertexList;
	}

}
