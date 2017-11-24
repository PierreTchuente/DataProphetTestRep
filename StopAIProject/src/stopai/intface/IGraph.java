package stopai.intface;
import java.util.Iterator;

import stopai.model.Edges;
import stopai.model.Vertex;

/**
 * 
 */

/**
 * @author TCHUENTE
 *
 */
public interface IGraph<V,E> {
	/**
	 * 
	 * @param v
	 * @return an iterable collection of the edges incident
	 * upon vertex v. this can tell us how many friend a user
	 * will have since identify by vertex.
	 */
	public Iterator<Edges<E>> IncidentEdges(Vertex<V> v);
	/**
	 * 
	 * @param v
	 * @param w
	 * @return true if vertices v and w are adjacent and false otherwise.
	 * this methods will help find out if two persons are friend or not.
	 * 
	 */
	public boolean areAdjacent(Vertex<V> v,Vertex<V> w);
	/**
	 * 
	 * @param x
	 * @return the new inserted vertex x(person) in the Graph.
	 * without creating a relationship.
	 */
	public Vertex<V> insertVertex(Vertex<V> x);
	/**
	 * 
	 * @param v
	 * @param w
	 * @param x
	 * insert a new edges in the graph between v and w containing the element x.
	 * this will help us create a friendship between two users.
	 */ 
	public void InsertEdge(Vertex<V> v,Vertex<V> w,E x);
	/**
	 * 
	 * @param e
	 * @return the edge remove from the graph.
	 * this methods will help up end up a friendship
	 * between users without removing them from the
	 * network(Graph)
	 */
	public E removeEdge(Edges<E> e);
	
	/**
	 * 
	 * @param v
	 * @return the vertex remove from the graph and all its 
	 * incident edges.
	 * this method will help us remove a user and destroy all relate
	 * relationship with other users.
	 */
	public V removeVertex(Vertex<V> v);
	/**
	 * 
	 * @return the number of vertex (users) in the graph
	 */
	public int size();
	
 
}
