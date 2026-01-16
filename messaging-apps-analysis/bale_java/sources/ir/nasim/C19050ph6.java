package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.nasim.C13122fh6;
import ir.nasim.C22698vg6;

/* renamed from: ir.nasim.ph6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19050ph6 extends AbstractC16640ld0 {
    public static final a x = new a(null);
    public static final int y = 8;
    private final C8497Wf3 v;
    private final C13122fh6.d w;

    /* renamed from: ir.nasim.ph6$a */
    public static final class a {
        private a() {
        }

        public final C19050ph6 a(ViewGroup viewGroup, C13122fh6.d dVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C8497Wf3 c8497Wf3C = C8497Wf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c8497Wf3C, "inflate(...)");
            return new C19050ph6(c8497Wf3C, dVar);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C19050ph6(C8497Wf3 c8497Wf3, C13122fh6.d dVar) {
        AbstractC13042fc3.i(c8497Wf3, "binding");
        LinearLayout linearLayout = c8497Wf3.b;
        AbstractC13042fc3.h(linearLayout, "root");
        super(linearLayout);
        this.v = c8497Wf3;
        this.w = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C19050ph6 c19050ph6, C22698vg6.d dVar, View view) {
        AbstractC13042fc3.i(c19050ph6, "this$0");
        AbstractC13042fc3.i(dVar, "$item");
        C13122fh6.d dVar2 = c19050ph6.w;
        if (dVar2 != null) {
            dVar2.r2(dVar);
        }
    }

    public final void E0(final C22698vg6.d dVar) {
        AbstractC13042fc3.i(dVar, "item");
        this.v.b.setOnClickListener(new View.OnClickListener(dVar) { // from class: ir.nasim.oh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19050ph6.F0(this.a, null, view);
            }
        });
    }
}
