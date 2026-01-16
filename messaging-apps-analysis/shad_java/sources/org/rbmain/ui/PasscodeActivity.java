package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.common.Utf8Charset;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.support.fingerprint.FingerprintManagerCompat;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberPicker;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class PasscodeActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int autoLockDetailRow;
    private int autoLockRow;
    private int captureDetailRow;
    private int captureRow;
    private int changePasscodeRow;
    private TextView dropDown;
    private ActionBarMenuItem dropDownContainer;
    private Drawable dropDownDrawable;
    private int fingerprintRow;
    private String firstPassword;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int passcodeDetailRow;
    private int passcodeRow;
    private EditTextBoldCursor passwordEditText;
    private int rowCount;
    private TextView titleTextView;
    private int type;
    private int currentPasswordType = 1;
    private int passcodeSetStep = 0;

    public PasscodeActivity(int i) {
        this.type = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        if (this.type != 0) {
            return true;
        }
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetPasscode);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        if (this.type == 0) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetPasscode);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        if (this.type != 3) {
            this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        }
        boolean z = false;
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.PasscodeActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) throws UnsupportedEncodingException {
                if (i == -1) {
                    PasscodeActivity.this.finishFragment();
                    return;
                }
                if (i == 1) {
                    if (PasscodeActivity.this.passcodeSetStep == 0) {
                        PasscodeActivity.this.processNext();
                        return;
                    } else {
                        if (PasscodeActivity.this.passcodeSetStep == 1) {
                            PasscodeActivity.this.processDone();
                            return;
                        }
                        return;
                    }
                }
                if (i == 2) {
                    PasscodeActivity.this.currentPasswordType = 0;
                    PasscodeActivity.this.updateDropDownTextView();
                } else if (i == 3) {
                    PasscodeActivity.this.currentPasswordType = 1;
                    PasscodeActivity.this.updateDropDownTextView();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        int i = 1;
        if (this.type != 0) {
            ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
            actionBarMenuCreateMenu.addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
            TextView textView = new TextView(context);
            this.titleTextView = textView;
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
            if (this.type == 1) {
                if (SharedConfig.passcodeHash.length() != 0) {
                    this.titleTextView.setText(LocaleController.getString("EnterNewPasscode", R.string.EnterNewPasscode));
                } else {
                    this.titleTextView.setText(LocaleController.getString("EnterNewFirstPasscode", R.string.EnterNewFirstPasscode));
                }
            } else {
                this.titleTextView.setText(LocaleController.getString("EnterCurrentPasscode", R.string.EnterCurrentPasscode));
            }
            this.titleTextView.setTextSize(1, 18.0f);
            this.titleTextView.setGravity(1);
            frameLayout2.addView(this.titleTextView, LayoutHelper.createFrame(-2, -2.0f, 1, 0.0f, 38.0f, 0.0f, 0.0f));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.passwordEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 20.0f);
            EditTextBoldCursor editTextBoldCursor2 = this.passwordEditText;
            int i2 = Theme.key_windowBackgroundWhiteBlackText;
            editTextBoldCursor2.setTextColor(Theme.getColor(i2));
            this.passwordEditText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.passwordEditText.setMaxLines(1);
            this.passwordEditText.setLines(1);
            this.passwordEditText.setGravity(1);
            this.passwordEditText.setSingleLine(true);
            if (this.type == 1) {
                this.passcodeSetStep = 0;
                this.passwordEditText.setImeOptions(5);
            } else {
                this.passcodeSetStep = 1;
                this.passwordEditText.setImeOptions(6);
            }
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.passwordEditText.setTypeface(Typeface.DEFAULT);
            this.passwordEditText.setCursorColor(Theme.getColor(i2));
            this.passwordEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.passwordEditText.setCursorWidth(1.5f);
            frameLayout2.addView(this.passwordEditText, LayoutHelper.createFrame(-1, 36.0f, 51, 40.0f, 90.0f, 40.0f, 0.0f));
            this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.PasscodeActivity$$ExternalSyntheticLambda2
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                    return this.f$0.lambda$createView$0(textView2, i3, keyEvent);
                }
            });
            this.passwordEditText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.PasscodeActivity.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) throws UnsupportedEncodingException {
                    if (PasscodeActivity.this.passwordEditText.length() == 4) {
                        if (PasscodeActivity.this.type != 2 || SharedConfig.passcodeType != 0) {
                            if (PasscodeActivity.this.type == 1 && PasscodeActivity.this.currentPasswordType == 0) {
                                if (PasscodeActivity.this.passcodeSetStep == 0) {
                                    PasscodeActivity.this.processNext();
                                    return;
                                } else {
                                    if (PasscodeActivity.this.passcodeSetStep == 1) {
                                        PasscodeActivity.this.processDone();
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        PasscodeActivity.this.processDone();
                    }
                }
            });
            this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback(this) { // from class: org.rbmain.ui.PasscodeActivity.3
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode actionMode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }
            });
            if (this.type == 1) {
                frameLayout2.setTag(Integer.valueOf(Theme.key_windowBackgroundWhite));
                ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0);
                this.dropDownContainer = actionBarMenuItem;
                actionBarMenuItem.setSubMenuOpenSide(1);
                this.dropDownContainer.addSubItem(2, LocaleController.getString("PasscodePIN", R.string.PasscodePIN));
                this.dropDownContainer.addSubItem(3, LocaleController.getString("PasscodePassword", R.string.PasscodePassword));
                this.actionBar.addView(this.dropDownContainer, LayoutHelper.createFrame(-2, -1.0f, 51, AndroidUtilities.isTablet() ? 64.0f : 56.0f, 0.0f, 40.0f, 0.0f));
                this.dropDownContainer.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PasscodeActivity$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createView$1(view);
                    }
                });
                this.dropDownContainer.setVisibility(8);
                TextView textView2 = new TextView(context);
                this.dropDown = textView2;
                textView2.setGravity(3);
                this.dropDown.setSingleLine(true);
                this.dropDown.setLines(1);
                this.dropDown.setMaxLines(1);
                this.dropDown.setEllipsize(TextUtils.TruncateAt.END);
                TextView textView3 = this.dropDown;
                int i3 = Theme.key_actionBarDefaultTitle;
                textView3.setTextColor(Theme.getColor(i3));
                this.dropDown.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                Drawable drawableMutate = context.getResources().getDrawable(R.drawable.ic_arrow_drop_down).mutate();
                this.dropDownDrawable = drawableMutate;
                drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i3), PorterDuff.Mode.MULTIPLY));
                this.dropDown.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.dropDownDrawable, (Drawable) null);
                this.dropDown.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
                this.dropDown.setPadding(0, 0, AndroidUtilities.dp(10.0f), 0);
                this.dropDownContainer.addView(this.dropDown, LayoutHelper.createFrame(-2, -2.0f, 16, 16.0f, 0.0f, 0.0f, 1.0f));
            } else {
                this.actionBar.setTitle(LocaleController.getString("Passcode", R.string.Passcode));
            }
            updateDropDownTextView();
        } else {
            this.actionBar.setTitle(LocaleController.getString("Passcode", R.string.Passcode));
            int i4 = Theme.key_windowBackgroundGray;
            frameLayout2.setTag(Integer.valueOf(i4));
            frameLayout2.setBackgroundColor(Theme.getColor(i4));
            RecyclerListView recyclerListView = new RecyclerListView(context);
            this.listView = recyclerListView;
            recyclerListView.setLayoutManager(new LinearLayoutManager(this, context, i, z) { // from class: org.rbmain.ui.PasscodeActivity.4
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean supportsPredictiveItemAnimations() {
                    return false;
                }
            });
            this.listView.setVerticalScrollBarEnabled(false);
            this.listView.setItemAnimator(null);
            this.listView.setLayoutAnimation(null);
            frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
            RecyclerListView recyclerListView2 = this.listView;
            ListAdapter listAdapter = new ListAdapter(context);
            this.listAdapter = listAdapter;
            recyclerListView2.setAdapter(listAdapter);
            this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.PasscodeActivity$$ExternalSyntheticLambda5
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i5) {
                    this.f$0.lambda$createView$4(view, i5);
                }
            });
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$0(TextView textView, int i, KeyEvent keyEvent) throws UnsupportedEncodingException {
        int i2 = this.passcodeSetStep;
        if (i2 == 0) {
            processNext();
            return true;
        }
        if (i2 != 1) {
            return false;
        }
        processDone();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(View view) {
        this.dropDownContainer.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(View view, final int i) {
        if (view.isEnabled()) {
            if (i == this.changePasscodeRow) {
                presentFragment(new PasscodeActivity(1));
                return;
            }
            if (i == this.passcodeRow) {
                TextCheckCell textCheckCell = (TextCheckCell) view;
                if (SharedConfig.passcodeHash.length() != 0) {
                    SharedConfig.passcodeHash = BuildConfig.FLAVOR;
                    SharedConfig.appLocked = false;
                    SharedConfig.saveConfig();
                    getMediaDataController().buildShortcuts();
                    int childCount = this.listView.getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            break;
                        }
                        View childAt = this.listView.getChildAt(i2);
                        if (childAt instanceof TextSettingsCell) {
                            ((TextSettingsCell) childAt).setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText7));
                            break;
                        }
                        i2++;
                    }
                    textCheckCell.setChecked(SharedConfig.passcodeHash.length() != 0);
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetPasscode, new Object[0]);
                    return;
                }
                presentFragment(new PasscodeActivity(1));
                return;
            }
            if (i == this.autoLockRow) {
                if (getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("AutoLock", R.string.AutoLock));
                final NumberPicker numberPicker = new NumberPicker(getParentActivity());
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(4);
                int i3 = SharedConfig.autoLockIn;
                if (i3 == 0) {
                    numberPicker.setValue(0);
                } else if (i3 == 60) {
                    numberPicker.setValue(1);
                } else if (i3 == 300) {
                    numberPicker.setValue(2);
                } else if (i3 == 3600) {
                    numberPicker.setValue(3);
                } else if (i3 == 18000) {
                    numberPicker.setValue(4);
                }
                numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.PasscodeActivity$$ExternalSyntheticLambda4
                    @Override // org.rbmain.ui.Components.NumberPicker.Formatter
                    public final String format(int i4) {
                        return PasscodeActivity.lambda$createView$2(i4);
                    }
                });
                builder.setView(numberPicker);
                builder.setNegativeButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PasscodeActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$createView$3(numberPicker, i, dialogInterface, i4);
                    }
                });
                showDialog(builder.create());
                return;
            }
            if (i == this.fingerprintRow) {
                SharedConfig.useFingerprint = !SharedConfig.useFingerprint;
                UserConfig.getInstance(this.currentAccount).saveConfig(false);
                ((TextCheckCell) view).setChecked(SharedConfig.useFingerprint);
            } else if (i == this.captureRow) {
                SharedConfig.allowScreenCapture = !SharedConfig.allowScreenCapture;
                UserConfig.getInstance(this.currentAccount).saveConfig(false);
                ((TextCheckCell) view).setChecked(SharedConfig.allowScreenCapture);
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetPasscode, new Object[0]);
                if (SharedConfig.allowScreenCapture) {
                    return;
                }
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("ScreenCaptureAlert", R.string.ScreenCaptureAlert));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createView$2(int i) {
        if (i == 0) {
            return LocaleController.getString("AutoLockDisabled", R.string.AutoLockDisabled);
        }
        return i == 1 ? LocaleController.formatString("AutoLockInTime", R.string.AutoLockInTime, LocaleController.formatPluralString("Minutes", 1)) : i == 2 ? LocaleController.formatString("AutoLockInTime", R.string.AutoLockInTime, LocaleController.formatPluralString("Minutes", 5)) : i == 3 ? LocaleController.formatString("AutoLockInTime", R.string.AutoLockInTime, LocaleController.formatPluralString("Hours", 1)) : i == 4 ? LocaleController.formatString("AutoLockInTime", R.string.AutoLockInTime, LocaleController.formatPluralString("Hours", 5)) : BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(NumberPicker numberPicker, int i, DialogInterface dialogInterface, int i2) {
        int value = numberPicker.getValue();
        if (value == 0) {
            SharedConfig.autoLockIn = 0;
        } else if (value == 1) {
            SharedConfig.autoLockIn = 60;
        } else if (value == 2) {
            SharedConfig.autoLockIn = 300;
        } else if (value == 3) {
            SharedConfig.autoLockIn = 3600;
        } else if (value == 4) {
            SharedConfig.autoLockIn = 18000;
        }
        this.listAdapter.notifyItemChanged(i);
        UserConfig.getInstance(this.currentAccount).saveConfig(false);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        if (this.type != 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PasscodeActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$5();
                }
            }, 200L);
        }
        fixLayoutInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$5() {
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.didSetPasscode && this.type == 0) {
            updateRows();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
    }

    private void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.passcodeRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.changePasscodeRow = i;
        this.rowCount = i2 + 1;
        this.passcodeDetailRow = i2;
        if (SharedConfig.passcodeHash.length() > 0) {
            try {
                if (Build.VERSION.SDK_INT >= 23 && FingerprintManagerCompat.from(ApplicationLoader.applicationContext).isHardwareDetected()) {
                    int i3 = this.rowCount;
                    this.rowCount = i3 + 1;
                    this.fingerprintRow = i3;
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
            int i4 = this.rowCount;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.autoLockRow = i4;
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.autoLockDetailRow = i5;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.captureRow = i6;
            this.rowCount = i7 + 1;
            this.captureDetailRow = i7;
            return;
        }
        this.captureRow = -1;
        this.captureDetailRow = -1;
        this.fingerprintRow = -1;
        this.autoLockRow = -1;
        this.autoLockDetailRow = -1;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.PasscodeActivity.5
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    PasscodeActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    PasscodeActivity.this.fixLayoutInternal();
                    return true;
                }
            });
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (!z || this.type == 0) {
            return;
        }
        AndroidUtilities.showKeyboard(this.passwordEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDropDownTextView() {
        TextView textView = this.dropDown;
        if (textView != null) {
            int i = this.currentPasswordType;
            if (i == 0) {
                textView.setText(LocaleController.getString("PasscodePIN", R.string.PasscodePIN));
            } else if (i == 1) {
                textView.setText(LocaleController.getString("PasscodePassword", R.string.PasscodePassword));
            }
        }
        int i2 = this.type;
        if ((i2 == 1 && this.currentPasswordType == 0) || (i2 == 2 && SharedConfig.passcodeType == 0)) {
            this.passwordEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            this.passwordEditText.setInputType(3);
            this.passwordEditText.setKeyListener(DigitsKeyListener.getInstance("1234567890"));
        } else if ((i2 == 1 && this.currentPasswordType == 1) || (i2 == 2 && SharedConfig.passcodeType == 1)) {
            this.passwordEditText.setFilters(new InputFilter[0]);
            this.passwordEditText.setKeyListener(null);
            this.passwordEditText.setInputType(129);
        }
        this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNext() {
        if (this.passwordEditText.getText().length() == 0 || (this.currentPasswordType == 0 && this.passwordEditText.getText().length() != 4)) {
            onPasscodeError();
            return;
        }
        if (this.currentPasswordType == 0) {
            this.actionBar.setTitle(LocaleController.getString("PasscodePIN", R.string.PasscodePIN));
        } else {
            this.actionBar.setTitle(LocaleController.getString("PasscodePassword", R.string.PasscodePassword));
        }
        this.dropDownContainer.setVisibility(8);
        this.titleTextView.setText(LocaleController.getString("ReEnterYourPasscode", R.string.ReEnterYourPasscode));
        this.firstPassword = this.passwordEditText.getText().toString();
        this.passwordEditText.setText(BuildConfig.FLAVOR);
        this.passcodeSetStep = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() throws UnsupportedEncodingException {
        if (this.passwordEditText.getText().length() == 0) {
            onPasscodeError();
            return;
        }
        int i = this.type;
        if (i != 1) {
            if (i == 2) {
                long j = SharedConfig.passcodeRetryInMs;
                if (j > 0) {
                    double d = j;
                    Double.isNaN(d);
                    Toast.makeText(getParentActivity(), LocaleController.formatString("TooManyTries", R.string.TooManyTries, LocaleController.formatPluralString("Seconds", Math.max(1, (int) Math.ceil(d / 1000.0d)))), 0).show();
                    this.passwordEditText.setText(BuildConfig.FLAVOR);
                    onPasscodeError();
                    return;
                }
                if (!SharedConfig.checkPasscode(this.passwordEditText.getText().toString())) {
                    SharedConfig.increaseBadPasscodeTries();
                    this.passwordEditText.setText(BuildConfig.FLAVOR);
                    onPasscodeError();
                    return;
                } else {
                    SharedConfig.badPasscodeTries = 0;
                    SharedConfig.saveConfig();
                    this.passwordEditText.clearFocus();
                    AndroidUtilities.hideKeyboard(this.passwordEditText);
                    presentFragment(new PasscodeActivity(0), true);
                    return;
                }
            }
            return;
        }
        if (!this.firstPassword.equals(this.passwordEditText.getText().toString())) {
            try {
                Toast.makeText(getParentActivity(), LocaleController.getString("PasscodeDoNotMatch", R.string.PasscodeDoNotMatch), 0).show();
            } catch (Exception e) {
                FileLog.e(e);
            }
            AndroidUtilities.shakeView(this.titleTextView, 2.0f, 0);
            this.passwordEditText.setText(BuildConfig.FLAVOR);
            return;
        }
        try {
            SharedConfig.passcodeSalt = new byte[16];
            Utilities.random.nextBytes(SharedConfig.passcodeSalt);
            byte[] bytes = this.firstPassword.getBytes(Utf8Charset.NAME);
            int length = bytes.length + 32;
            byte[] bArr = new byte[length];
            System.arraycopy(SharedConfig.passcodeSalt, 0, bArr, 0, 16);
            System.arraycopy(bytes, 0, bArr, 16, bytes.length);
            System.arraycopy(SharedConfig.passcodeSalt, 0, bArr, bytes.length + 16, 16);
            SharedConfig.passcodeHash = Utilities.bytesToHex(Utilities.computeSHA256(bArr, 0, length));
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        SharedConfig.allowScreenCapture = true;
        SharedConfig.passcodeType = this.currentPasswordType;
        SharedConfig.saveConfig();
        getMediaDataController().buildShortcuts();
        finishFragment();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetPasscode, new Object[0]);
        this.passwordEditText.clearFocus();
        AndroidUtilities.hideKeyboard(this.passwordEditText);
    }

    private void onPasscodeError() {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        AndroidUtilities.shakeView(this.titleTextView, 2.0f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal() {
        if (this.dropDownContainer != null) {
            if (!AndroidUtilities.isTablet()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dropDownContainer.getLayoutParams();
                layoutParams.topMargin = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
                this.dropDownContainer.setLayoutParams(layoutParams);
            }
            if (!AndroidUtilities.isTablet() && ApplicationLoader.applicationContext.getResources().getConfiguration().orientation == 2) {
                this.dropDown.setTextSize(1, 18.0f);
            } else {
                this.dropDown.setTextSize(1, 20.0f);
            }
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Boolean hasWidgets;
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == PasscodeActivity.this.passcodeRow || adapterPosition == PasscodeActivity.this.fingerprintRow || adapterPosition == PasscodeActivity.this.autoLockRow || adapterPosition == PasscodeActivity.this.captureRow || (SharedConfig.passcodeHash.length() != 0 && adapterPosition == PasscodeActivity.this.changePasscodeRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PasscodeActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textCheckCell;
            if (i == 0) {
                textCheckCell = new TextCheckCell(this.mContext);
                textCheckCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 1) {
                textCheckCell = new TextSettingsCell(this.mContext);
                textCheckCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else {
                textCheckCell = new TextInfoPrivacyCell(this.mContext);
            }
            return new RecyclerListView.Holder(textCheckCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                if (i != PasscodeActivity.this.passcodeRow) {
                    if (i != PasscodeActivity.this.fingerprintRow) {
                        if (i == PasscodeActivity.this.captureRow) {
                            textCheckCell.setTextAndCheck(LocaleController.getString("ScreenCapture", R.string.ScreenCapture), SharedConfig.allowScreenCapture, false);
                            return;
                        }
                        return;
                    }
                    textCheckCell.setTextAndCheck(LocaleController.getString("UnlockFingerprint", R.string.UnlockFingerprint), SharedConfig.useFingerprint, true);
                    return;
                }
                textCheckCell.setTextAndCheck(LocaleController.getString("Passcode", R.string.Passcode), SharedConfig.passcodeHash.length() > 0, true);
                return;
            }
            if (itemViewType == 1) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                if (i != PasscodeActivity.this.changePasscodeRow) {
                    if (i == PasscodeActivity.this.autoLockRow) {
                        int i2 = SharedConfig.autoLockIn;
                        if (i2 == 0) {
                            string = LocaleController.formatString("AutoLockDisabled", R.string.AutoLockDisabled, new Object[0]);
                        } else {
                            string = i2 < 3600 ? LocaleController.formatString("AutoLockInTime", R.string.AutoLockInTime, LocaleController.formatPluralString("Minutes", i2 / 60)) : i2 < 86400 ? LocaleController.formatString("AutoLockInTime", R.string.AutoLockInTime, LocaleController.formatPluralString("Hours", (int) Math.ceil((i2 / 60.0f) / 60.0f))) : LocaleController.formatString("AutoLockInTime", R.string.AutoLockInTime, LocaleController.formatPluralString("Days", (int) Math.ceil(((i2 / 60.0f) / 60.0f) / 24.0f)));
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("AutoLock", R.string.AutoLock), string, true);
                        int i3 = Theme.key_windowBackgroundWhiteBlackText;
                        textSettingsCell.setTag(Integer.valueOf(i3));
                        textSettingsCell.setTextColor(Theme.getColor(i3));
                        return;
                    }
                    return;
                }
                textSettingsCell.setText(LocaleController.getString("ChangePasscode", R.string.ChangePasscode), false);
                if (SharedConfig.passcodeHash.length() == 0) {
                    int i4 = Theme.key_windowBackgroundWhiteGrayText7;
                    textSettingsCell.setTag(Integer.valueOf(i4));
                    textSettingsCell.setTextColor(Theme.getColor(i4));
                    return;
                } else {
                    int i5 = Theme.key_windowBackgroundWhiteBlackText;
                    textSettingsCell.setTag(Integer.valueOf(i5));
                    textSettingsCell.setTextColor(Theme.getColor(i5));
                    return;
                }
            }
            if (itemViewType != 2) {
                return;
            }
            TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
            if (i != PasscodeActivity.this.passcodeDetailRow) {
                if (i != PasscodeActivity.this.autoLockDetailRow) {
                    if (i == PasscodeActivity.this.captureDetailRow) {
                        textInfoPrivacyCell.setText(LocaleController.getString("ScreenCaptureInfo", R.string.ScreenCaptureInfo));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                        return;
                    }
                    return;
                }
                textInfoPrivacyCell.setText(LocaleController.getString("AutoLockInfo", R.string.AutoLockInfo));
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(LocaleController.getString("ChangePasscodeInfo", R.string.ChangePasscodeInfo));
            if (this.hasWidgets == null) {
                this.hasWidgets = Boolean.valueOf(!this.mContext.getSharedPreferences("shortcut_widget", 0).getAll().isEmpty());
            }
            if (this.hasWidgets.booleanValue()) {
                spannableStringBuilder.append((CharSequence) "\n\n").append((CharSequence) AndroidUtilities.replaceTags(LocaleController.getString("WidgetPasscodeEnable2", R.string.WidgetPasscodeEnable2)));
            }
            textInfoPrivacyCell.setText(spannableStringBuilder);
            if (PasscodeActivity.this.autoLockDetailRow != -1) {
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
            } else {
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == PasscodeActivity.this.passcodeRow || i == PasscodeActivity.this.fingerprintRow || i == PasscodeActivity.this.captureRow) {
                return 0;
            }
            if (i == PasscodeActivity.this.changePasscodeRow || i == PasscodeActivity.this.autoLockRow) {
                return 1;
            }
            return (i == PasscodeActivity.this.passcodeDetailRow || i == PasscodeActivity.this.autoLockDetailRow || i == PasscodeActivity.this.captureDetailRow) ? 2 : 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextCheckCell.class, TextSettingsCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_BACKGROUND;
        int i3 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        ActionBar actionBar2 = this.actionBar;
        int i4 = ThemeDescription.FLAG_AB_TITLECOLOR;
        int i5 = Theme.key_actionBarDefaultTitle;
        arrayList.add(new ThemeDescription(actionBar2, i4, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, Theme.key_actionBarDefaultSubmenuBackground));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, Theme.key_actionBarDefaultSubmenuItem));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, Theme.key_actionBarDefaultSubmenuItemIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText6));
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        int i6 = ThemeDescription.FLAG_TEXTCOLOR;
        int i7 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(editTextBoldCursor, i6, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputField));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
        arrayList.add(new ThemeDescription(this.dropDown, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.dropDown, 0, null, null, new Drawable[]{this.dropDownDrawable}, null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        return arrayList;
    }
}
