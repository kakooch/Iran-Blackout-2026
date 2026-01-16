package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class db {
    private String a;
    private Uri b;
    private String c;
    private final long d;
    private List<sr> e;
    private List f;
    private dh g;
    private long h;
    private float i;
    private float j;

    public db() {
        this.d = Long.MIN_VALUE;
        Collections.emptyList();
        Collections.emptyMap();
        this.e = Collections.emptyList();
        this.f = Collections.emptyList();
        this.h = -9223372036854775807L;
        this.i = -3.4028235E38f;
        this.j = -3.4028235E38f;
    }

    /* synthetic */ db(dg dgVar) {
        this();
        this.d = Long.MIN_VALUE;
        this.a = dgVar.a;
        this.g = dgVar.d;
        de deVar = dgVar.c;
        this.h = deVar.b;
        this.i = deVar.c;
        this.j = deVar.d;
        df dfVar = dgVar.b;
        if (dfVar != null) {
            this.c = dfVar.b;
            this.b = dfVar.a;
            this.e = dfVar.d;
            this.f = dfVar.f;
        }
    }

    public final dg a() {
        df dfVar;
        ary.q(true);
        Uri uri = this.b;
        if (uri != null) {
            dfVar = new df(uri, this.c, null, this.e, this.f);
            String string = this.a;
            if (string == null) {
                string = this.b.toString();
            }
            this.a = string;
        } else {
            dfVar = null;
        }
        df dfVar2 = dfVar;
        String str = this.a;
        ary.t(str);
        dc dcVar = new dc(Long.MIN_VALUE);
        de deVar = new de(this.h, this.i, this.j);
        dh dhVar = this.g;
        if (dhVar == null) {
            dhVar = new dh();
        }
        return new dg(str, dcVar, dfVar2, deVar, dhVar);
    }

    public final void b(float f) {
        this.j = f;
    }

    public final void c(float f) {
        this.i = f;
    }

    public final void d(long j) {
        this.h = j;
    }

    public final void e(String str) {
        this.a = str;
    }

    public final void f(String str) {
        this.c = str;
    }

    public final void g(List<sr> list) {
        this.e = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
    }

    public final void h(Uri uri) {
        this.b = uri;
    }
}
