package com.google.android.gms.internal.clearcut;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class u0 extends r0 {
    u0() {
    }

    private static int f(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return q0.d(i);
        }
        if (i2 == 1) {
            return q0.l(i, o0.a(bArr, j));
        }
        if (i2 == 2) {
            return q0.f(i, o0.a(bArr, j), o0.a(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.clearcut.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.u0.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.clearcut.r0
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
            o0.k(bArr, j4, (byte) cCharAt);
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
                                throw new t0(i4, length);
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
                                o0.k(bArr, j4, (byte) ((codePoint >>> 18) | SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER));
                                j3 = j5;
                                o0.k(bArr, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j4 + 3;
                                o0.k(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                o0.k(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new t0(i4 - 1, length);
                    }
                    o0.k(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j7 = j4 + 2;
                    o0.k(bArr, j4 + 1, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    j4 += 3;
                    o0.k(bArr, j7, (byte) ((cCharAt3 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j8 = j4 + j;
                    o0.k(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                    j4 += 2;
                    o0.k(bArr, j8, (byte) ((cCharAt3 & '?') | 128));
                }
                j3 = j5;
                j2 = 1;
            } else {
                o0.k(bArr, j4, (byte) cCharAt3);
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

    @Override // com.google.android.gms.internal.clearcut.r0
    final void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        char c;
        int i;
        long j2;
        int i2;
        int i3;
        char c2;
        char cCharAt;
        ByteBuffer byteBuffer2 = byteBuffer;
        long jO = o0.o(byteBuffer);
        long jPosition = byteBuffer.position() + jO;
        long jLimit = byteBuffer.limit() + jO;
        int length = charSequence.length();
        if (length > jLimit - jPosition) {
            char cCharAt2 = charSequence.charAt(length - 1);
            int iLimit = byteBuffer.limit();
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(iLimit);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            c = 128;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            o0.c(jPosition, (byte) cCharAt);
            i4++;
            jPosition = 1 + jPosition;
        }
        if (i4 == length) {
            i = (int) (jPosition - jO);
        } else {
            while (i4 < length) {
                char cCharAt3 = charSequence.charAt(i4);
                if (cCharAt3 >= c || jPosition >= jLimit) {
                    if (cCharAt3 >= 2048 || jPosition > jLimit - 2) {
                        j2 = jO;
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || jPosition > jLimit - 3) {
                            if (jPosition > jLimit - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i2 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i2)))) {
                                    throw new t0(i4, length);
                                }
                                StringBuilder sb2 = new StringBuilder(46);
                                sb2.append("Failed writing ");
                                sb2.append(cCharAt3);
                                sb2.append(" at index ");
                                sb2.append(jPosition);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i3 = i4 + 1;
                            if (i3 != length) {
                                char cCharAt4 = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    o0.c(jPosition, (byte) ((codePoint >>> 18) | SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER));
                                    c2 = 128;
                                    o0.c(jPosition + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j3 = jPosition + 3;
                                    o0.c(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    o0.c(j3, (byte) ((codePoint & 63) | 128));
                                } else {
                                    i4 = i3;
                                }
                            }
                            throw new t0(i4 - 1, length);
                        }
                        long j4 = jPosition + j;
                        o0.c(jPosition, (byte) ((cCharAt3 >>> '\f') | 480));
                        long j5 = jPosition + 2;
                        o0.c(j4, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                        jPosition += 3;
                        o0.c(j5, (byte) ((cCharAt3 & '?') | 128));
                    } else {
                        j2 = jO;
                        long j6 = jPosition + j;
                        o0.c(jPosition, (byte) ((cCharAt3 >>> 6) | 960));
                        jPosition += 2;
                        o0.c(j6, (byte) ((cCharAt3 & '?') | 128));
                    }
                    i3 = i4;
                    c2 = 128;
                } else {
                    o0.c(jPosition, (byte) cCharAt3);
                    j2 = jO;
                    i3 = i4;
                    c2 = c;
                    jPosition += j;
                }
                c = c2;
                jO = j2;
                j = 1;
                i4 = i3 + 1;
            }
            i = (int) (jPosition - jO);
            byteBuffer2 = byteBuffer;
        }
        byteBuffer2.position(i);
    }
}
