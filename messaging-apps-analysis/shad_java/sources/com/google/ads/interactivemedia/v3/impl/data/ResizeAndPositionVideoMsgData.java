package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = ai.class)
/* loaded from: classes.dex */
public abstract class ResizeAndPositionVideoMsgData {
    public static ResizeAndPositionVideoMsgData create(Integer num, Integer num2, Integer num3, Integer num4) {
        return new ai(num, num2, num3, num4);
    }

    public abstract Integer height();

    public final String toString() {
        String strValueOf = String.valueOf(x());
        String strValueOf2 = String.valueOf(y());
        String strValueOf3 = String.valueOf(width());
        String strValueOf4 = String.valueOf(height());
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 55 + length2 + strValueOf3.length() + strValueOf4.length());
        sb.append("ResizeAndPositionVideoMsgData [x=");
        sb.append(strValueOf);
        sb.append(", y=");
        sb.append(strValueOf2);
        sb.append(", width=");
        sb.append(strValueOf3);
        sb.append(", height=");
        sb.append(strValueOf4);
        sb.append("]");
        return sb.toString();
    }

    public abstract Integer width();

    public abstract Integer x();

    public abstract Integer y();
}
