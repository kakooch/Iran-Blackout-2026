package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.measurement.u0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2148u0 implements Comparator {
    C2148u0() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        A0 a0 = (A0) obj;
        A0 a02 = (A0) obj2;
        C2146t0 c2146t0 = new C2146t0(a0);
        C2146t0 c2146t02 = new C2146t0(a02);
        while (c2146t0.hasNext() && c2146t02.hasNext()) {
            int iCompareTo = Integer.valueOf(c2146t0.zza() & 255).compareTo(Integer.valueOf(c2146t02.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(a0.r()).compareTo(Integer.valueOf(a02.r()));
    }
}
