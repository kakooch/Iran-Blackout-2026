package ir.nasim;

import android.os.Build;

/* renamed from: ir.nasim.nE, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17593nE {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.nE$a */
    public static final class a {
        private a() {
        }

        public final String a() {
            return "productionMyket";
        }

        public final String b() {
            return "myket";
        }

        public final int c() {
            return Build.VERSION.SDK_INT;
        }

        public final C9728aS7 d() {
            Integer num = AbstractC7373Rl0.a;
            AbstractC13042fc3.h(num, "VERSION_CODE");
            return new C9728aS7(num.intValue());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }
}
