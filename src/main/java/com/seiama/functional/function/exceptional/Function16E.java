/*
 * This file is part of functional, licensed under the MIT License.
 *
 * Copyright (c) 2021-2023 Seiama
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.seiama.functional.function.exceptional;

/**
 * A function that accepts sixteen arguments and produces a result, potentially throwing an exception.
 *
 * @param <T1> the 1st argument type
 * @param <T2> the 2nd argument type
 * @param <T3> the 3rd argument type
 * @param <T4> the 4th argument type
 * @param <T5> the 5th argument type
 * @param <T6> the 6th argument type
 * @param <T7> the 7th argument type
 * @param <T8> the 8th argument type
 * @param <T9> the 9th argument type
 * @param <T10> the 10th argument type
 * @param <T11> the 11th argument type
 * @param <T12> the 12th argument type
 * @param <T13> the 13th argument type
 * @param <T14> the 14th argument type
 * @param <T15> the 15th argument type
 * @param <T16> the 16th argument type
 * @param <R> the result type
 * @param <E> the exception type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function16E<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R, E extends Throwable> {
  /**
   * Applies this function to the given arguments.
   *
   * @param t1 the 1st argument
   * @param t2 the 2nd argument
   * @param t3 the 3rd argument
   * @param t4 the 4th argument
   * @param t5 the 5th argument
   * @param t6 the 6th argument
   * @param t7 the 7th argument
   * @param t8 the 8th argument
   * @param t9 the 9th argument
   * @param t10 the 10th argument
   * @param t11 the 11th argument
   * @param t12 the 12th argument
   * @param t13 the 13th argument
   * @param t14 the 14th argument
   * @param t15 the 15th argument
   * @param t16 the 16th argument
   * @return the result
   * @throws E if an exception was encountered
   * @since 1.0.0
   */
  R apply(
    final T1 t1,
    final T2 t2,
    final T3 t3,
    final T4 t4,
    final T5 t5,
    final T6 t6,
    final T7 t7,
    final T8 t8,
    final T9 t9,
    final T10 t10,
    final T11 t11,
    final T12 t12,
    final T13 t13,
    final T14 t14,
    final T15 t15,
    final T16 t16
  ) throws E;
}
