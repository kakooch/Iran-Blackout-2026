package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Ft7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC4589Ft7 {

    /* renamed from: ir.nasim.Ft7$a */
    public static final class a {
        public final int a;
        public final byte[] b;
        public final int c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.a = i;
            this.b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.d == aVar.d && Arrays.equals(this.b, aVar.b);
        }

        public int hashCode() {
            return (((((this.a * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
        }
    }

    void a(EW4 ew4, int i, int i2);

    void b(long j, int i, int i2, int i3, a aVar);

    void c(com.google.android.exoplayer2.X x);

    default void d(EW4 ew4, int i) {
        a(ew4, i, 0);
    }

    int e(InterfaceC18631oz1 interfaceC18631oz1, int i, boolean z, int i2);

    default int f(InterfaceC18631oz1 interfaceC18631oz1, int i, boolean z) {
        return e(interfaceC18631oz1, i, z, 0);
    }
}
