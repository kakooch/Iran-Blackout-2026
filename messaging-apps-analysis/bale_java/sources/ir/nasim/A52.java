package ir.nasim;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class A52 {
    private static final a e = new a(null);
    private static final long[] f = new long[0];
    private final SerialDescriptor a;
    private final InterfaceC14603iB2 b;
    private long c;
    private final long[] d;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public A52(SerialDescriptor serialDescriptor, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(interfaceC14603iB2, "readIfAbsent");
        this.a = serialDescriptor;
        this.b = interfaceC14603iB2;
        int iD = serialDescriptor.d();
        if (iD <= 64) {
            this.c = iD != 64 ? (-1) << iD : 0L;
            this.d = f;
        } else {
            this.c = 0L;
            this.d = e(iD);
        }
    }

    private final void b(int i) {
        int i2 = (i >>> 6) - 1;
        long[] jArr = this.d;
        jArr[i2] = jArr[i2] | (1 << (i & 63));
    }

    private final int c() {
        int length = this.d.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = i2 * 64;
            long j = this.d[i];
            while (j != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
                j |= 1 << iNumberOfTrailingZeros;
                int i4 = iNumberOfTrailingZeros + i3;
                if (((Boolean) this.b.invoke(this.a, Integer.valueOf(i4))).booleanValue()) {
                    this.d[i] = j;
                    return i4;
                }
            }
            this.d[i] = j;
            i = i2;
        }
        return -1;
    }

    private final long[] e(int i) {
        long[] jArr = new long[(i - 1) >>> 6];
        if ((i & 63) != 0) {
            jArr[AbstractC10242bK.k0(jArr)] = (-1) << i;
        }
        return jArr;
    }

    public final void a(int i) {
        if (i < 64) {
            this.c |= 1 << i;
        } else {
            b(i);
        }
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iD = this.a.d();
        do {
            long j = this.c;
            if (j == -1) {
                if (iD > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j);
            this.c |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) this.b.invoke(this.a, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }
}
