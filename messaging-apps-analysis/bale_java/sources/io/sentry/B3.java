package io.sentry;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class B3 {
    private final List a;

    B3(List list) {
        this.a = new ArrayList(list == null ? new ArrayList(0) : list);
    }

    public List a() {
        return this.a;
    }
}
