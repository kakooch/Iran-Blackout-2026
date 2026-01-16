package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class anp {
    private final ano a;
    private final ani b;
    private final ats c;

    anp(ani aniVar) {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        ann annVar = new ann(null);
        this.c = atv.a(executorServiceNewCachedThreadPool);
        this.a = annVar;
        this.b = aniVar;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0099: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x0099 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static final /* synthetic */ com.google.ads.interactivemedia.v3.impl.data.bi c(com.google.ads.interactivemedia.v3.impl.data.bh r9) throws java.lang.Exception {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            java.lang.String r3 = r9.url()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            java.lang.String r1 = "User-Agent"
            java.lang.String r3 = r9.userAgent()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            r2.setRequestProperty(r1, r3)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            int r1 = r9.connectionTimeoutMs()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            r2.setConnectTimeout(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            int r1 = r9.readTimeoutMs()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            r2.setReadTimeout(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            com.google.ads.interactivemedia.v3.impl.data.bg r1 = r9.requestType()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            com.google.ads.interactivemedia.v3.impl.data.bg r3 = com.google.ads.interactivemedia.v3.impl.data.bg.POST     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            if (r1 != r3) goto L39
            r1 = 1
            r2.setDoOutput(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            r1 = 0
            r2.setChunkedStreamingMode(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
        L39:
            java.io.InputStream r1 = r2.getInputStream()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L70
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L70
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r4.<init>()     // Catch: java.lang.Throwable -> L70
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L70
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L70
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L70
            r6.<init>(r3, r7)     // Catch: java.lang.Throwable -> L70
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L70
        L53:
            java.lang.String r3 = r5.readLine()     // Catch: java.lang.Throwable -> L70
            if (r3 == 0) goto L5d
            r4.append(r3)     // Catch: java.lang.Throwable -> L70
            goto L53
        L5d:
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L66
            r1.close()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
        L66:
            java.lang.String r0 = r2.getContentType()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
            r2.disconnect()
            r1 = r0
            r0 = r3
            goto L8f
        L70:
            r3 = move-exception
            if (r1 == 0) goto L7b
            r1.close()     // Catch: java.lang.Throwable -> L77
            goto L7b
        L77:
            r1 = move-exception
            com.google.ads.interactivemedia.v3.internal.auf.a(r3, r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
        L7b:
            throw r3     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L98
        L7c:
            r1 = move-exception
            goto L84
        L7e:
            r9 = move-exception
            goto L9a
        L80:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L84:
            java.lang.String r3 = "Failed to make native network request"
            com.google.ads.interactivemedia.v3.internal.yy.e(r3, r1)     // Catch: java.lang.Throwable -> L98
            if (r2 == 0) goto L8e
            r2.disconnect()
        L8e:
            r1 = r0
        L8f:
            java.lang.String r9 = r9.id()
            com.google.ads.interactivemedia.v3.impl.data.bi r9 = com.google.ads.interactivemedia.v3.impl.data.bi.create(r9, r0, r1)
            return r9
        L98:
            r9 = move-exception
            r1 = r2
        L9a:
            if (r1 == 0) goto L9f
            r1.disconnect()
        L9f:
            goto La1
        La0:
            throw r9
        La1:
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.anp.c(com.google.ads.interactivemedia.v3.impl.data.bh):com.google.ads.interactivemedia.v3.impl.data.bi");
    }

    final void a(amw amwVar, String str, final com.google.ads.interactivemedia.v3.impl.data.bh bhVar) {
        amw amwVar2 = amw.activate;
        if (amwVar.ordinal() == 34) {
            atv.b(this.c.submit(new Callable(this, bhVar) { // from class: com.google.ads.interactivemedia.v3.internal.anl
                private final anp a;
                private final com.google.ads.interactivemedia.v3.impl.data.bh b;

                {
                    this.a = this;
                    this.b = bhVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return anp.c(this.b);
                }
            }), new anm(this, str), this.c);
            return;
        }
        String strValueOf = String.valueOf(amwVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
        sb.append("Unexpected network request of type");
        sb.append(strValueOf);
        yy.c(sb.toString());
    }
}
