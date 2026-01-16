package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.C20882sl7;
import ir.nasim.M44;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import java.util.List;

/* renamed from: ir.nasim.t80, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21114t80 extends C20882sl7 implements O44 {
    public static final a v = new a(null);
    public static final int w = 8;
    private final ConstraintLayout r;
    private final C6596Oe3 s;
    private final InterfaceC9173Yu3 t;
    private final C20326rp2 u;

    /* renamed from: ir.nasim.t80$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.t80$b */
    public static final class b extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C21114t80(c15481jf3, z, c(), null);
        }
    }

    public /* synthetic */ C21114t80(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c15481jf3, z, abstractC23538x54);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20326rp2 b1(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "$binding");
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        CommentContainerView commentContainerView = c15481jf3.e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        return new C20326rp2(messageReactionView, messageStateView, messageEmojiTextView, commentContainerView);
    }

    private final Spannable c1(EnumC22974w80 enumC22974w80, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = x0().getRoot().getContext().getString(enumC22974w80.j());
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = x0().getRoot().getContext().getString(AbstractC12217eE5.banned_message_bubble, string);
        AbstractC13042fc3.h(string2, "getString(...)");
        List listN0 = AbstractC20762sZ6.N0(string2, new String[]{string}, false, 0, 6, null);
        spannableStringBuilder.append((CharSequence) listN0.get(0));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        spannableStringBuilder.append((CharSequence) listN0.get(1));
        if (z) {
            AbstractC13042fc3.h(spannableStringBuilder.append('\n'), "append(...)");
            AbstractC13042fc3.h(spannableStringBuilder.append('\n'), "append(...)");
            spannableStringBuilder.append((CharSequence) x0().getRoot().getContext().getString(AbstractC12217eE5.banned_sender_discription));
        }
        return spannableStringBuilder;
    }

    private final C20326rp2 e1() {
        return (C20326rp2) this.t.getValue();
    }

    private final int f1(int i) {
        return Math.min(i, (int) (this.s.getRoot().getResources().getDisplayMetrics().widthPixels * 0.75d));
    }

    @Override // ir.nasim.C20882sl7
    protected int C0() {
        return 4;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    @Override // ir.nasim.C20882sl7
    protected void X0(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        B0().s((f1(((Number) xv4.e()).intValue()) - x0().getRoot().getPaddingLeft()) - x0().getRoot().getPaddingRight());
    }

    @Override // ir.nasim.C20882sl7
    public void Z0() {
        ViewStub viewStub = x0().g;
        AbstractC13042fc3.h(viewStub, "mainViewStub");
        ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(AbstractC8943Xx1.c(4));
        layoutParams2.setMarginEnd(AbstractC8943Xx1.c(4));
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = AbstractC8943Xx1.c(4);
        viewStub.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C20882sl7
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public C20326rp2 B0() {
        return this.u;
    }

    @Override // ir.nasim.O44
    public void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        ConstraintLayout root = x0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = f1(((Number) xv4.e()).intValue());
        root.setLayoutParams(layoutParams2);
        AbstractC17457n0 abstractC17457n0F = c8967Xz7.j().F();
        C21788u80 c21788u80 = abstractC17457n0F instanceof C21788u80 ? (C21788u80) abstractC17457n0F : null;
        if (c21788u80 != null) {
            this.s.b.setText(c1(c21788u80.s(), c8967Xz7.j().U() == AbstractC5969Lp4.f()));
        }
        Z0();
    }

    private C21114t80(final C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.s80
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21114t80.b1(c15481jf3);
            }
        });
        this.u = e1();
        ViewStub viewStub = c15481jf3.g;
        AbstractC13042fc3.h(viewStub, "mainViewStub");
        ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        viewStub.setLayoutParams(layoutParams2);
        C6596Oe3 c6596Oe3A = C6596Oe3.a(R0(AbstractC12208eD5.item_banned_messaged_bubble));
        c6596Oe3A.b.setTypeface(C6011Lu2.i());
        this.s = c6596Oe3A;
        if (z) {
            MaterialCardView root = c6596Oe3A.getRoot();
            Context context = c15481jf3.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            root.setCardBackgroundColor(OY0.b(context, AbstractC21139tA5.n20));
            return;
        }
        MaterialCardView root2 = c6596Oe3A.getRoot();
        Context context2 = c15481jf3.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        root2.setCardBackgroundColor(OY0.b(context2, AbstractC21139tA5.bubble_third));
    }
}
