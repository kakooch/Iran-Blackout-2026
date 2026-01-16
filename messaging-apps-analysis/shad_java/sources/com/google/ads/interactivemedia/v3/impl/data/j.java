package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class j extends b {
    private final String appState;
    private final String eventId;
    private final long nativeTime;
    private final boolean nativeViewAttached;
    private final as nativeViewBounds;
    private final boolean nativeViewHidden;
    private final as nativeViewVisibleBounds;
    private final double nativeVolume;
    private final String queryId;

    private j(String str, String str2, String str3, long j, double d, boolean z, boolean z2, as asVar, as asVar2) {
        this.queryId = str;
        this.eventId = str2;
        this.appState = str3;
        this.nativeTime = j;
        this.nativeVolume = d;
        this.nativeViewAttached = z;
        this.nativeViewHidden = z2;
        this.nativeViewBounds = asVar;
        this.nativeViewVisibleBounds = asVar2;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public String appState() {
        return this.appState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.queryId.equals(bVar.queryId()) && this.eventId.equals(bVar.eventId()) && this.appState.equals(bVar.appState()) && this.nativeTime == bVar.nativeTime() && Double.doubleToLongBits(this.nativeVolume) == Double.doubleToLongBits(bVar.nativeVolume()) && this.nativeViewAttached == bVar.nativeViewAttached() && this.nativeViewHidden == bVar.nativeViewHidden() && this.nativeViewBounds.equals(bVar.nativeViewBounds()) && this.nativeViewVisibleBounds.equals(bVar.nativeViewVisibleBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public String eventId() {
        return this.eventId;
    }

    public int hashCode() {
        int iHashCode = this.queryId.hashCode();
        int iHashCode2 = this.eventId.hashCode();
        int iHashCode3 = this.appState.hashCode();
        long j = this.nativeTime;
        return ((((((((((((((((iHashCode ^ 1000003) * 1000003) ^ iHashCode2) * 1000003) ^ iHashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.nativeVolume) >>> 32) ^ Double.doubleToLongBits(this.nativeVolume)))) * 1000003) ^ (true != this.nativeViewAttached ? 1237 : 1231)) * 1000003) ^ (true == this.nativeViewHidden ? 1231 : 1237)) * 1000003) ^ this.nativeViewBounds.hashCode()) * 1000003) ^ this.nativeViewVisibleBounds.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public long nativeTime() {
        return this.nativeTime;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public boolean nativeViewAttached() {
        return this.nativeViewAttached;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public as nativeViewBounds() {
        return this.nativeViewBounds;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public boolean nativeViewHidden() {
        return this.nativeViewHidden;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public as nativeViewVisibleBounds() {
        return this.nativeViewVisibleBounds;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public double nativeVolume() {
        return this.nativeVolume;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.b
    public String queryId() {
        return this.queryId;
    }

    public String toString() {
        String str = this.queryId;
        String str2 = this.eventId;
        String str3 = this.appState;
        long j = this.nativeTime;
        double d = this.nativeVolume;
        boolean z = this.nativeViewAttached;
        boolean z2 = this.nativeViewHidden;
        String strValueOf = String.valueOf(this.nativeViewBounds);
        String strValueOf2 = String.valueOf(this.nativeViewVisibleBounds);
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(length + 217 + length2 + length3 + strValueOf.length() + strValueOf2.length());
        sb.append("ActivityMonitorData{queryId=");
        sb.append(str);
        sb.append(", eventId=");
        sb.append(str2);
        sb.append(", appState=");
        sb.append(str3);
        sb.append(", nativeTime=");
        sb.append(j);
        sb.append(", nativeVolume=");
        sb.append(d);
        sb.append(", nativeViewAttached=");
        sb.append(z);
        sb.append(", nativeViewHidden=");
        sb.append(z2);
        sb.append(", nativeViewBounds=");
        sb.append(strValueOf);
        sb.append(", nativeViewVisibleBounds=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
