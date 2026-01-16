package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes3.dex */
final class e implements DynamiteModule.a {
    e() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0174a interfaceC0174a) {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int iB = interfaceC0174a.b(context, str);
        bVar.a = iB;
        if (iB != 0) {
            bVar.c = -1;
        } else {
            int iA = interfaceC0174a.a(context, str, true);
            bVar.b = iA;
            if (iA != 0) {
                bVar.c = 1;
            }
        }
        return bVar;
    }
}
