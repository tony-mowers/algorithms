package ch.alika.algorithms;

public class Searches {

	public static class SubarrayResult {
		public SubarrayResult() {

		}

		public SubarrayResult(int from, int to, int total) {
			this.from = from;
			this.to = to;
			this.total = total;
		}

		int from;
		int to;
		int total;
	}

	public static SubarrayResult findMaxSubarray(int[] a) {

		return findMaxSubarray(a, 0, a.length - 1);
	}

	private static SubarrayResult findMaxSubarray(int[] a, int low, int high) {
		if (low > high)
			return new SubarrayResult();

		if (low == high) {
			return new SubarrayResult(low, low + 1, a[low]);
		}

		int mid = (low + high) / 2;
		SubarrayResult left = findMaxSubarray(a, low, mid);
		SubarrayResult right = findMaxSubarray(a, mid + 1, high);
		SubarrayResult crossing = findMaxCrossingSubarray(a, low, mid, high);

		if ((left.total >= right.total) && (left.total >= crossing.total))
			return left;

		if ((right.total >= left.total) && (right.total >= crossing.total))
			return right;

		return crossing;
	}

	private static SubarrayResult findMaxCrossingSubarray(int[] a, int low,
			int mid, int high) {
		int leftTotal = a[mid];
		int leftLow = mid;

		int rightTotal = a[mid + 1];
		int rightHigh = mid + 1;

		int runningSum = 0;
		for (int i = mid; i >= 0; i--) {
			runningSum += a[i];
			if (runningSum > leftTotal) {
				leftLow = i;
				leftTotal = runningSum;
			}
		}

		runningSum = 0;
		for (int i = mid + 1; i <= high; i++) {
			runningSum += a[i];
			if (runningSum > rightTotal) {
				rightHigh = i;
				rightTotal = runningSum;
			}
		}

		return new SubarrayResult(leftLow, rightHigh + 1, leftTotal
				+ rightTotal);
	}
}
