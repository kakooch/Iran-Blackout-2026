package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Host;
import android.gov.nist.core.HostNameParser;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.address.GenericURI;
import android.gov.nist.javax.sip.address.SipUri;
import android.gov.nist.javax.sip.address.TelephoneNumber;
import android.gov.nist.javax.sip.header.ExtensionHeaderImpl;
import android.gov.nist.javax.sip.header.NameMap;
import android.gov.nist.javax.sip.header.RequestLine;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.StatusLine;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

/* loaded from: classes.dex */
public class StringMsgParser implements MessageParser {
    protected static boolean computeContentLengthFromMessage = false;
    private static StackLogger logger = CommonLogger.getLogger(StringMsgParser.class);

    public static void main(String[] strArr) {
        String[] strArr2 = {"SIP/2.0 200 OK\r\nTo: \"The Little Blister\" <sip:LittleGuy@there.com>;tag=469bc066\r\nFrom: \"The Master Blaster\" <sip:BigGuy@here.com>;tag=11\r\nVia: SIP/2.0/UDP 139.10.134.246:5060;branch=z9hG4bK8b0a86f6_1030c7d18e0_17;received=139.10.134.246\r\nCall-ID: 1030c7d18ae_a97b0b_b@8b0a86f6\r\nCSeq: 1 SUBSCRIBE\r\nContact: <sip:172.16.11.162:5070>\r\nContent-Length: 0\r\n\r\n", "SIP/2.0 180 Ringing\r\nVia: SIP/2.0/UDP 172.18.1.29:5060;branch=z9hG4bK43fc10fb4446d55fc5c8f969607991f4\r\nTo: \"0440\" <sip:0440@212.209.220.131>;tag=2600\r\nFrom: \"Andreas\" <sip:andreas@e-horizon.se>;tag=8524\r\nCall-ID: f51a1851c5f570606140f14c8eb64fd3@172.18.1.29\r\nCSeq: 1 INVITE\r\nMax-Forwards: 70\r\nRecord-Route: <sip:212.209.220.131:5060>\r\nContent-Length: 0\r\n\r\n", "REGISTER sip:nist.gov SIP/2.0\r\nVia: SIP/2.0/UDP 129.6.55.182:14826\r\nMax-Forwards: 70\r\nFrom: <sip:mranga@nist.gov>;tag=6fcd5c7ace8b4a45acf0f0cd539b168b;epid=0d4c418ddf\r\nTo: <sip:mranga@nist.gov>\r\nCall-ID: c5679907eb954a8da9f9dceb282d7230@129.6.55.182\r\nCSeq: 1 REGISTER\r\nContact: <sip:129.6.55.182:14826>;methods=\"INVITE, MESSAGE, INFO, SUBSCRIBE, OPTIONS, BYE, CANCEL, NOTIFY, ACK, REFER\"\r\nUser-Agent: RTC/(Microsoft RTC)\r\nEvent:  registration\r\nAllow-Events: presence\r\nContent-Length: 0\r\n\r\nINVITE sip:littleguy@there.com:5060 SIP/2.0\r\nVia: SIP/2.0/UDP 65.243.118.100:5050\r\nFrom: M. Ranganathan  <sip:M.Ranganathan@sipbakeoff.com>;tag=1234\r\nTo: \"littleguy@there.com\" <sip:littleguy@there.com:5060> \r\nCall-ID: Q2AboBsaGn9!?x6@sipbakeoff.com \r\nCSeq: 1 INVITE \r\nContent-Length: 247\r\n\r\nv=0\r\no=4855 13760799956958020 13760799956958020 IN IP4  129.6.55.78\r\ns=mysession session\r\np=+46 8 52018010\r\nc=IN IP4  129.6.55.78\r\nt=0 0\r\nm=audio 6022 RTP/AVP 0 4 18\r\na=rtpmap:0 PCMU/8000\r\na=rtpmap:4 G723/8000\r\na=rtpmap:18 G729A/8000\r\na=ptime:20\r\n"};
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable(strArr2) { // from class: android.gov.nist.javax.sip.parser.StringMsgParser.1ParserThread
                String[] messages;

                {
                    this.messages = strArr2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (int i2 = 0; i2 < this.messages.length; i2++) {
                        try {
                            SIPMessage sIPMessage = new StringMsgParser().parseSIPMessage(this.messages[i2].getBytes(), true, false, null);
                            System.out.println(" i = " + i2 + " branchId = " + sIPMessage.getTopmostVia().getBranch());
                        } catch (ParseException unused) {
                        }
                    }
                }
            }).start();
        }
    }

    public static SIPHeader parseSIPHeader(String str) throws ParseException {
        int length = str.length() - 1;
        int i = 0;
        while (str.charAt(i) <= ' ') {
            try {
                i++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParseException("Empty header.", 0);
            }
        }
        while (str.charAt(length) <= ' ') {
            length--;
        }
        StringBuilder sb = new StringBuilder(length + 1);
        boolean z = false;
        int i2 = i;
        while (i <= length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\r' || cCharAt == '\n') {
                if (!z) {
                    sb.append(str.substring(i2, i));
                    z = true;
                }
            } else if (z) {
                if (cCharAt == ' ' || cCharAt == '\t') {
                    sb.append(' ');
                    i2 = i + 1;
                    z = false;
                } else {
                    z = false;
                    i2 = i;
                }
            }
            i++;
        }
        sb.append(str.substring(i2, i));
        sb.append('\n');
        HeaderParser headerParserCreateParser = ParserFactory.createParser(sb.toString());
        if (headerParserCreateParser != null) {
            return headerParserCreateParser.parse();
        }
        throw new ParseException("could not create parser", 0);
    }

    public static void setComputeContentLengthFromMessage(boolean z) {
        computeContentLengthFromMessage = z;
    }

    protected static String trimEndOfLine(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length() - 1;
        while (length >= 0 && str.charAt(length) <= ' ') {
            length--;
        }
        return length == str.length() + (-1) ? str : length == -1 ? "" : str.substring(0, length + 1);
    }

    public AddressImpl parseAddress(String str) {
        return new AddressParser(str).address(true);
    }

    public Host parseHost(String str) {
        return new HostNameParser(new Lexer("charLexer", str)).host();
    }

    @Override // android.gov.nist.javax.sip.parser.MessageParser
    public SIPMessage parseSIPMessage(byte[] bArr, boolean z, boolean z2, ParseExceptionListener parseExceptionListener) {
        int i;
        int i2;
        String str = null;
        if (bArr != null && bArr.length != 0) {
            int i3 = 0;
            while (bArr[i3] < 32) {
                try {
                    i3++;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("handled only control char so returning null");
                    }
                }
            }
            int i4 = i3;
            boolean z3 = true;
            SIPMessage sIPMessageProcessFirstLine = null;
            while (true) {
                i = i4;
                while (true) {
                    try {
                        byte b = bArr[i];
                        if (b == 13 || b == 10) {
                            break;
                        }
                        i++;
                    } catch (ArrayIndexOutOfBoundsException unused2) {
                    }
                }
                try {
                    String strTrimEndOfLine = trimEndOfLine(new String(bArr, i4, i - i4, "UTF-8"));
                    if (strTrimEndOfLine.length() == 0) {
                        if (str != null && sIPMessageProcessFirstLine != null) {
                            processHeader(str, sIPMessageProcessFirstLine, parseExceptionListener, bArr);
                        }
                    } else if (z3) {
                        sIPMessageProcessFirstLine = processFirstLine(strTrimEndOfLine, parseExceptionListener, bArr);
                    } else {
                        char cCharAt = strTrimEndOfLine.charAt(0);
                        if (cCharAt != '\t' && cCharAt != ' ') {
                            if (str != null && sIPMessageProcessFirstLine != null) {
                                processHeader(str, sIPMessageProcessFirstLine, parseExceptionListener, bArr);
                            }
                            str = strTrimEndOfLine;
                        } else {
                            if (str == null) {
                                throw new ParseException("Bad header continuation.", 0);
                            }
                            str = str + strTrimEndOfLine.substring(1);
                        }
                    }
                    if (bArr[i] == 13 && bArr.length > (i2 = i + 1) && bArr[i2] == 10) {
                        i = i2;
                    }
                    int i5 = i + 1;
                    if (strTrimEndOfLine.length() <= 0) {
                        i = i5;
                        break;
                    }
                    i4 = i5;
                    z3 = false;
                } catch (UnsupportedEncodingException unused3) {
                    throw new ParseException("Bad message encoding!", 0);
                }
            }
            if (sIPMessageProcessFirstLine == null) {
                throw new ParseException("Bad message", 0);
            }
            sIPMessageProcessFirstLine.setSize(i);
            if (z && sIPMessageProcessFirstLine.getContentLength() != null) {
                if (sIPMessageProcessFirstLine.getContentLength().getContentLength() != 0) {
                    int length = bArr.length - i;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, i, bArr2, 0, length);
                    sIPMessageProcessFirstLine.setMessageContent(bArr2, !z2, computeContentLengthFromMessage, sIPMessageProcessFirstLine.getContentLength().getContentLength());
                } else if (!computeContentLengthFromMessage) {
                    if (((sIPMessageProcessFirstLine.getContentLength().getContentLength() == 0) & z2) && !"\r\n\r\n".equals(new String(bArr, bArr.length - 4, 4))) {
                        throw new ParseException("Extraneous characters at the end of the message ", i);
                    }
                }
            }
            return sIPMessageProcessFirstLine;
        }
        return null;
    }

    public RequestLine parseSIPRequestLine(String str) {
        return new RequestLineParser(str + Separators.RETURN).parse();
    }

    public StatusLine parseSIPStatusLine(String str) {
        return new StatusLineParser(str + Separators.RETURN).parse();
    }

    public SipUri parseSIPUrl(String str) throws ParseException {
        try {
            return new URLParser(str).sipURL(true);
        } catch (ClassCastException unused) {
            throw new ParseException(str + " Not a SIP URL ", 0);
        }
    }

    public TelephoneNumber parseTelephoneNumber(String str) {
        return new URLParser(str).parseTelephoneNumber(true);
    }

    public GenericURI parseUrl(String str) {
        return new URLParser(str).parse();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected SIPMessage processFirstLine(String str, ParseExceptionListener parseExceptionListener, byte[] bArr) throws ParseException {
        SIPResponse sIPResponse;
        if (str.startsWith(SIPConstants.SIP_VERSION_STRING)) {
            SIPResponse sIPResponse2 = new SIPResponse();
            try {
                sIPResponse2.setStatusLine(new StatusLineParser(str + Separators.RETURN).parse());
                sIPResponse = sIPResponse2;
            } catch (ParseException e) {
                if (parseExceptionListener == null) {
                    throw e;
                }
                try {
                    parseExceptionListener.handleException(e, sIPResponse2, StatusLine.class, str, new String(bArr, "UTF-8"));
                    sIPResponse = sIPResponse2;
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    sIPResponse = sIPResponse2;
                }
            }
        } else {
            SIPRequest sIPRequest = new SIPRequest();
            try {
                sIPRequest.setRequestLine(new RequestLineParser(str + Separators.RETURN).parse());
                sIPResponse = sIPRequest;
            } catch (ParseException e3) {
                if (parseExceptionListener == null) {
                    throw e3;
                }
                try {
                    parseExceptionListener.handleException(e3, sIPRequest, RequestLine.class, str, new String(bArr, "UTF-8"));
                    sIPResponse = sIPRequest;
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    sIPResponse = sIPRequest;
                }
            }
        }
        return sIPResponse;
    }

    protected void processHeader(String str, SIPMessage sIPMessage, ParseExceptionListener parseExceptionListener, byte[] bArr) throws ParseException {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            try {
                sIPMessage.attachHeader(ParserFactory.createParser(str + Separators.RETURN).parse(), false);
            } catch (ParseException e) {
                if (parseExceptionListener != null) {
                    Class<ExtensionHeaderImpl> classFromName = NameMap.getClassFromName(Lexer.getHeaderName(str));
                    if (classFromName == null) {
                        classFromName = ExtensionHeaderImpl.class;
                    }
                    try {
                        parseExceptionListener.handleException(e, sIPMessage, classFromName, str, new String(bArr, "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (ParseException e3) {
            if (parseExceptionListener == null) {
                throw e3;
            }
            parseExceptionListener.handleException(e3, sIPMessage, null, str, null);
        }
    }
}
