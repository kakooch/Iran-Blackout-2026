package ir.nasim;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.utils.ImageUtil;
import ir.nasim.C11982ds5;
import ir.nasim.C24677z13;
import ir.nasim.C6602Of0;
import ir.nasim.N03;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.ds5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C11982ds5 {
    final Executor a;
    final AbstractC5842Lb3 b;
    private a c;
    private InterfaceC15888kL4 d;
    private InterfaceC15888kL4 e;
    private InterfaceC15888kL4 f;
    private InterfaceC15888kL4 g;
    private InterfaceC15888kL4 h;
    private InterfaceC15888kL4 i;
    private InterfaceC15888kL4 j;
    private InterfaceC15888kL4 k;
    private InterfaceC15888kL4 l;
    private final C6293Mz5 m;
    private final boolean n;

    /* renamed from: ir.nasim.ds5$a */
    static abstract class a {
        a() {
        }

        static a e(int i, int i2) {
            return new C23164wT(new X22(), new X22(), i, i2);
        }

        abstract X22 a();

        abstract int b();

        abstract int c();

        abstract X22 d();
    }

    /* renamed from: ir.nasim.ds5$b */
    static abstract class b {
        b() {
        }

        static b c(AbstractC12595es5 abstractC12595es5, androidx.camera.core.f fVar) {
            return new C23754xT(abstractC12595es5, fVar);
        }

        abstract androidx.camera.core.f a();

        abstract AbstractC12595es5 b();
    }

    C11982ds5(Executor executor, AbstractC5842Lb3 abstractC5842Lb3) {
        this(executor, abstractC5842Lb3, androidx.camera.core.internal.compat.quirk.a.c());
    }

    private PS4 i(PS4 ps4, int i) {
        AbstractC4980Hj5.i(ImageUtil.g(ps4.e()));
        PS4 ps42 = (PS4) this.h.apply(ps4);
        InterfaceC15888kL4 interfaceC15888kL4 = this.l;
        if (interfaceC15888kL4 != null) {
            ps42 = (PS4) interfaceC15888kL4.apply(ps42);
        }
        return (PS4) this.f.apply(C6602Of0.b.c(ps42, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(final b bVar) {
        if (bVar.b().j()) {
            bVar.a().close();
        } else {
            this.a.execute(new Runnable() { // from class: ir.nasim.cs5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final b bVar) {
        if (!bVar.b().j()) {
            this.a.execute(new Runnable() { // from class: ir.nasim.bs5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.p(bVar);
                }
            });
        } else {
            PI3.l("ProcessingNode", "The postview image is closed due to request aborted");
            bVar.a().close();
        }
    }

    private static void w(final AbstractC12595es5 abstractC12595es5, final ImageCaptureException imageCaptureException) {
        AbstractC20567sE0.c().execute(new Runnable(abstractC12595es5, imageCaptureException) { // from class: ir.nasim.Yr5
            public final /* synthetic */ AbstractC12595es5 a;
            public final /* synthetic */ ImageCaptureException b;

            {
                this.b = imageCaptureException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.r(this.b);
            }
        });
    }

    androidx.camera.core.f r(b bVar) {
        AbstractC12595es5 abstractC12595es5B = bVar.b();
        PS4 ps4 = (PS4) this.d.apply(bVar);
        if ((ps4.e() == 35 || this.l != null || this.n) && this.c.c() == 256) {
            PS4 ps4I = (PS4) this.e.apply(N03.a.c(ps4, abstractC12595es5B.c()));
            if (this.l != null) {
                ps4I = i(ps4I, abstractC12595es5B.c());
            }
            ps4 = (PS4) this.j.apply(ps4I);
        }
        return (androidx.camera.core.f) this.i.apply(ps4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void n(b bVar) {
        final AbstractC12595es5 abstractC12595es5B = bVar.b();
        try {
            if (bVar.b().k()) {
                final androidx.camera.core.f fVarR = r(bVar);
                AbstractC20567sE0.c().execute(new Runnable(abstractC12595es5B, fVarR) { // from class: ir.nasim.Vr5
                    public final /* synthetic */ AbstractC12595es5 a;
                    public final /* synthetic */ androidx.camera.core.f b;

                    {
                        this.b = fVarR;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.n(this.b);
                    }
                });
            } else {
                final C24677z13.e eVarT = t(bVar);
                AbstractC20567sE0.c().execute(new Runnable(abstractC12595es5B, eVarT) { // from class: ir.nasim.Wr5
                    public final /* synthetic */ AbstractC12595es5 a;
                    public final /* synthetic */ C24677z13.e b;

                    {
                        this.b = eVarT;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.o(this.b);
                    }
                });
            }
        } catch (ImageCaptureException e) {
            w(abstractC12595es5B, e);
        } catch (OutOfMemoryError e2) {
            w(abstractC12595es5B, new ImageCaptureException(0, "Processing failed due to low memory.", e2));
        } catch (RuntimeException e3) {
            w(abstractC12595es5B, new ImageCaptureException(0, "Processing failed.", e3));
        }
    }

    C24677z13.e t(b bVar) {
        int iC = this.c.c();
        AbstractC4980Hj5.b(ImageUtil.g(iC), String.format("On-disk capture only support JPEG and JPEG/R output formats. Output format: %s", Integer.valueOf(iC)));
        AbstractC12595es5 abstractC12595es5B = bVar.b();
        PS4 ps4 = (PS4) this.e.apply(N03.a.c((PS4) this.d.apply(bVar), abstractC12595es5B.c()));
        if (ps4.i() || this.l != null) {
            i(ps4, abstractC12595es5B.c());
        }
        abstractC12595es5B.d();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void p(b bVar) {
        int iC = this.c.c();
        AbstractC4980Hj5.b(iC == 35 || iC == 256, String.format("Postview only support YUV and JPEG output formats. Output format: %s", Integer.valueOf(iC)));
        final AbstractC12595es5 abstractC12595es5B = bVar.b();
        try {
            final Bitmap bitmap = (Bitmap) this.k.apply((PS4) this.d.apply(bVar));
            AbstractC20567sE0.c().execute(new Runnable(abstractC12595es5B, bitmap) { // from class: ir.nasim.Xr5
                public final /* synthetic */ AbstractC12595es5 a;
                public final /* synthetic */ Bitmap b;

                {
                    this.b = bitmap;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q(this.b);
                }
            });
        } catch (Exception e) {
            bVar.a().close();
            PI3.d("ProcessingNode", "process postview input packet failed.", e);
        }
    }

    public Void x(a aVar) {
        this.c = aVar;
        aVar.a().a(new InterfaceC25043ze1() { // from class: ir.nasim.Zr5
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.o((C11982ds5.b) obj);
            }
        });
        aVar.d().a(new InterfaceC25043ze1() { // from class: ir.nasim.as5
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.q((C11982ds5.b) obj);
            }
        });
        this.d = new C8139Ur5();
        this.e = new N03(this.m);
        this.h = new C8533Wj3();
        this.f = new C6602Of0();
        this.g = new C8799Xj3();
        this.i = new C9896ak3();
        this.k = new M03();
        if (aVar.b() != 35 && !this.n) {
            return null;
        }
        this.j = new C9074Yj3();
        return null;
    }

    C11982ds5(Executor executor, AbstractC5842Lb3 abstractC5842Lb3, C6293Mz5 c6293Mz5) {
        if (androidx.camera.core.internal.compat.quirk.a.b(LowMemoryQuirk.class) != null) {
            this.a = AbstractC20567sE0.e(executor);
        } else {
            this.a = executor;
        }
        this.m = c6293Mz5;
        this.n = c6293Mz5.a(IncorrectJpegMetadataQuirk.class);
    }

    public void v() {
    }
}
