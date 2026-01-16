package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
class InstallerPackageNameProvider {
    private String installerPackageName;

    InstallerPackageNameProvider() {
    }

    synchronized String getInstallerPackageName(Context context) {
        if (this.installerPackageName == null) {
            this.installerPackageName = loadInstallerPackageName(context);
        }
        return BuildConfig.FLAVOR.equals(this.installerPackageName) ? null : this.installerPackageName;
    }

    private static String loadInstallerPackageName(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? BuildConfig.FLAVOR : installerPackageName;
    }
}
