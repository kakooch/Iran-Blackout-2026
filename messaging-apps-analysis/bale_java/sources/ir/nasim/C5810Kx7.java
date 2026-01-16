package ir.nasim;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import ir.nasim.C14451hw1;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: ir.nasim.Kx7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5810Kx7 extends WC6 {
    private final EW4 o;
    private final boolean p;
    private final int q;
    private final int r;
    private final String s;
    private final float t;
    private final int u;

    public C5810Kx7(List list) {
        super("Tx3gDecoder");
        this.o = new EW4();
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.q = 0;
            this.r = -1;
            this.s = "sans-serif";
            this.p = false;
            this.t = 0.85f;
            this.u = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.q = bArr[24];
        this.r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.s = "Serif".equals(AbstractC9683aN7.C(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.u = i;
        boolean z = (bArr[0] & 32) != 0;
        this.p = z;
        if (z) {
            this.t = AbstractC9683aN7.o(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.t = 0.85f;
        }
    }

    private void B(EW4 ew4, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        C(ew4.a() >= 12);
        int iL = ew4.L();
        int iL2 = ew4.L();
        ew4.T(2);
        int iF = ew4.F();
        ew4.T(1);
        int iO = ew4.o();
        if (iL2 > spannableStringBuilder.length()) {
            AbstractC18815pI3.k("Tx3gDecoder", "Truncating styl end (" + iL2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iL2 = spannableStringBuilder.length();
        }
        if (iL < iL2) {
            int i = iL2;
            E(spannableStringBuilder, iF, this.q, iL, i, 0);
            D(spannableStringBuilder, iO, this.r, iL, i, 0);
            return;
        }
        AbstractC18815pI3.k("Tx3gDecoder", "Ignoring styl with start (" + iL + ") >= end (" + iL2 + ").");
    }

    private static void C(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void D(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void E(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
        }
    }

    private static void F(SpannableStringBuilder spannableStringBuilder, String str, int i, int i2) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, 16711713);
        }
    }

    private static String G(EW4 ew4) throws SubtitleDecoderException {
        C(ew4.a() >= 2);
        int iL = ew4.L();
        if (iL == 0) {
            return "";
        }
        int iF = ew4.f();
        Charset charsetN = ew4.N();
        int iF2 = iL - (ew4.f() - iF);
        if (charsetN == null) {
            charsetN = AbstractC12884fL0.c;
        }
        return ew4.D(iF2, charsetN);
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.o.Q(bArr, i);
        String strG = G(this.o);
        if (strG.isEmpty()) {
            return C6043Lx7.b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strG);
        E(spannableStringBuilder, this.q, 0, 0, spannableStringBuilder.length(), 16711680);
        D(spannableStringBuilder, this.r, -1, 0, spannableStringBuilder.length(), 16711680);
        F(spannableStringBuilder, this.s, 0, spannableStringBuilder.length());
        float fO = this.t;
        while (this.o.a() >= 8) {
            int iF = this.o.f();
            int iO = this.o.o();
            int iO2 = this.o.o();
            if (iO2 == 1937013100) {
                C(this.o.a() >= 2);
                int iL = this.o.L();
                for (int i2 = 0; i2 < iL; i2++) {
                    B(this.o, spannableStringBuilder);
                }
            } else if (iO2 == 1952608120 && this.p) {
                C(this.o.a() >= 2);
                fO = AbstractC9683aN7.o(this.o.L() / this.u, 0.0f, 0.95f);
            }
            this.o.S(iF + iO);
        }
        return new C6043Lx7(new C14451hw1.b().o(spannableStringBuilder).h(fO, 0).i(0).a());
    }
}
