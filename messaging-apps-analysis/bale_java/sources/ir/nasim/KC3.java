package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C19835r13;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* loaded from: classes5.dex */
public final class KC3 extends C19835r13 {
    private final MessageStateView A0;

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
            return new KC3(c15481jf3, z, c());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KC3(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        AbstractC13042fc3.i(c15481jf3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        MessageStateView messageStateView = J1().f;
        messageStateView.setTextAppearance(messageStateView.getContext(), AbstractC17008mE5.TextAppearance_Bale_LabelMedium_1_12_Regular);
        Context context = messageStateView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        messageStateView.setTextColor(OY0.b(context, AbstractC15199jA5.colorOnPrimary));
        messageStateView.setMaxLines(1);
        Context context2 = c15481jf3.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        this.A0 = u2(context2);
    }

    private final void s2(C8967Xz7 c8967Xz7, C19943rC3 c19943rC3, XV4 xv4) {
        t2(c19943rC3);
        v1(c8967Xz7, c19943rC3.a(), xv4);
        v2(c8967Xz7, c19943rC3);
    }

    private final void t2(C19943rC3 c19943rC3) {
        J1().b.c(Integer.valueOf(AbstractC24188yB5.live));
        z2(c19943rC3.d(), c19943rC3.c());
    }

    private final MessageStateView u2(Context context) throws Resources.NotFoundException {
        MessageStateView messageStateView = new MessageStateView(context, null, 0, 6, null);
        messageStateView.setIncludeFontPadding(false);
        messageStateView.setTextAlignment(4);
        messageStateView.setTextAppearance(context, AbstractC23035wE5.TextAppearance_Bale_LabelMedium_1_12_Regular);
        messageStateView.setTextColor(OY0.b(context, AbstractC15199jA5.colorOnPrimary));
        messageStateView.setTextDirection(3);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(XA5.spacing_4);
        layoutParams.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        int i = BC5.imageView;
        layoutParams.h = i;
        layoutParams.s = i;
        messageStateView.setLayoutParams(layoutParams);
        J1().getRoot().addView(messageStateView);
        return messageStateView;
    }

    private final void v2(final C8967Xz7 c8967Xz7, final C19943rC3 c19943rC3) {
        x0().getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.HC3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KC3.w2(this.a, view);
            }
        });
        J1().b.setOnClickListener(new UA2() { // from class: ir.nasim.IC3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return KC3.x2(this.a, (DocumentStateButton.a) obj);
            }
        });
        M1().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JC3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KC3.y2(this.a, c8967Xz7, c19943rC3, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(KC3 kc3, View view) {
        AbstractC13042fc3.i(kc3, "this$0");
        kc3.M1().performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x2(KC3 kc3, DocumentStateButton.a aVar) {
        AbstractC13042fc3.i(kc3, "this$0");
        AbstractC13042fc3.i(aVar, "it");
        kc3.M1().performClick();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(KC3 kc3, C8967Xz7 c8967Xz7, C19943rC3 c19943rC3, View view) {
        AbstractC13042fc3.i(kc3, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c19943rC3, "$live");
        kc3.z0().d().d(c8967Xz7, c19943rC3);
    }

    private final void z2(Spannable spannable, Spannable spannable2) {
        C9263Ze3 c9263Ze3J1 = J1();
        this.A0.r(spannable2);
        c9263Ze3J1.f.r(spannable);
    }

    @Override // ir.nasim.C19835r13
    protected boolean Q1() {
        return false;
    }

    @Override // ir.nasim.C19835r13
    protected void U1(AbstractC17757nW1.c cVar, C22007uW1 c22007uW1) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(c22007uW1, "documentBinder");
        AbstractC17168mW3 abstractC17168mW3L1 = L1();
        if (abstractC17168mW3L1 != null) {
            c22007uW1.I(abstractC17168mW3L1);
        }
        AbstractC4767Gm.a(c22007uW1, cVar.b(), G0(), cVar.c());
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7
    public void t0(Spannable spannable) {
        AbstractC13042fc3.i(spannable, "state");
        x0().l.r(spannable);
    }

    @Override // ir.nasim.C19835r13
    protected void u1(XV4 xv4, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        z0().f().a(c8967Xz7);
        int iR1 = R1(((Number) xv4.e()).intValue());
        int iIntValue = ((Number) xv4.f()).intValue();
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Live");
        s2(c8967Xz7, (C19943rC3) objF, AbstractC4616Fw7.a(Integer.valueOf(iR1), Integer.valueOf(iIntValue)));
        Z0();
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (!(n15 instanceof N15.m)) {
            super.z(n15);
        } else {
            N15.m mVar = (N15.m) n15;
            z2(mVar.c(), mVar.b());
        }
    }
}
