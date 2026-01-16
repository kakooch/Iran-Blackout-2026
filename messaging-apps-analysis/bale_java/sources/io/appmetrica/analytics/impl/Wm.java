package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class Wm extends AbstractC2568gg {
    public Wm(C2484d5 c2484d5) {
        super(c2484d5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        String strI = this.a.c.i();
        String str = q5.h;
        this.a.c.j(str).b();
        if (TextUtils.equals(strI, str)) {
            return false;
        }
        this.a.a(C2433b4.o());
        return false;
    }
}
