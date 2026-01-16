package ir.nasim;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public abstract class TF6 extends com.google.android.gms.common.api.b {
    private static final a.g k;
    private static final a.AbstractC0169a l;
    private static final com.google.android.gms.common.api.a m;

    static {
        a.g gVar = new a.g();
        k = gVar;
        Vg8 vg8 = new Vg8();
        l = vg8;
        m = new com.google.android.gms.common.api.a("SmsRetriever.API", vg8, gVar);
    }

    public TF6(Activity activity) {
        super(activity, m, (a.d) a.d.P, b.a.c);
    }

    public abstract Task A(String str);

    public abstract Task z();

    public TF6(Context context) {
        super(context, m, a.d.P, b.a.c);
    }
}
