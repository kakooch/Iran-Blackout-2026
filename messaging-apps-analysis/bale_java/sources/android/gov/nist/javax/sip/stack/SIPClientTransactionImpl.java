package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.NameValueList;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.ReleaseReferencesStrategy;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.SipProviderImpl;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.Utils;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.header.Contact;
import android.gov.nist.javax.sip.header.Event;
import android.gov.nist.javax.sip.header.Expires;
import android.gov.nist.javax.sip.header.RecordRoute;
import android.gov.nist.javax.sip.header.RecordRouteList;
import android.gov.nist.javax.sip.header.Route;
import android.gov.nist.javax.sip.header.RouteList;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.TimeStamp;
import android.gov.nist.javax.sip.header.To;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.IllegalTransactionStateException;
import android.gov.nist.javax.sip.stack.SIPTransactionImpl;
import android.gov.nist.javax.sip.stack.timers.SipTimer;
import android.javax.sip.InvalidArgumentException;
import android.javax.sip.SipException;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C13253fu7;
import ir.nasim.C23720xP1;
import ir.nasim.C25169zq7;
import ir.nasim.C3626Bq7;
import ir.nasim.FY2;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.ND6;
import ir.nasim.UP5;
import java.io.IOException;
import java.text.ParseException;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class SIPClientTransactionImpl extends SIPTransactionImpl implements SIPClientTransaction {
    private static StackLogger logger = CommonLogger.getLogger(SIPClientTransaction.class);
    private int callingStateTimeoutCount;
    private SIPDialog defaultDialog;
    private String defaultDialogId;
    private SIPRequest lastRequest;
    private FY2 nextHop;
    private boolean notifyOnRetransmit;
    private String originalRequestCallId;
    private Contact originalRequestContact;
    private Event originalRequestEventHeader;
    private String originalRequestFromTag;
    private String originalRequestScheme;
    private transient ServerResponseInterface respondTo;
    private Set<Integer> responsesReceived;
    private Set<String> sipDialogs;
    private boolean terminateDialogOnCleanUp;
    private boolean timeoutIfStillInCallingState;
    private AtomicBoolean timerKStarted;
    private transient SIPStackTimerTask transactionTimer;
    private boolean transactionTimerCancelled;
    private transient Object transactionTimerLock;
    private String viaHost;
    private int viaPort;

    class ExpiresTimerTask extends SIPStackTimerTask {
        public ExpiresTimerTask() {
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            UP5 request = SIPClientTransactionImpl.this.getRequest();
            if (request == null || !(request instanceof SIPRequest)) {
                return null;
            }
            return ((SIPRequest) request).getCallIdHeader().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            SIPClientTransactionImpl sIPClientTransactionImpl = SIPClientTransactionImpl.this;
            SipProviderImpl sipProvider = sIPClientTransactionImpl.getSipProvider();
            if (sIPClientTransactionImpl.getState() != C13253fu7.i) {
                sipProvider.handleEvent(new C3626Bq7(sipProvider, sIPClientTransactionImpl, C25169zq7.d), sIPClientTransactionImpl);
                return;
            }
            if (SIPClientTransactionImpl.logger.isLoggingEnabled(32)) {
                SIPClientTransactionImpl.logger.logDebug("state = " + sIPClientTransactionImpl.getState());
            }
        }
    }

    public class TransactionTimer extends SIPStackTimerTask {
        public TransactionTimer() {
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            UP5 request = SIPClientTransactionImpl.this.getRequest();
            if (request == null || !(request instanceof SIPRequest)) {
                return null;
            }
            return ((SIPRequest) request).getCallIdHeader().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            if (!SIPClientTransactionImpl.this.isTerminated()) {
                SIPClientTransactionImpl.this.fireTimer();
                return;
            }
            try {
                SIPClientTransactionImpl.this.sipStack.getTimer().cancel(this);
            } catch (IllegalStateException unused) {
                if (!SIPClientTransactionImpl.this.sipStack.isAlive()) {
                    return;
                }
            }
            SIPClientTransactionImpl.this.cleanUpOnTerminated();
        }
    }

    protected SIPClientTransactionImpl(SIPTransactionStack sIPTransactionStack, MessageChannel messageChannel) {
        super(sIPTransactionStack, messageChannel);
        this.transactionTimerLock = new Object();
        this.timerKStarted = new AtomicBoolean(false);
        this.transactionTimerCancelled = false;
        this.responsesReceived = new CopyOnWriteArraySet();
        this.terminateDialogOnCleanUp = true;
        setBranch(Utils.getInstance().generateBranchId());
        setEncapsulatedChannel(messageChannel);
        this.notifyOnRetransmit = false;
        this.timeoutIfStillInCallingState = false;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Creating clientTransaction " + this);
            logger.logStackTrace();
        }
        this.sipDialogs = new CopyOnWriteArraySet();
    }

    private final UP5 createErrorAck() throws SipException {
        SIPRequest originalRequest = getOriginalRequest();
        if (originalRequest == null) {
            throw new SipException("bad state " + getState());
        }
        if (!isInviteTransaction()) {
            throw new SipException("Can only ACK an INVITE!");
        }
        SIPResponse sIPResponse = this.lastResponse;
        if (sIPResponse == null) {
            throw new SipException("bad Transaction state");
        }
        if (sIPResponse.getStatusCode() >= 200) {
            return originalRequest.createErrorAck((To) this.lastResponse.getTo());
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("lastResponse = " + this.lastResponse);
        }
        throw new SipException("Cannot ACK a provisional response!");
    }

    private void inviteClientTransaction(SIPResponse sIPResponse, MessageChannel messageChannel, SIPDialog sIPDialog) {
        int statusCode = sIPResponse.getStatusCode();
        if (5 == getInternalState()) {
            boolean z = sIPDialog != null && sIPDialog.isAckSent(sIPResponse.getCSeq().getSeqNumber()) && sIPDialog.getLastAckSentCSeq().getSeqNumber() == sIPResponse.getCSeq().getSeqNumber() && sIPResponse.getFromTag().equals(sIPDialog.getLastAckSentFromTag());
            if (sIPDialog != null && z && sIPResponse.getCSeq().getMethod().equals(sIPDialog.getMethod())) {
                try {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("resending ACK");
                    }
                    sIPDialog.resendAck();
                } catch (SipException unused) {
                }
            }
            if (logger.isLoggingEnabled(32) && sIPDialog != null) {
                logger.logDebug("Dialog " + sIPDialog + " current state " + sIPDialog.getState());
            }
            if (sIPDialog == null && statusCode >= 200 && statusCode < 300) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Client Transaction " + this + " branch id " + getBranch() + " doesn't have any dialog and is in TERMINATED state");
                }
                if (this.respondTo != null) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("passing 2xx response up to the application");
                    }
                    this.respondTo.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                    return;
                }
                return;
            }
            if (sIPDialog == null || sIPDialog.getState() != C23720xP1.d || statusCode < 200 || statusCode >= 300) {
                return;
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Client Transaction " + this + " branch id " + getBranch() + " has a early dialog and is in TERMINATED state");
            }
            sIPResponse.setRetransmission(false);
            if (this.respondTo != null) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("passing 2xx response up to the application");
                }
                this.respondTo.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                return;
            }
            return;
        }
        if (getInternalState() == 0) {
            int i = statusCode / 100;
            if (i == 2) {
                disableRetransmissionTimer();
                disableTimeoutTimer();
                setState(5);
                ServerResponseInterface serverResponseInterface = this.respondTo;
                if (serverResponseInterface != null) {
                    serverResponseInterface.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                    return;
                }
                return;
            }
            if (i == 1) {
                disableRetransmissionTimer();
                disableTimeoutTimer();
                setState(2);
                ServerResponseInterface serverResponseInterface2 = this.respondTo;
                if (serverResponseInterface2 != null) {
                    serverResponseInterface2.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                    return;
                }
                return;
            }
            if (300 > statusCode || statusCode > 699) {
                return;
            }
            try {
                sendMessage((SIPRequest) createErrorAck());
            } catch (Exception e) {
                logger.logError("Unexpected Exception sending ACK -- sending error AcK ", e);
            }
            if (getDialog() != null && ((SIPDialog) getDialog()).isBackToBackUserAgent()) {
                ((SIPDialog) getDialog()).releaseAckSem();
            }
            if (isReliable()) {
                setState(5);
            } else {
                setState(3);
                enableTimeoutTimer(this.timerD);
            }
            ServerResponseInterface serverResponseInterface3 = this.respondTo;
            if (serverResponseInterface3 != null) {
                serverResponseInterface3.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
            }
            cleanUpOnTimer();
            return;
        }
        if (2 != getInternalState()) {
            if (3 != getInternalState() || 300 > statusCode || statusCode > 699) {
                return;
            }
            try {
                try {
                    sendMessage((SIPRequest) createErrorAck());
                } catch (Exception e2) {
                    InternalErrorHandler.handleException(e2);
                }
                return;
            } finally {
                semRelease();
            }
        }
        int i2 = statusCode / 100;
        if (i2 == 1) {
            ServerResponseInterface serverResponseInterface4 = this.respondTo;
            if (serverResponseInterface4 != null) {
                serverResponseInterface4.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                return;
            }
            return;
        }
        if (i2 == 2) {
            setState(5);
            ServerResponseInterface serverResponseInterface5 = this.respondTo;
            if (serverResponseInterface5 != null) {
                serverResponseInterface5.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                return;
            }
            return;
        }
        if (300 > statusCode || statusCode > 699) {
            return;
        }
        try {
            sendMessage((SIPRequest) createErrorAck());
        } catch (Exception e3) {
            InternalErrorHandler.handleException(e3);
        }
        if (getDialog() != null) {
            ((SIPDialog) getDialog()).releaseAckSem();
        }
        if (isReliable()) {
            setState(5);
        } else {
            setState(3);
            enableTimeoutTimer(this.timerD);
        }
        cleanUpOnTimer();
        ServerResponseInterface serverResponseInterface6 = this.respondTo;
        if (serverResponseInterface6 != null) {
            serverResponseInterface6.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
        }
    }

    private void nonInviteClientTransaction(SIPResponse sIPResponse, MessageChannel messageChannel, SIPDialog sIPDialog) {
        int statusCode = sIPResponse.getStatusCode();
        if (1 == getInternalState()) {
            if (statusCode / 100 == 1) {
                setState(2);
                enableRetransmissionTimer(getTimerT2());
                enableTimeoutTimer(64);
                ServerResponseInterface serverResponseInterface = this.respondTo;
                if (serverResponseInterface != null) {
                    serverResponseInterface.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                    return;
                } else {
                    semRelease();
                    return;
                }
            }
            if (200 > statusCode || statusCode > 699) {
                return;
            }
            if (isReliable()) {
                setState(5);
            } else {
                setState(3);
                scheduleTimerK(this.timerK);
            }
            ServerResponseInterface serverResponseInterface2 = this.respondTo;
            if (serverResponseInterface2 != null) {
                serverResponseInterface2.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
            } else {
                semRelease();
            }
            if (isReliable() && 5 == getInternalState()) {
                cleanUpOnTerminated();
            }
            cleanUpOnTimer();
            return;
        }
        if (2 != getInternalState()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug(" Not sending response to TU! " + getState());
            }
            semRelease();
            return;
        }
        if (statusCode / 100 == 1) {
            ServerResponseInterface serverResponseInterface3 = this.respondTo;
            if (serverResponseInterface3 != null) {
                serverResponseInterface3.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
                return;
            } else {
                semRelease();
                return;
            }
        }
        if (200 > statusCode || statusCode > 699) {
            return;
        }
        disableRetransmissionTimer();
        disableTimeoutTimer();
        if (isReliable()) {
            setState(5);
        } else {
            setState(3);
            scheduleTimerK(this.timerK);
        }
        ServerResponseInterface serverResponseInterface4 = this.respondTo;
        if (serverResponseInterface4 != null) {
            serverResponseInterface4.processResponse(sIPResponse, this.encapsulatedChannel, sIPDialog);
        } else {
            semRelease();
        }
        if (isReliable() && 5 == getInternalState()) {
            cleanUpOnTerminated();
        }
        cleanUpOnTimer();
    }

    private void scheduleTimerK(long j) {
        if (this.transactionTimer == null || !this.timerKStarted.compareAndSet(false, true)) {
            return;
        }
        synchronized (this.transactionTimerLock) {
            try {
                if (!this.transactionTimerCancelled) {
                    this.sipStack.getTimer().cancel(this.transactionTimer);
                    this.transactionTimer = null;
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("starting TransactionTimerK() : " + getTransactionId() + " time " + j);
                    }
                    SIPStackTimerTask sIPStackTimerTask = new SIPStackTimerTask() { // from class: android.gov.nist.javax.sip.stack.SIPClientTransactionImpl.1
                        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
                        public Object getThreadHash() {
                            UP5 request = SIPClientTransactionImpl.this.getRequest();
                            if (request == null || !(request instanceof SIPRequest)) {
                                return null;
                            }
                            return ((SIPRequest) request).getCallIdHeader().getCallId();
                        }

                        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
                        public void runTask() {
                            if (SIPClientTransactionImpl.logger.isLoggingEnabled(32)) {
                                SIPClientTransactionImpl.logger.logDebug("executing TransactionTimerJ() : " + SIPClientTransactionImpl.this.getTransactionId());
                            }
                            SIPClientTransactionImpl.this.fireTimeoutTimer();
                            SIPClientTransactionImpl.this.cleanUpOnTerminated();
                        }
                    };
                    if (j > 0) {
                        this.sipStack.getTimer().schedule(sIPStackTimerTask, j * this.baseTimerInterval);
                    } else {
                        sIPStackTimerTask.runTask();
                    }
                    this.transactionTimerCancelled = true;
                }
            } finally {
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.ClientTransactionExt
    public void alertIfStillInCallingStateBy(int i) {
        this.timeoutIfStillInCallingState = true;
        this.callingStateTimeoutCount = i;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public boolean checkFromTag(SIPResponse sIPResponse) {
        String originalRequestFromTag = getOriginalRequestFromTag();
        if (this.defaultDialog != null) {
            if ((originalRequestFromTag == null) ^ (sIPResponse.getFrom().getTag() == null)) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("From tag mismatch -- dropping response");
                }
                return false;
            }
            if (originalRequestFromTag != null && !originalRequestFromTag.equalsIgnoreCase(sIPResponse.getFrom().getTag())) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("From tag mismatch -- dropping response");
                }
                return false;
            }
        }
        return true;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction
    public void cleanUp() {
        if (getReleaseReferencesStrategy() != ReleaseReferencesStrategy.None) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("cleanup : " + getTransactionId());
            }
            SIPDialog sIPDialog = this.defaultDialog;
            if (sIPDialog != null) {
                this.defaultDialogId = sIPDialog.getDialogId();
                this.defaultDialog = null;
            }
            if (this.originalRequest != null && this.originalRequestBytes == null) {
                if (getReleaseReferencesStrategy() == ReleaseReferencesStrategy.Normal) {
                    this.originalRequestBytes = this.originalRequest.encodeAsBytes(getTransport());
                }
                this.mergeId = this.originalRequest.getMergeId();
            }
            this.originalRequest = null;
            cleanUpOnTimer();
            this.originalRequestCallId = null;
            this.originalRequestEventHeader = null;
            this.originalRequestFromTag = null;
            this.originalRequestContact = null;
            this.originalRequestScheme = null;
            Set<String> set = this.sipDialogs;
            if (set != null) {
                set.clear();
            }
            this.responsesReceived.clear();
            this.respondTo = null;
            this.transactionTimer = null;
            this.lastResponse = null;
            this.transactionTimerLock = null;
            this.timerKStarted = null;
        }
    }

    protected void cleanUpOnTerminated() {
        SIPDialog sIPDialog;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("removing  = " + this + " isReliable " + isReliable());
        }
        if (getReleaseReferencesStrategy() == ReleaseReferencesStrategy.Normal && this.originalRequest == null && this.originalRequestBytes != null) {
            try {
                this.originalRequest = (SIPRequest) this.sipStack.getMessageParserFactory().createMessageParser(this.sipStack).parseSIPMessage(this.originalRequestBytes, true, false, null);
            } catch (ParseException e) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("message " + this.originalRequestBytes + " could not be reparsed !", e);
                }
            }
        }
        this.sipStack.removeTransaction(this);
        if (this.sipStack.cacheClientConnections || !isReliable()) {
            if (logger.isLoggingEnabled() && isReliable()) {
                int i = getMessageChannel().useCount;
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Client Use Count = " + i);
                }
            }
            if (((SipStackImpl) getSIPStack()).isReEntrantListener() && getReleaseReferencesStrategy() != ReleaseReferencesStrategy.None) {
                cleanUp();
            }
        } else {
            MessageChannel messageChannel = getMessageChannel();
            int i2 = messageChannel.useCount - 1;
            messageChannel.useCount = i2;
            if (i2 <= 0) {
                SIPTransactionImpl.LingerTimer lingerTimer = new SIPTransactionImpl.LingerTimer();
                if (this.sipStack.getConnectionLingerTimer() != 0) {
                    this.sipStack.getTimer().schedule(lingerTimer, this.sipStack.getConnectionLingerTimer() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                } else {
                    lingerTimer.runTask();
                }
            }
        }
        if (this.terminateDialogOnCleanUp && (sIPDialog = this.defaultDialog) != null && sIPDialog.getState() == null) {
            this.defaultDialog.setState(3);
        }
    }

    protected void cleanUpOnTimer() {
        String dialogId;
        if (getReleaseReferencesStrategy() != ReleaseReferencesStrategy.None) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("cleanupOnTimer: " + getTransactionId());
            }
            SIPDialog sIPDialog = this.defaultDialog;
            if (sIPDialog != null && (dialogId = sIPDialog.getDialogId()) != null && this.sipStack.getDialog(dialogId) != null) {
                this.defaultDialogId = dialogId;
                this.defaultDialog = null;
            }
            SIPRequest sIPRequest = this.originalRequest;
            if (sIPRequest != null) {
                this.mergeId = sIPRequest.getMergeId();
                this.originalRequest.setTransaction(null);
                this.originalRequest.setInviteTransaction(null);
                this.originalRequest.cleanUp();
                if (this.originalRequestBytes == null && getReleaseReferencesStrategy() == ReleaseReferencesStrategy.Normal) {
                    this.originalRequestBytes = this.originalRequest.encodeAsBytes(getTransport());
                }
                if (!getMethod().equalsIgnoreCase(TokenNames.INVITE) && !getMethod().equalsIgnoreCase("CANCEL")) {
                    this.originalRequestFromTag = this.originalRequest.getFromTag();
                    this.originalRequestCallId = this.originalRequest.getCallId().getCallId();
                    this.originalRequestEventHeader = (Event) this.originalRequest.getHeader(SIPHeaderNames.EVENT);
                    this.originalRequestContact = this.originalRequest.getContactHeader();
                    this.originalRequestScheme = this.originalRequest.getRequestURI().getScheme();
                    this.originalRequest = null;
                }
            }
            if (!getMethod().equalsIgnoreCase(TokenNames.SUBSCRIBE)) {
                this.lastResponse = null;
            }
            this.lastRequest = null;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public void clearState() {
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.ClientTransactionExt
    public UP5 createAck() throws SipException {
        SIPRequest originalRequest = getOriginalRequest();
        if (originalRequest == null) {
            throw new SipException("bad state " + getState());
        }
        if (getMethod().equalsIgnoreCase(TokenNames.ACK)) {
            throw new SipException("Cannot ACK an ACK!");
        }
        SIPResponse sIPResponse = this.lastResponse;
        if (sIPResponse == null) {
            throw new SipException("bad Transaction state");
        }
        if (sIPResponse.getStatusCode() < 200) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("lastResponse = " + this.lastResponse);
            }
            throw new SipException("Cannot ACK a provisional response!");
        }
        SIPRequest sIPRequestCreateAckRequest = originalRequest.createAckRequest((To) this.lastResponse.getTo());
        RecordRouteList recordRouteHeaders = this.lastResponse.getRecordRouteHeaders();
        if (recordRouteHeaders == null) {
            if (this.lastResponse.getContactHeaders() != null && this.lastResponse.getStatusCode() / 100 != 3) {
                sIPRequestCreateAckRequest.setRequestURI((InterfaceC21815uA7) ((Contact) this.lastResponse.getContactHeaders().getFirst()).getAddress().getURI().clone());
            }
            return sIPRequestCreateAckRequest;
        }
        sIPRequestCreateAckRequest.removeHeader(SIPHeaderNames.ROUTE);
        RouteList routeList = new RouteList();
        ListIterator<RecordRoute> listIterator = recordRouteHeaders.listIterator(recordRouteHeaders.size());
        while (listIterator.hasPrevious()) {
            RecordRoute recordRoutePrevious = listIterator.previous();
            Route route = new Route();
            route.setAddress((AddressImpl) ((AddressImpl) recordRoutePrevious.getAddress()).clone());
            route.setParameters((NameValueList) recordRoutePrevious.getParameters().clone());
            routeList.add((RouteList) route);
        }
        Route route2 = null;
        Contact contact = this.lastResponse.getContactHeaders() != null ? (Contact) this.lastResponse.getContactHeaders().getFirst() : null;
        if (!((ND6) ((Route) routeList.getFirst()).getAddress().getURI()).hasLrParam()) {
            if (contact != null) {
                route2 = new Route();
                route2.setAddress((AddressImpl) ((AddressImpl) contact.getAddress()).clone());
            }
            Route route3 = (Route) routeList.getFirst();
            routeList.removeFirst();
            sIPRequestCreateAckRequest.setRequestURI(route3.getAddress().getURI());
            if (route2 != null) {
                routeList.add((RouteList) route2);
            }
            sIPRequestCreateAckRequest.addHeader(routeList);
        } else if (contact != null) {
            sIPRequestCreateAckRequest.setRequestURI((InterfaceC21815uA7) contact.getAddress().getURI().clone());
            sIPRequestCreateAckRequest.addHeader(routeList);
        }
        return sIPRequestCreateAckRequest;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.ClientTransactionExt
    public UP5 createCancel() throws SipException {
        SIPRequest originalRequest = getOriginalRequest();
        if (originalRequest == null) {
            throw new SipException("Bad state " + getState());
        }
        if (!originalRequest.getMethod().equals(TokenNames.INVITE)) {
            throw new SipException("Only INIVTE may be cancelled");
        }
        if (originalRequest.getMethod().equalsIgnoreCase(TokenNames.ACK)) {
            throw new SipException("Cannot Cancel ACK!");
        }
        SIPRequest sIPRequestCreateCancelRequest = originalRequest.createCancelRequest();
        sIPRequestCreateCancelRequest.setInviteTransaction(this);
        return sIPRequestCreateCancelRequest;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void fireRetransmissionTimer() {
        try {
            if (getInternalState() >= 0 && this.isMapped) {
                boolean zIsInviteTransaction = isInviteTransaction();
                int internalState = getInternalState();
                if (!zIsInviteTransaction || internalState != 0) {
                    if (zIsInviteTransaction) {
                        return;
                    }
                    if (1 != internalState && 2 != internalState) {
                        return;
                    }
                }
                SIPRequest sIPRequest = this.lastRequest;
                if (sIPRequest != null) {
                    if (this.sipStack.generateTimeStampHeader && sIPRequest.getHeader(SIPHeaderNames.TIMESTAMP) != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        TimeStamp timeStamp = new TimeStamp();
                        try {
                            timeStamp.setTimeStamp(jCurrentTimeMillis);
                        } catch (InvalidArgumentException e) {
                            InternalErrorHandler.handleException(e);
                        }
                        this.lastRequest.setHeader(timeStamp);
                    }
                    super.sendMessage(this.lastRequest);
                    if (this.notifyOnRetransmit) {
                        getSipProvider().handleEvent(new C3626Bq7(getSipProvider(), this, C25169zq7.c), this);
                    }
                    if (this.timeoutIfStillInCallingState && getInternalState() == 0) {
                        int i = this.callingStateTimeoutCount - 1;
                        this.callingStateTimeoutCount = i;
                        if (i == 0) {
                            getSipProvider().handleEvent(new C3626Bq7(getSipProvider(), this, C25169zq7.c), this);
                            this.timeoutIfStillInCallingState = false;
                        }
                    }
                }
            }
        } catch (IOException unused) {
            raiseIOExceptionEvent();
            raiseErrorEvent(2);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void fireTimeoutTimer() {
        SIPClientTransaction sIPClientTransaction;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("fireTimeoutTimer " + this);
        }
        SIPDialog sIPDialog = (SIPDialog) getDialog();
        if (getInternalState() == 0 || 1 == getInternalState() || 2 == getInternalState()) {
            if (sIPDialog == null || !(sIPDialog.getState() == null || sIPDialog.getState() == C23720xP1.d)) {
                if (sIPDialog != null && getMethod().equalsIgnoreCase(TokenNames.BYE) && sIPDialog.isTerminatedOnBye()) {
                    sIPDialog.delete();
                }
            } else if (SIPTransactionStack.isDialogCreated(getMethod())) {
                sIPDialog.delete();
            }
        }
        if (3 == getInternalState() || 5 == getInternalState()) {
            setState(5);
            return;
        }
        raiseErrorEvent(1);
        if (!getMethod().equalsIgnoreCase("CANCEL") || (sIPClientTransaction = (SIPClientTransaction) getOriginalRequest().getInviteTransaction()) == null) {
            return;
        }
        if ((sIPClientTransaction.getInternalState() == 0 || sIPClientTransaction.getInternalState() == 2) && sIPClientTransaction.getDialog() != null) {
            sIPClientTransaction.setState(5);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public InterfaceC17658nL1 getDialog() {
        SIPResponse sIPResponse = this.lastResponse;
        SIPDialog dialog = (sIPResponse == null || sIPResponse.getFromTag() == null || sIPResponse.getToTag() == null || sIPResponse.getStatusCode() == 100) ? null : getDialog(sIPResponse.getDialogId(false));
        if (dialog == null) {
            dialog = getDefaultDialog();
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug(" sipDialogs =  " + this.sipDialogs + " default dialog " + getDefaultDialog() + " retval " + dialog);
        }
        return dialog;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.ClientTransactionExt
    public FY2 getNextHop() {
        return this.nextHop;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public String getOriginalRequestCallId() {
        SIPRequest sIPRequest = this.originalRequest;
        return sIPRequest == null ? this.originalRequestCallId : sIPRequest.getCallId().getCallId();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public Contact getOriginalRequestContact() {
        SIPRequest sIPRequest = this.originalRequest;
        return sIPRequest == null ? this.originalRequestContact : sIPRequest.getContactHeader();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public Event getOriginalRequestEvent() {
        SIPRequest sIPRequest = this.originalRequest;
        return sIPRequest == null ? this.originalRequestEventHeader : (Event) sIPRequest.getHeader(SIPHeaderNames.EVENT);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public String getOriginalRequestFromTag() {
        SIPRequest sIPRequest = this.originalRequest;
        return sIPRequest == null ? this.originalRequestFromTag : sIPRequest.getFromTag();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public String getOriginalRequestScheme() {
        SIPRequest sIPRequest = this.originalRequest;
        return sIPRequest == null ? this.originalRequestScheme : sIPRequest.getRequestURI().getScheme();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public Via getOutgoingViaHeader() {
        return getMessageProcessor().getViaHeader();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public MessageChannel getRequestChannel() {
        return this.encapsulatedChannel;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction
    public String getViaHost() {
        return this.viaHost;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction
    public int getViaPort() {
        return this.viaPort;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isMessagePartOfTransaction(SIPMessage sIPMessage) {
        Via topmostVia = sIPMessage.getTopmostVia();
        String branch = topmostVia.getBranch();
        boolean z = getBranch() != null && branch != null && getBranch().toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE) && branch.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE);
        if (3 == getInternalState()) {
            if (z) {
                return getBranch().equalsIgnoreCase(topmostVia.getBranch()) && getMethod().equals(sIPMessage.getCSeq().getMethod());
            }
            return getBranch().equals(sIPMessage.getTransactionId());
        }
        if (isTerminated()) {
            return false;
        }
        if (!z) {
            return getBranch() != null ? getBranch().equalsIgnoreCase(sIPMessage.getTransactionId()) : ((SIPRequest) getRequest()).getTransactionId().equalsIgnoreCase(sIPMessage.getTransactionId());
        }
        if (getBranch().equalsIgnoreCase(topmostVia.getBranch())) {
            return getMethod().equals(sIPMessage.getCSeq().getMethod());
        }
        return false;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public boolean isNotifyOnRetransmit() {
        return this.notifyOnRetransmit;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.stack.ServerResponseInterface
    public synchronized void processResponse(SIPResponse sIPResponse, MessageChannel messageChannel, SIPDialog sIPDialog) {
        try {
            if (getInternalState() < 0) {
                return;
            }
            if (3 == getInternalState() || 5 == getInternalState()) {
                if (sIPResponse.getStatusCode() / 100 == 1) {
                    return;
                }
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("processing " + sIPResponse.getFirstLine() + "current state = " + getState());
                StackLogger stackLogger = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("dialog = ");
                sb.append(sIPDialog);
                stackLogger.logDebug(sb.toString());
            }
            this.lastResponse = sIPResponse;
            try {
                if (isInviteTransaction()) {
                    inviteClientTransaction(sIPResponse, messageChannel, sIPDialog);
                } else {
                    nonInviteClientTransaction(sIPResponse, messageChannel, sIPDialog);
                }
            } catch (IOException e) {
                if (logger.isLoggingEnabled()) {
                    logger.logException(e);
                }
                setState(5);
                raiseErrorEvent(2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction
    public void sendMessage(SIPMessage sIPMessage) {
        try {
            SIPRequest sIPRequest = (SIPRequest) sIPMessage;
            try {
                sIPRequest.getTopmostVia().setBranch(getBranch());
            } catch (ParseException unused) {
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Sending Message " + sIPMessage);
                logger.logDebug("TransactionState " + getState());
            }
            if ((2 == getInternalState() || getInternalState() == 0) && sIPRequest.getMethod().equals(TokenNames.ACK)) {
                if (isReliable()) {
                    setState(5);
                } else {
                    setState(3);
                }
                cleanUpOnTimer();
                super.sendMessage(sIPRequest);
                return;
            }
            try {
                this.lastRequest = sIPRequest;
                if (getInternalState() < 0) {
                    setOriginalRequest(sIPRequest);
                    if (sIPRequest.getMethod().equals(TokenNames.INVITE)) {
                        setState(0);
                    } else if (sIPRequest.getMethod().equals(TokenNames.ACK)) {
                        setState(5);
                        cleanUpOnTimer();
                    } else {
                        setState(1);
                    }
                    if (!isReliable()) {
                        enableRetransmissionTimer();
                    }
                    if (isInviteTransaction()) {
                        enableTimeoutTimer(64);
                    } else {
                        enableTimeoutTimer(64);
                    }
                }
                super.sendMessage(sIPRequest);
            } catch (IOException e) {
                setState(5);
                throw e;
            }
        } finally {
            this.isMapped = true;
            startTransactionTimer();
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.ClientTransactionExt
    public void sendRequest() throws SipException {
        SIPDialog defaultDialog;
        SIPRequest originalRequest = getOriginalRequest();
        if (getInternalState() >= 0) {
            throw new IllegalTransactionStateException("Request already sent", IllegalTransactionStateException.Reason.RequestAlreadySent);
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendRequest() " + originalRequest);
        }
        try {
            originalRequest.checkHeaders();
            if (getMethod().equals(TokenNames.SUBSCRIBE) && originalRequest.getHeader(SIPHeaderNames.EXPIRES) == null && logger.isLoggingEnabled()) {
                logger.logWarning("Expires header missing in outgoing subscribe -- Notifier will assume implied value on event package");
            }
            try {
                if (getMethod().equals("CANCEL") && this.sipStack.isCancelClientTransactionChecked()) {
                    SIPClientTransaction sIPClientTransaction = (SIPClientTransaction) this.sipStack.findCancelTransaction(getOriginalRequest(), false);
                    if (sIPClientTransaction == null) {
                        throw new SipException("Could not find original tx to cancel. RFC 3261 9.1");
                    }
                    if (sIPClientTransaction.getInternalState() < 0) {
                        throw new SipException("State is null no provisional response yet -- cannot cancel RFC 3261 9.1");
                    }
                    if (!sIPClientTransaction.isInviteTransaction()) {
                        throw new SipException("Cannot cancel non-invite requests RFC 3261 9.1");
                    }
                } else if (getMethod().equals(TokenNames.BYE) || getMethod().equals(TokenNames.NOTIFY)) {
                    SIPDialog dialog = this.sipStack.getDialog(getOriginalRequest().getDialogId(false));
                    if (getSipProvider().isAutomaticDialogSupportEnabled() && dialog != null) {
                        throw new SipException("Dialog is present and AutomaticDialogSupport is enabled for  the provider -- Send the Request using the Dialog.sendRequest(transaction)");
                    }
                }
                if (isInviteTransaction() && (defaultDialog = getDefaultDialog()) != null && defaultDialog.isBackToBackUserAgent() && !defaultDialog.takeAckSem()) {
                    throw new SipException("Failed to take ACK semaphore");
                }
                this.isMapped = true;
                int expires = originalRequest.getHeader(SIPHeaderNames.EXPIRES) != null ? ((Expires) originalRequest.getHeader(SIPHeaderNames.EXPIRES)).getExpires() : -1;
                if (getDefaultDialog() != null && isInviteTransaction() && expires != -1 && this.expiresTimerTask == null) {
                    this.expiresTimerTask = new ExpiresTimerTask();
                    this.sipStack.getTimer().schedule(this.expiresTimerTask, expires * 1000);
                }
                sendMessage(originalRequest);
            } catch (IOException e) {
                setState(5);
                if (this.expiresTimerTask != null) {
                    this.sipStack.getTimer().cancel(this.expiresTimerTask);
                }
                throw new SipException(e.getMessage() == null ? "IO Error sending request" : e.getMessage(), e);
            }
        } catch (ParseException e2) {
            if (logger.isLoggingEnabled()) {
                logger.logError("missing required header");
            }
            throw new IllegalTransactionStateException(e2.getMessage(), IllegalTransactionStateException.Reason.MissingRequiredHeader);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction
    public void setDialog(SIPDialog sIPDialog, String str) {
        Set<String> set;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("setDialog: " + str + " sipDialog = " + sIPDialog);
        }
        if (sIPDialog == null) {
            if (logger.isLoggingEnabled(4)) {
                logger.logError("NULL DIALOG!!");
            }
            throw new NullPointerException("bad dialog null");
        }
        if (this.defaultDialog == null && this.defaultDialogId == null) {
            this.defaultDialog = sIPDialog;
            if (isInviteTransaction() && getSIPStack().getMaxForkTime() != 0) {
                getSIPStack().addForkedClientTransaction(this);
            }
        }
        if (str == null || sIPDialog.getDialogId() == null || (set = this.sipDialogs) == null) {
            return;
        }
        set.add(str);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public void setNextHop(FY2 fy2) {
        this.nextHop = fy2;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.ClientTransactionExt
    public void setNotifyOnRetransmit(boolean z) {
        this.notifyOnRetransmit = z;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public void setResponseInterface(ServerResponseInterface serverResponseInterface) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Setting response interface for " + this + " to " + serverResponseInterface);
            if (serverResponseInterface == null) {
                logger.logStackTrace();
                logger.logDebug("WARNING -- setting to null!");
            }
        }
        this.respondTo = serverResponseInterface;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction
    public void setState(int i) {
        if (i == 5 && isReliable() && !getSIPStack().cacheClientConnections) {
            this.collectionTime = 64;
        }
        if (super.getInternalState() != 3 && (i == 3 || i == 5)) {
            this.sipStack.decrementActiveClientTransactionCount();
        }
        super.setState(i);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public void setTerminateDialogOnCleanUp(boolean z) {
        this.terminateDialogOnCleanUp = z;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public void setViaHost(String str) {
        this.viaHost = str;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public void setViaPort(int i) {
        this.viaPort = i;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void startTransactionTimer() {
        Object obj;
        if (!this.transactionTimerStarted.compareAndSet(false, true) || this.sipStack.getTimer() == null || (obj = this.transactionTimerLock) == null) {
            return;
        }
        synchronized (obj) {
            try {
                if (!this.transactionTimerCancelled) {
                    this.transactionTimer = new TransactionTimer();
                    SipTimer timer = this.sipStack.getTimer();
                    SIPStackTimerTask sIPStackTimerTask = this.transactionTimer;
                    int i = this.baseTimerInterval;
                    timer.scheduleWithFixedDelay(sIPStackTimerTask, i, i);
                }
            } finally {
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public void stopExpiresTimer() {
        if (this.expiresTimerTask != null) {
            this.sipStack.getTimer().cancel(this.expiresTimerTask);
            this.expiresTimerTask = null;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionImpl, android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public void terminate() {
        setState(5);
        if (!this.transactionTimerStarted.get()) {
            testAndSetTransactionTerminatedEvent();
            this.sipStack.removeTransaction(this);
        }
        SIPDialog sIPDialog = (SIPDialog) getDialog();
        if (sIPDialog != null) {
            sIPDialog.releaseAckSem();
        }
    }

    @Override // android.gov.nist.javax.sip.ClientTransactionExt
    public SIPDialog getDefaultDialog() {
        String str;
        SIPDialog sIPDialog = this.defaultDialog;
        return (sIPDialog != null || (str = this.defaultDialogId) == null) ? sIPDialog : this.sipStack.getDialog(str);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction
    public SIPDialog getDialog(String str) {
        Set<String> set = this.sipDialogs;
        if (set == null || !set.contains(str)) {
            return null;
        }
        SIPDialog dialog = this.sipStack.getDialog(str);
        return dialog == null ? this.sipStack.getEarlyDialog(str) : dialog;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPClientTransaction, android.gov.nist.javax.sip.stack.ServerResponseInterface
    public void processResponse(SIPResponse sIPResponse, MessageChannel messageChannel) throws Throwable {
        SIPDialog dialog;
        SIPDialog dialog2;
        SIPRequest sIPRequest;
        SIPResponse sIPResponse2;
        int statusCode = sIPResponse.getStatusCode();
        boolean z = !this.responsesReceived.add(Integer.valueOf(statusCode));
        if (statusCode > 100 && statusCode < 200 && z && (sIPResponse2 = this.lastResponse) != null && !sIPResponse.equals(sIPResponse2)) {
            z = false;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("marking response as retransmission " + z + " for ctx " + this);
        }
        sIPResponse.setRetransmission(z);
        String method = sIPResponse.getCSeq().getMethod();
        String dialogId = sIPResponse.getDialogId(false);
        if (method.equals("CANCEL") && (sIPRequest = this.lastRequest) != null) {
            SIPClientTransaction sIPClientTransaction = (SIPClientTransaction) sIPRequest.getInviteTransaction();
            dialog = sIPClientTransaction != null ? sIPClientTransaction.getDefaultDialog() : null;
        } else {
            dialog = getDialog(dialogId);
        }
        if (dialog == null) {
            if (statusCode > 100 && statusCode < 300 && ((sIPResponse.getToTag() != null || this.sipStack.isRfc2543Supported()) && SIPTransactionStack.isDialogCreated(method))) {
                synchronized (this) {
                    try {
                        if (this.defaultDialog != null) {
                            if (sIPResponse.getFromTag() != null) {
                                String dialogId2 = this.defaultDialog.getDialogId();
                                if (this.defaultDialog.getLastResponseMethod() != null && (!method.equals(TokenNames.SUBSCRIBE) || !this.defaultDialog.getLastResponseMethod().equals(TokenNames.NOTIFY) || !dialogId2.equals(dialogId))) {
                                    dialog2 = this.sipStack.getDialog(dialogId);
                                    if (dialog2 == null && this.defaultDialog.isAssigned()) {
                                        dialog2 = this.sipStack.createDialog(this, sIPResponse);
                                        dialog2.setOriginalDialog(this.defaultDialog);
                                    }
                                } else {
                                    this.defaultDialog.setLastResponse(this, sIPResponse);
                                    dialog2 = this.defaultDialog;
                                }
                                dialog = dialog2;
                                if (dialog != null) {
                                    setDialog(dialog, dialog.getDialogId());
                                } else {
                                    logger.logError("dialog is unexpectedly null", new NullPointerException());
                                }
                            } else {
                                throw new RuntimeException("Response without from-tag");
                            }
                        } else {
                            SIPTransactionStack sIPTransactionStack = this.sipStack;
                            if (sIPTransactionStack.isAutomaticDialogSupportEnabled) {
                                dialog = sIPTransactionStack.createDialog(this, sIPResponse);
                                setDialog(dialog, dialog.getDialogId());
                            }
                        }
                    } finally {
                    }
                }
            } else {
                dialog = this.defaultDialog;
            }
        } else if (5 != getInternalState()) {
            dialog.setLastResponse(this, sIPResponse);
        }
        processResponse(sIPResponse, messageChannel, dialog);
    }
}
