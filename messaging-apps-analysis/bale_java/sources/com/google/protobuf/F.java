package com.google.protobuf;

import com.google.protobuf.B;
import ir.nasim.FB7;
import ir.nasim.InterfaceC3919Cx3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
abstract class F {
    private static final F a;
    private static final F b;

    private static final class b extends F {
        private static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static List f(Object obj, long j) {
            return (List) o0.G(obj, j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static List g(Object obj, long j, int i) {
            E e;
            List listF = f(obj, j);
            if (listF.isEmpty()) {
                List e2 = listF instanceof InterfaceC3919Cx3 ? new E(i) : ((listF instanceof Z) && (listF instanceof B.j)) ? ((B.j) listF).b(i) : new ArrayList(i);
                o0.V(obj, j, e2);
                return e2;
            }
            if (c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i);
                arrayList.addAll(listF);
                o0.V(obj, j, arrayList);
                e = arrayList;
            } else {
                if (!(listF instanceof FB7)) {
                    if (!(listF instanceof Z) || !(listF instanceof B.j)) {
                        return listF;
                    }
                    B.j jVar = (B.j) listF;
                    if (jVar.u()) {
                        return listF;
                    }
                    B.j jVarB = jVar.b(listF.size() + i);
                    o0.V(obj, j, jVarB);
                    return jVarB;
                }
                E e3 = new E(listF.size() + i);
                e3.addAll((FB7) listF);
                o0.V(obj, j, e3);
                e = e3;
            }
            return e;
        }

        @Override // com.google.protobuf.F
        void c(Object obj, long j) {
            Object objUnmodifiableList;
            List list = (List) o0.G(obj, j);
            if (list instanceof InterfaceC3919Cx3) {
                objUnmodifiableList = ((InterfaceC3919Cx3) list).p();
            } else {
                if (c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof Z) && (list instanceof B.j)) {
                    B.j jVar = (B.j) list;
                    if (jVar.u()) {
                        jVar.s();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            o0.V(obj, j, objUnmodifiableList);
        }

        @Override // com.google.protobuf.F
        void d(Object obj, Object obj2, long j) {
            List listF = f(obj2, j);
            List listG = g(obj, j, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            o0.V(obj, j, listF);
        }

        @Override // com.google.protobuf.F
        List e(Object obj, long j) {
            return g(obj, j, 10);
        }
    }

    private static final class c extends F {
        private c() {
            super();
        }

        static B.j f(Object obj, long j) {
            return (B.j) o0.G(obj, j);
        }

        @Override // com.google.protobuf.F
        void c(Object obj, long j) {
            f(obj, j).s();
        }

        @Override // com.google.protobuf.F
        void d(Object obj, Object obj2, long j) {
            B.j jVarF = f(obj, j);
            B.j jVarF2 = f(obj2, j);
            int size = jVarF.size();
            int size2 = jVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!jVarF.u()) {
                    jVarF = jVarF.b(size2 + size);
                }
                jVarF.addAll(jVarF2);
            }
            if (size > 0) {
                jVarF2 = jVarF;
            }
            o0.V(obj, j, jVarF2);
        }

        @Override // com.google.protobuf.F
        List e(Object obj, long j) {
            B.j jVarF = f(obj, j);
            if (jVarF.u()) {
                return jVarF;
            }
            int size = jVarF.size();
            B.j jVarB = jVarF.b(size == 0 ? 10 : size * 2);
            o0.V(obj, j, jVarB);
            return jVarB;
        }
    }

    static {
        a = new b();
        b = new c();
    }

    private F() {
    }

    static F a() {
        return a;
    }

    static F b() {
        return b;
    }

    abstract void c(Object obj, long j);

    abstract void d(Object obj, Object obj2, long j);

    abstract List e(Object obj, long j);
}
