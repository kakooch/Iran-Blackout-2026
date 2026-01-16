package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.arn;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ae extends bm {
    private final arn<bl> obstructions;

    private ae(arn<bl> arnVar) {
        this.obstructions = arnVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bm) {
            return this.obstructions.equals(((bm) obj).obstructions());
        }
        return false;
    }

    public int hashCode() {
        return this.obstructions.hashCode() ^ 1000003;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bm
    arn<bl> obstructions() {
        return this.obstructions;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.obstructions);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
        sb.append("ObstructionListData{obstructions=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
