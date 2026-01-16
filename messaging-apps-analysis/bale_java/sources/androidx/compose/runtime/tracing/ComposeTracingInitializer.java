package androidx.compose.runtime.tracing;

import android.content.Context;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.B35;
import ir.nasim.C19938rB7;
import ir.nasim.E73;
import ir.nasim.InterfaceC16631lc1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/tracing/ComposeTracingInitializer;", "Lir/nasim/E73;", "Lir/nasim/rB7;", "<init>", "()V", "Landroid/content/Context;", "context", "c", "(Landroid/content/Context;)V", "", "Ljava/lang/Class;", "b", "()Ljava/util/List;", "runtime-tracing_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class ComposeTracingInitializer implements E73 {

    public static final class a implements InterfaceC16631lc1 {
        a() {
        }

        @Override // ir.nasim.InterfaceC16631lc1
        public boolean a() {
            return B35.a.k();
        }

        @Override // ir.nasim.InterfaceC16631lc1
        public void b(int i, int i2, int i3, String str) {
            B35.a.d(str);
        }

        @Override // ir.nasim.InterfaceC16631lc1
        public void c() {
            B35.a.i();
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
        InterfaceC22053ub1.a.b(new a());
    }
}
