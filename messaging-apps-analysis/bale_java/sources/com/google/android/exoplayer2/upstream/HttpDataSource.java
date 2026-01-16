package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.a;
import ir.nasim.AbstractC14083hK;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public interface HttpDataSource extends com.google.android.exoplayer2.upstream.a {

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, bVar, 2007, 1);
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String d;

        public InvalidContentTypeException(String str, com.google.android.exoplayer2.upstream.b bVar) {
            super("Invalid content type: " + str, bVar, 2003, 1);
            this.d = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final int d;
        public final String e;
        public final Map f;
        public final byte[] g;

        public InvalidResponseCodeException(int i, String str, IOException iOException, Map map, com.google.android.exoplayer2.upstream.b bVar, byte[] bArr) {
            super("Response code: " + i, iOException, bVar, 2004, 1);
            this.d = i;
            this.e = str;
            this.f = map;
            this.g = bArr;
        }
    }

    public static abstract class a implements a.InterfaceC0163a {
        private final b a = new b();

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HttpDataSource a() {
            return c(this.a);
        }

        protected abstract HttpDataSource c(b bVar);
    }

    public static final class b {
        private final Map a = new HashMap();
        private Map b;

        public synchronized Map a() {
            try {
                if (this.b == null) {
                    this.b = Collections.unmodifiableMap(new HashMap(this.a));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.b;
        }
    }

    public static class HttpDataSourceException extends DataSourceException {
        public final com.google.android.exoplayer2.upstream.b b;
        public final int c;

        public HttpDataSourceException(com.google.android.exoplayer2.upstream.b bVar, int i, int i2) {
            super(b(i, i2));
            this.b = bVar;
            this.c = i2;
        }

        private static int b(int i, int i2) {
            if (i == 2000 && i2 == 1) {
                return 2001;
            }
            return i;
        }

        public static HttpDataSourceException c(IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i) {
            String message = iOException.getMessage();
            int i2 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !AbstractC14083hK.e(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
            return i2 == 2007 ? new CleartextNotPermittedException(iOException, bVar) : new HttpDataSourceException(iOException, bVar, i2, i);
        }

        public HttpDataSourceException(String str, com.google.android.exoplayer2.upstream.b bVar, int i, int i2) {
            super(str, b(i, i2));
            this.b = bVar;
            this.c = i2;
        }

        public HttpDataSourceException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i, int i2) {
            super(iOException, b(i, i2));
            this.b = bVar;
            this.c = i2;
        }

        public HttpDataSourceException(String str, IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i, int i2) {
            super(str, iOException, b(i, i2));
            this.b = bVar;
            this.c = i2;
        }
    }
}
