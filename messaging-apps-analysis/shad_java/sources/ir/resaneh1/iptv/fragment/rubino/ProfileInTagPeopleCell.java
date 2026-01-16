package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ProfileInTagPeopleCell extends FrameLayout {
    public PostTagObject currentTagObject;
    private ProfileTagPeopleDelegate delegate;
    public ImageView imageViewClose;
    public Context mContext;
    private final View.OnClickListener onCloseListener;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public InsStoryAvatarView userImageView;

    public interface ProfileTagPeopleDelegate {
        void onCloseClick(PostTagObject postTagObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        PostTagObject postTagObject;
        ProfileTagPeopleDelegate profileTagPeopleDelegate = this.delegate;
        if (profileTagPeopleDelegate == null || (postTagObject = this.currentTagObject) == null) {
            return;
        }
        profileTagPeopleDelegate.onCloseClick(postTagObject);
    }

    public void setDelegate(ProfileTagPeopleDelegate profileTagPeopleDelegate) {
        this.delegate = profileTagPeopleDelegate;
    }

    public ProfileInTagPeopleCell(Context context) {
        super(context);
        this.onCloseListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileInTagPeopleCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        };
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.rubino_profile_in_tag_people, (ViewGroup) null, false);
        addView(viewGroup);
        this.textView1 = (TextView) viewGroup.findViewById(R.id.textView1);
        this.textView2 = (TextView) viewGroup.findViewById(R.id.textView2);
        this.textView3 = (TextView) viewGroup.findViewById(R.id.textView3);
        this.textView1.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        TextView textView = this.textView2;
        int i = Theme.key_rubinoGrayColor;
        textView.setTextColor(Theme.getColor(i));
        viewGroup.findViewById(R.id.textContainer);
        this.userImageView = (InsStoryAvatarView) viewGroup.findViewById(R.id.imageViewUser);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.imageViewClose);
        this.imageViewClose = imageView;
        imageView.setColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP);
        viewGroup.findViewById(R.id.container);
        this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView3.setTypeface(Theme.getRubinoTypeFaceRegular());
    }

    public void setProfile(PostTagObject postTagObject) {
        RubinoProfileObject rubinoProfileObject;
        this.currentTagObject = postTagObject;
        CharSequence charSequence = BuildConfig.FLAVOR;
        if (postTagObject != null && (rubinoProfileObject = postTagObject.profileObject) != null) {
            TextView textView = this.textView1;
            CharSequence charSequence2 = rubinoProfileObject.usernameSpannableString;
            if (charSequence2 != null) {
                charSequence = charSequence2;
            }
            textView.setText(charSequence);
            String str = postTagObject.name;
            if (str != null && !str.isEmpty()) {
                this.textView2.setText(postTagObject.name);
                this.textView2.setVisibility(0);
            } else {
                this.textView2.setVisibility(8);
            }
            this.textView3.setVisibility(8);
            this.userImageView.setVisibility(0);
            GlideHelper.loadCircle(this.mContext, this.userImageView, rubinoProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
            this.imageViewClose.setOnClickListener(this.onCloseListener);
            return;
        }
        this.userImageView.setVisibility(4);
        this.textView1.setText(BuildConfig.FLAVOR);
        this.textView2.setText(BuildConfig.FLAVOR);
    }
}
