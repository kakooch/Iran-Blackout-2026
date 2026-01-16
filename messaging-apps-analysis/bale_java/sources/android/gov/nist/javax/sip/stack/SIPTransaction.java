package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.ReleaseReferencesStrategy;
import android.gov.nist.javax.sip.SipProviderImpl;
import android.gov.nist.javax.sip.TransactionExt;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import ir.nasim.C13253fu7;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.UP5;
import java.net.InetAddress;
import java.security.cert.Certificate;
import java.util.List;

/* loaded from: classes.dex */
public interface SIPTransaction extends TransactionExt {
    public static final C13253fu7 INITIAL_STATE = null;
    public static final int T1 = 1;
    public static final int TIMER_A = 1;
    public static final int TIMER_B = 64;
    public static final int TIMER_F = 64;
    public static final int TIMER_H = 64;
    public static final int TIMER_J = 64;
    public static final C13253fu7 TRYING_STATE = C13253fu7.e;
    public static final C13253fu7 CALLING_STATE = C13253fu7.d;
    public static final C13253fu7 PROCEEDING_STATE = C13253fu7.f;
    public static final C13253fu7 COMPLETED_STATE = C13253fu7.g;
    public static final C13253fu7 CONFIRMED_STATE = C13253fu7.h;
    public static final C13253fu7 TERMINATED_STATE = C13253fu7.i;

    boolean acquireSem();

    void addEventListener(SIPTransactionEventListener sIPTransactionEventListener);

    void cancelMaxTxLifeTimeTimer();

    void cleanUp();

    void close();

    void disableRetransmissionTimer();

    void disableTimeoutTimer();

    boolean doesCancelMatchTransaction(SIPRequest sIPRequest);

    @Override // android.gov.nist.javax.sip.TransactionExt
    List<String> extractCertIdentities();

    void fireRetransmissionTimer();

    void fireTimeoutTimer();

    void fireTimer();

    @Override // android.gov.nist.javax.sip.TransactionExt
    Object getApplicationData();

    long getAuditTag();

    int getBaseTimerInterval();

    String getBranch();

    @Override // android.gov.nist.javax.sip.TransactionExt
    String getBranchId();

    long getCSeq();

    @Override // android.gov.nist.javax.sip.TransactionExt
    String getCipherSuite();

    @Override // android.gov.nist.javax.sip.TransactionExt
    InterfaceC17658nL1 getDialog();

    String getForkId();

    @Override // android.gov.nist.javax.sip.TransactionExt
    String getHost();

    int getInternalState();

    String getKey();

    SIPResponse getLastResponse();

    @Override // android.gov.nist.javax.sip.TransactionExt
    Certificate[] getLocalCertificates();

    String getMergeId();

    MessageChannel getMessageChannel();

    MessageProcessor getMessageProcessor();

    String getMethod();

    SIPRequest getOriginalRequest();

    @Override // android.gov.nist.javax.sip.TransactionExt
    String getPeerAddress();

    @Override // android.gov.nist.javax.sip.TransactionExt
    Certificate[] getPeerCertificates();

    InetAddress getPeerPacketSourceAddress();

    int getPeerPacketSourcePort();

    @Override // android.gov.nist.javax.sip.TransactionExt
    int getPeerPort();

    String getPeerProtocol();

    @Override // android.gov.nist.javax.sip.TransactionExt
    int getPort();

    @Override // android.gov.nist.javax.sip.TransactionExt
    ReleaseReferencesStrategy getReleaseReferencesStrategy();

    @Override // android.gov.nist.javax.sip.TransactionExt
    UP5 getRequest();

    InterfaceC10981cX5 getResponse();

    @Override // android.gov.nist.javax.sip.TransactionExt
    int getRetransmitTimer();

    SIPTransactionStack getSIPStack();

    @Override // android.gov.nist.javax.sip.TransactionExt
    SipProviderImpl getSipProvider();

    @Override // android.gov.nist.javax.sip.TransactionExt
    C13253fu7 getState();

    int getT2();

    int getT4();

    @Override // android.gov.nist.javax.sip.TransactionExt
    int getTimerD();

    int getTimerI();

    int getTimerK();

    @Override // android.gov.nist.javax.sip.TransactionExt
    int getTimerT2();

    @Override // android.gov.nist.javax.sip.TransactionExt
    int getTimerT4();

    String getTransactionId();

    @Override // android.gov.nist.javax.sip.TransactionExt
    String getTransport();

    Via getViaHeader();

    String getViaHost();

    int getViaPort();

    int hashCode();

    boolean isByeTransaction();

    boolean isCancelTransaction();

    boolean isDialogCreatingTransaction();

    boolean isInviteTransaction();

    boolean isMessagePartOfTransaction(SIPMessage sIPMessage);

    boolean isReliable();

    boolean isSecure();

    boolean isServerTransaction();

    boolean isTerminated();

    boolean isTransactionMapped();

    boolean passToListener();

    void raiseErrorEvent(int i);

    void raiseIOExceptionEvent();

    void releaseSem();

    void removeEventListener(SIPTransactionEventListener sIPTransactionEventListener);

    void scheduleMaxTxLifeTimeTimer();

    void semRelease();

    void sendMessage(SIPMessage sIPMessage);

    @Override // android.gov.nist.javax.sip.TransactionExt
    void setApplicationData(Object obj);

    void setAuditTag(long j);

    void setBranch(String str);

    void setCollectionTime(int i);

    void setDialog(SIPDialog sIPDialog, String str);

    void setEncapsulatedChannel(MessageChannel messageChannel);

    void setForkId(String str);

    void setOriginalRequest(SIPRequest sIPRequest);

    void setPassToListener();

    @Override // android.gov.nist.javax.sip.TransactionExt
    void setReleaseReferencesStrategy(ReleaseReferencesStrategy releaseReferencesStrategy);

    @Override // android.gov.nist.javax.sip.TransactionExt
    void setRetransmitTimer(int i);

    void setState(int i);

    @Override // android.gov.nist.javax.sip.TransactionExt
    void setTimerD(int i);

    @Override // android.gov.nist.javax.sip.TransactionExt
    void setTimerT2(int i);

    @Override // android.gov.nist.javax.sip.TransactionExt
    void setTimerT4(int i);

    void setTransactionMapped(boolean z);

    void startTransactionTimer();

    @Override // android.gov.nist.javax.sip.TransactionExt
    /* synthetic */ void terminate();

    boolean testAndSetTransactionTerminatedEvent();
}
