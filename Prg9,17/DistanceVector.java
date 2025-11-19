public class DistanceVector {
    public static void main(String[] args) {
        int INF = 999;
        int n = 3;
        int[][] cost = {{0, 2, 7}, {2, 0, 1}, {7, 1, 0}};
        int[][] d = new int[n][n];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                d[i][j] = cost[i][j];

        for (int k=0;k<n;k++)
            for (int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    if (d[i][j] > d[i][k] + d[k][j])
                        d[i][j] = d[i][k] + d[k][j];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++)
                System.out.print(d[i][j] + " ");
            System.out.println();
        }
    }
}
