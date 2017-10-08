public class InfiniteSequence
{
    private String _sequence;
    private int _sequenceLength;

    public long findSequence(String sequence)
    {
        _sequence = sequence;
        _sequenceLength = sequence.length();
        long result = -1;

        for (int power = 1; power <= _sequenceLength; ++power)
            {
                for (int offset = 0; offset < power; ++offset)
                    {
                        long infOffset = findCoincidences(power, offset);
                        if (infOffset != -1 && (result == -1 || result > infOffset))
                            {
                                result = infOffset;
                            }
                    }

                if (result != -1)
                    {
                        break;
                    }
            }

        return result;
    }

    private long findCoincidences(int power, int offset)
        {
            String temp = null;
            Long value = -1L;
            Long lastValue;
            Long startValue = -1L;
            int currentPosition = offset;

            Long maxValue = (long)Math.pow(10, power) - 1;

            while (currentPosition < _sequenceLength)
                {
                    lastValue = value;

                    if (currentPosition + power <= _sequenceLength)
                        {
                            temp = _sequence.substring(currentPosition, currentPosition + power);
                            if (temp.charAt(0) == '0')
                                {
                                    return -1L;
                                }
                            value = Long.valueOf(temp);
                        }
                    else
                        {
                            int overflow = currentPosition + power - _sequenceLength;
                            String temp2 = _sequence.substring(currentPosition, currentPosition + power - overflow);
                            if (temp2.charAt(0) == '0')
                                {
                                    return -1L;
                                }

                            if (currentPosition > offset)
                                {
                                    temp = temp.substring(temp.length() - overflow, temp.length());
                                    value = nextValue(Long.valueOf(temp2), Long.valueOf(temp), temp.length());
                                }
                            else
                                {
                                    temp = _sequence.substring(offset - overflow, offset);
                                    value = nextValue(Long.valueOf(temp2), Long.valueOf(temp), temp.length());
                                }
                        }

                    if (currentPosition == offset)
                        {
                            startValue = value;
                            if (offset > 0)
                                {
                                    String offsetSequence = _sequence.substring(0, offset);
                                    String comparedString = String.valueOf(value - 1);
                                    comparedString = comparedString.substring(comparedString.length() - offset);
                                    if (!comparedString.equals(offsetSequence))
                                        {
                                            return -1L;
                                        }
                                }
                        }
                    else if(value - lastValue != 1)
                        {
                            return -1;
                        }

                    currentPosition += power;
                    if (value.equals(maxValue))
                        {
                            ++power;
                            maxValue += 9L * (long) Math.pow(10, power);
                        }

                }

            long result = 0;
            int startValuePower = startValue.toString().length();
            for (int i = 1; i < startValuePower; ++i)
                {
                    result += 9 * (long)Math.pow(10, i - 1) * i;
                }
            startValue -= (long)Math.pow(10, startValuePower - 1);
            result += startValue * startValuePower + 1;
            return result - offset;
        }

    private long nextValue(Long value, Long lastNumbers, int power)
    {
        long powerOfTen = (long)Math.pow(10, power);
        return lastNumbers < powerOfTen - 1 ?
                value * powerOfTen + lastNumbers + 1 :
                value * powerOfTen;
    }
}