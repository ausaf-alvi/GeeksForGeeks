package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BalancedBrackets {
	public static void main(String[] args) throws IOException {
		// code
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int T = Integer.parseInt(obj.readLine()); // T is test cases
		while (T-- > 0) {
			Stack<Character> brackets = new Stack<Character>();
			// Code here
			// keep on appending solutions to output.
			// Also append "\n" after every test case's output.
			String s = obj.readLine();
			int len = s.length();
			boolean isbalanced = true;
			for(int i=0 ; i<len ; i++) {
				char c = s.charAt(i);
				if((c==']' || c==')' || c=='}')) {
					if(brackets.empty()) {
						isbalanced = false;
						break;
					} else {
						char d=brackets.pop();
						if((c==']'&&d=='[')||(c==')'&&d=='(')||(c=='}'&&d=='{')) {
//							do nothing....so far it is good
						} else {
							isbalanced=false;
							break;
						}
					}
				} else {
					brackets.push(c);
				}
			}
			if(isbalanced && brackets.empty()) {
				output.append("balanced\n");
			} else {
				output.append("not balanced\n");
			}
		}
		System.out.println(output);
	}
}