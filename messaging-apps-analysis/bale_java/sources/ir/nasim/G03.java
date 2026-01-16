package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;

/* loaded from: classes2.dex */
public final class G03 implements B52 {
    private InterfaceC4589Ft7 b;
    private boolean c;
    private int e;
    private int f;
    private final EW4 a = new EW4(10);
    private long d = -9223372036854775807L;

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        AbstractC20011rK.i(this.b);
        if (this.c) {
            int iA = ew4.a();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iA, 10 - i);
                System.arraycopy(ew4.e(), ew4.f(), this.a.e(), this.f, iMin);
                if (this.f + iMin == 10) {
                    this.a.S(0);
                    if (73 != this.a.F() || 68 != this.a.F() || 51 != this.a.F()) {
                        AbstractC18815pI3.k("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.T(3);
                        this.e = this.a.E() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.e - this.f);
            this.b.d(ew4, iMin2);
            this.f += iMin2;
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.c = false;
        this.d = -9223372036854775807L;
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 5);
        this.b = interfaceC4589Ft7B;
        interfaceC4589Ft7B.c(new X.b().U(dVar.b()).g0("application/id3").G());
    }

    @Override // ir.nasim.B52
    public void d() {
        int i;
        AbstractC20011rK.i(this.b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                this.b.b(j, 1, i, 0, null);
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
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }
}
