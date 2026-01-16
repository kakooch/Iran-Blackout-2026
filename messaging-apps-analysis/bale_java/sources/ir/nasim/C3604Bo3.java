package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* renamed from: ir.nasim.Bo3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3604Bo3 {
    private static final Logger b = Logger.getLogger(C3604Bo3.class.getName());
    private final ConcurrentMap a;

    /* renamed from: ir.nasim.Bo3$a */
    class a implements b {
        final /* synthetic */ AbstractC8110Uo3 a;

        a(AbstractC8110Uo3 abstractC8110Uo3) {
            this.a = abstractC8110Uo3;
        }

        @Override // ir.nasim.C3604Bo3.b
        public Class a() {
            return this.a.getClass();
        }

        @Override // ir.nasim.C3604Bo3.b
        public Set b() {
            return this.a.i();
        }

        @Override // ir.nasim.C3604Bo3.b
        public InterfaceC25145zo3 c(Class cls) throws GeneralSecurityException {
            try {
                return new C3365Ao3(this.a, cls);
            } catch (IllegalArgumentException e) {
                throw new GeneralSecurityException("Primitive type not supported", e);
            }
        }

        @Override // ir.nasim.C3604Bo3.b
        public InterfaceC25145zo3 d() {
            AbstractC8110Uo3 abstractC8110Uo3 = this.a;
            return new C3365Ao3(abstractC8110Uo3, abstractC8110Uo3.b());
        }
    }

    /* renamed from: ir.nasim.Bo3$b */
    private interface b {
        Class a();

        Set b();

        InterfaceC25145zo3 c(Class cls);

        InterfaceC25145zo3 d();
    }

    C3604Bo3(C3604Bo3 c3604Bo3) {
        this.a = new ConcurrentHashMap(c3604Bo3.a);
    }

    private static b a(AbstractC8110Uo3 abstractC8110Uo3) {
        return new a(abstractC8110Uo3);
    }

    private synchronized b c(String str) {
        if (!this.a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (b) this.a.get(str);
    }

    private synchronized void f(b bVar, boolean z) {
        try {
            String strB = bVar.d().b();
            b bVar2 = (b) this.a.get(strB);
            if (bVar2 != null && !bVar2.a().equals(bVar.a())) {
                b.warning("Attempted overwrite of a registered key manager for key type " + strB);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strB, bVar2.a().getName(), bVar.a().getName()));
            }
            if (z) {
                this.a.put(strB, bVar);
            } else {
                this.a.putIfAbsent(strB, bVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String g(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls.getCanonicalName());
            z = false;
        }
        return sb.toString();
    }

    InterfaceC25145zo3 b(String str, Class cls) throws GeneralSecurityException {
        b bVarC = c(str);
        if (bVarC.b().contains(cls)) {
            return bVarC.c(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + bVarC.a() + ", supported primitives: " + g(bVarC.b()));
    }

    InterfaceC25145zo3 d(String str) {
        return c(str).d();
    }

    synchronized void e(AbstractC8110Uo3 abstractC8110Uo3) {
        if (!abstractC8110Uo3.a().a()) {
            throw new GeneralSecurityException("failed to register key manager " + abstractC8110Uo3.getClass() + " as it is not FIPS compatible.");
        }
        f(a(abstractC8110Uo3), false);
    }

    boolean h(String str) {
        return this.a.containsKey(str);
    }

    C3604Bo3() {
        this.a = new ConcurrentHashMap();
    }
}
