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
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.JJTableRowObject;
import ir.resaneh1.iptv.model.JJTeamObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class JJTableRowPresenter extends AbstractPresenter<JJTableRowObject, MyViewHolder> {
    Context mContext;

    public JJTableRowPresenter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(R.layout.jj_table_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, JJTableRowObject jJTableRowObject) {
        super.onBindViewHolder((JJTableRowPresenter) myViewHolder, (MyViewHolder) jJTableRowObject);
        myViewHolder.textView1.setText(NumberUtils.toPersian(jJTableRowObject.points + BuildConfig.FLAVOR));
        myViewHolder.textView2.setText(NumberUtils.toPersian((jJTableRowObject.goalsFor - jJTableRowObject.goalsAgainst) + BuildConfig.FLAVOR));
        myViewHolder.textView3.setText(NumberUtils.toPersian(jJTableRowObject.losts + BuildConfig.FLAVOR));
        myViewHolder.textView4.setText(NumberUtils.toPersian(jJTableRowObject.draws + BuildConfig.FLAVOR));
        myViewHolder.textView5.setText(NumberUtils.toPersian(jJTableRowObject.wins + BuildConfig.FLAVOR));
        myViewHolder.textView6.setText(NumberUtils.toPersian(jJTableRowObject.played + BuildConfig.FLAVOR));
        JJTeamObject team = jJTableRowObject.getTeam();
        if (team != null) {
            myViewHolder.textViewName.setText(team.getName());
            GlideHelper.loadFitCenter(this.mContext, myViewHolder.imageView, team.flag, R.drawable.transparent);
        } else {
            myViewHolder.textViewName.setText(BuildConfig.FLAVOR);
            GlideHelper.loadResource(this.mContext, myViewHolder.imageView, R.color.transparent);
        }
        myViewHolder.textViewNumber.setText(NumberUtils.toPersian(jJTableRowObject.number));
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<JJTableRowObject> {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textViewName;
        TextView textViewNumber;

        public MyViewHolder(JJTableRowPresenter jJTableRowPresenter, View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.textViewName);
            this.textViewNumber = (TextView) view.findViewById(R.id.textViewNumber);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.textView3 = (TextView) view.findViewById(R.id.textView3);
            this.textView4 = (TextView) view.findViewById(R.id.textView4);
            this.textView5 = (TextView) view.findViewById(R.id.textView5);
            this.textView6 = (TextView) view.findViewById(R.id.textView6);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
