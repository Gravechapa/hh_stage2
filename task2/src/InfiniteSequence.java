public class InfiniteSequence
{
    public int findSequence(int sequence)
    {
        int result;
        String seq = Integer.toString(sequence);
        String infSeq = "";
        int counter = 1;
        int offset = 1;
        while (true)
        {
            while (infSeq.length() < seq.length() * 4)
                {
                    infSeq += counter++;
                }
            result = infSeq.indexOf(seq);

            if (result != -1)
                {
                    result += offset;
                    break;
                }

            offset += infSeq.length() - seq.length() + 1;
            infSeq = infSeq.substring(infSeq.length() - seq.length() + 1);

        }
        return result;
    }
}