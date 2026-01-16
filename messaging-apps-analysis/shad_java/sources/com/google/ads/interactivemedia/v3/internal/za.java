package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class za implements kr {
    private static final cy a;
    private final rd b = new rd();
    private final kr c;
    private final cy d;
    private cy e;
    private byte[] f;
    private int g;

    static {
        cx cxVar = new cx();
        cxVar.ae("application/id3");
        a = cxVar.a();
        cx cxVar2 = new cx();
        cxVar2.ae("application/x-emsg");
        cxVar2.a();
    }

    public za(kr krVar, int i) {
        this.c = krVar;
        if (i == 1) {
            this.d = a;
            this.f = new byte[0];
            this.g = 0;
        } else {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Unknown metadataType: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private final void g(int i) {
        byte[] bArr = this.f;
        if (bArr.length < i) {
            this.f = Arrays.copyOf(bArr, i + (i >> 1));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void a(cy cyVar) {
        this.e = cyVar;
        this.c.a(this.d);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void b(long j, int i, int i2, int i3, kq kqVar) {
        ary.t(this.e);
        int i4 = this.g - i3;
        aee aeeVar = new aee(Arrays.copyOfRange(this.f, i4 - i2, i4));
        byte[] bArr = this.f;
        System.arraycopy(bArr, i4, bArr, 0, i3);
        this.g = i3;
        if (!aeu.c(this.e.l, this.d.l)) {
            if (!"application/x-emsg".equals(this.e.l)) {
                String strValueOf = String.valueOf(this.e.l);
                Log.w("EmsgUnwrappingTrackOutput", strValueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(strValueOf) : new String("Ignoring sample for unsupported format: "));
                return;
            }
            rc rcVarC = rd.c(aeeVar);
            cy cyVarA = rcVarC.a();
            if (cyVarA == null || !aeu.c(this.d.l, cyVarA.l)) {
                Log.w("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.d.l, rcVarC.a()));
                return;
            }
            aeeVar = new aee((byte[]) ary.t(rcVarC.a() != null ? rcVarC.e : null));
        }
        int iD = aeeVar.d();
        this.c.d(aeeVar, iD);
        this.c.b(j, i, iD, i3, kqVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final int c(abu abuVar, int i, boolean z) throws IOException {
        return atv.q(this, abuVar, i, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void d(aee aeeVar, int i) {
        atv.r(this, aeeVar, i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final int e(abu abuVar, int i, boolean z) throws IOException {
        g(this.g + i);
        int iA = abuVar.a(this.f, this.g, i);
        if (iA != -1) {
            this.g += iA;
            return iA;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void f(aee aeeVar, int i) {
        g(this.g + i);
        aeeVar.m(this.f, this.g, i);
        this.g += i;
    }
}
