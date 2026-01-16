package ir.nasim;

import android.os.HandlerThread;
import ir.nasim.SZ;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class SZ {
    public static final SZ a = new SZ();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.QZ
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Integer.valueOf(SZ.d());
        }
    });
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.RZ
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Integer.valueOf(SZ.c());
        }
    });

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC11723dV1.values().length];
            try {
                iArr[EnumC11723dV1.IO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C9248Zc6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C9248Zc6 c9248Zc6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c9248Zc6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C9248Zc6 c9248Zc6, Object obj) {
            c9248Zc6.b().onSuccess(obj);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC20906so1.f(interfaceC20315ro1);
            try {
                final Object objRun = this.d.c().run();
                AbstractC20906so1.f(interfaceC20315ro1);
                if (this.d.b() != null) {
                    if (this.d.e()) {
                        final C9248Zc6 c9248Zc6 = this.d;
                        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.TZ
                            @Override // java.lang.Runnable
                            public final void run() {
                                SZ.b.y(c9248Zc6, objRun);
                            }
                        });
                    } else {
                        this.d.b().onSuccess(objRun);
                    }
                }
            } catch (Exception unused) {
                this.d.a();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private SZ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d() {
        return -1987432;
    }

    public static final HV1 e(C9248Zc6 c9248Zc6) {
        AbstractC13042fc3.i(c9248Zc6, "schedulerTask");
        EnumC11723dV1 enumC11723dV1D = c9248Zc6.d();
        AbstractC13042fc3.f(enumC11723dV1D);
        return new C8106Uo(AbstractC10533bm0.d(C17050mJ2.a, a.a[enumC11723dV1D.ordinal()] == 1 ? C12366eV1.b() : C12366eV1.a(), null, new b(c9248Zc6, null), 2, null));
    }

    private final int f() {
        return ((Number) b.getValue()).intValue();
    }

    public static final NZ g(String str) {
        AbstractC13042fc3.i(str, "name");
        return i(str, 0, 2, null);
    }

    public static final NZ h(String str, int i) {
        AbstractC13042fc3.i(str, "name");
        NZ nz = new NZ(str);
        if (i != -1987432) {
            nz.setPriority(i);
        }
        return nz;
    }

    public static /* synthetic */ NZ i(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = a.f();
        }
        return h(str, i);
    }

    public static final HandlerThread j(String str, int i) {
        AbstractC13042fc3.i(str, "name");
        return new HandlerThread(str, i);
    }

    public static final ExecutorService k(String str) {
        AbstractC13042fc3.i(str, "name");
        return m(str, 0, 0L, false, 14, null);
    }

    public static final ExecutorService l(String str, int i, long j, boolean z) {
        AbstractC13042fc3.i(str, "name");
        return n(str, 1, 1, i, j, z);
    }

    public static /* synthetic */ ExecutorService m(String str, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = a.f();
        }
        if ((i2 & 4) != 0) {
            j = 0;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return l(str, i, j, z);
    }

    public static final ThreadPoolExecutor n(String str, int i, int i2, int i3, long j, boolean z) {
        AbstractC13042fc3.i(str, "name");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new BF4(str, i3));
        threadPoolExecutor.allowCoreThreadTimeOut(z);
        return threadPoolExecutor;
    }
}
