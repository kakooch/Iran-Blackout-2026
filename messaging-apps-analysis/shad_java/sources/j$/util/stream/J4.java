package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class J4 extends K4 implements j$.util.t, Consumer {
    Object e;

    J4(j$.util.t tVar, long j, long j2) {
        super(tVar, j, j2);
    }

    J4(j$.util.t tVar, J4 j4) {
        super(tVar, j4);
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        consumer.getClass();
        while (r() != 1 && this.a.a(this)) {
            if (l(1L) == 1) {
                consumer.accept(this.e);
                this.e = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.e = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        C0187l4 c0187l4 = null;
        while (true) {
            int iR = r();
            if (iR == 1) {
                return;
            }
            if (iR != 2) {
                this.a.forEachRemaining(consumer);
                return;
            }
            if (c0187l4 == null) {
                c0187l4 = new C0187l4(128);
            } else {
                c0187l4.a = 0;
            }
            long j = 0;
            while (this.a.a(c0187l4)) {
                j++;
                if (j >= 128) {
                    break;
                }
            }
            if (j == 0) {
                return;
            }
            long jL = l(j);
            for (int i = 0; i < jL; i++) {
                consumer.accept(c0187l4.b[i]);
            }
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

    @Override // j$.util.stream.K4
    protected j$.util.t q(j$.util.t tVar) {
        return new J4(tVar, this);
    }
}
