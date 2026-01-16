package com.google.ads.interactivemedia.v3.internal;

import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aan implements Comparable<aan> {
    public final boolean a;
    private final String b;
    private final aaq c;
    private final boolean d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;

    public aan(cy cyVar, aaq aaqVar, int i) {
        int i2;
        int iD;
        this.c = aaqVar;
        this.b = aaw.c(cyVar.c);
        int i3 = 0;
        this.d = aaw.b(i, false);
        int i4 = 0;
        while (true) {
            int size = aaqVar.A.size();
            i2 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            if (i4 >= size) {
                i4 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                iD = 0;
                break;
            } else {
                iD = aaw.d(cyVar, aaqVar.A.get(i4), false);
                if (iD > 0) {
                    break;
                } else {
                    i4++;
                }
            }
        }
        this.f = i4;
        this.e = iD;
        boolean z = true;
        this.i = 1 == (cyVar.d & 1);
        int i5 = cyVar.y;
        this.j = i5;
        this.k = cyVar.z;
        int i6 = cyVar.h;
        this.l = i6;
        if ((i6 != -1 && i6 > aaqVar.q) || (i5 != -1 && i5 > aaqVar.p)) {
            z = false;
        }
        this.a = z;
        String[] strArrAf = aeu.af();
        int i7 = 0;
        while (true) {
            if (i7 >= strArrAf.length) {
                break;
            }
            int iD2 = aaw.d(cyVar, strArrAf[i7], false);
            if (iD2 > 0) {
                i2 = i7;
                i3 = iD2;
                break;
            }
            i7++;
        }
        this.g = i2;
        this.h = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(aan aanVar) {
        asc ascVarA = (this.a && this.d) ? aaw.c : aaw.c.a();
        aqv aqvVarA = aqv.g().d(this.d, aanVar.d).a(Integer.valueOf(this.f), Integer.valueOf(aanVar.f), asc.b().a()).b(this.e, aanVar.e).d(this.a, aanVar.a).a(Integer.valueOf(this.l), Integer.valueOf(aanVar.l), this.c.v ? aaw.c.a() : aaw.d).d(this.i, aanVar.i).a(Integer.valueOf(this.g), Integer.valueOf(aanVar.g), asc.b().a()).b(this.h, aanVar.h).a(Integer.valueOf(this.j), Integer.valueOf(aanVar.j), ascVarA).a(Integer.valueOf(this.k), Integer.valueOf(aanVar.k), ascVarA);
        Integer numValueOf = Integer.valueOf(this.l);
        Integer numValueOf2 = Integer.valueOf(aanVar.l);
        if (!aeu.c(this.b, aanVar.b)) {
            ascVarA = aaw.d;
        }
        return aqvVarA.a(numValueOf, numValueOf2, ascVarA).e();
    }
}
