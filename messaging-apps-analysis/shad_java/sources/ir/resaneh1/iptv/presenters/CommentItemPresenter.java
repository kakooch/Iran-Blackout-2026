package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.enums.EnumActionObject;
import ir.resaneh1.iptv.enums.EnumContentType;
import ir.resaneh1.iptv.fragment.ListFragment;
import ir.resaneh1.iptv.fragment.SendPostCommentFragment;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.ActionOnObjectInput;
import ir.resaneh1.iptv.model.CommentObject;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.TimeObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.HashSet;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.LaunchActivity;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class CommentItemPresenter extends AbstractPresenter<CommentObject, MyViewHolder> {
    public boolean isCanReply;
    public HashSet<String> likedItem;
    private Context mContext;
    View.OnLongClickListener onCommentClickListener;
    View.OnClickListener onLikeClickListener;
    View.OnClickListener onReplyClickListener;
    View.OnClickListener onReplyLikeClickListener;
    View.OnClickListener onShowMoreClickListener;
    public String postId;

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_comment_row, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(viewInflate);
        viewInflate.setTag(myViewHolder);
        myViewHolder.commentContainer.setTag(myViewHolder);
        myViewHolder.replyContainer.setTag(myViewHolder);
        myViewHolder.commentContainer.setOnLongClickListener(this.onCommentClickListener);
        myViewHolder.replyContainer.setOnLongClickListener(this.onCommentClickListener);
        myViewHolder.textView.setTag(myViewHolder);
        myViewHolder.imageViewLike.setOnClickListener(this.onLikeClickListener);
        myViewHolder.imageViewLikeReply.setOnClickListener(this.onReplyLikeClickListener);
        myViewHolder.imageViewLike.setTag(myViewHolder);
        myViewHolder.imageViewLikeReply.setTag(myViewHolder);
        myViewHolder.replyButton.setOnClickListener(this.onReplyClickListener);
        myViewHolder.replyButton.setTag(myViewHolder);
        myViewHolder.showMoreButton.setOnClickListener(this.onShowMoreClickListener);
        myViewHolder.showMoreButton.setTag(myViewHolder);
        myViewHolder.imageView.setTag(R.id.imagetag, myViewHolder);
        SpanHelper.makeLinksFocusable(myViewHolder.textView);
        SpanHelper.makeLinksFocusable(myViewHolder.textViewReply);
        myViewHolder.textView.setTag(R.id.imagetag, myViewHolder);
        myViewHolder.textViewReply.setTag(R.id.imagetag, myViewHolder);
        myViewHolder.imageViewReply.setTag(R.id.imagetag, myViewHolder);
        return myViewHolder;
    }

    public CommentItemPresenter(Context context, String str, HashSet<String> hashSet) {
        super(context);
        this.postId = BuildConfig.FLAVOR;
        this.isCanReply = true;
        this.onShowMoreClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ListInput listInput = new ListInput(((CommentObject) ((MyViewHolder) view.getTag()).item).replies);
                listInput.parentId = CommentItemPresenter.this.postId;
                listInput.tagObject.show_type = TagObject.ShowType.postComment;
                ListFragment listFragment = new ListFragment(listInput);
                listFragment.isGrid = false;
                ((LaunchActivity) CommentItemPresenter.this.mContext).getLastFragment().presentFragment(listFragment);
            }
        };
        this.onReplyClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((LaunchActivity) CommentItemPresenter.this.mContext).getLastFragment().presentFragment(new SendPostCommentFragment(((CommentObject) ((MyViewHolder) view.getTag()).item).id, EnumContentType.comment));
                } catch (Exception unused) {
                }
            }
        };
        this.onLikeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActionOnObjectInput actionOnObjectInput;
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                Titem titem = myViewHolder.item;
                if (!((CommentObject) titem).isLiked) {
                    FirebaseEventSender.sendEvent(CommentItemPresenter.this.mContext, "social_like_comment", CommentItemPresenter.this.postId);
                    actionOnObjectInput = new ActionOnObjectInput(((CommentObject) myViewHolder.item).id, EnumContentType.comment + BuildConfig.FLAVOR, EnumActionObject.like);
                    actionOnObjectInput.arg1 = CommentItemPresenter.this.postId;
                    myViewHolder.imageViewLike.setImageResource(R.drawable.ic_like_fill);
                    Titem titem2 = myViewHolder.item;
                    ((CommentObject) titem2).isLiked = true;
                    CommentItemPresenter.this.likedItem.add(((CommentObject) titem2).id);
                    Titem titem3 = myViewHolder.item;
                    ((CommentObject) titem3).count_like = NumberUtils.incrementIfPossibe(((CommentObject) titem3).count_like);
                    myViewHolder.textViewLike.setText(NumberUtils.toPersian(((CommentObject) myViewHolder.item).count_like));
                } else {
                    actionOnObjectInput = new ActionOnObjectInput(((CommentObject) titem).id, EnumContentType.comment + BuildConfig.FLAVOR, EnumActionObject.remove_like);
                    actionOnObjectInput.arg1 = CommentItemPresenter.this.postId;
                    myViewHolder.imageViewLike.setImageResource(R.drawable.ic_like_out_line);
                    Titem titem4 = myViewHolder.item;
                    ((CommentObject) titem4).isLiked = false;
                    CommentItemPresenter.this.likedItem.remove(((CommentObject) titem4).id);
                    Titem titem5 = myViewHolder.item;
                    ((CommentObject) titem5).count_like = NumberUtils.decrementIfPossibe(((CommentObject) titem5).count_like);
                    myViewHolder.textViewLike.setText(NumberUtils.toPersian(((CommentObject) myViewHolder.item).count_like));
                }
                ApiRequestIPTV.getInstance(UserConfig.selectedAccount).actionOnObject(actionOnObjectInput, new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.3.1
                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onFailure(Call call, Throwable th) {
                    }

                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onResponse(Call call, Response response) {
                    }
                });
            }
        };
        this.onReplyLikeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActionOnObjectInput actionOnObjectInput;
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                Titem titem = myViewHolder.item;
                if (titem == 0 || ((CommentObject) titem).reply_comment == null) {
                    return;
                }
                if (((CommentObject) titem).reply_comment.isLiked) {
                    actionOnObjectInput = new ActionOnObjectInput(((CommentObject) titem).reply_comment.id, EnumContentType.comment + BuildConfig.FLAVOR, EnumActionObject.remove_like);
                    actionOnObjectInput.arg1 = CommentItemPresenter.this.postId;
                    myViewHolder.imageViewLikeReply.setImageResource(R.drawable.ic_like_out_line);
                    Titem titem2 = myViewHolder.item;
                    ((CommentObject) titem2).reply_comment.isLiked = false;
                    CommentItemPresenter.this.likedItem.remove(((CommentObject) titem2).reply_comment.id);
                    Titem titem3 = myViewHolder.item;
                    ((CommentObject) titem3).reply_comment.count_like = NumberUtils.decrementIfPossibe(((CommentObject) titem3).reply_comment.count_like);
                    myViewHolder.textViewLikeReply.setText(NumberUtils.toPersian(((CommentObject) myViewHolder.item).reply_comment.count_like));
                } else {
                    actionOnObjectInput = new ActionOnObjectInput(((CommentObject) titem).reply_comment.id, EnumContentType.comment + BuildConfig.FLAVOR, EnumActionObject.like);
                    actionOnObjectInput.arg1 = CommentItemPresenter.this.postId;
                    myViewHolder.imageViewLikeReply.setImageResource(R.drawable.ic_like_fill);
                    Titem titem4 = myViewHolder.item;
                    ((CommentObject) titem4).reply_comment.isLiked = true;
                    CommentItemPresenter.this.likedItem.add(((CommentObject) titem4).reply_comment.id);
                    Titem titem5 = myViewHolder.item;
                    ((CommentObject) titem5).reply_comment.count_like = NumberUtils.incrementIfPossibe(((CommentObject) titem5).reply_comment.count_like);
                    myViewHolder.textViewLikeReply.setText(NumberUtils.toPersian(((CommentObject) myViewHolder.item).reply_comment.count_like));
                }
                ApiRequestIPTV.getInstance(UserConfig.selectedAccount).actionOnObject(actionOnObjectInput, new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.4.1
                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onFailure(Call call, Throwable th) {
                    }

                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onResponse(Call call, Response response) {
                    }
                });
            }
        };
        this.onCommentClickListener = new AnonymousClass5();
        this.mContext = context;
        this.postId = str;
        this.likedItem = hashSet;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, CommentObject commentObject) {
        super.onBindViewHolder((CommentItemPresenter) myViewHolder, (MyViewHolder) commentObject);
        HashSet<String> hashSet = this.likedItem;
        commentObject.isLiked = hashSet != null && hashSet.contains(commentObject.id);
        CommentObject commentObject2 = commentObject.reply_comment;
        if (commentObject2 != null) {
            HashSet<String> hashSet2 = this.likedItem;
            commentObject2.isLiked = hashSet2 != null && hashSet2.contains(commentObject2.id);
        }
        if (commentObject.reply_comment == null) {
            myViewHolder.replyContainer.setVisibility(8);
            myViewHolder.showMoreButton.setVisibility(8);
        } else {
            myViewHolder.replyContainer.setVisibility(0);
            if (commentObject.more_reply) {
                myViewHolder.showMoreButton.setVisibility(0);
            } else {
                myViewHolder.showMoreButton.setVisibility(8);
            }
        }
        if (commentObject.isLiked) {
            myViewHolder.imageViewLike.setImageResource(R.drawable.ic_like_fill);
        } else {
            myViewHolder.imageViewLike.setImageResource(R.drawable.ic_like_out_line);
        }
        myViewHolder.textViewLike.setText(NumberUtils.toPersian(((CommentObject) myViewHolder.item).count_like));
        myViewHolder.commentContainer.setTag(R.id.itemId, commentObject.id);
        myViewHolder.textView.setTag(R.id.itemId, commentObject.id);
        Titem titem = myViewHolder.item;
        if (((CommentObject) titem).reply_comment != null) {
            myViewHolder.replyContainer.setTag(R.id.itemId, ((CommentObject) titem).reply_comment.id);
        }
        myViewHolder.textView.setText(BuildConfig.FLAVOR);
        myViewHolder.textView.append(SpanHelper.makeWithColorAndRelativeSize(commentObject.usertitle, -14606047, 0.9f));
        myViewHolder.imageView.setOnClickListener(null);
        myViewHolder.textView.append("  ");
        myViewHolder.textView.append(commentObject.message);
        myViewHolder.textView.setOnLongClickListener(this.onCommentClickListener);
        TimeObject timeObject = commentObject.time;
        if (timeObject != null && timeObject.en_date != null) {
            myViewHolder.textViewTime.setText(NumberUtils.toPersian(timeObject.getAgoTime()));
        }
        GlideHelper.loadCircle(this.mContext, myViewHolder.imageView, commentObject.avatar_url, R.drawable.placeholder_avatar_man);
        CommentObject commentObject3 = commentObject.reply_comment;
        if (commentObject3 != null) {
            if (commentObject3.isLiked) {
                myViewHolder.imageViewLikeReply.setImageResource(R.drawable.ic_like_fill);
            } else {
                myViewHolder.imageViewLikeReply.setImageResource(R.drawable.ic_like_out_line);
            }
            myViewHolder.textViewLikeReply.setText(NumberUtils.toPersian(((CommentObject) myViewHolder.item).reply_comment.count_like));
            myViewHolder.textViewReply.setText(BuildConfig.FLAVOR);
            myViewHolder.textViewReply.append(SpanHelper.makeWithColorAndRelativeSize(commentObject.reply_comment.usertitle, -14606047, 0.9f));
            myViewHolder.imageViewReply.setOnClickListener(null);
            myViewHolder.textViewReply.append("  ");
            myViewHolder.textViewReply.append(commentObject.reply_comment.message);
            TimeObject timeObject2 = commentObject.reply_comment.time;
            if (timeObject2 != null && timeObject2.en_date != null) {
                myViewHolder.textViewTimeReply.setText(NumberUtils.toPersian(timeObject2.getAgoTime()));
            }
            GlideHelper.loadCircle(this.mContext, myViewHolder.imageViewReply, commentObject.reply_comment.avatar_url, R.drawable.placeholder_avatar_man);
        }
        if (this.isCanReply) {
            myViewHolder.replyButton.setVisibility(0);
        } else {
            myViewHolder.replyButton.setVisibility(4);
        }
    }

    /* renamed from: ir.resaneh1.iptv.presenters.CommentItemPresenter$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnLongClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            final MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(CommentItemPresenter.this.mContext, "در صورتی که این نظر دارای محتوای نامناسب،غیراخلاقی و یا تبلیغاتی هست گزارش کنید");
            threeButtonDialog.button1.setText("انصراف");
            threeButtonDialog.button2.setText("گزارش");
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.5.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.5.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ActionOnObjectInput actionOnObjectInput = new ActionOnObjectInput(((CommentObject) myViewHolder.item).id + BuildConfig.FLAVOR, EnumContentType.comment + BuildConfig.FLAVOR, EnumActionObject.report_comment);
                    actionOnObjectInput.arg1 = CommentItemPresenter.this.postId;
                    ApiRequestIPTV.getInstance(UserConfig.selectedAccount).actionOnObject(actionOnObjectInput, new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.presenters.CommentItemPresenter.5.2.1
                        @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                        public void onFailure(Call call, Throwable th) {
                        }

                        @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                        public void onResponse(Call call, Response response) {
                            ToastiLikeSnack.showL(CommentItemPresenter.this.mContext, LocaleController.getString(R.string.ReportSend));
                        }
                    });
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.show();
            return true;
        }
    }

    public static class MyViewHolder extends AbstractPresenter.AbstractViewHolder<CommentObject> {
        public final View commentContainer;
        public final ImageView imageView;
        public final ImageView imageViewLike;
        public final ImageView imageViewLikeReply;
        public final ImageView imageViewReply;
        public final View replyButton;
        public final View replyContainer;
        private final View showMoreButton;
        public final TextView textView;
        public final TextView textViewLike;
        public final TextView textViewLikeReply;
        public final TextView textViewReply;
        public final TextView textViewTime;
        public final TextView textViewTimeReply;

        public MyViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.textViewTime = (TextView) view.findViewById(R.id.textViewTime);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.imageViewLike = (ImageView) view.findViewById(R.id.imageViewLike);
            this.textViewReply = (TextView) view.findViewById(R.id.textViewMessageReply);
            this.textViewTimeReply = (TextView) view.findViewById(R.id.textViewTimeReply);
            this.imageViewReply = (ImageView) view.findViewById(R.id.imageViewReply);
            this.replyContainer = view.findViewById(R.id.replyContainer);
            this.imageViewLikeReply = (ImageView) view.findViewById(R.id.imageViewLikeReply);
            this.replyButton = view.findViewById(R.id.buttonReply);
            this.showMoreButton = view.findViewById(R.id.textViewShowMoreReply);
            this.commentContainer = view.findViewById(R.id.commentContainer);
            this.textViewLike = (TextView) view.findViewById(R.id.textViewLike);
            this.textViewLikeReply = (TextView) view.findViewById(R.id.textViewLikeReply);
        }
    }
}
