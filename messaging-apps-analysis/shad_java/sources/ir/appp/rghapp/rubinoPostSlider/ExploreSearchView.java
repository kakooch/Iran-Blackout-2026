package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity;
import ir.resaneh1.iptv.helper.FlavorHelper;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ExploreSearchView extends FrameLayout {
    public ExploreSearchView(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(R.drawable.rubino_explore_search_icon);
        int i = Theme.key_rubinoBlackColor;
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        imageView.setLayoutParams(LayoutHelper.createFrame(26, 26, 19));
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_profile_plus));
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP));
        imageView2.setLayoutParams(LayoutHelper.createFrame(26, 26, 21));
        if (FlavorHelper.isShad()) {
            imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_home_shadino));
        }
        imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.appp.rghapp.rubinoPostSlider.ExploreSearchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FlavorHelper.isShad()) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(RubinoPostListActivity.homeRecentFollowingType));
                } else {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoProfileListActivity(RubinoProfileListActivity.suggestedType));
                }
            }
        });
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString(R.string.rubinoSearch));
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setTextSize(1, 17.0f);
        textView.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
        textView.setGravity(21);
        int iDp = AndroidUtilities.dp(42.0f);
        LinearLayout.LayoutParams layoutParamsCreateLinear = LayoutHelper.createLinear(-1, 44, 3);
        layoutParamsCreateLinear.setMargins(iDp, 0, iDp, 0);
        textView.setLayoutParams(layoutParamsCreateLinear);
        addView(textView);
        addView(imageView);
        addView(imageView2);
        setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
    }
}
