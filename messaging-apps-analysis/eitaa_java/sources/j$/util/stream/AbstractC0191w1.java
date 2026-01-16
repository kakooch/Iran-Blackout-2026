package j$.util.stream;

import j$.util.Optional;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.w1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0191w1<T, O> implements j3<T, O> {
    boolean a;
    Object b;

    /* renamed from: j$.util.stream.w1$a */
    static final class a extends AbstractC0191w1<Double, j$.util.o> implements C2.e {
        a() {
        }

        @Override // j$.util.stream.AbstractC0191w1, j$.util.stream.C2
        public void accept(double d) {
            accept(Double.valueOf(d));
        }

        @Override // j$.util.function.L
        public Object get() {
            if (this.a) {
                return j$.util.o.d(((Double) this.b).doubleValue());
            }
            return null;
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }
    }

    /* renamed from: j$.util.stream.w1$b */
    static final class b extends AbstractC0191w1<Integer, j$.util.p> implements C2.f {
        b() {
        }

        @Override // j$.util.stream.AbstractC0191w1, j$.util.stream.C2, j$.util.function.y
        public void accept(int i) {
            accept(Integer.valueOf(i));
        }

        @Override // j$.util.function.L
        public Object get() {
            if (this.a) {
                return j$.util.p.d(((Integer) this.b).intValue());
            }
            return null;
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }
    }

    /* renamed from: j$.util.stream.w1$c */
    static final class c extends AbstractC0191w1<Long, j$.util.q> implements C2.g {
        c() {
        }

        @Override // j$.util.stream.AbstractC0191w1, j$.util.stream.C2
        public void accept(long j) {
            accept(Long.valueOf(j));
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e) {
            e.getClass();
            return new C0099j(this, e);
        }

        @Override // j$.util.function.L
        public Object get() {
            if (this.a) {
                return j$.util.q.d(((Long) this.b).longValue());
            }
            return null;
        }
    }

    /* renamed from: j$.util.stream.w1$d */
    static final class d<T> extends AbstractC0191w1<T, Optional<T>> {
        d() {
        }

        @Override // j$.util.function.L
        public Object get() {
            if (this.a) {
                return Optional.of(this.b);
            }
            return null;
        }
    }

    AbstractC0191w1() {
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(double d2) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public /* synthetic */ void accept(int i) {
        j$.time.a.a(this);
        throw null;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(long j) {
        j$.time.a.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (this.a) {
            return;
        }
        this.a = true;
        this.b = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
    }

    @Override // j$.util.stream.C2
    public boolean o() {
        return this.a;
    }
}
