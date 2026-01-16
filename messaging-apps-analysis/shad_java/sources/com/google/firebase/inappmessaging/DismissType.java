package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* loaded from: classes3.dex */
public enum DismissType implements Internal.EnumLite {
    UNKNOWN_DISMISS_TYPE(0),
    AUTO(1),
    CLICK(2),
    SWIPE(3);

    private final int value;

    static {
        new Internal.EnumLiteMap<DismissType>() { // from class: com.google.firebase.inappmessaging.DismissType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public DismissType findValueByNumber(int i) {
                return DismissType.forNumber(i);
            }
        };
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static DismissType forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_DISMISS_TYPE;
        }
        if (i == 1) {
            return AUTO;
        }
        if (i == 2) {
            return CLICK;
        }
        if (i != 3) {
            return null;
        }
        return SWIPE;
    }

    DismissType(int i) {
        this.value = i;
    }
}
