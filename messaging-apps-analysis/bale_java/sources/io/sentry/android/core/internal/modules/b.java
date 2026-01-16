package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.internal.modules.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class b extends d {
    private final Context e;

    public b(Context context, ILogger iLogger) {
        super(iLogger);
        this.e = AbstractC3060k0.g(context);
        new Thread(new Runnable() { // from class: io.sentry.android.core.internal.modules.a
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        a();
    }

    @Override // io.sentry.internal.modules.d
    protected Map b() throws IOException {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream inputStreamOpen = this.e.getAssets().open("sentry-external-modules.txt");
            try {
                Map mapC = c(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return mapC;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            this.a.c(Y2.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (IOException e) {
            this.a.b(Y2.ERROR, "Error extracting modules.", e);
            return treeMap;
        }
    }
}
