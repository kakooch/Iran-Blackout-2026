package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.gV6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC13598gV6 implements B.c {
    WidgetType_Unknown(0),
    WidgetType_Link(1),
    WidgetType_Poll(2),
    WidgetType_Post(3),
    WidgetType_ReStory(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.gV6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13598gV6 a(int i2) {
            return EnumC13598gV6.j(i2);
        }
    };
    private final int a;

    EnumC13598gV6(int i2) {
        this.a = i2;
    }

    public static EnumC13598gV6 j(int i2) {
        if (i2 == 0) {
            return WidgetType_Unknown;
        }
        if (i2 == 1) {
            return WidgetType_Link;
        }
        if (i2 == 2) {
            return WidgetType_Poll;
        }
        if (i2 == 3) {
            return WidgetType_Post;
        }
        if (i2 != 4) {
            return null;
        }
        return WidgetType_ReStory;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
