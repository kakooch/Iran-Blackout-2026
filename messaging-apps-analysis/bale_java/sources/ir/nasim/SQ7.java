package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class SQ7 extends UQ7 implements Iterable, InterfaceC17915nm3 {
    private final String a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final List i;
    private final List j;

    public static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;

        a(SQ7 sq7) {
            this.a = sq7.j.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UQ7 next() {
            return (UQ7) this.a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public SQ7(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, List list2) {
        super(null);
        this.a = str;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
        this.g = f6;
        this.h = f7;
        this.i = list;
        this.j = list2;
    }

    public final float A() {
        return this.f;
    }

    public final int B() {
        return this.j.size();
    }

    public final float C() {
        return this.g;
    }

    public final float E() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof SQ7)) {
            SQ7 sq7 = (SQ7) obj;
            return AbstractC13042fc3.d(this.a, sq7.a) && this.b == sq7.b && this.c == sq7.c && this.d == sq7.d && this.e == sq7.e && this.f == sq7.f && this.g == sq7.g && this.h == sq7.h && AbstractC13042fc3.d(this.i, sq7.i) && AbstractC13042fc3.d(this.j, sq7.j);
        }
        return false;
    }

    public final UQ7 h(int i) {
        return (UQ7) this.j.get(i);
    }

    public int hashCode() {
        return (((((((((((((((((this.a.hashCode() * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    }

    public final List i() {
        return this.i;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a(this);
    }

    public final String j() {
        return this.a;
    }

    public final float o() {
        return this.c;
    }

    public final float t() {
        return this.d;
    }

    public final float v() {
        return this.b;
    }

    public final float x() {
        return this.e;
    }
}
