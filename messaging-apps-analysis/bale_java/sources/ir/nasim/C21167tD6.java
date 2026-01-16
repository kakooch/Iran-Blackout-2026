package ir.nasim;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.tD6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21167tD6 extends C20298rm4 {
    public static final a m = new a(null);
    public static final int n = 8;
    private final AtomicBoolean l = new AtomicBoolean(false);

    /* renamed from: ir.nasim.tD6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(C21167tD6 c21167tD6, QG4 qg4, Object obj) {
        AbstractC13042fc3.i(c21167tD6, "this$0");
        AbstractC13042fc3.i(qg4, "$observer");
        if (c21167tD6.l.compareAndSet(true, false)) {
            qg4.a(obj);
        }
    }

    @Override // androidx.lifecycle.r
    public void j(InterfaceC18633oz3 interfaceC18633oz3, final QG4 qg4) {
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        AbstractC13042fc3.i(qg4, "observer");
        if (h()) {
            C19406qI3.j("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        super.j(interfaceC18633oz3, new QG4() { // from class: ir.nasim.sD6
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                C21167tD6.s(this.a, qg4, obj);
            }
        });
    }

    @Override // ir.nasim.C20298rm4, androidx.lifecycle.r
    public void p(Object obj) {
        this.l.set(true);
        super.p(obj);
    }

    public final void r() {
        p(null);
    }
}
