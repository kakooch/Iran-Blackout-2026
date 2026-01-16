package j$.util.stream;

import j$.util.stream.AbstractC0171r1;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
class C1 extends AbstractC0171r1.i<Integer> {
    final /* synthetic */ j$.X l;

    class a extends C2.b<Double> {
        a(C2 c2) {
            super(c2);
        }

        @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
        public void accept(int i) {
            this.a.accept(C1.this.l.a(i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1(B1 b1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.X x) {
        super(abstractC0148l1, w2, i);
        this.l = x;
    }

    @Override // j$.util.stream.AbstractC0148l1
    C2 F0(int i, C2 c2) {
        return new a(c2);
    }
}
