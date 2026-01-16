package com.google.ads.interactivemedia.v3.internal;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zw implements adc<zu> {
    private final zr Q;
    private static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern b = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern c = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern d = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern g = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern h = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern l = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern m = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern n = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern o = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern p = k("CAN-SKIP-DATERANGES");
    private static final Pattern q = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern r = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern s = k("CAN-BLOCK-RELOAD");
    private static final Pattern t = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern u = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern v = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern w = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern x = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern y = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern z = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern A = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern B = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern C = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern D = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern E = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern F = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern G = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern H = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern I = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern K = k("AUTOSELECT");
    private static final Pattern L = k("DEFAULT");
    private static final Pattern M = k("FORCED");
    private static final Pattern N = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern O = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern P = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public zw() {
        zr zrVar = zr.a;
        throw null;
    }

    public zw(zr zrVar) {
        this.Q = zrVar;
    }

    private static int b(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !aeu.B(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static jb c(String str, String str2, Map<String, String> map) throws dt {
        String strI = i(str, B, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String strG = g(str, C, map);
            return new jb(bi.c, "video/mp4", Base64.decode(strG.substring(strG.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new jb(bi.c, "hls", aeu.y(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(strI)) {
            return null;
        }
        String strG2 = g(str, C, map);
        byte[] bArrDecode = Base64.decode(strG2.substring(strG2.indexOf(44)), 0);
        UUID uuid = bi.d;
        return new jb(uuid, "video/mp4", mz.a(uuid, bArrDecode));
    }

    private static String d(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int e(String str, Pattern pattern) throws dt {
        return Integer.parseInt(g(str, pattern, Collections.emptyMap()));
    }

    private static double f(String str, Pattern pattern) throws dt {
        return Double.parseDouble(g(str, pattern, Collections.emptyMap()));
    }

    private static String g(String str, Pattern pattern, Map<String, String> map) throws dt {
        String strH = h(str, pattern, map);
        if (strH != null) {
            return strH;
        }
        String strPattern = pattern.pattern();
        StringBuilder sb = new StringBuilder(String.valueOf(strPattern).length() + 19 + String.valueOf(str).length());
        sb.append("Couldn't match ");
        sb.append(strPattern);
        sb.append(" in ");
        sb.append(str);
        throw new dt(sb.toString());
    }

    private static String h(String str, Pattern pattern, Map<String, String> map) {
        return i(str, pattern, null, map);
    }

    private static String i(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            ary.t(str2);
        }
        return (map.isEmpty() || str2 == null) ? str2 : j(str2, map);
    }

    private static String j(String str, Map<String, String> map) {
        Matcher matcher = P.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static Pattern k(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 9);
        sb.append(str);
        sb.append("=(");
        sb.append("NO");
        sb.append("|");
        sb.append("YES");
        sb.append(")");
        return Pattern.compile(sb.toString());
    }

    private static boolean l(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return false;
    }

    private static double m(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -9.223372036854776E18d;
        }
        String strGroup = matcher.group(1);
        ary.t(strGroup);
        return Double.parseDouble(strGroup);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02de, code lost:
    
        if (r3.add(r6.a) == false) goto L505;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02e4, code lost:
    
        if (r6.b.j != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02e6, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02e8, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02e9, code lost:
    
        com.google.ads.interactivemedia.v3.internal.ary.q(r7);
        r9 = (java.util.ArrayList) r1.get(r6.a);
        com.google.ads.interactivemedia.v3.internal.ary.t(r9);
        r9 = new com.google.ads.interactivemedia.v3.internal.qz(new com.google.ads.interactivemedia.v3.internal.zg(null, null, r9));
        r7 = r6.b.a();
        r7.X(r9);
        r2.add(new com.google.ads.interactivemedia.v3.internal.zq(r6.a, r7.a(), r6.c, r6.d, r6.e, r6.f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0333, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0336, code lost:
    
        r1 = 0;
        r10 = null;
        r22 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x033e, code lost:
    
        if (r1 >= r39.size()) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0340, code lost:
    
        r3 = r39;
        r4 = (java.lang.String) r3.get(r1);
        r6 = g(r4, com.google.ads.interactivemedia.v3.internal.zw.H, r5);
        r7 = g(r4, com.google.ads.interactivemedia.v3.internal.zw.G, r5);
        r9 = new com.google.ads.interactivemedia.v3.internal.cx();
        r12 = new java.lang.StringBuilder((r6.length() + 1) + r7.length());
        r12.append(r6);
        r12.append(":");
        r12.append(r7);
        r9.S(r12.toString());
        r9.U(r7);
        r9.K("application/x-mpegURL");
        r11 = l(r4, com.google.ads.interactivemedia.v3.internal.zw.L);
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x038f, code lost:
    
        if (l(r4, com.google.ads.interactivemedia.v3.internal.zw.M) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0391, code lost:
    
        r11 = (r11 == true ? 1 : 0) | 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0393, code lost:
    
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0399, code lost:
    
        if (l(r4, com.google.ads.interactivemedia.v3.internal.zw.K) == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x039b, code lost:
    
        r11 = (r11 == true ? 1 : 0) | 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x039d, code lost:
    
        r9.ag(r11);
        r11 = h(r4, com.google.ads.interactivemedia.v3.internal.zw.I, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x03aa, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x03ac, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x03ae, code lost:
    
        r11 = com.google.ads.interactivemedia.v3.internal.aeu.z(r11, ",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03bb, code lost:
    
        if (true == com.google.ads.interactivemedia.v3.internal.aeu.d(r11, "public.accessibility.describes-video")) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03bd, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03bf, code lost:
    
        r12 = 512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x03c7, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.aeu.d(r11, "public.accessibility.transcribes-spoken-dialog") == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03c9, code lost:
    
        r12 = r12 | 4096;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x03d1, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.aeu.d(r11, "public.accessibility.describes-music-and-sound") == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03d3, code lost:
    
        r12 = r12 | 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03db, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.aeu.d(r11, "public.easy-to-read") == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03dd, code lost:
    
        r11 = r12 | 8192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03e0, code lost:
    
        r11 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03e1, code lost:
    
        r9.ac(r11);
        r9.V(h(r4, com.google.ads.interactivemedia.v3.internal.zw.F, r5));
        r11 = h(r4, com.google.ads.interactivemedia.v3.internal.zw.C, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03f3, code lost:
    
        if (r11 != null) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03f5, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x03f7, code lost:
    
        r11 = com.google.ads.interactivemedia.v3.internal.atv.i(r15, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x03fb, code lost:
    
        r39 = r3;
        r12 = new com.google.ads.interactivemedia.v3.internal.qz(new com.google.ads.interactivemedia.v3.internal.zg(r6, r7, java.util.Collections.emptyList()));
        r3 = g(r4, com.google.ads.interactivemedia.v3.internal.zw.E, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x041c, code lost:
    
        switch(r3.hashCode()) {
            case -959297733: goto L150;
            case -333210994: goto L147;
            case 62628790: goto L144;
            case 81665115: goto L141;
            default: goto L153;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0426, code lost:
    
        if (r3.equals("VIDEO") == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0428, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0430, code lost:
    
        if (r3.equals("AUDIO") == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0432, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x043a, code lost:
    
        if (r3.equals("CLOSED-CAPTIONS") == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x043c, code lost:
    
        r3 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0444, code lost:
    
        if (r3.equals("SUBTITLES") == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0446, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0448, code lost:
    
        r3 = 65535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0449, code lost:
    
        if (r3 == 0) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x044c, code lost:
    
        if (r3 == 1) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x044f, code lost:
    
        if (r3 == 2) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0451, code lost:
    
        if (r3 == 3) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0454, code lost:
    
        r3 = g(r4, com.google.ads.interactivemedia.v3.internal.zw.J, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0460, code lost:
    
        if (r3.startsWith("CC") == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0462, code lost:
    
        r4 = "application/cea-608";
        r3 = java.lang.Integer.parseInt(r3.substring(2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x046f, code lost:
    
        r4 = "application/cea-708";
        r3 = java.lang.Integer.parseInt(r3.substring(7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x047a, code lost:
    
        if (r10 != null) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x047c, code lost:
    
        r10 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0481, code lost:
    
        r9.ae(r4);
        r9.F(r3);
        r10.add(r9.a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x048e, code lost:
    
        r25 = r10;
        r6 = r26;
        r4 = r37;
        r13 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0498, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x049e, code lost:
    
        if (r3 >= r8.size()) goto L510;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x04a0, code lost:
    
        r4 = (com.google.ads.interactivemedia.v3.internal.zq) r8.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x04ac, code lost:
    
        if (r6.equals(r4.e) == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x04af, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x04b3, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x04b4, code lost:
    
        if (r4 == null) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x04b6, code lost:
    
        r3 = com.google.ads.interactivemedia.v3.internal.aeu.T(r4.b.i, 3);
        r9.I(r3);
        r3 = com.google.ads.interactivemedia.v3.internal.adz.h(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x04c6, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x04c9, code lost:
    
        if (r3 != null) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x04cb, code lost:
    
        r3 = "text/vtt";
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x04cc, code lost:
    
        r9.ae(r3);
        r9.X(r12);
        r13 = r38;
        r13.add(new com.google.ads.interactivemedia.v3.internal.zp(r11, r9.a(), r7));
        r25 = r10;
        r6 = r26;
        r4 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x04e8, code lost:
    
        r13 = r38;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x04ef, code lost:
    
        if (r3 >= r8.size()) goto L512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x04f1, code lost:
    
        r14 = (com.google.ads.interactivemedia.v3.internal.zq) r8.get(r3);
        r25 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x04ff, code lost:
    
        if (r6.equals(r14.d) == false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0501, code lost:
    
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0503, code lost:
    
        r3 = r3 + 1;
        r10 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0508, code lost:
    
        r25 = r10;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x050b, code lost:
    
        if (r10 == null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x050d, code lost:
    
        r3 = com.google.ads.interactivemedia.v3.internal.aeu.T(r10.b.i, 1);
        r9.I(r3);
        r3 = com.google.ads.interactivemedia.v3.internal.adz.h(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x051e, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x051f, code lost:
    
        r4 = h(r4, com.google.ads.interactivemedia.v3.internal.zw.g, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0525, code lost:
    
        if (r4 == null) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0527, code lost:
    
        r9.H(java.lang.Integer.parseInt(com.google.ads.interactivemedia.v3.internal.aeu.A(r4, "/")[0]));
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x053d, code lost:
    
        if ("audio/eac3".equals(r3) == false) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0545, code lost:
    
        if (r4.endsWith("/JOC") == false) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0547, code lost:
    
        r3 = "audio/eac3-joc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0549, code lost:
    
        r9.ae(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x054c, code lost:
    
        if (r11 == null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x054e, code lost:
    
        r9.X(r12);
        r4 = r37;
        r4.add(new com.google.ads.interactivemedia.v3.internal.zp(r11, r9.a(), r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0560, code lost:
    
        r4 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0562, code lost:
    
        if (r10 == null) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0564, code lost:
    
        r22 = r9.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0568, code lost:
    
        r6 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x056c, code lost:
    
        r25 = r10;
        r4 = r37;
        r13 = r38;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0577, code lost:
    
        if (r3 >= r8.size()) goto L514;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0579, code lost:
    
        r10 = (com.google.ads.interactivemedia.v3.internal.zq) r8.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0585, code lost:
    
        if (r6.equals(r10.c) == false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0588, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x058b, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x058c, code lost:
    
        if (r10 == null) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x058e, code lost:
    
        r3 = r10.b;
        r6 = com.google.ads.interactivemedia.v3.internal.aeu.T(r3.i, 2);
        r9.I(r6);
        r9.ae(com.google.ads.interactivemedia.v3.internal.adz.h(r6));
        r9.aj(r3.q);
        r9.Q(r3.r);
        r9.P(r3.s);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x05b2, code lost:
    
        if (r11 != null) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x05b4, code lost:
    
        r6 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x05b7, code lost:
    
        r9.X(r12);
        r6 = r26;
        r6.add(new com.google.ads.interactivemedia.v3.internal.zp(r11, r9.a(), r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x05c8, code lost:
    
        r1 = r1 + 1;
        r37 = r4;
        r26 = r6;
        r38 = r13;
        r10 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x05d4, code lost:
    
        r25 = r10;
        r6 = r26;
        r4 = r37;
        r13 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x05dc, code lost:
    
        if (r20 == false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x05de, code lost:
    
        r23 = java.util.Collections.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x05e5, code lost:
    
        r23 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x05e7, code lost:
    
        r1 = new com.google.ads.interactivemedia.v3.internal.zr(r15, r86, r2, r6, r4, r13, r21, r22, r23, r24, r5, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x05fc, code lost:
    
        com.google.ads.interactivemedia.v3.internal.aeu.r(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0601, code lost:
    
        r35 = r2;
        r27 = r3;
        r22 = "#EXT";
        r25 = "identity";
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x060e, code lost:
    
        r3 = "#EXT-X-ENDLIST";
        r6 = "#EXT-X-DISCONTINUITY-SEQUENCE";
        r7 = "#EXT-X-DISCONTINUITY";
        r8 = "#EXT-X-BYTERANGE";
        r9 = "#EXT-X-KEY";
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x061c, code lost:
    
        if (r5.startsWith("#EXT-X-TARGETDURATION") != false) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0622, code lost:
    
        if (r5.startsWith("#EXT-X-MEDIA-SEQUENCE") != false) goto L450;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0628, code lost:
    
        if (r5.startsWith("#EXTINF") != false) goto L451;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x062e, code lost:
    
        if (r5.startsWith("#EXT-X-KEY") != false) goto L452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0634, code lost:
    
        if (r5.startsWith("#EXT-X-BYTERANGE") != false) goto L453;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x063a, code lost:
    
        if (r5.equals("#EXT-X-DISCONTINUITY") != false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0640, code lost:
    
        if (r5.equals("#EXT-X-DISCONTINUITY-SEQUENCE") != false) goto L455;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0646, code lost:
    
        if (r5.equals("#EXT-X-ENDLIST") == false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0649, code lost:
    
        r4.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x064c, code lost:
    
        r3 = r27;
        r2 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0655, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0656, code lost:
    
        r1 = r0;
        r23 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x065b, code lost:
    
        r4.add(r5);
        r5 = r85.Q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0666, code lost:
    
        r13 = new com.google.ads.interactivemedia.v3.internal.zv(r4, r27);
        r28 = r86.toString();
        r4 = r5.r;
        r15 = new java.util.HashMap();
        r10 = new java.util.HashMap();
        r2 = new java.util.ArrayList();
        r4 = new java.util.ArrayList();
        r21 = new com.google.ads.interactivemedia.v3.internal.ary();
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x068c, code lost:
    
        r14 = new java.util.TreeMap();
        r86 = r2;
        r66 = r4;
        r68 = r21;
        r53 = -9223372036854775807L;
        r62 = -9223372036854775807L;
        r64 = -9223372036854775807L;
        r50 = -1;
        r41 = 0;
        r43 = 0;
        r55 = 0;
        r59 = 0;
        r69 = 0;
        r71 = 0;
        r2 = null;
        r20 = null;
        r21 = null;
        r24 = null;
        r26 = null;
        r27 = 0;
        r46 = null;
        r48 = false;
        r49 = false;
        r52 = 0;
        r57 = false;
        r58 = 0;
        r61 = 1;
        r67 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        if (com.google.ads.interactivemedia.v3.internal.aeu.B(b(r3, false, r5)) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x06d3, code lost:
    
        if (r13.a() == false) goto L460;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x06d5, code lost:
    
        r87 = r10;
        r10 = r13.b();
        r73 = r13;
        r13 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x06e3, code lost:
    
        if (r10.startsWith(r13) == false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x06e5, code lost:
    
        r4.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x06e8, code lost:
    
        r22 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x06f0, code lost:
    
        if (r10.startsWith("#EXT-X-PLAYLIST-TYPE") == false) goto L461;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x06f2, code lost:
    
        r10 = g(r10, com.google.ads.interactivemedia.v3.internal.zw.n, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x06fe, code lost:
    
        if ("VOD".equals(r10) == false) goto L462;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0700, code lost:
    
        r10 = r87;
        r13 = r73;
        r52 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        r5 = r3.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x070d, code lost:
    
        if ("EVENT".equals(r10) == false) goto L464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x070f, code lost:
    
        r10 = r87;
        r13 = r73;
        r52 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0716, code lost:
    
        r13 = r87;
        r75 = r1;
        r87 = r3;
        r74 = r4;
        r80 = r6;
        r81 = r7;
        r82 = r8;
        r83 = r9;
        r18 = r25;
        r4 = r86;
        r25 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0735, code lost:
    
        if (r10.equals("#EXT-X-I-FRAMES-ONLY") == false) goto L489;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0737, code lost:
    
        r10 = r87;
        r13 = r73;
        r49 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0749, code lost:
    
        if (r10.startsWith("#EXT-X-START") == false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x074b, code lost:
    
        r35 = f(r10, com.google.ads.interactivemedia.v3.internal.zw.w);
        r13 = r3;
        r74 = r4;
        r10 = r87;
        r53 = (long) (r35 * 1000000.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x075b, code lost:
    
        r3 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        if (r5 == null) goto L446;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x075c, code lost:
    
        r13 = r73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x075e, code lost:
    
        r4 = r74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0762, code lost:
    
        r13 = r3;
        r74 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x076b, code lost:
    
        if (r10.startsWith("#EXT-X-SERVER-CONTROL") == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x076d, code lost:
    
        m(r10, com.google.ads.interactivemedia.v3.internal.zw.o);
        l(r10, com.google.ads.interactivemedia.v3.internal.zw.p);
        m(r10, com.google.ads.interactivemedia.v3.internal.zw.q);
        m(r10, com.google.ads.interactivemedia.v3.internal.zw.r);
        l(r10, com.google.ads.interactivemedia.v3.internal.zw.s);
        r68 = new com.google.ads.interactivemedia.v3.internal.ary();
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0793, code lost:
    
        if (r10.startsWith("#EXT-X-PART-INF") == false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0795, code lost:
    
        r3 = (long) (f(r10, com.google.ads.interactivemedia.v3.internal.zw.l) * 1000000.0d);
        r10 = r87;
        r64 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x07a9, code lost:
    
        if (r10.startsWith("#EXT-X-MAP") == false) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r5 = r5.trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x07ab, code lost:
    
        r34 = g(r10, com.google.ads.interactivemedia.v3.internal.zw.C, r15);
        r3 = h(r10, com.google.ads.interactivemedia.v3.internal.zw.y, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x07b7, code lost:
    
        if (r3 == null) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x07b9, code lost:
    
        r3 = r3.split("@");
        r35 = java.lang.Long.parseLong(r3[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x07c8, code lost:
    
        if (r3.length <= 1) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x07ca, code lost:
    
        r37 = r35;
        r35 = java.lang.Long.parseLong(r3[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x07d5, code lost:
    
        r37 = r35;
        r35 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x07da, code lost:
    
        r35 = r41;
        r37 = r50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x07de, code lost:
    
        if (r20 == null) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x07e0, code lost:
    
        if (r21 == null) goto L484;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r5.isEmpty() != false) goto L458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x07ea, code lost:
    
        throw new com.google.ads.interactivemedia.v3.internal.dt("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x07eb, code lost:
    
        r26 = new com.google.ads.interactivemedia.v3.internal.zs(r34, r35, r37, r20, r21);
        r10 = r87;
        r3 = r13;
        r50 = -1;
        r41 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0803, code lost:
    
        if (r10.startsWith(r1) == false) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0805, code lost:
    
        r62 = e(r10, com.google.ads.interactivemedia.v3.internal.zw.k) * 1000000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0811, code lost:
    
        r10 = r87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0819, code lost:
    
        if (r10.startsWith("#EXT-X-MEDIA-SEQUENCE") == false) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x081b, code lost:
    
        r43 = java.lang.Long.parseLong(g(r10, com.google.ads.interactivemedia.v3.internal.zw.t, java.util.Collections.emptyMap()));
        r10 = r87;
        r3 = r13;
        r59 = r43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0836, code lost:
    
        if (r10.startsWith("#EXT-X-VERSION") == false) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0838, code lost:
    
        r61 = e(r10, com.google.ads.interactivemedia.v3.internal.zw.m);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0845, code lost:
    
        if (r10.startsWith("#EXT-X-DEFINE") == false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0847, code lost:
    
        r3 = h(r10, com.google.ads.interactivemedia.v3.internal.zw.O, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x084d, code lost:
    
        if (r3 == null) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x084f, code lost:
    
        r4 = r5.h.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0857, code lost:
    
        if (r4 == null) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0859, code lost:
    
        r15.put(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        r10 = "#EXT";
        r11 = "identity";
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x085c, code lost:
    
        r4 = r86;
        r75 = r1;
        r80 = r6;
        r81 = r7;
        r82 = r8;
        r83 = r9;
        r18 = r25;
        r25 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x086d, code lost:
    
        r13 = r87;
        r87 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0875, code lost:
    
        r3 = g(r10, com.google.ads.interactivemedia.v3.internal.zw.G, r15);
        r4 = g(r10, com.google.ads.interactivemedia.v3.internal.zw.N, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0886, code lost:
    
        if (r10.startsWith("#EXTINF") == false) goto L488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0888, code lost:
    
        r3 = (long) (f(r10, com.google.ads.interactivemedia.v3.internal.zw.u) * 1000000.0d);
        i(r10, com.google.ads.interactivemedia.v3.internal.zw.v, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR, r15);
        r10 = r87;
        r3 = r13;
        r71 = r3;
        r13 = r73;
        r4 = r74;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x08a9, code lost:
    
        r75 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x08af, code lost:
    
        if (r10.startsWith(r9) == false) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x08b1, code lost:
    
        r1 = g(r10, com.google.ads.interactivemedia.v3.internal.zw.z, r15);
        r4 = r25;
        r3 = i(r10, com.google.ads.interactivemedia.v3.internal.zw.A, r4, r15);
        r25 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x08c7, code lost:
    
        if ("NONE".equals(r1) == false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        if (r5.startsWith(r2) == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x08c9, code lost:
    
        r14.clear();
        r20 = null;
        r21 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x08d0, code lost:
    
        r24 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x08d4, code lost:
    
        r5 = h(r10, com.google.ads.interactivemedia.v3.internal.zw.D, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x08de, code lost:
    
        if (r4.equals(r3) == false) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x08e6, code lost:
    
        if ("AES-128".equals(r1) == false) goto L337;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x08e8, code lost:
    
        r20 = g(r10, com.google.ads.interactivemedia.v3.internal.zw.C, r15);
        r21 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x08f4, code lost:
    
        r21 = r5;
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x08f9, code lost:
    
        if (r2 != null) goto L340;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x08fb, code lost:
    
        r2 = d(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        r4.add(r5);
        r1 = new com.google.ads.interactivemedia.v3.internal.zv(r4, r3);
        r15 = r86.toString();
        r4 = new java.util.HashMap();
        r5 = new java.util.HashMap();
        r8 = new java.util.ArrayList();
        r14 = new java.util.ArrayList();
        r9 = new java.util.ArrayList();
        r12 = new java.util.ArrayList();
        r21 = new java.util.ArrayList();
        r13 = new java.util.ArrayList();
        r7 = new java.util.ArrayList();
        r6 = new java.util.ArrayList();
        r20 = false;
        r24 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x08ff, code lost:
    
        r1 = c(r10, r3, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0903, code lost:
    
        if (r1 == null) goto L337;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0905, code lost:
    
        r14.put(r3, r1);
        r21 = r5;
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x090d, code lost:
    
        r4 = r25;
        r25 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0915, code lost:
    
        if (r10.startsWith(r8) == false) goto L348;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0917, code lost:
    
        r1 = g(r10, com.google.ads.interactivemedia.v3.internal.zw.x, r15).split("@");
        r50 = java.lang.Long.parseLong(r1[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x092c, code lost:
    
        if (r1.length <= 1) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x092e, code lost:
    
        r41 = java.lang.Long.parseLong(r1[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0939, code lost:
    
        if (r10.startsWith(r6) == false) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x093b, code lost:
    
        r58 = java.lang.Integer.parseInt(r10.substring(r10.indexOf(58) + 1));
        r10 = r87;
        r3 = r13;
        r5 = r25;
        r13 = r73;
        r1 = r75;
        r57 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x095b, code lost:
    
        if (r10.equals(r7) == false) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x095d, code lost:
    
        r27 = r27 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x095f, code lost:
    
        r10 = r87;
        r3 = r13;
        r5 = r25;
        r13 = r73;
        r1 = r75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0968, code lost:
    
        r25 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0972, code lost:
    
        if (r10.startsWith("#EXT-X-PROGRAM-DATE-TIME") == false) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0976, code lost:
    
        if (r55 != 0) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
    
        r23 = -1;
        r27 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0978, code lost:
    
        r55 = com.google.ads.interactivemedia.v3.internal.bi.b(com.google.ads.interactivemedia.v3.internal.aeu.M(r10.substring(r10.indexOf(58) + 1))) - r69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x098f, code lost:
    
        r18 = r4;
        r80 = r6;
        r81 = r7;
        r82 = r8;
        r83 = r9;
        r4 = r86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x09a5, code lost:
    
        if (r10.equals("#EXT-X-GAP") == false) goto L365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x09a7, code lost:
    
        r10 = r87;
        r3 = r13;
        r5 = r25;
        r13 = r73;
        r1 = r75;
        r48 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x09b9, code lost:
    
        if (r10.equals("#EXT-X-INDEPENDENT-SEGMENTS") == false) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x09bb, code lost:
    
        r10 = r87;
        r3 = r13;
        r5 = r25;
        r13 = r73;
        r1 = r75;
        r66 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x09cc, code lost:
    
        if (r10.equals(r13) == false) goto L487;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
    
        if (r1.a() == false) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x09ce, code lost:
    
        r10 = r87;
        r3 = r13;
        r5 = r25;
        r13 = r73;
        r1 = r75;
        r67 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x09e0, code lost:
    
        if (r10.startsWith("#") != false) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x09e2, code lost:
    
        if (r20 != null) goto L375;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x09e4, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x09e6, code lost:
    
        if (r21 == null) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x09e8, code lost:
    
        r5 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x09eb, code lost:
    
        r5 = java.lang.Long.toHexString(r43);
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x09ef, code lost:
    
        r76 = r43 + 1;
        r10 = j(r10, r15);
        r19 = (com.google.ads.interactivemedia.v3.internal.zs) r87.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0a01, code lost:
    
        if (r50 != (-1)) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c5, code lost:
    
        r3 = r1.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0a03, code lost:
    
        r78 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0a06, code lost:
    
        if (r49 == false) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0a08, code lost:
    
        if (r26 != null) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0a0a, code lost:
    
        if (r19 != null) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0a0c, code lost:
    
        r3 = new com.google.ads.interactivemedia.v3.internal.zs(r10, 0, r41, null, null);
        r87.put(r10, r3);
        r19 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0a22, code lost:
    
        r78 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0a24, code lost:
    
        if (r24 != null) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x0a2a, code lost:
    
        if (r14.isEmpty() != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0a2c, code lost:
    
        r87 = r13;
        r18 = r4;
        r3 = (com.google.ads.interactivemedia.v3.internal.jb[]) r14.values().toArray(new com.google.ads.interactivemedia.v3.internal.jb[0]);
        r4 = new com.google.ads.interactivemedia.v3.internal.jc(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
    
        if (r3.startsWith(r10) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0a42, code lost:
    
        if (r46 != null) goto L396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0a44, code lost:
    
        r1 = new com.google.ads.interactivemedia.v3.internal.jb[r3.length];
        r24 = r4;
        r80 = r6;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0a4d, code lost:
    
        if (r4 >= r3.length) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0a4f, code lost:
    
        r6 = r3[r4];
        r1[r4] = new com.google.ads.interactivemedia.v3.internal.jb(r6.a, r6.b, r6.c, null);
        r4 = r4 + 1;
        r3 = r3;
        r7 = r7;
        r8 = r8;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0a72, code lost:
    
        r81 = r7;
        r82 = r8;
        r83 = r9;
        r3 = new com.google.ads.interactivemedia.v3.internal.jc(r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0a7f, code lost:
    
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0a81, code lost:
    
        r80 = r6;
        r81 = r7;
        r82 = r8;
        r83 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0a8b, code lost:
    
        r87 = r13;
        r18 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0a90, code lost:
    
        r3 = r46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        r6.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0a94, code lost:
    
        if (r26 == null) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0a96, code lost:
    
        r35 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0a99, code lost:
    
        r35 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0a9b, code lost:
    
        r4 = r86;
        r4.add(new com.google.ads.interactivemedia.v3.internal.zs(r10, r35, r71, r27, r69, r24, r20, r5, r78, r50, r48));
        r69 = r69 + r71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x0abb, code lost:
    
        if (r50 == (-1)) goto L407;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0abd, code lost:
    
        r78 = r78 + r50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0abf, code lost:
    
        r41 = r78;
        r46 = r3;
        r86 = r4;
        r10 = r87;
        r5 = r25;
        r50 = -1;
        r71 = 0;
        r13 = r73;
        r4 = r74;
        r1 = r75;
        r43 = r76;
        r6 = r80;
        r7 = r81;
        r8 = r82;
        r9 = r83;
        r48 = false;
        r3 = r87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0ae1, code lost:
    
        r13 = r87;
        r87 = r13;
        r18 = r4;
        r80 = r6;
        r81 = r7;
        r82 = r8;
        r83 = r9;
        r4 = r86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0af2, code lost:
    
        r3 = r87;
        r86 = r4;
        r10 = r13;
        r5 = r25;
        r13 = r73;
        r4 = r74;
        r1 = r75;
        r6 = r80;
        r7 = r81;
        r8 = r82;
        r9 = r83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
    
        r22 = r10;
        r10 = r3.startsWith("#EXT-X-I-FRAME-STREAM-INF");
        r86 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0b07, code lost:
    
        r25 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0b0b, code lost:
    
        r74 = r4;
        r4 = r86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0b13, code lost:
    
        if (r55 == 0) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0b15, code lost:
    
        r45 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x0b18, code lost:
    
        r45 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x0b1a, code lost:
    
        r1 = new com.google.ads.interactivemedia.v3.internal.zt(r52, r28, r74, r53, r55, r57, r58, r59, r61, r62, r64, r66, r67, r45, r46, r4, r68, null, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x0b41, code lost:
    
        com.google.ads.interactivemedia.v3.internal.aeu.r(r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0b44, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0b45, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0b46, code lost:
    
        r23 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
    
        if (r3.startsWith("#EXT-X-DEFINE") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0b49, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0b4a, code lost:
    
        r23 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0b4d, code lost:
    
        com.google.ads.interactivemedia.v3.internal.aeu.r(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0b59, code lost:
    
        throw new com.google.ads.interactivemedia.v3.internal.dt("Failed to parse the playlist, could not identify any tags.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
    
        r5.put(g(r3, com.google.ads.interactivemedia.v3.internal.zw.G, r5), g(r3, com.google.ads.interactivemedia.v3.internal.zw.N, r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x0b67, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f3, code lost:
    
        r25 = r11;
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ff, code lost:
    
        if (r3.equals("#EXT-X-INDEPENDENT-SEGMENTS") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0101, code lost:
    
        r42 = r1;
        r35 = r2;
        r1 = r4;
        r36 = r7;
        r37 = r9;
        r25 = r11;
        r38 = r12;
        r39 = r13;
        r26 = r14;
        r24 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011c, code lost:
    
        if (r3.startsWith("#EXT-X-MEDIA") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
    
        r13.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0128, code lost:
    
        if (r3.startsWith("#EXT-X-SESSION-KEY") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012a, code lost:
    
        r6 = c(r3, i(r3, com.google.ads.interactivemedia.v3.internal.zw.A, r11, r5), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0134, code lost:
    
        if (r6 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0136, code lost:
    
        r25 = r11;
        r26 = r14;
        r7.add(new com.google.ads.interactivemedia.v3.internal.jc(d(g(r3, com.google.ads.interactivemedia.v3.internal.zw.z, r5)), r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0153, code lost:
    
        r25 = r11;
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015b, code lost:
    
        if (r3.startsWith(r2) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015d, code lost:
    
        if (r10 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015f, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0161, code lost:
    
        r42 = r1;
        r35 = r2;
        r1 = r4;
        r36 = r7;
        r37 = r9;
        r38 = r12;
        r39 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0170, code lost:
    
        r6 = r20 | r3.contains("CLOSED-CAPTIONS=NONE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0179, code lost:
    
        if (true == r10) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x017b, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x017d, code lost:
    
        r11 = org.rbmain.messenger.LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017f, code lost:
    
        r14 = e(r3, com.google.ads.interactivemedia.v3.internal.zw.f);
        r35 = r2;
        r2 = com.google.ads.interactivemedia.v3.internal.zw.a.matcher(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0191, code lost:
    
        if (r2.find() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0193, code lost:
    
        r20 = r6;
        r2 = r2.group(1);
        com.google.ads.interactivemedia.v3.internal.ary.t(r2);
        r2 = java.lang.Integer.parseInt(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01a2, code lost:
    
        r20 = r6;
        r2 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01a5, code lost:
    
        r6 = h(r3, com.google.ads.interactivemedia.v3.internal.zw.h, r5);
        r36 = r7;
        r7 = h(r3, com.google.ads.interactivemedia.v3.internal.zw.i, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b3, code lost:
    
        if (r7 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b5, code lost:
    
        r37 = r9;
        r7 = r7.split("x");
        r9 = java.lang.Integer.parseInt(r7[0]);
        r7 = java.lang.Integer.parseInt(r7[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01cc, code lost:
    
        if (r9 <= 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01ce, code lost:
    
        if (r7 > 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d1, code lost:
    
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01d4, code lost:
    
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d5, code lost:
    
        r38 = r12;
        r7 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01da, code lost:
    
        r37 = r9;
        r38 = r12;
        r7 = -1;
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e0, code lost:
    
        r12 = h(r3, com.google.ads.interactivemedia.v3.internal.zw.j, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e6, code lost:
    
        if (r12 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e8, code lost:
    
        r12 = java.lang.Float.parseFloat(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ed, code lost:
    
        r12 = -1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ef, code lost:
    
        r39 = r13;
        r13 = h(r3, com.google.ads.interactivemedia.v3.internal.zw.b, r5);
        r40 = r4;
        r4 = h(r3, com.google.ads.interactivemedia.v3.internal.zw.c, r5);
        r4 = h(r3, com.google.ads.interactivemedia.v3.internal.zw.d, r5);
        r4 = h(r3, com.google.ads.interactivemedia.v3.internal.zw.e, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x020f, code lost:
    
        if (r10 == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0211, code lost:
    
        r3 = g(r3, com.google.ads.interactivemedia.v3.internal.zw.C, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0217, code lost:
    
        r3 = com.google.ads.interactivemedia.v3.internal.atv.i(r15, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0220, code lost:
    
        if (r1.a() == false) goto L499;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0222, code lost:
    
        r3 = j(r1.b(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x022b, code lost:
    
        r10 = new com.google.ads.interactivemedia.v3.internal.cx();
        r42 = r1;
        r10.R(r8.size());
        r10.K("application/x-mpegURL");
        r10.I(r6);
        r10.G(r2);
        r10.Z(r14);
        r10.aj(r9);
        r10.Q(r7);
        r10.P(r12);
        r10.ac(r11);
        r8.add(new com.google.ads.interactivemedia.v3.internal.zq(r3, r10.a(), r13, r4, r4, r4));
        r1 = r40;
        r6 = (java.util.ArrayList) r1.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0273, code lost:
    
        if (r6 != null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0275, code lost:
    
        r6 = new java.util.ArrayList();
        r1.put(r3, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x027d, code lost:
    
        r6.add(new com.google.ads.interactivemedia.v3.internal.zf(r2, r14, r13, r4, r4, r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0293, code lost:
    
        r6 = r86;
        r4 = r1;
        r10 = r22;
        r11 = r25;
        r14 = r26;
        r3 = r27;
        r2 = r35;
        r7 = r36;
        r9 = r37;
        r12 = r38;
        r13 = r39;
        r1 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02b3, code lost:
    
        throw new com.google.ads.interactivemedia.v3.internal.dt("#EXT-X-STREAM-INF must be followed by another line");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02b4, code lost:
    
        r1 = r4;
        r86 = r6;
        r36 = r7;
        r37 = r9;
        r38 = r12;
        r39 = r13;
        r26 = r14;
        r2 = new java.util.ArrayList();
        r3 = new java.util.HashSet();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02d0, code lost:
    
        if (r4 >= r8.size()) goto L503;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02d2, code lost:
    
        r6 = (com.google.ads.interactivemedia.v3.internal.zq) r8.get(r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046 A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #4 {all -> 0x0036, blocks: (B:6:0x001d, B:8:0x0025, B:10:0x002d, B:20:0x0046, B:22:0x004e, B:33:0x0079, B:34:0x00bb), top: B:440:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0055 A[EDGE_INSN: B:444:0x0055->B:24:0x0055 BREAK  A[LOOP:0: B:18:0x0043->B:23:0x0052], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    @Override // com.google.ads.interactivemedia.v3.internal.adc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* bridge */ /* synthetic */ com.google.ads.interactivemedia.v3.internal.zu a(android.net.Uri r86, java.io.InputStream r87) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zw.a(android.net.Uri, java.io.InputStream):java.lang.Object");
    }
}
