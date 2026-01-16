package com.google.android.gms.internal.measurement;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC19152pr8;
import ir.nasim.InterfaceC19743qr8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Pr8;
import ir.nasim.Qr8;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class P0 extends AbstractC2137o0 {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected t1 zzc = t1.c();

    private final int h(o1 o1Var) {
        return o1Var == null ? l1.a().b(getClass()).h(this) : o1Var.h(this);
    }

    protected static InterfaceC19152pr8 j() {
        return Q0.i();
    }

    protected static InterfaceC19743qr8 k() {
        return W0.h();
    }

    protected static InterfaceC19743qr8 l(InterfaceC19743qr8 interfaceC19743qr8) {
        int size = interfaceC19743qr8.size();
        return interfaceC19743qr8.K(size == 0 ? 10 : size + size);
    }

    protected static InterfaceC20943sr8 m() {
        return m1.h();
    }

    protected static InterfaceC20943sr8 n(InterfaceC20943sr8 interfaceC20943sr8) {
        int size = interfaceC20943sr8.size();
        return interfaceC20943sr8.K(size == 0 ? 10 : size + size);
    }

    static Object o(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object p(Qr8 qr8, String str, Object[] objArr) {
        return new n1(qr8, str, objArr);
    }

    protected static void s(Class cls, P0 p0) {
        zza.put(cls, p0);
        p0.q();
    }

    static P0 y(Class cls) throws ClassNotFoundException {
        Map map = zza;
        P0 p0 = (P0) map.get(cls);
        if (p0 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                p0 = (P0) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (p0 == null) {
            p0 = (P0) ((P0) z1.j(cls)).z(6, null, null);
            if (p0 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, p0);
        }
        return p0;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC2137o0
    final int a(o1 o1Var) {
        if (u()) {
            int iH = h(o1Var);
            if (iH >= 0) {
                return iH;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iH);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iH2 = h(o1Var);
        if (iH2 >= 0) {
            this.zzd = (this.zzd & RecyclerView.UNDEFINED_DURATION) | iH2;
            return iH2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iH2);
    }

    @Override // ir.nasim.Qr8
    public final void b(E0 e0) {
        l1.a().b(getClass()).l(this, F0.K(e0));
    }

    @Override // ir.nasim.Qr8
    public final /* synthetic */ Pr8 c() {
        return (O0) z(5, null, null);
    }

    @Override // ir.nasim.Qr8
    public final int d() {
        int iH;
        if (u()) {
            iH = h(null);
            if (iH < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iH);
            }
        } else {
            iH = this.zzd & Integer.MAX_VALUE;
            if (iH == Integer.MAX_VALUE) {
                iH = h(null);
                if (iH < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iH);
                }
                this.zzd = (this.zzd & RecyclerView.UNDEFINED_DURATION) | iH;
            }
        }
        return iH;
    }

    @Override // ir.nasim.Rr8
    public final /* synthetic */ Qr8 e() {
        return (P0) z(6, null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return l1.a().b(getClass()).m(this, (P0) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (u()) {
            return v();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iV = v();
        this.zzb = iV;
        return iV;
    }

    final P0 i() {
        return (P0) z(4, null, null);
    }

    protected final void q() {
        l1.a().b(getClass()).j(this);
        r();
    }

    final void r() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void t(int i) {
        this.zzd = (this.zzd & RecyclerView.UNDEFINED_DURATION) | Integer.MAX_VALUE;
    }

    public final String toString() {
        return AbstractC2119f1.a(this, super.toString());
    }

    final boolean u() {
        return (this.zzd & RecyclerView.UNDEFINED_DURATION) != 0;
    }

    final int v() {
        return l1.a().b(getClass()).i(this);
    }

    protected final O0 w() {
        return (O0) z(5, null, null);
    }

    public final O0 x() {
        O0 o0 = (O0) z(5, null, null);
        o0.k(this);
        return o0;
    }

    protected abstract Object z(int i, Object obj, Object obj2);
}
