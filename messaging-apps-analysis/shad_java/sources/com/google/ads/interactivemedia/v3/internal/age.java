package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class age {
    final List<agu> a;
    final boolean b;
    private final ThreadLocal<Map<akz<?>, agd<?>>> c;
    private final Map<akz<?>, agt<?>> d;
    private final ahp e;
    private final aiq f;

    static {
        akz.d(Object.class);
    }

    public age() {
        ahr ahrVar = ahr.a;
        throw null;
    }

    static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static final ald j(Writer writer) throws IOException {
        ald aldVar = new ald(writer);
        aldVar.q(false);
        return aldVar;
    }

    public final <T> agt<T> b(akz<T> akzVar) {
        boolean z;
        agt<T> agtVar = (agt) this.d.get(akzVar);
        if (agtVar != null) {
            return agtVar;
        }
        Map<akz<?>, agd<?>> map = this.c.get();
        if (map == null) {
            map = new HashMap<>();
            this.c.set(map);
            z = true;
        } else {
            z = false;
        }
        agd<?> agdVar = map.get(akzVar);
        if (agdVar != null) {
            return agdVar;
        }
        try {
            agd<?> agdVar2 = new agd<>();
            map.put(akzVar, agdVar2);
            Iterator<agu> it = this.a.iterator();
            while (it.hasNext()) {
                agt<T> agtVarA = it.next().a(this, akzVar);
                if (agtVarA != null) {
                    agdVar2.a(agtVarA);
                    this.d.put(akzVar, agtVarA);
                    return agtVarA;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + akzVar);
        } finally {
            map.remove(akzVar);
            if (z) {
                this.c.remove();
            }
        }
    }

    public final <T> agt<T> c(agu aguVar, akz<T> akzVar) {
        if (!this.a.contains(aguVar)) {
            aguVar = this.f;
        }
        boolean z = false;
        for (agu aguVar2 : this.a) {
            if (z) {
                agt<T> agtVarA = aguVar2.a(this, akzVar);
                if (agtVarA != null) {
                    return agtVarA;
                }
            } else if (aguVar2 == aguVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + akzVar);
    }

    public final <T> agt<T> d(Class<T> cls) {
        return b(akz.d(cls));
    }

    public final String e(Object obj) throws agk {
        if (obj == null) {
            agl aglVar = agl.a;
            StringWriter stringWriter = new StringWriter();
            try {
                g(aglVar, j(com.google.ads.interactivemedia.v3.impl.data.ax.c(stringWriter)));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new agk(e);
            }
        }
        Class<?> cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            f(obj, cls, j(com.google.ads.interactivemedia.v3.impl.data.ax.c(stringWriter2)));
            return stringWriter2.toString();
        } catch (IOException e2) {
            throw new agk(e2);
        }
    }

    public final void f(Object obj, Type type, ald aldVar) throws agk {
        agt agtVarB = b(akz.c(type));
        boolean zN = aldVar.n();
        aldVar.m(true);
        boolean zP = aldVar.p();
        aldVar.o(this.b);
        boolean zR = aldVar.r();
        aldVar.q(false);
        try {
            try {
                agtVarB.write(aldVar, obj);
            } catch (IOException e) {
                throw new agk(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            aldVar.m(zN);
            aldVar.o(zP);
            aldVar.q(zR);
        }
    }

    public final void g(agj agjVar, ald aldVar) throws agk {
        boolean zN = aldVar.n();
        aldVar.m(true);
        boolean zP = aldVar.p();
        aldVar.o(this.b);
        boolean zR = aldVar.r();
        aldVar.q(false);
        try {
            try {
                com.google.ads.interactivemedia.v3.impl.data.ax.b(agjVar, aldVar);
            } catch (IOException e) {
                throw new agk(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            aldVar.m(zN);
            aldVar.o(zP);
            aldVar.q(zR);
        }
    }

    public final <T> T h(Reader reader, Type type) throws agk, agq {
        alb albVar = new alb(reader);
        albVar.q(false);
        T t = (T) i(albVar, type);
        if (t != null) {
            try {
                if (albVar.p() != 10) {
                    throw new agk("JSON document was not fully consumed.");
                }
            } catch (ale e) {
                throw new agq(e);
            } catch (IOException e2) {
                throw new agk(e2);
            }
        }
        return t;
    }

    public final <T> T i(alb albVar, Type type) throws agk, agq {
        boolean zR = albVar.r();
        boolean z = true;
        albVar.q(true);
        try {
            try {
                try {
                    albVar.p();
                } catch (EOFException e) {
                    e = e;
                }
                try {
                    return b(akz.c(type)).read(albVar);
                } catch (EOFException e2) {
                    e = e2;
                    z = false;
                    if (!z) {
                        throw new agq(e);
                    }
                    albVar.q(zR);
                    return null;
                }
            } catch (IOException e3) {
                throw new agq(e3);
            } catch (AssertionError e4) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e4.getMessage());
                assertionError.initCause(e4);
                throw assertionError;
            } catch (IllegalStateException e5) {
                throw new agq(e5);
            }
        } finally {
            albVar.q(zR);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.a + ",instanceCreators:" + this.e + "}";
    }

    age(ahr ahrVar, afx afxVar, Map<Type, agg<?>> map, boolean z, int i, List<agu> list) {
        this.c = new ThreadLocal<>();
        this.d = new ConcurrentHashMap();
        ahp ahpVar = new ahp(map);
        this.e = ahpVar;
        this.b = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(aku.W);
        arrayList.add(aiy.a);
        arrayList.add(ahrVar);
        arrayList.addAll(list);
        arrayList.add(aku.B);
        arrayList.add(aku.m);
        arrayList.add(aku.g);
        arrayList.add(aku.i);
        arrayList.add(aku.k);
        agt agaVar = i == agr.a ? aku.t : new aga();
        arrayList.add(aku.c(Long.TYPE, Long.class, agaVar));
        arrayList.add(aku.c(Double.TYPE, Double.class, new afy()));
        arrayList.add(aku.c(Float.TYPE, Float.class, new afz()));
        arrayList.add(aku.v);
        arrayList.add(aku.o);
        arrayList.add(aku.q);
        arrayList.add(aku.b(AtomicLong.class, new agb(agaVar).nullSafe()));
        arrayList.add(aku.b(AtomicLongArray.class, new agc(agaVar).nullSafe()));
        arrayList.add(aku.s);
        arrayList.add(aku.x);
        arrayList.add(aku.D);
        arrayList.add(aku.F);
        arrayList.add(aku.b(BigDecimal.class, aku.z));
        arrayList.add(aku.b(BigInteger.class, aku.A));
        arrayList.add(aku.H);
        arrayList.add(aku.J);
        arrayList.add(aku.N);
        arrayList.add(aku.P);
        arrayList.add(aku.U);
        arrayList.add(aku.L);
        arrayList.add(aku.d);
        arrayList.add(aip.a);
        arrayList.add(aku.S);
        arrayList.add(ajf.a);
        arrayList.add(ajd.a);
        arrayList.add(aku.Q);
        arrayList.add(ail.a);
        arrayList.add(aku.b);
        arrayList.add(new ain(ahpVar));
        arrayList.add(new aiw(ahpVar));
        aiq aiqVar = new aiq(ahpVar);
        this.f = aiqVar;
        arrayList.add(aiqVar);
        arrayList.add(aku.X);
        arrayList.add(new ajb(ahpVar, afxVar, ahrVar, aiqVar));
        this.a = Collections.unmodifiableList(arrayList);
    }
}
