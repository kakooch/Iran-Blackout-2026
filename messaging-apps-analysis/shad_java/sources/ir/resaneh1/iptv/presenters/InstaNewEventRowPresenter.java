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
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.messanger.RubikaNotificationManager;
import ir.resaneh1.iptv.model.InstaRemoveNotificationInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoNewEventObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class InstaNewEventRowPresenter extends AbstractPresenter<RubinoNewEventObject, MyViewHolder> {
    private int currentAccount;
    private Context mContext;
    View.OnClickListener onClickListener;
    View.OnLongClickListener onRemoveNotifClick;
    public OnDoneListener onRemoveNotifDone;
    View.OnClickListener onUserClickListener;

    public InstaNewEventRowPresenter(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaNewEventRowPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().onInstaEventClick((RubinoNewEventObject) ((MyViewHolder) view.getTag()).item);
            }
        };
        this.onUserClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaNewEventRowPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag(R.id.viewTag2);
                if (((RubinoNewEventObject) myViewHolder.item).getUserProfile() == null || ApplicationLoader.applicationActivity == null) {
                    return;
                }
                new MainClickHandler().onRubinoProfileClick(((RubinoNewEventObject) myViewHolder.item).getUserProfile());
            }
        };
        this.onRemoveNotifClick = new AnonymousClass3();
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.insta_new_event_row, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(viewInflate);
        myViewHolder.textView.setTag(myViewHolder);
        myViewHolder.textView.setOnClickListener(this.onClickListener);
        myViewHolder.textView.setOnLongClickListener(this.onRemoveNotifClick);
        myViewHolder.container.setTag(myViewHolder);
        myViewHolder.container.setOnClickListener(this.onClickListener);
        myViewHolder.container.setOnLongClickListener(this.onRemoveNotifClick);
        viewInflate.setTag(myViewHolder);
        viewInflate.setOnClickListener(this.onClickListener);
        viewInflate.setOnLongClickListener(this.onRemoveNotifClick);
        myViewHolder.userImageView.setTag(R.id.viewTag2, myViewHolder);
        myViewHolder.userImageView.setOnClickListener(this.onUserClickListener);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, RubinoNewEventObject rubinoNewEventObject) {
        super.onBindViewHolder((InstaNewEventRowPresenter) myViewHolder, (MyViewHolder) rubinoNewEventObject);
        RubikaNotificationManager.getInstance(this.currentAccount).clearNotificationInsta(rubinoNewEventObject);
        if (rubinoNewEventObject.getPostImageUrl().equals(BuildConfig.FLAVOR)) {
            myViewHolder.postImageView.setVisibility(8);
        } else {
            myViewHolder.postImageView.setVisibility(0);
            GlideHelper.load(this.mContext, myViewHolder.postImageView, rubinoNewEventObject.getPostImageUrl(), R.color.transparent);
        }
        myViewHolder.textView.setMovementMethod(LinkMovementMethod.getInstance());
        myViewHolder.textView.setText(((RubinoNewEventObject) myViewHolder.item).getText());
        myViewHolder.textView.append(SpanHelper.makeWithColorAndRelativeSize("\n " + NumberUtils.toPersian(rubinoNewEventObject.getPersianDate()), this.mContext.getResources().getColor(R.color.grey_700), 0.8f));
        GlideHelper.loadCircle(this.mContext, myViewHolder.userImageView, rubinoNewEventObject.getUserImageUrl(), R.drawable.placeholder_avatar_man);
        if (((RubinoNewEventObject) myViewHolder.item).count_owners > 1) {
            myViewHolder.userImageView2.setVisibility(0);
            GlideHelper.loadCircle(this.mContext, myViewHolder.userImageView2, rubinoNewEventObject.getUserImageUrl2(), R.drawable.placeholder_avatar_man);
        } else {
            myViewHolder.userImageView2.setVisibility(8);
        }
    }

    public static class MyViewHolder extends AbstractPresenter.AbstractViewHolder<RubinoNewEventObject> {
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

    /* renamed from: ir.resaneh1.iptv.presenters.InstaNewEventRowPresenter$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnLongClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            final MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(((AbstractPresenter) InstaNewEventRowPresenter.this).context, "آیا می خواهید اعلان پاک شود؟");
            threeButtonDialog.button1.setText("بله");
            threeButtonDialog.button2.setText("خیر");
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.InstaNewEventRowPresenter.3.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    threeButtonDialog.dismiss();
                    Titem titem = myViewHolder.item;
                    ApiRequestMessanger.getInstance(InstaNewEventRowPresenter.this.currentAccount).instaRemoveNotification(new InstaRemoveNotificationInput(((RubinoNewEventObject) titem).id, ((RubinoNewEventObject) titem).profile_id), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.InstaNewEventRowPresenter.3.1.1
                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onError(MessangerOutput messangerOutput) {
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onFailure(Call call, Throwable th) {
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onResponse(Call call, Object obj) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            OnDoneListener onDoneListener = InstaNewEventRowPresenter.this.onRemoveNotifDone;
                            if (onDoneListener != null) {
                                onDoneListener.onDone(myViewHolder);
                            }
                        }
                    });
                }
            });
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaNewEventRowPresenter.3.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.show();
            return true;
        }
    }
}
