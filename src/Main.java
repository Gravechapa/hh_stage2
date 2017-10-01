public class Main
{
    public static void main(String[] args)
    {
        Integer[][] island = {
                /*{4, 5, 4},
                {3, 1, 5},
                {5, 4, 1}*/
                /*{5, 3, 4, 5},
                {6, 2, 1, 4},
                {3, 1, 1, 4},
                {8, 5, 4, 3}*/
                /*{2, 2, 2},
                {2, 1, 2},
                {2, 1, 2},
                {2, 1, 2}*/
                {3, 3, 3, 3},
                {3, 1, 1, 3},
                {3, 1, 8, 3},
                {3, 3, 3, 3}

        };
        TropicalIsland ti = new TropicalIsland();
        long start = System.nanoTime();
        System.out.println(ti.getWaterVolume(island));
        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;
        System.out.println(microseconds);

        InfiniteSequence is = new InfiniteSequence();
        start = System.nanoTime();
        System.out.println(is.findSequence(555555559));
        end = System.nanoTime();
        microseconds = (end - start) / 1000;
        System.out.println(microseconds);
    }
}