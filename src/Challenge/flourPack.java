package Challenge;

public class flourPack {
    public static void main(String[] args) {
        System.out.println("Can pack (1,0,4): "+ canPack(1,0,4));
        System.out.println("Can pack (1,0,5): "+ canPack(1,0,5));
        System.out.println("Can pack (6,2,17): "+ canPack(6,2,17));
        System.out.println(17/5);
    }

    /**
     * The parameter bigCount represents the count of big flour bags (5 kilos each).
     *
     * The parameter smallCount represents the count of small flour bags (1 kilo each).
     *
     * The parameter goal represents the goal amount of kilos of flour needed to assemble a package.
     * @param bigCount
     * @param smallCount
     * @param goal
     * @return
     */
    public static boolean canPack(int bigCount, int smallCount, int goal){
        boolean isPack = false;
        if(bigCount >= 0 && smallCount >= 0 && goal >= 0 && (bigCount*5 + smallCount >= goal)){
            if(bigCount* 5 % goal == 0 ) isPack = true;
            else if (bigCount * 5 <= goal){
                isPack = bigCount*5 + smallCount >= goal;
            }
            else {
                int div = goal / 5;
                isPack = div <= bigCount && div*5 + smallCount >= goal && smallCount > 0;
            }
        }
        return isPack;
    }
}
