package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C10489bh6;
import ir.nasim.C13122fh6;

/* renamed from: ir.nasim.kh6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16095kh6 extends AbstractC16640ld0 {
    public static final a y = new a(null);
    public static final int z = 8;
    private final C8029Uf3 v;
    private final C13122fh6.c w;
    private InterfaceC7857Tm2 x;

    /* renamed from: ir.nasim.kh6$a */
    public static final class a {
        private a() {
        }

        public final C16095kh6 a(ViewGroup viewGroup, C13122fh6.c cVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C8029Uf3 c8029Uf3C = C8029Uf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c8029Uf3C, "inflate(...)");
            return new C16095kh6(c8029Uf3C, cVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kh6$b */
    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            QI2 qi2 = QI2.a;
            ImageView imageView = C16095kh6.this.v.c;
            AbstractC13042fc3.h(imageView, "image");
            qi2.a(imageView);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2 qi2 = QI2.a;
            ImageView imageView = C16095kh6.this.v.c;
            AbstractC13042fc3.h(imageView, "image");
            qi2.m(imageView, interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            QI2 qi2 = QI2.a;
            ImageView imageView = C16095kh6.this.v.c;
            AbstractC13042fc3.h(imageView, "image");
            qi2.a(imageView);
        }
    }

    public /* synthetic */ C16095kh6(C8029Uf3 c8029Uf3, C13122fh6.c cVar, ED1 ed1) {
        this(c8029Uf3, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C16095kh6 c16095kh6, C10489bh6.b bVar, View view) {
        AbstractC13042fc3.i(c16095kh6, "this$0");
        AbstractC13042fc3.i(bVar, "$post");
        C13122fh6.c cVar = c16095kh6.w;
        if (cVar != null) {
            cVar.r4(bVar);
        }
    }

    public final void F0(final C10489bh6.b bVar) {
        AbstractC13042fc3.i(bVar, "post");
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.x;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
            this.x = null;
        }
        this.x = AbstractC5969Lp4.e().D().D(bVar.a(), true, new b(), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        this.v.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16095kh6.H0(this.a, bVar, view);
            }
        });
    }

    public final void J0() {
        QI2 qi2 = QI2.a;
        ImageView imageView = this.v.c;
        AbstractC13042fc3.h(imageView, "image");
        qi2.a(imageView);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C16095kh6(C8029Uf3 c8029Uf3, C13122fh6.c cVar) {
        ConstraintLayout constraintLayout = c8029Uf3.e;
        AbstractC13042fc3.h(constraintLayout, "root");
        super(constraintLayout);
        this.v = c8029Uf3;
        this.w = cVar;
    }
}
