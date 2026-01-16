package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import ir.nasim.AbstractC6193Mo4;
import ir.nasim.C21339tV;
import ir.nasim.EW4;
import ir.nasim.InterfaceC4589Ft7;

/* loaded from: classes2.dex */
final class d extends TagPayloadReader {
    private final EW4 b;
    private final EW4 c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;

    public d(InterfaceC4589Ft7 interfaceC4589Ft7) {
        super(interfaceC4589Ft7);
        this.b = new EW4(AbstractC6193Mo4.a);
        this.c = new EW4(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean b(EW4 ew4) throws TagPayloadReader.UnsupportedFormatException {
        int iF = ew4.F();
        int i = (iF >> 4) & 15;
        int i2 = iF & 15;
        if (i2 == 7) {
            this.g = i;
            return i != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean c(EW4 ew4, long j) throws ParserException {
        int iF = ew4.F();
        long jP = j + (ew4.p() * 1000);
        if (iF == 0 && !this.e) {
            EW4 ew42 = new EW4(new byte[ew4.a()]);
            ew4.j(ew42.e(), 0, ew4.a());
            C21339tV c21339tVB = C21339tV.b(ew42);
            this.d = c21339tVB.b;
            this.a.c(new X.b().g0("video/avc").K(c21339tVB.f).n0(c21339tVB.c).S(c21339tVB.d).c0(c21339tVB.e).V(c21339tVB.a).G());
            this.e = true;
            return false;
        }
        if (iF != 1 || !this.e) {
            return false;
        }
        int i = this.g == 1 ? 1 : 0;
        if (!this.f && i == 0) {
            return false;
        }
        byte[] bArrE = this.c.e();
        bArrE[0] = 0;
        bArrE[1] = 0;
        bArrE[2] = 0;
        int i2 = 4 - this.d;
        int i3 = 0;
        while (ew4.a() > 0) {
            ew4.j(this.c.e(), i2, this.d);
            this.c.S(0);
            int iJ = this.c.J();
            this.b.S(0);
            this.a.d(this.b, 4);
            this.a.d(ew4, iJ);
            i3 = i3 + 4 + iJ;
        }
        this.a.b(jP, i, i3, 0, null);
        this.f = true;
        return true;
    }
}
