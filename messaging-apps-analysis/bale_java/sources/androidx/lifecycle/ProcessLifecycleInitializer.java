package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleOwner;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.E73;
import ir.nasim.InterfaceC18633oz3;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleInitializer;", "Lir/nasim/E73;", "Lir/nasim/oz3;", "<init>", "()V", "Landroid/content/Context;", "context", "c", "(Landroid/content/Context;)Lir/nasim/oz3;", "", "Ljava/lang/Class;", "b", "()Ljava/util/List;", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ProcessLifecycleInitializer implements E73 {
    @Override // ir.nasim.E73
    public List b() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.E73
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC18633oz3 a(Context context) {
        AbstractC13042fc3.i(context, "context");
        androidx.startup.a aVarE = androidx.startup.a.e(context);
        AbstractC13042fc3.h(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
        }
        m.a(context);
        ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.INSTANCE;
        companion.b(context);
        return companion.a();
    }
}
