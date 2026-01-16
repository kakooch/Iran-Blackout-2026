package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.auj;
import com.google.ads.interactivemedia.v3.internal.aul;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class be {
    public int errorCode;
    public String errorMessage;
    public String innerError;
    public String type;

    public Map<String, String> constructMap() {
        HashMap map = new HashMap();
        map.put("type", this.type);
        map.put("errorCode", String.valueOf(this.errorCode));
        map.put("errorMessage", this.errorMessage);
        String str = this.innerError;
        if (str != null) {
            map.put("innerError", str);
        }
        return map;
    }

    public boolean equals(Object obj) {
        return auj.c(this, obj, new String[0]);
    }

    public int hashCode() {
        return aul.b(this, new String[0]);
    }

    public String toString() {
        return String.format("Log[type=%s, errorCode=%s, errorMessage=%s, innerError=%s]", this.type, Integer.valueOf(this.errorCode), this.errorMessage, this.innerError);
    }
}
