package ir.resaneh1.iptv.fragment.home.sectionInfo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidMessenger.helper.GlideHelper;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.helper.ViewUpdateHelper;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: HeaderInfoCell.kt */
/* loaded from: classes3.dex */
public final class HeaderInfoCell extends FrameLayout {
    private final Lazy buttonImageView$delegate;
    private final Lazy buttonTextView$delegate;
    private HomePageModels.HeaderInfoObject cachedHeaderInfo;
    private final Context context;
    private final Lazy iconImageView$delegate;
    private final int iconSize;
    private final Lazy leftFrameLayout$delegate;
    private final View.OnClickListener linkClickListener;
    private final Lazy rightFrameLayout$delegate;
    private final Lazy titleTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderInfoCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.context = context;
        this.rightFrameLayout$delegate = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell$rightFrameLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return this.this$0.initRightFrameLayout();
            }
        });
        this.leftFrameLayout$delegate = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell$leftFrameLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return this.this$0.initLeftFrameLayout();
            }
        });
        this.iconImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell$iconImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0.context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
        this.buttonImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell$buttonImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0.context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
        this.titleTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell$titleTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).removeBackgrounds().setTextSize(14).setGravity(21).isBold(true).setPadding(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f)).setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).build();
                textViewBuild.setSingleLine(true);
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                return textViewBuild;
            }
        });
        this.buttonTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell$buttonTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).removeBackgrounds().setTextSize(12).setGravity(19).setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).setPadding(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f)).build();
                textViewBuild.setSingleLine(true);
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                return textViewBuild;
            }
        });
        this.linkClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeaderInfoCell.m470linkClickListener$lambda0(this.f$0, view);
            }
        };
        this.iconSize = 24;
        addView(getLeftFrameLayout(), LayoutHelper.createFrame(-2, -1, 19));
        addView(getRightFrameLayout(), LayoutHelper.createFrame(-2, -1, 21));
        VisibilityHelper.hideViews(this);
        initListeners();
    }

    private final FrameLayout getRightFrameLayout() {
        return (FrameLayout) this.rightFrameLayout$delegate.getValue();
    }

    private final FrameLayout getLeftFrameLayout() {
        return (FrameLayout) this.leftFrameLayout$delegate.getValue();
    }

    private final ImageView getIconImageView() {
        return (ImageView) this.iconImageView$delegate.getValue();
    }

    private final ImageView getButtonImageView() {
        return (ImageView) this.buttonImageView$delegate.getValue();
    }

    private final TextView getTitleTextView() {
        return (TextView) this.titleTextView$delegate.getValue();
    }

    private final TextView getButtonTextView() {
        return (TextView) this.buttonTextView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: linkClickListener$lambda-0, reason: not valid java name */
    public static final void m470linkClickListener$lambda0(HeaderInfoCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomePageModels.HeaderInfoObject headerInfoObject = this$0.cachedHeaderInfo;
        HomePageActivityNew.onLinkClick(headerInfoObject == null ? null : headerInfoObject.action_link);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = getLeftFrameLayout().getMeasuredWidth();
        int measuredWidth3 = getRightFrameLayout().getMeasuredWidth();
        if (measuredWidth2 + measuredWidth3 > measuredWidth) {
            double d = measuredWidth;
            Double.isNaN(d);
            int i3 = (int) (0.75d * d);
            if (measuredWidth3 > i3) {
                Double.isNaN(d);
                measuredWidth3 = i3;
                measuredWidth2 = (int) (d * 0.25d);
            } else {
                measuredWidth2 = measuredWidth - measuredWidth3;
            }
        }
        getLeftFrameLayout().measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), i2);
        getRightFrameLayout().measure(View.MeasureSpec.makeMeasureSpec(measuredWidth3, 1073741824), i2);
    }

    public final void overrideClickListeners(View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        getIconImageView().setOnClickListener(clickListener);
        getTitleTextView().setOnClickListener(clickListener);
        getButtonImageView().setOnClickListener(clickListener);
        getButtonTextView().setOnClickListener(clickListener);
    }

    public final void setImageLongClickListeners(View.OnLongClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        getButtonImageView().setOnLongClickListener(clickListener);
    }

    private final void initListeners() {
        getIconImageView().setOnClickListener(this.linkClickListener);
        getTitleTextView().setOnClickListener(this.linkClickListener);
        getButtonImageView().setOnClickListener(this.linkClickListener);
        getButtonTextView().setOnClickListener(this.linkClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout initRightFrameLayout() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        ImageView iconImageView = getIconImageView();
        int i = this.iconSize;
        frameLayout.addView(iconImageView, LayoutHelper.createFrame(i, i, 21, 0.0f, 0.0f, 0.0f, 0.0f));
        frameLayout.addView(getTitleTextView(), LayoutHelper.createFrame(-2, -1.0f, 21, 0.0f, 0.0f, this.iconSize + 8.0f, 0.0f));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout initLeftFrameLayout() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        ImageView buttonImageView = getButtonImageView();
        int i = this.iconSize;
        frameLayout.addView(buttonImageView, LayoutHelper.createFrame(i, i, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        frameLayout.addView(getButtonTextView(), LayoutHelper.createFrame(-2, -1.0f, 19, this.iconSize + 8.0f, 0.0f, 0.0f, 0.0f));
        return frameLayout;
    }

    public final void setData(HomePageModels.HeaderInfoObject headerInfoObject) {
        resetData();
        if (headerInfoObject != null) {
            this.cachedHeaderInfo = headerInfoObject;
            VisibilityHelper.showViews(this);
            setTitle(headerInfoObject);
            setIcon(headerInfoObject);
            setButtonIcon(headerInfoObject);
            setButtonText(headerInfoObject);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private final void resetData() {
        getTitleTextView().setText(BuildConfig.FLAVOR);
        getButtonTextView().setText(BuildConfig.FLAVOR);
        TextView titleTextView = getTitleTextView();
        int i = Theme.key_dialogTextBlack;
        titleTextView.setTextColor(Theme.getColor(i));
        getButtonTextView().setTextColor(Theme.getColor(i));
        getTitleTextView().setTextSize(14.0f);
        getButtonTextView().setTextSize(12.0f);
        getIconImageView().setImageDrawable(null);
        getButtonImageView().setImageDrawable(null);
    }

    private final void setButtonIcon(HomePageModels.HeaderInfoObject headerInfoObject) {
        if (headerInfoObject == null) {
            return;
        }
        String str = headerInfoObject.button_icon_url;
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "it.button_icon_url");
            if (str.length() > 0) {
                VisibilityHelper.showViews(getButtonImageView());
                GlideHelper.load(this.context, getButtonImageView(), headerInfoObject.button_icon_url);
                getButtonTextView().setLayoutParams(LayoutHelper.createFrame(-2, -1.0f, 19, this.iconSize + 8.0f, 0.0f, 0.0f, 0.0f));
                return;
            }
        }
        VisibilityHelper.hideViews(getButtonImageView());
        getButtonTextView().setLayoutParams(LayoutHelper.createFrame(-2, -1.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    private final void setButtonText(HomePageModels.HeaderInfoObject headerInfoObject) {
        String str;
        if (headerInfoObject == null || (str = headerInfoObject.button_text) == null) {
            return;
        }
        if (str != null) {
            getButtonTextView().setText(headerInfoObject.button_text);
        }
        ViewUpdateHelper viewUpdateHelper = ViewUpdateHelper.INSTANCE;
        TextView buttonTextView = getButtonTextView();
        Intrinsics.checkNotNullExpressionValue(buttonTextView, "buttonTextView");
        viewUpdateHelper.updateTextSize(buttonTextView, Float.valueOf(headerInfoObject.button_text_size));
        if (headerInfoObject.button_color_code != null) {
            TextView buttonTextView2 = getButtonTextView();
            Intrinsics.checkNotNullExpressionValue(buttonTextView2, "buttonTextView");
            viewUpdateHelper.updateColor(buttonTextView2, headerInfoObject.button_color_code);
        }
    }

    private final void setTitle(HomePageModels.HeaderInfoObject headerInfoObject) {
        if (headerInfoObject == null || headerInfoObject.title == null) {
            return;
        }
        getTitleTextView().setText(headerInfoObject.title);
        ViewUpdateHelper viewUpdateHelper = ViewUpdateHelper.INSTANCE;
        TextView titleTextView = getTitleTextView();
        Intrinsics.checkNotNullExpressionValue(titleTextView, "titleTextView");
        viewUpdateHelper.updateTextSize(titleTextView, Float.valueOf(headerInfoObject.title_size));
        if (headerInfoObject.title_color_code != null) {
            TextView titleTextView2 = getTitleTextView();
            Intrinsics.checkNotNullExpressionValue(titleTextView2, "titleTextView");
            viewUpdateHelper.updateColor(titleTextView2, headerInfoObject.title_color_code);
        }
    }

    private final void setIcon(HomePageModels.HeaderInfoObject headerInfoObject) {
        if (headerInfoObject == null) {
            return;
        }
        String str = headerInfoObject.icon_url;
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "it.icon_url");
            if (str.length() > 0) {
                VisibilityHelper.showViews(getIconImageView());
                getTitleTextView().setLayoutParams(LayoutHelper.createFrame(-2, -1.0f, 21, 0.0f, 0.0f, this.iconSize + 8.0f, 0.0f));
                GlideHelper.load(this.context, getIconImageView(), headerInfoObject.icon_url);
                return;
            }
        }
        VisibilityHelper.hideViews(getIconImageView());
        getTitleTextView().setLayoutParams(LayoutHelper.createFrame(-2, -1.0f, 21, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    public final void setServiceButtonImageView() {
        getButtonImageView().setImageResource(R.drawable.ic_my_services_option);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void hideTitle() {
        VisibilityHelper.hideViews(getTitleTextView());
    }
}
