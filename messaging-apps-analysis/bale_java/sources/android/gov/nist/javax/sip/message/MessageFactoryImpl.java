package android.gov.nist.javax.sip.message;

import android.gov.nist.javax.sip.header.CSeq;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.ContentType;
import android.gov.nist.javax.sip.header.From;
import android.gov.nist.javax.sip.header.MaxForwards;
import android.gov.nist.javax.sip.header.RequestLine;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.StatusLine;
import android.gov.nist.javax.sip.header.To;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.parser.ParseExceptionListener;
import android.gov.nist.javax.sip.parser.StringMsgParser;
import ir.nasim.B64;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC12560ep0;
import ir.nasim.InterfaceC17560nA2;
import ir.nasim.InterfaceC18560or7;
import ir.nasim.InterfaceC18819pI7;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC5044Hq6;
import ir.nasim.UP5;
import ir.nasim.VV3;
import java.text.ParseException;
import java.util.List;

/* loaded from: classes.dex */
public class MessageFactoryImpl implements B64, MessageFactoryExt {
    private static String defaultContentEncodingCharset = "UTF-8";
    private static InterfaceC5044Hq6 server;
    private static InterfaceC18819pI7 userAgent;
    private boolean testing = false;
    private boolean strict = true;

    public static String getDefaultContentEncodingCharset() {
        return defaultContentEncodingCharset;
    }

    public static InterfaceC5044Hq6 getDefaultServerHeader() {
        return server;
    }

