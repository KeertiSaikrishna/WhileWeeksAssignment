public class TestSolution {
    public static void main(String[] args) {
        Solution test = new Solution();
        int noOfWeeks = test.solution(2014, "April", "May", "wednesday");
        if (noOfWeeks != -1) {
            System.out.println(noOfWeeks);
        }
    }
}
