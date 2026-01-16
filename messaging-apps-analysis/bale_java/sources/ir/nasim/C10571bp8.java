package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.bp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10571bp8 {
    private final AbstractC16197kr8 a;
    private final OV0 b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private final Map i;
    private final List j;

    C10571bp8(C10571bp8 c10571bp8) {
        this.a = c10571bp8.a;
        this.b = c10571bp8.b;
        this.c = c10571bp8.c;
        this.d = c10571bp8.d;
        this.e = c10571bp8.e;
        this.f = c10571bp8.f;
        this.g = c10571bp8.g;
        this.j = new ArrayList(c10571bp8.j);
        this.i = new HashMap(c10571bp8.i.size());
        for (Map.Entry entry : c10571bp8.i.entrySet()) {
            Kq8 kq8E = e((Class) entry.getKey());
            ((Kq8) entry.getValue()).zzc(kq8E);
            this.i.put((Class) entry.getKey(), kq8E);
        }
    }

    private static Kq8 e(Class cls) {
        try {
            return (Kq8) cls.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception e) {
            if (e instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e);
            }
            if (e instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e);
            }
            if (e instanceof ReflectiveOperationException) {
                throw new IllegalArgumentException("Linkage exception", e);
            }
            throw new RuntimeException(e);
        }
    }

    public final Kq8 a(Class cls) {
        Kq8 kq8 = (Kq8) this.i.get(cls);
        if (kq8 != null) {
            return kq8;
        }
        Kq8 kq8E = e(cls);
        this.i.put(cls, kq8E);
        return kq8E;
    }

    public final List b() {
        return this.j;
    }

    public final void c(Kq8 kq8) {
        AbstractC3795Cj5.j(kq8);
        Class<?> cls = kq8.getClass();
        if (cls.getSuperclass() != Kq8.class) {
            throw new IllegalArgumentException();
        }
        kq8.zzc(a(cls));
    }

    final void d() {
        this.h = true;
    }

    C10571bp8(AbstractC16197kr8 abstractC16197kr8, OV0 ov0) {
        AbstractC3795Cj5.j(abstractC16197kr8);
        AbstractC3795Cj5.j(ov0);
        this.a = abstractC16197kr8;
        this.b = ov0;
        this.f = 1800000L;
        this.g = 3024000000L;
        this.i = new HashMap();
        this.j = new ArrayList();
    }
}
