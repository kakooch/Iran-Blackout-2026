package ir.resaneh1.iptv.fragment.home.music;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.FrameLayoutLikeLinear;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: HomeMusicItemCell.kt */
/* loaded from: classes3.dex */
public final class HomeMusicItemCell extends FrameLayout {
    private final int LOGO_ACTION_SIZE;
    private final Lazy actionImageView$delegate;
    private final Lazy artistTextView$delegate;
    private final Lazy avatarView$delegate;
    private final Context context;
    private final Lazy currentPositionTextView$delegate;
    private final Lazy durationTextView$delegate;
    private final Lazy pauseDrawable$delegate;
    private final Lazy placeHolderRes$delegate;
    private final Lazy playDrawable$delegate;
    private final Lazy seekbar$delegate;
    private boolean tempPlaying;
    private final Lazy titleTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeMusicItemCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.context = context;
        this.placeHolderRes$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$placeHolderRes$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(R.drawable.bg_circle_white);
            }
        });
        this.avatarView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$avatarView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(this.this$0.context);
            }
        });
        this.titleTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$titleTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextSize(16).setGravity(48).removeBackgrounds().setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).build();
                textViewBuild.setSingleLine(true);
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                return textViewBuild;
            }
        });
        this.artistTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$artistTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextColor(Theme.getColor(Theme.key_dialogTextGray)).removeBackgrounds().build();
                textViewBuild.setEllipsize(TextUtils.TruncateAt.END);
                textViewBuild.setSingleLine(true);
                return textViewBuild;
            }
        });
        this.durationTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$durationTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextColor(Theme.getColor(Theme.key_dialogTextGray)).removeBackgrounds().setGravity(17).build();
                textViewBuild.setSingleLine(true);
                return textViewBuild;
            }
        });
        this.currentPositionTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$currentPositionTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewBuild = new CustomTextView.Builder(this.this$0.context).setTextColor(Theme.getColor(Theme.key_dialogTextGray)).removeBackgrounds().setGravity(17).build();
                textViewBuild.setSingleLine(true);
                return textViewBuild;
            }
        });
        this.seekbar$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SeekBar>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$seekbar$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SeekBar invoke() {
                return new SeekBar(this.this$0.context);
            }
        });
        this.LOGO_ACTION_SIZE = 25;
        this.pauseDrawable$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$pauseDrawable$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return this.this$0.context.getResources().getDrawable(R.drawable.ic_pause_arrow);
            }
        });
        this.playDrawable$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$playDrawable$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return this.this$0.context.getResources().getDrawable(R.drawable.ic_play_arrow);
            }
        });
        this.actionImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$actionImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(this.this$0.context);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        initViews();
        linearLayout.addView(createCreditsLayout(), LayoutHelper.createFrame(-1, -2, 17));
        linearLayout.addView(createMediaLayout(), LayoutHelper.createFrame(-1, -2, 17));
        addView(createAvatarLayout(), LayoutHelper.createFrame(50, 50, 3));
        addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f, 5, 54.0f, 0.0f, 0.0f, 16.0f));
        addView(VisibilityHelper.createLine(context), LayoutHelper.createFrame(-1, 1.0f, 80, 0.0f, 8.0f, 0.0f, 0.0f));
        initListeners();
    }

    private final int getPlaceHolderRes() {
        return ((Number) this.placeHolderRes$delegate.getValue()).intValue();
    }

    private final ImageView getAvatarView() {
        return (ImageView) this.avatarView$delegate.getValue();
    }

    private final TextView getTitleTextView() {
        return (TextView) this.titleTextView$delegate.getValue();
    }

    private final TextView getArtistTextView() {
        return (TextView) this.artistTextView$delegate.getValue();
    }

    private final TextView getDurationTextView() {
        return (TextView) this.durationTextView$delegate.getValue();
    }

    private final TextView getCurrentPositionTextView() {
        return (TextView) this.currentPositionTextView$delegate.getValue();
    }

    private final SeekBar getSeekbar() {
        return (SeekBar) this.seekbar$delegate.getValue();
    }

    private final Drawable getPauseDrawable() {
        return (Drawable) this.pauseDrawable$delegate.getValue();
    }

    private final Drawable getPlayDrawable() {
        return (Drawable) this.playDrawable$delegate.getValue();
    }

    private final ImageView getActionImageView() {
        return (ImageView) this.actionImageView$delegate.getValue();
    }

    private final void initViews() {
        getActionImageView().setImageDrawable(getPlayDrawable());
        getAvatarView().setScaleType(ImageView.ScaleType.FIT_XY);
        getActionImageView().setScaleType(ImageView.ScaleType.FIT_XY);
        getSeekbar().setClickable(true);
        getSeekbar().getProgressDrawable().setColorFilter(this.context.getResources().getColor(R.color.wallet_purple), PorterDuff.Mode.MULTIPLY);
    }

    private final FrameLayout createAvatarLayout() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setBackground(null);
        frameLayout.addView(getAvatarView(), LayoutHelper.createFrame(-1, -1, 17));
        ImageView imageView = new ImageView(this.context);
        frameLayout.addView(imageView);
        GlideHelper.loadCircle(this.context, imageView, BuildConfig.FLAVOR, R.drawable.ic_home_music_gradiant);
        ImageView actionImageView = getActionImageView();
        int i = this.LOGO_ACTION_SIZE;
        frameLayout.addView(actionImageView, LayoutHelper.createFrame(i, i, 17));
        return frameLayout;
    }

    private final void initListeners() {
        getAvatarView().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.music.HomeMusicItemCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeMusicItemCell.m464initListeners$lambda0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initListeners$lambda-0, reason: not valid java name */
    public static final void m464initListeners$lambda0(HomeMusicItemCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.tempPlaying) {
            this$0.getActionImageView().setImageDrawable(this$0.getPauseDrawable());
            this$0.tempPlaying = false;
        } else {
            this$0.getActionImageView().setImageDrawable(this$0.getPlayDrawable());
            this$0.tempPlaying = true;
        }
    }

    private final FrameLayoutLikeLinear createCreditsLayout() {
        FrameLayoutLikeLinear frameLayoutLikeLinear = new FrameLayoutLikeLinear(this.context);
        frameLayoutLikeLinear.addView(getArtistTextView(), LayoutHelper.createLinear(0, -2, 1.0f, 3));
        frameLayoutLikeLinear.addView(getTitleTextView(), LayoutHelper.createLinear(0, -2, 1.0f, 5));
        return frameLayoutLikeLinear;
    }

    private final FrameLayout createMediaLayout() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.addView(getCurrentPositionTextView(), LayoutHelper.createFrame(40, -2, 3));
        frameLayout.addView(getDurationTextView(), LayoutHelper.createFrame(40, -2, 5));
        frameLayout.addView(getSeekbar(), LayoutHelper.createFrame(-1, -2.0f, 17, 44.0f, 0.0f, 44.0f, 0.0f));
        return frameLayout;
    }

    public final void setData(HomePageModels.MusicItem musicItem) {
        Intrinsics.checkNotNullParameter(musicItem, "musicItem");
        resetData();
        if (isValid(musicItem)) {
            VisibilityHelper.showViews(this);
            GlideHelper.loadCircle(this.context, getAvatarView(), musicItem.image_url);
            String str = musicItem.title;
            if (str != null) {
                getTitleTextView().setText(str);
            }
            String str2 = musicItem.music_performer;
            if (str2 != null) {
                getArtistTextView().setText(str2);
            }
            getDurationTextView().setText(DateFormatUtils.getClock(musicItem.duration_seconds));
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private final void resetData() {
        getTitleTextView().setText(BuildConfig.FLAVOR);
        getArtistTextView().setText(BuildConfig.FLAVOR);
        getDurationTextView().setText(BuildConfig.FLAVOR);
        getCurrentPositionTextView().setText("۰۰:۰۰");
        getAvatarView().setImageDrawable(null);
    }

    public final boolean isValid(HomePageModels.MusicItem musicItem) {
        Intrinsics.checkNotNullParameter(musicItem, "<this>");
        return (musicItem.music_performer == null && musicItem.title == null && musicItem.image_url == null && musicItem.play_url == null) ? false : true;
    }
}
