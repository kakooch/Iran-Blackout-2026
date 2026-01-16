package ir.resaneh1.iptv.fragment.rubino;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.fragment.InstaEditProfileFragment;
import ir.resaneh1.iptv.fragment.LinearFragment;
import ir.resaneh1.iptv.fragment.RubinoFollowerFollowingActivity;
import ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment;
import ir.resaneh1.iptv.fragment.StoryFragment;
import ir.resaneh1.iptv.fragment.StorySeenFragment;
import ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity;
import ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment;
import ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ImageObject;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenters.ImageLargeZoomPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class ProfileHeaderView extends FrameLayout {
    int CLICK_ACTION_THRESHOLD;
    private Drawable arrowDownDrawable;
    private final TextView bioTextView;
    private final View contactButton;
    private final TextView contactButtonText;
    private final Context context;
    int currentAccount;
    private DisposableObserver disposable;
    private final TextView followerCountTextView;
    private final TextView followingCountTextView;
    private final View headerView;
    private final InsStoryAvatarView imageView;
    private String lastLoadedUrl;
    private final View leftButton;
    private final FrameLayout leftButtonProgressView;
    private final TextView leftButtonText;
    private final View messageButton;
    private final TextView messageButtonText;
    private final TextView moreInfoTextView;
    private final TextView nameTextView;
    private final View.OnClickListener onBlockClick;
    View.OnTouchListener onBodyTouch;
    View.OnClickListener onContactClick;
    private final View.OnClickListener onEditClicked;
    private final View.OnClickListener onFollowClick;
    View.OnClickListener onFollowerClicked;
    View.OnClickListener onOpenImageClicked;
    View.OnClickListener onOpenStoryClick;
    private final View.OnClickListener onProductClick;
    private final View.OnClickListener onSendMessageClick;
    View.OnClickListener onSettingClicked;
    private final View.OnClickListener onStoreClick;
    private final TextView postCountTextView;
    private final View productButton;
    private final TextView productButtonText;
    private RubinoProfileObject profileObject;
    private final View settingButton;
    private final TextView settingButtonText;
    private final View storeButton;
    private final TextView storeButtonText;
    private final TextView textViewLeft;
    private final TextView textViewPost;
    private final TextView textViewRight;

    public ProfileHeaderView(Context context, RubinoProfileObject rubinoProfileObject) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.lastLoadedUrl = BuildConfig.FLAVOR;
        this.onContactClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList<Rubino.AlertItem> contactInfoArray = ProfileHeaderView.this.profileObject.getContactInfoArray();
                if (contactInfoArray.size() > 1) {
                    RubinoBottomUpAlert rubinoBottomUpAlertCreateRubinoDialogItems = RubinoBottomUpAlert.createRubinoDialogItems(ApplicationLoader.applicationActivity.getLastFragment(), LocaleController.getString(R.string.rubinoContact), contactInfoArray);
                    Iterator<Rubino.AlertItem> it = contactInfoArray.iterator();
                    while (it.hasNext()) {
                        it.next().parentDialog = rubinoBottomUpAlertCreateRubinoDialogItems;
                    }
                    rubinoBottomUpAlertCreateRubinoDialogItems.show();
                    return;
                }
                if (contactInfoArray.size() > 0) {
                    contactInfoArray.get(0).onClickListener.onClick(view);
                }
            }
        };
        this.onSettingClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoSettingsActivity(AppRubinoPreferences.getInstance(ProfileHeaderView.this.currentAccount).getInstaCurrentProfileObject()));
                }
            }
        };
        this.onFollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog dialogOnFollowButtonInProfileClicked = RubinoController.getInstance(ProfileHeaderView.this.currentAccount).onFollowButtonInProfileClicked(ProfileHeaderView.this.profileObject);
                if (dialogOnFollowButtonInProfileClicked != null) {
                    dialogOnFollowButtonInProfileClicked.show();
                }
            }
        };
        this.onBlockClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoController.getInstance(ProfileHeaderView.this.currentAccount).onBlockClick(ProfileHeaderView.this.profileObject, null);
            }
        };
        this.onSendMessageClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfileHeaderView.this.profileObject == null || !ProfileHeaderView.this.profileObject.is_message_allowed) {
                    ToastiLikeSnack.showL(ProfileHeaderView.this.context, LocaleController.getString(R.string.rubinoMessageNotAllowed));
                } else {
                    new MainClickHandler().onLinkClick(ProfileHeaderView.this.profileObject.chat_link);
                }
            }
        };
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new InstaEditProfileFragment());
                }
            }
        };
        this.onEditClicked = onClickListener;
        this.onStoreClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        };
        this.onProductClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        };
        this.CLICK_ACTION_THRESHOLD = AndroidUtilities.dp(2.0f);
        this.onBodyTouch = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.8
            float startX;
            float startY;

            /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
            
                if (r0 != 5) goto L23;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
                /*
                    r10 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    int r1 = r12.getAction()
                    r0.append(r1)
                    java.lang.String r1 = ""
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "onTouch"
                    ir.resaneh1.iptv.logger.MyLog.e(r1, r0)
                    boolean r0 = r11 instanceof android.widget.TextView
                    r1 = 0
                    if (r0 == 0) goto Lb3
                    android.widget.TextView r11 = (android.widget.TextView) r11
                    int r0 = r12.getAction()
                    r2 = 1
                    if (r0 == 0) goto La3
                    if (r0 == r2) goto L2f
                    r11 = 5
                    if (r0 == r11) goto La3
                    goto Lb3
                L2f:
                    ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView r0 = ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.this
                    float r3 = r10.startX
                    float r4 = r12.getX()
                    float r5 = r10.startY
                    float r6 = r12.getY()
                    boolean r0 = ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.access$400(r0, r3, r4, r5, r6)
                    if (r0 == 0) goto Lb3
                    java.lang.CharSequence r0 = r11.getText()
                    android.text.SpannableString r0 = (android.text.SpannableString) r0
                    int r3 = r0.length()
                    java.lang.Class<ir.resaneh1.iptv.helper.RubinoShowMoreSpan> r4 = ir.resaneh1.iptv.helper.RubinoShowMoreSpan.class
                    java.lang.Object[] r3 = r0.getSpans(r1, r3, r4)
                    ir.resaneh1.iptv.helper.RubinoShowMoreSpan[] r3 = (ir.resaneh1.iptv.helper.RubinoShowMoreSpan[]) r3
                    int r4 = r3.length
                    r5 = 0
                L57:
                    if (r5 >= r4) goto L94
                    r6 = r3[r5]
                    int r7 = r0.getSpanStart(r6)
                    int r6 = r0.getSpanEnd(r6)
                    android.graphics.Path r8 = new android.graphics.Path
                    r8.<init>()
                    android.text.Layout r9 = r11.getLayout()
                    r9.getSelectionPath(r7, r6, r8)
                    android.graphics.RectF r6 = new android.graphics.RectF
                    r6.<init>()
                    r8.computeBounds(r6, r1)
                    float r7 = r12.getX()
                    float r8 = r12.getY()
                    boolean r6 = r6.contains(r7, r8)
                    if (r6 == 0) goto L91
                    ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView r0 = ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.this
                    ir.resaneh1.iptv.model.RubinoProfileObject r0 = ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.access$000(r0)
                    android.text.SpannableString r0 = r0.bioSpannableString
                    r11.setText(r0)
                    goto L95
                L91:
                    int r5 = r5 + 1
                    goto L57
                L94:
                    r2 = 0
                L95:
                    if (r2 != 0) goto Lb3
                    float r0 = r12.getX()
                    float r12 = r12.getY()
                    ir.resaneh1.iptv.model.Rubino.checkUserNameOrHashtagClick(r11, r0, r12)
                    goto Lb3
                La3:
                    float r11 = r12.getX()
                    r10.startX = r11
                    float r11 = r12.getY()
                    r10.startY = r11
                    java.lang.System.currentTimeMillis()
                    return r2
                Lb3:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.AnonymousClass8.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        };
        this.onFollowerClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfileHeaderView.this.profileObject.isMyCurrentProfile() || !ProfileHeaderView.this.profileObject.isPrivate() || RubinoController.getInstance(ProfileHeaderView.this.currentAccount).isProfileFollowed(ProfileHeaderView.this.profileObject)) {
                    if (view != ProfileHeaderView.this.followerCountTextView && view != ProfileHeaderView.this.textViewLeft) {
                        if ((view == ProfileHeaderView.this.followingCountTextView || view == ProfileHeaderView.this.textViewRight) && ApplicationLoader.applicationActivity != null) {
                            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoFollowerFollowingActivity(ProfileHeaderView.this.profileObject, 1));
                            return;
                        }
                        return;
                    }
                    if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoFollowerFollowingActivity(ProfileHeaderView.this.profileObject, 0));
                    }
                }
            }
        };
        this.onOpenStoryClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                StoryController.ProfileStoryStatusEnum profileStoriesStatus = StoryController.getInstance(ProfileHeaderView.this.currentAccount).getProfileStoriesStatus(ProfileHeaderView.this.profileObject.id);
                boolean z = profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory || profileStoriesStatus == StoryController.ProfileStoryStatusEnum.NotSeenStory;
                boolean zProfileHasLive = StoryController.getInstance(ProfileHeaderView.this.currentAccount).profileHasLive(ProfileHeaderView.this.profileObject.id);
                if (!zProfileHasLive && !z) {
                    if (ProfileHeaderView.this.profileObject.id != null && ProfileHeaderView.this.profileObject.isMyCurrentProfile()) {
                        if (RubinoController.getInstance(ProfileHeaderView.this.currentAccount).hasPermissionAddStory()) {
                            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new StoryCameraAndGalleryFragment());
                            return;
                        }
                        return;
                    }
                    ProfileHeaderView.this.onOpenImageClicked.onClick(view);
                    return;
                }
                if (zProfileHasLive) {
                    InsStoryAvatarView insStoryAvatarView = ProfileHeaderView.this.imageView;
                    float x = insStoryAvatarView.getX() + (insStoryAvatarView.getMeasuredWidth() / 2.0f) + ProfileHeaderView.this.getX();
                    float y = ((insStoryAvatarView.getY() + ((insStoryAvatarView.getY() + (insStoryAvatarView.getMeasuredHeight() / 2.0f)) + ProfileHeaderView.this.getY())) / 2.0f) + ActionBar.getCurrentActionBarHeight();
                    LiveBroadCastActivity liveBroadCastActivity = new LiveBroadCastActivity(ProfileHeaderView.this.profileObject);
                    liveBroadCastActivity.fragmentPresentOriginX = x;
                    liveBroadCastActivity.fragmentPresentOriginY = y;
                    liveBroadCastActivity.setIsSwipeDownEnable(true);
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(liveBroadCastActivity);
                    return;
                }
                if (ProfileHeaderView.this.disposable != null) {
                    ProfileHeaderView.this.disposable.dispose();
                }
                if (StoryController.getInstance(ProfileHeaderView.this.currentAccount).getInstantProfileStoryIdsWithLocal(ProfileHeaderView.this.profileObject, null, false) != null) {
                    ProfileHeaderView.this.openStoryIfExist();
                    return;
                }
                ProfileHeaderView.this.imageView.setStatus(InsStoryAvatarView.Status.LOADING);
                ProfileHeaderView profileHeaderView = ProfileHeaderView.this;
                profileHeaderView.disposable = (DisposableObserver) StoryController.getInstance(profileHeaderView.currentAccount).getProfileStoryIdsWithLoadStoryObservable(ProfileHeaderView.this.profileObject, 0, 10, false).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.10.2
                    @Override // io.reactivex.functions.Consumer
                    public void accept(Integer num) throws Exception {
                        ProfileHeaderView.this.setStoryStatus();
                    }
                }).delay(10L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.10.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) {
                        ProfileHeaderView.this.openStoryIfExist();
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        ProfileHeaderView.this.openStoryIfExist();
                        ProfileHeaderView.this.setStoryStatus();
                    }
                });
                ApplicationLoader.applicationActivity.mainCompositeDisposable.add(ProfileHeaderView.this.disposable);
            }
        };
        this.onOpenImageClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((LaunchActivity) ProfileHeaderView.this.context).lambda$runLinkRequest$40(new LinearFragment(new ImageLargeZoomPresenter(ProfileHeaderView.this.context).createViewHolderAndBind(new ImageObject(ProfileHeaderView.this.profileObject.full_photo_url)).itemView));
            }
        };
        this.context = context;
        this.profileObject = rubinoProfileObject;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rubino_profile_header_view, (ViewGroup) null, false);
        this.headerView = viewInflate;
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f));
        viewInflate.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        InsStoryAvatarView insStoryAvatarView = (InsStoryAvatarView) viewInflate.findViewById(R.id.imageView);
        this.imageView = insStoryAvatarView;
        TextView textView = (TextView) viewInflate.findViewById(R.id.textViewPostCount);
        this.postCountTextView = textView;
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.textViewLeftNumber);
        this.followerCountTextView = textView2;
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.textViewRightNumber);
        this.followingCountTextView = textView3;
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.textViewUserName);
        this.nameTextView = textView4;
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.textViewBio);
        this.bioTextView = textView5;
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.textViewMoreInfo);
        this.moreInfoTextView = textView6;
        View viewFindViewById = viewInflate.findViewById(R.id.leftButton);
        this.leftButton = viewFindViewById;
        GradientDrawable gradientDrawable = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(Theme.key_rubinoFollowingBorderColor));
        viewFindViewById.setBackground(gradientDrawable);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.leftButtonText);
        this.leftButtonText = textView7;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.progressBarFrame);
        this.leftButtonProgressView = frameLayout;
        this.messageButton = viewInflate.findViewById(R.id.messageButton);
        View viewFindViewById2 = viewInflate.findViewById(R.id.settingButton);
        this.settingButton = viewFindViewById2;
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.settingButtonTextView);
        this.settingButtonText = textView8;
        TextView textView9 = (TextView) viewInflate.findViewById(R.id.messageButtonTextView);
        this.messageButtonText = textView9;
        TextView textView10 = (TextView) viewInflate.findViewById(R.id.textViewPost);
        this.textViewPost = textView10;
        TextView textView11 = (TextView) viewInflate.findViewById(R.id.textViewLeftText);
        this.textViewLeft = textView11;
        TextView textView12 = (TextView) viewInflate.findViewById(R.id.textViewRightText);
        this.textViewRight = textView12;
        View viewFindViewById3 = viewInflate.findViewById(R.id.contactButton);
        this.contactButton = viewFindViewById3;
        this.storeButton = viewInflate.findViewById(R.id.storeButton);
        this.productButton = viewInflate.findViewById(R.id.productButton);
        TextView textView13 = (TextView) viewInflate.findViewById(R.id.contactButtonText);
        this.contactButtonText = textView13;
        TextView textView14 = (TextView) viewInflate.findViewById(R.id.storeButtonText);
        this.storeButtonText = textView14;
        TextView textView15 = (TextView) viewInflate.findViewById(R.id.productButtonText);
        this.productButtonText = textView15;
        textView9.setText(LocaleController.getString(R.string.rubinoMessage));
        textView10.setText(LocaleController.getString(R.string.rubinoPosts));
        textView11.setText(LocaleController.getString(R.string.rubinoFollowers));
        textView12.setText(LocaleController.getString(R.string.rubinoFollowings));
        if (ApplicationLoader.applicationActivity != null) {
            UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, frameLayout, 18);
        }
        textView13.setTypeface(Theme.getRubinoTypeFaceBold());
        textView10.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView11.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView12.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setTypeface(Theme.getRubinoTypeFaceBold());
        textView3.setTypeface(Theme.getRubinoTypeFaceBold());
        textView2.setTypeface(Theme.getRubinoTypeFaceBold());
        textView4.setTypeface(Theme.getRubinoTypeFaceBold());
        textView5.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView6.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView7.setTypeface(Theme.getRubinoTypeFaceBold());
        textView8.setTypeface(Theme.getRubinoTypeFaceBold());
        textView9.setTypeface(Theme.getRubinoTypeFaceBold());
        textView14.setTypeface(Theme.getRubinoTypeFaceBold());
        textView15.setTypeface(Theme.getRubinoTypeFaceBold());
        int i = Theme.key_rubinoBlackColor;
        textView4.setTextColor(Theme.getColor(i));
        viewFindViewById3.setOnClickListener(this.onContactClick);
        textView5.setOnTouchListener(this.onBodyTouch);
        textView5.setMovementMethod(LinkMovementMethod.getInstance());
        textView5.setLinkTextColor(Theme.getColor(Theme.key_rubinoMentionColor));
        textView5.setTextColor(Theme.getColor(i));
        viewFindViewById2.setOnClickListener(this.onSettingClicked);
        viewFindViewById.setOnClickListener(onClickListener);
        textView11.setOnClickListener(this.onFollowerClicked);
        textView12.setOnClickListener(this.onFollowerClicked);
        textView2.setOnClickListener(this.onFollowerClicked);
        textView3.setOnClickListener(this.onFollowerClicked);
        textView2.setTextColor(Theme.getColor(i));
        textView3.setTextColor(Theme.getColor(i));
        textView11.setTextColor(Theme.getColor(i));
        textView12.setTextColor(Theme.getColor(i));
        textView10.setTextColor(Theme.getColor(i));
        textView.setTextColor(Theme.getColor(i));
        insStoryAvatarView.setOnClickListener(this.onOpenStoryClick);
        setData();
    }

    public void setProfile(RubinoProfileObject rubinoProfileObject) {
        this.profileObject = rubinoProfileObject;
    }

    public void setData() {
        setUserInfo();
        setButtons();
        setNumbers();
        setStoryStatus();
    }

    public void setNumbers() {
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.currentAccount).profileMap.get(this.profileObject.id);
        boolean zIsProfileLoading = RubinoController.getInstance(this.currentAccount).isProfileLoading(this.profileObject.id);
        String str = BuildConfig.FLAVOR;
        if (zIsProfileLoading && rubinoProfileObject == null) {
            this.postCountTextView.setText(BuildConfig.FLAVOR);
            this.followingCountTextView.setText(BuildConfig.FLAVOR);
            this.followerCountTextView.setText(BuildConfig.FLAVOR);
            return;
        }
        TextView textView = this.postCountTextView;
        String str2 = this.profileObject.postCountString;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        textView.setText(str2);
        TextView textView2 = this.followingCountTextView;
        String str3 = this.profileObject.followingCountString;
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        textView2.setText(str3);
        TextView textView3 = this.followerCountTextView;
        String str4 = this.profileObject.followerCountString;
        if (str4 != null) {
            str = str4;
        }
        textView3.setText(str);
    }

    public void setButtons() {
        this.messageButton.setVisibility(8);
        this.settingButton.setVisibility(8);
        this.leftButtonProgressView.setVisibility(4);
        this.leftButtonText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        GradientDrawable gradientDrawable = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        int iDp = AndroidUtilities.dp(1.0f);
        int i = Theme.key_rubinoFollowingBorderColor;
        gradientDrawable.setStroke(iDp, Theme.getColor(i));
        int i2 = Theme.key_windowBackgroundWhite;
        gradientDrawable.setColor(Theme.getColor(i2));
        this.leftButton.setBackground(gradientDrawable);
        TextView textView = this.leftButtonText;
        int i3 = Theme.key_rubinoBlackColor;
        textView.setTextColor(Theme.getColor(i3));
        GradientDrawable gradientDrawable2 = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable2.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(i));
        gradientDrawable2.setColor(Theme.getColor(i2));
        this.messageButton.setBackground(gradientDrawable2);
        this.messageButtonText.setTextColor(Theme.getColor(i3));
        GradientDrawable gradientDrawable3 = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable3.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(i));
        gradientDrawable3.setColor(Theme.getColor(i2));
        this.contactButton.setBackground(gradientDrawable3);
        this.contactButtonText.setTextColor(Theme.getColor(i3));
        GradientDrawable gradientDrawable4 = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable4.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(i));
        gradientDrawable4.setColor(Theme.getColor(i2));
        this.storeButton.setBackground(gradientDrawable4);
        this.storeButtonText.setTextColor(Theme.getColor(i3));
        GradientDrawable gradientDrawable5 = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable5.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(i));
        gradientDrawable5.setColor(Theme.getColor(i2));
        this.productButton.setBackground(gradientDrawable5);
        this.productButtonText.setTextColor(Theme.getColor(i3));
        GradientDrawable gradientDrawable6 = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable6.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(i));
        gradientDrawable6.setColor(Theme.getColor(i2));
        this.settingButton.setBackground(gradientDrawable6);
        this.settingButtonText.setTextColor(Theme.getColor(i3));
        if (this.profileObject.hasContact()) {
            this.contactButton.setVisibility(0);
            ArrayList<Rubino.AlertItem> contactInfoArray = this.profileObject.getContactInfoArray();
            if (contactInfoArray.size() > 1) {
                this.contactButtonText.setText(LocaleController.getString(R.string.rubinoContact));
            } else if (contactInfoArray.size() > 0) {
                this.contactButtonText.setText(contactInfoArray.get(0).text);
            } else {
                this.contactButton.setVisibility(8);
            }
        } else {
            this.contactButton.setVisibility(8);
        }
        if ((!this.profileObject.isPrivate() || RubinoController.getInstance(this.currentAccount).isProfileFollowed(this.profileObject) || this.profileObject.isMyCurrentProfile()) && !TextUtils.isEmpty(this.profileObject.store_id)) {
            this.storeButton.setVisibility(0);
            this.storeButtonText.setText(LocaleController.getString(R.string.Shop_view));
            this.storeButton.setOnClickListener(this.onStoreClick);
            if (this.profileObject.isMyCurrentProfile()) {
                this.productButtonText.setText(LocaleController.getString(R.string.shop_setting));
                this.productButton.setVisibility(0);
                this.productButton.setOnClickListener(this.onProductClick);
            } else {
                this.productButton.setVisibility(8);
                this.productButton.setOnClickListener(null);
            }
        } else {
            this.productButton.setVisibility(8);
            this.productButton.setOnClickListener(null);
            this.storeButton.setVisibility(8);
            this.storeButton.setOnClickListener(null);
        }
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.currentAccount).profileMap.get(this.profileObject.id);
        if (RubinoController.getInstance(this.currentAccount).isProfileLoading(this.profileObject.id) && rubinoProfileObject == null) {
            this.leftButtonText.setText(LocaleController.getString(R.string.rubinoLoadingProfile));
            this.leftButton.setOnClickListener(null);
            return;
        }
        if (this.profileObject.isMyCurrentProfile()) {
            this.leftButtonText.setText(LocaleController.getString(R.string.rubinoEditProfile));
            this.leftButton.setOnClickListener(this.onEditClicked);
            return;
        }
        if (RubinoController.getInstance(this.currentAccount).isProfileBlocked(this.profileObject)) {
            this.leftButtonText.setText(LocaleController.getString(R.string.rubinoUnBlock));
            this.leftButton.setBackground(this.context.getResources().getDrawable(R.drawable.rubino_follow_background_shape_blue));
            this.leftButtonText.setTextColor(-1);
            this.leftButton.setOnClickListener(this.onBlockClick);
        } else if (RubinoController.getInstance(this.currentAccount).isProfileFollowRequested(this.profileObject)) {
            this.leftButtonText.setText(LocaleController.getString(R.string.rubinoIsRequested));
            this.leftButton.setOnClickListener(this.onFollowClick);
        } else if (RubinoController.getInstance(this.currentAccount).isProfileFollowed(this.profileObject)) {
            this.leftButtonText.setText(LocaleController.getString(R.string.rubinoIsFollowed));
            this.leftButton.setOnClickListener(this.onFollowClick);
            if (this.arrowDownDrawable == null) {
                Drawable drawable = this.context.getResources().getDrawable(R.drawable.search_down);
                this.arrowDownDrawable = drawable;
                drawable.setColorFilter(new PorterDuffColorFilter(ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900), PorterDuff.Mode.SRC_ATOP));
                this.arrowDownDrawable.setBounds(AndroidUtilities.dp(5.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(15.0f), AndroidUtilities.dp(7.0f));
            }
            this.leftButtonText.setCompoundDrawables(null, null, this.arrowDownDrawable, null);
        } else {
            this.leftButtonText.setText(LocaleController.getString(R.string.rubinoFollowAction));
            this.leftButton.setBackground(this.context.getResources().getDrawable(R.drawable.rubino_follow_background_shape_blue));
            this.leftButtonText.setTextColor(-1);
            this.leftButton.setOnClickListener(this.onFollowClick);
        }
        if (this.profileObject.is_message_allowed) {
            this.messageButton.setVisibility(0);
            this.messageButton.setOnClickListener(this.onSendMessageClick);
        } else {
            this.messageButton.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (ApplicationLoader.applicationActivity == null || this.profileObject == null) {
            return;
        }
        ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new ShopDetailFragment(ApplicationLoader.applicationActivity, this.currentAccount, this.profileObject.store_id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        RubinoProfileObject rubinoProfileObject;
        if (ApplicationLoader.applicationActivity == null || (rubinoProfileObject = this.profileObject) == null || rubinoProfileObject.store_id == null) {
            return;
        }
        ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new ProductListFragment(this.profileObject.store_id));
    }

    private void setUserInfo() {
        if (this.profileObject.hasThumbnail()) {
            if (!this.lastLoadedUrl.equals(this.profileObject.full_thumbnail_url)) {
                try {
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.circleCrop().placeholder(R.drawable.placeholder_avatar_man);
                    Glide.with(this.context).asBitmap().apply((BaseRequestOptions<?>) requestOptions).load(this.profileObject.full_thumbnail_url).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileHeaderView.7
                        @Override // com.bumptech.glide.request.target.Target
                        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                        }

                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            ProfileHeaderView.this.imageView.setImageBitmap(bitmap);
                            ProfileHeaderView profileHeaderView = ProfileHeaderView.this;
                            profileHeaderView.lastLoadedUrl = profileHeaderView.profileObject.full_thumbnail_url;
                        }
                    });
                } catch (Exception e) {
                    MyLog.e("messsage GlideException", "Glide" + e.getMessage());
                }
            }
        } else {
            GlideHelper.loadResource(this.context, this.imageView, R.drawable.placeholder_avatar_man);
        }
        if (!this.profileObject.getName().isEmpty()) {
            this.nameTextView.setVisibility(0);
            this.nameTextView.setText(this.profileObject.getName());
        } else {
            this.nameTextView.setVisibility(8);
        }
        if (this.profileObject.bioSpannableString != null) {
            this.bioTextView.setVisibility(0);
            RubinoProfileObject rubinoProfileObject = this.profileObject;
            SpannableString spannableString = rubinoProfileObject.shortBioSpannableString;
            if (spannableString != null) {
                this.bioTextView.setText(spannableString);
            } else {
                this.bioTextView.setText(rubinoProfileObject.bioSpannableString);
            }
        } else {
            this.bioTextView.setVisibility(8);
        }
        this.moreInfoTextView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAClick(float f, float f2, float f3, float f4) {
        float fAbs = Math.abs(f - f2);
        float fAbs2 = Math.abs(f3 - f4);
        int i = this.CLICK_ACTION_THRESHOLD;
        return fAbs < ((float) i) && fAbs2 < ((float) i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openStoryIfExist() {
        StoryController.ProfileStoryInfo instantProfileStoryIdsWithLocal = StoryController.getInstance(this.currentAccount).getInstantProfileStoryIdsWithLocal(this.profileObject, null, false);
        if (instantProfileStoryIdsWithLocal == null) {
            return;
        }
        InsStoryAvatarView insStoryAvatarView = this.imageView;
        float x = insStoryAvatarView.getX() + (insStoryAvatarView.getMeasuredWidth() / 2.0f) + getX();
        float y = ((insStoryAvatarView.getY() + ((insStoryAvatarView.getY() + (insStoryAvatarView.getMeasuredHeight() / 2.0f)) + getY())) / 2.0f) + ActionBar.getCurrentActionBarHeight();
        if (this.profileObject.isMyProfile) {
            StorySeenFragment storySeenFragment = new StorySeenFragment(true);
            storySeenFragment.fragmentPresentOriginX = x;
            storySeenFragment.fragmentPresentOriginY = y;
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storySeenFragment);
            return;
        }
        ArrayList arrayList = new ArrayList();
        StoryListOfAProfileObject storyListOfAProfileObject = new StoryListOfAProfileObject(this.currentAccount);
        storyListOfAProfileObject.profileObject = this.profileObject;
        storyListOfAProfileObject.info = instantProfileStoryIdsWithLocal;
        arrayList.add(storyListOfAProfileObject);
        StoryFragment storyFragment = new StoryFragment(arrayList, 0);
        storyFragment.fragmentPresentOriginX = x;
        storyFragment.fragmentPresentOriginY = y;
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storyFragment);
    }

    public void setStoryStatus() {
        RubinoProfileObject rubinoProfileObject = this.profileObject;
        boolean z = rubinoProfileObject.id != null && rubinoProfileObject.isMyCurrentProfile();
        StoryController.ProfileStoryStatusEnum profileStoriesStatus = StoryController.getInstance(this.currentAccount).getProfileStoriesStatus(this.profileObject.id);
        boolean zProfileHasLive = StoryController.getInstance(this.currentAccount).profileHasLive(this.profileObject.id);
        if (!zProfileHasLive && profileStoriesStatus != StoryController.ProfileStoryStatusEnum.SeenStory && profileStoriesStatus != StoryController.ProfileStoryStatusEnum.NotSeenStory) {
            if (z && RubinoController.getInstance(this.currentAccount).hasPermissionAddStory()) {
                this.imageView.setStatus(InsStoryAvatarView.Status.ADDSTORY);
                return;
            } else {
                this.imageView.setStatus(InsStoryAvatarView.Status.NONE);
                return;
            }
        }
        if (zProfileHasLive) {
            this.imageView.setStatus(InsStoryAvatarView.Status.LIVE);
            return;
        }
        if (z) {
            StoryController.ProfileStorySendingStatusEnum myProfileStorySendingStatus = StoryController.getInstance(this.currentAccount).getMyProfileStorySendingStatus();
            if (myProfileStorySendingStatus == StoryController.ProfileStorySendingStatusEnum.ERRORSENDING) {
                this.imageView.setStatus(InsStoryAvatarView.Status.ERRORSENDING);
                return;
            }
            if (myProfileStorySendingStatus == StoryController.ProfileStorySendingStatusEnum.SENDINGSTORY) {
                this.imageView.setStatus(InsStoryAvatarView.Status.SENDINGSTORY);
                return;
            } else if (profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory) {
                this.imageView.setStatus(InsStoryAvatarView.Status.CLICKED);
                return;
            } else {
                this.imageView.setStatus(InsStoryAvatarView.Status.UNCLICKED);
                return;
            }
        }
        if (profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory) {
            this.imageView.setStatus(InsStoryAvatarView.Status.CLICKED);
        } else {
            this.imageView.setStatus(InsStoryAvatarView.Status.UNCLICKED);
        }
    }
}
