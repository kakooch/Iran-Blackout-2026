package ir.eitaa.messenger.audioinfo.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class PositionInputStream extends FilterInputStream {
    private long position;
    private long positionMark;

    public PositionInputStream(InputStream delegate) {
        this(delegate, 0L);
    }

    public PositionInputStream(InputStream delegate, long position) {
        super(delegate);
        this.position = position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readlimit) {
        this.positionMark = this.position;
        super.mark(readlimit);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.position = this.positionMark;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i >= 0) {
            this.position++;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        long j = this.position;
        int i = super.read(b, off, len);
        if (i > 0) {
            this.position = j + i;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n) throws IOException {
        long j = this.position;
        long jSkip = super.skip(n);
        this.position = j + jSkip;
        return jSkip;
    }

    public long getPosition() {
        return this.position;
    }
}
