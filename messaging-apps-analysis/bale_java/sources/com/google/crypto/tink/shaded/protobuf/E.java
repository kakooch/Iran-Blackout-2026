package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.B;
import ir.nasim.AbstractC18350oW3;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
class E implements D {
    E() {
    }

    private static int i(int i, Object obj, Object obj2) {
        C c = (C) obj;
        AbstractC18350oW3.a(obj2);
        if (c.isEmpty()) {
            return 0;
        }
        Iterator it = c.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
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

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public B.a b(Object obj) {
        AbstractC18350oW3.a(obj);
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public Map c(Object obj) {
        return (C) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public Object d(Object obj) {
        return C.e().s();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public Map e(Object obj) {
        return (C) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public Object f(Object obj) {
        ((C) obj).p();
        return obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public int g(int i, Object obj, Object obj2) {
        return i(i, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.D
    public boolean h(Object obj) {
        return !((C) obj).n();
    }
}
