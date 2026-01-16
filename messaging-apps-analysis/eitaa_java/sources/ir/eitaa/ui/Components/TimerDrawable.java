package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class TimerDrawable extends Drawable {
    private StaticLayout timeLayout;
    private TextPaint timePaint = new TextPaint(1);
    private Paint paint = new Paint(1);
    private Paint linePaint = new Paint(1);
    private float timeWidth = 0.0f;
    private int timeHeight = 0;
    private int time = 0;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public TimerDrawable(Context context) {
        this.timePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.timePaint.setTextSize(AndroidUtilities.dp(11.0f));
        this.linePaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        this.linePaint.setStyle(Paint.Style.STROKE);
    }

    public void setTime(int value) {
        String str;
        this.time = value;
        if (value >= 1 && value < 60) {
            str = "" + value;
            if (str.length() < 2) {
                str = str + LocaleController.getString("SecretChatTimerSeconds", R.string.SecretChatTimerSeconds);
            }
        } else if (value >= 60 && value < 3600) {
            str = "" + (value / 60);
            if (str.length() < 2) {
                str = str + LocaleController.getString("SecretChatTimerMinutes", R.string.SecretChatTimerMinutes);
            }
        } else if (value >= 3600 && value < 86400) {
            str = "" + ((value / 60) / 60);
            if (str.length() < 2) {
                str = str + LocaleController.getString("SecretChatTimerHours", R.string.SecretChatTimerHours);
            }
        } else if (value >= 86400 && value < 604800) {
            str = "" + (((value / 60) / 60) / 24);
            if (str.length() < 2) {
                str = str + LocaleController.getString("SecretChatTimerDays", R.string.SecretChatTimerDays);
            }
        } else if (value >= 2592000 && value <= 2678400) {
            str = "" + ((((value / 60) / 60) / 24) / 30);
            if (str.length() < 2) {
                str = str + LocaleController.getString("SecretChatTimerMonths", R.string.SecretChatTimerMonths);
            }
        } else {
            str = "" + ((((value / 60) / 60) / 24) / 7);
            if (str.length() < 2) {
                str = str + LocaleController.getString("SecretChatTimerWeeks", R.string.SecretChatTimerWeeks);
            } else if (str.length() > 2) {
                str = "c";
            }
        }
        String str2 = str;
        this.timeWidth = this.timePaint.measureText(str2);
        try {
            StaticLayout staticLayout = new StaticLayout(str2, this.timePaint, (int) Math.ceil(this.timeWidth), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.timeLayout = staticLayout;
            this.timeHeight = staticLayout.getHeight();
        } catch (Exception e) {
            this.timeLayout = null;
            FileLog.e(e);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int intrinsicWidth = getIntrinsicWidth();
        int intrinsicHeight = getIntrinsicHeight();
        if (this.time == 0) {
            this.paint.setColor(Theme.getColor("chat_secretTimerBackground"));
            this.linePaint.setColor(Theme.getColor("chat_secretTimerText"));
            canvas.drawCircle(AndroidUtilities.dpf2(9.0f), AndroidUtilities.dpf2(9.0f), AndroidUtilities.dpf2(7.5f), this.paint);
            canvas.drawCircle(AndroidUtilities.dpf2(9.0f), AndroidUtilities.dpf2(9.0f), AndroidUtilities.dpf2(8.0f), this.linePaint);
            this.paint.setColor(Theme.getColor("chat_secretTimerText"));
            canvas.drawLine(AndroidUtilities.dp(9.0f), AndroidUtilities.dp(9.0f), AndroidUtilities.dp(13.0f), AndroidUtilities.dp(9.0f), this.linePaint);
            canvas.drawLine(AndroidUtilities.dp(9.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(9.0f), AndroidUtilities.dp(9.5f), this.linePaint);
            canvas.drawRect(AndroidUtilities.dpf2(7.0f), AndroidUtilities.dpf2(0.0f), AndroidUtilities.dpf2(11.0f), AndroidUtilities.dpf2(1.5f), this.paint);
        } else {
            this.paint.setColor(Theme.getColor("chat_secretTimerBackground"));
            this.timePaint.setColor(Theme.getColor("chat_secretTimerText"));
            canvas.drawCircle(AndroidUtilities.dp(9.5f), AndroidUtilities.dp(9.5f), AndroidUtilities.dp(9.5f), this.paint);
        }
        if (this.time == 0 || this.timeLayout == null) {
            return;
        }
        int i = AndroidUtilities.density == 3.0f ? -1 : 0;
        double dCeil = Math.ceil(this.timeWidth / 2.0f);
        Double.isNaN(intrinsicWidth / 2);
        canvas.translate(((int) (r3 - dCeil)) + i, (intrinsicHeight - this.timeHeight) / 2);
        this.timeLayout.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(19.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(19.0f);
    }
}
