package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.fh1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13117fh1 extends OT4 {
    private final UA2 h;

    /* renamed from: ir.nasim.fh1$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C3512Be1 c3512Be1, C3512Be1 c3512Be12) {
            AbstractC13042fc3.i(c3512Be1, "oldItem");
            AbstractC13042fc3.i(c3512Be12, "newItem");
            return c3512Be1.r() == c3512Be12.r();
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C3512Be1 c3512Be1, C3512Be1 c3512Be12) {
            AbstractC13042fc3.i(c3512Be1, "oldItem");
            AbstractC13042fc3.i(c3512Be12, "newItem");
            return c3512Be1.r() == c3512Be12.r();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13117fh1(UA2 ua2) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(ua2, "onContactClick");
        this.h = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R(C13117fh1 c13117fh1, C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(c13117fh1, "this$0");
        AbstractC13042fc3.i(c3512Be1, "it");
        c13117fh1.h.invoke(c3512Be1);
        return C19938rB7.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C11869dh1 c11869dh1, int i) {
        AbstractC13042fc3.i(c11869dh1, "holder");
        c11869dh1.J0((C3512Be1) D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public C11869dh1 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C16854ly6 c16854ly6C = C16854ly6.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c16854ly6C, "inflate(...)");
        return new C11869dh1(c16854ly6C, new UA2() { // from class: ir.nasim.eh1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13117fh1.R(this.a, (C3512Be1) obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(C11869dh1 c11869dh1) {
        AbstractC13042fc3.i(c11869dh1, "holder");
        c11869dh1.a();
    }
}
