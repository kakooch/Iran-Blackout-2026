package ir.resaneh1.iptv.fragment.rubino;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerObject;
import ir.appp.rghapp.rubinoPostSlider.RGHAnimatedView;
import ir.appp.rghapp.rubinoPostSlider.ScrollingPagerIndicator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.fragment.StoryFragment;
import ir.resaneh1.iptv.fragment.StorySeenFragment;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
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
public class PostCell extends FrameLayout {
    int CLICK_ACTION_THRESHOLD;
    private AnimatorSet addCommentAnimation;
    private DisposableObserver addCommentAnimationObserver;
    private AddCommentListener addCommentListener;
    public AddCommentCell addCommentView;
    public RGHAnimatedView bookmarkImageView;
    public LinearLayout commentContainer;
    int currentAccount;
    public TextView descriptionTextView;
    private DisposableObserver disposable;
    private final FrameLayout frameLayoutBottomRow;
    public FrameLayout frameLayoutProgress;
    public boolean hasFollowingText;
    public ImageView imageViewCart;
    public ImageView imageViewComment;
    public boolean isInCommentPage;
    public boolean isInList;
    public boolean isInPageFragment;
    public TextView likeCountTextView;
    public RGHAnimatedView likeImageView;
    public View linearLayout;
    public Context mContext;
    public ImageView menuImageView;
    private CommentRowView mostLikeCommentView;
    public LinearLayout myCommentContainer;
    View.OnClickListener onAddCommentClick;
    public View.OnTouchListener onBodyTouch;
    View.OnClickListener onBookmarkClickListener;
    View.OnClickListener onCommentClick;
    View.OnClickListener onDirectClicked;
    View.OnClickListener onFollowUnfollowClick;
    View.OnClickListener onLikeClickListener;
    View.OnClickListener onLikeCountClicked;
    View.OnClickListener onMenuClickListener;
    private final View.OnClickListener onStoryClicked;
    View.OnClickListener onUserClicked;
    private int ownerClassGuid;
    public PhotoViewerCell photoViewerCell;
    public RubinoPostObject postObject;
    public ImageView shareImageView;
    public FrameLayout sliderFrameLayout;
    public TextView textViewCost;
    public TextView textViewFollow;
    public TextView textViewSponsor;
    public TextView textViewTime;
    public InsStoryAvatarView userImageView;
    public TextView userTextView;
    public TextView viewCommentTextView;
    public TextView viewCountTextView;

    public interface AddCommentListener {
        void addCommentClick(PostCell postCell, RubinoPostObject rubinoPostObject, CharSequence charSequence);
    }

    public void setPlayerDelegate(PhotoViewerCell.PlayerDelegate playerDelegate) {
        this.photoViewerCell.setPlayerDelegate(playerDelegate);
    }

    public void setAddCommentListener(AddCommentListener addCommentListener) {
        this.addCommentListener = addCommentListener;
    }

