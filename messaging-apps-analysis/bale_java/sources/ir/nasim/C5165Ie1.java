package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.C20882sl7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.N15;
import ir.nasim.X2;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.Ie1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5165Ie1 extends C20882sl7 {
    private final ConstraintLayout r;
    private final C8020Ue3 s;

    /* renamed from: ir.nasim.Ie1$a */
    public static final class a extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C5165Ie1(c15481jf3, z, c(), null);
        }
    }

    public /* synthetic */ C5165Ie1(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c15481jf3, z, abstractC23538x54);
    }

    private final void f1(C12461ef1 c12461ef1, final long j, final C6833Pe1 c6833Pe1) {
        final String strM;
        C8020Ue3 c8020Ue3 = this.s;
        String str = (String) AbstractC15401jX0.s0(c12461ef1.f());
        if (str == null || (strM = AbstractC20153rZ6.M(str, Separators.SP, "", false, 4, null)) == null) {
            return;
        }
        c8020Ue3.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Fe1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5165Ie1.g1(this.a, strM, j, c6833Pe1, view);
            }
        });
        c8020Ue3.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ge1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5165Ie1.h1(this.a, strM, view);
            }
        });
        this.s.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.He1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5165Ie1.i1(this.a, strM, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(C5165Ie1 c5165Ie1, String str, long j, C6833Pe1 c6833Pe1, View view) {
        AbstractC13042fc3.i(c5165Ie1, "this$0");
        AbstractC13042fc3.i(str, "$phone");
        AbstractC13042fc3.i(c6833Pe1, "$content");
        c5165Ie1.z0().c().c(str, j, c6833Pe1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(C5165Ie1 c5165Ie1, String str, View view) {
        AbstractC13042fc3.i(c5165Ie1, "this$0");
        AbstractC13042fc3.i(str, "$phone");
        c5165Ie1.z0().c().b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(C5165Ie1 c5165Ie1, String str, View view) {
        AbstractC13042fc3.i(c5165Ie1, "this$0");
        AbstractC13042fc3.i(str, "$phone");
        c5165Ie1.z0().c().a(str);
    }

    private final void j1(final C8967Xz7 c8967Xz7, final C12461ef1 c12461ef1) {
        C8020Ue3 c8020Ue3 = this.s;
        c8020Ue3.h.r(c12461ef1.e());
        c8020Ue3.g.r(c12461ef1.d());
        l1(c12461ef1.h(), c12461ef1.b(), c12461ef1.g());
        c8020Ue3.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.De1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5165Ie1.k1(this.a, c8967Xz7, c12461ef1, view);
            }
        });
        long jI = c8967Xz7.h().i();
        AbstractC17457n0 abstractC17457n0F = c8967Xz7.j().F();
        C6833Pe1 c6833Pe1 = abstractC17457n0F instanceof C6833Pe1 ? (C6833Pe1) abstractC17457n0F : null;
        if (c6833Pe1 == null) {
            return;
        }
        f1(c12461ef1, jI, c6833Pe1);
        n1(c12461ef1.a(), c12461ef1.b(), c12461ef1.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(C5165Ie1 c5165Ie1, C8967Xz7 c8967Xz7, C12461ef1 c12461ef1, View view) {
        AbstractC13042fc3.i(c5165Ie1, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c12461ef1, "$contactInfo");
        c5165Ie1.z0().d().d(c8967Xz7, c12461ef1);
    }

    private final void l1(boolean z, int i, boolean z2) {
        C8020Ue3 c8020Ue3 = this.s;
        LinearLayout linearLayout = c8020Ue3.f;
        AbstractC13042fc3.h(linearLayout, "notContactButtons");
        linearLayout.setVisibility(!z && i > 0 && !z2 ? 0 : 8);
        MaterialButton materialButton = c8020Ue3.d;
        AbstractC13042fc3.h(materialButton, "btnSeeProfile");
        materialButton.setVisibility(z && i > 0 && !z2 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m1(C5165Ie1 c5165Ie1, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c5165Ie1, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c5165Ie1.s.g.performClick();
        return true;
    }

    private final void n1(Avatar avatar, int i, Spannable spannable) {
        AvatarViewGlide.v(this.s.e, avatar, spannable.toString(), i, false, null, 16, null);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.ContactInfo");
        j1(c8967Xz7, (C12461ef1) objF);
        Z0();
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC12990fW7.l0(view, X2.a.i, view.getContext().getString(AbstractC12217eE5.message_options_activate), new InterfaceC10698c3() { // from class: ir.nasim.Ee1
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C5165Ie1.m1(this.a, view2, aVar);
            }
        });
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.e) {
            N15.e eVar = (N15.e) n15;
            n1(eVar.b(), eVar.c(), eVar.d());
            return;
        }
        if (!(n15 instanceof N15.f)) {
            super.z(n15);
        } else {
            N15.f fVar = (N15.f) n15;
            l1(fVar.d(), fVar.b(), fVar.c());
        }
    }

    private C5165Ie1(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
        C8020Ue3 c8020Ue3A = C8020Ue3.a(R0(AbstractC12208eD5.item_chat_contact_bubble));
        ConstraintLayout root = c8020Ue3A.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.F = 0.0f;
        root.setLayoutParams(layoutParams2);
        MessageEmojiTextView messageEmojiTextView = c8020Ue3A.h;
        messageEmojiTextView.setTypeface(C6011Lu2.k());
        C3335Al0 c3335Al0 = C3335Al0.a;
        messageEmojiTextView.setTextSize(c3335Al0.g());
        BubbleTextView bubbleTextView = c8020Ue3A.g;
        bubbleTextView.setTypeface(C6011Lu2.k());
        bubbleTextView.setTextSize(c3335Al0.f());
        c8020Ue3A.e.B(16.0f, true);
        this.s = c8020Ue3A;
    }
}
