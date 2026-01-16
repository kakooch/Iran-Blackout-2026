package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.RubinoAddMediaItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class RubinoAddMediaPresenter extends AbstractPresenter<RubinoAddMediaItem, MyViewHolder> {
    public int height;
    Context mContext;
    public int width;

    public RubinoAddMediaPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.rubino_add_media_cell, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(this, viewInflate);
        viewInflate.setTag(myViewHolder);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, RubinoAddMediaItem rubinoAddMediaItem) {
        super.onBindViewHolder((RubinoAddMediaPresenter) myViewHolder, (MyViewHolder) rubinoAddMediaItem);
        if (this.width <= 0 || this.height <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.width, this.height);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, AndroidUtilities.dp(8.0f), 0);
        myViewHolder.imageView.setLayoutParams(layoutParams);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<RubinoAddMediaItem> {
        public ImageView imageView;

        public MyViewHolder(RubinoAddMediaPresenter rubinoAddMediaPresenter, View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
