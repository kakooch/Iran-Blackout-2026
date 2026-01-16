package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class t extends aw {
    private final int experimentId;
    private final boolean shouldReport;

    t(int i, boolean z) {
        this.experimentId = i;
        this.shouldReport = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aw) {
            aw awVar = (aw) obj;
            if (this.experimentId == awVar.experimentId() && this.shouldReport == awVar.shouldReport()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.aw
    public int experimentId() {
        return this.experimentId;
    }

    public int hashCode() {
        return ((this.experimentId ^ 1000003) * 1000003) ^ (true != this.shouldReport ? 1237 : 1231);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.aw
    public boolean shouldReport() {
        return this.shouldReport;
    }

    public String toString() {
        int i = this.experimentId;
        boolean z = this.shouldReport;
        StringBuilder sb = new StringBuilder(65);
        sb.append("ExperimentLayerData{experimentId=");
        sb.append(i);
        sb.append(", shouldReport=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
