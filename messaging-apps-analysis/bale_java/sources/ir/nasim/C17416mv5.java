package ir.nasim;

import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import ir.nasim.C21602tp0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.mv5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17416mv5 {
    private final Executor a;
    private final com.google.android.exoplayer2.upstream.b b;
    private final com.google.android.exoplayer2.upstream.cache.a c;
    private final C21602tp0 d;
    private InterfaceC10995cZ1 e;
    private volatile AbstractRunnableFutureC15761k76 f;
    private volatile boolean g;

    /* renamed from: ir.nasim.mv5$a */
    class a extends AbstractRunnableFutureC15761k76 {
        a() {
        }

        @Override // ir.nasim.AbstractRunnableFutureC15761k76
        protected void b() {
            C17416mv5.this.d.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractRunnableFutureC15761k76
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Void c() throws InterruptedIOException {
            C17416mv5.this.d.a();
            return null;
        }
    }

    public C17416mv5(C2018a0 c2018a0, a.c cVar) {
        this(c2018a0, cVar, new ExecutorC4596Fu5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, long j2, long j3) {
        InterfaceC10995cZ1 interfaceC10995cZ1 = this.e;
        if (interfaceC10995cZ1 == null) {
            return;
        }
        interfaceC10995cZ1.a(j, j2, (j == -1 || j == 0) ? -1.0f : (j2 * 100.0f) / j);
    }

    public void c() {
        this.g = true;
        AbstractRunnableFutureC15761k76 abstractRunnableFutureC15761k76 = this.f;
        if (abstractRunnableFutureC15761k76 != null) {
            abstractRunnableFutureC15761k76.cancel(true);
        }
    }

    public void d(InterfaceC10995cZ1 interfaceC10995cZ1) {
        this.e = interfaceC10995cZ1;
        boolean z = false;
        while (!z) {
            try {
                if (this.g) {
                    break;
                }
                this.f = new a();
                this.a.execute(this.f);
                try {
                    this.f.get();
                    z = true;
                } catch (ExecutionException e) {
                    Throwable th = (Throwable) AbstractC20011rK.e(e.getCause());
                    if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                        if (th instanceof IOException) {
                            throw ((IOException) th);
                        }
                        AbstractC9683aN7.P0(th);
                    }
                }
            } finally {
                ((AbstractRunnableFutureC15761k76) AbstractC20011rK.e(this.f)).a();
            }
        }
    }

    public C17416mv5(C2018a0 c2018a0, a.c cVar, Executor executor) {
        this.a = (Executor) AbstractC20011rK.e(executor);
        AbstractC20011rK.e(c2018a0.b);
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0164b().i(c2018a0.b.a).f(c2018a0.b.e).b(4).a();
        this.b = bVarA;
        com.google.android.exoplayer2.upstream.cache.a aVarC = cVar.c();
        this.c = aVarC;
        this.d = new C21602tp0(aVarC, bVarA, null, new C21602tp0.a() { // from class: ir.nasim.lv5
            @Override // ir.nasim.C21602tp0.a
            public final void a(long j, long j2, long j3) {
                this.a.e(j, j2, j3);
            }
        });
        cVar.g();
    }
}
