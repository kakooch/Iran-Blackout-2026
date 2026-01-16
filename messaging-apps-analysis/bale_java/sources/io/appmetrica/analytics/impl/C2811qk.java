package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.qk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2811qk {
    public final C2683lc a;
    public final C2659kc b;

    public C2811qk(PublicLogger publicLogger, String str) {
        this(new C2683lc(str, publicLogger), new C2659kc(str, publicLogger));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized boolean a(C2755oc c2755oc, String str, String str2) {
        try {
            int size = c2755oc.size();
            int i = this.a.c.a;
            if (size < i || (i == c2755oc.size() && c2755oc.containsKey(str))) {
                this.b.getClass();
                int length = c2755oc.a;
                if (str2 != null) {
                    length += str2.length();
                }
                if (c2755oc.containsKey(str)) {
                    String str3 = (String) c2755oc.get(str);
                    if (str3 != null) {
                        length -= str3.length();
                    }
                } else {
                    length += str.length();
                }
                if (length <= 4500) {
                    c2755oc.put(str, str2);
                    return true;
                }
                C2659kc c2659kc = this.b;
                c2659kc.b.warning("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", c2659kc.a, 4500, str);
            } else {
                C2683lc c2683lc = this.a;
                c2683lc.d.warning("The %s has reached the limit of %d items. Item with key %s will be ignored", c2683lc.e, Integer.valueOf(c2683lc.c.a), str);
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean b(C2755oc c2755oc, String str, String str2) {
        if (c2755oc == null) {
            return false;
        }
        String strA = this.a.a.a(str);
        String strA2 = this.a.b.a(str2);
        if (!c2755oc.containsKey(strA)) {
            if (strA2 != null) {
                return a(c2755oc, strA, strA2);
            }
            return false;
        }
        String str3 = (String) c2755oc.get(strA);
        if (strA2 == null || !strA2.equals(str3)) {
            return a(c2755oc, strA, strA2);
        }
        return false;
    }

    public C2811qk(C2683lc c2683lc, C2659kc c2659kc) {
        this.a = c2683lc;
        this.b = c2659kc;
    }
}
