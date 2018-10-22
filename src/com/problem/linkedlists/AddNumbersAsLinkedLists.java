package com.problem.linkedlists;

/* !!!!!!!!!!!!!!!!!!yet to be completed.... only works for numbers with equal number of digits...*/
public class AddNumbersAsLinkedLists {

	Node head;
	static AddNumbersAsLinkedLists linkedList1, linkedList2;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void insertInFirstPlace(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private void insertInLastPlace(int data) {
		if (isListEmpty()) {
			System.out.println("list is empty, inserting in first place");
			insertInFirstPlace(data);
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

	private boolean isListEmpty() {
		return head == null;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -- >");
			temp = temp.next;
		}
	}

	private void addNumbersWithEqualSize(AddNumbersAsLinkedLists linkedList1, AddNumbersAsLinkedLists linkedList2,
			AddNumbersAsLinkedLists linkedList3) {
		/*
		 * we need to initially reverse the linked list, add the digits node wise and
		 * add them to the resultant linked list and again reverse all the lists
		 */
		linkedList1.reverseLinkedList();
		linkedList2.reverseLinkedList();
		Node temp1 = linkedList1.head, temp2 = linkedList2.head;
		int sum = 0;
		while (temp1 != null && temp2 != null) {
			/* first add the numbers and calculate the sum */
			sum = temp1.data + temp2.data;
			/*
			 * check if the sum is greater than 10 i.e is there a carry, if yes then insert
			 * sum-10 in the last place of the resultant linked list, else insert the sum
			 * directly in the resultant linked list
			 */
			if (sum >= 10) {
				linkedList3.insertInLastPlace(sum - 10);
				/*
				 * this condition is to check if the current two nodes being added are the last
				 * nodes in the list, if yes then we need to add an extra node having 1 as data
				 * in the end of the resultant linked list
				 */
				if (temp1.next == null) {
					linkedList3.insertInLastPlace(1);
				}
				/*
				 * in case of carry but it is not the last node, we simply increment the data of
				 * the next node
				 */
				else
					temp1.next.data++;
			}
			/*
			 * this is the condition when there is no carry, we directly insert the data
			 * into the resultant linked list
			 */
			else {
				linkedList3.insertInLastPlace(sum);
			}

			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		/*
		 * at the end of the processing, we need to reverse all the lists, so that we
		 * have the result in the proper order
		 */
		linkedList1.reverseLinkedList();
		linkedList2.reverseLinkedList();
		linkedList3.reverseLinkedList();
	}

	private int getSize() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	private void reverseLinkedList() {
		Node previous = null, next = null, current = head;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	/* this function will add the numbers with unequal number of digits */
	private void addNumbersWithUnequalSizes(AddNumbersAsLinkedLists linkedList1, AddNumbersAsLinkedLists linkedList2,
			AddNumbersAsLinkedLists linkedList3) {
		/* even in this method we need to reverse the lists first */
		linkedList1.reverseLinkedList();
		linkedList2.reverseLinkedList();
		Node temp1 = null, temp2 = null;
		/*
		 * this condition ensures that the first pointer will always traverse through
		 * the linked list with greater number of digits
		 */
		if (linkedList1.getSize() > linkedList2.getSize()) {
			temp1 = linkedList1.head;
			temp2 = linkedList2.head;
		} else {
			temp1 = linkedList2.head;
			temp2 = linkedList1.head;
		}
		int sum = 0;
		/* loop through the two lists and add node by node */
		while (temp1 != null && temp2 != null) {
			/*
			 * this is to calculate the sum of the two nodes that the pointers are currently
			 * pointing to
			 */
			sum = temp1.data + temp2.data;
			/*
			 * if the sum is greater than 10, then there is a carry, so we increment the
			 * data of the next node by 1
			 */
			if (sum >= 10) {
				linkedList3.insertInLastPlace(sum - 10);
				temp1.next.data++;
			}
			/*
			 * in case of no carry we can directly append the sum to the resultant linked
			 * list
			 */
			else
				linkedList3.insertInLastPlace(sum);
			/* move both the pointers to the next nodes */
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		/*
		 * this is to add the remaining nodes of the first list once the parsing is
		 * done, because unlike with equal sizes, we still have nodes left in first list
		 */
		while (temp1 != null) {
			/*
			 * this is to check if the node being parsed is greater than 10, then again we
			 * need to propagate the carry to the next node if it is not the last node or
			 * else if it is the last node, then we need to add one more node at the end
			 */
			if (temp1.data >= 10) {
				linkedList3.insertInLastPlace(temp1.data - 10);
				/*
				 * this is to check if the current node is the last, if yes, then add one more
				 * node
				 */
				if (temp1.next == null) {
					linkedList3.insertInLastPlace(1);
				}
				/* else just propagate the carry to the next node in the larger list */
				else {
					temp1.next.data++;
				}
			}
			/*
			 * in case the current data is not more than 10, we can simply insert it into
			 * the result
			 */
			else
				linkedList3.insertInLastPlace(temp1.data);
			temp1 = temp1.next;
		}

		/* we need to reverse all the lists again */
		linkedList1.reverseLinkedList();
		linkedList2.reverseLinkedList();
		linkedList3.reverseLinkedList();

	}

	private void addNumbers(AddNumbersAsLinkedLists linkedList1, AddNumbersAsLinkedLists linkedList2,
			AddNumbersAsLinkedLists linkedList3) {
		if (linkedList1.getSize() == linkedList2.getSize())
			addNumbersWithEqualSize(linkedList1, linkedList2, linkedList3);
		else
			addNumbersWithUnequalSizes(linkedList1, linkedList2, linkedList3);
	}

	public static void main(String[] args) {
		AddNumbersAsLinkedLists linkedList1 = new AddNumbersAsLinkedLists();
		linkedList1.insertInLastPlace(9);
		linkedList1.insertInLastPlace(9);
		linkedList1.insertInLastPlace(9);
		//linkedList1.insertInLastPlace(9);
		System.out.println(" first number is ___________ ");
		linkedList1.printList();
		AddNumbersAsLinkedLists linkedList2 = new AddNumbersAsLinkedLists();
		// linkedList2.insertInLastPlace(3);
		// linkedList2.insertInLastPlace(1);
		// linkedList1.insertInLastPlace(9);
				linkedList2.insertInLastPlace(9);
			 linkedList2.insertInLastPlace(9);
				
		linkedList2.insertInLastPlace(9);
		System.out.println(" second number is ___________");
		linkedList2.printList();
		// AddNumbersAsLinkedLists.linkedList1 = linkedList1;
		// AddNumbersAsLinkedLists.linkedList2 = linkedList2;
		AddNumbersAsLinkedLists linkedList3 = new AddNumbersAsLinkedLists();
		linkedList3.addNumbers(linkedList1, linkedList2, linkedList3);
		linkedList3.printList();

	}

}
