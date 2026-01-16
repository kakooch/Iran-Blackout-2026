package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import io.sentry.W2;
import io.sentry.Y2;
import io.sentry.Z1;

/* loaded from: classes3.dex */
public final class SentryInitProvider extends AbstractC3073r0 {
    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryInitProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C3086y c3086y = new C3086y();
        Context context = getContext();
        if (context == null) {
            c3086y.c(Y2.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return false;
        }
        if (!A0.c(context, c3086y) || AbstractC3060k0.f(context)) {
            return true;
        }
        O0.e(context, c3086y);
        W2.d().a("AutoInit");
        return true;
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        Z1.l();
    }
}
