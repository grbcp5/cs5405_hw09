
/*
 * CS5405
 * Grant Broadwater (grbcp5)
 *
 * ResourceLoader.java
 */
package code;

import java.io.InputStream;

final public class ResourceLoader {

  public static InputStream load(String path) {
    
    InputStream input = ResourceLoader.class.getResourceAsStream(path);

    if (input == null) {
      input = ResourceLoader.class.getResourceAsStream("/" + path);
    }

    return input;
  }

}
