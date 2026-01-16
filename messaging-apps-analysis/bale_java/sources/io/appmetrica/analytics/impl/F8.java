package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* loaded from: classes3.dex */
public final class F8 {
    public final int a;
    public final K8 b;
    public H8 c;

    public F8(K8 k8, int i) {
        this.a = i;
        this.b = k8;
    }

    public final void a() {
        H8 h8;
        K8 k8 = this.b;
        k8.getClass();
        try {
            byte[] bArr = k8.c.get("event_hashes");
            if (bArr == null || bArr.length == 0) {
                I8 i8 = k8.a;
                k8.b.getClass();
                C2728n9 c2728n9 = new C2728n9();
                i8.getClass();
                h8 = new H8(c2728n9.a, c2728n9.b, c2728n9.c, CollectionUtils.hashSetFromIntArray(c2728n9.d));
            } else {
                I8 i82 = k8.a;
                C2728n9 state = k8.b.toState(bArr);
                i82.getClass();
                h8 = new H8(state.a, state.b, state.c, CollectionUtils.hashSetFromIntArray(state.d));
            }
        } catch (Throwable unused) {
            I8 i83 = k8.a;
            k8.b.getClass();
            C2728n9 c2728n92 = new C2728n9();
            i83.getClass();
            h8 = new H8(c2728n92.a, c2728n92.b, c2728n92.c, CollectionUtils.hashSetFromIntArray(c2728n92.d));
        }
        this.c = h8;
        int i = h8.c;
        int i2 = this.a;
        if (i != i2) {
            h8.c = i2;
            h8.d = 0;
            K8 k82 = this.b;
            IBinaryDataHelper iBinaryDataHelper = k82.c;
            J8 j8 = k82.b;
            k82.a.getClass();
            C2728n9 c2728n9A = I8.a(h8);
            j8.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(c2728n9A));
        }
    }
}
