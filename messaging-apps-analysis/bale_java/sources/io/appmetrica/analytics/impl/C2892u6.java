package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC20051rO3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.u6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2892u6 {
    public final Sk a = new Sk();
    public Map b = AbstractC20051rO3.k();
    public Map c = AbstractC20051rO3.k();
    public IdentifiersResult d;

    public final synchronized void a(IdentifiersResult identifiersResult) {
        HashMap map;
        Map mapK;
        List listA;
        String str;
        try {
            IdentifiersResult identifiersResult2 = this.d;
            String str2 = identifiersResult2 != null ? identifiersResult2.id : null;
            if (str2 == null || str2.length() == 0 || ((str = identifiersResult.id) != null && str.length() != 0)) {
                this.d = identifiersResult;
                String str3 = identifiersResult.id;
                if (str3 == null) {
                    map = null;
                } else {
                    map = new HashMap();
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            try {
                                ArrayList arrayListA = Ya.a(new JSONArray(jSONObject.optString(next)));
                                if (arrayListA != null) {
                                    map.put(next, arrayListA);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (map != null) {
                    mapK = new LinkedHashMap(AbstractC19460qO3.f(map.size()));
                    for (Map.Entry entry : map.entrySet()) {
                        Object key = entry.getKey();
                        List list = (List) entry.getValue();
                        mapK.put(key, new IdentifiersResult(String.valueOf(hn.a((Collection) list) ? null : new JSONArray((Collection) list)), identifiersResult.status, identifiersResult.errorExplanation));
                    }
                } else {
                    mapK = AbstractC20051rO3.k();
                }
                this.c = mapK;
                LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(mapK.size()));
                for (Map.Entry entry2 : mapK.entrySet()) {
                    Object key2 = entry2.getKey();
                    String str4 = ((IdentifiersResult) entry2.getValue()).id;
                    if (str4 == null) {
                        listA = null;
                    } else {
                        try {
                            listA = Ya.a(new JSONArray(str4));
                        } catch (Throwable unused3) {
                        }
                    }
                    if (listA == null) {
                        listA = AbstractC10360bX0.m();
                    }
                    linkedHashMap.put(key2, listA);
                }
                this.b = linkedHashMap;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(List list, HashMap map) {
        IdentifierStatus identifierStatus;
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                List list2 = (List) this.b.get(str);
                if (list2 != null && !list2.isEmpty()) {
                    linkedHashMap.put(str, list2);
                }
            }
            Sk sk = this.a;
            String strA = Ya.a((Map) linkedHashMap);
            IdentifiersResult identifiersResult = this.d;
            if (identifiersResult == null || (identifierStatus = identifiersResult.status) == null) {
                identifierStatus = IdentifierStatus.UNKNOWN;
            }
            map.put("appmetrica_custom_sdk_hosts", sk.a(new IdentifiersResult(strA, identifierStatus, identifiersResult != null ? identifiersResult.errorExplanation : null)));
        } catch (Throwable th) {
            throw th;
        }
    }
}
