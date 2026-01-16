package io.appmetrica.analytics.coreutils.impl;

import android.content.ComponentName;
import android.content.Context;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.SA2;

/* loaded from: classes3.dex */
public final class j extends AbstractC8614Ws3 implements SA2 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ComponentName b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, ComponentName componentName, int i, int i2) {
        super(0);
        this.a = context;
        this.b = componentName;
        this.c = i;
        this.d = i2;
    }

    @Override // ir.nasim.SA2
    public final Object invoke() {
        this.a.getPackageManager().setComponentEnabledSetting(this.b, this.c, this.d);
        return C19938rB7.a;
    }
}
