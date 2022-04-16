**Problem Statement:**
<br>
Given a N-by-N grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of 
neighboring (left, right, up or down) open sites. The system is said to be percolating if there is a full site in the bottom row. In other words, a system percolates if we 
fill all open sites connected to the top row and that process fills some open sites in the bottom row.
<br><br>
**Approach:**
<br>
We can convert the 2D grid to a 1D union-find to solve this problem. We can add two virtual nodes. The vitual top node is unioned with the top row and virtual bottom node is 
unioned with the bottom row. Now, to check isFull(i) we can easily check whether i is connected to the virtual top node.
