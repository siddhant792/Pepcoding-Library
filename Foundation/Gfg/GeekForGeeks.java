
public class GeekForGeeks {

    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static void ratInMazeMultipleJump(int sr, int sc, int dr, int dc, int[][] option, int[][] dirArr,int[][] answer) {
        if (sr == dr && sc == dc) {
            answer[sr][sc] = 1;
            printBoard(answer);
            answer[sr][sc] = 0;
            return;
        }

        int n = option.length;
        int m = option[0].length;
        int k = option[sr][sc];
        answer[sr][sc] = 1;
        for (int radius = 1; radius <= k ; radius++) {
            for (int repeat = 0; repeat < dirArr.length; repeat++) {
                int r = sr + radius * dirArr[repeat][0];
                int c = sc + radius * dirArr[repeat][1];
                if (r < n && c < m && option[r][c] != 0) {
                    ratInMazeMultipleJump(r, c, dr, dc, option, dirArr,answer);
                }
            }
        }
        answer[sr][sc] = 0;
    }

    public static void printBoard(int[][] chess){
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int sumOfleafNodes(Node root){
        if(root == null) return 0;

        int left = sumOfleafNodes(root.left);
        int right = sumOfleafNodes(root.right);

        return left + right + (root.left==null && root.right==null ? root.data : 0);
    }

    

}
