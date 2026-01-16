package android.gov.nist.javax.sip.header;

import android.gov.nist.javax.sip.header.extensions.JoinHeader;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import android.gov.nist.javax.sip.header.extensions.ReferredByHeader;
import android.gov.nist.javax.sip.header.extensions.ReplacesHeader;
import android.gov.nist.javax.sip.header.extensions.SessionExpiresHeader;
import android.gov.nist.javax.sip.header.ims.PAccessNetworkInfoHeader;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentityHeader;
import android.gov.nist.javax.sip.header.ims.PAssertedServiceHeader;
import android.gov.nist.javax.sip.header.ims.PAssociatedURIHeader;
import android.gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;
import android.gov.nist.javax.sip.header.ims.PChargingFunctionAddressesHeader;
import android.gov.nist.javax.sip.header.ims.PChargingVectorHeader;
import android.gov.nist.javax.sip.header.ims.PMediaAuthorizationHeader;
import android.gov.nist.javax.sip.header.ims.PPreferredIdentityHeader;
import android.gov.nist.javax.sip.header.ims.PPreferredServiceHeader;
import android.gov.nist.javax.sip.header.ims.PProfileKeyHeader;
import android.gov.nist.javax.sip.header.ims.PServedUserHeader;
import android.gov.nist.javax.sip.header.ims.PUserDatabaseHeader;
import android.gov.nist.javax.sip.header.ims.PVisitedNetworkIDHeader;
import android.gov.nist.javax.sip.header.ims.PathHeader;
import android.gov.nist.javax.sip.header.ims.PrivacyHeader;
import android.gov.nist.javax.sip.header.ims.SecurityClientHeader;
import android.gov.nist.javax.sip.header.ims.SecurityServerHeader;
import android.gov.nist.javax.sip.header.ims.SecurityVerifyHeader;
import android.gov.nist.javax.sip.header.ims.ServiceRouteHeader;
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
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public interface HeaderFactoryExt extends LU2 {
    /* synthetic */ InterfaceC18659p2 createAcceptEncodingHeader(String str);

    /* synthetic */ InterfaceC19250q2 createAcceptHeader(String str, String str2);

    /* synthetic */ InterfaceC19841r2 createAcceptLanguageHeader(Locale locale);

    /* synthetic */ InterfaceC9088Yl createAlertInfoHeader(InterfaceC21815uA7 interfaceC21815uA7);

    /* synthetic */ InterfaceC20293rm createAllowEventsHeader(String str);

    /* synthetic */ InterfaceC20884sm createAllowHeader(String str);

    /* synthetic */ InterfaceC17119mR createAuthenticationInfoHeader(String str);

    @Override // ir.nasim.LU2
    /* synthetic */ VR createAuthorizationHeader(String str);

    /* synthetic */ InterfaceC12560ep0 createCSeqHeader(int i, String str);

    /* synthetic */ InterfaceC12560ep0 createCSeqHeader(long j, String str);

    /* synthetic */ InterfaceC21662tv0 createCallIdHeader(String str);

    /* synthetic */ InterfaceC22252uv0 createCallInfoHeader(InterfaceC21815uA7 interfaceC21815uA7);

    PChargingVectorHeader createChargingVectorHeader(String str);

    /* synthetic */ InterfaceC7782Te1 createContactHeader();

    /* synthetic */ InterfaceC7782Te1 createContactHeader(InterfaceC16609la interfaceC16609la);

    /* synthetic */ InterfaceC23329wk1 createContentDispositionHeader(String str);

    /* synthetic */ InterfaceC24509yk1 createContentEncodingHeader(String str);

    /* synthetic */ InterfaceC7365Rk1 createContentLanguageHeader(Locale locale);

    /* synthetic */ InterfaceC7599Sk1 createContentLengthHeader(int i);

    /* synthetic */ InterfaceC19085pl1 createContentTypeHeader(String str, String str2);

    /* synthetic */ InterfaceC15786kA1 createDateHeader(Calendar calendar);

    /* synthetic */ Z92 createErrorInfoHeader(InterfaceC21815uA7 interfaceC21815uA7);

    /* synthetic */ InterfaceC7510Sa2 createEventHeader(String str);

    /* synthetic */ InterfaceC21427te2 createExpiresHeader(int i);

    /* synthetic */ InterfaceC17560nA2 createFromHeader(InterfaceC16609la interfaceC16609la, String str);

    HU2 createHeader(String str);

    @Override // ir.nasim.LU2
    /* synthetic */ HU2 createHeader(String str, String str2);

    /* synthetic */ List createHeaders(String str);

    /* synthetic */ InterfaceC20484s53 createInReplyToHeader(String str);

    JoinHeader createJoinHeader(String str, String str2, String str3);

    /* synthetic */ VV3 createMaxForwardsHeader(int i);

    /* synthetic */ InterfaceC3285Af4 createMimeVersionHeader(int i, int i2);

    /* synthetic */ InterfaceC3524Bf4 createMinExpiresHeader(int i);

    /* synthetic */ InterfaceC16488lM4 createOrganizationHeader(String str);

    PAccessNetworkInfoHeader createPAccessNetworkInfoHeader();

    PAssertedIdentityHeader createPAssertedIdentityHeader(InterfaceC16609la interfaceC16609la);

    PAssertedServiceHeader createPAssertedServiceHeader();

    PAssociatedURIHeader createPAssociatedURIHeader(InterfaceC16609la interfaceC16609la);

    PCalledPartyIDHeader createPCalledPartyIDHeader(InterfaceC16609la interfaceC16609la);

    PChargingFunctionAddressesHeader createPChargingFunctionAddressesHeader();

    PMediaAuthorizationHeader createPMediaAuthorizationHeader(String str);

    PPreferredIdentityHeader createPPreferredIdentityHeader(InterfaceC16609la interfaceC16609la);

    PPreferredServiceHeader createPPreferredServiceHeader();

    PProfileKeyHeader createPProfileKeyHeader(InterfaceC16609la interfaceC16609la);

    PServedUserHeader createPServedUserHeader(InterfaceC16609la interfaceC16609la);

    PUserDatabaseHeader createPUserDatabaseHeader(String str);

    PVisitedNetworkIDHeader createPVisitedNetworkIDHeader();

    PathHeader createPathHeader(InterfaceC16609la interfaceC16609la);

    /* synthetic */ InterfaceC6711Oq5 createPriorityHeader(String str);

    PrivacyHeader createPrivacyHeader(String str);

    @Override // ir.nasim.LU2
    /* synthetic */ InterfaceC9436Zx5 createProxyAuthenticateHeader(String str);

    @Override // ir.nasim.LU2
    /* synthetic */ InterfaceC10039ay5 createProxyAuthorizationHeader(String str);

    /* synthetic */ InterfaceC12062dy5 createProxyRequireHeader(String str);

    /* synthetic */ ZE5 createRAckHeader(int i, int i2, String str);

    /* synthetic */ InterfaceC13453gF5 createRSeqHeader(int i);

    /* synthetic */ JI5 createReasonHeader(String str, int i, String str2);

    /* synthetic */ InterfaceC9654aK5 createRecordRouteHeader(InterfaceC16609la interfaceC16609la);

    /* synthetic */ InterfaceC14098hL5 createReferToHeader(InterfaceC16609la interfaceC16609la);

    ReferencesHeader createReferencesHeader(String str, String str2);

    ReferredByHeader createReferredByHeader(InterfaceC16609la interfaceC16609la);

    ReplacesHeader createReplacesHeader(String str, String str2, String str3);

    /* synthetic */ InterfaceC13543gP5 createReplyToHeader(InterfaceC16609la interfaceC16609la);

    SipRequestLine createRequestLine(String str);

    /* synthetic */ InterfaceC18352oW5 createRequireHeader(String str);

    /* synthetic */ InterfaceC19838r16 createRetryAfterHeader(int i);

    /* synthetic */ V46 createRouteHeader(InterfaceC16609la interfaceC16609la);

    /* synthetic */ K76 createSIPETagHeader(String str);

    /* synthetic */ L76 createSIPIfMatchHeader(String str);

    SecurityClientHeader createSecurityClientHeader();

    SecurityServerHeader createSecurityServerHeader();

    SecurityVerifyHeader createSecurityVerifyHeader();

    /* synthetic */ InterfaceC5044Hq6 createServerHeader(List list);

    ServiceRouteHeader createServiceRouteHeader(InterfaceC16609la interfaceC16609la);

    SessionExpiresHeader createSessionExpiresHeader(int i);

    SipStatusLine createStatusLine(String str);

    /* synthetic */ YZ6 createSubjectHeader(String str);

    /* synthetic */ InterfaceC19238q07 createSubscriptionStateHeader(String str);

    /* synthetic */ InterfaceC15712k27 createSupportedHeader(String str);

    /* synthetic */ InterfaceC16186kq7 createTimeStampHeader(float f);

    /* synthetic */ InterfaceC18560or7 createToHeader(InterfaceC16609la interfaceC16609la, String str);

    /* synthetic */ InterfaceC12201eC7 createUnsupportedHeader(String str);

    /* synthetic */ InterfaceC18819pI7 createUserAgentHeader(List list);

    /* synthetic */ InterfaceC18318oS7 createViaHeader(String str, int i, String str2, String str3);

    /* synthetic */ InterfaceC21052t18 createWWWAuthenticateHeader(String str);

    /* synthetic */ Y38 createWarningHeader(String str, int i, String str2);
}
