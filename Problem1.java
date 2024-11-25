// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    //TC:O(M*N)
    //SC:O(M*N)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        int oldColor = image[sr][sc] ;
        image[sr][sc] = color;
        dfsHelper(image,sr,sc,oldColor ,color);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]<0){
                    image[i][j] = image[i][j]*-1;
                }

            }
        }
        return image;
    }

    void dfsHelper(int[][] image, int i, int j,int oldColor, int color){

        for(int[] dir : this.dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]>=0 && image[r][c] == oldColor){
                image[r][c] = -1*color;
                dfsHelper(image, r, c,oldColor, color);

            }
        }

    }
    //TC:O(M*N)
    //SC:O(M*N)
    int[][] bfsHelper(int[][] image, int sr, int sc, int color){
        if(image[sr][sc] == color){
            return image;
        }

        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc] ;

        image[sr][sc] = -1*color;
        q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int[] curr =  q.poll();
            for(int[] dir : this.dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] +curr[1];
                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]>=0){
                    image[r][c] = image[r][c]*-1;
                    if(image[r][c] == -1*oldColor){

                        image[r][c] = -1*color;
                        q.add(new int[]{r,c});
                    }
                }
            }


        }

        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]<0){
                    image[i][j] = image[i][j]*-1;
                }

            }
        }
        return image;
    }

}