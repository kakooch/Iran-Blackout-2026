package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class Q90 extends AbstractC4177Ea0 {
    private PE f;
    private E84 g;
    private R90 h;
    private C19024pf0 i;
    public OP1 j;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OP1.values().length];
            a = iArr;
            try {
                iArr[OP1.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OP1.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OP1.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OP1.CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[OP1.BOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Q90(R90 r90, OP1 op1) {
        super(r90);
        this.f = ((InterfaceC9291Zh4) C92.a(AbstractC14047hG.a, InterfaceC9291Zh4.class)).M0();
        this.g = ((InterfaceC9291Zh4) C92.a(AbstractC14047hG.a, InterfaceC9291Zh4.class)).O0();
        this.h = r90;
        this.j = op1;
        n();
    }

    private void n() {
        C19024pf0 c19024pf0K2 = AbstractC5969Lp4.d().k2(this.j);
        this.i = c19024pf0K2;
        if (c19024pf0K2 == null) {
            C19406qI3.b("BaseDialogFragmentMVPPresenter", "initDisplayList get null list and returned");
            return;
        }
        try {
        } catch (Exception e) {
            C19406qI3.c("BaseDialogFragmentMVPPresenter", "initDisplayList failed to GETListProcessor", e);
        }
        if (c19024pf0K2.p() == null) {
            try {
                this.i.v(new VB3() { // from class: ir.nasim.P90
                    @Override // ir.nasim.VB3
                    public final Object a(List list, Object obj) {
                        return Q90.t(list, obj);
                    }
                });
            } catch (Exception e2) {
                C19406qI3.c("BaseDialogFragmentMVPPresenter", "initDisplayList failed to SETListProcessor", e2);
            }
        }
        this.i.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(EnumC12820fE enumC12820fE, AbstractC13554gQ7 abstractC13554gQ7) {
        this.h.J3(enumC12820fE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(EnumC12820fE enumC12820fE, AbstractC13554gQ7 abstractC13554gQ7) {
        this.h.J3(enumC12820fE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(EnumC12820fE enumC12820fE, AbstractC13554gQ7 abstractC13554gQ7) {
        this.h.J3(enumC12820fE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(EnumC12820fE enumC12820fE, AbstractC13554gQ7 abstractC13554gQ7) {
        this.h.J3(enumC12820fE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(EnumC12820fE enumC12820fE, AbstractC13554gQ7 abstractC13554gQ7) {
        this.h.J3(enumC12820fE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object t(List list, Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C17067mL1 c17067mL1 = (C17067mL1) it.next();
            if (c17067mL1.getExPeerType() == ExPeerType.GROUP) {
                long jU = c17067mL1.Q().U();
                if (!arrayList.contains(Long.valueOf(jU))) {
                    arrayList.add(Long.valueOf(jU));
                }
            }
        }
        for (C17637nI7 c17637nI7 : AbstractC5969Lp4.g().o().f(arrayList)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C17067mL1 c17067mL12 = (C17067mL1) it2.next();
                if (c17067mL12.Q().U() == c17637nI7.n0()) {
                    c17067mL12.i0(c17637nI7.getName());
                }
            }
        }
        return null;
    }

    @Override // ir.nasim.AbstractC4177Ea0
    public void b() {
        super.b();
        e();
    }

    public C19024pf0 l(String str) {
        if (this.i == null) {
            C19406qI3.b("BaseDialogFragmentMVPPresenter", str + " wants getDisplayList but is null");
        }
        return this.i;
    }

    public void m() {
        int i = a.a[this.j.ordinal()];
        if (i == 1) {
            a(this.f.D().a(), new InterfaceC14756iQ7() { // from class: ir.nasim.K90
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.o((EnumC12820fE) obj, abstractC13554gQ7);
                }
            });
        } else if (i == 2) {
            a(this.f.D().g(), new InterfaceC14756iQ7() { // from class: ir.nasim.L90
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.p((EnumC12820fE) obj, abstractC13554gQ7);
                }
            });
        } else if (i == 3) {
            a(this.f.D().f(), new InterfaceC14756iQ7() { // from class: ir.nasim.M90
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.q((EnumC12820fE) obj, abstractC13554gQ7);
                }
            });
        } else if (i == 4) {
            a(this.f.D().d(), new InterfaceC14756iQ7() { // from class: ir.nasim.N90
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.r((EnumC12820fE) obj, abstractC13554gQ7);
                }
            });
        } else if (i == 5) {
            a(this.f.D().c(), new InterfaceC14756iQ7() { // from class: ir.nasim.O90
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.s((EnumC12820fE) obj, abstractC13554gQ7);
                }
            });
        }
        this.g.Y0(this.j);
    }
}
