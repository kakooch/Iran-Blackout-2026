package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1952v;
import ir.nasim.HB7;
import ir.nasim.InterfaceC4387Ex3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC1955y {
    private static final AbstractC1955y a;
    private static final AbstractC1955y b;

    /* renamed from: androidx.datastore.preferences.protobuf.y$b */
    private static final class b extends AbstractC1955y {
        private static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static List f(Object obj, long j) {
            return (List) e0.A(obj, j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static List g(Object obj, long j, int i) {
            C1954x c1954x;
            List listF = f(obj, j);
            if (listF.isEmpty()) {
                List c1954x2 = listF instanceof InterfaceC4387Ex3 ? new C1954x(i) : ((listF instanceof P) && (listF instanceof AbstractC1952v.b)) ? ((AbstractC1952v.b) listF).b(i) : new ArrayList(i);
                e0.O(obj, j, c1954x2);
                return c1954x2;
            }
            if (c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i);
                arrayList.addAll(listF);
                e0.O(obj, j, arrayList);
                c1954x = arrayList;
            } else {
                if (!(listF instanceof HB7)) {
                    if (!(listF instanceof P) || !(listF instanceof AbstractC1952v.b)) {
                        return listF;
                    }
                    AbstractC1952v.b bVar = (AbstractC1952v.b) listF;
                    if (bVar.u()) {
                        return listF;
                    }
                    AbstractC1952v.b bVarB = bVar.b(listF.size() + i);
                    e0.O(obj, j, bVarB);
                    return bVarB;
                }
                C1954x c1954x3 = new C1954x(listF.size() + i);
                c1954x3.addAll((HB7) listF);
                e0.O(obj, j, c1954x3);
                c1954x = c1954x3;
            }
            return c1954x;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1955y
        void c(Object obj, long j) {
            Object objUnmodifiableList;
            List list = (List) e0.A(obj, j);
            if (list instanceof InterfaceC4387Ex3) {
                objUnmodifiableList = ((InterfaceC4387Ex3) list).p();
            } else {
                if (c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof P) && (list instanceof AbstractC1952v.b)) {
                    AbstractC1952v.b bVar = (AbstractC1952v.b) list;
                    if (bVar.u()) {
                        bVar.s();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            e0.O(obj, j, objUnmodifiableList);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1955y
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
            e0.O(obj, j, listF);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1955y
        List e(Object obj, long j) {
            return g(obj, j, 10);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.y$c */
    private static final class c extends AbstractC1955y {
        private c() {
            super();
        }

        static AbstractC1952v.b f(Object obj, long j) {
            return (AbstractC1952v.b) e0.A(obj, j);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1955y
        void c(Object obj, long j) {
            f(obj, j).s();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1955y
        void d(Object obj, Object obj2, long j) {
            AbstractC1952v.b bVarF = f(obj, j);
            AbstractC1952v.b bVarF2 = f(obj2, j);
            int size = bVarF.size();
            int size2 = bVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!bVarF.u()) {
                    bVarF = bVarF.b(size2 + size);
                }
                bVarF.addAll(bVarF2);
            }
            if (size > 0) {
                bVarF2 = bVarF;
            }
            e0.O(obj, j, bVarF2);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1955y
        List e(Object obj, long j) {
            AbstractC1952v.b bVarF = f(obj, j);
            if (bVarF.u()) {
                return bVarF;
            }
            int size = bVarF.size();
            AbstractC1952v.b bVarB = bVarF.b(size == 0 ? 10 : size * 2);
            e0.O(obj, j, bVarB);
            return bVarB;
        }
    }

    static {
        a = new b();
        b = new c();
    }

    private AbstractC1955y() {
    }

    static AbstractC1955y a() {
        return a;
    }

    static AbstractC1955y b() {
        return b;
    }

    abstract void c(Object obj, long j);

    abstract void d(Object obj, Object obj2, long j);

    abstract List e(Object obj, long j);
}
