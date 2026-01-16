package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes3.dex */
final class f implements DynamiteModule.a {
    f() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0174a interfaceC0174a) {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int iA = interfaceC0174a.a(context, str, false);
        bVar.b = iA;
        bVar.c = iA != 0 ? 1 : 0;
        return bVar;
    }
}
