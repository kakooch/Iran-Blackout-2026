package ir.resaneh1.iptv.appUpdate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidMessenger.model.UpdateObject2;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import ir.medu.shad.R;
import java.util.Locale;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class UpdateActivity extends Activity {
    TextView bodyTextView;
    private TextView cancelButton;
    TextView contentTextView;
    private TextView submitButton;
    TextView titleTextView;
    private UpdateObject2 updateObject;

    public static Intent creatIntent(Activity activity, UpdateObject2 updateObject2) {
        Intent intent = new Intent(activity, (Class<?>) UpdateActivity.class);
        intent.putExtra("arg", ApplicationLoader.getGson().toJson(updateObject2));
        return intent;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getPackageManager();
        this.updateObject = (UpdateObject2) ApplicationLoader.getGson().fromJson(getIntent().getStringExtra("arg"), UpdateObject2.class);
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLayoutDirection(new Locale("fa"));
        }
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        setContentView(R.layout.dialog_update_app);
        findViews();
        init();
    }

    private void init() {
        this.titleTextView.setText("به روزرسانی به نسخه جدید");
        this.bodyTextView.setVisibility(8);
        if (this.updateObject.changes != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("تغییرات اخیر:\n");
            for (int i = 0; i < this.updateObject.changes.size(); i++) {
                sb.append("- " + this.updateObject.changes.get(i) + "\n");
            }
            this.contentTextView.setText(sb.toString());
            this.contentTextView.setMovementMethod(new ScrollingMovementMethod());
        }
        if (this.updateObject.force_update) {
            this.cancelButton.setVisibility(8);
        }
        this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.appUpdate.UpdateActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateActivity.this.finish();
            }
        });
        this.submitButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.appUpdate.UpdateActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateActivity.this.updateObject.store_landing != null) {
                    AccountInstance.getInstance(UserConfig.selectedAccount).getMessengerLinkHandler().onLinkClick((BaseFragment) null, UpdateActivity.this.updateObject.store_landing);
                }
            }
        });
    }

    private void findViews() {
        this.titleTextView = (TextView) findViewById(R.id.textViewTitle);
        this.contentTextView = (TextView) findViewById(R.id.textViewChanges);
        this.bodyTextView = (TextView) findViewById(R.id.textViewDescription);
        this.submitButton = (TextView) findViewById(R.id.buttonSubmit);
        this.cancelButton = (TextView) findViewById(R.id.buttonCancel);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(context));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        UpdateObject2 updateObject2 = this.updateObject;
        if (updateObject2 != null && updateObject2.force_update) {
            finishAffinity();
        } else {
            super.onBackPressed();
        }
    }
}
