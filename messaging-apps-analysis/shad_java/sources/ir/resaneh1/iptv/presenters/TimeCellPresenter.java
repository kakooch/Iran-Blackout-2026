package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.TimeObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class TimeCellPresenter extends AbstractPresenter<TimeObject, ViewHolder> {
    public TimeCellPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_time, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, TimeObject timeObject) {
        super.onBindViewHolder((TimeCellPresenter) viewHolder, (ViewHolder) timeObject);
        if (((TimeObject) viewHolder.item).presenterIsSelected) {
            viewHolder.textView1.setBackgroundResource(R.drawable.time_selected);
        } else {
            viewHolder.textView1.setBackgroundResource(R.drawable.time_unselected);
        }
        if (timeObject.isToday) {
            viewHolder.textView1.setText("   امروز   ");
            return;
        }
        String jalaiWeekDay = getJalaiWeekDay(timeObject.day_of_week);
        String[] strArrSplit = timeObject.fa_date.split("/");
        TextView textView = viewHolder.textView1;
        StringBuilder sb = new StringBuilder();
        sb.append(jalaiWeekDay);
        sb.append(" ");
        sb.append(NumberUtils.toPersian(strArrSplit[1] + "/" + strArrSplit[2]));
        textView.setText(sb.toString());
    }

    public static String getJalaiWeekDay(String str) {
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "saturday":
                return "شنبه";
            case "friday":
                return "جمعه";
            case "monday":
                return "دوشنبه";
            case "tuesday":
                return "سه شنبه";
            case "sunday":
                return "یک شنبه";
            case "wednesday":
                return "چهارشنبه";
            case "thursday":
                return "پنج شنبه";
            default:
                return BuildConfig.FLAVOR;
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<TimeObject> {
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
        }
    }
}
