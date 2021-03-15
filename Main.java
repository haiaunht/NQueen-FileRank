import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    //System.out.println(solveNQueens(4));
    NQueens test = new NQueens(4);
    System.out.println(test.getSolution());
  }
}
