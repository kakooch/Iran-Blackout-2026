package androidx.compose.foundation;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC10274bN4;
import ir.nasim.AbstractC10890cN4;
import ir.nasim.AbstractC12520el0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16278l02;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C24381yX0;
import ir.nasim.C8568Wn2;
import ir.nasim.ED1;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.InterfaceC15687k02;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.MK5;
import ir.nasim.OD6;
import ir.nasim.SA2;
import ir.nasim.SG4;
import ir.nasim.TG4;

/* loaded from: classes.dex */
final class c extends e.c implements InterfaceC15687k02, SG4 {
    private long o;
    private AbstractC12520el0 p;
    private float q;
    private InterfaceC10031ax6 r;
    private long s;
    private EnumC12613eu3 t;
    private AbstractC10274bN4 u;
    private InterfaceC10031ax6 v;
    private AbstractC10274bN4 w;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC23919xk1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC23919xk1 interfaceC23919xk1) {
            super(0);
            this.f = interfaceC23919xk1;
        }

        public final void a() {
            c cVar = c.this;
            cVar.w = cVar.z2().a(this.f.d(), this.f.getLayoutDirection(), this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ c(long j, AbstractC12520el0 abstractC12520el0, float f, InterfaceC10031ax6 interfaceC10031ax6, ED1 ed1) {
        this(j, abstractC12520el0, f, interfaceC10031ax6);
    }

    private final void w2(InterfaceC23919xk1 interfaceC23919xk1) {
        AbstractC10274bN4 abstractC10274bN4Y2 = y2(interfaceC23919xk1);
        if (!C24381yX0.q(this.o, C24381yX0.b.i())) {
            AbstractC10890cN4.c(interfaceC23919xk1, abstractC10274bN4Y2, this.o, (60 & 4) != 0 ? 1.0f : 0.0f, (60 & 8) != 0 ? C8568Wn2.a : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? InterfaceC17460n02.i0.a() : 0);
        }
        AbstractC12520el0 abstractC12520el0 = this.p;
        if (abstractC12520el0 != null) {
            AbstractC10890cN4.b(interfaceC23919xk1, abstractC10274bN4Y2, abstractC12520el0, this.q, null, null, 0, 56, null);
        }
    }

    private final void x2(InterfaceC23919xk1 interfaceC23919xk1) {
        if (!C24381yX0.q(this.o, C24381yX0.b.i())) {
            InterfaceC17460n02.C1(interfaceC23919xk1, this.o, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        AbstractC12520el0 abstractC12520el0 = this.p;
        if (abstractC12520el0 != null) {
            InterfaceC17460n02.y0(interfaceC23919xk1, abstractC12520el0, 0L, 0L, this.q, null, null, 0, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, null);
        }
    }

    private final AbstractC10274bN4 y2(InterfaceC23919xk1 interfaceC23919xk1) {
        AbstractC10274bN4 abstractC10274bN4;
        if (OD6.f(interfaceC23919xk1.d(), this.s) && interfaceC23919xk1.getLayoutDirection() == this.t && AbstractC13042fc3.d(this.v, this.r)) {
            abstractC10274bN4 = this.u;
            AbstractC13042fc3.f(abstractC10274bN4);
        } else {
            TG4.a(this, new a(interfaceC23919xk1));
            abstractC10274bN4 = this.w;
            this.w = null;
        }
        this.u = abstractC10274bN4;
        this.s = interfaceC23919xk1.d();
        this.t = interfaceC23919xk1.getLayoutDirection();
        this.v = this.r;
        AbstractC13042fc3.f(abstractC10274bN4);
        return abstractC10274bN4;
    }

    public final void A2(AbstractC12520el0 abstractC12520el0) {
        this.p = abstractC12520el0;
    }

    public final void B2(long j) {
        this.o = j;
    }

    public final void V(InterfaceC10031ax6 interfaceC10031ax6) {
        this.r = interfaceC10031ax6;
    }

    public final void c(float f) {
        this.q = f;
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        if (this.r == MK5.a()) {
            x2(interfaceC23919xk1);
        } else {
            w2(interfaceC23919xk1);
        }
        interfaceC23919xk1.N1();
    }

    @Override // ir.nasim.SG4
    public void x0() {
        this.s = OD6.b.a();
        this.t = null;
        this.u = null;
        this.v = null;
        AbstractC16278l02.a(this);
    }

    public final InterfaceC10031ax6 z2() {
        return this.r;
    }

    private c(long j, AbstractC12520el0 abstractC12520el0, float f, InterfaceC10031ax6 interfaceC10031ax6) {
        this.o = j;
        this.p = abstractC12520el0;
        this.q = f;
        this.r = interfaceC10031ax6;
        this.s = OD6.b.a();
    }
}
