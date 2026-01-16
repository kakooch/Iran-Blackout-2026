package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apy {
    private final String a;
    private final apx b;
    private apx c;

    /* synthetic */ apy(String str) {
        apx apxVar = new apx(null);
        this.b = apxVar;
        this.c = apxVar;
        aqd.j(str);
        this.a = str;
    }

    public final apy a(Object obj) {
        apx apxVar = new apx(null);
        this.c.b = apxVar;
        this.c = apxVar;
        apxVar.a = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        apx apxVar = this.b.b;
        String str = BuildConfig.FLAVOR;
        while (apxVar != null) {
            Object obj = apxVar.a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            apxVar = apxVar.b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
