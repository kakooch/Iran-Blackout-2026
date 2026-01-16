package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.uX6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22021uX6 extends OT4 {
    private final UA2 h;

    /* renamed from: ir.nasim.uX6$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C20744sX6 c20744sX6, C20744sX6 c20744sX62) {
            AbstractC13042fc3.i(c20744sX6, "oldItem");
            AbstractC13042fc3.i(c20744sX62, "newItem");
            return AbstractC13042fc3.d(c20744sX6, c20744sX62);
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C20744sX6 c20744sX6, C20744sX6 c20744sX62) {
            AbstractC13042fc3.i(c20744sX6, "oldItem");
            AbstractC13042fc3.i(c20744sX62, "newItem");
            return c20744sX6.c() == c20744sX62.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22021uX6(UA2 ua2) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(ua2, "itemClick");
        this.h = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C20135rX6 c20135rX6, int i) {
        AbstractC13042fc3.i(c20135rX6, "holder");
        Object objD = D(i);
        AbstractC13042fc3.f(objD);
        c20135rX6.H0((C20744sX6) objD, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C20135rX6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(RC5.view_holder_story_viewer, viewGroup, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return new C20135rX6(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C20135rX6 c20135rX6) {
        AbstractC13042fc3.i(c20135rX6, "holder");
        super.onViewRecycled(c20135rX6);
        c20135rX6.a();
    }
}
