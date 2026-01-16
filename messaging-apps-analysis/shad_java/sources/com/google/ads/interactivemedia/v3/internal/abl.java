package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abl extends abr {
    private final AssetManager a;
    private Uri b;
    private InputStream c;
    private long d;
    private boolean e;

    public abl(Context context) {
        super(false);
        this.a = context.getAssets();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new abk(e);
            }
        }
        InputStream inputStream = this.c;
        int i3 = aeu.a;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            if (this.d == -1) {
                return -1;
            }
            throw new abk(new EOFException());
        }
        long j2 = this.d;
        if (j2 != -1) {
            this.d = j2 - i4;
        }
        i(i4);
        return i4;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws IOException {
        try {
            Uri uri = acbVar.a;
            this.b = uri;
            String path = uri.getPath();
            ary.t(path);
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            g(acbVar);
            InputStream inputStreamOpen = this.a.open(path, 1);
            this.c = inputStreamOpen;
            if (inputStreamOpen.skip(acbVar.e) < acbVar.e) {
                throw new EOFException();
            }
            long j = acbVar.f;
            if (j != -1) {
                this.d = j;
            } else {
                long jAvailable = this.c.available();
                this.d = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.d = -1L;
                }
            }
            this.e = true;
            h(acbVar);
            return this.d;
        } catch (IOException e) {
            throw new abk(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws abk {
        this.b = null;
        try {
            try {
                InputStream inputStream = this.c;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.c = null;
                if (this.e) {
                    this.e = false;
                    j();
                }
            } catch (IOException e) {
                throw new abk(e);
            }
        } catch (Throwable th) {
            this.c = null;
            if (this.e) {
                this.e = false;
                j();
            }
            throw th;
        }
    }
}
