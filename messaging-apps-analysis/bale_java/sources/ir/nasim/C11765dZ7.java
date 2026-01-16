package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C20919sp4;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.jaryan.discover.model.Action;
import ir.nasim.jaryan.discover.model.PeerItem;
import java.util.List;

/* renamed from: ir.nasim.dZ7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11765dZ7 extends RecyclerView.C {
    public static final a J = new a(null);
    public static final int Y = 8;
    private C20919sp4.b A;
    private C20919sp4.b B;
    private C20919sp4.b D;
    private C20919sp4.b G;
    private C16017kZ7 H;
    private final C12408eZ7 u;
    private final InterfaceC15426jZ7 v;
    private final IZ7 w;
    private final UA2 x;
    private final UA2 y;
    private C20919sp4 z;

    /* renamed from: ir.nasim.dZ7$a */
    public static final class a {
        private a() {
        }

        public final C11765dZ7 a(ViewGroup viewGroup, InterfaceC15426jZ7 interfaceC15426jZ7, C13635gZ7 c13635gZ7, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC15426jZ7, "vitrineClickListener");
            AbstractC13042fc3.i(c13635gZ7, "vitrinRowHolder");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C12408eZ7 c12408eZ7C = C12408eZ7.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c12408eZ7C, "inflate(...)");
            return new C11765dZ7(c12408eZ7C, interfaceC15426jZ7, c13635gZ7, ua2, ua22);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11765dZ7(C12408eZ7 c12408eZ7, InterfaceC15426jZ7 interfaceC15426jZ7, IZ7 iz7, UA2 ua2, UA2 ua22) {
        super(c12408eZ7.getRoot());
        AbstractC13042fc3.i(c12408eZ7, "binding");
        AbstractC13042fc3.i(interfaceC15426jZ7, "vitrineClickListener");
        AbstractC13042fc3.i(iz7, "vitrineRowClickListener");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.u = c12408eZ7;
        this.v = interfaceC15426jZ7;
        this.w = iz7;
        this.x = ua2;
        this.y = ua22;
        c12408eZ7.b.B(22.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(ExPeer exPeer, C11765dZ7 c11765dZ7, List list) {
        AbstractC13042fc3.i(exPeer, "$exPeer");
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(exPeer.getPeerId());
        if (c21231tK7 == null) {
            C19406qI3.b("VitrinItemHolder", "updatedUserVM is null in vitrine item holder bind!");
            return;
        }
        ExPeerType exPeerType = exPeer.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        c11765dZ7.Z0(c21231tK7, exPeerType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(ExPeer exPeer, C11765dZ7 c11765dZ7, PeerItem peerItem, String str, int i, List list) {
        AbstractC13042fc3.i(exPeer, "$exPeer");
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        AbstractC13042fc3.i(peerItem, "$peerItem");
        AbstractC13042fc3.i(str, "$rowTitle");
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(exPeer.getPeerId());
        if (c14733iO2 == null) {
            C19406qI3.b("VitrinItemHolder", "updatedGroupVM is null in vitrine item holder bind!");
            return;
        }
        c11765dZ7.W0(c14733iO2);
        Action action = peerItem.getAction();
        ExPeerType exPeerType = exPeer.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        c11765dZ7.c1(action, exPeerType, c14733iO2, str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V0(C11765dZ7 c11765dZ7, PeerItem peerItem, View view) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        AbstractC13042fc3.i(peerItem, "$peerItem");
        c11765dZ7.v.T3(peerItem);
        return true;
    }

    private final void W0(C14733iO2 c14733iO2) {
        TextView textView = this.u.d;
        AbstractC13042fc3.h(textView, "vitrineItemMemberTv");
        textView.setVisibility(0);
        this.u.b.q(c14733iO2);
        C20919sp4 c20919sp4 = this.z;
        this.B = c20919sp4 != null ? c20919sp4.r(c14733iO2.v(), new InterfaceC14756iQ7() { // from class: ir.nasim.cZ7
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C11765dZ7.X0(this.a, (String) obj, abstractC13554gQ7);
            }
        }) : null;
        C20919sp4 c20919sp42 = this.z;
        this.D = c20919sp42 != null ? c20919sp42.r(c14733iO2.u(), new InterfaceC14756iQ7() { // from class: ir.nasim.SY7
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C11765dZ7.Y0(this.a, (Integer) obj, abstractC13554gQ7);
            }
        }) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(C11765dZ7 c11765dZ7, String str, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        c11765dZ7.u.e.setText(str.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(C11765dZ7 c11765dZ7, Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        String strA = JF5.g() ? GY6.a(num.toString()) : GY6.b(num.toString());
        c11765dZ7.u.d.setText(strA + Separators.SP + c11765dZ7.a.getContext().getString(ID5.member));
    }

    private final void Z0(C21231tK7 c21231tK7, ExPeerType exPeerType) {
        TextView textView = this.u.d;
        AbstractC13042fc3.h(textView, "vitrineItemMemberTv");
        textView.setVisibility(8);
        AvatarViewGlide.u(this.u.b, c21231tK7, null, 2, null);
        C20919sp4 c20919sp4 = this.z;
        this.A = c20919sp4 != null ? c20919sp4.r(c21231tK7.r(), new InterfaceC14756iQ7() { // from class: ir.nasim.TY7
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C11765dZ7.a1(this.a, (String) obj, abstractC13554gQ7);
            }
        }) : null;
        if (exPeerType == ExPeerType.PRIVATE) {
            this.u.c.setText(this.a.getContext().getString(ID5.vitrine_start_private));
        } else if (exPeerType == ExPeerType.BOT) {
            this.u.c.setText(this.a.getContext().getString(ID5.vitrine_start_bot));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(C11765dZ7 c11765dZ7, String str, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        c11765dZ7.u.e.setText(str.toString());
    }

    private final void c1(Action action, final ExPeerType exPeerType, final C14733iO2 c14733iO2, final String str, final int i) {
        if (action.getTypeIsURL()) {
            final String url = action.getUrl();
            if (url == null) {
                url = "";
            }
            if (exPeerType == ExPeerType.CHANNEL) {
                this.u.c.setText(this.a.getContext().getString(ID5.vitrine_open_url));
            }
            this.u.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.WY7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C11765dZ7.g1(this.a, url, str, i, view);
                }
            });
            this.u.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.XY7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C11765dZ7.i1(this.a, url, str, i, view);
                }
            });
            return;
        }
        final ExPeer exPeer = action.getExPeer();
        if (exPeer == null) {
            return;
        }
        this.u.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.YY7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C11765dZ7.j1(exPeerType, this, exPeer, c14733iO2, str, i, view);
            }
        });
        this.u.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ZY7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C11765dZ7.d1(this.a, exPeer, str, i, view);
            }
        });
        if (exPeerType == ExPeerType.PRIVATE) {
            this.u.c.setText(this.a.getContext().getString(ID5.vitrine_start_private));
            return;
        }
        if (exPeerType == ExPeerType.BOT) {
            this.u.c.setText(this.a.getContext().getString(ID5.vitrine_start_bot));
            return;
        }
        if (exPeerType == ExPeerType.CHANNEL) {
            if (c14733iO2 != null) {
                C20919sp4 c20919sp4 = this.z;
                this.G = c20919sp4 != null ? c20919sp4.r(c14733iO2.F(), new InterfaceC14756iQ7() { // from class: ir.nasim.aZ7
                    @Override // ir.nasim.InterfaceC14756iQ7
                    public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                        C11765dZ7.e1(this.a, (Boolean) obj, abstractC13554gQ7);
                    }
                }) : null;
                return;
            }
            return;
        }
        if (exPeerType != ExPeerType.GROUP || c14733iO2 == null) {
            return;
        }
        C20919sp4 c20919sp42 = this.z;
        this.G = c20919sp42 != null ? c20919sp42.r(c14733iO2.F(), new InterfaceC14756iQ7() { // from class: ir.nasim.bZ7
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C11765dZ7.f1(this.a, (Boolean) obj, abstractC13554gQ7);
            }
        }) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(C11765dZ7 c11765dZ7, ExPeer exPeer, String str, int i, View view) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        AbstractC13042fc3.i(exPeer, "$actionExPeer");
        AbstractC13042fc3.i(str, "$rowTitle");
        c11765dZ7.v.y1(exPeer, str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(C11765dZ7 c11765dZ7, Boolean bool, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        if (bool.booleanValue()) {
            c11765dZ7.u.c.setText(c11765dZ7.a.getContext().getString(ID5.vitrine_member));
        } else {
            c11765dZ7.u.c.setText(c11765dZ7.a.getContext().getString(ID5.vitrine_join));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(C11765dZ7 c11765dZ7, Boolean bool, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        if (bool.booleanValue()) {
            c11765dZ7.u.c.setText(c11765dZ7.a.getContext().getString(ID5.vitrine_member_group));
        } else {
            c11765dZ7.u.c.setText(c11765dZ7.a.getContext().getString(ID5.vitrine_join));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(C11765dZ7 c11765dZ7, String str, String str2, int i, View view) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        AbstractC13042fc3.i(str, "$url");
        AbstractC13042fc3.i(str2, "$rowTitle");
        c11765dZ7.v.O4(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(C11765dZ7 c11765dZ7, String str, String str2, int i, View view) {
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        AbstractC13042fc3.i(str, "$url");
        AbstractC13042fc3.i(str2, "$rowTitle");
        c11765dZ7.v.O4(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(ExPeerType exPeerType, C11765dZ7 c11765dZ7, ExPeer exPeer, C14733iO2 c14733iO2, String str, int i, View view) {
        C8512Wh0 c8512Wh0F;
        AbstractC13042fc3.i(exPeerType, "$type");
        AbstractC13042fc3.i(c11765dZ7, "this$0");
        AbstractC13042fc3.i(exPeer, "$actionExPeer");
        AbstractC13042fc3.i(str, "$rowTitle");
        if (exPeerType == ExPeerType.CHANNEL || exPeerType == ExPeerType.GROUP) {
            c11765dZ7.w.m(c11765dZ7.a.getWidth());
        }
        c11765dZ7.v.Y1(exPeer, (c14733iO2 == null || (c8512Wh0F = c14733iO2.F()) == null) ? null : (Boolean) c8512Wh0F.b(), str, i);
    }

    public final void S0(final String str, final PeerItem peerItem, final int i) {
        AbstractC13042fc3.i(str, "rowTitle");
        AbstractC13042fc3.i(peerItem, "peerItem");
        UA2 ua2 = this.x;
        C16017kZ7 c16017kZ7 = new C16017kZ7(peerItem, str, i);
        this.H = c16017kZ7;
        ua2.invoke(c16017kZ7);
        this.z = new C20919sp4();
        final ExPeer exPeer = peerItem.getExPeer();
        if (exPeer.getExPeerType() == ExPeerType.PRIVATE || exPeer.getExPeerType() == ExPeerType.BOT) {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(exPeer.getPeerId());
            if (c21231tK7 == null) {
                AbstractC5969Lp4.d().o2().V().Y(AbstractC9766aX0.e(new C18766pD(exPeer.getPeerId(), 0L))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.RY7
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C11765dZ7.T0(exPeer, this, (List) obj);
                    }
                });
            } else {
                ExPeerType exPeerType = exPeer.getExPeerType();
                AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
                Z0(c21231tK7, exPeerType);
            }
            Action action = peerItem.getAction();
            ExPeerType exPeerType2 = exPeer.getExPeerType();
            AbstractC13042fc3.h(exPeerType2, "getExPeerType(...)");
            c1(action, exPeerType2, null, str, i);
        } else if (exPeer.getExPeerType() == ExPeerType.CHANNEL || exPeer.getExPeerType() == ExPeerType.GROUP) {
            C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(exPeer.getPeerId());
            if (c14733iO2 == null) {
                AbstractC5969Lp4.d().o2().V().W(AbstractC9766aX0.e(new C25238zy(exPeer.getPeerId(), 0L))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.UY7
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C11765dZ7.U0(exPeer, this, peerItem, str, i, (List) obj);
                    }
                });
            } else {
                W0(c14733iO2);
                Action action2 = peerItem.getAction();
                ExPeerType exPeerType3 = exPeer.getExPeerType();
                AbstractC13042fc3.h(exPeerType3, "getExPeerType(...)");
                c1(action2, exPeerType3, c14733iO2, str, i);
            }
        }
        this.u.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.VY7
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C11765dZ7.V0(this.a, peerItem, view);
            }
        });
    }

    public final void a() {
        C20919sp4 c20919sp4;
        C20919sp4 c20919sp42;
        C20919sp4 c20919sp43;
        C20919sp4 c20919sp44;
        C16017kZ7 c16017kZ7 = this.H;
        if (c16017kZ7 != null) {
            this.y.invoke(c16017kZ7);
        }
        this.u.b.D();
        C20919sp4.b bVar = this.A;
        if (bVar != null && (c20919sp44 = this.z) != null) {
            c20919sp44.c0(bVar);
        }
        C20919sp4.b bVar2 = this.B;
        if (bVar2 != null && (c20919sp43 = this.z) != null) {
            c20919sp43.c0(bVar2);
        }
        C20919sp4.b bVar3 = this.D;
        if (bVar3 != null && (c20919sp42 = this.z) != null) {
            c20919sp42.c0(bVar3);
        }
        C20919sp4.b bVar4 = this.G;
        if (bVar4 != null && (c20919sp4 = this.z) != null) {
            c20919sp4.c0(bVar4);
        }
        this.A = null;
        this.B = null;
        this.D = null;
        this.G = null;
        this.z = null;
    }
}
