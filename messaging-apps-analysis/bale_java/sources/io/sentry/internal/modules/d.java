package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public abstract class d implements b {
    private static final Charset d = Charset.forName("UTF-8");
    protected final ILogger a;
    private final C3202a b = new C3202a();
    private volatile Map c = null;

    public d(ILogger iLogger) {
        this.a = iLogger;
    }

    @Override // io.sentry.internal.modules.b
    public Map a() {
        if (this.c == null) {
            InterfaceC3102d0 interfaceC3102d0A = this.b.a();
            try {
                if (this.c == null) {
                    this.c = b();
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
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
        return this.c;
    }

    protected abstract Map b();

    protected Map c(InputStream inputStream) throws IOException {
        TreeMap treeMap = new TreeMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, d));
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    int iLastIndexOf = line.lastIndexOf(58);
                    treeMap.put(line.substring(0, iLastIndexOf), line.substring(iLastIndexOf + 1));
                }
                this.a.c(Y2.DEBUG, "Extracted %d modules from resources.", Integer.valueOf(treeMap.size()));
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            this.a.b(Y2.ERROR, "Error extracting modules.", e);
        } catch (RuntimeException e2) {
            this.a.a(Y2.ERROR, e2, "%s file is malformed.", "sentry-external-modules.txt");
        }
        return treeMap;
    }
}
