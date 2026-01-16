package io.sentry.cache;

import io.sentry.A3;
import io.sentry.AbstractC3141l;
import io.sentry.C3;
import io.sentry.C3119g2;
import io.sentry.C3134j2;
import io.sentry.C3155n3;
import io.sentry.I;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3107e0;
import io.sentry.J2;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.X2;
import io.sentry.Y2;
import io.sentry.transport.s;
import io.sentry.util.C3202a;
import io.sentry.util.u;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class f extends c implements g {
    private final CountDownLatch f;
    private final Map g;
    protected final C3202a h;
    protected final C3202a i;

    public f(C3155n3 c3155n3, String str, int i) {
        super(c3155n3, str, i);
        this.g = new WeakHashMap();
        this.h = new C3202a();
        this.i = new C3202a();
        this.f = new CountDownLatch(1);
    }

    private File[] L() {
        File[] fileArrListFiles;
        return (!o() || (fileArrListFiles = this.c.listFiles(new FilenameFilter() { // from class: io.sentry.cache.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return f.S(file, str);
            }
        })) == null) ? new File[0] : fileArrListFiles;
    }

    public static g N(C3155n3 c3155n3) {
        String cacheDirPath = c3155n3.getCacheDirPath();
        int maxCacheItems = c3155n3.getMaxCacheItems();
        if (cacheDirPath != null) {
            return new f(c3155n3, cacheDirPath, maxCacheItems);
        }
        c3155n3.getLogger().c(Y2.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
        return s.f();
    }

    public static File P(String str) {
        return new File(str, "session.json");
    }

    private File Q(C3134j2 c3134j2) {
        String str;
        InterfaceC3102d0 interfaceC3102d0A = this.h.a();
        try {
            if (this.g.containsKey(c3134j2)) {
                str = (String) this.g.get(c3134j2);
            } else {
                String str2 = A3.a() + ".envelope";
                this.g.put(c3134j2, str2);
                str = str2;
            }
            File file = new File(this.c.getAbsolutePath(), str);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return file;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static File R(String str) {
        return new File(str, "previous_session.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean S(File file, String str) {
        return str.endsWith(".envelope");
    }

    private boolean W(C3134j2 c3134j2, I i) {
        u.c(c3134j2, "Envelope is required.");
        D(L());
        File fileP = P(this.c.getAbsolutePath());
        File fileR = R(this.c.getAbsolutePath());
        if (io.sentry.util.m.h(i, io.sentry.hints.l.class) && !fileP.delete()) {
            this.a.getLogger().c(Y2.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (io.sentry.util.m.h(i, io.sentry.hints.a.class)) {
            Y(i);
        }
        if (io.sentry.util.m.h(i, io.sentry.hints.n.class)) {
            V(fileP, fileR);
            Z(fileP, c3134j2);
            boolean zExists = new File(this.a.getCacheDirPath(), ".sentry-native/last_crash").exists();
            if (!zExists) {
                File file = new File(this.a.getCacheDirPath(), "last_crash");
                if (file.exists()) {
                    this.a.getLogger().c(Y2.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file.delete()) {
                        this.a.getLogger().c(Y2.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                    }
                    zExists = true;
                }
            }
            C3119g2.a().b(zExists);
            O();
        }
        File fileQ = Q(c3134j2);
        if (fileQ.exists()) {
            this.a.getLogger().c(Y2.WARNING, "Not adding Envelope to offline storage because it already exists: %s", fileQ.getAbsolutePath());
            return true;
        }
        this.a.getLogger().c(Y2.DEBUG, "Adding Envelope to offline storage: %s", fileQ.getAbsolutePath());
        boolean zC0 = c0(fileQ, c3134j2);
        if (io.sentry.util.m.h(i, UncaughtExceptionHandlerIntegration.a.class)) {
            b0();
        }
        return zC0;
    }

    private void Y(I i) {
        Date dateE;
        Object objG = io.sentry.util.m.g(i);
        if (objG instanceof io.sentry.hints.a) {
            File fileR = R(this.c.getAbsolutePath());
            if (!fileR.exists()) {
                this.a.getLogger().c(Y2.DEBUG, "No previous session file to end.", new Object[0]);
                return;
            }
            ILogger logger = this.a.getLogger();
            Y2 y2 = Y2.WARNING;
            logger.c(y2, "Previous session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileR), c.e));
                try {
                    C3 c3 = (C3) ((InterfaceC3107e0) this.b.a()).c(bufferedReader, C3.class);
                    if (c3 != null) {
                        io.sentry.hints.a aVar = (io.sentry.hints.a) objG;
                        Long lE = aVar.e();
                        if (lE != null) {
                            dateE = AbstractC3141l.e(lE.longValue());
                            Date dateK = c3.k();
                            if (dateK != null) {
                                if (dateE.before(dateK)) {
                                }
                            }
                            this.a.getLogger().c(y2, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                            bufferedReader.close();
                            return;
                        }
                        dateE = null;
                        c3.q(C3.b.Abnormal, null, true, aVar.h());
                        c3.d(dateE);
                        d0(fileR, c3);
                    }
                    bufferedReader.close();
                } finally {
                }
            } catch (Throwable th) {
                this.a.getLogger().b(Y2.ERROR, "Error processing previous session.", th);
            }
        }
    }

    private void Z(File file, C3134j2 c3134j2) {
        Iterable iterableC = c3134j2.c();
        if (!iterableC.iterator().hasNext()) {
            this.a.getLogger().c(Y2.INFO, "Current envelope %s is empty", file.getAbsolutePath());
            return;
        }
        J2 j2 = (J2) iterableC.iterator().next();
        if (!X2.Session.equals(j2.J().b())) {
            this.a.getLogger().c(Y2.INFO, "Current envelope has a different envelope type %s", j2.J().b());
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(j2.I()), c.e));
            try {
                C3 c3 = (C3) ((InterfaceC3107e0) this.b.a()).c(bufferedReader, C3.class);
                if (c3 == null) {
                    this.a.getLogger().c(Y2.ERROR, "Item of type %s returned null by the parser.", j2.J().b());
                } else {
                    d0(file, c3);
                }
                bufferedReader.close();
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Item failed to process.", th);
        }
    }

    private void b0() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.a.getCacheDirPath(), "last_crash"));
            try {
                fileOutputStream.write(AbstractC3141l.h(AbstractC3141l.d()).getBytes(c.e));
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Error writing the crash marker file to the disk", th);
        }
    }

    private boolean c0(File file, C3134j2 c3134j2) {
        if (file.exists()) {
            this.a.getLogger().c(Y2.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.a.getLogger().c(Y2.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ((InterfaceC3107e0) this.b.a()).b(c3134j2, fileOutputStream);
                fileOutputStream.close();
                return true;
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().a(Y2.ERROR, th, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
            return false;
        }
    }

    private void d0(File file, C3 c3) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, c.e));
                try {
                    this.a.getLogger().c(Y2.DEBUG, "Overwriting session to offline storage: %s", c3.j());
                    ((InterfaceC3107e0) this.b.a()).a(c3, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().a(Y2.ERROR, th, "Error writing Session to offline storage: %s", c3.j());
        }
    }

    @Override // io.sentry.cache.g
    public void J(C3134j2 c3134j2) {
        u.c(c3134j2, "Envelope is required.");
        File fileQ = Q(c3134j2);
        if (!fileQ.exists()) {
            this.a.getLogger().c(Y2.DEBUG, "Envelope was not cached: %s", fileQ.getAbsolutePath());
            return;
        }
        this.a.getLogger().c(Y2.DEBUG, "Discarding envelope from cache: %s", fileQ.getAbsolutePath());
        if (fileQ.delete()) {
            return;
        }
        this.a.getLogger().c(Y2.ERROR, "Failed to delete envelope: %s", fileQ.getAbsolutePath());
    }

    public void O() {
        this.f.countDown();
    }

    public void V(File file, File file2) {
        InterfaceC3102d0 interfaceC3102d0A = this.i.a();
        try {
            if (file2.exists()) {
                this.a.getLogger().c(Y2.DEBUG, "Previous session file already exists, deleting it.", new Object[0]);
                if (!file2.delete()) {
                    this.a.getLogger().c(Y2.WARNING, "Unable to delete previous session file: %s", file2);
                }
            }
            if (file.exists()) {
                this.a.getLogger().c(Y2.INFO, "Moving current session to previous session.", new Object[0]);
                try {
                    if (!file.renameTo(file2)) {
                        this.a.getLogger().c(Y2.WARNING, "Unable to move current session to previous session.", new Object[0]);
                    }
                } catch (Throwable th) {
                    this.a.getLogger().b(Y2.ERROR, "Error moving current session to previous session.", th);
                }
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th2) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public boolean a0() {
        try {
            return this.f.await(this.a.getSessionFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.a.getLogger().c(Y2.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() throws IOException {
        File[] fileArrL = L();
        ArrayList arrayList = new ArrayList(fileArrL.length);
        for (File file : fileArrL) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(((InterfaceC3107e0) this.b.a()).d(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                this.a.getLogger().c(Y2.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e) {
                this.a.getLogger().b(Y2.ERROR, String.format("Error while reading cached envelope from file %s", file.getAbsolutePath()), e);
            }
        }
        return arrayList.iterator();
    }

    public boolean o1(C3134j2 c3134j2, I i) {
        return W(c3134j2, i);
    }
}
