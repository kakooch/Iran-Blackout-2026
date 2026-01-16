package ir.nasim;

import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.Vw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC8418Vw5 implements i.a {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);

    private static i.b f = new i.b() { // from class: ir.nasim.Vw5.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8418Vw5 a(int i) {
            return EnumC8418Vw5.a(i);
        }
    };
    private final int a;

    EnumC8418Vw5(int i, int i2) {
        this.a = i2;
    }

    public static EnumC8418Vw5 a(int i) {
        if (i == 0) {
            return FINAL;
        }
        if (i == 1) {
            return OPEN;
        }
        if (i == 2) {
            return ABSTRACT;
        }
        if (i != 3) {
            return null;
        }
        return SEALED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
    public final int getNumber() {
        return this.a;
    }
}
