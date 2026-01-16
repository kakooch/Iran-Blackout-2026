package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class su implements uj {
    private final kc a;
    private jy b;
    private jv c;

    public su(kc kcVar) {
        this.a = kcVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uj
    public final void a(abu abuVar, Uri uri, Map<String, List<String>> map, long j, long j2, ka kaVar) throws IOException {
        jv jvVar = new jv(abuVar, j, j2);
        this.c = jvVar;
        if (this.b != null) {
            return;
        }
        jy[] jyVarArrB = this.a.b(uri, map);
        int length = jyVarArrB.length;
        if (length == 1) {
            this.b = jyVarArrB[0];
        } else {
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                jy jyVar = jyVarArrB[i];
                try {
                } catch (EOFException unused) {
                    if (this.b != null || jvVar.l() == j) {
                    }
                } catch (Throwable th) {
                    ary.q(this.b != null || jvVar.l() == j);
                    jvVar.j();
                    throw th;
                }
                if (jyVar.g(jvVar)) {
                    this.b = jyVar;
                    ary.q(true);
                    jvVar.j();
                    break;
                } else {
                    boolean z = this.b != null || jvVar.l() == j;
                    ary.q(z);
                    jvVar.j();
                    i++;
                }
            }
            if (this.b == null) {
                String strS = aeu.S(jyVarArrB);
                StringBuilder sb = new StringBuilder(String.valueOf(strS).length() + 58);
                sb.append("None of the available extractors (");
                sb.append(strS);
                sb.append(") could read the stream.");
                String string = sb.toString();
                ary.t(uri);
                throw new vk(string);
            }
        }
        this.b.d(kaVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uj
    public final void b() {
        if (this.b != null) {
            this.b = null;
        }
        this.c = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uj
    public final void c() {
        jy jyVar = this.b;
        if (jyVar instanceof ly) {
            ((ly) jyVar).a();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uj
    public final long d() {
        jv jvVar = this.c;
        if (jvVar != null) {
            return jvVar.l();
        }
        return -1L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uj
    public final void e(long j, long j2) {
        jy jyVar = this.b;
        ary.t(jyVar);
        jyVar.e(j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uj
    public final int f(kl klVar) throws IOException {
        jy jyVar = this.b;
        ary.t(jyVar);
        jv jvVar = this.c;
        ary.t(jvVar);
        return jyVar.h(jvVar, klVar);
    }
}
