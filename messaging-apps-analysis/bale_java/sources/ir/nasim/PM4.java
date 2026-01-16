package ir.nasim;

import ir.nasim.AbstractC7031Pz0;
import ir.nasim.C17448mz0;
import ir.nasim.InterfaceC9449Zz0;

/* loaded from: classes5.dex */
public final class PM4 {
    public static final a b = new a(null);
    public static final int c = 8;
    private static InterfaceC9449Zz0.c d;
    private final C4627Fy0 a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public PM4(C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = c4627Fy0;
    }

    public final void a() {
        C17448mz0 c17448mz0 = (C17448mz0) C18039nz0.a.d().getValue();
        InterfaceC9449Zz0.c cVar = d;
        if (cVar != null) {
            long jA = cVar.a();
            if (c17448mz0.c() != jA || !(c17448mz0.f() instanceof AbstractC7031Pz0.g) || c17448mz0.e() != C17448mz0.a.b) {
                C19406qI3.a("OutGoingCallReceivedUseCase", "update call received ignored, because no call with id: " + jA + " is in progress.", new Object[0]);
                return;
            }
            C19406qI3.a("OutGoingCallReceivedUseCase", "outgoing call " + jA + " received applied", new Object[0]);
            this.a.W0();
        }
    }

    public final void b(InterfaceC9449Zz0.c cVar) {
        AbstractC13042fc3.i(cVar, "callReceived");
        C17448mz0 c17448mz0 = (C17448mz0) C18039nz0.a.d().getValue();
        long jA = cVar.a();
        if (c17448mz0.c() == jA && (c17448mz0.f() instanceof AbstractC7031Pz0.g) && c17448mz0.e() == C17448mz0.a.b) {
            C19406qI3.a("OutGoingCallReceivedUseCase", "outgoing call " + jA + " received applied", new Object[0]);
            this.a.W0();
            return;
        }
        if (!(c17448mz0.f() instanceof AbstractC7031Pz0.g) || c17448mz0.e() != C17448mz0.a.a) {
            C19406qI3.a("OutGoingCallReceivedUseCase", "update call received ignored, because no call with id: " + jA + " is in progress.", new Object[0]);
            return;
        }
        C19406qI3.a("OutGoingCallReceivedUseCase", "outgoing call " + jA + " received , add it to pending", new Object[0]);
        d = cVar;
    }
}
