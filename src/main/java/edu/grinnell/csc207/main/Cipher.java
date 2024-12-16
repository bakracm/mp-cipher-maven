package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * Encodes and decodes using ciphers.
 *
 * @author Mina Bakrac
 */
public class Cipher {

  /**
   * The required number of arguments.
   */
  static final int ARGSLEN = 4;

  /**
  * Encode or decode a word given as input using any cipher.
  *
  * @param args
  *   Command line arguments.
  */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String cipherType = new String();
    String encOrDec = new String();
    String[] wordAndKey = new String[2];
    int c = 0;
    int hasSpace = 0;
    int noKey = 0;

    if (args.length == ARGSLEN) {
      for (int i = 0; i < args.length; i++) {
        if (args[i] == "") {
          noKey = 1;
        } else if (args[i].charAt(0) == '-') {
          if (args[i] == "-encode") {
            encOrDec = "encode";
          } // if
          if (args[i] == "-decode") {
            encOrDec = "decode";
          } // if
          if (args[i] == "-caesar") {
            cipherType = "caesar";
          } // if
          if (args[i] == "-vigenere") {
            cipherType = "vigenere";
          } // if
        } else {
          wordAndKey[c] = args[i];
          c++;
        } // if/else
      } // for

      for (int j = 0; j < wordAndKey[0].length(); j++) {
        if (wordAndKey[0].charAt(j) == ' ') {
          hasSpace = 1;
        } // if
      } // for

      if ((wordAndKey[0] == wordAndKey[0].toLowerCase()) && (hasSpace == 0)) {
        if ((noKey == 0) && (wordAndKey[1] == wordAndKey[1].toLowerCase())) {
          if (cipherType != "") {
            if (encOrDec != "") {
              if ((cipherType == "caesar") && (wordAndKey[1].length() == 1)) {
                if (encOrDec == "encode") {
                  pen.println(CipherUtils.caesarEncrypt(wordAndKey[0], wordAndKey[1].charAt(0)));
                } // if
                if (encOrDec == "decode") {
                  pen.println(CipherUtils.caesarDecrypt(wordAndKey[0], wordAndKey[1].charAt(0)));
                } // if
              } else if (cipherType == "vigenere") {
                if (encOrDec == "encode") {
                  pen.println(CipherUtils.vigenereEncrypt(wordAndKey[0], wordAndKey[1]));
                } // if
                if (encOrDec == "decode") {
                  pen.println(CipherUtils.vigenereDecrypt(wordAndKey[0], wordAndKey[1]));
                } // if
              } else {
                System.err.println("Error: Caesar key must have length 1");
              } // if/else
            } else {
              System.err.println("Error: Please provide either -encode or -decode");
            } // if/else
          } else {
            System.err.println("Error: Please provide a cipher type: -caesar or -vigenere");
          } // if/else
        } else {
          System.err.println("Error: Provided invalid word.");
        } // if/else
      } else {
        System.err.println("Error: Provided invalid key");
      } // if/else
    } else if ((args.length < ARGSLEN) || (args.length > ARGSLEN)) {
      System.err.println("Error: Provided incorrect number of arguments.");
    } // if/else
    pen.close();
  } // main(String[])
} // class Cipher

