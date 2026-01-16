package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.C20882sl7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.uI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21882uI2 extends C20882sl7 {
    private static final a w = new a(null);
    public static final int x = 8;
    private final ConstraintLayout r;
    private final C8754Xe3 s;
    private final MaterialButton t;
    private final FU u;
    private final T73 v;

    /* renamed from: ir.nasim.uI2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.uI2$b */
    public static final class b extends C20882sl7.b {
        private final boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, boolean z2, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.c = z2;
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C21882uI2(c15481jf3, z, this.c, c(), null);
        }
    }

    public /* synthetic */ C21882uI2(C15481jf3 c15481jf3, boolean z, boolean z2, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c15481jf3, z, z2, abstractC23538x54);
    }

    private final void d1(final C8967Xz7 c8967Xz7, final C19405qI2 c19405qI2) {
        g1(c19405qI2);
        h1(c19405qI2);
        C8754Xe3 c8754Xe3 = this.s;
        f1(c19405qI2);
        c8754Xe3.e.r(c19405qI2.a());
        this.t.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rI2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C21882uI2.e1(this.a, c8967Xz7, c19405qI2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(C21882uI2 c21882uI2, C8967Xz7 c8967Xz7, C19405qI2 c19405qI2, View view) {
        AbstractC13042fc3.i(c21882uI2, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c19405qI2, "$giftPacket");
        c21882uI2.z0().d().d(c8967Xz7, c19405qI2);
    }

    private final void f1(C19405qI2 c19405qI2) {
        if (c19405qI2.b()) {
            ImageView imageView = this.s.d;
            imageView.setImageDrawable(AbstractC4043Dl1.f(imageView.getContext(), KB5.gold_gift_card_new));
            BubbleTextView bubbleTextView = this.s.f;
            AbstractC13042fc3.f(bubbleTextView);
            Context context = bubbleTextView.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            int iB = OY0.b(context, AbstractC21139tA5.a01);
            int i = KB5.gift_card;
            String string = bubbleTextView.getContext().getString(AbstractC12217eE5.gold_gift_packet);
            AbstractC13042fc3.h(string, "getString(...)");
            l1(bubbleTextView, iB, i, string);
            return;
        }
        ImageView imageView2 = this.s.d;
        imageView2.setImageDrawable(AbstractC4043Dl1.f(imageView2.getContext(), KB5.gift_packet_bubble));
        BubbleTextView bubbleTextView2 = this.s.f;
        AbstractC13042fc3.f(bubbleTextView2);
        Context context2 = bubbleTextView2.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        int iB2 = OY0.b(context2, AbstractC21139tA5.bubble_secondary);
        int i2 = KB5.bubble_icon_gift;
        String string2 = bubbleTextView2.getContext().getString(AbstractC12217eE5.gift_packet);
        AbstractC13042fc3.h(string2, "getString(...)");
        l1(bubbleTextView2, iB2, i2, string2);
    }

    private final void g1(C19405qI2 c19405qI2) {
        if (c19405qI2.b()) {
            C8754Xe3 c8754Xe3 = this.s;
            c8754Xe3.c.setVisibility(4);
            c8754Xe3.c.setMargin(0);
            c8754Xe3.b.setVisibility(4);
            x0().i.setPadding(AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(8));
            ConstraintLayout constraintLayout = x0().f;
            Drawable drawableF = AbstractC4043Dl1.f(constraintLayout.getContext(), J0() ? KB5.bubble_in : KB5.bubble_out);
            if (drawableF != null) {
                drawableF.mutate();
                Context context = constraintLayout.getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                drawableF.setTint(OY0.b(context, AbstractC21139tA5.golden_packet_gradient01));
            } else {
                drawableF = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            Context context2 = constraintLayout.getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            gradientDrawable.setColor(OY0.b(context2, AbstractC21139tA5.golden_packet_gradient01));
            gradientDrawable.setCornerRadius(AbstractC8943Xx1.c(8));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setGradientType(1);
            gradientDrawable2.setGradientRadius(500.0f);
            gradientDrawable2.setGradientCenter(0.0f, 0.0f);
            Context context3 = constraintLayout.getContext();
            AbstractC13042fc3.h(context3, "getContext(...)");
            gradientDrawable2.setColors(new int[]{OY0.b(context3, AbstractC21139tA5.golden_packet_gradient02), 0});
            gradientDrawable2.setAlpha(90);
            gradientDrawable2.setCornerRadius(AbstractC8943Xx1.c(8));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setGradientType(1);
            gradientDrawable3.setGradientRadius(350.0f);
            gradientDrawable3.setGradientCenter(0.9f, 0.9f);
            Context context4 = constraintLayout.getContext();
            AbstractC13042fc3.h(context4, "getContext(...)");
            gradientDrawable3.setColors(new int[]{OY0.b(context4, AbstractC21139tA5.golden_packet_gradient02), 0});
            gradientDrawable3.setAlpha(60);
            gradientDrawable3.setCornerRadius(AbstractC8943Xx1.c(8));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableF, gradientDrawable, gradientDrawable2, gradientDrawable3});
            layerDrawable.setLayerInset(0, 10, 10, 10, 10);
            constraintLayout.setBackground(layerDrawable);
        }
    }

    private final void h1(C19405qI2 c19405qI2) {
        Spannable spannableA = c19405qI2.a();
        if (spannableA != null) {
            C12973fV[] c12973fVArr = (C12973fV[]) spannableA.getSpans(0, spannableA.length(), C12973fV.class);
            if (c12973fVArr != null) {
                for (final C12973fV c12973fV : c12973fVArr) {
                    FU.g(this.u, c12973fV.c(), c12973fV.b(), null, new UA2() { // from class: ir.nasim.tI2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C21882uI2.i1(c12973fV, this, (Drawable) obj);
                        }
                    }, 4, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i1(C12973fV c12973fV, C21882uI2 c21882uI2, Drawable drawable) {
        AbstractC13042fc3.i(c12973fV, "$span");
        AbstractC13042fc3.i(c21882uI2, "this$0");
        AbstractC13042fc3.i(drawable, "drawable");
        c12973fV.a(drawable);
        c21882uI2.s.e.invalidate();
        return C19938rB7.a;
    }

    private final MaterialButton j1(boolean z) {
        MaterialButton root = C9029Ye3.a(z ? Q0(AbstractC12208eD5.item_chat_gift_gold_packet_button) : Q0(AbstractC12208eD5.item_chat_gift_packet_button)).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k1(C21882uI2 c21882uI2, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c21882uI2, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c21882uI2.t.performClick();
        return true;
    }

    private final void l1(BubbleTextView bubbleTextView, int i, int i2, String str) {
        Drawable drawableF = AbstractC4043Dl1.f(bubbleTextView.getContext(), i2);
        Drawable drawableMutate = drawableF != null ? drawableF.mutate() : null;
        if (drawableMutate != null) {
            drawableMutate.setBounds(0, 0, AbstractC8943Xx1.c(20), AbstractC8943Xx1.c(20));
            AbstractC21710u02.h(drawableMutate, i);
            SpannableString spannableString = new SpannableString("  " + str);
            spannableString.setSpan(new C12109e33(drawableMutate, -((AbstractC8943Xx1.c(1) * 13) + 2)), 0, 1, 33);
            bubbleTextView.setText(spannableString, TextView.BufferType.SPANNABLE);
        } else {
            bubbleTextView.setText(str);
        }
        bubbleTextView.setTextColor(i);
    }

    private final void m1(XV4 xv4) {
        int iMin = Math.min((((Number) xv4.e()).intValue() - x0().getRoot().getPaddingLeft()) - x0().getRoot().getPaddingRight(), (int) (this.s.getRoot().getResources().getDisplayMetrics().widthPixels * 0.8d));
        MessageEmojiTextView messageEmojiTextView = x0().i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        ViewGroup.LayoutParams layoutParams = messageEmojiTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = iMin - AbstractC8943Xx1.c(16);
        messageEmojiTextView.setLayoutParams(layoutParams2);
    }

    private final void n1(MaterialButton materialButton, boolean z) {
        if (!J0() && !z) {
            materialButton.setText(materialButton.getContext().getString(AbstractC12217eE5.crowd_funding_view_details));
        }
        materialButton.setTypeface(C6011Lu2.i());
        materialButton.setTextSize(C3335Al0.a.l());
        ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int iC = AbstractC8943Xx1.c(8);
        int iC2 = AbstractC8943Xx1.c(8);
        int iC3 = AbstractC8943Xx1.c(6);
        int iC4 = AbstractC8943Xx1.c(6);
        layoutParams2.setMarginStart(iC);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = iC3;
        layoutParams2.setMarginEnd(iC2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = iC4;
        materialButton.setLayoutParams(layoutParams2);
    }

    private final C8754Xe3 o1() {
        ViewStub viewStub = x0().g;
        AbstractC13042fc3.h(viewStub, "mainViewStub");
        ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        viewStub.setLayoutParams(layoutParams2);
        C8754Xe3 c8754Xe3A = C8754Xe3.a(R0(AbstractC12208eD5.item_chat_gift_packet_bubble));
        ImageView imageView = c8754Xe3A.d;
        if (!JF5.g()) {
            imageView.setRotationY(180.0f);
        }
        BubbleTextView bubbleTextView = c8754Xe3A.f;
        bubbleTextView.setTypeface(C6011Lu2.k());
        C3335Al0 c3335Al0 = C3335Al0.a;
        bubbleTextView.setTextSize(c3335Al0.n());
        MessageEmojiTextView messageEmojiTextView = c8754Xe3A.e;
        messageEmojiTextView.setTypeface(C6011Lu2.k());
        messageEmojiTextView.setTextSize(c3335Al0.m());
        AbstractC13042fc3.h(c8754Xe3A, "apply(...)");
        return c8754Xe3A;
    }

    @Override // ir.nasim.C20882sl7
    protected T73 B0() {
        return this.v;
    }

    @Override // ir.nasim.C20882sl7
    protected int C0() {
        return 8;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        this.u.d();
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        MessageEmojiTextView messageEmojiTextView = x0().i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        messageEmojiTextView.setVisibility(0);
        m1(xv4);
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.GiftPacket");
        d1(c8967Xz7, (C19405qI2) objF);
        if (c8967Xz7.i() != null) {
            B0().u();
        }
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC12990fW7.c(view, this.t.getText().toString(), new InterfaceC10698c3() { // from class: ir.nasim.sI2
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C21882uI2.k1(this.a, view2, aVar);
            }
        });
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.j) {
            super.z(n15);
            MessageEmojiTextView messageEmojiTextView = x0().i;
            AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
            messageEmojiTextView.setVisibility(0);
        } else {
            super.z(n15);
        }
        CommentContainerView commentContainerView = x0().e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        if (commentContainerView.getVisibility() == 0) {
            B0().u();
        }
    }

    private C21882uI2(C15481jf3 c15481jf3, boolean z, boolean z2, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
        Context context = c15481jf3.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        this.u = new FU(context);
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        CommentContainerView commentContainerView = c15481jf3.e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        this.v = new T73(messageReactionView, messageStateView, commentContainerView);
        this.s = o1();
        MaterialButton materialButtonJ1 = j1(z2);
        this.t = materialButtonJ1;
        n1(materialButtonJ1, z2);
        materialButtonJ1.setImportantForAccessibility(1);
    }
}
