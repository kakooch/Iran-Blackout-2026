package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
public final class m implements AudioProcessor {
    private int b;
    private float c = 1.0f;
    private float d = 1.0f;
    private AudioProcessor.a e;
    private AudioProcessor.a f;
    private AudioProcessor.a g;
    private AudioProcessor.a h;
    private boolean i;
    private l j;
    private ByteBuffer k;
    private ShortBuffer l;
    private ByteBuffer m;
    private long n;
    private long o;
    private boolean p;

    public m() {
        AudioProcessor.a aVar = AudioProcessor.a.e;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
    }

    public long a(long j) {
        if (this.o < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return (long) (this.c * j);
        }
        long jL = this.n - ((l) AbstractC20011rK.e(this.j)).l();
        int i = this.h.a;
        int i2 = this.g.a;
        return i == i2 ? AbstractC9683aN7.N0(j, jL, this.o) : AbstractC9683aN7.N0(j, jL * i, this.o * i2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return this.f.a != -1 && (Math.abs(this.c - 1.0f) >= 1.0E-4f || Math.abs(this.d - 1.0f) >= 1.0E-4f || this.f.a != this.e.a);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer c() {
        int iK;
        l lVar = this.j;
        if (lVar != null && (iK = lVar.k()) > 0) {
            if (this.k.capacity() < iK) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iK).order(ByteOrder.nativeOrder());
                this.k = byteBufferOrder;
                this.l = byteBufferOrder.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            lVar.j(this.l);
            this.o += iK;
            this.k.limit(iK);
            this.m = this.k;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = AudioProcessor.a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean d() {
        l lVar;
        return this.p && ((lVar = this.j) == null || lVar.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            l lVar = (l) AbstractC20011rK.e(this.j);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.n += iRemaining;
            lVar.t(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a f(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i = this.b;
        if (i == -1) {
            i = aVar.a;
        }
        this.e = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i, aVar.b, 2);
        this.f = aVar2;
        this.i = true;
        return aVar2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (b()) {
            AudioProcessor.a aVar = this.e;
            this.g = aVar;
            AudioProcessor.a aVar2 = this.f;
            this.h = aVar2;
            if (this.i) {
                this.j = new l(aVar.a, aVar.b, this.c, this.d, aVar2.a);
            } else {
                l lVar = this.j;
                if (lVar != null) {
                    lVar.i();
                }
            }
        }
        this.m = AudioProcessor.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void g() {
        l lVar = this.j;
        if (lVar != null) {
            lVar.s();
        }
        this.p = true;
    }

    public void h(float f) {
        if (this.d != f) {
            this.d = f;
            this.i = true;
        }
    }

    public void i(float f) {
        if (this.c != f) {
            this.c = f;
            this.i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.e;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}
