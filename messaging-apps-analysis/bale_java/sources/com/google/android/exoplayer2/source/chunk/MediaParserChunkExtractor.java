package com.google.android.exoplayer2.source.chunk;

import android.media.MediaParser;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import ir.nasim.C3583Bm0;
import ir.nasim.FY3;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.InterfaceC9845af2;
import ir.nasim.P12;

/* loaded from: classes2.dex */
public final class MediaParserChunkExtractor implements ChunkExtractor {
    public static final ChunkExtractor.Factory i = new C3583Bm0();
    private final OutputConsumerAdapterV30 a;
    private final InputReaderAdapterV30 b;
    private final MediaParser c;
    private final TrackOutputProviderAdapter d;
    private final P12 e;
    private long f;
    private ChunkExtractor.TrackOutputProvider g;
    private X[] h;

    private void g() {
        MediaParser.SeekMap seekMapC = this.a.c();
        long j = this.f;
        if (j == -9223372036854775807L || seekMapC == null) {
            return;
        }
        this.c.seek(FY3.a(seekMapC.getSeekPoints(j).first));
        this.f = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean a(InterfaceC9845af2 interfaceC9845af2) {
        g();
        this.b.c(interfaceC9845af2, interfaceC9845af2.getLength());
        return this.c.advance(this.b);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void c(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2) {
        this.g = trackOutputProvider;
        this.a.n(j2);
        this.a.l(this.d);
        this.f = j;
    }

    private class TrackOutputProviderAdapter implements InterfaceC10465bf2 {
        final /* synthetic */ MediaParserChunkExtractor a;

        @Override // ir.nasim.InterfaceC10465bf2
        public InterfaceC4589Ft7 b(int i, int i2) {
            return this.a.g != null ? this.a.g.b(i, i2) : this.a.e;
        }

        @Override // ir.nasim.InterfaceC10465bf2
        public void s() {
            MediaParserChunkExtractor mediaParserChunkExtractor = this.a;
            mediaParserChunkExtractor.h = mediaParserChunkExtractor.a.g();
        }

        @Override // ir.nasim.InterfaceC10465bf2
        public void o(InterfaceC22148uk6 interfaceC22148uk6) {
        }
    }
}
