package com.google.android.exoplayer2.source.mediaparser;

import android.media.MediaParser$SeekableInputReader;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC18631oz1;

/* loaded from: classes2.dex */
public final class InputReaderAdapterV30 implements MediaParser$SeekableInputReader {
    private InterfaceC18631oz1 a;
    private long b;
    private long c;
    private long d;

    public long a() {
        long j = this.d;
        this.d = -1L;
        return j;
    }

    public void b(long j) {
        this.c = j;
    }

    public void c(InterfaceC18631oz1 interfaceC18631oz1, long j) {
        this.a = interfaceC18631oz1;
        this.b = j;
        this.d = -1L;
    }

    public long getLength() {
        return this.b;
    }

    public long getPosition() {
        return this.c;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = ((InterfaceC18631oz1) AbstractC9683aN7.j(this.a)).read(bArr, i, i2);
        this.c += i3;
        return i3;
    }

    public void seekToPosition(long j) {
        this.d = j;
    }
}
