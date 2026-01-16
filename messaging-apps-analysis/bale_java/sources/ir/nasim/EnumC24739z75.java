package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.z75, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC24739z75 implements B.c {
    PfmTransactionShreddingType_UNKNOWN(0),
    PfmTransactionShreddingType_MAIN_TRANSACTION(1),
    PfmTransactionShreddingType_SHARD(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.z75.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24739z75 a(int i) {
            return EnumC24739z75.j(i);
        }
    };
    private final int a;

    EnumC24739z75(int i) {
        this.a = i;
    }

    public static EnumC24739z75 j(int i) {
        if (i == 0) {
            return PfmTransactionShreddingType_UNKNOWN;
        }
        if (i == 1) {
            return PfmTransactionShreddingType_MAIN_TRANSACTION;
        }
        if (i != 2) {
            return null;
        }
        return PfmTransactionShreddingType_SHARD;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
