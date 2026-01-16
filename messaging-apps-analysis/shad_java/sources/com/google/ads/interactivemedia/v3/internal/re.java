package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class re {
    private final ByteArrayOutputStream a;
    private final DataOutputStream b;

    public re() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    private static void c(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeByte(((int) (j >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j) & 255);
    }

    public final byte[] a(rc rcVar) throws IOException {
        this.a.reset();
        try {
            b(this.b, rcVar.a);
            String str = rcVar.b;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            b(this.b, str);
            c(this.b, rcVar.c);
            c(this.b, rcVar.d);
            this.b.write(rcVar.e);
            this.b.flush();
            return this.a.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
