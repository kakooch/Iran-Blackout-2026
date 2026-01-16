package ir.nasim;

/* loaded from: classes2.dex */
class OS2 extends AbstractC15192j98 {
    public OS2(C16651le1 c16651le1) {
        super(c16651le1);
        c16651le1.e.f();
        c16651le1.f.f();
        this.f = ((NS2) c16651le1).r1();
    }

    private void q(C13476gI1 c13476gI1) {
        this.h.k.add(c13476gI1);
        c13476gI1.l.add(this.h);
    }

    @Override // ir.nasim.AbstractC15192j98, ir.nasim.InterfaceC10842cI1
    public void a(InterfaceC10842cI1 interfaceC10842cI1) {
        C13476gI1 c13476gI1 = this.h;
        if (c13476gI1.c && !c13476gI1.j) {
            this.h.d((int) ((((C13476gI1) c13476gI1.l.get(0)).g * ((NS2) this.b).u1()) + 0.5f));
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void d() {
        NS2 ns2 = (NS2) this.b;
        int iS1 = ns2.s1();
        int iT1 = ns2.t1();
        ns2.u1();
        if (ns2.r1() == 1) {
            if (iS1 != -1) {
                this.h.l.add(this.b.c0.e.h);
                this.b.c0.e.h.k.add(this.h);
                this.h.f = iS1;
            } else if (iT1 != -1) {
                this.h.l.add(this.b.c0.e.i);
                this.b.c0.e.i.k.add(this.h);
                this.h.f = -iT1;
            } else {
                C13476gI1 c13476gI1 = this.h;
                c13476gI1.b = true;
                c13476gI1.l.add(this.b.c0.e.i);
                this.b.c0.e.i.k.add(this.h);
            }
            q(this.b.e.h);
            q(this.b.e.i);
            return;
        }
        if (iS1 != -1) {
            this.h.l.add(this.b.c0.f.h);
            this.b.c0.f.h.k.add(this.h);
            this.h.f = iS1;
        } else if (iT1 != -1) {
            this.h.l.add(this.b.c0.f.i);
            this.b.c0.f.i.k.add(this.h);
            this.h.f = -iT1;
        } else {
            C13476gI1 c13476gI12 = this.h;
            c13476gI12.b = true;
            c13476gI12.l.add(this.b.c0.f.i);
            this.b.c0.f.i.k.add(this.h);
        }
        q(this.b.f.h);
        q(this.b.f.i);
    }

    @Override // ir.nasim.AbstractC15192j98
    public void e() {
        if (((NS2) this.b).r1() == 1) {
            this.b.l1(this.h.g);
        } else {
            this.b.m1(this.h.g);
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void f() {
        this.h.c();
    }

    @Override // ir.nasim.AbstractC15192j98
    boolean m() {
        return false;
    }
}
