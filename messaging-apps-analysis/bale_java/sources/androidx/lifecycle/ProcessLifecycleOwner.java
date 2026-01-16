package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.j;
import androidx.lifecycle.x;
import ir.nasim.AbstractC12739f72;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC18633oz3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0002\u0010\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner;", "Lir/nasim/oz3;", "<init>", "()V", "Lir/nasim/rB7;", "f", "e", "d", "g", "j", "k", "Landroid/content/Context;", "context", "h", "(Landroid/content/Context;)V", "", "a", TokenNames.I, "startedCounter", "b", "resumedCounter", "", "c", "Z", "pauseSent", "stopSent", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Landroidx/lifecycle/p;", "Landroidx/lifecycle/p;", "registry", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "delayedPauseRunnable", "Landroidx/lifecycle/x$a;", "Landroidx/lifecycle/x$a;", "initializationListener", "Landroidx/lifecycle/j;", "getLifecycle", "()Landroidx/lifecycle/j;", "lifecycle", "i", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ProcessLifecycleOwner implements InterfaceC18633oz3 {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ProcessLifecycleOwner j = new ProcessLifecycleOwner();

    /* renamed from: a, reason: from kotlin metadata */
    private int startedCounter;

    /* renamed from: b, reason: from kotlin metadata */
    private int resumedCounter;

    /* renamed from: e, reason: from kotlin metadata */
    private Handler handler;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean pauseSent = true;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean stopSent = true;

    /* renamed from: f, reason: from kotlin metadata */
    private final p registry = new p(this);

    /* renamed from: g, reason: from kotlin metadata */
    private final Runnable delayedPauseRunnable = new Runnable() { // from class: ir.nasim.Or5
        @Override // java.lang.Runnable
        public final void run() {
            ProcessLifecycleOwner.i(this.a);
        }
    };

    /* renamed from: h, reason: from kotlin metadata */
    private final x.a initializationListener = new d();

    public static final class a {
        public static final a a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* renamed from: androidx.lifecycle.ProcessLifecycleOwner$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final InterfaceC18633oz3 a() {
            return ProcessLifecycleOwner.j;
        }

        public final void b(Context context) {
            AbstractC13042fc3.i(context, "context");
            ProcessLifecycleOwner.j.h(context);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class c extends AbstractC12739f72 {

        public static final class a extends AbstractC12739f72 {
            final /* synthetic */ ProcessLifecycleOwner this$0;

            a(ProcessLifecycleOwner processLifecycleOwner) {
                this.this$0 = processLifecycleOwner;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                AbstractC13042fc3.i(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                AbstractC13042fc3.i(activity, "activity");
                this.this$0.f();
            }
        }

        c() {
        }

        @Override // ir.nasim.AbstractC12739f72, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            AbstractC13042fc3.i(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                x.INSTANCE.b(activity).e(ProcessLifecycleOwner.this.initializationListener);
            }
        }

        @Override // ir.nasim.AbstractC12739f72, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
            ProcessLifecycleOwner.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            AbstractC13042fc3.i(activity, "activity");
            a.a(activity, new a(ProcessLifecycleOwner.this));
        }

        @Override // ir.nasim.AbstractC12739f72, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
            ProcessLifecycleOwner.this.g();
        }
    }

    public static final class d implements x.a {
        d() {
        }

        @Override // androidx.lifecycle.x.a
        public void f() {
            ProcessLifecycleOwner.this.f();
        }

        @Override // androidx.lifecycle.x.a
        public void onCreate() {
        }

        @Override // androidx.lifecycle.x.a
        public void onResume() {
            ProcessLifecycleOwner.this.e();
        }
    }

    private ProcessLifecycleOwner() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ProcessLifecycleOwner processLifecycleOwner) {
        AbstractC13042fc3.i(processLifecycleOwner, "this$0");
        processLifecycleOwner.j();
        processLifecycleOwner.k();
    }

    public static final InterfaceC18633oz3 l() {
        return INSTANCE.a();
    }

    public final void d() {
        int i = this.resumedCounter - 1;
        this.resumedCounter = i;
        if (i == 0) {
            Handler handler = this.handler;
            AbstractC13042fc3.f(handler);
            handler.postDelayed(this.delayedPauseRunnable, 700L);
        }
    }

    public final void e() {
        int i = this.resumedCounter + 1;
        this.resumedCounter = i;
        if (i == 1) {
            if (this.pauseSent) {
                this.registry.i(j.a.ON_RESUME);
                this.pauseSent = false;
            } else {
                Handler handler = this.handler;
                AbstractC13042fc3.f(handler);
                handler.removeCallbacks(this.delayedPauseRunnable);
            }
        }
    }

    public final void f() {
        int i = this.startedCounter + 1;
        this.startedCounter = i;
        if (i == 1 && this.stopSent) {
            this.registry.i(j.a.ON_START);
            this.stopSent = false;
        }
    }

    public final void g() {
        this.startedCounter--;
        k();
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public j getLifecycle() {
        return this.registry;
    }

    public final void h(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.handler = new Handler();
        this.registry.i(j.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        AbstractC13042fc3.g(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void j() {
        if (this.resumedCounter == 0) {
            this.pauseSent = true;
            this.registry.i(j.a.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.startedCounter == 0 && this.pauseSent) {
            this.registry.i(j.a.ON_STOP);
            this.stopSent = true;
        }
    }
}
