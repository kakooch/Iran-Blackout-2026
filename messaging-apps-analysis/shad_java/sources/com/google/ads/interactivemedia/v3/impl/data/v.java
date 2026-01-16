package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class v implements ay {
    private String detailedReason;
    private FriendlyObstructionPurpose purpose;
    private View view;

    v() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ay
    public az build() {
        View view = this.view;
        String strConcat = BuildConfig.FLAVOR;
        if (view == null) {
            strConcat = BuildConfig.FLAVOR.concat(" view");
        }
        if (this.purpose == null) {
            strConcat = String.valueOf(strConcat).concat(" purpose");
        }
        if (strConcat.isEmpty()) {
            return new w(this.view, this.purpose, this.detailedReason);
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ay
    public ay detailedReason(String str) {
        this.detailedReason = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ay
    public ay purpose(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (friendlyObstructionPurpose == null) {
            throw new NullPointerException("Null purpose");
        }
        this.purpose = friendlyObstructionPurpose;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ay
    public ay view(View view) {
        if (view == null) {
            throw new NullPointerException("Null view");
        }
        this.view = view;
        return this;
    }
}
