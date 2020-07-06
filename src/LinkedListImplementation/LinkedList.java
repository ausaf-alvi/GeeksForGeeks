package LinkedListImplementation;

class LinkedList {
	    node head;
	    static class node{
	        int data;
	        node next;
	        node(int d){
	            data=d;
	            next=null;
	        }
	    }
	    public static void main(String[] args) {
	        LinkedList ll1=new LinkedList();
	        ll1.head=new node(1);
	        node n2=new node(2);
	        node n3=new node(3);
	        ll1.head.next=n2;
	        n2.next=n3;
	        ll1.printlist();
	        ll1.insertBeggining(85);
	        ll1.insertEnd(32);
	        ll1.printlist();
	        ll1.insertAfter(n2, 2);
	        ll1.printlist();
	        System.out.print("\nCurrent Node Count: "+ll1.getCount(ll1.head));
	        ll1.deleteKey(3);
	        ll1.printlist();        
	        ll1.deletebyIndex(4);
	        ll1.printlist();
	        System.out.print("\nCurrent Node Count: "+ll1.getCountRec(ll1.head));
	        ll1.swapNodes(1 , 85);
	        ll1.printlist();
	        ll1.head=ll1.reverse(ll1.head);
	        ll1.printlist();
	        ll1.head=ll1.reverseRec(ll1.head, null);
	        ll1.printlist();
	        
	        LinkedList ll2=new LinkedList();
	        LinkedList ll3=new LinkedList();
	        ll2.head=new node(8);
	        ll2.head.next=new node(11);
	        ll2.head.next.next=new node(15);
	        ll3.head=new node(5);
	        ll3.head.next=new node(7);
	        ll3.head.next.next=new node(15);
	        ll3.head.next.next.next=new node(25);
	        ll2.head=ll2.sortedMergeRec(ll2.head, ll3.head);
	        ll2.printlist();
	        
	        LinkedList ll4=new LinkedList();
	        LinkedList ll5=new LinkedList();
	        ll4.head=new node(8);
	        ll4.head.next=new node(11);
	        ll4.head.next.next=new node(15);
	        ll5.head=new node(5);
	        ll5.head.next=new node(7);
	        ll5.head.next.next=new node(15);
	        ll5.head.next.next.next=new node(25);
	        ll4.head=ll4.sortedMerge(ll4.head, ll5.head);
	        ll4.printlist();
	        
	        System.out.println("\nMiddle node of this Linked List="+ll4.getMiddle(ll4.head).data);
	        
	        System.out.print("\nUnsorted");ll1.printlist();
	        ll1.head=ll1.mergesort(ll1.head);
	        System.out.print("\nSorted ");ll1.printlist();

	        
	    }
	    //This method prints the whole linked list starting from head
	    public void printlist(){
	        node n=head;
	        System.out.println("\nLinked List is:-");
	        while(n!=null){
	            System.out.print(n.data+" ");
	            n=n.next;
	        }
	    }
	    
	    //This method insert a node in the beginning
	    public void insertBeggining(int newData){
	        node n=new node(newData);
	        n.next=head;
	        head=n;
	    }
	    
	    //this method inserts a node at the end
	    public void insertEnd(int newData){
	        node n=new node(newData);
	        n.next=null;
	        if(head==null){
	            head=n;
	        }else{
	            node last=head;
	            while(last.next!=null){
	                last=last.next;
	            }
	            last.next=n;
	        }
	    }
	    
	    //this method insert a new node after a given node
	   public void insertAfter(node prevNode,int newData){
	       if(prevNode==null){
	           System.out.println("Previous Node cant be null");
	           return;
	       }
	       node n=new node(newData);
	       n.next=prevNode.next;
	       prevNode.next=n;
	   }
	   
	//This method deletes the first occurance of the given key in LinkedList
	   public void deleteKey(int key){
	       node temp=head;
	       node prev=null;
	       if(temp!=null && temp.data==key){
	           head=temp.next;
	           return;
	       }
	       while(temp!=null && temp.data!=key){
	           prev=temp;
	           temp=temp.next;
	       }
	       if(temp==null)
	           return;
	       prev.next=temp.next;
	   }
	   
