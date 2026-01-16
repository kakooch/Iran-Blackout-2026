package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.a;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.G90;
import ir.nasim.InterfaceC25209zu7;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public final class FileDataSource extends G90 {
    private RandomAccessFile e;
    private Uri f;
    private long g;
    private boolean h;

    public static class FileDataSourceException extends DataSourceException {
        public FileDataSourceException(Throwable th, int i) {
            super(th, i);
        }

        public FileDataSourceException(String str, Throwable th, int i) {
            super(str, th, i);
        }
    }

    private static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public static final class b implements a.InterfaceC0163a {
        private InterfaceC25209zu7 a;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            InterfaceC25209zu7 interfaceC25209zu7 = this.a;
            if (interfaceC25209zu7 != null) {
                fileDataSource.i(interfaceC25209zu7);
            }
            return fileDataSource;
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile r(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) AbstractC20011rK.e(uri.getPath()), "r");
        } catch (FileNotFoundException e) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e, (AbstractC9683aN7.a < 21 || !a.b(e.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e, 1004);
        } catch (SecurityException e2) {
            throw new FileDataSourceException(e2, 2006);
        } catch (RuntimeException e3) {
            throw new FileDataSourceException(e3, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        Uri uri = bVar.a;
        this.f = uri;
        p(bVar);
        RandomAccessFile randomAccessFileR = r(uri);
        this.e = randomAccessFileR;
        try {
            randomAccessFileR.seek(bVar.g);
            long length = bVar.h;
            if (length == -1) {
                length = this.e.length() - bVar.g;
            }
            this.g = length;
            if (length < 0) {
                throw new FileDataSourceException(null, null, 2008);
            }
            this.h = true;
            q(bVar);
            return this.g;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        this.f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } finally {
            this.e = null;
            if (this.h) {
                this.h = false;
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
        if (this.g == 0) {
            return -1;
        }
        try {
            int i3 = ((RandomAccessFile) AbstractC9683aN7.j(this.e)).read(bArr, i, (int) Math.min(this.g, i2));
            if (i3 > 0) {
                this.g -= i3;
                n(i3);
            }
            return i3;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }
}
