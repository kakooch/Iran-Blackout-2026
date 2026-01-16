package ir.resaneh1.iptv.fragment.home.banner;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.fragment.home.feed.FeedTimerCell;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: BannerCell.kt */
/* loaded from: classes3.dex */
public final class BannerCell extends HomeCell {
    private HomePageModels.BannerSectionObject cachedBannerData;
    private ImageView imageView;
    private LinearLayout innerLinearLayout;
    private final View.OnClickListener onLinkClick;
    private FeedTimerCell timerCell;
    private Integer widthImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.banner.BannerCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerCell.m456onLinkClick$lambda0(this.f$0, view);
            }
        };
        this.onLinkClick = onClickListener;
        getFrameLayout().setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onLinkClick$lambda-0, reason: not valid java name */
    public static final void m456onLinkClick$lambda0(BannerCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomePageModels.BannerSectionObject bannerSectionObject = this$0.cachedBannerData;
        if (bannerSectionObject != null) {
            if ((bannerSectionObject == null ? null : bannerSectionObject.action_link) != null) {
                HomePageActivityNew.onLinkClick(bannerSectionObject != null ? bannerSectionObject.action_link : null);
            }
        }
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.widthImage = Integer.valueOf(AndroidUtilities.px(AndroidUtilities.getScreenWidth()) - 12);
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.timerCell = new FeedTimerCell(context, Boolean.TRUE);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.innerLinearLayout = linearLayout;
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.imageView = imageView;
        Intrinsics.checkNotNull(this.widthImage);
        frameLayout2.addView(imageView, LayoutHelper.createFrame(-1, (r3.intValue() * 3) / 4));
        View view = new View(context);
        view.setBackgroundResource(R.drawable.bg_banner_view_gradient);
        frameLayout2.addView(view, LayoutHelper.createFrame(-1.0f, -1.0f, 48));
        LinearLayout linearLayout2 = this.innerLinearLayout;
        LinearLayout linearLayout3 = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerLinearLayout");
            linearLayout2 = null;
        }
        FeedTimerCell feedTimerCell = this.timerCell;
        if (feedTimerCell == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timerCell");
            feedTimerCell = null;
        }
        linearLayout2.addView(feedTimerCell, LayoutHelper.createLinear(-1, -2, 40.0f, 40.0f, 40.0f, 16.0f));
        LinearLayout linearLayout4 = this.innerLinearLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerLinearLayout");
        } else {
            linearLayout3 = linearLayout4;
        }
        frameLayout2.addView(linearLayout3, LayoutHelper.createFrame(-1, -2, 80));
        frameLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, -2, 17));
        return frameLayout;
    }

    public final void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.BannerSectionObject bannerSectionObject;
        Unit unit;
        Unit unit2;
        resetData();
        if (homePageSectionObject == null || (bannerSectionObject = homePageSectionObject.banner_section) == null) {
            unit2 = null;
        } else {
            this.cachedBannerData = bannerSectionObject;
            VisibilityHelper.showViews(this);
            setImageViewSrc(bannerSectionObject);
            HomePageModels.TimerInfoObject timerInfoObject = bannerSectionObject.timer_info;
            if (timerInfoObject == null) {
                unit = null;
            } else {
                int i = timerInfoObject.expiration_time;
                if (i > 0) {
                    View[] viewArr = new View[1];
                    FeedTimerCell feedTimerCell = this.timerCell;
                    if (feedTimerCell == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                        feedTimerCell = null;
                    }
                    viewArr[0] = feedTimerCell;
                    VisibilityHelper.showViews(viewArr);
                    FeedTimerCell feedTimerCell2 = this.timerCell;
                    if (feedTimerCell2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                        feedTimerCell2 = null;
                    }
                    feedTimerCell2.setData(bannerSectionObject);
                    feedTimerCell2.refreshCounter(i);
                    feedTimerCell2.updateFonts(bannerSectionObject.timer_info.font_size);
                    feedTimerCell2.updateTextColor(bannerSectionObject.timer_info.color_code);
                    FeedTimerCell feedTimerCell3 = this.timerCell;
                    if (feedTimerCell3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                        feedTimerCell3 = null;
                    }
                    feedTimerCell3.setColonsColor(bannerSectionObject.timer_info.color_code);
                } else {
                    View[] viewArr2 = new View[1];
                    FeedTimerCell feedTimerCell4 = this.timerCell;
                    if (feedTimerCell4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                        feedTimerCell4 = null;
                    }
                    viewArr2[0] = feedTimerCell4;
                    VisibilityHelper.hideViews(viewArr2);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                View[] viewArr3 = new View[1];
                FeedTimerCell feedTimerCell5 = this.timerCell;
                if (feedTimerCell5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                    feedTimerCell5 = null;
                }
                viewArr3[0] = feedTimerCell5;
                VisibilityHelper.hideViews(viewArr3);
            }
            setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            this.cachedBannerData = null;
            VisibilityHelper.hideViews(this);
        }
    }

    private final void resetData() {
        FeedTimerCell feedTimerCell = null;
        this.cachedBannerData = null;
        ImageView imageView = this.imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setImageDrawable(null);
        FeedTimerCell feedTimerCell2 = this.timerCell;
        if (feedTimerCell2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timerCell");
        } else {
            feedTimerCell = feedTimerCell2;
        }
        feedTimerCell.resetFonts();
    }

    private final void setImageViewSrc(HomePageModels.BannerSectionObject bannerSectionObject) {
        ImageView imageView = this.imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setVisibility(0);
        if (bannerSectionObject.image_url == null) {
            if (bannerSectionObject.background_color_code != null) {
                ImageView imageView3 = this.imageView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageView");
                } else {
                    imageView2 = imageView3;
                }
                imageView2.setBackgroundColor(Color.parseColor(bannerSectionObject.background_color_code));
                return;
            }
            ImageView imageView4 = this.imageView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView2 = imageView4;
            }
            imageView2.setVisibility(8);
            return;
        }
        Context context = getContext();
        ImageView imageView5 = this.imageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            imageView2 = imageView5;
        }
        GlideHelper.load(context, imageView2, bannerSectionObject.image_url);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        HomePageModels.TimerInfoObject timerInfoObject;
        Unit unit;
        super.onAttachedToWindow();
        HomePageModels.BannerSectionObject bannerSectionObject = this.cachedBannerData;
        FeedTimerCell feedTimerCell = null;
        if (bannerSectionObject == null || (timerInfoObject = bannerSectionObject.timer_info) == null) {
            unit = null;
        } else {
            int i = timerInfoObject.expiration_time;
            if (i > 0) {
                View[] viewArr = new View[1];
                FeedTimerCell feedTimerCell2 = this.timerCell;
                if (feedTimerCell2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                    feedTimerCell2 = null;
                }
                viewArr[0] = feedTimerCell2;
                VisibilityHelper.showViews(viewArr);
                FeedTimerCell feedTimerCell3 = this.timerCell;
                if (feedTimerCell3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                    feedTimerCell3 = null;
                }
                feedTimerCell3.refreshCounter(i);
            } else {
                View[] viewArr2 = new View[1];
                FeedTimerCell feedTimerCell4 = this.timerCell;
                if (feedTimerCell4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timerCell");
                    feedTimerCell4 = null;
                }
                viewArr2[0] = feedTimerCell4;
                VisibilityHelper.hideViews(viewArr2);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            View[] viewArr3 = new View[1];
            FeedTimerCell feedTimerCell5 = this.timerCell;
            if (feedTimerCell5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timerCell");
            } else {
                feedTimerCell = feedTimerCell5;
            }
            viewArr3[0] = feedTimerCell;
            VisibilityHelper.hideViews(viewArr3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FeedTimerCell feedTimerCell = this.timerCell;
        if (feedTimerCell == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timerCell");
            feedTimerCell = null;
        }
        feedTimerCell.stopCounter();
    }
}
