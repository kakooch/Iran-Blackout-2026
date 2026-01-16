package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import java.util.List;

/* renamed from: ir.nasim.xI7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C23663xI7 {
    private final List a;
    private final InterfaceC4589Ft7[] b;

    public C23663xI7(List list) {
        this.a = list;
        this.b = new InterfaceC4589Ft7[list.size()];
    }

    public void a(long j, EW4 ew4) {
        if (ew4.a() < 9) {
            return;
        }
        int iO = ew4.o();
        int iO2 = ew4.o();
        int iF = ew4.F();
        if (iO == 434 && iO2 == 1195456820 && iF == 3) {
            KH0.b(j, ew4, this.b);
        }
    }

    public void b(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 3);
            com.google.android.exoplayer2.X x = (com.google.android.exoplayer2.X) this.a.get(i);
            String str = x.l;
            AbstractC20011rK.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            interfaceC4589Ft7B.c(new X.b().U(dVar.b()).g0(str).i0(x.d).X(x.c).H(x.G).V(x.n).G());
            this.b[i] = interfaceC4589Ft7B;
        }
    }
}
