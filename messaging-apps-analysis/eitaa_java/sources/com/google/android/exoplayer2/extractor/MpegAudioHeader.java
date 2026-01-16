package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public final class MpegAudioHeader {
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;
    private static final String[] MIME_TYPE_BY_LAYER = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] SAMPLING_RATE_V1 = {44100, 48000, 32000};
    private static final int[] BITRATE_V1_L1 = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] BITRATE_V2_L1 = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] BITRATE_V1_L2 = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] BITRATE_V1_L3 = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] BITRATE_V2 = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    private static boolean isMagicPresent(int header) {
        return (header & (-2097152)) == -2097152;
    }

    public static int getFrameSize(int header) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (!isMagicPresent(header) || (i = (header >>> 19) & 3) == 1 || (i2 = (header >>> 17) & 3) == 0 || (i3 = (header >>> 12) & 15) == 0 || i3 == 15 || (i4 = (header >>> 10) & 3) == 3) {
            return -1;
        }
        int i6 = SAMPLING_RATE_V1[i4];
        if (i == 2) {
            i6 /= 2;
        } else if (i == 0) {
            i6 /= 4;
        }
        int i7 = (header >>> 9) & 1;
        if (i2 == 3) {
            return ((((i == 3 ? BITRATE_V1_L1[i3 - 1] : BITRATE_V2_L1[i3 - 1]) * 12) / i6) + i7) * 4;
        }
        if (i == 3) {
            i5 = i2 == 2 ? BITRATE_V1_L2[i3 - 1] : BITRATE_V1_L3[i3 - 1];
        } else {
            i5 = BITRATE_V2[i3 - 1];
        }
        if (i == 3) {
            return ((i5 * 144) / i6) + i7;
        }
        return (((i2 == 1 ? 72 : 144) * i5) / i6) + i7;
    }

    public static int getFrameSampleCount(int header) {
        int i;
        int i2;
        if (!isMagicPresent(header) || (i = (header >>> 19) & 3) == 1 || (i2 = (header >>> 17) & 3) == 0) {
            return -1;
        }
        int i3 = (header >>> 12) & 15;
        int i4 = (header >>> 10) & 3;
        if (i3 == 0 || i3 == 15 || i4 == 3) {
            return -1;
        }
        return getFrameSizeInSamples(i, i2);
    }

    public static boolean populateHeader(int headerData, MpegAudioHeader header) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (!isMagicPresent(headerData) || (i = (headerData >>> 19) & 3) == 1 || (i2 = (headerData >>> 17) & 3) == 0 || (i3 = (headerData >>> 12) & 15) == 0 || i3 == 15 || (i4 = (headerData >>> 10) & 3) == 3) {
            return false;
        }
        int i8 = SAMPLING_RATE_V1[i4];
        if (i == 2) {
            i8 /= 2;
        } else if (i == 0) {
            i8 /= 4;
        }
        int i9 = i8;
        int i10 = (headerData >>> 9) & 1;
        int frameSizeInSamples = getFrameSizeInSamples(i, i2);
        if (i2 == 3) {
            i5 = i == 3 ? BITRATE_V1_L1[i3 - 1] : BITRATE_V2_L1[i3 - 1];
            i7 = (((i5 * 12) / i9) + i10) * 4;
        } else {
            if (i == 3) {
                i5 = i2 == 2 ? BITRATE_V1_L2[i3 - 1] : BITRATE_V1_L3[i3 - 1];
                i6 = (i5 * 144) / i9;
            } else {
                i5 = BITRATE_V2[i3 - 1];
                i6 = ((i2 == 1 ? 72 : 144) * i5) / i9;
            }
            i7 = i6 + i10;
        }
        header.setValues(i, MIME_TYPE_BY_LAYER[3 - i2], i7, i9, ((headerData >> 6) & 3) == 3 ? 1 : 2, i5, frameSizeInSamples);
        return true;
    }

    private static int getFrameSizeInSamples(int version, int layer) {
        if (layer == 1) {
            return version == 3 ? 1152 : 576;
        }
        if (layer == 2) {
            return 1152;
        }
        if (layer == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    private void setValues(int version, String mimeType, int frameSize, int sampleRate, int channels, int bitrate, int samplesPerFrame) {
        this.version = version;
        this.mimeType = mimeType;
        this.frameSize = frameSize;
        this.sampleRate = sampleRate;
        this.channels = channels;
        this.bitrate = bitrate;
        this.samplesPerFrame = samplesPerFrame;
    }
}
