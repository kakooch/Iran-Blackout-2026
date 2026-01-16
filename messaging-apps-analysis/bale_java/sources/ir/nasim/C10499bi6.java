package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C9059Yh6;
import ir.nasim.C9293Zh6;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.market.model.SearchSuggestionRow;

/* renamed from: ir.nasim.bi6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10499bi6 extends AbstractC16640ld0 implements C9059Yh6.a {
    public static final a B = new a(null);
    public static final int D = 8;
    private boolean A;
    private final C8763Xf3 v;
    private final C9293Zh6.a w;
    private C9059Yh6.a x;
    private final C9059Yh6.b y;
    private final C9059Yh6 z;

    /* renamed from: ir.nasim.bi6$a */
    public static final class a {
        private a() {
        }

        private final void b(C8763Xf3 c8763Xf3) {
            c8763Xf3.e.setTypeface(C6011Lu2.k());
            c8763Xf3.b.setTypeface(C6011Lu2.k());
        }

        public final C10499bi6 a(ViewGroup viewGroup, C9293Zh6.a aVar, C9059Yh6.a aVar2, C9059Yh6.b bVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C8763Xf3 c8763Xf3C = C8763Xf3.c(LayoutInflater.from(new C16731lm1(viewGroup.getContext(), AbstractC17008mE5.Theme_Bale_Base)), viewGroup, false);
            AbstractC13042fc3.h(c8763Xf3C, "inflate(...)");
            b(c8763Xf3C);
            return new C10499bi6(c8763Xf3C, aVar, aVar2, bVar);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C10499bi6(C8763Xf3 c8763Xf3, C9293Zh6.a aVar, C9059Yh6.a aVar2, C9059Yh6.b bVar) {
        AbstractC13042fc3.i(c8763Xf3, "binding");
        LinearLayout root = c8763Xf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c8763Xf3;
        this.w = aVar;
        this.x = aVar2;
        this.y = bVar;
        this.z = new C9059Yh6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C10499bi6 c10499bi6, SearchSuggestionRow searchSuggestionRow, View view) {
        AbstractC13042fc3.i(c10499bi6, "this$0");
        AbstractC13042fc3.i(searchSuggestionRow, "$item");
        C9293Zh6.a aVar = c10499bi6.w;
        if (aVar != null) {
            aVar.n5(searchSuggestionRow);
        }
    }

    private final void H0(SearchSuggestionRow searchSuggestionRow) {
        this.v.d.setAdapter(this.z);
        this.z.D(this);
        this.z.C(this.y);
        if (!this.A) {
            this.A = true;
            while (this.v.d.getItemDecorationCount() > 0) {
                this.v.d.removeItemDecorationAt(0);
            }
            RecyclerView recyclerView = this.v.d;
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            recyclerView.addItemDecoration(new C22527vO3(aVar.f(8.0f), aVar.f(8.0f), aVar.f(4.0f), aVar.f(4.0f), aVar.f(4.0f)));
        }
        this.z.z().clear();
        this.z.z().addAll(searchSuggestionRow.getItems());
        C9059Yh6 c9059Yh6 = this.z;
        c9059Yh6.notifyItemRangeInserted(0, c9059Yh6.z().size());
    }

    public final void E0(final SearchSuggestionRow searchSuggestionRow) {
        AbstractC13042fc3.i(searchSuggestionRow, "item");
        this.v.e.setText(searchSuggestionRow.getTitle());
        this.v.b.setVisibility(searchSuggestionRow.getShouldShowDeleteAction() ? 0 : 8);
        this.v.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ai6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C10499bi6.F0(this.a, searchSuggestionRow, view);
            }
        });
        H0(searchSuggestionRow);
    }

    @Override // ir.nasim.C9059Yh6.a
    public void k5(SearchSuggestion searchSuggestion) {
        AbstractC13042fc3.i(searchSuggestion, "item");
        C9059Yh6.a aVar = this.x;
        if (aVar != null) {
            aVar.k5(searchSuggestion);
        }
    }
}
