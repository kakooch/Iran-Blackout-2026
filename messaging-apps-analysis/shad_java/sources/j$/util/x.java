package j$.util;

import j$.util.Iterator;
import j$.util.function.Consumer;
import j$.util.t;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
class x implements r, j$.util.function.q, Iterator {
    boolean a = false;
    long b;
    final /* synthetic */ t.c c;

    x(t.c cVar) {
        this.c = cVar;
    }

    @Override // j$.util.function.q
    public void accept(long j) {
        this.a = true;
        this.b = j;
    }

    @Override // j$.util.p
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void forEachRemaining(j$.util.function.q qVar) {
        qVar.getClass();
        while (hasNext()) {
            qVar.accept(nextLong());
        }
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }

    @Override // j$.util.r, j$.util.Iterator
    public void forEachRemaining(Consumer consumer) {
        if (consumer instanceof j$.util.function.q) {
            forEachRemaining((j$.util.function.q) consumer);
            return;
        }
        consumer.getClass();
        if (L.a) {
            L.a(x.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
            throw null;
        }
        forEachRemaining(new q(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        if (!this.a) {
            this.c.tryAdvance(this);
        }
        return this.a;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public Long next() {
        if (!L.a) {
            return Long.valueOf(nextLong());
        }
        L.a(x.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
        throw null;
    }

    @Override // j$.util.r
    public long nextLong() {
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
