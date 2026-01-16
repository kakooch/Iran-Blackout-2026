package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;

/* loaded from: classes3.dex */
public final class Tg extends AbstractC2629j6 {
    public final Sm d;

    public Tg(Context context, Sm sm, InterfaceC2606i6 interfaceC2606i6, ICrashTransformer iCrashTransformer) {
        this(sm, interfaceC2606i6, iCrashTransformer, new G9(context));
    }

    public final Sm c() {
        return this.d;
    }

    public Tg(Sm sm, InterfaceC2606i6 interfaceC2606i6, ICrashTransformer iCrashTransformer, G9 g9) {
        super(interfaceC2606i6, iCrashTransformer, g9);
        this.d = sm;
    }
}
