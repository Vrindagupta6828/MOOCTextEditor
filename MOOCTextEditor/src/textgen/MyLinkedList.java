package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		size=0;
		head.next=tail;
		tail.prev=head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element==null)
			  throw new NullPointerException();
		LLNode<E> n0=new LLNode<E>(element);
		n0.next=tail;
		n0.prev=tail.prev;
		tail.prev.next=n0;
		tail.prev=n0;
		size+=1;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index<0 || index>=size)
		  throw new IndexOutOfBoundsException();
		LLNode<E> p=new LLNode<E>(null);
		p=head.next;
		int i=0;
		while(i<index)
		{   p=p.next;
		    i+=1;
		}
			return p.data;
		}
		

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element==null)
			  throw new NullPointerException();
		if (index <0 || index>size+1) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> n0=new LLNode<E>(element);
		LLNode<E> p=new LLNode<E>(null);
		p=head;
		int i=0;
		while(i<index)
		{   p=p.next;
		    i+=1;
		}
        n0.next=p.next;
        n0.prev=p.next.prev;
        n0.next.prev=n0;
        p.next=n0;
        size+=1;
		}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index<0 || index>size-1)
			throw new IndexOutOfBoundsException();
		if (size<1)
			throw new NullPointerException();
		LLNode<E> p=new LLNode<E>(null);
		p=head.next;
		int i=0;
		while(i<index)
		{   p=p.next;
		    i+=1;
		}
		E v=p.data;
		p.next.prev=p.prev;
		p.prev.next=p.next;
		p.next=p.prev=null;
		size-=1;
		return v;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index<0 || index>size-1) {
			throw new IndexOutOfBoundsException();
		}
		if (element==null) {
			throw new NullPointerException();
		}
		LLNode<E> p=new LLNode<E>(null);
		p=head.next;
		int i=0;
		while(i<index)
		{   p=p.next;
		    i+=1;
		}
		E v=p.data;
		p.data=element;
		return v;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
