package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class V1 implements ProtobufConverter {
    public final C2 a;

    public V1() {
        this(new C2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Y1 fromModel(U1 u1) {
        Y1 y1 = new Y1();
        y1.a = new X1[u1.a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : u1.a) {
            X1[] x1Arr = y1.a;
            X1 x1 = new X1();
            x1.a = permissionState.name;
            x1.b = permissionState.granted;
            x1Arr[i2] = x1;
            i2++;
        }
        E2 e2 = u1.b;
        if (e2 != null) {
            y1.b = this.a.fromModel(e2);
        }
        y1.c = new String[u1.c.size()];
        Iterator it = u1.c.iterator();
        while (it.hasNext()) {
            y1.c[i] = (String) it.next();
            i++;
        }
        return y1;
    }

    public V1(C2 c2) {
        this.a = c2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final U1 toModel(Y1 y1) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            X1[] x1Arr = y1.a;
            if (i2 >= x1Arr.length) {
                break;
            }
            X1 x1 = x1Arr[i2];
            arrayList.add(new PermissionState(x1.a, x1.b));
            i2++;
        }
        W1 w1 = y1.b;
        E2 model = w1 != null ? this.a.toModel(w1) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = y1.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new U1(arrayList, model, arrayList2);
            }
        }
    }
}
