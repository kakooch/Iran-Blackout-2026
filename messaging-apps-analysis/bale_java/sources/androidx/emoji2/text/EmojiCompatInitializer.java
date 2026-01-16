package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.e;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.ProcessLifecycleInitializer;
import ir.nasim.AbstractC18580ot7;
import ir.nasim.E73;
import ir.nasim.InterfaceC18633oz3;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public class EmojiCompatInitializer implements E73 {

    class a implements DefaultLifecycleObserver {
        final /* synthetic */ androidx.lifecycle.j a;

        a(androidx.lifecycle.j jVar) {
            this.a = jVar;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(InterfaceC18633oz3 interfaceC18633oz3) {
            EmojiCompatInitializer.this.e();
            this.a.d(this);
        }
    }

    static class b extends e.c {
        protected b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    static class c implements e.h {
        private final Context a;

        class a extends e.i {
            final /* synthetic */ e.i a;
            final /* synthetic */ ThreadPoolExecutor b;

            a(e.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.a = iVar;
                this.b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.e.i
            public void a(Throwable th) {
                try {
                    this.a.a(th);
                } finally {
                    this.b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.e.i
            public void b(l lVar) {
                try {
                    this.a.b(lVar);
                } finally {
                    this.b.shutdown();
                }
            }
        }

        c(Context context) {
            this.a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.e.h
        public void a(final e.i iVar) {
            final ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d(iVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(e.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                i iVarA = androidx.emoji2.text.c.a(this.a);
                if (iVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                iVarA.c(threadPoolExecutor);
                iVarA.a().a(new a(iVar, threadPoolExecutor));
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractC18580ot7.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.k()) {
                    e.c().n();
                }
            } finally {
                AbstractC18580ot7.b();
            }
        }
    }

    @Override // ir.nasim.E73
    public List b() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // ir.nasim.E73
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean a(Context context) {
        e.j(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        androidx.lifecycle.j lifecycle = ((InterfaceC18633oz3) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    void e() {
        androidx.emoji2.text.b.d().postDelayed(new d(), 500L);
    }
}
