package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodLoadingCell.kt */
/* loaded from: classes3.dex */
public final class VodLoadingCell extends FrameLayout {
    private final View contentView;
    private LoadingMode loadingMode;
    private ProgressBar loadingProgressBar;
    private TextView retryText;
    private ImageView retryView;

    /* compiled from: VodLoadingCell.kt */
    public enum LoadingMode {
        LOADING,
        RETRY
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodLoadingCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.contentView = FrameLayout.inflate(getContext(), R.layout.vod_loading, null);
        this.loadingMode = LoadingMode.LOADING;
        initViews();
    }

    public final LoadingMode getLoadingMode() {
        return this.loadingMode;
    }

    public final void setLoadingMode(LoadingMode loadingMode) {
        Intrinsics.checkNotNullParameter(loadingMode, "<set-?>");
        this.loadingMode = loadingMode;
    }

    private final void initViews() {
        this.loadingProgressBar = (ProgressBar) this.contentView.findViewById(R.id.vod_loading_progress_bar);
        this.retryView = (ImageView) this.contentView.findViewById(R.id.vod_retry);
        this.retryText = (TextView) this.contentView.findViewById(R.id.vod_retry_txt);
        addView(this.contentView);
    }

    public final void setMode(LoadingMode loadingMode) {
        Intrinsics.checkNotNullParameter(loadingMode, "loadingMode");
        this.loadingMode = loadingMode;
        if (loadingMode == LoadingMode.LOADING) {
            ProgressBar progressBar = this.loadingProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            ImageView imageView = this.retryView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.retryText;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        ProgressBar progressBar2 = this.loadingProgressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        ImageView imageView2 = this.retryView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        TextView textView2 = this.retryText;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(0);
    }
}
