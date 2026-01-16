package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
abstract class o0 {
    private static final Logger a = Logger.getLogger(o0.class.getName());
    private static final Unsafe b;
    private static final Class c;
    private static final boolean d;
    private static final boolean e;
    private static final d f;
    private static final boolean g;
    private static final boolean h;
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
    private static final long v;
    private static final long w;
    private static final boolean x;

    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void b(long j, byte b) {
            Memory.pokeByte((int) j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void g(Object obj, long j, boolean z) {
            if (o0.x) {
                o0.r(obj, j, z);
            } else {
                o0.t(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) j2, bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void i(Object obj, long j, byte b) {
            if (o0.x) {
                o0.d(obj, j, b);
            } else {
                o0.q(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final boolean l(Object obj, long j) {
            return o0.x ? o0.P(obj, j) : o0.Q(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final byte o(Object obj, long j) {
            return o0.x ? o0.N(obj, j) : o0.O(obj, j);
        }
    }

    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void b(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void c(Object obj, long j, double d) {
            f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void d(Object obj, long j, float f) {
            e(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void g(Object obj, long j, boolean z) {
            if (o0.x) {
                o0.r(obj, j, z);
            } else {
                o0.t(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void i(Object obj, long j, byte b) {
            if (o0.x) {
                o0.d(obj, j, b);
            } else {
                o0.q(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final boolean l(Object obj, long j) {
            return o0.x ? o0.P(obj, j) : o0.Q(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final byte o(Object obj, long j) {
            return o0.x ? o0.N(obj, j) : o0.O(obj, j);
        }
    }

    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void b(long j, byte b) {
            this.a.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void c(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void d(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void g(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            this.a.copyMemory(bArr, o0.i + j, (Object) null, j2, j3);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final void i(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final boolean l(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final float m(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final double n(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.clearcut.o0.d
        public final byte o(Object obj, long j) {
            return this.a.getByte(obj, j);
        }
    }

    static abstract class d {
        Unsafe a;

        d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final long a(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void b(long j, byte b);

        public abstract void c(Object obj, long j, double d);

        public abstract void d(Object obj, long j, float f);

        public final void e(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract void h(byte[] bArr, long j, long j2, long j3);

        public abstract void i(Object obj, long j, byte b);

        public final int j(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long k(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public abstract boolean l(Object obj, long j);

        public abstract float m(Object obj, long j);

        public abstract double n(Object obj, long j);

        public abstract byte o(Object obj, long j);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x002b  */
    static {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.o0.<clinit>():void");
    }

    private static boolean A() {
        Unsafe unsafe = b;
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
            if (AbstractC2075c.b()) {
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
            Logger logger = a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean B() {
        Unsafe unsafe = b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (C() == null) {
                return false;
            }
            if (AbstractC2075c.b()) {
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
            Logger logger = a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field C() {
        Field fieldP;
        if (AbstractC2075c.b() && (fieldP = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldP;
        }
        Field fieldP2 = p(Buffer.class, "address");
        if (fieldP2 == null || fieldP2.getType() != Long.TYPE) {
            return null;
        }
        return fieldP2;
    }

    private static int E(Class cls) {
        if (h) {
            return f.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int F(Class cls) {
        if (h) {
            return f.a.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean G(Class cls) {
        if (!AbstractC2075c.b()) {
            return false;
        }
        try {
            Class cls2 = c;
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

    static int H(Object obj, long j2) {
        return f.j(obj, j2);
    }

    static long I(Object obj, long j2) {
        return f.k(obj, j2);
    }

    static boolean J(Object obj, long j2) {
        return f.l(obj, j2);
    }

    static float K(Object obj, long j2) {
        return f.m(obj, j2);
    }

    static double L(Object obj, long j2) {
        return f.n(obj, j2);
    }

    static Object M(Object obj, long j2) {
        return f.a.getObject(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte N(Object obj, long j2) {
        return (byte) (H(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte O(Object obj, long j2) {
        return (byte) (H(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(Object obj, long j2) {
        return N(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Q(Object obj, long j2) {
        return O(obj, j2) != 0;
    }

    static byte a(byte[] bArr, long j2) {
        return f.o(bArr, i + j2);
    }

    static long b(Field field) {
        return f.a(field);
    }

    static void c(long j2, byte b2) {
        f.b(j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iH = H(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        g(obj, j3, ((255 & b2) << i2) | (iH & (~(255 << i2))));
    }

    static void e(Object obj, long j2, double d2) {
        f.c(obj, j2, d2);
    }

    static void f(Object obj, long j2, float f2) {
        f.d(obj, j2, f2);
    }

    static void g(Object obj, long j2, int i2) {
        f.e(obj, j2, i2);
    }

    static void h(Object obj, long j2, long j3) {
        f.f(obj, j2, j3);
    }

    static void i(Object obj, long j2, Object obj2) {
        f.a.putObject(obj, j2, obj2);
    }

    static void j(Object obj, long j2, boolean z) {
        f.g(obj, j2, z);
    }

    static void k(byte[] bArr, long j2, byte b2) {
        f.i(bArr, i + j2, b2);
    }

    static void l(byte[] bArr, long j2, long j3, long j4) {
        f.h(bArr, j2, j3, j4);
    }

    private static long n(Field field) {
        d dVar;
        if (field == null || (dVar = f) == null) {
            return -1L;
        }
        return dVar.a(field);
    }

    static long o(ByteBuffer byteBuffer) {
        return f.k(byteBuffer, v);
    }

    private static Field p(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        g(obj, j3, ((255 & b2) << i2) | (H(obj, j3) & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(Object obj, long j2, boolean z) {
        q(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static boolean x() {
        return h;
    }

    static boolean y() {
        return g;
    }

    static Unsafe z() {
        try {
            return (Unsafe) AccessController.doPrivileged(new p0());
        } catch (Throwable unused) {
            return null;
        }
    }
}
