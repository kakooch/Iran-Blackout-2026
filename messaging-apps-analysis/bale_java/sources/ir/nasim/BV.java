package ir.nasim;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes8.dex */
final class BV {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(BV.class, "notCompletedCount");
    private final InterfaceC24823zG1[] a;
    private volatile int notCompletedCount;

    private final class a extends AbstractC22135uj3 {
        private static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        private volatile Object _disposer;
        private final HE0 e;
        public NV1 f;

        public a(HE0 he0) {
            this.e = he0;
        }

        @Override // ir.nasim.D01
        public void A(Throwable th) {
            if (th != null) {
                Object objE = this.e.E(th);
                if (objE != null) {
                    this.e.W(objE);
                    b bVarD = D();
                    if (bVarD != null) {
                        bVarD.k();
                        return;
                    }
                    return;
                }
                return;
            }
            if (BV.b.decrementAndGet(BV.this) == 0) {
                HE0 he0 = this.e;
                InterfaceC24823zG1[] interfaceC24823zG1Arr = BV.this.a;
                ArrayList arrayList = new ArrayList(interfaceC24823zG1Arr.length);
                for (InterfaceC24823zG1 interfaceC24823zG1 : interfaceC24823zG1Arr) {
                    arrayList.add(interfaceC24823zG1.k());
                }
                he0.resumeWith(C9475a16.b(arrayList));
            }
        }

        public final b D() {
            return (b) h.get(this);
        }

        public final NV1 E() {
            NV1 nv1 = this.f;
            if (nv1 != null) {
                return nv1;
            }
            AbstractC13042fc3.y("handle");
            return null;
        }

        public final void F(b bVar) {
            h.set(this, bVar);
        }

        public final void G(NV1 nv1) {
            this.f = nv1;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            A((Throwable) obj);
            return C19938rB7.a;
        }
    }

    private final class b extends AbstractC24804zE0 {
        private final a[] a;

        public b(a[] aVarArr) {
            this.a = aVarArr;
        }

        @Override // ir.nasim.AE0
        public void i(Throwable th) {
            k();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            i((Throwable) obj);
            return C19938rB7.a;
        }

        public final void k() {
            for (a aVar : this.a) {
                aVar.E().dispose();
            }
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.a + ']';
        }
    }

    public BV(InterfaceC24823zG1[] interfaceC24823zG1Arr) {
        this.a = interfaceC24823zG1Arr;
        this.notCompletedCount = interfaceC24823zG1Arr.length;
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        int length = this.a.length;
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            InterfaceC24823zG1 interfaceC24823zG1 = this.a[i];
            interfaceC24823zG1.start();
            a aVar = new a(ie0);
            aVar.G(interfaceC24823zG1.s(aVar));
            C19938rB7 c19938rB7 = C19938rB7.a;
            aVarArr[i] = aVar;
        }
        b bVar = new b(aVarArr);
        for (int i2 = 0; i2 < length; i2++) {
            aVarArr[i2].F(bVar);
        }
        if (ie0.p()) {
            bVar.k();
        } else {
            ie0.J(bVar);
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }
}
