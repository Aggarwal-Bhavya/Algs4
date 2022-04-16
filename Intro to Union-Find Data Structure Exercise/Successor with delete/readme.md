**Problem Statement:**
<br>
Given a set of n integers S = {0, 1,..., n-1} and a sequence of requests of the following form:
<br>
* Remove x from S
* Find the successor of x: the smallest y in S such that y >= x. <br>
Design a data type so that all operations (except construction) take logarithmic time or better in the worst case.  
<br> 

**Approach:**<br>
For this, we can modify the UFWithFindLargest. The remove() method indicates union(x, x+1) or union(x, x-1) method, because of which the actual root node of x is becomes different.
Another actualList array can be added which would corresponds to the root of any removed number.
