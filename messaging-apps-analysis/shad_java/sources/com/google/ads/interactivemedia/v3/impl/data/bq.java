package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.agt;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class bq implements UiElement {
    public static final agt<bq> GSON_TYPE_ADAPTER = new bp();
    private final String name;

    public bq(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof bq)) {
            return this.name.equals(((bq) obj).name);
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.api.UiElement
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name});
    }

    public String toString() {
        String str = this.name;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20);
        sb.append("UiElementImpl[name=");
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }
}
