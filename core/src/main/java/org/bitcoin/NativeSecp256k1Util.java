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

public class NativeSecp256k1Util{

    public static void assertEquals( int val, int val2, String message ) throws AssertFailException{
      if( val != val2 )
        throw new AssertFailException("FAIL: " + message);
    }

    public static void assertEquals( boolean val, boolean val2, String message ) throws AssertFailException{
      if( val != val2 )
        throw new AssertFailException("FAIL: " + message);
      else
        System.out.println("PASS: " + message);
    }

    public static void assertEquals( String val, String val2, String message ) throws AssertFailException{
      if( !val.equals(val2) )
        throw new AssertFailException("FAIL: " + message);
      else
        System.out.println("PASS: " + message);
    }

    public static class AssertFailException extends Exception {
      public AssertFailException(String message) {
        super( message );
      }
    }
}
