## Notes 

#### No. of edges
  - The maximum number of edges in an undirected graph is n(n-1)/2 and obviously in a directed graph there are twice as many. If the graph is not a multi graph then it is clearly n * (n - 1), as each node can at most have edges to every other node.
  - There are a total of 2^(n*(n-1)/2) possible undirected graphs that can be constructed using the n vertices. Because you can add NcR of all edges starting from max edges, R=  n*(n-1)/2 to 1, and keeping constantly N = n*(n-1)/2. Sum of combinations is 2^n always.
