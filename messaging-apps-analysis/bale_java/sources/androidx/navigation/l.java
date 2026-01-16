package androidx.navigation;

import android.content.Context;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes2.dex */
public final class l {
    public static final a c = new a(null);
    private static final ThreadLocal d = new ThreadLocal();
    private final Context a;
    private final q b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public l(Context context, q qVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(qVar, "navigatorProvider");
        this.a = context;
        this.b = qVar;
    }
}
