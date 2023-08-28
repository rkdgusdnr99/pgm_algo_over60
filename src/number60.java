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


    public int[] slowerShortSolution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }

}
