package ir.nasim;

import android.database.ContentObserver;
import android.os.Environment;
import android.provider.MediaStore;
import ir.nasim.features.media.components.PhotoViewerAbs;
import java.io.File;
import java.io.IOException;

/* renamed from: ir.nasim.cX3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C10979cX3 extends AbstractC11743dX3 {
    private boolean b = false;
    private Runnable c;

    /* renamed from: ir.nasim.cX3$a */
    private class a extends ContentObserver {

        /* renamed from: ir.nasim.cX3$a$a, reason: collision with other inner class name */
        class RunnableC0939a implements Runnable {
            RunnableC0939a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C10979cX3.this.c = null;
                AbstractC14815iX3.k();
            }
        }

        public a() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (C10979cX3.this.c != null) {
                AbstractC7426Rr.w(C10979cX3.this.c);
            }
            C10979cX3 c10979cX3 = C10979cX3.this;
            RunnableC0939a runnableC0939a = new RunnableC0939a();
            c10979cX3.c = runnableC0939a;
            AbstractC7426Rr.Q(runnableC0939a, 2000L);
        }
    }

    /* renamed from: ir.nasim.cX3$b */
    private class b extends ContentObserver {

        /* renamed from: ir.nasim.cX3$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PhotoViewerAbs.getInstance().isVisible()) {
                    b.this.b();
                } else {
                    C10979cX3.this.c = null;
                    AbstractC14815iX3.k();
                }
            }
        }

        public b() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            C10979cX3 c10979cX3 = C10979cX3.this;
            a aVar = new a();
            c10979cX3.c = aVar;
            AbstractC7426Rr.Q(aVar, 2000L);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (C10979cX3.this.c != null) {
                AbstractC7426Rr.w(C10979cX3.this.c);
            }
            b();
        }
    }

    public C10979cX3() {
        SZ.e(new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.MW3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        })).h(EnumC11723dV1.IO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            C5721Ko.b.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, new a());
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
        try {
            C5721Ko.b.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, new b());
        } catch (Exception e2) {
            C19406qI3.d("baleMessages", e2);
        }
    }

    @Override // ir.nasim.AbstractC11743dX3
    public void a() throws IOException {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Bale");
            File file2 = new File(file, "Bale Images");
            file2.mkdir();
            File file3 = new File(file, "Bale Video");
            file3.mkdir();
            if (this.b) {
                if (file2.isDirectory()) {
                    new File(file2, ".nomedia").delete();
                }
                if (file3.isDirectory()) {
                    new File(file3, ".nomedia").delete();
                    return;
                }
                return;
            }
            if (file2.isDirectory()) {
                new File(file2, ".nomedia").createNewFile();
            }
            if (file3.isDirectory()) {
                new File(file3, ".nomedia").createNewFile();
            }
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
    }
}
