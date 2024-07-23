import java.util.ArrayList;
import java.util.List;

class BacktrackingTemplate {
  public List<List<Integer>> backtrack(int[] input) {
    List<List<Integer>> result = new ArrayList<>();
    backtrackHelper(new ArrayList<>(), 0, input, result);
    return result;
  }

  private void backtrackHelper(List<Integer> current, int index, int[] input, List<List<Integer>> result) {
    // Base case: check if the current state is a valid solution
    if (isValidSolution(current)) {
      result.add(new ArrayList<>(current));
      return;
    }

    // Check if we've reached the end of our choices
    if (index >= input.length) {
      return;
    }

    // Recursive case: try all possible choices
    for (int i = index; i < input.length; i++) {
      // Make a choice
      current.add(input[i]);

      // Recurse
      backtrackHelper(current, i + 1, input, result);

      // Undo the choice (backtrack)
      current.remove(current.size() - 1);
    }
  }

  private boolean isValidSolution(List<Integer> current) {
    // Implement your solution validation logic here
    return true; // This is a placeholder
  }

  public static void main(String[] args) {
    BacktrackingTemplate solution = new BacktrackingTemplate();
    int[] input = {1, 2, 3};
    List<List<Integer>> result = solution.backtrack(input);
    System.out.println(result);
  }
}