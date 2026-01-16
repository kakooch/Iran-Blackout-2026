package com.google.android.gms.internal.clearcut;

import ir.nasim.Dj8;
import ir.nasim.InterfaceC20302rm8;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class zzbn extends Dj8 {
    private static final Logger b = Logger.getLogger(zzbn.class.getName());
    private static final boolean c = o0.x();
    C2094s a;

    static class a extends zzbn {
        private final byte[] d;
        private final int e;
        private final int f;
        private int g;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.d = bArr;
            this.e = i;
            this.g = i;
            this.f = i3;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void D(int i, int i2) {
            s0((i << 3) | i2);
        }

        public final int D0() {
            return this.g - this.e;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void F(int i, AbstractC2081f abstractC2081f) {
            D(1, 3);
            V(2, i);
            k(3, abstractC2081f);
            D(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i, InterfaceC20302rm8 interfaceC20302rm8) {
            D(1, 3);
            V(2, i);
            l(3, interfaceC20302rm8);
            D(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void H(int i, boolean z) {
            D(i, 0);
            e(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(long j) throws zzc {
            if (zzbn.c && s() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.d;
                    int i = this.g;
                    this.g = i + 1;
                    o0.k(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i2 = this.g;
                this.g = i2 + 1;
                o0.k(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.d;
                    int i3 = this.g;
                    this.g = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
                }
            }
            byte[] bArr4 = this.d;
            int i4 = this.g;
            this.g = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(InterfaceC20302rm8 interfaceC20302rm8) {
            s0(interfaceC20302rm8.e());
            interfaceC20302rm8.c(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void Q(int i, int i2) {
            D(i, 0);
            r0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void R(int i, long j) {
            D(i, 1);
            W(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void V(int i, int i2) {
            D(i, 0);
            s0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void W(long j) throws zzc {
            try {
                byte[] bArr = this.d;
                int i = this.g;
                bArr[i] = (byte) j;
                bArr[i + 1] = (byte) (j >> 8);
                bArr[i + 2] = (byte) (j >> 16);
                bArr[i + 3] = (byte) (j >> 24);
                bArr[i + 4] = (byte) (j >> 32);
                bArr[i + 5] = (byte) (j >> 40);
                bArr[i + 6] = (byte) (j >> 48);
                this.g = i + 8;
                bArr[i + 7] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }

        @Override // ir.nasim.Dj8
        public final void a(byte[] bArr, int i, int i2) {
            c(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public void b() {
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i, int i2) throws zzc {
            try {
                System.arraycopy(bArr, i, this.d, this.g, i2);
                this.g += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(int i, int i2) {
            D(i, 5);
            u0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void e(byte b) throws zzc {
            try {
                byte[] bArr = this.d;
                int i = this.g;
                this.g = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g0(String str) throws zzc {
            int i = this.g;
            try {
                int iX0 = zzbn.x0(str.length() * 3);
                int iX02 = zzbn.x0(str.length());
                if (iX02 != iX0) {
                    s0(q0.a(str));
                    this.g = q0.b(str, this.d, this.g, s());
                    return;
                }
                int i2 = i + iX02;
                this.g = i2;
                int iB = q0.b(str, this.d, i2, s());
                this.g = i;
                s0((iB - i) - iX02);
                this.g = iB;
            } catch (t0 e) {
                this.g = i;
                q(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void j(int i, long j) {
            D(i, 0);
            I(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void k(int i, AbstractC2081f abstractC2081f) {
            D(i, 2);
            o(abstractC2081f);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i, InterfaceC20302rm8 interfaceC20302rm8) {
            D(i, 2);
            J(interfaceC20302rm8);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void m(int i, InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
            D(i, 2);
            AbstractC2071a abstractC2071a = (AbstractC2071a) interfaceC20302rm8;
            int iG = abstractC2071a.g();
            if (iG == -1) {
                iG = interfaceC2082f0.h(abstractC2071a);
                abstractC2071a.a(iG);
            }
            s0(iG);
            interfaceC2082f0.e(interfaceC20302rm8, this.a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i, String str) {
            D(i, 2);
            g0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void o(AbstractC2081f abstractC2081f) {
            s0(abstractC2081f.size());
            abstractC2081f.w(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void p(InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
            AbstractC2071a abstractC2071a = (AbstractC2071a) interfaceC20302rm8;
            int iG = abstractC2071a.g();
            if (iG == -1) {
                iG = interfaceC2082f0.h(abstractC2071a);
                abstractC2071a.a(iG);
            }
            s0(iG);
            interfaceC2082f0.e(interfaceC20302rm8, this.a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void r0(int i) {
            if (i >= 0) {
                s0(i);
            } else {
                I(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int s() {
            return this.f - this.g;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void s0(int i) throws zzc {
            if (zzbn.c && s() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.d;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    o0.k(bArr, i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i3 = this.g;
                this.g = i3 + 1;
                o0.k(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.d;
                    int i4 = this.g;
                    this.g = i4 + 1;
                    bArr3[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
                }
            }
            byte[] bArr4 = this.d;
            int i5 = this.g;
            this.g = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void u0(int i) throws zzc {
            try {
                byte[] bArr = this.d;
                int i2 = this.g;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                this.g = i2 + 4;
                bArr[i2 + 3] = i >> 24;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }
    }

    static final class b extends a {
        private final ByteBuffer h;
        private int i;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.h = byteBuffer;
            this.i = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn.a, com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.h.position(this.i + D0());
        }
    }

    static final class c extends zzbn {
        private final ByteBuffer d;
        private final ByteBuffer e;
        private final int f;

        c(ByteBuffer byteBuffer) {
            super();
            this.d = byteBuffer;
            this.e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f = byteBuffer.position();
        }

        private final void D0(String str) throws zzc {
            try {
                q0.c(str, this.e);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void D(int i, int i2) {
            s0((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void F(int i, AbstractC2081f abstractC2081f) {
            D(1, 3);
            V(2, i);
            k(3, abstractC2081f);
            D(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i, InterfaceC20302rm8 interfaceC20302rm8) {
            D(1, 3);
            V(2, i);
            l(3, interfaceC20302rm8);
            D(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void H(int i, boolean z) {
            D(i, 0);
            e(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(long j) throws zzc {
            while (((-128) & j) != 0) {
                try {
                    this.e.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.e.put((byte) j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(InterfaceC20302rm8 interfaceC20302rm8) {
            s0(interfaceC20302rm8.e());
            interfaceC20302rm8.c(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void Q(int i, int i2) {
            D(i, 0);
            r0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void R(int i, long j) {
            D(i, 1);
            W(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void V(int i, int i2) {
            D(i, 0);
            s0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void W(long j) throws zzc {
            try {
                this.e.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // ir.nasim.Dj8
        public final void a(byte[] bArr, int i, int i2) {
            c(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.d.position(this.e.position());
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i, int i2) throws zzc {
            try {
                this.e.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(int i, int i2) {
            D(i, 5);
            u0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void e(byte b) throws zzc {
            try {
                this.e.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g0(String str) throws zzc {
            int iPosition = this.e.position();
            try {
                int iX0 = zzbn.x0(str.length() * 3);
                int iX02 = zzbn.x0(str.length());
                if (iX02 != iX0) {
                    s0(q0.a(str));
                    D0(str);
                    return;
                }
                int iPosition2 = this.e.position() + iX02;
                this.e.position(iPosition2);
                D0(str);
                int iPosition3 = this.e.position();
                this.e.position(iPosition);
                s0(iPosition3 - iPosition2);
                this.e.position(iPosition3);
            } catch (t0 e) {
                this.e.position(iPosition);
                q(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void j(int i, long j) {
            D(i, 0);
            I(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void k(int i, AbstractC2081f abstractC2081f) {
            D(i, 2);
            o(abstractC2081f);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i, InterfaceC20302rm8 interfaceC20302rm8) {
            D(i, 2);
            J(interfaceC20302rm8);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void m(int i, InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
            D(i, 2);
            p(interfaceC20302rm8, interfaceC2082f0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i, String str) {
            D(i, 2);
            g0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void o(AbstractC2081f abstractC2081f) {
            s0(abstractC2081f.size());
            abstractC2081f.w(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void p(InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
            AbstractC2071a abstractC2071a = (AbstractC2071a) interfaceC20302rm8;
            int iG = abstractC2071a.g();
            if (iG == -1) {
                iG = interfaceC2082f0.h(abstractC2071a);
                abstractC2071a.a(iG);
            }
            s0(iG);
            interfaceC2082f0.e(interfaceC20302rm8, this.a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void r0(int i) {
            if (i >= 0) {
                s0(i);
            } else {
                I(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int s() {
            return this.e.remaining();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void s0(int i) throws zzc {
            while ((i & (-128)) != 0) {
                try {
                    this.e.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.e.put((byte) i);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void u0(int i) throws zzc {
            try {
                this.e.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }
    }

    static final class d extends zzbn {
        private final ByteBuffer d;
        private final ByteBuffer e;
        private final long f;
        private final long g;
        private final long h;
        private final long i;
        private long j;

        d(ByteBuffer byteBuffer) {
            super();
            this.d = byteBuffer;
            this.e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long jO = o0.o(byteBuffer);
            this.f = jO;
            long jPosition = byteBuffer.position() + jO;
            this.g = jPosition;
            long jLimit = jO + byteBuffer.limit();
            this.h = jLimit;
            this.i = jLimit - 10;
            this.j = jPosition;
        }

        private final void D0(long j) {
            this.e.position((int) (j - this.f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void D(int i, int i2) {
            s0((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void F(int i, AbstractC2081f abstractC2081f) {
            D(1, 3);
            V(2, i);
            k(3, abstractC2081f);
            D(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i, InterfaceC20302rm8 interfaceC20302rm8) {
            D(1, 3);
            V(2, i);
            l(3, interfaceC20302rm8);
            D(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void H(int i, boolean z) {
            D(i, 0);
            e(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(long j) throws zzc {
            if (this.j <= this.i) {
                while ((j & (-128)) != 0) {
                    long j2 = this.j;
                    this.j = j2 + 1;
                    o0.c(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.j;
                this.j = 1 + j3;
                o0.c(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.j;
                if (j4 >= this.h) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
                }
                if ((j & (-128)) == 0) {
                    this.j = 1 + j4;
                    o0.c(j4, (byte) j);
                    return;
                } else {
                    this.j = j4 + 1;
                    o0.c(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(InterfaceC20302rm8 interfaceC20302rm8) {
            s0(interfaceC20302rm8.e());
            interfaceC20302rm8.c(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void Q(int i, int i2) {
            D(i, 0);
            r0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void R(int i, long j) {
            D(i, 1);
            W(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void V(int i, int i2) {
            D(i, 0);
            s0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void W(long j) {
            this.e.putLong((int) (this.j - this.f), j);
            this.j += 8;
        }

        @Override // ir.nasim.Dj8
        public final void a(byte[] bArr, int i, int i2) {
            c(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.d.position((int) (this.j - this.f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i, int i2) throws zzc {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.h - j;
                long j3 = this.j;
                if (j2 >= j3) {
                    o0.l(bArr, i, j3, j);
                    this.j += j;
                    return;
                }
            }
            if (bArr != null) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), Integer.valueOf(i2)));
            }
            throw new NullPointerException("value");
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(int i, int i2) {
            D(i, 5);
            u0(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void e(byte b) throws zzc {
            long j = this.j;
            if (j >= this.h) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
            }
            this.j = 1 + j;
            o0.c(j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g0(String str) throws zzc {
            long j = this.j;
            try {
                int iX0 = zzbn.x0(str.length() * 3);
                int iX02 = zzbn.x0(str.length());
                if (iX02 != iX0) {
                    int iA = q0.a(str);
                    s0(iA);
                    D0(this.j);
                    q0.c(str, this.e);
                    this.j += iA;
                    return;
                }
                int i = ((int) (this.j - this.f)) + iX02;
                this.e.position(i);
                q0.c(str, this.e);
                int iPosition = this.e.position() - i;
                s0(iPosition);
                this.j += iPosition;
            } catch (t0 e) {
                this.j = j;
                D0(j);
                q(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void j(int i, long j) {
            D(i, 0);
            I(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void k(int i, AbstractC2081f abstractC2081f) {
            D(i, 2);
            o(abstractC2081f);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i, InterfaceC20302rm8 interfaceC20302rm8) {
            D(i, 2);
            J(interfaceC20302rm8);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void m(int i, InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
            D(i, 2);
            p(interfaceC20302rm8, interfaceC2082f0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i, String str) {
            D(i, 2);
            g0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void o(AbstractC2081f abstractC2081f) {
            s0(abstractC2081f.size());
            abstractC2081f.w(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void p(InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
            AbstractC2071a abstractC2071a = (AbstractC2071a) interfaceC20302rm8;
            int iG = abstractC2071a.g();
            if (iG == -1) {
                iG = interfaceC2082f0.h(abstractC2071a);
                abstractC2071a.a(iG);
            }
            s0(iG);
            interfaceC2082f0.e(interfaceC20302rm8, this.a);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void r0(int i) {
            if (i >= 0) {
                s0(i);
            } else {
                I(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int s() {
            return (int) (this.h - this.j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void s0(int i) throws zzc {
            long j;
            if (this.j <= this.i) {
                while (true) {
                    int i2 = i & (-128);
                    j = this.j;
                    if (i2 == 0) {
                        break;
                    }
                    this.j = j + 1;
                    o0.c(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            } else {
                while (true) {
                    j = this.j;
                    if (j >= this.h) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.j), Long.valueOf(this.h), 1));
                    }
                    if ((i & (-128)) == 0) {
                        break;
                    }
                    this.j = j + 1;
                    o0.c(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
            this.j = 1 + j;
            o0.c(j, (byte) i);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void u0(int i) {
            this.e.putInt((int) (this.j - this.f), i);
            this.j += 4;
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzc(String str) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzc(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzbn() {
    }

    public static int A(AbstractC2081f abstractC2081f) {
        int size = abstractC2081f.size();
        return x0(size) + size;
    }

    public static int A0(int i) {
        return 4;
    }

    static int B(InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
        AbstractC2071a abstractC2071a = (AbstractC2071a) interfaceC20302rm8;
        int iG = abstractC2071a.g();
        if (iG == -1) {
            iG = interfaceC2082f0.h(abstractC2071a);
            abstractC2071a.a(iG);
        }
        return x0(iG) + iG;
    }

    public static int B0(int i) {
        return w0(i);
    }

    public static int C(boolean z) {
        return 1;
    }

    private static int C0(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int K(int i, AbstractC2081f abstractC2081f) {
        int iV0 = v0(i);
        int size = abstractC2081f.size();
        return iV0 + x0(size) + size;
    }

    public static int L(int i, InterfaceC20302rm8 interfaceC20302rm8) {
        return v0(i) + O(interfaceC20302rm8);
    }

    static int M(int i, InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
        int iV0 = v0(i) << 1;
        AbstractC2071a abstractC2071a = (AbstractC2071a) interfaceC20302rm8;
        int iG = abstractC2071a.g();
        if (iG == -1) {
            iG = interfaceC2082f0.h(abstractC2071a);
            abstractC2071a.a(iG);
        }
        return iV0 + iG;
    }

    public static int N(int i, boolean z) {
        return v0(i) + 1;
    }

    public static int O(InterfaceC20302rm8 interfaceC20302rm8) {
        int iE = interfaceC20302rm8.e();
        return x0(iE) + iE;
    }

    public static zzbn P(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int T(int i, long j) {
        return v0(i) + b0(j);
    }

    public static int U(int i, AbstractC2081f abstractC2081f) {
        return (v0(1) << 1) + h0(2, i) + K(3, abstractC2081f);
    }

    public static int X(int i, long j) {
        return v0(i) + b0(j);
    }

    public static int Y(long j) {
        return b0(j);
    }

    public static int a0(int i, long j) {
        return v0(i) + b0(o0(j));
    }

    public static int b0(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static zzbn d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return o0.y() ? new d(byteBuffer) : new c(byteBuffer);
    }

    public static int d0(int i, int i2) {
        return v0(i) + w0(i2);
    }

    public static int e0(int i, long j) {
        return v0(i) + 8;
    }

    public static int f0(long j) {
        return b0(o0(j));
    }

    public static int h0(int i, int i2) {
        return v0(i) + x0(i2);
    }

    public static int i0(int i, long j) {
        return v0(i) + 8;
    }

    public static int j0(long j) {
        return 8;
    }

    public static int k0(String str) {
        int length;
        try {
            length = q0.a(str);
        } catch (t0 unused) {
            length = str.getBytes(B.a).length;
        }
        return x0(length) + length;
    }

    public static int l0(int i, int i2) {
        return v0(i) + x0(C0(i2));
    }

    public static int m0(long j) {
        return 8;
    }

    public static int n0(int i, int i2) {
        return v0(i) + 4;
    }

    private static long o0(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int p0(int i, int i2) {
        return v0(i) + 4;
    }

    public static int q0(int i, int i2) {
        return v0(i) + w0(i2);
    }

    public static int u(double d2) {
        return 8;
    }

    public static int v(float f) {
        return 4;
    }

    public static int v0(int i) {
        return x0(i << 3);
    }

    public static int w(int i, double d2) {
        return v0(i) + 8;
    }

    public static int w0(int i) {
        if (i >= 0) {
            return x0(i);
        }
        return 10;
    }

    public static int x(int i, float f) {
        return v0(i) + 4;
    }

    public static int x0(int i) {
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

    static int y(int i, InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0) {
        return v0(i) + B(interfaceC20302rm8, interfaceC2082f0);
    }

    public static int y0(int i) {
        return x0(C0(i));
    }

    public static int z(int i, String str) {
        return v0(i) + k0(str);
    }

    public static int z0(int i) {
        return 4;
    }

    public abstract void D(int i, int i2);

    public final void E(int i, long j) {
        j(i, o0(j));
    }

    public abstract void F(int i, AbstractC2081f abstractC2081f);

    public abstract void G(int i, InterfaceC20302rm8 interfaceC20302rm8);

    public abstract void H(int i, boolean z);

    public abstract void I(long j);

    public abstract void J(InterfaceC20302rm8 interfaceC20302rm8);

    public abstract void Q(int i, int i2);

    public abstract void R(int i, long j);

    public final void S(long j) {
        I(o0(j));
    }

    public abstract void V(int i, int i2);

    public abstract void W(long j);

    public final void Z(int i, int i2) {
        V(i, C0(i2));
    }

    public abstract void b();

    public abstract void c(byte[] bArr, int i, int i2);

    public abstract void c0(int i, int i2);

    public abstract void e(byte b2);

    public final void f(double d2) {
        W(Double.doubleToRawLongBits(d2));
    }

    public final void g(float f) {
        u0(Float.floatToRawIntBits(f));
    }

    public abstract void g0(String str);

    public final void h(int i, double d2) {
        R(i, Double.doubleToRawLongBits(d2));
    }

    public final void i(int i, float f) {
        c0(i, Float.floatToRawIntBits(f));
    }

    public abstract void j(int i, long j);

    public abstract void k(int i, AbstractC2081f abstractC2081f);

    public abstract void l(int i, InterfaceC20302rm8 interfaceC20302rm8);

    abstract void m(int i, InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0);

    public abstract void n(int i, String str);

    public abstract void o(AbstractC2081f abstractC2081f);

    abstract void p(InterfaceC20302rm8 interfaceC20302rm8, InterfaceC2082f0 interfaceC2082f0);

    final void q(String str, t0 t0Var) throws zzc {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) t0Var);
        byte[] bytes = str.getBytes(B.a);
        try {
            s0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzc e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzc(e2);
        }
    }

    public final void r(boolean z) {
        e(z ? (byte) 1 : (byte) 0);
    }

    public abstract void r0(int i);

    public abstract int s();

    public abstract void s0(int i);

    public final void t0(int i) {
        s0(C0(i));
    }

    public abstract void u0(int i);
}
