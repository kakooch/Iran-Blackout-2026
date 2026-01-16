package com.google.android.exoplayer2.source.mediaparser;

import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.media.MediaParser$InputReader;
import android.media.MediaParser$OutputConsumer;
import android.util.Pair;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmInitData;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC18359oX3;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24889zN4;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C23334wk6;
import ir.nasim.C5045Hq7;
import ir.nasim.FY3;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.LT0;
import ir.nasim.O12;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class OutputConsumerAdapterV30 implements MediaParser$OutputConsumer {
    private static final Pair u = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);
    private static final Pattern v = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    private final ArrayList a;
    private final ArrayList b;
    private final ArrayList c;
    private final ArrayList d;
    private final DataReaderAdapter e;
    private final boolean f;
    private final int g;
    private final X h;
    private InterfaceC10465bf2 i;
    private MediaParser.SeekMap j;
    private MediaParser.SeekMap k;
    private String l;
    private LT0 m;
    private C5045Hq7 n;
    private List o;
    private int p;
    private long q;
    private boolean r;
    private boolean s;
    private boolean t;

    private static final class DataReaderAdapter implements InterfaceC18631oz1 {
        public MediaParser$InputReader a;

        private DataReaderAdapter() {
        }

        @Override // ir.nasim.InterfaceC18631oz1
        public int read(byte[] bArr, int i, int i2) {
            return AbstractC24889zN4.a(AbstractC9683aN7.j(this.a)).read(bArr, i, i2);
        }
    }

    private static final class SeekMapAdapter implements InterfaceC22148uk6 {
        private final MediaParser.SeekMap a;

        public SeekMapAdapter(MediaParser.SeekMap seekMap) {
            this.a = seekMap;
        }

        private static C23334wk6 a(MediaParser.SeekPoint seekPoint) {
            return new C23334wk6(seekPoint.timeMicros, seekPoint.position);
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public InterfaceC22148uk6.a c(long j) {
            Pair seekPoints = this.a.getSeekPoints(j);
            Object obj = seekPoints.first;
            return obj == seekPoints.second ? new InterfaceC22148uk6.a(a(FY3.a(obj))) : new InterfaceC22148uk6.a(a(FY3.a(obj)), a(FY3.a(seekPoints.second)));
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public boolean g() {
            return this.a.isSeekable();
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public long i() {
            long durationMicros = this.a.getDurationMicros();
            if (durationMicros != -2147483648L) {
                return durationMicros;
            }
            return -9223372036854775807L;
        }
    }

    public OutputConsumerAdapterV30() {
        this(null, -2, false);
    }

    private void b(int i) {
        for (int size = this.a.size(); size <= i; size++) {
            this.a.add(null);
            this.b.add(null);
            this.c.add(null);
            this.d.add(null);
        }
    }

    private static int d(MediaFormat mediaFormat, String str, int i) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i;
        }
        return 0;
    }

    private static List e(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append("csd-");
            int i2 = i + 1;
            sb.append(i);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb.toString());
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(AbstractC18359oX3.a(byteBuffer));
            i = i2;
        }
    }

    private static String f(String str) {
        str.hashCode();
        switch (str) {
            case "android.media.mediaparser.Mp4Parser":
            case "android.media.mediaparser.FragmentedMp4Parser":
                return "video/mp4";
            case "android.media.mediaparser.OggParser":
                return "audio/ogg";
            case "android.media.mediaparser.TsParser":
                return "video/mp2t";
            case "android.media.mediaparser.AdtsParser":
                return "audio/mp4a-latm";
            case "android.media.mediaparser.WavParser":
                return "audio/raw";
            case "android.media.mediaparser.PsParser":
                return "video/mp2p";
            case "android.media.mediaparser.Ac3Parser":
                return "audio/ac3";
            case "android.media.mediaparser.AmrParser":
                return "audio/amr";
            case "android.media.mediaparser.FlacParser":
                return "audio/flac";
            case "android.media.mediaparser.MatroskaParser":
                return "video/webm";
            case "android.media.mediaparser.Ac4Parser":
                return "audio/ac4";
            case "android.media.mediaparser.Mp3Parser":
                return "audio/mpeg";
            case "android.media.mediaparser.FlvParser":
                return "video/x-flv";
            default:
                throw new IllegalArgumentException("Illegal parser name: " + str);
        }
    }

    private static int i(MediaFormat mediaFormat) {
        return d(mediaFormat, "is-forced-subtitle", 2) | d(mediaFormat, "is-autoselect", 4) | d(mediaFormat, "is-default", 1);
    }

    private void j() {
        if (!this.r || this.s) {
            return;
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) == null) {
                return;
            }
        }
        this.i.s();
        this.s = true;
    }

    private boolean k(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("chunk-index-int-sizes");
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer intBufferAsIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer longBufferAsLongBuffer = ((ByteBuffer) AbstractC20011rK.e(mediaFormat.getByteBuffer("chunk-index-long-offsets"))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer2 = ((ByteBuffer) AbstractC20011rK.e(mediaFormat.getByteBuffer("chunk-index-long-us-durations"))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer3 = ((ByteBuffer) AbstractC20011rK.e(mediaFormat.getByteBuffer("chunk-index-long-us-times"))).asLongBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        long[] jArr = new long[longBufferAsLongBuffer.remaining()];
        long[] jArr2 = new long[longBufferAsLongBuffer2.remaining()];
        long[] jArr3 = new long[longBufferAsLongBuffer3.remaining()];
        intBufferAsIntBuffer.get(iArr);
        longBufferAsLongBuffer.get(jArr);
        longBufferAsLongBuffer2.get(jArr2);
        longBufferAsLongBuffer3.get(jArr3);
        LT0 lt0 = new LT0(iArr, jArr, jArr2, jArr3);
        this.m = lt0;
        this.i.o(lt0);
        return true;
    }

    private InterfaceC4589Ft7.a q(int i, MediaCodec.CryptoInfo cryptoInfo) throws NumberFormatException {
        int i2;
        int i3;
        if (cryptoInfo == null) {
            return null;
        }
        if (((MediaCodec.CryptoInfo) this.c.get(i)) == cryptoInfo) {
            return (InterfaceC4589Ft7.a) AbstractC20011rK.e((InterfaceC4589Ft7.a) this.d.get(i));
        }
        try {
            Matcher matcher = v.matcher(cryptoInfo.toString());
            matcher.find();
            i2 = Integer.parseInt((String) AbstractC9683aN7.j(matcher.group(1)));
            i3 = Integer.parseInt((String) AbstractC9683aN7.j(matcher.group(2)));
        } catch (RuntimeException e) {
            AbstractC18815pI3.d("OConsumerAdapterV30", "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e);
            i2 = 0;
            i3 = 0;
        }
        InterfaceC4589Ft7.a aVar = new InterfaceC4589Ft7.a(cryptoInfo.mode, cryptoInfo.key, i2, i3);
        this.c.set(i, cryptoInfo);
        this.d.set(i, aVar);
        return aVar;
    }

    private static DrmInitData r(String str, android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int schemeInitDataCount = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[schemeInitDataCount];
        for (int i = 0; i < schemeInitDataCount; i++) {
            DrmInitData.SchemeInitData schemeInitDataAt = drmInitData.getSchemeInitDataAt(i);
            schemeDataArr[i] = new DrmInitData.SchemeData(schemeInitDataAt.uuid, schemeInitDataAt.mimeType, schemeInitDataAt.data);
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str, schemeDataArr);
    }

    private X s(MediaParser.TrackData trackData) {
        MediaFormat mediaFormat = trackData.mediaFormat;
        String string = mediaFormat.getString("mime");
        int integer = mediaFormat.getInteger("caption-service-number", -1);
        int i = 0;
        X.b bVarH = new X.b().O(r(mediaFormat.getString("crypto-mode-fourcc"), trackData.drmInitData)).M(this.l).b0(mediaFormat.getInteger("bitrate", -1)).J(mediaFormat.getInteger("channel-count", -1)).L(AbstractC18359oX3.b(mediaFormat)).g0(string).K(mediaFormat.getString("codecs-string")).R(mediaFormat.getFloat("frame-rate", -1.0f)).n0(mediaFormat.getInteger("width", -1)).S(mediaFormat.getInteger("height", -1)).V(e(mediaFormat)).X(mediaFormat.getString("language")).Y(mediaFormat.getInteger("max-input-size", -1)).a0(mediaFormat.getInteger("exo-pcm-encoding", -1)).f0(mediaFormat.getInteger("rotation-degrees", 0)).h0(mediaFormat.getInteger("sample-rate", -1)).i0(i(mediaFormat)).P(mediaFormat.getInteger("encoder-delay", 0)).Q(mediaFormat.getInteger("encoder-padding", 0)).c0(mediaFormat.getFloat("pixel-width-height-ratio-float", 1.0f)).k0(mediaFormat.getLong("subsample-offset-us-long", Long.MAX_VALUE)).H(integer);
        while (true) {
            if (i >= this.o.size()) {
                break;
            }
            X x = (X) this.o.get(i);
            if (AbstractC9683aN7.c(x.l, string) && x.G == integer) {
                bVarH.X(x.c).e0(x.e).i0(x.d).W(x.b).Z(x.j);
                break;
            }
            i++;
        }
        return bVarH.G();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int t(java.lang.String r5) {
        /*
            r0 = -1
            if (r5 != 0) goto L4
            return r0
        L4:
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -450004177: goto L3c;
                case -284840886: goto L31;
                case 3556653: goto L26;
                case 93166550: goto L1b;
                case 112202875: goto L10;
                default: goto Le;
            }
        Le:
            r1 = r0
            goto L46
        L10:
            java.lang.String r1 = "video"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L19
            goto Le
        L19:
            r1 = 4
            goto L46
        L1b:
            java.lang.String r1 = "audio"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L24
            goto Le
        L24:
            r1 = r2
            goto L46
        L26:
            java.lang.String r1 = "text"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L2f
            goto Le
        L2f:
            r1 = r3
            goto L46
        L31:
            java.lang.String r1 = "unknown"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L3a
            goto Le
        L3a:
            r1 = r4
            goto L46
        L3c:
            java.lang.String r1 = "metadata"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L45
            goto Le
        L45:
            r1 = 0
        L46:
            switch(r1) {
                case 0: goto L52;
                case 1: goto L51;
                case 2: goto L50;
                case 3: goto L4f;
                case 4: goto L4e;
                default: goto L49;
            }
        L49:
            int r5 = ir.nasim.AbstractC24462yf4.k(r5)
            return r5
        L4e:
            return r3
        L4f:
            return r4
        L50:
            return r2
        L51:
            return r0
        L52:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30.t(java.lang.String):int");
    }

    public void a() {
        this.t = true;
    }

    public MediaParser.SeekMap c() {
        return this.j;
    }

    public X[] g() {
        if (!this.r) {
            return null;
        }
        X[] xArr = new X[this.b.size()];
        for (int i = 0; i < this.b.size(); i++) {
            xArr[i] = (X) AbstractC20011rK.e((X) this.b.get(i));
        }
        return xArr;
    }

    public Pair h(long j) {
        MediaParser.SeekMap seekMap = this.k;
        return seekMap != null ? seekMap.getSeekPoints(j) : u;
    }

    public void l(InterfaceC10465bf2 interfaceC10465bf2) {
        this.i = interfaceC10465bf2;
    }

    public void m(List list) {
        this.o = list;
    }

    public void n(long j) {
        this.q = j;
    }

    public void o(String str) {
        this.l = f(str);
    }

    public void onSampleCompleted(int i, long j, int i2, int i3, int i4, MediaCodec.CryptoInfo cryptoInfo) {
        long j2 = this.q;
        if (j2 == -9223372036854775807L || j < j2) {
            C5045Hq7 c5045Hq7 = this.n;
            if (c5045Hq7 != null) {
                j = c5045Hq7.a(j);
            }
            ((InterfaceC4589Ft7) AbstractC20011rK.e((InterfaceC4589Ft7) this.a.get(i))).b(j, i2, i3, i4, q(i, cryptoInfo));
        }
    }

    public void onSampleDataFound(int i, MediaParser$InputReader mediaParser$InputReader) {
        b(i);
        this.e.a = mediaParser$InputReader;
        InterfaceC4589Ft7 interfaceC4589Ft7B = (InterfaceC4589Ft7) this.a.get(i);
        if (interfaceC4589Ft7B == null) {
            interfaceC4589Ft7B = this.i.b(i, -1);
            this.a.set(i, interfaceC4589Ft7B);
        }
        interfaceC4589Ft7B.f(this.e, (int) mediaParser$InputReader.getLength(), true);
    }

    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        InterfaceC22148uk6 seekMapAdapter;
        if (this.f && this.j == null) {
            this.j = seekMap;
            return;
        }
        this.k = seekMap;
        long durationMicros = seekMap.getDurationMicros();
        InterfaceC10465bf2 interfaceC10465bf2 = this.i;
        if (this.t) {
            if (durationMicros == -2147483648L) {
                durationMicros = -9223372036854775807L;
            }
            seekMapAdapter = new InterfaceC22148uk6.b(durationMicros);
        } else {
            seekMapAdapter = new SeekMapAdapter(seekMap);
        }
        interfaceC10465bf2.o(seekMapAdapter);
    }

    public void onTrackCountFound(int i) {
        this.r = true;
        j();
    }

    public void onTrackDataFound(int i, MediaParser.TrackData trackData) {
        if (k(trackData.mediaFormat)) {
            return;
        }
        b(i);
        InterfaceC4589Ft7 interfaceC4589Ft7 = (InterfaceC4589Ft7) this.a.get(i);
        if (interfaceC4589Ft7 == null) {
            String string = trackData.mediaFormat.getString("track-type-string");
            int iT = t(string != null ? string : trackData.mediaFormat.getString("mime"));
            if (iT == this.g) {
                this.p = i;
            }
            InterfaceC4589Ft7 interfaceC4589Ft7B = this.i.b(i, iT);
            this.a.set(i, interfaceC4589Ft7B);
            if (string != null) {
                return;
            } else {
                interfaceC4589Ft7 = interfaceC4589Ft7B;
            }
        }
        X xS = s(trackData);
        X x = this.h;
        interfaceC4589Ft7.c((x == null || i != this.p) ? xS : xS.l(x));
        this.b.set(i, xS);
        j();
    }

    public void p(C5045Hq7 c5045Hq7) {
        this.n = c5045Hq7;
    }

    public OutputConsumerAdapterV30(X x, int i, boolean z) {
        this.f = z;
        this.h = x;
        this.g = i;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new DataReaderAdapter();
        this.i = new O12();
        this.q = -9223372036854775807L;
        this.o = AbstractC12710f43.V();
    }
}
