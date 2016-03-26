/**
 * Copyright (c) 2013 Pieter Wuille
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.bitcoin;

/**
 * This class holds the context reference used in native methods 
   to handle ECDSA operations.
 */
public class Secp256k1Context {
  private static final boolean enabled; //true if the library is loaded
  private static final long context; //ref to pointer to context obj

  static { //static initializer
      boolean isEnabled = true;
      long contextRef = -1;
      try {
          System.loadLibrary("secp256k1");
          contextRef = secp256k1_init_context();
      } catch (UnsatisfiedLinkError e) {
          System.out.println("UnsatisfiedLinkError: " + e.toString());
          isEnabled = false;
      }
      enabled = isEnabled;
      context = contextRef;
  }

  public static boolean isEnabled() {
     return enabled;
  }

  public static long getContext() {
     if(!enabled) return -1; //sanity check
     return context;
  }

  private static native long secp256k1_init_context();
}
