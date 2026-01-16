package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class df {
    public final Uri a;
    public final String b;
    public final List<sr> d;
    public final List f;
    public final dd c = null;
    public final String e = null;
    public final Uri g = null;
    public final Object h = null;

    /* synthetic */ df(Uri uri, String str, dd ddVar, List list, List list2) {
        this.a = uri;
        this.b = str;
        this.d = list;
        this.f = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof df)) {
            return false;
        }
        df dfVar = (df) obj;
        return this.a.equals(dfVar.a) && aeu.c(this.b, dfVar.b) && aeu.c(null, null) && this.d.equals(dfVar.d) && aeu.c(null, null) && this.f.equals(dfVar.f) && aeu.c(null, null) && aeu.c(null, null);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return (((((iHashCode + (str == null ? 0 : str.hashCode())) * 961) + this.d.hashCode()) * 961) + this.f.hashCode()) * 961;
    }
}
