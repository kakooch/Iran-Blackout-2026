package androidx.camera.core.impl;

import ir.nasim.AbstractC23197wW5;
import ir.nasim.C22601vW5;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public interface j {

    public static abstract class a {
        a() {
        }

        public static a a(String str, Class cls) {
            return b(str, cls, null);
        }

        public static a b(String str, Class cls, Object obj) {
            return new C1922c(str, cls, obj);
        }

        public abstract String c();

        public abstract Object d();

        public abstract Class e();
    }

    public interface b {
        boolean a(a aVar);
    }

    public enum c {
        ALWAYS_OVERRIDE,
        HIGH_PRIORITY_REQUIRED,
        REQUIRED,
        OPTIONAL
    }

    static void D(q qVar, j jVar, j jVar2, a aVar) {
        if (!Objects.equals(aVar, o.r)) {
            qVar.n(aVar, jVar2.h(aVar), jVar2.a(aVar));
            return;
        }
        C22601vW5 c22601vW5 = (C22601vW5) jVar2.g(aVar, null);
        qVar.n(aVar, jVar2.h(aVar), AbstractC23197wW5.a((C22601vW5) jVar.g(aVar, null), c22601vW5));
    }

    static j O(j jVar, j jVar2) {
        if (jVar == null && jVar2 == null) {
            return r.W();
        }
        q qVarA0 = jVar2 != null ? q.a0(jVar2) : q.Z();
        if (jVar != null) {
            Iterator it = jVar.e().iterator();
            while (it.hasNext()) {
                D(qVarA0, jVar2, jVar, (a) it.next());
            }
        }
        return r.X(qVarA0);
    }

    static boolean y(c cVar, c cVar2) {
        c cVar3 = c.REQUIRED;
        return cVar == cVar3 && cVar2 == cVar3;
    }

    Object a(a aVar);

    boolean b(a aVar);

    void c(String str, b bVar);

    Object d(a aVar, c cVar);

    Set e();

    Set f(a aVar);

    Object g(a aVar, Object obj);

    c h(a aVar);
}
