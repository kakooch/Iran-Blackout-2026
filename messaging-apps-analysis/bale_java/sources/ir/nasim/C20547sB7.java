package ir.nasim;

import android.graphics.Bitmap;

/* renamed from: ir.nasim.sB7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20547sB7 implements HW5 {
    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(Bitmap bitmap, int i, int i2, HL4 hl4) {
        return new a(bitmap);
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(Bitmap bitmap, HL4 hl4) {
        return true;
    }

    /* renamed from: ir.nasim.sB7$a */
    private static final class a implements DW5 {
        private final Bitmap a;

        a(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // ir.nasim.DW5
        public Class b() {
            return Bitmap.class;
        }

        @Override // ir.nasim.DW5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.a;
        }

        @Override // ir.nasim.DW5
        public int f() {
            return YM7.i(this.a);
        }

        @Override // ir.nasim.DW5
        public void a() {
        }
    }
}
