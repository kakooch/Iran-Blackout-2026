package com.google.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
abstract class o0 {
    private static final Unsafe a = H();
    private static final Class b = AbstractC2380d.b();
    private static final boolean c = q(Long.TYPE);
    private static final boolean d = q(Integer.TYPE);
    private static final e e = F();
    private static final boolean f = X();
    private static final boolean g = W();
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
            for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
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

        @Override // com.google.protobuf.o0.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.o0.e
        public boolean d(Object obj, long j) {
            return o0.w ? o0.u(obj, j) : o0.v(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public byte e(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.o0.e
        public byte f(Object obj, long j) {
            return o0.w ? o0.y(obj, j) : o0.z(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public double g(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // com.google.protobuf.o0.e
        public float h(Object obj, long j) {
            return Float.intBitsToFloat(i(obj, j));
        }

        @Override // com.google.protobuf.o0.e
        public long j(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.o0.e
        public void n(Object obj, long j, boolean z) {
            if (o0.w) {
                o0.M(obj, j, z);
            } else {
                o0.N(obj, j, z);
            }
        }

        @Override // com.google.protobuf.o0.e
        public void o(Object obj, long j, byte b) {
            if (o0.w) {
                o0.P(obj, j, b);
            } else {
                o0.Q(obj, j, b);
            }
        }

        @Override // com.google.protobuf.o0.e
        public void p(Object obj, long j, double d) {
            s(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.protobuf.o0.e
        public void q(Object obj, long j, float f) {
            r(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.protobuf.o0.e
        public boolean v() {
            return false;
        }
    }

    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.o0.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.o0.e
        public boolean d(Object obj, long j) {
            return o0.w ? o0.u(obj, j) : o0.v(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public byte e(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.o0.e
        public byte f(Object obj, long j) {
            return o0.w ? o0.y(obj, j) : o0.z(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public double g(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // com.google.protobuf.o0.e
        public float h(Object obj, long j) {
            return Float.intBitsToFloat(i(obj, j));
        }

        @Override // com.google.protobuf.o0.e
        public long j(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.o0.e
        public void n(Object obj, long j, boolean z) {
            if (o0.w) {
                o0.M(obj, j, z);
            } else {
                o0.N(obj, j, z);
            }
        }

        @Override // com.google.protobuf.o0.e
        public void o(Object obj, long j, byte b) {
            if (o0.w) {
                o0.P(obj, j, b);
            } else {
                o0.Q(obj, j, b);
            }
        }

        @Override // com.google.protobuf.o0.e
        public void p(Object obj, long j, double d) {
            s(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.protobuf.o0.e
        public void q(Object obj, long j, float f) {
            r(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.protobuf.o0.e
        public boolean v() {
            return false;
        }
    }

    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.o0.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            this.a.copyMemory((Object) null, j, bArr, o0.h + j2, j3);
        }

        @Override // com.google.protobuf.o0.e
        public boolean d(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public byte e(long j) {
            return this.a.getByte(j);
        }

        @Override // com.google.protobuf.o0.e
        public byte f(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public double g(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public float h(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // com.google.protobuf.o0.e
        public long j(long j) {
            return this.a.getLong(j);
        }

        @Override // com.google.protobuf.o0.e
        public void n(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // com.google.protobuf.o0.e
        public void o(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // com.google.protobuf.o0.e
        public void p(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // com.google.protobuf.o0.e
        public void q(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // com.google.protobuf.o0.e
        public boolean u() {
            if (!super.u()) {
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
                o0.K(th);
                return false;
            }
        }

        @Override // com.google.protobuf.o0.e
        public boolean v() {
            if (!super.v()) {
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
                o0.K(th);
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

        public abstract void c(long j, byte[] bArr, long j2, long j3);

        public abstract boolean d(Object obj, long j);

        public abstract byte e(long j);

        public abstract byte f(Object obj, long j);

        public abstract double g(Object obj, long j);

        public abstract float h(Object obj, long j);

        public final int i(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public abstract long j(long j);

        public final long k(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public final Object l(Object obj, long j) {
            return this.a.getObject(obj, j);
        }

        public final long m(java.lang.reflect.Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j, boolean z);

        public abstract void o(Object obj, long j, byte b);

        public abstract void p(Object obj, long j, double d);

        public abstract void q(Object obj, long j, float f);

        public final void r(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void s(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public final void t(Object obj, long j, Object obj2) {
            this.a.putObject(obj, j, obj2);
        }

        public boolean u() {
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
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
                o0.K(th);
                return false;
            }
        }

        public boolean v() {
            Unsafe unsafe = this.a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return o0.o() != null;
            } catch (Throwable th) {
                o0.K(th);
                return false;
            }
        }
    }

    static {
        long jM = m(byte[].class);
        h = jM;
        i = m(boolean[].class);
        j = n(boolean[].class);
        k = m(int[].class);
        l = n(int[].class);
        m = m(long[].class);
        n = n(long[].class);
        o = m(float[].class);
        p = n(float[].class);
        q = m(double[].class);
        r = n(double[].class);
        s = m(Object[].class);
        t = n(Object[].class);
        u = s(o());
        v = (int) (jM & 7);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static double A(Object obj, long j2) {
        return e.g(obj, j2);
    }

    static float B(Object obj, long j2) {
        return e.h(obj, j2);
    }

    static int C(Object obj, long j2) {
        return e.i(obj, j2);
    }

    static long D(long j2) {
        return e.j(j2);
    }

    static long E(Object obj, long j2) {
        return e.k(obj, j2);
    }

    private static e F() {
        Unsafe unsafe = a;
        if (unsafe == null) {
            return null;
        }
        if (!AbstractC2380d.c()) {
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

    static Object G(Object obj, long j2) {
        return e.l(obj, j2);
    }

    static Unsafe H() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean I() {
        return g;
    }

    static boolean J() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(Throwable th) {
        Logger.getLogger(o0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static void L(Object obj, long j2, boolean z) {
        e.n(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(Object obj, long j2, boolean z) {
        P(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(Object obj, long j2, boolean z) {
        Q(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static void O(byte[] bArr, long j2, byte b2) {
        e.o(bArr, h + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int iC = C(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        T(obj, j3, ((255 & b2) << i2) | (iC & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        T(obj, j3, ((255 & b2) << i2) | (C(obj, j3) & (~(255 << i2))));
    }

    static void R(Object obj, long j2, double d2) {
        e.p(obj, j2, d2);
    }

    static void S(Object obj, long j2, float f2) {
        e.q(obj, j2, f2);
    }

    static void T(Object obj, long j2, int i2) {
        e.r(obj, j2, i2);
    }

    static void U(Object obj, long j2, long j3) {
        e.s(obj, j2, j3);
    }

    static void V(Object obj, long j2, Object obj2) {
        e.t(obj, j2, obj2);
    }

    private static boolean W() {
        e eVar = e;
        if (eVar == null) {
            return false;
        }
        return eVar.u();
    }

    private static boolean X() {
        e eVar = e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    static long k(ByteBuffer byteBuffer) {
        return e.k(byteBuffer, u);
    }

    static Object l(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int m(Class cls) {
        if (g) {
            return e.a(cls);
        }
        return -1;
    }

    private static int n(Class cls) {
        if (g) {
            return e.b(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Field o() {
        java.lang.reflect.Field fieldR;
        if (AbstractC2380d.c() && (fieldR = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldR;
        }
        java.lang.reflect.Field fieldR2 = r(Buffer.class, "address");
        if (fieldR2 == null || fieldR2.getType() != Long.TYPE) {
            return null;
        }
        return fieldR2;
    }

    static void p(long j2, byte[] bArr, long j3, long j4) {
        e.c(j2, bArr, j3, j4);
    }

    static boolean q(Class cls) {
        if (!AbstractC2380d.c()) {
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

    private static java.lang.reflect.Field r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long s(java.lang.reflect.Field field) {
        e eVar;
        if (field == null || (eVar = e) == null) {
            return -1L;
        }
        return eVar.m(field);
    }

    static boolean t(Object obj, long j2) {
        return e.d(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Object obj, long j2) {
        return y(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j2) {
        return z(obj, j2) != 0;
    }

    static byte w(long j2) {
        return e.e(j2);
    }

    static byte x(byte[] bArr, long j2) {
        return e.f(bArr, h + j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte y(Object obj, long j2) {
        return (byte) ((C(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j2) {
        return (byte) ((C(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }
}
