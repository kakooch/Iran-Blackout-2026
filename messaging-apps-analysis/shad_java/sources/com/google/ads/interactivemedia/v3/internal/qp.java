package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qp {
    public final String a;
    public final boolean b;
    public final boolean c;

    public qp(String str, boolean z, boolean z2) {
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == qp.class) {
            qp qpVar = (qp) obj;
            if (TextUtils.equals(this.a, qpVar.a) && this.b == qpVar.b && this.c == qpVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() + 31) * 31) + (true != this.b ? 1237 : 1231)) * 31) + (true == this.c ? 1231 : 1237);
    }
}
