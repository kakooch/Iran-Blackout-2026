package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;

/* loaded from: classes3.dex */
public final class C3 implements Converter {
    public final C2681la a;

    public C3() {
        this(new C2681la(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(List<String> list) {
        Im imA = this.a.a((List<Object>) list);
        C2412a8 c2412a8 = new C2412a8();
        c2412a8.a = StringUtils.getUTF8Bytes((List<String>) imA.a);
        InterfaceC2841s3 interfaceC2841s3 = imA.b;
        int i = ((C2986y4) interfaceC2841s3).a;
        return new Rh(c2412a8, interfaceC2841s3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C3(C2681la c2681la) {
        this.a = c2681la;
    }

    public final List<String> a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
