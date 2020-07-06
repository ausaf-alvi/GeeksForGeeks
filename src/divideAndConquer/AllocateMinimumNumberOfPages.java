package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllocateMinimumNumberOfPages {
	static int numberOfNotebooks;
	static long pagesInEachBook[];
	static int numberOfStudentsWeHave;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//code
		 BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder output = new StringBuilder();
		 int t = Integer.parseInt(obj.readLine()); //T is test cases
		 while(t-->0){
		 //Code here
			 numberOfNotebooks = Integer.parseInt(obj.readLine()); //N
			 pagesInEachBook = new long[numberOfNotebooks];// Array a[1..N]
			 {
				 String input[] = obj.readLine().split(" ");
				 for(int i = 0; i <numberOfNotebooks ; i++) {
					 pagesInEachBook[i] = Long.parseLong(input[i]);
				 }
			 }
			 numberOfStudentsWeHave = Integer.parseInt(obj.readLine());//M
			 long sum = 0l;
			 long min = Long.MAX_VALUE;
			 for(long pages:pagesInEachBook) {
				 sum += pages;
				 if(pages<min)	min = pages;
			 }
			 long minimumPagesForAStudent = 0l;
			 long maximumPagesForAStudent = sum;
			 long answer = Long.MAX_VALUE;
			 while(minimumPagesForAStudent<=maximumPagesForAStudent) {
				 long mid = (minimumPagesForAStudent + maximumPagesForAStudent)/2;
				 long requiredStudents = numberOfStudentsRequired(mid);
				 if(requiredStudents<=numberOfStudentsWeHave && requiredStudents!=-1) {
					 maximumPagesForAStudent = mid-1;
					 answer = mid;
				 } else {
					 minimumPagesForAStudent = mid+1;
				 }
			 }
			 if(numberOfStudentsWeHave==1) 
				 output.append(sum);
			 else if(answer < Long.MAX_VALUE && numberOfStudentsWeHave<=numberOfNotebooks)
				 output.append(answer);
			 else
				 output.append("-1");
			 output.append("\n");
			 
			 
		 //keep on appending solutions to output. 
		 //Also append "\n" after every test case's output.
		 }
		 System.out.println(output);        //Printing outputs of all test cases together

	}
	static long numberOfStudentsRequired(long maxPagesEachStudentCanHave) {
		long requiredStudents = 1l;
		long pagesForCurrentStudent = 0l;
		for(int i=0 ; i<pagesInEachBook.length ; i++) {
			pagesForCurrentStudent += pagesInEachBook[i];
			if(maxPagesEachStudentCanHave<pagesInEachBook[i]) return -1;//i.re. such type of allocation is impossible
			if(pagesForCurrentStudent>maxPagesEachStudentCanHave) {
				requiredStudents++;
				pagesForCurrentStudent = pagesInEachBook[i];
			}
		}
		return requiredStudents;
	}

}
