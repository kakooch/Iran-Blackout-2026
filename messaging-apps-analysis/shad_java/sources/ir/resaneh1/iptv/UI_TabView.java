package ir.resaneh1.iptv;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.FlavorHelper;

/* loaded from: classes3.dex */
public class UI_TabView {
    public ImageView imageView;
    public TextView numberTextView;
    public TextView textView;
    public View view;

    public View createView(Activity activity, String str, int i, int i2) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.cell_tab, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textView = textView;
        if (textView != null) {
            textView.setText(str);
            this.textView.setTextColor(i);
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.imageView = imageView;
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.imageView.setImageResource(i2);
            if (!FlavorHelper.isShad()) {
                this.imageView.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
            }
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.textViewNumber);
        this.numberTextView = textView2;
        textView2.setVisibility(4);
        this.view = viewInflate;
        return viewInflate;
    }

    public View refreshView(View view, String str, int i, int i2) {
        TextView textView = (TextView) view.findViewById(R.id.textView);
        this.textView = textView;
        if (textView != null) {
            textView.setText(str);
            this.textView.setTextColor(i);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        this.imageView = imageView;
        if (imageView != null) {
            imageView.setImageResource(i2);
            if (!FlavorHelper.isShad()) {
                this.imageView.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
            }
        }
        TextView textView2 = (TextView) view.findViewById(R.id.textViewNumber);
        this.numberTextView = textView2;
        textView2.setVisibility(4);
        this.view = view;
        return view;
    }
}
