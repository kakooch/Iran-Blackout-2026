package ir.eitaa.ui;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_authorizations;
import ir.eitaa.tgnet.TLRPC$TL_account_resetAuthorization;
import ir.eitaa.tgnet.TLRPC$TL_account_resetWebAuthorization;
import ir.eitaa.tgnet.TLRPC$TL_account_webAuthorizations;
import ir.eitaa.tgnet.TLRPC$TL_auth_acceptLoginToken;
import ir.eitaa.tgnet.TLRPC$TL_authorization;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_webAuthorization;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.ActionIntroActivity;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.SessionCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.UndoView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SessionsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
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

    public SessionsActivity(int type) {
        this.currentType = type;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        loadSessions(false);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.newSessionReceived);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.newSessionReceived);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("Devices", R.string.Devices));
        } else {
            this.actionBar.setTitle(LocaleController.getString("WebSessionsTitle", R.string.WebSessionsTitle));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.SessionsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    SessionsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyLayout.setGravity(17);
        this.emptyLayout.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.emptyLayout.setLayoutParams(new AbsListView.LayoutParams(-1, AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()));
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        if (this.currentType == 0) {
            imageView.setImageResource(R.drawable.devices);
        } else {
            imageView.setImageResource(R.drawable.no_apps);
        }
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("sessions_devicesImage"), PorterDuff.Mode.MULTIPLY));
        this.emptyLayout.addView(this.imageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.textView1 = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        this.textView1.setGravity(17);
        this.textView1.setTextSize(1, 17.0f);
        this.textView1.setTypeface(AndroidUtilities.getFontFamily(true));
        if (this.currentType == 0) {
            this.textView1.setText(LocaleController.getString("NoOtherSessions", R.string.NoOtherSessions));
        } else {
            this.textView1.setText(LocaleController.getString("NoOtherWebSessions", R.string.NoOtherWebSessions));
        }
        this.emptyLayout.addView(this.textView1, LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 0));
        TextView textView2 = new TextView(context);
        this.textView2 = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
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
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$kNbQNrMjt0d-ppPr7c0PqzR7LXI
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$15$SessionsActivity(view, i);
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
    /* renamed from: lambda$createView$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$15$SessionsActivity(View view, final int i) {
        CharSequence string;
        String string2;
        if (i == this.qrCodeRow) {
            ActionIntroActivity actionIntroActivity = new ActionIntroActivity(5);
            actionIntroActivity.setQrLoginDelegate(new ActionIntroActivity.ActionIntroQRLoginDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$DwIDjeOxCuCMWTYXN31mDQ4mnsY
                @Override // ir.eitaa.ui.ActionIntroActivity.ActionIntroQRLoginDelegate
                public final void didFindQRCode(String str) {
                    this.f$0.lambda$createView$3$SessionsActivity(str);
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
            builder.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$sJxTctDh7IFDoW4JsZQON3gdcu0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$8$SessionsActivity(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
                return;
            }
            return;
        }
        if (((i < this.otherSessionsStartRow || i >= this.otherSessionsEndRow) && (i < this.passwordSessionsStartRow || i >= this.passwordSessionsEndRow)) || getParentActivity() == null) {
            return;
        }
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
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(tLRPC$TL_webAuthorization.bot_id));
            String firstName = user != null ? UserObject.getFirstName(user) : "";
            CheckBoxCell checkBoxCell = new CheckBoxCell(getParentActivity(), 1);
            checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            checkBoxCell.setText(LocaleController.formatString("TerminateWebSessionStop", R.string.TerminateWebSessionStop, firstName), "", false, false);
            checkBoxCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
            frameLayout.addView(checkBoxCell, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
            checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$u8lExWzS9MU2NYBf013Z8WZg7kI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SessionsActivity.lambda$createView$9(zArr, view2);
                }
            });
            builder2.setCustomViewOffset(16);
            builder2.setView(frameLayout);
            string = string3;
        }
        builder2.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$C1B3jI4KIgY5ZQ2focc_GpAnNx8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$createView$14$SessionsActivity(i, zArr, dialogInterface, i2);
            }
        });
        builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate2 = builder2.create();
        showDialog(alertDialogCreate2);
        TextView textView2 = (TextView) alertDialogCreate2.getButton(-1);
        if (textView2 != null) {
            textView2.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$SessionsActivity(String str) {
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.show();
        byte[] bArrDecode = Base64.decode(str.substring(17), 8);
        TLRPC$TL_auth_acceptLoginToken tLRPC$TL_auth_acceptLoginToken = new TLRPC$TL_auth_acceptLoginToken();
        tLRPC$TL_auth_acceptLoginToken.token = bArrDecode;
        getConnectionsManager().sendRequest(tLRPC$TL_auth_acceptLoginToken, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$MntX7_Cef_X4_2WhllFYWDhHSBk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$2$SessionsActivity(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$SessionsActivity(final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$bjVo2fc42usUH5P7uuWlITqHBZg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1$SessionsActivity(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$SessionsActivity(AlertDialog alertDialog, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$_wBDjm9wvUknmtKlYq232nrdKi8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$0$SessionsActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$SessionsActivity(TLRPC$TL_error tLRPC$TL_error) {
        String string;
        if (tLRPC$TL_error.text.equals("AUTH_TOKEN_EXCEPTION")) {
            string = LocaleController.getString("AccountAlreadyLoggedIn", R.string.AccountAlreadyLoggedIn);
        } else {
            string = LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text;
        }
        AlertsCreator.showSimpleAlert(this, LocaleController.getString("AuthAnotherClient", R.string.AuthAnotherClient), string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$SessionsActivity(DialogInterface dialogInterface, int i) {
        if (this.currentType == 0) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_resetAuthorizations
                public static int constructor = -1616179942;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$ZkTryZkcTn8FP0eLqhYp6zJhMHo
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$5$SessionsActivity(tLObject, tLRPC$TL_error);
                }
            });
        } else {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_resetWebAuthorizations
                public static int constructor = 1747789204;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$Ug-Yr7BQW6BKl43bs_k-XEea6po
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$7$SessionsActivity(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$SessionsActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$x-z8bTyeK2JIXLV-2r5SUWfI3_I
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$4$SessionsActivity(tLRPC$TL_error, tLObject);
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
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$SessionsActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (getParentActivity() != null && tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            Toast.makeText(getParentActivity(), LocaleController.getString("TerminateAllSessions", R.string.TerminateAllSessions), 0).show();
            finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$SessionsActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$m02VEOppN55Z3aeLf4uLzmeF-Jo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$6$SessionsActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$SessionsActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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

    static /* synthetic */ void lambda$createView$9(boolean[] zArr, View view) {
        if (view.isEnabled()) {
            zArr[0] = !zArr[0];
            ((CheckBoxCell) view).setChecked(zArr[0], true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$14$SessionsActivity(int i, boolean[] zArr, DialogInterface dialogInterface, int i2) {
        final TLRPC$TL_authorization tLRPC$TL_authorization;
        if (getParentActivity() == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
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
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_resetAuthorization, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$2C9-cpqPKFUFFgepZiLFdjzwoOA
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$11$SessionsActivity(alertDialog, tLRPC$TL_authorization, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        final TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization = (TLRPC$TL_webAuthorization) this.sessions.get(i - this.otherSessionsStartRow);
        TLRPC$TL_account_resetWebAuthorization tLRPC$TL_account_resetWebAuthorization = new TLRPC$TL_account_resetWebAuthorization();
        tLRPC$TL_account_resetWebAuthorization.hash = tLRPC$TL_webAuthorization.hash;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_resetWebAuthorization, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$bDnmFk9sM8nLdn79Cl_wxxDpwzU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$13$SessionsActivity(alertDialog, tLRPC$TL_webAuthorization, tLObject, tLRPC$TL_error);
            }
        });
        if (zArr[0]) {
            MessagesController.getInstance(this.currentAccount).blockPeer(tLRPC$TL_webAuthorization.bot_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$11$SessionsActivity(final AlertDialog alertDialog, final TLRPC$TL_authorization tLRPC$TL_authorization, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$LmMKh00Wn4bfZg-NtFAmErGhvIk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$10$SessionsActivity(alertDialog, tLRPC$TL_error, tLRPC$TL_authorization);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$10$SessionsActivity(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_authorization tLRPC$TL_authorization) {
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
    /* renamed from: lambda$createView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$13$SessionsActivity(final AlertDialog alertDialog, final TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$Hgj-PFKUy-gP-KdG7JCvvMhTO4Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$12$SessionsActivity(alertDialog, tLRPC$TL_error, tLRPC$TL_webAuthorization);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$12$SessionsActivity(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization) {
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

    /* renamed from: ir.eitaa.ui.SessionsActivity$2, reason: invalid class name */
    class AnonymousClass2 extends UndoView {
        AnonymousClass2(Context context) {
            super(context);
        }

        @Override // ir.eitaa.ui.Components.UndoView
        public void hide(boolean apply, int animated) {
            if (!apply) {
                final TLRPC$TL_authorization tLRPC$TL_authorization = (TLRPC$TL_authorization) getCurrentInfoObject();
                TLRPC$TL_account_resetAuthorization tLRPC$TL_account_resetAuthorization = new TLRPC$TL_account_resetAuthorization();
                tLRPC$TL_account_resetAuthorization.hash = tLRPC$TL_authorization.hash;
                ConnectionsManager.getInstance(((BaseFragment) SessionsActivity.this).currentAccount).sendRequest(tLRPC$TL_account_resetAuthorization, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$2$jtTS1W40Wfjfz6dHXh4bWGgC5LM
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$hide$1$SessionsActivity$2(tLRPC$TL_authorization, tLObject, tLRPC$TL_error);
                    }
                });
            }
            super.hide(apply, animated);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$hide$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$hide$1$SessionsActivity$2(final TLRPC$TL_authorization tLRPC$TL_authorization, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$2$44aIKfpKZUemHWh-N433xOX4Vlg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hide$0$SessionsActivity$2(tLRPC$TL_error, tLRPC$TL_authorization);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$hide$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$hide$0$SessionsActivity$2(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_authorization tLRPC$TL_authorization) {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.newSessionReceived) {
            loadSessions(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSessions(boolean silent) {
        if (this.loading) {
            return;
        }
        if (!silent) {
            this.loading = true;
        }
        if (this.currentType == 0) {
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_getAuthorizations
                public static int constructor = -484392616;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$TL_account_authorizations.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$XNpHzEfGYdw1L0JqWiBDRw1DLbw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadSessions$17$SessionsActivity(tLObject, tLRPC$TL_error);
                }
            }), this.classGuid);
        } else {
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_getWebAuthorizations
                public static int constructor = 405695855;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$TL_account_webAuthorizations.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$ncoa0sRqiEbYlUXlnB8TftehW_M
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadSessions$19$SessionsActivity(tLObject, tLRPC$TL_error);
                }
            }), this.classGuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSessions$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSessions$17$SessionsActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$q6uUqnpwiny5RWVI8UT-L17qfT8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSessions$16$SessionsActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSessions$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSessions$16$SessionsActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
            updateRows();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSessions$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSessions$19$SessionsActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$SessionsActivity$lO9e8_RmBlgQU7oW7LpQsDS3EVI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadSessions$18$SessionsActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadSessions$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadSessions$18$SessionsActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
        if (!this.passwordSessions.isEmpty() || !this.sessions.isEmpty()) {
            int i2 = this.rowCount;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.terminateAllSessionsRow = i2;
            this.rowCount = i3 + 1;
            this.terminateAllSessionsDetailRow = i3;
            this.noOtherSessionsRow = -1;
        } else {
            this.terminateAllSessionsRow = -1;
            this.terminateAllSessionsDetailRow = -1;
            if (z) {
                int i4 = this.rowCount;
                this.rowCount = i4 + 1;
                this.qrCodeRow = i4;
            }
            if (this.currentType == 1 || this.currentSession != null) {
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
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
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textSettingsCell;
            if (viewType == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 1) {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            } else if (viewType == 2) {
                textSettingsCell = new HeaderCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 3) {
                textSettingsCell = SessionsActivity.this.emptyLayout;
            } else {
                textSettingsCell = new SessionCell(this.mContext, SessionsActivity.this.currentType);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
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
                        textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
                        textSettingsCell.setTag("windowBackgroundWhiteBlueText4");
                        textSettingsCell.setText(LocaleController.getString("AuthAnotherClient", R.string.AuthAnotherClient), !SessionsActivity.this.sessions.isEmpty());
                        return;
                    }
                    return;
                }
                textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText2"));
                textSettingsCell.setTag("windowBackgroundWhiteRedText2");
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
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    return;
                }
                if (i == SessionsActivity.this.otherSessionsTerminateDetail) {
                    if (SessionsActivity.this.currentType == 0) {
                        if (SessionsActivity.this.sessions.isEmpty()) {
                            textInfoPrivacyCell.setText("");
                        } else {
                            textInfoPrivacyCell.setText(LocaleController.getString("TerminateSessionInfo", R.string.TerminateSessionInfo));
                        }
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("TerminateWebSessionInfo", R.string.TerminateWebSessionInfo));
                    }
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                }
                if (i == SessionsActivity.this.passwordSessionsDetailRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("LoginAttemptsInfo", R.string.LoginAttemptsInfo));
                    if (SessionsActivity.this.otherSessionsTerminateDetail == -1) {
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                        return;
                    } else {
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
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
        public int getItemViewType(int position) {
            if (position == SessionsActivity.this.terminateAllSessionsRow || position == SessionsActivity.this.qrCodeRow) {
                return 0;
            }
            if (position == SessionsActivity.this.terminateAllSessionsDetailRow || position == SessionsActivity.this.otherSessionsTerminateDetail || position == SessionsActivity.this.passwordSessionsDetailRow) {
                return 1;
            }
            if (position == SessionsActivity.this.currentSessionSectionRow || position == SessionsActivity.this.otherSessionsSectionRow || position == SessionsActivity.this.passwordSessionsSectionRow) {
                return 2;
            }
            if (position == SessionsActivity.this.noOtherSessionsRow) {
                return 3;
            }
            if (position == SessionsActivity.this.currentSessionRow) {
                return 4;
            }
            if (position < SessionsActivity.this.otherSessionsStartRow || position >= SessionsActivity.this.otherSessionsEndRow) {
                return (position < SessionsActivity.this.passwordSessionsStartRow || position >= SessionsActivity.this.passwordSessionsEndRow) ? 0 : 4;
            }
            return 4;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, SessionCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.imageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "sessions_devicesImage"));
        arrayList.add(new ThemeDescription(this.textView1, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.textView2, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SessionCell.class}, new String[]{"onlineTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SessionCell.class}, new String[]{"onlineTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"detailTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"detailExTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "undo_background"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText2"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText2"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{UndoView.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        return arrayList;
    }
}
