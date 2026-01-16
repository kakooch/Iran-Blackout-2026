package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* loaded from: classes3.dex */
public final class Yl implements pn {
    @Override // io.appmetrica.analytics.impl.pn
    public final byte[] a(G8 g8, Cg cg) {
        return !TextUtils.isEmpty(g8.b) ? StringUtils.getUTF8Bytes(g8.b) : new byte[0];
    }
}
