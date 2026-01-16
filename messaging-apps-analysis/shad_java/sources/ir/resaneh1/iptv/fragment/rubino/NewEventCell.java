package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.messanger.RubikaNotificationManager;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class NewEventCell extends FrameLayout {
    public static int eventType = 0;
    public static int requestNumberType = 2;
    public static int requestType = 1;
    public TextView acceptButton;
    public View container;
    int currentAccount;
    public Rubino.NewEventObject currentEvent;
    public TextView deleteButton;
    public TextView followButton;
    public ImageView imageViewPlus;
    public View imagesContainer;
    boolean isClickConsumed;
    boolean isLongClick;
    public Context mContext;
    View.OnClickListener onAcceptRequestClick;
    View.OnClickListener onCancelRequestOrUnfollowClick;
    View.OnClickListener onDeleteRequestClick;
    View.OnClickListener onFollowClick;
    View.OnLongClickListener onLongClick;
    private View.OnLongClickListener onLongClickListener;
    View.OnClickListener onUserClickListener;
    public ImageView postImageView;
    public TextView requestedButton;
    public View textContainer;
    public TextView textView1;
    public TextView textView2;
    public TextView textViewCount;
    public int type;
    public InsStoryAvatarView userImageView;
    public InsStoryAvatarView userImageView1;
    public InsStoryAvatarView userImageView2;

    public void setLongClick(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public NewEventCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.isClickConsumed = false;
        this.isLongClick = false;
        this.onFollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList<RubinoProfileObject> arrayList = NewEventCell.this.currentEvent.event.owners;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                NewEventCell newEventCell = NewEventCell.this;
                newEventCell.isClickConsumed = true;
                RubinoController.getInstance(newEventCell.currentAccount).doFollowUnfollowAction(NewEventCell.this.currentEvent.event.owners.get(0), Rubino.FollowActionTypeEnum.Follow);
            }
        };
        this.onCancelRequestOrUnfollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList<RubinoProfileObject> arrayList = NewEventCell.this.currentEvent.event.owners;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                NewEventCell newEventCell = NewEventCell.this;
                newEventCell.isClickConsumed = true;
                RubinoController.getInstance(newEventCell.currentAccount).unFollowClickWithDialogIfNeeded(NewEventCell.this.currentEvent.event.owners.get(0), null);
            }
        };
        this.onAcceptRequestClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventCell.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewEventCell newEventCell = NewEventCell.this;
                newEventCell.isClickConsumed = true;
                RubinoController.getInstance(newEventCell.currentAccount).onAcceptRequestClick(NewEventCell.this.currentEvent.event.request_id);
            }
        };
        this.onDeleteRequestClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventCell.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewEventCell newEventCell = NewEventCell.this;
                newEventCell.isClickConsumed = true;
                RubinoController.getInstance(newEventCell.currentAccount).onDeleteRequestClick(NewEventCell.this.currentEvent.event.request_id);
            }
        };
        AndroidUtilities.dp(2.0f);
        this.onUserClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventCell.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Rubino.NewEventFromServerObject newEventFromServerObject;
                ArrayList<RubinoProfileObject> arrayList;
                Rubino.NewEventObject newEventObject = NewEventCell.this.currentEvent;
                if (newEventObject == null || (newEventFromServerObject = newEventObject.event) == null || (arrayList = newEventFromServerObject.owners) == null || arrayList.size() <= 0 || ApplicationLoader.applicationActivity == null) {
                    return;
                }
                new MainClickHandler().onRubinoProfileClick(NewEventCell.this.currentEvent.event.owners.get(0));
                NewEventCell.this.isClickConsumed = true;
            }
        };
        this.onLongClick = new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventCell.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (NewEventCell.this.onLongClickListener != null) {
                    NewEventCell.this.onLongClickListener.onLongClick(NewEventCell.this);
                    NewEventCell.this.isLongClick = true;
                }
                NewEventCell newEventCell = NewEventCell.this;
                newEventCell.isClickConsumed = false;
                return newEventCell.isLongClick;
            }
        };
        new GestureDetector(ApplicationLoader.applicationActivity, new GestureDetector.SimpleOnGestureListener() { // from class: ir.resaneh1.iptv.fragment.rubino.NewEventCell.7
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (NewEventCell.this.onLongClickListener != null) {
                    NewEventCell newEventCell = NewEventCell.this;
                    if (!newEventCell.isClickConsumed) {
                        newEventCell.onLongClickListener.onLongClick(NewEventCell.this.container);
                        NewEventCell.this.isLongClick = true;
                    }
                }
                NewEventCell.this.isClickConsumed = false;
            }
        });
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.rubino_new_event_row, (ViewGroup) null, false);
        addView(viewGroup);
        this.textView1 = (TextView) viewGroup.findViewById(R.id.textView1);
        this.textView2 = (TextView) viewGroup.findViewById(R.id.textView2);
        this.textContainer = viewGroup.findViewById(R.id.textContainer);
        this.userImageView = (InsStoryAvatarView) viewGroup.findViewById(R.id.imageViewUser);
        this.userImageView1 = (InsStoryAvatarView) viewGroup.findViewById(R.id.imageViewUser1);
        this.userImageView2 = (InsStoryAvatarView) viewGroup.findViewById(R.id.imageViewUser2);
        this.imagesContainer = viewGroup.findViewById(R.id.imagesContainer);
        this.imageViewPlus = (ImageView) viewGroup.findViewById(R.id.imageViewPlus);
        this.postImageView = (ImageView) viewGroup.findViewById(R.id.imageViewPost);
        this.textViewCount = (TextView) viewGroup.findViewById(R.id.textViewCount);
        this.acceptButton = (TextView) viewGroup.findViewById(R.id.acceptButton);
        this.deleteButton = (TextView) viewGroup.findViewById(R.id.deleteButton);
        this.followButton = (TextView) viewGroup.findViewById(R.id.followButton);
        this.requestedButton = (TextView) viewGroup.findViewById(R.id.requestedButton);
        this.container = viewGroup.findViewById(R.id.container);
        this.textViewCount.setTypeface(Theme.getRubinoTypeFaceBold());
        this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
        TextView textView = this.textView1;
        int i = Theme.key_rubinoBlackColor;
        textView.setTextColor(Theme.getColor(i));
        this.textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView2.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
        this.acceptButton.setTypeface(Theme.getRubinoTypeFaceBold());
        this.deleteButton.setTypeface(Theme.getRubinoTypeFaceBold());
        this.followButton.setTypeface(Theme.getRubinoTypeFaceBold());
        this.requestedButton.setTypeface(Theme.getRubinoTypeFaceBold());
        this.deleteButton.setText(LocaleController.getString("rubinoDeleteRequest", R.string.rubinoDeleteRequest));
        this.acceptButton.setText(LocaleController.getString("rubinoAcceptRequest", R.string.rubinoAcceptRequest));
        this.followButton.setText(LocaleController.getString("rubinoFollowAction", R.string.rubinoFollowAction));
        this.requestedButton.setText(LocaleController.getString("rubinoIsRequested", R.string.rubinoIsRequested));
        GradientDrawable gradientDrawable = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        int iDp = AndroidUtilities.dp(1.0f);
        int i2 = Theme.key_rubinoFollowingBorderColor;
        gradientDrawable.setStroke(iDp, Theme.getColor(i2));
        this.requestedButton.setBackground(gradientDrawable);
        this.requestedButton.setTextColor(Theme.getColor(i));
        this.requestedButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        GradientDrawable gradientDrawable2 = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable2.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(i2));
        this.deleteButton.setBackground(gradientDrawable2);
        this.deleteButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.deleteButton.setTextColor(Theme.getColor(i));
        this.textView1.setMovementMethod(LinkMovementMethod.getInstance());
        this.userImageView.setOnClickListener(this.onUserClickListener);
        this.userImageView1.setOnClickListener(this.onUserClickListener);
        this.userImageView2.setOnClickListener(this.onUserClickListener);
        this.acceptButton.setOnClickListener(this.onAcceptRequestClick);
        this.deleteButton.setOnClickListener(this.onDeleteRequestClick);
        this.followButton.setOnClickListener(this.onFollowClick);
        this.requestedButton.setOnClickListener(this.onCancelRequestOrUnfollowClick);
        viewGroup.setOnLongClickListener(this.onLongClick);
        requestDisallowInterceptTouchEvent(true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 5) {
            this.isClickConsumed = false;
            this.isLongClick = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEvent(Rubino.NewEventObject newEventObject, int i) {
        this.currentEvent = newEventObject;
        this.type = eventType;
        this.textView1.setMaxLines(4);
        this.textViewCount.setVisibility(8);
        this.imageViewPlus.setVisibility(8);
        this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView2.setVisibility(8);
        this.userImageView.getLayoutParams().width = AndroidUtilities.dp(54.0f);
        this.userImageView.getLayoutParams().height = AndroidUtilities.dp(54.0f);
        ((FrameLayout.LayoutParams) this.userImageView.getLayoutParams()).topMargin = AndroidUtilities.dp(8.0f);
        ((FrameLayout.LayoutParams) this.userImageView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(8.0f);
        RubikaNotificationManager rubikaNotificationManager = RubikaNotificationManager.getInstance(this.currentAccount);
        Rubino.NewEventFromServerObject newEventFromServerObject = newEventObject.event;
        rubikaNotificationManager.clearNotificationRubino(newEventFromServerObject.id, newEventFromServerObject.profile_id);
        setButtons();
        Rubino.NewEventFromServerObject newEventFromServerObject2 = this.currentEvent.event;
        Rubino.NotifEnum notifEnum = newEventFromServerObject2.model;
        if (notifEnum == Rubino.NotifEnum.Request || notifEnum == Rubino.NotifEnum.FollowingYou) {
            this.postImageView.setVisibility(8);
        } else {
            String str = newEventFromServerObject2.full_post_thumbnail_url;
            if (str == null || str.isEmpty()) {
                this.postImageView.setVisibility(8);
                this.textContainer.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), this.textContainer.getPaddingRight(), AndroidUtilities.dp(8.0f));
            } else {
                this.postImageView.setVisibility(0);
                GlideHelper.load(this.mContext, this.postImageView, this.currentEvent.event.full_post_thumbnail_url, R.color.transparent);
                this.textContainer.setPadding(AndroidUtilities.dp(64.0f), AndroidUtilities.dp(8.0f), this.textContainer.getPaddingRight(), AndroidUtilities.dp(8.0f));
            }
        }
        this.textView1.setText(this.currentEvent.spannableEvent);
        SpannableString spannableTime = this.currentEvent.getSpannableTime();
        if (spannableTime != null) {
            this.textView1.append(spannableTime);
        }
        if (this.currentEvent.event.count_owners > 1) {
            this.userImageView.setVisibility(8);
            this.imagesContainer.setVisibility(0);
            Context context = this.mContext;
            InsStoryAvatarView insStoryAvatarView = this.userImageView1;
            ArrayList<RubinoProfileObject> arrayList = this.currentEvent.event.owners;
            GlideHelper.loadCircle(context, insStoryAvatarView, arrayList.get(arrayList.size() - 1).full_thumbnail_url, R.drawable.placeholder_avatar_man);
            GlideHelper.loadCircle(this.mContext, this.userImageView2, this.currentEvent.event.owners.get(r1.size() - 2).full_thumbnail_url, R.drawable.placeholder_avatar_man);
            return;
        }
        this.imagesContainer.setVisibility(8);
        this.userImageView.setVisibility(0);
        Context context2 = this.mContext;
        InsStoryAvatarView insStoryAvatarView2 = this.userImageView;
        ArrayList<RubinoProfileObject> arrayList2 = this.currentEvent.event.owners;
        GlideHelper.loadCircle(context2, insStoryAvatarView2, arrayList2.get(arrayList2.size() - 1).full_thumbnail_url, R.drawable.placeholder_avatar_man);
    }

    public void setRequest(Rubino.NewEventObject newEventObject, int i) {
        this.currentEvent = newEventObject;
        this.type = requestType;
        this.textView1.setMaxLines(1);
        this.textViewCount.setVisibility(8);
        this.imageViewPlus.setVisibility(8);
        this.postImageView.setVisibility(8);
        this.textView1.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.imagesContainer.setVisibility(8);
        this.userImageView.setVisibility(8);
        this.userImageView.getLayoutParams().width = AndroidUtilities.dp(50.0f);
        this.userImageView.getLayoutParams().height = AndroidUtilities.dp(50.0f);
        ((FrameLayout.LayoutParams) this.userImageView.getLayoutParams()).topMargin = AndroidUtilities.dp(0.0f);
        ((FrameLayout.LayoutParams) this.userImageView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(0.0f);
        setButtons();
        TextView textView = this.textView1;
        String str = BuildConfig.FLAVOR;
        textView.setText(BuildConfig.FLAVOR);
        this.textView2.setText(BuildConfig.FLAVOR);
        Rubino.NewEventFromServerObject newEventFromServerObject = this.currentEvent.event;
        if (newEventFromServerObject.count_owners > 0) {
            TextView textView2 = this.textView1;
            if (newEventFromServerObject.owners.get(0).username != null) {
                str = this.currentEvent.event.owners.get(0).username;
            }
            textView2.setText(str);
            if (this.currentEvent.event.owners.get(0).name != null) {
                this.textView2.setVisibility(0);
                this.textView2.setText(this.currentEvent.event.owners.get(0).name);
            } else {
                this.textView2.setVisibility(8);
            }
            this.userImageView.setVisibility(0);
            Context context = this.mContext;
            InsStoryAvatarView insStoryAvatarView = this.userImageView;
            ArrayList<RubinoProfileObject> arrayList = this.currentEvent.event.owners;
            GlideHelper.loadCircle(context, insStoryAvatarView, arrayList.get(arrayList.size() - 1).full_thumbnail_url, R.drawable.placeholder_avatar_man);
        }
    }

    public void setRequestNumber(SpannableString spannableString, int i, int i2) {
        this.currentEvent = null;
        this.type = requestNumberType;
        this.textView1.setMaxLines(4);
        this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.acceptButton.setVisibility(8);
        this.deleteButton.setVisibility(8);
        this.followButton.setVisibility(8);
        this.requestedButton.setVisibility(8);
        this.textView2.setVisibility(8);
        this.postImageView.setVisibility(8);
        this.textContainer.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
        this.textView1.setText(spannableString);
        if (i > 0) {
            this.textViewCount.setVisibility(0);
            this.textViewCount.setText(NumberUtils.toCuteStringWithKOrMEnglish(i));
        } else {
            this.textViewCount.setVisibility(8);
        }
        this.imagesContainer.setVisibility(8);
        this.userImageView.setVisibility(8);
        this.imageViewPlus.setVisibility(0);
        this.imageViewPlus.setColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.SRC_ATOP);
    }

    public void setButtons() {
        ArrayList<RubinoProfileObject> arrayList;
        Rubino.NotifEnum notifEnum = this.currentEvent.event.model;
        Rubino.NotifEnum notifEnum2 = Rubino.NotifEnum.Request;
        if (notifEnum == notifEnum2 || notifEnum == Rubino.NotifEnum.FollowingYou) {
            this.postImageView.setVisibility(8);
            this.textContainer.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
            if (this.currentEvent.event.model == notifEnum2 && !RubinoController.getInstance(this.currentAccount).isRequestAnswered(this.currentEvent.event.request_id)) {
                this.acceptButton.setVisibility(0);
                this.deleteButton.setVisibility(0);
                this.followButton.setVisibility(8);
                this.requestedButton.setVisibility(8);
                this.textContainer.setPadding(AndroidUtilities.dp(184.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
                return;
            }
            if (((this.currentEvent.event.model == notifEnum2 && RubinoController.getInstance(this.currentAccount).actionOnRequestMap.get(this.currentEvent.event.request_id) == Rubino.ActionOnRequestTypeEnum.Accept) || this.currentEvent.event.model == Rubino.NotifEnum.FollowingYou) && (arrayList = this.currentEvent.event.owners) != null && arrayList.size() > 0) {
                this.acceptButton.setVisibility(8);
                this.deleteButton.setVisibility(8);
                if (RubinoController.getInstance(this.currentAccount).isProfileFollowed(this.currentEvent.event.owners.get(0))) {
                    this.followButton.setVisibility(8);
                    this.requestedButton.setVisibility(0);
                    this.requestedButton.setText(LocaleController.getString(R.string.rubinoIsFollowed));
                    this.textContainer.setPadding(AndroidUtilities.dp(144.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
                    return;
                }
                if (RubinoController.getInstance(this.currentAccount).isProfileFollowRequested(this.currentEvent.event.owners.get(0))) {
                    this.followButton.setVisibility(8);
                    this.requestedButton.setVisibility(0);
                    this.requestedButton.setText(LocaleController.getString(R.string.rubinoIsRequested));
                    this.textContainer.setPadding(AndroidUtilities.dp(144.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
                    return;
                }
                this.followButton.setVisibility(0);
                this.requestedButton.setVisibility(8);
                this.textContainer.setPadding(AndroidUtilities.dp(96.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
                return;
            }
            this.acceptButton.setVisibility(8);
            this.deleteButton.setVisibility(8);
            this.followButton.setVisibility(8);
            this.requestedButton.setVisibility(8);
            this.textContainer.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
            return;
        }
        this.acceptButton.setVisibility(8);
        this.deleteButton.setVisibility(8);
        this.followButton.setVisibility(8);
        this.requestedButton.setVisibility(8);
        this.textContainer.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
    }

    public void handleEventClick(float f, float f2) {
        if (this.type != eventType) {
            return;
        }
        if (!this.isClickConsumed) {
            TextView textView = this.textView1;
            this.isClickConsumed = Rubino.checkUserNameOrHashtagClick(textView, ((f - textView.getX()) - this.textView1.getPaddingLeft()) - ((View) this.textView1.getParent()).getX(), ((f2 - this.textView1.getY()) - this.textView1.getPaddingTop()) - ((View) this.textView1.getParent()).getY());
        }
        if (this.isClickConsumed) {
            return;
        }
        new MainClickHandler().onRubinoEventClick(this.currentEvent);
        this.isClickConsumed = true;
    }

    public void handleRequestClick() {
        Rubino.NewEventObject newEventObject;
        Rubino.NewEventFromServerObject newEventFromServerObject;
        ArrayList<RubinoProfileObject> arrayList;
        if (this.type != requestType || this.isClickConsumed || (newEventObject = this.currentEvent) == null || (newEventFromServerObject = newEventObject.event) == null || (arrayList = newEventFromServerObject.owners) == null || arrayList.size() <= 0) {
            return;
        }
        new MainClickHandler().onInstaUsernameClicked(this.currentEvent.event.owners.get(0).username);
        this.isClickConsumed = true;
    }

    public void handleClick(float f, float f2) {
        if (this.isLongClick || this.isClickConsumed) {
            return;
        }
        int i = this.type;
        if (i == requestNumberType) {
            AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().new_follow_request_count = 0;
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.rubinoMyProfileNotifCountChange, new Object[0]);
            RubinoNewEventActivity rubinoNewEventActivity = new RubinoNewEventActivity(RubinoNewEventActivity.requestType);
            if (ApplicationLoader.applicationActivity != null) {
                ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(rubinoNewEventActivity);
                return;
            }
            return;
        }
        if (i == eventType) {
            handleEventClick(f, f2);
        } else if (i == requestType) {
            handleRequestClick();
        }
    }
}
