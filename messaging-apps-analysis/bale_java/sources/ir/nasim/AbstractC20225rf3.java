package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.rf3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC20225rf3 extends RecyclerView.C {
    private final /* synthetic */ UW7 u;
    private Object v;

    public /* synthetic */ AbstractC20225rf3(View view, InterfaceC22483vJ4 interfaceC22483vJ4, UW7 uw7, int i, ED1 ed1) {
        this(view, interfaceC22483vJ4, (i & 4) != 0 ? new UW7() : uw7);
    }

    private final void M0(View view, final InterfaceC22483vJ4 interfaceC22483vJ4) {
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pf3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AbstractC20225rf3.N0(this.a, interfaceC22483vJ4, view2);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.qf3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return AbstractC20225rf3.O0(this.a, interfaceC22483vJ4, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(AbstractC20225rf3 abstractC20225rf3, InterfaceC22483vJ4 interfaceC22483vJ4, View view) {
        AbstractC13042fc3.i(abstractC20225rf3, "this$0");
        AbstractC13042fc3.i(interfaceC22483vJ4, "$listener");
        Object obj = abstractC20225rf3.v;
        if (obj != null) {
            interfaceC22483vJ4.e(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O0(AbstractC20225rf3 abstractC20225rf3, InterfaceC22483vJ4 interfaceC22483vJ4, View view) {
        AbstractC13042fc3.i(abstractC20225rf3, "this$0");
        AbstractC13042fc3.i(interfaceC22483vJ4, "$listener");
        Object obj = abstractC20225rf3.v;
        if (obj != null) {
            return interfaceC22483vJ4.v(obj);
        }
        return false;
    }

    public final void E0(Object obj) {
        AbstractC13042fc3.i(obj, "item");
        a();
        H0(obj);
        this.v = obj;
    }

    protected final Object F0() {
        return this.v;
    }

    protected abstract void H0(Object obj);

    public void J0() {
        this.u.a();
    }

    public void L0() {
        this.u.b();
    }

    public abstract void a();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC20225rf3(View view, InterfaceC22483vJ4 interfaceC22483vJ4, UW7 uw7) {
        super(view);
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(uw7, "viewLifecycleHolder");
        this.u = uw7;
        if (interfaceC22483vJ4 != null) {
            M0(view, interfaceC22483vJ4);
        }
    }
}
