package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
abstract class d0 {
    private static final Unsafe a = D();
    private static final Class b = AbstractC2342d.b();
    private static final boolean c = o(Long.TYPE);
    private static final boolean d = o(Integer.TYPE);
    private static final e e = B();
    private static final boolean f = T();
    private static final boolean g = S();
    static final long h;
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

    class a implements PrivilegedExceptionAction {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws IllegalAccessException, SecurityException, IllegalArgumentException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    private static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public boolean c(Object obj, long j) {
            return d0.w ? d0.s(obj, j) : d0.t(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public byte d(Object obj, long j) {
            return d0.w ? d0.v(obj, j) : d0.w(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void k(Object obj, long j, boolean z) {
            if (d0.w) {
                d0.I(obj, j, z);
            } else {
                d0.J(obj, j, z);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void l(Object obj, long j, byte b) {
            if (d0.w) {
                d0.L(obj, j, b);
            } else {
                d0.M(obj, j, b);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public boolean s() {
            return false;
        }
    }

    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public boolean c(Object obj, long j) {
            return d0.w ? d0.s(obj, j) : d0.t(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public byte d(Object obj, long j) {
            return d0.w ? d0.v(obj, j) : d0.w(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void k(Object obj, long j, boolean z) {
            if (d0.w) {
                d0.I(obj, j, z);
            } else {
                d0.J(obj, j, z);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void l(Object obj, long j, byte b) {
            if (d0.w) {
                d0.L(obj, j, b);
            } else {
                d0.M(obj, j, b);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public boolean s() {
            return false;
        }
    }

    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public boolean c(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public byte d(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public double e(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public float f(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void k(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void l(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void m(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public void n(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public boolean r() {
            if (!super.r()) {
                return false;
            }
            try {
                Class<?> cls = this.a.getClass();
                Class cls2 = Long.TYPE;
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
                d0.G(th);
                return false;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.d0.e
        public boolean s() {
            if (!super.s()) {
                return false;
            }
            try {
                Class<?> cls = this.a.getClass();
                Class cls2 = Long.TYPE;
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
                d0.G(th);
                return false;
            }
        }
    }

    private static abstract class e {
        Unsafe a;

        e(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final int a(Class cls) {
            return this.a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j);

        public abstract byte d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract float f(Object obj, long j);

        public final int g(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public final Object i(Object obj, long j) {
            return this.a.getObject(obj, j);
        }

        public final long j(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j, boolean z);

        public abstract void l(Object obj, long j, byte b);

        public abstract void m(Object obj, long j, double d);

        public abstract void n(Object obj, long j, float f);

        public final void o(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void p(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public final void q(Object obj, long j, Object obj2) {
            this.a.putObject(obj, j, obj2);
        }

        public boolean r() {
            Unsafe unsafe = this.a;
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
                return true;
            } catch (Throwable th) {
                d0.G(th);
                return false;
            }
        }

        public boolean s() {
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return d0.n() != null;
            } catch (Throwable th) {
                d0.G(th);
                return false;
            }
        }
    }

    static {
        long jL = l(byte[].class);
        h = jL;
        i = l(boolean[].class);
        j = m(boolean[].class);
        k = l(int[].class);
        l = m(int[].class);
        m = l(long[].class);
        n = m(long[].class);
        o = l(float[].class);
        p = m(float[].class);
        q = l(double[].class);
        r = m(double[].class);
        s = l(Object[].class);
        t = m(Object[].class);
        u = q(n());
        v = (int) (jL & 7);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static long A(Object obj, long j2) {
        return e.h(obj, j2);
    }

    private static e B() {
        Unsafe unsafe = a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC2342d.c()) {
            return new d(unsafe);
        }
        if (c) {
            return new c(unsafe);
        }
        if (d) {
            return new b(unsafe);
        }
        return null;
    }

    static Object C(Object obj, long j2) {
        return e.i(obj, j2);
    }

    static Unsafe D() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean E() {
        return g;
    }

    static boolean F() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Throwable th) {
        Logger.getLogger(d0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static void H(Object obj, long j2, boolean z) {
        e.k(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(Object obj, long j2, boolean z) {
        L(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(Object obj, long j2, boolean z) {
        M(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static void K(byte[] bArr, long j2, byte b2) {
        e.l(bArr, h + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iZ = z(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        P(obj, j3, ((255 & b2) << i2) | (iZ & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        P(obj, j3, ((255 & b2) << i2) | (z(obj, j3) & (~(255 << i2))));
    }

    static void N(Object obj, long j2, double d2) {
        e.m(obj, j2, d2);
    }

    static void O(Object obj, long j2, float f2) {
        e.n(obj, j2, f2);
    }

    static void P(Object obj, long j2, int i2) {
        e.o(obj, j2, i2);
    }

    static void Q(Object obj, long j2, long j3) {
        e.p(obj, j2, j3);
    }

    static void R(Object obj, long j2, Object obj2) {
        e.q(obj, j2, obj2);
    }

    private static boolean S() {
        e eVar = e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    private static boolean T() {
        e eVar = e;
        if (eVar == null) {
            return false;
        }
        return eVar.s();
    }

    static Object k(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int l(Class cls) {
        if (g) {
            return e.a(cls);
        }
        return -1;
    }

    private static int m(Class cls) {
        if (g) {
            return e.b(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field n() {
        Field fieldP;
        if (AbstractC2342d.c() && (fieldP = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldP;
        }
        Field fieldP2 = p(Buffer.class, "address");
        if (fieldP2 == null || fieldP2.getType() != Long.TYPE) {
            return null;
        }
        return fieldP2;
    }

    static boolean o(Class cls) {
        if (!AbstractC2342d.c()) {
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

    private static Field p(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long q(Field field) {
        e eVar;
        if (field == null || (eVar = e) == null) {
            return -1L;
        }
        return eVar.j(field);
    }

    static boolean r(Object obj, long j2) {
        return e.c(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(Object obj, long j2) {
        return v(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(Object obj, long j2) {
        return w(obj, j2) != 0;
    }

    static byte u(byte[] bArr, long j2) {
        return e.d(bArr, h + j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte v(Object obj, long j2) {
        return (byte) ((z(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte w(Object obj, long j2) {
        return (byte) ((z(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    static double x(Object obj, long j2) {
        return e.e(obj, j2);
    }

    static float y(Object obj, long j2) {
        return e.f(obj, j2);
    }

    static int z(Object obj, long j2) {
        return e.g(obj, j2);
    }
}
