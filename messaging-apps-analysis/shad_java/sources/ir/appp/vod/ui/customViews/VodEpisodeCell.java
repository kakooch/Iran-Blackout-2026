package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.vod.domain.model.output.VodBriefEpisodeEntity;
import ir.appp.vod.util.VodViewExtensionsKt;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;

/* compiled from: VodEpisodeCell.kt */
/* loaded from: classes3.dex */
public final class VodEpisodeCell extends FrameLayout {
    private final View contentView;
    private TextView episodeDescriptionTextView;
    private TextView episodeDurationTextView;
    private ImageView episodeImageView;
    private ProgressBar episodeProgressBar;
    private TextView episodeTitleTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodEpisodeCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.contentView = FrameLayout.inflate(getContext(), R.layout.vod_episods_item, null);
        initViews();
    }

    private final void initViews() {
        addView(this.contentView);
        this.episodeImageView = (ImageView) this.contentView.findViewById(R.id.episode_image);
        this.episodeTitleTextView = (TextView) this.contentView.findViewById(R.id.episode_title);
        this.episodeDurationTextView = (TextView) this.contentView.findViewById(R.id.episode_time);
        this.episodeDescriptionTextView = (TextView) this.contentView.findViewById(R.id.episode_description);
        this.episodeProgressBar = (ProgressBar) this.contentView.findViewById(R.id.episode_progressbar);
        loadImage(BuildConfig.FLAVOR);
        TextView textView = this.episodeDurationTextView;
        if (textView != null) {
            textView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iran_yekan));
        }
        TextView textView2 = this.episodeTitleTextView;
        if (textView2 != null) {
            textView2.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iran_yekan));
        }
        TextView textView3 = this.episodeDescriptionTextView;
        if (textView3 == null) {
            return;
        }
        textView3.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iran_yekan));
    }

    private final void loadImage(String str) {
        GlideHelper.loadRoundedCorner(getContext(), this.episodeImageView, str, AndroidUtilities.dp(1.5f), R.drawable.vod_round_rect_dark_gray_1dp);
    }

    public final void setData(VodBriefEpisodeEntity vodEpisodeObject) {
        Intrinsics.checkNotNullParameter(vodEpisodeObject, "vodEpisodeObject");
        String imageUrl = vodEpisodeObject.getImageUrl();
        if (imageUrl != null) {
            loadImage(imageUrl);
        }
        TextView textView = this.episodeTitleTextView;
        String str = BuildConfig.FLAVOR;
        if (textView != null) {
            String title = vodEpisodeObject.getTitle();
            if (title == null) {
                title = BuildConfig.FLAVOR;
            }
            textView.setText(title);
        }
        TextView textView2 = this.episodeDurationTextView;
        if (textView2 != null) {
            Long mediaDuration = vodEpisodeObject.getMediaDuration();
            textView2.setText(mediaDuration == null ? null : VodViewExtensionsKt.toReadableTime(mediaDuration.longValue()));
        }
        TextView textView3 = this.episodeDescriptionTextView;
        if (textView3 != null) {
            String shortDescription = vodEpisodeObject.getShortDescription();
            if (shortDescription != null) {
                str = shortDescription;
            }
            textView3.setText(str);
        }
        setProgressbar(vodEpisodeObject);
    }

    private final void setProgressbar(VodBriefEpisodeEntity vodBriefEpisodeEntity) {
        Long lastPosition;
        if (vodBriefEpisodeEntity.getLastPosition() != null && (((lastPosition = vodBriefEpisodeEntity.getLastPosition()) == null || lastPosition.longValue() != 0) && vodBriefEpisodeEntity.getMediaDuration() != null)) {
            ProgressBar progressBar = this.episodeProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            ProgressBar progressBar2 = this.episodeProgressBar;
            if (progressBar2 == null) {
                return;
            }
            Long lastPosition2 = vodBriefEpisodeEntity.getLastPosition();
            Intrinsics.checkNotNull(lastPosition2);
            float fLongValue = lastPosition2.longValue();
            Float fValueOf = vodBriefEpisodeEntity.getMediaDuration() == null ? null : Float.valueOf(r6.longValue());
            Intrinsics.checkNotNull(fValueOf);
            progressBar2.setProgress((int) ((fLongValue / fValueOf.floatValue()) * 100));
            return;
        }
        ProgressBar progressBar3 = this.episodeProgressBar;
        if (progressBar3 == null) {
            return;
        }
        progressBar3.setVisibility(8);
    }

    public final void setListener(final Function0<Unit> clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.contentView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodEpisodeCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodEpisodeCell.m350setListener$lambda1(clickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setListener$lambda-1, reason: not valid java name */
    public static final void m350setListener$lambda1(Function0 clickListener, View view) {
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        clickListener.invoke();
    }
}
