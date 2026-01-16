package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ChangeMyProfileActionBarView extends FrameLayout {
    int currentAccount;
    public ImageView imageViewTriangle;
    public Context mContext;
    private RubinoChangeProfileDialog profileList;
    public TextView textView;

    public ChangeMyProfileActionBarView(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rubino_my_profile_actionbar, (ViewGroup) null, false);
        addView(viewInflate);
        this.imageViewTriangle = (ImageView) viewInflate.findViewById(R.id.imageViewTriangle);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textView = textView;
        textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.imageViewTriangle.setColorFilter(new PorterDuffColorFilter(ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900), PorterDuff.Mode.SRC_ATOP));
        this.imageViewTriangle.setColorFilter(Theme.getColor(Theme.key_actionBarDefaultIcon), PorterDuff.Mode.SRC_ATOP);
        this.textView.setTextColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
        setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ChangeMyProfileActionBarView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChangeMyProfileActionBarView changeMyProfileActionBarView = ChangeMyProfileActionBarView.this;
                changeMyProfileActionBarView.profileList = RubinoController.getInstance(changeMyProfileActionBarView.currentAccount).getChangeProfileAlert(ChangeMyProfileActionBarView.this.mContext);
                ChangeMyProfileActionBarView.this.profileList.show();
            }
        });
    }

    public void changeName(String str, boolean z, boolean z2) {
        if (z || z2) {
            SpannableString spannableString = new SpannableString("  " + str);
            ImageSpan imageSpanVerifyOrSale = RubinoController.getInstance(this.currentAccount).getImageSpanVerifyOrSale(z, z2, 16, 2);
            if (imageSpanVerifyOrSale != null) {
                spannableString.setSpan(imageSpanVerifyOrSale, 0, 1, 17);
            }
            this.textView.setText(spannableString);
            return;
        }
        this.textView.setText(str);
    }
}
