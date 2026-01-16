package com.google.protobuf;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2381e;
import com.google.protobuf.B;
import com.google.protobuf.C2399x;
import com.google.protobuf.P;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends AbstractC2377a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected m0 unknownFields = m0.c();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.c.values().length];
            a = iArr;
            try {
                iArr[r0.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class b extends AbstractC2377a.AbstractC0204a {
        private final GeneratedMessageLite a;
        protected GeneratedMessageLite b;

        protected b(GeneratedMessageLite generatedMessageLite) {
            this.a = generatedMessageLite;
            if (generatedMessageLite.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.b = z();
        }

        private static void y(Object obj, Object obj2) {
            a0.a().d(obj).a(obj, obj2);
        }

        private GeneratedMessageLite z() {
            return this.a.newMutableInstance();
        }

        @Override // ir.nasim.U64
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.b, false);
        }

        @Override // com.google.protobuf.P.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final GeneratedMessageLite a() {
            GeneratedMessageLite generatedMessageLiteJ = j();
            if (generatedMessageLiteJ.isInitialized()) {
                return generatedMessageLiteJ;
            }
            throw AbstractC2377a.AbstractC0204a.m(generatedMessageLiteJ);
        }

        @Override // com.google.protobuf.P.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite j() {
            if (!this.b.isMutable()) {
                return this.b;
            }
            this.b.makeImmutable();
            return this.b;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b clone() {
            b bVarNewBuilderForType = getDefaultInstanceForType().newBuilderForType();
            bVarNewBuilderForType.b = j();
            return bVarNewBuilderForType;
        }

        protected final void q() {
            if (this.b.isMutable()) {
                return;
            }
            r();
        }

        protected void r() {
            GeneratedMessageLite generatedMessageLiteZ = z();
            y(generatedMessageLiteZ, this.b);
            this.b = generatedMessageLiteZ;
        }

        @Override // ir.nasim.U64
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite getDefaultInstanceForType() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractC2377a.AbstractC0204a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b e(GeneratedMessageLite generatedMessageLite) {
            return v(generatedMessageLite);
        }

        @Override // com.google.protobuf.AbstractC2377a.AbstractC0204a
        /* renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b h(AbstractC2384h abstractC2384h, C2394s c2394s) throws IOException {
            q();
            try {
                a0.a().d(this.b).i(this.b, C2385i.P(abstractC2384h), c2394s);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public b v(GeneratedMessageLite generatedMessageLite) {
            if (getDefaultInstanceForType().equals(generatedMessageLite)) {
                return this;
            }
            q();
            y(this.b, generatedMessageLite);
            return this;
        }

        @Override // com.google.protobuf.AbstractC2377a.AbstractC0204a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b l(byte[] bArr, int i, int i2) {
            return x(bArr, i, i2, C2394s.b());
        }

        public b x(byte[] bArr, int i, int i2, C2394s c2394s) throws InvalidProtocolBufferException {
            q();
            try {
                a0.a().d(this.b).j(this.b, bArr, i, i + i2, new AbstractC2381e.b(c2394s));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.p();
            }
        }
    }

    protected static class c extends AbstractC2378b {
        private final GeneratedMessageLite b;

        public c(GeneratedMessageLite generatedMessageLite) {
            this.b = generatedMessageLite;
        }

        @Override // com.google.protobuf.AbstractC2378b
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite g(byte[] bArr, int i, int i2, C2394s c2394s) {
            return GeneratedMessageLite.i(this.b, bArr, i, i2, c2394s);
        }
    }

    public static abstract class d extends b implements U64 {
        protected d(ExtendableMessage extendableMessage) {
            super(extendableMessage);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.b
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public final ExtendableMessage j() {
            if (!((ExtendableMessage) this.b).isMutable()) {
                return (ExtendableMessage) this.b;
            }
            ((ExtendableMessage) this.b).extensions.x();
            return (ExtendableMessage) super.j();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.b
        protected void r() {
            super.r();
            if (((ExtendableMessage) this.b).extensions != C2399x.h()) {
                GeneratedMessageLite generatedMessageLite = this.b;
                ((ExtendableMessage) generatedMessageLite).extensions = ((ExtendableMessage) generatedMessageLite).extensions.clone();
            }
        }
    }

    static final class e implements C2399x.b {
        final B.d a;
        final int b;
        final r0.b c;
        final boolean d;
        final boolean e;

        e(B.d dVar, int i, r0.b bVar, boolean z, boolean z2) {
            this.a = dVar;
            this.b = i;
            this.c = bVar;
            this.d = z;
            this.e = z2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.b - eVar.b;
        }

        @Override // com.google.protobuf.C2399x.b
        public boolean b() {
            return this.d;
        }

        @Override // com.google.protobuf.C2399x.b
        public r0.b e() {
            return this.c;
        }

        @Override // com.google.protobuf.C2399x.b
        public boolean f() {
            return this.e;
        }

        @Override // com.google.protobuf.C2399x.b
        public int getNumber() {
            return this.b;
        }

        public B.d h() {
            return this.a;
        }

        @Override // com.google.protobuf.C2399x.b
        public r0.c k() {
            return this.c.a();
        }

        @Override // com.google.protobuf.C2399x.b
        public P.a l(P.a aVar, P p) {
            return ((b) aVar).v((GeneratedMessageLite) p);
        }
    }

    public static class f extends AbstractC2393q {
        final P a;
        final Object b;
        final P c;
        final e d;

        f(P p, Object obj, P p2, e eVar, Class cls) {
            if (p == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.e() == r0.b.m && p2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.a = p;
            this.b = obj;
            this.c = p2;
            this.d = eVar;
        }

        Object b(Object obj) {
            if (!this.d.b()) {
                return h(obj);
            }
            if (this.d.k() != r0.c.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(h(it.next()));
            }
            return arrayList;
        }

        public P c() {
            return this.a;
        }

        public r0.b d() {
            return this.d.e();
        }

        public P e() {
            return this.c;
        }

        public int f() {
            return this.d.getNumber();
        }

        public boolean g() {
            return this.d.d;
        }

        Object h(Object obj) {
            return this.d.k() == r0.c.ENUM ? this.d.a.a(((Integer) obj).intValue()) : obj;
        }

        Object i(Object obj) {
            return this.d.k() == r0.c.ENUM ? Integer.valueOf(((B.c) obj).getNumber()) : obj;
        }
    }

    public enum g {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f c(AbstractC2393q abstractC2393q) {
        if (abstractC2393q.a()) {
            return (f) abstractC2393q;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static GeneratedMessageLite d(GeneratedMessageLite generatedMessageLite) throws InvalidProtocolBufferException {
        if (generatedMessageLite == null || generatedMessageLite.isInitialized()) {
            return generatedMessageLite;
        }
        throw generatedMessageLite.newUninitializedMessageException().a().m(generatedMessageLite);
    }

    private int e(e0 e0Var) {
        return e0Var == null ? a0.a().d(this).g(this) : e0Var.g(this);
    }

    protected static B.a emptyBooleanList() {
        return C2382f.r();
    }

    protected static B.b emptyDoubleList() {
        return C2392p.o();
    }

    protected static B.f emptyFloatList() {
        return C2400y.o();
    }

    protected static B.g emptyIntList() {
        return A.o();
    }

    protected static B.i emptyLongList() {
        return G.o();
    }

    protected static <E> B.j emptyProtobufList() {
        return b0.i();
    }

    private void f() {
        if (this.unknownFields == m0.c()) {
            this.unknownFields = m0.o();
        }
    }

    private static GeneratedMessageLite g(GeneratedMessageLite generatedMessageLite, InputStream inputStream, C2394s c2394s) throws IOException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            AbstractC2384h abstractC2384hH = AbstractC2384h.h(new AbstractC2377a.AbstractC0204a.C0205a(inputStream, AbstractC2384h.C(i, inputStream)));
            GeneratedMessageLite partialFrom = parsePartialFrom(generatedMessageLite, abstractC2384hH, c2394s);
            try {
                abstractC2384hH.a(0);
                return partialFrom;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.m(partialFrom);
            }
        } catch (InvalidProtocolBufferException e3) {
            if (e3.a()) {
                throw new InvalidProtocolBufferException(e3);
            }
            throw e3;
        } catch (IOException e4) {
            throw new InvalidProtocolBufferException(e4);
        }
    }

    static <T extends GeneratedMessageLite> T getDefaultInstance(Class<T> cls) throws ClassNotFoundException {
        GeneratedMessageLite generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) o0.l(cls)).getDefaultInstanceForType();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    static java.lang.reflect.Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e2);
        }
    }

    private static GeneratedMessageLite h(GeneratedMessageLite generatedMessageLite, AbstractC2383g abstractC2383g, C2394s c2394s) throws InvalidProtocolBufferException {
        AbstractC2384h abstractC2384hV = abstractC2383g.V();
        GeneratedMessageLite partialFrom = parsePartialFrom(generatedMessageLite, abstractC2384hV, c2394s);
        try {
            abstractC2384hV.a(0);
            return partialFrom;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.m(partialFrom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GeneratedMessageLite i(GeneratedMessageLite generatedMessageLite, byte[] bArr, int i, int i2, C2394s c2394s) throws InvalidProtocolBufferException {
        GeneratedMessageLite generatedMessageLiteNewMutableInstance = generatedMessageLite.newMutableInstance();
        try {
            e0 e0VarD = a0.a().d(generatedMessageLiteNewMutableInstance);
            e0VarD.j(generatedMessageLiteNewMutableInstance, bArr, i, i + i2, new AbstractC2381e.b(c2394s));
            e0VarD.e(generatedMessageLiteNewMutableInstance);
            return generatedMessageLiteNewMutableInstance;
        } catch (InvalidProtocolBufferException e2) {
            e = e2;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.m(generatedMessageLiteNewMutableInstance);
        } catch (UninitializedMessageException e3) {
            throw e3.a().m(generatedMessageLiteNewMutableInstance);
        } catch (IOException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw new InvalidProtocolBufferException(e4).m(generatedMessageLiteNewMutableInstance);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.p().m(generatedMessageLiteNewMutableInstance);
        }
    }

    static Object invokeOrDie(java.lang.reflect.Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static B.g mutableCopy(B.g gVar) {
        int size = gVar.size();
        return gVar.b(size == 0 ? 10 : size * 2);
    }

    protected static Object newMessageInfo(P p, String str, Object[] objArr) {
        return new c0(p, str, objArr);
    }

    public static <ContainingType extends P, Type> f newRepeatedGeneratedExtension(ContainingType containingtype, P p, B.d dVar, int i, r0.b bVar, boolean z, Class cls) {
        return new f(containingtype, Collections.emptyList(), p, new e(dVar, i, bVar, true, z), cls);
    }

    public static <ContainingType extends P, Type> f newSingularGeneratedExtension(ContainingType containingtype, Type type, P p, B.d dVar, int i, r0.b bVar, Class cls) {
        return new f(containingtype, type, p, new e(dVar, i, bVar, false, false), cls);
    }

    protected static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t, InputStream inputStream) {
        return (T) d(g(t, inputStream, C2394s.b()));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, ByteBuffer byteBuffer, C2394s c2394s) {
        return (T) d(parseFrom(t, AbstractC2384h.j(byteBuffer), c2394s));
    }

    static <T extends GeneratedMessageLite> T parsePartialFrom(T t, AbstractC2384h abstractC2384h, C2394s c2394s) throws InvalidProtocolBufferException {
        T t2 = (T) t.newMutableInstance();
        try {
            e0 e0VarD = a0.a().d(t2);
            e0VarD.i(t2, C2385i.P(abstractC2384h), c2394s);
            e0VarD.e(t2);
            return t2;
        } catch (InvalidProtocolBufferException e2) {
            e = e2;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.m(t2);
        } catch (UninitializedMessageException e3) {
            throw e3.a().m(t2);
        } catch (IOException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw new InvalidProtocolBufferException(e4).m(t2);
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e5.getCause());
            }
            throw e5;
        }
    }

    protected static <T extends GeneratedMessageLite> void registerDefaultInstance(Class<T> cls, T t) {
        t.markImmutable();
        defaultInstanceMap.put(cls, t);
    }

    Object buildMessageInfo() {
        return dynamicMethod(g.BUILD_MESSAGE_INFO);
    }

    void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    int computeHashCode() {
        return a0.a().d(this).b(this);
    }

    protected final <MessageType extends GeneratedMessageLite, BuilderType extends b> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(g.NEW_BUILDER);
    }

    protected Object dynamicMethod(g gVar, Object obj) {
        return dynamicMethod(gVar, obj, null);
    }

    protected abstract Object dynamicMethod(g gVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return a0.a().d(this).c(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.P
    public final KW4 getParserForType() {
        return (KW4) dynamicMethod(g.GET_PARSER);
    }

    @Override // com.google.protobuf.AbstractC2377a
    int getSerializedSize(e0 e0Var) {
        if (!isMutable()) {
            if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
                return getMemoizedSerializedSize();
            }
            int iE = e(e0Var);
            setMemoizedSerializedSize(iE);
            return iE;
        }
        int iE2 = e(e0Var);
        if (iE2 >= 0) {
            return iE2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iE2);
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    @Override // ir.nasim.U64
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    boolean isMutable() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    protected void makeImmutable() {
        a0.a().d(this).e(this);
        markImmutable();
    }

    void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    protected void mergeLengthDelimitedField(int i, AbstractC2383g abstractC2383g) {
        f();
        this.unknownFields.l(i, abstractC2383g);
    }

    protected final void mergeUnknownFields(m0 m0Var) {
        this.unknownFields = m0.n(this.unknownFields, m0Var);
    }

    protected void mergeVarintField(int i, int i2) {
        f();
        this.unknownFields.m(i, i2);
    }

    GeneratedMessageLite newMutableInstance() {
        return (GeneratedMessageLite) dynamicMethod(g.NEW_MUTABLE_INSTANCE);
    }

    protected boolean parseUnknownField(int i, AbstractC2384h abstractC2384h) {
        if (r0.b(i) == 4) {
            return false;
        }
        f();
        return this.unknownFields.i(i, abstractC2384h);
    }

    void setMemoizedHashCode(int i) {
        this.memoizedHashCode = i;
    }

    void setMemoizedSerializedSize(int i) {
        if (i >= 0) {
            this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
    }

    public String toString() {
        return Q.f(this, super.toString());
    }

    @Override // com.google.protobuf.P
    public void writeTo(CodedOutputStream codedOutputStream) {
        a0.a().d(this).h(this, C2386j.P(codedOutputStream));
    }

    protected static final <T extends GeneratedMessageLite> boolean isInitialized(T t, boolean z) {
        byte bByteValue = ((Byte) t.dynamicMethod(g.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zF = a0.a().d(t).f(t);
        if (z) {
            t.dynamicMethod(g.SET_MEMOIZED_IS_INITIALIZED, zF ? t : null);
        }
        return zF;
    }

    protected final <MessageType extends GeneratedMessageLite, BuilderType extends b> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().v(messagetype);
    }

    protected Object dynamicMethod(g gVar) {
        return dynamicMethod(gVar, null, null);
    }

    @Override // ir.nasim.U64
    public final GeneratedMessageLite getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(g.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.protobuf.P
    public final b newBuilderForType() {
        return (b) dynamicMethod(g.NEW_BUILDER);
    }

    @Override // com.google.protobuf.P
    public final b toBuilder() {
        return ((b) dynamicMethod(g.NEW_BUILDER)).v(this);
    }

    protected static B.i mutableCopy(B.i iVar) {
        int size = iVar.size();
        return iVar.b(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, ByteBuffer byteBuffer) {
        return (T) parseFrom(t, byteBuffer, C2394s.b());
    }

    protected static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t, InputStream inputStream, C2394s c2394s) {
        return (T) d(g(t, inputStream, c2394s));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, AbstractC2383g abstractC2383g) {
        return (T) d(parseFrom(t, abstractC2383g, C2394s.b()));
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends d> extends GeneratedMessageLite implements U64 {
        protected C2399x extensions = C2399x.h();

        protected class a {
            private final Iterator a;
            private Map.Entry b;
            private final boolean c;

            /* synthetic */ a(ExtendableMessage extendableMessage, boolean z, a aVar) {
                this(z);
            }

            private a(boolean z) {
                Iterator itW = ExtendableMessage.this.extensions.w();
                this.a = itW;
                if (itW.hasNext()) {
                    this.b = (Map.Entry) itW.next();
                }
                this.c = z;
            }
        }

        private void eagerlyMergeMessageSetExtension(AbstractC2384h abstractC2384h, f fVar, C2394s c2394s, int i) {
            parseExtension(abstractC2384h, c2394s, fVar, r0.c(i, 2), i);
        }

        private void mergeMessageSetExtensionFromBytes(AbstractC2383g abstractC2383g, C2394s c2394s, f fVar) {
            P p = (P) this.extensions.i(fVar.d);
            P.a builder = p != null ? p.toBuilder() : null;
            if (builder == null) {
                builder = fVar.e().newBuilderForType();
            }
            builder.X0(abstractC2383g, c2394s);
            ensureExtensionsAreMutable().C(fVar.d, fVar.i(builder.a()));
        }

        private <MessageType extends P> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, AbstractC2384h abstractC2384h, C2394s c2394s) {
            int iK = 0;
            AbstractC2383g abstractC2383gR = null;
            f fVarA = null;
            while (true) {
                int iJ = abstractC2384h.J();
                if (iJ == 0) {
                    break;
                }
                if (iJ == r0.c) {
                    iK = abstractC2384h.K();
                    if (iK != 0) {
                        fVarA = c2394s.a(messagetype, iK);
                    }
                } else if (iJ == r0.d) {
                    if (iK == 0 || fVarA == null) {
                        abstractC2383gR = abstractC2384h.r();
                    } else {
                        eagerlyMergeMessageSetExtension(abstractC2384h, fVarA, c2394s, iK);
                        abstractC2383gR = null;
                    }
                } else if (!abstractC2384h.M(iJ)) {
                    break;
                }
            }
            abstractC2384h.a(r0.b);
            if (abstractC2383gR == null || iK == 0) {
                return;
            }
            if (fVarA != null) {
                mergeMessageSetExtensionFromBytes(abstractC2383gR, c2394s, fVarA);
            } else {
                mergeLengthDelimitedField(iK, abstractC2383gR);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private boolean parseExtension(com.google.protobuf.AbstractC2384h r6, com.google.protobuf.C2394s r7, com.google.protobuf.GeneratedMessageLite.f r8, int r9, int r10) {
            /*
                Method dump skipped, instructions count: 293
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.ExtendableMessage.parseExtension(com.google.protobuf.h, com.google.protobuf.s, com.google.protobuf.GeneratedMessageLite$f, int, int):boolean");
        }

        private void verifyExtensionContainingType(f fVar) {
            if (fVar.c() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        C2399x ensureExtensionsAreMutable() {
            if (this.extensions.r()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.s();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.n();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.j();
        }

        public final <Type> Type getExtension(AbstractC2393q abstractC2393q) {
            f fVarC = GeneratedMessageLite.c(abstractC2393q);
            verifyExtensionContainingType(fVarC);
            Object objI = this.extensions.i(fVarC.d);
            return objI == null ? (Type) fVarC.b : (Type) fVarC.b(objI);
        }

        public final <Type> int getExtensionCount(AbstractC2393q abstractC2393q) {
            f fVarC = GeneratedMessageLite.c(abstractC2393q);
            verifyExtensionContainingType(fVarC);
            return this.extensions.m(fVarC.d);
        }

        public final <Type> boolean hasExtension(AbstractC2393q abstractC2393q) {
            f fVarC = GeneratedMessageLite.c(abstractC2393q);
            verifyExtensionContainingType(fVarC);
            return this.extensions.p(fVarC.d);
        }

        protected final void mergeExtensionFields(MessageType messagetype) {
            if (this.extensions.r()) {
                this.extensions = this.extensions.clone();
            }
            this.extensions.y(messagetype.extensions);
        }

        protected ExtendableMessage<MessageType, BuilderType>.a newExtensionWriter() {
            return new a(this, false, null);
        }

        protected ExtendableMessage<MessageType, BuilderType>.a newMessageSetExtensionWriter() {
            return new a(this, true, null);
        }

        protected <MessageType extends P> boolean parseUnknownField(MessageType messagetype, AbstractC2384h abstractC2384h, C2394s c2394s, int i) {
            int iA = r0.a(i);
            return parseExtension(abstractC2384h, c2394s, c2394s.a(messagetype, iA), i, iA);
        }

        protected <MessageType extends P> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, AbstractC2384h abstractC2384h, C2394s c2394s, int i) {
            if (i != r0.a) {
                return r0.b(i) == 2 ? parseUnknownField(messagetype, abstractC2384h, c2394s, i) : abstractC2384h.M(i);
            }
            mergeMessageSetExtensionFromCodedStream(messagetype, abstractC2384h, c2394s);
            return true;
        }

        public final <Type> Type getExtension(AbstractC2393q abstractC2393q, int i) {
            f fVarC = GeneratedMessageLite.c(abstractC2393q);
            verifyExtensionContainingType(fVarC);
            return (Type) fVarC.h(this.extensions.l(fVarC.d, i));
        }
    }

    protected static B.f mutableCopy(B.f fVar) {
        int size = fVar.size();
        return fVar.b(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (T) d(h(t, abstractC2383g, c2394s));
    }

    protected static B.b mutableCopy(B.b bVar) {
        int size = bVar.size();
        return bVar.b(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, byte[] bArr) {
        return (T) d(i(t, bArr, 0, bArr.length, C2394s.b()));
    }

    @Override // com.google.protobuf.P
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    protected static B.a mutableCopy(B.a aVar) {
        int size = aVar.size();
        return aVar.b(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, byte[] bArr, C2394s c2394s) {
        return (T) d(i(t, bArr, 0, bArr.length, c2394s));
    }

    protected static <E> B.j mutableCopy(B.j jVar) {
        int size = jVar.size();
        return jVar.b(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, InputStream inputStream) {
        return (T) d(parsePartialFrom(t, AbstractC2384h.h(inputStream), C2394s.b()));
    }

    protected static <T extends GeneratedMessageLite> T parsePartialFrom(T t, AbstractC2384h abstractC2384h) {
        return (T) parsePartialFrom(t, abstractC2384h, C2394s.b());
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, InputStream inputStream, C2394s c2394s) {
        return (T) d(parsePartialFrom(t, AbstractC2384h.h(inputStream), c2394s));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, AbstractC2384h abstractC2384h) {
        return (T) parseFrom(t, abstractC2384h, C2394s.b());
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (T) d(parsePartialFrom(t, abstractC2384h, c2394s));
    }
}
