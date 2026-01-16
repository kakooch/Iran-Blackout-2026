package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.rbmain.messenger.AndroidUtilities;

/* compiled from: VodRelatedVideoCell.kt */
/* loaded from: classes3.dex */
public final class VodRelatedVideoCell extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static int itemsMargin = AndroidUtilities.dp(8.0f);
    private static int padding = AndroidUtilities.dp(8.0f);
    private boolean ignoreLayout;
    private int itemsCount;
    private int maxColumns;
    private final ImageView[] photoVideoViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodRelatedVideoCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.photoVideoViews = new ImageView[6];
        this.maxColumns = 5;
        initViews();
    }

    private final void initViews() {
        int i = padding;
        int i2 = 0;
        setPadding(i, 0, i, 0);
        int i3 = this.maxColumns;
        if (i3 < 0) {
            return;
        }
        while (true) {
            int i4 = i2 + 1;
            this.photoVideoViews[i2] = new ImageView(getContext());
            ImageView imageView = this.photoVideoViews[i2];
            if (imageView != null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            addView(this.photoVideoViews[i2]);
            ImageView imageView2 = this.photoVideoViews[i2];
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            if (i2 == i3) {
                return;
            } else {
                i2 = i4;
            }
        }
    }

    @Override // android.view.View
    public void invalidate() {
        int i = this.maxColumns;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                ImageView imageView = this.photoVideoViews[i2];
                if (imageView != null) {
                    imageView.invalidate();
                }
                if (i2 == i) {
                    break;
                } else {
                    i2 = i3;
                }
            }
        }
        super.invalidate();
    }

    public final void setItemsCount(int i) {
        int length = this.photoVideoViews.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            ImageView imageView = this.photoVideoViews[i2];
            if (imageView != null) {
                imageView.clearAnimation();
            }
            ImageView imageView2 = this.photoVideoViews[i2];
            if (imageView2 != null) {
                imageView2.setVisibility(i2 >= i ? 4 : 0);
            }
            i2 = i3;
        }
        this.itemsCount = i;
    }

    public final ImageView getImageView(int i) {
        if (i >= this.itemsCount) {
            return null;
        }
        return this.photoVideoViews[i];
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        float itemSize = Companion.getItemSize(this.itemsCount);
        int iRoundToInt = MathKt__MathJVMKt.roundToInt(AndroidUtilities.displaySize.x - (padding * 2.0f));
        this.ignoreLayout = true;
        int i3 = this.itemsCount;
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i4 + 1;
            ImageView imageView = this.photoVideoViews[i4];
            ViewGroup.LayoutParams layoutParams = imageView == null ? null : imageView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = (int) ((itemsMargin + itemSize) * i4);
            }
            if (layoutParams2 != null) {
                layoutParams2.bottomMargin = itemsMargin;
            }
            if (i4 == this.itemsCount - 1) {
                if (AndroidUtilities.isTablet()) {
                    if (layoutParams2 != null) {
                        layoutParams2.width = (int) ((AndroidUtilities.dp(490.0f) - (padding * 2.0f)) - ((this.itemsCount - 1.0f) * (itemsMargin + itemSize)));
                    }
                } else if (layoutParams2 != null) {
                    layoutParams2.width = (int) (iRoundToInt - ((this.itemsCount - 1.0f) * (itemsMargin + itemSize)));
                }
            } else if (layoutParams2 != null) {
                layoutParams2.width = (int) itemSize;
            }
            if (layoutParams2 != null) {
                layoutParams2.gravity = 53;
            }
            ImageView imageView2 = this.photoVideoViews[i4];
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams2);
            }
            i4 = i5;
        }
        this.ignoreLayout = false;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iRoundToInt, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (itemSize * 1.4285715f), 1073741824));
    }

    public final void setData(int i, String str) {
        GlideHelper.loadRoundedCorner(getContext(), getImageView(i), str, AndroidUtilities.dp(4.0f), R.drawable.vod_round_rect_dark_gray);
    }

    public final void setListener(int i, final Function0<Boolean> clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        ImageView imageView = getImageView(i);
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodRelatedVideoCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodRelatedVideoCell.m368setListener$lambda1(clickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setListener$lambda-1, reason: not valid java name */
    public static final void m368setListener$lambda1(Function0 clickListener, View view) {
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        clickListener.invoke();
    }

    /* compiled from: VodRelatedVideoCell.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getItemsMargin() {
            return VodRelatedVideoCell.itemsMargin;
        }

        public final int getPadding() {
            return VodRelatedVideoCell.padding;
        }

        public final float getItemSize(int i) {
            float padding;
            float f;
            float f2;
            int itemsMargin;
            if (AndroidUtilities.isTablet()) {
                padding = AndroidUtilities.dp(490.0f) - (getPadding() * 2.0f);
                f = i;
                f2 = f - 1.0f;
                itemsMargin = getItemsMargin();
            } else {
                padding = AndroidUtilities.displaySize.x - (getPadding() * 2.0f);
                f = i;
                f2 = f - 1.0f;
                itemsMargin = getItemsMargin();
            }
            return (padding - (f2 * itemsMargin)) / f;
        }
    }
}
