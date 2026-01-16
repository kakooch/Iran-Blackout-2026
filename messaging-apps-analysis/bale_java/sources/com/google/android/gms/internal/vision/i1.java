package com.google.android.gms.internal.vision;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
abstract class i1 {
    private static final Unsafe a;
    private static final Class b;
    private static final boolean c;
    private static final boolean d;
    private static final d e;
    private static final boolean f;
    private static final boolean g;
    private static final long h;
    private static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final int v;
    static final boolean w;

    private static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final byte a(Object obj, long j) {
            return i1.w ? i1.L(obj, j) : i1.M(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void b(Object obj, long j, byte b) {
            if (i1.w) {
                i1.u(obj, j, b);
            } else {
                i1.y(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void g(Object obj, long j, boolean z) {
            if (i1.w) {
                i1.z(obj, j, z);
            } else {
                i1.D(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final boolean h(Object obj, long j) {
            return i1.w ? i1.N(obj, j) : i1.O(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    private static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final byte a(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void b(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void c(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void d(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void g(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final boolean h(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final float i(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final double j(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }
    }

    private static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final byte a(Object obj, long j) {
            return i1.w ? i1.L(obj, j) : i1.M(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void b(Object obj, long j, byte b) {
            if (i1.w) {
                i1.u(obj, j, b);
            } else {
                i1.y(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final void g(Object obj, long j, boolean z) {
            if (i1.w) {
                i1.z(obj, j, z);
            } else {
                i1.D(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final boolean h(Object obj, long j) {
            return i1.w ? i1.N(obj, j) : i1.O(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final float i(Object obj, long j) {
            return Float.intBitsToFloat(k(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.i1.d
        public final double j(Object obj, long j) {
            return Double.longBitsToDouble(l(obj, j));
        }
    }

    private static abstract class d {
        Unsafe a;

        d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void b(Object obj, long j, byte b);

        public abstract void c(Object obj, long j, double d);

        public abstract void d(Object obj, long j, float f);

        public final void e(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract boolean h(Object obj, long j);

        public abstract float i(Object obj, long j);

        public abstract double j(Object obj, long j);

        public final int k(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long l(Object obj, long j) {
            return this.a.getLong(obj, j);
        }
    }

    static {
        Unsafe unsafeT = t();
        a = unsafeT;
        b = E.c();
        boolean zB = B(Long.TYPE);
        c = zB;
        boolean zB2 = B(Integer.TYPE);
        d = zB2;
        d bVar = null;
        if (unsafeT != null) {
            if (!E.b()) {
                bVar = new b(unsafeT);
            } else if (zB) {
                bVar = new c(unsafeT);
            } else if (zB2) {
                bVar = new a(unsafeT);
            }
        }
        e = bVar;
        f = E();
        g = A();
        long jN = n(byte[].class);
        h = jN;
        i = n(boolean[].class);
        j = s(boolean[].class);
        k = n(int[].class);
        l = s(int[].class);
        m = n(long[].class);
        n = s(long[].class);
        o = n(float[].class);
        p = s(float[].class);
        q = n(double[].class);
        r = s(double[].class);
        s = n(Object[].class);
        t = s(Object[].class);
        Field fieldG = G();
        u = (fieldG == null || bVar == null) ? -1L : bVar.a.objectFieldOffset(fieldG);
        v = (int) (jN & 7);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private static boolean A() {
        Unsafe unsafe = a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (E.b()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(i1.class.getName());
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean B(Class cls) {
        if (!E.b()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static double C(Object obj, long j2) {
        return e.j(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(Object obj, long j2, boolean z) {
        y(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    private static boolean E() {
        Unsafe unsafe = a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (G() == null) {
                return false;
            }
            if (E.b()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(i1.class.getName());
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    static Object F(Object obj, long j2) {
        return e.a.getObject(obj, j2);
    }

    private static Field G() {
        Field fieldD;
        if (E.b() && (fieldD = d(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldD;
        }
        Field fieldD2 = d(Buffer.class, "address");
        if (fieldD2 == null || fieldD2.getType() != Long.TYPE) {
            return null;
        }
        return fieldD2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte L(Object obj, long j2) {
        return (byte) (b(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte M(Object obj, long j2) {
        return (byte) (b(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean N(Object obj, long j2) {
        return L(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O(Object obj, long j2) {
        return M(obj, j2) != 0;
    }

    static byte a(byte[] bArr, long j2) {
        return e.a(bArr, h + j2);
    }

    static int b(Object obj, long j2) {
        return e.k(obj, j2);
    }

    static Object c(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static Field d(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static void f(Object obj, long j2, double d2) {
        e.c(obj, j2, d2);
    }

    static void g(Object obj, long j2, float f2) {
        e.d(obj, j2, f2);
    }

    static void h(Object obj, long j2, int i2) {
        e.e(obj, j2, i2);
    }

    static void i(Object obj, long j2, long j3) {
        e.f(obj, j2, j3);
    }

    static void j(Object obj, long j2, Object obj2) {
        e.a.putObject(obj, j2, obj2);
    }

    static void k(Object obj, long j2, boolean z) {
        e.g(obj, j2, z);
    }

    static void l(byte[] bArr, long j2, byte b2) {
        e.b(bArr, h + j2, b2);
    }

    static boolean m() {
        return g;
    }

    private static int n(Class cls) {
        if (g) {
            return e.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    static long o(Object obj, long j2) {
        return e.l(obj, j2);
    }

    static boolean r() {
        return f;
    }

    private static int s(Class cls) {
        if (g) {
            return e.a.arrayIndexScale(cls);
        }
        return -1;
    }

    static Unsafe t() {
        try {
            return (Unsafe) AccessController.doPrivileged(new j1());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iB = b(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        h(obj, j3, ((255 & b2) << i2) | (iB & (~(255 << i2))));
    }

    static boolean w(Object obj, long j2) {
        return e.h(obj, j2);
    }

    static float x(Object obj, long j2) {
        return e.i(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        h(obj, j3, ((255 & b2) << i2) | (b(obj, j3) & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Object obj, long j2, boolean z) {
        u(obj, j2, z ? (byte) 1 : (byte) 0);
    }
}
