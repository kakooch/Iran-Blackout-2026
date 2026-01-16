package ir.iranlms.asemnavideoplayerlibrary.player;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class SettingsDialog extends Dialog {
    private AddBookmarkDialog addBookMarkDialog;
    private final Activity mActivity;
    MyPlaybackControlView myPlaybackControlView;
    View.OnClickListener onClickListener;
    SettingListDialog settingListDialog;
    SettingListAdapter subtitleListAdapter;

    public SettingsDialog(Activity activity, MyPlaybackControlView myPlaybackControlView) {
        super(activity);
        this.onClickListener = new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.SettingsDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.textViewQuality) {
                    SettingsDialog.this.settingListDialog = new SettingListDialog(SettingsDialog.this.mActivity, SettingsDialog.this.myPlaybackControlView.getVideoQualityAdapter(), "انتخاب کیفیت");
                    SettingsDialog.this.settingListDialog.show();
                    return;
                }
                if (view.getId() == R.id.textViewSubtitle) {
                    SettingsDialog.this.settingListDialog = new SettingListDialog(SettingsDialog.this.mActivity, SettingsDialog.this.myPlaybackControlView.getVideoSubtitleAdapter(), "زیرنویس");
                    SettingsDialog.this.settingListDialog.show();
                } else if (view.getId() == R.id.textViewBookmarks) {
                    SettingsDialog.this.settingListDialog = new SettingListDialog(SettingsDialog.this.mActivity, SettingsDialog.this.myPlaybackControlView.getBookmarkAdapter(), "بوک مارک ها");
                    SettingsDialog.this.settingListDialog.show();
                } else if (view.getId() == R.id.textViewAddBookmark) {
                    SettingsDialog.this.addBookMarkDialog = new AddBookmarkDialog(SettingsDialog.this.mActivity, SettingsDialog.this.myPlaybackControlView);
                    SettingsDialog.this.addBookMarkDialog.show();
                    SettingsDialog.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.myPlaybackControlView = myPlaybackControlView;
        this.subtitleListAdapter = myPlaybackControlView.getVideoSubtitleAdapter();
        this.myPlaybackControlView.getVideoQualityAdapter();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.setting_dialog);
        findViewById(R.id.textViewQuality).setOnClickListener(this.onClickListener);
        if (this.myPlaybackControlView.getBookmarkAdapter().getItemCount() > 0) {
            findViewById(R.id.textViewBookmarks).setOnClickListener(this.onClickListener);
            findViewById(R.id.textViewBookmarks).setVisibility(0);
            findViewById(R.id.deviderBookmarks).setVisibility(0);
        }
        findViewById(R.id.textViewAddBookmark).setOnClickListener(this.onClickListener);
        findViewById(R.id.textViewAddBookmark).setVisibility(0);
        if (this.subtitleListAdapter.getItemCount() > 1) {
            findViewById(R.id.textViewSubtitle).setOnClickListener(this.onClickListener);
            findViewById(R.id.textViewSubtitle).setVisibility(0);
            findViewById(R.id.deviderSubtitle).setVisibility(0);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        SettingListDialog settingListDialog = this.settingListDialog;
        if (settingListDialog == null || !settingListDialog.isShowing()) {
            return;
        }
        this.settingListDialog.dismiss();
    }
}
