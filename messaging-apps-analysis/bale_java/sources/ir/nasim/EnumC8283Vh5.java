package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Vh5, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8283Vh5 implements B.c {
    PollType_SINGLECHOICE(0),
    PollType_MULTIPLECHOICE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Vh5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8283Vh5 a(int i) {
            return EnumC8283Vh5.j(i);
        }
    };
    private final int a;

    EnumC8283Vh5(int i) {
        this.a = i;
    }

    public static EnumC8283Vh5 j(int i) {
        if (i == 0) {
            return PollType_SINGLECHOICE;
        }
        if (i != 1) {
            return null;
        }
        return PollType_MULTIPLECHOICE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
