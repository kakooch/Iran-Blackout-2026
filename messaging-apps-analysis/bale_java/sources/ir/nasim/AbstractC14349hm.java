package ir.nasim;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.hm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14349hm {
    private final InterfaceC14957im a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private InterfaceC14957im h;
    private final Map i;

    /* renamed from: ir.nasim.hm$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(InterfaceC14957im interfaceC14957im) {
            if (interfaceC14957im.o()) {
                if (interfaceC14957im.t().g()) {
                    interfaceC14957im.S();
                }
                Map map = interfaceC14957im.t().i;
                AbstractC14349hm abstractC14349hm = AbstractC14349hm.this;
                for (Map.Entry entry : map.entrySet()) {
                    abstractC14349hm.c((AbstractC13165fm) entry.getKey(), ((Number) entry.getValue()).intValue(), interfaceC14957im.e0());
                }
                XA4 xa4L2 = interfaceC14957im.e0().L2();
                AbstractC13042fc3.f(xa4L2);
                while (!AbstractC13042fc3.d(xa4L2, AbstractC14349hm.this.f().e0())) {
                    Set<AbstractC13165fm> setKeySet = AbstractC14349hm.this.e(xa4L2).keySet();
                    AbstractC14349hm abstractC14349hm2 = AbstractC14349hm.this;
                    for (AbstractC13165fm abstractC13165fm : setKeySet) {
                        abstractC14349hm2.c(abstractC13165fm, abstractC14349hm2.i(xa4L2, abstractC13165fm), xa4L2);
                    }
                    xa4L2 = xa4L2.L2();
                    AbstractC13042fc3.f(xa4L2);
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC14957im) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ AbstractC14349hm(InterfaceC14957im interfaceC14957im, ED1 ed1) {
        this(interfaceC14957im);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(AbstractC13165fm abstractC13165fm, int i, XA4 xa4) {
        float f = i;
        long jE = ZG4.e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L));
        while (true) {
            jE = d(xa4, jE);
            xa4 = xa4.L2();
            AbstractC13042fc3.f(xa4);
            if (AbstractC13042fc3.d(xa4, this.a.e0())) {
                break;
            } else if (e(xa4).containsKey(abstractC13165fm)) {
                float fI = i(xa4, abstractC13165fm);
                jE = ZG4.e((Float.floatToRawIntBits(fI) << 32) | (Float.floatToRawIntBits(fI) & 4294967295L));
            }
        }
        int iRound = Math.round(abstractC13165fm instanceof HY2 ? Float.intBitsToFloat((int) (jE & 4294967295L)) : Float.intBitsToFloat((int) (jE >> 32)));
        Map map = this.i;
        if (map.containsKey(abstractC13165fm)) {
            iRound = AbstractC13756gm.c(abstractC13165fm, ((Number) AbstractC20051rO3.l(this.i, abstractC13165fm)).intValue(), iRound);
        }
        map.put(abstractC13165fm, Integer.valueOf(iRound));
    }

    protected abstract long d(XA4 xa4, long j);

    protected abstract Map e(XA4 xa4);

    public final InterfaceC14957im f() {
        return this.a;
    }

    public final boolean g() {
        return this.b;
    }

    public final Map h() {
        return this.i;
    }

    protected abstract int i(XA4 xa4, AbstractC13165fm abstractC13165fm);

    public final boolean j() {
        return this.c || this.e || this.f || this.g;
    }

    public final boolean k() {
        o();
        return this.h != null;
    }

    public final boolean l() {
        return this.d;
    }

    public final void m() {
        this.b = true;
        InterfaceC14957im interfaceC14957imE = this.a.E();
        if (interfaceC14957imE == null) {
            return;
        }
        if (this.c) {
            interfaceC14957imE.q0();
        } else if (this.e || this.d) {
            interfaceC14957imE.requestLayout();
        }
        if (this.f) {
            this.a.q0();
        }
        if (this.g) {
            this.a.requestLayout();
        }
        interfaceC14957imE.t().m();
    }

    public final void n() {
        this.i.clear();
        this.a.m0(new a());
        this.i.putAll(e(this.a.e0()));
        this.b = false;
    }

    public final void o() {
        InterfaceC14957im interfaceC14957im;
        AbstractC14349hm abstractC14349hmT;
        AbstractC14349hm abstractC14349hmT2;
        if (j()) {
            interfaceC14957im = this.a;
        } else {
            InterfaceC14957im interfaceC14957imE = this.a.E();
            if (interfaceC14957imE == null) {
                return;
            }
            interfaceC14957im = interfaceC14957imE.t().h;
            if (interfaceC14957im == null || !interfaceC14957im.t().j()) {
                InterfaceC14957im interfaceC14957im2 = this.h;
                if (interfaceC14957im2 == null || interfaceC14957im2.t().j()) {
                    return;
                }
                InterfaceC14957im interfaceC14957imE2 = interfaceC14957im2.E();
                if (interfaceC14957imE2 != null && (abstractC14349hmT2 = interfaceC14957imE2.t()) != null) {
                    abstractC14349hmT2.o();
                }
                InterfaceC14957im interfaceC14957imE3 = interfaceC14957im2.E();
                interfaceC14957im = (interfaceC14957imE3 == null || (abstractC14349hmT = interfaceC14957imE3.t()) == null) ? null : abstractC14349hmT.h;
            }
        }
        this.h = interfaceC14957im;
    }

    public final void p() {
        this.b = true;
        this.c = false;
        this.e = false;
        this.d = false;
        this.f = false;
        this.g = false;
        this.h = null;
    }

    public final void q(boolean z) {
        this.e = z;
    }

    public final void r(boolean z) {
        this.g = z;
    }

    public final void s(boolean z) {
        this.f = z;
    }

    public final void t(boolean z) {
        this.d = z;
    }

    public final void u(boolean z) {
        this.c = z;
    }

    private AbstractC14349hm(InterfaceC14957im interfaceC14957im) {
        this.a = interfaceC14957im;
        this.b = true;
        this.i = new HashMap();
    }
}
