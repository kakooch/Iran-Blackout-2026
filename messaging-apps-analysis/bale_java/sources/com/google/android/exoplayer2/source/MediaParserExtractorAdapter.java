package com.google.android.exoplayer2.source;

import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.source.MediaParserExtractorAdapter;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C8292Vi5;
import ir.nasim.FY3;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC18631oz1;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MediaParserExtractorAdapter implements ProgressiveMediaExtractor {
    public static final ProgressiveMediaExtractor.Factory e = new ProgressiveMediaExtractor.Factory() { // from class: ir.nasim.MY3
        @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor.Factory
        public final ProgressiveMediaExtractor a(C15493jg5 c15493jg5) {
            return new MediaParserExtractorAdapter(c15493jg5);
        }
    };
    private final OutputConsumerAdapterV30 a;
    private final InputReaderAdapterV30 b;
    private final MediaParser c;
    private String d;

    public MediaParserExtractorAdapter(C15493jg5 c15493jg5) {
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        this.a = outputConsumerAdapterV30;
        this.b = new InputReaderAdapterV30();
        MediaParser mediaParserCreate = MediaParser.create(outputConsumerAdapterV30, new String[0]);
        this.c = mediaParserCreate;
        Boolean bool = Boolean.TRUE;
        mediaParserCreate.setParameter("android.media.mediaparser.eagerlyExposeTrackType", bool);
        mediaParserCreate.setParameter("android.media.mediaparser.inBandCryptoInfo", bool);
        mediaParserCreate.setParameter("android.media.mediaparser.includeSupplementalData", bool);
        this.d = "android.media.mediaparser.UNKNOWN";
        if (AbstractC9683aN7.a >= 31) {
            MediaParserUtil.a(mediaParserCreate, c15493jg5);
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void a(long j, long j2) {
        this.b.b(j);
        Pair pairH = this.a.h(j2);
        this.c.seek(FY3.a(FY3.a(pairH.second).position == j ? pairH.second : pairH.first));
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public int b(C8292Vi5 c8292Vi5) throws IOException {
        boolean zAdvance = this.c.advance(this.b);
        long jA = this.b.a();
        c8292Vi5.a = jA;
        if (zAdvance) {
            return jA != -1 ? 1 : 0;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void c(InterfaceC18631oz1 interfaceC18631oz1, Uri uri, Map map, long j, long j2, InterfaceC10465bf2 interfaceC10465bf2) throws IOException {
        this.a.l(interfaceC10465bf2);
        this.b.c(interfaceC18631oz1, j2);
        this.b.b(j);
        String parserName = this.c.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(parserName)) {
            this.c.advance(this.b);
            String parserName2 = this.c.getParserName();
            this.d = parserName2;
            this.a.o(parserName2);
            return;
        }
        if (parserName.equals(this.d)) {
            return;
        }
        String parserName3 = this.c.getParserName();
        this.d = parserName3;
        this.a.o(parserName3);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void d() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.d)) {
            this.a.a();
        }
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public long e() {
        return this.b.getPosition();
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor
    public void release() {
        this.c.release();
    }
}
