package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class js {
    protected final jm a;
    protected final jr b;
    protected jo c;
    private final int d;

    protected js(jp jpVar, jr jrVar, long j, long j2, long j3, long j4, long j5, int i) {
        this.b = jrVar;
        this.d = i;
        this.a = new jm(jpVar, j, j2, j3, j4, j5);
    }

    protected static final int f(jv jvVar, long j, kl klVar) {
        if (j == jvVar.l()) {
            return 0;
        }
        klVar.a = j;
        return 1;
    }

    protected static final boolean g(jv jvVar, long j) throws IOException {
        long jL = j - jvVar.l();
        if (jL < 0 || jL > 262144) {
            return false;
        }
        jvVar.d((int) jL);
        return true;
    }

    public final ko a() {
        return this.a;
    }

    public final void b(long j) {
        jo joVar = this.c;
        if (joVar == null || joVar.a != j) {
            this.c = new jo(j, this.a.d(j), 0L, this.a.c, this.a.d, this.a.e, this.a.f);
        }
    }

    public final boolean c() {
        return this.c != null;
    }

    public final int d(jv jvVar, kl klVar) throws IOException {
        while (true) {
            jo joVar = this.c;
            ary.s(joVar);
            long j = joVar.f;
            long j2 = joVar.g;
            long j3 = joVar.h;
            if (j2 - j <= this.d) {
                e();
                return f(jvVar, j, klVar);
            }
            if (!g(jvVar, j3)) {
                return f(jvVar, j3, klVar);
            }
            jvVar.j();
            jq jqVarB = this.b.b(jvVar, joVar.b);
            int i = jqVarB.b;
            if (i == -3) {
                e();
                return f(jvVar, j3, klVar);
            }
            if (i == -2) {
                jo.h(joVar, jqVarB.c, jqVarB.d);
            } else {
                if (i != -1) {
                    g(jvVar, jqVarB.d);
                    long unused = jqVarB.d;
                    e();
                    return f(jvVar, jqVarB.d, klVar);
                }
                jo.g(joVar, jqVarB.c, jqVarB.d);
            }
        }
    }

    protected final void e() {
        this.c = null;
        this.b.a();
    }
}
