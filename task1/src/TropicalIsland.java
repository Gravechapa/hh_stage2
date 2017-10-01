public class TropicalIsland {
    public int getWaterVolume(Integer[][] island) {
        final int maxHight = 1000;
        boolean isStop;
        int result = 0;
        if (island.length < 3 || island[0].length < 3)
            {
                return result;
            }
        Integer[][] changedIsland = new Integer[island.length][island[0].length];
        changedIsland[0] = island[0];
        changedIsland[changedIsland.length - 1] = island[island.length - 1];
        for (int i = 1; i < island.length - 1; ++i)
            {
                for (int j = 0; j < island[i].length; ++j)
                    {
                        if (j == 0 || j == island[i].length -1)
                            {
                                changedIsland[i][j] = island[i][j];
                            }
                        else
                            {
                                changedIsland[i][j] = maxHight;
                            }
                    }
            }

        do
            {
                isStop = true;
                for (int i = 1; i < changedIsland.length - 1; ++i)
                {
                    for (int j = 1; j < changedIsland[i].length - 1; ++j)
                    {
                        if (island[i][j].equals(changedIsland[i][j]))
                            {
                                continue;
                            }

                        int minHight = Math.min(Math.min(changedIsland[i][j - 1], changedIsland[i - 1][j]),
                                Math.min(changedIsland[i][j + 1], changedIsland[i + 1][j]));

                        if (minHight < changedIsland[i][j])
                            {
                                changedIsland[i][j] = minHight > island[i][j] ? minHight : island[i][j];
                                isStop = false;
                            }
                    }
                }

                if (isStop)
                    {
                        break;
                    }

                for (int i = changedIsland.length - 1; i > 0; --i)
                {
                    for (int j = changedIsland[i].length - 1; j > 0; --j)
                    {
                        if (island[i][j].equals(changedIsland[i][j]))
                        {
                            continue;
                        }

                        int minHight = Math.min(Math.min(changedIsland[i][j - 1], changedIsland[i - 1][j]),
                                Math.min(changedIsland[i][j + 1], changedIsland[i + 1][j]));

                        if (minHight < changedIsland[i][j])
                        {
                            changedIsland[i][j] = minHight > island[i][j] ? minHight : island[i][j];
                            isStop = false;
                        }
                    }
                }
            } while(!isStop);

        for (int i = 1; i < changedIsland.length - 1; ++i)
        {
            for (int j = 1; j < changedIsland[i].length - 1; ++j)
            {
                result += changedIsland[i][j] - island[i][j];
            }
        }
        return result;
    }
}