package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ij extends qi implements adw {
    private final Context b;
    private final hh c;
    private final hn d;
    private int e;
    private boolean f;
    private boolean g;
    private cy h;
    private long i;
    private boolean j;
    private boolean k;
    private ec l;

    public ij(Context context, qk qkVar, Handler handler, hi hiVar) {
        ie ieVar = new ie(null, new hx(new gx[0]));
        super(1, qkVar, 44100.0f);
        this.b = context.getApplicationContext();
        this.d = ieVar;
        this.c = new hh(handler, hiVar);
        ieVar.a(new ii(this));
    }

    private final int aB(qg qgVar, cy cyVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(qgVar.a) || (i = aeu.a) >= 24 || (i == 23 && aeu.ag(this.b))) {
            return cyVar.m;
        }
        return -1;
    }

    private final void aC() {
        long jD = this.d.d(N());
        if (jD != Long.MIN_VALUE) {
            if (!this.k) {
                jD = Math.max(this.i, jD);
            }
            this.i = jD;
            this.k = false;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed, com.google.ads.interactivemedia.v3.internal.ee
    public final String K() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.ed
    public final boolean M() {
        return this.d.j() || super.M();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.ed
    public final boolean N() {
        return super.N() && this.d.i();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final int P(qk qkVar, cy cyVar) throws qq {
        if (!adz.a(cyVar.l)) {
            return asn.q(0);
        }
        int i = aeu.a >= 21 ? 32 : 0;
        Class cls = cyVar.E;
        boolean zAA = qi.aA(cyVar);
        if (zAA && this.d.b(cyVar) && (cls == null || qv.a() != null)) {
            return i | 12;
        }
        if ("audio/raw".equals(cyVar.l) && !this.d.b(cyVar)) {
            return asn.q(1);
        }
        if (!this.d.b(aeu.V(2, cyVar.y, cyVar.z))) {
            return asn.q(1);
        }
        List<qg> listQ = Q(qkVar, cyVar, false);
        if (listQ.isEmpty()) {
            return asn.q(1);
        }
        if (!zAA) {
            return asn.q(2);
        }
        qg qgVar = listQ.get(0);
        boolean zC = qgVar.c(cyVar);
        int i2 = 8;
        if (zC && qgVar.d(cyVar)) {
            i2 = 16;
        }
        return (true != zC ? 3 : 4) | i2 | i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final List<qg> Q(qk qkVar, cy cyVar, boolean z) throws qq {
        qg qgVarA;
        String str = cyVar.l;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.d.b(cyVar) && (qgVarA = qv.a()) != null) {
            return Collections.singletonList(qgVarA);
        }
        List<qg> listC = qv.c(qkVar.a(str, z, false), cyVar);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(listC);
            arrayList.addAll(qkVar.a("audio/eac3", z, false));
            listC = arrayList;
        }
        return Collections.unmodifiableList(listC);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final boolean R(cy cyVar) {
        return this.d.b(cyVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    @Override // com.google.ads.interactivemedia.v3.internal.qi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void S(com.google.ads.interactivemedia.v3.internal.qg r9, com.google.ads.interactivemedia.v3.internal.qe r10, com.google.ads.interactivemedia.v3.internal.cy r11, android.media.MediaCrypto r12, float r13) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ij.S(com.google.ads.interactivemedia.v3.internal.qg, com.google.ads.interactivemedia.v3.internal.qe, com.google.ads.interactivemedia.v3.internal.cy, android.media.MediaCrypto, float):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void T(String str, long j, long j2) {
        this.c.b(str, j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void U(cz czVar) throws bn {
        super.U(czVar);
        this.c.c(czVar.a);
    }

    protected final void W() {
        this.k = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void X(iw iwVar) {
        if (!this.j || iwVar.b()) {
            return;
        }
        if (Math.abs(iwVar.d - this.i) > 500000) {
            this.i = iwVar.d;
        }
        this.j = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void Y() {
        this.d.f();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final boolean Z(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, cy cyVar) throws bn {
        ary.t(byteBuffer);
        if (mediaCodec != null && this.g && j3 == 0 && (i2 & 4) != 0 && ay() != -9223372036854775807L) {
            j3 = ay();
        }
        if (this.h != null && (i2 & 2) != 0) {
            ary.t(mediaCodec);
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            if (mediaCodec != null) {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            ((qi) this).a.f += i3;
            this.d.f();
            return true;
        }
        try {
            if (!this.d.g(byteBuffer, j3, i3)) {
                return false;
            }
            if (mediaCodec != null) {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            ((qi) this).a.e += i3;
            return true;
        } catch (hk e) {
            throw E(e, cyVar, e.a);
        } catch (hm e2) {
            throw E(e2, cyVar, e2.a);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void aa() throws bn {
        try {
            this.d.h();
        } catch (hm e) {
            cy cyVarAl = al();
            if (cyVarAl == null) {
                cyVarAl = ak();
            }
            throw E(e, cyVarAl, e.a);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final int ad(qg qgVar, cy cyVar, cy cyVar2) {
        if (aB(qgVar, cyVar2) > this.e) {
            return 0;
        }
        if (qgVar.e(cyVar, cyVar2, true)) {
            return 3;
        }
        return (aeu.c(cyVar.l, cyVar2.l) && cyVar.y == cyVar2.y && cyVar.z == cyVar2.z && cyVar.A == cyVar2.A && cyVar.e(cyVar2) && !"audio/opus".equals(cyVar.l)) ? 1 : 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final float ae(float f, cy[] cyVarArr) {
        int iMax = -1;
        for (cy cyVar : cyVarArr) {
            int i = cyVar.z;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh, com.google.ads.interactivemedia.v3.internal.ed
    public final adw d() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final long g() {
        if (e() == 2) {
            aC();
        }
        return this.i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final void h(dv dvVar) {
        this.d.k(dvVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final dv i() {
        return this.d.l();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh, com.google.ads.interactivemedia.v3.internal.dz
    public final void t(int i, Object obj) throws bn {
        if (i == 2) {
            this.d.s(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            this.d.n((gs) obj);
            return;
        }
        if (i == 5) {
            this.d.p((hs) obj);
            return;
        }
        switch (i) {
            case 101:
                this.d.m(((Boolean) obj).booleanValue());
                break;
            case 102:
                this.d.o(((Integer) obj).intValue());
                break;
            case 103:
                this.l = (ec) obj;
                break;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void u(boolean z, boolean z2) throws bn {
        super.u(z, z2);
        this.c.a(((qi) this).a);
        int i = C().b;
        if (i != 0) {
            this.d.q(i);
        } else {
            this.d.r();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void v(long j, boolean z) throws bn {
        super.v(j, z);
        this.d.u();
        this.i = j;
        this.j = true;
        this.k = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected final void w() {
        this.d.e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bh
    protected final void x() {
        aC();
        this.d.t();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void y() {
        try {
            this.d.u();
            try {
                super.y();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.y();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi, com.google.ads.interactivemedia.v3.internal.bh
    protected final void z() {
        try {
            super.z();
        } finally {
            this.d.v();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qi
    protected final void V(cy cyVar, MediaFormat mediaFormat) throws bn {
        int i;
        cy cyVarA = this.h;
        int[] iArr = null;
        if (cyVarA == null) {
            if (am() == null) {
                cyVarA = cyVar;
            } else {
                int iW = "audio/raw".equals(cyVar.l) ? cyVar.A : (aeu.a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? aeu.W(mediaFormat.getInteger("v-bits-per-sample")) : "audio/raw".equals(cyVar.l) ? cyVar.A : 2 : mediaFormat.getInteger("pcm-encoding");
                cx cxVar = new cx();
                cxVar.ae("audio/raw");
                cxVar.Y(iW);
                cxVar.M(cyVar.B);
                cxVar.N(cyVar.C);
                cxVar.H(mediaFormat.getInteger("channel-count"));
                cxVar.af(mediaFormat.getInteger("sample-rate"));
                cyVarA = cxVar.a();
                if (this.f && cyVarA.y == 6 && (i = cyVar.y) < 6) {
                    iArr = new int[i];
                    for (int i2 = 0; i2 < cyVar.y; i2++) {
                        iArr[i2] = i2;
                    }
                }
            }
        }
        try {
            this.d.w(cyVarA, iArr);
        } catch (hj e) {
            throw D(e, cyVar);
        }
    }
}
