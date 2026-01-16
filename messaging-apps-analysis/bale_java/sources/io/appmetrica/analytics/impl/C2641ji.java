package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* renamed from: io.appmetrica.analytics.impl.ji, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2641ji extends AbstractC2568gg {
    public C2641ji(C2484d5 c2484d5) {
        super(c2484d5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        String str = q5.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.a.c.j(str).b();
        return false;
    }
}
