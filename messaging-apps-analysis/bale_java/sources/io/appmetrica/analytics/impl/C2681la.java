package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* renamed from: io.appmetrica.analytics.impl.la, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2681la extends C2657ka {
    public C2681la(int i, int i2) {
        this(i, new C2705ma(i2));
    }

    public final int a(String str) {
        return StringUtils.getUTF8Bytes(str).length;
    }

    @Override // io.appmetrica.analytics.impl.C2657ka
    public final int b(Object obj) {
        return StringUtils.getUTF8Bytes((String) obj).length;
    }

    public C2681la(int i, C2705ma c2705ma) {
        super(i, c2705ma);
    }
}
