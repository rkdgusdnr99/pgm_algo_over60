public class number60 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int arrlen = wallpaper.length;
        int strlen = wallpaper[0].length();
        String repeatstar = ".".repeat(strlen);
        for (int i = 0; i < arrlen; i++) {
            if (!wallpaper[i].equals(repeatstar)) {
                answer[0] = i;
                break;
            }
        }
        for (int i = arrlen; i > 0; i--) {
            if (!wallpaper[i-1].equals(repeatstar)) {
                answer[2] = i;
                break;
            }
        }
        for (int i = 0; i < strlen; i++) {
            boolean tf = false;
            for(int j = 0; j < arrlen; j++) {
                if (wallpaper[j].charAt(i) == '#') {
                    answer[1] = i;
                    tf = true;
                    break;
                }
            }
            if (tf == true)
                break;
        }
        for (int i = strlen; i > 0; i--) {
            boolean tf = false;
            for(int j = 0; j < arrlen; j++) {
                if (wallpaper[j].charAt(i - 1) == '#') {
                    answer[3] = i;
                    tf = true;
                    break;
                }
            }
            if (tf == true)
                break;
        }
        return answer;
    }
}
