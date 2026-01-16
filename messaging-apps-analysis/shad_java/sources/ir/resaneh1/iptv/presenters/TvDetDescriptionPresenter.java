package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UITextViewKeyValue;
import ir.resaneh1.iptv.model.TVObjectDet;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.Map;

/* loaded from: classes3.dex */
public class TvDetDescriptionPresenter extends AbstractPresenter<TVObjectDet, ViewHolder> {
    public TvDetDescriptionPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.tv_det_description, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, TVObjectDet tVObjectDet) {
        super.onBindViewHolder((TvDetDescriptionPresenter) viewHolder, (ViewHolder) tVObjectDet);
        String str = tVObjectDet.description;
        if (str != null) {
            viewHolder.textView1.setText(str);
        }
        if (viewHolder.linearLayout != null) {
            UITextViewKeyValue uITextViewKeyValue = new UITextViewKeyValue();
            Map<String, String> map = tVObjectDet.characteristics;
            if (map != null) {
                for (String str2 : map.keySet()) {
                    viewHolder.linearLayout.addView(uITextViewKeyValue.createView((Activity) this.context, str2, tVObjectDet.characteristics.get(str2)));
                }
            }
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<TVObjectDet> {
        LinearLayout linearLayout;
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        }
    }
}
