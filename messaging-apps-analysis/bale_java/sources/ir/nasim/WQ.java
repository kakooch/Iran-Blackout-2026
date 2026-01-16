package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum WQ implements B.c {
    AuthSendCodeType_UNKNOWN(0),
    AuthSendCodeType_DEFAULT(1),
    AuthSendCodeType_BALEONLY(2),
    AuthSendCodeType_SMS(3),
    AuthSendCodeType_CALL(4),
    AuthSendCodeType_EMAIL(5),
    AuthSendCodeType_MISSCALL(6),
    AuthSendCodeType_SETUP_EMAIL_REQUIRED(7),
    AuthSendCodeType_WHATSAPP(8),
    AuthSendCodeType_TELEGRAM(9),
    AuthSendCodeType_USSD(10),
    AuthSendCodeType_FUTURE_AUTH_TOKEN(11),
    AuthSendCodeType_TELEGRAM_GATEWAY(12),
    UNRECOGNIZED(-1);

    private static final B.d p = new B.d() { // from class: ir.nasim.WQ.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WQ a(int i) {
            return WQ.j(i);
        }
    };
    private final int a;

    WQ(int i) {
        this.a = i;
    }

    public static WQ j(int i) {
        switch (i) {
            case 0:
                return AuthSendCodeType_UNKNOWN;
            case 1:
                return AuthSendCodeType_DEFAULT;
            case 2:
                return AuthSendCodeType_BALEONLY;
            case 3:
                return AuthSendCodeType_SMS;
            case 4:
                return AuthSendCodeType_CALL;
            case 5:
                return AuthSendCodeType_EMAIL;
            case 6:
                return AuthSendCodeType_MISSCALL;
            case 7:
                return AuthSendCodeType_SETUP_EMAIL_REQUIRED;
            case 8:
                return AuthSendCodeType_WHATSAPP;
            case 9:
                return AuthSendCodeType_TELEGRAM;
            case 10:
                return AuthSendCodeType_USSD;
            case 11:
                return AuthSendCodeType_FUTURE_AUTH_TOKEN;
            case 12:
                return AuthSendCodeType_TELEGRAM_GATEWAY;
            default:
                return null;
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
