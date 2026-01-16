package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC20422rz1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class CacheDataSink implements InterfaceC20422rz1 {
    private final Cache a;
    private final long b;
    private final int c;
    private com.google.android.exoplayer2.upstream.b d;
    private long e;
    private File f;
    private OutputStream g;
    private long h;
    private long i;
    private g j;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public static final class a implements InterfaceC20422rz1.a {
        private Cache a;
        private long b = 5242880;
        private int c = 20480;

        @Override // ir.nasim.InterfaceC20422rz1.a
        public InterfaceC20422rz1 a() {
            return new CacheDataSink((Cache) AbstractC20011rK.e(this.a), this.b, this.c);
        }

        public a b(Cache cache) {
            this.a = cache;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j, int i) {
        AbstractC20011rK.h(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < 2097152) {
            AbstractC18815pI3.k("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.a = (Cache) AbstractC20011rK.e(cache);
        this.b = j == -1 ? Long.MAX_VALUE : j;
        this.c = i;
    }

    private void a() throws IOException {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            AbstractC9683aN7.m(this.g);
            this.g = null;
            File file = (File) AbstractC9683aN7.j(this.f);
            this.f = null;
            this.a.j(file, this.h);
        } catch (Throwable th) {
            AbstractC9683aN7.m(this.g);
            this.g = null;
            File file2 = (File) AbstractC9683aN7.j(this.f);
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    private void c(com.google.android.exoplayer2.upstream.b bVar) {
        long j = bVar.h;
        this.f = this.a.a((String) AbstractC9683aN7.j(bVar.i), bVar.g + this.i, j != -1 ? Math.min(j - this.i, this.e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
        if (this.c > 0) {
            g gVar = this.j;
            if (gVar == null) {
                this.j = new g(fileOutputStream, this.c);
            } else {
                gVar.a(fileOutputStream);
            }
            this.g = this.j;
        } else {
            this.g = fileOutputStream;
        }
        this.h = 0L;
    }

    @Override // ir.nasim.InterfaceC20422rz1
    public void b(com.google.android.exoplayer2.upstream.b bVar) throws CacheDataSinkException {
        AbstractC20011rK.e(bVar.i);
        if (bVar.h == -1 && bVar.d(2)) {
            this.d = null;
            return;
        }
        this.d = bVar;
        this.e = bVar.d(4) ? this.b : Long.MAX_VALUE;
        this.i = 0L;
        try {
            c(bVar);
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // ir.nasim.InterfaceC20422rz1
    public void close() throws CacheDataSinkException {
        if (this.d == null) {
            return;
        }
        try {
            a();
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // ir.nasim.InterfaceC20422rz1
    public void write(byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.upstream.b bVar = this.d;
        if (bVar == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.e) {
                    a();
                    c(bVar);
                }
                int iMin = (int) Math.min(i2 - i3, this.e - this.h);
                ((OutputStream) AbstractC9683aN7.j(this.g)).write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.h += j;
                this.i += j;
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }
}
