package ir.eitaa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestTimeDelegate;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ProxyListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int callsDetailRow;
    private int callsRow;
    private int connectionsHeaderRow;
    private int currentConnectionState;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int proxyAddRow;
    private int proxyDetailRow;
    private int proxyEndRow;
    private int proxyStartRow;
    private int rowCount;
    private int useProxyDetailRow;
    private boolean useProxyForCalls;
    private int useProxyRow;
    private boolean useProxySettings;

    public class TextDetailProxyCell extends FrameLayout {
        private Drawable checkDrawable;
        private ImageView checkImageView;
        private int color;
        private SharedConfig.ProxyInfo currentInfo;
        private TextView textView;
        private TextView valueTextView;

        public TextDetailProxyCell(Context context) {
            super(context);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            TextView textView2 = this.textView;
            boolean z = LocaleController.isRTL;
            addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (z ? 5 : 3) | 48, z ? 56 : 21, 10.0f, z ? 21 : 56, 0.0f));
            TextView textView3 = new TextView(context);
            this.valueTextView = textView3;
            textView3.setTextSize(1, 13.0f);
            this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setCompoundDrawablePadding(AndroidUtilities.dp(6.0f));
            this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.valueTextView.setPadding(0, 0, 0, 0);
            TextView textView4 = this.valueTextView;
            boolean z2 = LocaleController.isRTL;
            addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 56 : 21, 35.0f, z2 ? 21 : 56, 0.0f));
            ImageView imageView = new ImageView(context);
            this.checkImageView = imageView;
            imageView.setImageResource(R.drawable.profile_info);
            this.checkImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayText3"), PorterDuff.Mode.MULTIPLY));
            this.checkImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.checkImageView.setContentDescription(LocaleController.getString("Edit", R.string.Edit));
            addView(this.checkImageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 3 : 5) | 48, 8.0f, 8.0f, 8.0f, 0.0f));
            this.checkImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxyListActivity$TextDetailProxyCell$2fGEFZnu64vmIBm88nEBRO6-LT4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$ProxyListActivity$TextDetailProxyCell(view);
                }
            });
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ProxyListActivity$TextDetailProxyCell(View view) {
            ProxyListActivity.this.presentFragment(new ProxySettingsActivity(this.currentInfo));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + 1, 1073741824));
        }

        public void setProxy(SharedConfig.ProxyInfo proxyInfo) {
            this.textView.setText(proxyInfo.address + ":" + proxyInfo.port);
            this.currentInfo = proxyInfo;
        }

        public void updateStatus() {
            String str = "windowBackgroundWhiteGrayText2";
            if (SharedConfig.currentProxy == this.currentInfo && ProxyListActivity.this.useProxySettings) {
                if (ProxyListActivity.this.currentConnectionState == 3 || ProxyListActivity.this.currentConnectionState == 4) {
                    if (this.currentInfo.ping != 0) {
                        this.valueTextView.setText(LocaleController.getString("Connected", R.string.Connected) + ", " + LocaleController.formatString("Ping", R.string.Ping, Long.valueOf(this.currentInfo.ping)));
                    } else {
                        this.valueTextView.setText(LocaleController.getString("Connected", R.string.Connected));
                    }
                    SharedConfig.ProxyInfo proxyInfo = this.currentInfo;
                    if (!proxyInfo.checking && !proxyInfo.available) {
                        proxyInfo.availableCheckTime = 0L;
                    }
                    str = "windowBackgroundWhiteBlueText6";
                } else {
                    this.valueTextView.setText(LocaleController.getString("Connecting", R.string.Connecting));
                }
            } else {
                SharedConfig.ProxyInfo proxyInfo2 = this.currentInfo;
                if (proxyInfo2.checking) {
                    this.valueTextView.setText(LocaleController.getString("Checking", R.string.Checking));
                } else if (proxyInfo2.available) {
                    if (proxyInfo2.ping != 0) {
                        this.valueTextView.setText(LocaleController.getString("Available", R.string.Available) + ", " + LocaleController.formatString("Ping", R.string.Ping, Long.valueOf(this.currentInfo.ping)));
                    } else {
                        this.valueTextView.setText(LocaleController.getString("Available", R.string.Available));
                    }
                    str = "windowBackgroundWhiteGreenText";
                } else {
                    this.valueTextView.setText(LocaleController.getString("Unavailable", R.string.Unavailable));
                    str = "windowBackgroundWhiteRedText4";
                }
            }
            this.color = Theme.getColor(str);
            this.valueTextView.setTag(str);
            this.valueTextView.setTextColor(this.color);
            Drawable drawable = this.checkDrawable;
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(this.color, PorterDuff.Mode.MULTIPLY));
            }
        }

        public void setChecked(boolean checked) {
            if (checked) {
                if (this.checkDrawable == null) {
                    this.checkDrawable = getResources().getDrawable(R.drawable.proxy_check).mutate();
                }
                Drawable drawable = this.checkDrawable;
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(this.color, PorterDuff.Mode.MULTIPLY));
                }
                if (LocaleController.isRTL) {
                    this.valueTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.checkDrawable, (Drawable) null);
                    return;
                } else {
                    this.valueTextView.setCompoundDrawablesWithIntrinsicBounds(this.checkDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    return;
                }
            }
            this.valueTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }

        public void setValue(CharSequence value) {
            this.valueTextView.setText(value);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            updateStatus();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        SharedConfig.loadProxyList();
        this.currentConnectionState = ConnectionsManager.getInstance(this.currentAccount).getConnectionState();
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.proxySettingsChanged);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.proxyCheckDone);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateConnectionState);
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        this.useProxySettings = globalMainSettings.getBoolean("proxy_enabled", false) && !SharedConfig.proxyList.isEmpty();
        this.useProxyForCalls = globalMainSettings.getBoolean("proxy_enabled_calls", false);
        updateRows(true);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.proxySettingsChanged);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.proxyCheckDone);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateConnectionState);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("ProxySettings", R.string.ProxySettings));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ProxyListActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ProxyListActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        ((DefaultItemAnimator) recyclerListView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxyListActivity$hpq1k_gAQkobnF8K99IsnsDH804
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0$ProxyListActivity(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxyListActivity$aWMhRgMkALiLHQUMP3-VXMcuUIs
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$2$ProxyListActivity(view, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$ProxyListActivity(View view, int i) {
        if (i == this.useProxyRow) {
            if (SharedConfig.currentProxy == null) {
                if (!SharedConfig.proxyList.isEmpty()) {
                    SharedConfig.currentProxy = SharedConfig.proxyList.get(0);
                    if (!this.useProxySettings) {
                        MessagesController.getGlobalMainSettings();
                        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
                        editorEdit.putString("proxy_ip", SharedConfig.currentProxy.address);
                        editorEdit.putString("proxy_pass", SharedConfig.currentProxy.password);
                        editorEdit.putString("proxy_user", SharedConfig.currentProxy.username);
                        editorEdit.putInt("proxy_port", SharedConfig.currentProxy.port);
                        editorEdit.putString("proxy_secret", SharedConfig.currentProxy.secret);
                        editorEdit.commit();
                    }
                } else {
                    presentFragment(new ProxySettingsActivity());
                    return;
                }
            }
            this.useProxySettings = !this.useProxySettings;
            MessagesController.getGlobalMainSettings();
            ((TextCheckCell) view).setChecked(this.useProxySettings);
            if (!this.useProxySettings) {
                RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(this.callsRow);
                if (holder != null) {
                    ((TextCheckCell) holder.itemView).setChecked(false);
                }
                this.useProxyForCalls = false;
            }
            SharedPreferences.Editor editorEdit2 = MessagesController.getGlobalMainSettings().edit();
            editorEdit2.putBoolean("proxy_enabled", this.useProxySettings);
            editorEdit2.commit();
            boolean z = this.useProxySettings;
            SharedConfig.ProxyInfo proxyInfo = SharedConfig.currentProxy;
            ConnectionsManager.setProxySettings(z, proxyInfo.address, proxyInfo.port, proxyInfo.username, proxyInfo.password, proxyInfo.secret);
            NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
            int i2 = NotificationCenter.proxySettingsChanged;
            globalInstance.removeObserver(this, i2);
            NotificationCenter.getGlobalInstance().postNotificationName(i2, new Object[0]);
            NotificationCenter.getGlobalInstance().addObserver(this, i2);
            for (int i3 = this.proxyStartRow; i3 < this.proxyEndRow; i3++) {
                RecyclerListView.Holder holder2 = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(i3);
                if (holder2 != null) {
                    ((TextDetailProxyCell) holder2.itemView).updateStatus();
                }
            }
            return;
        }
        if (i == this.callsRow) {
            boolean z2 = !this.useProxyForCalls;
            this.useProxyForCalls = z2;
            ((TextCheckCell) view).setChecked(z2);
            SharedPreferences.Editor editorEdit3 = MessagesController.getGlobalMainSettings().edit();
            editorEdit3.putBoolean("proxy_enabled_calls", this.useProxyForCalls);
            editorEdit3.commit();
            return;
        }
        int i4 = this.proxyStartRow;
        if (i >= i4 && i < this.proxyEndRow) {
            SharedConfig.ProxyInfo proxyInfo2 = SharedConfig.proxyList.get(i - i4);
            this.useProxySettings = true;
            SharedPreferences.Editor editorEdit4 = MessagesController.getGlobalMainSettings().edit();
            editorEdit4.putString("proxy_ip", proxyInfo2.address);
            editorEdit4.putString("proxy_pass", proxyInfo2.password);
            editorEdit4.putString("proxy_user", proxyInfo2.username);
            editorEdit4.putInt("proxy_port", proxyInfo2.port);
            editorEdit4.putString("proxy_secret", proxyInfo2.secret);
            editorEdit4.putBoolean("proxy_enabled", this.useProxySettings);
            if (!proxyInfo2.secret.isEmpty()) {
                this.useProxyForCalls = false;
                editorEdit4.putBoolean("proxy_enabled_calls", false);
            }
            editorEdit4.commit();
            SharedConfig.currentProxy = proxyInfo2;
            for (int i5 = this.proxyStartRow; i5 < this.proxyEndRow; i5++) {
                RecyclerListView.Holder holder3 = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(i5);
                if (holder3 != null) {
                    TextDetailProxyCell textDetailProxyCell = (TextDetailProxyCell) holder3.itemView;
                    textDetailProxyCell.setChecked(textDetailProxyCell.currentInfo == proxyInfo2);
                    textDetailProxyCell.updateStatus();
                }
            }
            updateRows(false);
            RecyclerListView.Holder holder4 = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(this.useProxyRow);
            if (holder4 != null) {
                ((TextCheckCell) holder4.itemView).setChecked(true);
            }
            boolean z3 = this.useProxySettings;
            SharedConfig.ProxyInfo proxyInfo3 = SharedConfig.currentProxy;
            ConnectionsManager.setProxySettings(z3, proxyInfo3.address, proxyInfo3.port, proxyInfo3.username, proxyInfo3.password, proxyInfo3.secret);
            return;
        }
        if (i == this.proxyAddRow) {
            presentFragment(new ProxySettingsActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$2$ProxyListActivity(View view, final int i) {
        int i2 = this.proxyStartRow;
        if (i < i2 || i >= this.proxyEndRow) {
            return false;
        }
        final SharedConfig.ProxyInfo proxyInfo = SharedConfig.proxyList.get(i - i2);
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setMessage(LocaleController.getString("DeleteProxy", R.string.DeleteProxy));
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxyListActivity$MrC7mrUC0hKgiHqvsL0hohj2dzc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f$0.lambda$createView$1$ProxyListActivity(proxyInfo, i, dialogInterface, i3);
            }
        });
        showDialog(builder.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$ProxyListActivity(SharedConfig.ProxyInfo proxyInfo, int i, DialogInterface dialogInterface, int i2) {
        SharedConfig.deleteProxy(proxyInfo);
        if (SharedConfig.currentProxy == null) {
            this.useProxyForCalls = false;
            this.useProxySettings = false;
        }
        NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
        int i3 = NotificationCenter.proxySettingsChanged;
        globalInstance.removeObserver(this, i3);
        NotificationCenter.getGlobalInstance().postNotificationName(i3, new Object[0]);
        NotificationCenter.getGlobalInstance().addObserver(this, i3);
        updateRows(false);
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyItemRemoved(i);
            if (SharedConfig.currentProxy == null) {
                this.listAdapter.notifyItemChanged(this.useProxyRow, 0);
                this.listAdapter.notifyItemChanged(this.callsRow, 0);
            }
        }
    }

    private void updateRows(boolean notify) {
        boolean z;
        ListAdapter listAdapter;
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.useProxyDetailRow = 0;
        this.rowCount = i + 1;
        this.connectionsHeaderRow = i;
        if (!SharedConfig.proxyList.isEmpty()) {
            int i2 = this.rowCount;
            this.proxyStartRow = i2;
            int size = i2 + SharedConfig.proxyList.size();
            this.rowCount = size;
            this.proxyEndRow = size;
        } else {
            this.proxyStartRow = -1;
            this.proxyEndRow = -1;
        }
        int i3 = this.rowCount;
        this.rowCount = i3 + 1;
        this.proxyDetailRow = i3;
        SharedConfig.ProxyInfo proxyInfo = SharedConfig.currentProxy;
        if (proxyInfo == null || proxyInfo.secret.isEmpty()) {
            z = this.callsRow == -1;
            int i4 = this.rowCount;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.callsRow = i4;
            this.rowCount = i5 + 1;
            this.callsDetailRow = i5;
            if (!notify && z) {
                this.listAdapter.notifyItemChanged(this.proxyDetailRow);
                this.listAdapter.notifyItemRangeInserted(this.proxyDetailRow + 1, 2);
            }
        } else {
            z = this.callsRow != -1;
            this.callsRow = -1;
            this.callsDetailRow = -1;
            if (!notify && z) {
                this.listAdapter.notifyItemChanged(this.proxyDetailRow);
                this.listAdapter.notifyItemRangeRemoved(this.proxyDetailRow + 1, 2);
            }
        }
        checkProxyList();
        if (!notify || (listAdapter = this.listAdapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    private void checkProxyList() {
        int size = SharedConfig.proxyList.size();
        for (int i = 0; i < size; i++) {
            final SharedConfig.ProxyInfo proxyInfo = SharedConfig.proxyList.get(i);
            if (!proxyInfo.checking && SystemClock.elapsedRealtime() - proxyInfo.availableCheckTime >= 120000) {
                proxyInfo.checking = true;
                proxyInfo.proxyCheckPingId = ConnectionsManager.getInstance(this.currentAccount).checkProxy(proxyInfo.address, proxyInfo.port, proxyInfo.username, proxyInfo.password, proxyInfo.secret, new RequestTimeDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProxyListActivity$cfhFMmnk6OcrXSFU9mSocJ_g3C4
                    @Override // ir.eitaa.tgnet.RequestTimeDelegate
                    public final void run(long j) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProxyListActivity$sPMsBIbTAZwghNEBQ4_GjuejVuc
                            @Override // java.lang.Runnable
                            public final void run() {
                                ProxyListActivity.lambda$checkProxyList$3(proxyInfo, j);
                            }
                        });
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$checkProxyList$3(SharedConfig.ProxyInfo proxyInfo, long j) {
        proxyInfo.availableCheckTime = SystemClock.elapsedRealtime();
        proxyInfo.checking = false;
        if (j == -1) {
            proxyInfo.available = false;
            proxyInfo.ping = 0L;
        } else {
            proxyInfo.ping = j;
            proxyInfo.available = true;
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.proxyCheckDone, proxyInfo);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
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
        RecyclerListView.Holder holder;
        int iIndexOf;
        RecyclerListView.Holder holder2;
        if (id == NotificationCenter.proxySettingsChanged) {
            updateRows(true);
            return;
        }
        if (id == NotificationCenter.didUpdateConnectionState) {
            int connectionState = ConnectionsManager.getInstance(account).getConnectionState();
            if (this.currentConnectionState != connectionState) {
                this.currentConnectionState = connectionState;
                if (this.listView == null || SharedConfig.currentProxy == null || (iIndexOf = SharedConfig.proxyList.indexOf(SharedConfig.currentProxy)) < 0 || (holder2 = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(iIndexOf + this.proxyStartRow)) == null) {
                    return;
                }
                ((TextDetailProxyCell) holder2.itemView).updateStatus();
                return;
            }
            return;
        }
        if (id != NotificationCenter.proxyCheckDone || this.listView == null) {
            return;
        }
        int iIndexOf2 = SharedConfig.proxyList.indexOf((SharedConfig.ProxyInfo) args[0]);
        if (iIndexOf2 < 0 || (holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(iIndexOf2 + this.proxyStartRow)) == null) {
            return;
        }
        ((TextDetailProxyCell) holder.itemView).updateStatus();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProxyListActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                if (position == ProxyListActivity.this.proxyDetailRow && ProxyListActivity.this.callsRow == -1) {
                    holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                } else {
                    holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    return;
                }
            }
            if (itemViewType == 1) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                if (position == ProxyListActivity.this.proxyAddRow) {
                    textSettingsCell.setText(LocaleController.getString("AddProxy", R.string.AddProxy), false);
                    return;
                }
                return;
            }
            if (itemViewType == 2) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position == ProxyListActivity.this.connectionsHeaderRow) {
                    headerCell.setText(LocaleController.getString("ProxyConnections", R.string.ProxyConnections));
                    return;
                }
                return;
            }
            if (itemViewType == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                if (position == ProxyListActivity.this.useProxyRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("UseProxySettings", R.string.UseProxySettings), ProxyListActivity.this.useProxySettings, false);
                    return;
                } else {
                    if (position == ProxyListActivity.this.callsRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("UseProxyForCalls", R.string.UseProxyForCalls), ProxyListActivity.this.useProxyForCalls, false);
                        return;
                    }
                    return;
                }
            }
            if (itemViewType == 4) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position == ProxyListActivity.this.callsDetailRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("UseProxyForCallsInfo", R.string.UseProxyForCallsInfo));
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                }
                return;
            }
            if (itemViewType != 5) {
                return;
            }
            TextDetailProxyCell textDetailProxyCell = (TextDetailProxyCell) holder.itemView;
            SharedConfig.ProxyInfo proxyInfo = SharedConfig.proxyList.get(position - ProxyListActivity.this.proxyStartRow);
            textDetailProxyCell.setProxy(proxyInfo);
            textDetailProxyCell.setChecked(SharedConfig.currentProxy == proxyInfo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
            if (holder.getItemViewType() == 3 && payloads.contains(0)) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                if (position == ProxyListActivity.this.useProxyRow) {
                    textCheckCell.setChecked(ProxyListActivity.this.useProxySettings);
                    return;
                } else {
                    if (position == ProxyListActivity.this.callsRow) {
                        textCheckCell.setChecked(ProxyListActivity.this.useProxyForCalls);
                        return;
                    }
                    return;
                }
            }
            super.onBindViewHolder(holder, position, payloads);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition == ProxyListActivity.this.useProxyRow) {
                    textCheckCell.setChecked(ProxyListActivity.this.useProxySettings);
                } else if (adapterPosition == ProxyListActivity.this.callsRow) {
                    textCheckCell.setChecked(ProxyListActivity.this.useProxyForCalls);
                }
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return adapterPosition == ProxyListActivity.this.useProxyRow || adapterPosition == ProxyListActivity.this.callsRow || adapterPosition == ProxyListActivity.this.proxyAddRow || (adapterPosition >= ProxyListActivity.this.proxyStartRow && adapterPosition < ProxyListActivity.this.proxyEndRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View shadowSectionCell;
            if (viewType == 0) {
                shadowSectionCell = new ShadowSectionCell(this.mContext);
            } else if (viewType == 1) {
                shadowSectionCell = new TextSettingsCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 2) {
                shadowSectionCell = new HeaderCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 3) {
                shadowSectionCell = new TextCheckCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 4) {
                shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
            } else {
                shadowSectionCell = ProxyListActivity.this.new TextDetailProxyCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == ProxyListActivity.this.useProxyDetailRow || position == ProxyListActivity.this.proxyDetailRow) {
                return 0;
            }
            if (position == ProxyListActivity.this.proxyAddRow) {
                return 1;
            }
            if (position == ProxyListActivity.this.useProxyRow || position == ProxyListActivity.this.callsRow) {
                return 3;
            }
            if (position == ProxyListActivity.this.connectionsHeaderRow) {
                return 2;
            }
            return (position < ProxyListActivity.this.proxyStartRow || position >= ProxyListActivity.this.proxyEndRow) ? 4 : 5;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, TextCheckCell.class, HeaderCell.class, TextDetailProxyCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailProxyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText6"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGreenText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"checkImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        return arrayList;
    }
}
