package org.rbmain.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class ProxyListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int callsDetailRow;
    private int callsRow;
    private int connectionsHeaderRow;
    private int currentConnectionState;
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

    private void checkProxyList() {
    }

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
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
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
            this.checkImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3), PorterDuff.Mode.MULTIPLY));
            this.checkImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.checkImageView.setContentDescription(LocaleController.getString("Edit", R.string.Edit));
            addView(this.checkImageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 3 : 5) | 48, 8.0f, 8.0f, 8.0f, 0.0f));
            this.checkImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ProxyListActivity$TextDetailProxyCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            ProxyListActivity.this.presentFragment(new ProxySettingsActivity(this.currentInfo));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + 1, 1073741824));
        }

        public void setProxy(SharedConfig.ProxyInfo proxyInfo) {
            this.textView.setText(proxyInfo.address + ":" + proxyInfo.port);
            this.currentInfo = proxyInfo;
        }

        public void updateStatus() {
            int i;
            if (SharedConfig.currentProxy == this.currentInfo && ProxyListActivity.this.useProxySettings) {
                if (ProxyListActivity.this.currentConnectionState == 3 || ProxyListActivity.this.currentConnectionState == 5) {
                    i = Theme.key_windowBackgroundWhiteBlueText6;
                    if (this.currentInfo.ping != 0) {
                        this.valueTextView.setText(LocaleController.getString("Connected", R.string.Connected) + ", " + LocaleController.formatString("Ping", R.string.Ping, Long.valueOf(this.currentInfo.ping)));
                    } else {
                        this.valueTextView.setText(LocaleController.getString("Connected", R.string.Connected));
                    }
                    SharedConfig.ProxyInfo proxyInfo = this.currentInfo;
                    if (!proxyInfo.checking && !proxyInfo.available) {
                        proxyInfo.availableCheckTime = 0L;
                    }
                } else {
                    i = Theme.key_windowBackgroundWhiteGrayText2;
                    this.valueTextView.setText(LocaleController.getString("Connecting", R.string.Connecting));
                }
            } else {
                SharedConfig.ProxyInfo proxyInfo2 = this.currentInfo;
                if (proxyInfo2.checking) {
                    this.valueTextView.setText(LocaleController.getString("Checking", R.string.Checking));
                    i = Theme.key_windowBackgroundWhiteGrayText2;
                } else if (proxyInfo2.available) {
                    if (proxyInfo2.ping != 0) {
                        this.valueTextView.setText(LocaleController.getString("Available", R.string.Available) + ", " + LocaleController.formatString("Ping", R.string.Ping, Long.valueOf(this.currentInfo.ping)));
                    } else {
                        this.valueTextView.setText(LocaleController.getString("Available", R.string.Available));
                    }
                    i = Theme.key_windowBackgroundWhiteGreenText;
                } else {
                    this.valueTextView.setText(LocaleController.getString("Unavailable", R.string.Unavailable));
                    i = Theme.key_text_RedRegular;
                }
            }
            this.color = Theme.getColor(i);
            this.valueTextView.setTag(Integer.valueOf(i));
            this.valueTextView.setTextColor(this.color);
            Drawable drawable = this.checkDrawable;
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(this.color, PorterDuff.Mode.MULTIPLY));
            }
        }

        public void setChecked(boolean z) {
            if (z) {
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

        public void setValue(CharSequence charSequence) {
            this.valueTextView.setText(charSequence);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.proxySettingsChanged);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.proxyCheckDone);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateConnectionState);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("ProxySettings", R.string.ProxySettings));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ProxyListActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ProxyListActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        ((DefaultItemAnimator) recyclerListView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ProxyListActivity$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.ProxyListActivity$$ExternalSyntheticLambda2
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$2(view, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
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
                        editorEdit.apply();
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
            editorEdit2.apply();
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
            editorEdit3.apply();
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
            editorEdit4.apply();
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
    public /* synthetic */ boolean lambda$createView$2(View view, final int i) {
        int i2 = this.proxyStartRow;
        if (i < i2 || i >= this.proxyEndRow) {
            return false;
        }
        final SharedConfig.ProxyInfo proxyInfo = SharedConfig.proxyList.get(i - i2);
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setMessage(LocaleController.getString("DeleteProxy", R.string.DeleteProxy));
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProxyListActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f$0.lambda$createView$1(proxyInfo, i, dialogInterface, i3);
            }
        });
        showDialog(builder.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(SharedConfig.ProxyInfo proxyInfo, int i, DialogInterface dialogInterface, int i2) {
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

    private void updateRows(boolean z) {
        boolean z2;
        ListAdapter listAdapter;
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.useProxyRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.useProxyDetailRow = i;
        this.rowCount = i2 + 1;
        this.connectionsHeaderRow = i2;
        if (!SharedConfig.proxyList.isEmpty()) {
            int i3 = this.rowCount;
            this.proxyStartRow = i3;
            int size = i3 + SharedConfig.proxyList.size();
            this.rowCount = size;
            this.proxyEndRow = size;
        } else {
            this.proxyStartRow = -1;
            this.proxyEndRow = -1;
        }
        int i4 = this.rowCount;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.proxyAddRow = i4;
        this.rowCount = i5 + 1;
        this.proxyDetailRow = i5;
        SharedConfig.ProxyInfo proxyInfo = SharedConfig.currentProxy;
        if (proxyInfo == null || proxyInfo.secret.isEmpty()) {
            z2 = this.callsRow == -1;
            int i6 = this.rowCount;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.callsRow = i6;
            this.rowCount = i7 + 1;
            this.callsDetailRow = i7;
            if (!z && z2) {
                this.listAdapter.notifyItemChanged(this.proxyDetailRow);
                this.listAdapter.notifyItemRangeInserted(this.proxyDetailRow + 1, 2);
            }
        } else {
            z2 = this.callsRow != -1;
            this.callsRow = -1;
            this.callsDetailRow = -1;
            if (!z && z2) {
                this.listAdapter.notifyItemChanged(this.proxyDetailRow);
                this.listAdapter.notifyItemRangeRemoved(this.proxyDetailRow + 1, 2);
            }
        }
        checkProxyList();
        if (!z || (listAdapter = this.listAdapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
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
        RecyclerListView.Holder holder;
        int iIndexOf;
        RecyclerListView.Holder holder2;
        if (i == NotificationCenter.proxySettingsChanged) {
            updateRows(true);
            return;
        }
        if (i == NotificationCenter.didUpdateConnectionState) {
            int connectionState = ConnectionsManager.getInstance(i2).getConnectionState();
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
        if (i != NotificationCenter.proxyCheckDone || this.listView == null) {
            return;
        }
        int iIndexOf2 = SharedConfig.proxyList.indexOf((SharedConfig.ProxyInfo) objArr[0]);
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
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                if (i == ProxyListActivity.this.proxyDetailRow && ProxyListActivity.this.callsRow == -1) {
                    viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                } else {
                    viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
            }
            if (itemViewType == 1) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                textSettingsCell.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
                if (i == ProxyListActivity.this.proxyAddRow) {
                    textSettingsCell.setText(LocaleController.getString("AddProxy", R.string.AddProxy), false);
                    return;
                }
                return;
            }
            if (itemViewType == 2) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i == ProxyListActivity.this.connectionsHeaderRow) {
                    headerCell.setText(LocaleController.getString("ProxyConnections", R.string.ProxyConnections));
                    return;
                }
                return;
            }
            if (itemViewType == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                if (i == ProxyListActivity.this.useProxyRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("UseProxySettings", R.string.UseProxySettings), ProxyListActivity.this.useProxySettings, false);
                    return;
                } else {
                    if (i == ProxyListActivity.this.callsRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("UseProxyForCalls", R.string.UseProxyForCalls), ProxyListActivity.this.useProxyForCalls, false);
                        return;
                    }
                    return;
                }
            }
            if (itemViewType == 4) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i == ProxyListActivity.this.callsDetailRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("UseProxyForCallsInfo", R.string.UseProxyForCallsInfo));
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
                return;
            }
            if (itemViewType != 5) {
                return;
            }
            TextDetailProxyCell textDetailProxyCell = (TextDetailProxyCell) viewHolder.itemView;
            SharedConfig.ProxyInfo proxyInfo = SharedConfig.proxyList.get(i - ProxyListActivity.this.proxyStartRow);
            textDetailProxyCell.setProxy(proxyInfo);
            textDetailProxyCell.setChecked(SharedConfig.currentProxy == proxyInfo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
            if (viewHolder.getItemViewType() == 3 && list.contains(0)) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                if (i == ProxyListActivity.this.useProxyRow) {
                    textCheckCell.setChecked(ProxyListActivity.this.useProxySettings);
                    return;
                } else {
                    if (i == ProxyListActivity.this.callsRow) {
                        textCheckCell.setChecked(ProxyListActivity.this.useProxyForCalls);
                        return;
                    }
                    return;
                }
            }
            super.onBindViewHolder(viewHolder, i, list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                int adapterPosition = viewHolder.getAdapterPosition();
                if (adapterPosition == ProxyListActivity.this.useProxyRow) {
                    textCheckCell.setChecked(ProxyListActivity.this.useProxySettings);
                } else if (adapterPosition == ProxyListActivity.this.callsRow) {
                    textCheckCell.setChecked(ProxyListActivity.this.useProxyForCalls);
                }
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == ProxyListActivity.this.useProxyRow || adapterPosition == ProxyListActivity.this.callsRow || adapterPosition == ProxyListActivity.this.proxyAddRow || (adapterPosition >= ProxyListActivity.this.proxyStartRow && adapterPosition < ProxyListActivity.this.proxyEndRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shadowSectionCell;
            if (i == 0) {
                shadowSectionCell = new ShadowSectionCell(this.mContext);
            } else if (i == 1) {
                shadowSectionCell = new TextSettingsCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 2) {
                shadowSectionCell = new HeaderCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 3) {
                shadowSectionCell = new TextCheckCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 4) {
                shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
            } else if (i != 5) {
                shadowSectionCell = null;
            } else {
                shadowSectionCell = ProxyListActivity.this.new TextDetailProxyCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ProxyListActivity.this.useProxyDetailRow || i == ProxyListActivity.this.proxyDetailRow) {
                return 0;
            }
            if (i == ProxyListActivity.this.proxyAddRow) {
                return 1;
            }
            if (i == ProxyListActivity.this.useProxyRow || i == ProxyListActivity.this.callsRow) {
                return 3;
            }
            if (i == ProxyListActivity.this.connectionsHeaderRow) {
                return 2;
            }
            return (i < ProxyListActivity.this.proxyStartRow || i >= ProxyListActivity.this.proxyEndRow) ? 4 : 5;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, TextCheckCell.class, HeaderCell.class, TextDetailProxyCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
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
        int i3 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i3));
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailProxyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText6));
        int i5 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGreenText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_text_RedRegular));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailProxyCell.class}, new String[]{"checkImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        return arrayList;
    }
}
