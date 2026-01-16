package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;

/* loaded from: classes3.dex */
public final class in implements Ea {
    @Override // io.appmetrica.analytics.impl.Ea
    public final String a(Context context) {
        IdentifiersResult identifiersResultQ = new C2637je(W6.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(identifiersResultQ.id)) {
            return null;
        }
        return identifiersResultQ.id;
    }
}
