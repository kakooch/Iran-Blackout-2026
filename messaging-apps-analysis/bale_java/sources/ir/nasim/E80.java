package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.jaryan.discover.model.BannerItem;
import ir.nasim.jaryan.discover.model.FileLocation;

/* loaded from: classes6.dex */
public final class E80 extends RecyclerView.C {
    public static final a B = new a(null);
    public static final int D = 8;
    private C80 A;
    private final F80 u;
    private final InterfaceC24154y80 v;
    private final UA2 w;
    private final UA2 x;
    private InterfaceC7857Tm2 y;
    private InterfaceC8091Um2 z;

    public static final class a {
        private a() {
        }

        public final E80 a(ViewGroup viewGroup, InterfaceC24154y80 interfaceC24154y80, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC24154y80, "bannerClickListener");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            F80 f80C = F80.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(f80C, "inflate(...)");
            return new E80(f80C, interfaceC24154y80, ua2, ua22);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E80(F80 f80, InterfaceC24154y80 interfaceC24154y80, UA2 ua2, UA2 ua22) {
        super(f80.getRoot());
        AbstractC13042fc3.i(f80, "binding");
        AbstractC13042fc3.i(interfaceC24154y80, "bannerClickListener");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.u = f80;
        this.v = interfaceC24154y80;
        this.w = ua2;
        this.x = ua22;
        this.z = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(E80 e80, BannerItem bannerItem, int i, View view) {
        AbstractC13042fc3.i(e80, "this$0");
        AbstractC13042fc3.i(bannerItem, "$bannerItem");
        e80.v.h0(bannerItem.getAction(), i);
    }

    public final void E0(final BannerItem bannerItem, final int i) {
        AbstractC13042fc3.i(bannerItem, "bannerItem");
        UA2 ua2 = this.w;
        C80 c80 = new C80(i);
        this.A = c80;
        ua2.invoke(c80);
        FileLocation fileLocation = bannerItem.getFileLocation();
        if (fileLocation != null) {
            this.y = AbstractC5969Lp4.e().D().D(new FileReference(FileLocation.INSTANCE.a(fileLocation), "vitrin_banner_" + fileLocation.getFileId(), "", bannerItem.getFileSize()), true, this.z, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        }
        this.u.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.D80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                E80.F0(this.a, bannerItem, i, view);
            }
        });
    }

    public final void a() {
        C80 c80 = this.A;
        if (c80 != null) {
            this.x.invoke(c80);
        }
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.y;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.y = null;
        ImageView imageView = this.u.b;
        imageView.setImageURI(null);
        imageView.setImageDrawable(null);
    }

    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            String descriptor = interfaceC3346Am2.getDescriptor();
            ImageView imageView = E80.this.u.b;
            AbstractC13042fc3.h(imageView, "bannerItemIv");
            QI2.p(descriptor, imageView, null, 4, null);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
