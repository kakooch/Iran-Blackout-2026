package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import ir.nasim.AbstractC18108o6;

/* renamed from: ir.nasim.t6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C21093t6 extends AbstractC18108o6 {
    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Uri uri) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(uri, "input");
        Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
        AbstractC13042fc3.h(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
        return intentPutExtra;
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final AbstractC18108o6.a b(Context context, Uri uri) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(uri, "input");
        return null;
    }

    @Override // ir.nasim.AbstractC18108o6
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Boolean c(int i, Intent intent) {
        return Boolean.valueOf(i == -1);
    }
}
