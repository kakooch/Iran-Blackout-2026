package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.InstaActionOnRequestInput;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaRequestFollowInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class InstaContactRowPresenter extends AbstractPresenter<InstaProfileObject, ViewHolder> {
    private int currentAccount;
    public boolean isButtonsVisible;
    public boolean isFollowRequestPage;
    public OnDoneListener onActionOnRequestDone;
    View.OnClickListener onActionRequestClick;
    View.OnClickListener onFollowClick;
    View.OnClickListener onUserClicked;

    public InstaContactRowPresenter(Context context) {
        super(context);
        this.isFollowRequestPage = false;
        this.isButtonsVisible = true;
        this.currentAccount = UserConfig.selectedAccount;
        this.onFollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.InstaContactRowPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                final ViewHolder viewHolder = (ViewHolder) view.getTag();
                final InstaRequestFollowInput instaRequestFollowInput = new InstaRequestFollowInput(((InstaProfileObject) viewHolder.item).id);
                Titem titem = viewHolder.item;
                if (((InstaProfileObject) titem).isBlocked) {
                    ToastiLikeSnack.showL(((AbstractPresenter) InstaContactRowPresenter.this).context, "شما این صفحه را مسدود کرده اید ابتدا باید آن را از مسدود بودن خارج کنید");
                    return;
                }
                if (((InstaProfileObject) titem).isRequested) {
                    instaRequestFollowInput.f_type = InstaRequestFollowInput.TypeEnum.Unfollow;
                    str = "آیا می خواهید درخواست لغو شود؟";
                } else if (((InstaProfileObject) titem).isFollowed) {
                    instaRequestFollowInput.f_type = InstaRequestFollowInput.TypeEnum.Unfollow;
                    str = "آیا می خواهید از دنبال کردن انصراف دهید؟";
                } else {
                    instaRequestFollowInput.f_type = InstaRequestFollowInput.TypeEnum.Follow;
                    InstaContactRowPresenter.this.callFollowRequest(viewHolder, instaRequestFollowInput);
                    return;
                }
                final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(((AbstractPresenter) InstaContactRowPresenter.this).context, str);
                threeButtonDialog.button1.setText("بله");
                threeButtonDialog.button2.setText("خیر");
                threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.InstaContactRowPresenter.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        InstaContactRowPresenter.this.callFollowRequest(viewHolder, instaRequestFollowInput);
                        threeButtonDialog.dismiss();
                    }
                });
                threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaContactRowPresenter.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        threeButtonDialog.dismiss();
                    }
                });
            }
        };
        this.onActionRequestClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.InstaContactRowPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final ViewHolder viewHolder = (ViewHolder) view.getTag();
                Titem titem = viewHolder.item;
                if (((InstaProfileObject) titem).request != null) {
                    InstaActionOnRequestInput instaActionOnRequestInput = new InstaActionOnRequestInput(((InstaProfileObject) titem).request.id);
                    if (view == viewHolder.deleteButton) {
                        instaActionOnRequestInput.action = InstaActionOnRequestInput.ActionTypeEnum.Decline;
                    } else if (view == viewHolder.acceptButton) {
                        instaActionOnRequestInput.action = InstaActionOnRequestInput.ActionTypeEnum.Accept;
                    }
                    ApiRequestMessanger.getInstance(InstaContactRowPresenter.this.currentAccount).instaActionOnRequest(instaActionOnRequestInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.InstaContactRowPresenter.3.1
                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onError(MessangerOutput messangerOutput) {
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onFailure(Call call, Throwable th) {
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onResponse(Call call, Object obj) {
                            OnDoneListener onDoneListener = InstaContactRowPresenter.this.onActionOnRequestDone;
                            if (onDoneListener != null) {
                                onDoneListener.onDone(viewHolder);
                            }
                        }
                    });
                }
            }
        };
        this.onUserClicked = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.InstaContactRowPresenter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewHolder viewHolder;
                if (view.getTag(R.id.imagetag) != null) {
                    viewHolder = (ViewHolder) view.getTag(R.id.imagetag);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }
                if (viewHolder == null || viewHolder.item == 0) {
                    return;
                }
                new MainClickHandler().onRubinoProfileClick((InstaProfileObject) viewHolder.item);
            }
        };
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_contact_insta, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewHolder.followButton.setTag(viewHolder);
        viewHolder.deleteButton.setTag(viewHolder);
        viewHolder.acceptButton.setTag(viewHolder);
        viewHolder.usernameTextView.setTag(viewHolder);
        viewHolder.usernameTextView.setOnClickListener(this.onUserClicked);
        viewHolder.imageView.setTag(R.id.imagetag, viewHolder);
        viewHolder.imageView.setOnClickListener(this.onUserClicked);
        viewHolder.container.setTag(R.id.imagetag, viewHolder);
        viewHolder.container.setOnClickListener(this.onUserClicked);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, InstaProfileObject instaProfileObject) {
        super.onBindViewHolder((InstaContactRowPresenter) viewHolder, (ViewHolder) instaProfileObject);
        InstaProfileObject instaCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject();
        Titem titem = viewHolder.item;
        ((InstaProfileObject) titem).isMyProfile = instaCurrentProfileObject != null && instaCurrentProfileObject.id.equals(((InstaProfileObject) titem).id);
        if (instaProfileObject.is_verified || instaProfileObject.sale_permission) {
            viewHolder.imageViewVerified.setVisibility(0);
            if (instaProfileObject.sale_permission) {
                viewHolder.imageViewVerified.setImageResource(R.drawable.ic_sale_permission);
            } else {
                viewHolder.imageViewVerified.setImageResource(R.drawable.ic_insta_verified);
            }
        } else {
            viewHolder.imageViewVerified.setVisibility(4);
        }
        viewHolder.usernameTextView.setText(instaProfileObject.getUsername());
        Titem titem2 = viewHolder.item;
        if (((InstaProfileObject) titem2).name != null && !((InstaProfileObject) titem2).name.isEmpty()) {
            viewHolder.nameTextView.setVisibility(0);
            viewHolder.nameTextView.setText(((InstaProfileObject) viewHolder.item).getName());
        } else {
            viewHolder.nameTextView.setVisibility(8);
        }
        GlideHelper.loadCircle(this.context, viewHolder.imageView, instaProfileObject.full_thumbnail_url, R.drawable.default_profile);
        if (((InstaProfileObject) viewHolder.item).presenterIsSelected) {
            viewHolder.itemView.setBackgroundColor(this.context.getResources().getColor(R.color.selectedRowBackground));
        } else {
            viewHolder.itemView.setBackgroundColor(0);
        }
        if (this.isButtonsVisible) {
            Titem titem3 = viewHolder.item;
            if (!((InstaProfileObject) titem3).isMyProfile) {
                if (this.isFollowRequestPage) {
                    viewHolder.followButton.setVisibility(8);
                } else if (((InstaProfileObject) titem3).isRequested) {
                    viewHolder.followButton.setVisibility(0);
                    viewHolder.followButton.setText("درخواست ارسال شده");
                    viewHolder.followButton.setBackground(this.context.getResources().getDrawable(R.drawable.shape_grey_rectangle));
                    viewHolder.followButton.setTextColor(this.context.getResources().getColor(R.color.grey_600));
                } else {
                    viewHolder.followButton.setVisibility(0);
                    if (((InstaProfileObject) viewHolder.item).isFollowed) {
                        viewHolder.followButton.setText("دنبال می کنید");
                        viewHolder.followButton.setBackground(this.context.getResources().getDrawable(R.drawable.shape_grey_rectangle));
                        viewHolder.followButton.setTextColor(this.context.getResources().getColor(R.color.grey_600));
                    } else {
                        viewHolder.followButton.setText("دنبال کردن");
                        viewHolder.followButton.setBackground(this.context.getResources().getDrawable(R.drawable.shap_primary_rectangle));
                        viewHolder.followButton.setTextColor(this.context.getResources().getColor(R.color.white));
                    }
                }
                viewHolder.followButton.setOnClickListener(this.onFollowClick);
                viewHolder.acceptButton.setOnClickListener(this.onActionRequestClick);
                viewHolder.deleteButton.setOnClickListener(this.onActionRequestClick);
                return;
            }
        }
        viewHolder.followButton.setVisibility(4);
        viewHolder.acceptButton.setVisibility(4);
        viewHolder.deleteButton.setVisibility(4);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<InstaProfileObject> {
        TextView acceptButton;
        View container;
        TextView deleteButton;
        TextView followButton;
        ImageView imageView;
        ImageView imageViewVerified;
        TextView nameTextView;
        TextView usernameTextView;

        public ViewHolder(View view) {
            super(view);
            this.usernameTextView = (TextView) view.findViewById(R.id.textViewUserName);
            this.nameTextView = (TextView) view.findViewById(R.id.textViewName);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.acceptButton = (TextView) view.findViewById(R.id.acceptButton);
            this.deleteButton = (TextView) view.findViewById(R.id.deleteButton);
            this.followButton = (TextView) view.findViewById(R.id.followButton);
            this.container = view.findViewById(R.id.container);
            this.imageViewVerified = (ImageView) view.findViewById(R.id.imageViewVerified);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callFollowRequest(final ViewHolder viewHolder, InstaRequestFollowInput instaRequestFollowInput) {
        ApiRequestMessanger.getInstance(this.currentAccount).instaRequestFollow(instaRequestFollowInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenters.InstaContactRowPresenter.2
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                Titem titem = viewHolder.item;
                if (((InstaProfileObject) titem).isRequested) {
                    ((InstaProfileObject) titem).isRequested = false;
                } else if (((InstaProfileObject) titem).isFollowed) {
                    ((InstaProfileObject) titem).isFollowed = false;
                } else if (((InstaProfileObject) titem).isPrivate()) {
                    ((InstaProfileObject) viewHolder.item).isRequested = true;
                } else {
                    Titem titem2 = viewHolder.item;
                    ((InstaProfileObject) titem2).isFollowed = true;
                    ((InstaProfileObject) titem2).isRequested = false;
                }
                InstaContactRowPresenter instaContactRowPresenter = InstaContactRowPresenter.this;
                ViewHolder viewHolder2 = viewHolder;
                instaContactRowPresenter.onBindViewHolder(viewHolder2, (InstaProfileObject) viewHolder2.item);
                NotificationCenter notificationCenter = NotificationCenter.getInstance(InstaContactRowPresenter.this.currentAccount);
                NotificationCenter.getInstance(InstaContactRowPresenter.this.currentAccount);
                notificationCenter.postNotificationNameOnUIThread(NotificationCenter.rubinoFollowBlockChanged, ((InstaProfileObject) viewHolder.item).id);
            }
        });
    }
}
