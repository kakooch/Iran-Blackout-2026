package android.gov.nist.javax.sip;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.LogWriter;
import android.gov.nist.core.ServerLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.core.ThreadAuditor;
import android.gov.nist.core.net.AddressResolver;
import android.gov.nist.core.net.DefaultSecurityManagerProvider;
import android.gov.nist.core.net.NetworkLayer;
import android.gov.nist.core.net.SecurityManagerProvider;
import android.gov.nist.core.net.SslNetworkLayer;
import android.gov.nist.javax.sip.clientauthutils.AccountManager;
import android.gov.nist.javax.sip.clientauthutils.AuthenticationHelper;
import android.gov.nist.javax.sip.clientauthutils.AuthenticationHelperImpl;
import android.gov.nist.javax.sip.clientauthutils.SecureAccountManager;
import android.gov.nist.javax.sip.parser.MessageParserFactory;
import android.gov.nist.javax.sip.parser.PostParseExecutorServices;
import android.gov.nist.javax.sip.parser.StringMsgParser;
import android.gov.nist.javax.sip.parser.StringMsgParserFactory;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.ByteBufferFactory;
import android.gov.nist.javax.sip.stack.ClientAuthType;
import android.gov.nist.javax.sip.stack.DefaultMessageLogFactory;
import android.gov.nist.javax.sip.stack.DefaultRouter;
import android.gov.nist.javax.sip.stack.MessageProcessor;
import android.gov.nist.javax.sip.stack.MessageProcessorFactory;
import android.gov.nist.javax.sip.stack.NIOMode;
import android.gov.nist.javax.sip.stack.OIOMessageProcessorFactory;
import android.gov.nist.javax.sip.stack.SIPEventInterceptor;
import android.gov.nist.javax.sip.stack.SIPMessageValve;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.gov.nist.javax.sip.stack.timers.DefaultSipTimer;
import android.gov.nist.javax.sip.stack.timers.SipTimer;
import android.javax.sip.InvalidArgumentException;
import android.javax.sip.ObjectInUseException;
import android.javax.sip.PeerUnavailableException;
import android.javax.sip.TransportNotSupportedException;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC17579nC3;
import ir.nasim.KD6;
import ir.nasim.LD6;
import ir.nasim.LU2;
import ir.nasim.MD6;
import ir.nasim.W46;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

/* loaded from: classes.dex */
public class SipStackImpl extends SIPTransactionStack implements MD6, SipStackExt {
    private String[] cipherSuites;
    private Properties configurationProperties;
    private String[] enabledProtocols;
    private EventScanner eventScanner;
    protected Hashtable<String, ListeningPointImpl> listeningPoints;
    private boolean reEntrantListener;
    KD6 sipListener;
    protected List<SipProviderImpl> sipProviders;
    private Semaphore stackSemaphore;
    TlsSecurityPolicy tlsSecurityPolicy;
    private static StackLogger logger = CommonLogger.getLogger(SipStackImpl.class);
    public static final Integer MAX_DATAGRAM_SIZE = 65536;
    public static final String[] DEFAULT_CIPHERS = {"TLS_RSA_WITH_AES_128_CBC_SHA", "SSL_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA"};

    protected SipStackImpl() {
        this.stackSemaphore = new Semaphore(1);
        this.cipherSuites = DEFAULT_CIPHERS;
        this.enabledProtocols = new String[]{"TLSv1.2", "TLSv1.1", "TLSv1"};
        super.setMessageFactory(new NistSipMessageFactoryImpl(this));
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<>();
        this.sipProviders = new CopyOnWriteArrayList();
        try {
            if (Charset.forName("UTF-8") != null) {
            } else {
                throw new UnsupportedCharsetException("Unsupported charset UTF-8");
            }
        } catch (Exception e) {
            logger.logWarning("UTF-8 charset cannot be used this system. This will lead to unpredictable behavior when parsing SIP messages: " + e.getMessage());
        }
    }

    private void reInitialize() {
        super.reInit();
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<>();
        this.sipProviders = new CopyOnWriteArrayList();
        this.sipListener = null;
        if (getTimer().isStarted()) {
            return;
        }
        try {
            setTimer((SipTimer) Class.forName(this.configurationProperties.getProperty("android.gov.nist.javax.sip.TIMER_CLASS_NAME", DefaultSipTimer.class.getName())).newInstance());
            getTimer().start(this, this.configurationProperties);
            if (getThreadAuditor() == null || !getThreadAuditor().isEnabled()) {
                return;
            }
            getTimer().schedule(new SIPTransactionStack.PingTimer(null), 0L);
        } catch (Exception e) {
            logger.logError("Bad configuration value for android.gov.nist.javax.sip.TIMER_CLASS_NAME", e);
        }
    }

