package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.ServerTransactionExt;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import ir.nasim.C13253fu7;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.InterfaceC5278Iq6;

/* loaded from: classes.dex */
public interface SIPServerTransaction extends SIPTransaction, InterfaceC5278Iq6, ServerTransactionExt, ServerRequestInterface {
    public static final String CONTENT_SUBTYPE_SDP = "sdp";
    public static final String CONTENT_TYPE_APPLICATION = "application";

    boolean ackSeen();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void cleanUp();

    void disableRetransmissionAlerts();

    @Override // android.gov.nist.javax.sip.ServerTransactionExt
    void enableRetransmissionAlerts();

    boolean equals(Object obj);

    @Override // android.gov.nist.javax.sip.ServerTransactionExt
    SIPServerTransaction getCanceledInviteTransaction();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    InterfaceC17658nL1 getDialog();

    int getLastResponseStatusCode();

    long getPendingReliableCSeqNumber();

    long getPendingReliableRSeqNumber();

    String getPendingReliableResponseMethod();

    byte[] getReliableProvisionalResponse();

    MessageChannel getResponseChannel();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    C13253fu7 getState();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    String getViaHost();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    int getViaPort();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    boolean isMessagePartOfTransaction(SIPMessage sIPMessage);

    boolean isRetransmissionAlertEnabled();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    boolean isTransactionMapped();

    void map();

    boolean prackRecieved();

    @Override // android.gov.nist.javax.sip.stack.ServerRequestInterface
    void processRequest(SIPRequest sIPRequest, MessageChannel messageChannel);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void releaseSem();

    void resendLastResponseAsBytes();

    void scheduleAckRemoval();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void sendMessage(SIPMessage sIPMessage);

    void sendReliableProvisionalResponse(InterfaceC10981cX5 interfaceC10981cX5);

    @Override // android.gov.nist.javax.sip.ServerTransactionExt
    void sendResponse(InterfaceC10981cX5 interfaceC10981cX5);

    void setAckSeen();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void setDialog(SIPDialog sIPDialog, String str);

    void setInviteTransaction(SIPServerTransaction sIPServerTransaction);

    void setMapped(boolean z);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void setOriginalRequest(SIPRequest sIPRequest);

    void setPendingSubscribe(SIPClientTransaction sIPClientTransaction);

    void setRequestInterface(ServerRequestInterface serverRequestInterface);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void setState(int i);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void setTransactionMapped(boolean z);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    void terminate();

    void waitForTermination();
}
