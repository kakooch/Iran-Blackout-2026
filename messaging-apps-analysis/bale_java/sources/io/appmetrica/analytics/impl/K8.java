package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;

/* loaded from: classes3.dex */
public final class K8 {
    public final I8 a;
    public final J8 b;
    public final IBinaryDataHelper c;

    public K8(Context context, W4 w4) {
        this(new J8(), new I8(), W6.a(context).a(w4));
    }

    public K8(J8 j8, I8 i8, IBinaryDataHelper iBinaryDataHelper) {
        this.b = j8;
        this.a = i8;
        this.c = iBinaryDataHelper;
    }
}
