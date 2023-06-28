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
package com.seiama.functional.adt.either;

import com.seiama.functional.Unit;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EitherTest {
  private final Either<String, Unit> left = Either.left("abc");
  private final Either<Unit, String> right = Either.right("def");

  @SuppressWarnings("DataFlowIssue") // null is intentional for testing
  @Test
  void testCreateFromNull() {
    assertThrows(NullPointerException.class, () -> Either.left(null));
    assertThrows(NullPointerException.class, () -> Either.right(null));
  }

  @Test
  void testLeft() {
    assertEquals(Optional.of("abc"), this.left.left());
    assertEquals(Optional.empty(), this.left.right());
  }

  @Test
  void testRight() {
    assertEquals(Optional.empty(), this.right.left());
    assertEquals(Optional.of("def"), this.right.right());
  }

  @Test
  void testIfLeft() {
    final AtomicBoolean leftIfLeft = new AtomicBoolean();
    final AtomicBoolean rightIfLeft = new AtomicBoolean();

    assertSame(this.left, this.left.ifLeft(t -> leftIfLeft.setPlain(true)));
    assertSame(this.right, this.right.ifLeft(t -> rightIfLeft.setPlain(true)));

    assertTrue(leftIfLeft.getPlain());
    assertFalse(rightIfLeft.getPlain());
  }

  @Test
  void testIfRight() {
    final AtomicBoolean leftIfRight = new AtomicBoolean();
    final AtomicBoolean rightIfRight = new AtomicBoolean();

    assertSame(this.left, this.left.ifRight(t -> leftIfRight.setPlain(true)));
    assertSame(this.right, this.right.ifRight(t -> rightIfRight.setPlain(true)));

    assertFalse(leftIfRight.getPlain());
    assertTrue(rightIfRight.getPlain());
  }

  @Test
  void testMapLeft() {
    assertEquals(Either.left("ABC"), this.left.mapLeft(String::toUpperCase));
  }

  @Test
  void testMapRight() {
    assertEquals(Either.right("DEF"), this.right.mapRight(String::toUpperCase));
  }

  @Test
  void testFold() {
    assertEquals(true, this.left.fold(t -> true, t -> false));
    assertEquals(true, this.right.fold(t -> false, t -> true));
  }

  @Test
  void testSwap() {
    assertEquals(Either.right("abc"), this.left.swap());
    assertEquals(Either.left("def"), this.right.swap());
  }
}
