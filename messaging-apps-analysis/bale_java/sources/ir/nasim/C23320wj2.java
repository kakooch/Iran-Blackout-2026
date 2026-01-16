package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.wj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23320wj2 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private final C23910xj2 u;
    private final InterfaceC11890dj2 v;

    /* renamed from: ir.nasim.wj2$a */
    public static final class a {
        private a() {
        }

        public final C23320wj2 a(ViewGroup viewGroup, InterfaceC11890dj2 interfaceC11890dj2) {
            AbstractC13042fc3.i(viewGroup, "viewGroup");
            AbstractC13042fc3.i(interfaceC11890dj2, "feedHolderListener");
            C23910xj2 c23910xj2C = C23910xj2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c23910xj2C, "inflate(...)");
            return new C23320wj2(c23910xj2C, interfaceC11890dj2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23320wj2(C23910xj2 c23910xj2, InterfaceC11890dj2 interfaceC11890dj2) {
        super(c23910xj2.getRoot());
        AbstractC13042fc3.i(c23910xj2, "binding");
        AbstractC13042fc3.i(interfaceC11890dj2, "feedHolderListener");
        this.u = c23910xj2;
        this.v = interfaceC11890dj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C23320wj2 c23320wj2, C15759k74 c15759k74, View view) {
        AbstractC13042fc3.i(c23320wj2, "this$0");
        AbstractC13042fc3.i(c15759k74, "$messageReaction");
        c23320wj2.v.a(c15759k74.b(), c15759k74.c());
    }

    public final void D0(final C15759k74 c15759k74) {
        AbstractC13042fc3.i(c15759k74, "messageReaction");
        this.u.c.setImageDrawable(R62.A(c15759k74.b()));
        this.u.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vj2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23320wj2.E0(this.a, c15759k74, view);
            }
        });
        if (c15759k74.c()) {
            this.u.getRoot().setBackgroundResource(AbstractC18163oB5.feed_reaction_background_selected);
        } else {
            this.u.getRoot().setBackgroundResource(AbstractC18163oB5.feed_reaction_background);
        }
        if (c15759k74.a() <= 0) {
            TextView textView = this.u.b;
            AbstractC13042fc3.h(textView, "reactionCountTv");
            textView.setVisibility(8);
        } else {
            String strG = AbstractC20655sN7.g(c15759k74.a());
            TextView textView2 = this.u.b;
            AbstractC13042fc3.h(textView2, "reactionCountTv");
            textView2.setVisibility(0);
            this.u.b.setText(strG);
        }
    }
}
