package com.google.android.exoplayer2.source.hls.playlist;

import android.gov.nist.core.Separators;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.upstream.k;
import ir.nasim.AbstractC11612dI7;
import ir.nasim.AbstractC15671jy5;
import ir.nasim.AbstractC17264mg3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9683aN7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class HlsPlaylistParser implements k.a {
    private final HlsMultivariantPlaylist a;
    private final HlsMediaPlaylist b;
    private static final Pattern c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern d = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern e = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern f = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern i = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern j = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern n = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern s = c("CAN-SKIP-DATERANGES");
    private static final Pattern t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern w = c("CAN-BLOCK-RELOAD");
    private static final Pattern x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern A = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern B = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern K = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern L = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern N = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern O = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern P = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern T = c("AUTOSELECT");
    private static final Pattern U = c("DEFAULT");
    private static final Pattern V = c("FORCED");
    private static final Pattern W = c("INDEPENDENT");
    private static final Pattern X = c("GAP");
    private static final Pattern Y = c("PRECISE");
    private static final Pattern Z = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern a0 = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static final class DeltaUpdateException extends IOException {
    }

    private static class LineIterator {
        private final BufferedReader a;
        private final Queue b;
        private String c;

        public LineIterator(Queue queue, BufferedReader bufferedReader) {
            this.b = queue;
            this.a = bufferedReader;
        }

        public boolean a() throws IOException {
            String strTrim;
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = (String) AbstractC20011rK.e((String) this.b.poll());
                return true;
            }
            do {
                String line = this.a.readLine();
                this.c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.c;
            this.c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.n, null);
    }

    private static long A(String str, Pattern pattern) {
        return new BigDecimal(z(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    private static String B(String str, Map map) {
        Matcher matcher = b0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int C(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !AbstractC9683aN7.v0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        int i2 = bufferedReader.read();
        if (i2 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i2 = bufferedReader.read();
        }
        int iC = C(bufferedReader, true, i2);
        for (int i3 = 0; i3 < 7; i3++) {
            if (iC != "#EXTM3U".charAt(i3)) {
                return false;
            }
            iC = bufferedReader.read();
        }
        return AbstractC9683aN7.v0(C(bufferedReader, false, iC));
    }

    private static Pattern c(String str) {
        return Pattern.compile(str + "=(NO|YES" + Separators.RPAREN);
    }

    private static DrmInitData d(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i2 = 0; i2 < schemeDataArr.length; i2++) {
            schemeDataArr2[i2] = schemeDataArr[i2].a(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String e(long j2, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    private static HlsMultivariantPlaylist.Variant f(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList.get(i2);
            if (str.equals(variant.d)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant g(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList.get(i2);
            if (str.equals(variant.e)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant h(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList.get(i2);
            if (str.equals(variant.c)) {
                return variant;
            }
        }
        return null;
    }

    private static double j(String str, Pattern pattern) {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    private static DrmInitData.SchemeData k(String str, String str2, Map map) throws ParserException {
        String strU = u(str, J, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String strZ = z(str, K, map);
            return new DrmInitData.SchemeData(AbstractC9350Zo0.d, "video/mp4", Base64.decode(strZ.substring(strZ.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(AbstractC9350Zo0.d, "hls", AbstractC9683aN7.m0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(strU)) {
            return null;
        }
        String strZ2 = z(str, K, map);
        byte[] bArrDecode = Base64.decode(strZ2.substring(strZ2.indexOf(44)), 0);
        UUID uuid = AbstractC9350Zo0.e;
        return new DrmInitData.SchemeData(uuid, "video/mp4", AbstractC15671jy5.a(uuid, bArrDecode));
    }

    private static String l(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int m(String str, Pattern pattern) {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    private static long n(String str, Pattern pattern) {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HlsMediaPlaylist o(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist, LineIterator lineIterator, String str) throws DeltaUpdateException, ParserException, NumberFormatException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        long j2;
        boolean z2;
        int i2;
        HlsMediaPlaylist.Part part;
        int i3;
        String strV;
        long j3;
        long j4;
        long j5;
        long j6;
        boolean z3;
        Object drmInitData;
        HlsMultivariantPlaylist hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        boolean z4 = hlsMultivariantPlaylist2.c;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        HlsMediaPlaylist.ServerControl serverControl = new HlsMediaPlaylist.ServerControl(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        boolean z5 = false;
        String str3 = "";
        boolean z6 = z4;
        HlsMediaPlaylist.ServerControl serverControlY = serverControl;
        int i4 = 0;
        boolean zQ = false;
        boolean z7 = false;
        int i5 = 0;
        boolean z8 = false;
        boolean z9 = false;
        int i6 = 0;
        boolean z10 = false;
        String strU = str3;
        String strZ = null;
        long j7 = -9223372036854775807L;
        long jB0 = 0;
        long j8 = 0;
        int iM = 1;
        long jM = -9223372036854775807L;
        long j9 = -9223372036854775807L;
        DrmInitData drmInitDataD = null;
        long j10 = 0;
        Object obj = null;
        long j11 = 0;
        long j12 = -1;
        String str4 = null;
        String strL = null;
        long j13 = 0;
        long jN = 0;
        HlsMediaPlaylist.Segment segment = null;
        long jA = 0;
        long j14 = 0;
        ArrayList arrayList7 = arrayList4;
        HlsMediaPlaylist.Part part2 = null;
        while (lineIterator.a()) {
            String strB = lineIterator.b();
            if (strB.startsWith("#EXT")) {
                arrayList6.add(strB);
            }
            if (strB.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String strZ2 = z(strB, q, map);
                if ("VOD".equals(strZ2)) {
                    i4 = 1;
                } else if ("EVENT".equals(strZ2)) {
                    i4 = 2;
                }
            } else if (strB.equals("#EXT-X-I-FRAMES-ONLY")) {
                z10 = true;
            } else if (strB.startsWith("#EXT-X-START")) {
                j7 = (long) (j(strB, C) * 1000000.0d);
                zQ = q(strB, Y, z5);
            } else if (strB.startsWith("#EXT-X-SERVER-CONTROL")) {
                serverControlY = y(strB);
            } else if (strB.startsWith("#EXT-X-PART-INF")) {
                j9 = (long) (j(strB, o) * 1000000.0d);
            } else if (strB.startsWith("#EXT-X-MAP")) {
                String strZ3 = z(strB, K, map);
                String strV2 = v(strB, E, map);
                if (strV2 != null) {
                    String[] strArrR0 = AbstractC9683aN7.R0(strV2, Separators.AT);
                    j12 = Long.parseLong(strArrR0[z5 ? 1 : 0]);
                    if (strArrR0.length > 1) {
                        j10 = Long.parseLong(strArrR0[1]);
                    }
                }
                if (j12 == -1) {
                    j10 = 0;
                }
                String str5 = str4;
                if (strZ != null && str5 == null) {
                    throw ParserException.c("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                segment = new HlsMediaPlaylist.Segment(strZ3, j10, j12, strZ, str5);
                if (j12 != -1) {
                    j10 += j12;
                }
                str4 = str5;
                j12 = -1;
            } else {
                String str6 = str4;
                if (strB.startsWith("#EXT-X-TARGETDURATION")) {
                    jM = 1000000 * m(strB, m);
                } else {
                    if (strB.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        jN = n(strB, x);
                        str4 = str6;
                        j8 = jN;
                    } else if (strB.startsWith("#EXT-X-VERSION")) {
                        iM = m(strB, p);
                    } else {
                        if (strB.startsWith("#EXT-X-DEFINE")) {
                            String strV3 = v(strB, a0, map);
                            if (strV3 != null) {
                                String str7 = (String) hlsMultivariantPlaylist2.l.get(strV3);
                                if (str7 != null) {
                                    map.put(strV3, str7);
                                }
                            } else {
                                map.put(z(strB, P, map), z(strB, Z, map));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = strL;
                            j2 = jN;
                            z2 = false;
                            i2 = i4;
                        } else if (strB.startsWith("#EXTINF")) {
                            jA = A(strB, y);
                            strU = u(strB, z, str3, map);
                        } else {
                            String str8 = str3;
                            if (strB.startsWith("#EXT-X-SKIP")) {
                                int iM2 = m(strB, t);
                                AbstractC20011rK.g(hlsMediaPlaylist2 != null && arrayList3.isEmpty());
                                int i7 = (int) (j8 - ((HlsMediaPlaylist) AbstractC9683aN7.j(hlsMediaPlaylist)).k);
                                int i8 = iM2 + i7;
                                if (i7 < 0 || i8 > hlsMediaPlaylist2.r.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str3 = str8;
                                String str9 = str6;
                                long j15 = j13;
                                while (i7 < i8) {
                                    HlsMediaPlaylist.Segment segmentH = (HlsMediaPlaylist.Segment) hlsMediaPlaylist2.r.get(i7);
                                    ArrayList arrayList8 = arrayList7;
                                    ArrayList arrayList9 = arrayList6;
                                    if (j8 != hlsMediaPlaylist2.k) {
                                        segmentH = segmentH.h(j15, (hlsMediaPlaylist2.j - i5) + segmentH.d);
                                    }
                                    arrayList3.add(segmentH);
                                    j15 += segmentH.c;
                                    long j16 = segmentH.j;
                                    if (j16 != -1) {
                                        i3 = i8;
                                        j10 = segmentH.i + j16;
                                    } else {
                                        i3 = i8;
                                    }
                                    int i9 = segmentH.d;
                                    HlsMediaPlaylist.Segment segment2 = segmentH.b;
                                    DrmInitData drmInitData2 = segmentH.f;
                                    String str10 = segmentH.g;
                                    String str11 = segmentH.h;
                                    if (str11 == null || !str11.equals(Long.toHexString(jN))) {
                                        str9 = segmentH.h;
                                    }
                                    jN++;
                                    i7++;
                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                    obj = drmInitData2;
                                    strZ = str10;
                                    j11 = j15;
                                    i8 = i3;
                                    i6 = i9;
                                    segment = segment2;
                                    arrayList7 = arrayList8;
                                    arrayList6 = arrayList9;
                                }
                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                j13 = j15;
                                str4 = str9;
                            } else {
                                ArrayList arrayList10 = arrayList7;
                                arrayList2 = arrayList6;
                                str3 = str8;
                                if (strB.startsWith("#EXT-X-KEY")) {
                                    String strZ4 = z(strB, H, map);
                                    String strU2 = u(strB, I, "identity", map);
                                    if ("NONE".equals(strZ4)) {
                                        treeMap.clear();
                                        strV = null;
                                        strZ = null;
                                    } else {
                                        strV = v(strB, L, map);
                                        if ("identity".equals(strU2)) {
                                            if ("AES-128".equals(strZ4)) {
                                                strZ = z(strB, K, map);
                                            }
                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                                            str4 = strV;
                                        } else {
                                            String str12 = strL;
                                            strL = str12 == null ? l(strZ4) : str12;
                                            DrmInitData.SchemeData schemeDataK = k(strB, strU2, map);
                                            if (schemeDataK != null) {
                                                treeMap.put(strU2, schemeDataK);
                                                strZ = null;
                                            }
                                        }
                                        strZ = null;
                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                        str4 = strV;
                                    }
                                    obj = strZ;
                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                    str4 = strV;
                                } else {
                                    String str13 = strL;
                                    if (strB.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] strArrR02 = AbstractC9683aN7.R0(z(strB, D, map), Separators.AT);
                                        j12 = Long.parseLong(strArrR02[0]);
                                        if (strArrR02.length > 1) {
                                            j10 = Long.parseLong(strArrR02[1]);
                                        }
                                    } else if (strB.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i5 = Integer.parseInt(strB.substring(strB.indexOf(58) + 1));
                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                        strL = str13;
                                        str4 = str6;
                                        arrayList7 = arrayList10;
                                        arrayList6 = arrayList2;
                                        z5 = false;
                                        z7 = true;
                                    } else if (strB.equals("#EXT-X-DISCONTINUITY")) {
                                        i6++;
                                    } else {
                                        if (strB.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (jB0 == 0) {
                                                jB0 = AbstractC9683aN7.B0(AbstractC9683aN7.I0(strB.substring(strB.indexOf(58) + 1))) - j13;
                                            } else {
                                                i2 = i4;
                                                str2 = str13;
                                            }
                                        } else if (strB.equals("#EXT-X-GAP")) {
                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                                            strL = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z5 = false;
                                            z9 = true;
                                        } else if (strB.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                                            strL = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z5 = false;
                                            z6 = true;
                                        } else if (strB.equals("#EXT-X-ENDLIST")) {
                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                                            strL = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z5 = false;
                                            z8 = true;
                                        } else if (strB.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i2 = i4;
                                            str2 = str13;
                                            arrayList5.add(new HlsMediaPlaylist.RenditionReport(Uri.parse(AbstractC11612dI7.c(str, z(strB, K, map))), t(strB, A, -1L), s(strB, B, -1)));
                                        } else {
                                            i2 = i4;
                                            str2 = str13;
                                            if (!strB.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                j2 = jN;
                                                if (strB.startsWith("#EXT-X-PART")) {
                                                    String strE = e(j2, strZ, str6);
                                                    String strZ5 = z(strB, K, map);
                                                    long j17 = (long) (j(strB, n) * 1000000.0d);
                                                    HlsMediaPlaylist.Part part3 = part2;
                                                    boolean zQ2 = q(strB, W, false) | (z6 && arrayList10.isEmpty());
                                                    boolean zQ3 = q(strB, X, false);
                                                    String strV4 = v(strB, E, map);
                                                    if (strV4 != null) {
                                                        String[] strArrR03 = AbstractC9683aN7.R0(strV4, Separators.AT);
                                                        j4 = Long.parseLong(strArrR03[0]);
                                                        if (strArrR03.length > 1) {
                                                            j14 = Long.parseLong(strArrR03[1]);
                                                        }
                                                        j3 = -1;
                                                    } else {
                                                        j3 = -1;
                                                        j4 = -1;
                                                    }
                                                    if (j4 == j3) {
                                                        j14 = 0;
                                                    }
                                                    if (obj == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData3 = new DrmInitData(str2, schemeDataArr);
                                                        if (drmInitDataD == null) {
                                                            drmInitDataD = d(str2, schemeDataArr);
                                                        }
                                                        obj = drmInitData3;
                                                    }
                                                    arrayList10.add(new HlsMediaPlaylist.Part(strZ5, segment, j17, i6, j11, obj, strZ, strE, j14, j4, zQ3, zQ2, false));
                                                    j11 += j17;
                                                    if (j4 != j3) {
                                                        j14 += j4;
                                                    }
                                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    str4 = str6;
                                                    i4 = i2;
                                                    part2 = part3;
                                                    jN = j2;
                                                    strL = str2;
                                                    arrayList7 = arrayList10;
                                                    arrayList6 = arrayList2;
                                                } else {
                                                    part = part2;
                                                    arrayList = arrayList10;
                                                    if (strB.startsWith(Separators.POUND)) {
                                                        z2 = false;
                                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                        str4 = str6;
                                                        i4 = i2;
                                                        part2 = part;
                                                        jN = j2;
                                                        strL = str2;
                                                        arrayList7 = arrayList;
                                                        arrayList6 = arrayList2;
                                                        z5 = z2;
                                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    } else {
                                                        String strE2 = e(j2, strZ, str6);
                                                        long j18 = j2 + 1;
                                                        String strB2 = B(strB, map);
                                                        HlsMediaPlaylist.Segment segment3 = (HlsMediaPlaylist.Segment) map2.get(strB2);
                                                        if (j12 == -1) {
                                                            j5 = 0;
                                                        } else {
                                                            if (z10 && segment == null && segment3 == null) {
                                                                segment3 = new HlsMediaPlaylist.Segment(strB2, 0L, j10, null, null);
                                                                map2.put(strB2, segment3);
                                                            }
                                                            j5 = j10;
                                                        }
                                                        if (obj != null || treeMap.isEmpty()) {
                                                            j6 = j18;
                                                            z3 = false;
                                                            drmInitData = obj;
                                                        } else {
                                                            j6 = j18;
                                                            z3 = false;
                                                            DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            drmInitData = new DrmInitData(str2, schemeDataArr2);
                                                            if (drmInitDataD == null) {
                                                                drmInitDataD = d(str2, schemeDataArr2);
                                                            }
                                                        }
                                                        arrayList3.add(new HlsMediaPlaylist.Segment(strB2, segment != null ? segment : segment3, strU, jA, i6, j13, drmInitData, strZ, strE2, j5, j12, z9, arrayList));
                                                        j11 = j13 + jA;
                                                        arrayList7 = new ArrayList();
                                                        if (j12 != -1) {
                                                            j5 += j12;
                                                        }
                                                        j10 = j5;
                                                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                        z9 = z3;
                                                        str4 = str6;
                                                        obj = drmInitData;
                                                        strU = str3;
                                                        j13 = j11;
                                                        i4 = i2;
                                                        part2 = part;
                                                        arrayList6 = arrayList2;
                                                        j12 = -1;
                                                        jA = 0;
                                                        strL = str2;
                                                        jN = j6;
                                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                        z5 = z9;
                                                    }
                                                }
                                            } else if (part2 == null && "PART".equals(z(strB, N, map))) {
                                                String strZ6 = z(strB, K, map);
                                                long jT = t(strB, F, -1L);
                                                long jT2 = t(strB, G, -1L);
                                                long j19 = jN;
                                                String strE3 = e(j19, strZ, str6);
                                                if (obj == null && !treeMap.isEmpty()) {
                                                    DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData4 = new DrmInitData(str2, schemeDataArr3);
                                                    if (drmInitDataD == null) {
                                                        drmInitDataD = d(str2, schemeDataArr3);
                                                    }
                                                    obj = drmInitData4;
                                                }
                                                if (jT == -1 || jT2 != -1) {
                                                    part2 = new HlsMediaPlaylist.Part(strZ6, segment, 0L, i6, j11, obj, strZ, strE3, jT != -1 ? jT : 0L, jT2, false, false, true);
                                                }
                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                jN = j19;
                                                str4 = str6;
                                                arrayList7 = arrayList10;
                                                i4 = i2;
                                                arrayList6 = arrayList2;
                                                strL = str2;
                                            }
                                        }
                                        arrayList = arrayList10;
                                        j2 = jN;
                                        z2 = false;
                                    }
                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                    strL = str13;
                                    str4 = str6;
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList2;
                            }
                        }
                        part = part2;
                        hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                        str4 = str6;
                        i4 = i2;
                        part2 = part;
                        jN = j2;
                        strL = str2;
                        arrayList7 = arrayList;
                        arrayList6 = arrayList2;
                        z5 = z2;
                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                    }
                    z5 = false;
                }
                str4 = str6;
                z5 = false;
            }
        }
        int i10 = i4;
        HlsMediaPlaylist.Part part4 = part2;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        int i11 = z5 ? 1 : 0;
        HashMap map3 = new HashMap();
        for (int i12 = i11; i12 < arrayList5.size(); i12++) {
            HlsMediaPlaylist.RenditionReport renditionReport = (HlsMediaPlaylist.RenditionReport) arrayList5.get(i12);
            long size = renditionReport.b;
            if (size == -1) {
                size = (j8 + arrayList3.size()) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int size2 = renditionReport.c;
            if (size2 == -1 && j9 != -9223372036854775807L) {
                size2 = (arrayList11.isEmpty() ? ((HlsMediaPlaylist.Segment) AbstractC17264mg3.c(arrayList3)).m : arrayList11).size() - 1;
            }
            Uri uri = renditionReport.a;
            map3.put(uri, new HlsMediaPlaylist.RenditionReport(uri, size, size2));
        }
        if (part4 != null) {
            arrayList11.add(part4);
        }
        return new HlsMediaPlaylist(i10, str, arrayList12, j7, zQ, jB0, z7, i5, j8, iM, jM, j9, z6, z8, jB0 != 0, drmInitDataD, arrayList3, arrayList11, serverControlY, map3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0324  */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist p(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator r36, java.lang.String r37) throws com.google.android.exoplayer2.ParserException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.p(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist");
    }

    private static boolean q(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z2;
    }

    private static double r(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) AbstractC20011rK.e(matcher.group(1))) : d2;
    }

    private static int s(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) AbstractC20011rK.e(matcher.group(1))) : i2;
    }

    private static long t(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) AbstractC20011rK.e(matcher.group(1))) : j2;
    }

    private static String u(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) AbstractC20011rK.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : B(str2, map);
    }

    private static String v(String str, Pattern pattern, Map map) {
        return u(str, pattern, null, map);
    }

    private static int w(String str, Map map) {
        String strV = v(str, R, map);
        if (TextUtils.isEmpty(strV)) {
            return 0;
        }
        String[] strArrR0 = AbstractC9683aN7.R0(strV, ",");
        int i2 = AbstractC9683aN7.r(strArrR0, "public.accessibility.describes-video") ? 512 : 0;
        if (AbstractC9683aN7.r(strArrR0, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= 4096;
        }
        if (AbstractC9683aN7.r(strArrR0, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return AbstractC9683aN7.r(strArrR0, "public.easy-to-read") ? i2 | 8192 : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int x(String str) {
        boolean zQ = q(str, U, false);
        ?? r0 = zQ;
        if (q(str, V, false)) {
            r0 = (zQ ? 1 : 0) | 2;
        }
        return q(str, T, false) ? r0 | 4 : r0;
    }

    private static HlsMediaPlaylist.ServerControl y(String str) {
        double dR = r(str, r, -9.223372036854776E18d);
        long j2 = dR == -9.223372036854776E18d ? -9223372036854775807L : (long) (dR * 1000000.0d);
        boolean zQ = q(str, s, false);
        double dR2 = r(str, u, -9.223372036854776E18d);
        long j3 = dR2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (dR2 * 1000000.0d);
        double dR3 = r(str, v, -9.223372036854776E18d);
        return new HlsMediaPlaylist.ServerControl(j2, zQ, j3, dR3 != -9.223372036854776E18d ? (long) (dR3 * 1000000.0d) : -9223372036854775807L, q(str, w, false));
    }

    private static String z(String str, Pattern pattern, Map map) throws ParserException {
        String strV = v(str, pattern, map);
        if (strV != null) {
            return strV;
        }
        throw ParserException.c("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    @Override // com.google.android.exoplayer2.upstream.k.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public HlsPlaylist a(Uri uri, InputStream inputStream) throws IOException {
        String strTrim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!b(bufferedReader)) {
                throw ParserException.c("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    AbstractC9683aN7.m(bufferedReader);
                    throw ParserException.c("Failed to parse the playlist, could not identify any tags.", null);
                }
                strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (!strTrim.startsWith("#EXT-X-STREAM-INF")) {
                        if (strTrim.startsWith("#EXT-X-TARGETDURATION") || strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") || strTrim.startsWith("#EXTINF") || strTrim.startsWith("#EXT-X-KEY") || strTrim.startsWith("#EXT-X-BYTERANGE") || strTrim.equals("#EXT-X-DISCONTINUITY") || strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || strTrim.equals("#EXT-X-ENDLIST")) {
                            break;
                        }
                        arrayDeque.add(strTrim);
                    } else {
                        arrayDeque.add(strTrim);
                        return p(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(strTrim);
            return o(this.a, this.b, new LineIterator(arrayDeque, bufferedReader), uri.toString());
        } finally {
            AbstractC9683aN7.m(bufferedReader);
        }
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.a = hlsMultivariantPlaylist;
        this.b = hlsMediaPlaylist;
    }
}
