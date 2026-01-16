package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: classes3.dex */
public final class Xe implements pn, InterfaceC2846s8 {
    @Override // io.appmetrica.analytics.impl.InterfaceC2846s8
    public final int a(B8 b8) {
        return 2;
    }

    @Override // io.appmetrica.analytics.impl.pn
    public final byte[] a(G8 g8, Cg cg) {
        return TextUtils.isEmpty(g8.b) ? new byte[0] : Base64.decode(g8.b, 0);
    }
}
