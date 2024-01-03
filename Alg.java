public class Alg {
    public static String Algs(String[] i)
    {
        String shrt = i[0];
        for (int j = 1; j < i.length; j++)
        {
            if (i[j].length() > i[j - 1].length())
            {
                shrt = i[j];
            }


        }
        return shrt;
    }
}
