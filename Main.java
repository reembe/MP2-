/** A class with a method that converts
  * an int to a String.
  * @author Reem
  * @version 1.0 */
public class Main
  {
    public static void main(String[] args)
    {
      int j = 0;
      while(j != 3)
        {
          for(int i = 0; i > 7; i++)
        {
          System.out.print(i);
        }
          j++;
        }
    }
     /** This method returns the parameter as a String.
    * @param i an integer 
    * @return the integer parameter as a String **/
  public static String toString(int num)
  {
    return num + "";
  }
  }
