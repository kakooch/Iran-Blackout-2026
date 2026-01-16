package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC22885vz1;
import ir.nasim.AbstractC9683aN7;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class DataChunk extends Chunk {
    private byte[] j;
    private volatile boolean k;

    public DataChunk(a aVar, b bVar, int i, X x, int i2, Object obj, byte[] bArr) {
        DataChunk dataChunk;
        byte[] bArr2;
        super(aVar, bVar, i, x, i2, obj, -9223372036854775807L, -9223372036854775807L);
        if (bArr == null) {
            bArr2 = AbstractC9683aN7.f;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.j = bArr2;
    }

    private void i(int i) {
        byte[] bArr = this.j;
        if (bArr.length < i + 16384) {
            this.j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() {
        try {
            this.i.b(this.b);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.k) {
                i(i2);
                i = this.i.read(this.j, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.k) {
                g(this.j, i2);
            }
            AbstractC22885vz1.a(this.i);
        } catch (Throwable th) {
            AbstractC22885vz1.a(this.i);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
        this.k = true;
    }

    protected abstract void g(byte[] bArr, int i);

    public byte[] h() {
        return this.j;
    }
}
