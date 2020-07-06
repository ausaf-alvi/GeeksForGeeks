package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class nextLargestElement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// code
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int T = Integer.parseInt(obj.readLine()); // T is test cases
		while (T-- > 0) {
			// Code here
			int n = Integer.parseInt(obj.readLine());
			long a[] = new long[n];
			{
				String input[] = obj.readLine().split(" ");
				for (int i = 0; i < n; i++) {
					a[i] = Long.parseLong(input[i]);
				}
			}
			Stack<Long> indexStack = new Stack<Long>();
			Stack<Long> numberStack = new Stack<Long>();
			indexStack.push((long) 0);
			numberStack.push(a[0]);
			long nextLargest[] = new long[n];
			Arrays.fill(nextLargest, -1);
			for (long indexOfNext = 0; indexOfNext < n; indexOfNext++) {
				long nextElement = a[(int) indexOfNext];
				if (indexStack.empty() == false && numberStack.empty() == false) {
					long poppedIndex = indexStack.pop();
					long poppedNumber = numberStack.pop();
					while (nextElement > poppedNumber) { /* while(stacks not empty) */

						nextLargest[(int) poppedIndex] = nextElement;
						if (numberStack.empty() || indexStack.empty())
							break;
						poppedIndex = indexStack.pop();
						poppedNumber = numberStack.pop();

					}
					if (nextElement < poppedNumber) {
						indexStack.push(poppedIndex);
						numberStack.push(poppedNumber);
					}

				}
				indexStack.push(indexOfNext);
				numberStack.push(nextElement);

			}

			for (long NGE : nextLargest) {
				output.append(NGE).append(" ");
			}
			output.append("\n");
			// keep on appending solutions to output.
			// Also append "\n" after every test case's output.
		}
		System.out.println(output);
	}

}
