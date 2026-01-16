package android.gov.nist.javax.sip;

import ir.nasim.C13253fu7;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.InterfaceC5278Iq6;
import ir.nasim.UP5;

/* loaded from: classes.dex */
public interface ServerTransactionExt extends InterfaceC5278Iq6, TransactionExt {
    /* synthetic */ void enableRetransmissionAlerts();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ Object getApplicationData();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ String getBranchId();

    InterfaceC5278Iq6 getCanceledInviteTransaction();

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ InterfaceC17658nL1 getDialog();

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ UP5 getRequest();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ int getRetransmitTimer();

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ C13253fu7 getState();

    /* synthetic */ void sendResponse(InterfaceC10981cX5 interfaceC10981cX5);

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ void setApplicationData(Object obj);

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ void setRetransmitTimer(int i);

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ void terminate();
}
