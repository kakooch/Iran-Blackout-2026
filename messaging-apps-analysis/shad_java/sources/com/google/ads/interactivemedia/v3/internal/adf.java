package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class adf extends abr {
    private final Resources a;
    private final String b;
    private Uri c;
    private AssetFileDescriptor d;
    private InputStream e;
    private long f;
    private boolean g;

    public adf(Context context) {
        super(false);
        this.a = context.getResources();
        this.b = context.getPackageName();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new ade(e);
            }
        }
        InputStream inputStream = this.e;
        int i3 = aeu.a;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new ade(new EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - i4;
        }
        i(i4);
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.v3.internal.abx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long c(com.google.ads.interactivemedia.v3.internal.acb r8) throws android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adf.c(com.google.ads.interactivemedia.v3.internal.acb):long");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws ade {
        this.c = null;
        try {
            try {
                InputStream inputStream = this.e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.d = null;
                        if (this.g) {
                            this.g = false;
                            j();
                        }
                    }
                } catch (IOException e) {
                    throw new ade(e);
                }
            } catch (IOException e2) {
                throw new ade(e2);
            }
        } catch (Throwable th) {
            this.e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        j();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new ade(e3);
                }
            } catch (Throwable th2) {
                this.d = null;
                if (this.g) {
                    this.g = false;
                    j();
                }
                throw th2;
            }
        }
    }
}
