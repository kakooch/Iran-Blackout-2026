package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: ir.nasim.iI3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C14671iI3 implements ON6 {
    private static final String d = AbstractC20762sZ6.j1(C14671iI3.class.getCanonicalName(), Separators.DOT, "");
    public static final ON6 e = new a("NO_LOCKS", f.a, I72.b);
    protected final MC6 a;
    private final f b;
    private final String c;

    /* renamed from: ir.nasim.iI3$a */
    static class a extends C14671iI3 {
        a(String str, f fVar, MC6 mc6) {
            super(str, fVar, mc6, null);
        }

        private static /* synthetic */ void j(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 1 ? 3 : 2];
            if (i != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String str2 = String.format(str, objArr);
            if (i == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // ir.nasim.C14671iI3
        protected o p(String str, Object obj) {
            if (str == null) {
                j(0);
            }
            o oVarA = o.a();
            if (oVarA == null) {
                j(1);
            }
            return oVarA;
        }
    }

    /* renamed from: ir.nasim.iI3$b */
    class b extends j {
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C14671iI3 c14671iI3, SA2 sa2, Object obj) {
            super(c14671iI3, sa2);
            this.d = obj;
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // ir.nasim.C14671iI3.h
        protected o c(boolean z) {
            o oVarD = o.d(this.d);
            if (oVarD == null) {
                a(0);
            }
            return oVarD;
        }
    }

    /* renamed from: ir.nasim.iI3$c */
    class c extends k {
        final /* synthetic */ UA2 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C14671iI3 c14671iI3, SA2 sa2, UA2 ua2, UA2 ua22) {
            super(c14671iI3, sa2);
            this.e = ua2;
            this.f = ua22;
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 2 ? 2 : 3];
            if (i != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i == 2) {
                objArr[2] = "doPostCompute";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // ir.nasim.C14671iI3.h
        protected o c(boolean z) {
            UA2 ua2 = this.e;
            if (ua2 == null) {
                o oVarC = super.c(z);
                if (oVarC == null) {
                    a(0);
                }
                return oVarC;
            }
            o oVarD = o.d(ua2.invoke(Boolean.valueOf(z)));
            if (oVarD == null) {
                a(1);
            }
            return oVarD;
        }

        @Override // ir.nasim.C14671iI3.i
        protected void d(Object obj) {
            if (obj == null) {
                a(2);
            }
            this.f.invoke(obj);
        }
    }

    /* renamed from: ir.nasim.iI3$d */
    private static class d extends e implements InterfaceC20324rp0 {
        /* synthetic */ d(C14671iI3 c14671iI3, ConcurrentMap concurrentMap, a aVar) {
            this(c14671iI3, concurrentMap);
        }

        private static /* synthetic */ void b(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // ir.nasim.C14671iI3.e, ir.nasim.InterfaceC20324rp0
        public Object a(Object obj, SA2 sa2) {
            if (sa2 == null) {
                b(2);
            }
            Object objA = super.a(obj, sa2);
            if (objA == null) {
                b(3);
            }
            return objA;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(C14671iI3 c14671iI3, ConcurrentMap concurrentMap) {
            super(c14671iI3, concurrentMap, null);
            if (c14671iI3 == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }
    }

    /* renamed from: ir.nasim.iI3$e */
    private static class e extends l implements InterfaceC20915sp0 {

        /* renamed from: ir.nasim.iI3$e$a */
        class a implements UA2 {
            a() {
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Object invoke(g gVar) {
                return gVar.b.invoke();
            }
        }

        /* synthetic */ e(C14671iI3 c14671iI3, ConcurrentMap concurrentMap, a aVar) {
            this(c14671iI3, concurrentMap);
        }

        private static /* synthetic */ void b(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public Object a(Object obj, SA2 sa2) {
            if (sa2 == null) {
                b(2);
            }
            return invoke(new g(obj, sa2));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(C14671iI3 c14671iI3, ConcurrentMap concurrentMap) {
            super(c14671iI3, concurrentMap, new a());
            if (c14671iI3 == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }
    }

    /* renamed from: ir.nasim.iI3$f */
    public interface f {
        public static final f a = new a();

        /* renamed from: ir.nasim.iI3$f$a */
        static class a implements f {
            a() {
            }

            private static /* synthetic */ void b(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // ir.nasim.C14671iI3.f
            public RuntimeException a(Throwable th) {
                if (th == null) {
                    b(0);
                }
                throw AbstractC13659gc2.b(th);
            }
        }

        RuntimeException a(Throwable th);
    }

    /* renamed from: ir.nasim.iI3$g */
    private static class g {
        private final Object a;
        private final SA2 b;

        public g(Object obj, SA2 sa2) {
            this.a = obj;
            this.b = sa2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.a.equals(((g) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* renamed from: ir.nasim.iI3$i */
    private static abstract class i extends h {
        private volatile AD6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(C14671iI3 c14671iI3, SA2 sa2) {
            super(c14671iI3, sa2);
            if (c14671iI3 == null) {
                a(0);
            }
            if (sa2 == null) {
                a(1);
            }
            this.d = null;
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.C14671iI3.h
        protected final void b(Object obj) {
            this.d = new AD6(obj);
            try {
                d(obj);
            } finally {
                this.d = null;
            }
        }

        protected abstract void d(Object obj);

        @Override // ir.nasim.C14671iI3.h, ir.nasim.SA2
        public Object invoke() {
            AD6 ad6 = this.d;
            return (ad6 == null || !ad6.b()) ? super.invoke() : ad6.a();
        }
    }

    /* renamed from: ir.nasim.iI3$j */
    private static class j extends h implements InterfaceC23016wC4 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(C14671iI3 c14671iI3, SA2 sa2) {
            super(c14671iI3, sa2);
            if (c14671iI3 == null) {
                a(0);
            }
            if (sa2 == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // ir.nasim.C14671iI3.h, ir.nasim.SA2
        public Object invoke() {
            Object objInvoke = super.invoke();
            if (objInvoke == null) {
                a(2);
            }
            return objInvoke;
        }
    }

    /* renamed from: ir.nasim.iI3$k */
    private static abstract class k extends i implements InterfaceC23016wC4 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(C14671iI3 c14671iI3, SA2 sa2) {
            super(c14671iI3, sa2);
            if (c14671iI3 == null) {
                a(0);
            }
            if (sa2 == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // ir.nasim.C14671iI3.i, ir.nasim.C14671iI3.h, ir.nasim.SA2
        public Object invoke() {
            Object objInvoke = super.invoke();
            if (objInvoke == null) {
                a(2);
            }
            return objInvoke;
        }
    }

    /* renamed from: ir.nasim.iI3$l */
    private static class l implements J34 {
        private final C14671iI3 a;
        private final ConcurrentMap b;
        private final UA2 c;

        public l(C14671iI3 c14671iI3, ConcurrentMap concurrentMap, UA2 ua2) {
            if (c14671iI3 == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (ua2 == null) {
                b(2);
            }
            this.a = c14671iI3;
            this.b = concurrentMap;
            this.c = ua2;
        }

        private static /* synthetic */ void b(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        private AssertionError c(Object obj, Object obj2) {
            AssertionError assertionError = (AssertionError) C14671iI3.q(new AssertionError("Race condition detected on input " + obj + ". Old value is " + obj2 + " under " + this.a));
            if (assertionError == null) {
                b(4);
            }
            return assertionError;
        }

        protected o d(Object obj, boolean z) {
            o oVarP = this.a.p("", obj);
            if (oVarP == null) {
                b(3);
            }
            return oVarP;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x003b, PHI: r0
          0x003e: PHI (r0v8 java.lang.Object) = (r0v7 java.lang.Object), (r0v17 java.lang.Object) binds: [B:10:0x0020, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a4, B:43:0x00a5, B:44:0x00af, B:45:0x00b0, B:46:0x00b7, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
        @Override // ir.nasim.UA2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object invoke(java.lang.Object r6) {
            /*
                r5 = this;
                java.util.concurrent.ConcurrentMap r0 = r5.b
                java.lang.Object r0 = r0.get(r6)
                if (r0 == 0) goto L11
                ir.nasim.iI3$n r1 = ir.nasim.C14671iI3.n.COMPUTING
                if (r0 == r1) goto L11
                java.lang.Object r6 = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.d(r0)
                return r6
            L11:
                ir.nasim.iI3 r0 = r5.a
                ir.nasim.MC6 r0 = r0.a
                r0.lock()
                java.util.concurrent.ConcurrentMap r0 = r5.b     // Catch: java.lang.Throwable -> L3b
                java.lang.Object r0 = r0.get(r6)     // Catch: java.lang.Throwable -> L3b
                ir.nasim.iI3$n r1 = ir.nasim.C14671iI3.n.COMPUTING     // Catch: java.lang.Throwable -> L3b
                if (r0 != r1) goto L3e
                ir.nasim.iI3$n r0 = ir.nasim.C14671iI3.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> L3b
                r2 = 1
                ir.nasim.iI3$o r2 = r5.d(r6, r2)     // Catch: java.lang.Throwable -> L3b
                boolean r3 = r2.c()     // Catch: java.lang.Throwable -> L3b
                if (r3 != 0) goto L3e
                java.lang.Object r6 = r2.b()     // Catch: java.lang.Throwable -> L3b
            L33:
                ir.nasim.iI3 r0 = r5.a
                ir.nasim.MC6 r0 = r0.a
                r0.unlock()
                return r6
            L3b:
                r6 = move-exception
                goto Lb8
            L3e:
                ir.nasim.iI3$n r2 = ir.nasim.C14671iI3.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> L3b
                if (r0 != r2) goto L52
                r2 = 0
                ir.nasim.iI3$o r2 = r5.d(r6, r2)     // Catch: java.lang.Throwable -> L3b
                boolean r3 = r2.c()     // Catch: java.lang.Throwable -> L3b
                if (r3 != 0) goto L52
                java.lang.Object r6 = r2.b()     // Catch: java.lang.Throwable -> L3b
                goto L33
            L52:
                if (r0 == 0) goto L59
                java.lang.Object r6 = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.d(r0)     // Catch: java.lang.Throwable -> L3b
                goto L33
            L59:
                r0 = 0
                java.util.concurrent.ConcurrentMap r2 = r5.b     // Catch: java.lang.Throwable -> L7e
                r2.put(r6, r1)     // Catch: java.lang.Throwable -> L7e
                ir.nasim.UA2 r2 = r5.c     // Catch: java.lang.Throwable -> L7e
                java.lang.Object r2 = r2.invoke(r6)     // Catch: java.lang.Throwable -> L7e
                java.util.concurrent.ConcurrentMap r3 = r5.b     // Catch: java.lang.Throwable -> L7e
                java.lang.Object r4 = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.b(r2)     // Catch: java.lang.Throwable -> L7e
                java.lang.Object r3 = r3.put(r6, r4)     // Catch: java.lang.Throwable -> L7e
                if (r3 != r1) goto L79
                ir.nasim.iI3 r6 = r5.a
                ir.nasim.MC6 r6 = r6.a
                r6.unlock()
                return r2
            L79:
                java.lang.AssertionError r0 = r5.c(r6, r3)     // Catch: java.lang.Throwable -> L7e
                throw r0     // Catch: java.lang.Throwable -> L7e
            L7e:
                r1 = move-exception
                boolean r2 = ir.nasim.AbstractC13659gc2.a(r1)     // Catch: java.lang.Throwable -> L3b
                if (r2 != 0) goto Lb0
                if (r1 == r0) goto La5
                java.util.concurrent.ConcurrentMap r0 = r5.b     // Catch: java.lang.Throwable -> L3b
                java.lang.Object r2 = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.c(r1)     // Catch: java.lang.Throwable -> L3b
                java.lang.Object r0 = r0.put(r6, r2)     // Catch: java.lang.Throwable -> L3b
                ir.nasim.iI3$n r2 = ir.nasim.C14671iI3.n.COMPUTING     // Catch: java.lang.Throwable -> L3b
                if (r0 == r2) goto L9a
                java.lang.AssertionError r6 = r5.c(r6, r0)     // Catch: java.lang.Throwable -> L3b
                throw r6     // Catch: java.lang.Throwable -> L3b
            L9a:
                ir.nasim.iI3 r6 = r5.a     // Catch: java.lang.Throwable -> L3b
                ir.nasim.iI3$f r6 = ir.nasim.C14671iI3.k(r6)     // Catch: java.lang.Throwable -> L3b
                java.lang.RuntimeException r6 = r6.a(r1)     // Catch: java.lang.Throwable -> L3b
                throw r6     // Catch: java.lang.Throwable -> L3b
            La5:
                ir.nasim.iI3 r6 = r5.a     // Catch: java.lang.Throwable -> L3b
                ir.nasim.iI3$f r6 = ir.nasim.C14671iI3.k(r6)     // Catch: java.lang.Throwable -> L3b
                java.lang.RuntimeException r6 = r6.a(r1)     // Catch: java.lang.Throwable -> L3b
                throw r6     // Catch: java.lang.Throwable -> L3b
            Lb0:
                java.util.concurrent.ConcurrentMap r0 = r5.b     // Catch: java.lang.Throwable -> L3b
                r0.remove(r6)     // Catch: java.lang.Throwable -> L3b
                java.lang.RuntimeException r1 = (java.lang.RuntimeException) r1     // Catch: java.lang.Throwable -> L3b
                throw r1     // Catch: java.lang.Throwable -> L3b
            Lb8:
                ir.nasim.iI3 r0 = r5.a
                ir.nasim.MC6 r0 = r0.a
                r0.unlock()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14671iI3.l.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.iI3$m */
    private static class m extends l implements I34 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(C14671iI3 c14671iI3, ConcurrentMap concurrentMap, UA2 ua2) {
            super(c14671iI3, concurrentMap, ua2);
            if (c14671iI3 == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (ua2 == null) {
                b(2);
            }
        }

        private static /* synthetic */ void b(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // ir.nasim.C14671iI3.l, ir.nasim.UA2
        public Object invoke(Object obj) {
            Object objInvoke = super.invoke(obj);
            if (objInvoke == null) {
                b(3);
            }
            return objInvoke;
        }
    }

    /* renamed from: ir.nasim.iI3$n */
    private enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* renamed from: ir.nasim.iI3$o */
    private static class o {
        private final Object a;
        private final boolean b;

        private o(Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }

        public static o a() {
            return new o(null, true);
        }

        public static o d(Object obj) {
            return new o(obj, false);
        }

        public Object b() {
            return this.a;
        }

        public boolean c() {
            return this.b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.a);
        }
    }

    /* synthetic */ C14671iI3(String str, f fVar, MC6 mc6, a aVar) {
        this(str, fVar, mc6);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void j(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14671iI3.j(int):void");
    }

    private static ConcurrentMap m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Throwable q(Throwable th) {
        if (th == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!stackTrace[i2].getClassName().startsWith(d)) {
                break;
            }
            i2++;
        }
        List listSubList = Arrays.asList(stackTrace).subList(i2, length);
        th.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
        return th;
    }

    @Override // ir.nasim.ON6
    public InterfaceC20324rp0 a() {
        return new d(this, m(), null);
    }

    @Override // ir.nasim.ON6
    public J34 b(UA2 ua2) {
        if (ua2 == null) {
            j(19);
        }
        J34 j34O = o(ua2, m());
        if (j34O == null) {
            j(20);
        }
        return j34O;
    }

    @Override // ir.nasim.ON6
    public InterfaceC23016wC4 c(SA2 sa2) {
        if (sa2 == null) {
            j(23);
        }
        return new j(this, sa2);
    }

    @Override // ir.nasim.ON6
    public InterfaceC23016wC4 d(SA2 sa2, Object obj) {
        if (sa2 == null) {
            j(26);
        }
        if (obj == null) {
            j(27);
        }
        return new b(this, sa2, obj);
    }

    @Override // ir.nasim.ON6
    public I34 e(UA2 ua2) {
        if (ua2 == null) {
            j(9);
        }
        I34 i34N = n(ua2, m());
        if (i34N == null) {
            j(10);
        }
        return i34N;
    }

    @Override // ir.nasim.ON6
    public InterfaceC20915sp0 f() {
        return new e(this, m(), null);
    }

    @Override // ir.nasim.ON6
    public InterfaceC20580sF4 g(SA2 sa2) {
        if (sa2 == null) {
            j(30);
        }
        return new h(this, sa2);
    }

    @Override // ir.nasim.ON6
    public InterfaceC23016wC4 h(SA2 sa2, UA2 ua2, UA2 ua22) {
        if (sa2 == null) {
            j(28);
        }
        if (ua22 == null) {
            j(29);
        }
        return new c(this, sa2, ua2, ua22);
    }

    @Override // ir.nasim.ON6
    public Object i(SA2 sa2) {
        if (sa2 == null) {
            j(34);
        }
        this.a.lock();
        try {
            return sa2.invoke();
        } finally {
        }
    }

    public I34 n(UA2 ua2, ConcurrentMap concurrentMap) {
        if (ua2 == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, ua2);
    }

    public J34 o(UA2 ua2, ConcurrentMap concurrentMap) {
        if (ua2 == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, ua2);
    }

    protected o p(String str, Object obj) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (obj == null) {
            str2 = "";
        } else {
            str2 = "on input: " + obj;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) q(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + Separators.AT + Integer.toHexString(hashCode()) + " (" + this.c + Separators.RPAREN;
    }

    private C14671iI3(String str, f fVar, MC6 mc6) {
        if (str == null) {
            j(4);
        }
        if (fVar == null) {
            j(5);
        }
        if (mc6 == null) {
            j(6);
        }
        this.a = mc6;
        this.b = fVar;
        this.c = str;
    }

    public C14671iI3(String str) {
        this(str, (Runnable) null, (UA2) null);
    }

    public C14671iI3(String str, Runnable runnable, UA2 ua2) {
        this(str, f.a, MC6.a.a(runnable, ua2));
    }

    /* renamed from: ir.nasim.iI3$h */
    private static class h implements InterfaceC20580sF4 {
        private final C14671iI3 a;
        private final SA2 b;
        private volatile Object c;

        public h(C14671iI3 c14671iI3, SA2 sa2) {
            if (c14671iI3 == null) {
                a(0);
            }
            if (sa2 == null) {
                a(1);
            }
            this.c = n.NOT_COMPUTED;
            this.a = c14671iI3;
            this.b = sa2;
        }

        private static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i != 2 && i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        protected o c(boolean z) {
            o oVarP = this.a.p("in a lazy value", null);
            if (oVarP == null) {
                a(2);
            }
            return oVarP;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007d, B:35:0x007e, B:36:0x0084, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        @Override // ir.nasim.SA2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object invoke() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.c
                boolean r1 = r0 instanceof ir.nasim.C14671iI3.n
                if (r1 != 0) goto Lb
                java.lang.Object r0 = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.f(r0)
                return r0
            Lb:
                ir.nasim.iI3 r0 = r4.a
                ir.nasim.MC6 r0 = r0.a
                r0.lock()
                java.lang.Object r0 = r4.c     // Catch: java.lang.Throwable -> L24
                boolean r1 = r0 instanceof ir.nasim.C14671iI3.n     // Catch: java.lang.Throwable -> L24
                if (r1 != 0) goto L26
                java.lang.Object r0 = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.f(r0)     // Catch: java.lang.Throwable -> L24
            L1c:
                ir.nasim.iI3 r1 = r4.a
                ir.nasim.MC6 r1 = r1.a
                r1.unlock()
                return r0
            L24:
                r0 = move-exception
                goto L85
            L26:
                ir.nasim.iI3$n r1 = ir.nasim.C14671iI3.n.COMPUTING     // Catch: java.lang.Throwable -> L24
                if (r0 != r1) goto L3e
                ir.nasim.iI3$n r2 = ir.nasim.C14671iI3.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> L24
                r4.c = r2     // Catch: java.lang.Throwable -> L24
                r2 = 1
                ir.nasim.iI3$o r2 = r4.c(r2)     // Catch: java.lang.Throwable -> L24
                boolean r3 = r2.c()     // Catch: java.lang.Throwable -> L24
                if (r3 != 0) goto L3e
                java.lang.Object r0 = r2.b()     // Catch: java.lang.Throwable -> L24
                goto L1c
            L3e:
                ir.nasim.iI3$n r2 = ir.nasim.C14671iI3.n.RECURSION_WAS_DETECTED     // Catch: java.lang.Throwable -> L24
                if (r0 != r2) goto L52
                r0 = 0
                ir.nasim.iI3$o r0 = r4.c(r0)     // Catch: java.lang.Throwable -> L24
                boolean r2 = r0.c()     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L52
                java.lang.Object r0 = r0.b()     // Catch: java.lang.Throwable -> L24
                goto L1c
            L52:
                r4.c = r1     // Catch: java.lang.Throwable -> L24
                ir.nasim.SA2 r0 = r4.b     // Catch: java.lang.Throwable -> L60
                java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> L60
                r4.b(r0)     // Catch: java.lang.Throwable -> L60
                r4.c = r0     // Catch: java.lang.Throwable -> L60
                goto L1c
            L60:
                r0 = move-exception
                boolean r1 = ir.nasim.AbstractC13659gc2.a(r0)     // Catch: java.lang.Throwable -> L24
                if (r1 != 0) goto L7e
                java.lang.Object r1 = r4.c     // Catch: java.lang.Throwable -> L24
                ir.nasim.iI3$n r2 = ir.nasim.C14671iI3.n.COMPUTING     // Catch: java.lang.Throwable -> L24
                if (r1 != r2) goto L73
                java.lang.Object r1 = kotlin.reflect.jvm.internal.impl.utils.WrappedValues.c(r0)     // Catch: java.lang.Throwable -> L24
                r4.c = r1     // Catch: java.lang.Throwable -> L24
            L73:
                ir.nasim.iI3 r1 = r4.a     // Catch: java.lang.Throwable -> L24
                ir.nasim.iI3$f r1 = ir.nasim.C14671iI3.k(r1)     // Catch: java.lang.Throwable -> L24
                java.lang.RuntimeException r0 = r1.a(r0)     // Catch: java.lang.Throwable -> L24
                throw r0     // Catch: java.lang.Throwable -> L24
            L7e:
                ir.nasim.iI3$n r1 = ir.nasim.C14671iI3.n.NOT_COMPUTED     // Catch: java.lang.Throwable -> L24
                r4.c = r1     // Catch: java.lang.Throwable -> L24
                java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch: java.lang.Throwable -> L24
                throw r0     // Catch: java.lang.Throwable -> L24
            L85:
                ir.nasim.iI3 r1 = r4.a
                ir.nasim.MC6 r1 = r1.a
                r1.unlock()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14671iI3.h.invoke():java.lang.Object");
        }

        public boolean m() {
            return (this.c == n.NOT_COMPUTED || this.c == n.COMPUTING) ? false : true;
        }

        protected void b(Object obj) {
        }
    }
}
