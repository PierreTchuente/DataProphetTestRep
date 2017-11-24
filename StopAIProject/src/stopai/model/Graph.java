package stopai.model;
import java.util.ArrayList;
import java.util.Iterator;

import stopai.List_Iter_Col.EdgesCollection;
import stopai.List_Iter_Col.Position;
import stopai.List_Iter_Col.VertexCollection;
import stopai.intface.IGraph;

/**
 * 
 */

/**
 * @author TCHUENTE
 *
 */
public class Graph<V, E> implements IGraph<V, E> {

	private VertexCollection<Vertex<V>> vertices = null;
	private EdgesCollection<Edges<E>> edges = null;
	int size = 0;

	/**
	 * Default constructor for the graph.
	 * 
	 */
	public Graph() {
		// TODO Auto-generated constructor stub
		this.vertices = new VertexCollection<Vertex<V>>();
		this.edges = new EdgesCollection<Edges<E>>();
		this.size = 0;
	}

	/**
	 * @param vertices
	 * @param edges
	 */
	public Graph(VertexCollection<Vertex<V>> vertices,
			EdgesCollection<Edges<E>> edges) {

		this.vertices = vertices;
		this.edges = edges;
		this.size = 0;
	}
	

	/**
	 * @return the vertices
	 */
	public VertexCollection<Vertex<V>> getVertices() {
		return vertices;
	}


	/**
	 * @return the edges
	 */
	public EdgesCollection<Edges<E>> getEdges() {
		return edges;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IGraph#IncidentEdges(Vertex)
	 */
	@Override
	public Iterator<Edges<E>> IncidentEdges(Vertex<V> v) {
		// TODO Auto-generated method stub
		//PositionList<Edges<V>> edges = new PositionList<Edges<V>>();
		ArrayList<Edges<E>> edges = new ArrayList<Edges<E>>();
	    for (Edges<?> edges2 : v.getListOfEdges()) {
			edges.add((Edges<E>) edges2);
		} 
		
		return edges.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IGraph#areAdjacent(Vertex, Vertex)
	 */
	@Override
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) {
		// TODO Auto-generated method stub
	    int lv = v.getListOfEdges().size();
	    int lw = w.getListOfEdges().size();
	    if(lv > lw){
	    	for (int i = 0; i < lw; i++) {
				if(v.getListOfEdges().contains((w.getListOfEdges().get(i))) || w.getListOfEdges().contains((v.getListOfEdges().get(i)))){
					return true;
				}
			}
	    }else{
	    	for (int i = 0; i < lv; i++) {
				if(v.getListOfEdges().contains((w.getListOfEdges().get(i))) || w.getListOfEdges().contains((v.getListOfEdges().get(i)))){				
					return true;
				}
			}
	    }
		
		return false;
	}

	@Override
	public Vertex<V> insertVertex(Vertex<V> newVertex) {
		// TODO Auto-generated method stub
		vertices.addLast(newVertex);
		newVertex.setCurrentPosition(vertices.search(newVertex));
		size++;
		return newVertex;
	}

	@Override
	public void InsertEdge(Vertex<V> v, Vertex<V> w, E x) {
		// TODO Auto-generated method stub
		Position<Vertex<V>> posv = vertices.search(v);
		Position<Vertex<V>> posw = vertices.search(w);
		if(posv!=null && posw!=null){
			Edges<E> newEdge = new Edges<E>();
			newEdge.setElement(x);
			v.getListOfEdges().add(newEdge);
			w.getListOfEdges().add(newEdge);
		}
			
	
	}

	@Override
	public E removeEdge(Edges<E> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V removeVertex(Vertex<V> v) {
		// TODO Auto-generated method stub
		v.setListOfEdges(null);
		Position<Vertex<V>> p = this.vertices.search(v);
		vertices.remove(p);
		size--;
		return p.element().element();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
