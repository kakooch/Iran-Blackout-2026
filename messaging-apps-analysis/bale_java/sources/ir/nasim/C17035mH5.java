package ir.nasim;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.mH5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17035mH5 extends androidx.recyclerview.widget.q {

    /* renamed from: ir.nasim.mH5$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(Drawable drawable, Drawable drawable2) {
            AbstractC13042fc3.i(drawable, "oldItem");
            AbstractC13042fc3.i(drawable2, "newItem");
            return drawable.getMinimumHeight() == drawable2.getMinimumHeight();
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(Drawable drawable, Drawable drawable2) {
            AbstractC13042fc3.i(drawable, "oldItem");
            AbstractC13042fc3.i(drawable2, "newItem");
            return AbstractC13042fc3.d(drawable, drawable2);
        }
    }

    /* renamed from: ir.nasim.mH5$b */
    public static final class b extends RecyclerView.C {
        private final View u;
        private final ImageView v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            AbstractC13042fc3.i(view, "img");
            this.u = view;
            View viewFindViewById = view.findViewById(AbstractC19354qC5.image);
            AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
            this.v = (ImageView) viewFindViewById;
        }

        public final void C0(Drawable drawable) {
            AbstractC13042fc3.i(drawable, "drawable");
            this.v.setImageDrawable(drawable);
        }
    }

    public C17035mH5() {
        super(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        AbstractC13042fc3.i(bVar, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        bVar.C0((Drawable) objA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(TC5.reaction_view_item, viewGroup, false);
        AbstractC13042fc3.f(viewInflate);
        return new b(viewInflate);
    }
}
