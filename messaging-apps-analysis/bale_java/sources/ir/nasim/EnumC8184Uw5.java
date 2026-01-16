package ir.nasim;

import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* renamed from: ir.nasim.Uw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC8184Uw5 implements i.a {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);

    private static i.b f = new i.b() { // from class: ir.nasim.Uw5.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8184Uw5 a(int i) {
            return EnumC8184Uw5.a(i);
        }
    };
    private final int a;

    EnumC8184Uw5(int i, int i2) {
        this.a = i2;
    }

    public static EnumC8184Uw5 a(int i) {
        if (i == 0) {
            return DECLARATION;
        }
        if (i == 1) {
            return FAKE_OVERRIDE;
        }
        if (i == 2) {
            return DELEGATION;
        }
        if (i != 3) {
            return null;
        }
        return SYNTHESIZED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
    public final int getNumber() {
        return this.a;
    }
}
