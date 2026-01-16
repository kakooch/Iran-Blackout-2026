package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C8563Wm6;
import ir.nasim.features.payment.data.model.SelectableOption;

/* renamed from: ir.nasim.Ym6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9104Ym6 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private final C8563Wm6.a u;
    private final C9856ag3 v;

    /* renamed from: ir.nasim.Ym6$a */
    public static final class a {
        private a() {
        }

        public final C9104Ym6 a(ViewGroup viewGroup, C8563Wm6.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_selectable_option, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C9104Ym6(viewInflate, aVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C9104Ym6(View view, C8563Wm6.a aVar, ED1 ed1) {
        this(view, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C9104Ym6 c9104Ym6, SelectableOption selectableOption, View view) {
        AbstractC13042fc3.i(c9104Ym6, "this$0");
        AbstractC13042fc3.i(selectableOption, "$item");
        C8563Wm6.a aVar = c9104Ym6.u;
        if (aVar != null) {
            aVar.a(selectableOption);
        }
    }

    public final void D0(final SelectableOption selectableOption) {
        AbstractC13042fc3.i(selectableOption, "item");
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Xm6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C9104Ym6.E0(this.a, selectableOption, view);
            }
        });
        this.v.b.setText(selectableOption.getTitle());
        this.v.b.setTextColor(C5495Jo7.a.g0());
        this.v.b.setTypeface(C6011Lu2.k());
    }

    private C9104Ym6(View view, C8563Wm6.a aVar) {
        super(view);
        this.u = aVar;
        C9856ag3 c9856ag3A = C9856ag3.a(view);
        AbstractC13042fc3.h(c9856ag3A, "bind(...)");
        this.v = c9856ag3A;
    }
}
