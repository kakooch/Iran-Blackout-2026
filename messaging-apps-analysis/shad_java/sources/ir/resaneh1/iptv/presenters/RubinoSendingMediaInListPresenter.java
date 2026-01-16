package ir.resaneh1.iptv.presenters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.PlayerPresenterItem;
import ir.resaneh1.iptv.model.SendingMediaInfo;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import ir.resaneh1.iptv.presenters.PlayerPresenter;

/* loaded from: classes3.dex */
public class RubinoSendingMediaInListPresenter extends AbstractPresenter<SendingMediaInfo, ViewHolder> {
    public static ViewHolder lastPlayingHolder;
    public int height;
    public OnDoneListener onDelete;
    View.OnClickListener onDeleteClick;
    public PlayerPresenter playerPresenter;
    public int width;

    public RubinoSendingMediaInListPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
        this.onDeleteClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.RubinoSendingMediaInListPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewHolder viewHolder = (ViewHolder) view.getTag();
                if (viewHolder != null) {
                    PlayerPresenter.destroyPlayer(((AbstractPresenter) RubinoSendingMediaInListPresenter.this).context);
                    RubinoSendingMediaInListPresenter.lastPlayingHolder = null;
                    OnDoneListener onDoneListener = RubinoSendingMediaInListPresenter.this.onDelete;
                    if (onDoneListener != null) {
                        onDoneListener.onDone(viewHolder);
                    }
                }
            }
        };
        this.playerPresenter = new PlayerPresenter((Activity) context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.rubino_sending_media_in_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        viewGroup.setTag(viewHolder);
        viewHolder.imageViewClose.setTag(viewHolder);
        viewHolder.imageViewClose.setOnClickListener(this.onDeleteClick);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, SendingMediaInfo sendingMediaInfo) {
        super.onBindViewHolder((RubinoSendingMediaInListPresenter) viewHolder, (ViewHolder) sendingMediaInfo);
        if (this.width > 0 && this.height > 0) {
            viewHolder.imageView.getLayoutParams().width = this.width;
            viewHolder.imageView.getLayoutParams().height = this.height;
            viewHolder.frameLayout.getLayoutParams().width = this.width;
            viewHolder.frameLayout.getLayoutParams().height = this.height;
        }
        viewHolder.imageViewVideoIcon.setVisibility(4);
        GlideHelper.load(this.context, viewHolder.imageView, sendingMediaInfo.path, R.drawable.shape_white_background);
    }

    public void playMedia(ViewHolder viewHolder, long j, long j2) {
        PlayerPresenter.destroyPlayer(this.context);
        lastPlayingHolder = viewHolder;
        viewHolder.frameLayout.removeAllViews();
        viewHolder.playerHolder = this.playerPresenter.createViewHolderAndBind(new PlayerPresenterItem(((SendingMediaInfo) viewHolder.item).path));
        viewHolder.frameLayout.removeAllViews();
        viewHolder.frameLayout.addView(viewHolder.playerHolder.itemView);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewHolder.frameLayout, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 0.0f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.play(objectAnimatorOfPropertyValuesHolder);
        animatorSet.start();
        this.playerPresenter.playStreamInsta(viewHolder.playerHolder, ((SendingMediaInfo) viewHolder.item).path, j, j2, false);
    }

    public void playMedia(ViewHolder viewHolder) {
        playMedia(viewHolder, -1L, -1L);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<SendingMediaInfo> {
        public FrameLayout frameLayout;
        public ImageView imageView;
        public ImageView imageViewClose;
        public ImageView imageViewVideoIcon;
        public PlayerPresenter.MyViewHolder playerHolder;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            view.findViewById(R.id.progressBar);
            this.frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
            this.imageViewVideoIcon = (ImageView) view.findViewById(R.id.imageViewVideoIcon);
            this.imageViewClose = (ImageView) view.findViewById(R.id.imageViewClose);
        }
    }
}
