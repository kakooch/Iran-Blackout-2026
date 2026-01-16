package android.gov.nist.javax.sip;

import ir.nasim.AbstractC17125mR5;
import ir.nasim.C13844gu7;
import ir.nasim.C3626Bq7;
import ir.nasim.CX5;
import ir.nasim.KD6;
import ir.nasim.MP1;
import ir.nasim.UZ2;

/* loaded from: classes.dex */
public interface SipListenerExt extends KD6 {
    @Override // ir.nasim.KD6
    /* synthetic */ void processDialogTerminated(MP1 mp1);

    void processDialogTimeout(DialogTimeoutEvent dialogTimeoutEvent);

    @Override // ir.nasim.KD6
    /* synthetic */ void processIOException(UZ2 uz2);

    @Override // ir.nasim.KD6
    /* synthetic */ void processRequest(AbstractC17125mR5 abstractC17125mR5);

    @Override // ir.nasim.KD6
    /* synthetic */ void processResponse(CX5 cx5);

    @Override // ir.nasim.KD6
    /* synthetic */ void processTimeout(C3626Bq7 c3626Bq7);

    @Override // ir.nasim.KD6
    /* synthetic */ void processTransactionTerminated(C13844gu7 c13844gu7);
}
