##### 05. BFS
- We will need an arraylist where we will add whatever we remove from queue. We need a queue, where we will add all univisited neighbours after marking them as visited.
- Initially q.add(0) and vis[0] = true. while(!q.isEmpty()) remove from queue, add it to arraylist, for(all neighbours of curr) if they're unvisited then add to queue and mark them visited.

#### 06. DFS
- We will need an arraylist, "answer", visited array, and recursion.
- DFS is, explore all neighbours of n, add the uv neighbour of n to answer, mark it as visited, and call the function on that neighbour.
