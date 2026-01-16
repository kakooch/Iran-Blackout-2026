package ir.eitaa.ui.Components;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public abstract class StatusDrawable extends Drawable {
    public abstract void setColor(int color);

    public abstract void setIsChat(boolean value);

    public abstract void start();

    public abstract void stop();
}
