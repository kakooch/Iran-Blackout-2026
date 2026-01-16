package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import ir.nasim.AbstractC18108o6;

/* renamed from: ir.nasim.p6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C18699p6 extends AbstractC18108o6 {
    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "input");
        Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
        AbstractC13042fc3.h(type, "Intent(Intent.ACTION_GET…          .setType(input)");
        return type;
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final AbstractC18108o6.a b(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "input");
        return null;
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i, Intent intent) {
        if (i != -1) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }
}
