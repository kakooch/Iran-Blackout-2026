package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC13863gw6;
import ir.nasim.AbstractC19200pw6;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.lH5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16444lH5 extends AbstractC15063iw6 {
    public static final a w = new a(null);
    private final RH5 u;
    private final UA2 v;

    /* renamed from: ir.nasim.lH5$a */
    public static final class a {
        private a() {
        }

        public final C16444lH5 a(ViewGroup viewGroup, UA2 ua2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onItemClicked");
            RH5 rh5C = RH5.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(rh5C, "inflate(...)");
            return new C16444lH5(rh5C, ua2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C16444lH5(RH5 rh5, UA2 ua2, ED1 ed1) {
        this(rh5, ua2);
    }

    private final void J0(final AbstractC13863gw6.d dVar) {
        this.u.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kH5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16444lH5.L0(this.a, dVar, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(C16444lH5 c16444lH5, AbstractC13863gw6.d dVar, View view) {
        AbstractC13042fc3.i(c16444lH5, "this$0");
        AbstractC13042fc3.i(dVar, "$reactionItem");
        c16444lH5.v.invoke(dVar);
    }

    private final void M0(String str) {
        BubbleTextView bubbleTextView = this.u.b;
        bubbleTextView.setText(R62.V(str, bubbleTextView.getPaint().getFontMetricsInt(), false), TextView.BufferType.SPANNABLE);
    }

    private final void N0(boolean z) {
        this.u.c.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(RH5 rh5, View view) {
        AbstractC13042fc3.i(rh5, "$this_with");
        rh5.c.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P0(RH5 rh5, View view) {
        AbstractC13042fc3.i(rh5, "$this_with");
        rh5.c.callOnClick();
        return true;
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void C0(AbstractC13863gw6 abstractC13863gw6) {
        AbstractC13042fc3.i(abstractC13863gw6, "item");
        AbstractC13863gw6.d dVar = (AbstractC13863gw6.d) abstractC13863gw6;
        N0(dVar.i());
        M0(dVar.g());
        J0(dVar);
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void D0(AbstractC19200pw6 abstractC19200pw6) {
        AbstractC13042fc3.i(abstractC19200pw6, "payload");
        if (!(abstractC19200pw6 instanceof AbstractC19200pw6.a)) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC19200pw6.a aVar = (AbstractC19200pw6.a) abstractC19200pw6;
        N0(aVar.b());
        AbstractC13863gw6 abstractC13863gw6A = aVar.a();
        AbstractC13042fc3.g(abstractC13863gw6A, "null cannot be cast to non-null type ir.nasim.reactionsettings.model.SettingsItem.ReactionItem");
        J0((AbstractC13863gw6.d) abstractC13863gw6A);
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void a() {
        this.u.c.setChecked(false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C16444lH5(final RH5 rh5, UA2 ua2) {
        ConstraintLayout root = rh5.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.u = rh5;
        this.v = ua2;
        rh5.b.setTypeface(C6011Lu2.k());
        ConstraintLayout root2 = rh5.getRoot();
        root2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iH5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16444lH5.O0(rh5, view);
            }
        });
        root2.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.jH5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C16444lH5.P0(rh5, view);
            }
        });
    }
}
