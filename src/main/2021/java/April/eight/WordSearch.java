package April.eight;

public class WordSearch {

    int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public boolean exist(char[][] board, String word) {

        if(board == null && word == null) return true;

        boolean[][] visit = new boolean[board.length][board[0].length];
        char[] strs = word.toCharArray();
        for(int i = 0; i < board.length; i++){

            for(int j = 0; j < board[i].length; j++){

                // 如果当前位置灭有word中的数，则标记为已经访问过
                if(!ishave(strs, board[i][j])){

                    visit[i][j] = true;
                    continue;
                }

                if(help(strs, board, i, j, 0, visit)) return true;
            }
        }

        return false;
    }

    private boolean ishave(char[] strs, char c){

        for (char str : strs) {
            if(str == c) return true;
        }

        return false;
    }

    private boolean help(char[] strs, char[][] board, int i, int j, int index, boolean[][] visit){

        // 如果当前位置越界，并且当前位置不等于
        if( i < 0 || i >= board.length || j < 0 || j >= board[i].length || index >= strs.length || strs[index] != board[i][j] || visit[i][j]) return false;
        if(index == strs.length - 1) {
            return true;
        }

        for(int a = 0; a < move.length; a++){
                // 如果当前位置没有访问过
                if(!visit[i][j]){
                    visit[i][j] = true;
                    if(help(strs, board, i + move[a][0], j + move[a][1], index + 1, visit)) return true;
                    visit[i][j] = false;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        WordSearch w = new WordSearch();
        boolean exist = w.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},"ABCB");
        System.out.println(exist);
    }
}