	//This method deletes the node at a given position
	//index starts from 0   
	   public void deletebyIndex(int position){
	       if(head==null)
	           return;
	       node temp=head;
	       if(position==0){
	           head=temp.next;
	           return;
	       }
	       //This loop finds the speciied node
	       //node to be deleted is at temp.next position
	       for(int i=0;i<position-1 && temp!=null;i++)
	           temp=temp.next;
	       if(temp==null || temp.next==null)
	           return;
	       node nxt=temp.next.next;
	       temp.next=nxt;
	       }
	   
	   //This method returns the count of nodes in linkedlist
	   //By Iterative Method
	   public int getCount(node head){
	       node temp=head;
	       int count=0;
	       while(temp!=null){
	           count++;
	           temp=temp.next;
	       }
	       return count;
	   }
	   
	   //This method returns the count of nodes in linkedlist
	   //By Recursive Method
	   public int getCountRec(node headPointer){
	       if(headPointer==null)
	           return 0;
	       return(1+getCountRec(headPointer.next));
	   }
	   
	   //This method swaps nodes in a linkedlist without swapping data
	   public void swapNodes(int x,int y){
	       node prevX=null;
	       node prevY=null;
	       node nodeX=head;
	       node nodeY=head;
	       while(nodeX!=null && nodeX.data!=x){
	           prevX=nodeX;
	           nodeX=nodeX.next;
	       }
	       while(nodeY!=null && nodeY.data!=y){
	           prevY=nodeY;
	           nodeY=nodeY.next;
	       }
	       if(nodeY==null || nodeX==null)
	           return;
	       if(prevX!=null)
	           prevX.next=nodeY;
	       else
	           head=nodeY;
	       if(prevY!=null)
	           prevY.next=nodeX;
	       else
	           head=nodeX;
	       node temp=nodeX.next;
	       nodeX.next=nodeY.next;
	       nodeY.next=temp;
	   }
	   
	   //This method reverses the linked list and return the new head by iteration
	   public node reverse(node n){
	       node prev=null;
	       node curr=n;
	       node next;
	       while(curr!=null){
	           next=curr.next;
	           curr.next=prev;
	           prev=curr;
	           curr=next;
	       }
	       n=prev;
	       return n;
	   }
	   
	   //This method reverses the linked list and return the new head by recursion
	   //Initially curr=head and prev=null
	   public node reverseRec(node current,node previous){
	       //if last node
	       if(current.next==null){
	           head=current;
	           current.next=previous;
	           return head;           
	       }
	       //if not last node
	       node nextTemporary=current.next;
	       current.next=previous;
	       reverseRec(nextTemporary, current);
	       return head;
	   }
	   
	   //This method merges two already sorted Linked Lists by Iteration
	   public node sortedMerge(node headA,node headB){
	       node dummyHead=new node(0);
	       node tail=dummyHead;
	       while(true){
	           if(headA==null){
	               tail.next=headB;
	               break;
	           }
	           if(headB==null){
	               tail.next=headA;
	               break;
	           }
	           if(headA.data<=headB.data){
	               tail.next=headA;
	               headA=headA.next;
	           }
	           else{
	               tail.next=headB;
	               headB=headB.next;
	           }
	           tail=tail.next;
	       }
	       return dummyHead.next;
	   }

	   //This method merges two already sorted Linked Lists by Recursion
	   public node sortedMergeRec(node headA,node headB){
	       node result;
	       if(headA==null)
	           return headB;
	       if(headB==null)
	           return headA;
	       if(headA.data<=headB.data){
	           result=headA;
	           result.next=sortedMergeRec(headA.next, headB);
	       }else{
	           result=headB;
	           result.next=sortedMergeRec(headA, headB.next);
	       }
	       return result;
	   }
	   
	   //This method sorts the linked list using merge sort
	   //it uses previous method to merge the sorted array
	   public node mergesort(node head){
	       if(head==null || head.next==null)
	           return head;
	       node middleNode=getMiddle(head);
	       node nextOfMiddle=middleNode.next;
	       middleNode.next=null;
	       node left=mergesort(head);
	       node right=mergesort(nextOfMiddle);
	       node sortedList=sortedMerge(left, right);
	       return sortedList;
	   }
	   //This method finds the middle node of linkedlist
	   public node getMiddle(node h){
//	       if(h==null || h.next==null)
//	           return h;
//	       node temp=h;
//	       int nodeCount=getCount(h);
//	       for(int i=1;i<nodeCount;i=i+2){
//	           temp=temp.next;
//	       }
//	       return temp;    
	//above code gives error when called from mergesort()
	                       //Base case 
	        if (h == null) 
	            return h; 
	        node fastptr = h.next; 
	        node slowptr = h; 
	          
	        // Move fastptr by two and slow ptr by one 
	        // Finally slowptr will point to middle node 
	        while (fastptr != null) 
	        { 
	            fastptr = fastptr.next; 
	            if(fastptr!=null) 
	            { 
	                slowptr = slowptr.next; 
	                fastptr=fastptr.next; 
	            } 
	        } 
	        return slowptr; 
	   }
	   
