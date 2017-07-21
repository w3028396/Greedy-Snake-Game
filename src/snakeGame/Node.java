package snakeGame;

public class Node {
	private int x,y;
	private Node next_node;
	Node(int in_x,int in_y){
		x = in_x;
		y = in_y;
		next_node = null;
	}
	public int get_x(){
		return x;
	}
	public int get_y(){
		return y;
	}
	public Node get_next(){
		return next_node;
	}
	public void change_x(int new_x){
		x = new_x;
	}
	public void change_y(int new_y){
		y = new_y;
	}
	public void change_next(Node new_node){
		next_node = new_node;
	}
	
}
