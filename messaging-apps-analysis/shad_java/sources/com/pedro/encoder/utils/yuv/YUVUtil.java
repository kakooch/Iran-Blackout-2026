package com.pedro.encoder.utils.yuv;

import com.pedro.encoder.video.FormatVideoEncoder;

/* loaded from: classes3.dex */
public class YUVUtil {
    public static void preAllocateBuffers(int i) {
        NV21Utils.preAllocateBuffers(i);
        YV12Utils.preAllocateBuffers(i);
    }

    /* renamed from: com.pedro.encoder.utils.yuv.YUVUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder;

        static {
            int[] iArr = new int[FormatVideoEncoder.values().length];
            $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder = iArr;
            try {
                iArr[FormatVideoEncoder.YUV420PLANAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV420SEMIPLANAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static byte[] NV21toYUV420byColor(byte[] bArr, int i, int i2, FormatVideoEncoder formatVideoEncoder) {
        int i3 = AnonymousClass1.$SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[formatVideoEncoder.ordinal()];
        if (i3 == 1) {
            return NV21Utils.toI420(bArr, i, i2);
        }
        if (i3 != 2) {
            return null;
        }
        return NV21Utils.toNV12(bArr, i, i2);
    }

    public static byte[] rotateNV21(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (i3 == 90) {
            return NV21Utils.rotate90(bArr, i, i2);
        }
        if (i3 == 180) {
            return NV21Utils.rotate180(bArr, i, i2);
        }
        if (i3 != 270) {
            return null;
        }
        return NV21Utils.rotate270(bArr, i, i2);
    }

    public static byte[] YV12toYUV420byColor(byte[] bArr, int i, int i2, FormatVideoEncoder formatVideoEncoder) {
        int i3 = AnonymousClass1.$SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[formatVideoEncoder.ordinal()];
        if (i3 == 1) {
            return YV12Utils.toI420(bArr, i, i2);
        }
        if (i3 != 2) {
            return null;
        }
        return YV12Utils.toNV12(bArr, i, i2);
    }

    public static byte[] rotateYV12(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (i3 == 90) {
            return YV12Utils.rotate90(bArr, i, i2);
        }
        if (i3 == 180) {
            return YV12Utils.rotate180(bArr, i, i2);
        }
        if (i3 != 270) {
            return null;
        }
        return YV12Utils.rotate270(bArr, i, i2);
    }
}
