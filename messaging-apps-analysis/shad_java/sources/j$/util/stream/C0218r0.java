package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.r0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0218r0 extends CountedCompleter {
    private j$.util.t a;
    private final InterfaceC0192m3 b;
    private final AbstractC0256y2 c;
    private long d;

    C0218r0(C0218r0 c0218r0, j$.util.t tVar) {
        super(c0218r0);
        this.a = tVar;
        this.b = c0218r0.b;
        this.d = c0218r0.d;
        this.c = c0218r0.c;
    }

    C0218r0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, InterfaceC0192m3 interfaceC0192m3) {
        super(null);
        this.b = interfaceC0192m3;
        this.c = abstractC0256y2;
        this.a = tVar;
        this.d = 0L;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        j$.util.t tVarTrySplit;
        j$.util.t tVar = this.a;
        long jEstimateSize = tVar.estimateSize();
        long jH = this.d;
        if (jH == 0) {
            jH = AbstractC0146f.h(jEstimateSize);
            this.d = jH;
        }
        boolean zD = EnumC0145e4.SHORT_CIRCUIT.d(this.c.t0());
        boolean z = false;
        InterfaceC0192m3 interfaceC0192m3 = this.b;
        C0218r0 c0218r0 = this;
        while (true) {
            if (zD && interfaceC0192m3.p()) {
                break;
            }
            if (jEstimateSize <= jH || (tVarTrySplit = tVar.trySplit()) == null) {
                break;
            }
            C0218r0 c0218r02 = new C0218r0(c0218r0, tVarTrySplit);
            c0218r0.addToPendingCount(1);
            if (z) {
                tVar = tVarTrySplit;
            } else {
                C0218r0 c0218r03 = c0218r0;
                c0218r0 = c0218r02;
                c0218r02 = c0218r03;
            }
            z = !z;
            c0218r0.fork();
            c0218r0 = c0218r02;
            jEstimateSize = tVar.estimateSize();
        }
        c0218r0.c.o0(interfaceC0192m3, tVar);
        c0218r0.a = null;
        c0218r0.propagateCompletion();
    }
}
