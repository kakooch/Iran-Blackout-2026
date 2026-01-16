package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* renamed from: ir.nasim.fl0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC13156fl0 {

    /* renamed from: ir.nasim.fl0$a */
    public static class a implements InterfaceC13156fl0 {
        @Override // ir.nasim.InterfaceC13156fl0
        public float a() {
            return 0.3f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float b() {
            return 1.5f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float c() {
            return (float) Math.toRadians(125.0d);
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public boolean d() {
            return false;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float e() {
            return 0.04f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public Bitmap f() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeResource(C5721Ko.b.getResources(), KB5.paint_elliptical_brush, options);
        }
    }

    /* renamed from: ir.nasim.fl0$b */
    public static class b implements InterfaceC13156fl0 {
        @Override // ir.nasim.InterfaceC13156fl0
        public float a() {
            return 0.7f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float b() {
            return 1.45f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float c() {
            return 0.0f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public boolean d() {
            return true;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float e() {
            return 0.07f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public Bitmap f() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeResource(C5721Ko.b.getResources(), KB5.paint_neon_brush, options);
        }
    }

    /* renamed from: ir.nasim.fl0$c */
    public static class c implements InterfaceC13156fl0 {
        @Override // ir.nasim.InterfaceC13156fl0
        public float a() {
            return 0.85f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float b() {
            return 1.0f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float c() {
            return 0.0f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public boolean d() {
            return false;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public float e() {
            return 0.15f;
        }

        @Override // ir.nasim.InterfaceC13156fl0
        public Bitmap f() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeResource(C5721Ko.b.getResources(), KB5.paint_radial_brush, options);
        }
    }

    float a();

    float b();

    float c();

    boolean d();

    float e();

    Bitmap f();
}
