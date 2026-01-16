package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.mM7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC17082mM7 implements B.c {
    ContactType_PHONE(0),
    ContactType_EMAIL(1),
    ContactType_WEB(2),
    ContactType_SOCIAL(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.mM7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17082mM7 a(int i) {
            return EnumC17082mM7.j(i);
        }
    };
    private final int a;

    EnumC17082mM7(int i) {
        this.a = i;
    }

    public static EnumC17082mM7 j(int i) {
        if (i == 0) {
            return ContactType_PHONE;
        }
        if (i == 1) {
            return ContactType_EMAIL;
        }
        if (i == 2) {
            return ContactType_WEB;
        }
        if (i != 3) {
            return null;
        }
        return ContactType_SOCIAL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
