package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ab extends bi {
    private final String content;
    private final String contentType;
    private final String id;

    ab(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.id = str;
        if (str2 == null) {
            throw new NullPointerException("Null content");
        }
        this.content = str2;
        if (str3 == null) {
            throw new NullPointerException("Null contentType");
        }
        this.contentType = str3;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bi
    public String content() {
        return this.content;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bi
    public String contentType() {
        return this.contentType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bi) {
            bi biVar = (bi) obj;
            if (this.id.equals(biVar.id()) && this.content.equals(biVar.content()) && this.contentType.equals(biVar.contentType())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.content.hashCode()) * 1000003) ^ this.contentType.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bi
    public String id() {
        return this.id;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.content;
        String str3 = this.contentType;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 48 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("NetworkResponseData{id=");
        sb.append(str);
        sb.append(", content=");
        sb.append(str2);
        sb.append(", contentType=");
        sb.append(str3);
        sb.append("}");
        return sb.toString();
    }
}
