package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* loaded from: classes3.dex */
public final class Q8 extends R8 {
    public final List a;

    public Q8(List<Object> list) {
        this.a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.a;
    }
}
