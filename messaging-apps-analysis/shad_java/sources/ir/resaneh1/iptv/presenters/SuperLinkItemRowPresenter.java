package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class SuperLinkItemRowPresenter extends AbstractPresenter<Link.SuperLinkViewObject, MyViewHolder> {
    public SuperLinkItemRowPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.superlink_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, Link.SuperLinkViewObject superLinkViewObject) {
        super.onBindViewHolder((SuperLinkItemRowPresenter) myViewHolder, (MyViewHolder) superLinkViewObject);
        myViewHolder.textView.setText(superLinkViewObject.text);
        GlideHelper.loadRoundedCorner(this.context, myViewHolder.imageView, superLinkViewObject.image_url, R.drawable.shape_grey_background);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<Link.SuperLinkViewObject> {
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(SuperLinkItemRowPresenter superLinkItemRowPresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
