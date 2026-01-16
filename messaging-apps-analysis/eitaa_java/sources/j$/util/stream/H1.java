package j$.util.stream;

import j$.C0075l0;
import j$.util.stream.AbstractC0171r1;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
class H1 extends AbstractC0171r1.i<Long> {
    final /* synthetic */ C0075l0 l;

    class a extends C2.c<Double> {
        a(C2 c2) {
            super(c2);
        }

        @Override // j$.util.stream.C2.g, j$.util.stream.C2
        public void accept(long j) {
            this.a.accept(H1.this.l.a(j));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    H1(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, C0075l0 c0075l0) {
        super(abstractC0148l1, w2, i);
        this.l = c0075l0;
    }

    @Override // j$.util.stream.AbstractC0148l1
    C2 F0(int i, C2 c2) {
        return new a(c2);
    }
}
