package com.google.android.exoplayer2.source.hls;

import android.media.MediaParser;
import android.media.MediaParser$OutputConsumer;
import android.media.MediaParser$SeekableInputReader;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.hls.MediaParserHlsMediaChunkExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC5238Im2;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C5045Hq7;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC9845af2;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MediaParserHlsMediaChunkExtractor implements HlsMediaChunkExtractor {
    public static final HlsExtractorFactory i = new HlsExtractorFactory() { // from class: ir.nasim.PY3
        @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
        public final HlsMediaChunkExtractor a(Uri uri, com.google.android.exoplayer2.X x, List list, C5045Hq7 c5045Hq7, Map map, InterfaceC9845af2 interfaceC9845af2, C15493jg5 c15493jg5) {
            return MediaParserHlsMediaChunkExtractor.i(uri, x, list, c5045Hq7, map, interfaceC9845af2, c15493jg5);
        }
    };
    private final OutputConsumerAdapterV30 a;
    private final InputReaderAdapterV30 b = new InputReaderAdapterV30();
    private final MediaParser c;
    private final X d;
    private final boolean e;
    private final AbstractC12710f43 f;
    private final C15493jg5 g;
    private int h;

    private static final class PeekingInputReader implements MediaParser$SeekableInputReader {
        private final InterfaceC9845af2 a;
        private int b;

        public long getLength() {
            return this.a.getLength();
        }

        public long getPosition() {
            return this.a.g();
        }

        public int read(byte[] bArr, int i, int i2) {
            int iJ = this.a.j(bArr, i, i2);
            this.b += iJ;
            return iJ;
        }

        public void seekToPosition(long j) {
            throw new UnsupportedOperationException();
        }

        private PeekingInputReader(InterfaceC9845af2 interfaceC9845af2) {
            this.a = interfaceC9845af2;
        }
    }

    public MediaParserHlsMediaChunkExtractor(MediaParser mediaParser, OutputConsumerAdapterV30 outputConsumerAdapterV30, X x, boolean z, AbstractC12710f43 abstractC12710f43, int i2, C15493jg5 c15493jg5) {
        this.c = mediaParser;
        this.a = outputConsumerAdapterV30;
        this.e = z;
        this.f = abstractC12710f43;
        this.d = x;
        this.g = c15493jg5;
        this.h = i2;
    }

    private static MediaParser h(MediaParser$OutputConsumer mediaParser$OutputConsumer, X x, boolean z, AbstractC12710f43 abstractC12710f43, C15493jg5 c15493jg5, String... strArr) {
        MediaParser mediaParserCreateByName = strArr.length == 1 ? MediaParser.createByName(strArr[0], mediaParser$OutputConsumer) : MediaParser.create(mediaParser$OutputConsumer, strArr);
        mediaParserCreateByName.setParameter("android.media.mediaParser.exposeCaptionFormats", abstractC12710f43);
        mediaParserCreateByName.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", Boolean.valueOf(z));
        Boolean bool = Boolean.TRUE;
        mediaParserCreateByName.setParameter("android.media.mediaparser.inBandCryptoInfo", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.eagerlyExposeTrackType", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ignoreTimestampOffset", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", bool);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.mode", "hls");
        String str = x.i;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(AbstractC24462yf4.c(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAacStream", bool);
            }
            if (!"video/avc".equals(AbstractC24462yf4.n(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAvcStream", bool);
            }
        }
        if (AbstractC9683aN7.a >= 31) {
            MediaParserUtil.a(mediaParserCreateByName, c15493jg5);
        }
        return mediaParserCreateByName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HlsMediaChunkExtractor i(Uri uri, X x, List list, C5045Hq7 c5045Hq7, Map map, InterfaceC9845af2 interfaceC9845af2, C15493jg5 c15493jg5) throws IOException {
        if (AbstractC5238Im2.a(x.l) == 13) {
            return new BundledHlsMediaChunkExtractor(new WebvttExtractor(x.c, c5045Hq7), x, c5045Hq7);
        }
        boolean z = list != null;
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                aVarL.a(MediaParserUtil.b((X) list.get(i2)));
            }
        } else {
            aVarL.a(MediaParserUtil.b(new X.b().g0("application/cea-608").G()));
        }
        AbstractC12710f43 abstractC12710f43H = aVarL.h();
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        if (list == null) {
            list = AbstractC12710f43.V();
        }
        outputConsumerAdapterV30.m(list);
        outputConsumerAdapterV30.p(c5045Hq7);
        MediaParser mediaParserH = h(outputConsumerAdapterV30, x, z, abstractC12710f43H, c15493jg5, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        PeekingInputReader peekingInputReader = new PeekingInputReader(interfaceC9845af2);
        mediaParserH.advance(peekingInputReader);
        outputConsumerAdapterV30.o(mediaParserH.getParserName());
        return new MediaParserHlsMediaChunkExtractor(mediaParserH, outputConsumerAdapterV30, x, z, abstractC12710f43H, peekingInputReader.b, c15493jg5);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean a(InterfaceC9845af2 interfaceC9845af2) {
        interfaceC9845af2.k(this.h);
        this.h = 0;
        this.b.c(interfaceC9845af2, interfaceC9845af2.getLength());
        return this.c.advance(this.b);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.a.l(interfaceC10465bf2);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void c() {
        this.c.seek(MediaParser.SeekPoint.START);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean d() {
        String parserName = this.c.getParserName();
        return "android.media.mediaparser.FragmentedMp4Parser".equals(parserName) || "android.media.mediaparser.TsParser".equals(parserName);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean e() {
        String parserName = this.c.getParserName();
        return "android.media.mediaparser.Ac3Parser".equals(parserName) || "android.media.mediaparser.Ac4Parser".equals(parserName) || "android.media.mediaparser.AdtsParser".equals(parserName) || "android.media.mediaparser.Mp3Parser".equals(parserName);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public HlsMediaChunkExtractor f() {
        AbstractC20011rK.g(!d());
        return new MediaParserHlsMediaChunkExtractor(h(this.a, this.d, this.e, this.f, this.g, this.c.getParserName()), this.a, this.d, this.e, this.f, 0, this.g);
    }
}
