package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import java.util.List;

/* renamed from: ir.nasim.Bl6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3580Bl6 {
    private final List a;
    private final InterfaceC4589Ft7[] b;

    public C3580Bl6(List list) {
        this.a = list;
        this.b = new InterfaceC4589Ft7[list.size()];
    }

    public void a(long j, EW4 ew4) {
        KH0.a(j, ew4, this.b);
    }

    public void b(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 3);
            com.google.android.exoplayer2.X x = (com.google.android.exoplayer2.X) this.a.get(i);
            String str = x.l;
            AbstractC20011rK.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String strB = x.a;
            if (strB == null) {
                strB = dVar.b();
            }
            interfaceC4589Ft7B.c(new X.b().U(strB).g0(str).i0(x.d).X(x.c).H(x.G).V(x.n).G());
            this.b[i] = interfaceC4589Ft7B;
        }
    }
}
