package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.dialog.MatchForecastDialog;
import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJMatchObject;
import ir.resaneh1.iptv.model.JJVoteInput;
import ir.resaneh1.iptv.model.JJVoteOutput;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class JJMatchRowPresenter extends AbstractPresenter<JJMatchObject, ViewHolder> {
    View.OnClickListener onPredClicked;
    public boolean showDetail;

    public JJMatchRowPresenter(Context context) {
        super(context);
        this.showDetail = true;
        this.onPredClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.JJMatchRowPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                int i2;
                final ViewHolder viewHolder = (ViewHolder) view.getTag();
                Titem titem = viewHolder.item;
                if (((JJMatchObject) titem).pred1 < 0 || ((JJMatchObject) titem).pred2 < 0) {
                    i = 0;
                    i2 = 0;
                } else {
                    int i3 = ((JJMatchObject) titem).pred1;
                    i = ((JJMatchObject) titem).pred2;
                    i2 = i3;
                }
                final MatchForecastDialog matchForecastDialog = new MatchForecastDialog(((AbstractPresenter) JJMatchRowPresenter.this).context, i, i2, ((JJMatchObject) viewHolder.item).getGuestTeam(), ((JJMatchObject) viewHolder.item).getHostTeam());
                matchForecastDialog.button.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.JJMatchRowPresenter.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        matchForecastDialog.dismiss();
                        JJMatchRowPresenter.this.callVote(viewHolder, matchForecastDialog.numberHost.getValue(), matchForecastDialog.numberGuest.getValue());
                    }
                });
            }
        };
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.jj_match_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        viewHolder.foreCastTextView.setTag(viewHolder);
        viewHolder.resultPredView.setTag(viewHolder);
        return viewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(ir.resaneh1.iptv.presenters.JJMatchRowPresenter.ViewHolder r8, ir.resaneh1.iptv.model.JJMatchObject r9) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.presenters.JJMatchRowPresenter.onBindViewHolder(ir.resaneh1.iptv.presenters.JJMatchRowPresenter$ViewHolder, ir.resaneh1.iptv.model.JJMatchObject):void");
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<JJMatchObject> {
        View detailsButtonView;
        TextView foreCastTextView;
        TextView leftName;
        ImageView leftTeamImage;
        TextView resultGuestTextView;
        TextView resultHostTextView;
        TextView resultPredGuestTextView;
        TextView resultPredHostTextView;
        View resultPredView;
        View resultView;
        TextView rightName;
        ImageView rightTeamImage;
        TextView statusTextView;
        TextView textViewMatchId;
        TextView timeTextView;

        public ViewHolder(View view) {
            super(view);
            this.rightTeamImage = (ImageView) view.findViewById(R.id.imageViewRight);
            this.leftTeamImage = (ImageView) view.findViewById(R.id.imageViewLeft);
            this.timeTextView = (TextView) view.findViewById(R.id.textViewTime);
            this.statusTextView = (TextView) view.findViewById(R.id.textViewStatus);
            this.resultGuestTextView = (TextView) view.findViewById(R.id.textViewResultGuest);
            this.resultHostTextView = (TextView) view.findViewById(R.id.textViewResultHost);
            this.textViewMatchId = (TextView) view.findViewById(R.id.textViewMatchId);
            this.resultPredGuestTextView = (TextView) view.findViewById(R.id.textViewResultRaftGuest);
            this.resultPredHostTextView = (TextView) view.findViewById(R.id.textViewResultRaftHost);
            this.foreCastTextView = (TextView) view.findViewById(R.id.textViewForecast);
            this.rightName = (TextView) view.findViewById(R.id.textViewRightName);
            this.leftName = (TextView) view.findViewById(R.id.textViewLeftName);
            view.findViewById(R.id.rightButtonView);
            this.detailsButtonView = view.findViewById(R.id.detailsButtonView);
            this.resultView = view.findViewById(R.id.resultView);
            this.resultPredView = view.findViewById(R.id.resultRaftView);
            view.findViewById(R.id.detailsRowView);
            view.findViewById(R.id.line);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPredView(ViewHolder viewHolder, int i, int i2) {
        viewHolder.foreCastTextView.setVisibility(4);
        if (i < 0 || i2 < 0) {
            viewHolder.resultPredView.setVisibility(4);
        } else {
            viewHolder.resultPredView.setVisibility(0);
            viewHolder.resultPredGuestTextView.setText(NumberUtils.toPersian(i + BuildConfig.FLAVOR));
            viewHolder.resultPredHostTextView.setText(NumberUtils.toPersian(i2 + BuildConfig.FLAVOR));
        }
        Titem titem = viewHolder.item;
        if (((JJMatchObject) titem).status == 1 || ((JJMatchObject) titem).status == 4) {
            viewHolder.resultPredView.setOnClickListener(this.onPredClicked);
        } else {
            viewHolder.resultPredView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.JJMatchRowPresenter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ToastiLikeSnack.showL(((AbstractPresenter) JJMatchRowPresenter.this).context, "تغییر پیش بینی امکان پذیر نیست");
                }
            });
        }
    }

    void setForeCastView(ViewHolder viewHolder) {
        viewHolder.foreCastTextView.setVisibility(0);
        viewHolder.resultView.setVisibility(4);
        viewHolder.resultPredView.setVisibility(4);
        viewHolder.foreCastTextView.setOnClickListener(this.onPredClicked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callVote(final ViewHolder viewHolder, final int i, final int i2) {
        ApiRequestIPTV.getInstance(UserConfig.selectedAccount).jjVote(new JJVoteInput(((JJMatchObject) viewHolder.item).id, i + BuildConfig.FLAVOR + i2, JJAppPreferences.currentPredictLink.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.presenters.JJMatchRowPresenter.3
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                if (response.body() == null) {
                    ToastiLikeSnack.showL(((AbstractPresenter) JJMatchRowPresenter.this).context, "خطا در ثبت پیش بینی");
                    return;
                }
                JJVoteOutput jJVoteOutput = (JJVoteOutput) response.body();
                ArrayList<JJVoteOutput.JJVoteResult> arrayList = jJVoteOutput.result;
                if (arrayList == null || arrayList.size() <= 0 || (jJVoteOutput.result.get(0).status != JJVoteOutput.StatusEnum.OK && jJVoteOutput.result.get(0).status != JJVoteOutput.StatusEnum.OK_DUP)) {
                    ToastiLikeSnack.showL(((AbstractPresenter) JJMatchRowPresenter.this).context, "خطا در ثبت پیش بینی");
                    return;
                }
                JJMatchRowPresenter.this.setPredView(viewHolder, i2, i);
                ToastiLikeSnack.showL(((AbstractPresenter) JJMatchRowPresenter.this).context, "پیش بینی شما با موفقیت ثبت شد");
                JJMatchObject jJMatchObject = (JJMatchObject) viewHolder.item;
                jJMatchObject.pred1 = i;
                jJMatchObject.pred2 = i2;
                ArrayList<JJMatchObject> arrayList2 = new ArrayList<>();
                arrayList2.add(jJMatchObject);
                JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput = new JJGetMatchAndTeamListOutput();
                jJGetMatchAndTeamListOutput.result.matchUpdates = arrayList2;
                JJAppPreferences.getInstance().setOrUpdateMatchAndTeamList(jJGetMatchAndTeamListOutput);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                ToastiLikeSnack.showL(((AbstractPresenter) JJMatchRowPresenter.this).context, "خطا در ثبت پیش بینی");
            }
        });
    }

    void setResultView(ViewHolder viewHolder) {
        viewHolder.resultView.setVisibility(0);
        viewHolder.foreCastTextView.setVisibility(4);
        Titem titem = viewHolder.item;
        if (((JJMatchObject) titem).status == 2 || ((JJMatchObject) titem).status == 3) {
            viewHolder.resultGuestTextView.setText(NumberUtils.toPersian(((JJMatchObject) viewHolder.item).getGuestScor() + BuildConfig.FLAVOR));
            viewHolder.resultHostTextView.setText(NumberUtils.toPersian(((JJMatchObject) viewHolder.item).getHostScor() + BuildConfig.FLAVOR));
            return;
        }
        viewHolder.resultView.setVisibility(4);
    }

    void setStatus(ViewHolder viewHolder) {
        JJMatchObject jJMatchObject = (JJMatchObject) viewHolder.item;
        TextView textView = viewHolder.statusTextView;
        if (textView != null) {
            int i = jJMatchObject.status;
            textView.setText(i == 1 ? "شروع نشده" : i == 2 ? "در حال برگزاری" : i == 3 ? "تمام شده" : i == 4 ? "به تعویق افتاده" : BuildConfig.FLAVOR);
        }
    }

    void setTime(ViewHolder viewHolder) {
        String str;
        JJMatchObject jJMatchObject = (JJMatchObject) viewHolder.item;
        TextView textView = viewHolder.timeTextView;
        if (textView == null || (str = jJMatchObject.date) == null) {
            return;
        }
        textView.setText(NumberUtils.toPersian(str));
        if (jJMatchObject.time != null) {
            viewHolder.timeTextView.append(NumberUtils.toPersian(" " + jJMatchObject.time));
        }
    }
}
