package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class wp implements ui {
    private final abw a;
    private long b;
    private long c;
    private List<sr> d;
    private final wz e;
    private acj f;
    private final acs g;
    private aqd h;

    public wp(wz wzVar, abw abwVar) {
        ary.t(wzVar);
        this.e = wzVar;
        this.a = abwVar;
        this.g = new acs();
        this.f = new acj();
        this.b = -9223372036854775807L;
        this.c = 30000L;
        this.h = new aqd();
        this.d = Collections.emptyList();
    }

    @Deprecated
    public final ww a(Uri uri) {
        db dbVar = new db();
        dbVar.h(uri);
        dbVar.f("application/dash+xml");
        dg dgVarA = dbVar.a();
        ary.t(dgVarA.b);
        adc xlVar = new xl();
        List<sr> list = dgVarA.b.d.isEmpty() ? this.d : dgVarA.b.d;
        adc spVar = !list.isEmpty() ? new sp(xlVar, list) : xlVar;
        df dfVar = dgVarA.b;
        Object obj = dfVar.h;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = dfVar.d.isEmpty() && !list.isEmpty();
        if (dgVarA.c.b == -9223372036854775807L && this.b != -9223372036854775807L) {
            z2 = true;
        }
        if (!z3) {
            if (z2) {
            }
            dg dgVar = dgVarA;
            return new ww(dgVar, this.a, spVar, this.e, this.h, acs.b(dgVar), this.f, this.c, null, null, null);
        }
        z = z2;
        db dbVarA = dgVarA.a();
        if (z3) {
            dbVarA.g(list);
        }
        if (z) {
            dbVarA.d(this.b);
        }
        dgVarA = dbVarA.a();
        dg dgVar2 = dgVarA;
        return new ww(dgVar2, this.a, spVar, this.e, this.h, acs.b(dgVar2), this.f, this.c, null, null, null);
    }
}
