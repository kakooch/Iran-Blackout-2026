package ir.nasim;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.Hw5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5097Hw5 implements InterfaceC20284rl0 {
    public static final a f = new a(null);
    public static final int g = 8;
    private final C13690gf3 a;
    private final boolean b;
    private final AbstractC23538x54 c;
    private final ConstraintLayout d;
    private final C25112zl0 e;

    /* renamed from: ir.nasim.Hw5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Hw5$b */
    public static final class b implements InterfaceC22152ul0 {
        private final boolean a;
        private final AbstractC23538x54 b;

        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.a = z;
            this.b = abstractC23538x54;
        }

        @Override // ir.nasim.InterfaceC22152ul0
        public InterfaceC20284rl0 a(ViewStub viewStub) {
            AbstractC13042fc3.i(viewStub, "viewStub");
            viewStub.setLayoutResource(AbstractC12208eD5.item_chat_protected_bubble);
            C13690gf3 c13690gf3A = C13690gf3.a(viewStub.inflate());
            AbstractC13042fc3.h(c13690gf3A, "bind(...)");
            return new C5097Hw5(c13690gf3A, this.a, this.b);
        }
    }

    /* renamed from: ir.nasim.Hw5$c */
    public static final class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "view");
            C5097Hw5.this.c.h().b();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "textPaint");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(AbstractC4043Dl1.c(C5097Hw5.this.d().getContext(), TA5.link_color));
        }
    }

    public C5097Hw5(C13690gf3 c13690gf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        AbstractC13042fc3.i(c13690gf3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        this.a = c13690gf3;
        this.b = z;
        this.c = abstractC23538x54;
        ConstraintLayout constraintLayout = c13690gf3.c;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.d = constraintLayout;
        ConstraintLayout root = c13690gf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        this.e = new C25112zl0(root);
    }

    private final int A(int i) {
        return Math.min(i, (int) (this.a.getRoot().getResources().getDisplayMetrics().widthPixels * 0.85d));
    }

    private final SpannableStringBuilder B(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Context context = d().getContext();
        Drawable drawableF = AbstractC4043Dl1.f(context, i);
        if (drawableF != null) {
            drawableF.mutate();
            drawableF.setTint(AbstractC4043Dl1.c(context, i2));
            drawableF.setBounds(0, 0, drawableF.getIntrinsicWidth(), drawableF.getIntrinsicHeight());
        } else {
            drawableF = null;
        }
        if (drawableF != null) {
            ImageSpan imageSpan = new ImageSpan(drawableF, 1);
            spannableStringBuilder.insert(0, "  ");
            spannableStringBuilder.setSpan(imageSpan, 0, 1, 33);
        }
        return spannableStringBuilder;
    }

    private final void C(C13690gf3 c13690gf3) {
        if (this.b) {
            c13690gf3.getRoot().setBackgroundResource(KB5.bubble_in);
        } else {
            c13690gf3.getRoot().setBackgroundResource(KB5.bubble_out);
        }
    }

    private final void k(C13690gf3 c13690gf3) {
        BubbleTextView bubbleTextView = c13690gf3.b;
        String string = bubbleTextView.getContext().getString(AbstractC12217eE5.bubble_protected_description);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = bubbleTextView.getContext().getString(AbstractC12217eE5.bubble_protected_description_bold_section);
        AbstractC13042fc3.h(string2, "getString(...)");
        String string3 = bubbleTextView.getContext().getString(AbstractC12217eE5.bubble_protected_description_link_section);
        AbstractC13042fc3.h(string3, "getString(...)");
        bubbleTextView.setText(y(s(B(new SpannableStringBuilder(string), KB5.bot_info_vd, TA5.error), string2), string3));
        bubbleTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void m(C13690gf3 c13690gf3, XV4 xv4) {
        C(c13690gf3);
        ConstraintLayout root = c13690gf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = A(((Number) xv4.e()).intValue());
        root.setLayoutParams(layoutParams2);
    }

    private final void p(C13690gf3 c13690gf3, C8967Xz7 c8967Xz7) {
        c13690gf3.e.r(c8967Xz7.r());
    }

    private final void q(C13690gf3 c13690gf3, final C8967Xz7 c8967Xz7) {
        MaterialButton materialButton = c13690gf3.f;
        materialButton.setTextSize(C3335Al0.a.q());
        materialButton.setTypeface(C6011Lu2.i());
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gw5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5097Hw5.r(this.a, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(C5097Hw5 c5097Hw5, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c5097Hw5, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        c5097Hw5.c.h().a(c8967Xz7);
    }

    private final SpannableStringBuilder s(SpannableStringBuilder spannableStringBuilder, String str) {
        int iL0 = AbstractC20762sZ6.l0(spannableStringBuilder, str, 0, false, 6, null);
        int length = str.length() + iL0;
        spannableStringBuilder.setSpan(new T10(C6011Lu2.i()), iL0, length, 33);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(1.1f), iL0, length, 33);
        return spannableStringBuilder;
    }

    private final SpannableStringBuilder y(SpannableStringBuilder spannableStringBuilder, String str) {
        int iL0 = AbstractC20762sZ6.l0(spannableStringBuilder, str, 0, false, 6, null);
        spannableStringBuilder.setSpan(new c(), iL0, str.length() + iL0, 33);
        return spannableStringBuilder;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void a() {
        this.a.f.setOnClickListener(null);
    }

    @Override // ir.nasim.InterfaceC7879To6
    public Rect l() {
        return this.e.a();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        C13690gf3 c13690gf3 = this.a;
        m(c13690gf3, xv4);
        q(c13690gf3, c8967Xz7);
        k(c13690gf3);
        p(c13690gf3, c8967Xz7);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout d() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void i() {
    }
}
