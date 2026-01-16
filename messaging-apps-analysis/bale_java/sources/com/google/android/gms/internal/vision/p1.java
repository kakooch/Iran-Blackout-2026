package com.google.android.gms.internal.vision;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes3.dex */
final class p1 extends l1 {
    p1() {
    }

    private static int e(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return k1.h(i);
        }
        if (i2 == 1) {
            return k1.i(i, i1.a(bArr, j));
        }
        if (i2 == 2) {
            return k1.j(i, i1.a(bArr, j), i1.a(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.vision.l1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.p1.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.vision.l1
    final int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        String str;
        String str2;
        int i3;
        long j2;
        long j3;
        char cCharAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
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
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            i1.l(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= 128 || j4 >= j5) {
                if (cCharAt3 >= 2048 || j4 > j5 - 2) {
                    str = str3;
                    str2 = str4;
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j4 > j5 - 3) {
                        if (j4 > j5 - 4) {
                            if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                                throw new n1(i4, length);
                            }
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append(str2);
                            sb2.append(cCharAt3);
                            sb2.append(str);
                            sb2.append(j4);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                j2 = 1;
                                i1.l(bArr, j4, (byte) ((codePoint >>> 18) | SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER));
                                j3 = j5;
                                i1.l(bArr, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j4 + 3;
                                i1.l(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                i1.l(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new n1(i4 - 1, length);
                    }
                    i1.l(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j7 = j4 + 2;
                    i1.l(bArr, j4 + 1, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    j4 += 3;
                    i1.l(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j8 = j4 + j;
                    i1.l(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                    j4 += 2;
                    i1.l(bArr, j8, (byte) ((cCharAt3 & '?') | 128));
                }
                j3 = j5;
                j2 = 1;
            } else {
                i1.l(bArr, j4, (byte) cCharAt3);
                j3 = j5;
                str2 = str4;
                j2 = j;
                j4 += j;
                str = str3;
            }
            i4++;
            str3 = str;
            str4 = str2;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    @Override // com.google.android.gms.internal.vision.l1
    final String d(byte[] bArr, int i, int i2) throws zzjk {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bA = i1.a(bArr, i);
            if (!m1.l(bA)) {
                break;
            }
            i++;
            m1.i(bA, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bA2 = i1.a(bArr, i);
            if (m1.l(bA2)) {
                int i7 = i5 + 1;
                m1.i(bA2, cArr, i5);
                while (i6 < i3) {
                    byte bA3 = i1.a(bArr, i6);
                    if (!m1.l(bA3)) {
                        break;
                    }
                    i6++;
                    m1.i(bA3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (m1.m(bA2)) {
                if (i6 >= i3) {
                    throw zzjk.f();
                }
                i += 2;
                m1.h(bA2, i1.a(bArr, i6), cArr, i5);
                i5++;
            } else if (m1.n(bA2)) {
                if (i6 >= i3 - 1) {
                    throw zzjk.f();
                }
                int i8 = i + 2;
                i += 3;
                m1.g(bA2, i1.a(bArr, i6), i1.a(bArr, i8), cArr, i5);
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw zzjk.f();
                }
                byte bA4 = i1.a(bArr, i6);
                int i9 = i + 3;
                byte bA5 = i1.a(bArr, i + 2);
                i += 4;
                m1.f(bA2, bA4, bA5, i1.a(bArr, i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }
}
