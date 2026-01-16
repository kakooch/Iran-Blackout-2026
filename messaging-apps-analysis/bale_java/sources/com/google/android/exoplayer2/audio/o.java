package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import ir.nasim.AbstractC9683aN7;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class o extends e {
    private int i;
    private int j;
    private boolean k;
    private int l;
    private byte[] m = AbstractC9683aN7.f;
    private int n;
    private long o;

    @Override // com.google.android.exoplayer2.audio.e, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer c() {
        int i;
        if (super.d() && (i = this.n) > 0) {
            l(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.c();
    }

    @Override // com.google.android.exoplayer2.audio.e, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean d() {
        return super.d() && this.n == 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.l);
        this.o += iMin / this.b.d;
        this.l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.l > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.n + i2) - this.m.length;
        ByteBuffer byteBufferL = l(length);
        int iP = AbstractC9683aN7.p(length, 0, this.n);
        byteBufferL.put(this.m, 0, iP);
        int iP2 = AbstractC9683aN7.p(length - iP, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iP2);
        byteBufferL.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iP2;
        int i4 = this.n - iP;
        this.n = i4;
        byte[] bArr = this.m;
        System.arraycopy(bArr, iP, bArr, 0, i4);
        byteBuffer.get(this.m, this.n, i3);
        this.n += i3;
        byteBufferL.flip();
    }

    @Override // com.google.android.exoplayer2.audio.e
    public AudioProcessor.a h(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.k = true;
        return (this.i == 0 && this.j == 0) ? AudioProcessor.a.e : aVar;
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void i() {
        if (this.k) {
            this.k = false;
            int i = this.j;
            int i2 = this.b.d;
            this.m = new byte[i * i2];
            this.l = this.i * i2;
        }
        this.n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void j() {
        if (this.k) {
            if (this.n > 0) {
                this.o += r0 / this.b.d;
            }
            this.n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void k() {
        this.m = AbstractC9683aN7.f;
    }

    public long m() {
        return this.o;
    }

    public void n() {
        this.o = 0L;
    }

    public void o(int i, int i2) {
        this.i = i;
        this.j = i2;
    }
}
