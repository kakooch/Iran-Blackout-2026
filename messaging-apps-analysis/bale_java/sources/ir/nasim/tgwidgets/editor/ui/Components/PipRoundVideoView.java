package ir.nasim.tgwidgets.editor.ui.Components;

import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.nasim.tgwidgets.editor.messenger.E;

/* loaded from: classes7.dex */
public class PipRoundVideoView implements E.d {
    private FrameLayout a;
    private AspectRatioFrameLayout b;
    private WindowManager.LayoutParams c;
    private WindowManager d;

    @Keep
    public int getX() {
        return this.c.x;
    }

    @Keep
    public int getY() {
        return this.c.y;
    }

    @Keep
    public void setX(int i) {
        WindowManager.LayoutParams layoutParams = this.c;
        layoutParams.x = i;
        try {
            this.d.updateViewLayout(this.a, layoutParams);
        } catch (Exception unused) {
        }
    }

    @Keep
    public void setY(int i) {
        WindowManager.LayoutParams layoutParams = this.c;
        layoutParams.y = i;
        try {
            this.d.updateViewLayout(this.a, layoutParams);
        } catch (Exception unused) {
        }
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        AspectRatioFrameLayout aspectRatioFrameLayout;
        if (i != ir.nasim.tgwidgets.editor.messenger.E.S1 || (aspectRatioFrameLayout = this.b) == null) {
            return;
        }
        aspectRatioFrameLayout.invalidate();
    }
}
