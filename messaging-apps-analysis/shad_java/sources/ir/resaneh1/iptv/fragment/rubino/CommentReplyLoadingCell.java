package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class CommentReplyLoadingCell extends FrameLayout {
    public RubinoCommentObject commentObject;
    public Context mContext;
    public TextView textView;

    public CommentReplyLoadingCell(Context context) {
        super(context);
        this.mContext = context;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextSize(2, 12.0f);
        this.textView.setTextColor(this.mContext.getResources().getColor(R.color.grey_500));
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView.setGravity(3);
        addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 19, 100.0f, 8.0f, 16.0f, 8.0f));
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_400));
        addView(frameLayout, LayoutHelper.createFrame(28, 1.0f, 19, 66.0f, 8.0f, 0.0f, 8.0f));
    }

    public void setLoadingCommentReplies(RubinoCommentObject rubinoCommentObject) {
        this.commentObject = rubinoCommentObject;
        updateLoadingState(rubinoCommentObject.isReplyLoading);
    }

    public void setHideCommentReplies(RubinoCommentObject rubinoCommentObject) {
        this.commentObject = rubinoCommentObject;
        this.textView.setText(LocaleController.getString(R.string.rubinoHideReplies));
    }

    public void updateLoadingState(boolean z) {
        RubinoCommentObject rubinoCommentObject = this.commentObject;
        rubinoCommentObject.isReplyLoading = z;
        if (z) {
            this.textView.setText(LocaleController.getString(R.string.loading));
        } else if (rubinoCommentObject.isRepliesHidden && rubinoCommentObject.replyArray.size() > 0) {
            this.textView.setText(LocaleController.formatString("view_comments", R.string.view_comments, Integer.valueOf(this.commentObject.replyArray.size())));
        } else {
            this.textView.setText(LocaleController.formatString("view_comments", R.string.view_comments, Integer.valueOf(this.commentObject.getNotLoadedReplyCount())));
        }
    }
}
