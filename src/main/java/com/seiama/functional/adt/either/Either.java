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

import static java.util.Objects.requireNonNull;

/**
 * Either.
 *
 * @param <L> the type of the left value
 * @param <R> the type of the right value
 * @since 1.0.0
 */
public sealed interface Either<L, R> permits Left, Right {
  /**
   * Creates a new either with a left value.
   *
   * @param value the left value
   * @param <L> the type of the left value
   * @param <R> the type of the right value
   * @return a new either
   * @since 1.0.0
   */
  static <L, R> @NotNull Either<L, R> left(final @NotNull L value) {
    return new Left<>(requireNonNull(value));
  }

  /**
   * Creates a new either with a right value.
   *
   * @param value the right value
   * @param <L> the type of the left value
   * @param <R> the type of the right value
   * @return a new either
   * @since 1.0.0
   */
  static <L, R> @NotNull Either<L, R> right(final @NotNull R value) {
    return new Right<>(requireNonNull(value));
  }

  /**
   * Gets the left value.
   *
   * @return the left value
   * @since 1.0.0
   */
  @NotNull Optional<L> left();

  /**
   * Gets the right value.
   *
   * @return the right value
   * @since 1.0.0
   */
  @NotNull Optional<R> right();

  /**
   * Runs an action against the left value, if present.
   *
   * @param consumer the action to run if the left value is present
   * @return this either
   * @since 1.0.0
   */
  @NotNull Either<L, R> ifLeft(final @NotNull Consumer<? super L> consumer);

  /**
   * Runs an action against the right value, if present.
   *
   * @param consumer the action to run if the right value is present
   * @return this either
   * @since 1.0.0
   */
  @NotNull Either<L, R> ifRight(final @NotNull Consumer<? super R> consumer);

  /**
   * Applies {@code fn} to the left value, returning a new either with the returned value.
   *
   * @param fn the function to apply to the left value
   * @param <T> the type of the new left value
   * @return a new either
   * @since 1.0.0
   */
  default <T> @NotNull Either<T, R> mapLeft(final @NotNull Function<? super L, ? extends T> fn) {
    return this.map(fn, Function.identity());
  }

  /**
   * Applies {@code fn} to the right value, returning a new either with the returned value.
   *
   * @param fn the function to apply to the right value
   * @param <T> the type of the new right value
   * @return a new either
   * @since 1.0.0
   */
  default <T> @NotNull Either<L, T> mapRight(final @NotNull Function<? super R, ? extends T> fn) {
    return this.map(Function.identity(), fn);
  }

  /**
   * Applies {@code left} to the left value or {@code right} to the right value, returning a new either with the returned value.
   *
   * @param left the function to apply to the left value
   * @param right the function to apply to the right value
   * @param <C> the type of the new left value
   * @param <D> the type of the new right value
   * @return a new either
   * @since 1.0.0
   */
  <C, D> @NotNull Either<C, D> map(final @NotNull Function<? super L, ? extends C> left, final @NotNull Function<? super R, ? extends D> right);

  /**
   * Applies {@code ifLeft} to the left value or {@code ifRight} to the right value, returning the value.
   *
   * @param ifLeft the function to apply to the left value
   * @param ifRight the function to apply to the right value
   * @param <V> the type of the value
   * @return a value
   * @since 1.0.0
   */
  <V> @UnknownNullability V fold(final @NotNull Function<? super L, ? extends V> ifLeft, final @NotNull Function<? super R, ? extends V> ifRight);

  /**
   * Swaps the order of this either.
   *
   * @return a new either
   * @since 1.0.0
   */
  @NotNull Either<R, L> swap();
}
