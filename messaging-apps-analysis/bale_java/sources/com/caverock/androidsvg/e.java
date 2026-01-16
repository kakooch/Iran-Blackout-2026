package com.caverock.androidsvg;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public class e {
    public static final e c = new e(null, null);
    public static final e d = new e(a.none, null);
    public static final e e;
    public static final e f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;
    private a a;
    private b b;

    public enum a {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    public enum b {
        meet,
        slice
    }

    static {
        a aVar = a.xMidYMid;
        b bVar = b.meet;
        e = new e(aVar, bVar);
        a aVar2 = a.xMinYMin;
        f = new e(aVar2, bVar);
        g = new e(a.xMaxYMax, bVar);
        h = new e(a.xMidYMin, bVar);
        i = new e(a.xMidYMax, bVar);
        b bVar2 = b.slice;
        j = new e(aVar, bVar2);
        k = new e(aVar2, bVar2);
    }

    e(a aVar, b bVar) {
        this.a = aVar;
        this.b = bVar;
    }

    public a a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b;
    }

    public String toString() {
        return this.a + Separators.SP + this.b;
    }
}
