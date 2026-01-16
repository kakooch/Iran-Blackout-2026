package io.sentry.android.core.internal.util;

import android.content.ContentProvider;
import io.sentry.L0;
import io.sentry.android.core.Y;

/* loaded from: classes3.dex */
public final class k {
    private final Y a;

    public k() {
        this(new Y(L0.e()));
    }

    public void a(ContentProvider contentProvider) {
        int iD = this.a.d();
        if (iD < 26 || iD > 28) {
            return;
        }
        String callingPackage = contentProvider.getCallingPackage();
        String packageName = contentProvider.getContext().getPackageName();
        if (callingPackage == null || !callingPackage.equals(packageName)) {
            throw new SecurityException("Provider does not allow for granting of Uri permissions");
        }
    }

    public k(Y y) {
        this.a = y;
    }
}
