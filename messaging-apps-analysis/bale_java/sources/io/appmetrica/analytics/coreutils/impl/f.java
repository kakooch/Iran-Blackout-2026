package io.appmetrica.analytics.coreutils.impl;

import android.content.Context;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.SA2;

/* loaded from: classes3.dex */
public final class f extends AbstractC8614Ws3 implements SA2 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String str) {
        super(0);
        this.a = context;
        this.b = str;
    }

    @Override // ir.nasim.SA2
    public final Object invoke() {
        return Boolean.valueOf(this.a.getPackageManager().hasSystemFeature(this.b));
    }
}
