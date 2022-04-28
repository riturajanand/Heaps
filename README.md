# Heaps

*Complete Binary Tree*: Its is binary tree which is completely filled except the last level and insertions takes place from the left most 
                          empty node. 
                         
*HEAP*: Heap is a CBT that comes with heap property.

There are two heap order properties
     1. Max heap property 
     2. Min heap property
     
     In a max heap parent nodes always have greater values than their children and in a min heap parent node always have lesser values than their children.
     
     Heap is simply represented using arrays. 
     
     Indices.      1 2 3 4 5 6 7
     Array         5 3 8 0 9 6 1
     
     The heap of the aobe array looks like this 
                               1.   5
                                   / \
                                  /   \
                                 /     \
                            2.  3       8    .3
                               / \     / \
                              /   \   /   \
                             0    9  6     1
                             4.   5. 6.    7. 
                             
            We can see that left child of an element at index i is 2*i and right child is 2*i+1
            On the other hand parent of an element at index i is n/2.  
            NOTE: To have this convenience of finding the parent and child indices we used 1 based indexing for heaps. 
            
            If you want to follow 0 based indexing, then left child is 2*i+1 and right child is 2*i+2.
            And parent of an element with index i is i/2 (if i is odd) (i/2)-1 (if i is even).
