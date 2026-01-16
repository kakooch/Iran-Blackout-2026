package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.C24381yX0;
import ir.nasim.DX0;
import ir.nasim.ED1;

/* loaded from: classes.dex */
final class f extends RippleDrawable {
    public static final a e = new a(null);
    private final boolean a;
    private C24381yX0 b;
    private Integer c;
    private boolean d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b {
        public static final b a = new b();

        private b() {
        }

        public final void a(RippleDrawable rippleDrawable, int i) {
            rippleDrawable.setRadius(i);
        }
    }

    public f(boolean z) {
        super(ColorStateList.valueOf(-16777216), null, z ? new ColorDrawable(-1) : null);
        this.a = z;
    }

    private final long a(long j, float f) {
        if (Build.VERSION.SDK_INT < 28) {
            f *= 2;
        }
        return C24381yX0.o(j, AbstractC23053wG5.h(f, 1.0f), 0.0f, 0.0f, 0.0f, 14, null);
    }

    public final void b(long j, float f) {
        long jA = a(j, f);
        C24381yX0 c24381yX0 = this.b;
        if (c24381yX0 == null ? false : C24381yX0.q(c24381yX0.y(), jA)) {
            return;
        }
        this.b = C24381yX0.k(jA);
        setColor(ColorStateList.valueOf(DX0.k(jA)));
    }

    public final void c(int i) {
        Integer num = this.c;
        if (num != null && num.intValue() == i) {
            return;
        }
        this.c = Integer.valueOf(i);
        b.a.a(this, i);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        if (!this.a) {
            this.d = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        this.d = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return this.d;
    }
}
