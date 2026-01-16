package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C22698vg6;

/* renamed from: ir.nasim.mh6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17277mh6 extends AbstractC16640ld0 {
    public static final a v = new a(null);

    /* renamed from: ir.nasim.mh6$a */
    public static final class a {
        private a() {
        }

        public final C17277mh6 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C7793Tf3 c7793Tf3C = C7793Tf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c7793Tf3C, "inflate(...)");
            return new C17277mh6(c7793Tf3C, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C17277mh6(C7793Tf3 c7793Tf3, ED1 ed1) {
        this(c7793Tf3);
    }

    public final void D0(C22698vg6.c cVar) {
        AbstractC13042fc3.i(cVar, "peer");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C17277mh6(C7793Tf3 c7793Tf3) {
        ConstraintLayout constraintLayout = c7793Tf3.e;
        AbstractC13042fc3.h(constraintLayout, "root");
        super(constraintLayout);
    }
}
