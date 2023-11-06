package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private final T[] elements;
    private Predicate<T> filter;


    public IterableWithPolicyImpl(T[] elements) {
        this(
            elements,
            new Predicate<T>() {
                @Override
                public boolean test(T elem) {
                    return true;
                }
            }
        );
    }
    public IterableWithPolicyImpl(T[] elements, Predicate<T> filter) {
        this.elements = elements;
        this.filter = filter;
    };
    

    


    private class MyIterator implements Iterator<T>{
        
        int i = 0;

        @Override
        public boolean hasNext() {
            if (i < elements.length){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if(hasNext()){
                T element = elements[i];
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
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }

    

}