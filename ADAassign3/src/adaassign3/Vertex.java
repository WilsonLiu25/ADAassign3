/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaassign3;

/**
 *
 * @author will2
 */
import java.util.Set;

public interface Vertex<E>
{
   // returns the element held in the vertex
   public E getUserObject();
   // sets the element held in the vertex
   public void setUserObject(E element);
   // returns the edges connecting with this vertex as a Set
   public Set<Edge<E>> incidentEdges();
   // returns the vertices that are adjacent to this vertex as a Set
   public Set<Vertex<E>> adjacentVertices();
   // returns whether specified vertex is adjacent to this vertex
   public boolean isAdjacent(Vertex<?> vertex);
}
