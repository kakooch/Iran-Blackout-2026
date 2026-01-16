package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = q.class)
/* loaded from: classes.dex */
public abstract class CompanionData {
    private String companionId;

    private static CompanionData create(String str, String str2, String str3, at atVar) {
        return new q(str, str2, str3, atVar);
    }

    public abstract String clickThroughUrl();

    public String companionId() {
        return this.companionId;
    }

    public abstract String size();

    public abstract String src();

    public final String toString() {
        String strCompanionId = companionId();
        String size = size();
        String strSrc = src();
        String strClickThroughUrl = clickThroughUrl();
        String strValueOf = String.valueOf(type());
        int length = String.valueOf(strCompanionId).length();
        int length2 = String.valueOf(size).length();
        int length3 = String.valueOf(strSrc).length();
        StringBuilder sb = new StringBuilder(length + 66 + length2 + length3 + String.valueOf(strClickThroughUrl).length() + strValueOf.length());
        sb.append("CompanionData [companionId=");
        sb.append(strCompanionId);
        sb.append(", size=");
        sb.append(size);
        sb.append(", src=");
        sb.append(strSrc);
        sb.append(", clickThroughUrl=");
        sb.append(strClickThroughUrl);
        sb.append(", type=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    public abstract at type();

    public static CompanionData create(String str, String str2, String str3, String str4, at atVar) {
        CompanionData companionDataCreate = create(str2, str3, str4, atVar);
        companionDataCreate.companionId = str;
        return companionDataCreate;
    }
}
