package com.pedro.encoder.video;

/* loaded from: classes3.dex */
public enum FormatVideoEncoder {
    YUV420FLEXIBLE,
    YUV420PLANAR,
    YUV420SEMIPLANAR,
    YUV420PACKEDPLANAR,
    YUV420PACKEDSEMIPLANAR,
    YUV422FLEXIBLE,
    YUV422PLANAR,
    YUV422SEMIPLANAR,
    YUV422PACKEDPLANAR,
    YUV422PACKEDSEMIPLANAR,
    YUV444FLEXIBLE,
    YUV444INTERLEAVED,
    SURFACE,
    YUV420Dynamical;

    /* renamed from: com.pedro.encoder.video.FormatVideoEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder;

        static {
            int[] iArr = new int[FormatVideoEncoder.values().length];
            $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder = iArr;
            try {
                iArr[FormatVideoEncoder.YUV420FLEXIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV420PLANAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV420SEMIPLANAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV420PACKEDPLANAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV420PACKEDSEMIPLANAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV422FLEXIBLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV422PLANAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV422SEMIPLANAR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV422PACKEDPLANAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV422PACKEDSEMIPLANAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV444FLEXIBLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.YUV444INTERLEAVED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[FormatVideoEncoder.SURFACE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public int getFormatCodec() {
        switch (AnonymousClass1.$SwitchMap$com$pedro$encoder$video$FormatVideoEncoder[ordinal()]) {
            case 1:
                return 2135033992;
            case 2:
                return 19;
            case 3:
                return 21;
            case 4:
                return 20;
            case 5:
                return 39;
            case 6:
                return 2135042184;
            case 7:
                return 22;
            case 8:
                return 24;
            case 9:
                return 23;
            case 10:
                return 40;
            case 11:
                return 2135181448;
            case 12:
                return 29;
            case 13:
                return 2130708361;
            default:
                return -1;
        }
    }
}
