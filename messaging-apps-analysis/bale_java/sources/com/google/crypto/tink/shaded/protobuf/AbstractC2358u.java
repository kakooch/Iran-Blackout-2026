package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2339a;
import com.google.crypto.tink.shaded.protobuf.AbstractC2343e;
import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.crypto.tink.shaded.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2358u extends AbstractC2339a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC2358u> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected b0 unknownFields = b0.c();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.u$a */
    public static abstract class a extends AbstractC2339a.AbstractC0195a {
        private final AbstractC2358u a;
        protected AbstractC2358u b;

        protected a(AbstractC2358u abstractC2358u) {
            this.a = abstractC2358u;
            if (abstractC2358u.A()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.b = o();
        }

        private static void n(Object obj, Object obj2) {
            Q.a().d(obj).a(obj, obj2);
        }

        private AbstractC2358u o() {
            return this.a.G();
        }

        public final AbstractC2358u e() {
            AbstractC2358u abstractC2358uF = f();
            if (abstractC2358uF.y()) {
                return abstractC2358uF;
            }
            throw AbstractC2339a.AbstractC0195a.d(abstractC2358uF);
        }

        public AbstractC2358u f() {
            if (!this.b.A()) {
                return this.b;
            }
            this.b.B();
            return this.b;
        }

        public a h() {
            a aVarE = l().E();
            aVarE.b = f();
            return aVarE;
        }

        protected final void i() {
            if (this.b.A()) {
                return;
            }
            k();
        }

        protected void k() {
            AbstractC2358u abstractC2358uO = o();
            n(abstractC2358uO, this.b);
            this.b = abstractC2358uO;
        }

        public AbstractC2358u l() {
            return this.a;
        }

        public a m(AbstractC2358u abstractC2358u) {
            if (l().equals(abstractC2358u)) {
                return this;
            }
            i();
            n(this.b, abstractC2358u);
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.u$b */
    protected static class b extends AbstractC2340b {
        private final AbstractC2358u b;

        public b(AbstractC2358u abstractC2358u) {
            this.b = abstractC2358u;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.u$c */
    public static class c extends AbstractC2350l {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.u$d */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected static AbstractC2360w.d D(AbstractC2360w.d dVar) {
        int size = dVar.size();
        return dVar.b(size == 0 ? 10 : size * 2);
    }

    protected static Object F(I i, String str, Object[] objArr) {
        return new T(i, str, objArr);
    }

    protected static AbstractC2358u H(AbstractC2358u abstractC2358u, AbstractC2345g abstractC2345g, C2352n c2352n) {
        return h(K(abstractC2358u, abstractC2345g, c2352n));
    }

    protected static AbstractC2358u I(AbstractC2358u abstractC2358u, InputStream inputStream, C2352n c2352n) {
        return h(L(abstractC2358u, AbstractC2346h.f(inputStream), c2352n));
    }

    protected static AbstractC2358u J(AbstractC2358u abstractC2358u, byte[] bArr, C2352n c2352n) {
        return h(M(abstractC2358u, bArr, 0, bArr.length, c2352n));
    }

    private static AbstractC2358u K(AbstractC2358u abstractC2358u, AbstractC2345g abstractC2345g, C2352n c2352n) throws InvalidProtocolBufferException {
        AbstractC2346h abstractC2346hQ = abstractC2345g.Q();
        AbstractC2358u abstractC2358uL = L(abstractC2358u, abstractC2346hQ, c2352n);
        try {
            abstractC2346hQ.a(0);
            return abstractC2358uL;
        } catch (InvalidProtocolBufferException e) {
            throw e.m(abstractC2358uL);
        }
    }

    static AbstractC2358u L(AbstractC2358u abstractC2358u, AbstractC2346h abstractC2346h, C2352n c2352n) throws InvalidProtocolBufferException {
        AbstractC2358u abstractC2358uG = abstractC2358u.G();
        try {
            V vD = Q.a().d(abstractC2358uG);
            vD.i(abstractC2358uG, C2347i.N(abstractC2346h), c2352n);
            vD.e(abstractC2358uG);
            return abstractC2358uG;
        } catch (InvalidProtocolBufferException e) {
            e = e;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.m(abstractC2358uG);
        } catch (UninitializedMessageException e2) {
            throw e2.a().m(abstractC2358uG);
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3).m(abstractC2358uG);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw e4;
        }
    }

    private static AbstractC2358u M(AbstractC2358u abstractC2358u, byte[] bArr, int i, int i2, C2352n c2352n) throws InvalidProtocolBufferException {
        AbstractC2358u abstractC2358uG = abstractC2358u.G();
        try {
            V vD = Q.a().d(abstractC2358uG);
            vD.h(abstractC2358uG, bArr, i, i + i2, new AbstractC2343e.a(c2352n));
            vD.e(abstractC2358uG);
            return abstractC2358uG;
        } catch (InvalidProtocolBufferException e) {
            e = e;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.m(abstractC2358uG);
        } catch (UninitializedMessageException e2) {
            throw e2.a().m(abstractC2358uG);
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3).m(abstractC2358uG);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.p().m(abstractC2358uG);
        }
    }

    protected static void N(Class cls, AbstractC2358u abstractC2358u) {
        abstractC2358u.C();
        defaultInstanceMap.put(cls, abstractC2358u);
    }

    private static AbstractC2358u h(AbstractC2358u abstractC2358u) throws InvalidProtocolBufferException {
        if (abstractC2358u == null || abstractC2358u.y()) {
            return abstractC2358u;
        }
        throw abstractC2358u.e().a().m(abstractC2358u);
    }

    private int m(V v) {
        return v == null ? Q.a().d(this).g(this) : v.g(this);
    }

    protected static AbstractC2360w.d r() {
        return S.i();
    }

    static AbstractC2358u s(Class cls) throws ClassNotFoundException {
        AbstractC2358u abstractC2358uT = defaultInstanceMap.get(cls);
        if (abstractC2358uT == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC2358uT = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC2358uT == null) {
            abstractC2358uT = ((AbstractC2358u) d0.k(cls)).t();
            if (abstractC2358uT == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, abstractC2358uT);
        }
        return abstractC2358uT;
    }

    static Object x(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final boolean z(AbstractC2358u abstractC2358u, boolean z) {
        byte bByteValue = ((Byte) abstractC2358u.o(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zF = Q.a().d(abstractC2358u).f(abstractC2358u);
        if (z) {
            abstractC2358u.p(d.SET_MEMOIZED_IS_INITIALIZED, zF ? abstractC2358u : null);
        }
        return zF;
    }

    boolean A() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    protected void B() {
        Q.a().d(this).e(this);
        C();
    }

    void C() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final a E() {
        return (a) o(d.NEW_BUILDER);
    }

    AbstractC2358u G() {
        return (AbstractC2358u) o(d.NEW_MUTABLE_INSTANCE);
    }

    void O(int i) {
        this.memoizedHashCode = i;
    }

    void P(int i) {
        if (i >= 0) {
            this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
    }

    public final a Q() {
        return ((a) o(d.NEW_BUILDER)).m(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2339a
    int a(V v) {
        if (!A()) {
            if (v() != Integer.MAX_VALUE) {
                return v();
            }
            int iM = m(v);
            P(iM);
            return iM;
        }
        int iM2 = m(v);
        if (iM2 >= 0) {
            return iM2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iM2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.I
    public void c(CodedOutputStream codedOutputStream) {
        Q.a().d(this).j(this, C2348j.P(codedOutputStream));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Q.a().d(this).c(this, (AbstractC2358u) obj);
        }
        return false;
    }

    Object g() {
        return o(d.BUILD_MESSAGE_INFO);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.I
    public int getSerializedSize() {
        return a(null);
    }

    public int hashCode() {
        if (A()) {
            return l();
        }
        if (w()) {
            O(l());
        }
        return u();
    }

    void i() {
        this.memoizedHashCode = 0;
    }

    void k() {
        P(Integer.MAX_VALUE);
    }

    int l() {
        return Q.a().d(this).b(this);
    }

    protected final a n() {
        return (a) o(d.NEW_BUILDER);
    }

    protected Object o(d dVar) {
        return q(dVar, null, null);
    }

    protected Object p(d dVar, Object obj) {
        return q(dVar, obj, null);
    }

    protected abstract Object q(d dVar, Object obj, Object obj2);

    public final AbstractC2358u t() {
        return (AbstractC2358u) o(d.GET_DEFAULT_INSTANCE);
    }

    public String toString() {
        return J.f(this, super.toString());
    }

    int u() {
        return this.memoizedHashCode;
    }

    int v() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    boolean w() {
        return u() == 0;
    }

    public final boolean y() {
        return z(this, true);
    }
}
