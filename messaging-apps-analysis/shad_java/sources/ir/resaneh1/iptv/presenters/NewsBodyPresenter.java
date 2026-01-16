package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.NewsObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class NewsBodyPresenter extends AbstractPresenter<NewsObject, MyViewHolder> {
    Context mContext;

    public NewsBodyPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.news_body, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, NewsObject newsObject) {
        super.onBindViewHolder((NewsBodyPresenter) myViewHolder, (MyViewHolder) newsObject);
        String str = ((NewsObject) myViewHolder.item).title;
        String str2 = BuildConfig.FLAVOR;
        if (str != null) {
            str2 = BuildConfig.FLAVOR + newsObject.title;
        }
        myViewHolder.titleTextView.setText(str2);
        Titem titem = myViewHolder.item;
        if (((NewsObject) titem).body != null) {
            String strReplace = ((NewsObject) titem).body.replace("<br /><br />", "<br />").replace("<br /><br />", "<br />").replace("<br /><br />", "<br />");
            myViewHolder.bodyTextView.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 24) {
                myViewHolder.bodyTextView.setText(Html.fromHtml(strReplace, 63));
            } else {
                myViewHolder.bodyTextView.setText(Html.fromHtml(strReplace));
                myViewHolder.bodyTextView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            myViewHolder.bodyTextView.setLinksClickable(true);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<NewsObject> {
        public TextView bodyTextView;
        public TextView titleTextView;

        public MyViewHolder(NewsBodyPresenter newsBodyPresenter, View view) {
            super(view);
            this.titleTextView = (TextView) view.findViewById(R.id.textViewTitle);
            this.bodyTextView = (TextView) view.findViewById(R.id.textViewBody);
        }
    }
}
