package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* loaded from: classes3.dex */
public enum CommonTypesProto$Trigger implements Internal.EnumLite {
    UNKNOWN_TRIGGER(0),
    APP_LAUNCH(1),
    ON_FOREGROUND(2),
    UNRECOGNIZED(-1);

    private final int value;

    static {
        new Internal.EnumLiteMap<CommonTypesProto$Trigger>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto$Trigger.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CommonTypesProto$Trigger findValueByNumber(int i) {
                return CommonTypesProto$Trigger.forNumber(i);
            }
        };
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    public static CommonTypesProto$Trigger forNumber(int i) {
        if (i == 0) {
            return UNKNOWN_TRIGGER;
        }
        if (i == 1) {
            return APP_LAUNCH;
        }
        if (i != 2) {
            return null;
        }
        return ON_FOREGROUND;
    }

    CommonTypesProto$Trigger(int i) {
        this.value = i;
    }
}
