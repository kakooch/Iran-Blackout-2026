package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class EndpointTitlePresenter extends AbstractPresenter<TitleObject, MyViewHolder> {
    Context mContext;

    public EndpointTitlePresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.endpoint_title, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, TitleObject titleObject) {
        super.onBindViewHolder((EndpointTitlePresenter) myViewHolder, (MyViewHolder) titleObject);
        String str = titleObject.title;
        if (str != null) {
            myViewHolder.textView.setText(str);
        } else {
            myViewHolder.textView.setText(BuildConfig.FLAVOR);
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TitleObject> {
        public TextView textView;

        public MyViewHolder(EndpointTitlePresenter endpointTitlePresenter, View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
