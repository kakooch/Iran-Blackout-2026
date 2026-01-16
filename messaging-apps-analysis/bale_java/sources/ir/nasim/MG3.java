package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;

/* loaded from: classes5.dex */
public final class MG3 extends C9625aH3 {
    private CrowdfundingContentInfo i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MG3(CrowdfundingContentInfo crowdfundingContentInfo, C9625aH3 c9625aH3) {
        super(c9625aH3.getFileName(), c9625aH3.u(), c9625aH3.getCaption(), c9625aH3.getFileSize(), c9625aH3.w(), c9625aH3.s(), c9625aH3.z(), c9625aH3.y());
        AbstractC13042fc3.i(crowdfundingContentInfo, ParameterNames.INFO);
        AbstractC13042fc3.i(c9625aH3, "localImage");
        this.i = crowdfundingContentInfo;
    }

    public final CrowdfundingContentInfo C() {
        return this.i;
    }
}
