package edu.grinnell.csc207.util;

/**
 * Methods used for encoding and decoding.
 *
 * @author Mina Bakrac
 */
public class CipherUtils {

  /**
   * The length of the alphabet.
   */
  static final int ALPHABETLEN = 26;

  /**
   * The base of lowercase letters in ASCII.
   */
  static final int BASEASCII = 97;

  /**
   * Converts letter to integer (0-26).
   *
   * @param letter
   *   The letter we are converting
   * @return the number equivalent of that letter.
   */
  private static int letter2int(char letter) {
    return (int) letter - BASEASCII;
  } // letter2int(char)

  /**
   * Converts integer to letter (a-z).
   *
   * @param i
   *   The number we are converting
   * @return the letter equivalent of that number.
   */
  private static char int2letter(int i) {
    return (char) (i + BASEASCII);
  } // int2letter(int)

  /**
   * Uses the Caesar Cipher to encrypt a word.
   *
   * @param str
   *   The word we are encrypting.
   * @param letter
   *   The key we are using to encrypt.
   * @return the encrypted word.
   */
  public static String caesarEncrypt(String str, char letter) {
    int len = str.length();
    char[] encrArr = new char[len];
    char[] strArr = new char[len];
    strArr = str.toCharArray();
    for (int i = 0; i < len; i++) {
      encrArr[i] = int2letter((letter2int(strArr[i]) + letter2int(letter)) % ALPHABETLEN);
    } // for
    return new String(encrArr);
  } // caesarEncrypt(String, char)

  /**
   * Uses the Caesar Cipher to decrypt a word.
   *
   * @param str
   *   The word we are decrypting.
   * @param letter
   *   The key we are using to decrypt.
   * @return the decrypted word.
   */
  public static String caesarDecrypt(String str, char letter) {
    int len = str.length();
    char[] decrArr = new char[len];
    char[] strArr = new char[len];
    strArr = str.toCharArray();
    int decrInt;
    for (int i = 0; i < len; i++) {
      decrInt = (letter2int(strArr[i]) - letter2int(letter)) % ALPHABETLEN;
      if (decrInt < 0) {
        decrArr[i] = int2letter(ALPHABETLEN + decrInt);
      } else {
        decrArr[i] = int2letter(decrInt);
      } // if/else
    } // for
    return new String(decrArr);
  } // caesarDecrypt(String, char)

  /**
   * Uses the Vigenere Cipher to encrypt a word.
   *
   * @param str
   *   The word we are encrypting.
   * @param key
   *   The string we are using to encrypt.
   * @return the encrypted word.
   */
  public static String vigenereEncrypt(String str, String key) {
    int lenStr = str.length();
    int lenKey = key.length();
    char[] strArr = new char[lenStr];
    strArr = str.toCharArray();
    char[] encrArr = new char[lenStr];
    char[] keyword = new char[lenStr];
    for (int i = 0; i < lenStr; i++) {
      keyword[i] = key.charAt(i % lenKey);
    } // for
    for (int i = 0; i < lenStr; i++) {
      encrArr[i] = int2letter((letter2int(strArr[i]) + letter2int(keyword[i])) % ALPHABETLEN);
    } // for
    return new String(encrArr);
  } // vigenereEncrypt(String, String)

  /**
   * Uses the Vigenere Cipher to decrypt a word.
   *
   * @param str
   *   The word we are decrypting.
   * @param key
   *   The string we are using to decrypt.
   * @return the decrypted word.
   */
  public static String vigenereDecrypt(String str, String key) {
    int lenStr = str.length();
    int lenKey = key.length();
    char[] strArr = new char[lenStr];
    strArr = str.toCharArray();
    char[] decrArr = new char[lenStr];
    char[] keyword = new char[lenStr];
    int decrInt;
    for (int i = 0; i < lenStr; i++) {
      keyword[i] = key.charAt(i % lenKey);
    } // for
    for (int i = 0; i < lenStr; i++) {
      decrInt = (letter2int(strArr[i]) - letter2int(keyword[i])) % ALPHABETLEN;
      if (decrInt < 0) {
        decrArr[i] = int2letter(ALPHABETLEN + decrInt);
      } else {
        decrArr[i] = int2letter(decrInt);
      } // if/else
    } // for
    return new String(decrArr);
  } // vigenereDecrypt(String, String)
} // class CipherUtils
