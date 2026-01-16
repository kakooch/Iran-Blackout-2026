package io.appmetrica.analytics.coreutils.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManagerHelperForR;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.SA2;

/* loaded from: classes3.dex */
public final class c extends AbstractC8614Ws3 implements SA2 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, String str) {
        super(0);
        this.a = context;
        this.b = str;
    }

    @Override // ir.nasim.SA2
    public final Object invoke() {
        PackageManager packageManager = this.a.getPackageManager();
        return AndroidUtils.isApiAchieved(30) ? SafePackageManagerHelperForR.extractPackageInstaller(packageManager, this.b) : packageManager.getInstallerPackageName(this.b);
    }
}
