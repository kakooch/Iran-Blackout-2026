package ir.nasim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C19835r13;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.M44;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.ki4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16103ki4 extends C19835r13 {
    private static final a E0 = new a(null);
    public static final int F0 = 8;
    private final ConstraintLayout A0;
    private final C11056cf3 B0;
    private int C0;
    private final T73 D0;

    /* renamed from: ir.nasim.ki4$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ki4$b */
    public static final class b extends C19835r13.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C19835r13.b, ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C16103ki4(c15481jf3, z, c());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16103ki4(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        AbstractC13042fc3.i(c15481jf3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.A0 = constraintLayout;
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        CommentContainerView commentContainerView = c15481jf3.e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        this.D0 = new T73(messageReactionView, messageStateView, commentContainerView);
        C11056cf3 c11056cf3A = C11056cf3.a(Q0(AbstractC12208eD5.item_chat_money_request_bubble));
        BubbleTextView bubbleTextView = c11056cf3A.e;
        C3335Al0 c3335Al0 = C3335Al0.a;
        bubbleTextView.setTextSize(c3335Al0.p());
        bubbleTextView.setTypeface(C6011Lu2.i());
        BubbleTextView bubbleTextView2 = c11056cf3A.d;
        bubbleTextView2.setTextSize(c3335Al0.p());
        bubbleTextView2.setTypeface(C6011Lu2.i());
        String string = bubbleTextView2.getContext().getString(AbstractC12217eE5.money_request_amount);
        AbstractC13042fc3.h(string, "getString(...)");
        bubbleTextView2.r(AbstractC17636nI6.i(string));
        MaterialButton materialButton = c11056cf3A.b;
        materialButton.setTextSize(c3335Al0.q());
        materialButton.setTypeface(C6011Lu2.i());
        MaterialButton materialButton2 = c11056cf3A.g;
        AbstractC13042fc3.f(materialButton2);
        materialButton2.setVisibility(z ? 0 : 8);
        materialButton2.setTextSize(c3335Al0.q());
        materialButton2.setTypeface(C6011Lu2.i());
        this.B0 = c11056cf3A;
    }

    private final void t2(C8967Xz7 c8967Xz7, C12494ei4 c12494ei4, XV4 xv4) {
        v1(c8967Xz7, c12494ei4.a(), xv4);
        w2(c8967Xz7, c12494ei4);
        this.B0.e.r(c12494ei4.c());
        MessageEmojiTextView messageEmojiTextView = x0().i;
        AbstractC13042fc3.f(messageEmojiTextView);
        ViewGroup.LayoutParams layoutParams = messageEmojiTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((Number) K1().e()).intValue() - ((int) ((16 * AbstractC3742Cd6.c()) + 0.5d));
        messageEmojiTextView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u2(C16103ki4 c16103ki4, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c16103ki4, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c16103ki4.B0.b.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v2(C16103ki4 c16103ki4, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c16103ki4, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c16103ki4.B0.g.performClick();
        return true;
    }

    private final void w2(final C8967Xz7 c8967Xz7, final C12494ei4 c12494ei4) {
        C11056cf3 c11056cf3 = this.B0;
        c11056cf3.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gi4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16103ki4.y2(this.a, c8967Xz7, c12494ei4, view);
            }
        });
        c11056cf3.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hi4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16103ki4.x2(this.a, c8967Xz7, c12494ei4, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x2(C16103ki4 c16103ki4, C8967Xz7 c8967Xz7, C12494ei4 c12494ei4, View view) {
        AbstractC13042fc3.i(c16103ki4, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c12494ei4, "$document");
        InterfaceC22948w54 interfaceC22948w54B = c16103ki4.z0().b();
        Context context = c16103ki4.x0().getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        interfaceC22948w54B.c(context, c8967Xz7.j(), c12494ei4.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(C16103ki4 c16103ki4, C8967Xz7 c8967Xz7, C12494ei4 c12494ei4, View view) {
        AbstractC13042fc3.i(c16103ki4, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c12494ei4, "$document");
        c16103ki4.z0().d().d(c8967Xz7, c12494ei4);
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7
    protected T73 B0() {
        return this.D0;
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.A0;
    }

    @Override // ir.nasim.C19835r13
    protected AbstractC6981Pu5 E1(AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(cVar, "document");
        BubbleTextView bubbleTextView = J1().g;
        AbstractC13042fc3.h(bubbleTextView, "textViewProgress");
        return new C4736Gi4(bubbleTextView);
    }

    @Override // ir.nasim.C19835r13
    protected int N1() {
        return this.C0;
    }

    @Override // ir.nasim.C19835r13
    protected boolean Q1() {
        return false;
    }

    @Override // ir.nasim.C19835r13
    protected int R1(int i) {
        int iMin = Math.min(super.R1(i), (int) (J1().getRoot().getResources().getDisplayMetrics().widthPixels * 0.8d));
        this.C0 = iMin;
        return iMin;
    }

    @Override // ir.nasim.C19835r13, ir.nasim.O44
    public void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
    }

    @Override // ir.nasim.C19835r13
    protected void u1(XV4 xv4, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        int iR1 = R1(((Number) xv4.e()).intValue());
        int iIntValue = ((Number) xv4.f()).intValue();
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.MoneyRequest");
        t2(c8967Xz7, (C12494ei4) objF, AbstractC4616Fw7.a(Integer.valueOf(iR1), Integer.valueOf(iIntValue)));
        Z0();
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC12990fW7.c(view, this.B0.b.getText(), new InterfaceC10698c3() { // from class: ir.nasim.ii4
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C16103ki4.u2(this.a, view2, aVar);
            }
        });
        if (J0()) {
            AbstractC12990fW7.c(view, this.B0.g.getText(), new InterfaceC10698c3() { // from class: ir.nasim.ji4
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C16103ki4.v2(this.a, view2, aVar);
                }
            });
        }
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.C19835r13
    protected C22007uW1 y1(C8967Xz7 c8967Xz7, AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(cVar, "document");
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        return new C18467oi4(c14970in2D, cVar);
    }
}
