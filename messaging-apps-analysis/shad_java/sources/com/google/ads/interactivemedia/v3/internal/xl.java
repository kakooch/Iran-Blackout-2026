package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.messenger.LiteMode;
import org.webrtc.MediaStreamTrack;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xl extends DefaultHandler implements adc<xj> {
    private static final Pattern a = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern b = Pattern.compile("CC([1-4])=.*");
    private static final Pattern c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final int[] d = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    private final XmlPullParserFactory e;

    public xl() {
        try {
            this.e = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private static int A(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        ary.q(i == i2);
        return i;
    }

    private static long B(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    private static final long C(List<xx> list, long j, long j2, int i, long j3) {
        int iG = i >= 0 ? i + 1 : (int) aeu.G(j3 - j, j2);
        for (int i2 = 0; i2 < iG; i2++) {
            list.add(new xx(j, j2));
            j += j2;
        }
        return j;
    }

    public static void h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (atv.f(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (atv.f(xmlPullParser)) {
                    i++;
                } else if (atv.d(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    protected static xm i(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strO = o(xmlPullParser, "schemeIdUri", BuildConfig.FLAVOR);
        String strO2 = o(xmlPullParser, "value", null);
        String strO3 = o(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!atv.c(xmlPullParser, str));
        return new xm(strO, strO2, strO3);
    }

    protected static float j(XmlPullParser xmlPullParser, float f) throws NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = a.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int i = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? i / Integer.parseInt(r2) : i;
    }

    protected static long k(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : aeu.L(attributeValue);
    }

    protected static String l(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String text = BuildConfig.FLAVOR;
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                h(xmlPullParser);
            }
        } while (!atv.c(xmlPullParser, str));
        return text;
    }

    protected static int m(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long n(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static String o(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static final int p(org.xmlpull.v1.XmlPullParser r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = o(r8, r0, r1)
            int r2 = r0.hashCode()
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = -1
            switch(r2) {
                case -1352850286: goto L32;
                case -1138141449: goto L28;
                case -986633423: goto L1e;
                case 2036691300: goto L14;
                default: goto L13;
            }
        L13:
            goto L3c
        L14:
            java.lang.String r2 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 3
            goto L3d
        L1e:
            java.lang.String r2 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 1
            goto L3d
        L28:
            java.lang.String r2 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 2
            goto L3d
        L32:
            java.lang.String r2 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 0
            goto L3d
        L3c:
            r0 = -1
        L3d:
            java.lang.String r2 = "value"
            if (r0 == 0) goto La5
            if (r0 == r6) goto L95
            if (r0 == r5) goto L4a
            if (r0 == r4) goto L4a
        L47:
            r5 = -1
            goto La9
        L4a:
            java.lang.String r0 = r8.getAttributeValue(r1, r2)
            java.lang.String r0 = com.google.ads.interactivemedia.v3.internal.aeu.C(r0)
            if (r0 != 0) goto L55
            goto L47
        L55:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1596796: goto L7b;
                case 2937391: goto L71;
                case 3094035: goto L67;
                case 3133436: goto L5d;
                default: goto L5c;
            }
        L5c:
            goto L84
        L5d:
            java.lang.String r1 = "fa01"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r3 = 3
            goto L85
        L67:
            java.lang.String r1 = "f801"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r3 = 2
            goto L85
        L71:
            java.lang.String r1 = "a000"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r3 = 1
            goto L85
        L7b:
            java.lang.String r1 = "4000"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            goto L85
        L84:
            r3 = -1
        L85:
            if (r3 == 0) goto L93
            if (r3 == r6) goto La9
            if (r3 == r5) goto L91
            if (r3 == r4) goto L8e
            goto L47
        L8e:
            r5 = 8
            goto La9
        L91:
            r5 = 6
            goto La9
        L93:
            r5 = 1
            goto La9
        L95:
            int r0 = m(r8, r2, r7)
            if (r0 < 0) goto L47
            int[] r1 = com.google.ads.interactivemedia.v3.internal.xl.d
            int r2 = r1.length
            r2 = 21
            if (r0 >= r2) goto L47
            r5 = r1[r0]
            goto La9
        La5:
            int r5 = m(r8, r2, r7)
        La9:
            r8.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.ads.interactivemedia.v3.internal.atv.c(r8, r0)
            if (r0 == 0) goto La9
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xl.p(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static final long q(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    protected static final String r(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return atv.j(str, l(xmlPullParser, "BaseURL"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [byte[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static final android.util.Pair<java.lang.String, com.google.ads.interactivemedia.v3.internal.jb> s(org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xl.s(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    protected static final int t(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MediaStreamTrack.AUDIO_TRACK_KIND.equals(attributeValue)) {
            return 1;
        }
        if (MediaStreamTrack.VIDEO_TRACK_KIND.equals(attributeValue)) {
            return 2;
        }
        return !"text".equals(attributeValue) ? -1 : 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static final int u(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            int r1 = r6.hashCode()
            r2 = 2
            r3 = 8
            r4 = 4
            r5 = 1
            switch(r1) {
                case -2060497896: goto L7a;
                case -1724546052: goto L6f;
                case -1580883024: goto L64;
                case -1408024454: goto L5a;
                case 99825: goto L50;
                case 3343801: goto L46;
                case 3530173: goto L3b;
                case 552573414: goto L31;
                case 899152809: goto L27;
                case 1629013393: goto L1d;
                case 1855372047: goto L12;
                default: goto L10;
            }
        L10:
            goto L84
        L12:
            java.lang.String r1 = "supplementary"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 2
            goto L85
        L1d:
            java.lang.String r1 = "emergency"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 5
            goto L85
        L27:
            java.lang.String r1 = "commentary"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 3
            goto L85
        L31:
            java.lang.String r1 = "caption"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 6
            goto L85
        L3b:
            java.lang.String r1 = "sign"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 8
            goto L85
        L46:
            java.lang.String r1 = "main"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 0
            goto L85
        L50:
            java.lang.String r1 = "dub"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 4
            goto L85
        L5a:
            java.lang.String r1 = "alternate"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 1
            goto L85
        L64:
            java.lang.String r1 = "enhanced-audio-intelligibility"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 10
            goto L85
        L6f:
            java.lang.String r1 = "description"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 9
            goto L85
        L7a:
            java.lang.String r1 = "subtitle"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L84
            r6 = 7
            goto L85
        L84:
            r6 = -1
        L85:
            switch(r6) {
                case 0: goto La1;
                case 1: goto La0;
                case 2: goto L9f;
                case 3: goto L9e;
                case 4: goto L9b;
                case 5: goto L98;
                case 6: goto L95;
                case 7: goto L92;
                case 8: goto L8f;
                case 9: goto L8c;
                case 10: goto L89;
                default: goto L88;
            }
        L88:
            return r0
        L89:
            r6 = 2048(0x800, float:2.87E-42)
            return r6
        L8c:
            r6 = 512(0x200, float:7.17E-43)
            return r6
        L8f:
            r6 = 256(0x100, float:3.59E-43)
            return r6
        L92:
            r6 = 128(0x80, float:1.8E-43)
            return r6
        L95:
            r6 = 64
            return r6
        L98:
            r6 = 32
            return r6
        L9b:
            r6 = 16
            return r6
        L9e:
            return r3
        L9f:
            return r4
        La0:
            return r2
        La1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xl.u(java.lang.String):int");
    }

    protected static long v(XmlPullParser xmlPullParser, String str) throws dt {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return -9223372036854775807L;
        }
        return aeu.M(attributeValue);
    }

    protected static float w(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return -3.4028235E38f;
        }
        return Float.parseFloat(attributeValue);
    }

    protected static final xq x(XmlPullParser xmlPullParser, String str, String str2) throws NumberFormatException {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
            return new xq(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return new xq(attributeValue, j, j2);
    }

    protected static final int y(List<xm> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if ("http://dashif.org/guidelines/trickmode".equalsIgnoreCase(list.get(i2).a)) {
                i |= LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
            }
        }
        return i;
    }

    protected static final yc z(XmlPullParser xmlPullParser, String str, yc ycVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? yc.a(attributeValue) : ycVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:208:0x0a55  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0a99  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0acd A[Catch: XmlPullParserException -> 0x1398, TryCatch #2 {XmlPullParserException -> 0x1398, blocks: (B:3:0x0012, B:5:0x0025, B:7:0x002f, B:9:0x0059, B:12:0x0078, B:15:0x0085, B:17:0x0093, B:21:0x00a4, B:26:0x00c9, B:29:0x00d4, B:462:0x132d, B:471:0x1343, B:472:0x134a, B:473:0x134b, B:475:0x1351, B:477:0x136d, B:478:0x1374, B:32:0x0129, B:35:0x0131, B:36:0x0141, B:38:0x014c, B:46:0x016e, B:48:0x0174, B:39:0x0151, B:41:0x0159, B:42:0x015e, B:44:0x0166, B:45:0x016b, B:49:0x0189, B:53:0x0198, B:54:0x01a8, B:56:0x01b0, B:59:0x01ce, B:62:0x01df, B:64:0x01ea, B:70:0x021a, B:72:0x0220, B:67:0x0202, B:69:0x020d, B:74:0x0244, B:77:0x024e, B:79:0x0264, B:81:0x0269, B:82:0x0289, B:85:0x0294, B:445:0x1273, B:447:0x127b, B:451:0x12a1, B:452:0x12bd, B:453:0x12be, B:457:0x12d4, B:456:0x12cf, B:87:0x02fc, B:91:0x030f, B:92:0x03a2, B:95:0x03ad, B:352:0x0e95, B:354:0x0e9d, B:355:0x0ea7, B:357:0x0ead, B:359:0x0ebd, B:360:0x0ec0, B:363:0x0ec6, B:365:0x0ed3, B:367:0x0edb, B:370:0x0eea, B:372:0x0ef0, B:374:0x0efc, B:375:0x0f00, B:376:0x0f03, B:377:0x0f08, B:379:0x0f15, B:381:0x0f26, B:385:0x0f39, B:382:0x0f2e, B:384:0x0f32, B:386:0x0f46, B:387:0x0f4d, B:388:0x0f4e, B:99:0x045f, B:101:0x0469, B:103:0x0471, B:104:0x0475, B:106:0x0479, B:108:0x04ba, B:110:0x04c2, B:116:0x04d5, B:115:0x04ce, B:117:0x04df, B:119:0x04e7, B:121:0x0540, B:123:0x0548, B:124:0x0550, B:126:0x0558, B:127:0x0562, B:129:0x0568, B:130:0x0570, B:132:0x0578, B:133:0x05d6, B:137:0x05e5, B:138:0x066a, B:141:0x0675, B:185:0x09fc, B:187:0x0a04, B:189:0x0a0a, B:206:0x0a4d, B:209:0x0a56, B:211:0x0a5c, B:213:0x0a6c, B:215:0x0a76, B:217:0x0a7e, B:220:0x0a8b, B:223:0x0a91, B:227:0x0a9b, B:229:0x0aab, B:235:0x0ac7, B:237:0x0acd, B:239:0x0add, B:240:0x0ae4, B:242:0x0aed, B:244:0x0af3, B:246:0x0b09, B:271:0x0b62, B:247:0x0b13, B:249:0x0b1f, B:270:0x0b61, B:252:0x0b25, B:253:0x0b29, B:255:0x0b2d, B:258:0x0b37, B:261:0x0b42, B:264:0x0b4c, B:267:0x0b57, B:272:0x0b6d, B:274:0x0baa, B:321:0x0c8d, B:325:0x0ca9, B:324:0x0c96, B:276:0x0bbc, B:278:0x0bc2, B:279:0x0bcb, B:281:0x0bd1, B:284:0x0bda, B:286:0x0be0, B:288:0x0bf0, B:290:0x0bf4, B:292:0x0c00, B:320:0x0c8a, B:293:0x0c0b, B:295:0x0c1c, B:297:0x0c26, B:299:0x0c2b, B:296:0x0c21, B:301:0x0c30, B:304:0x0c3a, B:306:0x0c40, B:308:0x0c50, B:310:0x0c54, B:312:0x0c60, B:313:0x0c69, B:315:0x0c79, B:317:0x0c83, B:316:0x0c7e, B:318:0x0c86, B:232:0x0ab7, B:191:0x0a11, B:193:0x0a17, B:194:0x0a1c, B:196:0x0a22, B:198:0x0a2c, B:200:0x0a33, B:202:0x0a3d, B:145:0x0753, B:147:0x075d, B:148:0x07af, B:153:0x07c1, B:156:0x0832, B:158:0x0840, B:159:0x08d8, B:161:0x0935, B:163:0x0975, B:165:0x098a, B:167:0x0992, B:168:0x0996, B:170:0x099a, B:173:0x09ad, B:175:0x09b7, B:177:0x09c9, B:179:0x09d3, B:180:0x09df, B:182:0x09e9, B:183:0x09f3, B:327:0x0d53, B:331:0x0daf, B:334:0x0dd2, B:336:0x0ddc, B:338:0x0e15, B:340:0x0e2a, B:341:0x0e54, B:343:0x0e60, B:344:0x0e6a, B:346:0x0e74, B:347:0x0e82, B:349:0x0e88, B:390:0x0fc6, B:392:0x0ffc, B:393:0x1020, B:395:0x102b, B:396:0x1071, B:398:0x1079, B:399:0x107d, B:415:0x10f7, B:401:0x1082, B:402:0x108b, B:403:0x1093, B:404:0x109b, B:405:0x10a3, B:406:0x10ab, B:407:0x10b3, B:408:0x10bb, B:409:0x10c7, B:410:0x10d3, B:412:0x10d9, B:413:0x10ec, B:414:0x10f1, B:416:0x10fe, B:418:0x110b, B:420:0x1114, B:422:0x114e, B:424:0x1156, B:425:0x1163, B:427:0x1169, B:428:0x1182, B:421:0x113e, B:430:0x11a9, B:432:0x11ba, B:433:0x11d9, B:435:0x11e4, B:437:0x121a, B:439:0x1229, B:440:0x1255, B:442:0x1266, B:443:0x126c, B:460:0x1303, B:480:0x1390, B:481:0x1397), top: B:490:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0af3 A[Catch: XmlPullParserException -> 0x1398, TryCatch #2 {XmlPullParserException -> 0x1398, blocks: (B:3:0x0012, B:5:0x0025, B:7:0x002f, B:9:0x0059, B:12:0x0078, B:15:0x0085, B:17:0x0093, B:21:0x00a4, B:26:0x00c9, B:29:0x00d4, B:462:0x132d, B:471:0x1343, B:472:0x134a, B:473:0x134b, B:475:0x1351, B:477:0x136d, B:478:0x1374, B:32:0x0129, B:35:0x0131, B:36:0x0141, B:38:0x014c, B:46:0x016e, B:48:0x0174, B:39:0x0151, B:41:0x0159, B:42:0x015e, B:44:0x0166, B:45:0x016b, B:49:0x0189, B:53:0x0198, B:54:0x01a8, B:56:0x01b0, B:59:0x01ce, B:62:0x01df, B:64:0x01ea, B:70:0x021a, B:72:0x0220, B:67:0x0202, B:69:0x020d, B:74:0x0244, B:77:0x024e, B:79:0x0264, B:81:0x0269, B:82:0x0289, B:85:0x0294, B:445:0x1273, B:447:0x127b, B:451:0x12a1, B:452:0x12bd, B:453:0x12be, B:457:0x12d4, B:456:0x12cf, B:87:0x02fc, B:91:0x030f, B:92:0x03a2, B:95:0x03ad, B:352:0x0e95, B:354:0x0e9d, B:355:0x0ea7, B:357:0x0ead, B:359:0x0ebd, B:360:0x0ec0, B:363:0x0ec6, B:365:0x0ed3, B:367:0x0edb, B:370:0x0eea, B:372:0x0ef0, B:374:0x0efc, B:375:0x0f00, B:376:0x0f03, B:377:0x0f08, B:379:0x0f15, B:381:0x0f26, B:385:0x0f39, B:382:0x0f2e, B:384:0x0f32, B:386:0x0f46, B:387:0x0f4d, B:388:0x0f4e, B:99:0x045f, B:101:0x0469, B:103:0x0471, B:104:0x0475, B:106:0x0479, B:108:0x04ba, B:110:0x04c2, B:116:0x04d5, B:115:0x04ce, B:117:0x04df, B:119:0x04e7, B:121:0x0540, B:123:0x0548, B:124:0x0550, B:126:0x0558, B:127:0x0562, B:129:0x0568, B:130:0x0570, B:132:0x0578, B:133:0x05d6, B:137:0x05e5, B:138:0x066a, B:141:0x0675, B:185:0x09fc, B:187:0x0a04, B:189:0x0a0a, B:206:0x0a4d, B:209:0x0a56, B:211:0x0a5c, B:213:0x0a6c, B:215:0x0a76, B:217:0x0a7e, B:220:0x0a8b, B:223:0x0a91, B:227:0x0a9b, B:229:0x0aab, B:235:0x0ac7, B:237:0x0acd, B:239:0x0add, B:240:0x0ae4, B:242:0x0aed, B:244:0x0af3, B:246:0x0b09, B:271:0x0b62, B:247:0x0b13, B:249:0x0b1f, B:270:0x0b61, B:252:0x0b25, B:253:0x0b29, B:255:0x0b2d, B:258:0x0b37, B:261:0x0b42, B:264:0x0b4c, B:267:0x0b57, B:272:0x0b6d, B:274:0x0baa, B:321:0x0c8d, B:325:0x0ca9, B:324:0x0c96, B:276:0x0bbc, B:278:0x0bc2, B:279:0x0bcb, B:281:0x0bd1, B:284:0x0bda, B:286:0x0be0, B:288:0x0bf0, B:290:0x0bf4, B:292:0x0c00, B:320:0x0c8a, B:293:0x0c0b, B:295:0x0c1c, B:297:0x0c26, B:299:0x0c2b, B:296:0x0c21, B:301:0x0c30, B:304:0x0c3a, B:306:0x0c40, B:308:0x0c50, B:310:0x0c54, B:312:0x0c60, B:313:0x0c69, B:315:0x0c79, B:317:0x0c83, B:316:0x0c7e, B:318:0x0c86, B:232:0x0ab7, B:191:0x0a11, B:193:0x0a17, B:194:0x0a1c, B:196:0x0a22, B:198:0x0a2c, B:200:0x0a33, B:202:0x0a3d, B:145:0x0753, B:147:0x075d, B:148:0x07af, B:153:0x07c1, B:156:0x0832, B:158:0x0840, B:159:0x08d8, B:161:0x0935, B:163:0x0975, B:165:0x098a, B:167:0x0992, B:168:0x0996, B:170:0x099a, B:173:0x09ad, B:175:0x09b7, B:177:0x09c9, B:179:0x09d3, B:180:0x09df, B:182:0x09e9, B:183:0x09f3, B:327:0x0d53, B:331:0x0daf, B:334:0x0dd2, B:336:0x0ddc, B:338:0x0e15, B:340:0x0e2a, B:341:0x0e54, B:343:0x0e60, B:344:0x0e6a, B:346:0x0e74, B:347:0x0e82, B:349:0x0e88, B:390:0x0fc6, B:392:0x0ffc, B:393:0x1020, B:395:0x102b, B:396:0x1071, B:398:0x1079, B:399:0x107d, B:415:0x10f7, B:401:0x1082, B:402:0x108b, B:403:0x1093, B:404:0x109b, B:405:0x10a3, B:406:0x10ab, B:407:0x10b3, B:408:0x10bb, B:409:0x10c7, B:410:0x10d3, B:412:0x10d9, B:413:0x10ec, B:414:0x10f1, B:416:0x10fe, B:418:0x110b, B:420:0x1114, B:422:0x114e, B:424:0x1156, B:425:0x1163, B:427:0x1169, B:428:0x1182, B:421:0x113e, B:430:0x11a9, B:432:0x11ba, B:433:0x11d9, B:435:0x11e4, B:437:0x121a, B:439:0x1229, B:440:0x1255, B:442:0x1266, B:443:0x126c, B:460:0x1303, B:480:0x1390, B:481:0x1397), top: B:490:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0b23  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0baa A[Catch: XmlPullParserException -> 0x1398, TryCatch #2 {XmlPullParserException -> 0x1398, blocks: (B:3:0x0012, B:5:0x0025, B:7:0x002f, B:9:0x0059, B:12:0x0078, B:15:0x0085, B:17:0x0093, B:21:0x00a4, B:26:0x00c9, B:29:0x00d4, B:462:0x132d, B:471:0x1343, B:472:0x134a, B:473:0x134b, B:475:0x1351, B:477:0x136d, B:478:0x1374, B:32:0x0129, B:35:0x0131, B:36:0x0141, B:38:0x014c, B:46:0x016e, B:48:0x0174, B:39:0x0151, B:41:0x0159, B:42:0x015e, B:44:0x0166, B:45:0x016b, B:49:0x0189, B:53:0x0198, B:54:0x01a8, B:56:0x01b0, B:59:0x01ce, B:62:0x01df, B:64:0x01ea, B:70:0x021a, B:72:0x0220, B:67:0x0202, B:69:0x020d, B:74:0x0244, B:77:0x024e, B:79:0x0264, B:81:0x0269, B:82:0x0289, B:85:0x0294, B:445:0x1273, B:447:0x127b, B:451:0x12a1, B:452:0x12bd, B:453:0x12be, B:457:0x12d4, B:456:0x12cf, B:87:0x02fc, B:91:0x030f, B:92:0x03a2, B:95:0x03ad, B:352:0x0e95, B:354:0x0e9d, B:355:0x0ea7, B:357:0x0ead, B:359:0x0ebd, B:360:0x0ec0, B:363:0x0ec6, B:365:0x0ed3, B:367:0x0edb, B:370:0x0eea, B:372:0x0ef0, B:374:0x0efc, B:375:0x0f00, B:376:0x0f03, B:377:0x0f08, B:379:0x0f15, B:381:0x0f26, B:385:0x0f39, B:382:0x0f2e, B:384:0x0f32, B:386:0x0f46, B:387:0x0f4d, B:388:0x0f4e, B:99:0x045f, B:101:0x0469, B:103:0x0471, B:104:0x0475, B:106:0x0479, B:108:0x04ba, B:110:0x04c2, B:116:0x04d5, B:115:0x04ce, B:117:0x04df, B:119:0x04e7, B:121:0x0540, B:123:0x0548, B:124:0x0550, B:126:0x0558, B:127:0x0562, B:129:0x0568, B:130:0x0570, B:132:0x0578, B:133:0x05d6, B:137:0x05e5, B:138:0x066a, B:141:0x0675, B:185:0x09fc, B:187:0x0a04, B:189:0x0a0a, B:206:0x0a4d, B:209:0x0a56, B:211:0x0a5c, B:213:0x0a6c, B:215:0x0a76, B:217:0x0a7e, B:220:0x0a8b, B:223:0x0a91, B:227:0x0a9b, B:229:0x0aab, B:235:0x0ac7, B:237:0x0acd, B:239:0x0add, B:240:0x0ae4, B:242:0x0aed, B:244:0x0af3, B:246:0x0b09, B:271:0x0b62, B:247:0x0b13, B:249:0x0b1f, B:270:0x0b61, B:252:0x0b25, B:253:0x0b29, B:255:0x0b2d, B:258:0x0b37, B:261:0x0b42, B:264:0x0b4c, B:267:0x0b57, B:272:0x0b6d, B:274:0x0baa, B:321:0x0c8d, B:325:0x0ca9, B:324:0x0c96, B:276:0x0bbc, B:278:0x0bc2, B:279:0x0bcb, B:281:0x0bd1, B:284:0x0bda, B:286:0x0be0, B:288:0x0bf0, B:290:0x0bf4, B:292:0x0c00, B:320:0x0c8a, B:293:0x0c0b, B:295:0x0c1c, B:297:0x0c26, B:299:0x0c2b, B:296:0x0c21, B:301:0x0c30, B:304:0x0c3a, B:306:0x0c40, B:308:0x0c50, B:310:0x0c54, B:312:0x0c60, B:313:0x0c69, B:315:0x0c79, B:317:0x0c83, B:316:0x0c7e, B:318:0x0c86, B:232:0x0ab7, B:191:0x0a11, B:193:0x0a17, B:194:0x0a1c, B:196:0x0a22, B:198:0x0a2c, B:200:0x0a33, B:202:0x0a3d, B:145:0x0753, B:147:0x075d, B:148:0x07af, B:153:0x07c1, B:156:0x0832, B:158:0x0840, B:159:0x08d8, B:161:0x0935, B:163:0x0975, B:165:0x098a, B:167:0x0992, B:168:0x0996, B:170:0x099a, B:173:0x09ad, B:175:0x09b7, B:177:0x09c9, B:179:0x09d3, B:180:0x09df, B:182:0x09e9, B:183:0x09f3, B:327:0x0d53, B:331:0x0daf, B:334:0x0dd2, B:336:0x0ddc, B:338:0x0e15, B:340:0x0e2a, B:341:0x0e54, B:343:0x0e60, B:344:0x0e6a, B:346:0x0e74, B:347:0x0e82, B:349:0x0e88, B:390:0x0fc6, B:392:0x0ffc, B:393:0x1020, B:395:0x102b, B:396:0x1071, B:398:0x1079, B:399:0x107d, B:415:0x10f7, B:401:0x1082, B:402:0x108b, B:403:0x1093, B:404:0x109b, B:405:0x10a3, B:406:0x10ab, B:407:0x10b3, B:408:0x10bb, B:409:0x10c7, B:410:0x10d3, B:412:0x10d9, B:413:0x10ec, B:414:0x10f1, B:416:0x10fe, B:418:0x110b, B:420:0x1114, B:422:0x114e, B:424:0x1156, B:425:0x1163, B:427:0x1169, B:428:0x1182, B:421:0x113e, B:430:0x11a9, B:432:0x11ba, B:433:0x11d9, B:435:0x11e4, B:437:0x121a, B:439:0x1229, B:440:0x1255, B:442:0x1266, B:443:0x126c, B:460:0x1303, B:480:0x1390, B:481:0x1397), top: B:490:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0bbc A[Catch: XmlPullParserException -> 0x1398, TryCatch #2 {XmlPullParserException -> 0x1398, blocks: (B:3:0x0012, B:5:0x0025, B:7:0x002f, B:9:0x0059, B:12:0x0078, B:15:0x0085, B:17:0x0093, B:21:0x00a4, B:26:0x00c9, B:29:0x00d4, B:462:0x132d, B:471:0x1343, B:472:0x134a, B:473:0x134b, B:475:0x1351, B:477:0x136d, B:478:0x1374, B:32:0x0129, B:35:0x0131, B:36:0x0141, B:38:0x014c, B:46:0x016e, B:48:0x0174, B:39:0x0151, B:41:0x0159, B:42:0x015e, B:44:0x0166, B:45:0x016b, B:49:0x0189, B:53:0x0198, B:54:0x01a8, B:56:0x01b0, B:59:0x01ce, B:62:0x01df, B:64:0x01ea, B:70:0x021a, B:72:0x0220, B:67:0x0202, B:69:0x020d, B:74:0x0244, B:77:0x024e, B:79:0x0264, B:81:0x0269, B:82:0x0289, B:85:0x0294, B:445:0x1273, B:447:0x127b, B:451:0x12a1, B:452:0x12bd, B:453:0x12be, B:457:0x12d4, B:456:0x12cf, B:87:0x02fc, B:91:0x030f, B:92:0x03a2, B:95:0x03ad, B:352:0x0e95, B:354:0x0e9d, B:355:0x0ea7, B:357:0x0ead, B:359:0x0ebd, B:360:0x0ec0, B:363:0x0ec6, B:365:0x0ed3, B:367:0x0edb, B:370:0x0eea, B:372:0x0ef0, B:374:0x0efc, B:375:0x0f00, B:376:0x0f03, B:377:0x0f08, B:379:0x0f15, B:381:0x0f26, B:385:0x0f39, B:382:0x0f2e, B:384:0x0f32, B:386:0x0f46, B:387:0x0f4d, B:388:0x0f4e, B:99:0x045f, B:101:0x0469, B:103:0x0471, B:104:0x0475, B:106:0x0479, B:108:0x04ba, B:110:0x04c2, B:116:0x04d5, B:115:0x04ce, B:117:0x04df, B:119:0x04e7, B:121:0x0540, B:123:0x0548, B:124:0x0550, B:126:0x0558, B:127:0x0562, B:129:0x0568, B:130:0x0570, B:132:0x0578, B:133:0x05d6, B:137:0x05e5, B:138:0x066a, B:141:0x0675, B:185:0x09fc, B:187:0x0a04, B:189:0x0a0a, B:206:0x0a4d, B:209:0x0a56, B:211:0x0a5c, B:213:0x0a6c, B:215:0x0a76, B:217:0x0a7e, B:220:0x0a8b, B:223:0x0a91, B:227:0x0a9b, B:229:0x0aab, B:235:0x0ac7, B:237:0x0acd, B:239:0x0add, B:240:0x0ae4, B:242:0x0aed, B:244:0x0af3, B:246:0x0b09, B:271:0x0b62, B:247:0x0b13, B:249:0x0b1f, B:270:0x0b61, B:252:0x0b25, B:253:0x0b29, B:255:0x0b2d, B:258:0x0b37, B:261:0x0b42, B:264:0x0b4c, B:267:0x0b57, B:272:0x0b6d, B:274:0x0baa, B:321:0x0c8d, B:325:0x0ca9, B:324:0x0c96, B:276:0x0bbc, B:278:0x0bc2, B:279:0x0bcb, B:281:0x0bd1, B:284:0x0bda, B:286:0x0be0, B:288:0x0bf0, B:290:0x0bf4, B:292:0x0c00, B:320:0x0c8a, B:293:0x0c0b, B:295:0x0c1c, B:297:0x0c26, B:299:0x0c2b, B:296:0x0c21, B:301:0x0c30, B:304:0x0c3a, B:306:0x0c40, B:308:0x0c50, B:310:0x0c54, B:312:0x0c60, B:313:0x0c69, B:315:0x0c79, B:317:0x0c83, B:316:0x0c7e, B:318:0x0c86, B:232:0x0ab7, B:191:0x0a11, B:193:0x0a17, B:194:0x0a1c, B:196:0x0a22, B:198:0x0a2c, B:200:0x0a33, B:202:0x0a3d, B:145:0x0753, B:147:0x075d, B:148:0x07af, B:153:0x07c1, B:156:0x0832, B:158:0x0840, B:159:0x08d8, B:161:0x0935, B:163:0x0975, B:165:0x098a, B:167:0x0992, B:168:0x0996, B:170:0x099a, B:173:0x09ad, B:175:0x09b7, B:177:0x09c9, B:179:0x09d3, B:180:0x09df, B:182:0x09e9, B:183:0x09f3, B:327:0x0d53, B:331:0x0daf, B:334:0x0dd2, B:336:0x0ddc, B:338:0x0e15, B:340:0x0e2a, B:341:0x0e54, B:343:0x0e60, B:344:0x0e6a, B:346:0x0e74, B:347:0x0e82, B:349:0x0e88, B:390:0x0fc6, B:392:0x0ffc, B:393:0x1020, B:395:0x102b, B:396:0x1071, B:398:0x1079, B:399:0x107d, B:415:0x10f7, B:401:0x1082, B:402:0x108b, B:403:0x1093, B:404:0x109b, B:405:0x10a3, B:406:0x10ab, B:407:0x10b3, B:408:0x10bb, B:409:0x10c7, B:410:0x10d3, B:412:0x10d9, B:413:0x10ec, B:414:0x10f1, B:416:0x10fe, B:418:0x110b, B:420:0x1114, B:422:0x114e, B:424:0x1156, B:425:0x1163, B:427:0x1169, B:428:0x1182, B:421:0x113e, B:430:0x11a9, B:432:0x11ba, B:433:0x11d9, B:435:0x11e4, B:437:0x121a, B:439:0x1229, B:440:0x1255, B:442:0x1266, B:443:0x126c, B:460:0x1303, B:480:0x1390, B:481:0x1397), top: B:490:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0c93  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0c96 A[Catch: XmlPullParserException -> 0x1398, TryCatch #2 {XmlPullParserException -> 0x1398, blocks: (B:3:0x0012, B:5:0x0025, B:7:0x002f, B:9:0x0059, B:12:0x0078, B:15:0x0085, B:17:0x0093, B:21:0x00a4, B:26:0x00c9, B:29:0x00d4, B:462:0x132d, B:471:0x1343, B:472:0x134a, B:473:0x134b, B:475:0x1351, B:477:0x136d, B:478:0x1374, B:32:0x0129, B:35:0x0131, B:36:0x0141, B:38:0x014c, B:46:0x016e, B:48:0x0174, B:39:0x0151, B:41:0x0159, B:42:0x015e, B:44:0x0166, B:45:0x016b, B:49:0x0189, B:53:0x0198, B:54:0x01a8, B:56:0x01b0, B:59:0x01ce, B:62:0x01df, B:64:0x01ea, B:70:0x021a, B:72:0x0220, B:67:0x0202, B:69:0x020d, B:74:0x0244, B:77:0x024e, B:79:0x0264, B:81:0x0269, B:82:0x0289, B:85:0x0294, B:445:0x1273, B:447:0x127b, B:451:0x12a1, B:452:0x12bd, B:453:0x12be, B:457:0x12d4, B:456:0x12cf, B:87:0x02fc, B:91:0x030f, B:92:0x03a2, B:95:0x03ad, B:352:0x0e95, B:354:0x0e9d, B:355:0x0ea7, B:357:0x0ead, B:359:0x0ebd, B:360:0x0ec0, B:363:0x0ec6, B:365:0x0ed3, B:367:0x0edb, B:370:0x0eea, B:372:0x0ef0, B:374:0x0efc, B:375:0x0f00, B:376:0x0f03, B:377:0x0f08, B:379:0x0f15, B:381:0x0f26, B:385:0x0f39, B:382:0x0f2e, B:384:0x0f32, B:386:0x0f46, B:387:0x0f4d, B:388:0x0f4e, B:99:0x045f, B:101:0x0469, B:103:0x0471, B:104:0x0475, B:106:0x0479, B:108:0x04ba, B:110:0x04c2, B:116:0x04d5, B:115:0x04ce, B:117:0x04df, B:119:0x04e7, B:121:0x0540, B:123:0x0548, B:124:0x0550, B:126:0x0558, B:127:0x0562, B:129:0x0568, B:130:0x0570, B:132:0x0578, B:133:0x05d6, B:137:0x05e5, B:138:0x066a, B:141:0x0675, B:185:0x09fc, B:187:0x0a04, B:189:0x0a0a, B:206:0x0a4d, B:209:0x0a56, B:211:0x0a5c, B:213:0x0a6c, B:215:0x0a76, B:217:0x0a7e, B:220:0x0a8b, B:223:0x0a91, B:227:0x0a9b, B:229:0x0aab, B:235:0x0ac7, B:237:0x0acd, B:239:0x0add, B:240:0x0ae4, B:242:0x0aed, B:244:0x0af3, B:246:0x0b09, B:271:0x0b62, B:247:0x0b13, B:249:0x0b1f, B:270:0x0b61, B:252:0x0b25, B:253:0x0b29, B:255:0x0b2d, B:258:0x0b37, B:261:0x0b42, B:264:0x0b4c, B:267:0x0b57, B:272:0x0b6d, B:274:0x0baa, B:321:0x0c8d, B:325:0x0ca9, B:324:0x0c96, B:276:0x0bbc, B:278:0x0bc2, B:279:0x0bcb, B:281:0x0bd1, B:284:0x0bda, B:286:0x0be0, B:288:0x0bf0, B:290:0x0bf4, B:292:0x0c00, B:320:0x0c8a, B:293:0x0c0b, B:295:0x0c1c, B:297:0x0c26, B:299:0x0c2b, B:296:0x0c21, B:301:0x0c30, B:304:0x0c3a, B:306:0x0c40, B:308:0x0c50, B:310:0x0c54, B:312:0x0c60, B:313:0x0c69, B:315:0x0c79, B:317:0x0c83, B:316:0x0c7e, B:318:0x0c86, B:232:0x0ab7, B:191:0x0a11, B:193:0x0a17, B:194:0x0a1c, B:196:0x0a22, B:198:0x0a2c, B:200:0x0a33, B:202:0x0a3d, B:145:0x0753, B:147:0x075d, B:148:0x07af, B:153:0x07c1, B:156:0x0832, B:158:0x0840, B:159:0x08d8, B:161:0x0935, B:163:0x0975, B:165:0x098a, B:167:0x0992, B:168:0x0996, B:170:0x099a, B:173:0x09ad, B:175:0x09b7, B:177:0x09c9, B:179:0x09d3, B:180:0x09df, B:182:0x09e9, B:183:0x09f3, B:327:0x0d53, B:331:0x0daf, B:334:0x0dd2, B:336:0x0ddc, B:338:0x0e15, B:340:0x0e2a, B:341:0x0e54, B:343:0x0e60, B:344:0x0e6a, B:346:0x0e74, B:347:0x0e82, B:349:0x0e88, B:390:0x0fc6, B:392:0x0ffc, B:393:0x1020, B:395:0x102b, B:396:0x1071, B:398:0x1079, B:399:0x107d, B:415:0x10f7, B:401:0x1082, B:402:0x108b, B:403:0x1093, B:404:0x109b, B:405:0x10a3, B:406:0x10ab, B:407:0x10b3, B:408:0x10bb, B:409:0x10c7, B:410:0x10d3, B:412:0x10d9, B:413:0x10ec, B:414:0x10f1, B:416:0x10fe, B:418:0x110b, B:420:0x1114, B:422:0x114e, B:424:0x1156, B:425:0x1163, B:427:0x1169, B:428:0x1182, B:421:0x113e, B:430:0x11a9, B:432:0x11ba, B:433:0x11d9, B:435:0x11e4, B:437:0x121a, B:439:0x1229, B:440:0x1255, B:442:0x1266, B:443:0x126c, B:460:0x1303, B:480:0x1390, B:481:0x1397), top: B:490:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0ce6 A[LOOP:8: B:138:0x066a->B:326:0x0ce6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0f77 A[LOOP:4: B:92:0x03a2->B:389:0x0f77, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x12da A[LOOP:3: B:82:0x0289->B:459:0x12da, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:497:0x127b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0e9d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0a04 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0abe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023d A[LOOP:2: B:62:0x01df->B:73:0x023d, LOOP_END] */
    @Override // com.google.ads.interactivemedia.v3.internal.adc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.xj a(android.net.Uri r144, java.io.InputStream r145) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 5068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xl.a(android.net.Uri, java.io.InputStream):com.google.ads.interactivemedia.v3.internal.xj");
    }

    protected final xy c(XmlPullParser xmlPullParser, xy xyVar) throws XmlPullParserException, NumberFormatException, IOException {
        long j;
        long j2;
        long jN = n(xmlPullParser, "timescale", xyVar != null ? xyVar.i : 1L);
        long jN2 = n(xmlPullParser, "presentationTimeOffset", xyVar != null ? xyVar.j : 0L);
        long j3 = xyVar != null ? xyVar.a : 0L;
        long j4 = xyVar != null ? xyVar.b : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            long j5 = Long.parseLong(strArrSplit[0]);
            j = (Long.parseLong(strArrSplit[1]) - j5) + 1;
            j2 = j5;
        } else {
            j = j4;
            j2 = j3;
        }
        xq xqVarG = xyVar != null ? xyVar.h : null;
        do {
            xmlPullParser.next();
            if (atv.e(xmlPullParser, "Initialization")) {
                xqVarG = g(xmlPullParser);
            } else {
                h(xmlPullParser);
            }
        } while (!atv.c(xmlPullParser, "SegmentBase"));
        return new xy(xqVarG, jN, jN2, j2, j);
    }

    protected final xv d(XmlPullParser xmlPullParser, xv xvVar, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long jN = n(xmlPullParser, "timescale", xvVar != null ? xvVar.i : 1L);
        long jN2 = n(xmlPullParser, "presentationTimeOffset", xvVar != null ? xvVar.j : 0L);
        long jN3 = n(xmlPullParser, "duration", xvVar != null ? xvVar.b : -9223372036854775807L);
        long jN4 = n(xmlPullParser, "startNumber", xvVar != null ? xvVar.a : 1L);
        long jB = B(j3, j4);
        List<xx> listF = null;
        List arrayList = null;
        xq xqVarG = null;
        do {
            xmlPullParser.next();
            if (atv.e(xmlPullParser, "Initialization")) {
                xqVarG = g(xmlPullParser);
            } else if (atv.e(xmlPullParser, "SegmentTimeline")) {
                listF = f(xmlPullParser, jN, j2);
            } else if (atv.e(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(x(xmlPullParser, "media", "mediaRange"));
            } else {
                h(xmlPullParser);
            }
        } while (!atv.c(xmlPullParser, "SegmentList"));
        if (xvVar != null) {
            if (xqVarG == null) {
                xqVarG = xvVar.h;
            }
            if (listF == null) {
                listF = xvVar.c;
            }
            if (arrayList == null) {
                arrayList = xvVar.e;
            }
        }
        return new xv(xqVarG, jN, jN2, jN4, jN3, listF, jB, arrayList, bi.b(j5), bi.b(j));
    }

    protected final xw e(XmlPullParser xmlPullParser, xw xwVar, List<xm> list, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, NumberFormatException, IOException {
        long j6;
        long jN = n(xmlPullParser, "timescale", xwVar != null ? xwVar.i : 1L);
        long jN2 = n(xmlPullParser, "presentationTimeOffset", xwVar != null ? xwVar.j : 0L);
        long jN3 = n(xmlPullParser, "duration", xwVar != null ? xwVar.b : -9223372036854775807L);
        long jN4 = n(xmlPullParser, "startNumber", xwVar != null ? xwVar.a : 1L);
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                j6 = -1;
                break;
            }
            xm xmVar = list.get(i);
            if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(xmVar.a)) {
                j6 = Long.parseLong(xmVar.b);
                break;
            }
            i++;
        }
        long j7 = j6;
        long jB = B(j3, j4);
        List<xx> listF = null;
        yc ycVarZ = z(xmlPullParser, "media", xwVar != null ? xwVar.f : null);
        yc ycVarZ2 = z(xmlPullParser, "initialization", xwVar != null ? xwVar.e : null);
        xq xqVarG = null;
        do {
            xmlPullParser.next();
            if (atv.e(xmlPullParser, "Initialization")) {
                xqVarG = g(xmlPullParser);
            } else if (atv.e(xmlPullParser, "SegmentTimeline")) {
                listF = f(xmlPullParser, jN, j2);
            } else {
                h(xmlPullParser);
            }
        } while (!atv.c(xmlPullParser, "SegmentTemplate"));
        if (xwVar != null) {
            if (xqVarG == null) {
                xqVarG = xwVar.h;
            }
            if (listF == null) {
                listF = xwVar.c;
            }
        }
        return new xw(xqVarG, jN, jN2, jN4, j7, jN3, listF, jB, ycVarZ2, ycVarZ, bi.b(j5), bi.b(j));
    }

    protected final List<xx> f(XmlPullParser xmlPullParser, long j, long j2) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jC = 0;
        long jN = -9223372036854775807L;
        boolean z = false;
        int iM = 0;
        do {
            xmlPullParser.next();
            if (atv.e(xmlPullParser, "S")) {
                long jN2 = n(xmlPullParser, "t", -9223372036854775807L);
                if (z) {
                    jC = C(arrayList, jC, jN, iM, jN2);
                }
                if (jN2 == -9223372036854775807L) {
                    jN2 = jC;
                }
                jN = n(xmlPullParser, "d", -9223372036854775807L);
                iM = m(xmlPullParser, "r", 0);
                jC = jN2;
                z = true;
            } else {
                h(xmlPullParser);
            }
        } while (!atv.c(xmlPullParser, "SegmentTimeline"));
        if (z) {
            C(arrayList, jC, jN, iM, aeu.N(j2, j, 1000L));
        }
        return arrayList;
    }

    protected final xq g(XmlPullParser xmlPullParser) {
        return x(xmlPullParser, "sourceURL", "range");
    }
}
