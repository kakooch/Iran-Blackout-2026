package androidx.tracing.perfetto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.JsonWriter;
import androidx.tracing.perfetto.TracingReceiver;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.B35;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.RK6;
import ir.nasim.SA2;
import ir.nasim.YV0;
import ir.nasim.ZW5;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u0004*\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/tracing/perfetto/TracingReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "", "srcPath", "Landroid/content/Context;", "context", "Lir/nasim/ZW5;", "d", "(Ljava/lang/String;Landroid/content/Context;)Lir/nasim/ZW5;", "", "isPersistent", "c", "(Landroid/content/Context;Ljava/lang/String;Z)Lir/nasim/ZW5;", "b", "(Landroid/content/Context;)Lir/nasim/ZW5;", "g", "(Lir/nasim/ZW5;)Ljava/lang/String;", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Ljava/util/concurrent/ThreadPoolExecutor;", "a", "Lir/nasim/Yu3;", "e", "()Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "tracing-perfetto_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class TracingReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 executor = AbstractC13269fw3.a(a.e);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ThreadPoolExecutor invoke() {
            return new ThreadPoolExecutor(0, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
    }

    private final ZW5 b(Context context) {
        if (context == null) {
            return B35.a.a(99, "Cannot ensure we can disable cold start tracing without access to an app Context instance");
        }
        androidx.tracing.perfetto.a.a.a(context);
        return B35.c(B35.a, 1, null, 2, null);
    }

    private final ZW5 c(Context context, String srcPath, boolean isPersistent) throws IOException {
        ZW5 zw5D = d(srcPath, context);
        if (zw5D.c() == 1) {
            RK6 rk6 = new RK6(srcPath, isPersistent);
            if (context == null) {
                return B35.a.a(99, "Cannot set up cold start tracing without a Context instance.");
            }
            androidx.tracing.perfetto.a.a.d(rk6, context);
        }
        return zw5D;
    }

    private final ZW5 d(String srcPath, Context context) {
        if (Build.VERSION.SDK_INT < 30) {
            return B35.a.a(99, "SDK version not supported. Current minimum SDK = 30");
        }
        if (srcPath != null && context != null) {
            try {
                return B35.a.g(new File(srcPath), context);
            } catch (Exception e) {
                return B35.a.b(99, e);
            }
        }
        if (srcPath == null || context != null) {
            return B35.a.f();
        }
        return B35.a.a(99, "Cannot copy source file: " + srcPath + " without access to a Context instance.");
    }

    private final ThreadPoolExecutor e() {
        return (ThreadPoolExecutor) this.executor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Intent intent, TracingReceiver tracingReceiver, String str, Context context, BroadcastReceiver.PendingResult pendingResult) {
        ZW5 zw5B;
        AbstractC13042fc3.i(tracingReceiver, "this$0");
        try {
            String action = intent.getAction();
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode != -190038551) {
                    if (iHashCode != -72159468) {
                        if (iHashCode == 274599218 && action.equals("androidx.tracing.perfetto.action.ENABLE_TRACING_COLD_START")) {
                            Bundle extras = intent.getExtras();
                            zw5B = tracingReceiver.c(context, str, Boolean.parseBoolean(extras != null ? extras.getString("persistent") : null));
                            pendingResult.setResult(zw5B.c(), tracingReceiver.g(zw5B), null);
                            pendingResult.finish();
                            return;
                        }
                    } else if (action.equals("androidx.tracing.perfetto.action.ENABLE_TRACING")) {
                        zw5B = tracingReceiver.d(str, context);
                        pendingResult.setResult(zw5B.c(), tracingReceiver.g(zw5B), null);
                        pendingResult.finish();
                        return;
                    }
                } else if (action.equals("androidx.tracing.perfetto.action.DISABLE_TRACING_COLD_START")) {
                    zw5B = tracingReceiver.b(context);
                    pendingResult.setResult(zw5B.c(), tracingReceiver.g(zw5B), null);
                    pendingResult.finish();
                    return;
                }
            }
            throw new IllegalStateException();
        } catch (Throwable th) {
            pendingResult.finish();
            throw th;
        }
    }

    private final String g(ZW5 zw5) throws IOException {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("exitCode");
            jsonWriter.value(Integer.valueOf(zw5.c()));
            jsonWriter.name("requiredVersion");
            jsonWriter.value(zw5.b());
            String strA = zw5.a();
            if (strA != null) {
                jsonWriter.name(DialogEntity.COLUMN_MESSAGE);
                jsonWriter.value(strA);
            }
            jsonWriter.endObject();
            YV0.a(jsonWriter, null);
            String string = stringWriter.toString();
            AbstractC13042fc3.h(string, "output.toString()");
            return string;
        } finally {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent == null || !AbstractC15401jX0.i0(AbstractC10360bX0.p("androidx.tracing.perfetto.action.ENABLE_TRACING", "androidx.tracing.perfetto.action.ENABLE_TRACING_COLD_START", "androidx.tracing.perfetto.action.DISABLE_TRACING_COLD_START"), intent.getAction())) {
            return;
        }
        Bundle extras = intent.getExtras();
        final String string = extras != null ? extras.getString("path") : null;
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        e().execute(new Runnable() { // from class: ir.nasim.rt7
            @Override // java.lang.Runnable
            public final void run() {
                TracingReceiver.f(intent, this, string, context, pendingResultGoAsync);
            }
        });
    }
}
