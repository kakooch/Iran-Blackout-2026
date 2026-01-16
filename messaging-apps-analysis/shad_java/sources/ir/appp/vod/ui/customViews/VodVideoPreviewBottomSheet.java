package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: VodVideoPreviewBottomSheet.kt */
/* loaded from: classes3.dex */
public final class VodVideoPreviewBottomSheet extends BottomSheet {
    private TextView actionsPre;
    private TextView ageLimit;
    private final int backgroundColor;
    private ImageView close;
    private final View contentView;
    private ImageView downloadIcon;
    private TextView downloadText;
    private Button playButton;
    private ShimmerFrameLayout shimmerHolder;
    private ImageView trailerIcon;
    private TextView trailerText;
    private TextView videoDescription;
    private TextView videoDescriptionPre1;
    private TextView videoDescriptionPre2;
    private TextView videoDescriptionPre3;
    private TextView videoDescriptionPre4;
    private ImageView videoPoster;
    private TextView videoSeasons;
    private TextView videoTitle;
    private TextView videoYear;
    private TextView videoYearPre;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodVideoPreviewBottomSheet(Context context, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentView = View.inflate(context, R.layout.vod_video_detail_preview, null);
        this.backgroundColor = -13948117;
        initViews();
    }

    private final void initViews() {
        setupShadowDrawable();
        this.shimmerHolder = (ShimmerFrameLayout) this.contentView.findViewById(R.id.shimmer_holder);
        this.close = (ImageView) this.contentView.findViewById(R.id.close_button);
        this.videoTitle = (TextView) this.contentView.findViewById(R.id.video_title);
        this.videoYear = (TextView) this.contentView.findViewById(R.id.video_year);
        this.videoYearPre = (TextView) this.contentView.findViewById(R.id.video_year_pre);
        this.videoSeasons = (TextView) this.contentView.findViewById(R.id.video_seasons);
        this.videoDescription = (TextView) this.contentView.findViewById(R.id.episode_description);
        this.videoDescriptionPre1 = (TextView) this.contentView.findViewById(R.id.video_description_pre1);
        this.videoDescriptionPre2 = (TextView) this.contentView.findViewById(R.id.video_description_pre2);
        this.videoDescriptionPre3 = (TextView) this.contentView.findViewById(R.id.video_description_pre3);
        this.videoDescriptionPre4 = (TextView) this.contentView.findViewById(R.id.video_description_pre4);
        this.videoPoster = (ImageView) this.contentView.findViewById(R.id.video_image);
        this.actionsPre = (TextView) this.contentView.findViewById(R.id.actions_pre);
        this.downloadText = (TextView) this.contentView.findViewById(R.id.download_text);
        this.trailerText = (TextView) this.contentView.findViewById(R.id.trailer_text);
        this.downloadIcon = (ImageView) this.contentView.findViewById(R.id.episode_download_icon);
        this.trailerIcon = (ImageView) this.contentView.findViewById(R.id.trailer_icon);
        this.ageLimit = (TextView) this.contentView.findViewById(R.id.video_age_rate);
        this.playButton = (Button) this.contentView.findViewById(R.id.video_play_button);
        ImageView imageView = this.close;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodVideoPreviewBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VodVideoPreviewBottomSheet.m377initViews$lambda0(this.f$0, view);
                }
            });
        }
        FrameLayout frameLayout = new FrameLayout(getContext()) { // from class: ir.appp.vod.ui.customViews.VodVideoPreviewBottomSheet.initViews.2
            private boolean ignoreLayout;

            {
                new LinkedHashMap();
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) VodVideoPreviewBottomSheet.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) VodVideoPreviewBottomSheet.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                super.onMeasure(i, i2);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                int iDp = (-((BottomSheet) VodVideoPreviewBottomSheet.this).backgroundPaddingTop) - AndroidUtilities.dp(13.0f);
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(15.0f) + ((BottomSheet) VodVideoPreviewBottomSheet.this).backgroundPaddingTop;
                if (Build.VERSION.SDK_INT >= 21) {
                    int i = AndroidUtilities.statusBarHeight;
                    iDp += i;
                    measuredHeight -= i;
                }
                ((BottomSheet) VodVideoPreviewBottomSheet.this).shadowDrawable.setBounds(0, iDp, getMeasuredWidth(), measuredHeight);
                Drawable drawable = ((BottomSheet) VodVideoPreviewBottomSheet.this).shadowDrawable;
                Intrinsics.checkNotNull(canvas);
                drawable.draw(canvas);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        setBackgroundColor(this.backgroundColor);
        this.containerView.addView(this.contentView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        setState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initViews$lambda-0, reason: not valid java name */
    public static final void m377initViews$lambda0(VodVideoPreviewBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void setupShadowDrawable() {
        Rect rect = new Rect();
        Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
        this.shadowDrawable.getPadding(rect);
        this.backgroundPaddingLeft = rect.left;
        this.backgroundPaddingTop = rect.top;
    }

    private final void setState(boolean z) {
        ShimmerFrameLayout shimmerFrameLayout;
        if (z && (shimmerFrameLayout = this.shimmerHolder) != null) {
            shimmerFrameLayout.startShimmer();
        }
        TextView textView = this.actionsPre;
        if (textView != null) {
            textView.setVisibility(z ^ true ? 4 : 0);
        }
        TextView textView2 = this.videoYearPre;
        if (textView2 != null) {
            textView2.setVisibility(z ^ true ? 4 : 0);
        }
        TextView textView3 = this.videoDescriptionPre1;
        if (textView3 != null) {
            textView3.setVisibility(z ^ true ? 4 : 0);
        }
        TextView textView4 = this.videoDescriptionPre2;
        if (textView4 != null) {
            textView4.setVisibility(z ^ true ? 4 : 0);
        }
        TextView textView5 = this.videoDescriptionPre3;
        if (textView5 != null) {
            textView5.setVisibility(z ^ true ? 4 : 0);
        }
        TextView textView6 = this.videoDescriptionPre4;
        if (textView6 != null) {
            textView6.setVisibility(z ^ true ? 4 : 0);
        }
        TextView textView7 = this.videoYear;
        if (textView7 != null) {
            textView7.setVisibility(z ? 4 : 0);
        }
        TextView textView8 = this.ageLimit;
        if (textView8 != null) {
            textView8.setVisibility(z ? 4 : 0);
        }
        TextView textView9 = this.videoSeasons;
        if (textView9 != null) {
            textView9.setVisibility(z ? 4 : 0);
        }
        TextView textView10 = this.videoDescription;
        if (textView10 != null) {
            textView10.setVisibility(z ? 4 : 0);
        }
        ImageView imageView = this.downloadIcon;
        if (imageView != null) {
            imageView.setVisibility(z ? 4 : 0);
        }
        TextView textView11 = this.downloadText;
        if (textView11 != null) {
            textView11.setVisibility(z ? 4 : 0);
        }
        ImageView imageView2 = this.trailerIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(z ? 4 : 0);
        }
        TextView textView12 = this.trailerText;
        if (textView12 == null) {
            return;
        }
        textView12.setVisibility(z ? 4 : 0);
    }

    private final void loadImage(String str) {
        GlideHelper.loadRoundedCorner(getContext(), this.videoPoster, str);
    }

    public final void setVideoDetails(String str, String str2, String str3, String str4, String str5, Integer num) {
        TextView textView = this.videoTitle;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.videoYear;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = this.videoSeasons;
        if (textView3 != null) {
            textView3.setText(str3);
        }
        TextView textView4 = this.videoDescription;
        if (textView4 != null) {
            textView4.setText(str4);
        }
        if (num != null) {
            int iIntValue = num.intValue();
            TextView textView5 = this.ageLimit;
            if (textView5 != null) {
                textView5.setText(iIntValue);
            }
        }
        if (str5 != null) {
            loadImage(str5);
        }
        setState(false);
        ShimmerFrameLayout shimmerFrameLayout = this.shimmerHolder;
        if (shimmerFrameLayout == null) {
            return;
        }
        shimmerFrameLayout.stopShimmer();
    }

    public final void setDelegate(View.OnClickListener onClickListener) {
        View view = this.contentView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        Button button = this.playButton;
        if (button == null) {
            return;
        }
        button.setOnClickListener(onClickListener);
    }
}
