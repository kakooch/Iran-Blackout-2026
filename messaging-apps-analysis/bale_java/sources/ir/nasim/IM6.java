package ir.nasim;

import android.graphics.Rect;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReplyView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import ir.nasim.features.smiles.widget.StickerView;

/* loaded from: classes5.dex */
public class IM6 implements InterfaceC20284rl0 {
    public static final a j = new a(null);
    public static final int k = 8;
    private final C14891if3 a;
    private AbstractC23538x54 b;
    private final ConstraintLayout c;
    private final C25112zl0 d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC9173Yu3 f;
    private InterfaceC20875sl0 g;
    private final E64 h;
    private String i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static class b implements InterfaceC22152ul0 {
        private final boolean a;
        private AbstractC23538x54 b;

        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.a = z;
            this.b = abstractC23538x54;
        }

        @Override // ir.nasim.InterfaceC22152ul0
        public final InterfaceC20284rl0 a(ViewStub viewStub) {
            AbstractC13042fc3.i(viewStub, "viewStub");
            viewStub.setLayoutResource(AbstractC12208eD5.item_chat_sticker_bubble);
            C14891if3 c14891if3A = C14891if3.a(viewStub.inflate());
            AbstractC13042fc3.h(c14891if3A, "bind(...)");
            return new IM6(c14891if3A, this.a, this.b);
        }
    }

    public IM6(C14891if3 c14891if3, boolean z, AbstractC23538x54 abstractC23538x54) {
        AbstractC13042fc3.i(c14891if3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        this.a = c14891if3;
        this.b = abstractC23538x54;
        ConstraintLayout constraintLayout = c14891if3.e;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.c = constraintLayout;
        ConstraintLayout root = c14891if3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        this.d = new C25112zl0(root);
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.EM6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return IM6.S(this.a);
            }
        });
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.FM6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(IM6.A());
            }
        });
        E64 e64 = new E64();
        this.h = e64;
        W(z);
        U(z);
        StickerView stickerView = c14891if3.g;
        AbstractC13042fc3.f(stickerView);
        X(stickerView, z);
        final GestureDetector gestureDetector = new GestureDetector(c14891if3.getRoot().getContext(), e64);
        stickerView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.GM6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return IM6.T(gestureDetector, view, motionEvent);
            }
        });
        LottieAnimationView lottieAnimationView = c14891if3.b;
        AbstractC13042fc3.h(lottieAnimationView, "animationView");
        X(lottieAnimationView, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A() {
        return JF5.g() ? 1 : 2;
    }

    private final void B(String str) {
        this.a.getRoot().setContentDescription(str);
    }

    private final void C(final C8967Xz7 c8967Xz7, final C4602Fv2 c4602Fv2) {
        MessageEmojiTextView messageEmojiTextView = this.a.h;
        messageEmojiTextView.r(c4602Fv2 != null ? c4602Fv2.b() : null);
        messageEmojiTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.HM6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IM6.D(c4602Fv2, this, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(C4602Fv2 c4602Fv2, IM6 im6, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(im6, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        if (c4602Fv2 != null) {
            im6.b.b().p(c8967Xz7, c4602Fv2);
        }
    }

    private final C19938rB7 E(final C8967Xz7 c8967Xz7, Spannable spannable) {
        MessageReactionView messageReactionView = this.a.i;
        messageReactionView.r(spannable);
        this.i = c8967Xz7.k();
        messageReactionView.setMovementMethod(LinkMovementMethod.getInstance());
        if (spannable != null) {
            MG5[] mg5Arr = (MG5[]) spannable.getSpans(0, spannable.length(), MG5.class);
            if (mg5Arr != null) {
                for (MG5 mg5 : mg5Arr) {
                    mg5.b(new InterfaceC14603iB2() { // from class: ir.nasim.yM6
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return IM6.F(this.a, c8967Xz7, (String) obj, ((Boolean) obj2).booleanValue());
                        }
                    });
                }
                return C19938rB7.a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(IM6 im6, C8967Xz7 c8967Xz7, String str, boolean z) {
        AbstractC13042fc3.i(im6, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(str, "reactionCode");
        im6.b.b().t(c8967Xz7, str, z);
        return C19938rB7.a;
    }

    private final void G(final C8967Xz7 c8967Xz7, PO5 po5) {
        MessageReplyView messageReplyView = this.a.f;
        messageReplyView.d0(po5);
        if (po5 != null) {
            messageReplyView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zM6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IM6.H(this.a, c8967Xz7, view);
                }
            });
            messageReplyView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.AM6
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return IM6.I(this.a, c8967Xz7, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(IM6 im6, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(im6, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        im6.b.b().s(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(IM6 im6, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(im6, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        return im6.b.b().m(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L(IM6 im6, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(im6, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        InterfaceC24373yW1.h(im6.b.d(), c8967Xz7, null, null, 6, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(IM6 im6, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(im6, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        im6.b.b().m(c8967Xz7);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N(IM6 im6, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(im6, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        InterfaceC22948w54 interfaceC22948w54B = im6.b.b();
        StickerView stickerView = im6.a.g;
        AbstractC13042fc3.h(stickerView, "sticker");
        return interfaceC22948w54B.j(stickerView, c8967Xz7, im6.i);
    }

    private final int O() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final KM6 P() {
        return (KM6) this.e.getValue();
    }

    private final int Q(int i) {
        return Math.min(i, (int) (this.a.getRoot().getResources().getDisplayMetrics().widthPixels * 0.5d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KM6 S(IM6 im6) {
        AbstractC13042fc3.i(im6, "this$0");
        C14891if3 c14891if3 = im6.a;
        MessageReactionView messageReactionView = c14891if3.i;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c14891if3.j;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        Barrier barrier = c14891if3.d;
        AbstractC13042fc3.h(barrier, "barrierEnd");
        return new KM6(messageReactionView, messageStateView, barrier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(gestureDetector, "$gestureDetector");
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final void U(boolean z) {
        MessageEmojiTextView messageEmojiTextView = this.a.h;
        if (z) {
            messageEmojiTextView.setBackgroundResource(KB5.bubble_in_sticker);
        } else {
            messageEmojiTextView.setBackgroundResource(KB5.bubble_out_sticker);
        }
        AbstractC13042fc3.f(messageEmojiTextView);
        messageEmojiTextView.setPadding(AbstractC8943Xx1.c(12), messageEmojiTextView.getPaddingTop(), AbstractC8943Xx1.c(12), messageEmojiTextView.getPaddingBottom());
        X(messageEmojiTextView, z);
    }

    private final void V(XV4 xv4) {
        P().s(Q(((Number) xv4.e()).intValue()));
    }

    private final void W(boolean z) {
        MessageReplyView messageReplyView = this.a.f;
        if (z) {
            messageReplyView.setBackgroundResource(KB5.bubble_in_sticker);
        } else {
            messageReplyView.setBackgroundResource(KB5.bubble_out_sticker);
        }
        AbstractC13042fc3.f(messageReplyView);
        X(messageReplyView, z);
    }

    private final void X(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int i = 0;
        if (!z ? O() != 1 : O() == 1) {
            i = 1;
        }
        layoutParams2.F = i;
        view.setLayoutParams(layoutParams2);
    }

    public final void J(Spannable spannable) {
        AbstractC13042fc3.i(spannable, "state");
        this.a.j.r(spannable);
    }

    public void K(final C8967Xz7 c8967Xz7, AbstractC17757nW1.c.AbstractC1416c abstractC1416c) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC1416c, "document");
        StickerView stickerView = this.a.g;
        AbstractC13042fc3.f(stickerView);
        ViewGroup.LayoutParams layoutParams = stickerView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((Number) abstractC1416c.d().e()).intValue();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((Number) abstractC1416c.d().f()).intValue();
        stickerView.setLayoutParams(layoutParams2);
        E64 e64 = this.h;
        e64.c(new SA2() { // from class: ir.nasim.BM6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(IM6.L(this.a, c8967Xz7));
            }
        });
        e64.e(new SA2() { // from class: ir.nasim.CM6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return IM6.M(this.a, c8967Xz7);
            }
        });
        e64.d(new SA2() { // from class: ir.nasim.DM6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(IM6.N(this.a, c8967Xz7));
            }
        });
        StickerView.b(stickerView, abstractC1416c.b().a().b(), null, 2, null);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout d() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void a() {
        this.a.g.m();
        P().t();
        this.h.f();
        this.i = null;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void i() {
        this.a.f.f0();
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
        V(xv4);
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Document.Graphical.Sticker");
        K(c8967Xz7, (AbstractC17757nW1.c.AbstractC1416c) objF);
        C(c8967Xz7, c8967Xz7.g());
        G(c8967Xz7, c8967Xz7.m());
        J(c8967Xz7.r());
        E(c8967Xz7, c8967Xz7.l());
        B(c8967Xz7.e());
        P().r();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void t(InterfaceC20875sl0 interfaceC20875sl0) {
        AbstractC13042fc3.i(interfaceC20875sl0, "listener");
        this.g = interfaceC20875sl0;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.v) {
            J(((N15.v) n15).c());
            P().r();
        } else if (n15 instanceof N15.p) {
            N15.p pVar = (N15.p) n15;
            E(pVar.b(), pVar.c());
            P().r();
        }
    }
}
