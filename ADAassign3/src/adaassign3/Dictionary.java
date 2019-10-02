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
public interface Dictionary {
    //insets an element that implements comparable
    public Object insert(Comparable o);
    
    //removes an element
    public void delete(Object handle);
    
    /* Searches for an element with a given key.  Depending on the
     * type of element inserted into the dictionary, the type of the
     * key given to this method may be the same as the type of the
     * objects inserted, or the type of the key given to this method
     * may be a different type than the type of the objects inserted
     * but still can be compared to the type of the inserted objects.
     * For example, see {@link DynamicSetElement.Helper#compareTo}. */
    public Object search(Comparable k);
    
}
