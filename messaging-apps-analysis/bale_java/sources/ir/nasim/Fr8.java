package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Fr8 implements JE {
    private static JE e;
    private final Context a;
    private boolean b;
    private final ScheduledExecutorService c;
    private final ExecutorService d;

    Fr8(Context context) {
        this.b = false;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.c = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        this.d = Executors.newSingleThreadExecutor();
        this.a = context;
        if (this.b) {
            return;
        }
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new Cq8(this, null), 0L, 86400L, TimeUnit.SECONDS);
        this.b = true;
    }

    static synchronized JE c(Context context) {
        try {
            AbstractC3795Cj5.k(context, "Context must not be null");
            if (e == null) {
                e = new Fr8(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    protected static final void e(Context context) {
        if (!g(context).edit().remove(CommonUrlParts.APP_SET_ID).commit()) {
            String strValueOf = String.valueOf(context.getPackageName());
            Log.e("AppSet", strValueOf.length() != 0 ? "Failed to clear app set ID generated for App ".concat(strValueOf) : new String("Failed to clear app set ID generated for App "));
        }
        if (g(context).edit().remove("app_set_id_last_used_time").commit()) {
            return;
        }
        String strValueOf2 = String.valueOf(context.getPackageName());
        Log.e("AppSet", strValueOf2.length() != 0 ? "Failed to clear app set ID last used time for App ".concat(strValueOf2) : new String("Failed to clear app set ID last used time for App "));
    }

    private static final SharedPreferences g(Context context) {
        return context.getSharedPreferences("app_set_id_storage", 0);
    }

    private static final void h(Context context) throws C11354cr8 {
        if (g(context).edit().putLong("app_set_id_last_used_time", BD1.a().currentTimeMillis()).commit()) {
            return;
        }
        String strValueOf = String.valueOf(context.getPackageName());
        Log.e("AppSet", strValueOf.length() != 0 ? "Failed to store app set ID last used time for App ".concat(strValueOf) : new String("Failed to store app set ID last used time for App "));
        throw new C11354cr8("Failed to store the app set ID last used time.");
    }

    protected final long a() {
        long j = g(this.a).getLong("app_set_id_last_used_time", -1L);
        if (j != -1) {
            return j + 33696000000L;
        }
        return -1L;
    }

    final /* synthetic */ void d(C4982Hj7 c4982Hj7) throws C11354cr8 {
        String string = g(this.a).getString(CommonUrlParts.APP_SET_ID, null);
        long jA = a();
        if (string == null || BD1.a().currentTimeMillis() > jA) {
            string = UUID.randomUUID().toString();
            try {
                Context context = this.a;
                if (!g(context).edit().putString(CommonUrlParts.APP_SET_ID, string).commit()) {
                    String strValueOf = String.valueOf(context.getPackageName());
                    Log.e("AppSet", strValueOf.length() != 0 ? "Failed to store app set ID generated for App ".concat(strValueOf) : new String("Failed to store app set ID generated for App "));
                    throw new C11354cr8("Failed to store the app set ID.");
                }
                h(context);
                Context context2 = this.a;
                if (!g(context2).edit().putLong("app_set_id_creation_time", BD1.a().currentTimeMillis()).commit()) {
                    String strValueOf2 = String.valueOf(context2.getPackageName());
                    Log.e("AppSet", strValueOf2.length() != 0 ? "Failed to store app set ID creation time for App ".concat(strValueOf2) : new String("Failed to store app set ID creation time for App "));
                    throw new C11354cr8("Failed to store the app set ID creation time.");
                }
            } catch (C11354cr8 e2) {
                c4982Hj7.b(e2);
                return;
            }
        } else {
            try {
                h(this.a);
            } catch (C11354cr8 e3) {
                c4982Hj7.b(e3);
                return;
            }
        }
        c4982Hj7.c(new KE(string, 1));
    }

    @Override // ir.nasim.JE
    public final Task f() {
        final C4982Hj7 c4982Hj7 = new C4982Hj7();
        this.d.execute(new Runnable() { // from class: ir.nasim.Uo8
            @Override // java.lang.Runnable
            public final void run() throws C11354cr8 {
                this.a.d(c4982Hj7);
            }
        });
        return c4982Hj7.a();
    }
}
