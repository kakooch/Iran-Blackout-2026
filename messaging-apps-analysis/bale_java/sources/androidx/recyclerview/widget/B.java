package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C21892uJ3;
import ir.nasim.C22127ui5;
import ir.nasim.C24792zC6;
import ir.nasim.InterfaceC20850si5;

/* loaded from: classes2.dex */
class B {
    final C24792zC6 a = new C24792zC6();
    final C21892uJ3 b = new C21892uJ3();

    static class a {
        static InterfaceC20850si5 d = new C22127ui5(20);
        int a;
        RecyclerView.m.c b;
        RecyclerView.m.c c;

        private a() {
        }

        static void a() {
            while (d.b() != null) {
            }
        }

        static a b() {
            a aVar = (a) d.b();
            return aVar == null ? new a() : aVar;
        }

        static void c(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }
    }

    interface b {
        void a(RecyclerView.C c, RecyclerView.m.c cVar, RecyclerView.m.c cVar2);

        void b(RecyclerView.C c);

        void c(RecyclerView.C c, RecyclerView.m.c cVar, RecyclerView.m.c cVar2);

        void d(RecyclerView.C c, RecyclerView.m.c cVar, RecyclerView.m.c cVar2);
    }

    B() {
    }

    private RecyclerView.m.c l(RecyclerView.C c, int i) {
        a aVar;
        RecyclerView.m.c cVar;
        int iE = this.a.e(c);
        if (iE >= 0 && (aVar = (a) this.a.k(iE)) != null) {
            int i2 = aVar.a;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                aVar.a = i3;
                if (i == 4) {
                    cVar = aVar.b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVar.c;
                }
                if ((i3 & 12) == 0) {
                    this.a.i(iE);
                    a.c(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    void a(RecyclerView.C c, RecyclerView.m.c cVar) {
        a aVarB = (a) this.a.get(c);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c, aVarB);
        }
        aVarB.a |= 2;
        aVarB.b = cVar;
    }

    void b(RecyclerView.C c) {
        a aVarB = (a) this.a.get(c);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c, aVarB);
        }
        aVarB.a |= 1;
    }

    void c(long j, RecyclerView.C c) {
        this.b.l(j, c);
    }

    void d(RecyclerView.C c, RecyclerView.m.c cVar) {
        a aVarB = (a) this.a.get(c);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c, aVarB);
        }
        aVarB.c = cVar;
        aVarB.a |= 8;
    }

    void e(RecyclerView.C c, RecyclerView.m.c cVar) {
        a aVarB = (a) this.a.get(c);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c, aVarB);
        }
        aVarB.b = cVar;
        aVarB.a |= 4;
    }

    void f() {
        this.a.clear();
        this.b.c();
    }

    RecyclerView.C g(long j) {
        return (RecyclerView.C) this.b.f(j);
    }

    boolean h(RecyclerView.C c) {
        a aVar = (a) this.a.get(c);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.C c) {
        a aVar = (a) this.a.get(c);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.C c) {
        p(c);
    }

    RecyclerView.m.c m(RecyclerView.C c) {
        return l(c, 8);
    }

    RecyclerView.m.c n(RecyclerView.C c) {
        return l(c, 4);
    }

    void o(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.C c = (RecyclerView.C) this.a.g(size);
            a aVar = (a) this.a.i(size);
            int i = aVar.a;
            if ((i & 3) == 3) {
                bVar.b(c);
            } else if ((i & 1) != 0) {
                RecyclerView.m.c cVar = aVar.b;
                if (cVar == null) {
                    bVar.b(c);
                } else {
                    bVar.c(c, cVar, aVar.c);
                }
            } else if ((i & 14) == 14) {
                bVar.a(c, aVar.b, aVar.c);
            } else if ((i & 12) == 12) {
                bVar.d(c, aVar.b, aVar.c);
            } else if ((i & 4) != 0) {
                bVar.c(c, aVar.b, null);
            } else if ((i & 8) != 0) {
                bVar.a(c, aVar.b, aVar.c);
            }
            a.c(aVar);
        }
    }

    void p(RecyclerView.C c) {
        a aVar = (a) this.a.get(c);
        if (aVar == null) {
            return;
        }
        aVar.a &= -2;
    }

    void q(RecyclerView.C c) {
        int iO = this.b.o() - 1;
        while (true) {
            if (iO < 0) {
                break;
            }
            if (c == this.b.p(iO)) {
                this.b.n(iO);
                break;
            }
            iO--;
        }
        a aVar = (a) this.a.remove(c);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
