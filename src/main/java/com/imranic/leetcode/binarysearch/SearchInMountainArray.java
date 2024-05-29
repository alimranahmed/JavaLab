package com.imranic.leetcode.binarysearch;

// 1095. Find in Mountain Array
// https://leetcode.com/problems/find-in-mountain-array
// For submitting this solution: MountainArray interface mentioned in the description need to be used
public class SearchInMountainArray {

    public static void main(String[] args) {
        int[] mountainArray = {1,2,3,4,5,3,1};
        int output = (new SearchInMountainArray()).findInMountainArray(3, mountainArray);
        System.out.println(output);
    }

    public int findInMountainArray(int target, int[] mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);

        int foundInFirstHalf = binarySearch(mountainArr, target, 0, peakIndex);

        if (foundInFirstHalf == -1) {
            return binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length - 1);
        }

        return foundInFirstHalf;
    }

    public int binarySearch(int[] mountainArr, int target, int start, int end) {

        boolean isAsc = mountainArr[start] < mountainArr[end];

        while(start <= end) {
            int mid = start + (end - start) / 2;

            int currentElement = mountainArr[mid];
            if(currentElement == target) {
                return mid;
            }

            if(isAsc) {
                if(target > currentElement) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(target > currentElement) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public int findPeakIndex(int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            int elem = mountainArr[mid];
            int nextElem = mountainArr[mid + 1];

            if(elem > nextElem) {
                end = mid;
            } else if(elem < nextElem) {
                start = mid + 1;
            }
        }

        return start;
    }
}
