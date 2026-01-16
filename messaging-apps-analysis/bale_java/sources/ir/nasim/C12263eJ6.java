package ir.nasim;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C19835r13;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.eJ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12263eJ6 extends C19835r13 {
    private final ConstraintLayout A0;
    private C11861dg3 B0;
    private final C13490gJ6 C0;

    /* renamed from: ir.nasim.eJ6$a */
    public static final class a extends C19835r13.b {
        private final boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.c = z;
        }

        @Override // ir.nasim.C19835r13.b, ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C12263eJ6(c15481jf3, z, c());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12263eJ6(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
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
        this.C0 = new C13490gJ6(messageReactionView, messageStateView);
        C11861dg3 c11861dg3A = C11861dg3.a(Q0(AbstractC12208eD5.item_sponsored_bubble));
        c11861dg3A.b.setTextSize(C3335Al0.a.q());
        c11861dg3A.b.setTypeface(C6011Lu2.i());
        this.B0 = c11861dg3A;
    }

    private final void q2(C8967Xz7 c8967Xz7, final C10240bJ6 c10240bJ6, XV4 xv4) {
        String strC = c10240bJ6.c();
        if (strC != null && strC.length() != 0) {
            this.B0.b.setVisibility(0);
            String strD = c10240bJ6.d();
            if (strD == null || strD.length() == 0) {
                C11861dg3 c11861dg3 = this.B0;
                c11861dg3.b.setText(c11861dg3.getRoot().getContext().getString(AbstractC12217eE5.money_request_view_details));
            } else {
                this.B0.b.setText(c10240bJ6.d());
            }
            this.B0.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.dJ6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12263eJ6.r2(this.a, c10240bJ6, view);
                }
            });
        }
        AbstractC17757nW1.c cVarF = c10240bJ6.f();
        if (cVarF == null) {
            ConstraintLayout root = J1().getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            root.setVisibility(8);
        } else {
            v1(c8967Xz7, cVarF, xv4);
            ConstraintLayout root2 = J1().getRoot();
            AbstractC13042fc3.h(root2, "getRoot(...)");
            root2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(C12263eJ6 c12263eJ6, C10240bJ6 c10240bJ6, View view) {
        AbstractC13042fc3.i(c12263eJ6, "this$0");
        AbstractC13042fc3.i(c10240bJ6, "$sponsored");
        c12263eJ6.z0().b().f(c10240bJ6);
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.A0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7
    /* renamed from: s2, reason: merged with bridge method [inline-methods] */
    public C13490gJ6 B0() {
        return this.C0;
    }

    @Override // ir.nasim.C19835r13
    protected void u1(XV4 xv4, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        int iR1 = R1(((Number) xv4.e()).intValue());
        int iIntValue = ((Number) xv4.f()).intValue();
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Sponsored");
        q2(c8967Xz7, (C10240bJ6) objF, AbstractC4616Fw7.a(Integer.valueOf(iR1), Integer.valueOf(iIntValue)));
        Z0();
    }
}
