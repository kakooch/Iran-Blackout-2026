package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import ir.nasim.C4982Hj7;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.common.api.internal.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2068l {
    private final Map a = Collections.synchronizedMap(new WeakHashMap());
    private final Map b = Collections.synchronizedMap(new WeakHashMap());

    private final void h(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.a) {
            map = new HashMap(this.a);
        }
        synchronized (this.b) {
            map2 = new HashMap(this.b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C4982Hj7) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    final void c(BasePendingResult basePendingResult, boolean z) {
        this.a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.addStatusListener(new C2066j(this, basePendingResult));
    }

    final void d(C4982Hj7 c4982Hj7, boolean z) {
        this.b.put(c4982Hj7, Boolean.valueOf(z));
        c4982Hj7.a().b(new C2067k(this, c4982Hj7));
    }

    final void e(int i, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, C2059c.r);
    }

    final boolean g() {
        return (this.a.isEmpty() && this.b.isEmpty()) ? false : true;
    }
}
