package ir.resaneh1.iptv.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import ir.resaneh1.iptv.helper.DimensionHelper;

/* loaded from: classes3.dex */
public class StoryPositionObject {
    private float height;
    public double rotation;
    private float width;
    private float x;
    private float y;

    public StoryPositionObject(Context context, float f, float f2, float f3, float f4, double d) {
        Activity activity = (Activity) context;
        float storyViewWidthPx = DimensionHelper.getStoryViewWidthPx(activity);
        float storyViewHeightPx = DimensionHelper.getStoryViewHeightPx(activity);
        this.x = f / storyViewWidthPx;
        this.y = f2 / storyViewHeightPx;
        this.width = f3 / storyViewWidthPx;
        this.height = f4 / storyViewHeightPx;
        this.rotation = d;
    }

    public RectF getRectPx(Context context, float f) {
        float centerYPx = getCenterYPx(context, f) - (getHeightPx(context, f) / 2.0f);
        float centerXPx = getCenterXPx(context, f) - (getWidthPx(context, f) / 2.0f);
        return new RectF(centerXPx, centerYPx, getWidthPx(context, f) + centerXPx, getHeightPx(context, f) + centerYPx);
    }

    public float getWidthPx(Context context, float f) {
        return this.width * getStoryWidthPx(context);
    }

    public float getHeightPx(Context context, float f) {
        return this.height * getStoryHeightPx(context, f);
    }

    public float getCenterXPx(Context context, float f) {
        return this.x * getStoryWidthPx(context);
    }

    public float getCenterYPx(Context context, float f) {
        return this.y * getStoryHeightPx(context, f);
    }

    public float getStoryHeightPx(Context context, float f) {
        if (f == 0.0f) {
            f = 1.0f;
        }
        return getStoryWidthPx(context) / f;
    }

    public float getStoryWidthPx(Context context) {
        return DimensionHelper.getScreenMinDimension((Activity) context);
    }
}
