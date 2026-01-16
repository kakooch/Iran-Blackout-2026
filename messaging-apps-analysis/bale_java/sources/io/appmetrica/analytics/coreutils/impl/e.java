package io.appmetrica.analytics.coreutils.impl;

import android.content.ComponentName;
import android.content.Context;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.SA2;

/* loaded from: classes3.dex */
public final class e extends AbstractC8614Ws3 implements SA2 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ComponentName b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, ComponentName componentName, int i) {
        super(0);
        this.a = context;
        this.b = componentName;
        this.c = i;
    }

    @Override // ir.nasim.SA2
    public final Object invoke() {
        return this.a.getPackageManager().getServiceInfo(this.b, this.c);
    }
}
