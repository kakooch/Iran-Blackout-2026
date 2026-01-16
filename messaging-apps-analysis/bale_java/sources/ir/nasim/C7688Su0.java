package ir.nasim;

import android.graphics.Rect;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.X2;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.Su0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7688Su0 implements InterfaceC20284rl0 {
    private final C7784Te3 a;
    private AbstractC23538x54 b;
    private final ConstraintLayout c;
    private final C25112zl0 d;

    /* renamed from: ir.nasim.Su0$a */
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
            viewStub.setLayoutResource(AbstractC12208eD5.item_chat_call_bubble);
            C7784Te3 c7784Te3A = C7784Te3.a(viewStub.inflate());
            AbstractC13042fc3.h(c7784Te3A, "bind(...)");
            return new C7688Su0(c7784Te3A, this.a, this.b, null);
        }
    }

    public /* synthetic */ C7688Su0(C7784Te3 c7784Te3, boolean z, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c7784Te3, z, abstractC23538x54);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(C7688Su0 c7688Su0, C8967Xz7 c8967Xz7, AbstractC10613bu0 abstractC10613bu0) {
        AbstractC13042fc3.i(c7688Su0, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(abstractC10613bu0, "$call");
        c7688Su0.b.d().d(c8967Xz7, abstractC10613bu0);
        return C19938rB7.a;
    }

    private final void p(String str) {
        this.a.b.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(C7688Su0 c7688Su0, View view, C8967Xz7 c8967Xz7, View view2, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c7688Su0, "this$0");
        AbstractC13042fc3.i(view, "$accessibleView");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view2, "<unused var>");
        c7688Su0.b.b().e(view, c8967Xz7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(C7688Su0 c7688Su0, View view, C8967Xz7 c8967Xz7, View view2, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c7688Su0, "this$0");
        AbstractC13042fc3.i(view, "$accessibleView");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view2, "<unused var>");
        c7688Su0.b.b().e(view, c8967Xz7);
        return true;
    }

    private final void x(boolean z) {
        ConstraintLayout constraintLayout = this.a.b;
        if (z) {
            constraintLayout.setBackgroundResource(KB5.bubble_in);
        } else {
            constraintLayout.setBackgroundResource(KB5.bubble_out);
        }
    }

    private final void y() {
        C7784Te3 c7784Te3 = this.a;
        MessageEmojiTextView messageEmojiTextView = c7784Te3.e;
        messageEmojiTextView.setTextSize(C3335Al0.a.e());
        messageEmojiTextView.setMovementMethod(LinkMovementMethod.getInstance());
        c7784Te3.c.setTypeface(C6011Lu2.k());
    }

    @Override // ir.nasim.InterfaceC7879To6
    public Rect l() {
        return this.d.a();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void o(final C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        C7784Te3 c7784Te3 = this.a;
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Call");
        final AbstractC10613bu0 abstractC10613bu0 = (AbstractC10613bu0) objF;
        c7784Te3.e.r(abstractC10613bu0.b());
        c7784Te3.d.r(c8967Xz7.r());
        c7784Te3.c.r(abstractC10613bu0.a());
        p(((Object) abstractC10613bu0.b()) + c8967Xz7.e());
        Spannable spannableB = abstractC10613bu0.b();
        for (Object obj : spannableB.getSpans(0, spannableB.length(), C11376cu0.class)) {
            ((C11376cu0) obj).a(new SA2() { // from class: ir.nasim.Pu0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C7688Su0.m(this.a, c8967Xz7, abstractC10613bu0);
                }
            });
        }
    }

    @Override // ir.nasim.InterfaceC20284rl0
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout d() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void w(final View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC12990fW7.l0(view, X2.a.i, view.getContext().getString(AbstractC12217eE5.message_options_activate), new InterfaceC10698c3() { // from class: ir.nasim.Qu0
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C7688Su0.r(this.a, view, c8967Xz7, view2, aVar);
            }
        });
        AbstractC12990fW7.c(view, this.a.getRoot().getContext().getString(AbstractC12217eE5.message_options_context_menu), new InterfaceC10698c3() { // from class: ir.nasim.Ru0
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C7688Su0.s(this.a, view, c8967Xz7, view2, aVar);
            }
        });
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
    }

    private C7688Su0(C7784Te3 c7784Te3, boolean z, AbstractC23538x54 abstractC23538x54) {
        this.a = c7784Te3;
        this.b = abstractC23538x54;
        ConstraintLayout constraintLayout = c7784Te3.b;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.c = constraintLayout;
        ConstraintLayout root = c7784Te3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        this.d = new C25112zl0(root);
        x(z);
        y();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void a() {
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void i() {
    }
}
