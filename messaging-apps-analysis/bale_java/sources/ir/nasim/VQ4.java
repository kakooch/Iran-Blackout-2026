package ir.nasim;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import ir.nasim.C20882sl7;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import ir.nasim.features.pfm.PFMActivity;
import ir.nasim.features.pfm.entity.PFMTransaction;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class VQ4 implements InterfaceC20284rl0 {
    private final C20882sl7 a;
    private final C15481jf3 b;
    private final ConstraintLayout c;
    private final C12463ef3 d;

    public static final class a implements InterfaceC22152ul0 {
        private final boolean a;
        private final AbstractC23538x54 b;

        public a(boolean z, AbstractC23538x54 abstractC23538x54) {
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.a = z;
            this.b = abstractC23538x54;
        }

        @Override // ir.nasim.InterfaceC22152ul0
        public InterfaceC20284rl0 a(ViewStub viewStub) {
            AbstractC13042fc3.i(viewStub, "viewStub");
            ViewParent parent = viewStub.getParent();
            AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(viewStub);
            InterfaceC20284rl0 interfaceC20284rl0A = new C20882sl7.b(this.a, this.b).a(viewStub);
            AbstractC13042fc3.g(interfaceC20284rl0A, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.holder.bubble.TextBubble");
            C15481jf3 c15481jf3A = C15481jf3.a(viewGroup.getChildAt(iIndexOfChild));
            AbstractC13042fc3.h(c15481jf3A, "bind(...)");
            return new VQ4((C20882sl7) interfaceC20284rl0A, c15481jf3A, null);
        }
    }

    public /* synthetic */ VQ4(C20882sl7 c20882sl7, C15481jf3 c15481jf3, ED1 ed1) {
        this(c20882sl7, c15481jf3);
    }

    private final void j(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.j = this.d.b.getId();
        view.setLayoutParams(layoutParams2);
    }

    private final void k(final C8967Xz7 c8967Xz7) {
        C12463ef3 c12463ef3 = this.d;
        if (!c8967Xz7.j().V()) {
            Group group = c12463ef3.e;
            AbstractC13042fc3.h(group, "pfmGroupContainer");
            group.setVisibility(8);
            return;
        }
        final C8455Wa6 c8455Wa6A = C8455Wa6.h.a(c8967Xz7.j());
        if (c8455Wa6A == null) {
            Group group2 = c12463ef3.e;
            AbstractC13042fc3.h(group2, "pfmGroupContainer");
            group2.setVisibility(8);
            return;
        }
        EnumC18897pR4 transactionType = c8455Wa6A.i().getTransactionType();
        if (transactionType == null) {
            Group group3 = c12463ef3.e;
            AbstractC13042fc3.h(group3, "pfmGroupContainer");
            group3.setVisibility(8);
        } else {
            Group group4 = c12463ef3.e;
            AbstractC13042fc3.h(group4, "pfmGroupContainer");
            group4.setVisibility(0);
            final JA ja2 = new JA(c8455Wa6A.f(), c8967Xz7.h().i(), c8967Xz7.h().h(), MA.valueOf(transactionType.name()));
            this.d.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.UQ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VQ4.m(c8455Wa6A, c8967Xz7, ja2, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(C8455Wa6 c8455Wa6, C8967Xz7 c8967Xz7, JA ja2, View view) {
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(ja2, "$apiPfmTransactionId");
        PFMTransaction pFMTransaction = new PFMTransaction(c8967Xz7.h().i(), c8967Xz7.h().h(), XY6.h(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(c8455Wa6.g(), "+", "", false, 4, null), "-", "", false, 4, null), ",", "", false, 4, null)), c8455Wa6.i().getTransactionType(), ja2.q(), "", new ArrayList(), "", 0L);
        PFMActivity.Companion companion = PFMActivity.INSTANCE;
        C5721Ko c5721Ko = C5721Ko.a;
        c5721Ko.d().startActivity(companion.b(c5721Ko.d(), EnumC14097hL4.d, EnumC13506gL4.b, pFMTransaction));
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void a() {
        this.a.a();
    }

    @Override // ir.nasim.InterfaceC20284rl0, ir.nasim.InterfaceC9437Zx6
    public C8948Xx6 b() {
        return this.a.b();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void e() {
        this.a.e();
    }

    @Override // ir.nasim.InterfaceC7879To6
    public void f() {
        this.a.f();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public List g() {
        return this.a.g();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void i() {
        this.a.i();
    }

    @Override // ir.nasim.InterfaceC7879To6
    public Rect l() {
        return this.a.l();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void n() {
        this.a.n();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        k(c8967Xz7);
        InterfaceC20284rl0.h(this.a, c8967Xz7, xv4, null, 4, null);
        MessageEmojiTextView messageEmojiTextView = this.b.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        j(messageEmojiTextView);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout d() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void t(InterfaceC20875sl0 interfaceC20875sl0) {
        AbstractC13042fc3.i(interfaceC20875sl0, "listener");
        this.a.t(interfaceC20875sl0);
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void u() {
        this.a.u();
    }

    @Override // ir.nasim.InterfaceC7879To6
    public void v() {
        this.a.v();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void w(View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        this.a.w(view, c8967Xz7);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.n) {
            k(((N15.n) n15).b());
            return;
        }
        this.a.z(n15);
        MessageEmojiTextView messageEmojiTextView = this.b.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        j(messageEmojiTextView);
    }

    private VQ4(C20882sl7 c20882sl7, C15481jf3 c15481jf3) {
        this.a = c20882sl7;
        this.b = c15481jf3;
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.c = constraintLayout;
        C12463ef3 c12463ef3B = C12463ef3.b(LayoutInflater.from(c15481jf3.getRoot().getContext()), c15481jf3.getRoot());
        AbstractC13042fc3.h(c12463ef3B, "inflate(...)");
        this.d = c12463ef3B;
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        j(messageStateView);
        c12463ef3B.f.setTypeface(C6011Lu2.i());
    }
}
