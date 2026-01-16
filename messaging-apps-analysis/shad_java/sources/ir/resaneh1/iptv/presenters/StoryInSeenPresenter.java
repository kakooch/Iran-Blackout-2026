package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class StoryInSeenPresenter extends AbstractPresenter<StoryObject, ViewHolder> {
    public int height;
    public int width;

    public StoryInSeenPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.context);
        ImageView imageView = new ImageView(this.context);
        frameLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        ImageView imageView2 = new ImageView(this.context);
        imageView2.setImageDrawable(this.context.getResources().getDrawable(R.drawable.rubino_eye_white_outline_44));
        linearLayout.addView(imageView2, LayoutHelper.createFrame(24, -1, 16));
        TextView textView = new TextView(this.context);
        textView.setTextSize(1, 15.0f);
        textView.setTextColor(-1);
        textView.setShadowLayer(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), -1728053248);
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebbold.ttf"));
        textView.setPadding(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
        linearLayout.addView(textView, LayoutHelper.createFrame(-2, -2, 16));
        frameLayout.addView(linearLayout, LayoutHelper.createFrame(-2, -2, 81));
        ViewHolder viewHolder = new ViewHolder(frameLayout);
        viewHolder.imageView = imageView;
        viewHolder.textViewSeenCount = textView;
        frameLayout.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, StoryObject storyObject) {
        String str;
        super.onBindViewHolder((StoryInSeenPresenter) viewHolder, (ViewHolder) storyObject);
        String str2 = storyObject.full_thumbnail_url;
        if (str2 == null && storyObject.story_type == StoryObject.StoryTypeEnum.Picture && (str = storyObject.full_file_url) != null) {
            str2 = str;
        }
        GlideHelper.load(this.context, viewHolder.imageView, str2, R.color.grey_900);
        if (this.width > 0 && this.height > 0) {
            viewHolder.imageView.getLayoutParams().width = this.width;
            viewHolder.imageView.getLayoutParams().height = this.height;
        }
        viewHolder.textViewSeenCount.setText(storyObject.getSeenCountString());
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<StoryObject> {
        ImageView imageView;
        TextView textViewSeenCount;

        public ViewHolder(View view) {
            super(view);
        }
    }
}
