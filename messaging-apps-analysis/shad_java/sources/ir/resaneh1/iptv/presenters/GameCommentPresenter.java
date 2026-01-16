package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GameCommentObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class GameCommentPresenter extends AbstractPresenter<GameCommentObject, MyViewHolder> {
    Context mContext;

    public GameCommentPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.game_comment_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, GameCommentObject gameCommentObject) {
        super.onBindViewHolder((GameCommentPresenter) myViewHolder, (MyViewHolder) gameCommentObject);
        try {
            myViewHolder.textView.setText(BuildConfig.FLAVOR);
            GlideHelper.loadCircle(this.mContext, myViewHolder.imageView, ((GameCommentObject) myViewHolder.item).user_image_url, R.color.transparent);
            myViewHolder.textView.setText(gameCommentObject.getSpannableString());
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<GameCommentObject> {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(GameCommentPresenter gameCommentPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
