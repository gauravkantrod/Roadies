import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Roadies {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();
		
		List<Integer> totalList = new LinkedList<Integer>();

		for (int j = 0; j < numberOfTestCases; j++) {

			int numberOfBoxes = in.nextInt();

			String[] boxArray = new String[numberOfBoxes];
			for (int i = 0; i < numberOfBoxes; i++) {
				boxArray[i] = in.next();	
			}
			
			int total = boxesTotal(boxArray);
			totalList.add(total);

		}
		
		for(Integer i : totalList) {
			System.out.println(i);
		}
		
		
		in.close();
	}

	static int boxesTotal(String[] boxArray) {

		// String[] arr = { "14", "12", "23", "45", "39" };
		//String[] arr = { "3", "5", "7", "2" };
		// String[] arr = { "121", "23", "3", "333", "4"};
		// String[] arr = { "32", "42", "52", "62", "72", "82", "92" };

		

		Arrays.sort(boxArray, Collections.reverseOrder());

		CopyOnWriteArrayList<String> ltr = new CopyOnWriteArrayList<>(boxArray);

		for (int i = 0; i < ltr.size(); i++) {
			char[] cArr = ltr.get(i).toCharArray();
			List<String> dummyList = new ArrayList<String>();
			for (int j = 1; j < ltr.size(); j++) {
				for (char c : cArr) {
					if (ltr.get(j).indexOf(c) >= 0 && i != j) {
						dummyList.add(ltr.get(j));
					}
				}

			}

			for (String s : dummyList) {
				ltr.remove(s);
			}
		}

		int sum = 0;
		for (String s : ltr) {
			sum += Integer.parseInt(s);
		}

		//System.out.println(sum);
		return sum;

	}
}
