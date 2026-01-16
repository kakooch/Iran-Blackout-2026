package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Fh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC4473Fh implements B.c {
    SuggestedPeerType_ONLY_CHANNELS(0),
    SuggestedPeerType_ALL_RANDOMIZED(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Fh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4473Fh a(int i) {
            return EnumC4473Fh.j(i);
        }
    };
    private final int a;

    EnumC4473Fh(int i) {
        this.a = i;
    }

    public static EnumC4473Fh j(int i) {
        if (i == 0) {
            return SuggestedPeerType_ONLY_CHANNELS;
        }
        if (i != 1) {
            return null;
        }
        return SuggestedPeerType_ALL_RANDOMIZED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
