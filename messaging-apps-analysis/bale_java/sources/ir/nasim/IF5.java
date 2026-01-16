package ir.nasim;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class IF5 {
    private static final b a;
    private static ExecutorService b;
    private static AbstractC13778go1 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ FF5 d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* renamed from: ir.nasim.IF5$a$a, reason: collision with other inner class name */
        static final class C0414a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ FF5 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0414a(FF5 ff5, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = ff5;
                this.e = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0414a c0414a = new C0414a(this.d, this.e, interfaceC20295rm1);
                c0414a.c = obj;
                return c0414a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return obj;
                }
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (this.d.a()) {
                    return null;
                }
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                this.b = 1;
                Object objInvoke = interfaceC14603iB2.invoke(interfaceC20315ro1, this);
                return objInvoke == objE ? objE : objInvoke;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0414a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FF5 ff5, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ff5;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (this.d.a()) {
                    return null;
                }
                String name = Thread.currentThread().getName();
                AbstractC13042fc3.h(name, "getName(...)");
                if (AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    obj = interfaceC14603iB2.invoke(interfaceC20315ro1, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    InterfaceC24823zG1 interfaceC24823zG1B = AbstractC10533bm0.b(interfaceC20315ro1, IF5.c, null, new C0414a(this.d, this.e, null), 2, null);
                    this.b = 2;
                    obj = interfaceC24823zG1B.y(this);
                    if (obj == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(0);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            AbstractC13042fc3.i(runnable, "r");
            Thread thread = new Thread(runnable);
            thread.setName("LK_RTC_THREAD_" + this.a.incrementAndGet());
            return thread;
        }
    }

    static {
        b bVar = new b();
        a = bVar;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(bVar);
        b = executorServiceNewSingleThreadExecutor;
        AbstractC13042fc3.h(executorServiceNewSingleThreadExecutor, "executor");
        c = AbstractC14260hd2.c(executorServiceNewSingleThreadExecutor);
    }

    public static final void d(final FF5 ff5, final SA2 sa2) {
        AbstractC13042fc3.i(ff5, "token");
        AbstractC13042fc3.i(sa2, "action");
        if (ff5.a()) {
            return;
        }
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "getName(...)");
        if (AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
            sa2.invoke();
        } else {
            b.submit(new Runnable() { // from class: ir.nasim.HF5
                @Override // java.lang.Runnable
                public final void run() {
                    IF5.e(ff5, sa2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FF5 ff5, SA2 sa2) {
        AbstractC13042fc3.i(ff5, "$token");
        AbstractC13042fc3.i(sa2, "$action");
        if (ff5.a()) {
            return;
        }
        sa2.invoke();
    }

    public static final Object f(FF5 ff5, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new a(ff5, interfaceC14603iB2, null), interfaceC20295rm1);
    }
}
