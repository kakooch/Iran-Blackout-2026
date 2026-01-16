package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class acl extends abr {
    private RandomAccessFile a;
    private Uri b;
    private long c;
    private boolean d;

    public acl() {
        super(false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.c;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.a;
            int i3 = aeu.a;
            int i4 = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (i4 > 0) {
                this.c -= i4;
                i(i4);
            }
            return i4;
        } catch (IOException e) {
            throw new ack(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws IOException {
        try {
            Uri uri = acbVar.a;
            this.b = uri;
            g(acbVar);
            try {
                String path = uri.getPath();
                ary.t(path);
                RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
                this.a = randomAccessFile;
                randomAccessFile.seek(acbVar.e);
                long length = acbVar.f;
                if (length == -1) {
                    length = this.a.length() - acbVar.e;
                }
                this.c = length;
                if (length < 0) {
                    throw new EOFException();
                }
                this.d = true;
                h(acbVar);
                return this.c;
            } catch (FileNotFoundException e) {
                if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                    throw new ack(e);
                }
                throw new ack(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e);
            }
        } catch (IOException e2) {
            throw new ack(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws ack {
        this.b = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.a;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.a = null;
                if (this.d) {
                    this.d = false;
                    j();
                }
            } catch (IOException e) {
                throw new ack(e);
            }
        } catch (Throwable th) {
            this.a = null;
            if (this.d) {
                this.d = false;
                j();
            }
            throw th;
        }
    }
}
