package org.xbill.DNS;

import java.time.Instant;
import java.util.Date;

/* loaded from: classes8.dex */
public class RRSIGRecord extends SIGBase {
    RRSIGRecord() {
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ Instant getExpire() {
        return super.getExpire();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getLabels() {
        return super.getLabels();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ long getOrigTTL() {
        return super.getOrigTTL();
    }

    @Override // org.xbill.DNS.SIGBase, org.xbill.DNS.Record
    public /* bridge */ /* synthetic */ int getRRsetType() {
        return super.getRRsetType();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ byte[] getSignature() {
        return super.getSignature();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ Name getSigner() {
        return super.getSigner();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ Instant getTimeSigned() {
        return super.getTimeSigned();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getTypeCovered() {
        return super.getTypeCovered();
    }

    public RRSIGRecord(Name name, int i, long j, int i2, int i3, long j2, Instant instant, Instant instant2, int i4, Name name2, byte[] bArr) {
        super(name, 46, i, j, i2, i3, j2, instant, instant2, i4, name2, bArr);
    }

    @Deprecated
    public RRSIGRecord(Name name, int i, long j, int i2, int i3, long j2, Date date, Date date2, int i4, Name name2, byte[] bArr) {
        super(name, 46, i, j, i2, i3, j2, date.toInstant(), date2.toInstant(), i4, name2, bArr);
    }
}
