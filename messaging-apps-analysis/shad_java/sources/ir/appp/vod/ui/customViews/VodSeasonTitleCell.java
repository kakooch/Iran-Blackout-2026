package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodSeasonTitleCell.kt */
/* loaded from: classes3.dex */
public final class VodSeasonTitleCell extends FrameLayout {
    private final View contentView;
    private View holder;
    private ImageView showMoreSeasonImageView;
    private TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodSeasonTitleCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        View viewInflate = FrameLayout.inflate(context, R.layout.vod_episode_title_cell, null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(context, R.layou…episode_title_cell, null)");
        this.contentView = viewInflate;
        initViews();
    }

    public final View getContentView() {
        return this.contentView;
    }

    private final void initViews() {
        this.holder = this.contentView.findViewById(R.id.season_title_holder);
        this.title = (TextView) this.contentView.findViewById(R.id.season_title);
        this.showMoreSeasonImageView = (ImageView) this.contentView.findViewById(R.id.show_season_imageView);
        addView(this.contentView);
    }

    public final void setText(String str) {
        TextView textView = this.title;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void enableShowMoreOption(boolean z) {
        ImageView imageView = this.showMoreSeasonImageView;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
        if (z) {
            View view = this.holder;
            if (view == null) {
                return;
            }
            view.setBackgroundResource(R.drawable.vod_season_title_background);
            return;
        }
        View view2 = this.holder;
        if (view2 == null) {
            return;
        }
        view2.setBackground(null);
    }
}
