**Problem Statement:** 
<br>
Social network connectivity. Given a social network containing N members and a log file containing M timestamps at which times pairs of members formed friendships, 
design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend … of a friend). 
Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. 
The running time of your algorithm should be MlogN or better and use extra space proportional to N.
<br> <br>
**Pseudo-code:**
<br>
uf := UnionFind(1..N) <br>
count := 0 <br>
for timestamp p, q in friendships {<br>
&nbsp;&nbsp;&nbsp;&nbsp;if uf.Find(p) != uf.Find(q) { <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uf.Union(p, q) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;count++ <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if count == N-1 { <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return timestamp <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;} <br>
&nbsp;&nbsp;&nbsp;&nbsp;} <br>
} <br>
return +infinity <br>
