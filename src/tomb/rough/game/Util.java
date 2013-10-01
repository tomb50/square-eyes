package tomb.rough.game;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 24/09/2013 Time: 13:24
 */
public class Util
{


  /** Found from stack exchange*/
  private static final int CLIENT_CODE_STACK_INDEX;

  static {
    // Finds out the index of "this code" in the returned stack trace - funny but it differs in JDK 1.5 and 1.6
    int i = 0;
    for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
      i++;
      if (ste.getClassName().equals(Util.class.getName())) {
        break;
      }
    }
    CLIENT_CODE_STACK_INDEX = i-3;
  }

  public static void main(String[] args) {
    System.out.println("className() =" + className());
    System.out.println("methodName() = " + methodName());
    System.out.println("CLIENT_CODE_STACK_INDEX = " + CLIENT_CODE_STACK_INDEX);
  }

  public static void debug(String message)
  {
    System.out.println("className() = " + className() + ", methodName() = " + methodName() + ", message: " + message);

  }

  public static String methodName() {
    return Thread.currentThread().getStackTrace()[CLIENT_CODE_STACK_INDEX].getMethodName();

  }

  public static String className() {
    return Thread.currentThread().getStackTrace()[CLIENT_CODE_STACK_INDEX].getClassName();
  }
}
