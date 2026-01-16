package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.GenericURI;
import android.gov.nist.javax.sip.header.extensions.Join;
import android.gov.nist.javax.sip.header.extensions.JoinHeader;
import android.gov.nist.javax.sip.header.extensions.MinSE;
import android.gov.nist.javax.sip.header.extensions.References;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import android.gov.nist.javax.sip.header.extensions.ReferredBy;
import android.gov.nist.javax.sip.header.extensions.ReferredByHeader;
import android.gov.nist.javax.sip.header.extensions.Replaces;
import android.gov.nist.javax.sip.header.extensions.ReplacesHeader;
import android.gov.nist.javax.sip.header.extensions.SessionExpires;
import android.gov.nist.javax.sip.header.extensions.SessionExpiresHeader;
import android.gov.nist.javax.sip.header.ims.PAccessNetworkInfo;
import android.gov.nist.javax.sip.header.ims.PAccessNetworkInfoHeader;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentity;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import android.gov.nist.javax.sip.header.ims.PAssertedService;
import android.gov.nist.javax.sip.header.ims.PAssertedServiceHeader;
import android.gov.nist.javax.sip.header.ims.PAssociatedURI;
import android.gov.nist.javax.sip.header.ims.PAssociatedURIHeader;
import android.gov.nist.javax.sip.header.ims.PCalledPartyID;
import android.gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;
import android.gov.nist.javax.sip.header.ims.PChargingFunctionAddresses;
import android.gov.nist.javax.sip.header.ims.PChargingFunctionAddressesHeader;
import android.gov.nist.javax.sip.header.ims.PChargingVector;
import android.gov.nist.javax.sip.header.ims.PChargingVectorHeader;
import android.gov.nist.javax.sip.header.ims.PMediaAuthorization;
import android.gov.nist.javax.sip.header.ims.PMediaAuthorizationHeader;
import android.gov.nist.javax.sip.header.ims.PPreferredIdentity;
import android.gov.nist.javax.sip.header.ims.PPreferredIdentityHeader;
import android.gov.nist.javax.sip.header.ims.PPreferredService;
import android.gov.nist.javax.sip.header.ims.PPreferredServiceHeader;
import android.gov.nist.javax.sip.header.ims.PProfileKey;
import android.gov.nist.javax.sip.header.ims.PProfileKeyHeader;
import android.gov.nist.javax.sip.header.ims.PServedUser;
import android.gov.nist.javax.sip.header.ims.PServedUserHeader;
import android.gov.nist.javax.sip.header.ims.PUserDatabase;
import android.gov.nist.javax.sip.header.ims.PUserDatabaseHeader;
import android.gov.nist.javax.sip.header.ims.PVisitedNetworkID;
import android.gov.nist.javax.sip.header.ims.PVisitedNetworkIDHeader;
import android.gov.nist.javax.sip.header.ims.Path;
import android.gov.nist.javax.sip.header.ims.PathHeader;
import android.gov.nist.javax.sip.header.ims.Privacy;
import android.gov.nist.javax.sip.header.ims.PrivacyHeader;
import android.gov.nist.javax.sip.header.ims.SecurityClient;
import android.gov.nist.javax.sip.header.ims.SecurityClientHeader;
import android.gov.nist.javax.sip.header.ims.SecurityServer;
import android.gov.nist.javax.sip.header.ims.SecurityServerHeader;
import android.gov.nist.javax.sip.header.ims.SecurityVerify;
import android.gov.nist.javax.sip.header.ims.SecurityVerifyHeader;
import android.gov.nist.javax.sip.header.ims.ServiceRoute;
import android.gov.nist.javax.sip.header.ims.ServiceRouteHeader;
import android.gov.nist.javax.sip.parser.RequestLineParser;
import android.gov.nist.javax.sip.parser.StatusLineParser;
import android.gov.nist.javax.sip.parser.StringMsgParser;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.HU2;
import ir.nasim.InterfaceC10039ay5;
import ir.nasim.InterfaceC12062dy5;
import ir.nasim.InterfaceC12201eC7;
import ir.nasim.InterfaceC12560ep0;
import ir.nasim.InterfaceC13453gF5;
import ir.nasim.InterfaceC13543gP5;
import ir.nasim.InterfaceC14098hL5;
import ir.nasim.InterfaceC15712k27;
import ir.nasim.InterfaceC15786kA1;
import ir.nasim.InterfaceC16186kq7;
import ir.nasim.InterfaceC16488lM4;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC17119mR;
import ir.nasim.InterfaceC17560nA2;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC18352oW5;
import ir.nasim.InterfaceC18560or7;
import ir.nasim.InterfaceC18659p2;
import ir.nasim.InterfaceC18819pI7;
import ir.nasim.InterfaceC19085pl1;
import ir.nasim.InterfaceC19238q07;
import ir.nasim.InterfaceC19250q2;
import ir.nasim.InterfaceC19838r16;
import ir.nasim.InterfaceC19841r2;
import ir.nasim.InterfaceC20293rm;
import ir.nasim.InterfaceC20484s53;
import ir.nasim.InterfaceC20884sm;
import ir.nasim.InterfaceC21052t18;
import ir.nasim.InterfaceC21427te2;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC22252uv0;
import ir.nasim.InterfaceC23329wk1;
import ir.nasim.InterfaceC24509yk1;
import ir.nasim.InterfaceC3285Af4;
import ir.nasim.InterfaceC3524Bf4;
import ir.nasim.InterfaceC5044Hq6;
import ir.nasim.InterfaceC5634Ke2;
import ir.nasim.InterfaceC6711Oq5;
import ir.nasim.InterfaceC7365Rk1;
import ir.nasim.InterfaceC7510Sa2;
import ir.nasim.InterfaceC7599Sk1;
import ir.nasim.InterfaceC7782Te1;
import ir.nasim.InterfaceC9088Yl;
import ir.nasim.InterfaceC9436Zx5;
import ir.nasim.InterfaceC9654aK5;
import ir.nasim.JI5;
import ir.nasim.K76;
import ir.nasim.L76;
import ir.nasim.LU2;
import ir.nasim.V46;
import ir.nasim.VR;
import ir.nasim.VV3;
import ir.nasim.Y38;
import ir.nasim.YZ6;
import ir.nasim.Z92;
import ir.nasim.ZE5;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class HeaderFactoryImpl implements LU2, HeaderFactoryExt {
    private boolean stripAddressScopeZones;

    public HeaderFactoryImpl() {
        this.stripAddressScopeZones = false;
        this.stripAddressScopeZones = Boolean.getBoolean("android.gov.nist.core.STRIP_ADDR_SCOPES");
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC18659p2 createAcceptEncodingHeader(String str) {
        if (str == null) {
            throw new NullPointerException("the encoding parameter is null");
        }
        AcceptEncoding acceptEncoding = new AcceptEncoding();
        acceptEncoding.setEncoding(str);
        return acceptEncoding;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC19250q2 createAcceptHeader(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("contentType or subtype is null ");
        }
        Accept accept = new Accept();
        accept.setContentType(str);
        accept.setContentSubType(str2);
        return accept;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC19841r2 createAcceptLanguageHeader(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("null arg");
        }
        AcceptLanguage acceptLanguage = new AcceptLanguage();
        acceptLanguage.setAcceptLanguage(locale);
        return acceptLanguage;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC9088Yl createAlertInfoHeader(InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 == null) {
            throw new NullPointerException("null arg alertInfo");
        }
        AlertInfo alertInfo = new AlertInfo();
        alertInfo.setAlertInfo(interfaceC21815uA7);
        return alertInfo;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC20293rm createAllowEventsHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null arg eventType");
        }
        AllowEvents allowEvents = new AllowEvents();
        allowEvents.setEventType(str);
        return allowEvents;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC20884sm createAllowHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null arg method");
        }
        Allow allow = new Allow();
        allow.setMethod(str);
        return allow;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC17119mR createAuthenticationInfoHeader(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null arg response");
        }
        AuthenticationInfo authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setResponse(str);
        return authenticationInfo;
    }

    @Override // ir.nasim.LU2
    public VR createAuthorizationHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null arg scheme ");
        }
        Authorization authorization = new Authorization();
        authorization.setScheme(str);
        return authorization;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC12560ep0 createCSeqHeader(long j, String str) throws InvalidArgumentException {
        if (j < 0) {
            throw new InvalidArgumentException("bad arg " + j);
        }
        if (str == null) {
            throw new NullPointerException("null arg method");
        }
        CSeq cSeq = new CSeq();
        cSeq.setMethod(str);
        cSeq.setSeqNumber(j);
        return cSeq;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC21662tv0 createCallIdHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null arg callId");
        }
        CallID callID = new CallID();
        callID.setCallId(str);
        return callID;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC22252uv0 createCallInfoHeader(InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 == null) {
            throw new NullPointerException("null arg callInfo");
        }
        CallInfo callInfo = new CallInfo();
        callInfo.setInfo(interfaceC21815uA7);
        return callInfo;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PChargingVectorHeader createChargingVectorHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null icid arg!");
        }
        PChargingVector pChargingVector = new PChargingVector();
        pChargingVector.setICID(str);
        return pChargingVector;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC7782Te1 createContactHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null arg address");
        }
        Contact contact = new Contact();
        contact.setAddress(interfaceC16609la);
        return contact;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC23329wk1 createContentDispositionHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null arg contentDisposition");
        }
        ContentDisposition contentDisposition = new ContentDisposition();
        contentDisposition.setDispositionType(str);
        return contentDisposition;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC24509yk1 createContentEncodingHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null encoding");
        }
        ContentEncoding contentEncoding = new ContentEncoding();
        contentEncoding.setEncoding(str);
        return contentEncoding;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC7365Rk1 createContentLanguageHeader(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("null arg contentLanguage");
        }
        ContentLanguage contentLanguage = new ContentLanguage();
        contentLanguage.setContentLanguage(locale);
        return contentLanguage;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC7599Sk1 createContentLengthHeader(int i) throws InvalidArgumentException {
        if (i < 0) {
            throw new InvalidArgumentException("bad contentLength");
        }
        ContentLength contentLength = new ContentLength();
        contentLength.setContentLength(i);
        return contentLength;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC19085pl1 createContentTypeHeader(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("null contentType or subType");
        }
        ContentType contentType = new ContentType();
        contentType.setContentType(str);
        contentType.setContentSubType(str2);
        return contentType;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC15786kA1 createDateHeader(Calendar calendar) {
        SIPDateHeader sIPDateHeader = new SIPDateHeader();
        if (calendar == null) {
            throw new NullPointerException("null date");
        }
        sIPDateHeader.setDate(calendar);
        return sIPDateHeader;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public Z92 createErrorInfoHeader(InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 != null) {
            return new ErrorInfo((GenericURI) interfaceC21815uA7);
        }
        throw new NullPointerException("null arg");
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC7510Sa2 createEventHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null eventType");
        }
        Event event = new Event();
        event.setEventType(str);
        return event;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC21427te2 createExpiresHeader(int i) throws InvalidArgumentException {
        if (i >= 0) {
            Expires expires = new Expires();
            expires.setExpires(i);
            return expires;
        }
        throw new InvalidArgumentException("bad value " + i);
    }

    public InterfaceC5634Ke2 createExtensionHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("bad name");
        }
        ExtensionHeaderImpl extensionHeaderImpl = new ExtensionHeaderImpl();
        extensionHeaderImpl.setName(str);
        extensionHeaderImpl.setValue(str2);
        return extensionHeaderImpl;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC17560nA2 createFromHeader(InterfaceC16609la interfaceC16609la, String str) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address arg");
        }
        From from = new From();
        from.setAddress(interfaceC16609la);
        if (str != null) {
            from.setTag(str);
        }
        return from;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public HU2 createHeader(String str) throws ParseException {
        new StringMsgParser();
        SIPHeader sIPHeader = StringMsgParser.parseSIPHeader(str.trim());
        if (!(sIPHeader instanceof SIPHeaderList)) {
            return sIPHeader;
        }
        SIPHeaderList sIPHeaderList = (SIPHeaderList) sIPHeader;
        if (sIPHeaderList.size() > 1) {
            throw new ParseException("Only singleton allowed " + str, 0);
        }
        if (sIPHeaderList.size() != 0) {
            return sIPHeaderList.getFirst();
        }
        try {
            return (HU2) ((SIPHeaderList) sIPHeader).getMyClass().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public List createHeaders(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null arg!");
        }
        new StringMsgParser();
        SIPHeader sIPHeader = StringMsgParser.parseSIPHeader(str);
        if (sIPHeader instanceof SIPHeaderList) {
            return (SIPHeaderList) sIPHeader;
        }
        throw new ParseException("List of headers of this type is not allowed in a message", 0);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC20484s53 createInReplyToHeader(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null callId arg");
        }
        InReplyTo inReplyTo = new InReplyTo();
        inReplyTo.setCallId(str);
        return inReplyTo;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public JoinHeader createJoinHeader(String str, String str2, String str3) throws ParseException {
        Join join = new Join();
        join.setCallId(str);
        join.setFromTag(str3);
        join.setToTag(str2);
        return join;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public VV3 createMaxForwardsHeader(int i) throws InvalidArgumentException {
        if (i >= 0 && i <= 255) {
            MaxForwards maxForwards = new MaxForwards();
            maxForwards.setMaxForwards(i);
            return maxForwards;
        }
        throw new InvalidArgumentException("bad maxForwards arg " + i);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC3285Af4 createMimeVersionHeader(int i, int i2) throws InvalidArgumentException {
        if (i < 0 || i2 < 0) {
            throw new InvalidArgumentException("bad major/minor version");
        }
        MimeVersion mimeVersion = new MimeVersion();
        mimeVersion.setMajorVersion(i);
        mimeVersion.setMinorVersion(i2);
        return mimeVersion;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC3524Bf4 createMinExpiresHeader(int i) throws InvalidArgumentException {
        if (i >= 0) {
            MinExpires minExpires = new MinExpires();
            minExpires.setExpires(i);
            return minExpires;
        }
        throw new InvalidArgumentException("bad minExpires " + i);
    }

    public InterfaceC5634Ke2 createMinSEHeader(int i) throws InvalidArgumentException {
        if (i >= 0) {
            MinSE minSE = new MinSE();
            minSE.setExpires(i);
            return minSE;
        }
        throw new InvalidArgumentException("bad value " + i);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC16488lM4 createOrganizationHeader(String str) {
        if (str == null) {
            throw new NullPointerException("bad organization arg");
        }
        Organization organization = new Organization();
        organization.setOrganization(str);
        return organization;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PAccessNetworkInfoHeader createPAccessNetworkInfoHeader() {
        return new PAccessNetworkInfo();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PAssertedIdentityHeader createPAssertedIdentityHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address!");
        }
        PAssertedIdentity pAssertedIdentity = new PAssertedIdentity();
        pAssertedIdentity.setAddress(interfaceC16609la);
        return pAssertedIdentity;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PAssertedServiceHeader createPAssertedServiceHeader() {
        return new PAssertedService();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PAssociatedURIHeader createPAssociatedURIHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null associatedURI!");
        }
        PAssociatedURI pAssociatedURI = new PAssociatedURI();
        pAssociatedURI.setAddress(interfaceC16609la);
        return pAssociatedURI;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PCalledPartyIDHeader createPCalledPartyIDHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address!");
        }
        PCalledPartyID pCalledPartyID = new PCalledPartyID();
        pCalledPartyID.setAddress(interfaceC16609la);
        return pCalledPartyID;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader() {
        return new PChargingFunctionAddresses();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PMediaAuthorizationHeader createPMediaAuthorizationHeader(String str) throws InvalidArgumentException {
        if (str == null || str == "") {
            throw new InvalidArgumentException("The Media-Authorization-Token parameter is null or empty");
        }
        PMediaAuthorization pMediaAuthorization = new PMediaAuthorization();
        pMediaAuthorization.setMediaAuthorizationToken(str);
        return pMediaAuthorization;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PPreferredIdentityHeader createPPreferredIdentityHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address!");
        }
        PPreferredIdentity pPreferredIdentity = new PPreferredIdentity();
        pPreferredIdentity.setAddress(interfaceC16609la);
        return pPreferredIdentity;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PPreferredServiceHeader createPPreferredServiceHeader() {
        return new PPreferredService();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PProfileKeyHeader createPProfileKeyHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("Address is null");
        }
        PProfileKey pProfileKey = new PProfileKey();
        pProfileKey.setAddress(interfaceC16609la);
        return pProfileKey;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PServedUserHeader createPServedUserHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("Address is null");
        }
        PServedUser pServedUser = new PServedUser();
        pServedUser.setAddress(interfaceC16609la);
        return pServedUser;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PUserDatabaseHeader createPUserDatabaseHeader(String str) {
        if (str == null || str.equals(Separators.SP)) {
            throw new NullPointerException("Database name is null");
        }
        PUserDatabase pUserDatabase = new PUserDatabase();
        pUserDatabase.setDatabaseName(str);
        return pUserDatabase;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PVisitedNetworkIDHeader createPVisitedNetworkIDHeader() {
        return new PVisitedNetworkID();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PathHeader createPathHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address!");
        }
        Path path = new Path();
        path.setAddress(interfaceC16609la);
        return path;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC6711Oq5 createPriorityHeader(String str) {
        if (str == null) {
            throw new NullPointerException("bad priority arg");
        }
        Priority priority = new Priority();
        priority.setPriority(str);
        return priority;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public PrivacyHeader createPrivacyHeader(String str) {
        if (str != null) {
            return new Privacy(str);
        }
        throw new NullPointerException("null privacyType arg");
    }

    @Override // ir.nasim.LU2
    public InterfaceC9436Zx5 createProxyAuthenticateHeader(String str) {
        if (str == null) {
            throw new NullPointerException("bad scheme arg");
        }
        ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        proxyAuthenticate.setScheme(str);
        return proxyAuthenticate;
    }

    @Override // ir.nasim.LU2
    public InterfaceC10039ay5 createProxyAuthorizationHeader(String str) {
        if (str == null) {
            throw new NullPointerException("bad scheme arg");
        }
        ProxyAuthorization proxyAuthorization = new ProxyAuthorization();
        proxyAuthorization.setScheme(str);
        return proxyAuthorization;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC12062dy5 createProxyRequireHeader(String str) {
        if (str == null) {
            throw new NullPointerException("bad optionTag arg");
        }
        ProxyRequire proxyRequire = new ProxyRequire();
        proxyRequire.setOptionTag(str);
        return proxyRequire;
    }

    public ZE5 createRAckHeader(long j, long j2, String str) throws InvalidArgumentException {
        if (str == null) {
            throw new NullPointerException("Bad method");
        }
        if (j2 < 0 || j < 0) {
            throw new InvalidArgumentException("bad cseq/rseq arg");
        }
        RAck rAck = new RAck();
        rAck.setMethod(str);
        rAck.setCSequenceNumber(j2);
        rAck.setRSequenceNumber(j);
        return rAck;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC13453gF5 createRSeqHeader(int i) {
        return createRSeqHeader(i);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public JI5 createReasonHeader(String str, int i, String str2) throws InvalidArgumentException {
        if (str == null) {
            throw new NullPointerException("bad protocol arg");
        }
        if (i < 0) {
            throw new InvalidArgumentException("bad cause");
        }
        Reason reason = new Reason();
        reason.setProtocol(str);
        reason.setCause(i);
        reason.setText(str2);
        return reason;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC9654aK5 createRecordRouteHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("Null argument!");
        }
        RecordRoute recordRoute = new RecordRoute();
        recordRoute.setAddress(interfaceC16609la);
        return recordRoute;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC14098hL5 createReferToHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address!");
        }
        ReferTo referTo = new ReferTo();
        referTo.setAddress(interfaceC16609la);
        return referTo;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public ReferencesHeader createReferencesHeader(String str, String str2) {
        References references = new References();
        references.setCallId(str);
        references.setRel(str2);
        return references;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public ReferredByHeader createReferredByHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address!");
        }
        ReferredBy referredBy = new ReferredBy();
        referredBy.setAddress(interfaceC16609la);
        return referredBy;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public ReplacesHeader createReplacesHeader(String str, String str2, String str3) throws ParseException {
        Replaces replaces = new Replaces();
        replaces.setCallId(str);
        replaces.setFromTag(str3);
        replaces.setToTag(str2);
        return replaces;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC13543gP5 createReplyToHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address");
        }
        ReplyTo replyTo = new ReplyTo();
        replyTo.setAddress(interfaceC16609la);
        return replyTo;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public SipRequestLine createRequestLine(String str) {
        return new RequestLineParser(str).parse();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC18352oW5 createRequireHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null optionTag");
        }
        Require require = new Require();
        require.setOptionTag(str);
        return require;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC19838r16 createRetryAfterHeader(int i) throws InvalidArgumentException {
        if (i < 0) {
            throw new InvalidArgumentException("bad retryAfter arg");
        }
        RetryAfter retryAfter = new RetryAfter();
        retryAfter.setRetryAfter(i);
        return retryAfter;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public V46 createRouteHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address arg");
        }
        Route route = new Route();
        route.setAddress(interfaceC16609la);
        return route;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public K76 createSIPETagHeader(String str) {
        return new SIPETag(str);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public L76 createSIPIfMatchHeader(String str) {
        return new SIPIfMatch(str);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public SecurityClientHeader createSecurityClientHeader() {
        return new SecurityClient();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public SecurityServerHeader createSecurityServerHeader() {
        return new SecurityServer();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public SecurityVerifyHeader createSecurityVerifyHeader() {
        return new SecurityVerify();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC5044Hq6 createServerHeader(List list) {
        if (list == null) {
            throw new NullPointerException("null productList arg");
        }
        Server server = new Server();
        server.setProduct(list);
        return server;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public ServiceRouteHeader createServiceRouteHeader(InterfaceC16609la interfaceC16609la) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address!");
        }
        ServiceRoute serviceRoute = new ServiceRoute();
        serviceRoute.setAddress(interfaceC16609la);
        return serviceRoute;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public SessionExpiresHeader createSessionExpiresHeader(int i) throws InvalidArgumentException {
        if (i >= 0) {
            SessionExpires sessionExpires = new SessionExpires();
            sessionExpires.setExpires(i);
            return sessionExpires;
        }
        throw new InvalidArgumentException("bad value " + i);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public SipStatusLine createStatusLine(String str) {
        return new StatusLineParser(str).parse();
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public YZ6 createSubjectHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null subject arg");
        }
        Subject subject = new Subject();
        subject.setSubject(str);
        return subject;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC19238q07 createSubscriptionStateHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null subscriptionState arg");
        }
        SubscriptionState subscriptionState = new SubscriptionState();
        subscriptionState.setState(str);
        return subscriptionState;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC15712k27 createSupportedHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null optionTag arg");
        }
        Supported supported = new Supported();
        supported.setOptionTag(str);
        return supported;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC16186kq7 createTimeStampHeader(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("illegal timeStamp");
        }
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(f);
        return timeStamp;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC18560or7 createToHeader(InterfaceC16609la interfaceC16609la, String str) {
        if (interfaceC16609la == null) {
            throw new NullPointerException("null address");
        }
        To to = new To();
        to.setAddress(interfaceC16609la);
        if (str != null) {
            to.setTag(str);
        }
        return to;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC12201eC7 createUnsupportedHeader(String str) {
        if (str == null) {
            throw new NullPointerException(str);
        }
        Unsupported unsupported = new Unsupported();
        unsupported.setOptionTag(str);
        return unsupported;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC18819pI7 createUserAgentHeader(List list) {
        if (list == null) {
            throw new NullPointerException("null user agent");
        }
        UserAgent userAgent = new UserAgent();
        userAgent.setProduct(list);
        return userAgent;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC18318oS7 createViaHeader(String str, int i, String str2, String str3) throws InvalidArgumentException {
        int iIndexOf;
        if (str == null || str2 == null) {
            throw new NullPointerException("null arg");
        }
        Via via = new Via();
        if (str3 != null) {
            via.setBranch(str3);
        }
        if (str.indexOf(58) >= 0 && str.indexOf(91) < 0) {
            if (this.stripAddressScopeZones && (iIndexOf = str.indexOf(37)) != -1) {
                str = str.substring(0, iIndexOf);
            }
            str = '[' + str + ']';
        }
        via.setHost(str);
        via.setPort(i);
        via.setTransport(str2);
        return via;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC21052t18 createWWWAuthenticateHeader(String str) {
        if (str == null) {
            throw new NullPointerException("null scheme");
        }
        WWWAuthenticate wWWAuthenticate = new WWWAuthenticate();
        wWWAuthenticate.setScheme(str);
        return wWWAuthenticate;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public Y38 createWarningHeader(String str, int i, String str2) throws ParseException, InvalidArgumentException {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        Warning warning = new Warning();
        warning.setAgent(str);
        warning.setCode(i);
        warning.setText(str2);
        return warning;
    }

    public void setPrettyEncoding(boolean z) {
        SIPHeaderList.setPrettyEncode(z);
    }

    public InterfaceC13453gF5 createRSeqHeader(long j) throws InvalidArgumentException {
        if (j >= 0) {
            RSeq rSeq = new RSeq();
            rSeq.setSeqNumber(j);
            return rSeq;
        }
        throw new InvalidArgumentException("invalid sequenceNumber arg " + j);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC7782Te1 createContactHeader() {
        Contact contact = new Contact();
        contact.setWildCardFlag(true);
        contact.setExpires(0);
        return contact;
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public InterfaceC12560ep0 createCSeqHeader(int i, String str) {
        return createCSeqHeader(i, str);
    }

    @Override // android.gov.nist.javax.sip.header.HeaderFactoryExt
    public ZE5 createRAckHeader(int i, int i2, String str) {
        return createRAckHeader(i, i2, str);
    }

    @Override // ir.nasim.LU2
    public HU2 createHeader(String str, String str2) {
        if (str != null) {
            return createHeader(str + ":" + str2);
        }
        throw new NullPointerException("header name is null");
    }
}
