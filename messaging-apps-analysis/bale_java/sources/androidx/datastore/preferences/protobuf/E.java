package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.B;
import java.util.Map;

/* loaded from: classes2.dex */
class E implements D {
    E() {
    }

    private static int i(int i, Object obj, Object obj2) {
        C c = (C) obj;
        B b = (B) obj2;
        int iA = 0;
        if (c.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : c.entrySet()) {
            iA += b.a(i, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    private static C j(Object obj, Object obj2) {
        C cS = (C) obj;
        C c = (C) obj2;
        if (!c.isEmpty()) {
            if (!cS.n()) {
                cS = cS.s();
            }
            cS.q(c);
        }
        return cS;
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public B.a b(Object obj) {
        return ((B) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public Map c(Object obj) {
        return (C) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public Object d(Object obj) {
        return C.e().s();
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public Map e(Object obj) {
        return (C) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public Object f(Object obj) {
        ((C) obj).p();
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public int g(int i, Object obj, Object obj2) {
        return i(i, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.D
    public boolean h(Object obj) {
        return !((C) obj).n();
    }
}
