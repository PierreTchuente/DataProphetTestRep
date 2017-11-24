package stopai.model;
import java.util.ArrayList;

import stopai.List_Iter_Col.Position;

/**
 * 
 */

/**
 * @author TCHUENTE
 *Vertex object in the graph.
 *his element here will be represent 
 *later by a user
 * @param <E>
 */
public class Vertex<V> extends Node<V> {

	
	private ArrayList<Edges<?>> ListOfEdges = null; // collection of edges incident to this vertex
	private Position<Vertex<V>> currentPosition = null;  // position of this vertex in the VertexCollection
	
	public Vertex() {
		// TODO Auto-generated constructor stub
		ListOfEdges = new ArrayList<Edges<?>>();
		
	}

	/**
	 * @param <E>
	 * @return the listOfEdges
	 */
	public  ArrayList<Edges<?>> getListOfEdges() {
		return ListOfEdges;
	}

	/**
	 * @param listOfEdges the listOfEdges to set
	 */
	public void setListOfEdges(ArrayList<Edges<?>> listOfEdges) {
		ListOfEdges = listOfEdges;
	}

	/**
	 * @return the currentPosition
	 */
	public Position<Vertex<V>> getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * @param position the currentPosition to set
	 */
	public void setCurrentPosition(Position<Vertex<V>> position) {
		this.currentPosition = position;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.element().toString();
	}
	
}
