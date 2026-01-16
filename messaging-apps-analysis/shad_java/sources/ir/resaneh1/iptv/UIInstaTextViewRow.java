package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIInstaTextViewRow {
    public TextView textViewDescription;
    public TextView titleTextView;
    public View view;
    public View viewMore;

    public View createView(Activity activity, String str, boolean z, View.OnClickListener onClickListener) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.insta_textview_row, (ViewGroup) null);
        this.titleTextView = (TextView) viewInflate.findViewById(R.id.textViewTitle);
        this.viewMore = viewInflate.findViewById(R.id.imageViewMore);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textViewDescription);
        this.textViewDescription = textView;
        textView.setVisibility(8);
        this.titleTextView.setText(str);
        if (z) {
            this.viewMore.setVisibility(0);
            if (onClickListener != null) {
                this.viewMore.setOnClickListener(onClickListener);
            }
        } else {
            this.viewMore.setVisibility(8);
        }
        this.view = viewInflate;
        return viewInflate;
    }
}
