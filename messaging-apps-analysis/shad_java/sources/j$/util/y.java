package j$.util;

import j$.util.Iterator;
import j$.util.function.Consumer;
import j$.util.t;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
class y implements n, j$.util.function.f, Iterator {
    boolean a = false;
    double b;
    final /* synthetic */ t.a c;

    y(t.a aVar) {
        this.c = aVar;
    }

    @Override // j$.util.function.f
    public void accept(double d) {
        this.a = true;
        this.b = d;
    }

    @Override // j$.util.p
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void forEachRemaining(j$.util.function.f fVar) {
        fVar.getClass();
        while (hasNext()) {
            fVar.accept(nextDouble());
        }
    }

    @Override // j$.util.n, j$.util.Iterator
    public void forEachRemaining(Consumer consumer) {
        if (consumer instanceof j$.util.function.f) {
            forEachRemaining((j$.util.function.f) consumer);
            return;
        }
        consumer.getClass();
        if (L.a) {
            L.a(y.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
            throw null;
        }
        forEachRemaining(new m(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        if (!this.a) {
            this.c.tryAdvance(this);
        }
        return this.a;
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public Double next() {
        if (!L.a) {
            return Double.valueOf(nextDouble());
        }
        L.a(y.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
        throw null;
    }

    @Override // j$.util.n
    public double nextDouble() {
        if (!this.a && !hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = false;
        return this.b;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public /* synthetic */ void remove() {
        Iterator.CC.a(this);
        throw null;
    }
}
