/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bf.xmly;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void run() throws Exception {
    String[][] urls = {
        { "https://www.ximalaya.com/keji/246622/" },
        { "https://www.ximalaya.com/keji/5411224/" },
        { "https://www.ximalaya.com/xiangsheng/304601/" },
        { "https://www.ximalaya.com/xiangsheng/378478/" },
        { "https://www.ximalaya.com/keji/3308560/" },
        { "https://www.ximalaya.com/xiangsheng/2670589/" },
        { "https://www.ximalaya.com/xiangsheng/271731/" }

    };
    for (String[] url : urls) {
      App.main(url);
    }
  }
}
