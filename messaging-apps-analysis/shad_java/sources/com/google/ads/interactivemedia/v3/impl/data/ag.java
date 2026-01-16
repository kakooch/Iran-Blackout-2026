package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ag extends bk {
    private Boolean attached;
    private as bounds;
    private String detailedReason;
    private Boolean hidden;
    private FriendlyObstructionPurpose purpose;
    private String type;

    ag() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bk
    public bk attached(boolean z) {
        this.attached = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bk
    public bk bounds(as asVar) {
        if (asVar == null) {
            throw new NullPointerException("Null bounds");
        }
        this.bounds = asVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bk
    public bl build() {
        Boolean bool = this.attached;
        String strConcat = BuildConfig.FLAVOR;
        if (bool == null) {
            strConcat = BuildConfig.FLAVOR.concat(" attached");
        }
        if (this.bounds == null) {
            strConcat = String.valueOf(strConcat).concat(" bounds");
        }
        if (this.hidden == null) {
            strConcat = String.valueOf(strConcat).concat(" hidden");
        }
        if (this.purpose == null) {
            strConcat = String.valueOf(strConcat).concat(" purpose");
        }
        if (this.type == null) {
            strConcat = String.valueOf(strConcat).concat(" type");
        }
        if (strConcat.isEmpty()) {
            return new ah(this.attached.booleanValue(), this.bounds, this.detailedReason, this.hidden.booleanValue(), this.purpose, this.type);
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bk
    public bk detailedReason(String str) {
        this.detailedReason = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bk
    public bk hidden(boolean z) {
        this.hidden = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bk
    public bk purpose(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (friendlyObstructionPurpose == null) {
            throw new NullPointerException("Null purpose");
        }
        this.purpose = friendlyObstructionPurpose;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bk
    public bk type(String str) {
        if (str == null) {
            throw new NullPointerException("Null type");
        }
        this.type = str;
        return this;
    }
}
