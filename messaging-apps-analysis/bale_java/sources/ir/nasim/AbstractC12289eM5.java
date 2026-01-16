package ir.nasim;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.eM5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12289eM5 {

    /* renamed from: ir.nasim.eM5$b */
    private static abstract class b {
        public static final b a;

        /* renamed from: ir.nasim.eM5$b$a */
        class a extends b {
            final /* synthetic */ Method b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.b = method;
            }

            @Override // ir.nasim.AbstractC12289eM5.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e) {
                    throw new RuntimeException("Failed invoking canAccess", e);
                }
            }
        }

        /* renamed from: ir.nasim.eM5$b$b, reason: collision with other inner class name */
        class C1050b extends b {
            C1050b() {
                super();
            }

            @Override // ir.nasim.AbstractC12289eM5.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (AbstractC9299Zi3.d()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C1050b();
            }
            a = aVar;
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.a.a(accessibleObject, obj);
    }

    public static EnumC11646dM5 b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return EnumC11646dM5.ALLOW;
        }
        AbstractC18350oW3.a(it.next());
        throw null;
    }
}
