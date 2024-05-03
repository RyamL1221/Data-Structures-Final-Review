public class UnionFind {
    
    /*
     * Eager approach
     * Union is too expensive.
     * Processing a sequence of of n union operations on n elements takes more than n^2 array accesses.
     * Big O - initialize - O(n), union - O(n), find - O(1)
     */
    class QuickFind {
        
        // id[n] points to n's parent 
        private int[] parent; 

        /*
         * @param n - array size 
         */
        public QuickFind(int n) {
            parent = new int[n];
            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        /*
         * @param target - the number that is being searched for 
         * @return the target's parent
         */
        public int find(int target) {
            return parent[target]; // returns target's parent 
        }

        /*
         * sets int1 as int2's child
         * @param int1 - first number that is being unioned
         * @param int2 - second number that is being unioned 
         * connecting these two numbers
         */
        public void union(int int1, int int2) {
            int parentInt1 = parent[int1]; // finds int1's parent
            int parentInt2 = parent[int2]; // find int2's parent
            for(int i = 0; i < parent.length; i++) {
                if(parent[i] == int1) {
                    parent[i] = parentInt2;
                }
            }
        }
    }

    /*
     * The lazy approach
     * Can be interpreted as a tree
     * Trees can get too tall
     * Find is too expensive
     * Big O - initialize - O(n), union - O(n), find - O(n)
     */
    class QuickUnion {

        // parent array
        private int[] parent;

        /*
         * @param n - size of array
         * Populates the parent array and set each element's parent to itself
         */
        public QuickUnion(int n) {
            parent = new int[n];
            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        /*
         * @param number that is being searched for
         * @return parent of the number being searched 
         * traverse the parent tree until the root is reached
         * 
         */
        public int find(int target) {
            while(target != parent[target]) {
                target = parent[target];
            }
            return target;
        }

        /*
         * @param int1 - the child 
         * @param int2 - new parent
         * changes the parent of int1 to the parent of int2
         */
        public void union(int int1, int int2) {
            int parent1 = find(int1);
            int parent2 = find(int2);
            parent[parent1] = parent2;
        }
    }

    /*
     * Modify quick union to avoid tall trees
     * Keep trach of each tree
     * Link root of smaller tree to large tree
     */
    class WeightedQuickUnion {
        // parent array
        int[] parent;

        //size of each tree
        int[] size;

        /*
         * @param n - parent array size 
         */
        public WeightedQuickUnion(int n) {
            parent = new int[n];
            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void updateSize() {
            int size = 0;
            for(int i = 0; i < this.size.length; i++) {
                int index = i;
                size = 0;
                while(index != parent[index]) {
                    size++;
                    index = parent[index];
                }
                this.size[index] = size;
            }
        }

        /*
         * @param target - trying to find the parent of the number "target"
         * uses quick find 
         */
        public int find(int target) {
            while(target != parent[target]) {
                target = parent[target];
            }
            return target;
        }

        public void union(int int1, int int2) {
            int parent1 = find(int1);
            int parent2 = find(int2);
            if(parent1 == parent2) return;

            // parent1 is the root of the smaller tree
            if(size[parent1] >= size[parent2]) {
                int temp = parent1;
                parent1 = parent2;
                parent2 = temp;
            }

            // link root of smaller tree to root of the larger tree
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }
    }
}