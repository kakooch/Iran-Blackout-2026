package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class all implements AdEvent {
    private final AdEvent.AdEventType a;
    private final Ad b;
    private final Map<String, String> c;

    all(AdEvent.AdEventType adEventType, Ad ad, Map<String, String> map) {
        this.a = adEventType;
        this.b = ad;
        this.c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof all)) {
            return false;
        }
        all allVar = (all) obj;
        return this.a == allVar.a && apz.b(this.b, allVar.b) && apz.b(this.c, allVar.c);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent
    public final Ad getAd() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent
    public final Map<String, String> getAdData() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent
    public final AdEvent.AdEventType getType() {
        return this.a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    public final String toString() {
        String str;
        String strValueOf = String.valueOf(String.format("AdEvent[type=%s, ad=%s", this.a, this.b));
        if (this.c == null) {
            str = "]";
        } else {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder("{");
            Iterator<Map.Entry<String, String>> it = this.c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                sb.append(next.getKey());
                sb.append(": ");
                sb.append(next.getValue());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            objArr[0] = sb.toString();
            str = String.format(", adData=%s]", objArr);
        }
        String strValueOf2 = String.valueOf(str);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }
}
