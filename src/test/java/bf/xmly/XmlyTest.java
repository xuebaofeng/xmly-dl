/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bf.xmly;

import org.junit.Test;

public class XmlyTest {
  @Test
  public void run() throws Exception {
    String[][] urls = {
            {"https://www.ximalaya.com/keji/20486769/"},
            {"https://www.ximalaya.com/keji/246622/"},
            {"https://www.ximalaya.com/keji/5411224/"},
            {"https://www.ximalaya.com/keji/4310827/"},
            {"https://www.ximalaya.com/keji/4769101/"},
    };
    for (String[] url : urls) {
      DownXmly.main(url);
    }
  }
}
