package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.OperatorObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class OperatorCellPresenter extends AbstractPresenter<OperatorObject, ViewHolder> {
    public int height;
    public int width;

    public OperatorCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_operator, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, OperatorObject operatorObject) {
        super.onBindViewHolder((OperatorCellPresenter) viewHolder, (ViewHolder) operatorObject);
        viewHolder.textView1.setText(operatorObject.name);
        if (this.width > 0 && this.height > 0) {
            viewHolder.imageView.getLayoutParams().width = this.width;
            viewHolder.imageView.getLayoutParams().height = this.height;
        }
        GlideHelper.loadRoundedCorner(this.context, viewHolder.imageView, operatorObject.pic_url, 10, R.drawable.shape_white_background);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<OperatorObject> {
        ImageView imageView;
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
