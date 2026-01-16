package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;
import ir.nasim.EB7;
import ir.nasim.InterfaceC3685Bx3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.crypto.tink.shaded.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2362y {
    private static final AbstractC2362y a;
    private static final AbstractC2362y b;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.y$b */
    private static final class b extends AbstractC2362y {
        private static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static List f(Object obj, long j) {
            return (List) d0.C(obj, j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static List g(Object obj, long j, int i) {
            C2361x c2361x;
            List listF = f(obj, j);
            if (listF.isEmpty()) {
                List c2361x2 = listF instanceof InterfaceC3685Bx3 ? new C2361x(i) : ((listF instanceof P) && (listF instanceof AbstractC2360w.d)) ? ((AbstractC2360w.d) listF).b(i) : new ArrayList(i);
                d0.R(obj, j, c2361x2);
                return c2361x2;
            }
            if (c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i);
                arrayList.addAll(listF);
                d0.R(obj, j, arrayList);
                c2361x = arrayList;
            } else {
                if (!(listF instanceof EB7)) {
                    if (!(listF instanceof P) || !(listF instanceof AbstractC2360w.d)) {
                        return listF;
                    }
                    AbstractC2360w.d dVar = (AbstractC2360w.d) listF;
                    if (dVar.u()) {
                        return listF;
                    }
                    AbstractC2360w.d dVarB = dVar.b(listF.size() + i);
                    d0.R(obj, j, dVarB);
                    return dVarB;
                }
                C2361x c2361x3 = new C2361x(listF.size() + i);
                c2361x3.addAll((EB7) listF);
                d0.R(obj, j, c2361x3);
                c2361x = c2361x3;
            }
            return c2361x;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2362y
        void c(Object obj, long j) {
            Object objUnmodifiableList;
            List list = (List) d0.C(obj, j);
            if (list instanceof InterfaceC3685Bx3) {
                objUnmodifiableList = ((InterfaceC3685Bx3) list).p();
            } else {
                if (c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof P) && (list instanceof AbstractC2360w.d)) {
                    AbstractC2360w.d dVar = (AbstractC2360w.d) list;
                    if (dVar.u()) {
                        dVar.s();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            d0.R(obj, j, objUnmodifiableList);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2362y
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
            d0.R(obj, j, listF);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2362y
        List e(Object obj, long j) {
            return g(obj, j, 10);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.y$c */
    private static final class c extends AbstractC2362y {
        private c() {
            super();
        }

        static AbstractC2360w.d f(Object obj, long j) {
            return (AbstractC2360w.d) d0.C(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2362y
        void c(Object obj, long j) {
            f(obj, j).s();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2362y
        void d(Object obj, Object obj2, long j) {
            AbstractC2360w.d dVarF = f(obj, j);
            AbstractC2360w.d dVarF2 = f(obj2, j);
            int size = dVarF.size();
            int size2 = dVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!dVarF.u()) {
                    dVarF = dVarF.b(size2 + size);
                }
                dVarF.addAll(dVarF2);
            }
            if (size > 0) {
                dVarF2 = dVarF;
            }
            d0.R(obj, j, dVarF2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2362y
        List e(Object obj, long j) {
            AbstractC2360w.d dVarF = f(obj, j);
            if (dVarF.u()) {
                return dVarF;
            }
            int size = dVarF.size();
            AbstractC2360w.d dVarB = dVarF.b(size == 0 ? 10 : size * 2);
            d0.R(obj, j, dVarB);
            return dVarB;
        }
    }

    static {
        a = new b();
        b = new c();
    }

    private AbstractC2362y() {
    }

    static AbstractC2362y a() {
        return a;
    }

    static AbstractC2362y b() {
        return b;
    }

    abstract void c(Object obj, long j);

    abstract void d(Object obj, Object obj2, long j);

    abstract List e(Object obj, long j);
}
