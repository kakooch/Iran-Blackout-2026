package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import ir.nasim.EW4;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.K;
import java.util.Collections;

/* loaded from: classes2.dex */
final class a extends TagPayloadReader {
    private static final int[] e = {5512, 11025, 22050, 44100};
    private boolean b;
    private boolean c;
    private int d;

    public a(InterfaceC4589Ft7 interfaceC4589Ft7) {
        super(interfaceC4589Ft7);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean b(EW4 ew4) throws TagPayloadReader.UnsupportedFormatException {
        if (this.b) {
            ew4.T(1);
        } else {
            int iF = ew4.F();
            int i = (iF >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.a.c(new X.b().g0("audio/mpeg").J(1).h0(e[(iF >> 2) & 3]).G());
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.a.c(new X.b().g0(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").J(1).h0(8000).G());
                this.c = true;
            } else if (i != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.d);
            }
            this.b = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean c(EW4 ew4, long j) {
        if (this.d == 2) {
            int iA = ew4.a();
            this.a.d(ew4, iA);
            this.a.b(j, 1, iA, 0, null);
            return true;
        }
        int iF = ew4.F();
        if (iF != 0 || this.c) {
            if (this.d == 10 && iF != 1) {
                return false;
            }
            int iA2 = ew4.a();
            this.a.d(ew4, iA2);
            this.a.b(j, 1, iA2, 0, null);
            return true;
        }
        int iA3 = ew4.a();
        byte[] bArr = new byte[iA3];
        ew4.j(bArr, 0, iA3);
        K.b bVarE = K.e(bArr);
        this.a.c(new X.b().g0("audio/mp4a-latm").K(bVarE.c).J(bVarE.b).h0(bVarE.a).V(Collections.singletonList(bArr)).G());
        this.c = true;
        return false;
    }
}
