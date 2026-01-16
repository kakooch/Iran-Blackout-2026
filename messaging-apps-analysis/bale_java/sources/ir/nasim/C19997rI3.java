package ir.nasim;

import android.app.Activity;
import android.app.Application;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import android.os.Bundle;
import android.os.Process;
import java.lang.Thread;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.rI3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19997rI3 implements Thread.UncaughtExceptionHandler {
    private WeakReference a;
    private Thread.UncaughtExceptionHandler b;

    /* renamed from: ir.nasim.rI3$a */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            AbstractC13042fc3.i(activity, "activity");
            C19997rI3.this.a = new WeakReference(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(bundle, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
        }
    }

    public C19997rI3(Application application) {
        AbstractC13042fc3.i(application, SIPServerTransaction.CONTENT_TYPE_APPLICATION);
        this.a = new WeakReference(null);
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        application.registerActivityLifecycleCallbacks(new a());
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws Throwable {
        AbstractC13042fc3.i(thread, "t");
        AbstractC13042fc3.i(th, "e");
        C19406qI3.d("--CRASH--", th);
        Activity activity = (Activity) this.a.get();
        if (activity != null) {
            activity.finishAffinity();
        }
        this.a.clear();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
        throw th;
    }
}
