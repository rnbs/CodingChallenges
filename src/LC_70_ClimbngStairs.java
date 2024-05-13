public class LC_70_ClimbngStairs {
    public static int climbstairs(int n) {

        if(n == 2 || n == 1) {
            return n;
        }

        int[] memoryTable = new int[n+1];
        memoryTable[1] = 1;
        memoryTable[2] = 2;
        for (int steps = 3; steps < memoryTable.length; steps++) {
            memoryTable[steps] = memoryTable[steps -1] + memoryTable[steps -2];
        }
        return memoryTable[n];
    }

    public static void main(String[] args) {
        System.out.println(climbstairs(2));
        System.out.println(climbstairs(3));
    }
}
