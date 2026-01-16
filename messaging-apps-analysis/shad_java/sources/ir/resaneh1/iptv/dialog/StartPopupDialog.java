package ir.resaneh1.iptv.dialog;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidMessenger.model.StartPopupObject;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class StartPopupDialog extends PresenterDialog {
    private final StartPopupObject startPopupObject;

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    public int getLayoutId() {
        return R.layout.dialog_start_popup;
    }

    public StartPopupDialog(Activity activity, StartPopupObject startPopupObject) {
        super(activity);
        this.startPopupObject = startPopupObject;
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_100));
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        toolbarImageView.createView(ApplicationLoader.applicationActivity, R.drawable.ic_close_grey, Integer.valueOf(R.color.grey_900));
        toolbarImageView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.StartPopupDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartPopupDialog.this.dismiss();
            }
        });
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        toolbarTextView.createView(ApplicationLoader.applicationActivity, this.startPopupObject.title, R.color.grey_900);
        this.toolbarMaker.addViewToRightLayout(toolbarImageView.view);
        this.toolbarMaker.addViewToRightLayout(toolbarTextView.view);
        this.toolbarMaker.leftLayout.setLayoutTransition(new LayoutTransition());
        TextView textView = (TextView) findViewById(R.id.textViewDescription);
        String str = this.startPopupObject.text;
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText(BuildConfig.FLAVOR);
        }
        TextView textView2 = (TextView) findViewById(R.id.buttonSubmit);
        StartPopupObject startPopupObject = this.startPopupObject;
        if (startPopupObject.has_link && startPopupObject.link_text != null) {
            textView2.setVisibility(0);
            textView2.setText(this.startPopupObject.link_text);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.StartPopupDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StartPopupDialog.this.dismiss();
                    try {
                        AccountInstance.getInstance(UserConfig.selectedAccount).getMessengerLinkHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), StartPopupDialog.this.startPopupObject.link);
                    } catch (Exception unused) {
                    }
                }
            });
        } else {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) findViewById(R.id.buttonCancel);
        String str2 = this.startPopupObject.ignore_text;
        if (str2 != null) {
            textView3.setText(str2);
        } else {
            textView3.setVisibility(8);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.StartPopupDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartPopupDialog.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }
}
