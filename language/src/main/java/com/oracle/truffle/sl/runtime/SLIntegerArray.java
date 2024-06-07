/*
 * Copyright (c) 2017, 2023, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.sl.runtime;


import java.util.ArrayList;


import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;


@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("static-method")
public final class SLIntegerArray implements TruffleObject{

    private final ArrayList<Integer> values;

    public SLIntegerArray(ArrayList<Integer> values) {
        this.values = values;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    public int size(){
        return this.values.size();
    }

    public Integer get(int index){
        return this.values.get(index);
    }

    @Override
    public int hashCode() {
        return values.hashCode();
    }


    boolean valuesFitInLong() {
        return true;
    }

    public SLIntegerArray() {
        this.values = new ArrayList<Integer>();
        for(int i=0; i< 1000; i++){
            this.values.add(i);
        }
    }

    public SLIntegerArray(String token) {
        final int n_iter = 1000;
        this.values = new ArrayList<Integer>();

        switch(token) {
            case "BIG_ZERO_ARRAY":
                for(int i=0; i< n_iter; i++){
                    this.values.add(Integer.valueOf(0));
                }
                break;

            case "BIG_ONES_ARRAY":
                for(int i=0; i< n_iter; i++){
                    this.values.add(Integer.valueOf(1));
                }
                break;

            default:
                for(int i=0; i< n_iter; i++){
                    this.values.add(Integer.valueOf(i));
                }
        }

    }

    boolean valuesFitInInt() {
        for(Integer val : values){
            if( val > Integer.MAX_VALUE){
                return false;
            }
        }
        return true;
    }

    @ExportMessage
    @TruffleBoundary
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        String result = "[";
        for(Integer val : this.values){
            result = result.concat(val.toString() + ", ");
        }
        result = result.concat("]");
        return result;
    }

    @Override
    @TruffleBoundary
    public String toString(){
        String result = "[";
        for(Integer val : this.values){
            result = result.concat(val.toString() + ", ");
        }
        result = result.concat("]");
        return result;
    }
}
