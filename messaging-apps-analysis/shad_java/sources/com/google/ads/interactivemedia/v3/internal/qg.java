package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class qg {
    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    private final boolean g;

    private qg(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        ary.t(str);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        boolean z3 = true;
        this.e = !z && codecCapabilities != null && aeu.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
        if (codecCapabilities != null && aeu.a >= 21) {
            codecCapabilities.isFeatureSupported("tunneled-playback");
        }
        if (!z2 && (codecCapabilities == null || aeu.a < 21 || !codecCapabilities.isFeatureSupported("secure-playback"))) {
            z3 = false;
        }
        this.f = z3;
        this.g = adz.b(str2);
    }

    public static qg a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new qg(str, str2, str3, codecCapabilities, z4, z5);
    }

    private final void h(String str) {
        String str2 = this.a;
        String str3 = this.b;
        String str4 = aeu.e;
        int length = String.valueOf(str).length();
        int length2 = str2.length();
        StringBuilder sb = new StringBuilder(length + 20 + length2 + str3.length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    private static boolean i(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointJ = j(videoCapabilities, i, i2);
        int i3 = pointJ.x;
        int i4 = pointJ.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    private static Point j(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(aeu.F(i, widthAlignment) * widthAlignment, aeu.F(i2, heightAlignment) * heightAlignment);
    }

    public final MediaCodecInfo.CodecProfileLevel[] b() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public final boolean c(cy cyVar) throws qq {
        int i;
        String strH;
        String str = cyVar.i;
        if (str != null && (strH = adz.h(str)) != null) {
            if (this.b.equals(strH)) {
                Pair<Integer, Integer> pairE = qv.e(cyVar);
                if (pairE != null) {
                    int iIntValue = ((Integer) pairE.first).intValue();
                    int iIntValue2 = ((Integer) pairE.second).intValue();
                    if (!this.g) {
                        if (iIntValue == 42) {
                            iIntValue = 42;
                        }
                    }
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : b()) {
                        if (codecProfileLevel.profile != iIntValue || codecProfileLevel.level < iIntValue2) {
                        }
                    }
                    String str2 = cyVar.i;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 22 + strH.length());
                    sb.append("codec.profileLevel, ");
                    sb.append(str2);
                    sb.append(", ");
                    sb.append(strH);
                    h(sb.toString());
                }
            } else {
                String str3 = cyVar.i;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 13 + strH.length());
                sb2.append("codec.mime ");
                sb2.append(str3);
                sb2.append(", ");
                sb2.append(strH);
                h(sb2.toString());
            }
            return false;
        }
        if (this.g) {
            int i2 = cyVar.q;
            if (i2 <= 0 || (i = cyVar.r) <= 0) {
                return true;
            }
            if (aeu.a >= 21) {
                return f(i2, i, cyVar.s);
            }
            boolean z = i2 * i <= qv.d();
            if (!z) {
                int i3 = cyVar.q;
                int i4 = cyVar.r;
                StringBuilder sb3 = new StringBuilder(40);
                sb3.append("legacyFrameSize, ");
                sb3.append(i3);
                sb3.append("x");
                sb3.append(i4);
                h(sb3.toString());
            }
            return z;
        }
        int i5 = aeu.a;
        if (i5 >= 21) {
            int i6 = cyVar.z;
            if (i6 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
                if (codecCapabilities == null) {
                    h("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    h("sampleRate.aCaps");
                    return false;
                }
                if (!audioCapabilities.isSampleRateSupported(i6)) {
                    StringBuilder sb4 = new StringBuilder(31);
                    sb4.append("sampleRate.support, ");
                    sb4.append(i6);
                    h(sb4.toString());
                    return false;
                }
            }
            int i7 = cyVar.y;
            if (i7 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.d;
                if (codecCapabilities2 == null) {
                    h("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        h("channelCount.aCaps");
                    } else {
                        String str4 = this.a;
                        String str5 = this.b;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i5 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str5) && !"audio/3gpp".equals(str5) && !"audio/amr-wb".equals(str5) && !MediaController.AUIDO_MIME_TYPE.equals(str5) && !"audio/vorbis".equals(str5) && !"audio/opus".equals(str5) && !"audio/raw".equals(str5) && !"audio/flac".equals(str5) && !"audio/g711-alaw".equals(str5) && !"audio/g711-mlaw".equals(str5) && !"audio/gsm".equals(str5))) {
                            int i8 = "audio/ac3".equals(str5) ? 6 : "audio/eac3".equals(str5) ? 16 : 30;
                            StringBuilder sb5 = new StringBuilder(str4.length() + 59);
                            sb5.append("AssumedMaxChannelAdjustment: ");
                            sb5.append(str4);
                            sb5.append(", [");
                            sb5.append(maxInputChannelCount);
                            sb5.append(" to ");
                            sb5.append(i8);
                            sb5.append("]");
                            Log.w("MediaCodecInfo", sb5.toString());
                            maxInputChannelCount = i8;
                        }
                        if (maxInputChannelCount < i7) {
                            StringBuilder sb6 = new StringBuilder(33);
                            sb6.append("channelCount.support, ");
                            sb6.append(i7);
                            h(sb6.toString());
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean d(cy cyVar) {
        if (this.g) {
            return this.e;
        }
        Pair<Integer, Integer> pairE = qv.e(cyVar);
        return pairE != null && ((Integer) pairE.first).intValue() == 42;
    }

    public final boolean e(cy cyVar, cy cyVar2, boolean z) {
        if (this.g) {
            String str = cyVar.l;
            ary.t(str);
            return str.equals(cyVar2.l) && cyVar.t == cyVar2.t && (this.e || (cyVar.q == cyVar2.q && cyVar.r == cyVar2.r)) && ((!z && cyVar2.x == null) || aeu.c(cyVar.x, cyVar2.x));
        }
        if (MediaController.AUIDO_MIME_TYPE.equals(this.b)) {
            String str2 = cyVar.l;
            ary.t(str2);
            if (str2.equals(cyVar2.l) && cyVar.y == cyVar2.y && cyVar.z == cyVar2.z) {
                Pair<Integer, Integer> pairE = qv.e(cyVar);
                Pair<Integer, Integer> pairE2 = qv.e(cyVar2);
                if (pairE != null && pairE2 != null) {
                    int iIntValue = ((Integer) pairE.first).intValue();
                    int iIntValue2 = ((Integer) pairE2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean f(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            h("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            h("sizeAndRate.vCaps");
            return false;
        }
        if (i(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i >= i2 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.a) && "mcv5a".equals(aeu.b)) || !i(videoCapabilities, i2, i, d))) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("sizeAndRate.support, ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("x");
            sb.append(d);
            h(sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("sizeAndRate.rotated, ");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("x");
        sb2.append(d);
        String string = sb2.toString();
        String str = this.a;
        String str2 = this.b;
        String str3 = aeu.e;
        int length = String.valueOf(string).length();
        int length2 = str.length();
        StringBuilder sb3 = new StringBuilder(length + 25 + length2 + str2.length() + String.valueOf(str3).length());
        sb3.append("AssumedSupport [");
        sb3.append(string);
        sb3.append("] [");
        sb3.append(str);
        sb3.append(", ");
        sb3.append(str2);
        sb3.append("] [");
        sb3.append(str3);
        sb3.append("]");
        Log.d("MediaCodecInfo", sb3.toString());
        return true;
    }

    public final Point g(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return j(videoCapabilities, i, i2);
    }

    public final String toString() {
        return this.a;
    }
}
