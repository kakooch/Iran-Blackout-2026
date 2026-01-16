package android.gov.nist.javax.sip.stack;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.NameValueList;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.DialogExt;
import android.gov.nist.javax.sip.ListeningPointImpl;
import android.gov.nist.javax.sip.ReleaseReferencesStrategy;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.SipListenerExt;
import android.gov.nist.javax.sip.SipProviderImpl;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.Utils;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.address.SipUri;
import android.gov.nist.javax.sip.header.CSeq;
import android.gov.nist.javax.sip.header.Contact;
import android.gov.nist.javax.sip.header.ContactList;
import android.gov.nist.javax.sip.header.Event;
import android.gov.nist.javax.sip.header.From;
import android.gov.nist.javax.sip.header.MaxForwards;
import android.gov.nist.javax.sip.header.RAck;
import android.gov.nist.javax.sip.header.RSeq;
import android.gov.nist.javax.sip.header.Reason;
import android.gov.nist.javax.sip.header.RecordRoute;
import android.gov.nist.javax.sip.header.RecordRouteList;
import android.gov.nist.javax.sip.header.Require;
import android.gov.nist.javax.sip.header.Route;
import android.gov.nist.javax.sip.header.RouteList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.TimeStamp;
import android.gov.nist.javax.sip.header.To;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import android.gov.nist.javax.sip.message.MessageFactoryImpl;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.AddressParser;
import android.gov.nist.javax.sip.parser.CallIDParser;
import android.gov.nist.javax.sip.parser.ContactParser;
import android.gov.nist.javax.sip.parser.RecordRouteParser;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.javax.sip.DialogDoesNotExistException;
import android.javax.sip.InvalidArgumentException;
import android.javax.sip.ObjectInUseException;
import android.javax.sip.SipException;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C13253fu7;
import ir.nasim.C23720xP1;
import ir.nasim.CL4;
import ir.nasim.CV0;
import ir.nasim.FY2;
import ir.nasim.HU2;
import ir.nasim.InterfaceC10039ay5;
import ir.nasim.InterfaceC10620bu7;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC12560ep0;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.InterfaceC18352oW5;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.InterfaceC7510Sa2;
import ir.nasim.InterfaceC7782Te1;
import ir.nasim.ND6;
import ir.nasim.UP5;
import ir.nasim.UZ2;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SIPDialog implements InterfaceC17658nL1, DialogExt {
    public static final int CONFIRMED_STATE = 1;
    public static final int EARLY_STATE = 0;
    public static final int NULL_STATE = -1;
    public static final int TERMINATED_STATE = 3;
    private static StackLogger logger = CommonLogger.getLogger(SIPDialog.class);
    private static final long serialVersionUID = -1429794423085204069L;
    private transient int ackLine;
    protected transient boolean ackProcessed;
    private transient Semaphore ackSem;
    private transient AckSendingStrategy ackSendingStrategy;
    private transient Object applicationData;
    public transient long auditTag;
    protected transient boolean byeSent;
    protected InterfaceC21662tv0 callIdHeader;
    protected String callIdHeaderString;
    protected Contact contactHeader;
    protected String contactHeaderStringified;
    private transient DialogDeleteIfNoAckSentTask dialogDeleteIfNoAckSentTask;
    private transient DialogDeleteTask dialogDeleteTask;
    protected String dialogId;
    private int dialogState;
    private transient boolean dialogTerminatedEventDelivered;
    protected transient String earlyDialogId;
    private int earlyDialogTimeout;
    private transient EarlyStateTimerTask earlyStateTimerTask;
    protected InterfaceC7510Sa2 eventHeader;
    private transient Set<SIPDialogEventListener> eventListeners;
    protected SIPTransaction firstTransaction;
    protected String firstTransactionId;
    protected boolean firstTransactionIsServerTransaction;
    protected String firstTransactionMergeId;
    protected String firstTransactionMethod;
    protected int firstTransactionPort;
    protected boolean firstTransactionSecure;
    protected boolean firstTransactionSeen;
    private transient long highestSequenceNumberAcknowledged;
    protected String hisTag;
    protected transient boolean isAcknowledged;
    protected transient boolean isAssigned;
    protected boolean isBackToBackUserAgent;
    protected Long lastAckReceivedCSeqNumber;
    private transient ACKWrapper lastAckSent;
    protected transient long lastInviteOkReceived;
    protected long lastInviteResponseCSeqNumber;
    protected int lastInviteResponseCode;
    protected long lastResponseCSeqNumber;
    protected String lastResponseDialogId;
    protected String lastResponseFromTag;
    protected String lastResponseMethod;
    protected Integer lastResponseStatusCode;
    protected String lastResponseToTag;
    private Via lastResponseTopMostVia;
    protected SIPTransaction lastTransaction;
    protected InterfaceC16609la localParty;
    protected String localPartyStringified;
    protected long localSequenceNumber;
    protected String method;
    protected String myTag;
    protected transient long nextSeqno;
    private SIPDialog originalDialog;
    protected long originalLocalSequenceNumber;
    private transient SIPRequest originalRequest;
    protected transient RecordRouteList originalRequestRecordRouteHeaders;
    protected transient String originalRequestRecordRouteHeadersString;
    private boolean pendingRouteUpdateOn202Response;
    private transient int prevRetransmissionTicks;
    protected InterfaceC10039ay5 proxyAuthorizationHeader;
    protected boolean reInviteFlag;
    protected transient int reInviteWaitTime;
    private ReleaseReferencesStrategy releaseReferencesStrategy;
    protected InterfaceC16609la remoteParty;
    protected String remotePartyStringified;
    protected long remoteSequenceNumber;
    protected InterfaceC16609la remoteTarget;
    protected String remoteTargetStringified;
    private Set<String> responsesReceivedInForkingCase;
    private transient int retransmissionTicksLeft;
    protected RouteList routeList;
    protected boolean sequenceNumberValidation;
    protected boolean serverTransactionFlag;
    private transient SipProviderImpl sipProvider;
    private transient SIPTransactionStack sipStack;
    private transient String stackTrace;
    protected boolean terminateOnBye;
    protected transient DialogTimerTask timerTask;
    private transient Semaphore timerTaskLock;

    final class ACKWrapper {
        InterfaceC12560ep0 cSeq;
        String dialogId;
        String fromTag;
        String msgBytes;

        ACKWrapper(SIPRequest sIPRequest) {
            sIPRequest.setTransaction(null);
            this.msgBytes = sIPRequest.encode();
            this.fromTag = sIPRequest.getFromTag();
            this.dialogId = sIPRequest.getDialogId(false);
            this.cSeq = sIPRequest.getCSeq();
        }

        public InterfaceC12560ep0 getCSeq() {
            return this.cSeq;
        }

        public String getDialogId() {
            return this.dialogId;
        }

        public String getFromTag() {
            return this.fromTag;
        }

        public SIPRequest reparseRequest() {
            try {
                return (SIPRequest) SIPDialog.this.sipStack.getMessageParserFactory().createMessageParser(SIPDialog.this.sipStack).parseSIPMessage(this.msgBytes.getBytes("UTF-8"), true, false, null);
            } catch (Exception unused) {
                if (SIPDialog.logger.isLoggingEnabled(32)) {
                    SIPDialog.logger.logDebug("SIPDialog::resendAck:lastAck failed reparsing, hence not resending ACK");
                }
                return null;
            }
        }
    }

    public class AckSendingStrategyImpl implements AckSendingStrategy {
        private FY2 hop = null;

        public AckSendingStrategyImpl() {
        }

        @Override // android.gov.nist.javax.sip.stack.AckSendingStrategy
        public FY2 getLastHop() {
            return this.hop;
        }

        @Override // android.gov.nist.javax.sip.stack.AckSendingStrategy
        public void send(SIPRequest sIPRequest) throws SipException, UnknownHostException {
            FY2 nextHop = SIPDialog.this.sipStack.getNextHop(sIPRequest);
            this.hop = nextHop;
            if (nextHop == null) {
                throw new SipException("No route!");
            }
            if (SIPDialog.logger.isLoggingEnabled(32)) {
                SIPDialog.logger.logDebug("hop = " + this.hop);
            }
            ListeningPointImpl listeningPointImpl = (ListeningPointImpl) SIPDialog.this.sipProvider.getListeningPoint(this.hop.getTransport());
            if (listeningPointImpl != null) {
                listeningPointImpl.getMessageProcessor().createMessageChannel(InetAddress.getByName(this.hop.getHost()), this.hop.getPort()).sendMessage(sIPRequest);
            } else {
                throw new SipException("No listening point for this provider registered at " + this.hop);
            }
        }
    }

    class DialogDeleteIfNoAckSentTask extends SIPStackTimerTask implements Serializable {
        private long seqno;

        public DialogDeleteIfNoAckSentTask(long j) {
            this.seqno = j;
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return SIPDialog.this.getCallId().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            if (SIPDialog.this.highestSequenceNumberAcknowledged < this.seqno) {
                SIPDialog.this.dialogDeleteIfNoAckSentTask = null;
                if (!SIPDialog.this.isBackToBackUserAgent) {
                    if (SIPDialog.logger.isLoggingEnabled()) {
                        SIPDialog.logger.logError("ACK Was not sent. killing dialog " + SIPDialog.this.dialogId);
                    }
                    if (SIPDialog.this.sipProvider.getSipListener() instanceof SipListenerExt) {
                        SIPDialog.this.raiseErrorEvent(2);
                        return;
                    } else {
                        SIPDialog.this.delete();
                        return;
                    }
                }
                if (SIPDialog.logger.isLoggingEnabled()) {
                    SIPDialog.logger.logError("ACK Was not sent. Sending BYE " + SIPDialog.this.dialogId);
                }
                if (SIPDialog.this.sipProvider.getSipListener() instanceof SipListenerExt) {
                    SIPDialog.this.raiseErrorEvent(2);
                    return;
                }
                try {
                    UP5 up5CreateRequest = SIPDialog.this.createRequest(TokenNames.BYE);
                    if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
                        up5CreateRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                    }
                    Reason reason = new Reason();
                    reason.setProtocol("SIP");
                    reason.setCause(1025);
                    reason.setText("Timed out waiting to send ACK " + SIPDialog.this.dialogId);
                    up5CreateRequest.addHeader(reason);
                    SIPDialog.this.sendRequest(SIPDialog.this.getSipProvider().getNewClientTransaction(up5CreateRequest));
                } catch (Exception unused) {
                    SIPDialog.this.delete();
                }
            }
        }
    }

    class DialogDeleteTask extends SIPStackTimerTask implements Serializable {
        DialogDeleteTask() {
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return SIPDialog.this.getCallId().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            SIPDialog.this.delete();
        }
    }

    class DialogTimerTask extends SIPStackTimerTask implements Serializable {
        int nRetransmissions = 0;
        SIPServerTransaction transaction;

        public DialogTimerTask(SIPServerTransaction sIPServerTransaction) {
            this.transaction = sIPServerTransaction;
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void cleanUpBeforeCancel() {
            this.transaction = null;
            SIPDialog.this.cleanUpOnAck();
            super.cleanUpBeforeCancel();
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return SIPDialog.this.getCallId().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            StackLogger stackLogger;
            StringBuilder sb;
            SIPDialog sIPDialog = SIPDialog.this;
            if (SIPDialog.logger.isLoggingEnabled(32)) {
                SIPDialog.logger.logDebug("Running dialog timer");
            }
            int i = this.nRetransmissions + 1;
            this.nRetransmissions = i;
            SIPServerTransaction sIPServerTransaction = this.transaction;
            if (i > SIPDialog.this.sipStack.getAckTimeoutFactor()) {
                if (SIPDialog.this.getSipProvider().getSipListener() == null || !(SIPDialog.this.getSipProvider().getSipListener() instanceof SipListenerExt)) {
                    SIPDialog.this.delete();
                } else {
                    SIPDialog.this.raiseErrorEvent(1);
                }
                if (sIPServerTransaction != null && sIPServerTransaction.getState() != C13253fu7.i) {
                    sIPServerTransaction.raiseErrorEvent(1);
                }
            } else if (sIPServerTransaction != null && !sIPDialog.isAckSeen()) {
                try {
                    if (SIPDialog.this.lastResponseStatusCode.intValue() / 100 == 2) {
                        try {
                            if (sIPDialog.toRetransmitFinalResponse(sIPServerTransaction.getTimerT2())) {
                                sIPServerTransaction.resendLastResponseAsBytes();
                            }
                            SIPTransactionStack unused = sIPDialog.sipStack;
                        } catch (IOException unused2) {
                            SIPDialog.this.raiseIOException(sIPServerTransaction.getPeerAddress(), sIPServerTransaction.getPeerPort(), sIPServerTransaction.getPeerProtocol());
                            SIPTransactionStack unused3 = sIPDialog.sipStack;
                            if (SIPDialog.logger.isLoggingEnabled(32)) {
                                stackLogger = SIPDialog.logger;
                                sb = new StringBuilder();
                            }
                        }
                        if (SIPDialog.logger.isLoggingEnabled(32)) {
                            stackLogger = SIPDialog.logger;
                            sb = new StringBuilder();
                            sb.append("resend 200 response from ");
                            sb.append(sIPDialog);
                            stackLogger.logDebug(sb.toString());
                        }
                        sIPServerTransaction.fireTimer();
                    }
                } catch (Throwable th) {
                    SIPTransactionStack unused4 = sIPDialog.sipStack;
                    if (SIPDialog.logger.isLoggingEnabled(32)) {
                        SIPDialog.logger.logDebug("resend 200 response from " + sIPDialog);
                    }
                    sIPServerTransaction.fireTimer();
                    throw th;
                }
            }
            if (sIPDialog.isAckSeen() || sIPDialog.dialogState == 3) {
                this.transaction = null;
                SIPDialog.this.getStack().getTimer().cancel(this);
            }
        }
    }

    class EarlyStateTimerTask extends SIPStackTimerTask implements Serializable {
        public EarlyStateTimerTask() {
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return SIPDialog.this.getCallId().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            try {
                if (SIPDialog.this.getState().equals(C23720xP1.d)) {
                    SIPDialog.this.raiseErrorEvent(4);
                } else if (SIPDialog.logger.isLoggingEnabled(32)) {
                    SIPDialog.logger.logDebug("EarlyStateTimerTask : Dialog state is " + SIPDialog.this.getState());
                }
            } catch (Exception e) {
                SIPDialog.logger.logError("Unexpected exception delivering event", e);
            }
        }
    }

    class LingerTimer extends SIPStackTimerTask implements Serializable {
        LingerTimer() {
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return SIPDialog.this.getCallId().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            SIPDialog sIPDialog = SIPDialog.this;
            sIPDialog.sipStack.removeDialog(sIPDialog);
            if (((SipStackImpl) SIPDialog.this.getStack()).isReEntrantListener()) {
                SIPDialog.this.cleanUp();
            }
        }
    }

    public class ReInviteSender implements Runnable, Serializable {
        private static final long serialVersionUID = 1019346148741070635L;
        CV0 ctx;

        public ReInviteSender(CV0 cv0) {
            this.ctx = cv0;
            if (SIPDialog.logger.isLoggingEnabled(32)) {
                SIPDialog.logger.logDebug("ReInviteSender::ReInviteSender: ctx = " + cv0);
                SIPDialog.logger.logStackTrace();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (SIPDialog.logger.isLoggingEnabled(32)) {
                        SIPDialog.logger.logDebug("SIPDialog::reInviteSender: dialog = " + this.ctx.getDialog() + " lastTransaction = " + SIPDialog.this.lastTransaction + " lastTransactionState " + SIPDialog.this.lastTransaction.getState());
                    }
                    SIPTransaction sIPTransaction = SIPDialog.this.lastTransaction;
                    if (sIPTransaction != null && (sIPTransaction instanceof SIPServerTransaction) && sIPTransaction.isInviteTransaction() && SIPDialog.this.lastTransaction.getState() != C13253fu7.i) {
                        ((SIPServerTransaction) SIPDialog.this.lastTransaction).waitForTermination();
                        Thread.sleep(50L);
                    }
                    if (SIPDialog.this.takeAckSem()) {
                        z = false;
                    } else {
                        if (SIPDialog.logger.isLoggingEnabled()) {
                            SIPDialog.logger.logError("Could not send re-INVITE time out ClientTransaction");
                        }
                        ((SIPClientTransaction) this.ctx).fireTimeoutTimer();
                        if (SIPDialog.this.sipProvider.getSipListener() == null || !(SIPDialog.this.sipProvider.getSipListener() instanceof SipListenerExt)) {
                            UP5 up5CreateRequest = SIPDialog.this.createRequest(TokenNames.BYE);
                            if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
                                up5CreateRequest.addHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
                            }
                            Reason reason = new Reason();
                            reason.setCause(1024);
                            reason.setText("Timed out waiting to re-INVITE");
                            up5CreateRequest.addHeader(reason);
                            SIPDialog.this.sendRequest(SIPDialog.this.getSipProvider().getNewClientTransaction(up5CreateRequest));
                            this.ctx = null;
                            return;
                        }
                        SIPDialog.this.raiseErrorEvent(3, (SIPClientTransaction) this.ctx);
                        z = true;
                    }
                    C23720xP1 state = SIPDialog.this.getState();
                    C23720xP1 c23720xP1 = C23720xP1.g;
                    if ((state != c23720xP1 ? System.currentTimeMillis() - jCurrentTimeMillis : 0L) != 0) {
                        try {
                            Thread.sleep(SIPDialog.this.reInviteWaitTime);
                        } catch (InterruptedException unused) {
                            if (SIPDialog.logger.isLoggingEnabled(32)) {
                                SIPDialog.logger.logDebug("Interrupted sleep");
                            }
                            this.ctx = null;
                            return;
                        }
                    }
                    if (SIPDialog.this.getState() != c23720xP1 && !z && this.ctx.getState() != C13253fu7.i) {
                        SIPDialog.this.sendRequest(this.ctx, true);
                        if (SIPDialog.logger.isLoggingEnabled(32)) {
                            SIPDialog.logger.logDebug("re-INVITE successfully sent");
                        }
                    }
                } catch (Exception e) {
                    SIPDialog.logger.logError("Error sending re-INVITE", e);
                }
                this.ctx = null;
            } catch (Throwable th) {
                this.ctx = null;
                throw th;
            }
        }

        public void terminate() {
            try {
                if (SIPDialog.logger.isLoggingEnabled(32)) {
                    SIPDialog.logger.logDebug("ReInviteSender::terminate: ctx = " + this.ctx);
                }
                this.ctx.terminate();
                Thread.currentThread().interrupt();
            } catch (ObjectInUseException e) {
                SIPDialog.logger.logError("unexpected error", e);
            }
        }
    }

    private SIPDialog(SipProviderImpl sipProviderImpl) {
        this.auditTag = 0L;
        this.ackSem = new Semaphore(1);
        this.reInviteWaitTime = 100;
        this.highestSequenceNumberAcknowledged = -1L;
        this.sequenceNumberValidation = true;
        this.timerTaskLock = new Semaphore(1);
        this.firstTransactionPort = SIPConstants.DEFAULT_PORT;
        this.earlyDialogTimeout = SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
        this.responsesReceivedInForkingCase = new HashSet(0);
        this.ackSendingStrategy = new AckSendingStrategyImpl();
        this.terminateOnBye = true;
        this.routeList = new RouteList();
        this.dialogState = -1;
        this.localSequenceNumber = 0L;
        this.remoteSequenceNumber = -1L;
        this.sipProvider = sipProviderImpl;
        this.eventListeners = new CopyOnWriteArraySet();
        this.earlyDialogTimeout = ((SIPTransactionStack) sipProviderImpl.getSipStack()).getEarlyDialogTimeout();
    }

    private void addRoute(RecordRouteList recordRouteList) {
        try {
            if (isServer()) {
                this.routeList = new RouteList();
                ListIterator<RecordRoute> listIterator = recordRouteList.listIterator();
                while (listIterator.hasNext()) {
                    RecordRoute next = listIterator.next();
                    Route route = new Route();
                    route.setAddress((AddressImpl) ((AddressImpl) next.getAddress()).clone());
                    route.setParameters((NameValueList) next.getParameters().clone());
                    this.routeList.add((RouteList) route);
                }
            } else {
                this.routeList = new RouteList();
                ListIterator<RecordRoute> listIterator2 = recordRouteList.listIterator(recordRouteList.size());
                while (listIterator2.hasPrevious()) {
                    RecordRoute recordRoutePrevious = listIterator2.previous();
                    Route route2 = new Route();
                    route2.setAddress((AddressImpl) ((AddressImpl) recordRoutePrevious.getAddress()).clone());
                    route2.setParameters((NameValueList) recordRoutePrevious.getParameters().clone());
                    this.routeList.add((RouteList) route2);
                }
            }
            if (logger.isLoggingEnabled()) {
                Iterator<Route> it = this.routeList.iterator();
                while (it.hasNext()) {
                    ND6 nd6 = (ND6) it.next().getAddress().getURI();
                    if (nd6.hasLrParam()) {
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("route = " + nd6);
                        }
                    } else if (logger.isLoggingEnabled()) {
                        logger.logWarning("NON LR route in Route set detected for dialog : " + this);
                        logger.logStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            if (logger.isLoggingEnabled()) {
                Iterator<Route> it2 = this.routeList.iterator();
                while (it2.hasNext()) {
                    ND6 nd62 = (ND6) it2.next().getAddress().getURI();
                    if (nd62.hasLrParam()) {
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("route = " + nd62);
                        }
                    } else if (logger.isLoggingEnabled()) {
                        logger.logWarning("NON LR route in Route set detected for dialog : " + this);
                        logger.logStackTrace();
                    }
                }
            }
            throw th;
        }
    }

    private void doTargetRefresh(SIPMessage sIPMessage) {
        ContactList contactHeaders = sIPMessage.getContactHeaders();
        if (contactHeaders != null) {
            setRemoteTarget((Contact) contactHeaders.getFirst());
        }
    }

    private synchronized RouteList getRouteList() {
        RouteList routeList;
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("getRouteList " + this);
            }
            new RouteList();
            routeList = new RouteList();
            RouteList routeList2 = this.routeList;
            if (routeList2 != null) {
                ListIterator<Route> listIterator = routeList2.listIterator();
                while (listIterator.hasNext()) {
                    routeList.add((RouteList) listIterator.next().clone());
                }
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("----- ");
                logger.logDebug("getRouteList for " + this);
                logger.logDebug("RouteList = " + routeList.encode());
                if (this.routeList != null) {
                    logger.logDebug("myRouteList = " + this.routeList.encode());
                }
                logger.logDebug("----- ");
            }
        } catch (Throwable th) {
            throw th;
        }
        return routeList;
    }

    private static final boolean optionPresent(ListIterator listIterator, String str) {
        while (listIterator.hasNext()) {
            CL4 cl4 = (CL4) listIterator.next();
            if (cl4 != null && str.equalsIgnoreCase(cl4.getOptionTag())) {
                return true;
            }
        }
        return false;
    }

    private void printRouteList() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("this : " + this);
            logger.logDebug("printRouteList : " + this.routeList.encode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseErrorEvent(int i, SIPClientTransaction sIPClientTransaction) {
        SIPDialogErrorEvent sIPDialogErrorEvent = new SIPDialogErrorEvent(this, i);
        sIPDialogErrorEvent.setClientTransaction(sIPClientTransaction);
        synchronized (this.eventListeners) {
            try {
                Iterator<SIPDialogEventListener> it = this.eventListeners.iterator();
                while (it.hasNext()) {
                    it.next().dialogErrorEvent(sIPDialogErrorEvent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.eventListeners.clear();
        if (i != 2 && i != 1 && i != 4 && i != 3) {
            delete();
        }
        stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseIOException(String str, int i, String str2) {
        this.sipProvider.handleEvent(new UZ2(this, str, i, str2), null);
        setState(3);
    }

    private void recordStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Exception().printStackTrace(new PrintWriter(stringWriter));
        String string = Integer.toString(Math.abs(new Random().nextInt()));
        logger.logDebug("TraceRecord = " + string);
        this.stackTrace = "TraceRecord = " + string + ":" + stringWriter.getBuffer().toString();
    }

    private void sendAck(UP5 up5, boolean z) throws SipException {
        SIPRequest sIPRequest = (SIPRequest) up5;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendAck" + this);
        }
        if (!sIPRequest.getMethod().equals(TokenNames.ACK)) {
            throw new SipException("Bad request method -- should be ACK");
        }
        if (getState() == null || getState().b() == 0) {
            if (logger.isLoggingEnabled(4)) {
                logger.logError("Bad Dialog State for " + this + " dialogID = " + getDialogId());
            }
            throw new SipException("Bad dialog state " + getState());
        }
        if (!getCallId().getCallId().equals(sIPRequest.getCallId().getCallId())) {
            if (logger.isLoggingEnabled(32)) {
                logger.logError("CallID " + getCallId());
                logger.logError("RequestCallID = " + sIPRequest.getCallId().getCallId());
                logger.logError("dialog =  " + this);
            }
            throw new SipException("Bad call ID in request");
        }
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("setting from tag For outgoing ACK= " + getLocalTag());
                logger.logDebug("setting To tag for outgoing ACK = " + getRemoteTag());
                logger.logDebug("ack = " + sIPRequest);
            }
            if (getLocalTag() != null) {
                sIPRequest.getFrom().setTag(getLocalTag());
            }
            if (getRemoteTag() != null) {
                sIPRequest.getTo().setTag(getRemoteTag());
            }
            boolean z2 = !isAckSent(sIPRequest.getCSeq().getSeqNumber());
            setLastAckSent(sIPRequest);
            try {
                this.ackSendingStrategy.send(sIPRequest);
                this.isAcknowledged = true;
                this.highestSequenceNumberAcknowledged = Math.max(this.highestSequenceNumberAcknowledged, sIPRequest.getCSeq().getSeqNumber());
                if (z2 && this.isBackToBackUserAgent) {
                    releaseAckSem();
                } else if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Not releasing ack sem for " + this + " isAckSent " + z2);
                }
            } catch (SipException e) {
                if (logger.isLoggingEnabled()) {
                    logger.logException(e);
                }
                throw e;
            } catch (IOException e2) {
                if (z) {
                    throw new SipException("Could not send ack", e2);
                }
                FY2 lastHop = this.ackSendingStrategy.getLastHop();
                if (lastHop == null) {
                    lastHop = this.sipStack.getNextHop(sIPRequest);
                }
                raiseIOException(lastHop.getHost(), lastHop.getPort(), lastHop.getTransport());
            } catch (Exception e3) {
                if (logger.isLoggingEnabled()) {
                    logger.logException(e3);
                }
                throw new SipException("Could not create message channel", e3);
            }
            if (this.dialogDeleteTask != null) {
                getStack().getTimer().cancel(this.dialogDeleteTask);
                this.dialogDeleteTask = null;
            }
        } catch (ParseException e4) {
            throw new SipException(e4.getMessage());
        }
    }

    private final void setBranch(Via via, String str) {
        String branch;
        if (str.equals(TokenNames.ACK)) {
            branch = getLastResponseStatusCode().intValue() >= 300 ? this.lastResponseTopMostVia.getBranch() : Utils.getInstance().generateBranchId();
        } else if (!str.equals("CANCEL")) {
            return;
        } else {
            branch = this.lastResponseTopMostVia.getBranch();
        }
        try {
            via.setBranch(branch);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setCallId(SIPRequest sIPRequest) {
        this.callIdHeader = sIPRequest.getCallId();
    }

    private void setLastAckSent(SIPRequest sIPRequest) {
        this.lastAckSent = new ACKWrapper(sIPRequest);
    }

    private void setLocalSequenceNumber(long j) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("setLocalSequenceNumber: original  " + this.localSequenceNumber + " new  = " + j);
        }
        if (j <= this.localSequenceNumber) {
            throw new RuntimeException("Sequence number should not decrease !");
        }
        this.localSequenceNumber = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toRetransmitFinalResponse(int i) {
        int i2 = this.retransmissionTicksLeft - 1;
        this.retransmissionTicksLeft = i2;
        if (i2 != 0) {
            return false;
        }
        int i3 = this.prevRetransmissionTicks;
        if (i3 * 2 <= i) {
            this.retransmissionTicksLeft = i3 * 2;
        } else {
            this.retransmissionTicksLeft = i3;
        }
        this.prevRetransmissionTicks = this.retransmissionTicksLeft;
        return true;
    }

    private void updateRequest(SIPRequest sIPRequest) {
        RouteList routeList = getRouteList();
        if (routeList.size() > 0) {
            sIPRequest.setHeader((HU2) routeList);
        } else {
            sIPRequest.removeHeader(SIPHeaderNames.ROUTE);
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            sIPRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        }
        if (this.proxyAuthorizationHeader == null || sIPRequest.getHeader(SIPHeaderNames.PROXY_AUTHORIZATION) != null) {
            return;
        }
        sIPRequest.setHeader(this.proxyAuthorizationHeader);
    }

    void ackReceived(long j) throws InterruptedException {
        if (isAckSeen()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Ack already seen for response -- dropping");
                return;
            }
            return;
        }
        SIPServerTransaction inviteTransaction = getInviteTransaction();
        if (inviteTransaction == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("tr is null -- not updating the ack state");
                return;
            }
            return;
        }
        if (inviteTransaction.getCSeq() == j) {
            acquireTimerTaskSem();
            try {
                if (this.timerTask != null) {
                    getStack().getTimer().cancel(this.timerTask);
                    this.timerTask = null;
                }
                releaseTimerTaskSem();
                if (this.dialogDeleteTask != null) {
                    getStack().getTimer().cancel(this.dialogDeleteTask);
                    this.dialogDeleteTask = null;
                }
                this.lastAckReceivedCSeqNumber = Long.valueOf(j);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("ackReceived for " + inviteTransaction.getMethod());
                    this.ackLine = logger.getLineCount();
                    printDebugInfo();
                }
                if (this.isBackToBackUserAgent) {
                    releaseAckSem();
                }
                setState(1);
            } catch (Throwable th) {
                releaseTimerTaskSem();
                throw th;
            }
        }
    }

    public void acquireTimerTaskSem() throws InterruptedException {
        boolean zTryAcquire;
        try {
            zTryAcquire = this.timerTaskLock.tryAcquire(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            zTryAcquire = false;
        }
        if (!zTryAcquire) {
            throw new IllegalStateException("Impossible to acquire the dialog timer task lock");
        }
    }

    public void addEventListener(SIPDialogEventListener sIPDialogEventListener) {
        this.eventListeners.add(sIPDialogEventListener);
    }

    public boolean addTransaction(SIPTransaction sIPTransaction) {
        SIPRequest originalRequest = sIPTransaction.getOriginalRequest();
        if (this.firstTransactionSeen && !this.firstTransactionId.equals(sIPTransaction.getBranchId()) && sIPTransaction.getMethod().equals(this.firstTransactionMethod)) {
            setReInviteFlag(true);
            this.ackProcessed = false;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("SipDialog.addTransaction() " + this + " transaction = " + sIPTransaction);
        }
        if (!this.firstTransactionSeen) {
            storeFirstTransactionInfo(this, sIPTransaction);
            if (originalRequest.getMethod().equals(TokenNames.SUBSCRIBE)) {
                this.eventHeader = (InterfaceC7510Sa2) originalRequest.getHeader(SIPHeaderNames.EVENT);
            }
            setLocalParty(originalRequest);
            setRemoteParty(originalRequest);
            setCallId(originalRequest);
            if (this.originalRequest == null && sIPTransaction.isInviteTransaction()) {
                this.originalRequest = originalRequest;
            } else if (this.originalRequest != null) {
                this.originalRequestRecordRouteHeaders = originalRequest.getRecordRouteHeaders();
            }
            if (this.method == null) {
                this.method = originalRequest.getMethod();
            }
            if (sIPTransaction instanceof SIPServerTransaction) {
                this.hisTag = originalRequest.getFrom().getTag();
            } else {
                setLocalSequenceNumber(originalRequest.getCSeq().getSeqNumber());
                this.originalLocalSequenceNumber = getLocalSeqNumber();
                setLocalTag(originalRequest.getFrom().getTag());
                if (this.myTag == null && logger.isLoggingEnabled()) {
                    logger.logError("The request's From header is missing the required Tag parameter.");
                }
            }
        } else if (sIPTransaction.getMethod().equals(this.firstTransactionMethod) && this.firstTransactionIsServerTransaction != sIPTransaction.isServerTransaction()) {
            storeFirstTransactionInfo(this, sIPTransaction);
            setLocalParty(originalRequest);
            setRemoteParty(originalRequest);
            setCallId(originalRequest);
            if (sIPTransaction.isInviteTransaction()) {
                this.originalRequest = originalRequest;
            } else {
                this.originalRequestRecordRouteHeaders = originalRequest.getRecordRouteHeaders();
            }
            this.method = originalRequest.getMethod();
        } else if (this.firstTransaction == null && sIPTransaction.isInviteTransaction()) {
            this.firstTransaction = sIPTransaction;
        }
        if (sIPTransaction instanceof SIPServerTransaction) {
            setRemoteSequenceNumber(originalRequest.getCSeq().getSeqNumber());
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("isBackToBackUserAgent = " + this.isBackToBackUserAgent);
        }
        if (sIPTransaction.isInviteTransaction()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::setLastTransaction:dialog= " + this + " lastTransaction = " + sIPTransaction);
            }
            this.lastTransaction = sIPTransaction;
        }
        try {
            if (sIPTransaction.getRequest().getMethod().equals("REFER") && (sIPTransaction instanceof SIPServerTransaction)) {
                long seqNumber = ((SIPRequest) sIPTransaction.getRequest()).getCSeq().getSeqNumber();
                Event event = new Event();
                this.eventHeader = event;
                event.setEventType(ReferencesHeader.REFER);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("SIPDialog::setLastTransaction:lastReferCSeq = " + seqNumber);
                }
                this.eventHeader.setEventId(Long.toString(seqNumber));
            }
        } catch (Exception unused) {
            logger.logFatalError("Unexpected exception in REFER processing");
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Transaction Added " + this + this.myTag + Separators.SLASH + this.hisTag);
            logger.logDebug("TID = " + sIPTransaction.getTransactionId() + Separators.SLASH + sIPTransaction.isServerTransaction());
            logger.logStackTrace();
        }
        return true;
    }

    public void checkRetransmissionForForking(SIPResponse sIPResponse) {
        int statusCode = sIPResponse.getStatusCode();
        String method = sIPResponse.getCSeqHeader().getMethod();
        long seqNumber = sIPResponse.getCSeq().getSeqNumber();
        RSeq rSeq = (RSeq) sIPResponse.getHeader(SIPHeaderNames.RSEQ);
        String str = statusCode + Separators.SLASH + seqNumber + Separators.SLASH + method;
        if (rSeq != null) {
            str = str + Separators.SLASH + rSeq.getSeqNumber();
        }
        boolean z = !this.responsesReceivedInForkingCase.add(str);
        sIPResponse.setRetransmission(z);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("marking response as retransmission " + z + " for dialog " + this);
        }
    }

    protected void cleanUp() {
        if (getReleaseReferencesStrategy() != ReleaseReferencesStrategy.None) {
            cleanUpOnAck();
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("dialog cleanup : " + getDialogId());
            }
            Set<SIPDialogEventListener> set = this.eventListeners;
            if (set != null) {
                set.clear();
            }
            this.timerTaskLock = null;
            this.ackSem = null;
            this.contactHeader = null;
            this.eventHeader = null;
            this.firstTransactionId = null;
            this.firstTransactionMethod = null;
            this.lastResponseDialogId = null;
            this.lastResponseMethod = null;
            this.lastResponseTopMostVia = null;
            RecordRouteList recordRouteList = this.originalRequestRecordRouteHeaders;
            if (recordRouteList != null) {
                recordRouteList.clear();
                this.originalRequestRecordRouteHeaders = null;
                this.originalRequestRecordRouteHeadersString = null;
            }
            RouteList routeList = this.routeList;
            if (routeList != null) {
                routeList.clear();
                this.routeList = null;
            }
            this.responsesReceivedInForkingCase.clear();
        }
    }

    protected void cleanUpOnAck() {
        if (getReleaseReferencesStrategy() != ReleaseReferencesStrategy.None) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("cleanupOnAck : " + getDialogId());
            }
            if (this.originalRequest != null) {
                RecordRouteList recordRouteList = this.originalRequestRecordRouteHeaders;
                if (recordRouteList != null) {
                    this.originalRequestRecordRouteHeadersString = recordRouteList.toString();
                }
                this.originalRequestRecordRouteHeaders = null;
                this.originalRequest = null;
            }
            SIPTransaction sIPTransaction = this.firstTransaction;
            if (sIPTransaction != null) {
                if (sIPTransaction.getOriginalRequest() != null) {
                    this.firstTransaction.getOriginalRequest().cleanUp();
                }
                this.firstTransaction = null;
            }
            SIPTransaction sIPTransaction2 = this.lastTransaction;
            if (sIPTransaction2 != null) {
                if (sIPTransaction2.getOriginalRequest() != null) {
                    this.lastTransaction.getOriginalRequest().cleanUp();
                }
                this.lastTransaction = null;
            }
            InterfaceC21662tv0 interfaceC21662tv0 = this.callIdHeader;
            if (interfaceC21662tv0 != null) {
                this.callIdHeaderString = interfaceC21662tv0.toString();
                this.callIdHeader = null;
            }
            Contact contact = this.contactHeader;
            if (contact != null) {
                this.contactHeaderStringified = contact.toString();
                this.contactHeader = null;
            }
            InterfaceC16609la interfaceC16609la = this.remoteTarget;
            if (interfaceC16609la != null) {
                this.remoteTargetStringified = interfaceC16609la.toString();
                this.remoteTarget = null;
            }
            InterfaceC16609la interfaceC16609la2 = this.remoteParty;
            if (interfaceC16609la2 != null) {
                this.remotePartyStringified = interfaceC16609la2.toString();
                this.remoteParty = null;
            }
            InterfaceC16609la interfaceC16609la3 = this.localParty;
            if (interfaceC16609la3 != null) {
                this.localPartyStringified = interfaceC16609la3.toString();
                this.localParty = null;
            }
        }
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public UP5 createAck(long j) throws SipException, InvalidArgumentException {
        ListeningPointImpl listeningPointImpl;
        NameValueList parameters;
        if (!this.method.equals(TokenNames.INVITE)) {
            throw new SipException("Dialog was not created with an INVITE" + this.method);
        }
        if (j <= 0) {
            throw new InvalidArgumentException("bad cseq <= 0 ");
        }
        if (j > 4294967295L) {
            throw new InvalidArgumentException("bad cseq > 4294967295");
        }
        if (getRemoteTarget() == null) {
            throw new SipException("Cannot create ACK - no remote Target!");
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("createAck " + this + " cseqno " + j);
        }
        if (this.lastInviteOkReceived < j) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("WARNING : Attempt to crete ACK without OK " + this);
                logger.logDebug("LAST RESPONSE = " + getLastResponseStatusCode());
            }
            throw new SipException("Dialog not yet established -- no OK response! lastInviteOkReceived=" + this.lastInviteOkReceived + " cseqno=" + j);
        }
        try {
            RouteList routeList = this.routeList;
            ND6 nd6 = (routeList == null || routeList.isEmpty()) ? (ND6) getRemoteTarget().getURI() : (ND6) ((Route) this.routeList.getFirst()).getAddress().getURI();
            String transportParam = nd6.getTransportParam();
            if (nd6.isSecure()) {
                if (transportParam != null && transportParam.equalsIgnoreCase("UDP")) {
                    throw new SipException("Cannot create ACK - impossible to use sips uri with transport UDP:" + nd6);
                }
                transportParam = "TLS";
            }
            if (transportParam != null) {
                listeningPointImpl = (ListeningPointImpl) this.sipProvider.getListeningPoint(transportParam);
            } else if (nd6.isSecure()) {
                listeningPointImpl = (ListeningPointImpl) this.sipProvider.getListeningPoint("TLS");
            } else {
                listeningPointImpl = (ListeningPointImpl) this.sipProvider.getListeningPoint("UDP");
                if (listeningPointImpl == null) {
                    listeningPointImpl = (ListeningPointImpl) this.sipProvider.getListeningPoint("TCP");
                }
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("uri4transport =  " + nd6);
            }
            if (listeningPointImpl == null) {
                if (!nd6.isSecure()) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("No Listening point for " + nd6 + " Using last response topmost");
                    }
                    listeningPointImpl = (ListeningPointImpl) this.sipProvider.getListeningPoint(this.lastResponseTopMostVia.getTransport());
                }
                if (listeningPointImpl == null) {
                    if (logger.isLoggingEnabled(4)) {
                        logger.logError("remoteTargetURI " + getRemoteTarget().getURI());
                        logger.logError("uri4transport = " + nd6);
                        logger.logError("No LP found for transport=" + transportParam);
                    }
                    throw new SipException("Cannot create ACK - no ListeningPoint for transport towards next hop found:" + transportParam);
                }
            }
            SIPRequest sIPRequest = new SIPRequest();
            sIPRequest.setMethod(TokenNames.ACK);
            sIPRequest.setRequestURI((SipUri) getRemoteTarget().getURI().clone());
            sIPRequest.setCallId(getCallId());
            sIPRequest.setCSeq(new CSeq(j, TokenNames.ACK));
            List arrayList = new ArrayList();
            Via via = this.lastResponseTopMostVia;
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("lastResponseTopMostVia " + this.lastResponseTopMostVia);
            }
            via.removeParameters();
            SIPRequest sIPRequest2 = this.originalRequest;
            if (sIPRequest2 != null && sIPRequest2.getTopmostVia() != null && (parameters = this.originalRequest.getTopmostVia().getParameters()) != null && parameters.size() > 0) {
                via.setParameters((NameValueList) parameters.clone());
            }
            via.setBranch(Utils.getInstance().generateBranchId());
            arrayList.add(via);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Adding via to the ACK we are creating : " + via + " lastResponseTopMostVia " + this.lastResponseTopMostVia);
            }
            sIPRequest.setVia(arrayList);
            From from = new From();
            from.setAddress(getLocalParty());
            from.setTag(this.myTag);
            sIPRequest.setFrom(from);
            To to = new To();
            to.setAddress(getRemoteParty());
            String str = this.hisTag;
            if (str != null) {
                to.setTag(str);
            }
            sIPRequest.setTo(to);
            sIPRequest.setMaxForwards(new MaxForwards(70));
            SIPRequest sIPRequest3 = this.originalRequest;
            if (sIPRequest3 != null) {
                HU2 authorization = sIPRequest3.getAuthorization();
                if (authorization != null) {
                    sIPRequest.setHeader(authorization);
                }
                this.originalRequestRecordRouteHeaders = this.originalRequest.getRecordRouteHeaders();
                this.originalRequest = null;
            }
            updateRequest(sIPRequest);
            return sIPRequest;
        } catch (Exception e) {
            InternalErrorHandler.handleException(e);
            throw new SipException("unexpected exception ", e);
        }
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public UP5 createPrack(InterfaceC10981cX5 interfaceC10981cX5) throws SipException {
        if (getState() == null || getState().equals(C23720xP1.g)) {
            throw new DialogDoesNotExistException("Dialog not initialized or terminated");
        }
        if (((RSeq) interfaceC10981cX5.getHeader(SIPHeaderNames.RSEQ)) == null) {
            throw new SipException("Missing RSeq Header");
        }
        try {
            SIPResponse sIPResponse = (SIPResponse) interfaceC10981cX5;
            SIPRequest sIPRequestCreateRequest = createRequest("PRACK", sIPResponse.getTopmostVia().getTransport());
            sIPRequestCreateRequest.setToTag(sIPResponse.getTo().getTag());
            RAck rAck = new RAck();
            RSeq rSeq = (RSeq) interfaceC10981cX5.getHeader(SIPHeaderNames.RSEQ);
            rAck.setMethod(sIPResponse.getCSeq().getMethod());
            rAck.setCSequenceNumber((int) sIPResponse.getCSeq().getSeqNumber());
            rAck.setRSequenceNumber(rSeq.getSeqNumber());
            sIPRequestCreateRequest.setHeader(rAck);
            InterfaceC10039ay5 interfaceC10039ay5 = this.proxyAuthorizationHeader;
            if (interfaceC10039ay5 != null) {
                sIPRequestCreateRequest.addHeader(interfaceC10039ay5);
            }
            return sIPRequestCreateRequest;
        } catch (Exception e) {
            InternalErrorHandler.handleException(e);
            return null;
        }
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public InterfaceC10981cX5 createReliableProvisionalResponse(int i) throws SipException, InvalidArgumentException {
        ListIterator<SIPHeader> headers;
        if (!this.firstTransactionIsServerTransaction) {
            throw new SipException("Not a Server Dialog!");
        }
        if (i <= 100 || i > 199) {
            throw new InvalidArgumentException("Bad status code ");
        }
        SIPRequest sIPRequest = this.originalRequest;
        if (!sIPRequest.getMethod().equals(TokenNames.INVITE)) {
            throw new SipException("Bad method");
        }
        ListIterator<SIPHeader> headers2 = sIPRequest.getHeaders(SIPHeaderNames.SUPPORTED);
        if ((headers2 == null || !optionPresent(headers2, "100rel")) && ((headers = sIPRequest.getHeaders(SIPHeaderNames.REQUIRE)) == null || !optionPresent(headers, "100rel"))) {
            throw new SipException("No Supported/Require 100rel header in the request");
        }
        SIPResponse sIPResponseCreateResponse = sIPRequest.createResponse(i);
        Require require = new Require();
        try {
            require.setOptionTag("100rel");
        } catch (Exception e) {
            InternalErrorHandler.handleException(e);
        }
        sIPResponseCreateResponse.addHeader(require);
        new RSeq().setSeqNumber(1L);
        RecordRouteList recordRouteHeaders = sIPRequest.getRecordRouteHeaders();
        if (recordRouteHeaders != null) {
            sIPResponseCreateResponse.setHeader((HU2) recordRouteHeaders.clone());
        }
        return sIPResponseCreateResponse;
    }

    @Override // ir.nasim.InterfaceC17658nL1
    public UP5 createRequest(String str) throws SipException {
        if (str.equals(TokenNames.ACK) || str.equals("PRACK")) {
            throw new SipException("Invalid method specified for createRequest:" + str);
        }
        Via via = this.lastResponseTopMostVia;
        if (via != null) {
            return createRequest(str, via.getTransport());
        }
        throw new SipException("Dialog not yet established -- no response!");
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void delete() {
        setState(3);
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void disableSequenceNumberValidation() {
        this.sequenceNumberValidation = false;
    }

    public void doDeferredDelete() {
        if (this.sipStack.getTimer() == null) {
            setState(3);
            return;
        }
        this.dialogDeleteTask = new DialogDeleteTask();
        if (this.sipStack.getTimer() == null || !this.sipStack.getTimer().isStarted()) {
            delete();
        } else {
            this.sipStack.getTimer().schedule(this.dialogDeleteTask, (this.lastTransaction != null ? r0.getBaseTimerInterval() : SIPTransactionStack.BASE_TIMER_INTERVAL) * 64);
        }
    }

    public synchronized void doDeferredDeleteIfNoAckSent(long j) {
        try {
            if (this.sipStack.getTimer() == null) {
                setState(3);
            } else if (this.dialogDeleteIfNoAckSentTask == null) {
                this.dialogDeleteIfNoAckSentTask = new DialogDeleteIfNoAckSentTask(j);
                if (this.sipStack.getTimer() != null && this.sipStack.getTimer().isStarted()) {
                    this.sipStack.getTimer().schedule(this.dialogDeleteIfNoAckSentTask, this.sipStack.getAckTimeoutFactor() * (this.lastTransaction != null ? r4.getBaseTimerInterval() : SIPTransactionStack.BASE_TIMER_INTERVAL));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public Object getApplicationData() {
        return this.applicationData;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public InterfaceC21662tv0 getCallId() {
        if (this.callIdHeader == null && this.callIdHeaderString != null) {
            try {
                this.callIdHeader = (InterfaceC21662tv0) new CallIDParser(this.callIdHeaderString).parse();
            } catch (ParseException e) {
                logger.logError("error reparsing the call id header", e);
            }
        }
        return this.callIdHeader;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public String getDialogId() {
        String str;
        if (this.dialogId == null && (str = this.lastResponseDialogId) != null) {
            this.dialogId = str;
        }
        return this.dialogId;
    }

    String getEarlyDialogId() {
        return this.earlyDialogId;
    }

    InterfaceC7510Sa2 getEventHeader() {
        return this.eventHeader;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    @Deprecated
    public InterfaceC10620bu7 getFirstTransaction() {
        throw new UnsupportedOperationException("This method has been deprecated and is no longer supported");
    }

    public InterfaceC10620bu7 getFirstTransactionInt() {
        SIPTransaction sIPTransaction = this.firstTransaction;
        return sIPTransaction != null ? sIPTransaction : this.sipStack.findTransaction(this.firstTransactionId, this.firstTransactionIsServerTransaction);
    }

    public SIPServerTransaction getInviteTransaction() {
        DialogTimerTask dialogTimerTask = this.timerTask;
        if (dialogTimerTask != null) {
            return dialogTimerTask.transaction;
        }
        return null;
    }

    public InterfaceC12560ep0 getLastAckSentCSeq() {
        ACKWrapper aCKWrapper = this.lastAckSent;
        if (aCKWrapper != null) {
            return aCKWrapper.getCSeq();
        }
        return null;
    }

    public String getLastAckSentDialogId() {
        ACKWrapper aCKWrapper = this.lastAckSent;
        if (aCKWrapper != null) {
            return aCKWrapper.getDialogId();
        }
        return null;
    }

    public String getLastAckSentFromTag() {
        ACKWrapper aCKWrapper = this.lastAckSent;
        if (aCKWrapper != null) {
            return aCKWrapper.getFromTag();
        }
        return null;
    }

    public long getLastResponseCSeqNumber() {
        return this.lastResponseCSeqNumber;
    }

    public String getLastResponseMethod() {
        return this.lastResponseMethod;
    }

    public Integer getLastResponseStatusCode() {
        return this.lastResponseStatusCode;
    }

    public Via getLastResponseTopMostVia() {
        return this.lastResponseTopMostVia;
    }

    public SIPTransaction getLastTransaction() {
        return this.lastTransaction;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public InterfaceC16609la getLocalParty() {
        if (this.localParty == null && this.localPartyStringified != null) {
            try {
                this.localParty = new AddressParser(this.localPartyStringified).address(true);
            } catch (ParseException e) {
                logger.logError("error reparsing the localParty", e);
            }
        }
        return this.localParty;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public long getLocalSeqNumber() {
        return this.localSequenceNumber;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public int getLocalSequenceNumber() {
        return (int) this.localSequenceNumber;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public String getLocalTag() {
        return this.myTag;
    }

    public String getMergeId() {
        return this.firstTransactionMergeId;
    }

    public String getMethod() {
        return this.method;
    }

    public Contact getMyContactHeader() {
        if (this.contactHeader == null && this.contactHeaderStringified != null) {
            try {
                this.contactHeader = (Contact) new ContactParser(this.contactHeaderStringified).parse();
            } catch (ParseException e) {
                logger.logError("error reparsing the contact header", e);
            }
        }
        return this.contactHeader;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public InterfaceC17658nL1 getOriginalDialog() {
        return this.originalDialog;
    }

    public long getOriginalLocalSequenceNumber() {
        return this.originalLocalSequenceNumber;
    }

    protected RecordRouteList getOriginalRequestRecordRouteHeaders() {
        if (this.originalRequestRecordRouteHeaders == null && this.originalRequestRecordRouteHeadersString != null) {
            try {
                this.originalRequestRecordRouteHeaders = (RecordRouteList) new RecordRouteParser(this.originalRequestRecordRouteHeadersString).parse();
            } catch (ParseException e) {
                logger.logError("error reparsing the originalRequest RecordRoute Headers", e);
            }
            this.originalRequestRecordRouteHeadersString = null;
        }
        return this.originalRequestRecordRouteHeaders;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public ReleaseReferencesStrategy getReleaseReferencesStrategy() {
        return this.releaseReferencesStrategy;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public InterfaceC16609la getRemoteParty() {
        if (this.remoteParty == null && this.remotePartyStringified != null) {
            try {
                this.remoteParty = new AddressParser(this.remotePartyStringified).address(true);
            } catch (ParseException e) {
                logger.logError("error reparsing the remoteParty", e);
            }
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("gettingRemoteParty " + this.remoteParty);
        }
        return this.remoteParty;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public long getRemoteSeqNumber() {
        return this.remoteSequenceNumber;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public int getRemoteSequenceNumber() {
        return (int) this.remoteSequenceNumber;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public String getRemoteTag() {
        return this.hisTag;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public InterfaceC16609la getRemoteTarget() {
        if (this.remoteTarget == null && this.remoteTargetStringified != null) {
            try {
                this.remoteTarget = new AddressParser(this.remoteTargetStringified).address(true);
            } catch (ParseException e) {
                logger.logError("error reparsing the remoteTarget", e);
            }
        }
        return this.remoteTarget;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public Iterator getRouteSet() {
        return this.routeList == null ? new LinkedList().listIterator() : getRouteList().listIterator();
    }

    SIPTransactionStack getStack() {
        return this.sipStack;
    }

    @Override // ir.nasim.InterfaceC17658nL1
    public C23720xP1 getState() {
        int i = this.dialogState;
        if (i == -1) {
            return null;
        }
        return C23720xP1.a(i);
    }

    public boolean handleAck(SIPServerTransaction sIPServerTransaction) throws InterruptedException {
        if (isAckSeen() && getRemoteSeqNumber() == sIPServerTransaction.getCSeq()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::handleAck: ACK already seen by dialog -- dropping Ack retransmission");
            }
            acquireTimerTaskSem();
            try {
                if (this.timerTask != null) {
                    getStack().getTimer().cancel(this.timerTask);
                    this.timerTask = null;
                }
                return false;
            } finally {
                releaseTimerTaskSem();
            }
        }
        if (getState() == C23720xP1.g) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::handleAck: Dialog is terminated -- dropping ACK");
            }
            return false;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("SIPDialog::handleAck: lastResponseCSeqNumber = " + this.lastInviteOkReceived + " ackTxCSeq " + sIPServerTransaction.getCSeq());
        }
        if (this.lastResponseStatusCode == null || this.lastInviteResponseCode / 100 != 2 || this.lastInviteResponseCSeqNumber != sIPServerTransaction.getCSeq()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug(" INVITE transaction not found");
            }
            if (isBackToBackUserAgent()) {
                releaseAckSem();
            }
            return false;
        }
        sIPServerTransaction.setDialog(this, this.lastResponseDialogId);
        ackReceived(sIPServerTransaction.getCSeq());
        if (!logger.isLoggingEnabled(32)) {
            return true;
        }
        logger.logDebug("SIPDialog::handleACK: ACK for 2XX response --- sending to TU ");
        return true;
    }

    public boolean handlePrack(SIPRequest sIPRequest) {
        if (!isServer()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Dropping Prack -- not a server Dialog");
            }
            return false;
        }
        SIPServerTransaction sIPServerTransaction = (SIPServerTransaction) getFirstTransactionInt();
        if (sIPServerTransaction.getReliableProvisionalResponse() == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Dropping Prack -- ReliableResponse not found");
            }
            return false;
        }
        RAck rAck = (RAck) sIPRequest.getHeader(SIPHeaderNames.RACK);
        if (rAck == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Dropping Prack -- rack header not found");
            }
            return false;
        }
        if (!rAck.getMethod().equals(sIPServerTransaction.getPendingReliableResponseMethod())) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Dropping Prack -- CSeq Header does not match PRACK");
            }
            return false;
        }
        if (rAck.getCSeqNumberLong() != sIPServerTransaction.getPendingReliableCSeqNumber()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Dropping Prack -- CSeq Header does not match PRACK");
            }
            return false;
        }
        if (rAck.getRSequenceNumber() == sIPServerTransaction.getPendingReliableRSeqNumber()) {
            return sIPServerTransaction.prackRecieved();
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Dropping Prack -- RSeq Header does not match PRACK");
        }
        return false;
    }

    public int hashCode() {
        if (this.callIdHeader == null && this.callIdHeaderString == null) {
            return 0;
        }
        return getCallId().getCallId().hashCode();
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void incrementLocalSequenceNumber() {
        this.localSequenceNumber++;
    }

    public boolean isAckSeen() {
        if (this.lastAckReceivedCSeqNumber == null && this.lastResponseStatusCode.intValue() == 200) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::isAckSeen:" + this + "lastAckReceived is null -- returning false");
            }
            return false;
        }
        if (this.lastResponseMethod == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::isAckSeen:" + this + "lastResponse is null -- returning false");
            }
            return false;
        }
        if (this.lastAckReceivedCSeqNumber == null && this.lastResponseStatusCode.intValue() / 100 > 2) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::isAckSeen:" + this + "lastResponse statusCode " + this.lastResponseStatusCode);
            }
            return true;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("SIPDialog::isAckSeen:lastAckReceivedCSeqNumber = " + this.lastAckReceivedCSeqNumber + " remoteCSeqNumber = " + getRemoteSeqNumber());
        }
        Long l = this.lastAckReceivedCSeqNumber;
        return l != null && l.longValue() >= getRemoteSeqNumber();
    }

    public boolean isAckSent() {
        return isAckSent(-1L);
    }

    public boolean isAssigned() {
        return this.isAssigned;
    }

    public boolean isAtleastOneAckSent() {
        return this.isAcknowledged;
    }

    public boolean isBackToBackUserAgent() {
        return this.isBackToBackUserAgent;
    }

    boolean isBlockedForReInvite() {
        return this.ackSem.availablePermits() == 0;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public boolean isForked() {
        return this.originalDialog != null;
    }

    public boolean isLastAckPresent() {
        return this.lastAckSent != null;
    }

    protected boolean isReInvite() {
        return this.reInviteFlag;
    }

    public synchronized boolean isRequestConsumable(SIPRequest sIPRequest) {
        if (sIPRequest.getMethod().equals(TokenNames.ACK)) {
            throw new RuntimeException("Illegal method");
        }
        if (isSequenceNumberValidation()) {
            return this.remoteSequenceNumber < sIPRequest.getCSeq().getSeqNumber();
        }
        return true;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public boolean isSecure() {
        return this.firstTransactionSecure;
    }

    public boolean isSequenceNumberValidation() {
        return this.sequenceNumberValidation;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public boolean isServer() {
        return !this.firstTransactionSeen ? this.serverTransactionFlag : this.firstTransactionIsServerTransaction;
    }

    boolean isTerminatedOnBye() {
        return this.terminateOnBye;
    }

    public void printDebugInfo() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("isServer = " + isServer());
            logger.logDebug("localTag = " + getLocalTag());
            logger.logDebug("remoteTag = " + getRemoteTag());
            logger.logDebug("localSequenceNumer = " + getLocalSeqNumber());
            logger.logDebug("remoteSequenceNumer = " + getRemoteSeqNumber());
            logger.logDebug("ackLine:" + getRemoteTag() + Separators.SP + this.ackLine);
        }
    }

    void releaseAckSem() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("releaseAckSem-enter]]" + this + " sem=" + this.ackSem + " b2bua=" + this.isBackToBackUserAgent);
            logger.logStackTrace();
        }
        if (this.isBackToBackUserAgent) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("releaseAckSem]]" + this + " sem=" + this.ackSem);
                logger.logStackTrace();
            }
            if (this.ackSem.availablePermits() == 0) {
                this.ackSem.release();
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("releaseAckSem]]" + this + " sem=" + this.ackSem);
                }
            }
        }
    }

    public void releaseTimerTaskSem() {
        this.timerTaskLock.release();
    }

    public void removeEventListener(SIPDialogEventListener sIPDialogEventListener) {
        this.eventListeners.remove(sIPDialogEventListener);
    }

    public synchronized void requestConsumed() {
        this.nextSeqno = getRemoteSeqNumber() + 1;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Request Consumed -- next consumable Request Seqno = " + this.nextSeqno);
        }
    }

    public void resendAck() throws SipException {
        ACKWrapper aCKWrapper = this.lastAckSent;
        if (aCKWrapper == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::resendAck:lastAck sent is NULL hence not resending ACK");
                return;
            }
            return;
        }
        UP5 up5ReparseRequest = aCKWrapper.reparseRequest();
        if (up5ReparseRequest.getHeader(SIPHeaderNames.TIMESTAMP) != null && this.sipStack.generateTimeStampHeader) {
            TimeStamp timeStamp = new TimeStamp();
            try {
                timeStamp.setTimeStamp(System.currentTimeMillis());
                up5ReparseRequest.setHeader(timeStamp);
            } catch (InvalidArgumentException unused) {
            }
        }
        sendAck(up5ReparseRequest, false);
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void sendReliableProvisionalResponse(InterfaceC10981cX5 interfaceC10981cX5) throws Throwable {
        if (!isServer()) {
            throw new SipException("Not a Server Dialog");
        }
        SIPResponse sIPResponse = (SIPResponse) interfaceC10981cX5;
        if (interfaceC10981cX5.getStatusCode() == 100) {
            throw new SipException("Cannot send 100 as a reliable provisional response");
        }
        if (interfaceC10981cX5.getStatusCode() / 100 > 2) {
            throw new SipException("Response code is not a 1xx response - should be in the range 101 to 199 ");
        }
        if (sIPResponse.getToTag() == null) {
            throw new SipException("Badly formatted response -- To tag mandatory for Reliable Provisional Response");
        }
        ListIterator headers = interfaceC10981cX5.getHeaders(SIPHeaderNames.REQUIRE);
        boolean z = false;
        if (headers != null) {
            while (headers.hasNext() && !z) {
                if (((InterfaceC18352oW5) headers.next()).getOptionTag().equalsIgnoreCase("100rel")) {
                    z = true;
                }
            }
        }
        if (!z) {
            interfaceC10981cX5.addHeader(new Require("100rel"));
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Require header with optionTag 100rel is needed -- adding one");
            }
        }
        SIPServerTransaction sIPServerTransaction = (SIPServerTransaction) getFirstTransactionInt();
        setLastResponse(sIPServerTransaction, sIPResponse);
        setDialogId(sIPResponse.getDialogId(true));
        sIPServerTransaction.sendReliableProvisionalResponse(interfaceC10981cX5);
        startRetransmitTimer(sIPServerTransaction, interfaceC10981cX5);
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void sendRequest(CV0 cv0) throws SipException {
        sendRequest(cv0, !this.isBackToBackUserAgent);
    }

    public void setAckSendingStrategy(AckSendingStrategy ackSendingStrategy) {
        this.ackSendingStrategy = ackSendingStrategy;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void setApplicationData(Object obj) {
        this.applicationData = obj;
    }

    public void setAssigned() {
        this.isAssigned = true;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void setBackToBackUserAgent() {
        this.isBackToBackUserAgent = true;
    }

    public void setDialogId(String str) {
        SIPTransaction sIPTransaction = this.firstTransaction;
        if (sIPTransaction != null) {
            sIPTransaction.setDialog(this, str);
        }
        this.dialogId = str;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void setEarlyDialogTimeoutSeconds(int i) {
        if (i > 0) {
            this.earlyDialogTimeout = i;
            return;
        }
        throw new IllegalArgumentException("Invalid value " + i);
    }

    void setEventHeader(InterfaceC7510Sa2 interfaceC7510Sa2) {
        this.eventHeader = interfaceC7510Sa2;
    }

    public void setLastResponse(SIPTransaction sIPTransaction, SIPResponse sIPResponse) throws Throwable {
        String str;
        boolean z;
        boolean z2;
        String str2 = "EarlyStateTimerTask craeted ";
        this.callIdHeader = sIPResponse.getCallId();
        int statusCode = sIPResponse.getStatusCode();
        if (statusCode == 100) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Invalid status code - 100 in setLastResponse - ignoring");
                return;
            }
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logStackTrace();
        }
        try {
            this.lastResponseStatusCode = Integer.valueOf(statusCode);
            this.lastResponseTopMostVia = (Via) sIPResponse.getTopmostVia().clone();
            String method = sIPResponse.getCSeqHeader().getMethod();
            this.lastResponseMethod = method;
            long seqNumber = sIPResponse.getCSeq().getSeqNumber();
            boolean z3 = statusCode / 100 == 1;
            boolean z4 = statusCode / 100 == 2;
            this.lastResponseCSeqNumber = seqNumber;
            if (TokenNames.INVITE.equals(method)) {
                this.lastInviteResponseCSeqNumber = seqNumber;
                this.lastInviteResponseCode = statusCode;
            }
            if (sIPResponse.getToTag() != null) {
                this.lastResponseToTag = sIPResponse.getToTag();
            }
            if (sIPResponse.getFromTag() != null) {
                this.lastResponseFromTag = sIPResponse.getFromTag();
            }
            if (sIPTransaction != null) {
                this.lastResponseDialogId = sIPResponse.getDialogId(sIPTransaction.isServerTransaction());
            }
            setAssigned();
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("sipDialog: setLastResponse:" + this + " lastResponse = " + this.lastResponseStatusCode + " response " + sIPResponse.toString() + " topMostViaHeader " + this.lastResponseTopMostVia);
            }
            C23720xP1 state = getState();
            C23720xP1 c23720xP1 = C23720xP1.g;
            if (state == c23720xP1) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("sipDialog: setLastResponse -- dialog is terminated - ignoring ");
                }
                if (method.equals(TokenNames.INVITE) && statusCode == 200) {
                    this.lastInviteOkReceived = Math.max(seqNumber, this.lastInviteOkReceived);
                }
                if (!sIPResponse.getCSeq().getMethod().equals(TokenNames.INVITE) || sIPTransaction == null || !(sIPTransaction instanceof CV0) || getState() == c23720xP1) {
                    return;
                }
                acquireTimerTaskSem();
                try {
                    if (getState() == C23720xP1.d) {
                        if (this.earlyStateTimerTask != null) {
                            this.sipStack.getTimer().cancel(this.earlyStateTimerTask);
                        }
                        logger.logDebug("EarlyStateTimerTask craeted " + (this.earlyDialogTimeout * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
                        this.earlyStateTimerTask = new EarlyStateTimerTask();
                        if (this.sipStack.getTimer() != null && this.sipStack.getTimer().isStarted()) {
                            this.sipStack.getTimer().schedule(this.earlyStateTimerTask, this.earlyDialogTimeout * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                        }
                    } else if (this.earlyStateTimerTask != null) {
                        this.sipStack.getTimer().cancel(this.earlyStateTimerTask);
                        this.earlyStateTimerTask = null;
                    }
                    releaseTimerTaskSem();
                    return;
                } finally {
                }
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logStackTrace();
                logger.logDebug("cseqMethod = " + method);
                logger.logDebug("dialogState = " + getState());
                logger.logDebug("method = " + getMethod());
                logger.logDebug("statusCode = " + statusCode);
                logger.logDebug("transaction = " + sIPTransaction);
            }
            if (sIPTransaction != null) {
                str = "EarlyStateTimerTask craeted ";
                try {
                    if (!(sIPTransaction instanceof CV0)) {
                        if (method.equals(TokenNames.BYE) && z4 && isTerminatedOnBye()) {
                            setState(3);
                        } else {
                            if (getLocalTag() == null && sIPResponse.getTo().getTag() != null && SIPTransactionStack.isDialogCreated(method) && method.equals(getMethod())) {
                                setLocalTag(sIPResponse.getTo().getTag());
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z4) {
                                if (this.dialogState > 0 || !(method.equals(TokenNames.INVITE) || method.equals(TokenNames.SUBSCRIBE) || method.equals("REFER"))) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                    setState(1);
                                }
                                if (z) {
                                    setDialogId(sIPResponse.getDialogId(z2));
                                    this.sipStack.putDialog(this);
                                }
                            } else if (z3) {
                                if (z) {
                                    setState(0);
                                    setDialogId(sIPResponse.getDialogId(true));
                                    this.sipStack.putDialog(this);
                                }
                            } else if (statusCode == 489 && (method.equals(TokenNames.NOTIFY) || method.equals(TokenNames.SUBSCRIBE))) {
                                if (logger.isLoggingEnabled(32)) {
                                    logger.logDebug("RFC 3265 : Not setting dialog to TERMINATED for 489");
                                }
                            } else if (!isReInvite() && getState() != C23720xP1.e) {
                                setState(3);
                            }
                        }
                        if (sIPResponse.getCSeq().getMethod().equals(TokenNames.INVITE) || sIPTransaction == null || !(sIPTransaction instanceof CV0) || getState() == C23720xP1.g) {
                            return;
                        }
                        acquireTimerTaskSem();
                        try {
                            if (getState() == C23720xP1.d) {
                                if (this.earlyStateTimerTask != null) {
                                    this.sipStack.getTimer().cancel(this.earlyStateTimerTask);
                                }
                                logger.logDebug(str + (this.earlyDialogTimeout * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
                                this.earlyStateTimerTask = new EarlyStateTimerTask();
                                if (this.sipStack.getTimer() != null && this.sipStack.getTimer().isStarted()) {
                                    this.sipStack.getTimer().schedule(this.earlyStateTimerTask, this.earlyDialogTimeout * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                                }
                            } else if (this.earlyStateTimerTask != null) {
                                this.sipStack.getTimer().cancel(this.earlyStateTimerTask);
                                this.earlyStateTimerTask = null;
                            }
                            releaseTimerTaskSem();
                            return;
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = str;
                    if (sIPResponse.getCSeq().getMethod().equals(TokenNames.INVITE) && sIPTransaction != null && (sIPTransaction instanceof CV0) && getState() != C23720xP1.g) {
                        acquireTimerTaskSem();
                        try {
                            if (getState() == C23720xP1.d) {
                                if (this.earlyStateTimerTask != null) {
                                    this.sipStack.getTimer().cancel(this.earlyStateTimerTask);
                                }
                                logger.logDebug(str2 + (this.earlyDialogTimeout * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
                                this.earlyStateTimerTask = new EarlyStateTimerTask();
                                if (this.sipStack.getTimer() != null && this.sipStack.getTimer().isStarted()) {
                                    this.sipStack.getTimer().schedule(this.earlyStateTimerTask, this.earlyDialogTimeout * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                                }
                            } else if (this.earlyStateTimerTask != null) {
                                this.sipStack.getTimer().cancel(this.earlyStateTimerTask);
                                this.earlyStateTimerTask = null;
                            }
                            releaseTimerTaskSem();
                        } finally {
                            releaseTimerTaskSem();
                        }
                    }
                    throw th;
                }
            } else {
                str = "EarlyStateTimerTask craeted ";
            }
            if (SIPTransactionStack.isDialogCreated(method)) {
                if (getState() == null && z3) {
                    setState(0);
                    if ((sIPResponse.getToTag() != null || this.sipStack.rfc2543Supported) && getRemoteTag() == null) {
                        setRemoteTag(sIPResponse.getToTag());
                        setDialogId(sIPResponse.getDialogId(false));
                        this.sipStack.putDialog(this);
                        addRoute(sIPResponse);
                    }
                } else if (getState() != null && getState().equals(C23720xP1.d) && z3) {
                    if (method.equals(getMethod()) && sIPTransaction != null && (sIPResponse.getToTag() != null || this.sipStack.rfc2543Supported)) {
                        setRemoteTag(sIPResponse.getToTag());
                        setDialogId(sIPResponse.getDialogId(false));
                        this.sipStack.putDialog(this);
                        addRoute(sIPResponse);
                    }
                } else if (z4) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("pendingRouteUpdateOn202Response : " + this.pendingRouteUpdateOn202Response);
                    }
                    if (method.equals(getMethod()) && (sIPResponse.getToTag() != null || this.sipStack.rfc2543Supported)) {
                        C23720xP1 state2 = getState();
                        C23720xP1 c23720xP12 = C23720xP1.e;
                        if (state2 != c23720xP12 || (getState() == c23720xP12 && method.equals(TokenNames.SUBSCRIBE) && this.pendingRouteUpdateOn202Response && z4)) {
                            if (getState() != c23720xP12) {
                                setRemoteTag(sIPResponse.getToTag());
                                setDialogId(sIPResponse.getDialogId(false));
                                this.sipStack.putDialog(this);
                                addRoute(sIPResponse);
                                setState(1);
                            }
                            if (method.equals(TokenNames.SUBSCRIBE) && z4 && this.pendingRouteUpdateOn202Response) {
                                setRemoteTag(sIPResponse.getToTag());
                                addRoute(sIPResponse);
                                this.pendingRouteUpdateOn202Response = false;
                            }
                        }
                    }
                    if (method.equals(TokenNames.INVITE)) {
                        this.lastInviteOkReceived = Math.max(seqNumber, this.lastInviteOkReceived);
                        if (getState() != null && getState().b() == 1 && sIPTransaction != null) {
                            doTargetRefresh(sIPResponse);
                        }
                    }
                } else if (statusCode >= 300 && statusCode <= 699 && (getState() == null || (method.equals(getMethod()) && getState().b() == 0))) {
                    setState(3);
                }
                if (getState() != C23720xP1.e && getState() != c23720xP1 && getOriginalRequestRecordRouteHeaders() != null) {
                    ListIterator<RecordRoute> listIterator = getOriginalRequestRecordRouteHeaders().listIterator(getOriginalRequestRecordRouteHeaders().size());
                    while (listIterator.hasPrevious()) {
                        RecordRoute recordRoutePrevious = listIterator.previous();
                        Route route = (Route) this.routeList.getFirst();
                        if (route == null || !recordRoutePrevious.getAddress().equals(route.getAddress())) {
                            break;
                        } else {
                            this.routeList.removeFirst();
                        }
                    }
                }
            } else if (method.equals(TokenNames.NOTIFY) && ((getMethod().equals(TokenNames.SUBSCRIBE) || getMethod().equals("REFER")) && z4 && getState() == null)) {
                setDialogId(sIPResponse.getDialogId(true));
                this.sipStack.putDialog(this);
                setState(1);
            } else if (method.equals(TokenNames.BYE) && z4 && isTerminatedOnBye()) {
                setState(3);
            }
            if (sIPResponse.getCSeq().getMethod().equals(TokenNames.INVITE)) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected void setLocalParty(SIPMessage sIPMessage) {
        if (isServer()) {
            this.localParty = sIPMessage.getTo().getAddress();
        } else {
            this.localParty = sIPMessage.getFrom().getAddress();
        }
    }

    protected void setLocalTag(String str) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("set Local tag " + str + " dialog = " + this);
            logger.logStackTrace();
        }
        this.myTag = str;
    }

    public void setOriginalDialog(SIPDialog sIPDialog) {
        this.originalDialog = sIPDialog;
    }

    public void setPendingRouteUpdateOn202Response(SIPRequest sIPRequest) {
        this.pendingRouteUpdateOn202Response = true;
        String tag = sIPRequest.getFromHeader().getTag();
        if (tag != null) {
            setRemoteTag(tag);
        }
    }

    protected void setReInviteFlag(boolean z) {
        this.reInviteFlag = z;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void setReleaseReferencesStrategy(ReleaseReferencesStrategy releaseReferencesStrategy) {
        this.releaseReferencesStrategy = releaseReferencesStrategy;
    }

    protected void setRemoteParty(SIPMessage sIPMessage) {
        if (isServer()) {
            this.remoteParty = sIPMessage.getFrom().getAddress();
        } else {
            this.remoteParty = sIPMessage.getTo().getAddress();
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("settingRemoteParty " + this.remoteParty);
        }
    }

    public void setRemoteSequenceNumber(long j) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("setRemoteSeqno " + this + Separators.SLASH + j);
        }
        this.remoteSequenceNumber = j;
    }

    protected void setRemoteTag(String str) {
        boolean z;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("setRemoteTag(): " + this + " remoteTag = " + this.hisTag + " new tag = " + str);
        }
        String str2 = this.hisTag;
        if (str2 == null || str == null || str.equals(str2)) {
            if (str != null) {
                this.hisTag = str;
                return;
            } else {
                if (logger.isLoggingEnabled()) {
                    logger.logWarning("setRemoteTag : called with null argument ");
                    return;
                }
                return;
            }
        }
        if (getState() != C23720xP1.d) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Dialog is already established -- ignoring remote tag re-assignment");
                return;
            }
            return;
        }
        if (this.sipStack.isRemoteTagReassignmentAllowed()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("UNSAFE OPERATION !  tag re-assignment " + this.hisTag + " trying to set to " + str + " can cause unexpected effects ");
            }
            if (this.sipStack.getDialog(this.dialogId) == this) {
                this.sipStack.removeDialog(this.dialogId);
                z = true;
            } else {
                z = false;
            }
            this.dialogId = null;
            this.hisTag = str;
            if (z) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("ReInserting Dialog");
                }
                this.sipStack.putDialog(this);
            }
        }
    }

    protected void setRemoteTarget(InterfaceC7782Te1 interfaceC7782Te1) {
        this.remoteTarget = interfaceC7782Te1.getAddress();
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Dialog.setRemoteTarget: " + this.remoteTarget);
            logger.logStackTrace();
        }
    }

    public void setResponseTags(SIPResponse sIPResponse) {
        if (getLocalTag() == null && getRemoteTag() == null) {
            String fromTag = sIPResponse.getFromTag();
            if (fromTag == null) {
                if (logger.isLoggingEnabled()) {
                    logger.logWarning("No from tag in response! Not RFC 3261 compatible.");
                }
            } else if (fromTag.equals(getLocalTag())) {
                sIPResponse.setToTag(getRemoteTag());
            } else if (fromTag.equals(getRemoteTag())) {
                sIPResponse.setToTag(getLocalTag());
            }
        }
    }

    protected void setRetransmissionTicks() {
        this.retransmissionTicksLeft = 1;
        this.prevRetransmissionTicks = 1;
    }

    void setRouteList(RouteList routeList) {
        this.routeList = routeList;
    }

    void setServerTransactionFlag(boolean z) {
        this.serverTransactionFlag = z;
    }

    public void setSipProvider(SipProviderImpl sipProviderImpl) {
        this.sipProvider = sipProviderImpl;
    }

    void setStack(SIPTransactionStack sIPTransactionStack) {
        this.sipStack = sIPTransactionStack;
    }

    public void setState(int i) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("SIPDialog::setState:Setting dialog state for " + this + "newState = " + i);
            logger.logStackTrace();
            if (i != -1 && i != this.dialogState && logger.isLoggingEnabled()) {
                logger.logDebug("SIPDialog::setState:" + this + "  old dialog state is " + getState());
                logger.logDebug("SIPDialog::setState:" + this + "  New dialog state is " + C23720xP1.a(i));
            }
        }
        if (i == 0) {
            addEventListener(getSipProvider());
        }
        this.dialogState = i;
        if (i == 3) {
            removeEventListener(getSipProvider());
            if (this.sipStack.getTimer() != null && this.sipStack.getTimer().isStarted()) {
                if (this.sipStack.getConnectionLingerTimer() > 0) {
                    this.sipStack.getTimer().schedule(new LingerTimer(), this.sipStack.getConnectionLingerTimer() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                } else {
                    new LingerTimer().runTask();
                }
            }
            stopTimer();
        }
    }

    public void startRetransmitTimer(SIPServerTransaction sIPServerTransaction, InterfaceC10981cX5 interfaceC10981cX5) throws InterruptedException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("startRetransmitTimer() " + interfaceC10981cX5.getStatusCode() + " method " + sIPServerTransaction.getMethod());
        }
        if (sIPServerTransaction.isInviteTransaction() && interfaceC10981cX5.getStatusCode() / 100 == 2) {
            startTimer(sIPServerTransaction);
        }
    }

    protected void startTimer(SIPServerTransaction sIPServerTransaction) throws InterruptedException {
        DialogTimerTask dialogTimerTask = this.timerTask;
        if (dialogTimerTask != null && dialogTimerTask.transaction == sIPServerTransaction) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Timer already running for " + getDialogId());
                return;
            }
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Starting dialog timer for " + getDialogId());
        }
        acquireTimerTaskSem();
        try {
            DialogTimerTask dialogTimerTask2 = this.timerTask;
            if (dialogTimerTask2 != null) {
                dialogTimerTask2.transaction = sIPServerTransaction;
            } else {
                this.timerTask = new DialogTimerTask(sIPServerTransaction);
                if (this.sipStack.getTimer() != null && this.sipStack.getTimer().isStarted()) {
                    this.sipStack.getTimer().scheduleWithFixedDelay(this.timerTask, sIPServerTransaction.getBaseTimerInterval(), sIPServerTransaction.getBaseTimerInterval());
                }
            }
            releaseTimerTaskSem();
            setRetransmissionTicks();
        } catch (Throwable th) {
            releaseTimerTaskSem();
            throw th;
        }
    }

    protected void stopTimer() {
        try {
            acquireTimerTaskSem();
            try {
                if (this.timerTask != null) {
                    getStack().getTimer().cancel(this.timerTask);
                    this.timerTask = null;
                }
                if (this.earlyStateTimerTask != null) {
                    getStack().getTimer().cancel(this.earlyStateTimerTask);
                    this.earlyStateTimerTask = null;
                }
                releaseTimerTaskSem();
            } catch (Throwable th) {
                releaseTimerTaskSem();
                throw th;
            }
        } catch (Exception unused) {
        }
    }

    protected void storeFirstTransactionInfo(SIPDialog sIPDialog, SIPTransaction sIPTransaction) {
        sIPDialog.firstTransactionSeen = true;
        sIPDialog.firstTransaction = sIPTransaction;
        boolean zIsServerTransaction = sIPTransaction.isServerTransaction();
        sIPDialog.firstTransactionIsServerTransaction = zIsServerTransaction;
        if (zIsServerTransaction) {
            sIPDialog.firstTransactionSecure = sIPTransaction.getRequest().getRequestURI().getScheme().equalsIgnoreCase("sips");
        } else {
            sIPDialog.firstTransactionSecure = ((SIPClientTransaction) sIPTransaction).getOriginalRequestScheme().equalsIgnoreCase("sips");
        }
        sIPDialog.firstTransactionPort = sIPTransaction.getPort();
        sIPDialog.firstTransactionId = sIPTransaction.getBranchId();
        String method = sIPTransaction.getMethod();
        sIPDialog.firstTransactionMethod = method;
        if ((sIPTransaction instanceof SIPServerTransaction) && method.equals(TokenNames.INVITE)) {
            this.sipStack.removeMergeDialog(this.firstTransactionMergeId);
            sIPDialog.firstTransactionMergeId = sIPTransaction.getMergeId();
            this.sipStack.putMergeDialog(this);
        }
        if (sIPTransaction.isServerTransaction()) {
            SIPResponse lastResponse = ((SIPServerTransaction) sIPTransaction).getLastResponse();
            sIPDialog.contactHeader = lastResponse != null ? lastResponse.getContactHeader() : null;
        } else {
            sIPDialog.contactHeader = ((SIPClientTransaction) sIPTransaction).getOriginalRequestContact();
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("firstTransaction = " + sIPDialog.firstTransaction);
            logger.logDebug("firstTransactionIsServerTransaction = " + this.firstTransactionIsServerTransaction);
            logger.logDebug("firstTransactionSecure = " + this.firstTransactionSecure);
            logger.logDebug("firstTransactionPort = " + this.firstTransactionPort);
            logger.logDebug("firstTransactionId = " + this.firstTransactionId);
            logger.logDebug("firstTransactionMethod = " + this.firstTransactionMethod);
            logger.logDebug("firstTransactionMergeId = " + this.firstTransactionMergeId);
        }
    }

    boolean takeAckSem() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("[takeAckSem " + this + " sem=" + this.ackSem);
        }
        try {
            if (this.ackSem.tryAcquire(2L, TimeUnit.SECONDS)) {
                if (!logger.isLoggingEnabled(32)) {
                    return true;
                }
                recordStackTrace();
                return true;
            }
            if (logger.isLoggingEnabled()) {
                logger.logError("Cannot aquire ACK semaphore ");
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Semaphore previously acquired at " + this.stackTrace + " sem=" + this.ackSem);
                logger.logStackTrace();
            }
            return false;
        } catch (InterruptedException unused) {
            logger.logError("Cannot aquire ACK semaphore");
            return false;
        }
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void terminateOnBye(boolean z) {
        this.terminateOnBye = z;
    }

    synchronized boolean testAndSetIsDialogTerminatedEventDelivered() {
        boolean z;
        z = this.dialogTerminatedEventDelivered;
        this.dialogTerminatedEventDelivered = true;
        return z;
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public SipProviderImpl getSipProvider() {
        return this.sipProvider;
    }

    public boolean isAckSent(long j) {
        if (getLastTransaction() != null && (getLastTransaction() instanceof CV0)) {
            return this.lastAckSent != null && j <= getLastAckSentCSeq().getSeqNumber();
        }
        return true;
    }

    public void sendRequest(CV0 cv0, boolean z) throws SipException {
        if (cv0 == null) {
            throw new NullPointerException("null parameter");
        }
        if (!z && cv0.getRequest().getMethod().equals(TokenNames.INVITE)) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SIPDialog::sendRequest " + this + " clientTransaction = " + cv0);
            }
            this.sipStack.getReinviteExecutor().execute(new ReInviteSender(cv0));
            return;
        }
        SIPClientTransaction sIPClientTransaction = (SIPClientTransaction) cv0;
        SIPRequest originalRequest = sIPClientTransaction.getOriginalRequest();
        this.proxyAuthorizationHeader = (InterfaceC10039ay5) originalRequest.getHeader(SIPHeaderNames.PROXY_AUTHORIZATION);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("SIPDialog::sendRequest:dialog.sendRequest  dialog = " + this + "\ndialogRequest = \n" + originalRequest);
        }
        if (originalRequest.getMethod().equals(TokenNames.ACK) || originalRequest.getMethod().equals("CANCEL")) {
            throw new SipException("Bad Request Method. " + originalRequest.getMethod());
        }
        if (this.byeSent && isTerminatedOnBye() && !originalRequest.getMethod().equals(TokenNames.BYE)) {
            if (logger.isLoggingEnabled()) {
                logger.logError("BYE already sent for " + this);
            }
            throw new SipException("Cannot send request; BYE already sent");
        }
        if (originalRequest.getTopmostVia() == null) {
            originalRequest.addHeader(sIPClientTransaction.getOutgoingViaHeader());
        }
        if (!getCallId().getCallId().equalsIgnoreCase(originalRequest.getCallId().getCallId())) {
            if (logger.isLoggingEnabled()) {
                logger.logError("CallID " + getCallId());
                logger.logError("SIPDialog::sendRequest:RequestCallID = " + originalRequest.getCallId().getCallId());
                logger.logError("dialog =  " + this);
            }
            throw new SipException("Bad call ID in request");
        }
        sIPClientTransaction.setDialog(this, this.dialogId);
        addTransaction((SIPTransaction) cv0);
        sIPClientTransaction.setTransactionMapped(true);
        From from = (From) originalRequest.getFrom();
        To to = (To) originalRequest.getTo();
        if (getLocalTag() != null && from.getTag() != null && !from.getTag().equals(getLocalTag())) {
            throw new SipException("From tag mismatch expecting  " + getLocalTag());
        }
        if (getRemoteTag() != null && to.getTag() != null && !to.getTag().equals(getRemoteTag()) && logger.isLoggingEnabled()) {
            logger.logWarning("SIPDialog::sendRequest:To header tag mismatch expecting " + getRemoteTag());
        }
        if (getLocalTag() == null && originalRequest.getMethod().equals(TokenNames.NOTIFY)) {
            if (!getMethod().equals(TokenNames.SUBSCRIBE)) {
                throw new SipException("Trying to send NOTIFY without SUBSCRIBE Dialog!");
            }
            setLocalTag(from.getTag());
        }
        try {
            if (getLocalTag() != null) {
                from.setTag(getLocalTag());
            }
            if (getRemoteTag() != null) {
                to.setTag(getRemoteTag());
            }
        } catch (ParseException e) {
            InternalErrorHandler.handleException(e);
        }
        FY2 nextHop = sIPClientTransaction.getNextHop();
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("SIPDialog::sendRequest:Using hop = " + nextHop.getHost() + " : " + nextHop.getPort());
        }
        try {
            MessageChannel messageChannelCreateRawMessageChannel = this.sipStack.createRawMessageChannel(getSipProvider().getListeningPoint(nextHop.getTransport()).getIPAddress(), this.firstTransactionPort, nextHop);
            MessageChannel messageChannel = ((SIPClientTransaction) cv0).getMessageChannel();
            messageChannel.uncache();
            if (!this.sipStack.cacheClientConnections) {
                messageChannel.useCount--;
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("SIPDialog::sendRequest:oldChannel: useCount " + messageChannel.useCount);
                }
            }
            if (messageChannelCreateRawMessageChannel == null) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Null message channel using outbound proxy !");
                }
                FY2 outboundProxy = this.sipStack.getRouter(originalRequest).getOutboundProxy();
                if (outboundProxy == null) {
                    throw new SipException("No route found! hop=" + nextHop);
                }
                messageChannelCreateRawMessageChannel = this.sipStack.createRawMessageChannel(getSipProvider().getListeningPoint(outboundProxy.getTransport()).getIPAddress(), this.firstTransactionPort, outboundProxy);
                if (messageChannelCreateRawMessageChannel != null) {
                    ((SIPClientTransaction) cv0).setEncapsulatedChannel(messageChannelCreateRawMessageChannel);
                }
            } else {
                ((SIPClientTransaction) cv0).setEncapsulatedChannel(messageChannelCreateRawMessageChannel);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("SIPDialog::sendRequest:using message channel " + messageChannelCreateRawMessageChannel);
                }
            }
            if (messageChannelCreateRawMessageChannel != null) {
                messageChannelCreateRawMessageChannel.useCount++;
            }
            if (!this.sipStack.cacheClientConnections && messageChannel.useCount <= 0) {
                messageChannel.close();
            }
            try {
                long localSeqNumber = originalRequest.getCSeq() == null ? getLocalSeqNumber() : originalRequest.getCSeq().getSeqNumber();
                if (localSeqNumber > getLocalSeqNumber()) {
                    setLocalSequenceNumber(localSeqNumber);
                } else {
                    setLocalSequenceNumber(getLocalSeqNumber() + 1);
                }
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("SIPDialog::sendRequest:setting Seq Number to " + getLocalSeqNumber());
                }
                originalRequest.getCSeq().setSeqNumber(getLocalSeqNumber());
            } catch (InvalidArgumentException e2) {
                logger.logFatalError(e2.getMessage());
            }
            try {
                ((SIPClientTransaction) cv0).sendMessage(originalRequest);
                if (originalRequest.getMethod().equals(TokenNames.BYE)) {
                    this.byeSent = true;
                    if (isTerminatedOnBye()) {
                        setState(3);
                    }
                }
            } catch (IOException e3) {
                throw new SipException("error sending message", e3);
            }
        } catch (Exception e4) {
            if (logger.isLoggingEnabled()) {
                logger.logException(e4);
            }
            throw new SipException("Could not create message channel", e4);
        }
    }

    private SIPRequest createRequest(String str, String str2) throws SipException {
        SipUri sipUri;
        HU2 hu2;
        HU2 hu22;
        if (str != null && str2 != null) {
            if (!str.equals("CANCEL")) {
                if (getState() != null && ((getState().b() != 3 || str.equalsIgnoreCase(TokenNames.BYE)) && (!isServer() || getState().b() != 0 || !str.equalsIgnoreCase(TokenNames.BYE)))) {
                    if (getRemoteTarget() != null) {
                        sipUri = (SipUri) getRemoteTarget().getURI().clone();
                    } else {
                        sipUri = (SipUri) getRemoteParty().getURI().clone();
                        sipUri.clearUriParms();
                    }
                    SipUri sipUri2 = sipUri;
                    CSeq cSeq = new CSeq();
                    try {
                        cSeq.setMethod(str);
                        cSeq.setSeqNumber(getLocalSeqNumber());
                    } catch (Exception e) {
                        if (logger.isLoggingEnabled()) {
                            logger.logError("Unexpected error");
                        }
                        InternalErrorHandler.handleException(e);
                    }
                    ListeningPointImpl listeningPointImpl = (ListeningPointImpl) this.sipProvider.getListeningPoint(str2);
                    if (listeningPointImpl == null) {
                        if (logger.isLoggingEnabled()) {
                            logger.logError("Cannot find listening point for transport " + str2);
                        }
                        throw new SipException("Cannot find listening point for transport " + str2);
                    }
                    Via viaHeader = listeningPointImpl.getViaHeader();
                    From from = new From();
                    from.setAddress(getLocalParty());
                    To to = new To();
                    to.setAddress(getRemoteParty());
                    SIPRequest sIPRequestCreateRequest = createRequest(sipUri2, viaHeader, cSeq, from, to);
                    if (SIPRequest.isTargetRefresh(str)) {
                        InterfaceC7782Te1 interfaceC7782Te1CreateContactHeader = ((ListeningPointImpl) this.sipProvider.getListeningPoint(listeningPointImpl.getTransport())).createContactHeader();
                        ((ND6) interfaceC7782Te1CreateContactHeader.getAddress().getURI()).setSecure(isSecure());
                        sIPRequestCreateRequest.setHeader(interfaceC7782Te1CreateContactHeader);
                    }
                    try {
                        CSeq cSeq2 = (CSeq) sIPRequestCreateRequest.getCSeq();
                        cSeq2.setSeqNumber(getLocalSeqNumber() + 1);
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("SIPDialog::createRequest:setting Request Seq Number to " + cSeq2.getSeqNumber());
                        }
                    } catch (InvalidArgumentException e2) {
                        InternalErrorHandler.handleException(e2);
                    }
                    if (str.equals(TokenNames.SUBSCRIBE) && (hu22 = this.eventHeader) != null) {
                        sIPRequestCreateRequest.addHeader(hu22);
                    }
                    if (str.equals(TokenNames.NOTIFY) && (hu2 = this.eventHeader) != null) {
                        sIPRequestCreateRequest.addHeader(hu2);
                    }
                    try {
                        if (getLocalTag() != null) {
                            from.setTag(getLocalTag());
                        } else {
                            from.removeTag();
                        }
                        if (getRemoteTag() != null) {
                            to.setTag(getRemoteTag());
                        } else {
                            to.removeTag();
                        }
                    } catch (ParseException e3) {
                        InternalErrorHandler.handleException(e3);
                    }
                    updateRequest(sIPRequestCreateRequest);
                    return sIPRequestCreateRequest;
                }
                throw new SipException("Dialog  " + getDialogId() + " not yet established or terminated " + getState());
            }
            throw new SipException("Dialog.createRequest(): Invalid request");
        }
        throw new NullPointerException("null argument");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseErrorEvent(int i) {
        raiseErrorEvent(i, null);
    }

    public SIPDialog(SIPTransaction sIPTransaction) {
        this(sIPTransaction.getSipProvider());
        SIPRequest sIPRequest = (SIPRequest) sIPTransaction.getRequest();
        this.callIdHeader = sIPRequest.getCallId();
        this.earlyDialogId = sIPRequest.getDialogId(false);
        this.sipStack = sIPTransaction.getSIPStack();
        SipProviderImpl sipProvider = sIPTransaction.getSipProvider();
        this.sipProvider = sipProvider;
        if (sipProvider != null) {
            this.isBackToBackUserAgent = this.sipStack.isBackToBackUserAgent;
            addTransaction(sIPTransaction);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Creating a dialog : " + this);
                logger.logDebug("provider port = " + this.sipProvider.getListeningPoint().getPort());
                logger.logStackTrace();
            }
            addEventListener(this.sipStack);
            this.releaseReferencesStrategy = this.sipStack.getReleaseReferencesStrategy();
            return;
        }
        throw new NullPointerException("Null Provider!");
    }

    public SIPDialog(SIPClientTransaction sIPClientTransaction, SIPResponse sIPResponse) throws Throwable {
        this(sIPClientTransaction);
        if (sIPResponse != null) {
            setLastResponse(sIPClientTransaction, sIPResponse);
            this.isBackToBackUserAgent = this.sipStack.isBackToBackUserAgent;
            return;
        }
        throw new NullPointerException("Null SipResponse");
    }

    public SIPDialog(SipProviderImpl sipProviderImpl, SIPResponse sIPResponse) throws Throwable {
        this(sipProviderImpl);
        this.sipStack = (SIPTransactionStack) sipProviderImpl.getSipStack();
        setLastResponse(null, sIPResponse);
        long seqNumber = sIPResponse.getCSeq().getSeqNumber();
        this.localSequenceNumber = seqNumber;
        this.originalLocalSequenceNumber = seqNumber;
        this.localParty = sIPResponse.getFrom().getAddress();
        this.remoteParty = sIPResponse.getTo().getAddress();
        this.method = sIPResponse.getCSeq().getMethod();
        this.callIdHeader = sIPResponse.getCallId();
        this.serverTransactionFlag = false;
        setLocalTag(sIPResponse.getFrom().getTag());
        setRemoteTag(sIPResponse.getTo().getTag());
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Creating a dialog : " + this);
            logger.logStackTrace();
        }
        SIPTransactionStack sIPTransactionStack = this.sipStack;
        this.isBackToBackUserAgent = sIPTransactionStack.isBackToBackUserAgent;
        addEventListener(sIPTransactionStack);
        this.releaseReferencesStrategy = this.sipStack.getReleaseReferencesStrategy();
    }

    private synchronized void addRoute(SIPResponse sIPResponse) {
        ContactList contactHeaders;
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("setContact: dialogState: " + this + "state = " + getState());
            }
            if (sIPResponse.getStatusCode() == 100) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logStackTrace();
                }
                return;
            }
            int i = this.dialogState;
            if (i == 3) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logStackTrace();
                }
                return;
            }
            if (i == 1) {
                if (sIPResponse.getStatusCode() / 100 == 2 && !isServer() && (contactHeaders = sIPResponse.getContactHeaders()) != null && SIPRequest.isTargetRefresh(sIPResponse.getCSeq().getMethod())) {
                    setRemoteTarget((InterfaceC7782Te1) contactHeaders.getFirst());
                }
                if (!this.pendingRouteUpdateOn202Response) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logStackTrace();
                    }
                    return;
                }
            }
            if (!isServer() || this.pendingRouteUpdateOn202Response) {
                if ((getState() != C23720xP1.e && getState() != C23720xP1.g) || this.pendingRouteUpdateOn202Response) {
                    RecordRouteList recordRouteHeaders = sIPResponse.getRecordRouteHeaders();
                    if (recordRouteHeaders != null) {
                        addRoute(recordRouteHeaders);
                    } else {
                        this.routeList = new RouteList();
                    }
                }
                ContactList contactHeaders2 = sIPResponse.getContactHeaders();
                if (contactHeaders2 != null) {
                    setRemoteTarget((InterfaceC7782Te1) contactHeaders2.getFirst());
                }
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logStackTrace();
            }
        } catch (Throwable th) {
            if (logger.isLoggingEnabled(32)) {
                logger.logStackTrace();
            }
            throw th;
        }
    }

    @Override // android.gov.nist.javax.sip.DialogExt
    public void sendAck(UP5 up5) throws SipException {
        sendAck(up5, true);
    }

    public SIPRequest createRequest(SipUri sipUri, Via via, CSeq cSeq, From from, To to) {
        SIPRequest sIPRequest = new SIPRequest();
        String method = cSeq.getMethod();
        sIPRequest.setMethod(method);
        sIPRequest.setRequestURI(sipUri);
        setBranch(via, method);
        sIPRequest.setHeader(via);
        sIPRequest.setHeader(cSeq);
        sIPRequest.setHeader(from);
        sIPRequest.setHeader(to);
        sIPRequest.setHeader(getCallId());
        try {
            sIPRequest.attachHeader(new MaxForwards(70), false);
        } catch (Exception unused) {
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            sIPRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        }
        return sIPRequest;
    }

    public SIPDialog(SIPClientTransaction sIPClientTransaction, SIPTransaction sIPTransaction) throws Throwable {
        this(sIPTransaction);
        this.serverTransactionFlag = false;
        this.lastTransaction = sIPClientTransaction;
        storeFirstTransactionInfo(this, sIPClientTransaction);
        this.terminateOnBye = false;
        this.localSequenceNumber = sIPClientTransaction.getCSeq();
        SIPRequest sIPRequest = (SIPRequest) sIPTransaction.getRequest();
        this.remoteSequenceNumber = sIPRequest.getCSeq().getSeqNumber();
        setDialogId(sIPRequest.getDialogId(true));
        setLocalTag(sIPRequest.getToTag());
        setRemoteTag(sIPRequest.getFromTag());
        setLastResponse(sIPClientTransaction, sIPClientTransaction.getLastResponse());
        this.localParty = sIPRequest.getTo().getAddress();
        this.remoteParty = sIPRequest.getFrom().getAddress();
        addRoute(sIPRequest);
        setState(1);
    }

    public synchronized void addRoute(SIPRequest sIPRequest) {
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("setContact: dialogState: " + this + "state = " + getState());
            }
            if (this.dialogState == 1 && SIPRequest.isTargetRefresh(sIPRequest.getMethod())) {
                doTargetRefresh(sIPRequest);
            }
            int i = this.dialogState;
            if (i != 1 && i != 3) {
                ContactList contactHeaders = sIPRequest.getContactHeaders();
                if (contactHeaders != null) {
                    setRemoteTarget((InterfaceC7782Te1) contactHeaders.getFirst());
                }
                if (sIPRequest.getToTag() != null) {
                    return;
                }
                RecordRouteList recordRouteHeaders = sIPRequest.getRecordRouteHeaders();
                if (recordRouteHeaders != null) {
                    addRoute(recordRouteHeaders);
                } else {
                    this.routeList = new RouteList();
                }
            }
        } finally {
        }
    }
}
