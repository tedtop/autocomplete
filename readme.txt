/******************************************************************************
 *  Name: Ted Toporkov
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
It starts with a standard binary search, with a low index at 0 and high index at the end of the array. For each iteration of the binary search loop it calculates the middle index, uses the provided comparator to compare the element at the middle index with the search key (comparator.compare(a[mid], key) == 0). This modified binary search is different from standard binary search in that when it finds a matching element, it records that index as a potential result and then continues searching to the left (by setting hi = mid - 1) to see if there are any earlier matches for the key. If no match is found, it returns -1.



/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: The constructor creates a local copy O(n) of terms and sorts them O(n log n), so the total runtime is O(n log n) because O(n log n) grows faster than O(n)

allMatches(): Binary search to find the range of matching terms is O(log n) and sorting m matching terms by weight is O(m log m), so total O(log n + m log m)

numberOfMatches(): Uses binary search twice O(log n) + O(log n) = O(2 log n), so total runtime is O(log n)



/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
The main thing I noticed from a usability standpoint is that the comparisons should be case-insensitive to make the GUI more useful.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
I worked on this by myself

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/





/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
The GUI made it useful. I will probably use this in the future for looking up cities, but I will modify the implementation to use case-insensitive comparisons.

