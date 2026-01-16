package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC17359mp8;
import ir.nasim.AbstractC19132pp8;
import ir.nasim.AbstractC19142pq8;
import ir.nasim.InterfaceC18561or8;
import ir.nasim.InterfaceC21630tr8;
import ir.nasim.Sq8;
import ir.nasim.Tq8;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.vision.j0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2178j0 extends D {
    private static Map<Object, AbstractC2178j0> zzd = new ConcurrentHashMap();
    protected h1 zzb = h1.a();
    private int zzc = -1;

    /* renamed from: com.google.android.gms.internal.vision.j0$a */
    protected static class a extends AbstractC19132pp8 {
        private final AbstractC2178j0 b;

        public a(AbstractC2178j0 abstractC2178j0) {
            this.b = abstractC2178j0;
        }
    }

    /* renamed from: com.google.android.gms.internal.vision.j0$b */
    public static abstract class b extends AbstractC17359mp8 {
        private final AbstractC2178j0 a;
        protected AbstractC2178j0 b;
        protected boolean c = false;

        protected b(AbstractC2178j0 abstractC2178j0) {
            this.a = abstractC2178j0;
            this.b = (AbstractC2178j0) abstractC2178j0.m(d.d, null, null);
        }

        private static void h(AbstractC2178j0 abstractC2178j0, AbstractC2178j0 abstractC2178j02) {
            M0.a().c(abstractC2178j0).d(abstractC2178j0, abstractC2178j02);
        }

        private final b m(byte[] bArr, int i, int i2, C2162b0 c2162b0) throws zzjk {
            if (this.c) {
                n();
                this.c = false;
            }
            try {
                M0.a().c(this.b).f(this.b, bArr, 0, i2, new H(c2162b0));
                return this;
            } catch (zzjk e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzjk.a();
            }
        }

        public /* synthetic */ Object clone() {
            b bVar = (b) this.a.m(d.e, null, null);
            bVar.c((AbstractC2178j0) g());
            return bVar;
        }

        @Override // ir.nasim.AbstractC17359mp8
        public final /* synthetic */ AbstractC17359mp8 d(byte[] bArr, int i, int i2, C2162b0 c2162b0) {
            return m(bArr, 0, i2, c2162b0);
        }

        @Override // ir.nasim.AbstractC17359mp8
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b c(AbstractC2178j0 abstractC2178j0) {
            if (this.c) {
                n();
                this.c = false;
            }
            h(this.b, abstractC2178j0);
            return this;
        }

        @Override // ir.nasim.InterfaceC20352rr8
        public final /* synthetic */ InterfaceC18561or8 l() {
            return this.a;
        }

        protected void n() {
            AbstractC2178j0 abstractC2178j0 = (AbstractC2178j0) this.b.m(d.d, null, null);
            h(abstractC2178j0, this.b);
            this.b = abstractC2178j0;
        }

        @Override // ir.nasim.InterfaceC21630tr8
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public AbstractC2178j0 g() {
            if (this.c) {
                return this.b;
            }
            AbstractC2178j0 abstractC2178j0 = this.b;
            M0.a().c(abstractC2178j0).a(abstractC2178j0);
            this.c = true;
            return this.b;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public final AbstractC2178j0 q() {
            AbstractC2178j0 abstractC2178j0 = (AbstractC2178j0) g();
            if (abstractC2178j0.s()) {
                return abstractC2178j0;
            }
            throw new zzlv(abstractC2178j0);
        }
    }

    /* renamed from: com.google.android.gms.internal.vision.j0$c */
    public static class c extends AbstractC19142pq8 {
    }

    /* renamed from: com.google.android.gms.internal.vision.j0$d */
    public enum d {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        private static final /* synthetic */ int[] h = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) h.clone();
        }
    }

    static AbstractC2178j0 h(Class cls) throws ClassNotFoundException {
        AbstractC2178j0 abstractC2178j0 = zzd.get(cls);
        if (abstractC2178j0 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC2178j0 = zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC2178j0 == null) {
            abstractC2178j0 = (AbstractC2178j0) ((AbstractC2178j0) i1.c(cls)).m(d.f, null, null);
            if (abstractC2178j0 == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, abstractC2178j0);
        }
        return abstractC2178j0;
    }

    protected static Tq8 j(Tq8 tq8) {
        int size = tq8.size();
        return tq8.zza(size == 0 ? 10 : size << 1);
    }

    protected static Object n(InterfaceC18561or8 interfaceC18561or8, String str, Object[] objArr) {
        return new N0(interfaceC18561or8, str, objArr);
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

    protected static void p(Class cls, AbstractC2178j0 abstractC2178j0) {
        zzd.put(cls, abstractC2178j0);
    }

    protected static final boolean q(AbstractC2178j0 abstractC2178j0, boolean z) {
        byte bByteValue = ((Byte) abstractC2178j0.m(d.a, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zB = M0.a().c(abstractC2178j0).b(abstractC2178j0);
        if (z) {
            abstractC2178j0.m(d.b, zB ? abstractC2178j0 : null, null);
        }
        return zB;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.l0, ir.nasim.Sq8] */
    protected static Sq8 t() {
        return C2182l0.j();
    }

    protected static Tq8 u() {
        return O0.j();
    }

    @Override // ir.nasim.InterfaceC18561or8
    public final /* synthetic */ InterfaceC21630tr8 b() {
        b bVar = (b) m(d.e, null, null);
        bVar.c(this);
        return bVar;
    }

    @Override // com.google.android.gms.internal.vision.D
    final void c(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.D
    final int e() {
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return M0.a().c(this).c(this, (AbstractC2178j0) obj);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC18561or8
    public final int f() {
        if (this.zzc == -1) {
            this.zzc = M0.a().c(this).i(this);
        }
        return this.zzc;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iH = M0.a().c(this).h(this);
        this.zza = iH;
        return iH;
    }

    @Override // ir.nasim.InterfaceC18561or8
    public final /* synthetic */ InterfaceC21630tr8 i() {
        return (b) m(d.e, null, null);
    }

    @Override // ir.nasim.InterfaceC18561or8
    public final void k(zzii zziiVar) {
        M0.a().c(this).e(this, Z.h(zziiVar));
    }

    @Override // ir.nasim.InterfaceC20352rr8
    public final /* synthetic */ InterfaceC18561or8 l() {
        return (AbstractC2178j0) m(d.f, null, null);
    }

    protected abstract Object m(int i, Object obj, Object obj2);

    protected final b r() {
        return (b) m(d.e, null, null);
    }

    public final boolean s() {
        return q(this, true);
    }

    public String toString() {
        return G0.a(this, super.toString());
    }
}
