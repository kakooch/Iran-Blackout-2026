package ir.nasim;

import ir.nasim.C9475a16;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.fL6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C12890fL6 extends Y1 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C12890fL6.class, Object.class, "_state");
    private volatile Object _state;

    @Override // ir.nasim.Y1
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(C11638dL6 c11638dL6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, AbstractC12281eL6.a);
        return true;
    }

    public final Object e(InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        if (!F1.a(a, this, AbstractC12281eL6.a, ie0)) {
            C9475a16.a aVar = C9475a16.b;
            ie0.resumeWith(C9475a16.b(C19938rB7.a));
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    @Override // ir.nasim.Y1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC20295rm1[] b(C11638dL6 c11638dL6) {
        a.set(this, null);
        return X1.a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == AbstractC12281eL6.b) {
                return;
            }
            if (obj == AbstractC12281eL6.a) {
                if (F1.a(a, this, obj, AbstractC12281eL6.b)) {
                    return;
                }
            } else if (F1.a(a, this, obj, AbstractC12281eL6.a)) {
                C9475a16.a aVar = C9475a16.b;
                ((IE0) obj).resumeWith(C9475a16.b(C19938rB7.a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = a.getAndSet(this, AbstractC12281eL6.a);
        AbstractC13042fc3.f(andSet);
        return andSet == AbstractC12281eL6.b;
    }
}
