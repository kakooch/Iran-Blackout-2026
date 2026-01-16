package ir.appp.messenger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.utilites.AppFavorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.model.ChildLockSettingObject;
import ir.resaneh1.iptv.model.FragmentType;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.EditTextSettingsCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class ChildLockActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int abortPasswordRow;
    private AnimatorSet animatorSet;
    private int aodLockRow;
    private TextView bottomButton;
    private TextView bottomTextView;
    private int changePasswordRow;
    private int changeRecoveryEmailRow;
    private int channelRow;
    private int chatRow;
    private EditTextSettingsCell codeFieldCell;
    private ChildLockSettingObject currentChildLockSetting;
    private String currentPassword;
    private byte[] currentSecret;
    private long currentSecretId;
    private TwoStepVerificationActivityDelegate delegate;
    private boolean destroyed;
    private ActionBarMenuItem doneItem;
    private String email;
    private boolean emailOnly;
    private EmptyTextProgressView emptyView;
    private String firstPassword;
    private int groupRow;
    private String hint;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean loading;
    private int messengerHeaderRow;
    private int messengerLockRow;
    private int passwordCodeFieldRow;
    private EditTextBoldCursor passwordEditText;
    private int passwordEnabledDetailRow;
    private int passwordSetState;
    private int passwordSetupDetailRow;
    private int payLockRow;
    private AlertDialog progressDialog;
    private ContextProgressView progressView;
    private int resendCodeRow;
    private int rowCount;
    private int rubinoHeaderRow;
    private int rubinoLockRow;
    private ScrollView scrollView;
    private int serviceHeaderRow;
    private int setPasswordDetailRow;
    private int setPasswordRow;
    private int setRecoveryEmailRow;
    private int shadowRow;
    private Runnable shortPollRunnable;
    private TextView titleTextView;
    private int turnPasswordOffRow;
    private int type;
    private int vodLockRow;
    private boolean waitingForEmail;
    private int emailCodeLength = 6;
    private int passwordLength = 4;
    private boolean passwordEntered = true;
    private byte[] currentPasswordHash = new byte[0];

    public interface TwoStepVerificationActivityDelegate {
    }

    private void callResendCodeRecoveryEmail() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$1(View view) {
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.didSetChildLockPassword) {
            if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                this.currentPassword = (String) objArr[0];
            }
            loadPasswordInfo(false);
            updateRows();
        }
    }

    public ChildLockActivity(int i) {
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "ChildLockActivity";
        this.type = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        if (this.type != 0) {
            return true;
        }
        getNotificationCenter().addObserver(this, NotificationCenter.didSetChildLockPassword);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        if (this.type == 0) {
            getNotificationCenter().removeObserver(this, NotificationCenter.didSetChildLockPassword);
            Runnable runnable = this.shortPollRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.shortPollRunnable = null;
            }
            this.destroyed = true;
        }
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.progressDialog = null;
        }
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.messenger.ChildLockActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ChildLockActivity.this.finishFragment();
                } else if (i == 1) {
                    ChildLockActivity.this.processDone();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        int i = Theme.key_windowBackgroundWhite;
        frameLayout2.setBackgroundColor(Theme.getColor(i));
        this.doneItem = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.progressView = contextProgressView;
        contextProgressView.setAlpha(0.0f);
        this.progressView.setScaleX(0.1f);
        this.progressView.setScaleY(0.1f);
        this.progressView.setVisibility(4);
        this.doneItem.addView(this.progressView, LayoutHelper.createFrame(-1, -1.0f));
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        scrollView.setFillViewport(true);
        frameLayout2.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.scrollView.addView(linearLayout, LayoutHelper.createScroll(-1, -2, 51));
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        int i2 = Theme.key_windowBackgroundWhiteGrayText6;
        textView.setTextColor(Theme.getColor(i2));
        this.titleTextView.setTextSize(1, 18.0f);
        this.titleTextView.setGravity(1);
        this.titleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        linearLayout.addView(this.titleTextView, LayoutHelper.createLinear(-2, -2, 1, 0, 38, 0, 0));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.passwordEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 20.0f);
        EditTextBoldCursor editTextBoldCursor2 = this.passwordEditText;
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        editTextBoldCursor2.setTextColor(Theme.getColor(i3));
        this.passwordEditText.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
        this.passwordEditText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.passwordEditText.setMaxLines(1);
        this.passwordEditText.setLines(1);
        this.passwordEditText.setGravity(1);
        this.passwordEditText.setSingleLine(true);
        this.passwordEditText.setInputType(129);
        this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.passwordEditText.setTypeface(Typeface.DEFAULT);
        this.passwordEditText.setCursorColor(Theme.getColor(i3));
        this.passwordEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.passwordEditText.setCursorWidth(1.5f);
        this.passwordEditText.setInputType(2);
        this.passwordEditText.addTextChangedListener(new TextWatcher() { // from class: ir.appp.messenger.ChildLockActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ChildLockActivity.this.passwordLength == 0 || editable.length() != ChildLockActivity.this.passwordLength) {
                    return;
                }
                ChildLockActivity.this.processDone();
            }
        });
        linearLayout.addView(this.passwordEditText, LayoutHelper.createLinear(-1, 36, 51, 40, 32, 40, 0));
        this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i4, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$0(textView2, i4, keyEvent);
            }
        });
        this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback(this) { // from class: ir.appp.messenger.ChildLockActivity.3
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
        TextView textView2 = new TextView(context);
        this.bottomTextView = textView2;
        textView2.setTextColor(Theme.getColor(i2));
        this.bottomTextView.setTextSize(1, 14.0f);
        this.bottomTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        this.bottomTextView.setText(LocaleController.getString("YourEmailInfo", R.string.YourEmailInfo));
        linearLayout.addView(this.bottomTextView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 40, 30, 40, 0));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setGravity(80);
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -1));
        TextView textView3 = new TextView(context);
        this.bottomButton = textView3;
        textView3.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4));
        this.bottomButton.setTextSize(1, 14.0f);
        this.bottomButton.setGravity((LocaleController.isRTL ? 5 : 3) | 80);
        this.bottomButton.setText(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip));
        this.bottomButton.setPadding(0, AndroidUtilities.dp(10.0f), 0, 0);
        linearLayout2.addView(this.bottomButton, LayoutHelper.createLinear(-1, -2, (LocaleController.isRTL ? 5 : 3) | 80, 40, 0, 40, 14));
        this.bottomButton.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChildLockActivity.lambda$createView$1(view);
            }
        });
        int i4 = this.type;
        if (i4 == 0) {
            EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
            this.emptyView = emptyTextProgressView;
            emptyTextProgressView.showProgress();
            frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
            RecyclerListView recyclerListView = new RecyclerListView(context);
            this.listView = recyclerListView;
            recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
            this.listView.setEmptyView(this.emptyView);
            this.listView.setVerticalScrollBarEnabled(false);
            frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
            RecyclerListView recyclerListView2 = this.listView;
            ListAdapter listAdapter = new ListAdapter(context);
            this.listAdapter = listAdapter;
            recyclerListView2.setAdapter(listAdapter);
            this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda7
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i5) {
                    this.f$0.lambda$createView$3(view, i5);
                }
            });
            EditTextSettingsCell editTextSettingsCell = new EditTextSettingsCell(context);
            this.codeFieldCell = editTextSettingsCell;
            editTextSettingsCell.setTextAndHint(BuildConfig.FLAVOR, LocaleController.getString("PasswordCode", R.string.PasswordCode), false);
            this.codeFieldCell.setBackgroundColor(Theme.getColor(i));
            EditTextBoldCursor textView4 = this.codeFieldCell.getTextView();
            textView4.setInputType(3);
            textView4.setImeOptions(6);
            textView4.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda2
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView5, int i5, KeyEvent keyEvent) {
                    return this.f$0.lambda$createView$4(textView5, i5, keyEvent);
                }
            });
            textView4.addTextChangedListener(new TextWatcher() { // from class: ir.appp.messenger.ChildLockActivity.4
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (ChildLockActivity.this.emailCodeLength == 0 || editable.length() != ChildLockActivity.this.emailCodeLength) {
                        return;
                    }
                    ChildLockActivity.this.processDone();
                }
            });
            updateRows();
            this.actionBar.setTitle(LocaleController.getString(R.string.ChildLockTitle));
            if (this.delegate != null) {
                this.titleTextView.setText(LocaleController.getString("PleaseEnterCurrentPasswordTransfer", R.string.PleaseEnterCurrentPasswordTransfer));
            } else {
                this.titleTextView.setText(LocaleController.getString("PleaseEnterCurrentPassword", R.string.PleaseEnterCurrentPassword));
            }
        } else if (i4 == 1) {
            setPasswordSetState(this.passwordSetState);
        }
        if (this.passwordEntered && this.type != 1) {
            View view = this.fragmentView;
            int i5 = Theme.key_windowBackgroundGray;
            view.setBackgroundColor(Theme.getColor(i5));
            this.fragmentView.setTag(Integer.valueOf(i5));
        } else {
            this.fragmentView.setBackgroundColor(Theme.getColor(i));
            this.fragmentView.setTag(Integer.valueOf(i));
        }
        if (this.type == 0) {
            loadPasswordInfo(false);
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$0(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 && i != 6) {
            return false;
        }
        processDone();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view, final int i) {
        String string;
        int i2;
        int i3 = 0;
        if (i == this.messengerLockRow || i == this.rubinoLockRow || i == this.payLockRow || i == this.vodLockRow || i == this.aodLockRow) {
            if (view instanceof TextCheckCell) {
                this.currentChildLockSetting = AppPreferences.getInstance(0).getChildLockSettingObject();
                TextCheckCell textCheckCell = (TextCheckCell) view;
                boolean z = !textCheckCell.isChecked();
                textCheckCell.setChecked(z);
                if (i == this.messengerLockRow) {
                    this.currentChildLockSetting.messengerSettingObject.isMessengerLock = z;
                } else if (i == this.rubinoLockRow) {
                    this.currentChildLockSetting.rubinoSettingObject.isRubinoLock = z;
                } else if (i == this.payLockRow) {
                    this.currentChildLockSetting.servicesSettingObject.isPayLock = z;
                } else if (i == this.vodLockRow) {
                    this.currentChildLockSetting.servicesSettingObject.isVodLock = z;
                } else if (i == this.aodLockRow) {
                    this.currentChildLockSetting.servicesSettingObject.isAodLock = z;
                }
                AppPreferences.getInstance(0).setChildLockSettingObject(this.currentChildLockSetting);
                if (i == this.messengerLockRow) {
                    updateMessengerRows(z);
                    return;
                }
                return;
            }
            return;
        }
        if (!this.currentChildLockSetting.messengerSettingObject.isMessengerLock && (i == (i2 = this.groupRow) || i == this.channelRow || i == this.chatRow)) {
            if (i != this.chatRow) {
                if (i == i2) {
                    i3 = 1;
                } else if (i == this.channelRow) {
                    i3 = 2;
                }
            }
            presentFragment(new ChildLockSecondActivity(i3));
            return;
        }
        if (i == this.setPasswordRow || i == this.changePasswordRow) {
            ChildLockActivity childLockActivity = new ChildLockActivity(1);
            childLockActivity.currentPasswordHash = this.currentPasswordHash;
            childLockActivity.currentPassword = this.currentPassword;
            childLockActivity.currentChildLockSetting = this.currentChildLockSetting;
            childLockActivity.currentSecretId = this.currentSecretId;
            childLockActivity.currentSecret = this.currentSecret;
            presentFragment(childLockActivity);
            return;
        }
        if (i == this.setRecoveryEmailRow || i == this.changeRecoveryEmailRow) {
            ChildLockActivity childLockActivity2 = new ChildLockActivity(1);
            childLockActivity2.currentPasswordHash = this.currentPasswordHash;
            childLockActivity2.currentPassword = this.currentPassword;
            childLockActivity2.currentChildLockSetting = this.currentChildLockSetting;
            childLockActivity2.currentSecretId = this.currentSecretId;
            childLockActivity2.currentSecret = this.currentSecret;
            childLockActivity2.emailOnly = true;
            childLockActivity2.passwordSetState = 3;
            presentFragment(childLockActivity2);
            return;
        }
        if (i == this.turnPasswordOffRow || i == this.abortPasswordRow) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            if (i == this.abortPasswordRow) {
                ChildLockSettingObject childLockSettingObject = this.currentChildLockSetting;
                if (childLockSettingObject != null && childLockSettingObject.hasPassword()) {
                    string = LocaleController.getString("CancelEmailQuestion", R.string.CancelEmailQuestion);
                } else {
                    string = LocaleController.getString("CancelPasswordQuestion", R.string.CancelPasswordQuestion);
                }
            } else {
                string = LocaleController.getString(R.string.TurnChildLockOffQuestion);
            }
            builder.setMessage(string);
            builder.setTitle(LocaleController.getString(R.string.AppName));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$createView$2(i, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return;
        }
        if (i == this.resendCodeRow) {
            callResendCodeRecoveryEmail();
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            builder2.setMessage(LocaleController.getString("ResendCodeInfo", R.string.ResendCodeInfo));
            builder2.setTitle(LocaleController.getString(R.string.AppName));
            builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            showDialog(builder2.create());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(int i, DialogInterface dialogInterface, int i2) {
        if (i == this.turnPasswordOffRow) {
            callTurnPasswordOff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$4(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        processDone();
        return true;
    }

    private void updateMessengerRows(boolean z) {
        int childCount = this.listView.getChildCount();
        ArrayList<Animator> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.getChildViewHolder(this.listView.getChildAt(i));
            holder.getItemViewType();
            int adapterPosition = holder.getAdapterPosition();
            if (adapterPosition == this.channelRow || adapterPosition == this.chatRow || adapterPosition == this.groupRow) {
                ((TextSettingsCell) holder.itemView).setEnabled(!z, arrayList);
            } else if (z && adapterPosition == this.messengerLockRow) {
                ((TextCheckCell) holder.itemView).setChecked(true);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.animatorSet = animatorSet2;
        animatorSet2.playTogether(arrayList);
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.messenger.ChildLockActivity.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(ChildLockActivity.this.animatorSet)) {
                    ChildLockActivity.this.animatorSet = null;
                }
            }
        });
        this.animatorSet.setDuration(150L);
        this.animatorSet.start();
    }

    private void callTurnPasswordOff() {
        needShowProgress();
        this.currentChildLockSetting = new ChildLockSettingObject();
        AppPreferences.getInstance(0).setChildLockSettingObject(this.currentChildLockSetting);
        loadPasswordInfo(false);
        needHideProgress();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        EditTextSettingsCell editTextSettingsCell;
        super.onResume();
        int i = this.type;
        if (i == 1) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$5();
                }
            }, 200L);
        } else if (i == 0 && (editTextSettingsCell = this.codeFieldCell) != null && editTextSettingsCell.getVisibility() == 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$6();
                }
            }, 200L);
        }
        if (this.type == 0) {
            this.currentChildLockSetting = AppPreferences.getInstance(0).getChildLockSettingObject();
            updateRows();
            this.listAdapter.notifyDataSetChanged();
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$5() {
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$6() {
        EditTextSettingsCell editTextSettingsCell = this.codeFieldCell;
        if (editTextSettingsCell != null) {
            editTextSettingsCell.getTextView().requestFocus();
            AndroidUtilities.showKeyboard(this.codeFieldCell.getTextView());
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        EditTextSettingsCell editTextSettingsCell;
        if (z) {
            int i = this.type;
            if (i == 1) {
                AndroidUtilities.showKeyboard(this.passwordEditText);
            } else if (i == 0 && (editTextSettingsCell = this.codeFieldCell) != null && editTextSettingsCell.getVisibility() == 0) {
                AndroidUtilities.showKeyboard(this.codeFieldCell.getTextView());
            }
        }
    }

    private void loadPasswordInfo(boolean z) {
        boolean z2 = true;
        if (!z) {
            this.loading = true;
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
        this.currentChildLockSetting = AppPreferences.getInstance(0).getChildLockSettingObject();
        this.loading = false;
        if (!z) {
            String str = this.currentPassword;
            if ((str == null || str.isEmpty()) && this.currentChildLockSetting.hasPassword()) {
                z2 = false;
            }
            this.passwordEntered = z2;
        }
        updateRows();
    }

    private void setPasswordSetState(int i) {
        if (this.passwordEditText == null) {
            return;
        }
        this.passwordSetState = i;
        if (i == 0) {
            this.actionBar.setTitle(LocaleController.getString("YourPassword", R.string.YourPassword));
            ChildLockSettingObject childLockSettingObject = this.currentChildLockSetting;
            if (childLockSettingObject != null && childLockSettingObject.hasPassword()) {
                this.titleTextView.setText(LocaleController.getString(R.string.PleaseEnterPassword));
            } else {
                this.titleTextView.setText(LocaleController.getString(R.string.EnterFirstPasswordChildLock));
            }
            this.passwordEditText.setImeOptions(5);
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.bottomTextView.setVisibility(4);
            this.bottomButton.setVisibility(4);
        } else if (i == 1) {
            this.actionBar.setTitle(LocaleController.getString("YourPassword", R.string.YourPassword));
            this.titleTextView.setText(LocaleController.getString("PleaseReEnterPassword", R.string.PleaseReEnterPassword));
            this.passwordEditText.setImeOptions(5);
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.bottomTextView.setVisibility(4);
            this.bottomButton.setVisibility(4);
        } else if (i == 2) {
            this.actionBar.setTitle(LocaleController.getString("PasswordHint", R.string.PasswordHint));
            this.titleTextView.setText(LocaleController.getString("PasswordHintText", R.string.PasswordHintText));
            this.passwordEditText.setImeOptions(5);
            this.passwordEditText.setTransformationMethod(null);
            this.bottomTextView.setVisibility(4);
            this.bottomButton.setVisibility(4);
        } else if (i == 3) {
            this.actionBar.setTitle(LocaleController.getString("RecoveryEmail", R.string.RecoveryEmail));
            this.titleTextView.setText(LocaleController.getString("YourEmail", R.string.YourEmail));
            this.passwordEditText.setImeOptions(5);
            this.passwordEditText.setTransformationMethod(null);
            this.passwordEditText.setInputType(33);
            this.bottomTextView.setVisibility(0);
            this.bottomButton.setVisibility(this.emailOnly ? 4 : 0);
        } else if (i == 4) {
            this.actionBar.setTitle(LocaleController.getString("PasswordRecovery", R.string.PasswordRecovery));
            this.titleTextView.setText(LocaleController.getString("PasswordCode", R.string.PasswordCode));
            this.bottomTextView.setText(LocaleController.getString("RestoreEmailSentInfo", R.string.RestoreEmailSentInfo));
            this.passwordEditText.setImeOptions(6);
            this.passwordEditText.setTransformationMethod(null);
            this.passwordEditText.setInputType(3);
            this.bottomTextView.setVisibility(0);
            this.bottomButton.setVisibility(0);
        }
        this.passwordEditText.setText(BuildConfig.FLAVOR);
        this.passwordEditText.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword).toString());
    }

    private void updateRows() {
        ChildLockSettingObject childLockSettingObject;
        StringBuilder sb = new StringBuilder();
        sb.append(this.setPasswordRow);
        sb.append(this.setPasswordDetailRow);
        sb.append(this.changePasswordRow);
        sb.append(this.turnPasswordOffRow);
        sb.append(this.setRecoveryEmailRow);
        sb.append(this.changeRecoveryEmailRow);
        sb.append(this.resendCodeRow);
        sb.append(this.abortPasswordRow);
        sb.append(this.passwordSetupDetailRow);
        sb.append(this.passwordCodeFieldRow);
        sb.append(this.passwordEnabledDetailRow);
        sb.append(this.shadowRow);
        sb.append(this.messengerHeaderRow);
        sb.append(this.messengerLockRow);
        sb.append(this.chatRow);
        sb.append(this.channelRow);
        sb.append(this.groupRow);
        sb.append(this.rubinoHeaderRow);
        sb.append(this.rubinoLockRow);
        sb.append(this.serviceHeaderRow);
        sb.append(this.payLockRow);
        sb.append(this.vodLockRow);
        sb.append(this.aodLockRow);
        sb.append(this.rowCount);
        boolean z = this.passwordCodeFieldRow != -1;
        this.rowCount = 0;
        this.setPasswordRow = -1;
        this.setPasswordDetailRow = -1;
        this.changePasswordRow = -1;
        this.turnPasswordOffRow = -1;
        this.setRecoveryEmailRow = -1;
        this.changeRecoveryEmailRow = -1;
        this.abortPasswordRow = -1;
        this.resendCodeRow = -1;
        this.passwordSetupDetailRow = -1;
        this.passwordCodeFieldRow = -1;
        this.passwordEnabledDetailRow = -1;
        this.shadowRow = -1;
        this.messengerLockRow = -1;
        this.rubinoLockRow = -1;
        this.payLockRow = -1;
        this.vodLockRow = -1;
        this.aodLockRow = -1;
        this.messengerHeaderRow = -1;
        this.rubinoHeaderRow = -1;
        this.serviceHeaderRow = -1;
        this.chatRow = -1;
        this.channelRow = -1;
        this.groupRow = -1;
        if (!this.loading && (childLockSettingObject = this.currentChildLockSetting) != null) {
            if (this.waitingForEmail) {
                int i = 0 + 1;
                this.rowCount = i;
                this.passwordCodeFieldRow = 0;
                int i2 = i + 1;
                this.rowCount = i2;
                this.passwordSetupDetailRow = i;
                int i3 = i2 + 1;
                this.rowCount = i3;
                this.resendCodeRow = i2;
                int i4 = i3 + 1;
                this.rowCount = i4;
                this.abortPasswordRow = i3;
                this.rowCount = i4 + 1;
                this.shadowRow = i4;
            } else if (childLockSettingObject.hasPassword()) {
                int i5 = this.rowCount;
                int i6 = i5 + 1;
                this.rowCount = i6;
                this.changePasswordRow = i5;
                int i7 = i6 + 1;
                this.rowCount = i7;
                this.turnPasswordOffRow = i6;
                int i8 = i7 + 1;
                this.rowCount = i8;
                this.passwordEnabledDetailRow = i7;
                int i9 = i8 + 1;
                this.rowCount = i9;
                this.messengerHeaderRow = i8;
                int i10 = i9 + 1;
                this.rowCount = i10;
                this.messengerLockRow = i9;
                int i11 = i10 + 1;
                this.rowCount = i11;
                this.chatRow = i10;
                int i12 = i11 + 1;
                this.rowCount = i12;
                this.channelRow = i11;
                int i13 = i12 + 1;
                this.rowCount = i13;
                this.groupRow = i12;
                int i14 = i13 + 1;
                this.rowCount = i14;
                this.rubinoHeaderRow = i13;
                int i15 = i14 + 1;
                this.rowCount = i15;
                this.rubinoLockRow = i14;
                int i16 = i15 + 1;
                this.rowCount = i16;
                this.serviceHeaderRow = i15;
                int i17 = i16 + 1;
                this.rowCount = i17;
                this.payLockRow = i16;
                int i18 = i17 + 1;
                this.rowCount = i18;
                this.vodLockRow = i17;
                this.rowCount = i18 + 1;
                this.aodLockRow = i18;
            } else {
                int i19 = this.rowCount;
                int i20 = i19 + 1;
                this.rowCount = i20;
                this.setPasswordRow = i19;
                this.rowCount = i20 + 1;
                this.setPasswordDetailRow = i20;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.setPasswordRow);
        sb2.append(this.setPasswordDetailRow);
        sb2.append(this.changePasswordRow);
        sb2.append(this.turnPasswordOffRow);
        sb2.append(this.setRecoveryEmailRow);
        sb2.append(this.changeRecoveryEmailRow);
        sb2.append(this.resendCodeRow);
        sb2.append(this.abortPasswordRow);
        sb2.append(this.passwordSetupDetailRow);
        sb2.append(this.passwordCodeFieldRow);
        sb2.append(this.passwordEnabledDetailRow);
        sb.append(this.messengerHeaderRow);
        sb.append(this.messengerLockRow);
        sb.append(this.chatRow);
        sb.append(this.channelRow);
        sb.append(this.groupRow);
        sb.append(this.rubinoHeaderRow);
        sb.append(this.rubinoLockRow);
        sb.append(this.serviceHeaderRow);
        sb.append(this.payLockRow);
        sb.append(this.vodLockRow);
        sb.append(this.aodLockRow);
        sb2.append(this.shadowRow);
        sb2.append(this.rowCount);
        if (this.listAdapter != null && !sb.toString().equals(sb2.toString())) {
            this.listAdapter.notifyDataSetChanged();
            if (this.passwordCodeFieldRow == -1 && getParentActivity() != null && z) {
                AndroidUtilities.hideKeyboard(getParentActivity().getCurrentFocus());
                this.codeFieldCell.setText(BuildConfig.FLAVOR, false);
            }
        }
        if (this.fragmentView != null) {
            if (this.loading || this.passwordEntered) {
                RecyclerListView recyclerListView = this.listView;
                if (recyclerListView != null) {
                    recyclerListView.setVisibility(0);
                    this.scrollView.setVisibility(4);
                    this.listView.setEmptyView(this.emptyView);
                }
                if (this.waitingForEmail && this.currentChildLockSetting != null) {
                    this.doneItem.setVisibility(0);
                } else if (this.passwordEditText != null) {
                    this.doneItem.setVisibility(8);
                    this.passwordEditText.setVisibility(4);
                    this.titleTextView.setVisibility(4);
                    this.bottomTextView.setVisibility(4);
                    this.bottomButton.setVisibility(4);
                }
                View view = this.fragmentView;
                int i21 = Theme.key_windowBackgroundGray;
                view.setBackgroundColor(Theme.getColor(i21));
                this.fragmentView.setTag(Integer.valueOf(i21));
                return;
            }
            RecyclerListView recyclerListView2 = this.listView;
            if (recyclerListView2 != null) {
                recyclerListView2.setEmptyView(null);
                this.listView.setVisibility(4);
                this.scrollView.setVisibility(0);
                this.emptyView.setVisibility(4);
            }
            if (this.passwordEditText != null) {
                this.doneItem.setVisibility(0);
                this.passwordEditText.setVisibility(0);
                View view2 = this.fragmentView;
                int i22 = Theme.key_windowBackgroundWhite;
                view2.setBackgroundColor(Theme.getColor(i22));
                this.fragmentView.setTag(Integer.valueOf(i22));
                this.titleTextView.setVisibility(0);
                this.bottomButton.setVisibility(8);
                this.bottomTextView.setVisibility(4);
                this.bottomButton.setText(LocaleController.getString("ForgotPassword", R.string.ForgotPassword));
                this.passwordEditText.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword).toString());
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.ChildLockActivity$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateRows$8();
                    }
                }, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRows$8() {
        EditTextBoldCursor editTextBoldCursor;
        if (isFinishing() || this.destroyed || (editTextBoldCursor = this.passwordEditText) == null) {
            return;
        }
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(this.passwordEditText);
    }

    private void needShowProgress() {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCancel(false);
        this.progressDialog.show();
    }

    protected void needHideProgress() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.progressDialog = null;
    }

    private boolean isValidEmail(String str) {
        if (str == null || str.length() < 3) {
            return false;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iLastIndexOf2 = str.lastIndexOf(64);
        return iLastIndexOf2 >= 0 && iLastIndexOf >= iLastIndexOf2;
    }

    private void setNewPassword(boolean z) {
        this.currentChildLockSetting.password = Utilities.MD5(this.firstPassword);
        AppPreferences.getInstance(0).setChildLockSettingObject(this.currentChildLockSetting);
        getNotificationCenter().postNotificationName(NotificationCenter.didSetChildLockPassword, this.firstPassword, this.email, this.hint);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() {
        int i = this.type;
        if (i == 0) {
            if (this.passwordEntered) {
                return;
            }
            String string = this.passwordEditText.getText().toString();
            if (string.length() != this.passwordLength) {
                onFieldError(this.passwordEditText, false);
                return;
            }
            AndroidUtilities.getStringBytes(string);
            needShowProgress();
            this.currentChildLockSetting = AppPreferences.getInstance(0).getChildLockSettingObject();
            if (Utilities.MD5(string).equals(this.currentChildLockSetting.password)) {
                this.passwordEntered = true;
                this.currentPassword = Utilities.MD5(string);
                AndroidUtilities.hideKeyboard(this.passwordEditText);
                updateRows();
            } else {
                onFieldError(this.passwordEditText, true);
            }
            needHideProgress();
            return;
        }
        if (i == 1) {
            int i2 = this.passwordSetState;
            if (i2 == 0) {
                if (this.passwordEditText.getText().length() != this.passwordLength) {
                    onFieldError(this.passwordEditText, false);
                    return;
                }
                this.titleTextView.setText(LocaleController.getString("ReEnterYourPasscode", R.string.ReEnterYourPasscode));
                this.firstPassword = this.passwordEditText.getText().toString();
                setPasswordSetState(1);
                return;
            }
            if (i2 == 1) {
                if (!this.firstPassword.equals(this.passwordEditText.getText().toString())) {
                    try {
                        Toast.makeText(getParentActivity(), LocaleController.getString("PasswordDoNotMatch", R.string.PasswordDoNotMatch), 0).show();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    onFieldError(this.passwordEditText, true);
                    return;
                }
                setNewPassword(false);
                return;
            }
            if (i2 == 2) {
                String string2 = this.passwordEditText.getText().toString();
                this.hint = string2;
                if (string2.toLowerCase().equals(this.firstPassword.toLowerCase())) {
                    try {
                        Toast.makeText(getParentActivity(), LocaleController.getString("PasswordAsHintError", R.string.PasswordAsHintError), 0).show();
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    onFieldError(this.passwordEditText, false);
                    return;
                }
                setNewPassword(false);
                return;
            }
            if (i2 == 3) {
                String string3 = this.passwordEditText.getText().toString();
                this.email = string3;
                if (!isValidEmail(string3)) {
                    onFieldError(this.passwordEditText, false);
                    return;
                } else {
                    setNewPassword(false);
                    return;
                }
            }
            if (i2 == 4) {
                if (this.passwordEditText.getText().toString().length() == 0) {
                    onFieldError(this.passwordEditText, false);
                } else {
                    needShowProgress();
                }
            }
        }
    }

    private void onFieldError(TextView textView, boolean z) {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        if (z) {
            textView.setText(BuildConfig.FLAVOR);
        }
        AndroidUtilities.shakeView(textView, 2.0f, 0);
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            ChildLockActivity.this.currentChildLockSetting = AppPreferences.getInstance(0).getChildLockSettingObject();
            if (adapterPosition != ChildLockActivity.this.messengerLockRow && adapterPosition != ChildLockActivity.this.rubinoLockRow && adapterPosition != ChildLockActivity.this.payLockRow && adapterPosition != ChildLockActivity.this.vodLockRow && adapterPosition != ChildLockActivity.this.aodLockRow) {
                if (ChildLockActivity.this.currentChildLockSetting == null || ChildLockActivity.this.currentChildLockSetting.messengerSettingObject.isMessengerLock) {
                    return false;
                }
                if (adapterPosition != ChildLockActivity.this.chatRow && adapterPosition != ChildLockActivity.this.channelRow && adapterPosition != ChildLockActivity.this.groupRow) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (ChildLockActivity.this.loading || ChildLockActivity.this.currentChildLockSetting == null) {
                return 0;
            }
            return ChildLockActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textSettingsCell;
            if (i == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 1) {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 3) {
                textSettingsCell = new TextCheckCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i != 4) {
                textSettingsCell = ChildLockActivity.this.codeFieldCell;
                if (textSettingsCell.getParent() != null) {
                    ((ViewGroup) textSettingsCell.getParent()).removeView(textSettingsCell);
                }
            } else {
                textSettingsCell = new HeaderCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            String string2;
            String string3;
            ChildLockActivity.this.currentChildLockSetting = AppPreferences.getInstance(0).getChildLockSettingObject();
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                int i2 = Theme.key_windowBackgroundWhiteBlackText;
                textSettingsCell.setTag(Integer.valueOf(i2));
                textSettingsCell.setTextColor(Theme.getColor(i2));
                if (i != ChildLockActivity.this.changePasswordRow) {
                    if (i != ChildLockActivity.this.setPasswordRow) {
                        if (i != ChildLockActivity.this.turnPasswordOffRow) {
                            if (i == ChildLockActivity.this.changeRecoveryEmailRow) {
                                textSettingsCell.setText(LocaleController.getString("ChangeRecoveryEmail", R.string.ChangeRecoveryEmail), ChildLockActivity.this.abortPasswordRow != -1);
                                return;
                            }
                            if (i != ChildLockActivity.this.resendCodeRow) {
                                if (i != ChildLockActivity.this.setRecoveryEmailRow) {
                                    if (i != ChildLockActivity.this.abortPasswordRow) {
                                        if (i == ChildLockActivity.this.chatRow) {
                                            if (ChildLockActivity.this.currentChildLockSetting != null) {
                                                string3 = ChildLockActivity.this.currentChildLockSetting.messengerSettingObject.chatSetting.getAccessString();
                                            } else {
                                                string3 = LocaleController.getString("Loading", R.string.Loading);
                                            }
                                            textSettingsCell.setTextAndValue(LocaleController.getString("FilterChats", R.string.FilterChats), string3, true);
                                            return;
                                        }
                                        if (i == ChildLockActivity.this.channelRow) {
                                            if (ChildLockActivity.this.currentChildLockSetting != null) {
                                                string2 = ChildLockActivity.this.currentChildLockSetting.messengerSettingObject.channelSetting.getAccessString();
                                            } else {
                                                string2 = LocaleController.getString("Loading", R.string.Loading);
                                            }
                                            textSettingsCell.setTextAndValue(LocaleController.getString("Channel", R.string.Channel), string2, true);
                                            return;
                                        }
                                        if (i == ChildLockActivity.this.groupRow) {
                                            if (ChildLockActivity.this.currentChildLockSetting != null) {
                                                string = ChildLockActivity.this.currentChildLockSetting.messengerSettingObject.groupSetting.getAccessString();
                                            } else {
                                                string = LocaleController.getString("Loading", R.string.Loading);
                                            }
                                            textSettingsCell.setTextAndValue(LocaleController.getString("Group", R.string.Group), string, true);
                                            return;
                                        }
                                        return;
                                    }
                                    int i3 = Theme.key_text_RedRegular;
                                    textSettingsCell.setTag(Integer.valueOf(i3));
                                    textSettingsCell.setTextColor(Theme.getColor(i3));
                                    if (ChildLockActivity.this.currentChildLockSetting != null && ChildLockActivity.this.currentChildLockSetting.hasPassword()) {
                                        textSettingsCell.setText(LocaleController.getString("AbortEmail", R.string.AbortEmail), false);
                                        return;
                                    } else {
                                        textSettingsCell.setText(LocaleController.getString("AbortPassword", R.string.AbortPassword), false);
                                        return;
                                    }
                                }
                                textSettingsCell.setText(LocaleController.getString("SetRecoveryEmail", R.string.SetRecoveryEmail), false);
                                return;
                            }
                            textSettingsCell.setText(LocaleController.getString("ResendCode", R.string.ResendCode), true);
                            return;
                        }
                        textSettingsCell.setText(LocaleController.getString(R.string.TurnChildLockOff).toString(), true);
                        return;
                    }
                    textSettingsCell.setText(LocaleController.getString(R.string.SetChildLockPassword).toString(), true);
                    return;
                }
                textSettingsCell.setText(LocaleController.getString(R.string.ChangeChildLockPassword).toString(), true);
                return;
            }
            if (itemViewType == 1) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i != ChildLockActivity.this.setPasswordDetailRow) {
                    if (i != ChildLockActivity.this.shadowRow) {
                        if (i == ChildLockActivity.this.passwordSetupDetailRow) {
                            if (ChildLockActivity.this.currentChildLockSetting != null) {
                                ChildLockActivity.this.currentChildLockSetting.hasPassword();
                            }
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_top, Theme.key_windowBackgroundGrayShadow));
                            return;
                        } else {
                            if (i == ChildLockActivity.this.passwordEnabledDetailRow) {
                                textInfoPrivacyCell.setText(LocaleController.formatString(R.string.EnabledChildLockText, LocaleController.getString(R.string.AppName)));
                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                                return;
                            }
                            return;
                        }
                    }
                    textInfoPrivacyCell.setText(BuildConfig.FLAVOR);
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
                textInfoPrivacyCell.setText(LocaleController.formatString(R.string.SetChildLockPasswordInfo, LocaleController.getString(R.string.AppName)));
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                return;
            }
            if (itemViewType != 3) {
                if (itemViewType != 4) {
                    return;
                }
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != ChildLockActivity.this.messengerHeaderRow) {
                    if (i != ChildLockActivity.this.rubinoHeaderRow) {
                        if (i == ChildLockActivity.this.serviceHeaderRow) {
                            headerCell.setText(LocaleController.getString("services_tab", R.string.services_tab));
                            return;
                        }
                        return;
                    }
                    headerCell.setText(LocaleController.getString("RubinoName", R.string.RubinoName));
                    return;
                }
                headerCell.setText(LocaleController.getString("messenger_tab", R.string.messenger_tab));
                return;
            }
            TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
            if (i == ChildLockActivity.this.messengerLockRow) {
                String string4 = LocaleController.formatString(R.string.RubinoLock, LocaleController.getString(R.string.messenger_tab)).toString();
                if (ChildLockActivity.this.currentChildLockSetting != null && ChildLockActivity.this.currentChildLockSetting.messengerSettingObject.isMessengerLock) {
                    z = true;
                }
                textCheckCell.setTextAndCheck(string4, z, true);
                return;
            }
            if (i == ChildLockActivity.this.rubinoLockRow) {
                String string5 = LocaleController.formatString(R.string.RubinoLock, LocaleController.getString(AppFavorUtils.rubinoNameId)).toString();
                if (ChildLockActivity.this.currentChildLockSetting != null && ChildLockActivity.this.currentChildLockSetting.rubinoSettingObject.isRubinoLock) {
                    z = true;
                }
                textCheckCell.setTextAndCheck(string5, z, true);
                return;
            }
            if (i == ChildLockActivity.this.payLockRow) {
                String string6 = LocaleController.formatString(R.string.RubinoLock, LocaleController.getString(R.string.Pay)).toString();
                if (ChildLockActivity.this.currentChildLockSetting != null && ChildLockActivity.this.currentChildLockSetting.servicesSettingObject.isPayLock) {
                    z = true;
                }
                textCheckCell.setTextAndCheck(string6, z, true);
                return;
            }
            if (i == ChildLockActivity.this.vodLockRow) {
                String string7 = LocaleController.formatString(R.string.RubinoLock, LocaleController.getString(R.string.Video)).toString();
                if (ChildLockActivity.this.currentChildLockSetting != null && ChildLockActivity.this.currentChildLockSetting.servicesSettingObject.isVodLock) {
                    z = true;
                }
                textCheckCell.setTextAndCheck(string7, z, true);
                return;
            }
            if (i == ChildLockActivity.this.aodLockRow) {
                String string8 = LocaleController.formatString(R.string.RubinoLock, LocaleController.getString(R.string.music)).toString();
                if (ChildLockActivity.this.currentChildLockSetting != null && ChildLockActivity.this.currentChildLockSetting.servicesSettingObject.isAodLock) {
                    z = true;
                }
                textCheckCell.setTextAndCheck(string8, z, true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ChildLockActivity.this.setPasswordDetailRow || i == ChildLockActivity.this.shadowRow || i == ChildLockActivity.this.passwordSetupDetailRow || i == ChildLockActivity.this.passwordEnabledDetailRow) {
                return 1;
            }
            if (i == ChildLockActivity.this.passwordCodeFieldRow) {
                return 2;
            }
            if (i == ChildLockActivity.this.messengerLockRow || i == ChildLockActivity.this.rubinoLockRow || i == ChildLockActivity.this.payLockRow || i == ChildLockActivity.this.vodLockRow || i == ChildLockActivity.this.aodLockRow) {
                return 3;
            }
            return (i == ChildLockActivity.this.messengerHeaderRow || i == ChildLockActivity.this.rubinoHeaderRow || i == ChildLockActivity.this.serviceHeaderRow) ? 4 : 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, TextCheckCell.class}, null, null, null, i));
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, EditTextSettingsCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i3 = ThemeDescription.FLAG_BACKGROUND;
        int i4 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_text_RedRegular));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        int i5 = Theme.key_windowBackgroundWhiteHintText;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        TextView textView = this.titleTextView;
        int i6 = ThemeDescription.FLAG_TEXTCOLOR;
        int i7 = Theme.key_windowBackgroundWhiteGrayText6;
        arrayList.add(new ThemeDescription(textView, i6, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.bottomTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.bottomButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputField));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchThumb));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchThumbChecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        return arrayList;
    }
}
