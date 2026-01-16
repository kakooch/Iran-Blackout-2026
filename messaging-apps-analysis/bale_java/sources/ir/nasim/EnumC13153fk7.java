package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.fk7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC13153fk7 implements B.c {
    TaskUserType_UNKNOWN(0),
    TaskUserType_ARBAEEN(1),
    TaskUserType_OLD(2),
    TaskUserType_NEW(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.fk7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13153fk7 a(int i) {
            return EnumC13153fk7.j(i);
        }
    };
    private final int a;

    EnumC13153fk7(int i) {
        this.a = i;
    }

    public static EnumC13153fk7 j(int i) {
        if (i == 0) {
            return TaskUserType_UNKNOWN;
        }
        if (i == 1) {
            return TaskUserType_ARBAEEN;
        }
        if (i == 2) {
            return TaskUserType_OLD;
        }
        if (i != 3) {
            return null;
        }
        return TaskUserType_NEW;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
