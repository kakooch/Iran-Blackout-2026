package ir.nasim;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* renamed from: ir.nasim.Zr4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9381Zr4 extends ME {
    private static final ExecutorService s = SZ.k("S_ping");
    private boolean o;
    private Future p;
    private final C9057Yh4 q;
    private final InterfaceC3817Cm0 r;

    public C9381Zr4(C11335cq c11335cq, C9057Yh4 c9057Yh4) {
        super(c11335cq);
        this.o = false;
        this.r = new InterfaceC3817Cm0() { // from class: ir.nasim.Xr4
            @Override // ir.nasim.InterfaceC3817Cm0
            /* renamed from: g */
            public final void T(AbstractC18385oa2 abstractC18385oa2) {
                this.a.P(abstractC18385oa2);
            }
        };
        this.q = c9057Yh4;
    }

    private void O() {
        Future future = this.p;
        if (future != null) {
            future.cancel(true);
            this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(AbstractC18385oa2 abstractC18385oa2) {
        boolean z;
        if (B() && (abstractC18385oa2 instanceof C15459jd1) && (z = ((C15459jd1) abstractC18385oa2).a) != this.o) {
            this.o = z;
            if (z) {
                R();
            } else {
                S();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q() throws IOException {
        C19406qI3.a("NewAppStateActor", "ping result has network : " + C4100Dr4.c(), new Object[0]);
    }

    private void R() {
        if (!C4100Dr4.a(C5721Ko.b)) {
            C19406qI3.a("NewAppStateActor", " is connecting because of no network connection and returned", new Object[0]);
            return;
        }
        C19406qI3.a("NewAppStateActor", " is connecting and going to check ping", new Object[0]);
        O();
        this.p = s.submit(new Runnable() { // from class: ir.nasim.Yr4
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                C9381Zr4.Q();
            }
        });
    }

    private void S() {
        O();
        C19406qI3.a("NewAppStateActor", " STOP is_connecting trace", new Object[0]);
    }

    @Override // ir.nasim.ME
    protected void H() {
        S();
        super.H();
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.q.a().h(this.r, "connecting_state_changed");
    }
}
