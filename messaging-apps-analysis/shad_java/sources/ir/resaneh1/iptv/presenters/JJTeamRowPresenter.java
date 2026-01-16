package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.JJTeamObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class JJTeamRowPresenter extends AbstractPresenter<JJTeamObject, MyViewHolder> {
    Context mContext;

    public JJTeamRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.jj_team_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, JJTeamObject jJTeamObject) {
        super.onBindViewHolder((JJTeamRowPresenter) myViewHolder, (MyViewHolder) jJTeamObject);
        if (jJTeamObject != null) {
            myViewHolder.textViewName.setText(jJTeamObject.getName());
            GlideHelper.loadFitCenter(this.mContext, myViewHolder.imageView, jJTeamObject.flag, R.color.transparent);
        } else {
            myViewHolder.textViewName.setText(BuildConfig.FLAVOR);
            GlideHelper.loadResource(this.mContext, myViewHolder.imageView, R.color.transparent);
        }
        if (jJTeamObject.presenterIsSelected) {
            myViewHolder.itemView.setBackgroundColor(this.mContext.getResources().getColor(R.color.green_200));
        } else {
            myViewHolder.itemView.setBackgroundColor(this.mContext.getResources().getColor(R.color.transparent));
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<JJTeamObject> {
        ImageView imageView;
        TextView textViewName;

        public MyViewHolder(JJTeamRowPresenter jJTeamRowPresenter, View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.textViewName);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
