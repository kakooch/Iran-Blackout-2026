package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes3.dex */
final class h implements DynamiteModule.a {
    h() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0174a interfaceC0174a) {
        int iA;
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        int iB = interfaceC0174a.b(context, str);
        bVar.a = iB;
        int i = 1;
        int i2 = 0;
        if (iB != 0) {
            iA = interfaceC0174a.a(context, str, false);
            bVar.b = iA;
        } else {
            iA = interfaceC0174a.a(context, str, true);
            bVar.b = iA;
        }
        int i3 = bVar.a;
        if (i3 == 0) {
            if (iA == 0) {
                i = 0;
            }
            bVar.c = i;
            return bVar;
        }
        i2 = i3;
        if (i2 >= iA) {
            i = -1;
        }
        bVar.c = i;
        return bVar;
    }
}
