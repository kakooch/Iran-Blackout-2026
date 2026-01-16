package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ms implements jy {
    public static final /* synthetic */ int a = 0;
    private static final byte[] b;
    private static final cy c;
    private long A;
    private mr B;
    private int C;
    private int D;
    private int E;
    private boolean F;
    private ka G;
    private kr[] H;
    private kr[] I;
    private boolean J;
    private final int d;
    private final List<cy> e;
    private final SparseArray<mr> f;
    private final aee g;
    private final aee h;
    private final aee i;
    private final byte[] j;
    private final aee k;
    private final aes l;
    private final re m;
    private final aee n;
    private final ArrayDeque<mc> o;
    private final ArrayDeque<mq> p;
    private final kr q;
    private int r;
    private int s;
    private long t;
    private int u;
    private aee v;
    private long w;
    private int x;
    private long y;
    private long z;

    static {
        int i = mp.b;
        b = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
        cx cxVar = new cx();
        cxVar.ae("application/x-emsg");
        c = cxVar.a();
    }

    public ms() {
        this(null);
    }

    private final void a() {
        this.r = 0;
        this.u = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:256:0x0673  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(long r47) throws com.google.ads.interactivemedia.v3.internal.dt {
        /*
            Method dump skipped, instructions count: 1862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ms.b(long):void");
    }

    private static void c(aee aeeVar, int i, nd ndVar) throws dt {
        aeeVar.h(i + 8);
        int iF = me.f(aeeVar.v());
        if ((iF & 1) != 0) {
            throw new dt("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iF & 2) != 0;
        int iB = aeeVar.B();
        if (iB == 0) {
            Arrays.fill(ndVar.n, 0, ndVar.f, false);
            return;
        }
        int i2 = ndVar.f;
        if (iB == i2) {
            Arrays.fill(ndVar.n, 0, iB, z);
            ndVar.a(aeeVar.d());
            aeeVar.m(ndVar.p.i(), 0, ndVar.p.e());
            ndVar.p.h(0);
            ndVar.q = false;
            return;
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append("Senc sample count ");
        sb.append(iB);
        sb.append(" is different from fragment sample count");
        sb.append(i2);
        throw new dt(sb.toString());
    }

    private static jc i(List<md> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            md mdVar = list.get(i);
            if (mdVar.d == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrI = mdVar.a.i();
                UUID uuidC = mz.c(bArrI);
                if (uuidC == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new jb(uuidC, "video/mp4", bArrI));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new jc(arrayList);
    }

    private static void j(int i) throws dt {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected negtive value: ");
        sb.append(i);
        throw new dt(sb.toString());
    }

    private static final mm k(SparseArray<mm> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        mm mmVar = sparseArray.get(i);
        ary.t(mmVar);
        return mmVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        int i;
        this.G = kaVar;
        a();
        kr[] krVarArr = new kr[2];
        this.H = krVarArr;
        kr krVar = this.q;
        int i2 = 0;
        if (krVar != null) {
            krVarArr[0] = krVar;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.d & 4) != 0) {
            krVarArr[i] = this.G.ak(100, 4);
            i3 = 101;
            i++;
        }
        kr[] krVarArr2 = (kr[]) aeu.h(this.H, i);
        this.H = krVarArr2;
        for (kr krVar2 : krVarArr2) {
            krVar2.a(c);
        }
        this.I = new kr[this.e.size()];
        while (i2 < this.I.length) {
            kr krVarAk = this.G.ak(i3, 3);
            krVarAk.a(this.e.get(i2));
            this.I[i2] = krVarAk;
            i2++;
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.valueAt(i).b();
        }
        this.p.clear();
        this.x = 0;
        this.y = j2;
        this.o.clear();
        a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        return na.a(jvVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0237, code lost:
    
        r21 = r2.f();
        r1 = r2.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x023f, code lost:
    
        if (r1 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0241, code lost:
    
        r24 = r1.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0246, code lost:
    
        r24 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0248, code lost:
    
        r5.b(r9, r21, r28.C, 0, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x025b, code lost:
    
        if (r28.p.isEmpty() != false) goto L396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x025d, code lost:
    
        r1 = r28.p.removeFirst();
        r28.x -= r1.b;
        r3 = r1.a + r9;
        r5 = r28.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0271, code lost:
    
        if (r5 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0273, code lost:
    
        r3 = r5.g(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0277, code lost:
    
        r5 = r28.H;
        r7 = r5.length;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x027b, code lost:
    
        if (r8 >= r7) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027d, code lost:
    
        r5[r8].b(r3, 1, r1.b, r28.x, null);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0297, code lost:
    
        if (r2.g() != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0299, code lost:
    
        r28.B = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x029b, code lost:
    
        r28.r = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
    
        r4 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:
    
        if (r28.r != 3) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
    
        r3 = r2.e();
        r28.C = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a4, code lost:
    
        if (r2.f >= r2.i) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a6, code lost:
    
        r1.d(r3);
        r1 = r2.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ad, code lost:
    
        if (r1 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
    
        r3 = r2.b.p;
        r1 = r1.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b6, code lost:
    
        if (r1 == 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
    
        r3.k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c3, code lost:
    
        if (r2.b.c(r2.f) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c5, code lost:
    
        r3.k(r3.o() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d2, code lost:
    
        if (r2.g() != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d4, code lost:
    
        r28.B = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d6, code lost:
    
        r28.r = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d8, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e1, code lost:
    
        if (r2.d.a.g != 1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e3, code lost:
    
        r28.C = r3 - 8;
        r1.d(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f8, code lost:
    
        if ("audio/ac4".equals(r2.d.a.f.l) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fa, code lost:
    
        r28.D = r2.h(r28.C, 7);
        com.google.ads.interactivemedia.v3.internal.gr.b(r28.C, r28.k);
        r2.a.d(r28.k, 7);
        r3 = r28.D + 7;
        r28.D = r3;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0118, code lost:
    
        r5 = 0;
        r3 = r2.h(r28.C, 0);
        r28.D = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0121, code lost:
    
        r28.C += r3;
        r28.r = 4;
        r28.E = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x012b, code lost:
    
        r3 = r2.d.a;
        r5 = r2.a;
        r9 = r2.c();
        r7 = r28.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0137, code lost:
    
        if (r7 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0139, code lost:
    
        r9 = r7.g(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013f, code lost:
    
        if (r3.j != 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0141, code lost:
    
        r3 = r28.D;
        r4 = r28.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0145, code lost:
    
        if (r3 >= r4) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0147, code lost:
    
        r28.D += r5.c(r1, r4 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0153, code lost:
    
        r11 = r28.h.i();
        r11[0] = 0;
        r11[1] = 0;
        r11[2] = 0;
        r7 = r3.j;
        r13 = r7 + 1;
        r7 = 4 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x016c, code lost:
    
        if (r28.D >= r28.C) goto L400;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016e, code lost:
    
        r14 = r28.E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0172, code lost:
    
        if (r14 != 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0174, code lost:
    
        r1.c(r11, r7, r13);
        r28.h.h(0);
        r14 = r28.h.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0183, code lost:
    
        if (r14 <= 0) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0185, code lost:
    
        r28.E = r14 - 1;
        r28.g.h(0);
        r5.d(r28.g, 4);
        r5.d(r28.h, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019c, code lost:
    
        if (r28.I.length <= 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019e, code lost:
    
        r12 = r3.f.l;
        r18 = r11[4];
        r14 = com.google.ads.interactivemedia.v3.internal.aec.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ac, code lost:
    
        if (org.rbmain.messenger.MediaController.VIDEO_MIME_TYPE.equals(r12) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b0, code lost:
    
        if ((r18 & 31) == r4) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b3, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b9, code lost:
    
        if ("video/hevc".equals(r12) == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c0, code lost:
    
        if (((r18 & 126) >> r8) != 39) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c3, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c4, code lost:
    
        r28.F = r12;
        r28.D += 5;
        r28.C += r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d9, code lost:
    
        throw new com.google.ads.interactivemedia.v3.internal.dt("Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01dc, code lost:
    
        if (r28.F == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01de, code lost:
    
        r28.i.a(r14);
        r1.c(r28.i.i(), 0, r28.E);
        r5.d(r28.i, r28.E);
        r4 = r28.E;
        r12 = com.google.ads.interactivemedia.v3.internal.aec.a(r28.i.i(), r28.i.e());
        r28.i.h("video/hevc".equals(r3.f.l) ? 1 : 0);
        r28.i.f(r12);
        com.google.ads.interactivemedia.v3.internal.asn.o(r9, r28.i, r28.I);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0222, code lost:
    
        r4 = r5.c(r1, r14, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0228, code lost:
    
        r28.D += r4;
        r28.E -= r4;
        r4 = 6;
        r8 = 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(com.google.ads.interactivemedia.v3.internal.jv r29, com.google.ads.interactivemedia.v3.internal.kl r30) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1841
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ms.h(com.google.ads.interactivemedia.v3.internal.jv, com.google.ads.interactivemedia.v3.internal.kl):int");
    }

    public ms(byte[] bArr) {
        this(0, null, Collections.emptyList());
    }

    public ms(int i, aes aesVar, List<cy> list) {
        this(i, aesVar, list, null);
    }

    public ms(int i, aes aesVar, List<cy> list, kr krVar) {
        this.d = i;
        this.l = aesVar;
        this.e = Collections.unmodifiableList(list);
        this.q = krVar;
        this.m = new re();
        this.n = new aee(16);
        this.g = new aee(aec.a);
        this.h = new aee(5);
        this.i = new aee();
        byte[] bArr = new byte[16];
        this.j = bArr;
        this.k = new aee(bArr);
        this.o = new ArrayDeque<>();
        this.p = new ArrayDeque<>();
        this.f = new SparseArray<>();
        this.z = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.G = ka.a;
        this.H = new kr[0];
        this.I = new kr[0];
    }
}
