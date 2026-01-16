package ir.nasim;

import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.ix5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC15071ix5 implements i.a {
    INTERNAL(0, 0),
    PRIVATE(1, 1),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);

    private static i.b h = new i.b() { // from class: ir.nasim.ix5.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC15071ix5 a(int i2) {
            return EnumC15071ix5.a(i2);
        }
    };
    private final int a;

    EnumC15071ix5(int i2, int i3) {
        this.a = i3;
    }

    public static EnumC15071ix5 a(int i2) {
        if (i2 == 0) {
            return INTERNAL;
        }
        if (i2 == 1) {
            return PRIVATE;
        }
        if (i2 == 2) {
            return PROTECTED;
        }
        if (i2 == 3) {
            return PUBLIC;
        }
        if (i2 == 4) {
            return PRIVATE_TO_THIS;
        }
        if (i2 != 5) {
            return null;
        }
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
    public final int getNumber() {
        return this.a;
    }
}
