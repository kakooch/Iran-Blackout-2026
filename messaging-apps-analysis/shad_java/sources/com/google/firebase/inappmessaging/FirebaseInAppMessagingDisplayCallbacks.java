package com.google.firebase.inappmessaging;

/* loaded from: classes3.dex */
public interface FirebaseInAppMessagingDisplayCallbacks {

    public enum InAppMessagingDismissType {
        UNKNOWN_DISMISS_TYPE,
        AUTO,
        CLICK,
        SWIPE
    }

    public enum InAppMessagingErrorReason {
        UNSPECIFIED_RENDER_ERROR,
        IMAGE_FETCH_ERROR,
        IMAGE_DISPLAY_ERROR,
        IMAGE_UNSUPPORTED_FORMAT
    }
}
