package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C10489bh6;

/* renamed from: ir.nasim.nh6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17868nh6 extends AbstractC16640ld0 {
    public static final a v = new a(null);

    /* renamed from: ir.nasim.nh6$a */
    public static final class a {
        private a() {
        }

        public final C17868nh6 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C8263Vf3 c8263Vf3C = C8263Vf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c8263Vf3C, "inflate(...)");
            return new C17868nh6(c8263Vf3C, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C17868nh6(C8263Vf3 c8263Vf3, ED1 ed1) {
        this(c8263Vf3);
    }

    public final void D0(C10489bh6.c cVar) {
        AbstractC13042fc3.i(cVar, "peer");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C17868nh6(C8263Vf3 c8263Vf3) {
        ConstraintLayout constraintLayout = c8263Vf3.e;
        AbstractC13042fc3.h(constraintLayout, "root");
        super(constraintLayout);
    }
}
