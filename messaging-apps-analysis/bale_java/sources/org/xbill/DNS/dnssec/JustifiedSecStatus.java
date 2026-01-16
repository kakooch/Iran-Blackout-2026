package org.xbill.DNS.dnssec;

/* loaded from: classes8.dex */
final class JustifiedSecStatus {
    int edeReason;
    String reason;
    SecurityStatus status;

    JustifiedSecStatus(SecurityStatus securityStatus, int i, String str) {
        this.status = securityStatus;
        this.edeReason = i;
        this.reason = str;
    }

    void applyToResponse(SMessage sMessage) {
        sMessage.setStatus(this.status, this.edeReason, this.reason);
    }
}
