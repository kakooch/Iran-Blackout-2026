package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.wQ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23141wQ3 extends AbstractC16640ld0 {
    public static final a w = new a(null);
    public static final int x = 8;
    private final C24461yf3 v;

    /* renamed from: ir.nasim.wQ3$a */
    public static final class a {
        private a() {
        }

        public final C23141wQ3 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C24461yf3 c24461yf3C = C24461yf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c24461yf3C, "inflate(...)");
            return new C23141wQ3(c24461yf3C, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C23141wQ3(C24461yf3 c24461yf3, ED1 ed1) {
        this(c24461yf3);
    }

    public final void D0(boolean z) {
        if (z) {
            this.v.b.setColorFilter(C5495Jo7.a.n0());
        } else {
            this.v.b.setColorFilter(C5495Jo7.a.m0());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C23141wQ3(C24461yf3 c24461yf3) {
        ConstraintLayout root = c24461yf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c24461yf3;
    }
}
