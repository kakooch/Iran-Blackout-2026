package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes.dex */
final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z) throws IOException {
        boolean z2;
        long length = extractorInput.getLength();
        long j = 4096;
        long j2 = -1;
        if (length != -1 && length <= 4096) {
            j = length;
        }
        int i = (int) j;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z3 = false;
        int i2 = 0;
        boolean z4 = false;
        while (i2 < i) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), z3 ? 1 : 0, 8, true)) {
                break;
            }
            long unsignedInt = parsableByteArray.readUnsignedInt();
            int i3 = parsableByteArray.readInt();
            int i4 = 16;
            if (unsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                unsignedInt = parsableByteArray.readLong();
            } else {
                if (unsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j2) {
                        unsignedInt = 8 + (length2 - extractorInput.getPeekPosition());
                    }
                }
                i4 = 8;
            }
            long j3 = i4;
            if (unsignedInt < j3) {
                return z3;
            }
            i2 += i4;
            if (i3 == 1836019574) {
                i += (int) unsignedInt;
                if (length != -1 && i > length) {
                    i = (int) length;
                }
                j2 = -1;
            } else {
                if (i3 == 1836019558 || i3 == 1836475768) {
                    z2 = true;
                    break;
                }
                long j4 = length;
                if ((i2 + unsignedInt) - j3 >= i) {
                    break;
                }
                int i5 = (int) (unsignedInt - j3);
                i2 += i5;
                if (i3 == 1718909296) {
                    if (i5 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i5);
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i5);
                    int i6 = i5 / 4;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= i6) {
                            break;
                        }
                        if (i7 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt())) {
                            z4 = true;
                            break;
                        }
                        i7++;
                    }
                    if (!z4) {
                        return false;
                    }
                } else if (i5 != 0) {
                    extractorInput.advancePeekPosition(i5);
                }
                j2 = -1;
                length = j4;
                z3 = false;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }

    private static boolean isCompatibleBrand(int i) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
