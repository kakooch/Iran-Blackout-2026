package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import ir.eitaa.messenger.R;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public final class DtsUtil {
    private static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, R.styleable.AppCompatTheme_windowActionBarOverlay, 128, 192, 224, Factory.DEVICE_HAS_CRAPPY_OPENSLES, 384, 448, Factory.DEVICE_USE_ANDROID_CAMCORDER, 640, 768, 896, Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV, 1152, 1280, 1536, 1920, Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, Factory.DEVICE_HAS_CRAPPY_AAUDIO, 6144, 7680};

    public static boolean isSyncWord(int word) {
        return word == 2147385345 || word == -25230976 || word == 536864768 || word == -14745368;
    }

    public static Format parseDtsFormat(byte[] frame, String trackId, String language, DrmInitData drmInitData) {
        ParsableBitArray normalizedFrameHeader = getNormalizedFrameHeader(frame);
        normalizedFrameHeader.skipBits(60);
        int i = CHANNELS_BY_AMODE[normalizedFrameHeader.readBits(6)];
        int i2 = SAMPLE_RATE_BY_SFREQ[normalizedFrameHeader.readBits(4)];
        int bits = normalizedFrameHeader.readBits(5);
        int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
        int i3 = bits >= iArr.length ? -1 : (iArr[bits] * 1000) / 2;
        normalizedFrameHeader.skipBits(10);
        return Format.createAudioSampleFormat(trackId, "audio/vnd.dts", null, i3, -1, i + (normalizedFrameHeader.readBits(2) > 0 ? 1 : 0), i2, null, drmInitData, 0, language);
    }

    public static int parseDtsAudioSampleCount(byte[] data) {
        int i;
        byte b;
        int i2;
        byte b2;
        byte b3 = data[0];
        if (b3 != -2) {
            if (b3 == -1) {
                i = (data[4] & 7) << 4;
                b2 = data[7];
            } else if (b3 == 31) {
                i = (data[5] & 7) << 4;
                b2 = data[6];
            } else {
                i = (data[4] & 1) << 6;
                b = data[5];
            }
            i2 = b2 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (data[5] & 1) << 6;
        b = data[4];
        i2 = b & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static int parseDtsAudioSampleCount(ByteBuffer buffer) {
        int i;
        byte b;
        int i2;
        byte b2;
        int iPosition = buffer.position();
        byte b3 = buffer.get(iPosition);
        if (b3 != -2) {
            if (b3 == -1) {
                i = (buffer.get(iPosition + 4) & 7) << 4;
                b2 = buffer.get(iPosition + 7);
            } else if (b3 == 31) {
                i = (buffer.get(iPosition + 5) & 7) << 4;
                b2 = buffer.get(iPosition + 6);
            } else {
                i = (buffer.get(iPosition + 4) & 1) << 6;
                b = buffer.get(iPosition + 5);
            }
            i2 = b2 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (buffer.get(iPosition + 5) & 1) << 6;
        b = buffer.get(iPosition + 4);
        i2 = b & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getDtsFrameSize(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4a
            r2 = -1
            if (r1 == r2) goto L32
            r2 = 31
            if (r1 == r2) goto L21
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L58
        L21:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
            goto L42
        L32:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
        L42:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L5d
        L4a:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L58:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
        L5d:
            if (r0 == 0) goto L63
            int r7 = r7 * 16
            int r7 = r7 / 14
        L63:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DtsUtil.getDtsFrameSize(byte[]):int");
    }

    private static ParsableBitArray getNormalizedFrameHeader(byte[] frameHeader) {
        if (frameHeader[0] == 127) {
            return new ParsableBitArray(frameHeader);
        }
        byte[] bArrCopyOf = Arrays.copyOf(frameHeader, frameHeader.length);
        if (isLittleEndianFrameHeader(bArrCopyOf)) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b = bArrCopyOf[i];
                int i2 = i + 1;
                bArrCopyOf[i] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(bArrCopyOf);
            while (parsableBitArray2.bitsLeft() >= 16) {
                parsableBitArray2.skipBits(2);
                parsableBitArray.putInt(parsableBitArray2.readBits(14), 14);
            }
        }
        parsableBitArray.reset(bArrCopyOf);
        return parsableBitArray;
    }

    private static boolean isLittleEndianFrameHeader(byte[] frameHeader) {
        return frameHeader[0] == -2 || frameHeader[0] == -1;
    }
}
