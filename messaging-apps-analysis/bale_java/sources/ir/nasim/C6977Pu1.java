package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C19835r13;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.M44;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.Pu1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6977Pu1 extends C19835r13 {
    private static final a F0 = new a(null);
    public static final int G0 = 8;
    private final ConstraintLayout A0;
    private final C8254Ve3 B0;
    private boolean C0;
    private int D0;
    private final T73 E0;

    /* renamed from: ir.nasim.Pu1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Pu1$b */
    public static final class b extends C19835r13.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C19835r13.b, ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C6977Pu1(c15481jf3, z, c());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6977Pu1(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
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
        this.E0 = new T73(messageReactionView, messageStateView, commentContainerView);
        C8254Ve3 c8254Ve3A = C8254Ve3.a(Q0(AbstractC12208eD5.item_chat_crowd_funding_bubble));
        MaterialButton materialButton = c8254Ve3A.c;
        materialButton.setTypeface(C6011Lu2.i());
        materialButton.setTextSize(C3335Al0.a.h());
        this.B0 = c8254Ve3A;
    }

    private final MaterialButton r2(final C8967Xz7 c8967Xz7, final C6244Mu1 c6244Mu1) {
        C8254Ve3 c8254Ve3 = this.B0;
        c8254Ve3.g.setProgress(c6244Mu1.d());
        c8254Ve3.b.r(c6244Mu1.a());
        c8254Ve3.h.r(c6244Mu1.e());
        c8254Ve3.i.r(c6244Mu1.f());
        View view = c8254Ve3.e;
        AbstractC13042fc3.h(view, "crowdFundingDividerProgress");
        BubbleTextView bubbleTextView = c8254Ve3.i;
        AbstractC13042fc3.h(bubbleTextView, "crowdFundingRemainingDetails");
        view.setVisibility(bubbleTextView.getVisibility() == 0 ? 0 : 8);
        v2(c6244Mu1);
        MaterialButton materialButton = c8254Ve3.c;
        AbstractC13042fc3.f(materialButton);
        w2(materialButton, c6244Mu1.g());
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ou1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C6977Pu1.s2(this.a, c8967Xz7, c6244Mu1, view2);
            }
        });
        AbstractC13042fc3.h(materialButton, "with(...)");
        return materialButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(C6977Pu1 c6977Pu1, C8967Xz7 c8967Xz7, C6244Mu1 c6244Mu1, View view) {
        AbstractC13042fc3.i(c6977Pu1, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c6244Mu1, "$document");
        c6977Pu1.z0().d().d(c8967Xz7, c6244Mu1);
    }

    private final void t2(C8967Xz7 c8967Xz7, C6244Mu1 c6244Mu1, XV4 xv4) {
        r2(c8967Xz7, c6244Mu1);
        v1(c8967Xz7, c6244Mu1.b(), xv4);
        MessageEmojiTextView messageEmojiTextView = x0().i;
        AbstractC13042fc3.f(messageEmojiTextView);
        ViewGroup.LayoutParams layoutParams = messageEmojiTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((Number) K1().e()).intValue() - AbstractC8943Xx1.c(16);
        messageEmojiTextView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u2(C6977Pu1 c6977Pu1, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c6977Pu1, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c6977Pu1.B0.c.performClick();
        return true;
    }

    private final void v2(C6244Mu1 c6244Mu1) {
        this.B0.b.setContentDescription(c6244Mu1.a());
        this.B0.h.setContentDescription(c6244Mu1.e());
        this.B0.i.setContentDescription(c6244Mu1.f());
    }

    private final void w2(MaterialButton materialButton, boolean z) {
        materialButton.setText((J0() && z) ? materialButton.getContext().getString(AbstractC12217eE5.crowd_funding_details_and_support) : materialButton.getContext().getString(AbstractC12217eE5.crowd_funding_view_details));
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7
    protected T73 B0() {
        return this.E0;
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
        return new C8896Xu1(bubbleTextView);
    }

    @Override // ir.nasim.C19835r13
    protected int N1() {
        return this.D0;
    }

    @Override // ir.nasim.C19835r13
    protected boolean Q1() {
        return false;
    }

    @Override // ir.nasim.C19835r13
    protected int R1(int i) {
        int iMin = Math.min(super.R1(i), (int) (this.B0.getRoot().getResources().getDisplayMetrics().widthPixels * 0.8d));
        this.D0 = iMin;
        return iMin;
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        this.C0 = false;
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
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.CrowdFunding");
        t2(c8967Xz7, (C6244Mu1) objF, AbstractC4616Fw7.a(Integer.valueOf(iR1), Integer.valueOf(iIntValue)));
        Z0();
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC12990fW7.c(view, this.B0.c.getText(), new InterfaceC10698c3() { // from class: ir.nasim.Nu1
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C6977Pu1.u2(this.a, view2, aVar);
            }
        });
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.C19835r13
    protected C22007uW1 y1(C8967Xz7 c8967Xz7, AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(cVar, "document");
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        return new C7221Qu1(c14970in2D, cVar);
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (!(n15 instanceof N15.h)) {
            super.z(n15);
        } else {
            N15.h hVar = (N15.h) n15;
            r2(hVar.c(), hVar.b());
        }
    }
}
