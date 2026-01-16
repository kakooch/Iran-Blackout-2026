package ir.nasim;

/* renamed from: ir.nasim.zI4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC24844zI4 {

    /* renamed from: ir.nasim.zI4$a */
    public static final class a extends AbstractC23070wI4 {
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, UA2 ua2) {
            super(z);
            this.d = ua2;
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void d() {
            this.d.invoke(this);
        }
    }

    public static final AbstractC23070wI4 a(C23660xI4 c23660xI4, InterfaceC18633oz3 interfaceC18633oz3, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(c23660xI4, "<this>");
        AbstractC13042fc3.i(ua2, "onBackPressed");
        a aVar = new a(z, ua2);
        if (interfaceC18633oz3 != null) {
            c23660xI4.h(interfaceC18633oz3, aVar);
        } else {
            c23660xI4.i(aVar);
        }
        return aVar;
    }

    public static /* synthetic */ AbstractC23070wI4 b(C23660xI4 c23660xI4, InterfaceC18633oz3 interfaceC18633oz3, boolean z, UA2 ua2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC18633oz3 = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return a(c23660xI4, interfaceC18633oz3, z, ua2);
    }
}
