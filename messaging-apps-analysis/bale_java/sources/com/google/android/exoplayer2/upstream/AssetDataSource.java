package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.gov.nist.core.Separators;
import android.net.Uri;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.G90;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.xbill.DNS.TTL;

/* loaded from: classes2.dex */
public final class AssetDataSource extends G90 {
    private final AssetManager e;
    private Uri f;
    private InputStream g;
    private long h;
    private boolean i;

    public static final class AssetDataSourceException extends DataSourceException {
        public AssetDataSourceException(Throwable th, int i) {
            super(th, i);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(b bVar) throws IOException {
        try {
            Uri uri = bVar.a;
            this.f = uri;
            String strSubstring = (String) AbstractC20011rK.e(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith(Separators.SLASH)) {
                strSubstring = strSubstring.substring(1);
            }
            p(bVar);
            InputStream inputStreamOpen = this.e.open(strSubstring, 1);
            this.g = inputStreamOpen;
            if (inputStreamOpen.skip(bVar.g) < bVar.g) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j = bVar.h;
            if (j != -1) {
                this.h = j;
            } else {
                long jAvailable = this.g.available();
                this.h = jAvailable;
                if (jAvailable == TTL.MAX_VALUE) {
                    this.h = -1L;
                }
            }
            this.i = true;
            q(bVar);
            return this.h;
        } catch (AssetDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        this.f = null;
        try {
            try {
                InputStream inputStream = this.g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new AssetDataSourceException(e, 2000);
            }
        } finally {
            this.g = null;
            if (this.i) {
                this.i = false;
                o();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.h;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new AssetDataSourceException(e, 2000);
            }
        }
        int i3 = ((InputStream) AbstractC9683aN7.j(this.g)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        long j2 = this.h;
        if (j2 != -1) {
            this.h = j2 - i3;
        }
        n(i3);
        return i3;
    }
}
