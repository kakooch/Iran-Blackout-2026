package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.LiteMode;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class yo {
    private final yp a;
    private final abx b;
    private final abx c;
    private final zi d;
    private final Uri[] e;
    private final cy[] f;
    private final aad g;
    private final vh h;
    private final List<cy> i;
    private boolean k;
    private IOException m;
    private Uri n;
    private boolean o;
    private aba p;
    private boolean r;
    private final yj j = new yj();
    private byte[] l = aeu.f;
    private long q = -9223372036854775807L;

    public yo(yp ypVar, aad aadVar, Uri[] uriArr, cy[] cyVarArr, yg ygVar, adh adhVar, zi ziVar, List list) {
        this.a = ypVar;
        this.g = aadVar;
        this.e = uriArr;
        this.f = cyVarArr;
        this.d = ziVar;
        this.i = list;
        abx abxVarA = ygVar.a();
        this.b = abxVarA;
        if (adhVar != null) {
            abxVarA.b(adhVar);
        }
        this.c = ygVar.a();
        this.h = new vh(cyVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((cyVarArr[i].e & LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.p = new yn(this.h, aqd.m(arrayList));
    }

    private final vt o(Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] bArrB = this.j.b(uri);
        if (bArrB != null) {
            this.j.c(uri, bArrB);
            return null;
        }
        aca acaVar = new aca();
        acaVar.g(uri);
        acaVar.b(1);
        return new yk(this.c, acaVar.a(), this.f[i], this.p.b(), this.p.c(), this.l);
    }

    private static Uri p(zt ztVar, zs zsVar) {
        String str;
        if (zsVar == null || (str = zsVar.g) == null) {
            return null;
        }
        return atv.i(ztVar.p, str);
    }

    public final void a() throws IOException {
        IOException iOException = this.m;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.n;
        if (uri == null || !this.r) {
            return;
        }
        this.g.j(uri);
    }

    public final vh b() {
        return this.h;
    }

    public final void c(aba abaVar) {
        this.p = abaVar;
    }

    public final aba d() {
        return this.p;
    }

    public final void e() {
        this.m = null;
    }

    public final void f(boolean z) {
        this.k = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[PHI: r2
      0x005c: PHI (r2v2 long) = (r2v1 long), (r2v1 long), (r2v15 long) binds: [B:13:0x003e, B:15:0x0042, B:17:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(long r29, long r31, java.util.List<com.google.ads.interactivemedia.v3.internal.yq> r33, boolean r34, com.google.ads.interactivemedia.v3.internal.yl r35) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.yo.g(long, long, java.util.List, boolean, com.google.ads.interactivemedia.v3.internal.yl):void");
    }

    public final void h(vt vtVar) {
        if (vtVar instanceof yk) {
            yk ykVar = (yk) vtVar;
            this.l = ykVar.a();
            this.j.c(ykVar.d.a, (byte[]) ary.t(ykVar.e()));
        }
    }

    public final boolean i(vt vtVar, long j) {
        aba abaVar = this.p;
        return abaVar.s(abaVar.p(this.h.b(vtVar.f)), j);
    }

    public final boolean j(Uri uri, long j) {
        int iP;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.e;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(uri)) {
                break;
            }
            i++;
        }
        if (i == -1 || (iP = this.p.p(i)) == -1) {
            return true;
        }
        this.r = uri.equals(this.n) | this.r;
        return j == -9223372036854775807L || this.p.s(iP, j);
    }

    public final int l(long j, List<? extends wc> list) {
        return (this.m != null || this.p.l() < 2) ? list.size() : this.p.i(j, list);
    }

    public final boolean m(long j, vt vtVar, List<? extends wc> list) {
        if (this.m != null) {
            return false;
        }
        return this.p.u();
    }

    private final long n(yq yqVar, boolean z, zt ztVar, long j, long j2) {
        long jAl;
        long size;
        if (yqVar != null && !z) {
            return yqVar.j() ? yqVar.i() : yqVar.l;
        }
        long j3 = ztVar.n + j;
        if (yqVar != null && !this.o) {
            j2 = yqVar.i;
        }
        if (ztVar.j || j2 < j3) {
            List<zs> list = ztVar.m;
            Long lValueOf = Long.valueOf(j2 - j);
            boolean z2 = true;
            if (this.g.l() && yqVar != null) {
                z2 = false;
            }
            jAl = aeu.al(list, lValueOf, z2);
            size = ztVar.f;
        } else {
            jAl = ztVar.f;
            size = ztVar.m.size();
        }
        return jAl + size;
    }

    public final we[] k(yq yqVar, long j) {
        int iB = yqVar == null ? -1 : this.h.b(yqVar.f);
        int iL = this.p.l();
        we[] weVarArr = new we[iL];
        for (int i = 0; i < iL; i++) {
            int iN = this.p.n(i);
            Uri uri = this.e[iN];
            if (this.g.h(uri)) {
                zt ztVarF = this.g.f(uri, false);
                ary.t(ztVarF);
                long jN = n(yqVar, iN != iB, ztVarF, ztVarF.c - this.g.g(), j);
                long j2 = ztVarF.f;
                if (jN < j2) {
                    weVarArr[i] = we.a;
                } else {
                    weVarArr[i] = new ym(ztVarF, (int) (jN - j2));
                }
            } else {
                weVarArr[i] = we.a;
            }
        }
        return weVarArr;
    }
}
