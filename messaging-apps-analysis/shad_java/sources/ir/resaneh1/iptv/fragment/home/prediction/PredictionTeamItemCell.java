package ir.resaneh1.iptv.fragment.home.prediction;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PredictionTeamItemCell extends FrameLayout {
    private final Context context;
    private final ImageView logoIv;
    private final TextView nameTv;

    private boolean isValid(HomePageModels.PredictionSectionTeam predictionSectionTeam) {
        return predictionSectionTeam != null;
    }

    public PredictionTeamItemCell(Context context) {
        super(context);
        this.context = context;
        ImageView imageView = new ImageView(context);
        this.logoIv = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        TextView textViewCreateTv = createTv();
        this.nameTv = textViewCreateTv;
        addView(imageView, LayoutHelper.createFrame(40, 40, 5));
        addView(textViewCreateTv, LayoutHelper.createFrame(-2, 40, 5, 0.0f, 0.0f, 50.0f, 0.0f));
    }

    private TextView createTv() {
        return new CustomTextView.Builder(this.context).setText(BuildConfig.FLAVOR).setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).removeBackgrounds().setGravity(16).build();
    }

    public void setData(HomePageModels.PredictionSectionTeam predictionSectionTeam) {
        resetData();
        if (isValid(predictionSectionTeam)) {
            VisibilityHelper.showViews(this);
            String str = predictionSectionTeam.image_url;
            if (str != null) {
                GlideHelper.load(this.context, this.logoIv, str, R.drawable.home_team_placeholder);
            }
            String str2 = predictionSectionTeam.name;
            if (str2 != null) {
                this.nameTv.setText(str2);
                return;
            }
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    void resetData() {
        this.logoIv.setImageDrawable(null);
        this.nameTv.setText(BuildConfig.FLAVOR);
    }
}
