package io.sentry.android.core.internal.util;

import io.sentry.protocol.C3170e;

/* loaded from: classes3.dex */
public abstract class n {
    public static C3170e.b a(int i) {
        if (i == 1) {
            return C3170e.b.PORTRAIT;
        }
        if (i != 2) {
            return null;
        }
        return C3170e.b.LANDSCAPE;
    }
}
