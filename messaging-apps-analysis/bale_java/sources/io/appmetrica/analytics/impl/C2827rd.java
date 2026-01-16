package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* renamed from: io.appmetrica.analytics.impl.rd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2827rd implements on {
    public final String a;

    public C2827rd(String str) {
        this.a = str;
    }

    @Override // io.appmetrica.analytics.impl.on
    public final mn a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new mn(this, true, "");
        }
        return new mn(this, false, this.a + " is empty.");
    }
}
