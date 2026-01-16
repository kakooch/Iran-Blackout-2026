package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class Z implements on {
    @Override // io.appmetrica.analytics.impl.on
    public final mn a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new mn(this, false, "ApiKey is empty. Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
        try {
            UUID.fromString(str);
            return new mn(this, true, "");
        } catch (Throwable unused) {
            return new mn(this, false, "Invalid ApiKey=" + str + ". Please, read official documentation how to obtain one: https://appmetrica.io/docs/mobile-sdk-dg/android/about/android-initialize.html");
        }
    }
}
