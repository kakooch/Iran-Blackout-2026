package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: ir.nasim.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14485i {

    /* renamed from: ir.nasim.i$a */
    public static final class a extends AbstractC16198ks {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;

        a(SA2 sa2, SA2 sa22) {
            this.a = sa2;
            this.b = sa22;
        }

        @Override // ir.nasim.AbstractC16198ks
        public void a(Drawable drawable) {
            SA2 sa2 = this.b;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        @Override // ir.nasim.AbstractC16198ks
        public void b(Drawable drawable) {
            SA2 sa2 = this.a;
            if (sa2 != null) {
                sa2.invoke();
            }
        }
    }

    public static final AbstractC16198ks a(SA2 sa2, SA2 sa22) {
        return new a(sa2, sa22);
    }

    public static final boolean b(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }
}
