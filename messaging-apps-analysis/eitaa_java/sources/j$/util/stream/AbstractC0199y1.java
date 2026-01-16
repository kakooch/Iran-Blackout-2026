package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.y1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0199y1<T> implements i3<T, Void>, j3<T, Void> {
    private final boolean a;

    /* renamed from: j$.util.stream.y1$a */
    static final class a extends AbstractC0199y1<Double> implements C2.e {
        final j$.util.function.s b;

        a(j$.util.function.s sVar, boolean z) {
            super(z);
            this.b = sVar;
        }

        @Override // j$.util.stream.AbstractC0199y1, j$.util.stream.C2
        public void accept(double d) {
            this.b.accept(d);
        }

        @Override // j$.util.function.Consumer
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Double d) {
            S1.a(this, d);
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }
    }

    /* renamed from: j$.util.stream.y1$b */
    static final class b extends AbstractC0199y1<Integer> implements C2.f {
        final j$.util.function.y b;

        b(j$.util.function.y yVar, boolean z) {
            super(z);
            this.b = yVar;
        }

        @Override // j$.util.stream.AbstractC0199y1, j$.util.stream.C2, j$.util.function.y
        public void accept(int i) {
            this.b.accept(i);
        }

        @Override // j$.util.function.Consumer
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Integer num) {
            S1.b(this, num);
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }
    }

    /* renamed from: j$.util.stream.y1$c */
    static final class c extends AbstractC0199y1<Long> implements C2.g {
        final j$.util.function.E b;

        c(j$.util.function.E e, boolean z) {
            super(z);
            this.b = e;
        }

        @Override // j$.util.stream.AbstractC0199y1, j$.util.stream.C2
        public void accept(long j) {
            this.b.accept(j);
        }

        @Override // j$.util.function.Consumer
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void accept(Long l) {
            S1.c(this, l);
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e) {
            e.getClass();
            return new C0099j(this, e);
        }
    }

    /* renamed from: j$.util.stream.y1$d */
    static final class d<T> extends AbstractC0199y1<T> {
        final Consumer b;

        d(Consumer consumer, boolean z) {
            super(z);
            this.b = consumer;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            this.b.accept(obj);
        }
    }

    protected AbstractC0199y1(boolean z) {
        this.a = z;
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
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.i3
    public int b() {
        if (this.a) {
            return 0;
        }
        return V2.m;
    }

    @Override // j$.util.stream.i3
    public Object c(V1 v1, Spliterator spliterator) {
        (this.a ? new C0203z1(v1, spliterator, this) : new A1(v1, spliterator, v1.t0(this))).invoke();
        return null;
    }

    @Override // j$.util.stream.i3
    public Object d(V1 v1, Spliterator spliterator) {
        AbstractC0148l1 abstractC0148l1 = (AbstractC0148l1) v1;
        abstractC0148l1.l0(abstractC0148l1.t0(this), spliterator);
        return null;
    }

    @Override // j$.util.function.L
    public /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
