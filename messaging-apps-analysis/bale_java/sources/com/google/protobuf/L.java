package com.google.protobuf;

import com.google.protobuf.I;
import java.util.Map;

/* loaded from: classes3.dex */
class L implements K {
    L() {
    }

    private static int i(int i, Object obj, Object obj2) {
        J j = (J) obj;
        I i2 = (I) obj2;
        int iA = 0;
        if (j.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : j.entrySet()) {
            iA += i2.a(i, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    private static J j(Object obj, Object obj2) {
        J jS = (J) obj;
        J j = (J) obj2;
        if (!j.isEmpty()) {
            if (!jS.n()) {
                jS = jS.s();
            }
            jS.q(j);
        }
        return jS;
    }

    @Override // com.google.protobuf.K
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.K
    public I.a b(Object obj) {
        return ((I) obj).c();
    }

    @Override // com.google.protobuf.K
    public Map c(Object obj) {
        return (J) obj;
    }

    @Override // com.google.protobuf.K
    public Object d(Object obj) {
        return J.e().s();
    }

    @Override // com.google.protobuf.K
    public Map e(Object obj) {
        return (J) obj;
    }

    @Override // com.google.protobuf.K
    public Object f(Object obj) {
        ((J) obj).p();
        return obj;
    }

    @Override // com.google.protobuf.K
    public int g(int i, Object obj, Object obj2) {
        return i(i, obj, obj2);
    }

    @Override // com.google.protobuf.K
    public boolean h(Object obj) {
        return !((J) obj).n();
    }
}
