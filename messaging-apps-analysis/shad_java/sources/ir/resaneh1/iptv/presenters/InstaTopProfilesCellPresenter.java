package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class InstaTopProfilesCellPresenter extends AbstractPresenter<InstaProfileObject, ViewHolder> {
    public int height;
    public int width;

    public InstaTopProfilesCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_insta_top_profile, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, InstaProfileObject instaProfileObject) {
        super.onBindViewHolder((InstaTopProfilesCellPresenter) viewHolder, (ViewHolder) instaProfileObject);
        if (this.width > 0 && this.height > 0) {
            viewHolder.itemView.getLayoutParams().width = this.width + AndroidUtilities.dp(4.0f);
            viewHolder.linearLayout.getLayoutParams().width = this.width + AndroidUtilities.dp(4.0f);
        }
        viewHolder.textView1.setText(instaProfileObject.getUsername());
        GlideHelper.loadCircle(this.context, viewHolder.imageView, instaProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
        Titem titem = viewHolder.item;
        if (((InstaProfileObject) titem).is_verified || ((InstaProfileObject) titem).sale_permission) {
            viewHolder.textView1.setCompoundDrawablePadding(AndroidUtilities.dp(2.0f));
            if (((InstaProfileObject) viewHolder.item).sale_permission) {
                viewHolder.textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sale_permission_small, 0);
                return;
            } else {
                viewHolder.textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_insta_verified_small, 0);
                return;
            }
        }
        viewHolder.textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<InstaProfileObject> {
        ImageView imageView;
        View linearLayout;
        public TextView textView1;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.linearLayout = view.findViewById(R.id.linearLayout);
        }
    }
}
