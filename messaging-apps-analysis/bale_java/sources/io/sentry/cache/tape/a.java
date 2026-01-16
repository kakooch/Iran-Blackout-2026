package io.sentry.cache.tape;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class a extends c {

    private static final class b implements Iterator {
        private b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException("No elements in EmptyIterator!");
        }
    }

    a() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.sentry.cache.tape.c
    public void f0(int i) {
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new b();
    }

    @Override // io.sentry.cache.tape.c
    public void j(Object obj) {
    }

    @Override // io.sentry.cache.tape.c
    public int size() {
        return 0;
    }
}
