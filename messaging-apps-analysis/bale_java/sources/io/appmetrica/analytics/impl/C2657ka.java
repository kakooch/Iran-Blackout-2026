package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.ka, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2657ka extends J2 {
    public final InterfaceC2729na b;

    public C2657ka(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public C2657ka(int i, InterfaceC2729na interfaceC2729na) {
        super(i);
        this.b = interfaceC2729na;
    }

    @Override // io.appmetrica.analytics.impl.J2, io.appmetrica.analytics.impl.InterfaceC2729na
    public final Im a(List<Object> list) {
        int iB;
        int i = 0;
        if (list == null || (list.size() <= this.a && this.b == null)) {
            iB = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            iB = 0;
            int i2 = 0;
            for (Object obj : list) {
                if (i2 < this.a) {
                    InterfaceC2729na interfaceC2729na = this.b;
                    if (interfaceC2729na != null) {
                        Im imA = interfaceC2729na.a(obj);
                        Object obj2 = imA.a;
                        iB += imA.b.getBytesTruncated();
                        hn.a(obj, imA.a);
                        obj = obj2;
                    }
                    arrayList.add(obj);
                } else {
                    i++;
                    iB += b(obj);
                }
                i2++;
            }
            list = arrayList;
        }
        return new Im(list, new C2986y4(i, iB));
    }

    public final InterfaceC2729na b() {
        return this.b;
    }
}
