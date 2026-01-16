package io.sentry;

import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class I {
    private static final Map h;
    private final Map a = new HashMap();
    private final List b = new ArrayList();
    private final C3202a c = new C3202a();
    private C3091b d = null;
    private C3091b e = null;
    private C3091b f = null;
    private C3222x1 g = null;

    static {
        HashMap map = new HashMap();
        h = map;
        map.put("boolean", Boolean.class);
        map.put("char", Character.class);
        map.put("byte", Byte.class);
        map.put("short", Short.class);
        map.put("int", Integer.class);
        map.put("long", Long.class);
        map.put("float", Float.class);
        map.put("double", Double.class);
    }

    private boolean j(Object obj, Class cls) {
        Class cls2 = (Class) h.get(cls.getCanonicalName());
        return obj != null && cls.isPrimitive() && cls2 != null && cls2.isInstance(obj);
    }

    public void a(List list) {
        if (list != null) {
            this.b.addAll(list);
        }
    }

    public void b() {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            Iterator it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getKey() == null || !((String) entry.getKey()).startsWith("sentry:")) {
                    it.remove();
                }
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Object c(String str) {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            Object obj = this.a.get(str);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return obj;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Object d(String str, Class cls) {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            Object obj = this.a.get(str);
            if (cls.isInstance(obj)) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return obj;
            }
            if (j(obj, cls)) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return obj;
            }
            if (interfaceC3102d0A == null) {
                return null;
            }
            interfaceC3102d0A.close();
            return null;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public List e() {
        return new ArrayList(this.b);
    }

    public C3222x1 f() {
        return this.g;
    }

    public C3091b g() {
        return this.d;
    }

    public C3091b h() {
        return this.f;
    }

    public C3091b i() {
        return this.e;
    }

    public void k(String str, Object obj) {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            this.a.put(str, obj);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void l(C3222x1 c3222x1) {
        this.g = c3222x1;
    }

    public void m(C3091b c3091b) {
        this.d = c3091b;
    }

    public void n(C3091b c3091b) {
        this.f = c3091b;
    }

    public void o(C3091b c3091b) {
        this.e = c3091b;
    }
}
