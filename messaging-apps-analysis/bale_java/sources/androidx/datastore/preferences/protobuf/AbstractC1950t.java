package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1932a;
import androidx.datastore.preferences.protobuf.AbstractC1952v;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1950t extends AbstractC1932a {
    private static Map<Object, AbstractC1950t> defaultInstanceMap = new ConcurrentHashMap();
    protected c0 unknownFields = c0.e();
    protected int memoizedSerializedSize = -1;

    /* renamed from: androidx.datastore.preferences.protobuf.t$a */
    public static abstract class a extends AbstractC1932a.AbstractC0080a {
        private final AbstractC1950t a;
        protected AbstractC1950t b;
        protected boolean c = false;

        protected a(AbstractC1950t abstractC1950t) {
            this.a = abstractC1950t;
            this.b = (AbstractC1950t) abstractC1950t.l(d.NEW_MUTABLE_INSTANCE);
        }

        private void q(AbstractC1950t abstractC1950t, AbstractC1950t abstractC1950t2) {
            Q.a().d(abstractC1950t).a(abstractC1950t, abstractC1950t2);
        }

        public final AbstractC1950t i() {
            AbstractC1950t abstractC1950tJ = j();
            if (abstractC1950tJ.s()) {
                return abstractC1950tJ;
            }
            throw AbstractC1932a.AbstractC0080a.h(abstractC1950tJ);
        }

        @Override // androidx.datastore.preferences.protobuf.I.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public AbstractC1950t j() {
            if (this.c) {
                return this.b;
            }
            this.b.u();
            this.c = true;
            return this.b;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVarNewBuilderForType = getDefaultInstanceForType().newBuilderForType();
            aVarNewBuilderForType.p(j());
            return aVarNewBuilderForType;
        }

        protected void m() {
            if (this.c) {
                AbstractC1950t abstractC1950t = (AbstractC1950t) this.b.l(d.NEW_MUTABLE_INSTANCE);
                q(abstractC1950t, this.b);
                this.b = abstractC1950t;
                this.c = false;
            }
        }

        @Override // ir.nasim.W64
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public AbstractC1950t getDefaultInstanceForType() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.datastore.preferences.protobuf.AbstractC1932a.AbstractC0080a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a e(AbstractC1950t abstractC1950t) {
            return p(abstractC1950t);
        }

        public a p(AbstractC1950t abstractC1950t) {
            m();
            q(this.b, abstractC1950t);
            return this;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.t$b */
    protected static class b extends AbstractC1933b {
        private final AbstractC1950t b;

        public b(AbstractC1950t abstractC1950t) {
            this.b = abstractC1950t;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.t$c */
    public static class c extends AbstractC1942k {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.t$d */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected static void A(Class cls, AbstractC1950t abstractC1950t) {
        defaultInstanceMap.put(cls, abstractC1950t);
    }

    private static AbstractC1950t i(AbstractC1950t abstractC1950t) throws InvalidProtocolBufferException {
        if (abstractC1950t == null || abstractC1950t.s()) {
            return abstractC1950t;
        }
        throw abstractC1950t.e().a().k(abstractC1950t);
    }

    protected static AbstractC1952v.b o() {
        return S.i();
    }

    static AbstractC1950t p(Class cls) throws ClassNotFoundException {
        AbstractC1950t defaultInstanceForType = defaultInstanceMap.get(cls);
        if (defaultInstanceForType == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                defaultInstanceForType = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (defaultInstanceForType == null) {
            defaultInstanceForType = ((AbstractC1950t) e0.i(cls)).getDefaultInstanceForType();
            if (defaultInstanceForType == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, defaultInstanceForType);
        }
        return defaultInstanceForType;
    }

    static Object r(Method method, Object obj, Object... objArr) {
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

    protected static final boolean t(AbstractC1950t abstractC1950t, boolean z) {
        byte bByteValue = ((Byte) abstractC1950t.l(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zF = Q.a().d(abstractC1950t).f(abstractC1950t);
        if (z) {
            abstractC1950t.m(d.SET_MEMOIZED_IS_INITIALIZED, zF ? abstractC1950t : null);
        }
        return zF;
    }

    protected static AbstractC1952v.b v(AbstractC1952v.b bVar) {
        int size = bVar.size();
        return bVar.b(size == 0 ? 10 : size * 2);
    }

    protected static Object x(I i, String str, Object[] objArr) {
        return new T(i, str, objArr);
    }

    protected static AbstractC1950t y(AbstractC1950t abstractC1950t, InputStream inputStream) {
        return i(z(abstractC1950t, AbstractC1938g.f(inputStream), C1944m.b()));
    }

    static AbstractC1950t z(AbstractC1950t abstractC1950t, AbstractC1938g abstractC1938g, C1944m c1944m) throws InvalidProtocolBufferException {
        AbstractC1950t abstractC1950t2 = (AbstractC1950t) abstractC1950t.l(d.NEW_MUTABLE_INSTANCE);
        try {
            V vD = Q.a().d(abstractC1950t2);
            vD.h(abstractC1950t2, C1939h.N(abstractC1938g), c1944m);
            vD.e(abstractC1950t2);
            return abstractC1950t2;
        } catch (IOException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw new InvalidProtocolBufferException(e.getMessage()).k(abstractC1950t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.I
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final a toBuilder() {
        a aVar = (a) l(d.NEW_BUILDER);
        aVar.p(this);
        return aVar;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public void b(CodedOutputStream codedOutputStream) {
        Q.a().d(this).i(this, C1940i.P(codedOutputStream));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1932a
    int c() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getDefaultInstanceForType().getClass().isInstance(obj)) {
            return Q.a().d(this).c(this, (AbstractC1950t) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1932a
    void f(int i) {
        this.memoizedSerializedSize = i;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Q.a().d(this).g(this);
        }
        return this.memoizedSerializedSize;
    }

    Object h() {
        return l(d.BUILD_MESSAGE_INFO);
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iB = Q.a().d(this).b(this);
        this.memoizedHashCode = iB;
        return iB;
    }

    protected final a k() {
        return (a) l(d.NEW_BUILDER);
    }

    protected Object l(d dVar) {
        return n(dVar, null, null);
    }

    protected Object m(d dVar, Object obj) {
        return n(dVar, obj, null);
    }

    protected abstract Object n(d dVar, Object obj, Object obj2);

    @Override // ir.nasim.W64
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final AbstractC1950t getDefaultInstanceForType() {
        return (AbstractC1950t) l(d.GET_DEFAULT_INSTANCE);
    }

    public final boolean s() {
        return t(this, true);
    }

    public String toString() {
        return J.e(this, super.toString());
    }

    protected void u() {
        Q.a().d(this).e(this);
    }

    @Override // androidx.datastore.preferences.protobuf.I
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final a newBuilderForType() {
        return (a) l(d.NEW_BUILDER);
    }
}
