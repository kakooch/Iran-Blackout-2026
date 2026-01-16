package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class auh {
    private final ByteBuffer a;

    private auh(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static auh a(byte[] bArr) {
        return new auh(ByteBuffer.wrap(bArr, 0, bArr.length));
    }

    public static int g(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    private static void i(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char cCharAt;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i3 = 0;
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 < 128) {
                    byteBuffer.put((byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    byteBuffer.put((byte) ((cCharAt2 >>> 6) | 960));
                    byteBuffer.put((byte) ((cCharAt2 & '?') | 128));
                } else {
                    if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i4 = i3 + 1;
                        if (i4 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint & 63) | 128));
                                i3 = i4;
                            } else {
                                i3 = i4;
                            }
                        }
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i3 - 1);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    byteBuffer.put((byte) ((cCharAt2 >>> '\f') | 480));
                    byteBuffer.put((byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((cCharAt2 & '?') | 128));
                }
                i3++;
            }
            return;
        }
        try {
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i5 = iRemaining + iArrayOffset;
            while (i3 < length2) {
                int i6 = i3 + iArrayOffset;
                if (i6 >= i5 || (cCharAt = charSequence.charAt(i3)) >= 128) {
                    break;
                }
                bArrArray[i6] = (byte) cCharAt;
                i3++;
            }
            if (i3 == length2) {
                i = iArrayOffset + length2;
            } else {
                i = iArrayOffset + i3;
                while (i3 < length2) {
                    char cCharAt4 = charSequence.charAt(i3);
                    if (cCharAt4 >= 128 || i >= i5) {
                        if (cCharAt4 < 2048 && i <= i5 - 2) {
                            int i7 = i + 1;
                            bArrArray[i] = (byte) ((cCharAt4 >>> 6) | 960);
                            i = i7 + 1;
                            bArrArray[i7] = (byte) ((cCharAt4 & '?') | 128);
                        } else {
                            if ((cCharAt4 >= 55296 && cCharAt4 <= 57343) || i > i5 - 3) {
                                if (i > i5 - 4) {
                                    StringBuilder sb2 = new StringBuilder(37);
                                    sb2.append("Failed writing ");
                                    sb2.append(cCharAt4);
                                    sb2.append(" at index ");
                                    sb2.append(i);
                                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                }
                                int i8 = i3 + 1;
                                if (i8 != charSequence.length()) {
                                    char cCharAt5 = charSequence.charAt(i8);
                                    if (Character.isSurrogatePair(cCharAt4, cCharAt5)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt4, cCharAt5);
                                        int i9 = i + 1;
                                        bArrArray[i] = (byte) ((codePoint2 >>> 18) | 240);
                                        int i10 = i9 + 1;
                                        bArrArray[i9] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                        int i11 = i10 + 1;
                                        bArrArray[i10] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                        i = i11 + 1;
                                        bArrArray[i11] = (byte) ((codePoint2 & 63) | 128);
                                        i3 = i8;
                                    } else {
                                        i3 = i8;
                                    }
                                }
                                StringBuilder sb3 = new StringBuilder(39);
                                sb3.append("Unpaired surrogate at index ");
                                sb3.append(i3 - 1);
                                throw new IllegalArgumentException(sb3.toString());
                            }
                            int i12 = i + 1;
                            bArrArray[i] = (byte) ((cCharAt4 >>> '\f') | 480);
                            int i13 = i12 + 1;
                            bArrArray[i12] = (byte) (((cCharAt4 >>> 6) & 63) | 128);
                            i2 = i13 + 1;
                            bArrArray[i13] = (byte) ((cCharAt4 & '?') | 128);
                        }
                        i3++;
                    } else {
                        i2 = i + 1;
                        bArrArray[i] = (byte) cCharAt4;
                    }
                    i = i2;
                    i3++;
                }
            }
            byteBuffer.position(i - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public final void b(String str) throws IOException {
        try {
            int iG = g(str.length());
            if (iG == g(str.length() * 3)) {
                int iPosition = this.a.position();
                if (this.a.remaining() < iG) {
                    throw new aug(iPosition + iG, this.a.limit());
                }
                this.a.position(iPosition + iG);
                i(str, this.a);
                int iPosition2 = this.a.position();
                this.a.position(iPosition);
                f((iPosition2 - iPosition) - iG);
                this.a.position(iPosition2);
                return;
            }
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i2 < length && str.charAt(i2) < 128) {
                i2++;
            }
            int i3 = length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt < 2048) {
                    i3 += (127 - cCharAt) >>> 31;
                    i2++;
                } else {
                    int length2 = str.length();
                    while (i2 < length2) {
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 < 2048) {
                            i += (127 - cCharAt2) >>> 31;
                        } else {
                            i += 2;
                            if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                                if (Character.codePointAt(str, i2) < 65536) {
                                    StringBuilder sb = new StringBuilder(39);
                                    sb.append("Unpaired surrogate at index ");
                                    sb.append(i2);
                                    throw new IllegalArgumentException(sb.toString());
                                }
                                i2++;
                            }
                        }
                        i2++;
                    }
                    i3 += i;
                }
            }
            if (i3 >= length) {
                f(i3);
                i(str, this.a);
            } else {
                StringBuilder sb2 = new StringBuilder(54);
                sb2.append("UTF-8 length does not fit in int: ");
                sb2.append(i3 + 4294967296L);
                throw new IllegalArgumentException(sb2.toString());
            }
        } catch (BufferOverflowException e) {
            aug augVar = new aug(this.a.position(), this.a.limit());
            augVar.initCause(e);
            throw augVar;
        }
    }

    public final int c() {
        return this.a.remaining();
    }

    public final void d(int i) throws IOException {
        byte b = (byte) i;
        if (!this.a.hasRemaining()) {
            throw new aug(this.a.position(), this.a.limit());
        }
        this.a.put(b);
    }

    public final void e(int i, int i2) throws IOException {
        f(aty.b(i, i2));
    }

    public final void f(int i) throws IOException {
        while ((i & (-128)) != 0) {
            d((i & 127) | 128);
            i >>>= 7;
        }
        d(i);
    }

    public final void h(long j) throws IOException {
        while (((-128) & j) != 0) {
            d((((int) j) & 127) | 128);
            j >>>= 7;
        }
        d((int) j);
    }
}
