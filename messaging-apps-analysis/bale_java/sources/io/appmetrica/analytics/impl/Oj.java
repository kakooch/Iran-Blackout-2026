package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Oj {
    public final String a;
    public final Jj b;
    public final Nj c;
    public final IBinaryDataHelper d;

    public Oj(Context context, W4 w4) {
        w4.a();
        this.a = "session_extras";
        this.b = new Jj();
        this.c = new Nj();
        this.d = W6.a(context).a(w4);
    }

    public final Map a() {
        try {
            byte[] bArr = this.d.get(this.a);
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    return this.b.toModel(this.c.toState(bArr));
                }
            }
        } catch (Throwable unused) {
        }
        Jj jj = this.b;
        this.c.getClass();
        return jj.toModel(new Lj());
    }
}
