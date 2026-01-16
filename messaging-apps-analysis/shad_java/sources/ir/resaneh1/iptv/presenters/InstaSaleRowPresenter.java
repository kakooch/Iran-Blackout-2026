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
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.InstaSaleNotificationObject;
import ir.resaneh1.iptv.model.InstaSetReadInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class InstaSaleRowPresenter extends AbstractPresenter<InstaSaleNotificationObject, MyViewHolder> {
    private int currentAccount;
    private Context mContext;
    View.OnLongClickListener onLongClickListener;
    View.OnClickListener onPostClickListener;
    View.OnClickListener onUserClickListener;

    public InstaSaleRowPresenter(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onLongClickListener = new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.presenters.InstaSaleRowPresenter.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                ((InstaSaleNotificationObject) myViewHolder.item).is_read = !((InstaSaleNotificationObject) r0).is_read;
                InstaSaleRowPresenter.this.setBackGroundColor(myViewHolder);
                ApiRequestMessanger apiRequestMessanger = ApiRequestMessanger.getInstance(InstaSaleRowPresenter.this.currentAccount);
                Titem titem = myViewHolder.item;
                apiRequestMessanger.instaSetReadSale(new InstaSetReadInput(((InstaSaleNotificationObject) titem).id, ((InstaSaleNotificationObject) titem).is_read), new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.presenters.InstaSaleRowPresenter.1.1
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                    }
                });
                return true;
            }
        };
        this.onUserClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaSaleRowPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().onMessengerUsernameClicked(((InstaSaleNotificationObject) ((MyViewHolder) view.getTag(R.id.viewTag2)).item).customer_username);
            }
        };
        this.onPostClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaSaleRowPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().openRubinoPost(((InstaSaleNotificationObject) ((MyViewHolder) view.getTag(R.id.viewTag2)).item).getPostObject(UserConfig.selectedAccount), false);
            }
        };
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.insta_new_event_row, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(viewInflate);
        myViewHolder.textView.setTag(myViewHolder);
        myViewHolder.textView.setOnLongClickListener(this.onLongClickListener);
        myViewHolder.container.setTag(myViewHolder);
        myViewHolder.container.setOnLongClickListener(this.onLongClickListener);
        viewInflate.setTag(myViewHolder);
        viewInflate.setOnLongClickListener(this.onLongClickListener);
        myViewHolder.userImageView.setTag(R.id.viewTag2, myViewHolder);
        myViewHolder.userImageView.setOnClickListener(this.onUserClickListener);
        myViewHolder.postImageView.setTag(R.id.viewTag2, myViewHolder);
        myViewHolder.postImageView.setOnClickListener(this.onPostClickListener);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, InstaSaleNotificationObject instaSaleNotificationObject) {
        super.onBindViewHolder((InstaSaleRowPresenter) myViewHolder, (MyViewHolder) instaSaleNotificationObject);
        if (instaSaleNotificationObject.getPostImageUrl().equals(BuildConfig.FLAVOR)) {
            myViewHolder.postImageView.setVisibility(8);
        } else {
            myViewHolder.postImageView.setVisibility(0);
            GlideHelper.load(this.mContext, myViewHolder.postImageView, instaSaleNotificationObject.getPostImageUrl(), R.color.transparent);
        }
        myViewHolder.textView.setMovementMethod(LinkMovementMethod.getInstance());
        myViewHolder.textView.setText(((InstaSaleNotificationObject) myViewHolder.item).getText());
        myViewHolder.textView.append(SpanHelper.makeWithColorAndRelativeSize("\n " + NumberUtils.toPersian(instaSaleNotificationObject.getPersianDate()), this.mContext.getResources().getColor(R.color.grey_700), 0.8f));
        GlideHelper.loadCircle(this.mContext, myViewHolder.userImageView, instaSaleNotificationObject.getUserImageUrl(), R.drawable.placeholder_avatar_man);
        myViewHolder.userImageView2.setVisibility(8);
        setBackGroundColor(myViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackGroundColor(MyViewHolder myViewHolder) {
        if (((InstaSaleNotificationObject) myViewHolder.item).is_read) {
            myViewHolder.itemView.setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
        } else {
            myViewHolder.itemView.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        }
    }

    public static class MyViewHolder extends AbstractPresenter.AbstractViewHolder<InstaSaleNotificationObject> {
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
