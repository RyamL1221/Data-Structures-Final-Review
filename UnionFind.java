public class UnionFind {
    
    class QuickFind {
        
        private int[] id;

        public QuickFind(int n) {
            id = new int[n];
            for(int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        public int find(int target) {
            return id[target];
        }

        public void union(int int1, int int2) {
            
        }
    }
}