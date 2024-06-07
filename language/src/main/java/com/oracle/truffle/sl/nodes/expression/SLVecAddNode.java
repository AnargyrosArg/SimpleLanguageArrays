/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.sl.SLException;
import com.oracle.truffle.sl.nodes.SLBinaryNode;
import com.oracle.truffle.sl.runtime.SLBigIntegerArray;
import com.oracle.truffle.sl.runtime.SLIntegerArray;
import com.oracle.truffle.sl.runtime.SLLongArray;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * This class is similar to the extensively documented {@link SLAddNode}.
 */

@NodeInfo(shortName = "vec_add")
public abstract class SLVecAddNode extends SLBinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected SLIntegerArray doSLIntegerArray(SLIntegerArray left,SLIntegerArray right) {
//        System.out.println("Entering Integer Specialization");
        if(left.size()!=right.size()) {
            System.out.println("Arrays not of same size!");
            System.exit(1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < left.size(); i++){
            result.add(Math.addExact(left.get(i), right.get(i)));
        }
//        System.out.println("Integer Specialization!\n");
        return new SLIntegerArray(result);
    }

    @Specialization(rewriteOn = ArithmeticException.class, replaces = "doSLIntegerArray")
    @TruffleBoundary
    protected SLLongArray doSLLongArray(SLLongArray left, SLLongArray right) {
//        System.out.println("Entering Long Specialization");
        if(left.size()!=right.size()) {
            System.out.println("Arrays not of same size!");
            System.exit(1);
        }
        ArrayList<Long> result = new ArrayList<>();
        for(int i = 0; i < left.size(); i++){
            result.add(Math.addExact(left.get(i), right.get(i)));
        }
//        System.out.println("Long Specialization!\n");
        return new SLLongArray(result);
    }


    @Specialization(rewriteOn = ArithmeticException.class,replaces = "doSLLongArray")
//    @Specialization(rewriteOn = ArithmeticException.class)
    @TruffleBoundary
    protected SLBigIntegerArray doSLBigIntegerArray(SLBigIntegerArray left, SLBigIntegerArray right) {
//        System.out.println("Entering BigInteger Specialization");
        if(left.size()!=right.size()) {
            System.out.println("Arrays not of same size!");
            System.exit(1);
        }
        ArrayList<BigInteger> result = new ArrayList<>();
        for(int i = 0; i < left.size(); i++){
            result.add(left.get(i).add(right.get(i)));
        }
//        System.out.println("Big Integer Specialization!\n");
        return new SLBigIntegerArray(result);
    }

    @Fallback
    protected Object typeError(Object left, Object right) {
        System.out.println("Entered fallback");
        System.out.println(left.getClass()+" "+right.getClass());
        throw SLException.typeError(this, left, right);
    }

    protected boolean areBigIntegers(Object a, Object b) {
        return a instanceof BigInteger || b instanceof BigInteger;
    }
    protected boolean isCudaEnabled() {
        return cudaEnabled;
    }
    final boolean cudaEnabled = true;

//    @Specialization(guards = "isCudaEnabled()")
//    protected SLIntegerArray doSLIntegerArrayCUDA (SLIntegerArray left, SLIntegerArray right){
//        System.out.println("USING CUDA FOR VEC_ADD!");
//        if(left.size()!=right.size()) {
//            System.out.println("Arrays not of same size!");
//            System.exit(1);
//        }
//        //Initialize cublas context
//        JCublas.initialize();
//
//        //convert arraylists to int arrays
//        int[] vec1 = left.getValues().stream().mapToInt(i -> i).toArray();
//        int[] vec2 = right.getValues().stream().mapToInt(i -> i).toArray();
//
//        //Prepare pointers for vectors
//        Pointer p_vec1 = new Pointer();
//        Pointer p_vec2 = new Pointer();
//
//        //Allocate device memory at those pointers
//        JCublas.cublasAlloc(left.size(), Sizeof.INT, p_vec1);
//        JCublas.cublasAlloc(left.size(), Sizeof.INT, p_vec2);
//
//        //Copy vectors from host -> device memory
//        JCublas.cublasSetVector(left.size(), Sizeof.INT,Pointer.to(vec1),1,p_vec1,1);
//        JCublas.cublasSetVector(right.size(),Sizeof.INT,Pointer.to(vec2),1,p_vec2,1);
//
//        //Perform addition operation
//        JCublas.cublasSaxpy(left.size(), Sizeof.INT,p_vec1,1,p_vec2,1);
//
//        //Get result vector from device
//        JCublas.cublasGetVector(left.size(),Sizeof.INT,p_vec1,1,Pointer.to(vec1),1);
//
//        ArrayList<Integer> result = new ArrayList<>();
//        Collections.addAll(result, Arrays.stream(vec1).boxed().toArray(Integer[]::new));
//        return new SLIntegerArray(result);
//    }
}
