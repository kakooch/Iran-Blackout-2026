package com.google.android.exoplayer2.mediacodec;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import ir.nasim.AbstractC20011rK;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class f extends DecoderInputBuffer {
    private long i;
    private int j;
    private int k;

    public f() {
        super(2);
        this.k = 32;
    }

    private boolean F(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!J()) {
            return true;
        }
        if (this.j >= this.k || decoderInputBuffer.t() != t()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.c;
        return byteBuffer2 == null || (byteBuffer = this.c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public boolean E(DecoderInputBuffer decoderInputBuffer) {
        AbstractC20011rK.a(!decoderInputBuffer.B());
        AbstractC20011rK.a(!decoderInputBuffer.s());
        AbstractC20011rK.a(!decoderInputBuffer.u());
        if (!F(decoderInputBuffer)) {
            return false;
        }
        int i = this.j;
        this.j = i + 1;
        if (i == 0) {
            this.e = decoderInputBuffer.e;
            if (decoderInputBuffer.w()) {
                x(1);
            }
        }
        if (decoderInputBuffer.t()) {
            x(RecyclerView.UNDEFINED_DURATION);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.c;
        if (byteBuffer != null) {
            z(byteBuffer.remaining());
            this.c.put(byteBuffer);
        }
        this.i = decoderInputBuffer.e;
        return true;
    }

    public long G() {
        return this.e;
    }

    public long H() {
        return this.i;
    }

    public int I() {
        return this.j;
    }

    public boolean J() {
        return this.j > 0;
    }

    public void K(int i) {
        AbstractC20011rK.a(i > 0);
        this.k = i;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, ir.nasim.AbstractC5461Jl0
    public void p() {
        super.p();
        this.j = 0;
    }
}
