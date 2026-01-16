package io.sentry.android.core;

import android.os.Debug;
import io.sentry.C3148m1;

/* renamed from: io.sentry.android.core.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3088z implements io.sentry.W {
    @Override // io.sentry.W
    public void c() {
    }

    @Override // io.sentry.W
    public void d(C3148m1 c3148m1) {
        long jFreeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long nativeHeapSize = Debug.getNativeHeapSize() - Debug.getNativeHeapFreeSize();
        c3148m1.f(Long.valueOf(jFreeMemory));
        c3148m1.g(Long.valueOf(nativeHeapSize));
    }
}
