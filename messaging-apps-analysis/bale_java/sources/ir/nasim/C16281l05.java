package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;

/* renamed from: ir.nasim.l05, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16281l05 implements InterfaceC19651qi6 {
    private com.google.android.exoplayer2.X a;
    private C5045Hq7 b;
    private InterfaceC4589Ft7 c;

    public C16281l05(String str) {
        this.a = new X.b().g0(str).G();
    }

    private void b() {
        AbstractC20011rK.i(this.b);
        AbstractC9683aN7.j(this.c);
    }

    @Override // ir.nasim.InterfaceC19651qi6
    public void a(EW4 ew4) {
        b();
        long jD = this.b.d();
        long jE = this.b.e();
        if (jD == -9223372036854775807L || jE == -9223372036854775807L) {
            return;
        }
        com.google.android.exoplayer2.X x = this.a;
        if (jE != x.p) {
            com.google.android.exoplayer2.X xG = x.c().k0(jE).G();
            this.a = xG;
            this.c.c(xG);
        }
        int iA = ew4.a();
        this.c.d(ew4, iA);
        this.c.b(jD, 1, iA, 0, null);
    }

    @Override // ir.nasim.InterfaceC19651qi6
    public void c(C5045Hq7 c5045Hq7, InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        this.b = c5045Hq7;
        dVar.a();
        InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 5);
        this.c = interfaceC4589Ft7B;
        interfaceC4589Ft7B.c(this.a);
    }
}
