package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.util.Log;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ie implements hn {
    private long A;
    private long B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private float G;
    private gx[] H;
    private ByteBuffer[] I;
    private ByteBuffer J;
    private int K;
    private ByteBuffer L;
    private byte[] M;
    private int N;
    private int O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private hs T;
    private boolean U;
    private long V;
    private boolean W;
    private boolean X;
    private final hx Y;
    private final gt a = null;
    private final boolean b;
    private final hu c;
    private final iq d;
    private final gx[] e;
    private final gx[] f;
    private final ConditionVariable g;
    private final hr h;
    private final ArrayDeque<hy> i;
    private final boolean j;
    private final boolean k;
    private id l;
    private final hz<hk> m;
    private final hz<hm> n;
    private hl o;
    private hw p;
    private hw q;
    private AudioTrack r;
    private gs s;
    private hy t;
    private hy u;
    private dv v;
    private ByteBuffer w;
    private int x;
    private long y;
    private long z;

    public ie(gt gtVar, hx hxVar) {
        this.Y = hxVar;
        int i = aeu.a;
        this.b = false;
        this.j = false;
        this.k = false;
        this.g = new ConditionVariable(true);
        this.h = new hr(new ia(this));
        hu huVar = new hu();
        this.c = huVar;
        iq iqVar = new iq();
        this.d = iqVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new im(), huVar, iqVar);
        Collections.addAll(arrayList, hxVar.a());
        this.e = (gx[]) arrayList.toArray(new gx[0]);
        this.f = new gx[]{new ig()};
        this.G = 1.0f;
        this.s = gs.a;
        this.S = 0;
        this.T = new hs();
        dv dvVar = dv.a;
        this.u = new hy(dvVar, false, 0L, 0L);
        this.v = dvVar;
        this.O = -1;
        this.H = new gx[0];
        this.I = new ByteBuffer[0];
        this.i = new ArrayDeque<>();
        this.m = new hz<>();
        this.n = new hz<>();
    }

    private final void G() {
        int i = 0;
        while (true) {
            gx[] gxVarArr = this.H;
            if (i >= gxVarArr.length) {
                return;
            }
            gx gxVar = gxVarArr[i];
            gxVar.g();
            this.I[i] = gxVar.e();
            i++;
        }
    }

    private final void H(long j) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.H.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.I[i - 1];
            } else {
                byteBuffer = this.J;
                if (byteBuffer == null) {
                    byteBuffer = gx.a;
                }
            }
            if (i == length) {
                I(byteBuffer, j);
            } else {
                gx gxVar = this.H[i];
                gxVar.c(byteBuffer);
                ByteBuffer byteBufferE = gxVar.e();
                this.I[i] = byteBufferE;
                if (byteBufferE.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void I(java.nio.ByteBuffer r13, long r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ie.I(java.nio.ByteBuffer, long):void");
    }

    private final void J() {
        if (this.q.d()) {
            this.W = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean K() throws java.lang.Exception {
        /*
            r9 = this;
            int r0 = r9.O
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto Lb
            r9.O = r3
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.O
            com.google.ads.interactivemedia.v3.internal.gx[] r5 = r9.H
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.d()
        L1f:
            r9.H(r7)
            boolean r0 = r4.f()
            if (r0 != 0) goto L29
            return r3
        L29:
            int r0 = r9.O
            int r0 = r0 + r2
            r9.O = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.L
            if (r0 == 0) goto L3b
            r9.I(r0, r7)
            java.nio.ByteBuffer r0 = r9.L
            if (r0 == 0) goto L3b
            return r3
        L3b:
            r9.O = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ie.K():boolean");
    }

    private final void L() {
        if (Q()) {
            if (aeu.a >= 21) {
                this.r.setVolume(this.G);
                return;
            }
            AudioTrack audioTrack = this.r;
            float f = this.G;
            audioTrack.setStereoVolume(f, f);
        }
    }

    private final void M(dv dvVar, boolean z) {
        hy hyVarO = O();
        if (dvVar.equals(hyVarO.a) && z == hyVarO.b) {
            return;
        }
        hy hyVar = new hy(dvVar, z, -9223372036854775807L, -9223372036854775807L);
        if (Q()) {
            this.t = hyVar;
        } else {
            this.u = hyVar;
        }
    }

    private final dv N() {
        return O().a;
    }

    private final hy O() {
        hy hyVar = this.t;
        return hyVar != null ? hyVar : !this.i.isEmpty() ? this.i.getLast() : this.u;
    }

    private final void P(long j) {
        boolean z;
        dv dvVarB = this.q.i ? this.Y.b(N()) : dv.a;
        if (this.q.i) {
            hx hxVar = this.Y;
            boolean zX = x();
            hxVar.e(zX);
            z = zX;
        } else {
            z = false;
        }
        this.i.add(new hy(dvVarB, z, Math.max(0L, j), this.q.a(S())));
        gx[] gxVarArr = this.q.j;
        ArrayList arrayList = new ArrayList();
        for (gx gxVar : gxVarArr) {
            if (gxVar.b()) {
                arrayList.add(gxVar);
            } else {
                gxVar.g();
            }
        }
        int size = arrayList.size();
        this.H = (gx[]) arrayList.toArray(new gx[size]);
        this.I = new ByteBuffer[size];
        G();
        hl hlVar = this.o;
        if (hlVar != null) {
            ((ii) hlVar).a.c.h(z);
        }
    }

    private final boolean Q() {
        return this.r != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long R() {
        return this.q.c == 0 ? this.y / r0.b : this.z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long S() {
        return this.q.c == 0 ? this.A / r0.d : this.B;
    }

    private static Pair<Integer, Integer> T(cy cyVar, gt gtVar) {
        return null;
    }

    private static boolean U(AudioTrack audioTrack) {
        return aeu.a >= 29 && audioTrack.isOffloadedPlayback();
    }

    private static int V(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private final void W() throws IllegalStateException {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.h.i(S());
        this.r.stop();
        this.x = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioFormat X(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void a(hl hlVar) {
        this.o = hlVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final boolean b(cy cyVar) {
        return c(cyVar) != 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final int c(cy cyVar) {
        if (!"audio/raw".equals(cyVar.l)) {
            return T(cyVar, null) != null ? 2 : 0;
        }
        if (aeu.X(cyVar.A)) {
            return cyVar.A != 2 ? 1 : 2;
        }
        int i = cyVar.A;
        StringBuilder sb = new StringBuilder(33);
        sb.append("Invalid PCM encoding: ");
        sb.append(i);
        Log.w("AudioTrack", sb.toString());
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final long d(boolean z) {
        if (!Q() || this.E) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.h.b(z), this.q.a(S()));
        while (!this.i.isEmpty() && jMin >= this.i.getFirst().d) {
            this.u = this.i.remove();
        }
        hy hyVar = this.u;
        long jC = jMin - hyVar.d;
        if (!hyVar.a.equals(dv.a)) {
            jC = this.i.isEmpty() ? this.Y.c(jC) : aeu.O(jC, this.u.a.b);
        }
        return this.u.c + jC + this.q.a(this.Y.d());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void e() throws IllegalStateException {
        this.R = true;
        if (Q()) {
            this.h.c();
            this.r.play();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void f() {
        this.D = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final boolean g(ByteBuffer byteBuffer, long j, int i) throws Exception {
        int iE;
        int i2;
        byte b;
        int i3;
        byte b2;
        int i4;
        ByteBuffer byteBuffer2 = this.J;
        ary.o(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.p != null) {
            if (!K()) {
                return false;
            }
            hw hwVar = this.p;
            hw hwVar2 = this.q;
            if (hwVar2.c == hwVar.c && hwVar2.g == hwVar.g && hwVar2.e == hwVar.e && hwVar2.f == hwVar.f && hwVar2.d == hwVar.d) {
                this.q = hwVar;
                this.p = null;
                if (U(this.r)) {
                    this.r.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.r;
                    cy cyVar = this.q.a;
                    audioTrack.setOffloadDelayPadding(cyVar.B, cyVar.C);
                    this.X = true;
                }
            } else {
                W();
                if (j()) {
                    return false;
                }
                u();
            }
            P(j);
        }
        if (!Q()) {
            try {
                this.g.block();
                try {
                    hw hwVar3 = this.q;
                    ary.t(hwVar3);
                    AudioTrack audioTrackC = hwVar3.c(this.U, this.s, this.S);
                    this.r = audioTrackC;
                    if (U(audioTrackC)) {
                        AudioTrack audioTrack2 = this.r;
                        if (this.l == null) {
                            this.l = new id(this);
                        }
                        this.l.a(audioTrack2);
                        AudioTrack audioTrack3 = this.r;
                        cy cyVar2 = this.q.a;
                        audioTrack3.setOffloadDelayPadding(cyVar2.B, cyVar2.C);
                    }
                    int audioSessionId = this.r.getAudioSessionId();
                    if (this.S != audioSessionId) {
                        this.S = audioSessionId;
                        hl hlVar = this.o;
                        if (hlVar != null) {
                            ((ii) hlVar).a.c.g(audioSessionId);
                        }
                    }
                    hr hrVar = this.h;
                    AudioTrack audioTrack4 = this.r;
                    hw hwVar4 = this.q;
                    hrVar.a(audioTrack4, hwVar4.c == 2, hwVar4.g, hwVar4.d, hwVar4.h);
                    L();
                    int i5 = this.T.a;
                    this.E = true;
                } catch (hk e) {
                    J();
                    hl hlVar2 = this.o;
                    if (hlVar2 != null) {
                        hlVar2.d(e);
                    }
                    throw e;
                }
            } catch (hk e2) {
                if (e2.a) {
                    throw e2;
                }
                this.m.a(e2);
                return false;
            }
        }
        this.m.b();
        if (this.E) {
            this.F = Math.max(0L, j);
            this.D = false;
            this.E = false;
            P(j);
            if (this.R) {
                e();
            }
        }
        if (!this.h.e(S())) {
            return false;
        }
        if (this.J == null) {
            ary.o(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            hw hwVar5 = this.q;
            if (hwVar5.c != 0 && this.C == 0) {
                int i6 = hwVar5.g;
                switch (i6) {
                    case 5:
                    case 6:
                    case 18:
                        iE = gp.e(byteBuffer);
                        break;
                    case 7:
                    case 8:
                        int i7 = Cif.a;
                        int iPosition = byteBuffer.position();
                        byte b3 = byteBuffer.get(iPosition);
                        if (b3 != -2) {
                            if (b3 == -1) {
                                i2 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                b2 = byteBuffer.get(iPosition + 7);
                            } else if (b3 != 31) {
                                i2 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                b = byteBuffer.get(iPosition + 5);
                            } else {
                                i2 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                b2 = byteBuffer.get(iPosition + 6);
                            }
                            i3 = b2 & 60;
                            iE = (((i3 >> 2) | i2) + 1) * 32;
                            break;
                        } else {
                            i2 = (byteBuffer.get(iPosition + 5) & 1) << 6;
                            b = byteBuffer.get(iPosition + 4);
                        }
                        i3 = b & 252;
                        iE = (((i3 >> 2) | i2) + 1) * 32;
                    case 9:
                        int iB = il.b(aeu.ac(byteBuffer, byteBuffer.position()));
                        if (iB == -1) {
                            throw new IllegalArgumentException();
                        }
                        iE = iB;
                        break;
                    case 10:
                    case 16:
                        iE = 1024;
                        break;
                    case 11:
                    case 12:
                        iE = 2048;
                        break;
                    case 13:
                    default:
                        StringBuilder sb = new StringBuilder(38);
                        sb.append("Unexpected audio encoding: ");
                        sb.append(i6);
                        throw new IllegalStateException(sb.toString());
                    case 14:
                        int i8 = gp.a;
                        int iPosition2 = byteBuffer.position();
                        int iLimit = byteBuffer.limit() - 10;
                        int i9 = iPosition2;
                        while (true) {
                            if (i9 > iLimit) {
                                i4 = -1;
                            } else if ((aeu.ac(byteBuffer, i9 + 4) & (-2)) == -126718022) {
                                i4 = i9 - iPosition2;
                            } else {
                                i9++;
                            }
                        }
                        if (i4 != -1) {
                            iE = (40 << ((byteBuffer.get((byteBuffer.position() + i4) + ((byteBuffer.get((byteBuffer.position() + i4) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                            break;
                        } else {
                            iE = 0;
                            break;
                        }
                    case 15:
                        iE = 512;
                        break;
                    case 17:
                        int i10 = gr.a;
                        byte[] bArr = new byte[16];
                        int iPosition3 = byteBuffer.position();
                        byteBuffer.get(bArr);
                        byteBuffer.position(iPosition3);
                        iE = gr.a(new aed(bArr)).d;
                        break;
                }
                this.C = iE;
                if (iE == 0) {
                    return true;
                }
            }
            if (this.t != null) {
                if (!K()) {
                    return false;
                }
                P(j);
                this.t = null;
            }
            long jR = this.F + (((R() - this.d.q()) * 1000000) / this.q.a.z);
            if (!this.D && Math.abs(jR - j) > 200000) {
                StringBuilder sb2 = new StringBuilder(80);
                sb2.append("Discontinuity detected [expected ");
                sb2.append(jR);
                sb2.append(", got ");
                sb2.append(j);
                sb2.append("]");
                Log.e("AudioTrack", sb2.toString());
                this.D = true;
            }
            if (this.D) {
                if (!K()) {
                    return false;
                }
                long j2 = j - jR;
                this.F += j2;
                this.D = false;
                P(j);
                hl hlVar3 = this.o;
                if (hlVar3 != null && j2 != 0) {
                    ((ii) hlVar3).a.W();
                }
            }
            if (this.q.c == 0) {
                this.y += byteBuffer.remaining();
            } else {
                this.z += this.C * i;
            }
            this.J = byteBuffer;
            this.K = i;
        }
        H(j);
        if (!this.J.hasRemaining()) {
            this.J = null;
            this.K = 0;
            return true;
        }
        if (!this.h.h(S())) {
            return false;
        }
        Log.w("AudioTrack", "Resetting stalled audio track");
        u();
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void h() throws IllegalStateException, hm {
        if (!this.P && Q() && K()) {
            W();
            this.P = true;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final boolean i() {
        return !Q() || (this.P && !j());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final boolean j() {
        return Q() && this.h.j(S());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void k(dv dvVar) {
        M(new dv(aeu.J(dvVar.b, 0.1f, 8.0f), aeu.J(dvVar.c, 0.1f, 8.0f)), x());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final dv l() {
        return N();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void m(boolean z) {
        M(N(), z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void n(gs gsVar) throws IllegalStateException {
        if (this.s.equals(gsVar)) {
            return;
        }
        this.s = gsVar;
        if (this.U) {
            return;
        }
        u();
        this.S = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void o(int i) throws IllegalStateException {
        if (this.S != i) {
            this.S = i;
            u();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void p(hs hsVar) {
        if (this.T.equals(hsVar)) {
            return;
        }
        int i = hsVar.a;
        if (this.r != null) {
            int i2 = this.T.a;
        }
        this.T = hsVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void q(int i) throws IllegalStateException {
        ary.q(aeu.a >= 21);
        if (this.U && this.S == i) {
            return;
        }
        this.U = true;
        this.S = i;
        u();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void r() throws IllegalStateException {
        if (this.U) {
            this.U = false;
            this.S = 0;
            u();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void s(float f) {
        if (this.G != f) {
            this.G = f;
            L();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void t() throws IllegalStateException {
        this.R = false;
        if (Q() && this.h.k()) {
            this.r.pause();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void u() throws IllegalStateException {
        if (Q()) {
            this.y = 0L;
            this.z = 0L;
            this.A = 0L;
            this.B = 0L;
            this.X = false;
            this.C = 0;
            this.u = new hy(N(), x(), 0L, 0L);
            this.F = 0L;
            this.t = null;
            this.i.clear();
            this.J = null;
            this.K = 0;
            this.L = null;
            this.Q = false;
            this.P = false;
            this.O = -1;
            this.w = null;
            this.x = 0;
            this.d.p();
            G();
            if (this.h.d()) {
                this.r.pause();
            }
            if (U(this.r)) {
                id idVar = this.l;
                ary.t(idVar);
                idVar.b(this.r);
            }
            AudioTrack audioTrack = this.r;
            this.r = null;
            hw hwVar = this.p;
            if (hwVar != null) {
                this.q = hwVar;
                this.p = null;
            }
            this.h.l();
            this.g.close();
            new hv(this, audioTrack).start();
        }
        this.n.b();
        this.m.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void v() throws IllegalStateException {
        u();
        for (gx gxVar : this.e) {
            gxVar.h();
        }
        gx[] gxVarArr = this.f;
        int length = gxVarArr.length;
        for (int i = 0; i <= 0; i++) {
            gxVarArr[i].h();
        }
        this.S = 0;
        this.R = false;
        this.W = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hn
    public final void w(cy cyVar, int[] iArr) throws hj {
        int i;
        gx[] gxVarArr;
        int iIntValue;
        int i2;
        int iAa;
        boolean z;
        int i3;
        int i4;
        int[] iArr2;
        if ("audio/raw".equals(cyVar.l)) {
            ary.o(aeu.X(cyVar.A));
            int iAa2 = aeu.aa(cyVar.A, cyVar.y);
            gx[] gxVarArr2 = this.e;
            this.d.o(cyVar.B, cyVar.C);
            if (aeu.a < 21 && cyVar.y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i5 = 0; i5 < 6; i5++) {
                    iArr2[i5] = i5;
                }
            } else {
                iArr2 = iArr;
            }
            this.c.o(iArr2);
            gv gvVar = new gv(cyVar.z, cyVar.y, cyVar.A);
            for (gx gxVar : gxVarArr2) {
                try {
                    gv gvVarA = gxVar.a(gvVar);
                    if (true == gxVar.b()) {
                        gvVar = gvVarA;
                    }
                } catch (gw e) {
                    throw new hj(e);
                }
            }
            int i6 = gvVar.d;
            int i7 = gvVar.b;
            iIntValue = aeu.Z(gvVar.c);
            iAa = aeu.aa(i6, gvVar.c);
            i4 = iAa2;
            gxVarArr = gxVarArr2;
            i2 = i6;
            i3 = i7;
            i = 0;
            z = true;
        } else {
            gx[] gxVarArr3 = new gx[0];
            int i8 = cyVar.z;
            Pair<Integer, Integer> pairT = T(cyVar, null);
            if (pairT == null) {
                String strValueOf = String.valueOf(cyVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
                sb.append("Unable to configure passthrough for: ");
                sb.append(strValueOf);
                throw new hj(sb.toString());
            }
            int iIntValue2 = ((Integer) pairT.first).intValue();
            i = 2;
            gxVarArr = gxVarArr3;
            iIntValue = ((Integer) pairT.second).intValue();
            i2 = iIntValue2;
            iAa = -1;
            z = false;
            i3 = i8;
            i4 = -1;
        }
        if (i2 == 0) {
            String strValueOf2 = String.valueOf(cyVar);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 48);
            sb2.append("Invalid output encoding (mode=");
            sb2.append(i);
            sb2.append(") for: ");
            sb2.append(strValueOf2);
            throw new hj(sb2.toString());
        }
        if (iIntValue != 0) {
            this.W = false;
            hw hwVar = new hw(cyVar, i4, i, iAa, i3, iIntValue, i2, false, z, gxVarArr);
            if (Q()) {
                this.p = hwVar;
                return;
            } else {
                this.q = hwVar;
                return;
            }
        }
        String strValueOf3 = String.valueOf(cyVar);
        StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 54);
        sb3.append("Invalid output channel config (mode=");
        sb3.append(i);
        sb3.append(") for: ");
        sb3.append(strValueOf3);
        throw new hj(sb3.toString());
    }

    public final boolean x() {
        return O().b;
    }
}
