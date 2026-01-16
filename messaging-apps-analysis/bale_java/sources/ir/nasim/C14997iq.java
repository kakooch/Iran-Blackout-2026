package ir.nasim;

import android.graphics.Paint;
import android.graphics.Shader;

/* renamed from: ir.nasim.iq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14997iq implements InterfaceC12969fU4 {
    private Paint a;
    private int b;
    private Shader c;
    private AbstractC24975zX0 d;

    public C14997iq(Paint paint) {
        this.a = paint;
        this.b = AbstractC7094Qg0.a.B();
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public float a() {
        return AbstractC15587jq.c(this.a);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public AbstractC24975zX0 b() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void c(float f) {
        AbstractC15587jq.k(this.a, f);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public long d() {
        return AbstractC15587jq.d(this.a);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void e(AbstractC24975zX0 abstractC24975zX0) {
        this.d = abstractC24975zX0;
        AbstractC15587jq.n(this.a, abstractC24975zX0);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void f(int i) {
        AbstractC15587jq.r(this.a, i);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void g(int i) {
        if (AbstractC7094Qg0.E(this.b, i)) {
            return;
        }
        this.b = i;
        AbstractC15587jq.l(this.a, i);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void h(int i) {
        AbstractC15587jq.o(this.a, i);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public int i() {
        return AbstractC15587jq.f(this.a);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void j(int i) {
        AbstractC15587jq.s(this.a, i);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void k(long j) {
        AbstractC15587jq.m(this.a, j);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public InterfaceC13909h15 l() {
        return null;
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public int m() {
        return AbstractC15587jq.g(this.a);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public float n() {
        return AbstractC15587jq.h(this.a);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public int o() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public Paint p() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void q(Shader shader) {
        this.c = shader;
        AbstractC15587jq.q(this.a, shader);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public Shader r() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void s(InterfaceC13909h15 interfaceC13909h15) {
        AbstractC15587jq.p(this.a, interfaceC13909h15);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void t(float f) {
        AbstractC15587jq.t(this.a, f);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public int u() {
        return AbstractC15587jq.e(this.a);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void v(int i) {
        AbstractC15587jq.v(this.a, i);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public void w(float f) {
        AbstractC15587jq.u(this.a, f);
    }

    @Override // ir.nasim.InterfaceC12969fU4
    public float x() {
        return AbstractC15587jq.i(this.a);
    }

    public C14997iq() {
        this(AbstractC15587jq.j());
    }
}
