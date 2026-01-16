package ir.nasim;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: ir.nasim.Pl5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC6900Pl5 {
    /* JADX INFO: Access modifiers changed from: private */
    static C19938rB7 a() {
        return C19938rB7.a;
    }

    static /* synthetic */ AbstractC5462Jl1 c(InterfaceC6900Pl5 interfaceC6900Pl5, View view, ViewGroup viewGroup, InterfaceC18633oz3 interfaceC18633oz3, SA2 sa2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPremiumContextMenu");
        }
        if ((i & 8) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.Ol5
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InterfaceC6900Pl5.a();
                }
            };
        }
        return interfaceC6900Pl5.b(view, viewGroup, interfaceC18633oz3, sa2);
    }

    AbstractC5462Jl1 b(View view, ViewGroup viewGroup, InterfaceC18633oz3 interfaceC18633oz3, SA2 sa2);
}
