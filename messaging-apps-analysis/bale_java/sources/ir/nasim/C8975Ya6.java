package ir.nasim;

import android.graphics.Bitmap;

/* renamed from: ir.nasim.Ya6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8975Ya6 {
    private final boolean a;
    private final boolean b;
    private final Bitmap.CompressFormat c;
    private final int d;

    /* renamed from: ir.nasim.Ya6$a */
    public static final class a {
        private boolean a = true;
        private boolean b = true;
        private Bitmap.CompressFormat c = Bitmap.CompressFormat.PNG;
        private int d = 100;

        public final C8975Ya6 a() {
            return new C8975Ya6(this, null);
        }

        public final Bitmap.CompressFormat b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final boolean d() {
            return this.b;
        }

        public final boolean e() {
            return this.a;
        }

        public final a f(boolean z) {
            this.b = z;
            return this;
        }

        public final a g(boolean z) {
            this.a = z;
            return this;
        }
    }

    public /* synthetic */ C8975Ya6(a aVar, ED1 ed1) {
        this(aVar);
    }

    public final Bitmap.CompressFormat a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    private C8975Ya6(a aVar) {
        this.b = aVar.d();
        this.a = aVar.e();
        this.c = aVar.b();
        this.d = aVar.c();
    }
}
