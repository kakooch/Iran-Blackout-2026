package org.rbmain.ui.Components;

import org.rbmain.messenger.ImageReceiver;

/* loaded from: classes5.dex */
public interface AttachableDrawable {
    void onAttachedToWindow(ImageReceiver imageReceiver);

    void onDetachedFromWindow(ImageReceiver imageReceiver);
}
