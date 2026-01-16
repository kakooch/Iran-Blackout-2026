package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
public abstract class DJ3 extends BJ3 implements ZV3 {
    private final XA4 p;
    private Map r;
    private InterfaceC11734dW3 t;
    private long q = C22045ua3.b.b();
    private final EJ3 s = new EJ3(this);
    private final C3348Am4 u = AbstractC21866uG4.b();

    public DJ3(XA4 xa4) {
        this.p = xa4;
    }

    private final void h2(long j) {
        if (!C22045ua3.j(F1(), j)) {
            k2(j);
            GJ3 gj3V = G1().e0().v();
            if (gj3V != null) {
                gj3V.Z1();
            }
            K1(this.p);
        }
        if (R1()) {
            return;
        }
        h1(q1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(InterfaceC11734dW3 interfaceC11734dW3) {
        C19938rB7 c19938rB7;
        Map map;
        if (interfaceC11734dW3 != null) {
            Y0(C4414Fa3.c((interfaceC11734dW3.getHeight() & 4294967295L) | (interfaceC11734dW3.getWidth() << 32)));
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            Y0(C4414Fa3.b.a());
        }
        if (!AbstractC13042fc3.d(this.t, interfaceC11734dW3) && interfaceC11734dW3 != null && ((((map = this.r) != null && !map.isEmpty()) || (!interfaceC11734dW3.t().isEmpty())) && !AbstractC13042fc3.d(interfaceC11734dW3.t(), this.r))) {
            a2().t().m();
            Map linkedHashMap = this.r;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.r = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(interfaceC11734dW3.t());
        }
        this.t = interfaceC11734dW3;
    }

    @Override // ir.nasim.BJ3
    public long F1() {
        return this.q;
    }

    @Override // ir.nasim.BJ3, ir.nasim.InterfaceC12986fW3
    public C3419Au3 G1() {
        return this.p.G1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21430te5
    public final void U0(long j, float f, UA2 ua2) {
        h2(j);
        if (S1()) {
            return;
        }
        g2();
    }

    @Override // ir.nasim.BJ3
    public void U1() {
        U0(F1(), 0.0f, null);
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public abstract int Z(int i);

    public InterfaceC14957im a2() {
        InterfaceC14957im interfaceC14957imP = this.p.G1().e0().p();
        AbstractC13042fc3.f(interfaceC14957imP);
        return interfaceC14957imP;
    }

    public final int b2(AbstractC13165fm abstractC13165fm) {
        return this.u.e(abstractC13165fm, RecyclerView.UNDEFINED_DURATION);
    }

    protected final C3348Am4 c2() {
        return this.u;
    }

    public final long d2() {
        return O0();
    }

    public final XA4 e2() {
        return this.p;
    }

    public final EJ3 f2() {
        return this.s;
    }

    protected void g2() {
        q1().j();
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.p.getDensity();
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public EnumC12613eu3 getLayoutDirection() {
        return this.p.getLayoutDirection();
    }

    @Override // ir.nasim.InterfaceC14195hW3, ir.nasim.InterfaceC9236Zb3
    public Object h() {
        return this.p.h();
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public abstract int i0(int i);

    public final void i2(long j) {
        h2(C22045ua3.o(j, x0()));
    }

    @Override // ir.nasim.BJ3
    public BJ3 j1() {
        XA4 xa4K2 = this.p.K2();
        if (xa4K2 != null) {
            return xa4K2.E2();
        }
        return null;
    }

    public final long j2(DJ3 dj3, boolean z) {
        long jB = C22045ua3.b.b();
        DJ3 dj3E2 = this;
        while (!AbstractC13042fc3.d(dj3E2, dj3)) {
            if (!dj3E2.M1() || !z) {
                jB = C22045ua3.o(jB, dj3E2.F1());
            }
            XA4 xa4L2 = dj3E2.p.L2();
            AbstractC13042fc3.f(xa4L2);
            dj3E2 = xa4L2.E2();
            AbstractC13042fc3.f(dj3E2);
        }
        return jB;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public abstract int k0(int i);

    @Override // ir.nasim.BJ3
    public InterfaceC11379cu3 k1() {
        return this.s;
    }

    public void k2(long j) {
        this.q = j;
    }

    @Override // ir.nasim.BJ3
    public boolean l1() {
        return this.t != null;
    }

    @Override // ir.nasim.BJ3
    public InterfaceC11734dW3 q1() {
        InterfaceC11734dW3 interfaceC11734dW3 = this.t;
        if (interfaceC11734dW3 != null) {
            return interfaceC11734dW3;
        }
        M73.c("LookaheadDelegate has not been measured yet when measureResult is requested.");
        throw new KotlinNothingValueException();
    }

    @Override // ir.nasim.BJ3, ir.nasim.InterfaceC10436bc3
    public boolean s0() {
        return true;
    }

    @Override // ir.nasim.BJ3
    public BJ3 s1() {
        XA4 xa4L2 = this.p.L2();
        if (xa4L2 != null) {
            return xa4L2.E2();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.p.t1();
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public abstract int z(int i);
}
