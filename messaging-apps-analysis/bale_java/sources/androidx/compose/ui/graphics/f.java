package androidx.compose.ui.graphics;

import ir.nasim.AbstractC13854gv7;
import ir.nasim.ED1;

/* loaded from: classes2.dex */
public final class f {
    public static final a b = new a(null);
    private static final long c = AbstractC13854gv7.a(0.5f, 0.5f);
    private final long a;

    public static final class a {
        private a() {
        }

        public final long a() {
            return f.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ f(long j) {
        this.a = j;
    }

    public static final /* synthetic */ f b(long j) {
        return new f(j);
    }

    public static long c(long j) {
        return j;
    }

    public static boolean d(long j, Object obj) {
        return (obj instanceof f) && j == ((f) obj).j();
    }

    public static final boolean e(long j, long j2) {
        return j == j2;
    }

    public static final float f(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final float g(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static int h(long j) {
        return Long.hashCode(j);
    }

    public static String i(long j) {
        return "TransformOrigin(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return h(this.a);
    }

    public final /* synthetic */ long j() {
        return this.a;
    }

    public String toString() {
        return i(this.a);
    }
}
