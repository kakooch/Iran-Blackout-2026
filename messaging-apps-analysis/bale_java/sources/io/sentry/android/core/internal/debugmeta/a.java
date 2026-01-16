package io.sentry.android.core.internal.debugmeta;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.util.AbstractC3205d;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/* loaded from: classes3.dex */
public final class a implements io.sentry.internal.debugmeta.a {
    private final Context a;
    private final ILogger b;

    public a(Context context, ILogger iLogger) {
        this.a = AbstractC3060k0.g(context);
        this.b = iLogger;
    }

    @Override // io.sentry.internal.debugmeta.a
    public List a() throws IOException {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.a.getAssets().open(AbstractC3205d.a));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                List listSingletonList = Collections.singletonList(properties);
                bufferedInputStream.close();
                return listSingletonList;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            this.b.c(Y2.INFO, "%s file was not found.", AbstractC3205d.a);
            return null;
        } catch (IOException e) {
            this.b.b(Y2.ERROR, "Error getting Proguard UUIDs.", e);
            return null;
        } catch (RuntimeException e2) {
            this.b.a(Y2.ERROR, e2, "%s file is malformed.", AbstractC3205d.a);
            return null;
        }
    }
}
