package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzkm extends zzkj {
    zzkm() {
    }

    private static int zze(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzkn.zzj(i);
        }
        if (i2 == 1) {
            return zzkn.zzk(i, zzkh.zzp(bArr, j));
        }
        if (i2 == 2) {
            return zzkn.zzl(i, zzkh.zzp(bArr, j), zzkh.zzp(bArr, j + 1));
        }
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.measurement.zzkj
    final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        int length = bArr.length;
        if ((i2 | i3 | (length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j2 = i2;
        int i5 = (int) (i3 - j2);
        if (i5 >= 16) {
            long j3 = j2;
            i4 = 0;
            while (true) {
                if (i4 >= i5) {
                    i4 = i5;
                    break;
                }
                long j4 = j3 + 1;
                if (zzkh.zzp(bArr, j3) < 0) {
                    break;
                }
                i4++;
                j3 = j4;
            }
        } else {
            i4 = 0;
        }
        int i6 = i5 - i4;
        long j5 = j2 + i4;
        while (true) {
            byte bZzp = 0;
            while (true) {
                if (i6 <= 0) {
                    break;
                }
                long j6 = j5 + 1;
                bZzp = zzkh.zzp(bArr, j5);
                if (bZzp < 0) {
                    j5 = j6;
                    break;
                }
                i6--;
                j5 = j6;
            }
            if (i6 != 0) {
                int i7 = i6 - 1;
                if (bZzp >= -32) {
                    if (bZzp >= -16) {
                        if (i7 >= 3) {
                            i6 = i7 - 3;
                            long j7 = j5 + 1;
                            byte bZzp2 = zzkh.zzp(bArr, j5);
                            if (bZzp2 <= -65 && (((bZzp << 28) + (bZzp2 + 112)) >> 30) == 0) {
                                long j8 = j7 + 1;
                                if (zzkh.zzp(bArr, j7) > -65) {
                                    break;
                                }
                                j = j8 + 1;
                                if (zzkh.zzp(bArr, j8) > -65) {
                                    break;
                                }
                                j5 = j;
                            } else {
                                break;
                            }
                        } else {
                            return zze(bArr, bZzp, j5, i7);
                        }
                    } else {
                        if (i7 < 2) {
                            return zze(bArr, bZzp, j5, i7);
                        }
                        i6 = i7 - 2;
                        long j9 = j5 + 1;
                        byte bZzp3 = zzkh.zzp(bArr, j5);
                        if (bZzp3 > -65 || ((bZzp == -32 && bZzp3 < -96) || (bZzp == -19 && bZzp3 >= -96))) {
                            break;
                        }
                        j5 = j9 + 1;
                        if (zzkh.zzp(bArr, j9) > -65) {
                            break;
                        }
                    }
                } else {
                    if (i7 == 0) {
                        return bZzp;
                    }
                    i6 = i7 - 1;
                    if (bZzp < -62) {
                        break;
                    }
                    j = j5 + 1;
                    if (zzkh.zzp(bArr, j5) > -65) {
                        break;
                    }
                    j5 = j;
                }
            } else {
                return 0;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzkj
    final String zzc(byte[] bArr, int i, int i2) throws zzic {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZzp = zzkh.zzp(bArr, i);
            if (!zzki.zza(bZzp)) {
                break;
            }
            i++;
            cArr[i4] = (char) bZzp;
            i4++;
        }
        while (i < i3) {
            int i5 = i + 1;
            byte bZzp2 = zzkh.zzp(bArr, i);
            if (zzki.zza(bZzp2)) {
                int i6 = i4 + 1;
                cArr[i4] = (char) bZzp2;
                i = i5;
                while (true) {
                    i4 = i6;
                    if (i < i3) {
                        byte bZzp3 = zzkh.zzp(bArr, i);
                        if (!zzki.zza(bZzp3)) {
                            break;
                        }
                        i++;
                        i6 = i4 + 1;
                        cArr[i4] = (char) bZzp3;
                    }
                }
            } else if (zzki.zzb(bZzp2)) {
                if (i5 >= i3) {
                    throw zzic.zzf();
                }
                zzki.zzc(bZzp2, zzkh.zzp(bArr, i5), cArr, i4);
                i = i5 + 1;
                i4++;
            } else if (zzki.zzd(bZzp2)) {
                if (i5 >= i3 - 1) {
                    throw zzic.zzf();
                }
                int i7 = i5 + 1;
                zzki.zze(bZzp2, zzkh.zzp(bArr, i5), zzkh.zzp(bArr, i7), cArr, i4);
                i = i7 + 1;
                i4++;
            } else {
                if (i5 >= i3 - 2) {
                    throw zzic.zzf();
                }
                int i8 = i5 + 1;
                int i9 = i8 + 1;
                zzki.zzf(bZzp2, zzkh.zzp(bArr, i5), zzkh.zzp(bArr, i8), zzkh.zzp(bArr, i9), cArr, i4);
                i4 += 2;
                i = i9 + 1;
            }
        }
        return new String(cArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzkj
    final int zzd(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        int i3;
        char cCharAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzkh.zzq(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= c || j4 >= j5) {
                if (cCharAt3 < 2048 && j4 <= (-2) + j5) {
                    long j6 = j4 + j;
                    zzkh.zzq(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                    zzkh.zzq(bArr, j6, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((cCharAt3 >= 55296 && cCharAt3 <= 57343) || j4 > (-3) + j5) {
                        if (j4 > (-4) + j5) {
                            if (cCharAt3 >= 55296 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                                throw new zzkl(i4, length);
                            }
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Failed writing ");
                            sb2.append(cCharAt3);
                            sb2.append(" at index ");
                            sb2.append(j4);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                long j7 = j4 + 1;
                                zzkh.zzq(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j8 = j7 + 1;
                                zzkh.zzq(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j9 = j8 + 1;
                                zzkh.zzq(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j9 + 1;
                                zzkh.zzq(bArr, j9, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzkl(i4 - 1, length);
                    }
                    long j10 = j4 + j;
                    zzkh.zzq(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    zzkh.zzq(bArr, j10, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    zzkh.zzq(bArr, j11, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                zzkh.zzq(bArr, j4, (byte) cCharAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }
}
