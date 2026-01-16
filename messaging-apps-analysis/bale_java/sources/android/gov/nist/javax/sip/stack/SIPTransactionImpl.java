package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.ReleaseReferencesStrategy;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.SipProviderImpl;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.ThreadAffinityTask;
import android.gov.nist.javax.sip.address.AddressFactoryImpl;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.SIPClientTransactionImpl;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C13253fu7;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.ND6;
import ir.nasim.UP5;
import ir.nasim.UZ2;
import java.io.IOException;
import java.net.InetAddress;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class SIPTransactionImpl implements SIPTransaction {
    protected int T2;
    protected int T4;
    protected transient Object applicationData;
    protected long auditTag;
    protected int baseTimerInterval = SIPTransactionStack.BASE_TIMER_INTERVAL;
    private String branch;
    protected int collectionTime;
    private int currentState;
    private Boolean dialogCreatingTransaction;
    protected transient MessageChannel encapsulatedChannel;
    private transient Set<SIPTransactionEventListener> eventListeners;
    public SIPClientTransactionImpl.ExpiresTimerTask expiresTimerTask;
    private String forkId;
    private Boolean inviteTransaction;
    protected boolean isMapped;
    protected SIPResponse lastResponse;
    private MaxTxLifeTimeListener maxTxLifeTimeListener;
    protected String mergeId;
    private String method;
    protected SIPRequest originalRequest;
    protected String originalRequestBranch;
    protected byte[] originalRequestBytes;
    protected long originalRequestCSeqNumber;
    protected boolean originalRequestHasPort;
    private ReleaseReferencesStrategy releaseReferencesStrategy;
    private transient int retransmissionTimerLastTickCount;
    private transient int retransmissionTimerTicksLeft;
    private transient TransactionSemaphore semaphore;
    protected transient SIPTransactionStack sipStack;
    private boolean terminatedEventDelivered;
    protected int timeoutTimerTicksLeft;
    protected int timerD;
    protected int timerI;
    protected int timerK;
    protected boolean toListener;
    protected String transactionId;
    protected AtomicBoolean transactionTimerStarted;
    private static StackLogger logger = CommonLogger.getLogger(SIPTransaction.class);
    private static final Pattern EXTRACT_CN = Pattern.compile(".*CN\\s*=\\s*([\\w*\\.\\-_]+).*");

    class LingerTimer extends SIPStackTimerTask {
        public LingerTimer() {
            if (SIPTransactionImpl.logger.isLoggingEnabled(32)) {
                SIPTransactionImpl.logger.logDebug("LingerTimer : " + SIPTransactionImpl.this.getTransactionId());
            }
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            UP5 request = SIPTransactionImpl.this.getRequest();
            if (request == null || !(request instanceof SIPRequest)) {
                return null;
            }
            return ((SIPRequest) request).getCallIdHeader().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            SIPTransactionImpl.this.cleanUp();
        }
    }

    class MaxTxLifeTimeListener extends SIPStackTimerTask {
        SIPTransaction sipTransaction;

        MaxTxLifeTimeListener() {
            this.sipTransaction = SIPTransactionImpl.this;
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            UP5 request = SIPTransactionImpl.this.getRequest();
            if (request == null || !(request instanceof SIPRequest)) {
                return null;
            }
            return ((SIPRequest) request).getCallIdHeader().getCallId();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            try {
                if (SIPTransactionImpl.logger.isLoggingEnabled(32)) {
                    SIPTransactionImpl.logger.logDebug("Fired MaxTxLifeTimeListener for tx " + this.sipTransaction + " , tx id " + this.sipTransaction.getTransactionId() + " , state " + this.sipTransaction.getState());
                }
                SIPTransactionImpl.this.raiseErrorEvent(1);
                LingerTimer lingerTimer = SIPTransactionImpl.this.new LingerTimer();
                if (SIPTransactionImpl.this.sipStack.getConnectionLingerTimer() != 0) {
                    SIPTransactionImpl.this.sipStack.getTimer().schedule(lingerTimer, SIPTransactionImpl.this.sipStack.getConnectionLingerTimer() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                } else {
                    lingerTimer.runTask();
                }
                SIPTransactionImpl.this.maxTxLifeTimeListener = null;
            } catch (Exception e) {
                SIPTransactionImpl.logger.logError("unexpected exception", e);
            }
        }
    }

    class TransactionSemaphore {
        private static final long serialVersionUID = -1634100711669020804L;
        ReentrantLock lock;
        Semaphore sem;

        public TransactionSemaphore() {
            this.sem = null;
            this.lock = null;
            if (((SipStackImpl) SIPTransactionImpl.this.sipStack).isReEntrantListener()) {
                this.lock = new ReentrantLock();
            } else {
                this.sem = new Semaphore(1, true);
            }
        }

        public boolean acquire() throws InterruptedException {
            try {
                if (((SipStackImpl) SIPTransactionImpl.this.sipStack).isReEntrantListener()) {
                    this.lock.lock();
                    return true;
                }
                this.sem.acquire();
                return true;
            } catch (Exception e) {
                SIPTransactionImpl.logger.logError("Unexpected exception acquiring sem", e);
                InternalErrorHandler.handleException(e);
                return false;
            }
        }

        public void release() {
            try {
                if (!((SipStackImpl) SIPTransactionImpl.this.sipStack).isReEntrantListener()) {
                    this.sem.release();
                } else if (this.lock.isHeldByCurrentThread()) {
                    this.lock.unlock();
                }
            } catch (Exception e) {
                SIPTransactionImpl.logger.logError("Unexpected exception releasing sem", e);
            }
        }

        public boolean tryAcquire() {
            try {
                return ((SipStackImpl) SIPTransactionImpl.this.sipStack).isReEntrantListener() ? this.lock.tryLock(SIPTransactionImpl.this.sipStack.maxListenerResponseTime, TimeUnit.SECONDS) : this.sem.tryAcquire(SIPTransactionImpl.this.sipStack.maxListenerResponseTime, TimeUnit.SECONDS);
            } catch (Exception e) {
                SIPTransactionImpl.logger.logError("Unexpected exception trying acquiring sem", e);
                InternalErrorHandler.handleException(e);
                return false;
            }
        }
    }

    protected SIPTransactionImpl(SIPTransactionStack sIPTransactionStack, MessageChannel messageChannel) {
        int i = 5000 / SIPTransactionStack.BASE_TIMER_INTERVAL;
        this.T4 = i;
        this.T2 = 4000 / SIPTransactionStack.BASE_TIMER_INTERVAL;
        this.timerI = i;
        this.timerK = i;
        this.timerD = 32000 / SIPTransactionStack.BASE_TIMER_INTERVAL;
        this.auditTag = 0L;
        this.transactionTimerStarted = new AtomicBoolean(false);
        this.currentState = -1;
        this.inviteTransaction = null;
        this.dialogCreatingTransaction = null;
        this.forkId = null;
        this.mergeId = null;
        this.sipStack = sIPTransactionStack;
        this.semaphore = new TransactionSemaphore();
        this.encapsulatedChannel = messageChannel;
        if (isReliable()) {
            this.encapsulatedChannel.useCount++;
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("use count for encapsulated channel" + this + Separators.SP + this.encapsulatedChannel.useCount);
            }
        }
        this.currentState = -1;
        disableRetransmissionTimer();
        disableTimeoutTimer();
        this.eventListeners = new CopyOnWriteArraySet();
        addEventListener(sIPTransactionStack);
        this.releaseReferencesStrategy = this.sipStack.getReleaseReferencesStrategy();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean acquireSem() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("acquireSem [[[[" + this);
            logger.logStackTrace();
        }
        boolean zAcquire = this.sipStack.maxListenerResponseTime == -1 ? this.semaphore.acquire() : this.semaphore.tryAcquire();
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("acquireSem() returning : " + zAcquire);
        }
        return zAcquire;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void addEventListener(SIPTransactionEventListener sIPTransactionEventListener) {
        this.eventListeners.add(sIPTransactionEventListener);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void cancelMaxTxLifeTimeTimer() {
        if (this.maxTxLifeTimeListener != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Cancelling MaxTxLifeTimeListener for tx " + this + " , tx id " + getTransactionId() + " , state " + getState());
            }
            this.sipStack.getTimer().cancel(this.maxTxLifeTimeListener);
            this.maxTxLifeTimeListener = null;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public abstract void cleanUp();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void close() {
        this.encapsulatedChannel.close();
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Closing " + this.encapsulatedChannel);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void disableRetransmissionTimer() {
        this.retransmissionTimerTicksLeft = -1;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void disableTimeoutTimer() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("disableTimeoutTimer " + this);
        }
        this.timeoutTimerTicksLeft = -1;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean doesCancelMatchTransaction(SIPRequest sIPRequest) {
        Via topmostVia;
        SIPRequest originalRequest = getOriginalRequest();
        if (originalRequest == null || getMethod().equals("CANCEL") || (topmostVia = sIPRequest.getTopmostVia()) == null) {
            return false;
        }
        String branch = topmostVia.getBranch();
        if (branch != null && !branch.toLowerCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_LOWER_CASE)) {
            branch = null;
        }
        if (branch == null || getBranch() == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("testing against " + originalRequest);
            }
            if (!originalRequest.getRequestURI().equals(sIPRequest.getRequestURI()) || !originalRequest.getTo().equals(sIPRequest.getTo()) || !originalRequest.getFrom().equals(sIPRequest.getFrom()) || !originalRequest.getCallId().getCallId().equals(sIPRequest.getCallId().getCallId()) || originalRequest.getCSeq().getSeqNumber() != sIPRequest.getCSeq().getSeqNumber() || !topmostVia.equals(originalRequest.getTopmostVia())) {
                return false;
            }
        } else {
            if (!getBranch().equalsIgnoreCase(branch) || !topmostVia.getSentBy().equals(originalRequest.getTopmostVia().getSentBy())) {
                return false;
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("returning  true");
            }
        }
        return true;
    }

    protected void enableRetransmissionTimer() {
        enableRetransmissionTimer(1);
    }

    protected void enableTimeoutTimer(int i) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("enableTimeoutTimer " + this + " tickCount " + i + " currentTickCount = " + this.timeoutTimerTicksLeft);
        }
        this.timeoutTimerTicksLeft = i;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public List<String> extractCertIdentities() throws CertificateParsingException {
        Collection<List<?>> subjectAlternativeNames;
        if (!(getMessageChannel() instanceof TLSMessageChannel) && !(getMessageChannel() instanceof NioTlsMessageChannel)) {
            throw new UnsupportedOperationException("Not a TLS channel");
        }
        ArrayList arrayList = new ArrayList();
        Certificate[] peerCertificates = getPeerCertificates();
        if (peerCertificates == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("No certificates available");
            }
            return arrayList;
        }
        for (Certificate certificate : peerCertificates) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            try {
                subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            } catch (CertificateParsingException e) {
                if (logger.isLoggingEnabled()) {
                    logger.logError("Error parsing TLS certificate", e);
                }
                subjectAlternativeNames = null;
            }
            if (subjectAlternativeNames != null) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("found subjAltNames: " + subjectAlternativeNames);
                }
                for (List<?> list : subjectAlternativeNames) {
                    if (list.get(0).equals(6)) {
                        try {
                            ND6 nd6CreateSipURI = new AddressFactoryImpl().createSipURI((String) list.get(1));
                            if ("sip".equals(nd6CreateSipURI.getScheme()) && nd6CreateSipURI.getUser() == null) {
                                String host = nd6CreateSipURI.getHost();
                                if (logger.isLoggingEnabled(32)) {
                                    logger.logDebug("found uri " + list.get(1) + ", hostName " + host);
                                }
                                arrayList.add(host);
                            }
                        } catch (ParseException unused) {
                            if (logger.isLoggingEnabled()) {
                                logger.logError("certificate contains invalid uri: " + list.get(1));
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    for (List<?> list2 : subjectAlternativeNames) {
                        if (list2.get(0).equals(2)) {
                            if (logger.isLoggingEnabled(32)) {
                                logger.logDebug("found dns " + list2.get(1));
                            }
                            arrayList.add(list2.get(1).toString());
                        }
                    }
                }
            } else {
                String name = x509Certificate.getSubjectDN().getName();
                try {
                    Matcher matcher = EXTRACT_CN.matcher(name);
                    if (matcher.matches()) {
                        String strGroup = matcher.group(1);
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("found CN: " + strGroup + " from DN: " + name);
                        }
                        arrayList.add(strGroup);
                    }
                } catch (Exception e2) {
                    if (logger.isLoggingEnabled()) {
                        logger.logError("exception while extracting CN", e2);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void fireTimer() {
        int i = this.timeoutTimerTicksLeft;
        if (i != -1) {
            int i2 = i - 1;
            this.timeoutTimerTicksLeft = i2;
            if (i2 == 0) {
                fireTimeoutTimer();
            }
        }
        int i3 = this.retransmissionTimerTicksLeft;
        if (i3 != -1) {
            int i4 = i3 - 1;
            this.retransmissionTimerTicksLeft = i4;
            if (i4 == 0) {
                enableRetransmissionTimer(this.retransmissionTimerLastTickCount * 2);
                fireRetransmissionTimer();
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public Object getApplicationData() {
        return this.applicationData;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public long getAuditTag() {
        return this.auditTag;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getBaseTimerInterval() {
        return this.baseTimerInterval;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getBranch() {
        if (this.branch == null) {
            this.branch = this.originalRequestBranch;
        }
        return this.branch;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public String getBranchId() {
        return this.branch;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public long getCSeq() {
        return this.originalRequestCSeqNumber;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public String getCipherSuite() {
        if (getMessageChannel() instanceof TLSMessageChannel) {
            if (((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener() == null || ((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null) {
                return null;
            }
            return ((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getCipherSuite();
        }
        if (!(getMessageChannel() instanceof NioTlsMessageChannel)) {
            throw new UnsupportedOperationException("Not a TLS channel");
        }
        if (((NioTlsMessageChannel) getMessageChannel()).getHandshakeCompletedListener() == null) {
            return null;
        }
        return ((NioTlsMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getCipherSuite();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public abstract InterfaceC17658nL1 getDialog();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getForkId() {
        return this.forkId;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public String getHost() {
        return this.encapsulatedChannel.getHost();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getInternalState() {
        return this.currentState;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getKey() {
        return this.encapsulatedChannel.getKey();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public SIPResponse getLastResponse() {
        return this.lastResponse;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public Certificate[] getLocalCertificates() {
        if (getMessageChannel() instanceof TLSMessageChannel) {
            if (((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener() == null || ((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null) {
                return null;
            }
            return ((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getLocalCertificates();
        }
        if (!(getMessageChannel() instanceof NioTlsMessageChannel)) {
            throw new UnsupportedOperationException("Not a TLS channel");
        }
        if (((NioTlsMessageChannel) getMessageChannel()).getHandshakeCompletedListener() == null) {
            return null;
        }
        return ((NioTlsMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getLocalCertificates();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getMergeId() {
        String str = this.mergeId;
        return str == null ? ((SIPRequest) getRequest()).getMergeId() : str;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public MessageChannel getMessageChannel() {
        return this.encapsulatedChannel;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public MessageProcessor getMessageProcessor() {
        return this.encapsulatedChannel.getMessageProcessor();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getMethod() {
        return this.method;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public SIPRequest getOriginalRequest() {
        return this.originalRequest;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public String getPeerAddress() {
        return this.encapsulatedChannel.getPeerAddress();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public Certificate[] getPeerCertificates() {
        if (getMessageChannel() instanceof TLSMessageChannel) {
            if (((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener() == null || ((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent() == null) {
                return null;
            }
            return ((TLSMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getHandshakeCompletedEvent().getPeerCertificates();
        }
        if (!(getMessageChannel() instanceof NioTlsMessageChannel)) {
            throw new UnsupportedOperationException("Not a TLS channel");
        }
        if (((NioTlsMessageChannel) getMessageChannel()).getHandshakeCompletedListener() == null) {
            return null;
        }
        return ((NioTlsMessageChannel) getMessageChannel()).getHandshakeCompletedListener().getPeerCertificates();
    }

    public InetAddress getPeerInetAddress() {
        return this.encapsulatedChannel.getPeerInetAddress();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public InetAddress getPeerPacketSourceAddress() {
        return this.encapsulatedChannel.getPeerPacketSourceAddress();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getPeerPacketSourcePort() {
        return this.encapsulatedChannel.getPeerPacketSourcePort();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public int getPeerPort() {
        return this.encapsulatedChannel.getPeerPort();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getPeerProtocol() {
        return this.encapsulatedChannel.getPeerProtocol();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public int getPort() {
        return this.encapsulatedChannel.getPort();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public ReleaseReferencesStrategy getReleaseReferencesStrategy() {
        return this.releaseReferencesStrategy;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public UP5 getRequest() {
        if (getReleaseReferencesStrategy() != ReleaseReferencesStrategy.None && this.originalRequest == null && this.originalRequestBytes != null) {
            if (logger.isLoggingEnabled(8)) {
                logger.logWarning("reparsing original request " + this.originalRequestBytes + " since it was eagerly cleaned up, but beware this is not efficient with the aggressive flag set !");
            }
            try {
                this.originalRequest = (SIPRequest) this.sipStack.getMessageParserFactory().createMessageParser(this.sipStack).parseSIPMessage(this.originalRequestBytes, true, false, null);
            } catch (ParseException e) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("message " + this.originalRequestBytes + " could not be reparsed !", e);
                }
            }
        }
        return this.originalRequest;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public InterfaceC10981cX5 getResponse() {
        return this.lastResponse;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public int getRetransmitTimer() {
        return SIPTransactionStack.BASE_TIMER_INTERVAL;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public SIPTransactionStack getSIPStack() {
        return this.sipStack;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public C13253fu7 getState() {
        int i = this.currentState;
        if (i < 0) {
            return null;
        }
        return C13253fu7.a(i);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getT2() {
        return this.T2;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getT4() {
        return this.T4;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public int getTimerD() {
        return this.timerD;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getTimerI() {
        return this.timerI;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getTimerK() {
        return this.timerK;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public int getTimerT2() {
        return this.T2;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public int getTimerT4() {
        return this.T4;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getTransactionId() {
        return this.transactionId;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public String getTransport() {
        return this.encapsulatedChannel.getTransport();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public Via getViaHeader() {
        Via viaHeader = this.encapsulatedChannel.getViaHeader();
        try {
            viaHeader.setBranch(this.branch);
        } catch (ParseException unused) {
        }
        return viaHeader;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public String getViaHost() {
        return getViaHeader().getHost();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int getViaPort() {
        return getViaHeader().getPort();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public int hashCode() {
        String str = this.transactionId;
        if (str == null) {
            return -1;
        }
        return str.hashCode();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isByeTransaction() {
        return getMethod().equals(TokenNames.BYE);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isCancelTransaction() {
        return getMethod().equals("CANCEL");
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isDialogCreatingTransaction() {
        if (this.dialogCreatingTransaction == null) {
            this.dialogCreatingTransaction = Boolean.valueOf(isInviteTransaction() || getMethod().equals(TokenNames.SUBSCRIBE) || getMethod().equals("REFER"));
        }
        return this.dialogCreatingTransaction.booleanValue();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isInviteTransaction() {
        if (this.inviteTransaction == null) {
            this.inviteTransaction = Boolean.valueOf(getMethod().equals(TokenNames.INVITE));
        }
        return this.inviteTransaction.booleanValue();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public abstract boolean isMessagePartOfTransaction(SIPMessage sIPMessage);

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isReliable() {
        return this.encapsulatedChannel.isReliable();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isSecure() {
        return this.encapsulatedChannel.isSecure();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isServerTransaction() {
        return this instanceof SIPServerTransaction;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isTerminated() {
        return this.currentState == 5;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean isTransactionMapped() {
        return this.isMapped;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public boolean passToListener() {
        return this.toListener;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void raiseErrorEvent(int i) {
        SIPTransactionErrorEvent sIPTransactionErrorEvent = new SIPTransactionErrorEvent(this, i);
        synchronized (this.eventListeners) {
            try {
                Iterator<SIPTransactionEventListener> it = this.eventListeners.iterator();
                while (it.hasNext()) {
                    it.next().transactionErrorEvent(sIPTransactionErrorEvent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i != 3) {
            this.eventListeners.clear();
            setState(5);
            if ((this instanceof SIPServerTransaction) && isByeTransaction() && getDialog() != null) {
                ((SIPDialog) getDialog()).setState(3);
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void raiseIOExceptionEvent() {
        setState(5);
        getSipProvider().handleEvent(new UZ2(this, getPeerAddress(), getPeerPort(), getTransport()), this);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void releaseSem() {
        try {
            this.toListener = false;
            semRelease();
        } catch (Exception e) {
            logger.logError("Unexpected exception releasing sem", e);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void removeEventListener(SIPTransactionEventListener sIPTransactionEventListener) {
        this.eventListeners.remove(sIPTransactionEventListener);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void scheduleMaxTxLifeTimeTimer() {
        if (this.maxTxLifeTimeListener == null && getMethod().equalsIgnoreCase(TokenNames.INVITE) && this.sipStack.getMaxTxLifetimeInvite() > 0) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Scheduling MaxTxLifeTimeListener for tx " + this + " , tx id " + getTransactionId() + " , state " + getState());
            }
            this.maxTxLifeTimeListener = new MaxTxLifeTimeListener();
            this.sipStack.getTimer().schedule(this.maxTxLifeTimeListener, this.sipStack.getMaxTxLifetimeInvite() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
        if (this.maxTxLifeTimeListener != null || getMethod().equalsIgnoreCase(TokenNames.INVITE) || this.sipStack.getMaxTxLifetimeNonInvite() <= 0) {
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Scheduling MaxTxLifeTimeListener for tx " + this + " , tx id " + getTransactionId() + " , state " + getState());
        }
        this.maxTxLifeTimeListener = new MaxTxLifeTimeListener();
        this.sipStack.getTimer().schedule(this.maxTxLifeTimeListener, this.sipStack.getMaxTxLifetimeNonInvite() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void semRelease() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("semRelease ]]]]" + this);
            logger.logStackTrace();
        }
        this.semaphore.release();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void sendMessage(final SIPMessage sIPMessage) {
        final RawMessageChannel rawMessageChannel;
        int i;
        try {
            rawMessageChannel = (RawMessageChannel) this.encapsulatedChannel;
        } finally {
            startTransactionTimer();
        }
        for (MessageProcessor messageProcessor : this.sipStack.getMessageProcessors()) {
            if (messageProcessor.getIpAddress().getHostAddress().toString().equals(getPeerAddress()) && messageProcessor.getPort() == getPeerPort() && messageProcessor.getTransport().equalsIgnoreCase(getPeerProtocol())) {
                if (rawMessageChannel instanceof TCPMessageChannel) {
                    try {
                        getSIPStack().getSelfRoutingThreadpoolExecutor().execute(new ThreadAffinityTask() { // from class: android.gov.nist.javax.sip.stack.SIPTransactionImpl.1
                            @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
                            public Object getThreadHash() {
                                return sIPMessage.getCallId().getCallId();
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ((TCPMessageChannel) rawMessageChannel).processMessage((SIPMessage) sIPMessage.clone(), SIPTransactionImpl.this.getPeerInetAddress());
                                } catch (Exception e) {
                                    if (SIPTransactionImpl.logger.isLoggingEnabled(4)) {
                                        SIPTransactionImpl.logger.logError("Error self routing TCP message cause by: ", e);
                                    }
                                }
                            }
                        });
                    } catch (Exception e) {
                        logger.logError("Error passing message in self routing TCP", e);
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Self routing message TCP");
                    }
                    return;
                }
                if (rawMessageChannel instanceof TLSMessageChannel) {
                    try {
                        getSIPStack().getSelfRoutingThreadpoolExecutor().execute(new ThreadAffinityTask() { // from class: android.gov.nist.javax.sip.stack.SIPTransactionImpl.2
                            @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
                            public Object getThreadHash() {
                                return sIPMessage.getCallId().getCallId();
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ((TLSMessageChannel) rawMessageChannel).processMessage((SIPMessage) sIPMessage.clone(), SIPTransactionImpl.this.getPeerInetAddress());
                                } catch (Exception e2) {
                                    if (SIPTransactionImpl.logger.isLoggingEnabled(4)) {
                                        SIPTransactionImpl.logger.logError("Error self routing TLS message cause by: ", e2);
                                    }
                                }
                            }
                        });
                    } catch (Exception e2) {
                        logger.logError("Error passing message in TLS self routing", e2);
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Self routing message TLS");
                    }
                    return;
                }
                if (rawMessageChannel instanceof RawMessageChannel) {
                    try {
                        getSIPStack().getSelfRoutingThreadpoolExecutor().execute(new ThreadAffinityTask() { // from class: android.gov.nist.javax.sip.stack.SIPTransactionImpl.3
                            @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
                            public Object getThreadHash() {
                                return sIPMessage.getCallId().getCallId();
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    rawMessageChannel.processMessage((SIPMessage) sIPMessage.clone());
                                } catch (Exception e3) {
                                    if (SIPTransactionImpl.logger.isLoggingEnabled(4)) {
                                        SIPTransactionImpl.logger.logError("Error self routing message cause by: ", e3);
                                    }
                                }
                            }
                        });
                    } catch (Exception e3) {
                        logger.logError("Error passing message in self routing", e3);
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Self routing message");
                    }
                    return;
                }
                startTransactionTimer();
            }
        }
        this.encapsulatedChannel.sendMessage(sIPMessage, getPeerInetAddress(), getPeerPort());
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public void setApplicationData(Object obj) {
        this.applicationData = obj;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setAuditTag(long j) {
        this.auditTag = j;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setBranch(String str) {
        this.branch = str;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setCollectionTime(int i) {
        this.collectionTime = i;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public abstract void setDialog(SIPDialog sIPDialog, String str);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setEncapsulatedChannel(MessageChannel messageChannel) {
        this.encapsulatedChannel = messageChannel;
        if (this instanceof SIPClientTransaction) {
            messageChannel.setEncapsulatedClientTransaction((SIPClientTransaction) this);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setForkId(String str) {
        this.forkId = str;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setOriginalRequest(SIPRequest sIPRequest) {
        String transactionId = sIPRequest.getTransactionId();
        SIPRequest sIPRequest2 = this.originalRequest;
        if (sIPRequest2 != null && !sIPRequest2.getTransactionId().equals(transactionId)) {
            this.sipStack.removeTransactionHash(this);
        }
        this.originalRequest = sIPRequest;
        this.originalRequestCSeqNumber = sIPRequest.getCSeq().getSeqNumber();
        Via topmostVia = sIPRequest.getTopmostVia();
        this.originalRequestBranch = topmostVia.getBranch();
        this.originalRequestHasPort = topmostVia.hasPort();
        if (topmostVia.getPort() == -1) {
            topmostVia.getTransport().equalsIgnoreCase("TLS");
        }
        this.method = sIPRequest.getMethod();
        this.transactionId = transactionId;
        this.originalRequest.setTransaction(this);
        String branch = topmostVia.getBranch();
        if (branch != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Setting Branch id : " + branch);
            }
            setBranch(branch);
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Branch id is null - compute TID!" + sIPRequest.encode());
        }
        setBranch(transactionId);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setPassToListener() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("setPassToListener()");
        }
        this.toListener = true;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public void setReleaseReferencesStrategy(ReleaseReferencesStrategy releaseReferencesStrategy) {
        this.releaseReferencesStrategy = releaseReferencesStrategy;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public void setRetransmitTimer(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Retransmit timer must be positive!");
        }
        if (this.transactionTimerStarted.get()) {
            throw new IllegalStateException("Transaction timer is already started");
        }
        this.baseTimerInterval = i;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setState(int i) {
        int i2 = this.currentState;
        if (i2 == 3 && i != 5 && i != 4) {
            i = 3;
        }
        int i3 = (i2 != 4 || i == 5) ? i : 4;
        if (i2 != 5) {
            this.currentState = i3;
            i2 = i3;
        }
        if (i2 == 3) {
            enableTimeoutTimer(64);
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Transaction:setState " + i2 + Separators.SP + this + " branchID = " + getBranch() + " isClient = " + (this instanceof SIPClientTransaction));
            logger.logStackTrace();
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public void setTimerD(int i) {
        if (i < 32000) {
            throw new IllegalArgumentException("To be RFC 3261 compliant, the value of Timer D should be at least 32s");
        }
        this.timerD = i / this.baseTimerInterval;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public void setTimerT2(int i) {
        this.T2 = i / this.baseTimerInterval;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public void setTimerT4(int i) {
        int i2 = i / this.baseTimerInterval;
        this.T4 = i2;
        this.timerI = i2;
        this.timerK = i2;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public void setTransactionMapped(boolean z) {
        this.isMapped = z;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction, android.gov.nist.javax.sip.TransactionExt
    public abstract /* synthetic */ void terminate();

    @Override // android.gov.nist.javax.sip.stack.SIPTransaction
    public synchronized boolean testAndSetTransactionTerminatedEvent() {
        boolean z;
        z = !this.terminatedEventDelivered;
        this.terminatedEventDelivered = true;
        return z;
    }

    protected void enableRetransmissionTimer(int i) {
        if (isInviteTransaction() && (this instanceof SIPClientTransaction)) {
            this.retransmissionTimerTicksLeft = i;
        } else {
            this.retransmissionTimerTicksLeft = Math.min(i, getTimerT2());
        }
        this.retransmissionTimerLastTickCount = this.retransmissionTimerTicksLeft;
    }

    @Override // android.gov.nist.javax.sip.TransactionExt
    public SipProviderImpl getSipProvider() {
        return getMessageProcessor().getListeningPoint().getProvider();
    }

    public void sendMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws IOException {
        throw new IOException("Cannot send unparsed message through Transaction Channel!");
    }
}
