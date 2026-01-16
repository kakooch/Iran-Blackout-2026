package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aci extends abr implements acq {
    private static final Pattern a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> b = new AtomicReference<>();
    private final int c;
    private final int d;
    private final String e;
    private final acp f;
    private final acp g;
    private acb h;
    private HttpURLConnection i;
    private InputStream j;
    private boolean k;
    private int l;
    private long m;
    private long n;
    private long o;
    private long p;

    public aci() {
        String str = cv.a;
        throw null;
    }

    private final void k() {
        HttpURLConnection httpURLConnection = this.i;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                adu.b("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.i = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fc  */
    @Override // com.google.ads.interactivemedia.v3.internal.abx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long c(com.google.ads.interactivemedia.v3.internal.acb r23) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aci.c(com.google.ads.interactivemedia.v3.internal.acb):long");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        HttpURLConnection httpURLConnection = this.i;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abr, com.google.ads.interactivemedia.v3.internal.abx
    public final Map<String, List<String>> e() {
        HttpURLConnection httpURLConnection = this.i;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    public aci(String str, int i, int i2, acp acpVar) {
        super(true);
        ary.v(str);
        this.e = str;
        this.g = new acp();
        this.c = i;
        this.d = i2;
        this.f = acpVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[Catch: Exception -> 0x0067, all -> 0x0083, TRY_LEAVE, TryCatch #0 {all -> 0x0083, blocks: (B:3:0x0002, B:5:0x0006, B:9:0x0014, B:28:0x0067, B:31:0x006e, B:32:0x0073, B:15:0x001f, B:17:0x0027, B:23:0x0036, B:25:0x0046, B:27:0x004e, B:8:0x0011), top: B:43:0x0002, inners: #2 }] */
    @Override // com.google.ads.interactivemedia.v3.internal.abx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() throws com.google.ads.interactivemedia.v3.internal.acn {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.j     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L74
            java.net.HttpURLConnection r2 = r9.i     // Catch: java.lang.Throwable -> L83
            long r3 = r9.n     // Catch: java.lang.Throwable -> L83
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L11
            goto L14
        L11:
            long r7 = r9.p     // Catch: java.lang.Throwable -> L83
            long r3 = r3 - r7
        L14:
            int r7 = com.google.ads.interactivemedia.v3.internal.aeu.a     // Catch: java.lang.Throwable -> L83
            r8 = 19
            if (r7 == r8) goto L1f
            r8 = 20
            if (r7 == r8) goto L1f
            goto L67
        L1f:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L2f
            int r3 = r2.read()     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            r4 = -1
            if (r3 == r4) goto L67
            goto L36
        L2f:
            r5 = 2048(0x800, double:1.012E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L36
            goto L67
        L36:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            if (r4 != 0) goto L4e
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            if (r3 == 0) goto L67
        L4e:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L67 java.lang.Throwable -> L83
        L67:
            java.io.InputStream r2 = r9.j     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L83
            r2.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L83
            goto L74
        L6d:
            r2 = move-exception
            com.google.ads.interactivemedia.v3.internal.acn r3 = new com.google.ads.interactivemedia.v3.internal.acn     // Catch: java.lang.Throwable -> L83
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L83
            throw r3     // Catch: java.lang.Throwable -> L83
        L74:
            r9.j = r0
            r9.k()
            boolean r0 = r9.k
            if (r0 == 0) goto L82
            r9.k = r1
            r9.j()
        L82:
            return
        L83:
            r2 = move-exception
            r9.j = r0
            r9.k()
            boolean r0 = r9.k
            if (r0 == 0) goto L92
            r9.k = r1
            r9.j()
        L92:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aci.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007b A[Catch: IOException -> 0x0092, TryCatch #0 {IOException -> 0x0092, blocks: (B:2:0x0000, B:21:0x005a, B:23:0x0062, B:26:0x006d, B:27:0x0073, B:29:0x007b, B:32:0x0082, B:33:0x0087, B:34:0x0088, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x003c, B:14:0x0046, B:15:0x004b, B:16:0x004c, B:17:0x0051, B:18:0x0052), top: B:40:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088 A[Catch: IOException -> 0x0092, TRY_LEAVE, TryCatch #0 {IOException -> 0x0092, blocks: (B:2:0x0000, B:21:0x005a, B:23:0x0062, B:26:0x006d, B:27:0x0073, B:29:0x007b, B:32:0x0082, B:33:0x0087, B:34:0x0088, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x003c, B:14:0x0046, B:15:0x004b, B:16:0x004c, B:17:0x0051, B:18:0x0052), top: B:40:0x0000 }] */
    @Override // com.google.ads.interactivemedia.v3.internal.abu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(byte[] r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            long r0 = r8.o     // Catch: java.io.IOException -> L92
            long r2 = r8.m     // Catch: java.io.IOException -> L92
            r4 = 0
            r5 = -1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto Lb
            goto L57
        Lb:
            java.util.concurrent.atomic.AtomicReference<byte[]> r0 = com.google.ads.interactivemedia.v3.internal.aci.b     // Catch: java.io.IOException -> L92
            r1 = 0
            java.lang.Object r0 = r0.getAndSet(r1)     // Catch: java.io.IOException -> L92
            byte[] r0 = (byte[]) r0     // Catch: java.io.IOException -> L92
            if (r0 != 0) goto L1a
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.io.IOException -> L92
        L1a:
            long r1 = r8.o     // Catch: java.io.IOException -> L92
            long r6 = r8.m     // Catch: java.io.IOException -> L92
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L52
            long r6 = r6 - r1
            int r1 = r0.length     // Catch: java.io.IOException -> L92
            long r1 = (long) r1     // Catch: java.io.IOException -> L92
            long r1 = java.lang.Math.min(r6, r1)     // Catch: java.io.IOException -> L92
            int r2 = (int) r1     // Catch: java.io.IOException -> L92
            java.io.InputStream r1 = r8.j     // Catch: java.io.IOException -> L92
            int r1 = r1.read(r0, r4, r2)     // Catch: java.io.IOException -> L92
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch: java.io.IOException -> L92
            boolean r2 = r2.isInterrupted()     // Catch: java.io.IOException -> L92
            if (r2 != 0) goto L4c
            if (r1 == r5) goto L46
            long r2 = r8.o     // Catch: java.io.IOException -> L92
            long r6 = (long) r1     // Catch: java.io.IOException -> L92
            long r2 = r2 + r6
            r8.o = r2     // Catch: java.io.IOException -> L92
            r8.i(r1)     // Catch: java.io.IOException -> L92
            goto L1a
        L46:
            java.io.EOFException r9 = new java.io.EOFException     // Catch: java.io.IOException -> L92
            r9.<init>()     // Catch: java.io.IOException -> L92
            throw r9     // Catch: java.io.IOException -> L92
        L4c:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.io.IOException -> L92
            r9.<init>()     // Catch: java.io.IOException -> L92
            throw r9     // Catch: java.io.IOException -> L92
        L52:
            java.util.concurrent.atomic.AtomicReference<byte[]> r1 = com.google.ads.interactivemedia.v3.internal.aci.b     // Catch: java.io.IOException -> L92
            r1.set(r0)     // Catch: java.io.IOException -> L92
        L57:
            if (r11 != 0) goto L5a
            goto L91
        L5a:
            long r0 = r8.n     // Catch: java.io.IOException -> L92
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L73
            long r6 = r8.p     // Catch: java.io.IOException -> L92
            long r0 = r0 - r6
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 != 0) goto L6d
        L6b:
            r4 = -1
            goto L91
        L6d:
            long r6 = (long) r11     // Catch: java.io.IOException -> L92
            long r0 = java.lang.Math.min(r6, r0)     // Catch: java.io.IOException -> L92
            int r11 = (int) r0     // Catch: java.io.IOException -> L92
        L73:
            java.io.InputStream r0 = r8.j     // Catch: java.io.IOException -> L92
            int r4 = r0.read(r9, r10, r11)     // Catch: java.io.IOException -> L92
            if (r4 != r5) goto L88
            long r9 = r8.n     // Catch: java.io.IOException -> L92
            int r11 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r11 != 0) goto L82
            goto L6b
        L82:
            java.io.EOFException r9 = new java.io.EOFException     // Catch: java.io.IOException -> L92
            r9.<init>()     // Catch: java.io.IOException -> L92
            throw r9     // Catch: java.io.IOException -> L92
        L88:
            long r9 = r8.p     // Catch: java.io.IOException -> L92
            long r0 = (long) r4     // Catch: java.io.IOException -> L92
            long r9 = r9 + r0
            r8.p = r9     // Catch: java.io.IOException -> L92
            r8.i(r4)     // Catch: java.io.IOException -> L92
        L91:
            return r4
        L92:
            r9 = move-exception
            com.google.ads.interactivemedia.v3.internal.acn r10 = new com.google.ads.interactivemedia.v3.internal.acn
            r10.<init>(r9)
            goto L9a
        L99:
            throw r10
        L9a:
            goto L99
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aci.a(byte[], int, int):int");
    }
}
