package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class D4 extends E4 implements j$.util.t {
    D4(j$.util.t tVar, long j, long j2) {
        super(tVar, j, j2, 0L, Math.min(tVar.estimateSize(), j2));
    }

    private D4(j$.util.t tVar, long j, long j2, long j3, long j4) {
        super(tVar, j, j2, j3, j4);
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        long j;
        consumer.getClass();
        if (this.a >= this.e) {
            return false;
        }
        while (true) {
            long j2 = this.a;
            j = this.d;
            if (j2 <= j) {
                break;
            }
            this.c.a(new Consumer() { // from class: j$.util.stream.C4
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer2) {
                    return Consumer.CC.$default$andThen(this, consumer2);
                }
            });
            this.d++;
        }
        if (j >= this.e) {
            return false;
        }
        this.d = j + 1;
        return this.c.a(consumer);
    }

    @Override // j$.util.stream.E4
    protected j$.util.t b(j$.util.t tVar, long j, long j2, long j3, long j4) {
        return new D4(tVar, j, j2, j3, j4);
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        long j = this.a;
        long j2 = this.e;
        if (j >= j2) {
            return;
        }
        long j3 = this.d;
        if (j3 >= j2) {
            return;
        }
        if (j3 >= j && this.c.estimateSize() + j3 <= this.b) {
            this.c.forEachRemaining(consumer);
            this.d = this.e;
            return;
        }
        while (this.a > this.d) {
            this.c.a(new Consumer() { // from class: j$.util.stream.B4
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer2) {
                    return Consumer.CC.$default$andThen(this, consumer2);
                }
            });
            this.d++;
        }
        while (this.d < this.e) {
            this.c.a(consumer);
            this.d++;
        }
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0102a.e(this);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }
}
