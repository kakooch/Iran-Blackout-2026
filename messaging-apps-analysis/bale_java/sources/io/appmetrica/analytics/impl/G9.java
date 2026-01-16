package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class G9 {
    public final Vl a;
    public final C2722n3 b;

    public G9(Context context) {
        this(new Vl(context, "io.appmetrica.analytics.build_id"), new C2722n3(context, "io.appmetrica.analytics.is_offline"));
    }

    public G9(Vl vl, C2722n3 c2722n3) {
        this.a = vl;
        this.b = c2722n3;
    }
}
