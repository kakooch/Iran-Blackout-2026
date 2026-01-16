package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import ir.nasim.AbstractC18584ou1;
import ir.nasim.InterfaceC5558Jv7;
import ir.nasim.WV;

@Keep
/* loaded from: classes2.dex */
public class CctBackendFactory implements WV {
    @Override // ir.nasim.WV
    public InterfaceC5558Jv7 create(AbstractC18584ou1 abstractC18584ou1) {
        return new d(abstractC18584ou1.b(), abstractC18584ou1.e(), abstractC18584ou1.d());
    }
}
