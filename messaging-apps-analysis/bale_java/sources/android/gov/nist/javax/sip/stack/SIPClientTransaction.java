package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.ClientTransactionExt;
import android.gov.nist.javax.sip.header.Contact;
import android.gov.nist.javax.sip.header.Event;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPResponse;
import ir.nasim.FY2;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.UP5;

/* loaded from: classes.dex */
public interface SIPClientTransaction extends ClientTransactionExt, SIPTransaction, ServerResponseInterface {
    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    void alertIfStillInCallingStateBy(int i);

    boolean checkFromTag(SIPResponse sIPResponse);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void cleanUp();

    void clearState();

    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    UP5 createAck();

    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    UP5 createCancel();

    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    SIPDialog getDefaultDialog();

    SIPDialog getDialog(String str);

    @Override // android.gov.nist.javax.sip.ClientTransactionExt, ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    InterfaceC17658nL1 getDialog();

    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    FY2 getNextHop();

    String getOriginalRequestCallId();

    Contact getOriginalRequestContact();

    Event getOriginalRequestEvent();

    String getOriginalRequestFromTag();

    String getOriginalRequestScheme();

    Via getOutgoingViaHeader();

    MessageChannel getRequestChannel();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    String getViaHost();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    int getViaPort();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    boolean isMessagePartOfTransaction(SIPMessage sIPMessage);

    boolean isNotifyOnRetransmit();

    @Override // android.gov.nist.javax.sip.stack.ServerResponseInterface
    void processResponse(SIPResponse sIPResponse, MessageChannel messageChannel);

    @Override // android.gov.nist.javax.sip.stack.ServerResponseInterface
    void processResponse(SIPResponse sIPResponse, MessageChannel messageChannel, SIPDialog sIPDialog);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void sendMessage(SIPMessage sIPMessage);

    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    void sendRequest();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void setDialog(SIPDialog sIPDialog, String str);

    void setNextHop(FY2 fy2);

    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    void setNotifyOnRetransmit(boolean z);

    void setResponseInterface(ServerResponseInterface serverResponseInterface);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    void setState(int i);

    void setTerminateDialogOnCleanUp(boolean z);

    void setViaHost(String str);

    void setViaPort(int i);

    void stopExpiresTimer();

    @Override // android.gov.nist.javax.sip.ClientTransactionExt, ir.nasim.InterfaceC10620bu7, android.gov.nist.javax.sip.TransactionExt
    void terminate();
}
