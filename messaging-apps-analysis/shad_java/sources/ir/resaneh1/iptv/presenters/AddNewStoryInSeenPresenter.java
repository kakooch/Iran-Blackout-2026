package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.LoadMoreItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddNewStoryInSeenPresenter extends AbstractPresenter<LoadMoreItem, ViewHolder> {
    public int height;
    public int width;

    public AddNewStoryInSeenPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setBackgroundColor(this.context.getResources().getColor(R.color.grey_900));
        ImageView imageView = new ImageView(this.context);
        imageView.setImageDrawable(this.context.getResources().getDrawable(R.drawable.rubino_camera_white_outline));
        frameLayout.addView(imageView, LayoutHelper.createFrame(64, 64, 17));
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(this.width, this.height));
        ViewHolder viewHolder = new ViewHolder(frameLayout);
        frameLayout.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, LoadMoreItem loadMoreItem) {
        super.onBindViewHolder((AddNewStoryInSeenPresenter) viewHolder, (ViewHolder) loadMoreItem);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<LoadMoreItem> {
        public ViewHolder(View view) {
            super(view);
        }
    }
}
