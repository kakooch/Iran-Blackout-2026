package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class wj implements tv, vc, vw {
    private static final Pattern b = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern c = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    final int a;
    private final adh d;
    private final jh e;
    private final long f;
    private final adb g;
    private final vj h;
    private final wi[] i;
    private final xh j;
    private final ug l;
    private final je m;
    private tu n;
    private xj r;
    private int s;
    private List<xn> t;
    private final wz u;
    private final acj v;
    private final acc w;
    private final aqd x;
    private vx<wg>[] o = new vx[0];
    private xd[] p = new xd[0];
    private final IdentityHashMap<vx<wg>, xg> k = new IdentityHashMap<>();
    private vd q = aqd.t(this.o);

    public wj(int i, xj xjVar, int i2, wz wzVar, adh adhVar, jh jhVar, je jeVar, acj acjVar, ug ugVar, long j, adb adbVar, acc accVar, aqd aqdVar, xf xfVar, byte[] bArr, byte[] bArr2, byte[] bArr3) throws NumberFormatException {
        List<xi> list;
        int i3;
        int i4;
        boolean[] zArr;
        cy[] cyVarArrU;
        xm xmVarT;
        jh jhVar2 = jhVar;
        this.a = i;
        this.r = xjVar;
        this.s = i2;
        this.u = wzVar;
        this.d = adhVar;
        this.e = jhVar2;
        this.m = jeVar;
        this.v = acjVar;
        this.l = ugVar;
        this.f = j;
        this.g = adbVar;
        this.w = accVar;
        this.x = aqdVar;
        this.j = new xh(xjVar, xfVar, accVar);
        int i5 = 0;
        xo xoVarC = xjVar.c(i2);
        List<xn> list2 = xoVarC.d;
        this.t = list2;
        List<xi> list3 = xoVarC.c;
        int size = list3.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i6 = 0; i6 < size; i6++) {
            sparseIntArray.put(list3.get(i6).a, i6);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i6));
            arrayList.add(arrayList2);
            sparseArray.put(i6, arrayList2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            xi xiVar = list3.get(i7);
            xm xmVarS = s(xiVar.e);
            xmVarS = xmVarS == null ? s(xiVar.f) : xmVarS;
            int iMin = (xmVarS == null || (iMin = sparseIntArray.get(Integer.parseInt(xmVarS.b), -1)) == -1) ? i7 : iMin;
            if (iMin == i7 && (xmVarT = t(xiVar.f, "urn:mpeg:dash:adaptation-set-switching:2016")) != null) {
                for (String str : aeu.z(xmVarT.b, ",")) {
                    int i8 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i8 != -1) {
                        iMin = Math.min(iMin, i8);
                    }
                }
            }
            if (iMin != i7) {
                List list4 = (List) sparseArray.get(i7);
                List list5 = (List) sparseArray.get(iMin);
                list5.addAll(list4);
                sparseArray.put(i7, list5);
                arrayList.remove(list4);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i9 = 0; i9 < size2; i9++) {
            int[] iArrM = aqd.m((Collection) arrayList.get(i9));
            iArr[i9] = iArrM;
            Arrays.sort(iArrM);
        }
        boolean[] zArr2 = new boolean[size2];
        cy[][] cyVarArr = new cy[size2][];
        int i10 = 0;
        int i11 = 0;
        while (i10 < size2) {
            int[] iArr2 = iArr[i10];
            int length = iArr2.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                List<xt> list6 = list3.get(iArr2[i12]).c;
                while (i5 < list6.size()) {
                    if (!list6.get(i5).e.isEmpty()) {
                        zArr2[i10] = true;
                        i11++;
                        break;
                    }
                    i5++;
                }
                i12++;
                i5 = 0;
            }
            int[] iArr3 = iArr[i10];
            int length2 = iArr3.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    cyVarArrU = new cy[0];
                    break;
                }
                int i14 = iArr3[i13];
                xi xiVar2 = list3.get(i14);
                List<xm> list7 = list3.get(i14).d;
                int[] iArr4 = iArr3;
                int i15 = 0;
                while (i15 < list7.size()) {
                    xm xmVar = list7.get(i15);
                    int i16 = length2;
                    List<xm> list8 = list7;
                    if ("urn:scte:dash:cc:cea-608:2015".equals(xmVar.a)) {
                        cx cxVar = new cx();
                        cxVar.ae("application/cea-608");
                        int i17 = xiVar2.a;
                        StringBuilder sb = new StringBuilder(18);
                        sb.append(i17);
                        sb.append(":cea608");
                        cxVar.S(sb.toString());
                        cyVarArrU = u(xmVar, b, cxVar.a());
                        break;
                    }
                    if ("urn:scte:dash:cc:cea-708:2015".equals(xmVar.a)) {
                        cx cxVar2 = new cx();
                        cxVar2.ae("application/cea-708");
                        int i18 = xiVar2.a;
                        StringBuilder sb2 = new StringBuilder(18);
                        sb2.append(i18);
                        sb2.append(":cea708");
                        cxVar2.S(sb2.toString());
                        cyVarArrU = u(xmVar, c, cxVar2.a());
                        break;
                    }
                    i15++;
                    length2 = i16;
                    list7 = list8;
                }
                i13++;
                iArr3 = iArr4;
            }
            cyVarArr[i10] = cyVarArrU;
            if (cyVarArrU.length != 0) {
                i11++;
            }
            i10++;
            i5 = 0;
        }
        int size3 = i11 + size2 + list2.size();
        vh[] vhVarArr = new vh[size3];
        wi[] wiVarArr = new wi[size3];
        int i19 = 0;
        int i20 = 0;
        while (i19 < size2) {
            int[] iArr5 = iArr[i19];
            ArrayList arrayList3 = new ArrayList();
            int length3 = iArr5.length;
            int i21 = size2;
            int i22 = 0;
            while (i22 < length3) {
                arrayList3.addAll(list3.get(iArr5[i22]).c);
                i22++;
                iArr = iArr;
            }
            int[][] iArr6 = iArr;
            int size4 = arrayList3.size();
            cy[] cyVarArr2 = new cy[size4];
            int i23 = 0;
            while (i23 < size4) {
                int i24 = size4;
                cy cyVar = ((xt) arrayList3.get(i23)).b;
                cyVarArr2[i23] = cyVar.c(jhVar2.a(cyVar));
                i23++;
                size4 = i24;
                arrayList3 = arrayList3;
            }
            xi xiVar3 = list3.get(iArr5[0]);
            int i25 = i20 + 1;
            if (zArr2[i19]) {
                list = list3;
                i3 = i25;
                i25++;
            } else {
                list = list3;
                i3 = -1;
            }
            if (cyVarArr[i19].length != 0) {
                int i26 = i25;
                i25++;
                i4 = i26;
            } else {
                i4 = -1;
            }
            vhVarArr[i20] = new vh(cyVarArr2);
            wiVarArr[i20] = wi.a(xiVar3.b, iArr5, i20, i3, i4);
            int i27 = -1;
            if (i3 != -1) {
                cx cxVar3 = new cx();
                int i28 = xiVar3.a;
                zArr = zArr2;
                StringBuilder sb3 = new StringBuilder(16);
                sb3.append(i28);
                sb3.append(":emsg");
                cxVar3.S(sb3.toString());
                cxVar3.ae("application/x-emsg");
                vhVarArr[i3] = new vh(cxVar3.a());
                wiVarArr[i3] = wi.b(iArr5, i20);
                i27 = -1;
            } else {
                zArr = zArr2;
            }
            if (i4 != i27) {
                vhVarArr[i4] = new vh(cyVarArr[i19]);
                wiVarArr[i4] = wi.c(iArr5, i20);
            }
            i19++;
            size2 = i21;
            iArr = iArr6;
            jhVar2 = jhVar;
            zArr2 = zArr;
            i20 = i25;
            list3 = list;
        }
        int i29 = 0;
        while (i29 < list2.size()) {
            xn xnVar = list2.get(i29);
            cx cxVar4 = new cx();
            cxVar4.S(xnVar.a());
            cxVar4.ae("application/x-emsg");
            vhVarArr[i20] = new vh(cxVar4.a());
            wiVarArr[i20] = wi.d(i29);
            i29++;
            i20++;
        }
        Pair pairCreate = Pair.create(new vj(vhVarArr), wiVarArr);
        this.h = (vj) pairCreate.first;
        this.i = (wi[]) pairCreate.second;
    }

    private final int r(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.i[i2].e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.i[i5].c == 0) {
                return i4;
            }
        }
        return -1;
    }

    private static xm s(List<xm> list) {
        return t(list, "http://dashif.org/guidelines/trickmode");
    }

    private static xm t(List<xm> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            xm xmVar = list.get(i);
            if (str.equals(xmVar.a)) {
                return xmVar;
            }
        }
        return null;
    }

    private static cy[] u(xm xmVar, Pattern pattern, cy cyVar) throws NumberFormatException {
        String str = xmVar.b;
        if (str == null) {
            return new cy[]{cyVar};
        }
        String[] strArrZ = aeu.z(str, ";");
        cy[] cyVarArr = new cy[strArrZ.length];
        for (int i = 0; i < strArrZ.length; i++) {
            Matcher matcher = pattern.matcher(strArrZ[i]);
            if (!matcher.matches()) {
                return new cy[]{cyVar};
            }
            int i2 = Integer.parseInt(matcher.group(1));
            cx cxVarA = cyVar.a();
            String str2 = cyVar.a;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 12);
            sb.append(str2);
            sb.append(":");
            sb.append(i2);
            cxVarA.S(sb.toString());
            cxVarA.F(i2);
            cxVarA.V(matcher.group(2));
            cyVarArr[i] = cxVarA.a();
        }
        return cyVarArr;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void a(tu tuVar, long j) {
        this.n = tuVar;
        tuVar.k(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void b() throws IOException {
        this.g.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final vj c() {
        return this.h;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.ads.interactivemedia.v3.internal.vy, com.google.ads.interactivemedia.v3.internal.wg] */
    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long d(aba[] abaVarArr, boolean[] zArr, vb[] vbVarArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        int[] iArr;
        int i2;
        int[] iArr2;
        vb[] vbVarArr2;
        vh vhVarA;
        int i3;
        vh vhVarA2;
        int i4;
        aba[] abaVarArr2 = abaVarArr;
        vb[] vbVarArr3 = vbVarArr;
        int[] iArr3 = new int[abaVarArr2.length];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = -1;
            if (i6 >= abaVarArr2.length) {
                break;
            }
            aba abaVar = abaVarArr2[i6];
            if (abaVar != null) {
                iArr3[i6] = this.h.b(abaVar.k());
            } else {
                iArr3[i6] = -1;
            }
            i6++;
        }
        for (int i7 = 0; i7 < abaVarArr2.length; i7++) {
            if (abaVarArr2[i7] == null || !zArr[i7]) {
                vb vbVar = vbVarArr3[i7];
                if (vbVar instanceof vx) {
                    ((vx) vbVar).p(this);
                } else if (vbVar instanceof vv) {
                    ((vv) vbVar).a();
                }
                vbVarArr3[i7] = null;
            }
        }
        int i8 = 0;
        while (true) {
            z = true;
            if (i8 >= abaVarArr2.length) {
                break;
            }
            vb vbVar2 = vbVarArr3[i8];
            if ((vbVar2 instanceof tk) || (vbVar2 instanceof vv)) {
                int iR = r(i8, iArr3);
                if (iR == -1) {
                    z = vbVarArr3[i8] instanceof tk;
                } else {
                    vb vbVar3 = vbVarArr3[i8];
                    if (!(vbVar3 instanceof vv) || ((vv) vbVar3).a != vbVarArr3[iR]) {
                        z = false;
                    }
                }
                if (!z) {
                    vb vbVar4 = vbVarArr3[i8];
                    if (vbVar4 instanceof vv) {
                        ((vv) vbVar4).a();
                    }
                    vbVarArr3[i8] = null;
                }
            }
            i8++;
        }
        int i9 = 0;
        while (i9 < abaVarArr2.length) {
            aba abaVar2 = abaVarArr2[i9];
            if (abaVar2 == null) {
                i2 = i9;
                iArr2 = iArr3;
                vbVarArr2 = vbVarArr3;
            } else {
                vb vbVar5 = vbVarArr3[i9];
                if (vbVar5 == null) {
                    zArr2[i9] = z;
                    wi wiVar = this.i[iArr3[i9]];
                    int i10 = wiVar.c;
                    if (i10 == 0) {
                        int i11 = wiVar.f;
                        boolean z2 = i11 != i;
                        if (z2) {
                            vhVarA = this.h.a(i11);
                            i3 = 1;
                        } else {
                            vhVarA = null;
                            i3 = 0;
                        }
                        int i12 = wiVar.g;
                        if (i12 != i) {
                            vhVarA2 = this.h.a(i12);
                            i3 += vhVarA2.a;
                        } else {
                            vhVarA2 = null;
                        }
                        cy[] cyVarArr = new cy[i3];
                        int[] iArr4 = new int[i3];
                        if (z2) {
                            cyVarArr[i5] = vhVarA.a(i5);
                            iArr4[i5] = 4;
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        if (i12 != i) {
                            for (int i13 = 0; i13 < vhVarA2.a; i13++) {
                                cy cyVarA = vhVarA2.a(i13);
                                cyVarArr[i4] = cyVarA;
                                iArr4[i4] = 3;
                                arrayList.add(cyVarA);
                                i4++;
                            }
                        }
                        xg xgVarE = (this.r.d && z2) ? this.j.e() : null;
                        xg xgVar = xgVarE;
                        i2 = i9;
                        iArr2 = iArr3;
                        vx<wg> vxVar = new vx<>(wiVar.b, iArr4, cyVarArr, this.u.a(this.g, this.r, this.s, wiVar.a, abaVar2, wiVar.b, this.f, z2, arrayList, xgVarE, this.d), this, this.w, j, this.e, this.m, this.v, this.l);
                        synchronized (this) {
                            this.k.put(vxVar, xgVar);
                        }
                        vbVarArr2 = vbVarArr;
                        vbVarArr2[i2] = vxVar;
                    } else {
                        i2 = i9;
                        iArr2 = iArr3;
                        vbVarArr2 = vbVarArr3;
                        if (i10 == 2) {
                            vbVarArr2[i2] = new xd(this.t.get(wiVar.d), abaVar2.k().a(0), this.r.d);
                        }
                    }
                } else {
                    i2 = i9;
                    iArr2 = iArr3;
                    vbVarArr2 = vbVarArr3;
                    if (vbVar5 instanceof vx) {
                        ((vx) vbVar5).i().j(abaVar2);
                    }
                }
                i9 = i2 + 1;
                abaVarArr2 = abaVarArr;
                vbVarArr3 = vbVarArr2;
                iArr3 = iArr2;
                i = -1;
                z = true;
                i5 = 0;
            }
            i9 = i2 + 1;
            abaVarArr2 = abaVarArr;
            vbVarArr3 = vbVarArr2;
            iArr3 = iArr2;
            i = -1;
            z = true;
            i5 = 0;
        }
        int[] iArr5 = iArr3;
        vb[] vbVarArr4 = vbVarArr3;
        int i14 = 0;
        while (i14 < abaVarArr.length) {
            if (vbVarArr4[i14] != null || abaVarArr[i14] == null) {
                iArr = iArr5;
            } else {
                iArr = iArr5;
                wi wiVar2 = this.i[iArr[i14]];
                if (wiVar2.c == 1) {
                    int iR2 = r(i14, iArr);
                    if (iR2 == -1) {
                        vbVarArr4[i14] = new tk();
                    } else {
                        vbVarArr4[i14] = ((vx) vbVarArr4[iR2]).g(j, wiVar2.b);
                    }
                    i14++;
                    iArr5 = iArr;
                }
            }
            i14++;
            iArr5 = iArr;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (vb vbVar6 : vbVarArr4) {
            if (vbVar6 instanceof vx) {
                arrayList2.add((vx) vbVar6);
            } else if (vbVar6 instanceof xd) {
                arrayList3.add((xd) vbVar6);
            }
        }
        vx<wg>[] vxVarArr = new vx[arrayList2.size()];
        this.o = vxVarArr;
        arrayList2.toArray(vxVarArr);
        xd[] xdVarArr = new xd[arrayList3.size()];
        this.p = xdVarArr;
        arrayList3.toArray(xdVarArr);
        this.q = aqd.t(this.o);
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void e(long j, boolean z) {
        for (vx<wg> vxVar : this.o) {
            vxVar.a(j, false);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
        this.q.f(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long g() {
        return -9223372036854775807L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        return this.q.h();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long i(long j) {
        for (vx<wg> vxVar : this.o) {
            vxVar.k(j);
        }
        for (xd xdVar : this.p) {
            xdVar.g(j);
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long j(long j, eg egVar) {
        for (vx<wg> vxVar : this.o) {
            if (vxVar.a == 2) {
                return vxVar.j(j, egVar);
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vw
    public final synchronized void k(vx<wg> vxVar) {
        xg xgVarRemove = this.k.remove(vxVar);
        if (xgVarRemove != null) {
            xgVarRemove.g();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        return this.q.l();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vc
    public final /* bridge */ /* synthetic */ void m(vd vdVar) {
        this.n.m(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        return this.q.n(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        return this.q.o();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.ads.interactivemedia.v3.internal.vy, com.google.ads.interactivemedia.v3.internal.wg] */
    public final void p(xj xjVar, int i) {
        this.r = xjVar;
        this.s = i;
        this.j.a(xjVar);
        vx<wg>[] vxVarArr = this.o;
        if (vxVarArr != null) {
            for (vx<wg> vxVar : vxVarArr) {
                vxVar.i().i(xjVar, i);
            }
            this.n.m(this);
        }
        this.t = xjVar.c(i).d;
        for (xd xdVar : this.p) {
            Iterator<xn> it = this.t.iterator();
            while (true) {
                if (it.hasNext()) {
                    xn next = it.next();
                    if (next.a().equals(xdVar.a())) {
                        xdVar.f(next, xjVar.d && i == xjVar.b() + (-1));
                    }
                }
            }
        }
    }

    public final void q() {
        this.j.f();
        for (vx<wg> vxVar : this.o) {
            vxVar.p(this);
        }
        this.n = null;
    }
}
