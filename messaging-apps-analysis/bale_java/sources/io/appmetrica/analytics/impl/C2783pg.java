package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* renamed from: io.appmetrica.analytics.impl.pg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2783pg extends AbstractC2568gg {
    public final F8 b;

    public C2783pg(C2484d5 c2484d5) {
        this(c2484d5, c2484d5.i());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        X9 x9;
        if (!TextUtils.isEmpty(q5.getName())) {
            F8 f8 = this.b;
            String name = q5.getName();
            if (f8.c == null) {
                f8.a();
            }
            int iHashCode = name.hashCode();
            if (f8.c.b.contains(Integer.valueOf(iHashCode))) {
                x9 = X9.NON_FIRST_OCCURENCE;
            } else {
                H8 h8 = f8.c;
                X9 x92 = h8.a ? X9.FIRST_OCCURRENCE : X9.UNKNOWN;
                if (h8.d < 1000) {
                    h8.b.add(Integer.valueOf(iHashCode));
                    h8.d++;
                } else {
                    h8.a = false;
                }
                K8 k8 = f8.b;
                H8 h82 = f8.c;
                IBinaryDataHelper iBinaryDataHelper = k8.c;
                J8 j8 = k8.b;
                k8.a.getClass();
                C2728n9 c2728n9A = I8.a(h82);
                j8.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(c2728n9A));
                x9 = x92;
            }
            q5.k = x9;
        }
        return false;
    }

    public C2783pg(C2484d5 c2484d5, F8 f8) {
        super(c2484d5);
        this.b = f8;
    }
}
