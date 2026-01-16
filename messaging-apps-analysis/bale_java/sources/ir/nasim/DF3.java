package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import com.google.protobuf.B;
import okhttp3.internal.http.StatusLine;

/* loaded from: classes8.dex */
public enum DF3 implements B.c {
    SIP_STATUS_UNKNOWN(0),
    SIP_STATUS_TRYING(100),
    SIP_STATUS_RINGING(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER),
    SIP_STATUS_CALL_IS_FORWARDED(SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER),
    SIP_STATUS_QUEUED(182),
    SIP_STATUS_SESSION_PROGRESS(183),
    SIP_STATUS_OK(200),
    SIP_STATUS_ACCEPTED(202),
    SIP_STATUS_MOVED_PERMANENTLY(301),
    SIP_STATUS_MOVED_TEMPORARILY(302),
    SIP_STATUS_USE_PROXY(305),
    SIP_STATUS_BAD_REQUEST(400),
    SIP_STATUS_UNAUTHORIZED(401),
    SIP_STATUS_PAYMENT_REQUIRED(402),
    SIP_STATUS_FORBIDDEN(403),
    SIP_STATUS_NOTFOUND(404),
    SIP_STATUS_METHOD_NOT_ALLOWED(405),
    SIP_STATUS_NOT_ACCEPTABLE(406),
    SIP_STATUS_PROXY_AUTH_REQUIRED(407),
    SIP_STATUS_REQUEST_TIMEOUT(408),
    SIP_STATUS_CONFLICT(409),
    SIP_STATUS_GONE(410),
    SIP_STATUS_REQUEST_ENTITY_TOO_LARGE(413),
    SIP_STATUS_REQUEST_URI_TOO_LONG(414),
    SIP_STATUS_UNSUPPORTED_MEDIA_TYPE(415),
    SIP_STATUS_REQUESTED_RANGE_NOT_SATISFIABLE(416),
    SIP_STATUS_BAD_EXTENSION(420),
    SIP_STATUS_EXTENSION_REQUIRED(StatusLine.HTTP_MISDIRECTED_REQUEST),
    SIP_STATUS_INTERVAL_TOO_BRIEF(423),
    SIP_STATUS_TEMPORARILY_UNAVAILABLE(480),
    SIP_STATUS_CALL_TRANSACTION_DOES_NOT_EXISTS(481),
    SIP_STATUS_LOOP_DETECTED(482),
    SIP_STATUS_TOO_MANY_HOPS(483),
    SIP_STATUS_ADDRESS_INCOMPLETE(484),
    SIP_STATUS_AMBIGUOUS(485),
    SIP_STATUS_BUSY_HERE(486),
    SIP_STATUS_REQUEST_TERMINATED(487),
    SIP_STATUS_NOT_ACCEPTABLE_HERE(488),
    SIP_STATUS_INTERNAL_SERVER_ERROR(SIPTransactionStack.BASE_TIMER_INTERVAL),
    SIP_STATUS_NOT_IMPLEMENTED(501),
    SIP_STATUS_BAD_GATEWAY(502),
    SIP_STATUS_SERVICE_UNAVAILABLE(503),
    SIP_STATUS_GATEWAY_TIMEOUT(504),
    SIP_STATUS_VERSION_NOT_SUPPORTED(505),
    SIP_STATUS_MESSAGE_TOO_LARGE(513),
    SIP_STATUS_GLOBAL_BUSY_EVERYWHERE(SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER),
    SIP_STATUS_GLOBAL_DECLINE(603),
    SIP_STATUS_GLOBAL_DOES_NOT_EXIST_ANYWHERE(604),
    SIP_STATUS_GLOBAL_NOT_ACCEPTABLE(606),
    UNRECOGNIZED(-1);

