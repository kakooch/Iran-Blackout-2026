package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.d22, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11455d22 implements B52 {
    private final List a;
    private final InterfaceC4589Ft7[] b;
    private boolean c;
    private int d;
    private int e;
    private long f = -9223372036854775807L;

    public C11455d22(List list) {
        this.a = list;
        this.b = new InterfaceC4589Ft7[list.size()];
    }

    private boolean f(EW4 ew4, int i) {
        if (ew4.a() == 0) {
            return false;
        }
        if (ew4.F() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        if (this.c) {
            if (this.d != 2 || f(ew4, 32)) {
                if (this.d != 1 || f(ew4, 0)) {
                    int iF = ew4.f();
                    int iA = ew4.a();
                    for (InterfaceC4589Ft7 interfaceC4589Ft7 : this.b) {
                        ew4.S(iF);
                        interfaceC4589Ft7.d(ew4, iA);
                    }
                    this.e += iA;
                }
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.c = false;
        this.f = -9223372036854775807L;
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            InterfaceC22268uw7.a aVar = (InterfaceC22268uw7.a) this.a.get(i);
            dVar.a();
            InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 3);
            interfaceC4589Ft7B.c(new X.b().U(dVar.b()).g0("application/dvbsubs").V(Collections.singletonList(aVar.c)).X(aVar.a).G());
            this.b[i] = interfaceC4589Ft7B;
        }
    }

    @Override // ir.nasim.B52
    public void d() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (InterfaceC4589Ft7 interfaceC4589Ft7 : this.b) {
                    interfaceC4589Ft7.b(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }
}
