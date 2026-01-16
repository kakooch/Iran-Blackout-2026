package androidx.lifecycle;

import androidx.lifecycle.C1966b;
import androidx.lifecycle.j;
import ir.nasim.InterfaceC18633oz3;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
class v implements n {
    private final Object a;
    private final C1966b.a b;

    v(Object obj) {
        this.a = obj;
        this.b = C1966b.c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.n
    public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.b.a(interfaceC18633oz3, aVar, this.a);
    }
}
