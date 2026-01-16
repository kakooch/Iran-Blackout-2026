package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aa extends bh {
    private final int connectionTimeoutMs;
    private final String id;
    private final int readTimeoutMs;
    private final bg requestType;
    private final String url;
    private final String userAgent;

    aa(bg bgVar, String str, String str2, String str3, int i, int i2) {
        if (bgVar == null) {
            throw new NullPointerException("Null requestType");
        }
        this.requestType = bgVar;
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.id = str;
        if (str2 == null) {
            throw new NullPointerException("Null url");
        }
        this.url = str2;
        if (str3 == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.userAgent = str3;
        this.connectionTimeoutMs = i;
        this.readTimeoutMs = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bh
    public int connectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bh) {
            bh bhVar = (bh) obj;
            if (this.requestType.equals(bhVar.requestType()) && this.id.equals(bhVar.id()) && this.url.equals(bhVar.url()) && this.userAgent.equals(bhVar.userAgent()) && this.connectionTimeoutMs == bhVar.connectionTimeoutMs() && this.readTimeoutMs == bhVar.readTimeoutMs()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.requestType.hashCode() ^ 1000003) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.url.hashCode()) * 1000003) ^ this.userAgent.hashCode()) * 1000003) ^ this.connectionTimeoutMs) * 1000003) ^ this.readTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bh
    public String id() {
        return this.id;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bh
    public int readTimeoutMs() {
        return this.readTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bh
    public bg requestType() {
        return this.requestType;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.requestType);
        String str = this.id;
        String str2 = this.url;
        String str3 = this.userAgent;
        int i = this.connectionTimeoutMs;
        int i2 = this.readTimeoutMs;
        int length = strValueOf.length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 115 + length2 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("NetworkRequestData{requestType=");
        sb.append(strValueOf);
        sb.append(", id=");
        sb.append(str);
        sb.append(", url=");
        sb.append(str2);
        sb.append(", userAgent=");
        sb.append(str3);
        sb.append(", connectionTimeoutMs=");
        sb.append(i);
        sb.append(", readTimeoutMs=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bh
    public String url() {
        return this.url;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bh
    public String userAgent() {
        return this.userAgent;
    }
}
