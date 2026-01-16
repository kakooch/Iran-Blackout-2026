package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.NewsCategoryObject;

/* loaded from: classes3.dex */
public class UICellNewsCategory {
    ImageView imageView;
    public TextView textView;

    public View createView(Activity activity, NewsCategoryObject newsCategoryObject) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.cell_news_category, (ViewGroup) null);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textView = textView;
        textView.setText(newsCategoryObject.title);
        GlideHelper.load(activity, this.imageView, newsCategoryObject.thumb_Url, R.color.grey_500);
        return viewInflate;
    }
}
