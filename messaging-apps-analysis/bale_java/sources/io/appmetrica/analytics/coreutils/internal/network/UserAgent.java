package io.appmetrica.analytics.coreutils.internal.network;

import android.os.Build;
import io.appmetrica.analytics.coreutils.internal.StringExtensionsKt;
import ir.nasim.AbstractC20153rZ6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/network/UserAgent;", "", "", "sdkName", "versionName", "buildNumber", "getFor", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class UserAgent {
    public static final UserAgent INSTANCE = new UserAgent();

    private UserAgent() {
    }

    public static final String getFor(String sdkName, String versionName, String buildNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(sdkName);
        sb.append('/');
        sb.append(versionName);
        sb.append('.');
        sb.append(buildNumber);
        sb.append(" (");
        INSTANCE.getClass();
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        if (!AbstractC20153rZ6.S(str, str2, false, 2, null)) {
            str = str2 + ' ' + str;
        }
        sb.append(StringExtensionsKt.replaceFirstCharWithTitleCase(str));
        sb.append("; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(')');
        return sb.toString();
    }
}
