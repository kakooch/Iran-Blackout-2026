package j$.util.stream;

import j$.C0079n0;
import j$.util.stream.B1;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
class G1 extends B1.k<Long> {
    final /* synthetic */ C0079n0 l;

    class a extends C2.c<Integer> {
        a(C2 c2) {
            super(c2);
        }

        @Override // j$.util.stream.C2.g, j$.util.stream.C2
        public void accept(long j) {
            this.a.accept(G1.this.l.a(j));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    G1(F1 f1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, C0079n0 c0079n0) {
        super(abstractC0148l1, w2, i);
        this.l = c0079n0;
    }

    @Override // j$.util.stream.AbstractC0148l1
    C2 F0(int i, C2 c2) {
        return new a(c2);
    }
}
