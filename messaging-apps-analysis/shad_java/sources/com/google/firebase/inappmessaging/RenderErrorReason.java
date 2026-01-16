package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* loaded from: classes3.dex */
public enum RenderErrorReason implements Internal.EnumLite {
    UNSPECIFIED_RENDER_ERROR(0),
    IMAGE_FETCH_ERROR(1),
    IMAGE_DISPLAY_ERROR(2),
    IMAGE_UNSUPPORTED_FORMAT(3);

    private final int value;

    static {
        new Internal.EnumLiteMap<RenderErrorReason>() { // from class: com.google.firebase.inappmessaging.RenderErrorReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public RenderErrorReason findValueByNumber(int i) {
                return RenderErrorReason.forNumber(i);
            }
        };
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static RenderErrorReason forNumber(int i) {
        if (i == 0) {
            return UNSPECIFIED_RENDER_ERROR;
        }
        if (i == 1) {
            return IMAGE_FETCH_ERROR;
        }
        if (i == 2) {
            return IMAGE_DISPLAY_ERROR;
        }
        if (i != 3) {
            return null;
        }
        return IMAGE_UNSUPPORTED_FORMAT;
    }

    RenderErrorReason(int i) {
        this.value = i;
    }
}
