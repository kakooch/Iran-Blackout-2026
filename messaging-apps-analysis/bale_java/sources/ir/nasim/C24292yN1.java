package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;

/* renamed from: ir.nasim.yN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24292yN1 extends AbstractC4177Ea0 {
    private int f;
    private int g;
    private InterfaceC14756iQ7 h;
    private InterfaceC14756iQ7 i;
    private CharSequence j;
    private int k;
    private SettingsModule l;
    private final InterfaceC24886zN1 m;

    /* renamed from: ir.nasim.yN1$a */
    class a implements InterfaceC24449ye1 {
        final /* synthetic */ Context a;
        final /* synthetic */ ArrayList b;

        a(Context context, ArrayList arrayList) {
            this.a = context;
            this.b = arrayList;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void apply(C21231tK7 c21231tK7) {
            C24292yN1.this.m.W(AbstractC4699Ge3.a(this.a, this.b, (String) c21231tK7.r().b()) + "...");
        }
    }

    public C24292yN1(InterfaceC24886zN1 interfaceC24886zN1) {
        super(interfaceC24886zN1);
        this.l = AbstractC5969Lp4.e().S();
        this.m = interfaceC24886zN1;
        this.k = C5495Jo7.a.U0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(Context context, int i, EnumC5360Iz7 enumC5360Iz7, AbstractC13554gQ7 abstractC13554gQ7) {
        if (this.m != null) {
            if (!enumC5360Iz7.q()) {
                this.m.W(this.j);
                this.m.Y4(i);
                return;
            }
            this.m.W(AbstractC4699Ge3.b(context, enumC5360Iz7) + "...");
            this.m.Y4(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(int i, Context context, ArrayList arrayList, AbstractC13554gQ7 abstractC13554gQ7) {
        if (this.m == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            this.m.W(this.j);
            this.m.Y4(i);
        } else {
            AbstractC5969Lp4.g().k(((C11661dO2) arrayList2.get(0)).b()).m0(new a(context, arrayList2));
            this.m.Y4(this.k);
        }
    }

    public void i(C17067mL1 c17067mL1) {
        if (c17067mL1.R().getPeerId() == AbstractC5969Lp4.f()) {
            this.m.j3();
            return;
        }
        int iY = c17067mL1.Y();
        if (C8386Vt0.C6() && AbstractC20655sN7.j(this.l.b2()).contains(Long.valueOf(c17067mL1.R().u())) && iY > this.l.a2()) {
            this.m.m1(this.l.a2());
        } else if (iY > 0) {
            this.m.m1(iY);
        } else {
            this.m.j3();
        }
    }

    public void j(C17067mL1 c17067mL1) {
        if (c17067mL1.R().getPeerId() == AbstractC5969Lp4.f()) {
            this.m.G3();
            return;
        }
        if (c17067mL1.Q().U() != AbstractC5969Lp4.f() || c17067mL1.Y() > 0) {
            this.m.G3();
            return;
        }
        ExPeerType exPeerType = ExPeerType.PRIVATE;
        if (c17067mL1.R().s() == W25.b) {
            exPeerType = ExPeerType.GROUP;
        }
        if (c17067mL1.getExPeerType() != null) {
            ExPeerType exPeerType2 = c17067mL1.getExPeerType();
            ExPeerType exPeerType3 = ExPeerType.CHANNEL;
            if (exPeerType2.equals(exPeerType3)) {
                exPeerType = exPeerType3;
            }
        }
        if (exPeerType == ExPeerType.CHANNEL) {
            this.m.G3();
            return;
        }
        if (c17067mL1.K() != null && !c17067mL1.K().isEmpty() && c17067mL1.Y() == 0) {
            this.m.G3();
            return;
        }
        if (c17067mL1.g0()) {
            this.m.P4(EnumC23130wP1.c);
        } else if (c17067mL1.h0()) {
            this.m.P4(EnumC23130wP1.b);
        } else {
            this.m.P4(EnumC23130wP1.a);
        }
    }

    public void k(final Context context, C17067mL1 c17067mL1) {
        this.j = C15903kN1.c(context, c17067mL1);
        final int iF1 = C5495Jo7.a.f1();
        ExPeerType exPeerType = ExPeerType.PRIVATE;
        ExPeerType exPeerType2 = c17067mL1.R().s() == W25.b ? ExPeerType.GROUP : exPeerType;
        if (c17067mL1.getExPeerType() != null) {
            ExPeerType exPeerType3 = c17067mL1.getExPeerType();
            ExPeerType exPeerType4 = ExPeerType.CHANNEL;
            if (exPeerType3.equals(exPeerType4)) {
                exPeerType2 = exPeerType4;
            }
        }
        if (this.h != null) {
            AbstractC5969Lp4.d().g0(this.f).h(this.h);
            this.h = null;
        }
        if (this.i != null) {
            AbstractC5969Lp4.d().W(this.g).h(this.i);
            this.i = null;
        }
        if (exPeerType2 == exPeerType) {
            this.f = c17067mL1.R().getPeerId();
            this.h = new InterfaceC14756iQ7() { // from class: ir.nasim.wN1
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.n(context, iF1, (EnumC5360Iz7) obj, abstractC13554gQ7);
                }
            };
            AbstractC5969Lp4.d().g0(this.f).f(this.h);
        } else if (exPeerType2 != ExPeerType.GROUP) {
            this.m.W(this.j);
            this.m.Y4(iF1);
        } else {
            this.g = c17067mL1.R().getPeerId();
            this.i = new InterfaceC14756iQ7() { // from class: ir.nasim.xN1
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.o(iF1, context, (ArrayList) obj, abstractC13554gQ7);
                }
            };
            AbstractC5969Lp4.d().W(this.g).f(this.i);
        }
    }

    public void l(Context context, C17067mL1 c17067mL1) {
        if (c17067mL1.R().getPeerId() == AbstractC5969Lp4.f()) {
            this.m.J4();
            return;
        }
        if (c17067mL1.V() != null) {
            this.m.J4();
            return;
        }
        if (c17067mL1.K() != null && !c17067mL1.K().isEmpty() && c17067mL1.Y() == 0) {
            String strQ = C14593iA1.q(context, c17067mL1.L().longValue());
            if (JF5.g()) {
                strQ = XY6.e(strQ);
            }
            this.m.c2(strQ);
            return;
        }
        if (c17067mL1.X() <= 0) {
            this.m.J4();
            return;
        }
        String strQ2 = C14593iA1.q(context, c17067mL1.X());
        if (JF5.g()) {
            strQ2 = XY6.e(strQ2);
        }
        this.m.c2(strQ2);
    }

    public boolean m(C17067mL1 c17067mL1) {
        return AbstractC5969Lp4.d().A0(c17067mL1.R());
    }

    public void p() {
        if (this.h != null) {
            AbstractC5969Lp4.d().g0(this.f).h(this.h);
            this.h = null;
        }
        if (this.i != null) {
            AbstractC5969Lp4.d().W(this.g).h(this.i);
            this.i = null;
        }
    }
}
