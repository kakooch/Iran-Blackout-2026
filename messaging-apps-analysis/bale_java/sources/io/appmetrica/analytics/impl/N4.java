package io.appmetrica.analytics.impl;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class N4 extends Pe {
    public final M4 a;

    public N4(I4 i4) {
        this.a = new M4(i4);
    }

    @Override // io.appmetrica.analytics.impl.Pe
    public final R8 a(int i) {
        ArrayList arrayList = new ArrayList();
        int iOrdinal = Ta.a(i).ordinal();
        if (iOrdinal == 12) {
            arrayList.add(this.a.a);
        } else if (iOrdinal == 14) {
            arrayList.add(this.a.b);
        } else if (iOrdinal == 34) {
            arrayList.add(this.a.c);
        }
        return new Q8(arrayList);
    }
}
