package snakeGame;
import snakeGame.Linklist;
import snakeGame.Node;
public class snake {
	public Linklist snake_body;
	public int speed;
	public int head_dir;
	snake(){
		snake_body = new Linklist();
		Node node = new Node(28,36);
		snake_body.add_node(node);
		node = new Node(17,36);
		snake_body.add_node(node);
		node = new Node(6,36);
		snake_body.add_node(node);
		speed = 600;
		head_dir = 2;
	}
	public Node get_head(){
		return snake_body.get_head();
	}
	public void change_dir(int new_direction){
		head_dir = new_direction;
	}
	public void eat(){
		int x=0,y=0;
		Node new_node = null;
		Node tail = snake_body.get_tail();
		Node near_tail = snake_body.get_near_tail();
		if(tail.get_x() == near_tail.get_x()){
			x = tail.get_x();
			y = tail.get_y()> near_tail.get_y()?tail.get_y()+11:tail.get_y()-11;
		}
		if(tail.get_y() == near_tail.get_y()){
			y = tail.get_y();
			x = tail.get_x()> near_tail.get_x()?tail.get_x()+11:tail.get_x()-11;
		}
		new_node = new Node(x,y);
		snake_body.add_node(new_node);
		speed = (int)(speed*0.8);
	}
	public void move(int new_dir){
		head_dir = new_dir;
		int x=6,y=36;
		if (new_dir == 1){
			x = snake_body.get_head().get_x()-11;
			y = snake_body.get_head().get_y();
		}
		if (new_dir == 2){
			x = snake_body.get_head().get_x()+11;
			y = snake_body.get_head().get_y();			
		}
		if (new_dir == 3){
			x = snake_body.get_head().get_x();
			y = snake_body.get_head().get_y()-11;
		}
		if (new_dir == 4){
			x = snake_body.get_head().get_x();
			y = snake_body.get_head().get_y()+11;
		}
		Node new_head= new Node(x,y);
		snake_body.add_head(new_head);
		snake_body.delet_last();
	}
	public void grow(){
		
	}
	
}
