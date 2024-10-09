package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;
/**
 * All possible Caesar Cipher combinations of given word.
 *
 * @author Mina Bakrac
 */
public class AllCaesar {
  /**
  * Encode or decode a word given as input for all keys a-z.
  *
  * @param args
  *   Command line arguments.
  */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length == 2) {
      String str = args[1];
      if (args[0] == "encode") {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        } // for
      } else if (args[0] == "decode") {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
        } // for
      } else {
        System.err.println("Error: Please enter either 'encode' of 'decode'.");
      } // if/else
    } else if ((args.length < 2) || (args.length > 2)) {
      System.err.println("Error: Please enter two arguments.");
    } // if/else
    pen.close();
  } // main(String[])
} // class AllCaesar
