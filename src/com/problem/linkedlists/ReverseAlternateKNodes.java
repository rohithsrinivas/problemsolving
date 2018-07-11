package com.problem.linkedlists;

public class ReverseAlternateKNodes {

	static Node head;

	class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void addInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private void addInLastPlace(int data) {
		if (isLinkedListEmpty()) {
			addInFirstPlace(data);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		Node newNode = new Node(data);
		temp.next = newNode;
		newNode.next = null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private void insertBeforeNode(int data, int beforeData) {
		Node current = head.next, prev = head;
		while (current.next != null) {
			if (beforeData == current.data)
				break;
			current = current.next;
			prev = prev.next;
		}
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = current;
	}

	private void insertAfterNode(int data, int afterData) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.data == afterData)
				break;
			temp = temp.next;
		}

		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
	}

	private void deleteLastNode() {
		if (isLinkedListEmpty()) {
			System.out.println("linked list is empty");
			return;
		}
		if (doesLinkedListHaveOnlyOneNode()) {
			deleteFirstNode();
			return;
		}
		Node current = head.next, prev = head;
		while (current.next != null) {
			current = current.next;
			prev = prev.next;
		}

		prev.next = null;
		System.out.println(current.data + "deleted");
	}

	private void deleteFirstNode() {
		if (isLinkedListEmpty()) {
			System.out.println("linked list is empty");
			return;
		}
		Node temp = head;
		head = temp.next;
		System.out.println(temp.data + "deleted");
	}

	/* commented out as this approach wont work, better go with recursive approach..*/
//	private void reverseAlternateKNodes(int k) {
//		// boolean shouldBeReversed = true;
//		int index = 0;
//		Node temp = head, startingReverseIndex, endingReverseIndex, nodeBeforeStartingIndex = null;
//		boolean isFirst = true;
//		while (temp.next != null) {
//			if (index % 2 == 0) {
//				startingReverseIndex = temp;
//				for (int j = 0; j < k - 1; j++) {
//					temp = temp.next;
//				}
//				endingReverseIndex = temp;
//
//				if (isFirst) {
//					isFirst = false;
//					reverseNodes(null, startingReverseIndex, endingReverseIndex);
//				} else {
//					reverseNodes(nodeBeforeStartingIndex, startingReverseIndex, endingReverseIndex);
//				}
//
//			}
//
//			else {
//				for (int j = 0; j < k - 1; j++) {
//					if (j == k - 2)
//						nodeBeforeStartingIndex = temp;
//					temp = temp.next;
//				}
//			}
//			
//			index++;
//		}
//
//	}
//
//	private void reverseNodes(Node nodeBeforeStartingIndex, Node startingIndex, Node endingIndex) {
//		Node prev = nodeBeforeStartingIndex, current = startingIndex, next = null;
//
//		while (current != endingIndex) {
//			next = current.next;
//			current.next = prev;
//			prev = current;
//			current = next;
//		}
//
//		startingIndex.next = endingIndex.next;
//		if(nodeBeforeStartingIndex != null)
//		nodeBeforeStartingIndex.next = endingIndex;
//		
////		while(current != endingIndex) {
////			next = current.next;
////			
////		}
//
//	}
	
	/* this function will return the final head of the list after reversing, so we call this function recursively for every alternate k nodes*/
	Node reverseKNodesAlternatively(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;
 
        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
         
        /* 2) Now head points to the kth node.  So change next 
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }
        
       
 
        /* 3) We do not want to reverse next k nodes. So move the current 
         pointer to skip next k nodes */
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
 
        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = reverseKNodesAlternatively(current.next, k);
        }
 
        /* 5) prev is new head of the input list */
        return prev;
    }

	private boolean isLinkedListEmpty() {
		return head == null ? true : false;
	}

	private boolean doesLinkedListHaveOnlyOneNode() {
		return (head != null && head.next == null) ? true : false;
	}

	public static void main(String[] args) {
		ReverseAlternateKNodes linkedList = new ReverseAlternateKNodes();
		linkedList.addInLastPlace(10);
		linkedList.addInLastPlace(20);
		linkedList.addInLastPlace(30);
		linkedList.addInLastPlace(40);
		linkedList.addInLastPlace(50);
		linkedList.addInLastPlace(60);
		linkedList.addInLastPlace(70);
		linkedList.addInLastPlace(80);
		linkedList.addInLastPlace(90);
		linkedList.printList();
		head = linkedList.reverseKNodesAlternatively(head, 3);
		System.out.println("______________________________");
		linkedList.printList();
	}

}
