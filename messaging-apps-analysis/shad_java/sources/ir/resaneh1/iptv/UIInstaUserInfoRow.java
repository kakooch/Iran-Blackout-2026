package ir.resaneh1.iptv;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIInstaUserInfoRow {
    public EditText editText;
    public View horizontalLine;
    public boolean isDelete;
    public String text;
    public TextView textView;
    public TextView textViewDescription;
    public TextView titleTextView;
    public View verticalLine;
    public View view;
    public View viewMore;
    public boolean hasVerticalLine = false;
    public boolean hasHorizontalLine = false;
    public boolean isEditable = true;
    public boolean isChanged = false;
    public String current = BuildConfig.FLAVOR;

    public View createView(Activity activity, String str, final String str2, boolean z, View.OnClickListener onClickListener) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.insta_profile_row, (ViewGroup) null);
        this.titleTextView = (TextView) viewInflate.findViewById(R.id.textViewTitle);
        this.editText = (EditText) viewInflate.findViewById(R.id.editText);
        this.viewMore = viewInflate.findViewById(R.id.imageViewMore);
        this.verticalLine = viewInflate.findViewById(R.id.viewLineVertical);
        this.horizontalLine = viewInflate.findViewById(R.id.viewLineHorizontal);
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textViewDescription);
        this.textViewDescription = textView;
        textView.setVisibility(8);
        this.titleTextView.setText(str);
        if (str2 != null) {
            this.editText.setText(str2);
        }
        if (z) {
            this.viewMore.setVisibility(0);
            if (onClickListener != null) {
                this.viewMore.setOnClickListener(onClickListener);
            }
        } else {
            this.viewMore.setVisibility(8);
        }
        if (this.hasHorizontalLine) {
            this.horizontalLine.setVisibility(0);
        } else {
            this.horizontalLine.setVisibility(4);
        }
        if (this.hasVerticalLine) {
            this.verticalLine.setVisibility(0);
        } else {
            this.verticalLine.setVisibility(4);
        }
        this.editText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.UIInstaUserInfoRow.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UIInstaUserInfoRow uIInstaUserInfoRow = UIInstaUserInfoRow.this;
                uIInstaUserInfoRow.text = uIInstaUserInfoRow.editText.getText().toString();
                String str3 = str2;
                if (str3 != null && !str3.equals(UIInstaUserInfoRow.this.text)) {
                    UIInstaUserInfoRow.this.isChanged = true;
                }
                if (str2 != null || UIInstaUserInfoRow.this.text.length() <= 0) {
                    return;
                }
                UIInstaUserInfoRow.this.isChanged = true;
            }
        });
        if (this.isEditable) {
            this.editText.setInputType(1);
        } else {
            this.editText.setInputType(0);
            this.editText.setEnabled(false);
        }
        this.view = viewInflate;
        return viewInflate;
    }
}
