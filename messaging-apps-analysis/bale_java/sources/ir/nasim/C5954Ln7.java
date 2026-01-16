package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.AbstractC2027f;
import com.google.android.exoplayer2.text.SubtitleDecoderException;

/* renamed from: ir.nasim.Ln7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5954Ln7 extends AbstractC2027f implements Handler.Callback {
    private int A;
    private long B;
    private long D;
    private long G;
    private final Handler n;
    private final InterfaceC22769vn7 o;
    private final A07 p;
    private final C21664tv2 q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private com.google.android.exoplayer2.X v;
    private InterfaceC24671z07 w;
    private C07 x;
    private D07 y;
    private D07 z;

    public C5954Ln7(InterfaceC22769vn7 interfaceC22769vn7, Looper looper) {
        this(interfaceC22769vn7, looper, A07.a);
    }

    private void Y() {
        j0(new C16831lw1(AbstractC12710f43.V(), b0(this.G)));
    }

    private long Z(long j) {
        int iA = this.y.a(j);
        if (iA == 0 || this.y.j() == 0) {
            return this.y.b;
        }
        if (iA != -1) {
            return this.y.i(iA - 1);
        }
        return this.y.i(r2.j() - 1);
    }

    private long a0() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        AbstractC20011rK.e(this.y);
        if (this.A >= this.y.j()) {
            return Long.MAX_VALUE;
        }
        return this.y.i(this.A);
    }

    private long b0(long j) {
        AbstractC20011rK.g(j != -9223372036854775807L);
        AbstractC20011rK.g(this.D != -9223372036854775807L);
        return j - this.D;
    }

    private void c0(SubtitleDecoderException subtitleDecoderException) {
        AbstractC18815pI3.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.v, subtitleDecoderException);
        Y();
        h0();
    }

    private void d0() {
        this.t = true;
        this.w = this.p.a((com.google.android.exoplayer2.X) AbstractC20011rK.e(this.v));
    }

    private void e0(C16831lw1 c16831lw1) {
        this.o.u(c16831lw1.a);
        this.o.i(c16831lw1);
    }

    private void f0() {
        this.x = null;
        this.A = -1;
        D07 d07 = this.y;
        if (d07 != null) {
            d07.y();
            this.y = null;
        }
        D07 d072 = this.z;
        if (d072 != null) {
            d072.y();
            this.z = null;
        }
    }

    private void g0() {
        f0();
        ((InterfaceC24671z07) AbstractC20011rK.e(this.w)).release();
        this.w = null;
        this.u = 0;
    }

    private void h0() {
        g0();
        d0();
    }

    private void j0(C16831lw1 c16831lw1) {
        Handler handler = this.n;
        if (handler != null) {
            handler.obtainMessage(0, c16831lw1).sendToTarget();
        } else {
            e0(c16831lw1);
        }
    }

    @Override // com.google.android.exoplayer2.D0
    public void B(long j, long j2) {
        boolean z;
        this.G = j;
        if (s()) {
            long j3 = this.B;
            if (j3 != -9223372036854775807L && j >= j3) {
                f0();
                this.s = true;
            }
        }
        if (this.s) {
            return;
        }
        if (this.z == null) {
            ((InterfaceC24671z07) AbstractC20011rK.e(this.w)).a(j);
            try {
                this.z = (D07) ((InterfaceC24671z07) AbstractC20011rK.e(this.w)).b();
            } catch (SubtitleDecoderException e) {
                c0(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.y != null) {
            long jA0 = a0();
            z = false;
            while (jA0 <= j) {
                this.A++;
                jA0 = a0();
                z = true;
            }
        } else {
            z = false;
        }
        D07 d07 = this.z;
        if (d07 != null) {
            if (d07.u()) {
                if (!z && a0() == Long.MAX_VALUE) {
                    if (this.u == 2) {
                        h0();
                    } else {
                        f0();
                        this.s = true;
                    }
                }
            } else if (d07.b <= j) {
                D07 d072 = this.y;
                if (d072 != null) {
                    d072.y();
                }
                this.A = d07.a(j);
                this.y = d07;
                this.z = null;
                z = true;
            }
        }
        if (z) {
            AbstractC20011rK.e(this.y);
            j0(new C16831lw1(this.y.h(j), b0(Z(j))));
        }
        if (this.u == 2) {
            return;
        }
        while (!this.r) {
            try {
                C07 c07 = this.x;
                if (c07 == null) {
                    c07 = (C07) ((InterfaceC24671z07) AbstractC20011rK.e(this.w)).d();
                    if (c07 == null) {
                        return;
                    } else {
                        this.x = c07;
                    }
                }
                if (this.u == 1) {
                    c07.x(4);
                    ((InterfaceC24671z07) AbstractC20011rK.e(this.w)).c(c07);
                    this.x = null;
                    this.u = 2;
                    return;
                }
                int iV = V(this.q, c07, 0);
                if (iV == -4) {
                    if (c07.u()) {
                        this.r = true;
                        this.t = false;
                    } else {
                        com.google.android.exoplayer2.X x = this.q.b;
                        if (x == null) {
                            return;
                        }
                        c07.i = x.p;
                        c07.A();
                        this.t &= !c07.w();
                    }
                    if (!this.t) {
                        ((InterfaceC24671z07) AbstractC20011rK.e(this.w)).c(c07);
                        this.x = null;
                    }
                } else if (iV == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                c0(e2);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void O() {
        this.v = null;
        this.B = -9223372036854775807L;
        Y();
        this.D = -9223372036854775807L;
        this.G = -9223372036854775807L;
        g0();
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void Q(long j, boolean z) {
        this.G = j;
        Y();
        this.r = false;
        this.s = false;
        this.B = -9223372036854775807L;
        if (this.u != 0) {
            h0();
        } else {
            f0();
            ((InterfaceC24671z07) AbstractC20011rK.e(this.w)).flush();
        }
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void U(com.google.android.exoplayer2.X[] xArr, long j, long j2) {
        this.D = j2;
        this.v = xArr[0];
        if (this.w != null) {
            this.u = 1;
        } else {
            d0();
        }
    }

    @Override // ir.nasim.InterfaceC24899zO5
    public int b(com.google.android.exoplayer2.X x) {
        if (this.p.b(x)) {
            return InterfaceC24899zO5.a(x.Y == 0 ? 4 : 2);
        }
        return AbstractC24462yf4.q(x.l) ? InterfaceC24899zO5.a(1) : InterfaceC24899zO5.a(0);
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean d() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.D0, ir.nasim.InterfaceC24899zO5
    public String getName() {
        return "TextRenderer";
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean h() {
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        e0((C16831lw1) message.obj);
        return true;
    }

    public void i0(long j) {
        AbstractC20011rK.g(s());
        this.B = j;
    }

    public C5954Ln7(InterfaceC22769vn7 interfaceC22769vn7, Looper looper, A07 a07) {
        super(3);
        this.o = (InterfaceC22769vn7) AbstractC20011rK.e(interfaceC22769vn7);
        this.n = looper == null ? null : AbstractC9683aN7.u(looper, this);
        this.p = a07;
        this.q = new C21664tv2();
        this.B = -9223372036854775807L;
        this.D = -9223372036854775807L;
        this.G = -9223372036854775807L;
    }
}
