package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public final class S8 extends Pe {
    public final Gh a;
    public final HashMap b;
    public final B4 c;

    public S8(C2484d5 c2484d5) {
        Gh gh = new Gh(c2484d5);
        this.a = gh;
        this.c = new B4(gh);
        this.b = a();
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        map.put(Ta.EVENT_TYPE_ACTIVATION, new C2575h(this.a));
        map.put(Ta.EVENT_TYPE_START, new Dk(this.a));
        map.put(Ta.EVENT_TYPE_REGULAR, new Vf(this.a));
        C2415ab c2415ab = new C2415ab(this.a);
        map.put(Ta.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c2415ab);
        map.put(Ta.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c2415ab);
        map.put(Ta.EVENT_TYPE_SEND_REFERRER, c2415ab);
        map.put(Ta.EVENT_TYPE_CUSTOM_EVENT, c2415ab);
        Ta ta = Ta.EVENT_TYPE_SET_SESSION_EXTRA;
        Gh gh = this.a;
        map.put(ta, new C3002yk(gh, gh.t));
        map.put(Ta.EVENT_TYPE_APP_OPEN, new C2470cg(this.a));
        map.put(Ta.EVENT_TYPE_PURGE_BUFFER, new C2494df(this.a));
        map.put(Ta.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C2773p6(this.a));
        map.put(Ta.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Je(this.a));
        map.put(Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Rm(this.a));
        Qm qm = new Qm(this.a);
        map.put(Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, qm);
        map.put(Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT, qm);
        map.put(Ta.EVENT_TYPE_ANR, c2415ab);
        Ta ta2 = Ta.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Gh gh2 = this.a;
        map.put(ta2, new C3002yk(gh2, gh2.e));
        Ta ta3 = Ta.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Gh gh3 = this.a;
        map.put(ta3, new C3002yk(gh3, gh3.f));
        map.put(Ta.EVENT_TYPE_SEND_USER_PROFILE, c2415ab);
        Ta ta4 = Ta.EVENT_TYPE_SET_USER_PROFILE_ID;
        Gh gh4 = this.a;
        map.put(ta4, new C3002yk(gh4, gh4.k));
        map.put(Ta.EVENT_TYPE_SEND_REVENUE_EVENT, c2415ab);
        map.put(Ta.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c2415ab);
        map.put(Ta.EVENT_TYPE_CLEANUP, c2415ab);
        map.put(Ta.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c2415ab);
        map.put(Ta.EVENT_TYPE_WEBVIEW_SYNC, c2415ab);
        map.put(Ta.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new C2991y9(this.a));
        return map;
    }

    public final Gh b() {
        return this.a;
    }

    public final void a(Ta ta, AbstractC2610ia abstractC2610ia) {
        this.b.put(ta, abstractC2610ia);
    }

    @Override // io.appmetrica.analytics.impl.Pe
    public final R8 a(int i) {
        LinkedList linkedList = new LinkedList();
        Ta taA = Ta.a(i);
        B4 b4 = this.c;
        if (b4 != null) {
            b4.a(taA, linkedList);
        }
        AbstractC2610ia abstractC2610ia = (AbstractC2610ia) this.b.get(taA);
        if (abstractC2610ia != null) {
            abstractC2610ia.a(linkedList);
        }
        return new Q8(linkedList);
    }

    public final AbstractC2610ia a(Ta ta) {
        return (AbstractC2610ia) this.b.get(ta);
    }
}
