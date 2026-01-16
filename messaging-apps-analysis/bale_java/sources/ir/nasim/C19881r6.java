package ir.nasim;

import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC18108o6;

/* renamed from: ir.nasim.r6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19881r6 extends AbstractC18108o6 {
    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "input");
        return C19290q6.a.a(new String[]{str});
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC18108o6.a b(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "input");
        if (AbstractC4043Dl1.a(context, str) == 0) {
            return new AbstractC18108o6.a(Boolean.TRUE);
        }
        return null;
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Boolean c(int i, Intent intent) {
        if (intent == null || i != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        boolean z = false;
        if (intArrayExtra != null) {
            int length = intArrayExtra.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (intArrayExtra[i2] == 0) {
                    z = true;
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }
}
