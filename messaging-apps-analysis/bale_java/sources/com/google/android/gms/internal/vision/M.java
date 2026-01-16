package com.google.android.gms.internal.vision;

import ir.nasim.Jp8;
import java.util.Comparator;

/* loaded from: classes3.dex */
final class M implements Comparator {
    M() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        K k = (K) obj;
        K k2 = (K) obj2;
        Jp8 jp8 = (Jp8) k.iterator();
        Jp8 jp82 = (Jp8) k2.iterator();
        while (jp8.hasNext() && jp82.hasNext()) {
            int iCompare = Integer.compare(K.O(jp8.zza()), K.O(jp82.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(k.j(), k2.j());
    }
}
