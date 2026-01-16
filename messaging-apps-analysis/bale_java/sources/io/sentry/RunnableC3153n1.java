package io.sentry;

import io.sentry.C3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;

/* renamed from: io.sentry.n1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC3153n1 implements Runnable {
    private static final Charset c = Charset.forName("UTF-8");
    private final C3155n3 a;
    private final Z b;

    RunnableC3153n1(C3155n3 c3155n3, Z z) {
        this.a = c3155n3;
        this.b = z;
    }

    private Date a(File file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), c));
            try {
                String line = bufferedReader.readLine();
                this.a.getLogger().c(Y2.DEBUG, "Crash marker file has %s timestamp.", line);
                Date dateF = AbstractC3141l.f(line);
                bufferedReader.close();
                return dateF;
            } finally {
            }
        } catch (IOException e) {
            this.a.getLogger().b(Y2.ERROR, "Error reading the crash marker file.", e);
            return null;
        } catch (IllegalArgumentException e2) {
            this.a.getLogger().a(Y2.ERROR, e2, "Error converting the crash timestamp.", new Object[0]);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String cacheDirPath = this.a.getCacheDirPath();
        if (cacheDirPath == null) {
            this.a.getLogger().c(Y2.INFO, "Cache dir is not set, not finalizing the previous session.", new Object[0]);
            return;
        }
        if (!this.a.isEnableAutoSessionTracking()) {
            this.a.getLogger().c(Y2.DEBUG, "Session tracking is disabled, bailing from previous session finalizer.", new Object[0]);
            return;
        }
        io.sentry.cache.g envelopeDiskCache = this.a.getEnvelopeDiskCache();
        if ((envelopeDiskCache instanceof io.sentry.cache.f) && !((io.sentry.cache.f) envelopeDiskCache).a0()) {
            this.a.getLogger().c(Y2.WARNING, "Timed out waiting to flush previous session to its own file in session finalizer.", new Object[0]);
            return;
        }
        File fileR = io.sentry.cache.f.R(cacheDirPath);
        InterfaceC3107e0 serializer = this.a.getSerializer();
        if (fileR.exists()) {
            this.a.getLogger().c(Y2.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileR), c));
                try {
                    C3 c3 = (C3) serializer.c(bufferedReader, C3.class);
                    if (c3 == null) {
                        this.a.getLogger().c(Y2.ERROR, "Stream from path %s resulted in a null envelope.", fileR.getAbsolutePath());
                    } else {
                        File file = new File(this.a.getCacheDirPath(), ".sentry-native/last_crash");
                        Date date = null;
                        if (file.exists()) {
                            this.a.getLogger().c(Y2.INFO, "Crash marker file exists, last Session is gonna be Crashed.", new Object[0]);
                            Date dateA = a(file);
                            if (!file.delete()) {
                                this.a.getLogger().c(Y2.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                            }
                            c3.p(C3.b.Crashed, null, true);
                            date = dateA;
                        }
                        if (c3.f() == null) {
                            c3.d(date);
                        }
                        this.b.G(C3134j2.a(serializer, c3, this.a.getSdkVersion()));
                    }
                    bufferedReader.close();
                } finally {
                }
            } catch (Throwable th) {
                this.a.getLogger().b(Y2.ERROR, "Error processing previous session.", th);
            }
            if (fileR.delete()) {
                return;
            }
            this.a.getLogger().c(Y2.WARNING, "Failed to delete the previous session file.", new Object[0]);
        }
    }
}
