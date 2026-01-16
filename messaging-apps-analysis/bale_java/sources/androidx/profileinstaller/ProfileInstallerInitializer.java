package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.E73;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ProfileInstallerInitializer implements E73 {

    private static class a {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Context context, long j) {
        g(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: ir.nasim.Ju5
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                androidx.profileinstaller.f.i(context);
            }
        });
    }

    @Override // ir.nasim.E73
    public List b() {
        return Collections.emptyList();
    }

    @Override // ir.nasim.E73
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b a(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: ir.nasim.Hu5
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                this.a.h(applicationContext, j);
            }
        });
        return new b();
    }

    void g(final Context context) {
        (Build.VERSION.SDK_INT >= 28 ? a.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new Runnable() { // from class: ir.nasim.Iu5
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.k(context);
            }
        }, new Random().nextInt(Math.max(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 1)) + 5000);
    }
}
