package android.gov.nist.javax.sip.message;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.javax.sip.header.StatusLine;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import ir.nasim.InterfaceC10981cX5;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class SIPResponse extends SIPMessage implements InterfaceC10981cX5, ResponseExt {
    private boolean isRetransmission = true;
    protected StatusLine statusLine;

    public static String getReasonPhrase(int i) {
        if (i == 420) {
            return "Bad extension";
        }
        if (i == 421) {
            return "Etension Required";
        }
        if (i == 603) {
            return "Decline";
        }
        if (i == 604) {
            return "Does not exist anywhere";
        }
        switch (i) {
            case 100:
                return "Trying";
            case 200:
                return "OK";
            case 202:
                return "Accepted";
            case 305:
                return "Use proxy";
            case 380:
                return "Alternative service";
            case 410:
                return "Gone";
            case 423:
                return "Interval too brief";
            case 491:
                return "Request Pending";
            case 493:
                return "Undecipherable";
            case 513:
                return "Message Too Large";
            case SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER /* 600 */:
                return "Busy everywhere";
            case 606:
                return "Session Not acceptable";
            default:
                switch (i) {
                    case SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER /* 180 */:
                        return "Ringing";
                    case SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER /* 181 */:
                        return "Call is being forwarded";
                    case 182:
                        return "Queued";
                    case 183:
                        return "Session progress";
                    default:
                        switch (i) {
                            case 300:
                                return "Multiple choices";
                            case 301:
                                return "Moved permanently";
                            case 302:
                                return "Moved Temporarily";
                            default:
                                switch (i) {
                                    case 400:
                                        return "Bad request";
                                    case 401:
                                        return "Unauthorized";
                                    case 402:
                                        return "Payment required";
                                    case 403:
                                        return "Forbidden";
                                    case 404:
                                        return "Not found";
                                    case 405:
                                        return "Method not allowed";
                                    case 406:
                                        return "Not acceptable";
                                    case 407:
                                        return "Proxy Authentication required";
                                    case 408:
                                        return "Request timeout";
                                    default:
                                        switch (i) {
                                            case 412:
                                                return "Conditional request failed";
                                            case 413:
                                                return "Request entity too large";
                                            case 414:
                                                return "Request-URI too large";
                                            case 415:
                                                return "Unsupported media type";
                                            case 416:
                                                return "Unsupported URI Scheme";
                                            default:
                                                switch (i) {
                                                    case 480:
                                                        return "Temporarily Unavailable";
                                                    case 481:
                                                        return "Call leg/Transaction does not exist";
                                                    case 482:
                                                        return "Loop detected";
                                                    case 483:
                                                        return "Too many hops";
                                                    case 484:
                                                        return "Address incomplete";
                                                    case 485:
                                                        return "Ambiguous";
                                                    case 486:
                                                        return "Busy here";
                                                    case 487:
                                                        return "Request Terminated";
                                                    case 488:
                                                        return "Not Acceptable here";
                                                    case 489:
                                                        return "Bad Event";
                                                    default:
                                                        switch (i) {
                                                            case SIPTransactionStack.BASE_TIMER_INTERVAL /* 500 */:
                                                                return "Server Internal Error";
                                                            case 501:
                                                                return "Not implemented";
                                                            case 502:
                                                                return "Bad gateway";
                                                            case 503:
                                                                return "Service unavailable";
                                                            case 504:
                                                                return "Gateway timeout";
                                                            case 505:
                                                                return "SIP version not supported";
                                                            default:
                                                                return "Unknown Status";
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static boolean isFinalResponse(int i) {
        return i >= 200 && i < 700;
    }

    public void checkHeaders() throws ParseException {
        if (getCSeq() == null) {
            throw new ParseException("CSeq Is missing ", 0);
        }
        if (getTo() == null) {
            throw new ParseException("To Is missing ", 0);
        }
        if (getFrom() == null) {
            throw new ParseException("From Is missing ", 0);
        }
        if (getViaHeaders() == null) {
            throw new ParseException("Via Is missing ", 0);
        }
        if (getCallId() == null) {
            throw new ParseException("Call-ID Is missing ", 0);
        }
        if (getStatusCode() <= 699) {
            return;
        }
        throw new ParseException("Unknown error code!" + getStatusCode(), 0);
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public void cleanUp() {
        super.cleanUp();
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.core.GenericObject
    public Object clone() {
        SIPResponse sIPResponse = (SIPResponse) super.clone();
        StatusLine statusLine = this.statusLine;
        if (statusLine != null) {
            sIPResponse.statusLine = (StatusLine) statusLine.clone();
        }
        return sIPResponse;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageObject, android.gov.nist.core.GenericObject
    public String debugDump() {
        String strDebugDump = super.debugDump();
        this.stringRepresentation = "";
        sprint(SIPResponse.class.getCanonicalName());
        sprint("{");
        StatusLine statusLine = this.statusLine;
        if (statusLine != null) {
            sprint(statusLine.debugDump());
        }
        sprint(strDebugDump);
        sprint("}");
        return this.stringRepresentation;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageObject, android.gov.nist.core.GenericObject
    public String encode() {
        if (this.statusLine == null) {
            return super.encode();
        }
        return this.statusLine.encode() + super.encode();
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public byte[] encodeAsBytes(String str) throws UnsupportedEncodingException {
        byte[] bytes;
        StatusLine statusLine = this.statusLine;
        if (statusLine != null) {
            try {
                bytes = statusLine.encode().getBytes("UTF-8");
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
        StatusLine statusLine = this.statusLine;
        if (statusLine == null) {
            return super.encodeSIPHeaders(sb);
        }
        statusLine.encode(sb);
        super.encodeSIPHeaders(sb);
        return sb;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && this.statusLine.equals(((SIPResponse) obj).statusLine) && super.equals(obj);
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageExt
    public String getFirstLine() {
        StatusLine statusLine = this.statusLine;
        if (statusLine == null) {
            return null;
        }
        return statusLine.encode();
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public LinkedList getMessageAsEncodedStrings() {
        LinkedList<String> messageAsEncodedStrings = super.getMessageAsEncodedStrings();
        StatusLine statusLine = this.statusLine;
        if (statusLine != null) {
            messageAsEncodedStrings.addFirst(statusLine.encode());
        }
        return messageAsEncodedStrings;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageExt
    public String getSIPVersion() {
        return this.statusLine.getSipVersion();
    }

    @Override // ir.nasim.InterfaceC10981cX5
    public int getStatusCode() {
        return this.statusLine.getStatusCode();
    }

    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    public boolean isRetransmission() {
        return this.isRetransmission;
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
        Object obj2 = ((SIPResponse) obj).statusLine;
        StatusLine statusLine = this.statusLine;
        if (statusLine != null || obj2 == null) {
            return statusLine == obj2 ? super.match(obj) : statusLine.match(obj2) && super.match(obj);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC10981cX5
    public void setReasonPhrase(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Bad reason phrase");
        }
        if (this.statusLine == null) {
            this.statusLine = new StatusLine();
        }
        this.statusLine.setReasonPhrase(str);
    }

    public void setRetransmission(boolean z) {
        this.isRetransmission = z;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage, android.gov.nist.javax.sip.message.MessageExt
    public void setSIPVersion(String str) {
        this.statusLine.setSipVersion(str);
    }

    @Override // android.gov.nist.javax.sip.message.ResponseExt
    public void setStatusCode(int i) throws ParseException {
        if (i < 100 || i > 699) {
            throw new ParseException("bad status code", 0);
        }
        if (this.statusLine == null) {
            this.statusLine = new StatusLine();
        }
        this.statusLine.setStatusCode(i);
    }

    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
    }

    @Override // android.gov.nist.javax.sip.message.SIPMessage
    public String toString() {
        if (this.statusLine == null) {
            return "";
        }
        return this.statusLine.encode() + super.encode();
    }

    public boolean isFinalResponse() {
        return isFinalResponse(this.statusLine.getStatusCode());
    }

    @Override // android.gov.nist.javax.sip.message.ResponseExt
    public String getReasonPhrase() {
        StatusLine statusLine = this.statusLine;
        if (statusLine != null && statusLine.getReasonPhrase() != null) {
            return this.statusLine.getReasonPhrase();
        }
        return "";
    }
}
