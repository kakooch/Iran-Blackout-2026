package ir.nasim;

import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* renamed from: ir.nasim.Hq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C5040Hq2 extends C18419od6 {
    public C5040Hq2(InterfaceC11938do1 interfaceC11938do1, InterfaceC20295rm1 interfaceC20295rm1) {
        super(interfaceC11938do1, interfaceC20295rm1);
    }

    @Override // ir.nasim.C22725vj3
    public boolean h0(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return a0(th);
    }
}
