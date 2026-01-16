package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class km {
    public final kp a;
    public final kp b;

    public km(kp kpVar, kp kpVar2) {
        this.a = kpVar;
        this.b = kpVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && km.class == obj.getClass()) {
            km kmVar = (km) obj;
            if (this.a.equals(kmVar.a) && this.b.equals(kmVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        String string;
        String strValueOf = String.valueOf(this.a);
        if (this.a.equals(this.b)) {
            string = BuildConfig.FLAVOR;
        } else {
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf2.length() + 2);
            sb.append(", ");
            sb.append(strValueOf2);
            string = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 2 + String.valueOf(string).length());
        sb2.append("[");
        sb2.append(strValueOf);
        sb2.append(string);
        sb2.append("]");
        return sb2.toString();
    }
}
