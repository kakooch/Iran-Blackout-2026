package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class r extends au {
    private final String addtlConsent;
    private final String gdprApplies;
    private final String tcString;
    private final String uspString;

    r(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new NullPointerException("Null gdprApplies");
        }
        this.gdprApplies = str;
        if (str2 == null) {
            throw new NullPointerException("Null tcString");
        }
        this.tcString = str2;
        if (str3 == null) {
            throw new NullPointerException("Null addtlConsent");
        }
        this.addtlConsent = str3;
        if (str4 == null) {
            throw new NullPointerException("Null uspString");
        }
        this.uspString = str4;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.au
    public String addtlConsent() {
        return this.addtlConsent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof au) {
            au auVar = (au) obj;
            if (this.gdprApplies.equals(auVar.gdprApplies()) && this.tcString.equals(auVar.tcString()) && this.addtlConsent.equals(auVar.addtlConsent()) && this.uspString.equals(auVar.uspString())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.au
    public String gdprApplies() {
        return this.gdprApplies;
    }

    public int hashCode() {
        return ((((((this.gdprApplies.hashCode() ^ 1000003) * 1000003) ^ this.tcString.hashCode()) * 1000003) ^ this.addtlConsent.hashCode()) * 1000003) ^ this.uspString.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.au
    public String tcString() {
        return this.tcString;
    }

    public String toString() {
        String str = this.gdprApplies;
        String str2 = this.tcString;
        String str3 = this.addtlConsent;
        String str4 = this.uspString;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 67 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("ConsentSettings{gdprApplies=");
        sb.append(str);
        sb.append(", tcString=");
        sb.append(str2);
        sb.append(", addtlConsent=");
        sb.append(str3);
        sb.append(", uspString=");
        sb.append(str4);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.au
    public String uspString() {
        return this.uspString;
    }
}
