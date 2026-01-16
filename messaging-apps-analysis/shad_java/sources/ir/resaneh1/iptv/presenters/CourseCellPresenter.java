package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.CourseAbs;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class CourseCellPresenter extends AbstractPresenter<CourseAbs, ViewHolder> {
    public int height;
    public int width;

    public CourseCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_lms, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, CourseAbs courseAbs) {
        super.onBindViewHolder((CourseCellPresenter) viewHolder, (ViewHolder) courseAbs);
        viewHolder.textView1.setText(courseAbs.title);
        viewHolder.textView2.setText(courseAbs.group);
        GlideHelper.load(this.context, viewHolder.imageView, courseAbs.image_url, R.drawable.shape_white_background);
        if (this.width <= 0 || this.height <= 0) {
            return;
        }
        viewHolder.imageView.getLayoutParams().width = this.width;
        viewHolder.imageView.getLayoutParams().height = this.height;
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<CourseAbs> {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
