package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.cR, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC10921cR implements B.c {
    StartPhoneAuthOptions_SUPPORT_TELEGRAM_GATEWAY(0),
    StartPhoneAuthOptions_SIX_DIGIT_OTP(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.cR.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10921cR a(int i) {
            return EnumC10921cR.j(i);
        }
    };
    private final int a;

    EnumC10921cR(int i) {
        this.a = i;
    }

    public static EnumC10921cR j(int i) {
        if (i == 0) {
            return StartPhoneAuthOptions_SUPPORT_TELEGRAM_GATEWAY;
        }
        if (i != 1) {
            return null;
        }
        return StartPhoneAuthOptions_SIX_DIGIT_OTP;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
