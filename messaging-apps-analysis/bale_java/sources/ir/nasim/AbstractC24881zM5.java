package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* renamed from: ir.nasim.zM5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24881zM5 {
    private static final Logger a = Logger.getLogger(AbstractC24881zM5.class.getName());
    private static final AtomicReference b = new AtomicReference(new C3604Bo3());
    private static final ConcurrentMap c = new ConcurrentHashMap();
    private static final ConcurrentMap d = new ConcurrentHashMap();
    private static final ConcurrentMap e = new ConcurrentHashMap();

    /* renamed from: ir.nasim.zM5$a */
    class a implements b {
        final /* synthetic */ AbstractC8110Uo3 a;

        a(AbstractC8110Uo3 abstractC8110Uo3) {
            this.a = abstractC8110Uo3;
        }
    }

    /* renamed from: ir.nasim.zM5$b */
    private interface b {
    }

    private static b a(AbstractC8110Uo3 abstractC8110Uo3) {
        return new a(abstractC8110Uo3);
    }

    private static synchronized void b(String str, boolean z) {
        if (z) {
            ConcurrentMap concurrentMap = d;
            if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
            }
        }
    }

    public static Class c(Class cls) {
        try {
            return C5006Hm4.c().a(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object d(C20317ro3 c20317ro3, Class cls) {
        return e(c20317ro3.X(), c20317ro3.Y(), cls);
    }

    public static Object e(String str, AbstractC2345g abstractC2345g, Class cls) {
        return ((C3604Bo3) b.get()).b(str, cls).c(abstractC2345g);
    }

    public static Object f(String str, byte[] bArr, Class cls) {
        return e(str, AbstractC2345g.C(bArr), cls);
    }

    public static synchronized C20317ro3 g(C6691Oo3 c6691Oo3) {
        InterfaceC25145zo3 interfaceC25145zo3D;
        interfaceC25145zo3D = ((C3604Bo3) b.get()).d(c6691Oo3.X());
        if (!((Boolean) d.get(c6691Oo3.X())).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + c6691Oo3.X());
        }
        return interfaceC25145zo3D.a(c6691Oo3.Y());
    }

    public static synchronized void h(AbstractC8110Uo3 abstractC8110Uo3, boolean z) {
        try {
            if (abstractC8110Uo3 == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference atomicReference = b;
            C3604Bo3 c3604Bo3 = new C3604Bo3((C3604Bo3) atomicReference.get());
            c3604Bo3.e(abstractC8110Uo3);
            String strD = abstractC8110Uo3.d();
            b(strD, z);
            if (!((C3604Bo3) atomicReference.get()).h(strD)) {
                c.put(strD, a(abstractC8110Uo3));
            }
            d.put(strD, Boolean.valueOf(z));
            atomicReference.set(c3604Bo3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void i(InterfaceC5277Iq5 interfaceC5277Iq5) {
        C5006Hm4.c().e(interfaceC5277Iq5);
    }

    public static Object j(C4092Dq5 c4092Dq5, Class cls) {
        return C5006Hm4.c().f(c4092Dq5, cls);
    }
}
