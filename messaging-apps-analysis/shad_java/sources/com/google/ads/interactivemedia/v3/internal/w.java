package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class w {
    private static w a;
    private float b = 0.0f;
    private o c;
    private p d;
    private final ih e;
    private final asn f;

    public w(ih ihVar, asn asnVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.e = ihVar;
        this.f = asnVar;
    }

    public static w a() {
        if (a == null) {
            a = new w(new ih(), new asn(), null, null, null, null);
        }
        return a;
    }

    public final void b(Context context) {
        this.c = new o(new Handler(), context, new ek(), this, null, null);
    }

    public final void c() {
        r.a().g(this);
        r.a().c();
        if (r.a().e()) {
            aq.b().c();
        }
        this.c.a();
    }

    public final void d() {
        aq.b().d();
        r.a().d();
        this.c.b();
    }

    public final void e(float f) {
        this.b = f;
        if (this.d == null) {
            this.d = p.a();
        }
        Iterator<i> it = this.d.f().iterator();
        while (it.hasNext()) {
            it.next().h().j(f);
        }
    }

    public final float f() {
        return this.b;
    }
}
