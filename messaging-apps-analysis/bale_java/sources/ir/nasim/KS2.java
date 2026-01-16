package ir.nasim;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes3.dex */
public final class KS2 {
    static final InterfaceC3801Ck2 A = EnumC3567Bk2.a;
    static final InterfaceC19742qr7 B = EnumC19151pr7.a;
    static final InterfaceC19742qr7 C = EnumC19151pr7.b;
    static final String z = null;
    private final ThreadLocal a;
    private final ConcurrentMap b;
    private final C20806se1 c;
    private final C12513ek3 d;
    final List e;
    final C8469Wc2 f;
    final InterfaceC3801Ck2 g;
    final Map h;
    final boolean i;
    final boolean j;
    final boolean k;
    final boolean l;
    final boolean m;
    final boolean n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final EnumC19415qJ3 t;
    final List u;
    final List v;
    final InterfaceC19742qr7 w;
    final InterfaceC19742qr7 x;
    final List y;

    class a extends AbstractC6277Mx7 {
        a() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return Double.valueOf(c12523el3.f1());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
                return;
            }
            double dDoubleValue = number.doubleValue();
            KS2.d(dDoubleValue);
            c22155ul3.P(dDoubleValue);
        }
    }

    class b extends AbstractC6277Mx7 {
        b() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return Float.valueOf((float) c12523el3.f1());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
                return;
            }
            float fFloatValue = number.floatValue();
            KS2.d(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            c22155ul3.U(number);
        }
    }

    class c extends AbstractC6277Mx7 {
        c() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return Long.valueOf(c12523el3.K1());
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Number number) throws IOException {
            if (number == null) {
                c22155ul3.s();
            } else {
                c22155ul3.X(number.toString());
            }
        }
    }

    class d extends AbstractC6277Mx7 {
        final /* synthetic */ AbstractC6277Mx7 a;

        d(AbstractC6277Mx7 abstractC6277Mx7) {
            this.a = abstractC6277Mx7;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(C12523el3 c12523el3) {
            return new AtomicLong(((Number) this.a.b(c12523el3)).longValue());
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, AtomicLong atomicLong) {
            this.a.d(c22155ul3, Long.valueOf(atomicLong.get()));
        }
    }

    class e extends AbstractC6277Mx7 {
        final /* synthetic */ AbstractC6277Mx7 a;

        e(AbstractC6277Mx7 abstractC6277Mx7) {
            this.a = abstractC6277Mx7;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(C12523el3 c12523el3) throws IOException {
            ArrayList arrayList = new ArrayList();
            c12523el3.a();
            while (c12523el3.l()) {
                arrayList.add(Long.valueOf(((Number) this.a.b(c12523el3)).longValue()));
            }
            c12523el3.e();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i = 0; i < size; i++) {
                atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
            }
            return atomicLongArray;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, AtomicLongArray atomicLongArray) throws IOException {
            c22155ul3.c();
            int length = atomicLongArray.length();
            for (int i = 0; i < length; i++) {
                this.a.d(c22155ul3, Long.valueOf(atomicLongArray.get(i)));
            }
            c22155ul3.g();
        }
    }

    static class f extends AbstractC22208uq6 {
        private AbstractC6277Mx7 a = null;

        f() {
        }

        private AbstractC6277Mx7 f() {
            AbstractC6277Mx7 abstractC6277Mx7 = this.a;
            if (abstractC6277Mx7 != null) {
                return abstractC6277Mx7;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public Object b(C12523el3 c12523el3) {
            return f().b(c12523el3);
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public void d(C22155ul3 c22155ul3, Object obj) {
            f().d(c22155ul3, obj);
        }

        @Override // ir.nasim.AbstractC22208uq6
        public AbstractC6277Mx7 e() {
            return f();
        }

        public void g(AbstractC6277Mx7 abstractC6277Mx7) {
            if (this.a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.a = abstractC6277Mx7;
        }
    }

    public KS2() {
        this(C8469Wc2.g, A, Collections.emptyMap(), false, false, false, true, false, false, false, true, EnumC19415qJ3.a, z, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), B, C, Collections.emptyList());
    }

    private static void a(Object obj, C12523el3 c12523el3) {
        if (obj != null) {
            try {
                if (c12523el3.G() == EnumC16723ll3.END_DOCUMENT) {
                } else {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    private static AbstractC6277Mx7 b(AbstractC6277Mx7 abstractC6277Mx7) {
        return new d(abstractC6277Mx7).a();
    }

    private static AbstractC6277Mx7 c(AbstractC6277Mx7 abstractC6277Mx7) {
        return new e(abstractC6277Mx7).a();
    }

    static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private AbstractC6277Mx7 e(boolean z2) {
        return z2 ? AbstractC7010Px7.v : new a();
    }

    private AbstractC6277Mx7 f(boolean z2) {
        return z2 ? AbstractC7010Px7.u : new b();
    }

    private static AbstractC6277Mx7 p(EnumC19415qJ3 enumC19415qJ3) {
        return enumC19415qJ3 == EnumC19415qJ3.a ? AbstractC7010Px7.t : new c();
    }

    public Object g(C12523el3 c12523el3, TypeToken typeToken) {
        boolean zM = c12523el3.m();
        boolean z2 = true;
        c12523el3.D(true);
        try {
            try {
                try {
                    c12523el3.G();
                    z2 = false;
                    return m(typeToken).b(c12523el3);
                } catch (AssertionError e2) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (EOFException e4) {
                if (!z2) {
                    throw new JsonSyntaxException(e4);
                }
                c12523el3.D(zM);
                return null;
            } catch (IOException e5) {
                throw new JsonSyntaxException(e5);
            }
        } finally {
            c12523el3.D(zM);
        }
    }

    public Object h(Reader reader, TypeToken typeToken) {
        C12523el3 c12523el3Q = q(reader);
        Object objG = g(c12523el3Q, typeToken);
        a(objG, c12523el3Q);
        return objG;
    }

    public Object i(Reader reader, Class cls) {
        return AbstractC5511Jq5.b(cls).cast(h(reader, TypeToken.a(cls)));
    }

    public Object j(String str, TypeToken typeToken) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), typeToken);
    }

    public Object k(String str, Class cls) {
        return AbstractC5511Jq5.b(cls).cast(j(str, TypeToken.a(cls)));
    }

    public Object l(String str, Type type) {
        return j(str, TypeToken.b(type));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r2.g(r4);
        r0.put(r7, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.AbstractC6277Mx7 m(com.google.gson.reflect.TypeToken r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = r6.b
            java.lang.Object r0 = r0.get(r7)
            ir.nasim.Mx7 r0 = (ir.nasim.AbstractC6277Mx7) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal r0 = r6.a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal r1 = r6.a
            r1.set(r0)
            r1 = 1
            goto L30
        L26:
            java.lang.Object r1 = r0.get(r7)
            ir.nasim.Mx7 r1 = (ir.nasim.AbstractC6277Mx7) r1
            if (r1 == 0) goto L2f
            return r1
        L2f:
            r1 = 0
        L30:
            ir.nasim.KS2$f r2 = new ir.nasim.KS2$f     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.util.List r3 = r6.e     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
            r4 = 0
        L3f:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L5a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            ir.nasim.Nx7 r4 = (ir.nasim.InterfaceC6537Nx7) r4     // Catch: java.lang.Throwable -> L58
            ir.nasim.Mx7 r4 = r4.b(r6, r7)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L3f
            r2.g(r4)     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r7 = move-exception
            goto L82
        L5a:
            if (r1 == 0) goto L61
            java.lang.ThreadLocal r2 = r6.a
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap r7 = r6.b
            r7.putAll(r0)
        L6a:
            return r4
        L6b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "GSON (2.10.1) cannot handle "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L82:
            if (r1 == 0) goto L89
            java.lang.ThreadLocal r0 = r6.a
            r0.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KS2.m(com.google.gson.reflect.TypeToken):ir.nasim.Mx7");
    }

    public AbstractC6277Mx7 n(Class cls) {
        return m(TypeToken.a(cls));
    }

    public AbstractC6277Mx7 o(InterfaceC6537Nx7 interfaceC6537Nx7, TypeToken typeToken) {
        if (!this.e.contains(interfaceC6537Nx7)) {
            interfaceC6537Nx7 = this.d;
        }
        boolean z2 = false;
        for (InterfaceC6537Nx7 interfaceC6537Nx72 : this.e) {
            if (z2) {
                AbstractC6277Mx7 abstractC6277Mx7B = interfaceC6537Nx72.b(this, typeToken);
                if (abstractC6277Mx7B != null) {
                    return abstractC6277Mx7B;
                }
            } else if (interfaceC6537Nx72 == interfaceC6537Nx7) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public C12523el3 q(Reader reader) {
        C12523el3 c12523el3 = new C12523el3(reader);
        c12523el3.D(this.n);
        return c12523el3;
    }

    public C22155ul3 r(Writer writer) throws IOException {
        if (this.k) {
            writer.write(")]}'\n");
        }
        C22155ul3 c22155ul3 = new C22155ul3(writer);
        if (this.m) {
            c22155ul3.J("  ");
        }
        c22155ul3.H(this.l);
        c22155ul3.D(this.n);
        c22155ul3.K(this.i);
        return c22155ul3;
    }

    public String s(AbstractC22735vk3 abstractC22735vk3) {
        StringWriter stringWriter = new StringWriter();
        w(abstractC22735vk3, stringWriter);
        return stringWriter.toString();
    }

    public String t(Object obj) {
        return obj == null ? s(C8074Uk3.a) : u(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.i + ",factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    public String u(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        y(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void v(AbstractC22735vk3 abstractC22735vk3, C22155ul3 c22155ul3) {
        boolean zM = c22155ul3.m();
        c22155ul3.D(true);
        boolean zL = c22155ul3.l();
        c22155ul3.H(this.l);
        boolean zK = c22155ul3.k();
        c22155ul3.K(this.i);
        try {
            try {
                AbstractC19553qY6.b(abstractC22735vk3, c22155ul3);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            c22155ul3.D(zM);
            c22155ul3.H(zL);
            c22155ul3.K(zK);
        }
    }

    public void w(AbstractC22735vk3 abstractC22735vk3, Appendable appendable) {
        try {
            v(abstractC22735vk3, r(AbstractC19553qY6.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void x(Object obj, Type type, C22155ul3 c22155ul3) {
        AbstractC6277Mx7 abstractC6277Mx7M = m(TypeToken.b(type));
        boolean zM = c22155ul3.m();
        c22155ul3.D(true);
        boolean zL = c22155ul3.l();
        c22155ul3.H(this.l);
        boolean zK = c22155ul3.k();
        c22155ul3.K(this.i);
        try {
            try {
                abstractC6277Mx7M.d(c22155ul3, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            c22155ul3.D(zM);
            c22155ul3.H(zL);
            c22155ul3.K(zK);
        }
    }

    public void y(Object obj, Type type, Appendable appendable) {
        try {
            x(obj, type, r(AbstractC19553qY6.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    KS2(C8469Wc2 c8469Wc2, InterfaceC3801Ck2 interfaceC3801Ck2, Map map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, EnumC19415qJ3 enumC19415qJ3, String str, int i, int i2, List list, List list2, List list3, InterfaceC19742qr7 interfaceC19742qr7, InterfaceC19742qr7 interfaceC19742qr72, List list4) {
        this.a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.f = c8469Wc2;
        this.g = interfaceC3801Ck2;
        this.h = map;
        C20806se1 c20806se1 = new C20806se1(map, z9, list4);
        this.c = c20806se1;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = z5;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.p = z9;
        this.t = enumC19415qJ3;
        this.q = str;
        this.r = i;
        this.s = i2;
        this.u = list;
        this.v = list2;
        this.w = interfaceC19742qr7;
        this.x = interfaceC19742qr72;
        this.y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(AbstractC7010Px7.W);
        arrayList.add(BG4.e(interfaceC19742qr7));
        arrayList.add(c8469Wc2);
        arrayList.addAll(list3);
        arrayList.add(AbstractC7010Px7.C);
        arrayList.add(AbstractC7010Px7.m);
        arrayList.add(AbstractC7010Px7.g);
        arrayList.add(AbstractC7010Px7.i);
        arrayList.add(AbstractC7010Px7.k);
        AbstractC6277Mx7 abstractC6277Mx7P = p(enumC19415qJ3);
        arrayList.add(AbstractC7010Px7.c(Long.TYPE, Long.class, abstractC6277Mx7P));
        arrayList.add(AbstractC7010Px7.c(Double.TYPE, Double.class, e(z8)));
        arrayList.add(AbstractC7010Px7.c(Float.TYPE, Float.class, f(z8)));
        arrayList.add(C24817zF4.e(interfaceC19742qr72));
        arrayList.add(AbstractC7010Px7.o);
        arrayList.add(AbstractC7010Px7.q);
        arrayList.add(AbstractC7010Px7.b(AtomicLong.class, b(abstractC6277Mx7P)));
        arrayList.add(AbstractC7010Px7.b(AtomicLongArray.class, c(abstractC6277Mx7P)));
        arrayList.add(AbstractC7010Px7.s);
        arrayList.add(AbstractC7010Px7.x);
        arrayList.add(AbstractC7010Px7.E);
        arrayList.add(AbstractC7010Px7.G);
        arrayList.add(AbstractC7010Px7.b(BigDecimal.class, AbstractC7010Px7.z));
        arrayList.add(AbstractC7010Px7.b(BigInteger.class, AbstractC7010Px7.A));
        arrayList.add(AbstractC7010Px7.b(C8632Wu3.class, AbstractC7010Px7.B));
        arrayList.add(AbstractC7010Px7.I);
        arrayList.add(AbstractC7010Px7.K);
        arrayList.add(AbstractC7010Px7.O);
        arrayList.add(AbstractC7010Px7.Q);
        arrayList.add(AbstractC7010Px7.U);
        arrayList.add(AbstractC7010Px7.M);
        arrayList.add(AbstractC7010Px7.d);
        arrayList.add(JA1.b);
        arrayList.add(AbstractC7010Px7.S);
        if (AbstractC21895uJ6.a) {
            arrayList.add(AbstractC21895uJ6.e);
            arrayList.add(AbstractC21895uJ6.d);
            arrayList.add(AbstractC21895uJ6.f);
        }
        arrayList.add(SJ.c);
        arrayList.add(AbstractC7010Px7.b);
        arrayList.add(new VW0(c20806se1));
        arrayList.add(new XN3(c20806se1, z3));
        C12513ek3 c12513ek3 = new C12513ek3(c20806se1);
        this.d = c12513ek3;
        arrayList.add(c12513ek3);
        arrayList.add(AbstractC7010Px7.X);
        arrayList.add(new C16489lM5(c20806se1, interfaceC3801Ck2, c8469Wc2, c12513ek3, list4));
        this.e = Collections.unmodifiableList(arrayList);
    }
}
