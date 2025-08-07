public class GradeStatisticsSystem {
    public static void main(String[] args) {
        int[] grades = {85, 92, 78, 96, 87, 73, 89, 94, 82, 90};
        int sum = 0, max = grades[0], min = grades[0];
        int[] levelCount = new int[5]; // A, B, C, D, F

        for (int grade : grades) {
            sum += grade;
            if (grade > max) max = grade;
            if (grade < min) min = grade;

            if (grade >= 90) levelCount[0]++;
            else if (grade >= 80) levelCount[1]++;
            else if (grade >= 70) levelCount[2]++;
            else if (grade >= 60) levelCount[3]++;
            else levelCount[4]++;
        }

        double avg = sum / (double) grades.length;
        int aboveAvg = 0;
        for (int grade : grades) {
            if (grade > avg) aboveAvg++;
        }

        System.out.println("平均: " + avg);
        System.out.println("最高分: " + max);
        System.out.println("最低分: " + min);
        System.out.println("A: " + levelCount[0] + ", B: " + levelCount[1] + ", C: " + levelCount[2] +
                ", D: " + levelCount[3] + ", F: " + levelCount[4]);
        System.out.println("高於平均的人數: " + aboveAvg);
    }
}
