package algorithm;

public class Algorithm {

    public static boolean calc(int w, int h, int i, int j) {
        return (i >= 0 && i < h && j >= 0 && j < w);
    }

    public static void main(String[] args) {
        int[][] field = {
            {0, 1, 0, 1},
            {0, 0, 0, 1},
            {1, 1, 1, 0},
            {0, 1, 1, 1}
        };
        int[][] mines = new int[4][4];
        int w = 4, h = 4;
        for (int l = 0; l < h; l++) {
            for (int k = 0; k < w; k++) {
                if (field[l][k] == 0) continue;
                for (int i = l - 1; i <= l + 1; i++) {
                    for (int j = k - 1; j <= k + 1; j++) {
                        if (calc(w, h, i, j)) {
                            mines[i][j] += 1;
                        }
                    }
                }
            }
        }
        for (int l = 0; l < h; l++) {
            for (int k = 0; k < w; k++) {
                System.out.print(mines[l][k] + " ");
            }
            System.out.println();
        }
    }
}