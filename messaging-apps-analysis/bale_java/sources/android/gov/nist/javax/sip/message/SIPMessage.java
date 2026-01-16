package android.gov.nist.javax.sip.message;

import android.gov.nist.core.GenericObject;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.Utils;
import android.gov.nist.javax.sip.header.AlertInfo;
import android.gov.nist.javax.sip.header.Authorization;
import android.gov.nist.javax.sip.header.CSeq;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.Contact;
import android.gov.nist.javax.sip.header.ContactList;
import android.gov.nist.javax.sip.header.ContentLength;
import android.gov.nist.javax.sip.header.ContentType;
import android.gov.nist.javax.sip.header.ErrorInfo;
import android.gov.nist.javax.sip.header.ErrorInfoList;
import android.gov.nist.javax.sip.header.From;
import android.gov.nist.javax.sip.header.InReplyTo;
import android.gov.nist.javax.sip.header.MaxForwards;
import android.gov.nist.javax.sip.header.Priority;
import android.gov.nist.javax.sip.header.ProxyAuthenticate;
import android.gov.nist.javax.sip.header.ProxyAuthorization;
import android.gov.nist.javax.sip.header.ProxyRequire;
import android.gov.nist.javax.sip.header.ProxyRequireList;
import android.gov.nist.javax.sip.header.RSeq;
import android.gov.nist.javax.sip.header.RecordRouteList;
import android.gov.nist.javax.sip.header.RetryAfter;
import android.gov.nist.javax.sip.header.Route;
import android.gov.nist.javax.sip.header.RouteList;
import android.gov.nist.javax.sip.header.SIPETag;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderList;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.SIPHeaderNamesCache;
import android.gov.nist.javax.sip.header.SIPIfMatch;
import android.gov.nist.javax.sip.header.Server;
import android.gov.nist.javax.sip.header.Subject;
import android.gov.nist.javax.sip.header.To;
import android.gov.nist.javax.sip.header.Unsupported;
import android.gov.nist.javax.sip.header.UserAgent;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.header.ViaList;
import android.gov.nist.javax.sip.header.WWWAuthenticate;
import android.gov.nist.javax.sip.header.Warning;
import android.gov.nist.javax.sip.parser.ParserFactory;
import android.javax.sip.InvalidArgumentException;
import android.javax.sip.SipException;
import ir.nasim.HU2;
import ir.nasim.InterfaceC12560ep0;
import ir.nasim.InterfaceC17560nA2;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC18560or7;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC21427te2;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.InterfaceC23329wk1;
import ir.nasim.InterfaceC24509yk1;
import ir.nasim.InterfaceC7365Rk1;
import ir.nasim.InterfaceC7599Sk1;
import ir.nasim.InterfaceC9654aK5;
import ir.nasim.K44;
import ir.nasim.VV3;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public abstract class SIPMessage extends MessageObject implements K44, MessageExt {
    protected Object applicationData;
    protected CSeq cSeqHeader;
    protected CallID callIdHeader;
    protected ContentLength contentLengthHeader;
    protected String forkId;
    protected From fromHeader;
    private InetAddress localAddress;
    private int localPort;
    protected MaxForwards maxForwardsHeader;
    protected String messageContent;
    protected byte[] messageContentBytes;
    protected Object messageContentObject;
    protected boolean nullRequest;
    private InetAddress peerPacketSourceAddress;
    private int peerPacketSourcePort;
    private InetAddress remoteAddress;
    private int remotePort;
    protected int size;
    protected To toHeader;
    private static final String CONTENT_TYPE_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.CONTENT_TYPE);
    private static final String ERROR_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.ERROR_INFO);
    private static final String CONTACT_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.CONTACT);
    private static final String VIA_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.VIA);
    private static final String AUTHORIZATION_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.AUTHORIZATION);
    private static final String ROUTE_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.ROUTE);
    private static final String RECORDROUTE_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.RECORD_ROUTE);
    private static final String CONTENT_DISPOSITION_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.CONTENT_DISPOSITION);
    private static final String CONTENT_ENCODING_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.CONTENT_ENCODING);
    private static final String CONTENT_LANGUAGE_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.CONTENT_LANGUAGE);
    private static final String EXPIRES_LOWERCASE = SIPHeaderNamesCache.toLowerCase(SIPHeaderNames.EXPIRES);
    private String contentEncodingCharset = MessageFactoryImpl.getDefaultContentEncodingCharset();
    protected LinkedList<String> unrecognizedHeaders = new LinkedList<>();
    protected ConcurrentLinkedQueue<SIPHeader> headers = new ConcurrentLinkedQueue<>();
    protected Map<String, SIPHeader> headerTable = new ConcurrentHashMap();

    public SIPMessage() {
        try {
            attachHeader(new ContentLength(0), false);
        } catch (Exception unused) {
        }
    }

    private void attachHeader(SIPHeader sIPHeader) {
        if (sIPHeader == null) {
            throw new IllegalArgumentException("null header!");
        }
        try {
            if ((sIPHeader instanceof SIPHeaderList) && ((SIPHeaderList) sIPHeader).isEmpty()) {
                return;
            }
            attachHeader(sIPHeader, false, false);
        } catch (SIPDuplicateHeaderException unused) {
        }
    }

    private void computeContentLength(Object obj) {
        int length;
        if (obj == null) {
            length = 0;
        } else if (obj instanceof String) {
            try {
                length = ((String) obj).getBytes(getCharset()).length;
            } catch (UnsupportedEncodingException e) {
                InternalErrorHandler.handleException(e);
            }
        } else {
            length = obj instanceof byte[] ? ((byte[]) obj).length : obj.toString().length();
        }
        try {
            this.contentLengthHeader.setContentLength(length);
        } catch (InvalidArgumentException unused) {
        }
    }

    private List<SIPHeader> getHeaderList(String str) {
        SIPHeader sIPHeader = this.headerTable.get(SIPHeaderNamesCache.toLowerCase(str));
        if (sIPHeader == null) {
            return null;
        }
        if (sIPHeader instanceof SIPHeaderList) {
            return ((SIPHeaderList) sIPHeader).getHeaderList();
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(sIPHeader);
        return linkedList;
    }

    public static boolean isRequestHeader(SIPHeader sIPHeader) {
        return (sIPHeader instanceof AlertInfo) || (sIPHeader instanceof InReplyTo) || (sIPHeader instanceof Authorization) || (sIPHeader instanceof MaxForwards) || (sIPHeader instanceof UserAgent) || (sIPHeader instanceof Priority) || (sIPHeader instanceof ProxyAuthorization) || (sIPHeader instanceof ProxyRequire) || (sIPHeader instanceof ProxyRequireList) || (sIPHeader instanceof Route) || (sIPHeader instanceof RouteList) || (sIPHeader instanceof Subject) || (sIPHeader instanceof SIPIfMatch);
    }

    public static boolean isResponseHeader(SIPHeader sIPHeader) {
        return (sIPHeader instanceof ErrorInfo) || (sIPHeader instanceof ProxyAuthenticate) || (sIPHeader instanceof Server) || (sIPHeader instanceof Unsupported) || (sIPHeader instanceof RetryAfter) || (sIPHeader instanceof Warning) || (sIPHeader instanceof WWWAuthenticate) || (sIPHeader instanceof SIPETag) || (sIPHeader instanceof RSeq);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void addFirst(HU2 hu2) throws SipException {
        if (hu2 == null) {
            throw new NullPointerException("null arg!");
        }
        try {
            attachHeader((SIPHeader) hu2, false, true);
        } catch (SIPDuplicateHeaderException unused) {
            throw new SipException("Cannot add header - header already exists");
        }
    }

    @Override // ir.nasim.K44
    public void addHeader(HU2 hu2) {
        SIPHeader sIPHeader = (SIPHeader) hu2;
        try {
            try {
                if ((hu2 instanceof InterfaceC18318oS7) || (hu2 instanceof InterfaceC9654aK5)) {
                    attachHeader(sIPHeader, false, true);
                } else {
                    attachHeader(sIPHeader, false, false);
                }
            } catch (SIPDuplicateHeaderException unused) {
                if (hu2 instanceof ContentLength) {
                    this.contentLengthHeader.setContentLength(((ContentLength) hu2).getContentLength());
                }
            }
        } catch (InvalidArgumentException unused2) {
        }
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void addLast(HU2 hu2) throws SipException {
        if (hu2 == null) {
            throw new NullPointerException("null arg!");
        }
        try {
            attachHeader((SIPHeader) hu2, false, false);
        } catch (SIPDuplicateHeaderException unused) {
            throw new SipException("Cannot add header - header already exists");
        }
    }

    public void addUnparsed(String str) {
        getUnrecognizedHeadersList().add(str);
    }

    public void cleanUp() {
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        SIPMessage sIPMessage = (SIPMessage) super.clone();
        sIPMessage.headerTable = new ConcurrentHashMap();
        sIPMessage.fromHeader = null;
        sIPMessage.toHeader = null;
        sIPMessage.cSeqHeader = null;
        sIPMessage.callIdHeader = null;
        sIPMessage.contentLengthHeader = null;
        sIPMessage.maxForwardsHeader = null;
        sIPMessage.forkId = null;
        if (this.headers != null) {
            sIPMessage.headers = new ConcurrentLinkedQueue<>();
            Iterator<SIPHeader> it = this.headers.iterator();
            while (it.hasNext()) {
                sIPMessage.attachHeader((SIPHeader) it.next().clone());
            }
        }
        byte[] bArr = this.messageContentBytes;
        if (bArr != null) {
            sIPMessage.messageContentBytes = (byte[]) bArr.clone();
        }
        Object obj = this.messageContentObject;
        if (obj != null) {
            sIPMessage.messageContentObject = GenericObject.makeClone(obj);
        }
        sIPMessage.unrecognizedHeaders = this.unrecognizedHeaders;
        sIPMessage.remoteAddress = this.remoteAddress;
        sIPMessage.remotePort = this.remotePort;
        return sIPMessage;
    }

    @Override // android.gov.nist.javax.sip.message.MessageObject, android.gov.nist.core.GenericObject
    public String debugDump() {
        this.stringRepresentation = "";
        sprint("SIPMessage:");
        sprint("{");
        try {
            for (Field field : getClass().getDeclaredFields()) {
                Class<?> type = field.getType();
                String name = field.getName();
                if (field.get(this) != null && SIPHeader.class.isAssignableFrom(type) && name.compareTo("headers") != 0) {
                    sprint(name + Separators.EQUALS);
                    sprint(((SIPHeader) field.get(this)).debugDump());
                }
            }
        } catch (Exception e) {
            InternalErrorHandler.handleException(e);
        }
        sprint("List of headers : ");
        sprint(this.headers.toString());
        sprint("messageContent = ");
        sprint("{");
        sprint(this.messageContent);
        sprint("}");
        if (getContent() != null) {
            sprint(getContent().toString());
        }
        sprint("}");
        return this.stringRepresentation;
    }

    @Override // android.gov.nist.javax.sip.message.MessageObject, android.gov.nist.core.GenericObject
    public String encode() {
        StringBuilder sb = new StringBuilder();
        Iterator<SIPHeader> it = this.headers.iterator();
        while (it.hasNext()) {
            SIPHeader next = it.next();
            if (!(next instanceof ContentLength)) {
                next.encode(sb);
            }
        }
        LinkedList<String> linkedList = this.unrecognizedHeaders;
        if (linkedList != null) {
            Iterator<String> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
                sb.append(Separators.NEWLINE);
            }
        }
        this.contentLengthHeader.encode(sb).append(Separators.NEWLINE);
        if (this.messageContentObject != null) {
            sb.append(getContent().toString());
        } else {
            String str = this.messageContent;
            if (str != null || this.messageContentBytes != null) {
                if (str == null) {
                    try {
                        str = new String(this.messageContentBytes, getCharset());
                    } catch (UnsupportedEncodingException e) {
                        InternalErrorHandler.handleException(e);
                        str = null;
                    }
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public byte[] encodeAsBytes(String str) throws UnsupportedEncodingException {
        if ((this instanceof SIPRequest) && ((SIPRequest) this).isNullRequest()) {
            return "\r\n\r\n".getBytes();
        }
        try {
            ((InterfaceC18318oS7) getHeader(SIPHeaderNames.VIA)).setTransport(str);
        } catch (ParseException e) {
            InternalErrorHandler.handleException(e);
        }
        StringBuilder sb = new StringBuilder();
        synchronized (this.headers) {
            try {
                Iterator<SIPHeader> it = this.headers.iterator();
                while (it.hasNext()) {
                    SIPHeader next = it.next();
                    if (!(next instanceof ContentLength)) {
                        next.encode(sb);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.contentLengthHeader.encode(sb);
        sb.append(Separators.NEWLINE);
        byte[] rawContent = getRawContent();
        byte[] bytes = null;
        if (rawContent == null) {
            try {
                return sb.toString().getBytes(getCharset());
            } catch (UnsupportedEncodingException e2) {
                InternalErrorHandler.handleException(e2);
                return null;
            }
        }
        try {
            bytes = sb.toString().getBytes(getCharset());
        } catch (UnsupportedEncodingException e3) {
            InternalErrorHandler.handleException(e3);
        }
        byte[] bArr = new byte[bytes.length + rawContent.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(rawContent, 0, bArr, bytes.length, rawContent.length);
        return bArr;
    }

    public abstract StringBuilder encodeMessage(StringBuilder sb);

    protected StringBuilder encodeSIPHeaders(StringBuilder sb) {
        Iterator<SIPHeader> it = this.headers.iterator();
        while (it.hasNext()) {
            SIPHeader next = it.next();
            if (!(next instanceof ContentLength)) {
                next.encode(sb);
            }
        }
        StringBuilder sbEncode = this.contentLengthHeader.encode(sb);
        sbEncode.append(Separators.NEWLINE);
        return sbEncode;
    }

    @Override // android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        SIPMessage sIPMessage = (SIPMessage) obj;
        if (this.headerTable.size() != sIPMessage.headerTable.size()) {
            return false;
        }
        for (SIPHeader sIPHeader : this.headerTable.values()) {
            SIPHeader sIPHeader2 = sIPMessage.headerTable.get(SIPHeaderNamesCache.toLowerCase(sIPHeader.getName()));
            if (sIPHeader2 == null || !sIPHeader2.equals(sIPHeader)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public Object getApplicationData() {
        return this.applicationData;
    }

    public Authorization getAuthorization() {
        return (Authorization) getHeaderLowerCase(AUTHORIZATION_LOWERCASE);
    }

    public InterfaceC12560ep0 getCSeq() {
        return this.cSeqHeader;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC12560ep0 getCSeqHeader() {
        return this.cSeqHeader;
    }

    public InterfaceC21662tv0 getCallId() {
        return this.callIdHeader;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC21662tv0 getCallIdHeader() {
        return this.callIdHeader;
    }

    protected final String getCharset() {
        ContentType contentTypeHeader = getContentTypeHeader();
        if (contentTypeHeader == null) {
            return this.contentEncodingCharset;
        }
        String charset = contentTypeHeader.getCharset();
        return charset != null ? charset : this.contentEncodingCharset;
    }

    public Contact getContactHeader() {
        ContactList contactHeaders = getContactHeaders();
        if (contactHeaders != null) {
            return (Contact) contactHeaders.getFirst();
        }
        return null;
    }

    public ContactList getContactHeaders() {
        return (ContactList) getSIPHeaderListLowerCase(CONTACT_LOWERCASE);
    }

    @Override // ir.nasim.K44
    public Object getContent() {
        Object obj = this.messageContentObject;
        if (obj != null) {
            return obj;
        }
        String str = this.messageContent;
        if (str != null) {
            return str;
        }
        byte[] bArr = this.messageContentBytes;
        if (bArr != null) {
            return bArr;
        }
        return null;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC23329wk1 getContentDisposition() {
        return (InterfaceC23329wk1) getHeaderLowerCase(CONTENT_DISPOSITION_LOWERCASE);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC24509yk1 getContentEncoding() {
        return (InterfaceC24509yk1) getHeaderLowerCase(CONTENT_ENCODING_LOWERCASE);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC7365Rk1 getContentLanguage() {
        return (InterfaceC7365Rk1) getHeaderLowerCase(CONTENT_LANGUAGE_LOWERCASE);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC7599Sk1 getContentLength() {
        return this.contentLengthHeader;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC7599Sk1 getContentLengthHeader() {
        return getContentLength();
    }

    public final String getDialogId(boolean z) {
        return getDialogId(z, ((To) getTo()).getTag());
    }

    public ErrorInfoList getErrorInfoHeaders() {
        return (ErrorInfoList) getSIPHeaderListLowerCase(ERROR_LOWERCASE);
    }

    @Override // ir.nasim.K44
    public InterfaceC21427te2 getExpires() {
        return (InterfaceC21427te2) getHeaderLowerCase(EXPIRES_LOWERCASE);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public abstract String getFirstLine();

    public String getForkId() {
        String str = this.forkId;
        if (str != null) {
            return str;
        }
        String callId = getCallId().getCallId();
        String fromTag = getFromTag();
        if (fromTag == null) {
            throw new IllegalStateException("From tag is not yet set. Cannot compute forkId");
        }
        String lowerCase = (callId + ":" + fromTag).toLowerCase();
        this.forkId = lowerCase;
        return lowerCase;
    }

    public InterfaceC17560nA2 getFrom() {
        return this.fromHeader;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC17560nA2 getFromHeader() {
        return this.fromHeader;
    }

    public String getFromTag() {
        From from = this.fromHeader;
        if (from == null) {
            return null;
        }
        return from.getTag();
    }

    @Override // ir.nasim.K44
    public HU2 getHeader(String str) {
        return getHeaderLowerCase(SIPHeaderNamesCache.toLowerCase(str));
    }

    public String getHeaderAsFormattedString(String str) {
        String lowerCase = SIPHeaderNamesCache.toLowerCase(str);
        return this.headerTable.containsKey(lowerCase) ? this.headerTable.get(lowerCase).toString() : getHeader(str).toString();
    }

    protected HU2 getHeaderLowerCase(String str) {
        if (str == null) {
            throw new NullPointerException("bad name");
        }
        SIPHeader sIPHeader = this.headerTable.get(str);
        return sIPHeader instanceof SIPHeaderList ? ((SIPHeaderList) sIPHeader).getFirst() : sIPHeader;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public ListIterator<String> getHeaderNames() {
        Iterator<SIPHeader> it = this.headers.iterator();
        LinkedList linkedList = new LinkedList();
        while (it.hasNext()) {
            linkedList.add(it.next().getName());
        }
        return linkedList.listIterator();
    }

    public Iterator<SIPHeader> getHeaders() {
        return this.headers.iterator();
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public int getLocalPort() {
        return this.localPort;
    }

    public VV3 getMaxForwards() {
        return this.maxForwardsHeader;
    }

    public LinkedList<String> getMessageAsEncodedStrings() {
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<SIPHeader> it = this.headers.iterator();
        while (it.hasNext()) {
            SIPHeader next = it.next();
            if (next instanceof SIPHeaderList) {
                linkedList.addAll(((SIPHeaderList) next).getHeadersAsEncodedStrings());
            } else {
                linkedList.add(next.encode());
            }
        }
        return linkedList;
    }

    public String getMessageContent() {
        String str = this.messageContent;
        if (str == null && this.messageContentBytes == null) {
            return null;
        }
        if (str == null) {
            this.messageContent = new String(this.messageContentBytes, getCharset());
        }
        return this.messageContent;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public MultipartMimeContent getMultipartMimeContent() {
        if (this.contentLengthHeader.getContentLength() == 0) {
            return null;
        }
        MultipartMimeContentImpl multipartMimeContentImpl = new MultipartMimeContentImpl(getContentTypeHeader());
        try {
            multipartMimeContentImpl.createContentList(new String(getRawContent(), getCharset()));
            return multipartMimeContentImpl;
        } catch (UnsupportedEncodingException e) {
            InternalErrorHandler.handleException(e);
            return null;
        }
    }

    public InetAddress getPeerPacketSourceAddress() {
        return this.peerPacketSourceAddress;
    }

    public int getPeerPacketSourcePort() {
        return this.peerPacketSourcePort;
    }

    @Override // ir.nasim.K44
    public byte[] getRawContent() {
        try {
            if (this.messageContentBytes == null) {
                Object obj = this.messageContentObject;
                if (obj != null) {
                    this.messageContentBytes = obj.toString().getBytes(getCharset());
                } else {
                    String str = this.messageContent;
                    if (str != null) {
                        this.messageContentBytes = str.getBytes(getCharset());
                    }
                }
            }
            return this.messageContentBytes;
        } catch (UnsupportedEncodingException e) {
            InternalErrorHandler.handleException(e);
            return null;
        }
    }

    public RecordRouteList getRecordRouteHeaders() {
        return (RecordRouteList) getSIPHeaderListLowerCase(RECORDROUTE_LOWERCASE);
    }

    public InetAddress getRemoteAddress() {
        return this.remoteAddress;
    }

    public int getRemotePort() {
        return this.remotePort;
    }

    public RouteList getRouteHeaders() {
        return (RouteList) getSIPHeaderListLowerCase(ROUTE_LOWERCASE);
    }

    public SIPHeader getSIPHeaderListLowerCase(String str) {
        return this.headerTable.get(str);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public abstract String getSIPVersion();

    public int getSize() {
        return this.size;
    }

    public InterfaceC18560or7 getTo() {
        return this.toHeader;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC18560or7 getToHeader() {
        return this.toHeader;
    }

    public String getToTag() {
        To to = this.toHeader;
        if (to == null) {
            return null;
        }
        return to.getTag();
    }

    public Via getTopmostVia() {
        if (getViaHeaders() == null) {
            return null;
        }
        return (Via) getViaHeaders().getFirst();
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public InterfaceC18318oS7 getTopmostViaHeader() {
        return getTopmostVia();
    }

    public String getTransactionId() {
        Via topmostVia = getTopmostVia();
        if (topmostVia != null && topmostVia.getBranch() != null && topmostVia.getBranch().toUpperCase().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE_UPPER_CASE)) {
            if (!getCSeq().getMethod().equals("CANCEL")) {
                return topmostVia.getBranch().toLowerCase();
            }
            return (topmostVia.getBranch() + ":" + getCSeq().getMethod()).toLowerCase();
        }
        StringBuilder sb = new StringBuilder();
        From from = (From) getFrom();
        if (from.hasTag()) {
            sb.append(from.getTag());
            sb.append("-");
        }
        sb.append(this.callIdHeader.getCallId());
        sb.append("-");
        sb.append(this.cSeqHeader.getSequenceNumber());
        sb.append("-");
        sb.append(this.cSeqHeader.getMethod());
        if (topmostVia != null) {
            sb.append("-");
            sb.append(topmostVia.getSentBy().encode());
            if (!topmostVia.getSentBy().hasPort()) {
                sb.append("-");
                sb.append(SIPConstants.DEFAULT_PORT);
            }
        }
        if (getCSeq().getMethod().equals("CANCEL")) {
            sb.append("CANCEL");
        }
        return sb.toString().toLowerCase().replace(":", "-").replace(Separators.AT, "-") + Utils.getSignature();
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public ListIterator<String> getUnrecognizedHeaders() {
        return getUnrecognizedHeadersList().listIterator();
    }

    protected LinkedList<String> getUnrecognizedHeadersList() {
        if (this.unrecognizedHeaders == null) {
            this.unrecognizedHeaders = new LinkedList<>();
        }
        return this.unrecognizedHeaders;
    }

    public ViaList getViaHeaders() {
        return (ViaList) getSIPHeaderListLowerCase(VIA_LOWERCASE);
    }

    public boolean hasContent() {
        return (this.messageContent == null && this.messageContentBytes == null) ? false : true;
    }

    public boolean hasFromTag() {
        From from = this.fromHeader;
        return (from == null || from.getTag() == null) ? false : true;
    }

    public boolean hasHeader(String str) {
        return this.headerTable.containsKey(SIPHeaderNamesCache.toLowerCase(str));
    }

    public boolean hasToTag() {
        To to = this.toHeader;
        return (to == null || to.getTag() == null) ? false : true;
    }

    public int hashCode() {
        CallID callID = this.callIdHeader;
        if (callID != null) {
            return callID.getCallId().hashCode();
        }
        throw new RuntimeException("Invalid message! Cannot compute hashcode! call-id header is missing !");
    }

    public boolean isNullRequest() {
        return this.nullRequest;
    }

    @Override // android.gov.nist.core.GenericObject
    public boolean match(Object obj) {
        if (obj == null) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        Iterator<SIPHeader> headers = ((SIPMessage) obj).getHeaders();
        while (headers.hasNext()) {
            SIPHeader next = headers.next();
            List<SIPHeader> headerList = getHeaderList(next.getHeaderName());
            if (headerList != null && headerList.size() != 0) {
                if (next instanceof SIPHeaderList) {
                    ListIterator listIterator = ((SIPHeaderList) next).listIterator();
                    while (listIterator.hasNext()) {
                        SIPHeader sIPHeader = (SIPHeader) listIterator.next();
                        if (!(sIPHeader instanceof ContentLength)) {
                            ListIterator<SIPHeader> listIterator2 = headerList.listIterator();
                            while (listIterator2.hasNext()) {
                                if (listIterator2.next().match(sIPHeader)) {
                                    break;
                                }
                            }
                            return false;
                        }
                    }
                } else {
                    ListIterator<SIPHeader> listIterator3 = headerList.listIterator();
                    while (listIterator3.hasNext()) {
                        if (listIterator3.next().match(next)) {
                            break;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.gov.nist.core.GenericObject
    public void merge(Object obj) throws IllegalAccessException, IllegalArgumentException {
        if (!obj.getClass().equals(getClass())) {
            throw new IllegalArgumentException("Bad class " + obj.getClass());
        }
        for (Object obj2 : ((SIPMessage) obj).headers.toArray()) {
            SIPHeader sIPHeader = (SIPHeader) obj2;
            List<SIPHeader> headerList = getHeaderList(sIPHeader.getHeaderName());
            if (headerList == null) {
                attachHeader(sIPHeader);
            } else {
                ListIterator<SIPHeader> listIterator = headerList.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.next().merge(sIPHeader);
                }
            }
        }
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void removeContent() {
        this.messageContent = null;
        this.messageContentBytes = null;
        this.messageContentObject = null;
        try {
            this.contentLengthHeader.setContentLength(0);
        } catch (InvalidArgumentException unused) {
        }
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void removeFirst(String str) {
        if (str == null) {
            throw new NullPointerException("Null argument Provided!");
        }
        removeHeader(str, true);
    }

    public void removeHeader(String str, boolean z) {
        String lowerCase = SIPHeaderNamesCache.toLowerCase(str);
        SIPHeader sIPHeader = this.headerTable.get(lowerCase);
        if (sIPHeader == null) {
            return;
        }
        if (sIPHeader instanceof SIPHeaderList) {
            SIPHeaderList sIPHeaderList = (SIPHeaderList) sIPHeader;
            if (z) {
                sIPHeaderList.removeFirst();
            } else {
                sIPHeaderList.removeLast();
            }
            if (sIPHeaderList.isEmpty()) {
                Iterator<SIPHeader> it = this.headers.iterator();
                while (it.hasNext()) {
                    if (it.next().getName().equalsIgnoreCase(lowerCase)) {
                        it.remove();
                    }
                }
                this.headerTable.remove(lowerCase);
                return;
            }
            return;
        }
        this.headerTable.remove(lowerCase);
        if (sIPHeader instanceof From) {
            this.fromHeader = null;
        } else if (sIPHeader instanceof To) {
            this.toHeader = null;
        } else if (sIPHeader instanceof CSeq) {
            this.cSeqHeader = null;
        } else if (sIPHeader instanceof CallID) {
            this.callIdHeader = null;
        } else if (sIPHeader instanceof MaxForwards) {
            this.maxForwardsHeader = null;
        } else if (sIPHeader instanceof ContentLength) {
            this.contentLengthHeader = null;
        }
        Iterator<SIPHeader> it2 = this.headers.iterator();
        while (it2.hasNext()) {
            if (it2.next().getName().equalsIgnoreCase(str)) {
                it2.remove();
            }
        }
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void removeLast(String str) {
        if (str == null) {
            throw new NullPointerException("Null argument Provided!");
        }
        removeHeader(str, false);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void setApplicationData(Object obj) {
        this.applicationData = obj;
    }

    public void setCSeq(InterfaceC12560ep0 interfaceC12560ep0) {
        setHeader(interfaceC12560ep0);
    }

    public void setCallId(InterfaceC21662tv0 interfaceC21662tv0) {
        setHeader(interfaceC21662tv0);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void setContent(Object obj, InterfaceC19085pl1 interfaceC19085pl1) {
        if (obj == null) {
            throw new NullPointerException("null content");
        }
        setHeader(interfaceC19085pl1);
        this.messageContent = null;
        this.messageContentBytes = null;
        this.messageContentObject = null;
        if (obj instanceof String) {
            this.messageContent = (String) obj;
        } else if (obj instanceof byte[]) {
            this.messageContentBytes = (byte[]) obj;
        } else {
            this.messageContentObject = obj;
        }
        computeContentLength(obj);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void setContentDisposition(InterfaceC23329wk1 interfaceC23329wk1) {
        setHeader(interfaceC23329wk1);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void setContentEncoding(InterfaceC24509yk1 interfaceC24509yk1) {
        setHeader(interfaceC24509yk1);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void setContentLanguage(InterfaceC7365Rk1 interfaceC7365Rk1) {
        setHeader(interfaceC7365Rk1);
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void setContentLength(InterfaceC7599Sk1 interfaceC7599Sk1) {
        try {
            this.contentLengthHeader.setContentLength(interfaceC7599Sk1.getContentLength());
        } catch (InvalidArgumentException unused) {
        }
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public void setExpires(InterfaceC21427te2 interfaceC21427te2) {
        setHeader(interfaceC21427te2);
    }

    public void setFrom(InterfaceC17560nA2 interfaceC17560nA2) {
        setHeader(interfaceC17560nA2);
    }

    public void setFromTag(String str) {
        try {
            this.fromHeader.setTag(str);
        } catch (ParseException unused) {
        }
    }

    @Override // ir.nasim.K44
    public void setHeader(HU2 hu2) {
        SIPHeader sIPHeader = (SIPHeader) hu2;
        if (sIPHeader == null) {
            throw new IllegalArgumentException("null header!");
        }
        try {
            if ((sIPHeader instanceof SIPHeaderList) && ((SIPHeaderList) sIPHeader).isEmpty()) {
                return;
            }
            removeHeader(sIPHeader.getHeaderName());
            attachHeader(sIPHeader, true, false);
        } catch (SIPDuplicateHeaderException e) {
            InternalErrorHandler.handleException(e);
        }
    }

    public void setHeaders(List<SIPHeader> list) {
        ListIterator<SIPHeader> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            try {
                attachHeader(listIterator.next(), false);
            } catch (SIPDuplicateHeaderException unused) {
            }
        }
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = inetAddress;
    }

    public void setLocalPort(int i) {
        this.localPort = i;
    }

    public void setMaxForwards(VV3 vv3) {
        setHeader(vv3);
    }

    public void setMessageContent(String str, String str2, String str3) {
        if (str3 == null) {
            throw new IllegalArgumentException("messgeContent is null");
        }
        setHeader(new ContentType(str, str2));
        this.messageContent = str3;
        this.messageContentBytes = null;
        this.messageContentObject = null;
        computeContentLength(str3);
    }

    public void setNullRequest() {
        this.nullRequest = true;
    }

    public void setPeerPacketSourceAddress(InetAddress inetAddress) {
        this.peerPacketSourceAddress = inetAddress;
    }

    public void setPeerPacketSourcePort(int i) {
        this.peerPacketSourcePort = i;
    }

    public void setRemoteAddress(InetAddress inetAddress) {
        this.remoteAddress = inetAddress;
    }

    public void setRemotePort(int i) {
        this.remotePort = i;
    }

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public abstract void setSIPVersion(String str);

    public void setSize(int i) {
        this.size = i;
    }

    public void setTo(InterfaceC18560or7 interfaceC18560or7) {
        setHeader(interfaceC18560or7);
    }

    public void setToTag(String str) {
        try {
            this.toHeader.setTag(str);
        } catch (ParseException unused) {
        }
    }

    protected void setUnrecognizedHeadersList(LinkedList<String> linkedList) {
        this.unrecognizedHeaders = linkedList;
    }

    public void setVia(List list) {
        ViaList viaList = new ViaList();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            viaList.add((ViaList) listIterator.next());
        }
        setHeader((SIPHeaderList<Via>) viaList);
    }

    public abstract String toString();

    @Override // android.gov.nist.javax.sip.message.MessageExt
    public ContentType getContentTypeHeader() {
        return (ContentType) getHeaderLowerCase(CONTENT_TYPE_LOWERCASE);
    }

    @Override // ir.nasim.K44
    public ListIterator<SIPHeader> getHeaders(String str) {
        if (str == null) {
            throw new NullPointerException("null headerName");
        }
        SIPHeader sIPHeader = this.headerTable.get(SIPHeaderNamesCache.toLowerCase(str));
        return sIPHeader == null ? new LinkedList().listIterator() : sIPHeader instanceof SIPHeaderList ? ((SIPHeaderList) sIPHeader).listIterator() : new HeaderIterator(this, sIPHeader);
    }

    public void setCallId(String str) {
        if (this.callIdHeader == null) {
            setHeader(new CallID());
        }
        this.callIdHeader.setCallId(str);
    }

    public final String getDialogId(boolean z, String str) {
        From from = (From) getFrom();
        StringBuffer stringBuffer = new StringBuffer(((CallID) getCallId()).getCallId());
        if (!z) {
            if (from.getTag() != null) {
                stringBuffer.append(":");
                stringBuffer.append(from.getTag());
            }
            if (str != null) {
                stringBuffer.append(":");
                stringBuffer.append(str);
            }
        } else {
            if (str != null) {
                stringBuffer.append(":");
                stringBuffer.append(str);
            }
            if (from.getTag() != null) {
                stringBuffer.append(":");
                stringBuffer.append(from.getTag());
            }
        }
        return stringBuffer.toString().toLowerCase();
    }

    public void attachHeader(SIPHeader sIPHeader, boolean z) {
        attachHeader(sIPHeader, z, false);
    }

    public void attachHeader(SIPHeader sIPHeader, boolean z, boolean z2) {
        SIPHeader sIPHeader2;
        SIPHeaderList sIPHeaderList;
        if (sIPHeader != null) {
            if (!ListMap.hasList(sIPHeader) || SIPHeaderList.class.isAssignableFrom(sIPHeader.getClass())) {
                sIPHeader2 = sIPHeader;
            } else {
                SIPHeaderList<SIPHeader> list = ListMap.getList(sIPHeader);
                list.add((SIPHeaderList<SIPHeader>) sIPHeader);
                sIPHeader2 = list;
            }
            String lowerCase = SIPHeaderNamesCache.toLowerCase(sIPHeader2.getName());
            if (z) {
                this.headerTable.remove(lowerCase);
            } else if (this.headerTable.containsKey(lowerCase) && !(sIPHeader2 instanceof SIPHeaderList)) {
                if (sIPHeader2 instanceof ContentLength) {
                    try {
                        this.contentLengthHeader.setContentLength(((ContentLength) sIPHeader2).getContentLength());
                        return;
                    } catch (InvalidArgumentException unused) {
                        return;
                    }
                }
                return;
            }
            SIPHeader sIPHeader3 = (SIPHeader) getHeader(sIPHeader.getName());
            if (sIPHeader3 != null) {
                Iterator<SIPHeader> it = this.headers.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(sIPHeader3)) {
                        it.remove();
                    }
                }
            }
            if (!this.headerTable.containsKey(lowerCase)) {
                this.headerTable.put(lowerCase, sIPHeader2);
                this.headers.add(sIPHeader2);
            } else if ((sIPHeader2 instanceof SIPHeaderList) && (sIPHeaderList = (SIPHeaderList) this.headerTable.get(lowerCase)) != null) {
                sIPHeaderList.concatenate((SIPHeaderList) sIPHeader2, z2);
            } else {
                this.headerTable.put(lowerCase, sIPHeader2);
            }
            if (sIPHeader2 instanceof From) {
                this.fromHeader = (From) sIPHeader2;
                return;
            }
            if (sIPHeader2 instanceof ContentLength) {
                this.contentLengthHeader = (ContentLength) sIPHeader2;
                return;
            }
            if (sIPHeader2 instanceof To) {
                this.toHeader = (To) sIPHeader2;
                return;
            }
            if (sIPHeader2 instanceof CSeq) {
                this.cSeqHeader = (CSeq) sIPHeader2;
                return;
            } else if (sIPHeader2 instanceof CallID) {
                this.callIdHeader = (CallID) sIPHeader2;
                return;
            } else {
                if (sIPHeader2 instanceof MaxForwards) {
                    this.maxForwardsHeader = (MaxForwards) sIPHeader2;
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("null header");
    }

    public void addHeader(String str) {
        try {
            attachHeader(ParserFactory.createParser(str + Separators.RETURN).parse(), false);
        } catch (ParseException unused) {
            getUnrecognizedHeadersList().add(str);
        }
    }

    public void setMessageContent(String str, String str2, byte[] bArr) {
        setHeader(new ContentType(str, str2));
        setMessageContent(bArr);
        computeContentLength(bArr);
    }

    public void setHeader(SIPHeaderList<Via> sIPHeaderList) {
        setHeader((HU2) sIPHeaderList);
    }

    public void setMessageContent(byte[] bArr, boolean z, boolean z2, int i) throws ParseException {
        computeContentLength(bArr);
        if (!z2 && ((!z && this.contentLengthHeader.getContentLength() != i) || this.contentLengthHeader.getContentLength() < i)) {
            throw new ParseException("Invalid content length " + this.contentLengthHeader.getContentLength() + " / " + i, 0);
        }
        this.messageContent = null;
        this.messageContentBytes = bArr;
        this.messageContentObject = null;
    }

    public void setMessageContent(byte[] bArr) {
        computeContentLength(bArr);
        this.messageContentBytes = bArr;
        this.messageContent = null;
        this.messageContentObject = null;
    }

    public void setMessageContent(byte[] bArr, boolean z, int i) throws ParseException {
        computeContentLength(bArr);
        if (!z && this.contentLengthHeader.getContentLength() < i) {
            throw new ParseException("Invalid content length " + this.contentLengthHeader.getContentLength() + " / " + i, 0);
        }
        this.messageContentBytes = bArr;
        this.messageContent = null;
        this.messageContentObject = null;
    }

    @Override // ir.nasim.K44
    public void removeHeader(String str) {
        if (str != null) {
            String lowerCase = SIPHeaderNamesCache.toLowerCase(str);
            SIPHeader sIPHeaderRemove = this.headerTable.remove(lowerCase);
            if (sIPHeaderRemove == null) {
                return;
            }
            if (sIPHeaderRemove instanceof From) {
                this.fromHeader = null;
            } else if (sIPHeaderRemove instanceof To) {
                this.toHeader = null;
            } else if (sIPHeaderRemove instanceof CSeq) {
                this.cSeqHeader = null;
            } else if (sIPHeaderRemove instanceof CallID) {
                this.callIdHeader = null;
            } else if (sIPHeaderRemove instanceof MaxForwards) {
                this.maxForwardsHeader = null;
            } else if (sIPHeaderRemove instanceof ContentLength) {
                this.contentLengthHeader = null;
            }
            Iterator<SIPHeader> it = this.headers.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equalsIgnoreCase(lowerCase)) {
                    it.remove();
                }
            }
            return;
        }
        throw new NullPointerException("null arg");
    }
}
