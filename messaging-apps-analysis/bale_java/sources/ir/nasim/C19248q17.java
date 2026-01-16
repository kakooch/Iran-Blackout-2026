package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.q17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19248q17 extends OT4 {
    public static final b h = new b(null);
    private static final i.f i = new a();

    /* renamed from: ir.nasim.q17$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C17637nI7 c17637nI7, C17637nI7 c17637nI72) {
            AbstractC13042fc3.i(c17637nI7, "oldItem");
            AbstractC13042fc3.i(c17637nI72, "newItem");
            return c17637nI7.n0() == c17637nI7.n0();
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C17637nI7 c17637nI7, C17637nI7 c17637nI72) {
            AbstractC13042fc3.i(c17637nI7, "oldItem");
            AbstractC13042fc3.i(c17637nI72, "newItem");
            return c17637nI7.n0() == c17637nI7.n0();
        }
    }

    /* renamed from: ir.nasim.q17$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public C19248q17() {
        super(i, null, null, 6, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C18066o17 c18066o17, int i2) {
        AbstractC13042fc3.i(c18066o17, "holder");
        C17637nI7 c17637nI7 = (C17637nI7) D(i2);
        if (c17637nI7 == null) {
            return;
        }
        c18066o17.C0(c17637nI7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C18066o17 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C18066o17.v.a(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C18066o17 c18066o17) {
        AbstractC13042fc3.i(c18066o17, "holder");
        super.onViewRecycled(c18066o17);
        c18066o17.a();
    }
}
