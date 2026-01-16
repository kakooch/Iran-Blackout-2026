package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class K3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final O3 fromModel(J3 j3) {
        O3 o3 = new O3();
        o3.a = a(j3.a);
        int size = j3.b.size();
        L3[] l3Arr = new L3[size];
        for (int i = 0; i < size; i++) {
            l3Arr[i] = a((I3) j3.b.get(i));
        }
        o3.b = l3Arr;
        return o3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final J3 toModel(O3 o3) {
        L3 l3 = o3.a;
        if (l3 == null) {
            l3 = new L3();
        }
        I3 i3A = a(l3);
        L3[] l3Arr = o3.b;
        ArrayList arrayList = new ArrayList(l3Arr.length);
        for (L3 l32 : l3Arr) {
            arrayList.add(a(l32));
        }
        return new J3(i3A, arrayList);
    }

    public static L3 a(I3 i3) {
        N3 n3;
        L3 l3 = new L3();
        Map map = i3.a;
        int i = 0;
        if (map != null) {
            n3 = new N3();
            int size = map.size();
            M3[] m3Arr = new M3[size];
            for (int i2 = 0; i2 < size; i2++) {
                m3Arr[i2] = new M3();
            }
            n3.a = m3Arr;
            int i4 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                M3 m3 = n3.a[i4];
                m3.a = str;
                m3.b = str2;
                i4++;
            }
        } else {
            n3 = null;
        }
        l3.a = n3;
        int iOrdinal = i3.b.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                i = 2;
                if (iOrdinal != 2) {
                    i = 3;
                    if (iOrdinal != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else {
                i = 1;
            }
        }
        l3.b = i;
        return l3;
    }

    public static I3 a(L3 l3) {
        LinkedHashMap linkedHashMap;
        M7 m7;
        N3 n3 = l3.a;
        if (n3 != null) {
            M3[] m3Arr = n3.a;
            linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(m3Arr.length), 16));
            for (M3 m3 : m3Arr) {
                XV4 xv4A = AbstractC4616Fw7.a(m3.a, m3.b);
                linkedHashMap.put(xv4A.e(), xv4A.f());
            }
        } else {
            linkedHashMap = null;
        }
        int i = l3.b;
        if (i == 0) {
            m7 = M7.b;
        } else if (i == 1) {
            m7 = M7.c;
        } else if (i == 2) {
            m7 = M7.d;
        } else if (i != 3) {
            m7 = M7.b;
        } else {
            m7 = M7.e;
        }
        return new I3(linkedHashMap, m7);
    }
}
