package ir.resaneh1.iptv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.SectionObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class CourseSectionPresenter extends AbstractPresenter<SectionObject, ViewHolder> {
    public CourseSectionPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.row_course_section, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, SectionObject sectionObject) {
        super.onBindViewHolder((CourseSectionPresenter) viewHolder, (ViewHolder) sectionObject);
        viewHolder.textView.setText(sectionObject.section_title);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<SectionObject> {
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
