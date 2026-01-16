package ir.nasim;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lir/nasim/OJ1;", "", "Lir/nasim/PJ1;", "d", "()Lir/nasim/PJ1;", "e", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public interface OJ1 {

    /* renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* renamed from: ir.nasim.OJ1$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        private Companion() {
        }

        public final Intent a(Context context) {
            AbstractC13042fc3.i(context, "context");
            return ((OJ1) C92.a(C5721Ko.a.d(), OJ1.class)).d().a(context);
        }
    }

    PJ1 d();
}
