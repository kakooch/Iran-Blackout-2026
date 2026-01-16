package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.barcode.BarcodeHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.CameraScanActivity;

/* loaded from: classes3.dex */
public class EnterCodeFragment extends PresenterFragment {
    public EditText editText;
    private final BarcodeHelper.Listener listener;
    public String text;
    public TextView textView;
    public TextView textViewButton;
    public String title;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.enter_code_fragment;
    }

    public EnterCodeFragment(String str, String str2, BarcodeHelper.Listener listener) {
        this.title = str;
        this.text = str2;
        this.listener = listener;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.textView = (TextView) findViewById(R.id.textView);
        this.textViewButton = (TextView) findViewById(R.id.textViewButton);
        this.editText = (EditText) findViewById(R.id.editText);
        this.textViewButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.EnterCodeFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof CameraScanActivity) {
                        ApplicationLoader.applicationActivity.getActionBarLayout().removeFragmentFromStack(ApplicationLoader.applicationActivity.getSecondLastFragment());
                    }
                    ApplicationLoader.applicationActivity.onBackPressed();
                    EnterCodeFragment.this.listener.onDone(NumberUtils.toEnglish(((Object) EnterCodeFragment.this.editText.getText()) + BuildConfig.FLAVOR));
                }
            }
        });
        this.editText.requestFocus();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.EnterCodeFragment.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((InputMethodManager) EnterCodeFragment.this.getParentActivity().getSystemService("input_method")).showSoftInput(EnterCodeFragment.this.editText, 1);
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        setToolbar();
    }

    private void setToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, this.title);
        this.textView.setText(this.text);
    }
}
