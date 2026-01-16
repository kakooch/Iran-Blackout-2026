package ir.resaneh1.iptv.fragment.home.ad;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidMessenger.helper.GlideHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.feed.AdTimerCell;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.Link;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: AdItemCell.kt */
/* loaded from: classes3.dex */
public final class AdItemCell extends FrameLayout {
    private HomePageModels.AdItemObject currentItem;
    private final ImageView imageView;
    private AdTimerCell timerCell;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdItemCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        this.timerCell = new AdTimerCell(context, Boolean.FALSE);
        addView(imageView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
        addView(this.timerCell);
        setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.ad.AdItemCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdItemCell.m452_init_$lambda8(this.f$0, view);
            }
        });
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public final void setData(HomePageModels.AdItemObject adItemObject) {
        resetData();
        if (adItemObject != null) {
            Unit unit = null;
            this.imageView.setImageBitmap(null);
            this.currentItem = adItemObject;
            GlideHelper.loadRoundedCornerNoCropCenter(getContext(), this.imageView, adItemObject.image_url, 8, R.drawable.shape_grey_background_round);
            HomePageModels.TimerInfoObject timerInfoObject = adItemObject.timer_info;
            if (timerInfoObject != null) {
                if (timerInfoObject.expiration_time > 0) {
                    VisibilityHelper.showViews(this.timerCell);
                    AdTimerCell adTimerCell = this.timerCell;
                    adTimerCell.setAdTimerData(adItemObject);
                    adTimerCell.refreshCounter(timerInfoObject.expiration_time);
                    adTimerCell.updateFonts(timerInfoObject.font_size);
                    adTimerCell.updateTextColor(timerInfoObject.color_code);
                    this.timerCell.setColonsColor(timerInfoObject.color_code);
                } else {
                    VisibilityHelper.hideViews(this.timerCell);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                VisibilityHelper.hideViews(this.timerCell);
            }
        }
    }

    private final void resetData() {
        this.imageView.setImageDrawable(null);
        this.timerCell.resetViews();
        VisibilityHelper.hideViews(this.timerCell);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        HomePageModels.TimerInfoObject timerInfoObject;
        super.onMeasure(i, i2);
        this.timerCell.invalidate();
        HomePageModels.AdItemObject adItemObject = this.currentItem;
        Unit unit = null;
        if (adItemObject != null && (timerInfoObject = adItemObject.timer_info) != null) {
            if (timerInfoObject.expiration_time > 0) {
                double measuredWidth = getMeasuredWidth();
                double d = timerInfoObject.x2;
                Double.isNaN(measuredWidth);
                Double.isNaN(d);
                int iRoundToInt = MathKt__MathJVMKt.roundToInt(measuredWidth * d);
                double measuredWidth2 = getMeasuredWidth();
                double d2 = timerInfoObject.x1;
                Double.isNaN(measuredWidth2);
                Double.isNaN(d2);
                int iRoundToInt2 = iRoundToInt - MathKt__MathJVMKt.roundToInt(measuredWidth2 * d2);
                double measuredHeight = getMeasuredHeight();
                double d3 = timerInfoObject.y2;
                Double.isNaN(measuredHeight);
                Double.isNaN(d3);
                int iRoundToInt3 = MathKt__MathJVMKt.roundToInt(measuredHeight * d3);
                double measuredHeight2 = getMeasuredHeight();
                double d4 = timerInfoObject.y1;
                Double.isNaN(measuredHeight2);
                Double.isNaN(d4);
                this.timerCell.setLayoutParams(LayoutHelper.createFrame(AndroidUtilities.px(iRoundToInt2), AndroidUtilities.px(iRoundToInt3 - MathKt__MathJVMKt.roundToInt(measuredHeight2 * d4))));
            } else {
                VisibilityHelper.hideViews(this.timerCell);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            VisibilityHelper.hideViews(this.timerCell);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        HomePageModels.TimerInfoObject timerInfoObject;
        super.onLayout(z, i, i2, i3, i4);
        HomePageModels.AdItemObject adItemObject = this.currentItem;
        if (adItemObject == null || (timerInfoObject = adItemObject.timer_info) == null) {
            return;
        }
        AdTimerCell adTimerCell = this.timerCell;
        double measuredWidth = getMeasuredWidth();
        double d = timerInfoObject.x1;
        Double.isNaN(measuredWidth);
        Double.isNaN(d);
        int iRoundToInt = MathKt__MathJVMKt.roundToInt(measuredWidth * d);
        double measuredHeight = getMeasuredHeight();
        double d2 = timerInfoObject.y1;
        Double.isNaN(measuredHeight);
        Double.isNaN(d2);
        int iRoundToInt2 = MathKt__MathJVMKt.roundToInt(measuredHeight * d2);
        double measuredWidth2 = getMeasuredWidth();
        double d3 = timerInfoObject.x2;
        Double.isNaN(measuredWidth2);
        Double.isNaN(d3);
        int iRoundToInt3 = MathKt__MathJVMKt.roundToInt(measuredWidth2 * d3);
        double measuredHeight2 = getMeasuredHeight();
        double d4 = timerInfoObject.y2;
        Double.isNaN(measuredHeight2);
        Double.isNaN(d4);
        adTimerCell.layout(iRoundToInt, iRoundToInt2, iRoundToInt3, MathKt__MathJVMKt.roundToInt(measuredHeight2 * d4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-8, reason: not valid java name */
    public static final void m452_init_$lambda8(AdItemCell this$0, View view) {
        Link link;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomePageModels.AdItemObject adItemObject = this$0.currentItem;
        if (adItemObject == null || (link = adItemObject.action_link) == null) {
            return;
        }
        HomePageActivityNew.onLinkClick(link);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        HomePageModels.TimerInfoObject timerInfoObject;
        super.onAttachedToWindow();
        HomePageModels.AdItemObject adItemObject = this.currentItem;
        Unit unit = null;
        if (adItemObject != null && (timerInfoObject = adItemObject.timer_info) != null) {
            int i = timerInfoObject.expiration_time;
            if (i > 0) {
                VisibilityHelper.showViews(this.timerCell);
                this.timerCell.refreshCounter(i);
            } else {
                VisibilityHelper.hideViews(this.timerCell);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            VisibilityHelper.hideViews(this.timerCell);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.timerCell.stopCounter();
    }
}
