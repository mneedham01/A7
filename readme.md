RESULTS
Selection
-  10000: 0.43
-  20000: 1.44
-  40000: 5.87
Insertion
-  1000: 0.02
-  2000: 0.86
-  4000: 6.65
Merge
-  10000: 0.11
....
-  1920000: 2.66
-  3840000: 5.97

Quicksort
-  10000: 0.19
...
-  160000: 4.7

In the experiments, I found that the quickest method, by far, was merge sort. Quicksort was also fast, but both selection sort and insertion sort were slow. For insertion sort, I used index instead of an iterator, so it was much slower by far than the other methods, which I expected.

This assignment went relatively well; I wish I could have found a way to use an iterator but ran out of time.