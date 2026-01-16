package com.google.android.exoplayer2.mediacodec;

import android.gov.nist.core.Separators;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC23195wW3;
import ir.nasim.AbstractC24375yW3;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC24969zW3;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.MB1;
import java.util.List;

/* loaded from: classes2.dex */
public final class k {
    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    private final boolean k;

    private static final class a {
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
            List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            AbstractC24969zW3.a();
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePointA = AbstractC24375yW3.a(i, i2, (int) d);
            for (int i3 = 0; i3 < supportedPerformancePoints.size(); i3++) {
                if (AbstractC23195wW3.a(supportedPerformancePoints.get(i3)).covers(performancePointA)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    k(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = (String) AbstractC20011rK.e(str);
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.e = z4;
        this.f = z5;
        this.g = z6;
        this.k = AbstractC24462yf4.r(str2);
    }

    private static boolean A(String str) {
        if (AbstractC9683aN7.a <= 22) {
            String str2 = AbstractC9683aN7.d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    private static boolean B(String str, int i) {
        if ("video/hevc".equals(str) && 2 == i) {
            String str2 = AbstractC9683aN7.b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean C(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(AbstractC9683aN7.b)) ? false : true;
    }

    public static k D(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new k(str, str2, str3, codecCapabilities, z, z2, z3, (z4 || codecCapabilities == null || !h(codecCapabilities) || A(str)) ? false : true, codecCapabilities != null && t(codecCapabilities), z5 || (codecCapabilities != null && r(codecCapabilities)));
    }

    private static int a(String str, String str2, int i) {
        if (i > 1 || ((AbstractC9683aN7.a >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        AbstractC18815pI3.k("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    private static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(AbstractC9683aN7.l(i, widthAlignment) * widthAlignment, AbstractC9683aN7.l(i2, heightAlignment) * heightAlignment);
    }

    private static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointC = c(videoCapabilities, i, i2);
        int i3 = pointC.x;
        int i4 = pointC.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    private static MediaCodecInfo.CodecProfileLevel[] f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        int i = iIntValue >= 180000000 ? 1024 : iIntValue >= 120000000 ? 512 : iIntValue >= 60000000 ? 256 : iIntValue >= 30000000 ? 128 : iIntValue >= 18000000 ? 64 : iIntValue >= 12000000 ? 32 : iIntValue >= 7200000 ? 16 : iIntValue >= 3600000 ? 8 : iIntValue >= 1800000 ? 4 : iIntValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    private static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return AbstractC9683aN7.a >= 19 && i(codecCapabilities);
    }

    private static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean l(X x, boolean z) {
        Pair pairQ = MediaCodecUtil.q(x);
        if (pairQ == null) {
            return true;
        }
        int iIntValue = ((Integer) pairQ.first).intValue();
        int iIntValue2 = ((Integer) pairQ.second).intValue();
        if ("video/dolby-vision".equals(x.l)) {
            if (!"video/avc".equals(this.b)) {
                iIntValue = "video/hevc".equals(this.b) ? 2 : 8;
            }
            iIntValue2 = 0;
        }
        if (!this.k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrG = g();
        if (AbstractC9683aN7.a <= 23 && "video/x-vnd.on2.vp9".equals(this.b) && codecProfileLevelArrG.length == 0) {
            codecProfileLevelArrG = f(this.d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrG) {
            if (codecProfileLevel.profile == iIntValue && ((codecProfileLevel.level >= iIntValue2 || !z) && !B(this.b, iIntValue))) {
                return true;
            }
        }
        x("codec.profileLevel, " + x.i + ", " + this.c);
        return false;
    }

    private boolean p(X x) {
        return this.b.equals(x.l) || this.b.equals(MediaCodecUtil.m(x));
    }

    private static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return AbstractC9683aN7.a >= 21 && s(codecCapabilities);
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return AbstractC9683aN7.a >= 21 && u(codecCapabilities);
    }

    private static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void w(String str) {
        AbstractC18815pI3.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.a + ", " + this.b + "] [" + AbstractC9683aN7.e + "]");
    }

    private void x(String str) {
        AbstractC18815pI3.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.a + ", " + this.b + "] [" + AbstractC9683aN7.e + "]");
    }

    private static boolean y(String str) {
        return "audio/opus".equals(str);
    }

    private static boolean z(String str) {
        return AbstractC9683aN7.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public Point b(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i, i2);
    }

    public MB1 e(X x, X x2) {
        int i = !AbstractC9683aN7.c(x.l, x2.l) ? 8 : 0;
        if (this.k) {
            if (x.t != x2.t) {
                i |= 1024;
            }
            if (!this.e && (x.q != x2.q || x.r != x2.r)) {
                i |= 512;
            }
            if (!AbstractC9683aN7.c(x.x, x2.x)) {
                i |= 2048;
            }
            if (z(this.a) && !x.h(x2)) {
                i |= 2;
            }
            if (i == 0) {
                return new MB1(this.a, x, x2, x.h(x2) ? 3 : 2, 0);
            }
        } else {
            if (x.y != x2.y) {
                i |= 4096;
            }
            if (x.z != x2.z) {
                i |= 8192;
            }
            if (x.A != x2.A) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.b)) {
                Pair pairQ = MediaCodecUtil.q(x);
                Pair pairQ2 = MediaCodecUtil.q(x2);
                if (pairQ != null && pairQ2 != null) {
                    int iIntValue = ((Integer) pairQ.first).intValue();
                    int iIntValue2 = ((Integer) pairQ2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new MB1(this.a, x, x2, 3, 0);
                    }
                }
            }
            if (!x.h(x2)) {
                i |= 32;
            }
            if (y(this.b)) {
                i |= 2;
            }
            if (i == 0) {
                return new MB1(this.a, x, x2, 1, 0);
            }
        }
        return new MB1(this.a, x, x2, 0, i);
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean j(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            x("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            x("channelCount.aCaps");
            return false;
        }
        if (a(this.a, this.b, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        }
        x("channelCount.support, " + i);
        return false;
    }

    public boolean k(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            x("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            x("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        x("sampleRate.support, " + i);
        return false;
    }

    public boolean m(X x) {
        return p(x) && l(x, false);
    }

    public boolean n(X x) {
        int i;
        if (!p(x) || !l(x, true)) {
            return false;
        }
        if (!this.k) {
            if (AbstractC9683aN7.a >= 21) {
                int i2 = x.z;
                if (i2 != -1 && !k(i2)) {
                    return false;
                }
                int i3 = x.y;
                if (i3 != -1 && !j(i3)) {
                    return false;
                }
            }
            return true;
        }
        int i4 = x.q;
        if (i4 <= 0 || (i = x.r) <= 0) {
            return true;
        }
        if (AbstractC9683aN7.a >= 21) {
            return v(i4, i, x.s);
        }
        boolean z = i4 * i <= MediaCodecUtil.N();
        if (!z) {
            x("legacyFrameSize, " + x.q + "x" + x.r);
        }
        return z;
    }

    public boolean o() {
        if (AbstractC9683aN7.a >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean q(X x) {
        if (this.k) {
            return this.e;
        }
        Pair pairQ = MediaCodecUtil.q(x);
        return pairQ != null && ((Integer) pairQ.first).intValue() == 42;
    }

    public String toString() {
        return this.a;
    }

    public boolean v(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            x("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            x("sizeAndRate.vCaps");
            return false;
        }
        if (AbstractC9683aN7.a >= 29) {
            int iA = a.a(videoCapabilities, i, i2, d);
            if (iA == 2) {
                return true;
            }
            if (iA == 1) {
                x("sizeAndRate.cover, " + i + "x" + i2 + Separators.AT + d);
                return false;
            }
        }
        if (!d(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !C(this.a) || !d(videoCapabilities, i2, i, d)) {
                x("sizeAndRate.support, " + i + "x" + i2 + Separators.AT + d);
                return false;
            }
            w("sizeAndRate.rotated, " + i + "x" + i2 + Separators.AT + d);
        }
        return true;
    }
}
