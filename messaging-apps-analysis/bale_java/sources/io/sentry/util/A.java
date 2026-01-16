package io.sentry.util;

import io.sentry.EnumC3125h3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class A {
    private static final Map a = new ConcurrentHashMap();

    public static List a(EnumC3125h3 enumC3125h3) {
        ArrayList arrayList = new ArrayList();
        EnumC3125h3 enumC3125h32 = EnumC3125h3.AGENT;
        if (enumC3125h32 == enumC3125h3 || EnumC3125h3.AGENTLESS_SPRING == enumC3125h3) {
            arrayList.add("auto.http.spring_jakarta.webmvc");
            arrayList.add("auto.http.spring.webmvc");
            arrayList.add("auto.spring_jakarta.webflux");
            arrayList.add("auto.spring.webflux");
            arrayList.add("auto.db.jdbc");
            arrayList.add("auto.http.spring_jakarta.webclient");
            arrayList.add("auto.http.spring.webclient");
            arrayList.add("auto.http.spring_jakarta.restclient");
            arrayList.add("auto.http.spring.restclient");
            arrayList.add("auto.http.spring_jakarta.resttemplate");
            arrayList.add("auto.http.spring.resttemplate");
            arrayList.add("auto.http.openfeign");
            arrayList.add("auto.http.ktor-client");
        }
        if (enumC3125h32 == enumC3125h3) {
            arrayList.add("auto.graphql.graphql");
            arrayList.add("auto.graphql.graphql22");
        }
        return arrayList;
    }

    public static boolean b(List list, String str) {
        if (str != null && list != null && !list.isEmpty()) {
            Map map = a;
            if (map.containsKey(str)) {
                return ((Boolean) map.get(str)).booleanValue();
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((io.sentry.G) it.next()).a().equalsIgnoreCase(str)) {
                    a.put(str, Boolean.TRUE);
                    return true;
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (((io.sentry.G) it2.next()).b(str)) {
                    a.put(str, Boolean.TRUE);
                    return true;
                }
                continue;
            }
            a.put(str, Boolean.FALSE);
        }
        return false;
    }
}
