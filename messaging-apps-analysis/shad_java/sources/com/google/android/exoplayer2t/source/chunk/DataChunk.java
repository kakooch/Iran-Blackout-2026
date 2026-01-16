package com.google.android.exoplayer2t.source.chunk;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.upstream.DataSource;
import com.google.android.exoplayer2t.upstream.DataSpec;
import com.google.android.exoplayer2t.util.Util;
import java.io.IOException;
import java.util.Arrays;
import org.rbmain.messenger.LiteMode;

/* loaded from: classes.dex */
public abstract class DataChunk extends Chunk {
    private byte[] data;
    private volatile boolean loadCanceled;

    protected abstract void consume(byte[] bArr, int i) throws IOException;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    public byte[] getDataHolder() {
        return this.data;
    }

    @Override // com.google.android.exoplayer2t.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2t.upstream.Loader.Loadable
    public final void load() throws InterruptedException, IOException {
        try {
            this.dataSource.open(this.dataSpec);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.loadCanceled) {
                maybeExpandData(i2);
                i = this.dataSource.read(this.data, i2, LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, i2);
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }

    private void maybeExpandData(int i) {
        byte[] bArr = this.data;
        if (bArr == null) {
            this.data = new byte[LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM];
        } else if (bArr.length < i + LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) {
            this.data = Arrays.copyOf(bArr, bArr.length + LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
        }
    }
}
