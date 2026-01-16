package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UITextViewKeyValue;
import ir.resaneh1.iptv.model.AODObjectDet;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.Map;

/* loaded from: classes3.dex */
public class AodDetDescriptionPresenter extends AbstractPresenter<AODObjectDet, ViewHolder> {
    public AodDetDescriptionPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.aod_det_description, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, AODObjectDet aODObjectDet) {
        super.onBindViewHolder((AodDetDescriptionPresenter) viewHolder, (ViewHolder) aODObjectDet);
        if (viewHolder.linearLayout != null) {
            UITextViewKeyValue uITextViewKeyValue = new UITextViewKeyValue();
            Map<String, String> map = aODObjectDet.characteristics;
            if (map != null) {
                for (String str : map.keySet()) {
                    viewHolder.linearLayout.addView(uITextViewKeyValue.createView((Activity) this.context, str, aODObjectDet.characteristics.get(str)));
                }
            }
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<AODObjectDet> {
        LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);
            this.linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        }
    }
}
