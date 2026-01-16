package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class acg implements abx {
    private final Context a;
    private final List<adh> b;
    private final abx c;
    private abx d;
    private abx e;
    private abx f;
    private abx g;
    private abx h;
    private abx i;
    private abx j;
    private abx k;

    public acg(Context context, abx abxVar) {
        this.a = context.getApplicationContext();
        ary.t(abxVar);
        this.c = abxVar;
        this.b = new ArrayList();
    }

    private final abx g() {
        if (this.e == null) {
            abl ablVar = new abl(this.a);
            this.e = ablVar;
            h(ablVar);
        }
        return this.e;
    }

    private final void h(abx abxVar) {
        for (int i = 0; i < this.b.size(); i++) {
            abxVar.b(this.b.get(i));
        }
    }

    private static final void i(abx abxVar, adh adhVar) {
        if (abxVar != null) {
            abxVar.b(adhVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        abx abxVar = this.k;
        ary.t(abxVar);
        return abxVar.a(bArr, i, i2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void b(adh adhVar) {
        ary.t(adhVar);
        this.c.b(adhVar);
        this.b.add(adhVar);
        i(this.d, adhVar);
        i(this.e, adhVar);
        i(this.f, adhVar);
        i(this.g, adhVar);
        i(this.h, adhVar);
        i(this.i, adhVar);
        i(this.j, adhVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws IOException {
        abx abxVar;
        ary.q(this.k == null);
        String scheme = acbVar.a.getScheme();
        if (aeu.b(acbVar.a)) {
            String path = acbVar.a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.d == null) {
                    acl aclVar = new acl();
                    this.d = aclVar;
                    h(aclVar);
                }
                this.k = this.d;
            } else {
                this.k = g();
            }
        } else if ("asset".equals(scheme)) {
            this.k = g();
        } else if ("content".equals(scheme)) {
            if (this.f == null) {
                abt abtVar = new abt(this.a);
                this.f = abtVar;
                h(abtVar);
            }
            this.k = this.f;
        } else if ("rtmp".equals(scheme)) {
            if (this.g == null) {
                try {
                    abx abxVar2 = (abx) Class.forName("com.google.ads.interactivemedia.v3.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.g = abxVar2;
                    h(abxVar2);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.g == null) {
                    this.g = this.c;
                }
            }
            this.k = this.g;
        } else if ("udp".equals(scheme)) {
            if (this.h == null) {
                adj adjVar = new adj();
                this.h = adjVar;
                h(adjVar);
            }
            this.k = this.h;
        } else if ("data".equals(scheme)) {
            if (this.i == null) {
                abv abvVar = new abv();
                this.i = abvVar;
                h(abvVar);
            }
            this.k = this.i;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.j == null) {
                    adf adfVar = new adf(this.a);
                    this.j = adfVar;
                    h(adfVar);
                }
                abxVar = this.j;
            } else {
                abxVar = this.c;
            }
            this.k = abxVar;
        }
        return this.k.c(acbVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        abx abxVar = this.k;
        if (abxVar == null) {
            return null;
        }
        return abxVar.d();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Map<String, List<String>> e() {
        abx abxVar = this.k;
        return abxVar == null ? Collections.emptyMap() : abxVar.e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws IOException {
        abx abxVar = this.k;
        if (abxVar != null) {
            try {
                abxVar.f();
            } finally {
                this.k = null;
            }
        }
    }
}
