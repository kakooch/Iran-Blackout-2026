package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class UI_rubinoColorPickerCell {
    public ColorPickerCellFrameLayout frameLayout;
    public View view;

    public View createView(Activity activity) {
        ColorPickerCellFrameLayout colorPickerCellFrameLayout = new ColorPickerCellFrameLayout(this, activity);
        this.frameLayout = colorPickerCellFrameLayout;
        this.view = colorPickerCellFrameLayout;
        colorPickerCellFrameLayout.setTag(this);
        return this.view;
    }

    public void setColor(int i) {
        ColorPickerCellFrameLayout colorPickerCellFrameLayout = this.frameLayout;
        colorPickerCellFrameLayout.isDropper = false;
        colorPickerCellFrameLayout.setColor(i);
    }

    public void setDropper(int i) {
        this.frameLayout.isDropper = true;
        if (i == -1 || Color.red(i) + Color.green(i) + Color.blue(i) > 510) {
            this.frameLayout.dropperImage.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        } else {
            this.frameLayout.dropperImage.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        this.frameLayout.setColor(i);
    }

    private class ColorPickerCellFrameLayout extends FrameLayout {
        int color;
        Drawable dropperImage;
        boolean isDropper;
        Paint paint;
        Paint paint2;

        public ColorPickerCellFrameLayout(UI_rubinoColorPickerCell uI_rubinoColorPickerCell, Context context) {
            super(context);
            this.paint = new Paint(1);
            this.paint2 = new Paint(1);
            setWillNotDraw(false);
            this.paint.setColor(-1);
            this.paint2.setColor(-1);
            this.dropperImage = context.getResources().getDrawable(R.drawable.story_eyedropper);
        }

        public void setColor(int i) {
            this.color = i;
            this.paint2.setColor(i);
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int i = this.isDropper ? 3 : 6;
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(i), this.paint);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(i + 1), this.paint2);
            if (this.isDropper) {
                this.dropperImage.setBounds(8, 8, getMeasuredWidth() - 12, getMeasuredHeight() - 12);
                this.dropperImage.draw(canvas);
            }
        }
    }

    public int getColor() {
        return this.frameLayout.color;
    }
}
