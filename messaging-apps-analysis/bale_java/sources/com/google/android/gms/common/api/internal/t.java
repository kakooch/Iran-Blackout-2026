package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import ir.nasim.C9205Yy;
import ir.nasim.DG4;
import ir.nasim.We8;

/* loaded from: classes3.dex */
final class t {
    private final C9205Yy a;
    private final Feature b;

    /* synthetic */ t(C9205Yy c9205Yy, Feature feature, We8 we8) {
        this.a = c9205Yy;
        this.b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof t)) {
            t tVar = (t) obj;
            if (DG4.a(this.a, tVar.a) && DG4.a(this.b, tVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return DG4.b(this.a, this.b);
    }

    public final String toString() {
        return DG4.c(this).a("key", this.a).a("feature", this.b).toString();
    }
}
