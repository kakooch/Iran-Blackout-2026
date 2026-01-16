package android.gov.nist.javax.sip;

import ir.nasim.C13253fu7;
import ir.nasim.CV0;
import ir.nasim.FY2;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.UP5;

/* loaded from: classes.dex */
public interface ClientTransactionExt extends CV0, TransactionExt {
    void alertIfStillInCallingStateBy(int i);

    /* synthetic */ UP5 createAck();

    /* synthetic */ UP5 createCancel();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ Object getApplicationData();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ String getBranchId();

    InterfaceC17658nL1 getDefaultDialog();

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ InterfaceC17658nL1 getDialog();

    FY2 getNextHop();

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ UP5 getRequest();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ int getRetransmitTimer();

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ C13253fu7 getState();

    boolean isSecure();

    /* synthetic */ void sendRequest();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ void setApplicationData(Object obj);

    void setNotifyOnRetransmit(boolean z);

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ void setRetransmitTimer(int i);

    @Override // ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ void terminate();
}
