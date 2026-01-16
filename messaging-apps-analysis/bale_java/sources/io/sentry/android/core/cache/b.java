package io.sentry.android.core.cache;

import io.sentry.C3134j2;
import io.sentry.C3155n3;
import io.sentry.I;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.Y2;
import io.sentry.android.core.AnrV2Integration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.util.g;
import io.sentry.android.core.performance.h;
import io.sentry.android.core.performance.i;
import io.sentry.cache.f;
import io.sentry.transport.p;
import io.sentry.util.AbstractC3209h;
import io.sentry.util.m;
import io.sentry.util.u;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public final class b extends f {
    private final p j;

    public b(SentryAndroidOptions sentryAndroidOptions) {
        this(sentryAndroidOptions, g.b());
    }

    public static boolean g0(C3155n3 c3155n3) {
        String outboxPath = c3155n3.getOutboxPath();
        if (outboxPath == null) {
            c3155n3.getLogger().c(Y2.DEBUG, "Outbox path is null, the startup crash marker file does not exist", new Object[0]);
            return false;
        }
        File file = new File(outboxPath, "startup_crash");
        try {
            boolean zExists = file.exists();
            if (zExists && !file.delete()) {
                c3155n3.getLogger().c(Y2.ERROR, "Failed to delete the startup crash marker file. %s.", file.getAbsolutePath());
            }
            return zExists;
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Error reading/deleting the startup crash marker file on the disk", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(SentryAndroidOptions sentryAndroidOptions, AnrV2Integration.b bVar) {
        Long lE = bVar.e();
        sentryAndroidOptions.getLogger().c(Y2.DEBUG, "Writing last reported ANR marker with timestamp %d", lE);
        k0(lE);
    }

    public static Long i0(C3155n3 c3155n3) {
        File file = new File((String) u.c(c3155n3.getCacheDirPath(), "Cache dir path should be set for getting ANRs reported"), "last_anr_report");
        try {
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Error reading last ANR marker", th);
        }
        if (!file.exists() || !file.canRead()) {
            c3155n3.getLogger().c(Y2.DEBUG, "Last ANR marker does not exist. %s.", file.getAbsolutePath());
            return null;
        }
        String strC = AbstractC3209h.c(file);
        if (strC.equals("null")) {
            return null;
        }
        return Long.valueOf(Long.parseLong(strC.trim()));
    }

    private boolean j0(C3134j2 c3134j2, I i) {
        boolean zO1 = super.o1(c3134j2, i);
        final SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.a;
        i iVarQ = h.p().q();
        if (m.h(i, UncaughtExceptionHandlerIntegration.a.class) && iVarQ.w()) {
            long jA = this.j.a() - iVarQ.t();
            if (jA <= sentryAndroidOptions.getStartupCrashDurationThresholdMillis()) {
                sentryAndroidOptions.getLogger().c(Y2.DEBUG, "Startup Crash detected %d milliseconds after SDK init. Writing a startup crash marker file to disk.", Long.valueOf(jA));
                l0();
            }
        }
        m.o(i, AnrV2Integration.b.class, new m.a() { // from class: io.sentry.android.core.cache.a
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                this.a.h0(sentryAndroidOptions, (AnrV2Integration.b) obj);
            }
        });
        return zO1;
    }

    private void k0(Long l) {
        String cacheDirPath = this.a.getCacheDirPath();
        if (cacheDirPath == null) {
            this.a.getLogger().c(Y2.DEBUG, "Cache dir path is null, the ANR marker will not be written", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDirPath, "last_anr_report"));
            try {
                fileOutputStream.write(String.valueOf(l).getBytes(e));
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Error writing the ANR marker to the disk", th);
        }
    }

    private void l0() {
        String outboxPath = this.a.getOutboxPath();
        if (outboxPath == null) {
            this.a.getLogger().c(Y2.DEBUG, "Outbox path is null, the startup crash marker file will not be written", new Object[0]);
            return;
        }
        try {
            new File(outboxPath, "startup_crash").createNewFile();
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Error writing the startup crash marker file to the disk", th);
        }
    }

    @Override // io.sentry.cache.f, io.sentry.cache.g
    public boolean o1(C3134j2 c3134j2, I i) {
        return j0(c3134j2, i);
    }

    b(SentryAndroidOptions sentryAndroidOptions, p pVar) {
        super(sentryAndroidOptions, (String) u.c(sentryAndroidOptions.getCacheDirPath(), "cacheDirPath must not be null"), sentryAndroidOptions.getMaxCacheItems());
        this.j = pVar;
    }
}
