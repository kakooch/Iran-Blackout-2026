package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC18350oW3;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class S0 extends T0 {
    S0(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.vision.T0
    public final void f() {
        if (!j()) {
            if (k() > 0) {
                AbstractC18350oW3.a(i(0).getKey());
                throw null;
            }
            Iterator it = o().iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(((Map.Entry) it.next()).getKey());
                throw null;
            }
        }
        super.f();
    }
}
