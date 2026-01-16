package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class an extends bo {
    private final long currentTime;
    private final long duration;
    private final String timeUnit;

    an(long j, long j2, String str) {
        this.currentTime = j;
        this.duration = j2;
        if (str == null) {
            throw new NullPointerException("Null timeUnit");
        }
        this.timeUnit = str;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bo
    public long currentTime() {
        return this.currentTime;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bo
    public long duration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bo) {
            bo boVar = (bo) obj;
            if (this.currentTime == boVar.currentTime() && this.duration == boVar.duration() && this.timeUnit.equals(boVar.timeUnit())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.currentTime;
        long j2 = this.duration;
        return this.timeUnit.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bo
    public String timeUnit() {
        return this.timeUnit;
    }

    public String toString() {
        long j = this.currentTime;
        long j2 = this.duration;
        String str = this.timeUnit;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 90);
        sb.append("TimeUpdateData{currentTime=");
        sb.append(j);
        sb.append(", duration=");
        sb.append(j2);
        sb.append(", timeUnit=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
