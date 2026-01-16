package androidx.emoji2.text;

import ir.nasim.C3276Ae4;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
abstract class k {

    private static class a implements c {
        private final ByteBuffer a;

        a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.k.c
        public void a(int i) {
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + i);
        }

        @Override // androidx.emoji2.text.k.c
        public int b() {
            return this.a.getInt();
        }

        @Override // androidx.emoji2.text.k.c
        public long c() {
            return k.c(this.a.getInt());
        }

        @Override // androidx.emoji2.text.k.c
        public long getPosition() {
            return this.a.position();
        }

        @Override // androidx.emoji2.text.k.c
        public int readUnsignedShort() {
            return k.d(this.a.getShort());
        }
    }

    private static class b {
        private final long a;
        private final long b;

        b(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        long a() {
            return this.a;
        }
    }

    private interface c {
        void a(int i);

        int b();

        long c();

        long getPosition();

        int readUnsignedShort();
    }

    private static b a(c cVar) throws IOException {
        long jC;
        cVar.a(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.a(6);
        int i = 0;
        while (true) {
            if (i >= unsignedShort) {
                jC = -1;
                break;
            }
            int iB = cVar.b();
            cVar.a(4);
            jC = cVar.c();
            cVar.a(4);
            if (1835365473 == iB) {
                break;
            }
            i++;
        }
        if (jC != -1) {
            cVar.a((int) (jC - cVar.getPosition()));
            cVar.a(12);
            long jC2 = cVar.c();
            for (int i2 = 0; i2 < jC2; i2++) {
                int iB2 = cVar.b();
                long jC3 = cVar.c();
                long jC4 = cVar.c();
                if (1164798569 == iB2 || 1701669481 == iB2) {
                    return new b(jC3 + jC, jC4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static C3276Ae4 b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return C3276Ae4.h(byteBufferDuplicate);
    }

    static long c(int i) {
        return i & 4294967295L;
    }

    static int d(short s) {
        return s & 65535;
    }
}
