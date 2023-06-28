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

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

record Left<L, R>(L value) implements Either<L, R> {
  @Override
  public @NotNull Optional<L> left() {
    return Optional.of(this.value);
  }

  @Override
  public @NotNull Optional<R> right() {
    return Optional.empty();
  }

  @Override
  public @NotNull Either<L, R> ifLeft(final @NotNull Consumer<? super L> consumer) {
    consumer.accept(this.value);
    return this;
  }

  @Override
  public @NotNull Either<L, R> ifRight(final @NotNull Consumer<? super R> consumer) {
    return this;
  }

  @Override
  public <C, D> @NotNull Either<C, D> map(final @NotNull Function<? super L, ? extends C> left, final @NotNull Function<? super R, ? extends D> right) {
    return Either.left(left.apply(this.value));
  }

  @Override
  public <V> @UnknownNullability V fold(final @NotNull Function<? super L, ? extends V> ifLeft, final @NotNull Function<? super R, ? extends V> ifRight) {
    return ifLeft.apply(this.value);
  }

  @Override
  public @NotNull Either<R, L> swap() {
    return Either.right(this.value);
  }
}
