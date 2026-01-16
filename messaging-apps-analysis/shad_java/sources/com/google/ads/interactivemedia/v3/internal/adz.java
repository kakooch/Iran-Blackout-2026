package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.messenger.MediaController;
import org.webrtc.MediaStreamTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class adz {
    private static final ArrayList<adx> a = new ArrayList<>();
    private static final Pattern b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean a(String str) {
        return MediaStreamTrack.AUDIO_TRACK_KIND.equals(n(str));
    }

    public static boolean b(String str) {
        return MediaStreamTrack.VIDEO_TRACK_KIND.equals(n(str));
    }

    public static boolean c(String str) {
        return "text".equals(n(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : aeu.U(str)) {
            String strH = h(str2);
            if (strH != null && b(strH)) {
                return strH;
            }
        }
        return null;
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : aeu.U(str)) {
            String strH = h(str2);
            if (strH != null && a(strH)) {
                return strH;
            }
        }
        return null;
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : aeu.U(str)) {
            String strH = h(str2);
            if (strH != null && c(strH)) {
                return strH;
            }
        }
        return null;
    }

    public static String h(String str) {
        ady adyVarM;
        String strI = null;
        if (str == null) {
            return null;
        }
        String strC = aeu.C(str.trim());
        if (strC.startsWith("avc1") || strC.startsWith("avc3")) {
            return MediaController.VIDEO_MIME_TYPE;
        }
        if (strC.startsWith("hev1") || strC.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (strC.startsWith("dvav") || strC.startsWith("dva1") || strC.startsWith("dvhe") || strC.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (strC.startsWith("av01")) {
            return "video/av01";
        }
        if (strC.startsWith("vp9") || strC.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (strC.startsWith("vp8") || strC.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (strC.startsWith("mp4a")) {
            if (strC.startsWith("mp4a.") && (adyVarM = m(strC)) != null) {
                strI = i(adyVarM.a);
            }
            return strI == null ? MediaController.AUIDO_MIME_TYPE : strI;
        }
        if (strC.startsWith("ac-3") || strC.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (strC.startsWith("ec-3") || strC.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (strC.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (strC.startsWith("ac-4") || strC.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (strC.startsWith("dtsc") || strC.startsWith("dtse")) {
            return "audio/vnd.dts";
        }
        if (strC.startsWith("dtsh") || strC.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (strC.startsWith("opus")) {
            return "audio/opus";
        }
        if (strC.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (strC.startsWith("flac")) {
            return "audio/flac";
        }
        if (strC.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (strC.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (strC.contains("cea708")) {
            return "application/cea-708";
        }
        if (strC.contains("eia608") || strC.contains("cea608")) {
            return "application/cea-608";
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str2 = a.get(i).b;
            if (strC.startsWith(null)) {
                break;
            }
        }
        return null;
    }

    public static String i(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return MediaController.VIDEO_MIME_TYPE;
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return MediaController.AUIDO_MIME_TYPE;
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return MediaController.AUIDO_MIME_TYPE;
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static int j(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if (c(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String str2 = a.get(i).a;
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String k(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1007807498(0xffffffffc3ee13f6, float:-476.15594)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = -586683234(0xffffffffdd07ec9e, float:-6.1214856E17)
            if (r0 == r1) goto L20
            r1 = 187090231(0xb26c537, float:3.2118805E-32)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "audio/mp3"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L34
            r0 = 1
            goto L35
        L20:
            java.lang.String r0 = "audio/x-wav"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L34
            r0 = 2
            goto L35
        L2a:
            java.lang.String r0 = "audio/x-flac"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L34
            r0 = 0
            goto L35
        L34:
            r0 = -1
        L35:
            if (r0 == 0) goto L42
            if (r0 == r3) goto L3f
            if (r0 == r2) goto L3c
            return r4
        L3c:
            java.lang.String r4 = "audio/wav"
            return r4
        L3f:
            java.lang.String r4 = "audio/mpeg"
            return r4
        L42:
            java.lang.String r4 = "audio/flac"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adz.k(java.lang.String):java.lang.String");
    }

    public static boolean l(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    static ady m(String str) {
        Matcher matcher = b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        ary.t(strGroup);
        String strGroup2 = matcher.group(2);
        try {
            return new ady(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String n(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            int r1 = r3.hashCode()
            r2 = 1
            switch(r1) {
                case -2123537834: goto L75;
                case -432837260: goto L6b;
                case -432837259: goto L61;
                case -53558318: goto L56;
                case 187078296: goto L4c;
                case 187094639: goto L42;
                case 1504578661: goto L37;
                case 1504619009: goto L2d;
                case 1504831518: goto L23;
                case 1903231877: goto L19;
                case 1903589369: goto Le;
                default: goto Lc;
            }
        Lc:
            goto L80
        Le:
            java.lang.String r1 = "audio/g711-mlaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 5
            goto L81
        L19:
            java.lang.String r1 = "audio/g711-alaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 4
            goto L81
        L23:
            java.lang.String r1 = "audio/mpeg"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 0
            goto L81
        L2d:
            java.lang.String r1 = "audio/flac"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 6
            goto L81
        L37:
            java.lang.String r1 = "audio/eac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 8
            goto L81
        L42:
            java.lang.String r1 = "audio/raw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 3
            goto L81
        L4c:
            java.lang.String r1 = "audio/ac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 7
            goto L81
        L56:
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 10
            goto L81
        L61:
            java.lang.String r1 = "audio/mpeg-L2"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 2
            goto L81
        L6b:
            java.lang.String r1 = "audio/mpeg-L1"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 1
            goto L81
        L75:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L80
            r3 = 9
            goto L81
        L80:
            r3 = -1
        L81:
            switch(r3) {
                case 0: goto L9d;
                case 1: goto L9d;
                case 2: goto L9d;
                case 3: goto L9d;
                case 4: goto L9d;
                case 5: goto L9d;
                case 6: goto L9d;
                case 7: goto L9d;
                case 8: goto L9d;
                case 9: goto L9d;
                case 10: goto L85;
                default: goto L84;
            }
        L84:
            return r0
        L85:
            if (r4 != 0) goto L88
            return r0
        L88:
            com.google.ads.interactivemedia.v3.internal.ady r3 = m(r4)
            if (r3 != 0) goto L8f
            return r0
        L8f:
            int r3 = r3.b
            int r3 = com.google.ads.interactivemedia.v3.internal.gn.c(r3)
            if (r3 == 0) goto L9c
            r4 = 16
            if (r3 == r4) goto L9c
            return r2
        L9c:
            return r0
        L9d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adz.d(java.lang.String, java.lang.String):boolean");
    }
}