	   //This method reverses the linked list in groups of given sizes(k)
	//   Example:
	//Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
	//Output:  3->2->1->6->5->4->8->7->NULL.
	   
	//Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
	//Output:  5->4->3->2->1->8->7->6->NULL. 
	   public node reverseInGroups(node head,int k){
	       node prev,current,next;
	       prev=next=null;
	       current=head;
	       int count=0;
	       /* Reverse first k nodes of linked list */
	       while(count<k && current!=null){
	           next=current.next;
	           prev=current.next;
	           prev=current;
	           current=next;
	           count++;
	       }
	        /* next is now a pointer to (k+1)th node  
	          Recursively call for the list starting from current. 
	          And make rest of the list as next of first node */
	       if(next!=null)
	           head.next=reverseInGroups(next, k);
	       // prev is now head of input list 
	       return prev;
	   }
	   
	   //This method detects loop in a Linked List by Floyd's Cycles Detection Algo
	   //if loop exists it returns the meeting point of fast and slow pointer
	   //else it returns null
	   public node detectLoop(node head) {
		   node slowptr=head;
		   node fastptr=head;
		   while(slowptr!=null && fastptr!=null && fastptr.next!=null) {
			   slowptr=slowptr.next;
			   fastptr=fastptr.next.next;
			   if(slowptr==fastptr)
				   return slowptr;
		   }
		   return null;
	   }
	   
	   //This method Removes loop from the given linkedlist
	   void removeLoop(node head) {
		   node loopNode=detectLoop(head);//loopNode is meeting point of fast and slow ptr
		   if(loopNode!=null) {
			   node ptr1=head;
			   node ptr2=null;
			   while(true) {
				   ptr2=loopNode;
				   //now start a loop from loopNode an check if it reaches ptr1 or not
				   while(ptr2.next!=loopNode && ptr2.next!=ptr1) {
					   ptr2=ptr2.next;
				   }
				  // if ptr2 reaches ptr1 then there is a loop..So break it
				   if(ptr2.next==ptr1)
					   break;
				   //if ptr2 didnt reach ptr1 the try next node after ptr1
				   ptr1=ptr1.next;
			   }
			   //After the end of loop..ptr2 is the last node of the loop..head.so make it's next as null
			   ptr2.next=null;
		   }
	   }
	   

	//Add two numbers represented by linked lists | Set 1
	//Given two numbers represented by two lists, write a function that returns sum list. The sum list is list representation of addition of two input numbers.
	//Example Input:
	//  First List: 5->6->3  // represents number 365
	//  Second List: 8->4->2 //  represents number 248
	//Output	
	//  Resultant list: 3->1->6  // represents number 613
	//If one list has more elements than the other then consider remaining values of this list as 0
	   public node linkedListAddition(node list1,node list2) {
		   node resultListHead=new node(0);
		   node resultPtr=resultListHead;
		   while(!(list1==null && list2==null)) {
			   if(list1==null) {
				   resultPtr.data=list2.data;
				   list2=list2.next;
			   }
			   else if(list2==null) {
				   resultPtr.data=list1.data;
				   list1=list1.next;
			   }
			   else{
				   resultPtr.data=list1.data+list2.data;
				   list1=list1.next;
				   list2=list2.next;
			   }
			   resultPtr.next=new node(0);
			   resultPtr=resultPtr.next;
		   }
		   return resultListHead.next;
	   }
	   
	   
//	   Given a singly linked list, rotate the linked list counter-clockwise by k nodes.
//	   Where k is a given positive integer. 
//	   For example, if the given linked list is 10->20->30->40->50->60 and k is 4,
//	   the list should be modified to 50->60->10->20->30->40.
//	   Assume that k is smaller than the count of nodes in linked list.
	   public node rotateListAfterK(node head) {
		   return null;
	   }
	}
