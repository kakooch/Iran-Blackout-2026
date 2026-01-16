package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC18451og8;
import ir.nasim.AbstractC23519x35;
import ir.nasim.C9430Zx;
import ir.nasim.GP;

/* loaded from: classes3.dex */
public class b extends com.google.android.gms.common.api.b {
    private static final f k = new f(null);
    static int l = 1;

    b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, GP.c, googleSignInOptions, new C9430Zx());
    }

    private final synchronized int B() {
        int i;
        try {
            i = l;
            if (i == 1) {
                Context contextR = r();
                com.google.android.gms.common.a aVarM = com.google.android.gms.common.a.m();
                int iH = aVarM.h(contextR, 12451000);
                if (iH == 0) {
                    i = 4;
                    l = 4;
                } else if (aVarM.b(contextR, iH, null) != null || DynamiteModule.a(contextR, "com.google.android.gms.auth.api.fallback") == 0) {
                    i = 2;
                    l = 2;
                } else {
                    i = 3;
                    l = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public Task A() {
        return AbstractC23519x35.b(AbstractC18451og8.b(h(), r(), B() == 3));
    }

    public Task z() {
        return AbstractC23519x35.b(AbstractC18451og8.a(h(), r(), B() == 3));
    }
}
