/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.util;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Mutable, ordered, fixed sized sequence.
 *
 * @see ISeq
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 1.2 &mdash; <em>$Date$</em>
 */
public interface MSeq<T> extends Seq<T>, Copyable<MSeq<T>> {

	/**
	 * Set the {@code value} at the given {@code index}.
	 *
	 * @param index the index of the new value.
	 * @param value the new value.
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         {@code (index < 0 || index >= size())}.
	 */
	public void set(final int index, final T value);

	/**
	 * Set all sequence elements to the given {@code value}.
	 *
	 * @param value {@code value} to fill this sequence with.
	 * @return {@code this} array.
	 */
	public MSeq<T> setAll(final T value);

	/**
	 * Fills the sequence with values of the given iterator.
	 *
	 * @param it the iterator of the values to fill this sequence.
	 * @return {@code this} sequence.
	 */
	public MSeq<T> setAll(final Iterator<? extends T> it);

	/**
	 * Fills the sequence with values of the given iterable.
	 *
	 * @param values the values to fill this sequence.
	 * @return {@code this} sequence.
	 */
	public MSeq<T> setAll(final Iterable<? extends T> values);

	/**
	 * Fill the sequence with the given values.
	 *
	 * @param values the first initial values of this sequence
	 * @return {@code this} sequence.
	 */
	public MSeq<T> setAll(final T[] values);

	/**
	 * Fill the sequence with values generated by the given factory.
	 *
	 * @param factory the value factory.
	 * @return {@code this} sequence.
	 * @throws NullPointerException if the given {@code factory} is {@code null}.
	 */
	public MSeq<T> fill(final Factory<? extends T> factory);

	/**
	 * Swap the elements at the two positions.
	 *
	 * @param i the index of the first element.
	 * @param j the index of the second element.
	 * @throws IndexOutOfBoundsException if {@code i < 0 || j >= length()}.
	 */
	public void swap(final int i, final int j);

	/**
	 * Swap a given range with a range of the same size with another array.
	 *
	 * <pre>
	 *            start                end
	 *              |                   |
	 * this:  +---+---+---+---+---+---+---+---+---+---+---+---+
	 *              +---------------+
	 *                          +---------------+
	 * other: +---+---+---+---+---+---+---+---+---+---+---+---+
	 *                          |
	 *                      otherStart
	 * </pre>
	 *
	 * @param start the start index of {@code this} range, inclusively.
	 * @param end the end index of {@code this} range, exclusively.
	 * @param other the other array to swap the elements with.
	 * @param otherStart the start index of the {@code other} array.
	 * @throws IndexOutOfBoundsException if {@code start > end}.
	 * @throws IndexOutOfBoundsException if {@code start < 0 ||
	 *         end >= this.length() || otherStart < 0 ||
	 *         otherStart + (end - start) >= other.length()}
	 */
	public void swap(
		final int start, final int end,
		final MSeq<T> other, final int otherStart
	);

	/**
	 * Returns a list iterator over the elements in this sequence (in proper
	 * sequence).
	 *
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence)
	 */
	public ListIterator<T> listIterator();

	@Override
	public MSeq<T> subSeq(final int start, final int end);

	@Override
	public MSeq<T> subSeq(final int start);

	@Override
	public <B> MSeq<B> map(final Function<? super T, ? extends B> mapper);

	/**
	 * Return a read-only projection of this sequence. Changes to the original
	 * sequence will not influence the returned {@code ISeq}.
	 *
	 * @return a read-only projection of this sequence
	 */
	public ISeq<T> toISeq();


}




