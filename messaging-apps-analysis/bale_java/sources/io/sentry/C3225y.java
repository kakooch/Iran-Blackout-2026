package io.sentry;

import java.io.StringReader;
import java.nio.charset.Charset;

/* renamed from: io.sentry.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3225y implements P {
    private static final Charset b = Charset.forName("UTF-8");
    private final InterfaceC3107e0 a;

    public C3225y(InterfaceC3107e0 interfaceC3107e0) {
        this.a = interfaceC3107e0;
    }

    private C3139k2 b(byte[] bArr, int i, int i2) {
        StringReader stringReader = new StringReader(new String(bArr, i, i2, b));
        try {
            C3139k2 c3139k2 = (C3139k2) this.a.c(stringReader, C3139k2.class);
            stringReader.close();
            return c3139k2;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private K2 c(byte[] bArr, int i, int i2) {
        StringReader stringReader = new StringReader(new String(bArr, i, i2, b));
        try {
            K2 k2 = (K2) this.a.c(stringReader, K2.class);
            stringReader.close();
            return k2;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
    
        r11 = new io.sentry.C3134j2(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008c, code lost:
    
        return r11;
     */
    @Override // io.sentry.P
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.C3134j2 a(java.io.InputStream r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.C3225y.a(java.io.InputStream):io.sentry.j2");
    }
}
