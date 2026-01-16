package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class amd extends alt {
    private final int appVersion;
    private final String packageName;

    amd(int i, String str) {
        this.appVersion = i;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.packageName = str;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alt
    public int appVersion() {
        return this.appVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof alt) {
            alt altVar = (alt) obj;
            if (this.appVersion == altVar.appVersion() && this.packageName.equals(altVar.packageName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.appVersion ^ 1000003) * 1000003) ^ this.packageName.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.alt
    public String packageName() {
        return this.packageName;
    }

    public String toString() {
        int i = this.appVersion;
        String str = this.packageName;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("MarketAppInfo{appVersion=");
        sb.append(i);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
