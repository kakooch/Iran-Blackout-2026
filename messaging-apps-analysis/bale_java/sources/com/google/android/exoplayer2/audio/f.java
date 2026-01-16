package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import ir.nasim.AbstractC20011rK;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class f extends e {
    private int[] i;
    private int[] j;

    f() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) AbstractC20011rK.e(this.j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferL = l(((iLimit - iPosition) / this.b.d) * this.c.d);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferL.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.b.d;
        }
        byteBuffer.position(iLimit);
        byteBufferL.flip();
    }

    @Override // com.google.android.exoplayer2.audio.e
    public AudioProcessor.a h(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.i;
        if (iArr == null) {
            return AudioProcessor.a.e;
        }
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z = aVar.b != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= aVar.b) {
                throw new AudioProcessor.UnhandledAudioFormatException(aVar);
            }
            z |= i2 != i;
            i++;
        }
        return z ? new AudioProcessor.a(aVar.a, iArr.length, 2) : AudioProcessor.a.e;
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void i() {
        this.j = this.i;
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void k() {
        this.j = null;
        this.i = null;
    }

    public void m(int[] iArr) {
        this.i = iArr;
    }
}
