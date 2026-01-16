package ir.resaneh1.iptv.fragment.home.live;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.Link;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: HomeLiveItemCell.kt */
/* loaded from: classes3.dex */
public final class HomeLiveItemCell extends FrameLayout {
    private final Lazy avatarView$delegate;
    private final Lazy bottomLineView$delegate;
    private final Context context;
    private final Lazy liveCountImageView$delegate;
    private final Lazy mainLinearLayout$delegate;
    private final Lazy placeHolderRes$delegate;
    private final Lazy subtitleTextView$delegate;
    private final Lazy titleTextView$delegate;
    private final Lazy viewCountTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLiveItemCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.context = context;
        this.placeHolderRes$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$placeHolderRes$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(R.drawable.bg_circle_white);
            }
        });
        this.avatarView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<InsStoryAvatarView>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$avatarView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InsStoryAvatarView invoke() {
                return new InsStoryAvatarView(this.this$0.context, null);
            }
        });
        this.mainLinearLayout$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$mainLinearLayout$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(this.this$0.context);
                linearLayout.setOrientation(1);
                return linearLayout;
            }
        });
        this.titleTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$titleTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextSize(13).setGravity(48).removeBackgrounds().setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).build();
                textViewBuild.setSingleLine(true);
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                return textViewBuild;
            }
        });
        this.subtitleTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$subtitleTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextSize(12).setTextColor(Theme.getColor(Theme.key_dialogTextGray)).removeBackgrounds().build();
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                textViewBuild.setSingleLine(true);
                return textViewBuild;
            }
        });
        this.viewCountTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$viewCountTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return new CustomTextView.Builder(this.this$0.context).setTextColor(Theme.getColor(Theme.key_dialogTextGray)).setGravity(17).removeBackgrounds().build();
            }
        });
        this.liveCountImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$liveCountImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0.context);
                imageView.setImageDrawable(imageView.getContext().getResources().getDrawable(R.drawable.ic_live_count));
                imageView.setColorFilter(Theme.getColor(Theme.key_dialogTextGray));
                return imageView;
            }
        });
        this.bottomLineView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$bottomLineView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return VisibilityHelper.createLine(this.this$0.context);
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        getAvatarView().setStatus(InsStoryAvatarView.Status.LIVE);
        getAvatarView().setScaleType(ImageView.ScaleType.FIT_XY);
        getAvatarView().setImageDrawable(context.getResources().getDrawable(getPlaceHolderRes()));
        frameLayout.addView(getAvatarView(), LayoutHelper.createFrame(56, 56, 21, 0.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(5);
        linearLayout.addView(getTitleTextView(), LayoutHelper.createFrame(-2, -2.0f, 5, 0.0f, 0.0f, 0.0f, 0.0f));
        linearLayout.addView(getSubtitleTextView(), LayoutHelper.createFrame(-2, -2.0f, 5, 0.0f, 0.0f, 0.0f, 0.0f));
        frameLayout.addView(linearLayout, LayoutHelper.createFrame(-2, -2.0f, 21, 42.0f, 0.0f, 62.0f, 0.0f));
        frameLayout.addView(createCountView(), LayoutHelper.createFrame(-2, -2.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        getMainLinearLayout().addView(frameLayout, LayoutHelper.createLinear(-1, -2));
        getMainLinearLayout().addView(getBottomLineView(), LayoutHelper.createLinear(-1, 1, 0.0f, 8.0f, 0.0f, 0.0f));
        addView(getMainLinearLayout(), LayoutHelper.createFrame(-1, -2, 17, 8.0f, 0.0f, 8.0f, 0.0f));
    }

    private final int getPlaceHolderRes() {
        return ((Number) this.placeHolderRes$delegate.getValue()).intValue();
    }

    private final InsStoryAvatarView getAvatarView() {
        return (InsStoryAvatarView) this.avatarView$delegate.getValue();
    }

    private final LinearLayout getMainLinearLayout() {
        return (LinearLayout) this.mainLinearLayout$delegate.getValue();
    }

    private final TextView getTitleTextView() {
        return (TextView) this.titleTextView$delegate.getValue();
    }

    private final TextView getSubtitleTextView() {
        return (TextView) this.subtitleTextView$delegate.getValue();
    }

    private final TextView getViewCountTextView() {
        return (TextView) this.viewCountTextView$delegate.getValue();
    }

    private final ImageView getLiveCountImageView() {
        return (ImageView) this.liveCountImageView$delegate.getValue();
    }

    private final View getBottomLineView() {
        return (View) this.bottomLineView$delegate.getValue();
    }

    private final FrameLayout createCountView() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.addView(getViewCountTextView(), LayoutHelper.createFrame(-2, -2.0f, 21, 24.0f, 0.0f, 0.0f, 0.0f));
        frameLayout.addView(getLiveCountImageView(), LayoutHelper.createFrame(14, 14.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        return frameLayout;
    }

    private final void setActionOnLink(final Link link) {
        if (link == null) {
            return;
        }
        getMainLinearLayout().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveItemCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePageActivityNew.onLinkClick(link);
            }
        });
    }

    public final void setData(HomePageModels.LiveSectionItem liveItem, boolean z) {
        Intrinsics.checkNotNullParameter(liveItem, "liveItem");
        resetData();
        if (isValid(liveItem)) {
            setVisibility(0);
            if (z) {
                VisibilityHelper.hideViews(getBottomLineView());
            } else {
                VisibilityHelper.showViews(getBottomLineView());
            }
            if (liveItem.live_title != null) {
                getTitleTextView().setVisibility(TextUtils.isEmpty(liveItem.live_title) ? 8 : 0);
            } else {
                getTitleTextView().setVisibility(8);
            }
            String str = liveItem.channel_avatar_url;
            if (str != null) {
                GlideHelper.loadCircle(this.context, getAvatarView(), str);
            }
            String str2 = liveItem.live_title;
            if (str2 != null) {
                getTitleTextView().setText(str2);
            }
            String str3 = liveItem.channel_name;
            if (str3 != null) {
                getSubtitleTextView().setText(str3);
            }
            getViewCountTextView().setText(NumberUtils.toPersian(NumberUtils.toCuteStringWithKOrM(liveItem.live_online_count)));
            setActionOnLink(liveItem.live_message_share_link);
            return;
        }
        setVisibility(8);
    }

    private final void resetData() {
        getTitleTextView().setText(BuildConfig.FLAVOR);
        getSubtitleTextView().setText(BuildConfig.FLAVOR);
        getViewCountTextView().setText(BuildConfig.FLAVOR);
        getAvatarView().setImageDrawable(null);
        setActionOnLink(null);
    }

    public final boolean isValid(HomePageModels.LiveSectionItem liveSectionItem) {
        Intrinsics.checkNotNullParameter(liveSectionItem, "<this>");
        return (liveSectionItem.live_title == null && liveSectionItem.channel_name == null && liveSectionItem.channel_avatar_url == null) ? false : true;
    }
}
