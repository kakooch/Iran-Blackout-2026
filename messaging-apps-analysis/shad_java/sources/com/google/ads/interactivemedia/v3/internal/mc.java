package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class mc extends me {
    public final long a;
    public final List<md> b;
    public final List<mc> c;

    public mc(int i, long j) {
        super(i);
        this.a = j;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final void a(md mdVar) {
        this.b.add(mdVar);
    }

    public final void b(mc mcVar) {
        this.c.add(mcVar);
    }

    public final md c(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            md mdVar = this.b.get(i2);
            if (mdVar.d == i) {
                return mdVar;
            }
        }
        return null;
    }

    public final mc d(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            mc mcVar = this.c.get(i2);
            if (mcVar.d == i) {
                return mcVar;
            }
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.me
    public final String toString() {
        String strG = me.g(this.d);
        String string = Arrays.toString(this.b.toArray());
        String string2 = Arrays.toString(this.c.toArray());
        int length = String.valueOf(strG).length();
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(string).length() + String.valueOf(string2).length());
        sb.append(strG);
        sb.append(" leaves: ");
        sb.append(string);
        sb.append(" containers: ");
        sb.append(string2);
        return sb.toString();
    }
}
