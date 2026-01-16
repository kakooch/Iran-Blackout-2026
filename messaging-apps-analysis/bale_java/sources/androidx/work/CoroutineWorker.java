package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20267rj3;
import ir.nasim.AbstractC20906so1;
import ir.nasim.C12366eV1;
import ir.nasim.C19938rB7;
import ir.nasim.C20858sj3;
import ir.nasim.C5314Iu6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24075y01;
import ir.nasim.InterfaceFutureC15215jC3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u0010\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\u00020 8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Lir/nasim/jC3;", "Landroidx/work/ListenableWorker$a;", "p", "()Lir/nasim/jC3;", "r", "(Lir/nasim/rm1;)Ljava/lang/Object;", "Lir/nasim/fv2;", "t", "d", "Lir/nasim/rB7;", "m", "()V", "Lir/nasim/y01;", "f", "Lir/nasim/y01;", "w", "()Lir/nasim/y01;", "job", "Lir/nasim/Iu6;", "g", "Lir/nasim/Iu6;", "v", "()Lir/nasim/Iu6;", "future", "Lir/nasim/go1;", "h", "Lir/nasim/go1;", "s", "()Lir/nasim/go1;", "getCoroutineContext$annotations", "coroutineContext", "work-runtime-ktx_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: f, reason: from kotlin metadata */
    private final InterfaceC24075y01 job;

    /* renamed from: g, reason: from kotlin metadata */
    private final C5314Iu6 future;

    /* renamed from: h, reason: from kotlin metadata */
    private final AbstractC13778go1 coroutineContext;

    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CoroutineWorker.this.getFuture().isCancelled()) {
                InterfaceC13730gj3.a.a(CoroutineWorker.this.getJob(), null, 1, null);
            }
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ C20858sj3 d;
        final /* synthetic */ CoroutineWorker e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C20858sj3 c20858sj3, CoroutineWorker coroutineWorker, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c20858sj3;
            this.e = coroutineWorker;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C20858sj3 c20858sj3;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20858sj3 c20858sj32 = this.d;
                CoroutineWorker coroutineWorker = this.e;
                this.b = c20858sj32;
                this.c = 1;
                Object objT = coroutineWorker.t(this);
                if (objT == objE) {
                    return objE;
                }
                c20858sj3 = c20858sj32;
                obj = objT;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c20858sj3 = (C20858sj3) this.b;
                AbstractC10685c16.b(obj);
            }
            c20858sj3.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CoroutineWorker.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.b = 1;
                    obj = coroutineWorker.r(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                CoroutineWorker.this.getFuture().p((ListenableWorker.a) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.getFuture().q(th);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(workerParameters, "params");
        this.job = AbstractC20267rj3.b(null, 1, null);
        C5314Iu6 c5314Iu6T = C5314Iu6.t();
        AbstractC13042fc3.h(c5314Iu6T, "create()");
        this.future = c5314Iu6T;
        c5314Iu6T.j(new a(), h().c());
        this.coroutineContext = C12366eV1.a();
    }

    static /* synthetic */ Object u(CoroutineWorker coroutineWorker, InterfaceC20295rm1 interfaceC20295rm1) {
        throw new IllegalStateException("Not implemented");
    }

    @Override // androidx.work.ListenableWorker
    public final InterfaceFutureC15215jC3 d() {
        InterfaceC24075y01 interfaceC24075y01B = AbstractC20267rj3.b(null, 1, null);
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(getCoroutineContext().X(interfaceC24075y01B));
        C20858sj3 c20858sj3 = new C20858sj3(interfaceC24075y01B, null, 2, null);
        AbstractC10533bm0.d(interfaceC20315ro1A, null, null, new b(c20858sj3, this, null), 3, null);
        return c20858sj3;
    }

    @Override // androidx.work.ListenableWorker
    public final void m() {
        super.m();
        this.future.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final InterfaceFutureC15215jC3 p() {
        AbstractC10533bm0.d(AbstractC20906so1.a(getCoroutineContext().X(this.job)), null, null, new c(null), 3, null);
        return this.future;
    }

    public abstract Object r(InterfaceC20295rm1 interfaceC20295rm1);

    /* renamed from: s, reason: from getter */
    public AbstractC13778go1 getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object t(InterfaceC20295rm1 interfaceC20295rm1) {
        return u(this, interfaceC20295rm1);
    }

    /* renamed from: v, reason: from getter */
    public final C5314Iu6 getFuture() {
        return this.future;
    }

    /* renamed from: w, reason: from getter */
    public final InterfaceC24075y01 getJob() {
        return this.job;
    }
}
