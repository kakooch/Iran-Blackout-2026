package j$.util.stream;

import j$.util.stream.B1;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.s1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0175s1 extends B1.k<Double> {
    final /* synthetic */ j$.G l;

    /* renamed from: j$.util.stream.s1$a */
    class a extends C2.a<Integer> {
        a(C2 c2) {
            super(c2);
        }

        @Override // j$.util.stream.C2.e, j$.util.stream.C2
        public void accept(double d) {
            this.a.accept(C0175s1.this.l.a(d));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0175s1(AbstractC0171r1 abstractC0171r1, AbstractC0148l1 abstractC0148l1, W2 w2, int i, j$.G g) {
        super(abstractC0148l1, w2, i);
        this.l = g;
    }

    @Override // j$.util.stream.AbstractC0148l1
    C2 F0(int i, C2 c2) {
        return new a(c2);
    }
}
