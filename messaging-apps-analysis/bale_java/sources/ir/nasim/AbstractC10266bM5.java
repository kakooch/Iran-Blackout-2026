package ir.nasim;

import java.lang.ref.SoftReference;

/* renamed from: ir.nasim.bM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10266bM5 {

    /* renamed from: ir.nasim.bM5$a */
    public static class a extends c implements SA2 {
        private final SA2 b;
        private volatile SoftReference c;

        public a(Object obj, SA2 sa2) {
            if (sa2 == null) {
                d(0);
            }
            this.c = null;
            this.b = sa2;
            if (obj != null) {
                this.c = new SoftReference(a(obj));
            }
        }

        private static /* synthetic */ void d(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // ir.nasim.AbstractC10266bM5.c, ir.nasim.SA2
        public Object invoke() {
            Object obj;
            SoftReference softReference = this.c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            Object objInvoke = this.b.invoke();
            this.c = new SoftReference(a(objInvoke));
            return objInvoke;
        }
    }

    /* renamed from: ir.nasim.bM5$b */
    public static class b extends c {
        private final SA2 b;
        private volatile Object c;

        public b(SA2 sa2) {
            if (sa2 == null) {
                d(0);
            }
            this.c = null;
            this.b = sa2;
        }

        private static /* synthetic */ void d(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // ir.nasim.AbstractC10266bM5.c, ir.nasim.SA2
        public Object invoke() {
            Object obj = this.c;
            if (obj != null) {
                return c(obj);
            }
            Object objInvoke = this.b.invoke();
            this.c = a(objInvoke);
            return objInvoke;
        }
    }

    /* renamed from: ir.nasim.bM5$c */
    public static abstract class c {
        private static final Object a = new a();

        /* renamed from: ir.nasim.bM5$c$a */
        static class a {
            a() {
            }
        }

        protected Object a(Object obj) {
            return obj == null ? a : obj;
        }

        public final Object b(Object obj, Object obj2) {
            return invoke();
        }

        protected Object c(Object obj) {
            if (obj == a) {
                return null;
            }
            return obj;
        }

        public abstract Object invoke();
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static b b(SA2 sa2) {
        if (sa2 == null) {
            a(0);
        }
        return new b(sa2);
    }

    public static a c(SA2 sa2) {
        if (sa2 == null) {
            a(2);
        }
        return d(null, sa2);
    }

    public static a d(Object obj, SA2 sa2) {
        if (sa2 == null) {
            a(1);
        }
        return new a(obj, sa2);
    }
}
