package ir.nasim;

import ir.nasim.C13476gI1;
import java.util.Iterator;

/* renamed from: ir.nasim.oV2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C18340oV2 extends AbstractC15192j98 {
    public C18340oV2(C16651le1 c16651le1) {
        super(c16651le1);
    }

    private void q(C13476gI1 c13476gI1) {
        this.h.k.add(c13476gI1);
        c13476gI1.l.add(this.h);
    }

    @Override // ir.nasim.AbstractC15192j98, ir.nasim.InterfaceC10842cI1
    public void a(InterfaceC10842cI1 interfaceC10842cI1) {
        C11523d90 c11523d90 = (C11523d90) this.b;
        int iU1 = c11523d90.u1();
        Iterator it = this.h.l.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = ((C13476gI1) it.next()).g;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (iU1 == 0 || iU1 == 2) {
            this.h.d(i2 + c11523d90.v1());
        } else {
            this.h.d(i + c11523d90.v1());
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void d() {
        C16651le1 c16651le1 = this.b;
        if (c16651le1 instanceof C11523d90) {
            this.h.b = true;
            C11523d90 c11523d90 = (C11523d90) c16651le1;
            int iU1 = c11523d90.u1();
            boolean zT1 = c11523d90.t1();
            int i = 0;
            if (iU1 == 0) {
                this.h.e = C13476gI1.a.LEFT;
                while (i < c11523d90.W0) {
                    C16651le1 c16651le12 = c11523d90.V0[i];
                    if (zT1 || c16651le12.W() != 8) {
                        C13476gI1 c13476gI1 = c16651le12.e.h;
                        c13476gI1.k.add(this.h);
                        this.h.l.add(c13476gI1);
                    }
                    i++;
                }
                q(this.b.e.h);
                q(this.b.e.i);
                return;
            }
            if (iU1 == 1) {
                this.h.e = C13476gI1.a.RIGHT;
                while (i < c11523d90.W0) {
                    C16651le1 c16651le13 = c11523d90.V0[i];
                    if (zT1 || c16651le13.W() != 8) {
                        C13476gI1 c13476gI12 = c16651le13.e.i;
                        c13476gI12.k.add(this.h);
                        this.h.l.add(c13476gI12);
                    }
                    i++;
                }
                q(this.b.e.h);
                q(this.b.e.i);
                return;
            }
            if (iU1 == 2) {
                this.h.e = C13476gI1.a.TOP;
                while (i < c11523d90.W0) {
                    C16651le1 c16651le14 = c11523d90.V0[i];
                    if (zT1 || c16651le14.W() != 8) {
                        C13476gI1 c13476gI13 = c16651le14.f.h;
                        c13476gI13.k.add(this.h);
                        this.h.l.add(c13476gI13);
                    }
                    i++;
                }
                q(this.b.f.h);
                q(this.b.f.i);
                return;
            }
            if (iU1 != 3) {
                return;
            }
            this.h.e = C13476gI1.a.BOTTOM;
            while (i < c11523d90.W0) {
                C16651le1 c16651le15 = c11523d90.V0[i];
                if (zT1 || c16651le15.W() != 8) {
                    C13476gI1 c13476gI14 = c16651le15.f.i;
                    c13476gI14.k.add(this.h);
                    this.h.l.add(c13476gI14);
                }
                i++;
            }
            q(this.b.f.h);
            q(this.b.f.i);
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    public void e() {
        C16651le1 c16651le1 = this.b;
        if (c16651le1 instanceof C11523d90) {
            int iU1 = ((C11523d90) c16651le1).u1();
            if (iU1 == 0 || iU1 == 1) {
                this.b.l1(this.h.g);
            } else {
                this.b.m1(this.h.g);
            }
        }
    }

    @Override // ir.nasim.AbstractC15192j98
    void f() {
        this.c = null;
        this.h.c();
    }

    @Override // ir.nasim.AbstractC15192j98
    boolean m() {
        return false;
    }
}
