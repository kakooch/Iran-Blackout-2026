package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aau implements Comparable<aau> {
    public final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;

    public aau(cy cyVar, aaq aaqVar, int i, String str) {
        int iD;
        boolean z = false;
        this.b = aaw.b(i, false);
        int i2 = cyVar.d & (aaqVar.E ^ (-1));
        this.c = 1 == (i2 & 1);
        this.d = (i2 & 2) != 0;
        arn<String> arnVarJ = aaqVar.B.isEmpty() ? arn.j(BuildConfig.FLAVOR) : aaqVar.B;
        int i3 = 0;
        while (true) {
            if (i3 >= arnVarJ.size()) {
                i3 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                iD = 0;
                break;
            } else {
                iD = aaw.d(cyVar, arnVarJ.get(i3), aaqVar.D);
                if (iD > 0) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.e = i3;
        this.f = iD;
        int iBitCount = Integer.bitCount(cyVar.e & aaqVar.C);
        this.g = iBitCount;
        this.i = (cyVar.e & 1088) != 0;
        int iD2 = aaw.d(cyVar, str, aaw.c(str) == null);
        this.h = iD2;
        if (iD > 0 || ((aaqVar.B.isEmpty() && iBitCount > 0) || this.c || (this.d && iD2 > 0))) {
            z = true;
        }
        this.a = z;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(aau aauVar) {
        aqv aqvVarB = aqv.g().d(this.b, aauVar.b).a(Integer.valueOf(this.e), Integer.valueOf(aauVar.e), asc.b().a()).b(this.f, aauVar.f).b(this.g, aauVar.g).d(this.c, aauVar.c).a(Boolean.valueOf(this.d), Boolean.valueOf(aauVar.d), this.f == 0 ? asc.b() : asc.b().a()).b(this.h, aauVar.h);
        if (this.g == 0) {
            aqvVarB = aqvVarB.c(this.i, aauVar.i);
        }
        return aqvVarB.e();
    }
}
