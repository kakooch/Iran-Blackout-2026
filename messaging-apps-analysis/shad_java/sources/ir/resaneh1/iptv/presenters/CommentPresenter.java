package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.enums.EnumActionObject;
import ir.resaneh1.iptv.enums.EnumContentType;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ActionOnObjectInput;
import ir.resaneh1.iptv.model.CommentObject;
import ir.resaneh1.iptv.model.TimeObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class CommentPresenter extends AbstractPresenter<CommentObject, ViewHolder> {
    View.OnLongClickListener onCommentClickListener;

    public CommentPresenter(Context context) {
        super(context);
        this.onCommentClickListener = new AnonymousClass1();
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_comment, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        viewInflate.setOnLongClickListener(this.onCommentClickListener);
        viewHolder.textView2.setTag(viewHolder);
        viewHolder.textView2.setOnLongClickListener(this.onCommentClickListener);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, CommentObject commentObject) {
        super.onBindViewHolder((CommentPresenter) viewHolder, (ViewHolder) commentObject);
        MyLog.e("VodDetDescription", "onBindViewHolder: ");
        String str = commentObject.usertitle;
        if (str != null) {
            viewHolder.textView1.setText(str);
        }
        String str2 = commentObject.message;
        if (str2 != null) {
            viewHolder.textView2.setText(str2);
        }
        TimeObject timeObject = commentObject.time;
        if (timeObject != null) {
            viewHolder.textView3.setText(NumberUtils.toPersian(timeObject.getAgoTime()));
        }
        GlideHelper.loadCircle(this.context, viewHolder.imageView, commentObject.avatar_url, R.drawable.placeholder_avatar_man);
        viewHolder.ratingBar.setFocusable(false);
        viewHolder.ratingBar.setRating(commentObject.getStar().floatValue());
        viewHolder.itemView.setTag(R.id.itemId, commentObject.id);
        viewHolder.textView2.setTag(R.id.itemId, commentObject.id);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<CommentObject> {
        ImageView imageView;
        RatingBar ratingBar;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.textView3 = (TextView) view.findViewById(R.id.textView3);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.ratingBar = (RatingBar) view.findViewById(R.id.ratingbar);
        }
    }

    /* renamed from: ir.resaneh1.iptv.presenters.CommentPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnLongClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            final ViewHolder viewHolder = (ViewHolder) view.getTag();
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(((AbstractPresenter) CommentPresenter.this).context, "در صورتی که این نظر دارای محتوای نامناسب،غیراخلاقی و یا تبلیغاتی هست گزارش کنید");
            threeButtonDialog.button1.setText("انصراف");
            threeButtonDialog.button2.setText("گزارش");
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.CommentPresenter.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.CommentPresenter.1.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ApiRequestIPTV.getInstance(UserConfig.selectedAccount).actionOnObject(new ActionOnObjectInput(((CommentObject) viewHolder.item).id + BuildConfig.FLAVOR, EnumContentType.comment + BuildConfig.FLAVOR, EnumActionObject.report_comment), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.presenters.CommentPresenter.1.2.1
                        @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                        public void onFailure(Call call, Throwable th) {
                        }

                        @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                        public void onResponse(Call call, Response response) {
                            ToastiLikeSnack.showL(((AbstractPresenter) CommentPresenter.this).context, LocaleController.getString("ReportSent", R.string.ReportSent));
                        }
                    });
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.show();
            return true;
        }
    }
}
