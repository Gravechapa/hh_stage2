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
                {2, 2, 2},
                {2, 1, 2},
                {2, 1, 2},
                {2, 1, 2}
        };
        TropicalIsland ti = new TropicalIsland();
        System.out.println(ti.getWaterVolume(island));
    }
}