package src;
public class TreeNode {

	State state;
	TreeNode first;
	TreeNode second;
	TreeNode third;
	TreeNode fourth;
	TreeNode fifth;
	TreeNode sixth;
	TreeNode seventh;

	// Constructor, getters and setters
	public TreeNode(State state) {
		this.state = state;
	}
	
	//Calculate the goodness of TreeNode according to its nodes
	public int calculatePoint() {
		int point = 0;
		if (first != null) {
			point += first.state.calculatePoint();
		}
		if (second != null) {
			point += second.state.calculatePoint();
		}
		if (third != null) {
			point += third.state.calculatePoint();
		}
		if (fourth != null) {
			point += fourth.state.calculatePoint();
		}
		if (fifth != null) {
			point += fifth.state.calculatePoint();
		}
		if (sixth != null) {
			point += sixth.state.calculatePoint();
		}
		if (seventh != null) {
			point += seventh.state.calculatePoint();
		}
		
		return point;

	}

	public void add(TreeNode node) {
		if (first == null) {
			first = node;
		} else if (second == null) {
			second = node;
		} else if (third == null) {
			third = node;
		} else if (third == null) {
			third = node;
		} else if (fourth == null) {
			fourth = node;
		} else if (fifth == null) {
			fifth = node;
		} else if (sixth == null) {
			sixth = node;
		} else if (seventh == null) {
			seventh = node;
		} else {
			System.out.println("No place for adding the node to the node");
		}

	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public TreeNode getFirst() {
		return first;
	}

	public void setFirst(TreeNode first) {
		this.first = first;
	}

	public TreeNode getSecond() {
		return second;
	}

	public void setSecond(TreeNode second) {
		this.second = second;
	}

	public TreeNode getThird() {
		return third;
	}

	public void setThird(TreeNode third) {
		this.third = third;
	}

	public TreeNode getFourth() {
		return fourth;
	}

	public void setFourth(TreeNode fourth) {
		this.fourth = fourth;
	}

	public TreeNode getFifth() {
		return fifth;
	}

	public void setFifth(TreeNode fifth) {
		this.fifth = fifth;
	}

	public TreeNode getSixth() {
		return sixth;
	}

	public void setSixth(TreeNode sixth) {
		this.sixth = sixth;
	}

	public TreeNode getSeventh() {
		return seventh;
	}

	public void setSeventh(TreeNode seventh) {
		this.seventh = seventh;
	}

}