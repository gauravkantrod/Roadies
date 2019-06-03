import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Roadies {

	public static void main(String[] args) {

		// String[] arr = { "14", "12", "23", "45", "39" };
		// String[] arr = { "121", "23", "3", "333", "4"};
		// String[] arr = { "32", "42", "52", "62", "72", "82", "92" };

		String[] arr = { "3", "5", "7", "2" };

		Arrays.sort(arr, Collections.reverseOrder());

		CopyOnWriteArrayList<String> ltr = new CopyOnWriteArrayList<>(arr);

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

		System.out.println(sum);

	}
}