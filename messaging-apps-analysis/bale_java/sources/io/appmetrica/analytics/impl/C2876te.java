package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.te, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2876te implements ProtobufConverter {
    public final Fe a;
    public final C2757oe b;

    public C2876te() {
        this(new Fe(), new C2757oe());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Be fromModel(C2828re c2828re) {
        Be be = new Be();
        be.a = this.a.fromModel(c2828re.a);
        be.b = new Ae[c2828re.b.size()];
        Iterator<C2805qe> it = c2828re.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            be.b[i] = this.b.fromModel(it.next());
            i++;
        }
        return be;
    }

    public C2876te(Fe fe, C2757oe c2757oe) {
        this.a = fe;
        this.b = c2757oe;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2828re toModel(Be be) {
        Ee model;
        ArrayList arrayList = new ArrayList(be.b.length);
        for (Ae ae : be.b) {
            arrayList.add(this.b.toModel(ae));
        }
        C3020ze c3020ze = be.a;
        if (c3020ze == null) {
            model = this.a.toModel(new C3020ze());
        } else {
            model = this.a.toModel(c3020ze);
        }
        return new C2828re(model, arrayList);
    }
}
