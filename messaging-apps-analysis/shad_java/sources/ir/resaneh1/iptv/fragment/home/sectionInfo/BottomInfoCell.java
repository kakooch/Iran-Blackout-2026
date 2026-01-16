package ir.resaneh1.iptv.fragment.home.sectionInfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.HomeSliderCell$$ExternalSyntheticBackport0;
import ir.resaneh1.iptv.fragment.home.helper.ViewUpdateHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.Link;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class BottomInfoCell extends FrameLayout {
    private final TextView buttonTextView;
    private final Context context;
    public final TextView loadMoreNumberTextView;
    private final ImageView logoImageView;
    private final TextView subtitleTextView;
    public final LinearLayout titleSubtitleLinearLayout;
    private final TextView titleTextView;

    private boolean isValidData(HomePageModels.ContainerSectionItem containerSectionItem) {
        return containerSectionItem != null;
    }

    public BottomInfoCell(Context context) {
        super(context);
        this.context = context;
        TextView textViewCreateButton = createButton();
        this.buttonTextView = textViewCreateButton;
        ImageView imageView = new ImageView(context);
        this.logoImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        TextView textViewCreateTitle = createTitle();
        this.titleTextView = textViewCreateTitle;
        TextView textViewCreateSubtitle = createSubtitle();
        this.subtitleTextView = textViewCreateSubtitle;
        TextView textViewCreateTitle2 = createTitle();
        this.loadMoreNumberTextView = textViewCreateTitle2;
        addView(imageView, LayoutHelper.createFrame(50, 50, 21, 0.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.titleSubtitleLinearLayout = linearLayout;
        linearLayout.setOrientation(1);
        linearLayout.addView(textViewCreateTitle, LayoutHelper.createLinear(-2, -2, 5, 0, 0, 0, 0));
        linearLayout.addView(textViewCreateSubtitle, LayoutHelper.createLinear(-2, -2, 5, 0, 0, 0, 0));
        addView(linearLayout, LayoutHelper.createFrame(-2, -2, 21, 0.0f, 0.0f, 66, 0.0f));
        addView(textViewCreateButton, LayoutHelper.createFrame(-2, 30, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        addView(textViewCreateTitle2, LayoutHelper.createFrame(-2, -2, 19, 8.0f, 0.0f, 0.0f, 0.0f));
        VisibilityHelper.hideViews(textViewCreateTitle2, textViewCreateButton);
        VisibilityHelper.hideViews(this);
    }

    private Drawable getGreyBackground(Context context) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(R.drawable.home_gray_circle);
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(Theme.getColor(Theme.key_windowBackgroundGray));
        }
        return drawable;
    }

    public void setData(HomePageModels.BottomInfoObject bottomInfoObject) {
        resetData();
        if (bottomInfoObject != null) {
            VisibilityHelper.showViews(this);
            String str = bottomInfoObject.info_icon_1_url;
            if (str != null) {
                GlideHelper.loadCircle(this.context, this.logoImageView, str, bottomInfoObject.is_transparent ? R.drawable.transparent : R.drawable.bg_circle_white);
            }
            String str2 = bottomInfoObject.title;
            if (str2 != null) {
                this.titleTextView.setText(str2);
            }
            String str3 = bottomInfoObject.subtitle;
            if (str3 != null) {
                this.subtitleTextView.setText(str3);
            }
            String str4 = bottomInfoObject.title_color_code;
            if (str4 != null) {
                ViewUpdateHelper.INSTANCE.updateColor(this.titleTextView, str4);
            }
            String str5 = bottomInfoObject.subtitle_color_code;
            if (str5 != null) {
                ViewUpdateHelper.INSTANCE.updateColor(this.subtitleTextView, str5);
            }
            if (!HomeSliderCell$$ExternalSyntheticBackport0.m(Float.valueOf(bottomInfoObject.title_font_size))) {
                ViewUpdateHelper.INSTANCE.updateTextSize(this.titleTextView, Float.valueOf(bottomInfoObject.title_font_size));
            }
            if (!HomeSliderCell$$ExternalSyntheticBackport0.m(Float.valueOf(bottomInfoObject.subtitle_font_size))) {
                ViewUpdateHelper.INSTANCE.updateTextSize(this.subtitleTextView, Float.valueOf(bottomInfoObject.subtitle_font_size));
            }
            setActionOnLink(bottomInfoObject.action_link);
            setButtonData(bottomInfoObject.button_text);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    public void setData(HomePageModels.ContainerSectionItem containerSectionItem) {
        resetData();
        if (isValidData(containerSectionItem)) {
            VisibilityHelper.showViews(this);
            GlideHelper.loadCircle(this.context, this.logoImageView, containerSectionItem.image_url, R.drawable.bg_circle_white);
            this.subtitleTextView.setText(containerSectionItem.subtitle);
            setTitleData(containerSectionItem);
            setActionOnLink(containerSectionItem.action_link);
            setButtonData(containerSectionItem.button_text);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    public void resetData() {
        this.buttonTextView.setText(BuildConfig.FLAVOR);
        this.titleTextView.setText(BuildConfig.FLAVOR);
        this.subtitleTextView.setText(BuildConfig.FLAVOR);
        VisibilityHelper.hideViews(this.buttonTextView);
        this.logoImageView.setImageDrawable(null);
        setActionOnLink(null);
    }

    private void setButtonData(String str) {
        if (str == null) {
            this.buttonTextView.setVisibility(8);
        } else if (str.isEmpty()) {
            this.buttonTextView.setVisibility(8);
        } else {
            this.buttonTextView.setVisibility(0);
            this.buttonTextView.setText(str);
        }
    }

    private void setActionOnLink(final Link link) {
        if (link != null) {
            setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.BottomInfoCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomePageActivityNew.onLinkClick(link);
                }
            });
        }
    }

    private void setTitleData(HomePageModels.ContainerSectionItem containerSectionItem) {
        String str;
        TextView textView = this.titleTextView;
        if (containerSectionItem == null || (str = containerSectionItem.title) == null) {
            str = BuildConfig.FLAVOR;
        }
        textView.setText(str);
        this.titleTextView.setTextSize(2, 16.0f);
    }

    private TextView createButton() {
        TextView textView = new TextView(getContext());
        textView.setBackground(getGreyBackground(getContext()));
        textView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 8);
        textView.setGravity(17);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(Color.parseColor("#212121"));
        textView.setTypeface(Theme.getHomePageTypeFaceRegular());
        return textView;
    }

    private TextView createTitle() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(2, 14.0f);
        textView.setGravity(48);
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(Theme.getHomePageTypeFaceRegular());
        return textView;
    }

    private TextView createSubtitle() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextGray));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(Theme.getHomePageTypeFaceRegular());
        return textView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = (getMeasuredWidth() - this.logoImageView.getMeasuredWidth()) - AndroidUtilities.dp(16.0f);
        int measuredWidth2 = this.buttonTextView.getMeasuredWidth();
        if (this.titleSubtitleLinearLayout.getMeasuredWidth() + measuredWidth2 > measuredWidth) {
            int i3 = measuredWidth / 2;
            if (measuredWidth2 < i3) {
                this.buttonTextView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(this.buttonTextView.getMeasuredHeight(), 1073741824));
                this.titleSubtitleLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth - measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(this.titleSubtitleLinearLayout.getMeasuredHeight(), 1073741824));
            } else {
                this.buttonTextView.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.buttonTextView.getMeasuredHeight(), 1073741824));
                this.titleSubtitleLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.titleSubtitleLinearLayout.getMeasuredHeight(), 1073741824));
            }
        }
    }
}
