package ir.nasim;

import android.view.View;

/* renamed from: ir.nasim.mN1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C17085mN1 extends AbstractC22887vz3 {
    private final boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17085mN1(boolean z, UA2 ua2, UA2 ua22) {
        super(ua2, ua22);
        AbstractC13042fc3.i(ua2, "viewBinder");
        AbstractC13042fc3.i(ua22, "onViewDestroyed");
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC22887vz3
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public InterfaceC18633oz3 e(androidx.fragment.app.l lVar) {
        AbstractC13042fc3.i(lVar, "thisRef");
        View viewO6 = lVar.o6();
        InterfaceC18633oz3 interfaceC18633oz3 = lVar;
        if (viewO6 != null) {
            try {
                InterfaceC18633oz3 interfaceC18633oz3P6 = lVar.p6();
                AbstractC13042fc3.h(interfaceC18633oz3P6, "{\n            try {\n    …)\n            }\n        }");
                interfaceC18633oz3 = interfaceC18633oz3P6;
            } catch (IllegalStateException unused) {
                throw new IllegalStateException("Fragment doesn't have view associated with it or the view has been destroyed".toString());
            }
        }
        return interfaceC18633oz3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC22887vz3
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean g(androidx.fragment.app.l lVar) {
        AbstractC13042fc3.i(lVar, "thisRef");
        if (this.f) {
            return lVar.z8() ? lVar.y8() != null : lVar.o6() != null;
        }
        return true;
    }
}
