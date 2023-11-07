package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private final List<T> elements;
    private Predicate<T> filter;


    public IterableWithPolicyImpl(final T[] elements) {
        this(
            elements,
            new Predicate<T>() {
                @Override
                public final boolean test(final T elem) {
                    return true;
                }
            }
        );
    }
    public IterableWithPolicyImpl(final T[] elements, final Predicate<T> filter) {
        this.elements = List.of(elements);
        this.filter = filter;
    };

    private class MyIterator implements Iterator<T>{
        
        int i = 0;

        @Override
        public boolean hasNext() {
            for(; i < elements.size() && !filter.test(elements.get(i)); i++);
            return i < elements.size();
        }

        @Override
        public T next() {
            if(hasNext()){
                T element = elements.get(i);
                i++;
                return element;
            }
            throw new NoSuchElementException();
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public void setIterationPolicy(final Predicate<T> filter) {
        this.filter = filter;
    }
}