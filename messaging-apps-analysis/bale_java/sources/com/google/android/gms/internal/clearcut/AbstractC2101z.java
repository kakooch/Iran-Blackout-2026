package com.google.android.gms.internal.clearcut;

import ir.nasim.Gi8;
import ir.nasim.InterfaceC20302rm8;
import ir.nasim.InterfaceC21580tm8;
import ir.nasim.InterfaceC25120zl8;
import ir.nasim.Ji8;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.clearcut.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2101z extends AbstractC2071a {
    private static Map<Object, AbstractC2101z> zzjr = new ConcurrentHashMap();
    protected m0 zzjp = m0.h();
    private int zzjq = -1;

    /* renamed from: com.google.android.gms.internal.clearcut.z$a */
    public static abstract class a extends Gi8 {
        private final AbstractC2101z a;
        protected AbstractC2101z b;
        protected boolean c = false;

        protected a(AbstractC2101z abstractC2101z) {
            this.a = abstractC2101z;
            this.b = (AbstractC2101z) abstractC2101z.i(c.d, null, null);
        }

        private static void k(AbstractC2101z abstractC2101z, AbstractC2101z abstractC2101z2) {
            C2072a0.a().d(abstractC2101z).g(abstractC2101z, abstractC2101z2);
        }

        public /* synthetic */ Object clone() {
            a aVar = (a) this.a.i(c.e, null, null);
            aVar.h((AbstractC2101z) s0());
            return aVar;
        }

        @Override // ir.nasim.InterfaceC22760vm8
        public final /* synthetic */ InterfaceC20302rm8 f() {
            return this.a;
        }

        @Override // ir.nasim.Gi8
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final a h(AbstractC2101z abstractC2101z) {
            l();
            k(this.b, abstractC2101z);
            return this;
        }

        protected void l() {
            if (this.c) {
                AbstractC2101z abstractC2101z = (AbstractC2101z) this.b.i(c.d, null, null);
                k(abstractC2101z, this.b);
                this.b = abstractC2101z;
                this.c = false;
            }
        }

        @Override // ir.nasim.InterfaceC21580tm8
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public AbstractC2101z s0() {
            if (this.c) {
                return this.b;
            }
            AbstractC2101z abstractC2101z = this.b;
            C2072a0.a().d(abstractC2101z).a(abstractC2101z);
            this.c = true;
            return this.b;
        }

        public final AbstractC2101z n() {
            AbstractC2101z abstractC2101z = (AbstractC2101z) s0();
            byte bByteValue = ((Byte) abstractC2101z.i(c.a, null, null)).byteValue();
            boolean zF = true;
            if (bByteValue != 1) {
                if (bByteValue == 0) {
                    zF = false;
                } else {
                    zF = C2072a0.a().d(abstractC2101z).f(abstractC2101z);
                    abstractC2101z.i(c.b, zF ? abstractC2101z : null, null);
                }
            }
            if (zF) {
                return abstractC2101z;
            }
            throw new zzew(abstractC2101z);
        }
    }

    /* renamed from: com.google.android.gms.internal.clearcut.z$b */
    public static class b extends Ji8 {
        private AbstractC2101z b;

        public b(AbstractC2101z abstractC2101z) {
            this.b = abstractC2101z;
        }
    }

    /* renamed from: com.google.android.gms.internal.clearcut.z$c */
    public enum c {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        private static final /* synthetic */ int[] h = {1, 2, 3, 4, 5, 6, 7};
        public static final int i = 1;
        public static final int j = 2;
        private static final /* synthetic */ int[] k = {1, 2};
        public static final int l = 1;
        public static final int m = 2;
        private static final /* synthetic */ int[] n = {1, 2};

        public static int[] a() {
            return (int[]) h.clone();
        }
    }

    private static AbstractC2101z h(AbstractC2101z abstractC2101z, byte[] bArr) throws zzco {
        AbstractC2101z abstractC2101z2 = (AbstractC2101z) abstractC2101z.i(c.d, null, null);
        try {
            C2072a0.a().d(abstractC2101z2).i(abstractC2101z2, bArr, 0, bArr.length, new C2079e());
            C2072a0.a().d(abstractC2101z2).a(abstractC2101z2);
            if (abstractC2101z2.zzex == 0) {
                return abstractC2101z2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzco) {
                throw ((zzco) e.getCause());
            }
            throw new zzco(e.getMessage()).f(abstractC2101z2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzco.a().f(abstractC2101z2);
        }
    }

    protected static Object j(InterfaceC20302rm8 interfaceC20302rm8, String str, Object[] objArr) {
        return new C2076c0(interfaceC20302rm8, str, objArr);
    }

    static Object k(Method method, Object obj, Object... objArr) {
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

    protected static void l(Class cls, AbstractC2101z abstractC2101z) {
        zzjr.put(cls, abstractC2101z);
    }

    protected static AbstractC2101z m(AbstractC2101z abstractC2101z, byte[] bArr) throws zzco {
        AbstractC2101z abstractC2101zH = h(abstractC2101z, bArr);
        if (abstractC2101zH != null) {
            byte bByteValue = ((Byte) abstractC2101zH.i(c.a, null, null)).byteValue();
            boolean zF = true;
            if (bByteValue != 1) {
                if (bByteValue == 0) {
                    zF = false;
                } else {
                    zF = C2072a0.a().d(abstractC2101zH).f(abstractC2101zH);
                    abstractC2101zH.i(c.b, zF ? abstractC2101zH : null, null);
                }
            }
            if (!zF) {
                throw new zzco(new zzew(abstractC2101zH).getMessage()).f(abstractC2101zH);
            }
        }
        return abstractC2101zH;
    }

    protected static InterfaceC25120zl8 n() {
        return C2074b0.h();
    }

    static AbstractC2101z o(Class cls) throws ClassNotFoundException {
        AbstractC2101z abstractC2101z = zzjr.get(cls);
        if (abstractC2101z == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC2101z = zzjr.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC2101z != null) {
            return abstractC2101z;
        }
        String name = cls.getName();
        throw new IllegalStateException(name.length() != 0 ? "Unable to get default instance for: ".concat(name) : new String("Unable to get default instance for: "));
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2071a
    final void a(int i) {
        this.zzjq = i;
    }

    @Override // ir.nasim.InterfaceC20302rm8
    public final /* synthetic */ InterfaceC21580tm8 b() {
        a aVar = (a) i(c.e, null, null);
        aVar.h(this);
        return aVar;
    }

    @Override // ir.nasim.InterfaceC20302rm8
    public final void c(zzbn zzbnVar) {
        C2072a0.a().b(getClass()).e(this, C2094s.l(zzbnVar));
    }

    @Override // ir.nasim.InterfaceC20302rm8
    public final /* synthetic */ InterfaceC21580tm8 d() {
        return (a) i(c.e, null, null);
    }

    @Override // ir.nasim.InterfaceC20302rm8
    public final int e() {
        if (this.zzjq == -1) {
            this.zzjq = C2072a0.a().d(this).h(this);
        }
        return this.zzjq;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((AbstractC2101z) i(c.f, null, null)).getClass().isInstance(obj)) {
            return C2072a0.a().d(this).c(this, (AbstractC2101z) obj);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC22760vm8
    public final /* synthetic */ InterfaceC20302rm8 f() {
        return (AbstractC2101z) i(c.f, null, null);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2071a
    final int g() {
        return this.zzjq;
    }

    public int hashCode() {
        int i = this.zzex;
        if (i != 0) {
            return i;
        }
        int iB = C2072a0.a().d(this).b(this);
        this.zzex = iB;
        return iB;
    }

    protected abstract Object i(int i, Object obj, Object obj2);

    public String toString() {
        return U.a(this, super.toString());
    }
}
