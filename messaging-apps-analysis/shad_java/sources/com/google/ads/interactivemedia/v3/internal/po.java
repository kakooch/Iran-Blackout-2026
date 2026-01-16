package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class po {
    public final int a;
    public final String b;
    public final List<pn> c;
    public final byte[] d;

    public po(int i, String str, List<pn> list, byte[] bArr) {
        this.a = i;
        this.b = str;
        this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.d = bArr;
    }
}