    private static final B.d Q0 = new B.d() { // from class: ir.nasim.DF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DF3 a(int i) {
            return DF3.j(i);
        }
    };
    private final int a;

    DF3(int i) {
        this.a = i;
    }

    public static DF3 j(int i) {
        if (i == 0) {
            return SIP_STATUS_UNKNOWN;
        }
        if (i == 100) {
            return SIP_STATUS_TRYING;
        }
        if (i == 200) {
            return SIP_STATUS_OK;
        }
        if (i == 202) {
            return SIP_STATUS_ACCEPTED;
        }
        if (i == 305) {
            return SIP_STATUS_USE_PROXY;
        }
        if (i == 423) {
            return SIP_STATUS_INTERVAL_TOO_BRIEF;
        }
        if (i == 513) {
            return SIP_STATUS_MESSAGE_TOO_LARGE;
        }
        if (i == 600) {
            return SIP_STATUS_GLOBAL_BUSY_EVERYWHERE;
        }
        if (i == 606) {
            return SIP_STATUS_GLOBAL_NOT_ACCEPTABLE;
        }
        if (i == 301) {
            return SIP_STATUS_MOVED_PERMANENTLY;
        }
        if (i == 302) {
            return SIP_STATUS_MOVED_TEMPORARILY;
        }
        if (i == 420) {
            return SIP_STATUS_BAD_EXTENSION;
        }
        if (i == 421) {
            return SIP_STATUS_EXTENSION_REQUIRED;
        }
        if (i == 603) {
            return SIP_STATUS_GLOBAL_DECLINE;
        }
        if (i == 604) {
            return SIP_STATUS_GLOBAL_DOES_NOT_EXIST_ANYWHERE;
        }
        switch (i) {
            case SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER /* 180 */:
                return SIP_STATUS_RINGING;
            case SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER /* 181 */:
                return SIP_STATUS_CALL_IS_FORWARDED;
            case 182:
                return SIP_STATUS_QUEUED;
            case 183:
                return SIP_STATUS_SESSION_PROGRESS;
            default:
                switch (i) {
                    case 400:
                        return SIP_STATUS_BAD_REQUEST;
                    case 401:
                        return SIP_STATUS_UNAUTHORIZED;
                    case 402:
                        return SIP_STATUS_PAYMENT_REQUIRED;
                    case 403:
                        return SIP_STATUS_FORBIDDEN;
                    case 404:
                        return SIP_STATUS_NOTFOUND;
                    case 405:
                        return SIP_STATUS_METHOD_NOT_ALLOWED;
                    case 406:
                        return SIP_STATUS_NOT_ACCEPTABLE;
                    case 407:
                        return SIP_STATUS_PROXY_AUTH_REQUIRED;
                    case 408:
                        return SIP_STATUS_REQUEST_TIMEOUT;
                    case 409:
                        return SIP_STATUS_CONFLICT;
                    case 410:
                        return SIP_STATUS_GONE;
                    default:
                        switch (i) {
                            case 413:
                                return SIP_STATUS_REQUEST_ENTITY_TOO_LARGE;
                            case 414:
                                return SIP_STATUS_REQUEST_URI_TOO_LONG;
                            case 415:
                                return SIP_STATUS_UNSUPPORTED_MEDIA_TYPE;
                            case 416:
                                return SIP_STATUS_REQUESTED_RANGE_NOT_SATISFIABLE;
                            default:
                                switch (i) {
                                    case 480:
                                        return SIP_STATUS_TEMPORARILY_UNAVAILABLE;
                                    case 481:
                                        return SIP_STATUS_CALL_TRANSACTION_DOES_NOT_EXISTS;
                                    case 482:
                                        return SIP_STATUS_LOOP_DETECTED;
                                    case 483:
                                        return SIP_STATUS_TOO_MANY_HOPS;
                                    case 484:
                                        return SIP_STATUS_ADDRESS_INCOMPLETE;
                                    case 485:
                                        return SIP_STATUS_AMBIGUOUS;
                                    case 486:
                                        return SIP_STATUS_BUSY_HERE;
                                    case 487:
                                        return SIP_STATUS_REQUEST_TERMINATED;
                                    case 488:
                                        return SIP_STATUS_NOT_ACCEPTABLE_HERE;
                                    default:
                                        switch (i) {
                                            case SIPTransactionStack.BASE_TIMER_INTERVAL /* 500 */:
                                                return SIP_STATUS_INTERNAL_SERVER_ERROR;
                                            case 501:
                                                return SIP_STATUS_NOT_IMPLEMENTED;
                                            case 502:
                                                return SIP_STATUS_BAD_GATEWAY;
                                            case 503:
                                                return SIP_STATUS_SERVICE_UNAVAILABLE;
                                            case 504:
                                                return SIP_STATUS_GATEWAY_TIMEOUT;
                                            case 505:
                                                return SIP_STATUS_VERSION_NOT_SUPPORTED;
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
