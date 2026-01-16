package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.rB1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC19932rB1 {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(InterfaceC12683f16.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final Class a;

    EnumC19932rB1(Class cls) {
        this.a = cls;
    }
}
