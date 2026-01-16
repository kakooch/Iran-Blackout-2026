package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xj implements so<xj> {
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final yd i;
    public final ya j;
    public final Uri k;
    public final xp l;
    private final List<xo> m;

    public xj(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, xp xpVar, yd ydVar, ya yaVar, Uri uri, List<xo> list) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.l = xpVar;
        this.i = ydVar;
        this.k = uri;
        this.j = yaVar;
        this.m = list;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.so
    public final /* bridge */ /* synthetic */ xj a(List list) {
        xj xjVar = this;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new sr());
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (i < b()) {
            if (((sr) linkedList.peek()).a != i) {
                long jD = xjVar.d(i);
                if (jD != -9223372036854775807L) {
                    j += jD;
                }
            } else {
                xo xoVarC = xjVar.c(i);
                List<xi> list2 = xoVarC.c;
                sr srVar = (sr) linkedList.poll();
                int i2 = srVar.a;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i3 = srVar.b;
                    xi xiVar = list2.get(i3);
                    List<xt> list3 = xiVar.c;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add(list3.get(srVar.c));
                        srVar = (sr) linkedList.poll();
                        if (srVar.a != i2) {
                            break;
                        }
                    } while (srVar.b == i3);
                    List<xi> list4 = list2;
                    arrayList2.add(new xi(xiVar.a, xiVar.b, arrayList3, xiVar.d, xiVar.e, xiVar.f));
                    if (srVar.a != i2) {
                        break;
                    }
                    list2 = list4;
                }
                linkedList.addFirst(srVar);
                arrayList.add(new xo(xoVarC.a, xoVarC.b - j, arrayList2, xoVarC.d));
            }
            i++;
            xjVar = this;
        }
        long j2 = xjVar.b;
        return new xj(xjVar.a, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, xjVar.c, xjVar.d, xjVar.e, xjVar.f, xjVar.g, xjVar.h, xjVar.l, xjVar.i, xjVar.j, xjVar.k, arrayList);
    }

    public final int b() {
        return this.m.size();
    }

    public final xo c(int i) {
        return this.m.get(i);
    }

    public final long d(int i) {
        if (i != this.m.size() - 1) {
            return this.m.get(i + 1).b - this.m.get(i).b;
        }
        long j = this.b;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - this.m.get(i).b;
    }

    public final long e(int i) {
        return bi.b(d(i));
    }
}
