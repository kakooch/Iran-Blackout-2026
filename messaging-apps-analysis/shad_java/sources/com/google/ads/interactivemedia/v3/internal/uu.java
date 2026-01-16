package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class uu implements ui {
    private final abw a;
    private final kc b;
    private final acs e = new acs();
    private final acj d = new acj();
    private final int c = 1048576;

    public uu(abw abwVar, kc kcVar) {
        this.a = abwVar;
        this.b = kcVar;
    }

    @Deprecated
    public final uv a(Uri uri) {
        db dbVar = new db();
        dbVar.h(uri);
        dg dgVarA = dbVar.a();
        ary.t(dgVarA.b);
        Object obj = dgVarA.b.h;
        return new uv(dgVarA, this.a, this.b, acs.b(dgVarA), this.d, 1048576);
    }
}
