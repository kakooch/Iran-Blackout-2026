package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class JJTableTitleRowPresenter extends AbstractPresenter<TitleObject, MyViewHolder> {
    public boolean hasFields;
    Context mContext;

    public JJTableTitleRowPresenter(Context context) {
        super(context);
        this.hasFields = true;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(this, LayoutInflater.from(this.mContext).inflate(this.hasFields ? R.layout.jj_table_title_row : R.layout.jj_table_title_row_2, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, TitleObject titleObject) {
        super.onBindViewHolder((JJTableTitleRowPresenter) myViewHolder, (MyViewHolder) titleObject);
        myViewHolder.textViewName.setText(titleObject.title);
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TitleObject> {
        TextView textViewName;

        public MyViewHolder(JJTableTitleRowPresenter jJTableTitleRowPresenter, View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.textViewName);
        }
    }
}
