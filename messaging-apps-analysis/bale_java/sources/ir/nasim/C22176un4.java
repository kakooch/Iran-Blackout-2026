package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.un4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22176un4 extends OT4 {
    private final UA2 h;

    /* renamed from: ir.nasim.un4$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C21586tn4 c21586tn4, C21586tn4 c21586tn42) {
            AbstractC13042fc3.i(c21586tn4, "oldItem");
            AbstractC13042fc3.i(c21586tn42, "newItem");
            return AbstractC13042fc3.d(c21586tn4.c(), c21586tn42.c());
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C21586tn4 c21586tn4, C21586tn4 c21586tn42) {
            AbstractC13042fc3.i(c21586tn4, "oldItem");
            AbstractC13042fc3.i(c21586tn42, "newItem");
            return c21586tn4.b() == c21586tn42.b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22176un4(UA2 ua2) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(ua2, "onclick");
        this.h = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C25136zn4 c25136zn4, int i) {
        AbstractC13042fc3.i(c25136zn4, "holder");
        c25136zn4.E0((C21586tn4) D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C25136zn4 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C22766vn4 c22766vn4C = C22766vn4.c(LayoutInflater.from(viewGroup.getContext()));
        AbstractC13042fc3.h(c22766vn4C, "inflate(...)");
        return new C25136zn4(c22766vn4C, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(C25136zn4 c25136zn4) {
        AbstractC13042fc3.i(c25136zn4, "holder");
        c25136zn4.a();
    }
}
