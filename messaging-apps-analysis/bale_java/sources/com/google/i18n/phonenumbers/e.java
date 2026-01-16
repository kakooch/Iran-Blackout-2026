package com.google.i18n.phonenumbers;

import ir.nasim.InterfaceC3515Be4;
import ir.nasim.Z75;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class e implements d {
    private final String a;
    private final InterfaceC3515Be4 b;
    private final ConcurrentHashMap c;
    private final ConcurrentHashMap d;

    e(String str, InterfaceC3515Be4 interfaceC3515Be4) {
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.a = str;
        this.b = interfaceC3515Be4;
    }

    private boolean c(int i) {
        List list = (List) b.a().get(Integer.valueOf(i));
        return list.size() == 1 && "001".equals(list.get(0));
    }

    @Override // com.google.i18n.phonenumbers.d
    public Z75 a(String str) {
        return c.a(str, this.c, this.a, this.b);
    }

    @Override // com.google.i18n.phonenumbers.d
    public Z75 b(int i) {
        if (c(i)) {
            return c.a(Integer.valueOf(i), this.d, this.a, this.b);
        }
        return null;
    }

    e(InterfaceC3515Be4 interfaceC3515Be4) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", interfaceC3515Be4);
    }
}
