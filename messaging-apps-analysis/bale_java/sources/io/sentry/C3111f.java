package io.sentry;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* renamed from: io.sentry.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3111f extends AbstractCollection implements Queue, Serializable {
    private transient Object[] a;
    private transient int b = 0;
    private transient int c = 0;
    private transient boolean d = false;
    private final int e;

    /* renamed from: io.sentry.f$a */
    class a implements Iterator {
        private int a;
        private int b = -1;
        private boolean c;

        a() {
            this.a = C3111f.this.b;
            this.c = C3111f.this.d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c || this.a != C3111f.this.c;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c = false;
            int i = this.a;
            this.b = i;
            this.a = C3111f.this.O(i);
            return C3111f.this.a[this.b];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.b;
            if (i == -1) {
                throw new IllegalStateException();
            }
            if (i == C3111f.this.b) {
                C3111f.this.remove();
                this.b = -1;
                return;
            }
            int iO = this.b + 1;
            if (C3111f.this.b >= this.b || iO >= C3111f.this.c) {
                while (iO != C3111f.this.c) {
                    if (iO >= C3111f.this.e) {
                        C3111f.this.a[iO - 1] = C3111f.this.a[0];
                        iO = 0;
                    } else {
                        C3111f.this.a[C3111f.this.N(iO)] = C3111f.this.a[iO];
                        iO = C3111f.this.O(iO);
                    }
                }
            } else {
                System.arraycopy(C3111f.this.a, iO, C3111f.this.a, this.b, C3111f.this.c - iO);
            }
            this.b = -1;
            C3111f c3111f = C3111f.this;
            c3111f.c = c3111f.N(c3111f.c);
            C3111f.this.a[C3111f.this.c] = null;
            C3111f.this.d = false;
            this.a = C3111f.this.N(this.a);
        }
    }

    C3111f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        Object[] objArr = new Object[i];
        this.a = objArr;
        this.e = objArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int N(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.e - 1 : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(int i) {
        int i2 = i + 1;
        if (i2 >= this.e) {
            return 0;
        }
        return i2;
    }

    public boolean P() {
        return size() == this.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        if (P()) {
            remove();
        }
        Object[] objArr = this.a;
        int i = this.c;
        int i2 = i + 1;
        this.c = i2;
        objArr[i] = obj;
        if (i2 >= this.e) {
            this.c = 0;
        }
        if (this.c == this.b) {
            this.d = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.d = false;
        this.b = 0;
        this.c = 0;
        Arrays.fill(this.a, (Object) null);
    }

    @Override // java.util.Queue
    public Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        return add(obj);
    }

    @Override // java.util.Queue
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.a[this.b];
    }

    @Override // java.util.Queue
    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public Object remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Object[] objArr = this.a;
        int i = this.b;
        Object obj = objArr[i];
        if (obj != null) {
            int i2 = i + 1;
            this.b = i2;
            objArr[i] = null;
            if (i2 >= this.e) {
                this.b = 0;
            }
            this.d = false;
        }
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i = this.c;
        int i2 = this.b;
        if (i < i2) {
            return (this.e - i2) + i;
        }
        if (i == i2) {
            return this.d ? this.e : 0;
        }
        return i - i2;
    }
}
