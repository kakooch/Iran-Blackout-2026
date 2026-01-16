package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.rubinoPostSlider.RGHAnimatedView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class CommentCell extends FrameLayout {
    public static int captionPostType = 1;
    public static int commentType;
    private int BIG_SIZE_IMAGE;
    int CLICK_ACTION_THRESHOLD;
    private int SMALL_SIZE_IMAGE;
    public FrameLayout commentContainer;
    int currentAccount;
    public RubinoCommentObject currentComment;
    public RubinoPostObject currentPost;
    GestureDetector gestureDetector;
    public InsStoryAvatarView imageView;
    public RGHAnimatedView imageViewLike;
    boolean isClickConsumed;
    boolean isLongClick;
    public Context mContext;
    public boolean needDivider;
    View.OnTouchListener onBodyTouch;
    View.OnClickListener onLikeClickListener;
    View.OnClickListener onLikeCountClick;
    private View.OnLongClickListener onLongClickListener;
    public OnReplyClickListener onReplyClick;
    View.OnClickListener onReplyClickListener;
    View.OnClickListener onUserClick;
    public RubinoCommentObject parentComment;
    public String postId;
    public TextView textView;
    public TextView textViewLikeCount;
    public TextView textViewReply;
    public TextView textViewTime;
    public int type;
    public View view;

    public interface OnReplyClickListener {
        void onReplyClick(RubinoCommentObject rubinoCommentObject, RubinoCommentObject rubinoCommentObject2, int i);
    }

    public void setOnReplyClick(OnReplyClickListener onReplyClickListener) {
        this.onReplyClick = onReplyClickListener;
    }

    public void setonLongClick(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public CommentCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.BIG_SIZE_IMAGE = AndroidUtilities.dp(42.0f);
        this.SMALL_SIZE_IMAGE = AndroidUtilities.dp(34.0f);
        this.isClickConsumed = false;
        this.isLongClick = false;
        this.onUserClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.CommentCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentCell commentCell = CommentCell.this;
                if (commentCell.type == CommentCell.captionPostType) {
                    if (commentCell.currentPost == null) {
                        return;
                    }
                    commentCell.isClickConsumed = true;
                    new MainClickHandler().onRubinoProfileClick(CommentCell.this.currentPost.getProfileTryFromMap());
                    return;
                }
                if (commentCell.currentComment == null) {
                    return;
                }
                commentCell.isClickConsumed = true;
                new MainClickHandler().onRubinoProfileClick(CommentCell.this.currentComment.getProfileTryFromMap());
            }
        };
        this.onLikeCountClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.CommentCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentCell commentCell;
                RubinoCommentObject rubinoCommentObject;
                if (ApplicationLoader.applicationActivity == null || (rubinoCommentObject = (commentCell = CommentCell.this).currentComment) == null || rubinoCommentObject.comment.likes_count <= 0) {
                    return;
                }
                commentCell.isClickConsumed = true;
                LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
                CommentCell commentCell2 = CommentCell.this;
                launchActivity.lambda$runLinkRequest$40(new RubinoProfileListActivity(commentCell2.postId, commentCell2.currentComment));
            }
        };
        this.onReplyClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.CommentCell.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoCommentObject rubinoCommentObject;
                RubinoCommentObject rubinoCommentObject2;
                CommentCell commentCell = CommentCell.this;
                OnReplyClickListener onReplyClickListener = commentCell.onReplyClick;
                if (onReplyClickListener == null || (rubinoCommentObject = commentCell.currentComment) == null) {
                    return;
                }
                commentCell.isClickConsumed = true;
                if (rubinoCommentObject.isReply && (rubinoCommentObject2 = commentCell.parentComment) != null) {
                    onReplyClickListener.onReplyClick(rubinoCommentObject2, rubinoCommentObject, commentCell.getHeight());
                } else {
                    onReplyClickListener.onReplyClick(null, rubinoCommentObject, commentCell.getHeight());
                }
            }
        };
        this.onBodyTouch = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.CommentCell.4
            float startX;
            float startY;

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
            
                if (r0 != 5) goto L26;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
                /*
                    r7 = this;
                    boolean r0 = r8 instanceof android.widget.TextView
                    if (r0 == 0) goto L6e
                    android.widget.TextView r8 = (android.widget.TextView) r8
                    int r0 = r9.getAction()
                    r1 = 0
                    if (r0 == 0) goto L50
                    r2 = 1
                    if (r0 == r2) goto L14
                    r8 = 5
                    if (r0 == r8) goto L50
                    goto L6e
                L14:
                    ir.resaneh1.iptv.fragment.rubino.CommentCell r0 = ir.resaneh1.iptv.fragment.rubino.CommentCell.this
                    float r3 = r7.startX
                    float r4 = r9.getX()
                    float r5 = r7.startY
                    float r6 = r9.getY()
                    boolean r0 = ir.resaneh1.iptv.fragment.rubino.CommentCell.access$000(r0, r3, r4, r5, r6)
                    if (r0 == 0) goto L6e
                    ir.resaneh1.iptv.fragment.rubino.CommentCell r0 = ir.resaneh1.iptv.fragment.rubino.CommentCell.this
                    boolean r3 = r0.isClickConsumed
                    if (r3 != 0) goto L40
                    boolean r3 = r0.isLongClick
                    if (r3 != 0) goto L40
                    float r3 = r9.getX()
                    float r4 = r9.getY()
                    boolean r8 = ir.resaneh1.iptv.model.Rubino.checkUserNameOrHashtagClick(r8, r3, r4)
                    r0.isClickConsumed = r8
                L40:
                    ir.resaneh1.iptv.fragment.rubino.CommentCell r8 = ir.resaneh1.iptv.fragment.rubino.CommentCell.this
                    boolean r0 = r8.isClickConsumed
                    if (r0 != 0) goto L4e
                    android.view.GestureDetector r8 = r8.gestureDetector
                    boolean r8 = r8.onTouchEvent(r9)
                    if (r8 == 0) goto L4f
                L4e:
                    r1 = 1
                L4f:
                    return r1
                L50:
                    ir.resaneh1.iptv.fragment.rubino.CommentCell r8 = ir.resaneh1.iptv.fragment.rubino.CommentCell.this
                    r8.isClickConsumed = r1
                    r8.isLongClick = r1
                    float r8 = r9.getX()
                    r7.startX = r8
                    float r8 = r9.getY()
                    r7.startY = r8
                    java.lang.System.currentTimeMillis()
                    ir.resaneh1.iptv.fragment.rubino.CommentCell r8 = ir.resaneh1.iptv.fragment.rubino.CommentCell.this
                    android.view.GestureDetector r8 = r8.gestureDetector
                    boolean r8 = r8.onTouchEvent(r9)
                    return r8
                L6e:
                    ir.resaneh1.iptv.fragment.rubino.CommentCell r8 = ir.resaneh1.iptv.fragment.rubino.CommentCell.this
                    android.view.GestureDetector r8 = r8.gestureDetector
                    boolean r8 = r8.onTouchEvent(r9)
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.CommentCell.AnonymousClass4.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        };
        this.CLICK_ACTION_THRESHOLD = AndroidUtilities.dp(2.0f);
        this.onLikeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.CommentCell.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentCell commentCell = CommentCell.this;
                RubinoCommentObject rubinoCommentObject = commentCell.currentComment;
                if (rubinoCommentObject == null || rubinoCommentObject.comment == null) {
                    return;
                }
                commentCell.isClickConsumed = true;
                RubinoController rubinoController = RubinoController.getInstance(commentCell.currentAccount);
                CommentCell commentCell2 = CommentCell.this;
                rubinoController.onLikeCommentClick(commentCell2.currentComment, commentCell2.postId, commentCell2.imageViewLike.isShowingFilledState ? Rubino.LikeActionTypeEnum.Unlike : Rubino.LikeActionTypeEnum.Like);
            }
        };
        this.gestureDetector = new GestureDetector(ApplicationLoader.applicationActivity, new GestureDetector.SimpleOnGestureListener() { // from class: ir.resaneh1.iptv.fragment.rubino.CommentCell.6
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (CommentCell.this.onLongClickListener != null) {
                    CommentCell commentCell = CommentCell.this;
                    if (!commentCell.isClickConsumed) {
                        commentCell.onLongClickListener.onLongClick(CommentCell.this.view);
                        CommentCell.this.isLongClick = true;
                    }
                }
                CommentCell.this.isClickConsumed = false;
            }
        });
        this.mContext = context;
        setWillNotDraw(false);
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.rubino_comment_cell, (ViewGroup) null, false);
        this.view = viewInflate;
        addView(viewInflate);
        this.commentContainer = (FrameLayout) this.view.findViewById(R.id.commentContainer);
        RGHAnimatedView rGHAnimatedView = (RGHAnimatedView) this.view.findViewById(R.id.imageViewLike);
        this.imageViewLike = rGHAnimatedView;
        int i = Theme.key_rubinoBlackColor;
        rGHAnimatedView.setFilledAndrOutlineColor(-2337189, Theme.getColor(i));
        this.imageView = (InsStoryAvatarView) this.view.findViewById(R.id.imageView);
        this.textView = (TextView) this.view.findViewById(R.id.textView);
        this.textViewTime = (TextView) this.view.findViewById(R.id.textViewTime);
        this.textViewLikeCount = (TextView) this.view.findViewById(R.id.textViewLike);
        this.textViewReply = (TextView) this.view.findViewById(R.id.buttonReply);
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView.setLinkTextColor(Theme.getColor(Theme.key_rubinoMentionColor));
        this.textView.setTextColor(Theme.getColor(i));
        this.textViewTime.setTypeface(Theme.getRubinoTypeFaceRegular());
        TextView textView = this.textViewTime;
        int i2 = Theme.key_rubinoGrayColor;
        textView.setTextColor(Theme.getColor(i2));
        this.textViewLikeCount.setTypeface(Theme.getRubinoTypeFaceBold());
        this.textViewLikeCount.setTextColor(Theme.getColor(i2));
        this.textViewReply.setTypeface(Theme.getRubinoTypeFaceBold());
        this.textViewReply.setTextColor(Theme.getColor(i2));
        this.textViewReply.setOnClickListener(this.onReplyClickListener);
        this.textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.textView.setOnTouchListener(this.onBodyTouch);
        this.imageViewLike.setOnClickListener(this.onLikeClickListener);
        this.textViewLikeCount.setOnClickListener(this.onLikeCountClick);
        this.imageView.setOnClickListener(this.onUserClick);
        this.view.setTag(this);
        this.textView.setTag(this);
    }

    public void setPost(RubinoPostObject rubinoPostObject, boolean z) {
        this.needDivider = z;
        this.currentComment = null;
        this.currentPost = rubinoPostObject;
        this.type = captionPostType;
        ((FrameLayout.LayoutParams) this.commentContainer.getLayoutParams()).leftMargin = AndroidUtilities.dp(14.0f);
        this.imageView.getLayoutParams().width = this.BIG_SIZE_IMAGE;
        this.imageView.getLayoutParams().height = this.BIG_SIZE_IMAGE;
        SpannableString spannableString = rubinoPostObject.captionSpannableString;
        if (spannableString != null) {
            this.textView.setText(spannableString);
        } else {
            this.textView.setText(BuildConfig.FLAVOR);
        }
        this.textViewTime.setVisibility(8);
        setLikeCountView();
        this.textViewReply.setVisibility(8);
        this.imageViewLike.setVisibility(8);
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.currentAccount).profileMap.get(rubinoPostObject.post.profile_id);
        if (rubinoProfileObject != null) {
            GlideHelper.loadCircle(this.mContext, this.imageView, rubinoProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
        } else {
            GlideHelper.loadCircle(this.mContext, this.imageView, rubinoPostObject.post.full_post_profile_thumbnail_url, R.drawable.placeholder_avatar_man);
        }
    }

    public void setComment(String str, RubinoCommentObject rubinoCommentObject, RubinoCommentObject rubinoCommentObject2, boolean z) {
        this.needDivider = z;
        this.type = commentType;
        this.postId = str;
        this.currentComment = rubinoCommentObject2;
        this.parentComment = rubinoCommentObject;
        this.currentPost = null;
        setLikeCountView();
        if (rubinoCommentObject2.isReply) {
            this.imageView.getLayoutParams().width = this.SMALL_SIZE_IMAGE;
            this.imageView.getLayoutParams().height = this.SMALL_SIZE_IMAGE;
            ((FrameLayout.LayoutParams) this.commentContainer.getLayoutParams()).leftMargin = AndroidUtilities.dp(64.0f);
        } else {
            this.imageView.getLayoutParams().width = this.BIG_SIZE_IMAGE;
            this.imageView.getLayoutParams().height = this.BIG_SIZE_IMAGE;
            ((FrameLayout.LayoutParams) this.commentContainer.getLayoutParams()).leftMargin = AndroidUtilities.dp(14.0f);
        }
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.currentAccount).profileMap.get(rubinoCommentObject2.comment.profile_id);
        if (rubinoProfileObject != null) {
            GlideHelper.loadCircle(this.mContext, this.imageView, rubinoProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
        } else {
            GlideHelper.loadCircle(this.mContext, this.imageView, rubinoCommentObject2.comment.full_profile_thumbnail_url, R.drawable.placeholder_avatar_man);
        }
        SpannableString spannableString = rubinoCommentObject2.contentSpannableString;
        if (spannableString != null) {
            this.textView.setText(spannableString);
        } else {
            this.textView.setText(BuildConfig.FLAVOR);
        }
        if (this.currentComment.isLocal) {
            this.textViewReply.setVisibility(8);
            this.imageViewLike.setVisibility(8);
            this.textViewTime.setVisibility(0);
            this.textViewTime.setText(LocaleController.getString(R.string.rubinoSendingComment));
            return;
        }
        if (RubinoController.getInstance(this.currentAccount).hasPermissionAddComment()) {
            this.textViewReply.setVisibility(0);
        } else {
            this.textViewReply.setVisibility(8);
        }
        this.imageViewLike.setVisibility(0);
        setLikeIcon(false);
        this.textViewTime.setVisibility(0);
        this.textViewTime.setText(rubinoCommentObject2.getPersianDate());
    }

    public void setLikeCountView() {
        RubinoCommentObject rubinoCommentObject = this.currentComment;
        if (rubinoCommentObject == null) {
            this.textViewLikeCount.setVisibility(8);
            return;
        }
        if (rubinoCommentObject.isLocal) {
            this.textViewLikeCount.setVisibility(8);
        } else if (rubinoCommentObject.comment.likes_count > 0) {
            this.textViewLikeCount.setVisibility(0);
            this.textViewLikeCount.setText(this.currentComment.likeCountString);
        } else {
            this.textViewLikeCount.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAClick(float f, float f2, float f3, float f4) {
        float fAbs = Math.abs(f - f2);
        float fAbs2 = Math.abs(f3 - f4);
        int i = this.CLICK_ACTION_THRESHOLD;
        return fAbs < ((float) i) && fAbs2 < ((float) i);
    }

    public void setLikeIcon(boolean z) {
        this.imageViewLike.updateIcon(this.currentComment.isLiked, z);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(getPaddingLeft(), getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.getDividerPaint());
        }
    }
}
