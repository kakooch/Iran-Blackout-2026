package android.gov.nist.javax.sip.message;

import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.address.GenericURI;
import android.gov.nist.javax.sip.address.SipUri;
import android.gov.nist.javax.sip.header.CSeq;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.RecordRouteList;
import android.gov.nist.javax.sip.header.RequestLine;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderList;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.To;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.header.ViaList;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.javax.sip.SipException;
import ir.nasim.HU2;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC5044Hq6;
import ir.nasim.UP5;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class SIPRequest extends SIPMessage implements UP5, RequestExt {
    private static final String DEFAULT_TRANSPORT = "udp";
    private static final String DEFAULT_USER = "ip";
    protected static final Set<String> headersToIncludeInResponse;
    private static final Map<String, String> nameTable;
    private static final long serialVersionUID = 3360720013577322927L;
    private static final Set<String> targetRefreshMethods;
    private transient Object inviteTransaction;
    private transient Object messageChannel;
    protected RequestLine requestLine;
    private transient Object transactionPointer;

    static {
        HashSet hashSet = new HashSet();
        targetRefreshMethods = hashSet;
        nameTable = new ConcurrentHashMap(15);
        HashSet hashSet2 = new HashSet(0);
        headersToIncludeInResponse = hashSet2;
        hashSet.add(TokenNames.INVITE);
        hashSet.add("UPDATE");
        hashSet.add(TokenNames.SUBSCRIBE);
        hashSet.add(TokenNames.NOTIFY);
        hashSet.add("REFER");
        putName(TokenNames.INVITE);
        putName(TokenNames.BYE);
        putName("CANCEL");
        putName(TokenNames.ACK);
        putName("PRACK");
        putName("INFO");
        putName(TokenNames.MESSAGE);
        putName(TokenNames.NOTIFY);
        putName(TokenNames.OPTIONS);
        putName("PRACK");
        putName(TokenNames.PUBLISH);
        putName("REFER");
        putName(TokenNames.REGISTER);
        putName(TokenNames.SUBSCRIBE);
        putName("UPDATE");
        hashSet2.add(SIPHeaderNames.FROM.toLowerCase());
        hashSet2.add(SIPHeaderNames.TO.toLowerCase());
        hashSet2.add(SIPHeaderNames.VIA.toLowerCase());
        hashSet2.add(SIPHeaderNames.RECORD_ROUTE.toLowerCase());
        hashSet2.add(SIPHeaderNames.CALL_ID.toLowerCase());
        hashSet2.add(SIPHeaderNames.CSEQ.toLowerCase());
        hashSet2.add(SIPHeaderNames.TIMESTAMP.toLowerCase());
    }

    public static String getCannonicalName(String str) {
        Map<String, String> map = nameTable;
        return map.containsKey(str) ? map.get(str) : str;
    }

    public static boolean isDialogCreating(String str) {
        return SIPTransactionStack.isDialogCreated(str);
    }

    public static boolean isTargetRefresh(String str) {
        return targetRefreshMethods.contains(str);
    }

    private static void putName(String str) {
        nameTable.put(str, str);
    }

    public void checkHeaders() {
        if (getCSeq() == null) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.CSEQ, 0);
        }
        if (getTo() == null) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.TO, 0);
        }
        CallID callID = this.callIdHeader;
        if (callID == null || callID.getCallId() == null || this.callIdHeader.getCallId().equals("")) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.CALL_ID, 0);
        }
        if (getFrom() == null) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.FROM, 0);
        }
        if (getViaHeaders() == null) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.VIA, 0);
        }
        if (getMaxForwards() == null) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.MAX_FORWARDS, 0);
        }
        if (getTopmostVia() == null) {
            throw new ParseException("No via header in request! ", 0);
        }
        if (getMethod().equals(TokenNames.NOTIFY)) {
            if (getHeader(SIPHeaderNames.SUBSCRIPTION_STATE) == null) {
                throw new ParseException("Missing a required header : " + SIPHeaderNames.SUBSCRIPTION_STATE, 0);
            }
            if (getFromHeader().getTag() != null && getToHeader().getTag() != null && getHeader(SIPHeaderNames.EVENT) == null) {
                throw new ParseException("Missing a required header : " + SIPHeaderNames.EVENT, 0);
            }
        } else if (getMethod().equals(TokenNames.PUBLISH) && getHeader(SIPHeaderNames.EVENT) == null) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.EVENT, 0);
        }
        String method = this.requestLine.getMethod();
        if (SIPTransactionStack.isDialogCreated(method) && getContactHeader() == null && getToTag() == null) {
            throw new ParseException("Missing a required header : " + SIPHeaderNames.CONTACT, 0);
        }
        if (this.requestLine != null && method != null && getCSeq().getMethod() != null && method.compareTo(getCSeq().getMethod()) != 0) {
            throw new ParseException("CSEQ method mismatch with  Request-Line ", 0);
        }
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public void cleanUp() {
        super.cleanUp();
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.core.GenericObject
    public Object clone() {
        SIPRequest sIPRequest = (SIPRequest) super.clone();
        sIPRequest.transactionPointer = null;
        RequestLine requestLine = this.requestLine;
        if (requestLine != null) {
            sIPRequest.requestLine = (RequestLine) requestLine.clone();
        }
        return sIPRequest;
    }

    public SIPRequest createAckRequest(To to) {
        SIPRequest sIPRequest = (SIPRequest) clone();
        sIPRequest.setMethod(TokenNames.ACK);
        sIPRequest.removeHeader(SIPHeaderNames.ROUTE);
        sIPRequest.removeHeader(SIPHeaderNames.PROXY_AUTHORIZATION);
        sIPRequest.removeContent();
        sIPRequest.removeHeader(SIPHeaderNames.CONTENT_TYPE);
        try {
            sIPRequest.getCSeq().setMethod(TokenNames.ACK);
        } catch (ParseException unused) {
        }
        if (to != null) {
            sIPRequest.setTo(to);
        }
        sIPRequest.removeHeader(SIPHeaderNames.CONTACT);
        sIPRequest.removeHeader(SIPHeaderNames.EXPIRES);
        ViaList viaHeaders = sIPRequest.getViaHeaders();
        if (viaHeaders != null && viaHeaders.size() > 1) {
            for (int i = 2; i < viaHeaders.size(); i++) {
                viaHeaders.remove(i);
            }
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            sIPRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        }
        return sIPRequest;
    }

    public SIPRequest createCancelRequest() throws SipException {
        if (!getMethod().equals(TokenNames.INVITE)) {
            throw new SipException("Attempt to create CANCEL for " + getMethod());
        }
        SIPRequest sIPRequest = new SIPRequest();
        sIPRequest.setRequestLine((RequestLine) this.requestLine.clone());
        sIPRequest.setMethod("CANCEL");
        sIPRequest.setHeader((HU2) this.callIdHeader.clone());
        sIPRequest.setHeader((HU2) this.toHeader.clone());
        sIPRequest.setHeader((HU2) this.cSeqHeader.clone());
        try {
            sIPRequest.getCSeq().setMethod("CANCEL");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sIPRequest.setHeader((HU2) this.fromHeader.clone());
        sIPRequest.addFirst((HU2) getTopmostVia().clone());
        sIPRequest.setHeader((HU2) this.maxForwardsHeader.clone());
        if (getRouteHeaders() != null) {
            sIPRequest.setHeader((HU2) getRouteHeaders().clone());
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            sIPRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        }
        return sIPRequest;
    }

    public final SIPRequest createErrorAck(To to) throws SipException {
        SIPRequest sIPRequest = new SIPRequest();
        sIPRequest.setRequestLine((RequestLine) this.requestLine.clone());
        sIPRequest.setMethod(TokenNames.ACK);
        sIPRequest.setHeader((HU2) this.callIdHeader.clone());
        sIPRequest.setHeader((HU2) this.maxForwardsHeader.clone());
        sIPRequest.setHeader((HU2) this.fromHeader.clone());
        sIPRequest.setHeader((HU2) to.clone());
        sIPRequest.addFirst((HU2) getTopmostVia().clone());
        sIPRequest.setHeader((HU2) this.cSeqHeader.clone());
        sIPRequest.getCSeq().setMethod(TokenNames.ACK);
        if (getRouteHeaders() != null) {
            sIPRequest.setHeader((SIPHeaderList<Via>) getRouteHeaders().clone());
        }
        if (MessageFactoryImpl.getDefaultUserAgentHeader() != null) {
            sIPRequest.setHeader(MessageFactoryImpl.getDefaultUserAgentHeader());
        }
        return sIPRequest;
    }

    public SIPResponse createResponse(int i) {
        return createResponse(i, SIPResponse.getReasonPhrase(i));
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageObject, android.gov.nist.core.GenericObject
    public String debugDump() {
        String strDebugDump = super.debugDump();
        this.stringRepresentation = "";
        sprint(SIPRequest.class.getName());
        sprint("{");
        RequestLine requestLine = this.requestLine;
        if (requestLine != null) {
            sprint(requestLine.debugDump());
        }
        sprint(strDebugDump);
        sprint("}");
        return this.stringRepresentation;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageObject, android.gov.nist.core.GenericObject
    public String encode() {
        if (this.requestLine == null) {
            return isNullRequest() ? "\r\n\r\n" : super.encode();
        }
        setRequestLineDefaults();
        return this.requestLine.encode() + super.encode();
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public byte[] encodeAsBytes(String str) throws UnsupportedEncodingException {
        byte[] bytes;
        if (isNullRequest()) {
            return "\r\n\r\n".getBytes();
        }
        RequestLine requestLine = this.requestLine;
        if (requestLine == null) {
            return new byte[0];
        }
        if (requestLine != null) {
            try {
                bytes = requestLine.encode().getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                InternalErrorHandler.handleException(e);
            }
        } else {
            bytes = null;
        }
        byte[] bArrEncodeAsBytes = super.encodeAsBytes(str);
        byte[] bArr = new byte[bytes.length + bArrEncodeAsBytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bArrEncodeAsBytes, 0, bArr, bytes.length, bArrEncodeAsBytes.length);
        return bArr;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public StringBuilder encodeMessage(StringBuilder sb) {
        if (this.requestLine != null) {
            setRequestLineDefaults();
            this.requestLine.encode(sb);
            encodeSIPHeaders(sb);
            return sb;
        }
        if (!isNullRequest()) {
            return encodeSIPHeaders(sb);
        }
        sb.append("\r\n\r\n");
        return sb;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && this.requestLine.equals(((SIPRequest) obj).requestLine) && super.equals(obj);
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageExt
    public String getFirstLine() {
        RequestLine requestLine = this.requestLine;
        if (requestLine == null) {
            return null;
        }
        return requestLine.encode();
    }

    public Object getInviteTransaction() {
        return this.inviteTransaction;
    }

    public String getMergeId() {
        String fromTag = getFromTag();
        String string = this.cSeqHeader.toString();
        String callId = this.callIdHeader.getCallId();
        String string2 = getRequestURI().toString();
        if (fromTag == null) {
            return null;
        }
        return string2 + ":" + fromTag + ":" + string + ":" + callId;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList<String> messageAsEncodedStrings = super.getMessageAsEncodedStrings();
        if (this.requestLine != null) {
            setRequestLineDefaults();
            messageAsEncodedStrings.addFirst(this.requestLine.encode());
        }
        return messageAsEncodedStrings;
    }

    public Object getMessageChannel() {
        return this.messageChannel;
    }

    @Override // ir.nasim.UP5
    public String getMethod() {
        RequestLine requestLine = this.requestLine;
        if (requestLine == null) {
            return null;
        }
        return requestLine.getMethod();
    }

    public RequestLine getRequestLine() {
        return this.requestLine;
    }

    @Override // ir.nasim.UP5
    public InterfaceC21815uA7 getRequestURI() {
        RequestLine requestLine = this.requestLine;
        if (requestLine == null) {
            return null;
        }
        return requestLine.getUri();
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageExt
    public String getSIPVersion() {
        return this.requestLine.getSipVersion();
    }

    public Object getTransaction() {
        return this.transactionPointer;
    }

    public String getViaHost() {
        return ((Via) getViaHeaders().getFirst()).getHost();
    }

    public int getViaPort() {
        Via via = (Via) getViaHeaders().getFirst();
        return via.hasPort() ? via.getPort() : SIPConstants.DEFAULT_PORT;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.core.GenericObject
    public boolean match(Object obj) {
        if (obj == null) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Object obj2 = ((SIPRequest) obj).requestLine;
        RequestLine requestLine = this.requestLine;
        if (requestLine != null || obj2 == null) {
            return requestLine == obj2 ? super.match(obj) : requestLine.match(obj2) && super.match(obj);
        }
        return false;
    }

    protected final boolean mustCopyRR(int i) {
        return i > 100 && i < 300 && isDialogCreating(getMethod()) && getToTag() == null;
    }

    protected void setDefaults() {
        String method;
        GenericURI uri;
        RequestLine requestLine = this.requestLine;
        if (requestLine == null || (method = requestLine.getMethod()) == null || (uri = this.requestLine.getUri()) == null) {
            return;
        }
        if ((method.compareTo(TokenNames.REGISTER) == 0 || method.compareTo(TokenNames.INVITE) == 0) && (uri instanceof SipUri)) {
            SipUri sipUri = (SipUri) uri;
            sipUri.setUserParam(DEFAULT_USER);
            try {
                sipUri.setTransportParam("udp");
            } catch (ParseException unused) {
            }
        }
    }

    public void setInviteTransaction(Object obj) {
        this.inviteTransaction = obj;
    }

    public void setMessageChannel(Object obj) {
        this.messageChannel = obj;
    }

    @Override // android.gov.nist.javax.sip.message.RequestExt
    public void setMethod(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null method");
        }
        if (this.requestLine == null) {
            this.requestLine = new RequestLine();
        }
        String cannonicalName = getCannonicalName(str);
        this.requestLine.setMethod(cannonicalName);
        CSeq cSeq = this.cSeqHeader;
        if (cSeq != null) {
            try {
                cSeq.setMethod(cannonicalName);
            } catch (ParseException unused) {
            }
        }
    }

    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
    }

    protected void setRequestLineDefaults() {
        CSeq cSeq;
        if (this.requestLine.getMethod() != null || (cSeq = (CSeq) getCSeq()) == null) {
            return;
        }
        this.requestLine.setMethod(getCannonicalName(cSeq.getMethod()));
    }

    @Override // android.gov.nist.javax.sip.message.RequestExt
    public void setRequestURI(InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 == null) {
            throw new NullPointerException("Null request URI");
        }
        if (this.requestLine == null) {
            this.requestLine = new RequestLine();
        }
        this.requestLine.setUri((GenericURI) interfaceC21815uA7);
        this.nullRequest = false;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageExt
    public void setSIPVersion(String str) throws ParseException {
        if (str == null || !str.equalsIgnoreCase(SIPConstants.SIP_VERSION_STRING)) {
            throw new ParseException("sipVersion", 0);
        }
        this.requestLine.setSipVersion(str);
    }

    public void setTransaction(Object obj) {
        this.transactionPointer = obj;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public String toString() {
        return encode();
    }

    public SIPResponse createResponse(int i, String str) {
        boolean z;
        SIPResponse sIPResponse = new SIPResponse();
        try {
            sIPResponse.setStatusCode(i);
            if (str != null) {
                sIPResponse.setReasonPhrase(str);
            } else {
                sIPResponse.setReasonPhrase(SIPResponse.getReasonPhrase(i));
            }
            Iterator<String> it = headersToIncludeInResponse.iterator();
            while (it.hasNext()) {
                SIPHeader sIPHeader = this.headerTable.get(it.next());
                if (sIPHeader != null && (!((z = sIPHeader instanceof RecordRouteList)) || (z && mustCopyRR(i)))) {
                    try {
                        sIPResponse.attachHeader((SIPHeader) sIPHeader.clone(), false);
                    } catch (SIPDuplicateHeaderException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (MessageFactoryImpl.getDefaultServerHeader() != null) {
                sIPResponse.setHeader(MessageFactoryImpl.getDefaultServerHeader());
            }
            InterfaceC5044Hq6 defaultServerHeader = MessageFactoryImpl.getDefaultServerHeader();
            if (defaultServerHeader != null) {
                sIPResponse.setHeader(defaultServerHeader);
            }
            return sIPResponse;
        } catch (ParseException unused) {
            throw new IllegalArgumentException("Bad code " + i);
        }
    }
}
