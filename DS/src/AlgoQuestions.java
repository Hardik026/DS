import java.util.*;
import java.util.stream.Collectors;

public class AlgoQuestions {

	public static void findMajorityElement(int arr[]) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : arr) {

			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);

			} else {
				map.put(num, 1);
			}

		}
		
		

		Set<Integer> nums = map.keySet();
		int count=map.values().stream().collect(Collectors.toSet()).size();

		for (int num : nums) {
			if (map.get(num) > arr.length / 3) {
				System.out.println(num);
			}
		}

//		System.out.println(map);

	}

	public static void swap(int m, int n) {
		int temp;
		temp = m;
		m = n;
		n = temp;

	}

	public static void UniosOfTwoArrays(int arr1[], int arr2[]) {

		HashSet<Integer> set = new HashSet<>();
		for (int num : arr1) {
			set.add(num);
		}

		for (int num : arr2) {
			set.add(num);

		}

		System.out.println(set.size());

	}

	public static void reverseArray(int arr[]) {
//		ArrayList<Integer> revArr = new ArrayList<>();
//		int len = arr.length;
//
//		for (int i = len - 1; i >= 0; i--) {
//
//			revArr.add(arr[i]);
//
//		}

		int start = 0, end = arr.length - 1;
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;

		}
		System.out.println();
		for (int num : arr) {
			System.out.print(num + " ");

		}
	}

	public static void intersectionOfTwoArrays(int arr1[], int arr2[]) {
		int count = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int num : arr1) {
			set.add(num);

		}

		for (int num : arr2) {

			if (set.contains(num)) {
				count += 1;
				set.remove(num);

			}

		}

		System.out.println("The intersection of two arrays contains " + count);

	}

	public static void sortArrayOf0and1and2(int arr[]) {

		int low = 0, mid = 0, high = arr.length - 1;

		int temp;
		while (mid < high) {

			if (arr[mid] == 0) {

				temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;

				low++;
				mid++;

			}
			if (arr[mid] == 1) {

				mid++;

			}
			if (arr[mid] == 2) {

				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;

			}

		}

		System.out.println();
		for (int m : arr) {
			System.out.print(m + " ");
		}

	}

	public static void moveAllNegativetoOneSideAndPositiveToOtherSide(int arr[]) {

		int low = 0, high = arr.length - 1;
		int temp;
		while (low <= high) {

			if (arr[low] < 0) {

				low++;

			}

			else {
				temp = arr[high];
				arr[high] = arr[low];
				arr[low] = temp;
				high--;

			}
		}

		System.out.println();
		for (int m : arr) {
			System.out.print(m + " ");
		}

	}

	public static void findItinarary(HashMap<String, String> map) {

		String source = "";
		String destination = "";

		for (String sources : map.keySet()) {
			if (!map.containsValue(sources)) {
				source = sources;

			}
		}

		System.out.print(source);

		while (map.containsKey(source)) {

			System.out.print("->" + map.get(source));
			source = map.get(source);

		}

//		System.out.println(source);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr1[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
		int arr2[] = { 2, 3, 4, 6 };
		int arr[] = { 0, 2, 1, 1, 0, 1, 0, 1, 1, 1, 0, 2, 2, 2, 1, 0 };
		int arr3[] = { 12, -11, 4, -1, 5, 9, -19, -78, 10 };
		findMajorityElement(arr1);

		HashMap<String, String> map = new HashMap<>();
		map.put("Chennai", "Bengluru");
		map.put("Mumbai", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");

		UniosOfTwoArrays(arr1, arr2);
		intersectionOfTwoArrays(arr1, arr2);

		findItinarary(map);

		reverseArray(arr1);

		sortArrayOf0and1and2(arr);

		moveAllNegativetoOneSideAndPositiveToOtherSide(arr3);

	}

}
