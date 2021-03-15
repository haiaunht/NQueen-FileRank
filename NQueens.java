import java.util.ArrayList;
import java.util.List;

/**
 * Hai-Au Bui, Assignment #7
 * Professor Abbott
 */
public class NQueens {
  private int n = 0;

  public NQueens (int n) {
    this.n = n;
  }

  public List<List<String>> getSolution() {
    List<List<String>> solutions = new ArrayList<>();

    int[] column = new int[this.n];
    int[] queens = new int[this.n];
    int[] leftDiagonal = new int[2 * this.n - 1];
    int[] rightDiagonal = new int[2 * this.n - 1];

    Calculate(0, this.n, queens, column, leftDiagonal, rightDiagonal, solutions);
    return solutions;
  }

  public void Calculate(int row, int n, int queens[], int column[],
      int leftDiagonal[], int rightDig[], List<List<String>> solutions) {

    // if I was here which means I found queen at row n-1, n-2, ...done
    if (row == n) {
      addSolutions(solutions, queens);
      return;
    }

    // if i am not go over all the row, keep finding solutions
    for (int col = 0; col < column.length; col++) {
      if (column[col] == 0 && leftDiagonal[row + col] == 0 && rightDig[row - col + n - 1] == 0) {

        queens[row] = col;
        column[col] = 1;
        leftDiagonal[row + col] = 1;
        rightDig[row - col + n - 1] = 1;
        Calculate(row + 1, n, queens, column, leftDiagonal, rightDig, solutions);

        // if it is not working, backtracking and make these back to 0
        queens[row] = 0;
        column[col] = 0;
        leftDiagonal[row + col] = 0;
        rightDig[row - col + n - 1] = 0;
      }
    }
  }

  private void addSolutions(List<List<String>> solutions, int queens[]) {
    List<String> solution = new ArrayList<>();
    int queenRank = queens.length;
    for (int i = 0; i < queenRank; ++i) {
      int queenFile = queens[i];

      StringBuilder sb = new StringBuilder();
      sb.append("{" + convertColToFile(queenFile) + (queenRank - i) + "}");

      solution.add(sb.toString());
    }
    solutions.add(solution);
  }

  private char convertColToFile(int n) {
    switch (n) {
      case 0:
        return  'A';
      case 1:
        return 'B';
      case 2:
        return 'C';
      case 3:
        return 'D';
      case 4:
        return 'E';
      case 5:
        return 'F';
      case 6:
        return 'G';
      case 7:
        return 'H';
      case 8:
        return 'I';
      case 9:
        return 'J';
      default:
        return '?'; // the range of n is from 1-10 so this step will not reach
    }
  }

}
