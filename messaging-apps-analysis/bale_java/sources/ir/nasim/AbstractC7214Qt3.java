package ir.nasim;

import android.os.Build;
import java.util.Locale;

/* renamed from: ir.nasim.Qt3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7214Qt3 {
    public static final a a = new a(null);
    private static final boolean b;

    /* renamed from: ir.nasim.Qt3$a */
    public static final class a {
        private a() {
        }

        public final boolean a() {
            return AbstractC7214Qt3.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        b = AbstractC13042fc3.d(lowerCase, "robolectric");
    }
}
