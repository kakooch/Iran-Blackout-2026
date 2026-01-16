package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.clearcut.a0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2072a0 {
    private static final C2072a0 c = new C2072a0();
    private final g0 a;
    private final ConcurrentMap b = new ConcurrentHashMap();

    private C2072a0() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        g0 g0VarC = null;
        for (int i = 0; i <= 0; i++) {
            g0VarC = c(strArr[0]);
            if (g0VarC != null) {
                break;
            }
        }
        this.a = g0VarC == null ? new I() : g0VarC;
    }

    public static C2072a0 a() {
        return c;
    }

    private static g0 c(String str) {
        try {
            return (g0) Class.forName(str).getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final InterfaceC2082f0 b(Class cls) {
        B.e(cls, "messageType");
        InterfaceC2082f0 interfaceC2082f0 = (InterfaceC2082f0) this.b.get(cls);
        if (interfaceC2082f0 != null) {
            return interfaceC2082f0;
        }
        InterfaceC2082f0 interfaceC2082f0A = this.a.a(cls);
        B.e(cls, "messageType");
        B.e(interfaceC2082f0A, "schema");
        InterfaceC2082f0 interfaceC2082f02 = (InterfaceC2082f0) this.b.putIfAbsent(cls, interfaceC2082f0A);
        return interfaceC2082f02 != null ? interfaceC2082f02 : interfaceC2082f0A;
    }

    public final InterfaceC2082f0 d(Object obj) {
        return b(obj.getClass());
    }
}
