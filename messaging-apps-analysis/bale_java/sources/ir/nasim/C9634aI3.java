package ir.nasim;

import android.graphics.Rect;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.N15;
import ir.nasim.X2;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReplyView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.aI3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9634aI3 implements InterfaceC20284rl0 {
    private final C10466bf3 a;
    private AbstractC23538x54 b;
    private final ConstraintLayout c;
    private final C25112zl0 d;
    private SH3 e;
    private final C10228bI3 f;
    private InterfaceC20875sl0 g;

    /* renamed from: ir.nasim.aI3$a */
    public static final class a implements InterfaceC22152ul0 {
        private final boolean a;
        private AbstractC23538x54 b;

        public a(boolean z, AbstractC23538x54 abstractC23538x54) {
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.a = z;
            this.b = abstractC23538x54;
        }

        @Override // ir.nasim.InterfaceC22152ul0
        public InterfaceC20284rl0 a(ViewStub viewStub) {
            AbstractC13042fc3.i(viewStub, "viewStub");
            viewStub.setLayoutResource(AbstractC12208eD5.item_chat_location_bubble);
            C10466bf3 c10466bf3A = C10466bf3.a(viewStub.inflate());
            AbstractC13042fc3.h(c10466bf3A, "bind(...)");
            return new C9634aI3(c10466bf3A, this.a, this.b);
        }
    }

    /* renamed from: ir.nasim.aI3$b */
    public static final class b implements View.OnLayoutChangeListener {
        final /* synthetic */ C10466bf3 a;

        public b(C10466bf3 c10466bf3) {
            this.a = c10466bf3;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            ShapeableImageView shapeableImageView = this.a.c;
            AbstractC13042fc3.h(shapeableImageView, "imageViewLocation");
            ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = view.getWidth();
            layoutParams2.height = view.getHeight();
            shapeableImageView.setLayoutParams(layoutParams2);
        }
    }

    public C9634aI3(C10466bf3 c10466bf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        AbstractC13042fc3.i(c10466bf3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        this.a = c10466bf3;
        this.b = abstractC23538x54;
        ConstraintLayout constraintLayout = c10466bf3.d;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.c = constraintLayout;
        ConstraintLayout root = c10466bf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        this.d = new C25112zl0(root);
        this.f = new C10228bI3(z, c10466bf3.f.getId());
        L(z);
        MessageEmojiTextView messageEmojiTextView = c10466bf3.h;
        C3335Al0 c3335Al0 = C3335Al0.a;
        messageEmojiTextView.setTextSize(c3335Al0.k());
        BubbleTextView bubbleTextView = c10466bf3.j;
        bubbleTextView.setTypeface(C6011Lu2.i());
        bubbleTextView.setTextSize(c3335Al0.u());
    }

    private final void A(final C8967Xz7 c8967Xz7, final RH3 rh3) {
        this.a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ZH3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C9634aI3.B(this.a, c8967Xz7, rh3, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(C9634aI3 c9634aI3, C8967Xz7 c8967Xz7, RH3 rh3, View view) {
        AbstractC13042fc3.i(c9634aI3, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(rh3, "$location");
        c9634aI3.b.d().d(c8967Xz7, rh3);
    }

    private final C19938rB7 C(final C8967Xz7 c8967Xz7, Spannable spannable) {
        MessageReactionView messageReactionView = this.a.i;
        messageReactionView.r(spannable);
        messageReactionView.setMovementMethod(LinkMovementMethod.getInstance());
        if (spannable != null) {
            MG5[] mg5Arr = (MG5[]) spannable.getSpans(0, spannable.length(), MG5.class);
            if (mg5Arr != null) {
                for (MG5 mg5 : mg5Arr) {
                    mg5.b(new InterfaceC14603iB2() { // from class: ir.nasim.XH3
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return C9634aI3.D(this.a, c8967Xz7, (String) obj, ((Boolean) obj2).booleanValue());
                        }
                    });
                }
                return C19938rB7.a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(C9634aI3 c9634aI3, C8967Xz7 c8967Xz7, String str, boolean z) {
        AbstractC13042fc3.i(c9634aI3, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(str, "reactionCode");
        c9634aI3.b.b().t(c8967Xz7, str, z);
        return C19938rB7.a;
    }

    private final void E(final C8967Xz7 c8967Xz7, PO5 po5) {
        MessageReplyView messageReplyView = this.a.e;
        messageReplyView.d0(po5);
        if (po5 != null) {
            messageReplyView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.YH3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C9634aI3.F(this.a, c8967Xz7, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(C9634aI3 c9634aI3, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c9634aI3, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        c9634aI3.b.b().s(c8967Xz7);
    }

    private final void G(Spannable spannable) {
        this.a.g.r(spannable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(C8967Xz7 c8967Xz7, C9634aI3 c9634aI3, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c9634aI3, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        Object objF = c8967Xz7.f();
        RH3 rh3 = objF instanceof RH3 ? (RH3) objF : null;
        if (rh3 == null) {
            throw new IllegalArgumentException();
        }
        c9634aI3.b.d().d(c8967Xz7, rh3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(C9634aI3 c9634aI3, C8967Xz7 c8967Xz7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c9634aI3, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "<unused var>");
        InterfaceC22948w54 interfaceC22948w54B = c9634aI3.b.b();
        ConstraintLayout root = c9634aI3.a.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        interfaceC22948w54B.e(root, c8967Xz7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K(C9634aI3 c9634aI3, C8967Xz7 c8967Xz7, C4602Fv2 c4602Fv2, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c9634aI3, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c4602Fv2, "$it");
        AbstractC13042fc3.i(view, "<unused var>");
        c9634aI3.b.b().p(c8967Xz7, c4602Fv2);
        return true;
    }

    private final void L(boolean z) {
        ConstraintLayout root = this.a.getRoot();
        if (z) {
            root.setBackgroundResource(KB5.bubble_in);
        } else {
            root.setBackgroundResource(KB5.bubble_out);
        }
    }

    private final void M() {
        C10466bf3 c10466bf3 = this.a;
        C10228bI3 c10228bI3 = this.f;
        MessageReactionView messageReactionView = c10466bf3.i;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c10466bf3.g;
        AbstractC13042fc3.h(messageStateView, "stateView");
        c10228bI3.b(messageReactionView, messageStateView);
    }

    private final void s(String str) {
        this.a.getRoot().getRootView().setContentDescription(str);
    }

    private final void x(final C8967Xz7 c8967Xz7, final C4602Fv2 c4602Fv2) {
        MessageEmojiTextView messageEmojiTextView = this.a.h;
        messageEmojiTextView.r(c4602Fv2 != null ? c4602Fv2.b() : null);
        messageEmojiTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.TH3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C9634aI3.y(c4602Fv2, this, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(C4602Fv2 c4602Fv2, C9634aI3 c9634aI3, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c9634aI3, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        if (c4602Fv2 != null) {
            c9634aI3.b.b().p(c8967Xz7, c4602Fv2);
        }
    }

    @Override // ir.nasim.InterfaceC20284rl0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout d() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void a() {
        C10466bf3 c10466bf3 = this.a;
        c10466bf3.h.setOnClickListener(null);
        c10466bf3.e.setOnClickListener(null);
        SH3 sh3 = this.e;
        if (sh3 != null) {
            sh3.d();
        }
        this.e = null;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void i() {
        this.a.i.invalidate();
    }

    @Override // ir.nasim.InterfaceC7879To6
    public Rect l() {
        return this.d.a();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        C10466bf3 c10466bf3 = this.a;
        Object objF = c8967Xz7.f();
        RH3 rh3 = objF instanceof RH3 ? (RH3) objF : null;
        if (rh3 == null) {
            throw new IllegalArgumentException();
        }
        ConstraintLayout root = c10466bf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((Number) xv4.e()).intValue();
        root.setLayoutParams(layoutParams2);
        ShimmerFrameLayout shimmerFrameLayout = c10466bf3.f;
        AbstractC13042fc3.h(shimmerFrameLayout, "shimmerLayout");
        if (!shimmerFrameLayout.isLaidOut() || shimmerFrameLayout.isLayoutRequested()) {
            shimmerFrameLayout.addOnLayoutChangeListener(new b(c10466bf3));
        } else {
            ShapeableImageView shapeableImageView = c10466bf3.c;
            AbstractC13042fc3.h(shapeableImageView, "imageViewLocation");
            ViewGroup.LayoutParams layoutParams3 = shapeableImageView.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.width = shimmerFrameLayout.getWidth();
            layoutParams4.height = shimmerFrameLayout.getHeight();
            shapeableImageView.setLayoutParams(layoutParams4);
        }
        this.f.f(((Number) xv4.e()).intValue());
        G(c8967Xz7.r());
        x(c8967Xz7, c8967Xz7.g());
        E(c8967Xz7, c8967Xz7.m());
        C(c8967Xz7, c8967Xz7.l());
        s(c8967Xz7.e());
        M();
        c10466bf3.j.r(c8967Xz7.o());
        ShapeableImageView shapeableImageView2 = c10466bf3.c;
        AbstractC13042fc3.h(shapeableImageView2, "imageViewLocation");
        ShimmerFrameLayout shimmerFrameLayout2 = c10466bf3.f;
        AbstractC13042fc3.h(shimmerFrameLayout2, "shimmerLayout");
        SH3 sh3 = new SH3(shapeableImageView2, shimmerFrameLayout2);
        sh3.b(rh3);
        this.e = sh3;
        A(c8967Xz7, rh3);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void t(InterfaceC20875sl0 interfaceC20875sl0) {
        AbstractC13042fc3.i(interfaceC20875sl0, "listener");
        this.g = interfaceC20875sl0;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void w(View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC12990fW7.l0(view, X2.a.i, view.getContext().getString(AbstractC12217eE5.message_options_activate), new InterfaceC10698c3() { // from class: ir.nasim.UH3
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C9634aI3.I(c8967Xz7, this, view2, aVar);
            }
        });
        AbstractC12990fW7.c(view, this.a.getRoot().getContext().getString(AbstractC12217eE5.message_options_context_menu), new InterfaceC10698c3() { // from class: ir.nasim.VH3
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C9634aI3.J(this.a, c8967Xz7, view2, aVar);
            }
        });
        final C4602Fv2 c4602Fv2G = c8967Xz7.g();
        if (c4602Fv2G != null) {
            C4602Fv2 c4602Fv2G2 = c8967Xz7.g();
            AbstractC12990fW7.c(view, String.valueOf(c4602Fv2G2 != null ? c4602Fv2G2.b() : null), new InterfaceC10698c3() { // from class: ir.nasim.WH3
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C9634aI3.K(this.a, c8967Xz7, c4602Fv2G, view2, aVar);
                }
            });
        }
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.l) {
            N15.l lVar = (N15.l) n15;
            x(lVar.c(), lVar.b());
            return;
        }
        if (n15 instanceof N15.u) {
            this.a.j.r(((N15.u) n15).b().o());
            M();
        } else if (n15 instanceof N15.v) {
            G(((N15.v) n15).c());
            M();
        } else if (n15 instanceof N15.p) {
            N15.p pVar = (N15.p) n15;
            C(pVar.b(), pVar.c());
            G(pVar.b().r());
            M();
        }
    }
}
