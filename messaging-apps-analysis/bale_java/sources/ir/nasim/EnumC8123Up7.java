package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Up7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC8123Up7 implements B.c {
    Unknown(0),
    Chat(1),
    MiniApp(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Up7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8123Up7 a(int i) {
            return EnumC8123Up7.j(i);
        }
    };
    private final int a;

    EnumC8123Up7(int i) {
        this.a = i;
    }

    public static EnumC8123Up7 j(int i) {
        if (i == 0) {
            return Unknown;
        }
        if (i == 1) {
            return Chat;
        }
        if (i != 2) {
            return null;
        }
        return MiniApp;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
