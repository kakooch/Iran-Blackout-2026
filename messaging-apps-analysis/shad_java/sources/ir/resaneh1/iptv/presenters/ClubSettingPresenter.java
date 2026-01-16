package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.ClubSetttingItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ClubSettingPresenter extends AbstractPresenter<ClubSetttingItem, ViewHolder> {
    public ClubSettingPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_setting_club, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, ClubSetttingItem clubSetttingItem) {
        super.onBindViewHolder((ClubSettingPresenter) viewHolder, (ViewHolder) clubSetttingItem);
        GlideHelper.load(this.context, viewHolder.imageView, clubSetttingItem.icon_url);
        ArrayList<ClubSetttingItem> arrayList = clubSetttingItem.items;
        if (arrayList != null && arrayList.size() > 0) {
            viewHolder.moreImageView.setVisibility(0);
        } else {
            viewHolder.moreImageView.setVisibility(4);
        }
        viewHolder.text1TextView.setText(clubSetttingItem.text1);
        viewHolder.text2TextView.setText(clubSetttingItem.text2);
        viewHolder.text1TextView.setTextColor(clubSetttingItem.color1.getColor());
        viewHolder.text2TextView.setTextColor(clubSetttingItem.color2.getColor());
        String str = clubSetttingItem.text2;
        if (str == null || str.length() == 0) {
            viewHolder.text1TextView.setPadding(0, 0, 0, 0);
        } else {
            viewHolder.text1TextView.setPadding(AndroidUtilities.dp(88.0f), 0, 0, 0);
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<ClubSetttingItem> {
        ImageView imageView;
        ImageView moreImageView;
        TextView text1TextView;
        TextView text2TextView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.text1TextView = (TextView) view.findViewById(R.id.textView);
            this.text2TextView = (TextView) view.findViewById(R.id.textView2);
            this.moreImageView = (ImageView) view.findViewById(R.id.imageViewMore);
        }
    }
}
