package snakeGame;
import snakeGame.Node;
public class Linklist {
	private Node head;
	private int length;
	Linklist(){
		head=null;
		length = 0;
	}
	public Node get_head(){
		return head;
	}
	public int get_length(){
		return length;
	}
	public Node get_tail(){
		Node tail = head;
		while(tail.get_next() != null){
			tail = tail.get_next();
		}
		return tail;
	}
	public Node get_near_tail(){
		Node tail = head;
		while(tail.get_next().get_next() != null){
			tail = tail.get_next();
		}
		return tail;
	}
	public void add_node(Node new_node){
		if (head == null)
		{
			head = new_node;
			length = 1;
		}
		else
		{
			Node temp_node = head;
			while (temp_node.get_next()!=null)
			{
				temp_node = temp_node.get_next();
			}
			temp_node.change_next(new_node);
			length = length+1;
		}
	}
	public void delet_last(){
		if (length == 1){
			head =null;
			length = length-1;
		}
		else
		{
			Node temp_node = head;
			while (temp_node.get_next().get_next()!=null)
			{
				temp_node = temp_node.get_next();
			}
			
			temp_node.change_next(null);
			length = length-1;
		}
	}
	public void add_head(Node new_head){
		new_head.change_next(head);
		head = new_head;
		length = length+1;
	}
	/*
	public static void main(String[] args){
		Linklist list =  new Linklist();
		Node node1 = new Node(1,2);
		Node node2 = new Node(3,4);
		Node node3 = new Node(5,5);
		list.add_node(node1);
		list.add_node(node2);
		list.delet_last();
		list.add_head(node3);
		System.out.println(list.head.get_next().get_next());
	}*/
	
}
