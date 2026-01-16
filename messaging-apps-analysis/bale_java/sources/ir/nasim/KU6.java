package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes.dex */
public enum KU6 implements B.c {
    StoryExpirationType_OneDay(0),
    StoryExpirationType_TwoDays(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.KU6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KU6 a(int i) {
            return KU6.j(i);
        }
    };
    private final int a;

    KU6(int i) {
        this.a = i;
    }

    public static KU6 j(int i) {
        if (i == 0) {
            return StoryExpirationType_OneDay;
        }
        if (i != 1) {
            return null;
        }
        return StoryExpirationType_TwoDays;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