    public boolean acquireSem() {
        try {
            return this.stackSemaphore.tryAcquire(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            return false;
        }
    }

    @Deprecated
    public void addLogAppender(Appender appender) {
        StackLogger stackLogger = logger;
        if (stackLogger instanceof LogWriter) {
            ((LogWriter) stackLogger).addAppender(appender);
        }
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public synchronized InterfaceC17579nC3 createListeningPoint(String str, int i, String str2) {
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("createListeningPoint : address = " + str + " port = " + i + " transport = " + str2);
            }
            if (str == null) {
                throw new NullPointerException("Address for listening point is null!");
            }
            if (str2 == null) {
                throw new NullPointerException("null transport");
            }
            if (i <= 0) {
                throw new InvalidArgumentException("bad port");
            }
            if (!str2.equalsIgnoreCase("UDP") && !str2.equalsIgnoreCase("TLS") && !str2.equalsIgnoreCase("TCP") && !str2.equalsIgnoreCase("SCTP") && !str2.equalsIgnoreCase(ListeningPointExt.WS) && !str2.equalsIgnoreCase(ListeningPointExt.WSS)) {
                throw new TransportNotSupportedException("bad transport " + str2);
            }
            if (!isAlive()) {
                this.toExit = false;
                reInitialize();
            }
            String strMakeKey = ListeningPointImpl.makeKey(str, i, str2);
            ListeningPointImpl listeningPointImpl = this.listeningPoints.get(strMakeKey);
            if (listeningPointImpl != null) {
                return listeningPointImpl;
            }
            try {
                MessageProcessor messageProcessorCreateMessageProcessor = createMessageProcessor(InetAddress.getByName(str), i, str2);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Created Message Processor: " + str + " port = " + i + " transport = " + str2);
                }
                ListeningPointImpl listeningPointImpl2 = new ListeningPointImpl(this, i, str2);
                listeningPointImpl2.messageProcessor = messageProcessorCreateMessageProcessor;
                messageProcessorCreateMessageProcessor.setListeningPoint(listeningPointImpl2);
                this.listeningPoints.put(strMakeKey, listeningPointImpl2);
                messageProcessorCreateMessageProcessor.start();
                return listeningPointImpl2;
            } catch (IOException e) {
                if (logger.isLoggingEnabled()) {
                    logger.logError("Invalid argument address = " + str + " port = " + i + " transport = " + str2);
                }
                throw new InvalidArgumentException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public LD6 createSipProvider(InterfaceC17579nC3 interfaceC17579nC3) throws ObjectInUseException {
        if (interfaceC17579nC3 == null) {
            throw new NullPointerException("null listeningPoint");
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("createSipProvider: " + interfaceC17579nC3);
        }
        ListeningPointImpl listeningPointImpl = (ListeningPointImpl) interfaceC17579nC3;
        if (listeningPointImpl.sipProvider != null) {
            throw new ObjectInUseException("Provider already attached!");
        }
        SipProviderImpl sipProviderImpl = new SipProviderImpl(this);
        sipProviderImpl.setListeningPoint(listeningPointImpl);
        listeningPointImpl.sipProvider = sipProviderImpl;
        this.sipProviders.add(sipProviderImpl);
        return sipProviderImpl;
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public void deleteListeningPoint(InterfaceC17579nC3 interfaceC17579nC3) {
        if (interfaceC17579nC3 == null) {
            throw new NullPointerException("null listeningPoint arg");
        }
        ListeningPointImpl listeningPointImpl = (ListeningPointImpl) interfaceC17579nC3;
        super.removeMessageProcessor(listeningPointImpl.messageProcessor);
        this.listeningPoints.remove(listeningPointImpl.getKey());
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public void deleteSipProvider(LD6 ld6) throws ObjectInUseException {
        if (ld6 == null) {
            throw new NullPointerException("null provider arg");
        }
        SipProviderImpl sipProviderImpl = (SipProviderImpl) ld6;
        if (sipProviderImpl.getSipListener() != null) {
            throw new ObjectInUseException("SipProvider still has an associated SipListener!");
        }
        sipProviderImpl.removeListeningPoints();
        sipProviderImpl.stop();
        this.sipProviders.remove(ld6);
        if (this.sipProviders.isEmpty()) {
            stopStack();
        }
    }

    protected void finalize() {
        stopStack();
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public AuthenticationHelper getAuthenticationHelper(AccountManager accountManager, LU2 lu2) {
        return new AuthenticationHelperImpl(this, accountManager, lu2);
    }

    public Properties getConfigurationProperties() {
        return this.configurationProperties;
    }

    public String[] getEnabledCipherSuites() {
        return this.cipherSuites;
    }

    public String[] getEnabledProtocols() {
        return this.enabledProtocols;
    }

    public EventScanner getEventScanner() {
        return this.eventScanner;
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public String getIPAddress() {
        return super.getHostAddress();
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public Iterator getListeningPoints() {
        return this.listeningPoints.values().iterator();
    }

    public LogRecordFactory getLogRecordFactory() {
        return this.logRecordFactory;
    }

    @Deprecated
    public Logger getLogger() {
        StackLogger stackLogger = logger;
        if (stackLogger instanceof LogWriter) {
            return ((LogWriter) stackLogger).getLogger();
        }
        return null;
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public AuthenticationHelper getSecureAuthenticationHelper(SecureAccountManager secureAccountManager, LU2 lu2) {
        return new AuthenticationHelperImpl(this, secureAccountManager, lu2);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionStack
    public KD6 getSipListener() {
        return this.sipListener;
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public Iterator<SipProviderImpl> getSipProviders() {
        return this.sipProviders.iterator();
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public String getStackName() {
        return this.stackName;
    }

    public TlsSecurityPolicy getTlsSecurityPolicy() {
        return this.tlsSecurityPolicy;
    }

    public boolean isAutomaticDialogErrorHandlingEnabled() {
        return this.isAutomaticDialogErrorHandlingEnabled;
    }

    boolean isAutomaticDialogSupportEnabled() {
        return this.isAutomaticDialogSupportEnabled;
    }

    public boolean isBackToBackUserAgent() {
        return this.isBackToBackUserAgent;
    }

    public boolean isReEntrantListener() {
        return this.reEntrantListener;
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public boolean isRetransmissionFilterActive() {
        return true;
    }

    public void releaseSem() {
        this.stackSemaphore.release();
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public void setEnabledCipherSuites(String[] strArr) {
        this.cipherSuites = strArr;
    }

    public void setEnabledProtocols(String[] strArr) {
        this.enabledProtocols = strArr;
    }

    public void setIsBackToBackUserAgent(boolean z) {
        this.isBackToBackUserAgent = z;
    }

    public void setTlsSecurityPolicy(TlsSecurityPolicy tlsSecurityPolicy) {
        this.tlsSecurityPolicy = tlsSecurityPolicy;
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public void start() {
        if (this.eventScanner == null) {
            this.eventScanner = new EventScanner(this);
        }
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public void stop() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("stopStack -- stoppping the stack");
            logger.logStackTrace();
        }
        stopStack();
        if (this.sipMessageValves.size() != 0) {
            Iterator<SIPMessageValve> it = this.sipMessageValves.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
        }
        SIPEventInterceptor sIPEventInterceptor = this.sipEventInterceptor;
        if (sIPEventInterceptor != null) {
            sIPEventInterceptor.destroy();
        }
        this.sipProviders = new CopyOnWriteArrayList();
        this.listeningPoints = new Hashtable<>();
        EventScanner eventScanner = this.eventScanner;
        if (eventScanner != null) {
            eventScanner.forceStop();
        }
        this.eventScanner = null;
        PostParseExecutorServices.shutdownThreadpool();
    }

    public SipStackImpl(Properties properties) throws PeerUnavailableException, InterruptedException, NumberFormatException, IOException {
        this();
        MergedSystemProperties mergedSystemProperties = new MergedSystemProperties(properties);
        this.configurationProperties = mergedSystemProperties;
        String property = mergedSystemProperties.getProperty("android.javax.sip.IP_ADDRESS");
        if (property != null) {
            try {
                super.setHostAddress(property);
            } catch (UnknownHostException unused) {
                throw new PeerUnavailableException("bad address " + property);
            }
        }
        String property2 = mergedSystemProperties.getProperty("android.javax.sip.STACK_NAME");
        if (property2 != null) {
            super.setStackName(property2);
            String property3 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.STACK_LOGGER");
            String str = property3 == null ? "android.gov.nist.core.LogWriter" : property3;
            try {
                StackLogger stackLogger = (StackLogger) Class.forName(str).getConstructor(null).newInstance(null);
                CommonLogger.legacyLogger = stackLogger;
                stackLogger.setStackProperties(mergedSystemProperties);
                String property4 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.SERVER_LOGGER");
                try {
                    ServerLogger serverLogger = (ServerLogger) Class.forName(property4 == null ? "android.gov.nist.javax.sip.stack.ServerLog" : property4).getConstructor(null).newInstance(null);
                    this.serverLogger = serverLogger;
                    serverLogger.setSipStack(this);
                    this.serverLogger.setStackProperties(mergedSystemProperties);
                    super.setReliableConnectionKeepAliveTimeout(Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.RELIABLE_CONNECTION_KEEP_ALIVE_TIMEOUT", "-1")) * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                    super.setSslHandshakeTimeout(Long.parseLong(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.SSL_HANDSHAKE_TIMEOUT", "-1")));
                    super.setThreadPriority(Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.THREAD_PRIORITY", "10")));
                    this.outboundProxy = mergedSystemProperties.getProperty("android.javax.sip.OUTBOUND_PROXY");
                    ByteBufferFactory.getInstance().setUseDirect(Boolean.valueOf(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.stack.USE_DIRECT_BUFFERS", Boolean.TRUE.toString())).booleanValue());
                    this.defaultRouter = new DefaultRouter(this, this.outboundProxy);
                    String property5 = mergedSystemProperties.getProperty("android.javax.sip.ROUTER_PATH");
                    try {
                        super.setRouter((W46) Class.forName(property5 == null ? "android.gov.nist.javax.sip.stack.DefaultRouter" : property5).getConstructor(MD6.class, String.class).newInstance(this, this.outboundProxy));
                        String property6 = mergedSystemProperties.getProperty("android.javax.sip.USE_ROUTER_FOR_ALL_URIS");
                        this.useRouterForAll = true;
                        if (property6 != null) {
                            this.useRouterForAll = "true".equalsIgnoreCase(property6);
                        }
                        String property7 = mergedSystemProperties.getProperty("android.javax.sip.EXTENSION_METHODS");
                        if (property7 != null) {
                            StringTokenizer stringTokenizer = new StringTokenizer(property7);
                            while (stringTokenizer.hasMoreTokens()) {
                                String strNextToken = stringTokenizer.nextToken(":");
                                if (!strNextToken.equalsIgnoreCase(TokenNames.BYE) && !strNextToken.equalsIgnoreCase(TokenNames.INVITE) && !strNextToken.equalsIgnoreCase(TokenNames.SUBSCRIBE) && !strNextToken.equalsIgnoreCase(TokenNames.NOTIFY) && !strNextToken.equalsIgnoreCase(TokenNames.ACK) && !strNextToken.equalsIgnoreCase(TokenNames.OPTIONS)) {
                                    addExtensionMethod(strNextToken);
                                } else {
                                    throw new PeerUnavailableException("Bad extension method " + strNextToken);
                                }
                            }
                        }
                        String property8 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.TLS_CLIENT_AUTH_TYPE");
                        if (property8 != null) {
                            this.clientAuth = ClientAuthType.valueOf(property8);
                            logger.logInfo("using " + property8 + " tls auth policy");
                        }
                        String property9 = mergedSystemProperties.getProperty("javax.net.ssl.keyStore");
                        String property10 = mergedSystemProperties.getProperty("javax.net.ssl.trustStore");
                        if (property9 != null) {
                            String str2 = property10 == null ? property9 : property10;
                            String property11 = mergedSystemProperties.getProperty("javax.net.ssl.keyStorePassword");
                            String property12 = mergedSystemProperties.getProperty("javax.net.ssl.trustStorePassword", property11);
                            String property13 = mergedSystemProperties.getProperty("javax.net.ssl.keyStoreType");
                            String property14 = mergedSystemProperties.getProperty("javax.net.ssl.trustStoreType");
                            try {
                                this.networkLayer = new SslNetworkLayer(this, str2, property9, property11 != null ? property11.toCharArray() : null, property12 != null ? property12.toCharArray() : null, property13, property14 == null ? property13 : property14);
                            } catch (Exception e) {
                                logger.logError("could not instantiate SSL networking", e);
                            }
                        }
                        this.isAutomaticDialogSupportEnabled = mergedSystemProperties.getProperty("android.javax.sip.AUTOMATIC_DIALOG_SUPPORT", "on").equalsIgnoreCase("on");
                        this.isAutomaticDialogErrorHandlingEnabled = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.AUTOMATIC_DIALOG_ERROR_HANDLING", "true").equals(Boolean.TRUE.toString());
                        if (this.isAutomaticDialogSupportEnabled) {
                            this.isAutomaticDialogErrorHandlingEnabled = true;
                        }
                        if (mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME") != null) {
                            int i = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME"));
                            this.maxListenerResponseTime = i;
                            if (i <= 0) {
                                throw new PeerUnavailableException("Bad configuration parameter android.gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME : should be positive");
                            }
                        } else {
                            this.maxListenerResponseTime = -1;
                        }
                        if (mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_TX_LIFETIME_INVITE") != null) {
                            this.maxTxLifetimeInvite = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_TX_LIFETIME_INVITE"));
                            if (super.getMaxTxLifetimeInvite() <= 0) {
                                throw new PeerUnavailableException("Bad configuration parameter android.gov.nist.javax.sip.MAX_TX_LIFETIME_INVITE : should be positive");
                            }
                        } else {
                            this.maxTxLifetimeInvite = -1;
                        }
                        if (mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_TX_LIFETIME_NON_INVITE") != null) {
                            this.maxTxLifetimeNonInvite = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_TX_LIFETIME_NON_INVITE"));
                            if (super.getMaxTxLifetimeNonInvite() <= 0) {
                                throw new PeerUnavailableException("Bad configuration parameter android.gov.nist.javax.sip.MAX_TX_LIFETIME_NON_INVITE : should be positive");
                            }
                        } else {
                            this.maxTxLifetimeNonInvite = -1;
                        }
                        setDeliverTerminatedEventForAck(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.DELIVER_TERMINATED_EVENT_FOR_ACK", "false").equalsIgnoreCase("true"));
                        super.setDeliverUnsolicitedNotify(Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.DELIVER_UNSOLICITED_NOTIFY", "false")));
                        String property15 = mergedSystemProperties.getProperty("android.javax.sip.FORKABLE_EVENTS");
                        if (property15 != null) {
                            StringTokenizer stringTokenizer2 = new StringTokenizer(property15);
                            while (stringTokenizer2.hasMoreTokens()) {
                                this.forkedEvents.add(stringTokenizer2.nextToken());
                            }
                        }
                        String property16 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.TLS_SECURITY_POLICY");
                        if (property16 == null) {
                            logger.logWarning("using default tls security policy");
                            property16 = "android.gov.nist.javax.sip.stack.DefaultTlsSecurityPolicy";
                        }
                        String str3 = property16;
                        try {
                            this.tlsSecurityPolicy = (TlsSecurityPolicy) Class.forName(str3).getConstructor(null).newInstance(null);
                            if (mergedSystemProperties.containsKey("android.gov.nist.javax.sip.NETWORK_LAYER")) {
                                String property17 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.NETWORK_LAYER");
                                try {
                                    NetworkLayer networkLayer = (NetworkLayer) Class.forName(property17).getConstructor(null).newInstance(null);
                                    this.networkLayer = networkLayer;
                                    networkLayer.setSipStack(this);
                                } catch (Exception e2) {
                                    throw new PeerUnavailableException("can't find or instantiate NetworkLayer implementation: " + property17, e2);
                                }
                            }
                            if (mergedSystemProperties.containsKey("android.gov.nist.javax.sip.ADDRESS_RESOLVER")) {
                                String property18 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.ADDRESS_RESOLVER");
                                try {
                                    this.addressResolver = (AddressResolver) Class.forName(property18).getConstructor(null).newInstance(null);
                                } catch (Exception e3) {
                                    throw new PeerUnavailableException("can't find or instantiate AddressResolver implementation: " + property18, e3);
                                }
                            }
                            String property19 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_CONNECTIONS");
                            if (property19 != null) {
                                try {
                                    this.maxConnections = new Integer(property19).intValue();
                                } catch (NumberFormatException e4) {
                                    if (logger.isLoggingEnabled()) {
                                        logger.logError("max connections - bad value " + e4.getMessage());
                                    }
                                }
                            }
                            String property20 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.THREAD_POOL_SIZE");
                            if (property20 != null) {
                                try {
                                    this.threadPoolSize = new Integer(property20).intValue();
                                } catch (NumberFormatException e5) {
                                    if (logger.isLoggingEnabled()) {
                                        logger.logError("thread pool size - bad value " + e5.getMessage());
                                    }
                                }
                            }
                            int i2 = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.CONGESTION_CONTROL_TIMEOUT", "8000"));
                            super.setStackCongestionControlTimeout(i2);
                            String property21 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.TCP_POST_PARSING_THREAD_POOL_SIZE");
                            if (property21 != null) {
                                try {
                                    int iIntValue = new Integer(property21).intValue();
                                    super.setTcpPostParsingThreadPoolSize(iIntValue);
                                    PostParseExecutorServices.setPostParseExcutorSize(this, iIntValue, i2);
                                } catch (NumberFormatException e6) {
                                    if (logger.isLoggingEnabled()) {
                                        logger.logError("TCP post-parse thread pool size - bad value " + property21 + " : " + e6.getMessage());
                                    }
                                }
                            }
                            String property22 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_SERVER_TRANSACTIONS");
                            if (property22 != null) {
                                try {
                                    int iIntValue2 = new Integer(property22).intValue();
                                    this.serverTransactionTableHighwaterMark = iIntValue2;
                                    this.serverTransactionTableLowaterMark = (iIntValue2 * 80) / 100;
                                } catch (NumberFormatException e7) {
                                    if (logger.isLoggingEnabled()) {
                                        logger.logError("transaction table size - bad value " + e7.getMessage());
                                    }
                                }
                            } else {
                                this.unlimitedServerTransactionTableSize = true;
                            }
                            String property23 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_CLIENT_TRANSACTIONS");
                            if (property23 != null) {
                                try {
                                    this.clientTransactionTableHiwaterMark = new Integer(property23).intValue();
                                    this.clientTransactionTableLowaterMark = (this.clientTransactionTableLowaterMark * 80) / 100;
                                } catch (NumberFormatException e8) {
                                    if (logger.isLoggingEnabled()) {
                                        logger.logError("transaction table size - bad value " + e8.getMessage());
                                    }
                                }
                            } else {
                                this.unlimitedClientTransactionTableSize = true;
                            }
                            if (mergedSystemProperties.containsKey("android.gov.nist.javax.sip.SECURITY_MANAGER_PROVIDER")) {
                                String property24 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.SECURITY_MANAGER_PROVIDER");
                                try {
                                    this.securityManagerProvider = (SecurityManagerProvider) Class.forName(property24).getConstructor(null).newInstance(null);
                                } catch (Exception e9) {
                                    throw new PeerUnavailableException("can't find or instantiate SecurityManagerProvider implementation: " + property24, e9);
                                }
                            } else {
                                this.securityManagerProvider = new DefaultSecurityManagerProvider();
                            }
                            try {
                                this.securityManagerProvider.init(mergedSystemProperties);
                                this.cacheServerConnections = true;
                                String property25 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.CACHE_SERVER_CONNECTIONS");
                                if (property25 != null && "false".equalsIgnoreCase(property25.trim())) {
                                    this.cacheServerConnections = false;
                                }
                                this.cacheClientConnections = true;
                                String property26 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS");
                                if (property26 != null && "false".equalsIgnoreCase(property26.trim())) {
                                    this.cacheClientConnections = false;
                                }
                                String property27 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.READ_TIMEOUT");
                                if (property27 != null) {
                                    try {
                                        int i3 = Integer.parseInt(property27);
                                        if (i3 >= 100) {
                                            this.readTimeout = i3;
                                        } else {
                                            System.err.println("Value too low " + property27);
                                        }
                                    } catch (NumberFormatException unused2) {
                                        if (logger.isLoggingEnabled()) {
                                            logger.logError("Bad read timeout " + property27);
                                        }
                                    }
                                }
                                String property28 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.CONNECTION_TIMEOUT");
                                if (property28 != null) {
                                    try {
                                        int i4 = Integer.parseInt(property28);
                                        if (i4 >= 100) {
                                            this.connTimeout = i4;
                                        } else {
                                            System.err.println("Value too low " + property27);
                                        }
                                    } catch (NumberFormatException unused3) {
                                        if (logger.isLoggingEnabled()) {
                                            logger.logError("Bad conn timeout " + property27);
                                        }
                                    }
                                }
                                if (mergedSystemProperties.getProperty("android.gov.nist.javax.sip.STUN_SERVER") != null) {
                                    logger.logWarning("Ignoring obsolete property android.gov.nist.javax.sip.STUN_SERVER");
                                }
                                String property29 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_MESSAGE_SIZE");
                                try {
                                    if (property29 != null) {
                                        int iIntValue3 = new Integer(property29).intValue();
                                        this.maxMessageSize = iIntValue3;
                                        if (iIntValue3 < 4096) {
                                            this.maxMessageSize = 4096;
                                        }
                                    } else {
                                        this.maxMessageSize = 0;
                                    }
                                } catch (NumberFormatException e10) {
                                    if (logger.isLoggingEnabled()) {
                                        logger.logError("maxMessageSize - bad value " + e10.getMessage());
                                    }
                                }
                                String property30 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.REENTRANT_LISTENER");
                                this.reEntrantListener = property30 != null && "true".equalsIgnoreCase(property30);
                                String property31 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.THREAD_AUDIT_INTERVAL_IN_MILLISECS");
                                if (property31 != null) {
                                    try {
                                        this.threadAuditor = new ThreadAuditor();
                                        getThreadAuditor().setPingIntervalInMillisecs(Long.valueOf(property31).longValue() / 2);
                                    } catch (NumberFormatException e11) {
                                        if (logger.isLoggingEnabled()) {
                                            logger.logError("THREAD_AUDIT_INTERVAL_IN_MILLISECS - bad value [" + property31 + "] " + e11.getMessage());
                                        }
                                    }
                                }
                                setNon2XXAckPassedToListener(Boolean.valueOf(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.PASS_INVITE_NON_2XX_ACK_TO_LISTENER", "false")).booleanValue());
                                this.generateTimeStampHeader = Boolean.valueOf(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.AUTO_GENERATE_TIMESTAMP", "false")).booleanValue();
                                String property32 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.LOG_FACTORY");
                                if (property32 != null) {
                                    try {
                                        this.logRecordFactory = (LogRecordFactory) Class.forName(property32).getConstructor(null).newInstance(null);
                                    } catch (Exception unused4) {
                                        if (logger.isLoggingEnabled()) {
                                            logger.logError("Bad configuration value for LOG_FACTORY -- using default logger");
                                        }
                                        this.logRecordFactory = new DefaultMessageLogFactory();
                                    }
                                } else {
                                    this.logRecordFactory = new DefaultMessageLogFactory();
                                }
                                StringMsgParser.setComputeContentLengthFromMessage(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.COMPUTE_CONTENT_LENGTH_FROM_MESSAGE_BODY", "false").equalsIgnoreCase("true"));
                                String property33 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.TLS_CLIENT_PROTOCOLS");
                                if (property33 != null) {
                                    StringTokenizer stringTokenizer3 = new StringTokenizer(property33, "\" ,");
                                    String[] strArr = new String[stringTokenizer3.countTokens()];
                                    if (logger.isLoggingEnabled(32)) {
                                        logger.logDebug("TLS Client Protocols = ");
                                    }
                                    int i5 = 0;
                                    while (stringTokenizer3.hasMoreTokens()) {
                                        strArr[i5] = stringTokenizer3.nextToken();
                                        if (logger.isLoggingEnabled(32)) {
                                            logger.logDebug("TLS Client Protocol = " + strArr[i5]);
                                        }
                                        i5++;
                                    }
                                    this.enabledProtocols = strArr;
                                }
                                String property34 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.ENABLED_CIPHER_SUITES");
                                if (property34 != null) {
                                    StringTokenizer stringTokenizer4 = new StringTokenizer(property34, "\" ,");
                                    String[] strArr2 = new String[stringTokenizer4.countTokens()];
                                    if (logger.isLoggingEnabled(32)) {
                                        logger.logDebug("Cipher Suites = ");
                                    }
                                    int i6 = 0;
                                    while (stringTokenizer4.hasMoreTokens()) {
                                        strArr2[i6] = stringTokenizer4.nextToken();
                                        if (logger.isLoggingEnabled(32)) {
                                            logger.logDebug("Cipher Suite = " + strArr2[i6]);
                                        }
                                        i6++;
                                    }
                                    this.cipherSuites = strArr2;
                                }
                                this.rfc2543Supported = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.RFC_2543_SUPPORT_ENABLED", "true").equalsIgnoreCase("true");
                                super.setPatchWebSocketHeaders(Boolean.valueOf(Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.PATCH_SIP_WEBSOCKETS_HEADERS", "true"))));
                                super.setPatchRport(Boolean.valueOf(Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.ALWAYS_ADD_RPORT", "false"))));
                                super.setPatchReceivedRport(Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.NEVER_ADD_RECEIVED_RPORT", "false")));
                                this.cancelClientTransactionChecked = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.CANCEL_CLIENT_TRANSACTION_CHECKED", "true").equalsIgnoreCase("true");
                                this.logStackTraceOnMessageSend = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.LOG_STACK_TRACE_ON_MESSAGE_SEND", "false").equalsIgnoreCase("true");
                                if (logger.isLoggingEnabled(32)) {
                                    logger.logDebug("created Sip stack. Properties = " + mergedSystemProperties);
                                }
                                InputStream resourceAsStream = getClass().getResourceAsStream("/TIMESTAMP");
                                if (resourceAsStream != null) {
                                    try {
                                        String line = new BufferedReader(new InputStreamReader(resourceAsStream)).readLine();
                                        resourceAsStream.close();
                                        logger.setBuildTimeStamp(line);
                                    } catch (IOException unused5) {
                                        logger.logError("Could not open build timestamp.");
                                    }
                                }
                                Integer num = MAX_DATAGRAM_SIZE;
                                super.setReceiveUdpBufferSize(new Integer(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.RECEIVE_UDP_BUFFER_SIZE", num.toString())).intValue());
                                super.setSendUdpBufferSize(new Integer(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.SEND_UDP_BUFFER_SIZE", num.toString())).intValue());
                                super.setConnectionLingerTimer(Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.LINGER_TIMER", "8")));
                                Boolean bool = Boolean.FALSE;
                                this.isBackToBackUserAgent = Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.IS_BACK_TO_BACK_USER_AGENT", bool.toString()));
                                this.checkBranchId = Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.REJECT_STRAY_RESPONSES", bool.toString()));
                                this.isDialogTerminatedEventDeliveredForNullDialog = Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.DELIVER_TERMINATED_EVENT_FOR_NULL_DIALOG", bool.toString()));
                                this.maxForkTime = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MAX_FORK_TIME_SECONDS", "0"));
                                this.earlyDialogTimeout = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.EARLY_DIALOG_TIMEOUT_SECONDS", "180"));
                                this.minKeepAliveInterval = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MIN_KEEPALIVE_TIME_SECONDS", "-1"));
                                this.deliverRetransmittedAckToListener = Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.DELIVER_RETRANSMITTED_ACK_TO_LISTENER", "false"));
                                this.dialogTimeoutFactor = Integer.parseInt(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.DIALOG_TIMEOUT_FACTOR", "64"));
                                try {
                                    this.messageParserFactory = (MessageParserFactory) Class.forName(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MESSAGE_PARSER_FACTORY", StringMsgParserFactory.class.getName())).newInstance();
                                } catch (Exception e12) {
                                    logger.logError("Bad configuration value for android.gov.nist.javax.sip.MESSAGE_PARSER_FACTORY", e12);
                                }
                                try {
                                    this.messageProcessorFactory = (MessageProcessorFactory) Class.forName(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.MESSAGE_PROCESSOR_FACTORY", OIOMessageProcessorFactory.class.getName())).newInstance();
                                } catch (Exception e13) {
                                    logger.logError("Bad configuration value for android.gov.nist.javax.sip.MESSAGE_PROCESSOR_FACTORY", e13);
                                }
                                String property35 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.NIO_MAX_SOCKET_IDLE_TIME", "7200000");
                                try {
                                    this.nioSocketMaxIdleTime = Long.parseLong(property35);
                                } catch (Exception e14) {
                                    logger.logError("Bad configuration value for android.gov.nist.javax.sip.NIO_MAX_SOCKET_IDLE_TIME=" + property35, e14);
                                }
                                String property36 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.NIO_BLOCKING_MODE", "BLOCKING");
                                try {
                                    this.nioMode = NIOMode.valueOf(property36);
                                } catch (Exception e15) {
                                    logger.logError("Bad configuration value for android.gov.nist.javax.sip.NIO_BLOCKING_MODE=" + property36, e15);
                                }
                                try {
                                    setTimer((SipTimer) Class.forName(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.TIMER_CLASS_NAME", DefaultSipTimer.class.getName())).newInstance());
                                    getTimer().start(this, mergedSystemProperties);
                                    if (getThreadAuditor() != null && getThreadAuditor().isEnabled()) {
                                        getTimer().schedule(new SIPTransactionStack.PingTimer(null), 0L);
                                    }
                                } catch (Exception e16) {
                                    logger.logError("Bad configuration value for android.gov.nist.javax.sip.TIMER_CLASS_NAME", e16);
                                }
                                if (Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.AGGRESSIVE_CLEANUP", Boolean.FALSE.toString()))) {
                                    setReleaseReferencesStrategy(ReleaseReferencesStrategy.Normal);
                                }
                                String property37 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.RELEASE_REFERENCES_STRATEGY");
                                if (property37 != null) {
                                    setReleaseReferencesStrategy(ReleaseReferencesStrategy.valueOf(property37));
                                    if (logger.isLoggingEnabled(32)) {
                                        logger.logDebug("Using following release references strategy " + getReleaseReferencesStrategy());
                                    }
                                }
                                String property38 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.SIP_MESSAGE_VALVE", null);
                                if (property38 != null && !property38.equals("")) {
                                    for (String str4 : property38.split(",")) {
                                        try {
                                            SIPMessageValve sIPMessageValve = (SIPMessageValve) Class.forName(str4).newInstance();
                                            try {
                                                Thread.sleep(100L);
                                                sIPMessageValve.init(this);
                                            } catch (Exception e17) {
                                                logger.logError("Error intializing SIPMessageValve", e17);
                                            }
                                            this.sipMessageValves.add(sIPMessageValve);
                                        } catch (Exception e18) {
                                            logger.logError("Bad configuration value for android.gov.nist.javax.sip.SIP_MESSAGE_VALVE", e18);
                                        }
                                    }
                                }
                                String property39 = mergedSystemProperties.getProperty("android.gov.nist.javax.sip.SIP_EVENT_INTERCEPTOR", null);
                                if (property39 != null && !property39.equals("")) {
                                    try {
                                        this.sipEventInterceptor = (SIPEventInterceptor) Class.forName(property39).newInstance();
                                        new Thread() { // from class: android.gov.nist.javax.sip.SipStackImpl.1
                                            @Override // java.lang.Thread, java.lang.Runnable
                                            public void run() throws InterruptedException {
                                                try {
                                                    Thread.sleep(100L);
                                                    SipStackImpl.this.sipEventInterceptor.init(this);
                                                } catch (Exception e19) {
                                                    SipStackImpl.logger.logError("Error intializing SIPEventInterceptor", e19);
                                                }
                                            }
                                        }.start();
                                    } catch (Exception e19) {
                                        logger.logError("Bad configuration value for android.gov.nist.javax.sip.SIP_EVENT_INTERCEPTOR", e19);
                                    }
                                }
                                setSslRenegotiationEnabled(Boolean.parseBoolean(mergedSystemProperties.getProperty("android.gov.nist.javax.sip.SSL_RENEGOTIATION_ENABLED", "true")));
                                return;
                            } catch (IOException e20) {
                                throw new PeerUnavailableException("Cannot initialize security manager provider", e20);
                            } catch (GeneralSecurityException e21) {
                                throw new PeerUnavailableException("Cannot initialize security manager provider", e21);
                            }
                        } catch (InvocationTargetException e22) {
                            throw new IllegalArgumentException("Cound not instantiate TLS security policy " + str3 + "- check that it is present on the classpath and that there is a no-args constructor defined", e22);
                        } catch (Exception e23) {
                            throw new IllegalArgumentException("Cound not instantiate TLS security policy " + str3 + "- check that it is present on the classpath and that there is a no-args constructor defined", e23);
                        }
                    } catch (InvocationTargetException e24) {
                        logger.logError("could not instantiate router -- invocation target problem", (Exception) e24.getCause());
                        throw new PeerUnavailableException("Cound not instantiate router - check constructor", e24);
                    } catch (Exception e25) {
                        logger.logError("could not instantiate router", (Exception) e25.getCause());
                        throw new PeerUnavailableException("Could not instantiate router", e25);
                    }
                } catch (InvocationTargetException e26) {
                    throw new IllegalArgumentException("Cound not instantiate server logger " + str + "- check that it is present on the classpath and that there is a no-args constructor defined", e26);
                } catch (Exception e27) {
                    throw new IllegalArgumentException("Cound not instantiate server logger " + str + "- check that it is present on the classpath and that there is a no-args constructor defined", e27);
                }
            } catch (InvocationTargetException e28) {
                throw new IllegalArgumentException("Cound not instantiate stack logger " + str + "- check that it is present on the classpath and that there is a no-args constructor defined", e28);
            } catch (Exception e29) {
                throw new IllegalArgumentException("Cound not instantiate stack logger " + str + "- check that it is present on the classpath and that there is a no-args constructor defined", e29);
            }
        }
        throw new PeerUnavailableException("stack name is missing");
    }

    @Override // android.gov.nist.javax.sip.SipStackExt
    public InterfaceC17579nC3 createListeningPoint(int i, String str) {
        String str2 = this.stackAddress;
        if (str2 != null) {
            return createListeningPoint(str2, i, str);
        }
        throw new NullPointerException("Stack does not have a default IP Address!");
    }
}
