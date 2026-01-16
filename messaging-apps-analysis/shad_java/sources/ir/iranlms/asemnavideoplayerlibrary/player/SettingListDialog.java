package ir.iranlms.asemnavideoplayerlibrary.player;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class SettingListDialog extends Dialog {
    SettingListAdapter adapter;
    RecyclerView recyclerViewSetting;
    String title;

    public SettingListDialog(Activity activity, SettingListAdapter settingListAdapter, String str) {
        super(activity);
        this.adapter = settingListAdapter;
        this.title = str;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.setting_list_dialog);
        this.recyclerViewSetting = (RecyclerView) findViewById(R.id.recyclerview_quality);
        ((TextView) findViewById(R.id.textViewTitle)).setText(this.title);
        this.recyclerViewSetting.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.recyclerViewSetting.setAdapter(this.adapter);
    }
}
