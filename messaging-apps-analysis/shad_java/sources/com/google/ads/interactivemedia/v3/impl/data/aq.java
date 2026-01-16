package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aq extends bt {
    private final float volume;

    private aq(float f) {
        this.volume = f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof bt) && Float.floatToIntBits(this.volume) == Float.floatToIntBits(((bt) obj).volume());
    }

    public int hashCode() {
        return Float.floatToIntBits(this.volume) ^ 1000003;
    }

    public String toString() {
        float f = this.volume;
        StringBuilder sb = new StringBuilder(40);
        sb.append("VolumeUpdateData{volume=");
        sb.append(f);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bt
    public float volume() {
        return this.volume;
    }
}
