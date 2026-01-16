package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.story.avatarwithstory.AvatarWithStory;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.sp4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20919sp4 {
    private final ArrayList a = new ArrayList();
    private boolean b = false;
    private boolean c = true;
    private boolean d = false;
    private Boolean e = Boolean.FALSE;
    private EnumC5360Iz7 f = EnumC5360Iz7.b;
    private ArrayList g = new ArrayList();

    /* renamed from: ir.nasim.sp4$a */
    class a implements InterfaceC24449ye1 {
        final /* synthetic */ TextView a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ View c;
        final /* synthetic */ View d;

        a(TextView textView, ArrayList arrayList, View view, View view2) {
            this.a = textView;
            this.b = arrayList;
            this.c = view;
            this.d = view2;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void apply(C21231tK7 c21231tK7) {
            this.a.setText(R62.S(AbstractC4699Ge3.a(this.a.getContext(), this.b, (String) c21231tK7.r().b()), this.a.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(12.0f), false));
            this.c.setVisibility(0);
            this.d.setVisibility(4);
        }
    }

    /* renamed from: ir.nasim.sp4$b */
    public class b {
        private AbstractC13554gQ7 a;
        private InterfaceC14756iQ7 b;

        public void a() {
            this.a.f(this.b);
        }

        public void b() {
            this.a.h(this.b);
        }

        private b(AbstractC13554gQ7 abstractC13554gQ7, InterfaceC14756iQ7 interfaceC14756iQ7) {
            this.a = abstractC13554gQ7;
            this.b = interfaceC14756iQ7;
        }
    }

    private void C(ArrayList arrayList, TextView textView, View view, View view2) {
        if (arrayList.isEmpty()) {
            view.setVisibility(4);
            view2.setVisibility(0);
        } else {
            AbstractC5969Lp4.g().k(((C11661dO2) arrayList.get(0)).b()).m0(new a(textView, arrayList, view, view2));
        }
    }

    private void D(TextView textView, View view, View view2) {
        if (!this.f.q()) {
            view.setVisibility(4);
            view2.setVisibility(0);
        } else {
            textView.setText(R62.S(AbstractC4699Ge3.b(textView.getContext(), this.f), textView.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(12.0f), false));
            view.setVisibility(0);
            view2.setVisibility(4);
        }
    }

    private void E(TextView textView, View view, View view2) {
        if (view != null) {
            view.setVisibility(4);
            view2.setVisibility(0);
        }
        if (this.g.size() != 0) {
            C(new ArrayList(this.g), textView, view, view2);
        } else {
            D(textView, view, view2);
        }
    }

    private boolean F() {
        return !((Boolean) AbstractC5969Lp4.d().Y().v().E().f().b()).booleanValue();
    }

    private boolean G() {
        return ((Boolean) AbstractC5969Lp4.d().Y().v().E().g().b()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(boolean z, TextView textView, String str, AbstractC13554gQ7 abstractC13554gQ7) {
        if (z) {
            textView.setContentDescription(str);
        }
        textView.setText(R62.S(str, textView.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(14.0f), false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(DQ7 dq7, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, Object obj, AbstractC13554gQ7 abstractC13554gQ73) {
        dq7.a(obj, abstractC13554gQ73, abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(DQ7 dq7, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, Object obj, AbstractC13554gQ7 abstractC13554gQ73) {
        dq7.a(abstractC13554gQ7.b(), abstractC13554gQ7, obj, abstractC13554gQ73, abstractC13554gQ72.b(), abstractC13554gQ72);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(DQ7 dq7, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, Object obj, AbstractC13554gQ7 abstractC13554gQ73) {
        dq7.a(abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72, obj, abstractC13554gQ73);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(CQ7 cq7, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, AbstractC13554gQ7 abstractC13554gQ73, Object obj, AbstractC13554gQ7 abstractC13554gQ74) {
        cq7.a(obj, abstractC13554gQ74, abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72, abstractC13554gQ73.b(), abstractC13554gQ73);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(CQ7 cq7, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, AbstractC13554gQ7 abstractC13554gQ73, Object obj, AbstractC13554gQ7 abstractC13554gQ74) {
        cq7.a(abstractC13554gQ7.b(), abstractC13554gQ7, obj, abstractC13554gQ74, abstractC13554gQ72.b(), abstractC13554gQ72, abstractC13554gQ73.b(), abstractC13554gQ73);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(CQ7 cq7, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, AbstractC13554gQ7 abstractC13554gQ73, Object obj, AbstractC13554gQ7 abstractC13554gQ74) {
        cq7.a(abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72, obj, abstractC13554gQ74, abstractC13554gQ73.b(), abstractC13554gQ73);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(CQ7 cq7, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, AbstractC13554gQ7 abstractC13554gQ73, Object obj, AbstractC13554gQ7 abstractC13554gQ74) {
        cq7.a(abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72, abstractC13554gQ73.b(), abstractC13554gQ73, obj, abstractC13554gQ74);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(View view, C14733iO2 c14733iO2, TextView textView, Integer num, AbstractC13554gQ7 abstractC13554gQ7, Integer num2, AbstractC13554gQ7 abstractC13554gQ72, Boolean bool, AbstractC13554gQ7 abstractC13554gQ73) {
        if (bool.booleanValue()) {
            view.setVisibility(0);
            if (num.intValue() <= 0 || !((Boolean) c14733iO2.g().b()).booleanValue()) {
                String strE = AbstractC20655sN7.f(num2.intValue()) + Separators.SP + textView.getContext().getString(AbstractC12217eE5.member);
                if (JF5.g()) {
                    strE = XY6.e(strE);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strE);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(C5495Jo7.a.h()), 0, spannableStringBuilder.length(), 17);
                textView.setText(spannableStringBuilder);
            } else {
                String strE2 = AbstractC20655sN7.f(num2.intValue()) + Separators.SP + textView.getContext().getString(AbstractC12217eE5.member);
                String string = textView.getContext().getString(AbstractC12217eE5.group_chat_members_presence, XY6.v(num.toString()));
                if (JF5.g()) {
                    strE2 = XY6.e(strE2);
                    string = XY6.e(string);
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strE2 + ", ");
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(C5495Jo7.a.h()), 0, spannableStringBuilder2.length(), 17);
                spannableStringBuilder2.append((CharSequence) string);
                textView.setText(spannableStringBuilder2);
            }
        } else if (c14733iO2.q().equals(ZN2.CHANNEL)) {
            String strE3 = AbstractC20655sN7.f(num2.intValue()) + Separators.SP + textView.getContext().getString(AbstractC12217eE5.member);
            if (JF5.g()) {
                strE3 = XY6.e(strE3);
            }
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strE3);
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(C5495Jo7.a.h()), 0, spannableStringBuilder3.length(), 17);
            textView.setText(spannableStringBuilder3);
        } else {
            view.setVisibility(8);
        }
        textView.setContentDescription(textView.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(AvatarWithStory avatarWithStory, int i, Boolean bool, Avatar avatar, AbstractC13554gQ7 abstractC13554gQ7, String str, AbstractC13554gQ7 abstractC13554gQ72) {
        avatarWithStory.c(avatar, str, i, bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(InterfaceC16527lQ7 interfaceC16527lQ7, AbstractC13554gQ7 abstractC13554gQ7, Object obj, AbstractC13554gQ7 abstractC13554gQ72) {
        interfaceC16527lQ7.a(obj, abstractC13554gQ72, abstractC13554gQ7.b(), abstractC13554gQ7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(InterfaceC16527lQ7 interfaceC16527lQ7, AbstractC13554gQ7 abstractC13554gQ7, Object obj, AbstractC13554gQ7 abstractC13554gQ72) {
        interfaceC16527lQ7.a(abstractC13554gQ7.b(), abstractC13554gQ7, obj, abstractC13554gQ72);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(TextView textView, View view, View view2, Boolean bool, AbstractC13554gQ7 abstractC13554gQ7) {
        boolean z = !bool.booleanValue();
        this.b = z;
        if (!z) {
            this.c = true;
        }
        Z(textView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(TextView textView, View view, View view2, EnumC19739qr4 enumC19739qr4, AbstractC13554gQ7 abstractC13554gQ7) {
        Z(textView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(TextView textView, View view, View view2, Boolean bool, AbstractC13554gQ7 abstractC13554gQ7) {
        this.e = bool;
        Z(textView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(TextView textView, View view, View view2, ArrayList arrayList, AbstractC13554gQ7 abstractC13554gQ7) {
        this.g = arrayList;
        if (!this.b || this.e.booleanValue()) {
            return;
        }
        C(new ArrayList(this.g), textView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(TextView textView, View view, View view2, EnumC5360Iz7 enumC5360Iz7, AbstractC13554gQ7 abstractC13554gQ7) {
        this.f = enumC5360Iz7;
        if (!this.b || this.e.booleanValue()) {
            return;
        }
        D(textView, view, view2);
    }

    private void Z(TextView textView, View view, View view2) {
        boolean zF = F();
        boolean zG = G();
        if (!zF) {
            if (textView != null) {
                if (C4100Dr4.a(AbstractC5969Lp4.d().j2())) {
                    textView.setText(AbstractC12217eE5.chat_connection_state_connecting);
                } else {
                    textView.setText(AbstractC12217eE5.chat_connection_state_wait_for_network);
                }
            }
            a0(view, view2);
            return;
        }
        if (zG && this.c) {
            if (textView != null) {
                textView.setText(AbstractC12217eE5.chat_connection_state_updating);
            }
            a0(view, view2);
            this.d = true;
            return;
        }
        if (this.d) {
            this.c = false;
            this.d = false;
        }
        E(textView, view, view2);
    }

    private void a0(View view, View view2) {
        if (view != null) {
            view.setVisibility(0);
            view2.setVisibility(4);
        }
    }

    public void A(final TextView textView, final View view, final View view2, AbstractC13554gQ7 abstractC13554gQ7) {
        r(abstractC13554gQ7, new InterfaceC14756iQ7() { // from class: ir.nasim.dp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ72) {
                this.a.W(textView, view, view2, (ArrayList) obj, abstractC13554gQ72);
            }
        });
    }

    public void B(final TextView textView, final View view, final View view2, AbstractC13554gQ7 abstractC13554gQ7) {
        r(abstractC13554gQ7, new InterfaceC14756iQ7() { // from class: ir.nasim.rp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ72) {
                this.a.X(textView, view, view2, (EnumC5360Iz7) obj, abstractC13554gQ72);
            }
        });
    }

    public void Y() {
        if (this.a.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    public void b0() {
        if (this.a.isEmpty()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b();
        }
    }

    public void c0(b bVar) {
        bVar.b();
        this.a.remove(bVar);
    }

    public void d0() {
        if (this.a.isEmpty()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b();
        }
        this.a.clear();
    }

    public synchronized b r(AbstractC13554gQ7 abstractC13554gQ7, InterfaceC14756iQ7 interfaceC14756iQ7) {
        b bVar;
        abstractC13554gQ7.f(interfaceC14756iQ7);
        bVar = new b(abstractC13554gQ7, interfaceC14756iQ7);
        this.a.add(bVar);
        return bVar;
    }

    public b s(AbstractC13554gQ7 abstractC13554gQ7, boolean z, InterfaceC14756iQ7 interfaceC14756iQ7) {
        abstractC13554gQ7.g(interfaceC14756iQ7, z);
        b bVar = new b(abstractC13554gQ7, interfaceC14756iQ7);
        this.a.add(bVar);
        return bVar;
    }

    public void t(final TextView textView, final View view, final C14733iO2 c14733iO2) {
        w(c14733iO2.C(), c14733iO2.u(), c14733iO2.F(), new DQ7() { // from class: ir.nasim.fp4
            @Override // ir.nasim.DQ7
            public final void a(Object obj, AbstractC13554gQ7 abstractC13554gQ7, Object obj2, AbstractC13554gQ7 abstractC13554gQ72, Object obj3, AbstractC13554gQ7 abstractC13554gQ73) {
                C20919sp4.P(view, c14733iO2, textView, (Integer) obj, abstractC13554gQ7, (Integer) obj2, abstractC13554gQ72, (Boolean) obj3, abstractC13554gQ73);
            }
        });
    }

    public void u(final TextView textView, AbstractC13554gQ7 abstractC13554gQ7, final boolean z) {
        r(abstractC13554gQ7, new InterfaceC14756iQ7() { // from class: ir.nasim.cp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ72) {
                C20919sp4.H(z, textView, (String) obj, abstractC13554gQ72);
            }
        });
    }

    public void v(final AbstractC13554gQ7 abstractC13554gQ7, final AbstractC13554gQ7 abstractC13554gQ72, final AbstractC13554gQ7 abstractC13554gQ73, final AbstractC13554gQ7 abstractC13554gQ74, final CQ7 cq7) {
        s(abstractC13554gQ7, false, new InterfaceC14756iQ7() { // from class: ir.nasim.bp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ75) {
                C20919sp4.L(cq7, abstractC13554gQ72, abstractC13554gQ73, abstractC13554gQ74, obj, abstractC13554gQ75);
            }
        });
        s(abstractC13554gQ72, false, new InterfaceC14756iQ7() { // from class: ir.nasim.jp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ75) {
                C20919sp4.M(cq7, abstractC13554gQ7, abstractC13554gQ73, abstractC13554gQ74, obj, abstractC13554gQ75);
            }
        });
        s(abstractC13554gQ73, false, new InterfaceC14756iQ7() { // from class: ir.nasim.kp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ75) {
                C20919sp4.N(cq7, abstractC13554gQ7, abstractC13554gQ72, abstractC13554gQ74, obj, abstractC13554gQ75);
            }
        });
        s(abstractC13554gQ74, false, new InterfaceC14756iQ7() { // from class: ir.nasim.lp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ75) {
                C20919sp4.O(cq7, abstractC13554gQ7, abstractC13554gQ72, abstractC13554gQ73, obj, abstractC13554gQ75);
            }
        });
        cq7.a(abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72, abstractC13554gQ73.b(), abstractC13554gQ73, abstractC13554gQ74.b(), abstractC13554gQ74);
    }

    public void w(final AbstractC13554gQ7 abstractC13554gQ7, final AbstractC13554gQ7 abstractC13554gQ72, final AbstractC13554gQ7 abstractC13554gQ73, final DQ7 dq7) {
        s(abstractC13554gQ7, false, new InterfaceC14756iQ7() { // from class: ir.nasim.gp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ74) {
                C20919sp4.I(dq7, abstractC13554gQ72, abstractC13554gQ73, obj, abstractC13554gQ74);
            }
        });
        s(abstractC13554gQ72, false, new InterfaceC14756iQ7() { // from class: ir.nasim.hp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ74) {
                C20919sp4.J(dq7, abstractC13554gQ7, abstractC13554gQ73, obj, abstractC13554gQ74);
            }
        });
        s(abstractC13554gQ73, false, new InterfaceC14756iQ7() { // from class: ir.nasim.ip4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ74) {
                C20919sp4.K(dq7, abstractC13554gQ7, abstractC13554gQ72, obj, abstractC13554gQ74);
            }
        });
        dq7.a(abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72, abstractC13554gQ73.b(), abstractC13554gQ73);
    }

    public void x(final AvatarWithStory avatarWithStory, final int i, AbstractC13554gQ7 abstractC13554gQ7, AbstractC13554gQ7 abstractC13554gQ72, final Boolean bool) {
        y(abstractC13554gQ7, abstractC13554gQ72, new InterfaceC16527lQ7() { // from class: ir.nasim.ep4
            @Override // ir.nasim.InterfaceC16527lQ7
            public final void a(Object obj, AbstractC13554gQ7 abstractC13554gQ73, Object obj2, AbstractC13554gQ7 abstractC13554gQ74) {
                C20919sp4.Q(avatarWithStory, i, bool, (Avatar) obj, abstractC13554gQ73, (String) obj2, abstractC13554gQ74);
            }
        });
    }

    public b[] y(final AbstractC13554gQ7 abstractC13554gQ7, final AbstractC13554gQ7 abstractC13554gQ72, final InterfaceC16527lQ7 interfaceC16527lQ7) {
        b[] bVarArr = {s(abstractC13554gQ7, false, new InterfaceC14756iQ7() { // from class: ir.nasim.mp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ73) {
                C20919sp4.R(interfaceC16527lQ7, abstractC13554gQ72, obj, abstractC13554gQ73);
            }
        }), s(abstractC13554gQ72, false, new InterfaceC14756iQ7() { // from class: ir.nasim.np4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ73) {
                C20919sp4.S(interfaceC16527lQ7, abstractC13554gQ7, obj, abstractC13554gQ73);
            }
        })};
        interfaceC16527lQ7.a(abstractC13554gQ7.b(), abstractC13554gQ7, abstractC13554gQ72.b(), abstractC13554gQ72);
        return bVarArr;
    }

    public void z(final TextView textView, final View view, final View view2) {
        r(AbstractC5969Lp4.d().Y().v().E().f(), new InterfaceC14756iQ7() { // from class: ir.nasim.op4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.T(textView, view, view2, (Boolean) obj, abstractC13554gQ7);
            }
        });
        r(AbstractC5969Lp4.d().Y().v().E().h(), new InterfaceC14756iQ7() { // from class: ir.nasim.pp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.U(textView, view, view2, (EnumC19739qr4) obj, abstractC13554gQ7);
            }
        });
        r(AbstractC5969Lp4.d().Y().v().E().g(), new InterfaceC14756iQ7() { // from class: ir.nasim.qp4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.V(textView, view, view2, (Boolean) obj, abstractC13554gQ7);
            }
        });
    }
}
