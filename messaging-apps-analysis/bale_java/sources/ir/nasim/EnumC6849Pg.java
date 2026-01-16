package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Pg, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC6849Pg implements B.c {
    ContentType_NOADS(0),
    ContentType_ADLIST(1),
    ContentType_YEKTANETTOKEN(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Pg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6849Pg a(int i) {
            return EnumC6849Pg.j(i);
        }
    };
    private final int a;

    EnumC6849Pg(int i) {
        this.a = i;
    }

    public static EnumC6849Pg j(int i) {
        if (i == 0) {
            return ContentType_NOADS;
        }
        if (i == 1) {
            return ContentType_ADLIST;
        }
        if (i != 2) {
            return null;
        }
        return ContentType_YEKTANETTOKEN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
