package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.LiveModels;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class LiveCommentPresenter extends AbstractPresenter<LiveModels.LiveCommentObject, MyViewHolder> {
    Context mContext;

    public LiveCommentPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.live_comment_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, LiveModels.LiveCommentObject liveCommentObject) {
        super.onBindViewHolder((LiveCommentPresenter) myViewHolder, (MyViewHolder) liveCommentObject);
        try {
            if (liveCommentObject.full_profile_thumbnail_url != null) {
                myViewHolder.backupImageView.setVisibility(4);
                myViewHolder.imageViewUser.setVisibility(0);
                String str = liveCommentObject.full_profile_thumbnail_url;
                if (str != null && !str.isEmpty()) {
                    GlideHelper.loadCircle(this.context, myViewHolder.imageViewUser, liveCommentObject.full_profile_thumbnail_url, R.color.grey_100);
                } else {
                    myViewHolder.imageViewUser.setImageResource(R.drawable.placeholder_avatar_man);
                }
            }
            myViewHolder.textView.setText(Emoji.replaceEmoji(liveCommentObject.getSpannableString(), myViewHolder.textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<LiveModels.LiveCommentObject> {
        AvatarDrawable avatarDrawable;
        BackupImageView backupImageView;
        ImageView imageViewUser;
        TextView textView;

        public MyViewHolder(LiveCommentPresenter liveCommentPresenter, View view) {
            super(view);
            this.avatarDrawable = new AvatarDrawable();
            this.textView = (TextView) view.findViewById(R.id.textView);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.imageViewContainer);
            BackupImageView backupImageView = new BackupImageView(view.getContext());
            this.backupImageView = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(16.0f));
            this.avatarDrawable.setTextSize(AndroidUtilities.dp(13.0f));
            frameLayout.addView(this.backupImageView, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView = new ImageView(view.getContext());
            this.imageViewUser = imageView;
            frameLayout.addView(imageView, LayoutHelper.createFrame(-1, -1.0f));
            this.imageViewUser.setVisibility(4);
        }
    }
}
