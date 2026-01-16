package com.google.android.gms.internal.clearcut;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC20302rm8;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes3.dex */
public final class w0 {
    private final ByteBuffer a;
    private zzbn b;
    private int c;

    private w0(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 2048) {
                i3 += (127 - cCharAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
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
            return i3;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(i3 + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    private final void d(int i) throws zzft {
        byte b = (byte) i;
        if (!this.a.hasRemaining()) {
            throw new zzft(this.a.position(), this.a.limit());
        }
        this.a.put(b);
    }

    private final void e(int i) throws zzft {
        while ((i & (-128)) != 0) {
            d((i & 127) | 128);
            i >>>= 7;
        }
        d(i);
    }

    public static int f(int i, String str) {
        return v(i) + o(str);
    }

    public static int g(int i, byte[] bArr) {
        return v(i) + p(bArr);
    }

    public static int k(int i, long j) {
        return v(i) + u(j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v20 */
    private static void l(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        char cCharAt;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        char c = 57343;
        int i2 = 0;
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                char c2 = cCharAt2;
                if (cCharAt2 < 128) {
                    byteBuffer.put((byte) c2);
                } else if (cCharAt2 < 2048) {
                    byteBuffer.put((byte) ((cCharAt2 >>> 6) | 960));
                    c2 = (cCharAt2 & '?') | 128;
                    byteBuffer.put((byte) c2);
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i3 = i2 + 1;
                        if (i3 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i3);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                byteBuffer.put((byte) ((codePoint >>> 18) | SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint & 63) | 128));
                                i2 = i3;
                            } else {
                                i2 = i3;
                            }
                        }
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i2 - 1);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    byteBuffer.put((byte) ((cCharAt2 >>> '\f') | 480));
                    byteBuffer.put((byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((cCharAt2 & '?') | 128));
                }
                i2++;
            }
            return;
        }
        try {
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i4 = iRemaining + iArrayOffset;
            while (i2 < length2) {
                int i5 = i2 + iArrayOffset;
                if (i5 >= i4 || (cCharAt = charSequence.charAt(i2)) >= 128) {
                    break;
                }
                bArrArray[i5] = (byte) cCharAt;
                i2++;
            }
            if (i2 == length2) {
                i = iArrayOffset + length2;
            } else {
                i = iArrayOffset + i2;
                while (i2 < length2) {
                    char cCharAt4 = charSequence.charAt(i2);
                    if (cCharAt4 < 128 && i < i4) {
                        bArrArray[i] = (byte) cCharAt4;
                        i++;
                    } else if (cCharAt4 < 2048 && i <= i4 - 2) {
                        int i6 = i + 1;
                        bArrArray[i] = (byte) ((cCharAt4 >>> 6) | 960);
                        i += 2;
                        bArrArray[i6] = (byte) ((cCharAt4 & '?') | 128);
                    } else {
                        if ((cCharAt4 >= 55296 && c >= cCharAt4) || i > i4 - 3) {
                            if (i > i4 - 4) {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(cCharAt4);
                                sb2.append(" at index ");
                                sb2.append(i);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            int i7 = i2 + 1;
                            if (i7 != charSequence.length()) {
                                char cCharAt5 = charSequence.charAt(i7);
                                if (Character.isSurrogatePair(cCharAt4, cCharAt5)) {
                                    int codePoint2 = Character.toCodePoint(cCharAt4, cCharAt5);
                                    bArrArray[i] = (byte) ((codePoint2 >>> 18) | SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
                                    bArrArray[i + 1] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                    int i8 = i + 3;
                                    bArrArray[i + 2] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                    i += 4;
                                    bArrArray[i8] = (byte) ((codePoint2 & 63) | 128);
                                    i2 = i7;
                                } else {
                                    i2 = i7;
                                }
                            }
                            StringBuilder sb3 = new StringBuilder(39);
                            sb3.append("Unpaired surrogate at index ");
                            sb3.append(i2 - 1);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        bArrArray[i] = (byte) ((cCharAt4 >>> '\f') | 480);
                        int i9 = i + 2;
                        bArrArray[i + 1] = (byte) (((cCharAt4 >>> 6) & 63) | 128);
                        i += 3;
                        bArrArray[i9] = (byte) ((cCharAt4 & '?') | 128);
                    }
                    i2++;
                    c = 57343;
                }
            }
            byteBuffer.position(i - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int o(String str) {
        int iA = a(str);
        return x(iA) + iA;
    }

    public static int p(byte[] bArr) {
        return x(bArr.length) + bArr.length;
    }

    public static w0 q(byte[] bArr, int i, int i2) {
        return new w0(bArr, 0, i2);
    }

    public static long s(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int u(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int v(int i) {
        return x(i << 3);
    }

    public static int w(int i) {
        if (i >= 0) {
            return x(i);
        }
        return 10;
    }

    private static int x(int i) {
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

    public final void b(int i, String str) throws zzft {
        h(i, 2);
        try {
            int iX = x(str.length());
            if (iX != x(str.length() * 3)) {
                e(a(str));
                l(str, this.a);
                return;
            }
            int iPosition = this.a.position();
            if (this.a.remaining() < iX) {
                throw new zzft(iPosition + iX, this.a.limit());
            }
            this.a.position(iPosition + iX);
            l(str, this.a);
            int iPosition2 = this.a.position();
            this.a.position(iPosition);
            e((iPosition2 - iPosition) - iX);
            this.a.position(iPosition2);
        } catch (BufferOverflowException e) {
            zzft zzftVar = new zzft(this.a.position(), this.a.limit());
            zzftVar.initCause(e);
            throw zzftVar;
        }
    }

    public final void c(int i, byte[] bArr) throws zzft {
        h(i, 2);
        e(bArr.length);
        int length = bArr.length;
        if (this.a.remaining() < length) {
            throw new zzft(this.a.position(), this.a.limit());
        }
        this.a.put(bArr, 0, length);
    }

    public final void h(int i, int i2) throws zzft {
        e((i << 3) | i2);
    }

    public final void i(int i, boolean z) throws zzft {
        h(25, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        if (!this.a.hasRemaining()) {
            throw new zzft(this.a.position(), this.a.limit());
        }
        this.a.put(b);
    }

    public final void j(int i, int i2) throws zzft {
        h(i, 0);
        if (i2 >= 0) {
            e(i2);
        } else {
            t(i2);
        }
    }

    public final void m(int i, InterfaceC20302rm8 interfaceC20302rm8) {
        if (this.b != null) {
            if (this.c != this.a.position()) {
                this.b.c(this.a.array(), this.c, this.a.position() - this.c);
            }
            zzbn zzbnVar = this.b;
            zzbnVar.l(i, interfaceC20302rm8);
            zzbnVar.b();
            this.c = this.a.position();
        }
        this.b = zzbn.d(this.a);
        this.c = this.a.position();
        zzbn zzbnVar2 = this.b;
        zzbnVar2.l(i, interfaceC20302rm8);
        zzbnVar2.b();
        this.c = this.a.position();
    }

    public final void n() {
        if (this.a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.a.remaining())));
        }
    }

    public final void r(int i, long j) throws zzft {
        h(i, 0);
        t(j);
    }

    public final void t(long j) throws zzft {
        while (((-128) & j) != 0) {
            d((((int) j) & 127) | 128);
            j >>>= 7;
        }
        d((int) j);
    }

    private w0(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }
}
