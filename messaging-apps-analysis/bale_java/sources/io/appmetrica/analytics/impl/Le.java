package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* loaded from: classes3.dex */
public final class Le extends C2657ka {
    public Le(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.C2657ka
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int b(W w) {
        if (w == null) {
            return 0;
        }
        return StringUtils.getUtf8BytesLength(w.b) + 12;
    }
}
