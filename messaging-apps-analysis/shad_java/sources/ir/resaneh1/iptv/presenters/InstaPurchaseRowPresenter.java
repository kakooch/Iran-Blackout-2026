package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaPurchaseNotificationObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class InstaPurchaseRowPresenter extends AbstractPresenter<InstaPurchaseNotificationObject, MyViewHolder> {
    private Context mContext;
    View.OnClickListener onClickListener;
    View.OnClickListener onUserClickListener;

    public InstaPurchaseRowPresenter(Context context) {
        super(context);
        this.onClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaPurchaseRowPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().openRubinoPost(((InstaPurchaseNotificationObject) ((MyViewHolder) view.getTag()).item).getPostObject(UserConfig.selectedAccount), false);
            }
        };
        this.onUserClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaPurchaseRowPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag(R.id.viewTag2);
                if (((InstaPurchaseNotificationObject) myViewHolder.item).post_profile_id != null) {
                    new MainClickHandler().openProfileOrRubinoTab(new InstaProfileObject(((InstaPurchaseNotificationObject) myViewHolder.item).post_profile_id));
                }
            }
        };
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.insta_new_event_row, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(viewInflate);
        myViewHolder.textView.setTag(myViewHolder);
        myViewHolder.textView.setOnClickListener(this.onClickListener);
        myViewHolder.container.setTag(myViewHolder);
        myViewHolder.container.setOnClickListener(this.onClickListener);
        viewInflate.setTag(myViewHolder);
        viewInflate.setOnClickListener(this.onClickListener);
        myViewHolder.userImageView.setTag(R.id.viewTag2, myViewHolder);
        myViewHolder.userImageView.setOnClickListener(this.onUserClickListener);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, InstaPurchaseNotificationObject instaPurchaseNotificationObject) {
        super.onBindViewHolder((InstaPurchaseRowPresenter) myViewHolder, (MyViewHolder) instaPurchaseNotificationObject);
        if (instaPurchaseNotificationObject.getPostImageUrl().equals(BuildConfig.FLAVOR)) {
            myViewHolder.postImageView.setVisibility(8);
        } else {
            myViewHolder.postImageView.setVisibility(0);
            GlideHelper.load(this.mContext, myViewHolder.postImageView, instaPurchaseNotificationObject.getPostImageUrl(), R.color.transparent);
        }
        myViewHolder.textView.setMovementMethod(LinkMovementMethod.getInstance());
        myViewHolder.textView.setText(((InstaPurchaseNotificationObject) myViewHolder.item).getText());
        myViewHolder.textView.append(SpanHelper.makeWithColorAndRelativeSize("\n " + NumberUtils.toPersian(instaPurchaseNotificationObject.getPersianDate()), this.mContext.getResources().getColor(R.color.grey_700), 0.8f));
        myViewHolder.userImageView.setVisibility(0);
        GlideHelper.loadCircle(this.mContext, myViewHolder.userImageView, instaPurchaseNotificationObject.getUserImageUrl(), R.drawable.placeholder_avatar_man);
        myViewHolder.userImageView2.setVisibility(8);
    }

    public static class MyViewHolder extends AbstractPresenter.AbstractViewHolder<InstaPurchaseNotificationObject> {
        public View container;
        public ImageView postImageView;
        public TextView textView;
        public ImageView userImageView;
        public ImageView userImageView2;

        public MyViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.userImageView = (ImageView) view.findViewById(R.id.imageViewUser);
            this.userImageView2 = (ImageView) view.findViewById(R.id.imageViewUser2);
            this.postImageView = (ImageView) view.findViewById(R.id.imageViewPost);
            this.container = view.findViewById(R.id.container);
        }
    }
}