    void setBlackColorFilter(ImageView imageView) {
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.MULTIPLY));
    }

    public PostCell(Context context, ViewGroup viewGroup, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.hasFollowingText = false;
        this.isInCommentPage = false;
        this.isInPageFragment = false;
        this.isInList = false;
        new Handler();
        this.CLICK_ACTION_THRESHOLD = AndroidUtilities.dp(2.0f);
        this.onBodyTouch = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.2
            float startX;
            float startY;

            /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
            
                if (r0 != 5) goto L28;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
                /*
                    r11 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    int r1 = r13.getAction()
                    r0.append(r1)
                    java.lang.String r1 = ""
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "onTouch"
                    ir.resaneh1.iptv.logger.MyLog.e(r2, r0)
                    boolean r0 = r12 instanceof android.widget.TextView
                    r2 = 0
                    if (r0 == 0) goto Ld0
                    android.widget.TextView r12 = (android.widget.TextView) r12
                    int r0 = r13.getAction()
                    r3 = 1
                    if (r0 == 0) goto Lc0
                    if (r0 == r3) goto L2f
                    r12 = 5
                    if (r0 == r12) goto Lc0
                    goto Ld0
                L2f:
                    ir.resaneh1.iptv.fragment.rubino.PostCell r0 = ir.resaneh1.iptv.fragment.rubino.PostCell.this
                    float r4 = r11.startX
                    float r5 = r13.getX()
                    float r6 = r11.startY
                    float r7 = r13.getY()
                    boolean r0 = ir.resaneh1.iptv.fragment.rubino.PostCell.access$100(r0, r4, r5, r6, r7)
                    if (r0 == 0) goto Ld0
                    java.lang.CharSequence r0 = r12.getText()
                    android.text.SpannableString r0 = (android.text.SpannableString) r0
                    int r4 = r0.length()
                    java.lang.Class<ir.resaneh1.iptv.helper.RubinoShowMoreSpan> r5 = ir.resaneh1.iptv.helper.RubinoShowMoreSpan.class
                    java.lang.Object[] r4 = r0.getSpans(r2, r4, r5)
                    ir.resaneh1.iptv.helper.RubinoShowMoreSpan[] r4 = (ir.resaneh1.iptv.helper.RubinoShowMoreSpan[]) r4
                    int r5 = r4.length
                    r6 = 0
                L57:
                    if (r6 >= r5) goto Lb1
                    r7 = r4[r6]
                    int r8 = r0.getSpanStart(r7)
                    int r7 = r0.getSpanEnd(r7)
                    android.graphics.Path r9 = new android.graphics.Path
                    r9.<init>()
                    android.text.Layout r10 = r12.getLayout()
                    r10.getSelectionPath(r8, r7, r9)
                    android.graphics.RectF r7 = new android.graphics.RectF
                    r7.<init>()
                    r9.computeBounds(r7, r2)
                    float r8 = r13.getX()
                    float r9 = r13.getY()
                    boolean r7 = r7.contains(r8, r9)
                    if (r7 == 0) goto Lae
                    ir.resaneh1.iptv.fragment.rubino.PostCell r0 = ir.resaneh1.iptv.fragment.rubino.PostCell.this
                    ir.resaneh1.iptv.model.RubinoPostObject r0 = r0.postObject
                    android.text.SpannableString r0 = r0.captionSpannableString
                    if (r0 == 0) goto L8e
                    r1 = r0
                L8e:
                    r12.setText(r1)
                    ir.resaneh1.iptv.fragment.rubino.PostCell r0 = ir.resaneh1.iptv.fragment.rubino.PostCell.this
                    ir.resaneh1.iptv.model.RubinoPostObject r1 = r0.postObject
                    r1.isMoreCaptionClicked = r3
                    int r0 = r0.currentAccount
                    ir.resaneh1.iptv.fragment.rubino.RubinoController r0 = ir.resaneh1.iptv.fragment.rubino.RubinoController.getInstance(r0)
                    ir.resaneh1.iptv.fragment.rubino.PostCell r1 = ir.resaneh1.iptv.fragment.rubino.PostCell.this
                    ir.resaneh1.iptv.model.RubinoPostObject r1 = r1.postObject
                    ir.resaneh1.iptv.model.Rubino$PostObjectFromServer r1 = r1.post
                    java.lang.String r1 = r1.id
                    ir.resaneh1.iptv.model.RubinoPostObject r0 = r0.getFromPostMapIfExist(r1)
                    if (r0 == 0) goto Lb2
                    r0.isMoreCaptionClicked = r3
                    goto Lb2
                Lae:
                    int r6 = r6 + 1
                    goto L57
                Lb1:
                    r3 = 0
                Lb2:
                    if (r3 != 0) goto Ld0
                    float r0 = r13.getX()
                    float r13 = r13.getY()
                    ir.resaneh1.iptv.model.Rubino.checkUserNameOrHashtagClick(r12, r0, r13)
                    goto Ld0
                Lc0:
                    float r12 = r13.getX()
                    r11.startX = r12
                    float r12 = r13.getY()
                    r11.startY = r12
                    java.lang.System.currentTimeMillis()
                    return r3
                Ld0:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.PostCell.AnonymousClass2.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        };
        this.onMenuClickListener = new AnonymousClass3();
        this.onUserClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCell postCell = PostCell.this;
                if (postCell.postObject == null || postCell.isInPageFragment) {
                    return;
                }
                new MainClickHandler().onRubinoProfileClick(PostCell.this.postObject.getProfileTryFromMap());
            }
        };
        this.onLikeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCell postCell = PostCell.this;
                RubinoPostObject rubinoPostObject = postCell.postObject;
                if (rubinoPostObject == null || rubinoPostObject.post == null) {
                    return;
                }
                RubinoController rubinoController = RubinoController.getInstance(postCell.currentAccount);
                PostCell postCell2 = PostCell.this;
                rubinoController.onLikePostClick(postCell2.postObject, postCell2.likeImageView.isShowingFilledState ? Rubino.LikeActionTypeEnum.Unlike : Rubino.LikeActionTypeEnum.Like);
            }
        };
        this.onBookmarkClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCell postCell = PostCell.this;
                RubinoPostObject rubinoPostObject = postCell.postObject;
                if (rubinoPostObject == null || rubinoPostObject.post == null) {
                    return;
                }
                RubinoController rubinoController = RubinoController.getInstance(postCell.currentAccount);
                PostCell postCell2 = PostCell.this;
                rubinoController.onBookmarkClick(postCell2.postObject, postCell2.bookmarkImageView.isShowingFilledState ? Rubino.BookMarkActionEnum.Unbookmark : Rubino.BookMarkActionEnum.Bookmark);
            }
        };
        this.onStoryClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCell postCell = PostCell.this;
                RubinoPostObject rubinoPostObject = postCell.postObject;
                if (rubinoPostObject == null || rubinoPostObject.profile == null || StoryController.getInstance(postCell.currentAccount).getProfileStoriesStatus(PostCell.this.postObject.profile.id) != StoryController.ProfileStoryStatusEnum.NotSeenStory || ApplicationLoader.applicationActivity == null) {
                    return;
                }
                if (PostCell.this.disposable != null) {
                    PostCell.this.disposable.dispose();
                }
                if (StoryController.getInstance(PostCell.this.currentAccount).getInstantProfileStoryIdsWithLocal(PostCell.this.postObject.profile, null, false) != null) {
                    PostCell.this.openStoryIfExist();
                    return;
                }
                PostCell.this.userImageView.setStatus(InsStoryAvatarView.Status.LOADING);
                PostCell postCell2 = PostCell.this;
                postCell2.disposable = (DisposableObserver) StoryController.getInstance(postCell2.currentAccount).getProfileStoryIdsWithLoadStoryObservable(PostCell.this.postObject.profile, 0, 10, false).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.7.2
                    @Override // io.reactivex.functions.Consumer
                    public void accept(Integer num) throws Exception {
                        PostCell.this.setStoryStatus();
                    }
                }).delay(10L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.7.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) {
                        PostCell.this.openStoryIfExist();
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        PostCell.this.setStoryStatus();
                        PostCell.this.openStoryIfExist();
                    }
                });
                ApplicationLoader.applicationActivity.mainCompositeDisposable.add(PostCell.this.disposable);
            }
        };
        this.onLikeCountClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Rubino.PostObjectFromServer postObjectFromServer;
                RubinoPostObject rubinoPostObject = PostCell.this.postObject;
                if (rubinoPostObject == null || (postObjectFromServer = rubinoPostObject.post) == null || postObjectFromServer.likes_count <= 0 || ApplicationLoader.applicationActivity == null) {
                    return;
                }
                ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoProfileListActivity(RubinoProfileListActivity.postLikeAndViewType, PostCell.this.postObject));
            }
        };
        this.onAddCommentClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Rubino.PostObjectFromServer postObjectFromServer;
                PostCell postCell = PostCell.this;
                RubinoPostObject rubinoPostObject = postCell.postObject;
                if (rubinoPostObject == null || (postObjectFromServer = rubinoPostObject.post) == null || !postObjectFromServer.allow_show_comment) {
                    return;
                }
                CharSequence text = null;
                AddCommentCell addCommentCell = postCell.addCommentView;
                TextView textView = addCommentCell.textView1;
                if (view == textView) {
                    text = textView.getText();
                } else {
                    TextView textView2 = addCommentCell.textView2;
                    if (view == textView2) {
                        text = textView2.getText();
                    }
                }
                if (PostCell.this.addCommentListener != null) {
                    AddCommentListener addCommentListener = PostCell.this.addCommentListener;
                    PostCell postCell2 = PostCell.this;
                    addCommentListener.addCommentClick(postCell2, postCell2.postObject, text);
                }
            }
        };
        this.onCommentClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoPostObject rubinoPostObject;
                Rubino.PostObjectFromServer postObjectFromServer;
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                PostCell postCell = PostCell.this;
                if (postCell.isInCommentPage || (rubinoPostObject = postCell.postObject) == null || (postObjectFromServer = rubinoPostObject.post) == null || !postObjectFromServer.allow_show_comment) {
                    return;
                }
                LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
                int i = RubinoCommentListActivity.commentWithCaptionType;
                PostCell postCell2 = PostCell.this;
                launchActivity.lambda$runLinkRequest$40(new RubinoCommentListActivity(i, postCell2.postObject, view == postCell2.imageViewComment));
            }
        };
        this.onFollowUnfollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCell postCell = PostCell.this;
                RubinoPostObject rubinoPostObject = postCell.postObject;
                if (rubinoPostObject == null || rubinoPostObject.post == null) {
                    return;
                }
                RubinoController.getInstance(postCell.currentAccount).doFollowUnfollowAction(PostCell.this.postObject.getProfileTryFromMap());
            }
        };
        this.onDirectClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostCell postCell = PostCell.this;
                if (postCell.postObject == null) {
                    return;
                }
                RubinoController.getInstance(postCell.currentAccount).shareOrCopyPost(false, true, ApplicationLoader.applicationActivity.getLastFragment().compositeDisposable, PostCell.this.postObject);
            }
        };
        this.mContext = context;
        this.hasFollowingText = z;
        this.isInCommentPage = z2;
        this.isInPageFragment = z4;
        this.isInList = z3;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.rubino_post_cell, (ViewGroup) null, false);
        addView(viewGroup2);
        this.linearLayout = viewGroup2.findViewById(R.id.linearLayout);
        FrameLayout frameLayout = (FrameLayout) viewGroup2.findViewById(R.id.frameLayoutButtomRows);
        this.frameLayoutBottomRow = frameLayout;
        this.menuImageView = (ImageView) viewGroup2.findViewById(R.id.imageViewMenu);
        this.userImageView = (InsStoryAvatarView) viewGroup2.findViewById(R.id.imageViewUser);
        this.userTextView = (TextView) viewGroup2.findViewById(R.id.textViewUser);
        this.likeImageView = (RGHAnimatedView) viewGroup2.findViewById(R.id.imageViewLike);
        this.likeCountTextView = (TextView) viewGroup2.findViewById(R.id.textViewLike);
        this.viewCommentTextView = (TextView) viewGroup2.findViewById(R.id.textViewComment);
        this.bookmarkImageView = (RGHAnimatedView) viewGroup2.findViewById(R.id.imageViewBookmark);
        this.shareImageView = (ImageView) viewGroup2.findViewById(R.id.imageViewShare);
        this.descriptionTextView = (TextView) viewGroup2.findViewById(R.id.textViewDescription);
        this.imageViewComment = (ImageView) viewGroup2.findViewById(R.id.imageViewComment);
        FrameLayout frameLayout2 = (FrameLayout) viewGroup2.findViewById(R.id.frameLayoutSliderCell);
        this.sliderFrameLayout = frameLayout2;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.textViewTime = (TextView) viewGroup2.findViewById(R.id.textViewTime);
        this.imageViewCart = (ImageView) viewGroup2.findViewById(R.id.imageViewPay);
        this.commentContainer = (LinearLayout) viewGroup2.findViewById(R.id.commentLinearLayout);
        this.textViewCost = (TextView) viewGroup2.findViewById(R.id.textViewCost);
        this.viewCountTextView = (TextView) viewGroup2.findViewById(R.id.textViewViewCount);
        this.textViewFollow = (TextView) viewGroup2.findViewById(R.id.textViewFollow);
        this.textViewSponsor = (TextView) viewGroup2.findViewById(R.id.textViewSponsor);
        View viewFindViewById = viewGroup2.findViewById(R.id.deviderPost);
        int i = Theme.key_rubinoGrayColor;
        viewFindViewById.setBackgroundColor(Theme.getColor(i));
        viewFindViewById.setAlpha(0.5f);
        this.descriptionTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
        TextView textView = this.descriptionTextView;
        int i2 = Theme.key_rubinoBlackColor;
        textView.setTextColor(Theme.getColor(i2));
        this.descriptionTextView.setLinkTextColor(Theme.getColor(Theme.key_rubinoMentionColor));
        this.textViewCost.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.likeCountTextView.setTypeface(Theme.getRubinoTypeFaceBold());
        this.viewCountTextView.setTypeface(Theme.getRubinoTypeFaceBold());
        this.viewCommentTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textViewTime.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textViewFollow.setTypeface(Theme.getRubinoTypeFaceBold());
        this.userTextView.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.textViewSponsor.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.menuImageView.setColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP);
        this.likeImageView.setFilledAndrOutlineColor(-2337189, Theme.getColor(i2));
        this.bookmarkImageView.setFilledAndrOutlineColor(Theme.getColor(i2), Theme.getColor(i2));
        this.imageViewComment.setColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP);
        this.shareImageView.setColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP);
        this.likeCountTextView.setTextColor(Theme.getColor(i2));
        this.viewCountTextView.setTextColor(Theme.getColor(i2));
        this.userTextView.setTextColor(Theme.getColor(i2));
        this.textViewSponsor.setTextColor(Theme.getColor(i2));
        this.viewCommentTextView.setTextColor(Theme.getColor(i));
        this.textViewTime.setTextColor(Theme.getColor(i));
        this.frameLayoutProgress = (FrameLayout) viewGroup2.findViewById(R.id.progressBarFrame);
        if (ApplicationLoader.applicationActivity != null) {
            UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, this.frameLayoutProgress, 18);
        }
        if (!z2) {
            CommentRowView commentRowView = new CommentRowView(this, context);
            this.mostLikeCommentView = commentRowView;
            this.commentContainer.addView(commentRowView);
            LinearLayout linearLayout = new LinearLayout(context);
            this.myCommentContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.commentContainer.addView(this.myCommentContainer, LayoutHelper.createFrame(-1, -2.0f));
            AddCommentCell addCommentCell = new AddCommentCell(this.mContext);
            this.addCommentView = addCommentCell;
            this.commentContainer.addView(addCommentCell, LayoutHelper.createFrame(-1, -2.0f));
            this.addCommentView.setOnClickListener(this.onAddCommentClick);
            this.addCommentView.textView1.setOnClickListener(this.onAddCommentClick);
            this.addCommentView.textView2.setOnClickListener(this.onAddCommentClick);
            this.addCommentView.setVisibility(8);
        }
        ScrollingPagerIndicator scrollingPagerIndicator = new ScrollingPagerIndicator(context);
        PhotoViewerCell photoViewerCell = new PhotoViewerCell(this.mContext, scrollingPagerIndicator, z5);
        this.photoViewerCell = photoViewerCell;
        photoViewerCell.setPhotoViewerCellDelegate(new PhotoViewerCell.PhotoViewerCellDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell$$ExternalSyntheticLambda0
            @Override // ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.PhotoViewerCellDelegate
            public final void onUpdateTransitionZ(boolean z6) {
                this.f$0.lambda$new$0(z6);
            }
        });
        this.sliderFrameLayout.addView(this.photoViewerCell, LayoutHelper.createFrame(-1, -1.0f));
        this.sliderFrameLayout.setClipChildren(false);
        this.sliderFrameLayout.setClipToPadding(false);
        frameLayout.addView(scrollingPagerIndicator, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        setClipToPadding(false);
        setClipChildren(false);
        onCreateViewHolder(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (z) {
                setTranslationZ(5.0f);
            } else {
                setTranslationZ(0.0f);
            }
        }
    }

    public int getViewPagerWidth() {
        return DimensionHelper.getInstaPostMaxWidth(this.mContext);
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        int viewPagerWidth = getViewPagerWidth();
        this.linearLayout.getLayoutParams().width = viewPagerWidth;
        this.sliderFrameLayout.getLayoutParams().height = viewPagerWidth;
        this.viewCommentTextView.setOnClickListener(this.onCommentClick);
        this.imageViewComment.setOnClickListener(this.onCommentClick);
        this.userTextView.setOnClickListener(this.onUserClicked);
        this.likeImageView.setOnClickListener(this.onLikeClickListener);
        this.bookmarkImageView.setOnClickListener(this.onBookmarkClickListener);
        this.userImageView.setOnClickListener(this.onUserClicked);
        this.menuImageView.setOnClickListener(this.onMenuClickListener);
        this.descriptionTextView.setOnTouchListener(this.onBodyTouch);
        this.likeCountTextView.setOnClickListener(this.onLikeCountClicked);
        this.viewCountTextView.setOnClickListener(this.onLikeCountClicked);
        this.textViewFollow.setOnClickListener(this.onFollowUnfollowClick);
        this.shareImageView.setOnClickListener(this.onDirectClicked);
    }

    public void setPostObject(RubinoPostObject rubinoPostObject, int i) {
        this.postObject = rubinoPostObject;
        this.ownerClassGuid = i;
        setUserNameAndFollowView();
        setSponsor();
        this.frameLayoutProgress.setVisibility(4);
        setCaption();
        setCommentView();
        this.sliderFrameLayout.getLayoutParams().height = rubinoPostObject.viewPagerHeight;
        GlideHelper.loadCircle(ApplicationLoader.applicationContext, this.userImageView, rubinoPostObject.getProfileTryFromMap().full_thumbnail_url, R.drawable.placeholder_avatar_man);
        setLikeAndViewCount();
        setLikeIcon(false);
        setBookmarkIcon(false);
        setTime();
        setPriceView();
        setSlider();
        setStoryStatus();
    }

    private void setSlider() {
        PhotoViewerCell photoViewerCell = this.photoViewerCell;
        RubinoPostObject rubinoPostObject = this.postObject;
        photoViewerCell.setPhotoSlideObject(rubinoPostObject.photoSlideObject, rubinoPostObject, this.ownerClassGuid);
    }

    private void setTime() {
        this.textViewTime.setText(this.postObject.getPersianCreateDateString() != null ? this.postObject.getPersianCreateDateString() : BuildConfig.FLAVOR);
    }

    public void setBookmarkIcon(boolean z) {
        this.bookmarkImageView.updateIcon(this.postObject.isBookmarked, z);
    }

    public void setLikeIcon(boolean z) {
        this.likeImageView.updateIcon(this.postObject.isLiked, z);
    }

    public void setSponsor() {
        String str = this.postObject.post.sponsored_text;
        if (str != null && !str.isEmpty()) {
            this.textViewSponsor.setVisibility(0);
            this.textViewSponsor.setText(this.postObject.post.sponsored_text);
        } else {
            this.textViewSponsor.setVisibility(8);
        }
    }

    public void setUserNameAndFollowView() {
        boolean zIsProfileFollowed = RubinoController.getInstance(this.currentAccount).isProfileFollowed(this.postObject.getProfileTryFromMap());
        if (this.postObject.getProfileTryFromMap() != null) {
            boolean z = this.hasFollowingText;
            if (z && !this.postObject.isMyPost && !zIsProfileFollowed) {
                this.textViewFollow.setText(LocaleController.getString(R.string.follow));
                this.textViewFollow.setTextColor(this.mContext.getResources().getColor(R.color.rubino_blue));
                this.textViewFollow.setVisibility(0);
                this.userTextView.setText(this.postObject.getProfileTryFromMap().username + " .");
                return;
            }
            if (z && !this.postObject.isMyPost && zIsProfileFollowed) {
                this.textViewFollow.setText(LocaleController.getString(R.string.following));
                this.textViewFollow.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
                this.textViewFollow.setVisibility(0);
                this.userTextView.setText(this.postObject.getProfileTryFromMap().username + " .");
                return;
            }
            this.textViewFollow.setVisibility(8);
            this.userTextView.setText(this.postObject.getProfileTryFromMap().username);
            return;
        }
        this.userTextView.setText(BuildConfig.FLAVOR);
        this.textViewFollow.setText(BuildConfig.FLAVOR);
    }

    private void setCaption() {
        Rubino.PostObjectFromServer postObjectFromServer;
        this.descriptionTextView.setVisibility(8);
        RubinoPostObject rubinoPostObject = this.postObject;
        if (rubinoPostObject == null || (postObjectFromServer = rubinoPostObject.post) == null) {
            return;
        }
        String str = postObjectFromServer.caption;
        if (str != null) {
            CharSequence charSequence = BuildConfig.FLAVOR;
            if (!str.equals(BuildConfig.FLAVOR)) {
                this.descriptionTextView.setVisibility(0);
                this.descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance());
                if (this.isInList) {
                    if (!this.postObject.shortCaption.isEmpty()) {
                        RubinoPostObject rubinoPostObject2 = this.postObject;
                        if (!rubinoPostObject2.isMoreCaptionClicked) {
                            TextView textView = this.descriptionTextView;
                            CharSequence charSequence2 = rubinoPostObject2.shortCaptionSpannableString;
                            if (charSequence2 != null) {
                                charSequence = charSequence2;
                            }
                            textView.setText(charSequence);
                            return;
                        }
                    }
                    TextView textView2 = this.descriptionTextView;
                    CharSequence charSequence3 = this.postObject.captionSpannableString;
                    if (charSequence3 != null) {
                        charSequence = charSequence3;
                    }
                    textView2.setText(charSequence);
                    return;
                }
                TextView textView3 = this.descriptionTextView;
                CharSequence charSequence4 = this.postObject.captionSpannableString;
                if (charSequence4 != null) {
                    charSequence = charSequence4;
                }
                textView3.setText(charSequence);
                return;
            }
        }
        this.descriptionTextView.setVisibility(8);
    }

    public void setCommentView() {
        DisposableObserver disposableObserver = this.addCommentAnimationObserver;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        AnimatorSet animatorSet = this.addCommentAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CommentRowView commentRowView = this.mostLikeCommentView;
        if (commentRowView != null) {
            commentRowView.setVisibility(8);
        }
        this.viewCommentTextView.setVisibility(8);
        this.imageViewComment.setVisibility(8);
        this.myCommentContainer.removeAllViews();
        RubinoPostObject rubinoPostObject = this.postObject;
        if (rubinoPostObject == null || rubinoPostObject.post == null) {
            AddCommentCell addCommentCell = this.addCommentView;
            if (addCommentCell != null) {
                addCommentCell.setVisibility(8);
                return;
            }
            return;
        }
        if (!this.isInCommentPage && RubinoController.getInstance(this.currentAccount).hasPermissionAddComment()) {
            RubinoPostObject rubinoPostObject2 = this.postObject;
            if (rubinoPostObject2.post.allow_show_comment) {
                if (rubinoPostObject2.isAddCommentAnimationEnded) {
                    this.addCommentView.setVisibility(0);
                } else {
                    this.addCommentView.setVisibility(8);
                }
                RubinoPostObject rubinoPostObject3 = this.postObject;
                RubinoCommentObject rubinoCommentObject = rubinoPostObject3.mostLikeComment;
                if (rubinoCommentObject != null && rubinoCommentObject.contentSpannableString != null && !rubinoCommentObject.isContentMoreThanMax) {
                    rubinoCommentObject.comment.post_id = rubinoPostObject3.post.id;
                    this.mostLikeCommentView.setComment(rubinoCommentObject);
                    this.mostLikeCommentView.setVisibility(0);
                }
                if (this.postObject.myComments.size() > 0) {
                    Iterator<RubinoCommentObject> it = this.postObject.myComments.iterator();
                    while (it.hasNext()) {
                        RubinoCommentObject next = it.next();
                        CommentRowView commentRowView2 = new CommentRowView(this, this.mContext);
                        commentRowView2.setComment(next);
                        this.myCommentContainer.addView(commentRowView2);
                    }
                }
            } else {
                AddCommentCell addCommentCell2 = this.addCommentView;
                if (addCommentCell2 != null) {
                    addCommentCell2.setVisibility(8);
                }
            }
        } else {
            AddCommentCell addCommentCell3 = this.addCommentView;
            if (addCommentCell3 != null) {
                addCommentCell3.setVisibility(8);
            }
        }
        if (this.postObject.post.allow_show_comment) {
            this.viewCommentTextView.setVisibility(0);
            this.imageViewComment.setVisibility(0);
        } else {
            this.viewCommentTextView.setVisibility(8);
            this.imageViewComment.setVisibility(8);
        }
        setCommentNumber();
    }

    public void startAnimationComment() {
        if (RubinoController.getInstance(this.currentAccount).hasPermissionAddComment() && this.postObject.post.allow_show_comment && this.addCommentView.getVisibility() != 0) {
            try {
                AnimatorSet animatorSet = this.addCommentAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.addCommentAnimation = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.addCommentView, "alpha", 0.0f, 1.0f));
                this.addCommentAnimation.setInterpolator(new DecelerateInterpolator());
                this.addCommentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (PostCell.this.addCommentAnimation == null || !PostCell.this.addCommentAnimation.equals(animator)) {
                            return;
                        }
                        PostCell.this.addCommentView.setVisibility(0);
                        PostCell.this.addCommentView.setAlpha(0.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (PostCell.this.addCommentAnimation == null || !PostCell.this.addCommentAnimation.equals(animator)) {
                            return;
                        }
                        PostCell.this.addCommentView.setAlpha(1.0f);
                        PostCell.this.postObject.isAddCommentAnimationEnded = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        AddCommentCell addCommentCell = PostCell.this.addCommentView;
                        if (addCommentCell == null || !addCommentCell.equals(animator)) {
                            return;
                        }
                        PostCell.this.addCommentView.setVisibility(8);
                    }
                });
                this.addCommentAnimation.setDuration(200L);
                this.addCommentAnimation.start();
            } catch (Exception unused) {
            }
        }
    }

    private void setCommentNumber() {
        Rubino.PostObjectFromServer postObjectFromServer = this.postObject.post;
        if (!postObjectFromServer.allow_show_comment) {
            this.viewCommentTextView.setVisibility(8);
            return;
        }
        if (this.isInCommentPage) {
            this.viewCommentTextView.setVisibility(8);
            return;
        }
        if (postObjectFromServer.comment_count > 0) {
            this.viewCommentTextView.setVisibility(0);
            TextView textView = this.viewCommentTextView;
            CharSequence charSequence = this.postObject.commentCountSpannableString;
            if (charSequence == null) {
                charSequence = BuildConfig.FLAVOR;
            }
            textView.setText(charSequence);
            return;
        }
        this.viewCommentTextView.setVisibility(8);
    }

    public void setLikeAndViewCount() {
        int i = this.postObject.post.video_view_count;
        CharSequence charSequence = BuildConfig.FLAVOR;
        if (i > 0) {
            this.likeCountTextView.setVisibility(8);
            this.viewCountTextView.setVisibility(0);
            if (this.postObject.post.video_view_count == 0) {
                this.viewCountTextView.setVisibility(8);
            } else {
                this.viewCountTextView.setVisibility(0);
            }
            TextView textView = this.viewCountTextView;
            CharSequence charSequence2 = this.postObject.viewCountSpannableString;
            if (charSequence2 != null) {
                charSequence = charSequence2;
            }
            textView.setText(charSequence);
            return;
        }
        this.viewCountTextView.setVisibility(8);
        this.likeCountTextView.setVisibility(0);
        if (this.postObject.post.likes_count == 0) {
            this.likeCountTextView.setVisibility(8);
        } else {
            this.likeCountTextView.setVisibility(0);
        }
        TextView textView2 = this.likeCountTextView;
        CharSequence charSequence3 = this.postObject.likeCountSpannableString;
        if (charSequence3 != null) {
            charSequence = charSequence3;
        }
        textView2.setText(charSequence);
    }

    private void setPriceView() {
        this.textViewCost.setVisibility(8);
        this.imageViewCart.setVisibility(8);
    }

    public int getAddCommentTop() {
        return this.addCommentView.getTop() + this.commentContainer.getTop() + ((View) this.commentContainer.getParent()).getTop() + ((View) ((View) this.commentContainer.getParent()).getParent()).getTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAClick(float f, float f2, float f3, float f4) {
        float fAbs = Math.abs(f - f2);
        float fAbs2 = Math.abs(f3 - f4);
        int i = this.CLICK_ACTION_THRESHOLD;
        return fAbs < ((float) i) && fAbs2 < ((float) i);
    }

    /* renamed from: ir.resaneh1.iptv.fragment.rubino.PostCell$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final String str;
            String str2;
            RubinoPostObject rubinoPostObject = PostCell.this.postObject;
            if (rubinoPostObject == null || rubinoPostObject.post == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (PostCell.this.postObject.isMyPost) {
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoDeletePost), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        RubinoController.getInstance(PostCell.this.currentAccount).deletePost(PostCell.this.postObject);
                    }
                }));
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoEditPost), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        RubinoController.getInstance(PostCell.this.currentAccount).onEditPostClicked(ApplicationLoader.applicationActivity.getLastFragment(), PostCell.this.postObject);
                    }
                }));
                if (PostCell.this.postObject.post.is_for_sale) {
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSaleReport), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            RubinoController.getInstance(PostCell.this.currentAccount).onPostSaleListClick(PostCell.this.postObject.post.id);
                        }
                    }));
                }
                RubinoProfileObject instantProfileInfoIfExistFromMap = RubinoController.getInstance(PostCell.this.currentAccount).getInstantProfileInfoIfExistFromMap(PostCell.this.postObject.post.profile_id);
                if (instantProfileInfoIfExistFromMap == null || (str2 = instantProfileInfoIfExistFromMap.store_id) == null || str2.isEmpty()) {
                    String str3 = PostCell.this.postObject.post.profile_store_id;
                    str = (str3 == null || str3.isEmpty()) ? null : PostCell.this.postObject.post.profile_store_id;
                } else {
                    str = instantProfileInfoIfExistFromMap.store_id;
                }
                if (str != null) {
                    arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSetPostProducts), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
                            String str4 = str;
                            Rubino.PostObjectFromServer postObjectFromServer = PostCell.this.postObject.post;
                            launchActivity.lambda$runLinkRequest$40(new ProductListToAddPostActivity(str4, postObjectFromServer.id, postObjectFromServer.store_product_ids));
                        }
                    }));
                }
            } else {
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoReport), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ArrayList arrayList2 = new ArrayList();
                        final RubinoBottomUpAlert rubinoBottomUpAlertCreateRubinoDialogItems = RubinoBottomUpAlert.createRubinoDialogItems(ApplicationLoader.applicationActivity.getLastFragment(), LocaleController.getString(R.string.rubinoReport), arrayList2);
                        arrayList2.add(new Rubino.AlertBoldItem(LocaleController.getString(R.string.rubinoReportProfileQuestion)));
                        arrayList2.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSpam), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.5.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                RubinoController.getInstance(PostCell.this.currentAccount).reportPost(PostCell.this.postObject, 1);
                                rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                            }
                        }));
                        arrayList2.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoInAppropriate), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.5.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                RubinoController.getInstance(PostCell.this.currentAccount).reportPost(PostCell.this.postObject, 2);
                                rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                            }
                        }));
                        rubinoBottomUpAlertCreateRubinoDialogItems.listAdapter.notifyDataSetChanged();
                        ApplicationLoader.applicationActivity.getLastFragment().showDialog(rubinoBottomUpAlertCreateRubinoDialogItems);
                    }
                }));
                arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoCopyPost), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        RubinoController.getInstance(PostCell.this.currentAccount).shareOrCopyPost(true, false, ApplicationLoader.applicationActivity.getLastFragment().compositeDisposable, PostCell.this.postObject);
                    }
                }));
                arrayList.add(new Rubino.AlertItem(LocaleController.getString("rubinoShare", R.string.rubinoShare), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostCell.3.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        RubinoController.getInstance(PostCell.this.currentAccount).shareOrCopyPost(false, false, ApplicationLoader.applicationActivity.getLastFragment().compositeDisposable, PostCell.this.postObject);
                    }
                }));
            }
            if (arrayList.size() > 0) {
                RubinoController.showRubinoCenterDialog(null, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openStoryIfExist() {
        StoryController.ProfileStoryInfo instantProfileStoryIdsWithLocal = StoryController.getInstance(this.currentAccount).getInstantProfileStoryIdsWithLocal(this.postObject.profile, null, false);
        if (instantProfileStoryIdsWithLocal == null) {
            return;
        }
        InsStoryAvatarView insStoryAvatarView = this.userImageView;
        float x = insStoryAvatarView.getX() + (insStoryAvatarView.getMeasuredWidth() / 2.0f) + getX();
        float y = insStoryAvatarView.getY() + (insStoryAvatarView.getMeasuredHeight() / 2.0f) + getY() + ActionBar.getCurrentActionBarHeight();
        if (this.postObject.profile.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            StorySeenFragment storySeenFragment = new StorySeenFragment(true);
            storySeenFragment.fragmentPresentOriginX = x;
            storySeenFragment.fragmentPresentOriginY = y;
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storySeenFragment);
            return;
        }
        ArrayList arrayList = new ArrayList();
        StoryListOfAProfileObject storyListOfAProfileObject = new StoryListOfAProfileObject(this.currentAccount);
        storyListOfAProfileObject.profileObject = this.postObject.profile;
        storyListOfAProfileObject.info = instantProfileStoryIdsWithLocal;
        arrayList.add(storyListOfAProfileObject);
        StoryFragment storyFragment = new StoryFragment(arrayList, 0);
        storyFragment.fragmentPresentOriginX = x;
        storyFragment.fragmentPresentOriginY = y;
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storyFragment);
    }

    public void setStoryStatus() {
        RubinoPostObject rubinoPostObject = this.postObject;
        if (rubinoPostObject != null && rubinoPostObject.profile != null) {
            StoryController.ProfileStoryStatusEnum profileStoriesStatus = StoryController.getInstance(this.currentAccount).getProfileStoriesStatus(this.postObject.profile.id);
            if (profileStoriesStatus == null || profileStoriesStatus == StoryController.ProfileStoryStatusEnum.NoStory || profileStoriesStatus == StoryController.ProfileStoryStatusEnum.Unknown || profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory) {
                this.userImageView.setStatus(InsStoryAvatarView.Status.NONE);
                this.userImageView.setOnClickListener(this.onUserClicked);
                return;
            } else {
                if (profileStoriesStatus == StoryController.ProfileStoryStatusEnum.NotSeenStory) {
                    this.userImageView.setStatus(InsStoryAvatarView.Status.UNCLICKED);
                    this.userImageView.setOnClickListener(this.onStoryClicked);
                    return;
                }
                return;
            }
        }
        this.userImageView.setStatus(InsStoryAvatarView.Status.NONE);
        this.userImageView.setOnClickListener(this.onUserClicked);
    }

    public class CommentRowView extends FrameLayout {
        RubinoCommentObject commentObject;
        TextView textView;

        public CommentRowView(PostCell postCell, Context context) {
            super(context);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
            this.textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.textView.setPadding(0, 0, 0, AndroidUtilities.dp(4.0f));
            this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            this.textView.setTextSize(2, 13.0f);
            this.textView.setLinkTextColor(Theme.getColor(Theme.key_rubinoMentionColor));
            this.textView.setGravity(3);
            if (Build.VERSION.SDK_INT >= 17) {
                this.textView.setTextDirection(3);
            }
            this.textView.setOnTouchListener(postCell.onBodyTouch);
            addView(this.textView, LayoutHelper.createFrame(-1, -2.0f));
        }

        public void setComment(RubinoCommentObject rubinoCommentObject) {
            this.commentObject = rubinoCommentObject;
            this.textView.setText(rubinoCommentObject.contentSpannableString);
            if (rubinoCommentObject.isLocal) {
                setAlpha(0.5f);
            } else {
                setAlpha(1.0f);
            }
        }
    }

    public boolean isPlaying() {
        PhotoViewerCell photoViewerCell;
        PhotoViewerObject photoViewerObject;
        PhotoViewerCell photoViewerCell2 = this.photoViewerCell;
        if (photoViewerCell2 == null || photoViewerCell2.getVideoPlayer() == null || (photoViewerObject = (photoViewerCell = this.photoViewerCell).currentObject) == null || !photoViewerObject.isVideo) {
            return false;
        }
        return photoViewerCell.getVideoPlayer().isPlaying();
    }
}
