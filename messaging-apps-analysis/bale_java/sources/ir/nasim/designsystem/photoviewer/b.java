package ir.nasim.designsystem.photoviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.github.chrisbanes.photoview.PhotoView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16640ld0;
import ir.nasim.C5505Jq;
import ir.nasim.C7322Rf3;
import ir.nasim.C8610Ws;
import ir.nasim.ED1;
import ir.nasim.OK4;
import ir.nasim.QI2;
import ir.nasim.VI2;
import ir.nasim.XY6;
import ir.nasim.designsystem.photoviewer.a;
import ir.nasim.designsystem.photoviewer.data.Photo;
import java.io.File;
import java.net.URI;

/* loaded from: classes5.dex */
public final class b extends AbstractC16640ld0 {
    public static final a H = new a(null);
    public static final int J = 8;
    private final VI2 A;
    private C8610Ws B;
    private int D;
    private int G;
    private final C7322Rf3 v;
    private final a.c w;
    private final a.InterfaceC1021a x;
    private final a.b y;
    private final boolean z;

    public static final class a {
        private a() {
        }

        public final b a(ViewGroup viewGroup, a.c cVar, a.InterfaceC1021a interfaceC1021a, a.b bVar, boolean z, VI2 vi2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(vi2, "glide");
            C7322Rf3 c7322Rf3C = C7322Rf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c7322Rf3C, "inflate(...)");
            return new b(c7322Rf3C, cVar, interfaceC1021a, bVar, z, vi2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.designsystem.photoviewer.b$b, reason: collision with other inner class name */
    public static final class RunnableC1022b implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ b b;
        final /* synthetic */ Integer c;
        final /* synthetic */ Integer d;

        public RunnableC1022b(View view, b bVar, Integer num, Integer num2) {
            this.a = view;
            this.b = bVar;
            this.c = num;
            this.d = num2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = this.a;
            this.b.D = view.getWidth();
            this.b.G = view.getHeight();
            this.b.O0(this.c.intValue(), this.d.intValue(), this.b.D, this.b.G);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(C7322Rf3 c7322Rf3, a.c cVar, a.InterfaceC1021a interfaceC1021a, a.b bVar, boolean z, VI2 vi2) {
        AbstractC13042fc3.i(c7322Rf3, "binding");
        AbstractC13042fc3.i(vi2, "glide");
        RelativeLayout root = c7322Rf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c7322Rf3;
        this.w = cVar;
        this.x = interfaceC1021a;
        this.y = bVar;
        this.z = z;
        this.A = vi2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(int i, int i2, int i3, int i4) {
        float f = i;
        float f2 = i2;
        float fMin = Math.min(i3 / f, i4 / f2);
        int i5 = (int) (f * fMin);
        int i6 = (int) (f2 * fMin);
        PhotoView photoView = this.v.g;
        ViewGroup.LayoutParams layoutParams = photoView.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = i6;
        photoView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(b bVar, View view) {
        AbstractC13042fc3.i(bVar, "this$0");
        a.c cVar = bVar.w;
        if (cVar != null) {
            cVar.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(b bVar, View view) {
        AbstractC13042fc3.i(bVar, "this$0");
        a.c cVar = bVar.w;
        if (cVar != null) {
            cVar.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(Photo photo, b bVar, int i, View view) {
        AbstractC13042fc3.i(photo, "$photo");
        AbstractC13042fc3.i(bVar, "this$0");
        if (photo.getDownloadingNow()) {
            photo.q(false);
            bVar.U0();
            a.InterfaceC1021a interfaceC1021a = bVar.x;
            if (interfaceC1021a != null) {
                interfaceC1021a.J(i, photo);
                return;
            }
            return;
        }
        if (!C5505Jq.F()) {
            a.b bVar2 = bVar.y;
            if (bVar2 != null) {
                bVar2.A();
                return;
            }
            return;
        }
        photo.q(true);
        bVar.V0(photo.getDownloadingProgress());
        a.InterfaceC1021a interfaceC1021a2 = bVar.x;
        if (interfaceC1021a2 != null) {
            interfaceC1021a2.k(i, photo);
        }
    }

    private final void U0() {
        this.v.e.setVisibility(8);
        this.v.d.setVisibility(8);
        this.v.c.setVisibility(0);
    }

    private final void V0(int i) {
        this.v.e.setVisibility(0);
        this.v.d.setVisibility(0);
        this.v.c.setVisibility(8);
        this.v.e.setValue(i);
        this.v.d.setText(XY6.e(String.valueOf(i)));
    }

    private final void W0() {
        C8610Ws c8610Ws = this.B;
        if (c8610Ws != null) {
            c8610Ws.stop();
            c8610Ws.S(null);
        }
        this.B = null;
    }

    public final void P0(final int i, final Photo photo) {
        AbstractC13042fc3.i(photo, "photo");
        if (photo.getIsGif()) {
            this.v.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.M95
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ir.nasim.designsystem.photoviewer.b.Q0(this.a, view);
                }
            });
        } else {
            this.v.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.O95
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ir.nasim.designsystem.photoviewer.b.S0(this.a, view);
                }
            });
        }
        byte[] placeHolder = photo.getPlaceHolder();
        if (placeHolder != null) {
            if (!AbstractC13042fc3.d(this.v.g.getTag(), placeHolder)) {
                QI2 qi2 = QI2.a;
                PhotoView photoView = this.v.g;
                AbstractC13042fc3.h(photoView, "image");
                qi2.r(photoView, placeHolder, 30, 2);
                this.v.g.setTag(placeHolder);
            }
            this.v.f.setVisibility(0);
            if (photo.getDownloadingNow()) {
                V0(photo.getDownloadingProgress());
            } else if (photo.getPhotoUri() == null && !photo.getDownloadingNow() && this.z) {
                photo.q(true);
                V0(photo.getDownloadingProgress());
                a.InterfaceC1021a interfaceC1021a = this.x;
                if (interfaceC1021a != null) {
                    interfaceC1021a.k(i, photo);
                }
            } else {
                U0();
            }
        }
        String photoUri = photo.getPhotoUri();
        if (photoUri != null) {
            if (!AbstractC13042fc3.d(this.v.g.getTag(), photoUri)) {
                if (photo.getIsGif()) {
                    Integer width = photo.getWidth();
                    Integer height = photo.getHeight();
                    if (width != null && height != null) {
                        if (this.D == 0 || this.G == 0) {
                            RelativeLayout relativeLayout = this.v.b;
                            AbstractC13042fc3.h(relativeLayout, "container");
                            OK4.a(relativeLayout, new RunnableC1022b(relativeLayout, this, width, height));
                        } else {
                            O0(width.intValue(), height.intValue(), this.D, this.G);
                        }
                    }
                    C8610Ws c8610Ws = new C8610Ws(new File(URI.create(photoUri)), false);
                    this.B = c8610Ws;
                    PhotoView photoView2 = this.v.g;
                    c8610Ws.S(photoView2);
                    C8610Ws c8610Ws2 = this.B;
                    if (c8610Ws2 != null) {
                        c8610Ws2.start();
                    }
                    photoView2.setBackground(this.B);
                } else {
                    PhotoView photoView3 = this.v.g;
                    ViewGroup.LayoutParams layoutParams = photoView3.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    photoView3.setLayoutParams(layoutParams);
                    AbstractC13042fc3.f(this.A.y(photoUri).Q0(this.v.g));
                }
                this.v.g.setTag(photoUri);
            }
            this.v.f.setVisibility(8);
        }
        this.v.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.P95
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.designsystem.photoviewer.b.T0(photo, this, i, view);
            }
        });
    }

    public final void a() {
        W0();
    }
}
