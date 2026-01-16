package ir.nasim;

import android.graphics.Bitmap;
import android.widget.ImageView;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.utils.images.common.ImageLoadException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.xg2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23880xg2 {
    private static Executor k = SZ.k("S_FastThumb");
    private ImageView a;
    private byte[] d;
    private Bitmap g;
    private EnumC5425Jh0 h;
    private InterfaceC7857Tm2 i;
    private final Object b = new Object();
    private int c = 0;
    private boolean e = false;
    private int f = 0;
    private InterfaceC8091Um2 j = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.xg2$b */
    class b implements Runnable {
        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int[] iArr, int i, int i2) {
            C23880xg2.this.a.setWillNotDraw(true);
            if (C23880xg2.this.g != null) {
                C23880xg2.this.g.recycle();
                C23880xg2.this.g = null;
            }
            C23880xg2.this.g = C16670lg0.c(Bitmap.createBitmap(iArr, 0, i, i, i2, Bitmap.Config.ARGB_8888), C22078ud6.a(1.0f));
            if (!C23880xg2.this.h.equals(EnumC5425Jh0.BITMAP_BLUR)) {
                ((com.bumptech.glide.g) QI2.g(new C7321Rf2(C23880xg2.this.g), C23880xg2.this.a.getContext(), C23880xg2.this.a.getHeight(), C23880xg2.this.a.getWidth()).u0(new T46(C22078ud6.a(4.0f), 0))).Q0(C23880xg2.this.a);
            } else if (C22078ud6.a(i2) >= 20) {
                C23880xg2.this.a.setImageBitmap(C23880xg2.this.g);
            } else if (C23880xg2.this.a.getWidth() == 0 || C23880xg2.this.a.getHeight() == 0) {
                C19406qI3.a("FastThumbLoader", "Cannot scale bitmap => preview.width:" + C23880xg2.this.a.getWidth() + ", preview.height:" + C23880xg2.this.a.getHeight(), new Object[0]);
            } else {
                C23880xg2.this.a.setImageBitmap(Bitmap.createScaledBitmap(C23880xg2.this.g, C23880xg2.this.a.getWidth(), C23880xg2.this.a.getHeight(), false));
            }
            C23880xg2.this.a.setWillNotDraw(false);
            C23880xg2.this.a.postInvalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Bitmap bitmap) {
            ((com.bumptech.glide.g) QI2.g(new C7321Rf2(bitmap), C23880xg2.this.a.getContext(), C23880xg2.this.a.getHeight(), C23880xg2.this.a.getWidth()).u0(new T46(C22078ud6.a(4.0f), 0))).Q0(C23880xg2.this.a);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C23880xg2.this.b) {
                try {
                    if (C23880xg2.this.e) {
                        int i = C23880xg2.this.c;
                        byte[] bArr = C23880xg2.this.d;
                        try {
                            final Bitmap bitmapK = AbstractC24097y23.k(bArr);
                            if (C23880xg2.this.h.equals(EnumC5425Jh0.SIMPLE)) {
                                AbstractC7555Sf2.a(bitmapK, C23880xg2.this.f, true);
                            }
                            synchronized (C23880xg2.this.b) {
                                try {
                                    if (C23880xg2.this.e) {
                                        if (i == C23880xg2.this.c) {
                                            if (C23880xg2.this.h.equals(EnumC5425Jh0.BITMAP_BLUR) || C23880xg2.this.h.equals(EnumC5425Jh0.PLACEHOLDER_BLUR)) {
                                                final int width = bitmapK.getWidth();
                                                final int height = bitmapK.getHeight();
                                                if (width > 0 && height > 0) {
                                                    final int[] iArrE = new C4957Hh0().e(C16670lg0.a(bitmapK, width, height), width, height);
                                                    AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.yg2
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            this.a.c(iArrE, width, height);
                                                        }
                                                    });
                                                }
                                            } else {
                                                AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.zg2
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        this.a.d(bitmapK);
                                                    }
                                                });
                                            }
                                            C23880xg2.this.e = false;
                                        }
                                    }
                                } finally {
                                }
                            }
                        } catch (ImageLoadException e) {
                            C19406qI3.d("FastThumbLoader", e);
                            synchronized (C23880xg2.this.b) {
                                try {
                                    if (C23880xg2.this.e && C23880xg2.this.c == i) {
                                        C23880xg2.this.e = false;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                } finally {
                }
            }
        }

        private b() {
        }
    }

    public C23880xg2(ImageView imageView, EnumC5425Jh0 enumC5425Jh0) {
        this.a = imageView;
        this.h = enumC5425Jh0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(InterfaceC3346Am2 interfaceC3346Am2) throws IOException {
        try {
            byte[] bArr = new byte[interfaceC3346Am2.f()];
            new FileInputStream(new File(interfaceC3346Am2.getDescriptor())).read(bArr);
            p(bArr);
        } catch (Exception e) {
            C19406qI3.d("FastThumbLoader", e);
        }
    }

    public void m() {
        synchronized (this.b) {
            this.c++;
            this.d = null;
            this.e = false;
        }
        this.a.setImageDrawable(null);
    }

    public void o(final InterfaceC3346Am2 interfaceC3346Am2) {
        k.execute(new Runnable() { // from class: ir.nasim.wg2
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.n(interfaceC3346Am2);
            }
        });
    }

    public void p(byte[] bArr) {
        synchronized (this.b) {
            this.c++;
            this.d = bArr;
            this.e = true;
        }
        k.execute(new b());
    }

    public void q() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.i;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
    }

    public C23880xg2(ImageView imageView, EnumC5425Jh0 enumC5425Jh0, C24967zW1 c24967zW1) {
        this.a = imageView;
        this.h = enumC5425Jh0;
        if (c24967zW1.v() != null && c24967zW1.v().a() != null) {
            this.i = AbstractC5969Lp4.d().q(c24967zW1.v().a().b(), true, this.j);
        } else if (c24967zW1.v() != null) {
            p(c24967zW1.v().c());
        }
    }

    /* renamed from: ir.nasim.xg2$a */
    class a implements InterfaceC8091Um2 {
        a() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            C23880xg2.this.o(interfaceC3346Am2);
            C23880xg2.this.i.a(true);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }

    public C23880xg2(ImageView imageView, EnumC5425Jh0 enumC5425Jh0, byte[] bArr) {
        this.a = imageView;
        this.h = enumC5425Jh0;
        p(bArr);
    }

    public C23880xg2(ImageView imageView, EnumC5425Jh0 enumC5425Jh0, FileReference fileReference) {
        if (fileReference == null) {
            return;
        }
        this.a = imageView;
        this.h = enumC5425Jh0;
        this.i = AbstractC5969Lp4.d().q(fileReference, true, this.j);
    }
}
