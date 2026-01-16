package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import ir.eitaa.messenger.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CodecSpecificDataUtil {
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static byte[] buildAacAudioSpecificConfig(int audioObjectType, int sampleRateIndex, int channelConfig) {
        return new byte[]{(byte) (((audioObjectType << 3) & 248) | ((sampleRateIndex >> 1) & 7)), (byte) (((sampleRateIndex << 7) & 128) | ((channelConfig << 3) & R.styleable.AppCompatTheme_windowNoTitle))};
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] audioSpecificConfig) throws ParserException {
        return parseAacAudioSpecificConfig(new ParsableBitArray(audioSpecificConfig), false);
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(ParsableBitArray bitArray, boolean forceReadToEnd) throws ParserException {
        int aacAudioObjectType = getAacAudioObjectType(bitArray);
        int aacSamplingFrequency = getAacSamplingFrequency(bitArray);
        int bits = bitArray.readBits(4);
        if (aacAudioObjectType == 5 || aacAudioObjectType == 29) {
            aacSamplingFrequency = getAacSamplingFrequency(bitArray);
            aacAudioObjectType = getAacAudioObjectType(bitArray);
            if (aacAudioObjectType == 22) {
                bits = bitArray.readBits(4);
            }
        }
        if (forceReadToEnd) {
            if (aacAudioObjectType != 1 && aacAudioObjectType != 2 && aacAudioObjectType != 3 && aacAudioObjectType != 4 && aacAudioObjectType != 6 && aacAudioObjectType != 7 && aacAudioObjectType != 17) {
                switch (aacAudioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + aacAudioObjectType);
                }
            }
            parseGaSpecificConfig(bitArray, aacAudioObjectType, bits);
            switch (aacAudioObjectType) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int bits2 = bitArray.readBits(2);
                    if (bits2 == 2 || bits2 == 3) {
                        throw new ParserException("Unsupported epConfig: " + bits2);
                    }
            }
        }
        int i = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[bits];
        Assertions.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(aacSamplingFrequency), Integer.valueOf(i));
    }

    public static byte[] buildAacLcAudioSpecificConfig(int sampleRate, int channelCount) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
            if (i2 >= iArr.length) {
                break;
            }
            if (sampleRate == iArr[i2]) {
                i3 = i2;
            }
            i2++;
        }
        int i4 = -1;
        while (true) {
            int[] iArr2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
            if (i >= iArr2.length) {
                break;
            }
            if (channelCount == iArr2[i]) {
                i4 = i;
            }
            i++;
        }
        if (sampleRate == -1 || i4 == -1) {
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + sampleRate + ", " + channelCount);
        }
        return buildAacAudioSpecificConfig(2, i3, i4);
    }

    public static Pair<Integer, Integer> parseAlacAudioSpecificConfig(byte[] audioSpecificConfig) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(audioSpecificConfig);
        parsableByteArray.setPosition(9);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return Pair.create(Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), Integer.valueOf(unsignedByte));
    }

    public static String buildAvcCodecString(int profileIdc, int constraintsFlagsAndReservedZero2Bits, int levelIdc) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(profileIdc), Integer.valueOf(constraintsFlagsAndReservedZero2Bits), Integer.valueOf(levelIdc));
    }

    public static byte[] buildNalUnit(byte[] data, int offset, int length) {
        byte[] bArr = NAL_START_CODE;
        byte[] bArr2 = new byte[bArr.length + length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(data, offset, bArr2, bArr.length, length);
        return bArr2;
    }

    public static byte[][] splitNalUnits(byte[] data) {
        if (!isNalStartCode(data, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iFindNalStartCode = 0;
        do {
            arrayList.add(Integer.valueOf(iFindNalStartCode));
            iFindNalStartCode = findNalStartCode(data, iFindNalStartCode + NAL_START_CODE.length);
        } while (iFindNalStartCode != -1);
        byte[][] bArr = new byte[arrayList.size()][];
        int i = 0;
        while (i < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i)).intValue();
            int iIntValue2 = (i < arrayList.size() + (-1) ? ((Integer) arrayList.get(i + 1)).intValue() : data.length) - iIntValue;
            byte[] bArr2 = new byte[iIntValue2];
            System.arraycopy(data, iIntValue, bArr2, 0, iIntValue2);
            bArr[i] = bArr2;
            i++;
        }
        return bArr;
    }

    private static int findNalStartCode(byte[] data, int index) {
        int length = data.length - NAL_START_CODE.length;
        while (index <= length) {
            if (isNalStartCode(data, index)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private static boolean isNalStartCode(byte[] data, int index) {
        if (data.length - index <= NAL_START_CODE.length) {
            return false;
        }
        int i = 0;
        while (true) {
            byte[] bArr = NAL_START_CODE;
            if (i >= bArr.length) {
                return true;
            }
            if (data[index + i] != bArr[i]) {
                return false;
            }
            i++;
        }
    }

    private static int getAacAudioObjectType(ParsableBitArray bitArray) {
        int bits = bitArray.readBits(5);
        return bits == 31 ? bitArray.readBits(6) + 32 : bits;
    }

    private static int getAacSamplingFrequency(ParsableBitArray bitArray) {
        int bits = bitArray.readBits(4);
        if (bits == 15) {
            return bitArray.readBits(24);
        }
        Assertions.checkArgument(bits < 13);
        return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[bits];
    }

    private static void parseGaSpecificConfig(ParsableBitArray bitArray, int audioObjectType, int channelConfiguration) {
        bitArray.skipBits(1);
        if (bitArray.readBit()) {
            bitArray.skipBits(14);
        }
        boolean bit = bitArray.readBit();
        if (channelConfiguration == 0) {
            throw new UnsupportedOperationException();
        }
        if (audioObjectType == 6 || audioObjectType == 20) {
            bitArray.skipBits(3);
        }
        if (bit) {
            if (audioObjectType == 22) {
                bitArray.skipBits(16);
            }
            if (audioObjectType == 17 || audioObjectType == 19 || audioObjectType == 20 || audioObjectType == 23) {
                bitArray.skipBits(3);
            }
            bitArray.skipBits(1);
        }
    }
}
