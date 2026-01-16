package org.acra.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import org.acra.ACRA;
import org.acra.config.ConfigUtils;
import org.acra.config.DialogConfiguration;
import org.acra.prefs.SharedPreferencesFactory;

/* loaded from: classes.dex */
public class CrashReportDialog extends BaseCrashReportDialog implements DialogInterface.OnClickListener {
    private DialogConfiguration dialogConfiguration;
    private AlertDialog mDialog;
    private LinearLayout scrollable;
    private SharedPreferencesFactory sharedPreferencesFactory;
    private EditText userCommentView;
    private EditText userEmailView;

    @Override // org.acra.dialog.BaseCrashReportDialog
    protected void init(Bundle bundle) {
        LinearLayout linearLayout = new LinearLayout(this);
        this.scrollable = linearLayout;
        linearLayout.setOrientation(1);
        this.sharedPreferencesFactory = new SharedPreferencesFactory(getApplicationContext(), getConfig());
        DialogConfiguration dialogConfiguration = (DialogConfiguration) ConfigUtils.getPluginConfiguration(getConfig(), DialogConfiguration.class);
        this.dialogConfiguration = dialogConfiguration;
        int iResTheme = dialogConfiguration.resTheme();
        if (iResTheme != 0) {
            setTheme(iResTheme);
        }
        buildAndShowDialog(bundle);
    }

    protected void buildAndShowDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String strTitle = this.dialogConfiguration.title();
        if (strTitle != null) {
            builder.setTitle(strTitle);
        }
        int iResIcon = this.dialogConfiguration.resIcon();
        if (iResIcon != 0) {
            builder.setIcon(iResIcon);
        }
        builder.setView(buildCustomView(bundle)).setPositiveButton(this.dialogConfiguration.positiveButtonText(), this).setNegativeButton(this.dialogConfiguration.negativeButtonText(), this);
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.mDialog.show();
    }

    protected View buildCustomView(Bundle bundle) {
        ScrollView scrollView = new ScrollView(this);
        scrollView.setPadding(10, 10, 10, 10);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setFocusable(true);
        scrollView.setFocusableInTouchMode(true);
        scrollView.addView(this.scrollable);
        addViewToDialog(getMainView());
        View commentLabel = getCommentLabel();
        if (commentLabel != null) {
            commentLabel.setPadding(commentLabel.getPaddingLeft(), 10, commentLabel.getPaddingRight(), commentLabel.getPaddingBottom());
            addViewToDialog(commentLabel);
            EditText commentPrompt = getCommentPrompt(bundle != null ? bundle.getString("comment") : null);
            this.userCommentView = commentPrompt;
            addViewToDialog(commentPrompt);
        }
        View emailLabel = getEmailLabel();
        if (emailLabel != null) {
            emailLabel.setPadding(emailLabel.getPaddingLeft(), 10, emailLabel.getPaddingRight(), emailLabel.getPaddingBottom());
            addViewToDialog(emailLabel);
            EditText emailPrompt = getEmailPrompt(bundle != null ? bundle.getString("email") : null);
            this.userEmailView = emailPrompt;
            addViewToDialog(emailPrompt);
        }
        return scrollView;
    }

    protected final void addViewToDialog(View view) {
        this.scrollable.addView(view);
    }

    protected View getMainView() {
        TextView textView = new TextView(this);
        String strText = this.dialogConfiguration.text();
        if (strText != null) {
            textView.setText(strText);
        }
        return textView;
    }

    protected View getCommentLabel() {
        String strCommentPrompt = this.dialogConfiguration.commentPrompt();
        if (strCommentPrompt == null) {
            return null;
        }
        TextView textView = new TextView(this);
        textView.setText(strCommentPrompt);
        return textView;
    }

    protected EditText getCommentPrompt(CharSequence charSequence) {
        EditText editText = new EditText(this);
        editText.setLines(2);
        if (charSequence != null) {
            editText.setText(charSequence);
        }
        return editText;
    }

    protected View getEmailLabel() {
        String strEmailPrompt = this.dialogConfiguration.emailPrompt();
        if (strEmailPrompt == null) {
            return null;
        }
        TextView textView = new TextView(this);
        textView.setText(strEmailPrompt);
        return textView;
    }

    protected EditText getEmailPrompt(CharSequence charSequence) {
        EditText editText = new EditText(this);
        editText.setSingleLine();
        editText.setInputType(33);
        if (charSequence != null) {
            editText.setText(charSequence);
        } else {
            editText.setText(this.sharedPreferencesFactory.create().getString(ACRA.PREF_USER_EMAIL_ADDRESS, ""));
        }
        return editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String string;
        if (i == -1) {
            EditText editText = this.userCommentView;
            String string2 = editText != null ? editText.getText().toString() : "";
            SharedPreferences sharedPreferencesCreate = this.sharedPreferencesFactory.create();
            EditText editText2 = this.userEmailView;
            if (editText2 != null) {
                string = editText2.getText().toString();
                sharedPreferencesCreate.edit().putString(ACRA.PREF_USER_EMAIL_ADDRESS, string).apply();
            } else {
                string = sharedPreferencesCreate.getString(ACRA.PREF_USER_EMAIL_ADDRESS, "");
            }
            sendCrash(string2, string);
        } else {
            cancelReports();
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        EditText editText = this.userCommentView;
        if (editText != null && editText.getText() != null) {
            bundle.putString("comment", this.userCommentView.getText().toString());
        }
        EditText editText2 = this.userEmailView;
        if (editText2 == null || editText2.getText() == null) {
            return;
        }
        bundle.putString("email", this.userEmailView.getText().toString());
    }
}
