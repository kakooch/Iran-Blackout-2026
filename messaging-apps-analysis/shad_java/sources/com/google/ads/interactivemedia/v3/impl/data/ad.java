package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.arn;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ad extends bj {
    private arn<bl> obstructions;

    ad() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bj
    public bm build() {
        arn<bl> arnVar = this.obstructions;
        String strConcat = BuildConfig.FLAVOR;
        if (arnVar == null) {
            strConcat = BuildConfig.FLAVOR.concat(" obstructions");
        }
        if (strConcat.isEmpty()) {
            return new ae(this.obstructions);
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bj
    public bj obstructions(List<bl> list) {
        this.obstructions = arn.l(list);
        return this;
    }
}
