package android.gov.nist.javax.sip;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Host;
import android.gov.nist.core.HostPort;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.address.SipUri;
import android.gov.nist.javax.sip.header.Contact;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel;
import android.gov.nist.javax.sip.stack.MessageChannel;
import android.gov.nist.javax.sip.stack.MessageProcessor;
import ir.nasim.InterfaceC17579nC3;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC7782Te1;
import ir.nasim.MD6;

/* loaded from: classes.dex */
public class ListeningPointImpl implements InterfaceC17579nC3, ListeningPointExt {
    private static StackLogger logger = CommonLogger.getLogger(ListeningPointImpl.class);
    protected MessageProcessor messageProcessor;
    int port;
    protected SipProviderImpl sipProvider;
    protected SipStackImpl sipStack;
    protected String transport;

    protected ListeningPointImpl(MD6 md6, int i, String str) {
        this.sipStack = (SipStackImpl) md6;
        this.port = i;
        this.transport = str;
    }

    public static String makeKey(String str, int i, String str2) {
        return (str + ":" + i + Separators.SLASH + str2).toLowerCase();
    }

    public Object clone() {
        ListeningPointImpl listeningPointImpl = new ListeningPointImpl(this.sipStack, this.port, null);
        listeningPointImpl.sipStack = this.sipStack;
        return listeningPointImpl;
    }

    @Override // android.gov.nist.javax.sip.ListeningPointExt
    public InterfaceC7782Te1 createContactHeader() {
        try {
            String iPAddress = getIPAddress();
            int port = getPort();
            SipUri sipUri = new SipUri();
            sipUri.setHost(iPAddress);
            sipUri.setPort(port);
            sipUri.setTransportParam(this.transport);
            Contact contact = new Contact();
            AddressImpl addressImpl = new AddressImpl();
            addressImpl.setURI(sipUri);
            contact.setAddress(addressImpl);
            return contact;
        } catch (Exception unused) {
            InternalErrorHandler.handleException("Unexpected exception", logger);
            return null;
        }
    }

    @Override // android.gov.nist.javax.sip.ListeningPointExt
    public InterfaceC18318oS7 createViaHeader() {
        return getViaHeader();
    }

    @Override // ir.nasim.InterfaceC17579nC3
    public String getIPAddress() {
        return this.messageProcessor.getIpAddress().getHostAddress();
    }

    protected String getKey() {
        return makeKey(getIPAddress(), this.port, this.transport);
    }

    public MessageProcessor getMessageProcessor() {
        return this.messageProcessor;
    }

    @Override // ir.nasim.InterfaceC17579nC3
    public int getPort() {
        return this.messageProcessor.getPort();
    }

    public SipProviderImpl getProvider() {
        return this.sipProvider;
    }

    @Override // android.gov.nist.javax.sip.ListeningPointExt
    public String getSentBy() {
        return this.messageProcessor.getSentBy();
    }

    @Override // ir.nasim.InterfaceC17579nC3
    public String getTransport() {
        return this.messageProcessor.getTransport();
    }

    public Via getViaHeader() {
        return this.messageProcessor.getViaHeader();
    }

    public boolean isSentBySet() {
        return this.messageProcessor.isSentBySet();
    }

    public void removeSipProvider() {
        this.sipProvider = null;
    }

    @Override // android.gov.nist.javax.sip.ListeningPointExt
    public void sendHeartbeat(String str, int i) {
        if (this.sipStack.isAlive()) {
            HostPort hostPort = new HostPort();
            hostPort.setHost(new Host(str));
            hostPort.setPort(i);
            MessageChannel messageChannelCreateMessageChannel = this.messageProcessor.createMessageChannel(hostPort);
            SIPRequest sIPRequest = new SIPRequest();
            sIPRequest.setNullRequest();
            if (messageChannelCreateMessageChannel instanceof ConnectionOrientedMessageChannel) {
                ConnectionOrientedMessageChannel connectionOrientedMessageChannel = (ConnectionOrientedMessageChannel) messageChannelCreateMessageChannel;
                long keepAliveTimeout = connectionOrientedMessageChannel.getKeepAliveTimeout();
                if (keepAliveTimeout > 0) {
                    connectionOrientedMessageChannel.rescheduleKeepAliveTimeout(keepAliveTimeout);
                }
            }
            messageChannelCreateMessageChannel.sendMessage(sIPRequest);
        }
    }

    @Override // android.gov.nist.javax.sip.ListeningPointExt
    public void setSentBy(String str) {
        this.messageProcessor.setSentBy(str);
    }

    public void setSipProvider(SipProviderImpl sipProviderImpl) {
        this.sipProvider = sipProviderImpl;
    }
}