    public static InterfaceC18819pI7 getDefaultUserAgentHeader() {
        return userAgent;
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public MultipartMimeContent createMultipartMimeContent(InterfaceC19085pl1 interfaceC19085pl1, String[] strArr, String[] strArr2, String[] strArr3) {
        interfaceC19085pl1.getParameter(MultipartMimeContentImpl.BOUNDARY);
        MultipartMimeContentImpl multipartMimeContentImpl = new MultipartMimeContentImpl(interfaceC19085pl1);
        for (int i = 0; i < strArr.length; i++) {
            ContentType contentType = new ContentType(strArr[i], strArr2[i]);
            ContentImpl contentImpl = new ContentImpl(strArr3[i]);
            contentImpl.setContentTypeHeader(contentType);
            multipartMimeContentImpl.add(contentImpl);
        }
        return multipartMimeContentImpl;
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public UP5 createRequest(InterfaceC21815uA7 interfaceC21815uA7, String str, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, Object obj) {
        if (interfaceC21815uA7 == null || str == null || interfaceC21662tv0 == null || interfaceC12560ep0 == null || interfaceC17560nA2 == null || interfaceC18560or7 == null || list == null || vv3 == null || obj == null || interfaceC19085pl1 == null) {
            throw new NullPointerException("Null parameters");
        }
        SIPRequest sIPRequest = new SIPRequest();
        sIPRequest.setRequestURI(interfaceC21815uA7);
        sIPRequest.setMethod(str);
        sIPRequest.setCallId(interfaceC21662tv0);
        sIPRequest.setCSeq(interfaceC12560ep0);
        sIPRequest.setFrom(interfaceC17560nA2);
        sIPRequest.setTo(interfaceC18560or7);
        sIPRequest.setVia(list);
        sIPRequest.setMaxForwards(vv3);
        sIPRequest.setContent(obj, interfaceC19085pl1);
        InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
        if (interfaceC18819pI7 != null) {
            sIPRequest.setHeader(interfaceC18819pI7);
        }
        return sIPRequest;
    }

    public InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, Object obj, InterfaceC19085pl1 interfaceC19085pl1) {
        if (interfaceC21662tv0 == null || interfaceC12560ep0 == null || interfaceC17560nA2 == null || interfaceC18560or7 == null || list == null || vv3 == null || obj == null || interfaceC19085pl1 == null) {
            throw new NullPointerException(" unable to create the response");
        }
        SIPResponse sIPResponse = new SIPResponse();
        StatusLine statusLine = new StatusLine();
        statusLine.setStatusCode(i);
        statusLine.setReasonPhrase(SIPResponse.getReasonPhrase(i));
        sIPResponse.setStatusLine(statusLine);
        sIPResponse.setCallId(interfaceC21662tv0);
        sIPResponse.setCSeq(interfaceC12560ep0);
        sIPResponse.setFrom(interfaceC17560nA2);
        sIPResponse.setTo(interfaceC18560or7);
        sIPResponse.setVia(list);
        sIPResponse.setMaxForwards(vv3);
        sIPResponse.setContent(obj, interfaceC19085pl1);
        InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
        if (interfaceC18819pI7 != null) {
            sIPResponse.setHeader(interfaceC18819pI7);
        }
        return sIPResponse;
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public void setDefaultContentEncodingCharset(String str) {
        if (str == null) {
            throw new NullPointerException("Null argument!");
        }
        defaultContentEncodingCharset = str;
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public void setDefaultServerHeader(InterfaceC5044Hq6 interfaceC5044Hq6) {
        server = interfaceC5044Hq6;
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public void setDefaultUserAgentHeader(InterfaceC18819pI7 interfaceC18819pI7) {
        userAgent = interfaceC18819pI7;
    }

    public void setStrict(boolean z) {
        this.strict = z;
    }

    public void setTest(boolean z) {
        this.testing = z;
    }

    public UP5 createRequest(InterfaceC21815uA7 interfaceC21815uA7, String str, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, byte[] bArr, InterfaceC19085pl1 interfaceC19085pl1) throws ParseException {
        if (interfaceC21815uA7 != null && str != null && interfaceC21662tv0 != null && interfaceC12560ep0 != null && interfaceC17560nA2 != null && interfaceC18560or7 != null && list != null && vv3 != null && bArr != null && interfaceC19085pl1 != null) {
            SIPRequest sIPRequest = new SIPRequest();
            sIPRequest.setRequestURI(interfaceC21815uA7);
            sIPRequest.setMethod(str);
            sIPRequest.setCallId(interfaceC21662tv0);
            sIPRequest.setCSeq(interfaceC12560ep0);
            sIPRequest.setFrom(interfaceC17560nA2);
            sIPRequest.setTo(interfaceC18560or7);
            sIPRequest.setVia(list);
            sIPRequest.setMaxForwards(vv3);
            sIPRequest.setHeader((ContentType) interfaceC19085pl1);
            sIPRequest.setMessageContent(bArr);
            InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
            if (interfaceC18819pI7 != null) {
                sIPRequest.setHeader(interfaceC18819pI7);
            }
            return sIPRequest;
        }
        throw new ParseException("JAIN-SIP Exception, some parameters are missing, unable to create the request", 0);
    }

    public InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, byte[] bArr, InterfaceC19085pl1 interfaceC19085pl1) throws ParseException {
        if (interfaceC21662tv0 != null && interfaceC12560ep0 != null && interfaceC17560nA2 != null && interfaceC18560or7 != null && list != null && vv3 != null && bArr != null && interfaceC19085pl1 != null) {
            SIPResponse sIPResponse = new SIPResponse();
            sIPResponse.setStatusCode(i);
            sIPResponse.setCallId(interfaceC21662tv0);
            sIPResponse.setCSeq(interfaceC12560ep0);
            sIPResponse.setFrom(interfaceC17560nA2);
            sIPResponse.setTo(interfaceC18560or7);
            sIPResponse.setVia(list);
            sIPResponse.setMaxForwards(vv3);
            sIPResponse.setHeader((ContentType) interfaceC19085pl1);
            sIPResponse.setMessageContent(bArr);
            InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
            if (interfaceC18819pI7 != null) {
                sIPResponse.setHeader(interfaceC18819pI7);
            }
            return sIPResponse;
        }
        throw new NullPointerException("Null params ");
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public UP5 createRequest(InterfaceC21815uA7 interfaceC21815uA7, String str, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3) throws ParseException {
        if (interfaceC21815uA7 != null && str != null && interfaceC21662tv0 != null && interfaceC12560ep0 != null && interfaceC17560nA2 != null && interfaceC18560or7 != null && list != null && vv3 != null) {
            SIPRequest sIPRequest = new SIPRequest();
            sIPRequest.setRequestURI(interfaceC21815uA7);
            sIPRequest.setMethod(str);
            sIPRequest.setCallId(interfaceC21662tv0);
            sIPRequest.setCSeq(interfaceC12560ep0);
            sIPRequest.setFrom(interfaceC17560nA2);
            sIPRequest.setTo(interfaceC18560or7);
            sIPRequest.setVia(list);
            sIPRequest.setMaxForwards(vv3);
            InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
            if (interfaceC18819pI7 != null) {
                sIPRequest.setHeader(interfaceC18819pI7);
            }
            return sIPRequest;
        }
        throw new ParseException("JAIN-SIP Exception, some parameters are missing, unable to create the request", 0);
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3) throws ParseException {
        if (interfaceC21662tv0 != null && interfaceC12560ep0 != null && interfaceC17560nA2 != null && interfaceC18560or7 != null && list != null && vv3 != null) {
            SIPResponse sIPResponse = new SIPResponse();
            sIPResponse.setStatusCode(i);
            sIPResponse.setCallId(interfaceC21662tv0);
            sIPResponse.setCSeq(interfaceC12560ep0);
            sIPResponse.setFrom(interfaceC17560nA2);
            sIPResponse.setTo(interfaceC18560or7);
            sIPResponse.setVia(list);
            sIPResponse.setMaxForwards(vv3);
            InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
            if (interfaceC18819pI7 != null) {
                sIPResponse.setHeader(interfaceC18819pI7);
            }
            return sIPResponse;
        }
        throw new ParseException("JAIN-SIP Exception, some parameters are missing, unable to create the response", 0);
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public UP5 createRequest(InterfaceC21815uA7 interfaceC21815uA7, String str, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, byte[] bArr) {
        if (interfaceC21815uA7 != null && str != null && interfaceC21662tv0 != null && interfaceC12560ep0 != null && interfaceC17560nA2 != null && interfaceC18560or7 != null && list != null && vv3 != null && bArr != null && interfaceC19085pl1 != null) {
            SIPRequest sIPRequest = new SIPRequest();
            sIPRequest.setRequestURI(interfaceC21815uA7);
            sIPRequest.setMethod(str);
            sIPRequest.setCallId(interfaceC21662tv0);
            sIPRequest.setCSeq(interfaceC12560ep0);
            sIPRequest.setFrom(interfaceC17560nA2);
            sIPRequest.setTo(interfaceC18560or7);
            sIPRequest.setVia(list);
            sIPRequest.setMaxForwards(vv3);
            sIPRequest.setContent(bArr, interfaceC19085pl1);
            InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
            if (interfaceC18819pI7 != null) {
                sIPRequest.setHeader(interfaceC18819pI7);
            }
            return sIPRequest;
        }
        throw new NullPointerException("missing parameters");
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public InterfaceC10981cX5 createResponse(int i, UP5 up5, InterfaceC19085pl1 interfaceC19085pl1, Object obj) {
        if (up5 != null && obj != null && interfaceC19085pl1 != null) {
            SIPResponse sIPResponseCreateResponse = ((SIPRequest) up5).createResponse(i);
            sIPResponseCreateResponse.setContent(obj, interfaceC19085pl1);
            InterfaceC5044Hq6 interfaceC5044Hq6 = server;
            if (interfaceC5044Hq6 != null) {
                sIPResponseCreateResponse.setHeader(interfaceC5044Hq6);
            }
            return sIPResponseCreateResponse;
        }
        throw new NullPointerException("null parameters");
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public InterfaceC10981cX5 createResponse(int i, UP5 up5, InterfaceC19085pl1 interfaceC19085pl1, byte[] bArr) {
        if (up5 != null && bArr != null && interfaceC19085pl1 != null) {
            SIPResponse sIPResponseCreateResponse = ((SIPRequest) up5).createResponse(i);
            sIPResponseCreateResponse.setHeader((ContentType) interfaceC19085pl1);
            sIPResponseCreateResponse.setMessageContent(bArr);
            InterfaceC5044Hq6 interfaceC5044Hq6 = server;
            if (interfaceC5044Hq6 != null) {
                sIPResponseCreateResponse.setHeader(interfaceC5044Hq6);
            }
            return sIPResponseCreateResponse;
        }
        throw new NullPointerException("null Parameters");
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public UP5 createRequest(String str) throws ParseException {
        if (str != null && !str.equals("")) {
            StringMsgParser stringMsgParser = new StringMsgParser();
            ParseExceptionListener parseExceptionListener = new ParseExceptionListener() { // from class: android.gov.nist.javax.sip.message.MessageFactoryImpl.1
                @Override // android.gov.nist.javax.sip.parser.ParseExceptionListener
                public void handleException(ParseException parseException, SIPMessage sIPMessage, Class cls, String str2, String str3) throws ParseException {
                    if (MessageFactoryImpl.this.testing) {
                        if (cls == From.class || cls == To.class || cls == CallID.class || cls == MaxForwards.class || cls == Via.class || cls == RequestLine.class || cls == StatusLine.class || cls == CSeq.class) {
                            throw parseException;
                        }
                        sIPMessage.addUnparsed(str2);
                    }
                }
            };
            if (!this.testing) {
                parseExceptionListener = null;
            }
            SIPMessage sIPMessage = stringMsgParser.parseSIPMessage(str.getBytes(), true, this.strict, parseExceptionListener);
            if (sIPMessage instanceof SIPRequest) {
                return (SIPRequest) sIPMessage;
            }
            throw new ParseException(str, 0);
        }
        SIPRequest sIPRequest = new SIPRequest();
        sIPRequest.setNullRequest();
        return sIPRequest;
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public InterfaceC10981cX5 createResponse(int i, UP5 up5) {
        if (up5 != null) {
            SIPResponse sIPResponseCreateResponse = ((SIPRequest) up5).createResponse(i);
            sIPResponseCreateResponse.removeContent();
            sIPResponseCreateResponse.removeHeader(SIPHeaderNames.CONTENT_TYPE);
            InterfaceC5044Hq6 interfaceC5044Hq6 = server;
            if (interfaceC5044Hq6 != null) {
                sIPResponseCreateResponse.setHeader(interfaceC5044Hq6);
            }
            return sIPResponseCreateResponse;
        }
        throw new NullPointerException("null parameters");
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, Object obj) throws ParseException {
        if (interfaceC21662tv0 != null && interfaceC12560ep0 != null && interfaceC17560nA2 != null && interfaceC18560or7 != null && list != null && vv3 != null && obj != null && interfaceC19085pl1 != null) {
            SIPResponse sIPResponse = new SIPResponse();
            StatusLine statusLine = new StatusLine();
            statusLine.setStatusCode(i);
            String reasonPhrase = SIPResponse.getReasonPhrase(i);
            if (reasonPhrase != null) {
                statusLine.setReasonPhrase(reasonPhrase);
                sIPResponse.setStatusLine(statusLine);
                sIPResponse.setCallId(interfaceC21662tv0);
                sIPResponse.setCSeq(interfaceC12560ep0);
                sIPResponse.setFrom(interfaceC17560nA2);
                sIPResponse.setTo(interfaceC18560or7);
                sIPResponse.setVia(list);
                sIPResponse.setContent(obj, interfaceC19085pl1);
                InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
                if (interfaceC18819pI7 != null) {
                    sIPResponse.setHeader(interfaceC18819pI7);
                }
                return sIPResponse;
            }
            throw new ParseException(i + " Unknown", 0);
        }
        throw new NullPointerException("missing parameters");
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public InterfaceC10981cX5 createResponse(int i, InterfaceC21662tv0 interfaceC21662tv0, InterfaceC12560ep0 interfaceC12560ep0, InterfaceC17560nA2 interfaceC17560nA2, InterfaceC18560or7 interfaceC18560or7, List list, VV3 vv3, InterfaceC19085pl1 interfaceC19085pl1, byte[] bArr) throws ParseException {
        if (interfaceC21662tv0 != null && interfaceC12560ep0 != null && interfaceC17560nA2 != null && interfaceC18560or7 != null && list != null && vv3 != null && bArr != null && interfaceC19085pl1 != null) {
            SIPResponse sIPResponse = new SIPResponse();
            StatusLine statusLine = new StatusLine();
            statusLine.setStatusCode(i);
            String reasonPhrase = SIPResponse.getReasonPhrase(i);
            if (reasonPhrase != null) {
                statusLine.setReasonPhrase(reasonPhrase);
                sIPResponse.setStatusLine(statusLine);
                sIPResponse.setCallId(interfaceC21662tv0);
                sIPResponse.setCSeq(interfaceC12560ep0);
                sIPResponse.setFrom(interfaceC17560nA2);
                sIPResponse.setTo(interfaceC18560or7);
                sIPResponse.setVia(list);
                sIPResponse.setContent(bArr, interfaceC19085pl1);
                InterfaceC18819pI7 interfaceC18819pI7 = userAgent;
                if (interfaceC18819pI7 != null) {
                    sIPResponse.setHeader(interfaceC18819pI7);
                }
                return sIPResponse;
            }
            throw new ParseException(i + " : Unknown", 0);
        }
        throw new NullPointerException("missing parameters");
    }

    @Override // android.gov.nist.javax.sip.message.MessageFactoryExt
    public InterfaceC10981cX5 createResponse(String str) throws ParseException {
        if (str == null) {
            return new SIPResponse();
        }
        SIPMessage sIPMessage = new StringMsgParser().parseSIPMessage(str.getBytes(), true, false, null);
        if (sIPMessage instanceof SIPResponse) {
            return (SIPResponse) sIPMessage;
        }
        throw new ParseException(str, 0);
    }
}
