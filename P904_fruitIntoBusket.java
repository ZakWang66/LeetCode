public class P904_fruitIntoBusket {
    public static int totalFruit(int[] tree) {
        if (tree.length <= 2) {
            return tree.length;
        }
        int lastCount = 0;
        int lastLastCount = 0;
        int lastType = tree[1];
        int lastLastType = tree[0];
        int maxFruit = 0;
        lastCount++;
        lastLastCount++;
        for (int i = 2; i < tree.length; i++) {
            int thisType = tree[i];
            if (thisType == lastType) {
                lastCount++;
            }
            if (thisType == lastLastType && lastType != lastLastType) {
                lastLastCount++;
            }
            // going to stop (drop the lastLastType), check the max can be updated ?
            if (lastType != thisType && lastLastType != thisType) {
                lastLastType = lastType;
                lastType = thisType;
                lastLastCount = lastCount;
                lastCount = 1;
            }

            int fruitCount;
            if (lastLastType != lastType) {
                fruitCount = lastCount + lastLastCount;
            }
            else 
                fruitCount = lastCount;

            if (fruitCount > maxFruit) {
                maxFruit = fruitCount;
            }
        }
        return maxFruit;
    }
    public static void main(String[] args) {
        int[] tree = {1,0,1,4,1,4,1,2,3};
        System.out.println(totalFruit(tree));
    }
}