package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.model.RubinoCameraTypeItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoCameraTypeCellPresenter extends AbstractPresenter<RubinoCameraTypeItem, ViewHolder> {
    public RubinoCameraTypeCellPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.context);
        ViewHolder viewHolder = new ViewHolder(frameLayout);
        frameLayout.setTag(viewHolder);
        viewHolder.frameLayoutContainer = frameLayout;
        TextView textView = new TextView(this.context);
        viewHolder.textView1 = textView;
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebbold.ttf"));
        viewHolder.textView1.setTextSize(1, 14.0f);
        viewHolder.textView1.setTextColor(-1);
        viewHolder.textView1.setGravity(16);
        viewHolder.textView1.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        viewHolder.frameLayoutContainer.addView(viewHolder.textView1, LayoutHelper.createFrame(-2, -1.0f));
        viewHolder.frameLayoutContainer.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, RubinoCameraTypeItem rubinoCameraTypeItem) {
        super.onBindViewHolder((RubinoCameraTypeCellPresenter) viewHolder, (ViewHolder) rubinoCameraTypeItem);
        viewHolder.textView1.setText(rubinoCameraTypeItem.getName());
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<RubinoCameraTypeItem> {
        public FrameLayout frameLayoutContainer;
        public TextView textView1;

        public ViewHolder(View view) {
            super(view);
        }
    }
}
