package ir.nasim;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;

/* renamed from: ir.nasim.s6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20490s6 extends AbstractC18108o6 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.s6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(intent, "input");
        return intent;
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ActivityResult c(int i, Intent intent) {
        return new ActivityResult(i, intent);
    }
}
