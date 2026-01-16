package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import ir.nasim.AbstractC20011rK;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class n extends e {
    private final a i;

    public interface a {
        void a(ByteBuffer byteBuffer);

        void b(int i, int i2, int i3);
    }

    public n(a aVar) {
        this.i = (a) AbstractC20011rK.e(aVar);
    }

    private void m() {
        if (b()) {
            a aVar = this.i;
            AudioProcessor.a aVar2 = this.b;
            aVar.b(aVar2.a, aVar2.b, aVar2.c);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void e(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        this.i.a(byteBuffer.asReadOnlyBuffer());
        l(iRemaining).put(byteBuffer).flip();
    }

    @Override // com.google.android.exoplayer2.audio.e
    public AudioProcessor.a h(AudioProcessor.a aVar) {
        return aVar;
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void i() {
        m();
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void j() {
        m();
    }

    @Override // com.google.android.exoplayer2.audio.e
    protected void k() {
        m();
    }
}
