package androidx.tracing.perfetto;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.B35;
import ir.nasim.C19938rB7;
import ir.nasim.E73;
import ir.nasim.ED1;
import ir.nasim.RK6;
import ir.nasim.ZW5;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/tracing/perfetto/StartupTracingInitializer;", "Lir/nasim/E73;", "Lir/nasim/rB7;", "<init>", "()V", "Landroid/content/Context;", "context", "c", "(Landroid/content/Context;)V", "", "Ljava/lang/Class;", "b", "()Ljava/util/List;", "a", "tracing-perfetto_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class StartupTracingInitializer implements E73 {
    private static final a a = new a(null);
    private static final String b = StartupTracingInitializer.class.getName();

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.E73
    public /* bridge */ /* synthetic */ Object a(Context context) {
        c(context);
        return C19938rB7.a;
    }

    @Override // ir.nasim.E73
    public List b() {
        return AbstractC10360bX0.m();
    }

    public void c(Context context) {
        AbstractC13042fc3.i(context, "context");
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            androidx.tracing.perfetto.a aVar = androidx.tracing.perfetto.a.a;
            RK6 rk6B = aVar.b(context);
            if (rk6B == null) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                return;
            }
            if (!rk6B.b()) {
                aVar.a(context);
            }
            String strA = rk6B.a();
            ZW5 zw5F = strA == null ? B35.a.f() : B35.a.g(new File(strA), context);
            Log.d(b, ZW5.class.getName() + ": { resultCode: " + zw5F.c() + ", message: " + zw5F.a() + ", requiredVersion: " + zw5F.b() + " }");
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }
}
