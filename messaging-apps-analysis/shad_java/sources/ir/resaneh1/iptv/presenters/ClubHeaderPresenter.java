package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.ClubHeaderItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class ClubHeaderPresenter extends AbstractPresenter<ClubHeaderItem, MyViewHolder> {
    public ClubHeaderPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.club_header, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, ClubHeaderItem clubHeaderItem) {
        super.onBindViewHolder((ClubHeaderPresenter) myViewHolder, (MyViewHolder) clubHeaderItem);
        myViewHolder.scoreTextView.setText("امتیاز\n" + clubHeaderItem.score);
        myViewHolder.rankTextView.setText("رتبه\n" + clubHeaderItem.rank);
    }

    public static class MyViewHolder extends AbstractPresenter.AbstractViewHolder<ClubHeaderItem> {
        public TextView rankTextView;
        public TextView scoreTextView;

        public MyViewHolder(View view) {
            super(view);
            this.rankTextView = (TextView) view.findViewById(R.id.textViewUserRank);
            this.scoreTextView = (TextView) view.findViewById(R.id.textViewUserScore);
        }
    }
}
