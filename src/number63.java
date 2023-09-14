public class number63 {
    public static void main(String[] args) {
        String[] park1 = {"SOO","OOO","OOO"};
        String[] park2 = {"SOO","OXX","OOO"};
        String[] park3 = {"OSO","OOO","OXO","OOO"};

        String[] routes1 = {"E 2","S 2","W 1"};
        String[] routes2 = {"E 2","S 2","W 1"};
        String[] routes3 = {"E 2","S 3","W 1"};

        int[] answer1 = solution(park1, routes1);
        System.out.println(answer1[0] + ", " + answer1[1]);

        int[] answer2 = solution(park2, routes2);
        System.out.println(answer2[0] + ", " + answer2[1]);

        int[] answer3 = solution(park3, routes3);
        System.out.println(answer3[0] + ", " + answer3[1]);
    }
    public static int[] solution(String[] park, String[] routes) {
        // park를 한바퀴 돌림
        String[] turnPark = rotate(park);
        int xSize = park[0].length();
        int ySize = turnPark[0].length();
        int[] answer = findS(park);

        System.out.println("S test: " +answer[0] + ", " + answer[1]);

        for (String route: routes) {
            String[] parts = route.split(" ");
            int distance = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "E":
                    if (answer[1] + distance < xSize)
                        if (!park[answer[0]].substring(answer[1], answer[1] + distance + 1).contains("X"))
                            answer[1] += distance;
                    break;
                case "W":
                    if (answer[1] - distance >= 0)
                        if (!park[answer[0]].substring(answer[1] - distance, answer[1] + 1).contains("X"))
                            answer[1] -= distance;
                    break;
                case "N":
                    if (answer[0] - distance >= 0)
                        if (!turnPark[answer[1]].substring(ySize - answer[0] - 1, ySize - answer[0] + distance).contains("X"))
                            answer[0] -= distance;
                    break;
                case "S":
                    if (answer[0] + distance < ySize)
                        if (!turnPark[answer[1]].substring(ySize - answer[0] - distance - 1, ySize - answer[0]).contains("X"))
                            answer[0] += distance;
                    break;
                default:
                    break;
            }
            System.out.println("for test: " +answer[0] + ", " + answer[1]);
        }
        return answer;
    }

    public static int[] findS(String[] park) {
        int numRows = park.length;
        int numCols = park[0].length();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (park[row].charAt(col) == 'S') {
                    return new int[]{row, col};
                }
            }
        }
        // "S"를 찾지 못한 경우
        return new int[]{-1, -1};
    }

    public static String[] rotate(String[] park) {
        int numRows = park.length;
        int numCols = park[0].length();

        // 결과를 저장할 배열을 생성합니다.
        String[] rotatedPark = new String[numCols];

        for (int col = 0; col < numCols; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = numRows - 1; row >= 0; row--) {
                sb.append(park[row].charAt(col));
            }
            rotatedPark[col] = sb.toString();
        }
        return rotatedPark;
    }


}
