package ir.resaneh1.iptv.fragment.rubino;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.AndroidUtilities;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RubinoRelatedProfileCell extends FrameLayout {
    TextView buttonText;
    View buttonView;
    public CardView cardView;
    private Context context;
    ImageView imageView;
    TextView nameTextView;
    View.OnClickListener onFollowClick;
    public RubinoProfileObject profileObject;
    GradientDrawable shape;
    TextView userNameTextView;

    public RubinoRelatedProfileCell(Context context) {
        super(context);
        this.onFollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoRelatedProfileCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog dialogOnFollowButtonInProfileClicked;
                if (RubinoRelatedProfileCell.this.profileObject == null || (dialogOnFollowButtonInProfileClicked = RubinoController.getInstance(UserConfig.selectedAccount).onFollowButtonInProfileClicked(RubinoRelatedProfileCell.this.profileObject)) == null) {
                    return;
                }
                dialogOnFollowButtonInProfileClicked.show();
            }
        };
        this.context = context;
        GradientDrawable gradientDrawable = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        this.shape = gradientDrawable;
        gradientDrawable.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(Theme.key_rubinoFollowingBorderColor));
        GradientDrawable gradientDrawable2 = this.shape;
        int i = Theme.key_windowBackgroundWhite;
        gradientDrawable2.setColor(Theme.getColor(i));
        LayoutInflater.from(context).inflate(R.layout.insta_related_profile_cell, (ViewGroup) this, true);
        this.cardView = (CardView) findViewById(R.id.cardView);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.nameTextView = (TextView) findViewById(R.id.textViewName);
        this.userNameTextView = (TextView) findViewById(R.id.textViewUserName);
        this.buttonText = (TextView) findViewById(R.id.textViewButton);
        View viewFindViewById = findViewById(R.id.button);
        this.buttonView = viewFindViewById;
        viewFindViewById.setOnClickListener(this.onFollowClick);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.userNameTextView.setSingleLine(true);
        this.userNameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.buttonText.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.userNameTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
        TextView textView = this.userNameTextView;
        int i2 = Theme.key_dialogTextBlack;
        textView.setTextColor(Theme.getColor(i2));
        this.buttonText.setTextColor(Theme.getColor(i2));
        this.nameTextView.setTextColor(Theme.getColor(Theme.key_dialogTextGray2));
        this.cardView.setCardBackgroundColor(Theme.getColor(i));
        setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoRelatedProfileCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RubinoRelatedProfileCell.this.profileObject != null) {
                    new MainClickHandler().onRubinoProfileClick(RubinoRelatedProfileCell.this.profileObject);
                }
            }
        });
    }

    public void setData(RubinoProfileObject rubinoProfileObject) {
        this.profileObject = rubinoProfileObject;
        String str = rubinoProfileObject.full_thumbnail_url;
        if (str != null) {
            GlideHelper.loadCircle(this.context, this.imageView, str, R.drawable.rubino_grey_avatar_placeholder);
        }
        this.userNameTextView.setText(rubinoProfileObject.username);
        String str2 = rubinoProfileObject.name;
        if (str2 != null && !str2.isEmpty()) {
            this.nameTextView.setVisibility(0);
            this.nameTextView.setText(rubinoProfileObject.name);
        } else {
            this.nameTextView.setVisibility(4);
        }
        setButton();
    }

    private void setButton() {
        if (this.profileObject == null) {
            this.buttonText.setText(BuildConfig.FLAVOR);
            return;
        }
        if (RubinoController.getInstance(UserConfig.selectedAccount).isProfileFollowRequested(this.profileObject)) {
            this.buttonText.setText(LocaleController.getString(R.string.request_send));
            this.buttonText.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
            this.buttonView.setBackground(this.shape);
        } else if (RubinoController.getInstance(UserConfig.selectedAccount).isProfileFollowed(this.profileObject)) {
            this.buttonText.setText(LocaleController.getString(R.string.following));
            this.buttonText.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
            this.buttonView.setBackground(this.shape);
        } else {
            this.buttonText.setText(LocaleController.getString(R.string.follow));
            this.buttonView.setBackground(this.context.getResources().getDrawable(R.drawable.rubino_follow_background_shape_blue));
            this.buttonText.setTextColor(-1);
        }
    }
}
