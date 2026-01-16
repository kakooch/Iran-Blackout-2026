package ir.nasim;

import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.dm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11921dm3 {
    private static C23176wU2 a;

    static {
        C23176wU2 c23176wU2B = C23176wU2.b();
        AbstractC13042fc3.h(c23176wU2B, "HashPMap.empty<String, Any>()");
        a = c23176wU2B;
    }

    public static final C12533em3 a(Class cls) {
        AbstractC13042fc3.i(cls, "jClass");
        String name = cls.getName();
        Object objC = a.c(name);
        if (objC instanceof WeakReference) {
            C12533em3 c12533em3 = (C12533em3) ((WeakReference) objC).get();
            if (AbstractC13042fc3.d(c12533em3 != null ? c12533em3.e() : null, cls)) {
                return c12533em3;
            }
        } else if (objC != null) {
            for (WeakReference weakReference : (WeakReference[]) objC) {
                C12533em3 c12533em32 = (C12533em3) weakReference.get();
                if (AbstractC13042fc3.d(c12533em32 != null ? c12533em32.e() : null, cls)) {
                    return c12533em32;
                }
            }
            int length = ((Object[]) objC).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(objC, 0, weakReferenceArr, 0, length);
            C12533em3 c12533em33 = new C12533em3(cls);
            weakReferenceArr[length] = new WeakReference(c12533em33);
            C23176wU2 c23176wU2F = a.f(name, weakReferenceArr);
            AbstractC13042fc3.h(c23176wU2F, "K_CLASS_CACHE.plus(name, newArray)");
            a = c23176wU2F;
            return c12533em33;
        }
        C12533em3 c12533em34 = new C12533em3(cls);
        C23176wU2 c23176wU2F2 = a.f(name, new WeakReference(c12533em34));
        AbstractC13042fc3.h(c23176wU2F2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        a = c23176wU2F2;
        return c12533em34;
    }
}
