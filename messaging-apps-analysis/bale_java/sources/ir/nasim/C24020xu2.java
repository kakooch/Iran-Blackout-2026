package ir.nasim;

import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C20882sl7;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.xu2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24020xu2 extends C20882sl7 {
    private final ConstraintLayout r;
    private final T73 s;

    /* renamed from: ir.nasim.xu2$a */
    public static class a extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C24020xu2(c15481jf3, z, c(), null);
        }
    }

    public /* synthetic */ C24020xu2(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c15481jf3, z, abstractC23538x54);
    }

    @Override // ir.nasim.C20882sl7
    protected T73 B0() {
        return this.s;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    private C24020xu2(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        this.s = new T73(messageReactionView, messageStateView, null, 4, null);
    }
}
