package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.SessionObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class SessionRowPresenter extends AbstractPresenter<SessionObject, ViewHolder> {
    public SessionRowPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_session, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, SessionObject sessionObject) {
        super.onBindViewHolder((SessionRowPresenter) viewHolder, (ViewHolder) sessionObject);
        MyLog.e("VodDetDescription", "onBindViewHolder: ");
        viewHolder.textView1.setText(NumberUtils.toPersian(sessionObject.position + BuildConfig.FLAVOR));
        String str = sessionObject.title;
        if (str != null) {
            viewHolder.textView2.setText(str);
        }
        if (sessionObject.duration != null) {
            viewHolder.textView3.setText(NumberUtils.toPersian(sessionObject.duration) + " دقیقه");
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<SessionObject> {
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.textView3 = (TextView) view.findViewById(R.id.textView3);
        }
    }
}
