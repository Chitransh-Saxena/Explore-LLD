# Problem to be solved in order to deeply study visitor pattern, and why exactly it is required


## Problem Context
- A situation where a complex Tree representing complex data. Financial Product Hierarchy
- Each node in the tree represents
  - Portfolio Nodes - aggregation of accounts
  - Account Nodes - holding of multiple assets
  - Asset Nodes - individual securities, derivatives etc.
- Tree is quite large and changes frequently
- Operations needed on the Tree
  1. Valuation Operation
    - Compute the total value of all the assets in the entire hierarchy
    - Compute all : Assets > Portfolio > Accounts
    - Must be concurrent because of performance reasons.
      - Spawn threads to handle subtrees
  2. Risk Analysis
    - Analyse risk exposure for each portfolio by aggregating risks from accounts and asset nodes
    - Multiple risk computations: VaR, expected shortfall could run concurrently on separate branches of the tree
  3. Regulatory Reporting Operation
    - Generate various compliance reports that means traversing the tree, collecting the right data points, perform operations on that if needed,
      - And dump the response into a file.
    - Might be doing a dummy version of this operation in code implementation

## How does the Tree and functionalities look like?
- ![finance-tree-problem-statement.png](..%2F..%2F..%2F..%2F..%2F..%2Fdocs%2Fdiagrams%2Ffinance-tree-problem-statement.png)


## UML for this problem
- ![finance-tree-uml.png](..%2F..%2F..%2F..%2F..%2F..%2Fdocs%2Fdiagrams%2Ffinance-tree-uml.png)


## Why does this problem fall under visitor?

- Without Visitor
  - 3 Nodes are part of the same tree data structure
  - So many complex operations are required to be performed on them, which will club the operations and keep making the class messy
    - This makes the code unreadable, error prone and very very hard to test
    - Also, what happens if new functionality common for all the nodes have to be added
  - Multithreading and other concurrent operations are very hard to implement.
    - Faced it in a previous project so this is true
  - Constant changes violate the OCP and SRP

- Important pointer
  - If the operations are to be performed across all classes, then it makes more sense to use visitor
  - If the operations are specific to certain nodes, using interfaces would be better
  - Depending upon what kind of situation it is, a combination or only simple code path can also be chosen, no visitor required.