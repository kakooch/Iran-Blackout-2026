package ir.nasim;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.YX6;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
final class ML4 extends YX6 {
    private static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean n;

    ML4() {
    }

    private static boolean n(EW4 ew4, byte[] bArr) {
        if (ew4.a() < bArr.length) {
            return false;
        }
        int iF = ew4.f();
        byte[] bArr2 = new byte[bArr.length];
        ew4.j(bArr2, 0, bArr.length);
        ew4.S(iF);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(EW4 ew4) {
        return n(ew4, o);
    }

    @Override // ir.nasim.YX6
    protected long f(EW4 ew4) {
        return c(NL4.e(ew4.e()));
    }

    @Override // ir.nasim.YX6
    protected boolean i(EW4 ew4, long j, YX6.b bVar) {
        if (n(ew4, o)) {
            byte[] bArrCopyOf = Arrays.copyOf(ew4.e(), ew4.g());
            int iC = NL4.c(bArrCopyOf);
            List listA = NL4.a(bArrCopyOf);
            if (bVar.a != null) {
                return true;
            }
            bVar.a = new X.b().g0("audio/opus").J(iC).h0(48000).V(listA).G();
            return true;
        }
        byte[] bArr = p;
        if (!n(ew4, bArr)) {
            AbstractC20011rK.i(bVar.a);
            return false;
        }
        AbstractC20011rK.i(bVar.a);
        if (this.n) {
            return true;
        }
        this.n = true;
        ew4.T(bArr.length);
        Metadata metadataC = AbstractC16294l18.c(AbstractC12710f43.P(AbstractC16294l18.j(ew4, false, false).b));
        if (metadataC == null) {
            return true;
        }
        bVar.a = bVar.a.c().Z(metadataC.b(bVar.a.j)).G();
        return true;
    }

    @Override // ir.nasim.YX6
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = false;
        }
    }
}
