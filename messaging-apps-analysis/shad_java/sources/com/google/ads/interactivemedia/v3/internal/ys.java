package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ys implements ui {
    private yp a;
    private zx b;
    private zy c;
    private int d;
    private List<sr> e;
    private final yg f;
    private acj g;
    private final acs h;
    private aqd i;

    public ys(yg ygVar) {
        ary.t(ygVar);
        this.f = ygVar;
        this.h = new acs();
        this.b = new zk();
        this.c = zn.a;
        this.a = yp.a;
        int i = yt.a;
        yp ypVar = null;
        if (aeu.a >= 30) {
            try {
                ypVar = (yp) Class.forName("com.google.ads.interactivemedia.v3.exoplayer2.source.MediaParserHlsMediaChunkExtractor").getDeclaredField("FACTORY").get(null);
            } catch (Exception unused) {
            }
        }
        if (ypVar != null) {
            this.a = ypVar;
        }
        this.g = new acj();
        this.i = new aqd();
        this.d = 1;
        this.e = Collections.emptyList();
    }

    @Deprecated
    public final yt a(Uri uri) {
        db dbVar = new db();
        dbVar.h(uri);
        dbVar.f("application/x-mpegURL");
        dg dgVarA = dbVar.a();
        ary.t(dgVarA.b);
        zx zoVar = this.b;
        List<sr> list = dgVarA.b.d.isEmpty() ? this.e : dgVarA.b.d;
        if (!list.isEmpty()) {
            zoVar = new zo(zoVar, list);
        }
        df dfVar = dgVarA.b;
        Object obj = dfVar.h;
        if (dfVar.d.isEmpty() && !list.isEmpty()) {
            db dbVarA = dgVarA.a();
            dbVarA.g(list);
            dgVarA = dbVarA.a();
        }
        dg dgVar = dgVarA;
        yg ygVar = this.f;
        yp ypVar = this.a;
        aqd aqdVar = this.i;
        jh jhVarB = acs.b(dgVar);
        acj acjVar = this.g;
        return new yt(dgVar, ygVar, ypVar, aqdVar, jhVarB, acjVar, new zn(this.f, acjVar, zoVar), this.d, null, null, null);
    }
}
