package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13863gw6;
import ir.nasim.AbstractC19200pw6;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class AL4 extends AbstractC15063iw6 {
    public static final a w = new a(null);
    private final QH5 u;
    private final UA2 v;

    public static final class a {
        private a() {
        }

        public final AL4 a(ViewGroup viewGroup, UA2 ua2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onItemClicked");
            QH5 qh5C = QH5.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(qh5C, "inflate(...)");
            return new AL4(qh5C, ua2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ AL4(QH5 qh5, UA2 ua2, ED1 ed1) {
        this(qh5, ua2);
    }

    private final void J0(final AbstractC13863gw6.c cVar) {
        this.u.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xL4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AL4.L0(this.a, cVar, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(AL4 al4, AbstractC13863gw6.c cVar, View view) {
        AbstractC13042fc3.i(al4, "this$0");
        AbstractC13042fc3.i(cVar, "$option");
        al4.v.invoke(cVar);
    }

    private final void M0(boolean z) {
        this.u.b.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(QH5 qh5, View view) {
        AbstractC13042fc3.i(qh5, "$this_with");
        qh5.b.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O0(QH5 qh5, View view) {
        AbstractC13042fc3.i(qh5, "$this_with");
        qh5.b.callOnClick();
        return true;
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void C0(AbstractC13863gw6 abstractC13863gw6) {
        AbstractC13042fc3.i(abstractC13863gw6, "item");
        AbstractC13863gw6.c cVar = (AbstractC13863gw6.c) abstractC13863gw6;
        this.u.b.setText(cVar.h());
        M0(cVar.i());
        J0(cVar);
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void D0(AbstractC19200pw6 abstractC19200pw6) {
        AbstractC13042fc3.i(abstractC19200pw6, "payload");
        if (!(abstractC19200pw6 instanceof AbstractC19200pw6.a)) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC19200pw6.a aVar = (AbstractC19200pw6.a) abstractC19200pw6;
        M0(aVar.b());
        AbstractC13863gw6 abstractC13863gw6A = aVar.a();
        AbstractC13042fc3.g(abstractC13863gw6A, "null cannot be cast to non-null type ir.nasim.reactionsettings.model.SettingsItem.Option");
        J0((AbstractC13863gw6.c) abstractC13863gw6A);
    }

    @Override // ir.nasim.AbstractC15063iw6
    public void a() {
        this.u.b.setChecked(false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private AL4(final QH5 qh5, UA2 ua2) {
        FrameLayout root = qh5.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.u = qh5;
        this.v = ua2;
        qh5.b.setTypeface(C6011Lu2.i());
        FrameLayout root2 = qh5.getRoot();
        root2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yL4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AL4.N0(qh5, view);
            }
        });
        root2.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.zL4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AL4.O0(qh5, view);
            }
        });
    }
}
