package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class k extends e {
    private final long i;
    private final long j;
    private final short k;
    private int l;
    private boolean m;
    private byte[] n;
    private byte[] o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private long t;

    public k() {
        this(150000L, 20000L, (short) 1024);
    }

    private int m(long j) {
        return (int) ((j * this.b.a) / 1000000);
    }

    private int n(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.k);
        int i = this.l;
        return ((iLimit / i) * i) + i;
    }

    private int o(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.k) {
                int i = this.l;
                return i * (iPosition / i);
            }
        }
        return byteBuffer.limit();
    }

    private void q(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        l(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.s = true;
        }
    }

    private void r(byte[] bArr, int i) {
        l(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.s = true;
        }
    }

    private void s(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iO = o(byteBuffer);
        int iPosition = iO - byteBuffer.position();
        byte[] bArr = this.n;
        int length = bArr.length;
        int i = this.q;
        int i2 = length - i;
        if (iO < iLimit && iPosition < i2) {
            r(bArr, i);
            this.q = 0;
            this.p = 0;
            return;
        }
        int iMin = Math.min(iPosition, i2);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.n, this.q, iMin);
        int i3 = this.q + iMin;
        this.q = i3;
        byte[] bArr2 = this.n;
        if (i3 == bArr2.length) {
            if (this.s) {
                r(bArr2, this.r);
                this.t += (this.q - (this.r * 2)) / this.l;
            } else {
                this.t += (i3 - this.r) / this.l;
            }
            w(byteBuffer, this.n, this.q);
            this.q = 0;
            this.p = 2;
        }
        byteBuffer.limit(iLimit);
    }

    private void t(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.n.length));
        int iN = n(byteBuffer);
        if (iN == byteBuffer.position()) {
            this.p = 1;
        } else {
            byteBuffer.limit(iN);
            q(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void u(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iO = o(byteBuffer);
        byteBuffer.limit(iO);
        this.t += byteBuffer.remaining() / this.l;
        w(byteBuffer, this.o, this.r);
        if (iO < iLimit) {
            r(this.o, this.r);
            this.p = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private void w(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.r);
        int i2 = this.r - iMin;
        System.arraycopy(bArr, i - i2, this.o, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.o, i2, iMin);
    }

    @Override // com.google.android.exoplayer2.audio.e, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i = this.p;
            if (i == 0) {
                t(byteBuffer);
            } else if (i == 1) {
                s(byteBuffer);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                u(byteBuffer);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.e
    public AudioProcessor.a h(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c == 2) {
            return this.m ? aVar : AudioProcessor.a.e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void i() {
        if (this.m) {
            this.l = this.b.d;
            int iM = m(this.i) * this.l;
            if (this.n.length != iM) {
                this.n = new byte[iM];
            }
            int iM2 = m(this.j) * this.l;
            this.r = iM2;
            if (this.o.length != iM2) {
                this.o = new byte[iM2];
            }
        }
        this.p = 0;
        this.t = 0L;
        this.q = 0;
        this.s = false;
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void j() {
        int i = this.q;
        if (i > 0) {
            r(this.n, i);
        }
        if (this.s) {
            return;
        }
        this.t += this.r / this.l;
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void k() {
        this.m = false;
        this.r = 0;
        byte[] bArr = AbstractC9683aN7.f;
        this.n = bArr;
        this.o = bArr;
    }

    public long p() {
        return this.t;
    }

    public void v(boolean z) {
        this.m = z;
    }

    public k(long j, long j2, short s) {
        AbstractC20011rK.a(j2 <= j);
        this.i = j;
        this.j = j2;
        this.k = s;
        byte[] bArr = AbstractC9683aN7.f;
        this.n = bArr;
        this.o = bArr;
    }
}
