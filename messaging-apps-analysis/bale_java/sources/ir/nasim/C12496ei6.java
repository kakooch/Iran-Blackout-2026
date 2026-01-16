package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.C9059Yh6;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ei6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12496ei6 extends AbstractC16640ld0 {
    public static final a y = new a(null);
    public static final int z = 8;
    private final C9038Yf3 v;
    private final C9059Yh6.a w;
    private final C9059Yh6.b x;

    /* renamed from: ir.nasim.ei6$a */
    public static final class a {
        private a() {
        }

        private final void b(C9038Yf3 c9038Yf3) {
            c9038Yf3.e.setTypeface(C6011Lu2.k());
            c9038Yf3.c.setVisibility(0);
        }

        public final C12496ei6 a(ViewGroup viewGroup, C9059Yh6.a aVar, C9059Yh6.b bVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C9038Yf3 c9038Yf3C = C9038Yf3.c(LayoutInflater.from(new C16731lm1(viewGroup.getContext(), AbstractC17008mE5.Theme_Bale_Base)), viewGroup, false);
            AbstractC13042fc3.h(c9038Yf3C, "inflate(...)");
            b(c9038Yf3C);
            return new C12496ei6(c9038Yf3C, aVar, bVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ei6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SearchSuggestion.a.values().length];
            try {
                iArr[SearchSuggestion.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SearchSuggestion.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ C12496ei6(C9038Yf3 c9038Yf3, C9059Yh6.a aVar, C9059Yh6.b bVar, ED1 ed1) {
        this(c9038Yf3, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C12496ei6 c12496ei6, SearchSuggestion searchSuggestion, View view) {
        AbstractC13042fc3.i(c12496ei6, "this$0");
        AbstractC13042fc3.i(searchSuggestion, "$item");
        C9059Yh6.a aVar = c12496ei6.w;
        if (aVar != null) {
            aVar.k5(searchSuggestion);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(C12496ei6 c12496ei6, SearchSuggestion searchSuggestion, View view) {
        AbstractC13042fc3.i(c12496ei6, "this$0");
        AbstractC13042fc3.i(searchSuggestion, "$item");
        C9059Yh6.b bVar = c12496ei6.x;
        if (bVar != null) {
            bVar.i1(searchSuggestion);
        }
    }

    public final void F0(final SearchSuggestion searchSuggestion) {
        AbstractC13042fc3.i(searchSuggestion, "item");
        SearchSuggestion.a action = searchSuggestion.getAction();
        int i = action == null ? -1 : b.a[action.ordinal()];
        if (i == -1 || i == 1) {
            this.v.e.setText(searchSuggestion.getTerm());
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            SearchSuggestion.Peer peer = searchSuggestion.getPeer();
            if (peer != null) {
                this.v.e.setText(peer.getTitle());
            }
        }
        if (searchSuggestion.isWithDrawable()) {
            ImageView imageView = this.v.d;
            Context contextC0 = C0();
            MarketSection.Companion companion = MarketSection.INSTANCE;
            String drawable = searchSuggestion.getDrawable();
            AbstractC13042fc3.f(drawable);
            imageView.setImageDrawable(AbstractC4043Dl1.f(contextC0, companion.d(drawable)));
            this.v.d.setVisibility(0);
        } else {
            this.v.d.setVisibility(8);
        }
        this.v.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ci6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12496ei6.H0(this.a, searchSuggestion, view);
            }
        });
        this.v.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.di6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12496ei6.J0(this.a, searchSuggestion, view);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C12496ei6(C9038Yf3 c9038Yf3, C9059Yh6.a aVar, C9059Yh6.b bVar) {
        FrameLayout root = c9038Yf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c9038Yf3;
        this.w = aVar;
        this.x = bVar;
    }
}
