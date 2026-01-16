package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.BuildConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.regex.Pattern;

/* renamed from: io.appmetrica.analytics.impl.ui, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2904ui {
    public static final Pattern a = Pattern.compile(".*at io\\.appmetrica\\.analytics\\.push\\.*");
    public static final Pattern b = Pattern.compile(".*at io\\.appmetrica\\.analytics\\.(?!push)");

    public static void a(String str, Object... objArr) {
        ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format(str, objArr), new Object[0]);
    }

    public static String a() {
        StringBuilder sb = new StringBuilder(BuildConfig.SDK_BUILD_FLAVOR);
        if (!TextUtils.isEmpty(BuildConfig.SDK_DEPENDENCY)) {
            sb.append("_binary");
        }
        if (!TextUtils.isEmpty("")) {
            sb.append("_");
        }
        return sb.toString();
    }
}
