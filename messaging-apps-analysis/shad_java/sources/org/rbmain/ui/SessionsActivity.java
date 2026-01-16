package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.proxy.ContactsProxy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_account_authorizations;
import org.rbmain.tgnet.TLRPC$TL_account_resetAuthorization;
import org.rbmain.tgnet.TLRPC$TL_account_resetWebAuthorization;
import org.rbmain.tgnet.TLRPC$TL_account_webAuthorizations;
import org.rbmain.tgnet.TLRPC$TL_auth_acceptLoginToken;
import org.rbmain.tgnet.TLRPC$TL_authorization;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_webAuthorization;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.ActionIntroActivity;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.SessionCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.UndoView;

/* loaded from: classes4.dex */
public class SessionsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private boolean canRemoveAllSessions;
    private TLRPC$TL_authorization currentSession;
    private int currentSessionRow;
    private int currentSessionSectionRow;
    private int currentType;
    private LinearLayout emptyLayout;
    private EmptyTextProgressView emptyView;
    private ImageView imageView;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean loading;
    private int noOtherSessionsRow;
    private int otherSessionsEndRow;
    private int otherSessionsSectionRow;
    private int otherSessionsStartRow;
    private int otherSessionsTerminateDetail;
    private int passwordSessionsDetailRow;
    private int passwordSessionsEndRow;
    private int passwordSessionsSectionRow;
    private int passwordSessionsStartRow;
    private int qrCodeRow;
    private int rowCount;
    private int terminateAllSessionsDetailRow;
    private int terminateAllSessionsRow;
    private TextView textView1;
    private TextView textView2;
    private UndoView undoView;
    private ArrayList<TLObject> sessions = new ArrayList<>();
    private ArrayList<TLObject> passwordSessions = new ArrayList<>();

    public SessionsActivity(int i) {
        this.currentType = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        loadSessions(false);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.newSessionReceived);
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.newSessionReceived);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("Devices", R.string.Devices));
        } else {
            this.actionBar.setTitle(LocaleController.getString("WebSessionsTitle", R.string.WebSessionsTitle));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.SessionsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    SessionsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyLayout.setGravity(17);
        this.emptyLayout.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
        this.emptyLayout.setLayoutParams(new AbsListView.LayoutParams(-1, AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()));
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        if (this.currentType == 0) {
            imageView.setImageResource(R.drawable.devices);
        } else {
            imageView.setImageResource(R.drawable.no_apps);
        }
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_sessions_devicesImage), PorterDuff.Mode.MULTIPLY));
        this.emptyLayout.addView(this.imageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.textView1 = textView;
        int i = Theme.key_windowBackgroundWhiteGrayText2;
        textView.setTextColor(Theme.getColor(i));
        this.textView1.setGravity(17);
        this.textView1.setTextSize(1, 17.0f);
        this.textView1.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        if (this.currentType == 0) {
            this.textView1.setText(LocaleController.getString("NoOtherSessions", R.string.NoOtherSessions));
        } else {
            this.textView1.setText(LocaleController.getString("NoOtherWebSessions", R.string.NoOtherWebSessions));
        }
        this.emptyLayout.addView(this.textView1, LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 0));
        TextView textView2 = new TextView(context);
        this.textView2 = textView2;
        textView2.setTextColor(Theme.getColor(i));
        this.textView2.setGravity(17);
        this.textView2.setTextSize(1, 17.0f);
        this.textView2.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        if (this.currentType == 0) {
            this.textView2.setText(LocaleController.getString("NoOtherSessionsInfo", R.string.NoOtherSessionsInfo));
        } else {
            this.textView2.setText(LocaleController.getString("NoOtherWebSessionsInfo", R.string.NoOtherWebSessionsInfo));
        }
        this.emptyLayout.addView(this.textView2, LayoutHelper.createLinear(-2, -2, 17, 0, 14, 0, 0));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showProgress();
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1, 17));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setEmptyView(this.emptyView);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda19
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$15(view, i2);
            }
        });
        if (this.currentType == 0) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(context);
            this.undoView = anonymousClass2;
            frameLayout2.addView(anonymousClass2, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$15(View view, final int i) {
        CharSequence string;
        String string2;
        if (i == this.qrCodeRow) {
            ActionIntroActivity actionIntroActivity = new ActionIntroActivity(5);
            actionIntroActivity.setQrLoginDelegate(new ActionIntroActivity.ActionIntroQRLoginDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda18
                @Override // org.rbmain.ui.ActionIntroActivity.ActionIntroQRLoginDelegate
                public final void didFindQRCode(String str) {
                    this.f$0.lambda$createView$3(str);
                }
            });
            presentFragment(actionIntroActivity);
            return;
        }
        if (i == this.terminateAllSessionsRow) {
            if (getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            if (this.currentType == 0) {
                builder.setMessage(LocaleController.getString("AreYouSureSessions", R.string.AreYouSureSessions));
                builder.setTitle(LocaleController.getString("AreYouSureSessionsTitle", R.string.AreYouSureSessionsTitle));
                string2 = LocaleController.getString("Terminate", R.string.Terminate);
            } else {
                builder.setMessage(LocaleController.getString("AreYouSureWebSessions", R.string.AreYouSureWebSessions));
                builder.setTitle(LocaleController.getString("TerminateWebSessionsTitle", R.string.TerminateWebSessionsTitle));
                string2 = LocaleController.getString("Disconnect", R.string.Disconnect);
            }
            builder.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$8(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                return;
            }
            return;
        }
        if (((i < this.otherSessionsStartRow || i >= this.otherSessionsEndRow) && (i < this.passwordSessionsStartRow || i >= this.passwordSessionsEndRow)) || getParentActivity() == null) {
            return;
        }
        TLRPC$TL_authorization tLRPC$TL_authorization = (TLRPC$TL_authorization) this.sessions.get(i - this.otherSessionsStartRow);
        if (tLRPC$TL_authorization == null || tLRPC$TL_authorization.canTerminate) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            final boolean[] zArr = new boolean[1];
            if (this.currentType == 0) {
                builder2.setMessage(LocaleController.getString("TerminateSessionText", R.string.TerminateSessionText));
                builder2.setTitle(LocaleController.getString("AreYouSureSessionTitle", R.string.AreYouSureSessionTitle));
                string = LocaleController.getString("Terminate", R.string.Terminate);
            } else {
                TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization = (TLRPC$TL_webAuthorization) this.sessions.get(i - this.otherSessionsStartRow);
                builder2.setMessage(LocaleController.formatString("TerminateWebSessionText", R.string.TerminateWebSessionText, tLRPC$TL_webAuthorization.domain));
                builder2.setTitle(LocaleController.getString("TerminateWebSessionTitle", R.string.TerminateWebSessionTitle));
                CharSequence string3 = LocaleController.getString("Disconnect", R.string.Disconnect);
                FrameLayout frameLayout = new FrameLayout(getParentActivity());
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(tLRPC$TL_webAuthorization.bot_id));
                String firstName = user != null ? UserObject.getFirstName(user) : BuildConfig.FLAVOR;
                CheckBoxCell checkBoxCell = new CheckBoxCell(getParentActivity(), 1);
                checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                checkBoxCell.setText(LocaleController.formatString("TerminateWebSessionStop", R.string.TerminateWebSessionStop, firstName), BuildConfig.FLAVOR, false, false);
                checkBoxCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                frameLayout.addView(checkBoxCell, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SessionsActivity.lambda$createView$9(zArr, view2);
                    }
                });
                builder2.setCustomViewOffset(16);
                builder2.setView(frameLayout);
                string = string3;
            }
            builder2.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$14(i, zArr, dialogInterface, i2);
                }
            });
            builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate2 = builder2.create();
            showDialog(alertDialogCreate2);
            TextView textView2 = (TextView) alertDialogCreate2.getButton(-1);
            if (textView2 != null) {
                textView2.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(String str) {
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCancel(false);
        alertDialog.show();
        byte[] bArrDecode = Base64.decode(str.substring(14), 8);
        TLRPC$TL_auth_acceptLoginToken tLRPC$TL_auth_acceptLoginToken = new TLRPC$TL_auth_acceptLoginToken();
        tLRPC$TL_auth_acceptLoginToken.token = bArrDecode;
        getConnectionsManager().sendRequest(tLRPC$TL_auth_acceptLoginToken, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda15
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$2(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(AlertDialog alertDialog, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        try {
            alertDialog.dismiss();
        } catch (Exception unused) {
        }
        if (tLObject instanceof TLRPC$TL_authorization) {
            this.sessions.add(0, (TLRPC$TL_authorization) tLObject);
            updateRows();
            this.listAdapter.notifyDataSetChanged();
            this.undoView.showWithAction(0L, 11, tLObject);
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$0(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(TLRPC$TL_error tLRPC$TL_error) {
        String string;
        if (tLRPC$TL_error.text.equals("AUTH_TOKEN_EXCEPTION")) {
            string = LocaleController.getString("AccountAlreadyLoggedIn", R.string.AccountAlreadyLoggedIn);
        } else {
            string = LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text;
        }
        AlertsCreator.showSimpleAlert(this, LocaleController.getString("AuthAnotherClient", R.string.AuthAnotherClient), string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(DialogInterface dialogInterface, int i) {
        if (this.currentType == 0) {
            ContactsProxy.getInstance(this.currentAccount).terminateOtherSessions(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_resetAuthorizations
                public static int constructor = -1616179942;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i2, boolean z) {
                    return TLRPC$Bool.TLdeserialize(abstractSerializedData, i2, z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda11
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$5(tLObject, tLRPC$TL_error);
                }
            });
        } else {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_resetWebAuthorizations
                public static int constructor = 1747789204;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i2, boolean z) {
                    return TLRPC$Bool.TLdeserialize(abstractSerializedData, i2, z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda12
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$7(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$4(tLRPC$TL_error, tLObject);
            }
        });
        for (int i = 0; i < 3; i++) {
            UserConfig userConfig = UserConfig.getInstance(i);
            if (userConfig.isClientActivated()) {
                userConfig.registeredForPush = false;
                userConfig.saveConfig(false);
                MessagesController.getInstance(i).registerForPush(SharedConfig.pushString);
                ConnectionsManager.getInstance(i).setUserId(userConfig.getClientUserId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (getParentActivity() != null && tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            Toast.makeText(getParentActivity(), LocaleController.getString("TerminateAllSessions", R.string.TerminateAllSessions), 0).show();
            finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$6(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (getParentActivity() == null) {
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            Toast.makeText(getParentActivity(), LocaleController.getString("TerminateAllWebSessions", R.string.TerminateAllWebSessions), 0).show();
        } else {
            Toast.makeText(getParentActivity(), LocaleController.getString("UnknownError", R.string.UnknownError), 0).show();
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$9(boolean[] zArr, View view) {
        if (view.isEnabled()) {
            zArr[0] = !zArr[0];
            ((CheckBoxCell) view).setChecked(zArr[0], true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$14(int i, boolean[] zArr, DialogInterface dialogInterface, int i2) {
        final TLRPC$TL_authorization tLRPC$TL_authorization;
        if (getParentActivity() == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCancel(false);
        alertDialog.show();
        if (this.currentType == 0) {
            int i3 = this.otherSessionsStartRow;
            if (i >= i3 && i < this.otherSessionsEndRow) {
                tLRPC$TL_authorization = (TLRPC$TL_authorization) this.sessions.get(i - i3);
            } else {
                tLRPC$TL_authorization = (TLRPC$TL_authorization) this.passwordSessions.get(i - this.passwordSessionsStartRow);
            }
            TLRPC$TL_account_resetAuthorization tLRPC$TL_account_resetAuthorization = new TLRPC$TL_account_resetAuthorization();
            tLRPC$TL_account_resetAuthorization.hash = tLRPC$TL_authorization.hash;
            ContactsProxy.getInstance(this.currentAccount).terminateSession(tLRPC$TL_account_resetAuthorization, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda16
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$11(alertDialog, tLRPC$TL_authorization, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        final TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization = (TLRPC$TL_webAuthorization) this.sessions.get(i - this.otherSessionsStartRow);
        TLRPC$TL_account_resetWebAuthorization tLRPC$TL_account_resetWebAuthorization = new TLRPC$TL_account_resetWebAuthorization();
        tLRPC$TL_account_resetWebAuthorization.hash = tLRPC$TL_webAuthorization.hash;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_resetWebAuthorization, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda17
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$13(alertDialog, tLRPC$TL_webAuthorization, tLObject, tLRPC$TL_error);
            }
        });
        if (zArr[0]) {
            MessagesController.getInstance(this.currentAccount).blockPeer(tLRPC$TL_webAuthorization.bot_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$11(final AlertDialog alertDialog, final TLRPC$TL_authorization tLRPC$TL_authorization, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$10(alertDialog, tLRPC$TL_error, tLRPC$TL_authorization);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$10(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_authorization tLRPC$TL_authorization) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLRPC$TL_error == null) {
            this.sessions.remove(tLRPC$TL_authorization);
            this.passwordSessions.remove(tLRPC$TL_authorization);
            updateRows();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$13(final AlertDialog alertDialog, final TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$12(alertDialog, tLRPC$TL_error, tLRPC$TL_webAuthorization);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$12(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLRPC$TL_error == null) {
            this.sessions.remove(tLRPC$TL_webAuthorization);
            updateRows();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: org.rbmain.ui.SessionsActivity$2, reason: invalid class name */
    class AnonymousClass2 extends UndoView {
        AnonymousClass2(Context context) {
            super(context);
        }

        @Override // org.rbmain.ui.Components.UndoView
        public void hide(boolean z, int i) {
            if (!z) {
                final TLRPC$TL_authorization tLRPC$TL_authorization = (TLRPC$TL_authorization) getCurrentInfoObject();
                TLRPC$TL_account_resetAuthorization tLRPC$TL_account_resetAuthorization = new TLRPC$TL_account_resetAuthorization();
                tLRPC$TL_account_resetAuthorization.hash = tLRPC$TL_authorization.hash;
                ConnectionsManager.getInstance(((BaseFragment) SessionsActivity.this).currentAccount).sendRequest(tLRPC$TL_account_resetAuthorization, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$2$$ExternalSyntheticLambda1
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$hide$1(tLRPC$TL_authorization, tLObject, tLRPC$TL_error);
                    }
                });
            }
            super.hide(z, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$hide$1(final TLRPC$TL_authorization tLRPC$TL_authorization, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hide$0(tLRPC$TL_error, tLRPC$TL_authorization);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$hide$0(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_authorization tLRPC$TL_authorization) {
            if (tLRPC$TL_error == null) {
                SessionsActivity.this.sessions.remove(tLRPC$TL_authorization);
                SessionsActivity.this.passwordSessions.remove(tLRPC$TL_authorization);
                SessionsActivity.this.updateRows();
                if (SessionsActivity.this.listAdapter != null) {
                    SessionsActivity.this.listAdapter.notifyDataSetChanged();
                }
                SessionsActivity.this.loadSessions(true);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.newSessionReceived) {
            loadSessions(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSessions(boolean z) {
        if (this.loading) {
            return;
        }
        if (!z) {
            this.loading = true;
        }
        if (this.currentType == 0) {
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ContactsProxy.getInstance(this.currentAccount).getActiveSessions(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_getAuthorizations
                public static int constructor = -484392616;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z2) {
                    return TLRPC$TL_account_authorizations.TLdeserialize(abstractSerializedData, i, z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda14
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadSessions$17(tLObject, tLRPC$TL_error);
                }
            }), this.classGuid);
        } else {
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_getWebAuthorizations
                public static int constructor = 405695855;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z2) {
                    return TLRPC$TL_account_webAuthorizations.TLdeserialize(abstractSerializedData, i, z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda13
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadSessions$19(tLObject, tLRPC$TL_error);
                }
            }), this.classGuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSessions$17(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSessions$16(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSessions$16(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.loading = false;
        if (tLRPC$TL_error == null) {
            this.sessions.clear();
            this.passwordSessions.clear();
            TLRPC$TL_account_authorizations tLRPC$TL_account_authorizations = (TLRPC$TL_account_authorizations) tLObject;
            int size = tLRPC$TL_account_authorizations.authorizations.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_authorization tLRPC$TL_authorization = tLRPC$TL_account_authorizations.authorizations.get(i);
                if ((tLRPC$TL_authorization.flags & 1) != 0) {
                    this.currentSession = tLRPC$TL_authorization;
                } else if (tLRPC$TL_authorization.password_pending) {
                    this.passwordSessions.add(tLRPC$TL_authorization);
                } else {
                    this.sessions.add(tLRPC$TL_authorization);
                }
            }
            this.canRemoveAllSessions = tLRPC$TL_account_authorizations.canRemoveAll;
            updateRows();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSessions$19(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.SessionsActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSessions$18(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSessions$18(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.loading = false;
        if (tLRPC$TL_error == null) {
            this.sessions.clear();
            TLRPC$TL_account_webAuthorizations tLRPC$TL_account_webAuthorizations = (TLRPC$TL_account_webAuthorizations) tLObject;
            MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$TL_account_webAuthorizations.users, false);
            this.sessions.addAll(tLRPC$TL_account_webAuthorizations.authorizations);
            updateRows();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        boolean z = false;
        this.rowCount = 0;
        this.qrCodeRow = -1;
        if (this.currentSession != null) {
            int i = 0 + 1;
            this.rowCount = i;
            this.currentSessionSectionRow = 0;
            this.rowCount = i + 1;
            this.currentSessionRow = i;
        } else {
            this.currentSessionRow = -1;
            this.currentSessionSectionRow = -1;
        }
        if (this.currentType == 0 && getMessagesController().qrLoginCamera) {
            z = true;
        }
        if (this.canRemoveAllSessions && (!this.passwordSessions.isEmpty() || !this.sessions.isEmpty())) {
            int i2 = this.rowCount;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.terminateAllSessionsRow = i2;
            this.rowCount = i3 + 1;
            this.terminateAllSessionsDetailRow = i3;
        } else {
            this.terminateAllSessionsRow = -1;
            this.terminateAllSessionsDetailRow = -1;
            if (z) {
                int i4 = this.rowCount;
                this.rowCount = i4 + 1;
                this.qrCodeRow = i4;
            }
            if (this.passwordSessions.isEmpty() && this.sessions.isEmpty() && (this.currentType == 1 || this.currentSession != null)) {
                int i5 = this.rowCount;
                this.rowCount = i5 + 1;
                this.noOtherSessionsRow = i5;
            } else {
                this.noOtherSessionsRow = -1;
            }
        }
        if (this.passwordSessions.isEmpty()) {
            this.passwordSessionsDetailRow = -1;
            this.passwordSessionsEndRow = -1;
            this.passwordSessionsStartRow = -1;
            this.passwordSessionsSectionRow = -1;
        } else {
            int i6 = this.rowCount;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.passwordSessionsSectionRow = i6;
            this.passwordSessionsStartRow = i7;
            int size = i7 + this.passwordSessions.size();
            this.rowCount = size;
            this.passwordSessionsEndRow = size;
            this.rowCount = size + 1;
            this.passwordSessionsDetailRow = size;
        }
        if (this.sessions.isEmpty()) {
            this.otherSessionsSectionRow = -1;
            this.otherSessionsStartRow = -1;
            this.otherSessionsEndRow = -1;
            this.otherSessionsTerminateDetail = -1;
            return;
        }
        int i8 = this.rowCount;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.otherSessionsSectionRow = i8;
        if (z) {
            this.rowCount = i9 + 1;
            this.qrCodeRow = i9;
        }
        int i10 = this.rowCount;
        this.otherSessionsStartRow = i10;
        this.otherSessionsEndRow = i10 + this.sessions.size();
        int size2 = this.rowCount + this.sessions.size();
        this.rowCount = size2;
        this.rowCount = size2 + 1;
        this.otherSessionsTerminateDetail = size2;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == SessionsActivity.this.terminateAllSessionsRow || adapterPosition == SessionsActivity.this.qrCodeRow || (adapterPosition >= SessionsActivity.this.otherSessionsStartRow && adapterPosition < SessionsActivity.this.otherSessionsEndRow) || (adapterPosition >= SessionsActivity.this.passwordSessionsStartRow && adapterPosition < SessionsActivity.this.passwordSessionsEndRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (SessionsActivity.this.loading) {
                return 0;
            }
            return SessionsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textSettingsCell;
            if (i == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 1) {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 2) {
                textSettingsCell = new HeaderCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 3) {
                textSettingsCell = SessionsActivity.this.emptyLayout;
            } else {
                textSettingsCell = new SessionCell(this.mContext, SessionsActivity.this.currentType);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                if (i != SessionsActivity.this.terminateAllSessionsRow) {
                    if (i == SessionsActivity.this.qrCodeRow) {
                        int i2 = Theme.key_windowBackgroundWhiteBlueText4;
                        textSettingsCell.setTextColor(Theme.getColor(i2));
                        textSettingsCell.setTag(Integer.valueOf(i2));
                        textSettingsCell.setText(LocaleController.getString("AuthAnotherClient", R.string.AuthAnotherClient), !SessionsActivity.this.sessions.isEmpty());
                        return;
                    }
                    return;
                }
                int i3 = Theme.key_text_RedRegular;
                textSettingsCell.setTextColor(Theme.getColor(i3));
                textSettingsCell.setTag(Integer.valueOf(i3));
                if (SessionsActivity.this.currentType == 0) {
                    textSettingsCell.setText(LocaleController.getString("TerminateAllSessions", R.string.TerminateAllSessions), false);
                    return;
                } else {
                    textSettingsCell.setText(LocaleController.getString("TerminateAllWebSessions", R.string.TerminateAllWebSessions), false);
                    return;
                }
            }
            if (itemViewType == 1) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i == SessionsActivity.this.terminateAllSessionsDetailRow) {
                    if (SessionsActivity.this.currentType == 0) {
                        textInfoPrivacyCell.setText(LocaleController.getString("ClearOtherSessionsHelp", R.string.ClearOtherSessionsHelp));
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("ClearOtherWebSessionsHelp", R.string.ClearOtherWebSessionsHelp));
                    }
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
                if (i == SessionsActivity.this.otherSessionsTerminateDetail) {
                    if (SessionsActivity.this.currentType == 0) {
                        if (SessionsActivity.this.sessions.isEmpty()) {
                            textInfoPrivacyCell.setText(BuildConfig.FLAVOR);
                        } else {
                            textInfoPrivacyCell.setText(LocaleController.getString("TerminateSessionInfo", R.string.TerminateSessionInfo));
                        }
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("TerminateWebSessionInfo", R.string.TerminateWebSessionInfo));
                    }
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
                if (i == SessionsActivity.this.passwordSessionsDetailRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("LoginAttemptsInfo", R.string.LoginAttemptsInfo));
                    if (SessionsActivity.this.otherSessionsTerminateDetail == -1) {
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                        return;
                    } else {
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        return;
                    }
                }
                return;
            }
            if (itemViewType == 2) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != SessionsActivity.this.currentSessionSectionRow) {
                    if (i == SessionsActivity.this.otherSessionsSectionRow) {
                        if (SessionsActivity.this.currentType == 0) {
                            headerCell.setText(LocaleController.getString("OtherSessions", R.string.OtherSessions));
                            return;
                        } else {
                            headerCell.setText(LocaleController.getString("OtherWebSessions", R.string.OtherWebSessions));
                            return;
                        }
                    }
                    if (i == SessionsActivity.this.passwordSessionsSectionRow) {
                        headerCell.setText(LocaleController.getString("LoginAttempts", R.string.LoginAttempts));
                        return;
                    }
                    return;
                }
                headerCell.setText(LocaleController.getString("CurrentSession", R.string.CurrentSession));
                return;
            }
            if (itemViewType == 3) {
                ViewGroup.LayoutParams layoutParams = SessionsActivity.this.emptyLayout.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = Math.max(AndroidUtilities.dp(220.0f), ((AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp((SessionsActivity.this.qrCodeRow == -1 ? 0 : 30) + 128)) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0));
                    SessionsActivity.this.emptyLayout.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            SessionCell sessionCell = (SessionCell) viewHolder.itemView;
            if (i == SessionsActivity.this.currentSessionRow) {
                sessionCell.setSession(SessionsActivity.this.currentSession, (SessionsActivity.this.sessions.isEmpty() && SessionsActivity.this.passwordSessions.isEmpty() && SessionsActivity.this.qrCodeRow == -1) ? false : true);
                return;
            }
            if (i < SessionsActivity.this.otherSessionsStartRow || i >= SessionsActivity.this.otherSessionsEndRow) {
                if (i < SessionsActivity.this.passwordSessionsStartRow || i >= SessionsActivity.this.passwordSessionsEndRow) {
                    return;
                }
                sessionCell.setSession((TLObject) SessionsActivity.this.passwordSessions.get(i - SessionsActivity.this.passwordSessionsStartRow), i != SessionsActivity.this.passwordSessionsEndRow - 1);
                return;
            }
            sessionCell.setSession((TLObject) SessionsActivity.this.sessions.get(i - SessionsActivity.this.otherSessionsStartRow), i != SessionsActivity.this.otherSessionsEndRow - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == SessionsActivity.this.terminateAllSessionsRow || i == SessionsActivity.this.qrCodeRow) {
                return 0;
            }
            if (i == SessionsActivity.this.terminateAllSessionsDetailRow || i == SessionsActivity.this.otherSessionsTerminateDetail || i == SessionsActivity.this.passwordSessionsDetailRow) {
                return 1;
            }
            if (i == SessionsActivity.this.currentSessionSectionRow || i == SessionsActivity.this.otherSessionsSectionRow || i == SessionsActivity.this.passwordSessionsSectionRow) {
                return 2;
            }
            if (i == SessionsActivity.this.noOtherSessionsRow) {
                return 3;
            }
            if (i == SessionsActivity.this.currentSessionRow) {
                return 4;
            }
            if (i < SessionsActivity.this.otherSessionsStartRow || i >= SessionsActivity.this.otherSessionsEndRow) {
                return (i < SessionsActivity.this.passwordSessionsStartRow || i >= SessionsActivity.this.passwordSessionsEndRow) ? 0 : 4;
            }
            return 4;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, SessionCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.imageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_sessions_devicesImage));
        TextView textView = this.textView1;
        int i3 = ThemeDescription.FLAG_TEXTCOLOR;
        int i4 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(textView, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.textView2, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, Theme.key_progressCircle));
        int i5 = Theme.key_text_RedRegular;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        int i6 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SessionCell.class}, new String[]{"onlineTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        int i7 = Theme.key_windowBackgroundWhiteGrayText3;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SessionCell.class}, new String[]{"onlineTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"detailTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"detailExTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_undo_background));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        int i8 = Theme.key_undo_infoColor;
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{UndoView.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        return arrayList;
    }
}
