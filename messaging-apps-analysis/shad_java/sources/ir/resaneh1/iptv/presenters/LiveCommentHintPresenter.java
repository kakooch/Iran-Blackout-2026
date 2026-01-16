package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.LiveModels;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;

/* loaded from: classes3.dex */
public class LiveCommentHintPresenter extends AbstractPresenter<LiveModels.CommentLiveHintObject, MyViewHolder> {
    Context mContext;

    public LiveCommentHintPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.live_comment_hint_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, LiveModels.CommentLiveHintObject commentLiveHintObject) {
        super.onBindViewHolder((LiveCommentHintPresenter) myViewHolder, (MyViewHolder) commentLiveHintObject);
        try {
            TextView textView = myViewHolder.textView;
            textView.setText(Emoji.replaceEmoji(commentLiveHintObject.text, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<LiveModels.CommentLiveHintObject> {
        TextView textView;

        public MyViewHolder(LiveCommentHintPresenter liveCommentHintPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
