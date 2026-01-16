package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC16294l18;
import ir.nasim.YX6;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: ir.nasim.k18, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C15703k18 extends YX6 {
    private a n;
    private int o;
    private boolean p;
    private AbstractC16294l18.d q;
    private AbstractC16294l18.b r;

    /* renamed from: ir.nasim.k18$a */
    static final class a {
        public final AbstractC16294l18.d a;
        public final AbstractC16294l18.b b;
        public final byte[] c;
        public final AbstractC16294l18.c[] d;
        public final int e;

        public a(AbstractC16294l18.d dVar, AbstractC16294l18.b bVar, byte[] bArr, AbstractC16294l18.c[] cVarArr, int i) {
            this.a = dVar;
            this.b = bVar;
            this.c = bArr;
            this.d = cVarArr;
            this.e = i;
        }
    }

    C15703k18() {
    }

    static void n(EW4 ew4, long j) {
        if (ew4.b() < ew4.g() + 4) {
            ew4.P(Arrays.copyOf(ew4.e(), ew4.g() + 4));
        } else {
            ew4.R(ew4.g() + 4);
        }
        byte[] bArrE = ew4.e();
        bArrE[ew4.g() - 4] = (byte) (j & 255);
        bArrE[ew4.g() - 3] = (byte) ((j >>> 8) & 255);
        bArrE[ew4.g() - 2] = (byte) ((j >>> 16) & 255);
        bArrE[ew4.g() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int o(byte b, a aVar) {
        return !aVar.d[p(b, aVar.e, 1)].a ? aVar.a.g : aVar.a.h;
    }

    static int p(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    public static boolean r(EW4 ew4) {
        try {
            return AbstractC16294l18.m(1, ew4, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // ir.nasim.YX6
    protected void e(long j) {
        super.e(j);
        this.p = j != 0;
        AbstractC16294l18.d dVar = this.q;
        this.o = dVar != null ? dVar.g : 0;
    }

    @Override // ir.nasim.YX6
    protected long f(EW4 ew4) {
        if ((ew4.e()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(ew4.e()[0], (a) AbstractC20011rK.i(this.n));
        long j = this.p ? (this.o + iO) / 4 : 0;
        n(ew4, j);
        this.p = true;
        this.o = iO;
        return j;
    }

    @Override // ir.nasim.YX6
    protected boolean i(EW4 ew4, long j, YX6.b bVar) throws ParserException {
        if (this.n != null) {
            AbstractC20011rK.e(bVar.a);
            return false;
        }
        a aVarQ = q(ew4);
        this.n = aVarQ;
        if (aVarQ == null) {
            return true;
        }
        AbstractC16294l18.d dVar = aVarQ.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.j);
        arrayList.add(aVarQ.c);
        bVar.a = new X.b().g0("audio/vorbis").I(dVar.e).b0(dVar.d).J(dVar.b).h0(dVar.c).V(arrayList).Z(AbstractC16294l18.c(AbstractC12710f43.P(aVarQ.b.b))).G();
        return true;
    }

    @Override // ir.nasim.YX6
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    a q(EW4 ew4) throws ParserException {
        AbstractC16294l18.d dVar = this.q;
        if (dVar == null) {
            this.q = AbstractC16294l18.k(ew4);
            return null;
        }
        AbstractC16294l18.b bVar = this.r;
        if (bVar == null) {
            this.r = AbstractC16294l18.i(ew4);
            return null;
        }
        byte[] bArr = new byte[ew4.g()];
        System.arraycopy(ew4.e(), 0, bArr, 0, ew4.g());
        return new a(dVar, bVar, bArr, AbstractC16294l18.l(ew4, dVar.b), AbstractC16294l18.a(r4.length - 1));
    }
}
