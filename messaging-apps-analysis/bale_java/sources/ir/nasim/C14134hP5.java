package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.hP5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14134hP5 extends androidx.recyclerview.widget.q {
    private static final b g = new b(null);
    private static final i.f h = new a();
    private final UA2 f;

    /* renamed from: ir.nasim.hP5$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C21948uP5 c21948uP5, C21948uP5 c21948uP52) {
            AbstractC13042fc3.i(c21948uP5, "oldItem");
            AbstractC13042fc3.i(c21948uP52, "newItem");
            return AbstractC13042fc3.d(c21948uP5, c21948uP52);
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C21948uP5 c21948uP5, C21948uP5 c21948uP52) {
            AbstractC13042fc3.i(c21948uP5, "oldItem");
            AbstractC13042fc3.i(c21948uP52, "newItem");
            return c21948uP5.c() == c21948uP52.c();
        }
    }

    /* renamed from: ir.nasim.hP5$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14134hP5(UA2 ua2) {
        super(h);
        AbstractC13042fc3.i(ua2, "onItemClicked");
        this.f = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C23134wP5 c23134wP5, int i) {
        AbstractC13042fc3.i(c23134wP5, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        c23134wP5.D0((C21948uP5) objA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C23134wP5 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C23134wP5.w.a(viewGroup, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C23134wP5 c23134wP5) {
        AbstractC13042fc3.i(c23134wP5, "holder");
        c23134wP5.a();
        super.onViewRecycled(c23134wP5);
    }
}
