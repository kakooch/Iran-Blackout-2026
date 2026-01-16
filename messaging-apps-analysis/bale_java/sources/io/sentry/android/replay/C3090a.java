package io.sentry.android.replay;

import android.gov.nist.core.Separators;
import io.sentry.C3106e;
import io.sentry.InterfaceC3212v1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC22039uZ6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C20644sM5;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.OU3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: io.sentry.android.replay.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3090a implements InterfaceC3212v1 {
    public static final b b = new b(null);
    public static final int c = 8;
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.b(EnumC4870Gx3.c, C0231a.e);
    private static final HashSet e;
    private String a;

    /* renamed from: io.sentry.android.replay.a$a, reason: collision with other inner class name */
    static final class C0231a extends AbstractC8614Ws3 implements SA2 {
        public static final C0231a e = new C0231a();

        C0231a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C20644sM5 invoke() {
            return new C20644sM5("_[a-z]");
        }
    }

    /* renamed from: io.sentry.android.replay.a$b */
    public static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C20644sM5 b() {
            return (C20644sM5) C3090a.d.getValue();
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: io.sentry.android.replay.a$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(OU3 ou3) {
            AbstractC13042fc3.i(ou3, "it");
            String upperCase = String.valueOf(AbstractC22039uZ6.u1(ou3.getValue())).toUpperCase(Locale.ROOT);
            AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
            return upperCase;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("status_code");
        hashSet.add("method");
        hashSet.add("response_content_length");
        hashSet.add("request_content_length");
        hashSet.add("http.response_content_length");
        hashSet.add("http.request_content_length");
        e = hashSet;
    }

    private final boolean c(C3106e c3106e) {
        Object obj = c3106e.s().get("url");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null && str.length() != 0) {
            Map mapS = c3106e.s();
            AbstractC13042fc3.h(mapS, "data");
            if (mapS.containsKey("http.start_timestamp")) {
                Map mapS2 = c3106e.s();
                AbstractC13042fc3.h(mapS2, "data");
                if (mapS2.containsKey("http.end_timestamp")) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String d(String str) {
        return b.b().j(str, c.e);
    }

    private final io.sentry.rrweb.i e(C3106e c3106e) {
        double dLongValue;
        double dLongValue2;
        Object obj = c3106e.s().get("http.start_timestamp");
        Object obj2 = c3106e.s().get("http.end_timestamp");
        io.sentry.rrweb.i iVar = new io.sentry.rrweb.i();
        iVar.f(c3106e.v().getTime());
        iVar.s("resource.http");
        Object obj3 = c3106e.s().get("url");
        AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type kotlin.String");
        iVar.q((String) obj3);
        if (obj instanceof Double) {
            dLongValue = ((Number) obj).doubleValue();
        } else {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Long");
            dLongValue = ((Long) obj).longValue();
        }
        iVar.u(dLongValue / 1000.0d);
        if (obj2 instanceof Double) {
            dLongValue2 = ((Number) obj2).doubleValue();
        } else {
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Long");
            dLongValue2 = ((Long) obj2).longValue();
        }
        iVar.r(dLongValue2 / 1000.0d);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map mapS = c3106e.s();
        AbstractC13042fc3.h(mapS, "breadcrumb.data");
        for (Map.Entry entry : mapS.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (e.contains(str)) {
                AbstractC13042fc3.h(str, "key");
                linkedHashMap.put(d(AbstractC20762sZ6.Z0(AbstractC20153rZ6.M(str, "content_length", "body_size", false, 4, null), Separators.DOT, null, 2, null)), value);
            }
        }
        iVar.o(linkedHashMap);
        return iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x022e  */
    @Override // io.sentry.InterfaceC3212v1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.rrweb.b a(io.sentry.C3106e r10) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.C3090a.a(io.sentry.e):io.sentry.rrweb.b");
    }
}
