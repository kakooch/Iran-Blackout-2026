package io.sentry.cache;

import io.sentry.C3;
import io.sentry.C3134j2;
import io.sentry.C3155n3;
import io.sentry.InterfaceC3107e0;
import io.sentry.J2;
import io.sentry.X2;
import io.sentry.Y2;
import io.sentry.util.q;
import io.sentry.util.u;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class c {
    protected static final Charset e = Charset.forName("UTF-8");
    protected C3155n3 a;
    protected final io.sentry.util.q b = new io.sentry.util.q(new q.a() { // from class: io.sentry.cache.a
        @Override // io.sentry.util.q.a
        public final Object a() {
            return this.a.w();
        }
    });
    protected final File c;
    private final int d;

    c(C3155n3 c3155n3, String str, int i) {
        u.c(str, "Directory is required.");
        this.a = (C3155n3) u.c(c3155n3, "SentryOptions is required.");
        this.c = new File(str);
        this.d = i;
    }

    private void A(File file, File[] fileArr) throws IOException {
        Boolean boolG;
        J2 j2G;
        C3 c3C;
        C3134j2 c3134j2B = B(file);
        if (c3134j2B == null || !t(c3134j2B)) {
            return;
        }
        this.a.getClientReportRecorder().b(io.sentry.clientreport.f.CACHE_OVERFLOW, c3134j2B);
        C3 c3J = j(c3134j2B);
        if (c3J == null || !v(c3J) || (boolG = c3J.g()) == null || !boolG.booleanValue()) {
            return;
        }
        for (File file2 : fileArr) {
            C3134j2 c3134j2B2 = B(file2);
            if (c3134j2B2 != null && t(c3134j2B2)) {
                Iterator it = c3134j2B2.c().iterator();
                while (true) {
                    j2G = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    J2 j2 = (J2) it.next();
                    if (r(j2) && (c3C = C(j2)) != null && v(c3C)) {
                        Boolean boolG2 = c3C.g();
                        if (boolG2 != null && boolG2.booleanValue()) {
                            this.a.getLogger().c(Y2.ERROR, "Session %s has 2 times the init flag.", c3J.j());
                            return;
                        }
                        if (c3J.j() != null && c3J.j().equals(c3C.j())) {
                            c3C.n();
                            try {
                                j2G = J2.G((InterfaceC3107e0) this.b.a(), c3C);
                                it.remove();
                                break;
                            } catch (IOException e2) {
                                this.a.getLogger().a(Y2.ERROR, e2, "Failed to create new envelope item for the session %s", c3J.j());
                            }
                        }
                    }
                }
                if (j2G != null) {
                    C3134j2 c3134j2I = i(c3134j2B2, j2G);
                    long jLastModified = file2.lastModified();
                    if (!file2.delete()) {
                        this.a.getLogger().c(Y2.WARNING, "File can't be deleted: %s", file2.getAbsolutePath());
                    }
                    E(c3134j2I, file2, jLastModified);
                    return;
                }
            }
        }
    }

    private C3134j2 B(File file) throws IOException {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                C3134j2 c3134j2D = ((InterfaceC3107e0) this.b.a()).d(bufferedInputStream);
                bufferedInputStream.close();
                return c3134j2D;
            } finally {
            }
        } catch (IOException e2) {
            this.a.getLogger().b(Y2.ERROR, "Failed to deserialize the envelope.", e2);
            return null;
        }
    }

    private C3 C(J2 j2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(j2.I()), e));
            try {
                C3 c3 = (C3) ((InterfaceC3107e0) this.b.a()).c(bufferedReader, C3.class);
                bufferedReader.close();
                return c3;
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Failed to deserialize the session.", th);
            return null;
        }
    }

    private void E(C3134j2 c3134j2, File file, long j) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ((InterfaceC3107e0) this.b.a()).b(c3134j2, fileOutputStream);
                file.setLastModified(j);
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Failed to serialize the new envelope to the disk.", th);
        }
    }

    private void F(File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, new Comparator() { // from class: io.sentry.cache.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return c.x((File) obj, (File) obj2);
                }
            });
        }
    }

    private C3134j2 i(C3134j2 c3134j2, J2 j2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = c3134j2.c().iterator();
        while (it.hasNext()) {
            arrayList.add((J2) it.next());
        }
        arrayList.add(j2);
        return new C3134j2(c3134j2.b(), arrayList);
    }

    private C3 j(C3134j2 c3134j2) {
        for (J2 j2 : c3134j2.c()) {
            if (r(j2)) {
                return C(j2);
            }
        }
        return null;
    }

    private boolean r(J2 j2) {
        if (j2 == null) {
            return false;
        }
        return j2.J().b().equals(X2.Session);
    }

    private boolean t(C3134j2 c3134j2) {
        return c3134j2.c().iterator().hasNext();
    }

    private boolean v(C3 c3) {
        return c3.l().equals(C3.b.Ok) && c3.j() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceC3107e0 w() {
        return this.a.getSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int x(File file, File file2) {
        return Long.compare(file.lastModified(), file2.lastModified());
    }

    protected void D(File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.d) {
            this.a.getLogger().c(Y2.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i = (length - this.d) + 1;
            F(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i, length);
            for (int i2 = 0; i2 < i; i2++) {
                File file = fileArr[i2];
                A(file, fileArr2);
                if (!file.delete()) {
                    this.a.getLogger().c(Y2.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }

    protected boolean o() {
        if (this.c.isDirectory() && this.c.canWrite() && this.c.canRead()) {
            return true;
        }
        this.a.getLogger().c(Y2.ERROR, "The directory for caching files is inaccessible.: %s", this.c.getAbsolutePath());
        return false;
    }
}
