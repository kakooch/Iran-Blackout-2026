package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.ShortcutObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class ShortcutPresenter extends AbstractPresenter<ShortcutObject, MyViewHolder> {
    Context mContext;
    View.OnClickListener onShortcutClick;

    public ShortcutPresenter(Context context) {
        super(context);
        this.onShortcutClick = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.ShortcutPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyViewHolder myViewHolder = (MyViewHolder) view.getTag();
                if (((ShortcutObject) myViewHolder.item).link == null || ApplicationLoader.applicationActivity == null) {
                    return;
                }
                new MainClickHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), ((ShortcutObject) myViewHolder.item).link);
            }
        };
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        MyViewHolder myViewHolder = new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.shortcut_cell, viewGroup, false));
        myViewHolder.itemView.setTag(myViewHolder);
        myViewHolder.textView.setTag(myViewHolder);
        myViewHolder.frameLayoutClickable.setTag(myViewHolder);
        myViewHolder.textView.setOnClickListener(this.onShortcutClick);
        myViewHolder.frameLayoutClickable.setOnClickListener(this.onShortcutClick);
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, ShortcutObject shortcutObject) {
        super.onBindViewHolder((ShortcutPresenter) myViewHolder, (MyViewHolder) shortcutObject);
        myViewHolder.textView.setText(shortcutObject.title);
        GlideHelper.loadCircle(this.mContext, myViewHolder.imageView, shortcutObject.icon_url, R.drawable.circle_grey);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<ShortcutObject> {
        FrameLayout frameLayoutClickable;
        ImageView imageView;
        TextView textView;

        public MyViewHolder(ShortcutPresenter shortcutPresenter, View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.textView = (TextView) view.findViewById(R.id.textView);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frameLayoutClickable);
            this.frameLayoutClickable = frameLayout;
            frameLayout.setBackground(shortcutPresenter.mContext.getResources().getDrawable(R.drawable.transparent));
            view.setBackground(shortcutPresenter.mContext.getResources().getDrawable(R.drawable.transparent));
            this.textView.setBackground(shortcutPresenter.mContext.getResources().getDrawable(R.drawable.transparent));
        }
    }
}
