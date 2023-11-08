package src;

public class Tree {

	TreeNode root;

	// Constructor, getter and setter
	public Tree(TreeNode node) {
		root = node;

	}
	
	public Tree() {
		
	}

	public void add(TreeNode node) {
		if (root != null) {
			root.add(node);
		}
		else {
			root = node;
		}
	}

	public TreeNode getRoot() {
		return this.root;

	}

	public void setRoot(TreeNode root) {
		this.root = root;

	}
	
	//Returns the best state for bot according to states in tree
	public State bestChoice() {
	    State toReturn = null;
	    int temp;
	    int maxPoint = Integer.MIN_VALUE;

	    if (root.first != null) {
	        temp = root.first.calculatePoint();
	        if (temp >= maxPoint && !root.first.state.aboutToLose) {
	            maxPoint = temp;
	            toReturn = root.first.state;
	        }
	    }
	    if (root.second != null) {
	        temp = root.second.calculatePoint();
	        if (temp >= maxPoint && !root.second.state.aboutToLose) {
	            maxPoint = temp;
	            toReturn = root.second.state;
	        }
	    }
	    if (root.third != null) {
	        temp = root.third.calculatePoint();
	        if (temp >= maxPoint && !root.third.state.aboutToLose) {
	            maxPoint = temp;
	            toReturn = root.third.state;
	        }
	    }
	    if (root.fourth != null) {
	        temp = root.fourth.calculatePoint();
	        if (temp >= maxPoint && !root.fourth.state.aboutToLose) {
	            maxPoint = temp;
	            toReturn = root.fourth.state;
	        }
	    }
	    if (root.fifth != null) {
	        temp = root.fifth.calculatePoint();
	        if (temp >= maxPoint && !root.fifth.state.aboutToLose) {
	            maxPoint = temp;
	            toReturn = root.fifth.state;
	        }
	    }
	    if (root.sixth != null) {
	        temp = root.sixth.calculatePoint();
	        if (temp >= maxPoint && !root.sixth.state.aboutToLose) {
	            maxPoint = temp;
	            toReturn = root.sixth.state;
	        }
	    }
	    if (root.seventh != null) {
	        temp = root.seventh.calculatePoint();
	        if (temp >= maxPoint && !root.seventh.state.aboutToLose) {
	            maxPoint = temp;
	            toReturn = root.seventh.state;
	        }
	    }
	    if (toReturn == null) {
	        System.out.println("Game is over, no winner");
	    }
	    return toReturn;
	}


}