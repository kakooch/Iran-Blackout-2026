package org.rbmain.ui.Components.Premium;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;
import org.rbmain.messenger.ImageReceiver;

/* loaded from: classes5.dex */
public class PremiumLockIconView extends ImageView {
    public static int TYPE_REACTIONS = 0;
    public static int TYPE_STICKERS_PREMIUM_LOCKED = 1;

    public PremiumLockIconView(Context context) {
        super(context);
        new Path();
        new Paint(1);
    }

    public PremiumLockIconView(Context context, int i) {
        this(context);
    }

    public void setImageReceiver(ImageReceiver imageReceiver) {
        if (imageReceiver != null) {
            invalidate();
        }
    }
}
