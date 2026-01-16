package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.mJ5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17053mJ5 extends OT4 {
    private final UA2 h;

    /* renamed from: ir.nasim.mJ5$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C16462lJ5 c16462lJ5, C16462lJ5 c16462lJ52) {
            AbstractC13042fc3.i(c16462lJ5, "oldItem");
            AbstractC13042fc3.i(c16462lJ52, "newItem");
            return AbstractC13042fc3.d(c16462lJ5, c16462lJ52);
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C16462lJ5 c16462lJ5, C16462lJ5 c16462lJ52) {
            AbstractC13042fc3.i(c16462lJ5, "oldItem");
            AbstractC13042fc3.i(c16462lJ52, "newItem");
            return c16462lJ5.d() == c16462lJ52.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17053mJ5(UA2 ua2) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(ua2, "onItemClick");
        this.h = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AJ5 aj5, int i) {
        AbstractC13042fc3.i(aj5, "holder");
        aj5.L0((C16462lJ5) D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public AJ5 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        return new AJ5(composeView, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(AJ5 aj5) {
        AbstractC13042fc3.i(aj5, "holder");
        aj5.a();
    }
}
