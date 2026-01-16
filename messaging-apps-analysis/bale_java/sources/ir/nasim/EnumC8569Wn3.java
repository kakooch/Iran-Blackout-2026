package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Wn3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8569Wn3 implements B.c {
    PaymentFinalStatus_Unknown(0),
    PaymentFinalStatus_Success(1),
    PaymentFinalStatus_Fail(2),
    PaymentFinalStatus_BotRejected(3),
    PaymentFinalStatus_BotVerificationTimeOut(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.Wn3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8569Wn3 a(int i2) {
            return EnumC8569Wn3.j(i2);
        }
    };
    private final int a;

    EnumC8569Wn3(int i2) {
        this.a = i2;
    }

    public static EnumC8569Wn3 j(int i2) {
        if (i2 == 0) {
            return PaymentFinalStatus_Unknown;
        }
        if (i2 == 1) {
            return PaymentFinalStatus_Success;
        }
        if (i2 == 2) {
            return PaymentFinalStatus_Fail;
        }
        if (i2 == 3) {
            return PaymentFinalStatus_BotRejected;
        }
        if (i2 != 4) {
            return null;
        }
        return PaymentFinalStatus_BotVerificationTimeOut;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
