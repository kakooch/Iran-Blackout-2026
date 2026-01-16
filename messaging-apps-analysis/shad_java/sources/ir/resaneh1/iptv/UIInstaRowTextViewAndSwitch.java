package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIInstaRowTextViewAndSwitch {
    public boolean isSwitchChange;
    public View line;
    public Switch mySwitch;
    public TextView textView;
    public TextView textViewDescription;
    public View view;

    public View createView(Activity activity, String str, boolean z, boolean z2, boolean z3) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.insta_row_text_view_and_switch, (ViewGroup) null);
        this.view = viewInflate;
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.mySwitch = (Switch) this.view.findViewById(R.id.switchView);
        this.line = this.view.findViewById(R.id.viewLineHorizontal);
        TextView textView = (TextView) this.view.findViewById(R.id.textViewDescription);
        this.textViewDescription = textView;
        textView.setVisibility(8);
        TextView textView2 = this.textView;
        if (textView2 != null) {
            textView2.setText(str);
        }
        Switch r3 = this.mySwitch;
        if (r3 != null) {
            if (z) {
                r3.setVisibility(0);
                this.mySwitch.setChecked(z2);
            } else {
                r3.setVisibility(8);
            }
        }
        View view = this.line;
        if (view != null) {
            if (z3) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
        }
        this.mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.resaneh1.iptv.UIInstaRowTextViewAndSwitch.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                UIInstaRowTextViewAndSwitch.this.isSwitchChange = true;
            }
        });
        return this.view;
    }
}
