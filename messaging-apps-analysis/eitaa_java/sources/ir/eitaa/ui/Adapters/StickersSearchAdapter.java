package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_foundStickerSets;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_searchStickerSets;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickers;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell;
import ir.eitaa.ui.Cells.StickerEmojiCell;
import ir.eitaa.ui.Cells.StickerSetNameCell;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class StickersSearchAdapter extends RecyclerListView.SelectionAdapter {
    boolean cleared;
    private final Context context;
    private final Delegate delegate;
    private int emojiSearchId;
    private ImageView emptyImageView;
    private TextView emptyTextView;
    private final LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets;
    private final TLRPC$StickerSetCovered[] primaryInstallingStickerSets;
    private final LongSparseArray<TLRPC$StickerSetCovered> removingStickerSets;
    private int reqId;
    private int reqId2;
    private final Theme.ResourcesProvider resourcesProvider;
    private String searchQuery;
    private int totalItems;
    private final int currentAccount = UserConfig.selectedAccount;
    private SparseArray<Object> rowStartPack = new SparseArray<>();
    private SparseArray<Object> cache = new SparseArray<>();
    private SparseArray<Object> cacheParent = new SparseArray<>();
    private SparseIntArray positionToRow = new SparseIntArray();
    private SparseArray<String> positionToEmoji = new SparseArray<>();
    private ArrayList<TLRPC$StickerSetCovered> serverPacks = new ArrayList<>();
    private ArrayList<TLRPC$TL_messages_stickerSet> localPacks = new ArrayList<>();
    private HashMap<TLRPC$TL_messages_stickerSet, Boolean> localPacksByShortName = new HashMap<>();
    private HashMap<TLRPC$TL_messages_stickerSet, Integer> localPacksByName = new HashMap<>();
    private HashMap<ArrayList<TLRPC$Document>, String> emojiStickers = new HashMap<>();
    private ArrayList<ArrayList<TLRPC$Document>> emojiArrays = new ArrayList<>();
    private SparseArray<TLRPC$StickerSetCovered> positionsToSets = new SparseArray<>();
    private Runnable searchRunnable = new AnonymousClass1();

    public interface Delegate {
        String[] getLastSearchKeyboardLanguage();

        int getStickersPerRow();

        void onSearchStart();

        void onSearchStop();

        void onStickerSetAdd(TLRPC$StickerSetCovered stickerSet, boolean primary);

        void onStickerSetRemove(TLRPC$StickerSetCovered stickerSet);

        void setAdapterVisible(boolean visible);

        void setLastSearchKeyboardLanguage(String[] language);
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        return false;
    }

    static /* synthetic */ int access$804(StickersSearchAdapter stickersSearchAdapter) {
        int i = stickersSearchAdapter.emojiSearchId + 1;
        stickersSearchAdapter.emojiSearchId = i;
        return i;
    }

    /* renamed from: ir.eitaa.ui.Adapters.StickersSearchAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        private void clear() {
            StickersSearchAdapter stickersSearchAdapter = StickersSearchAdapter.this;
            if (stickersSearchAdapter.cleared) {
                return;
            }
            stickersSearchAdapter.cleared = true;
            stickersSearchAdapter.emojiStickers.clear();
            StickersSearchAdapter.this.emojiArrays.clear();
            StickersSearchAdapter.this.localPacks.clear();
            StickersSearchAdapter.this.serverPacks.clear();
            StickersSearchAdapter.this.localPacksByShortName.clear();
            StickersSearchAdapter.this.localPacksByName.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x00cf A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 787
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.StickersSearchAdapter.AnonymousClass1.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$StickersSearchAdapter$1(int i, HashMap map, ArrayList arrayList, String str) {
            if (i != StickersSearchAdapter.this.emojiSearchId) {
                return;
            }
            int size = arrayList.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = ((MediaDataController.KeywordResult) arrayList.get(i2)).emoji;
                ArrayList arrayList2 = map != null ? (ArrayList) map.get(str2) : null;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    clear();
                    if (!StickersSearchAdapter.this.emojiStickers.containsKey(arrayList2)) {
                        StickersSearchAdapter.this.emojiStickers.put(arrayList2, str2);
                        StickersSearchAdapter.this.emojiArrays.add(arrayList2);
                        z = true;
                    }
                }
            }
            if (z) {
                StickersSearchAdapter.this.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$2$StickersSearchAdapter$1(final TLRPC$TL_messages_searchStickerSets tLRPC$TL_messages_searchStickerSets, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject instanceof TLRPC$TL_messages_foundStickerSets) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$StickersSearchAdapter$1$hN_ltKA8gir9lI62cKjjxlONLWc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$1$StickersSearchAdapter$1(tLRPC$TL_messages_searchStickerSets, tLObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$StickersSearchAdapter$1(TLRPC$TL_messages_searchStickerSets tLRPC$TL_messages_searchStickerSets, TLObject tLObject) {
            if (tLRPC$TL_messages_searchStickerSets.q.equals(StickersSearchAdapter.this.searchQuery)) {
                clear();
                StickersSearchAdapter.this.delegate.onSearchStop();
                StickersSearchAdapter.this.reqId = 0;
                StickersSearchAdapter.this.delegate.setAdapterVisible(true);
                StickersSearchAdapter.this.serverPacks.addAll(((TLRPC$TL_messages_foundStickerSets) tLObject).sets);
                StickersSearchAdapter.this.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$4$StickersSearchAdapter$1(final TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, final ArrayList arrayList, final LongSparseArray longSparseArray, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$StickersSearchAdapter$1$bvGaYlUCkadtrJ8BHjG5kQD6rgE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$3$StickersSearchAdapter$1(tLRPC$TL_messages_getStickers, tLObject, arrayList, longSparseArray);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$3$StickersSearchAdapter$1(TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, TLObject tLObject, ArrayList arrayList, LongSparseArray longSparseArray) {
            if (tLRPC$TL_messages_getStickers.emoticon.equals(StickersSearchAdapter.this.searchQuery)) {
                StickersSearchAdapter.this.reqId2 = 0;
                if (tLObject instanceof TLRPC$TL_messages_stickers) {
                    TLRPC$TL_messages_stickers tLRPC$TL_messages_stickers = (TLRPC$TL_messages_stickers) tLObject;
                    int size = arrayList.size();
                    int size2 = tLRPC$TL_messages_stickers.stickers.size();
                    for (int i = 0; i < size2; i++) {
                        TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickers.stickers.get(i);
                        if (longSparseArray.indexOfKey(tLRPC$Document.id) < 0) {
                            arrayList.add(tLRPC$Document);
                        }
                    }
                    if (size != arrayList.size()) {
                        StickersSearchAdapter.this.emojiStickers.put(arrayList, StickersSearchAdapter.this.searchQuery);
                        if (size == 0) {
                            StickersSearchAdapter.this.emojiArrays.add(arrayList);
                        }
                        StickersSearchAdapter.this.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public StickersSearchAdapter(Context context, Delegate delegate, TLRPC$StickerSetCovered[] primaryInstallingStickerSets, LongSparseArray<TLRPC$StickerSetCovered> installingStickerSets, LongSparseArray<TLRPC$StickerSetCovered> removingStickerSets, Theme.ResourcesProvider resourcesProvider) {
        this.context = context;
        this.delegate = delegate;
        this.primaryInstallingStickerSets = primaryInstallingStickerSets;
        this.installingStickerSets = installingStickerSets;
        this.removingStickerSets = removingStickerSets;
        this.resourcesProvider = resourcesProvider;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(1, this.totalItems + 1);
    }

    public void search(String text) {
        if (this.reqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
            this.reqId = 0;
        }
        if (this.reqId2 != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId2, true);
            this.reqId2 = 0;
        }
        if (TextUtils.isEmpty(text)) {
            this.searchQuery = null;
            this.localPacks.clear();
            this.emojiStickers.clear();
            this.serverPacks.clear();
            this.delegate.setAdapterVisible(false);
            notifyDataSetChanged();
        } else {
            this.searchQuery = text.toLowerCase();
        }
        AndroidUtilities.cancelRunOnUIThread(this.searchRunnable);
        AndroidUtilities.runOnUIThread(this.searchRunnable, 300L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0 && this.totalItems == 0) {
            return 5;
        }
        if (position == getItemCount() - 1) {
            return 4;
        }
        Object obj = this.cache.get(position);
        if (obj == null) {
            return 1;
        }
        if (obj instanceof TLRPC$Document) {
            return 0;
        }
        return obj instanceof TLRPC$StickerSetCovered ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreateViewHolder$0$StickersSearchAdapter(View view) {
        FeaturedStickerSetInfoCell featuredStickerSetInfoCell = (FeaturedStickerSetInfoCell) view.getParent();
        TLRPC$StickerSetCovered stickerSet = featuredStickerSetInfoCell.getStickerSet();
        if (stickerSet == null || this.installingStickerSets.indexOfKey(stickerSet.set.id) >= 0 || this.removingStickerSets.indexOfKey(stickerSet.set.id) >= 0) {
            return;
        }
        if (featuredStickerSetInfoCell.isInstalled()) {
            this.removingStickerSets.put(stickerSet.set.id, stickerSet);
            this.delegate.onStickerSetRemove(featuredStickerSetInfoCell.getStickerSet());
        } else {
            installStickerSet(stickerSet, featuredStickerSetInfoCell);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r8v8, types: [android.view.View] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FrameLayout emptyCell;
        boolean z = false;
        if (i == 0) {
            StickerEmojiCell stickerEmojiCell = new StickerEmojiCell(this.context, z) { // from class: ir.eitaa.ui.Adapters.StickersSearchAdapter.2
                @Override // android.widget.FrameLayout, android.view.View
                public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                }
            };
            stickerEmojiCell.getImageView().setLayerNum(3);
            emptyCell = stickerEmojiCell;
        } else if (i == 1) {
            emptyCell = new EmptyCell(this.context);
        } else if (i == 2) {
            emptyCell = new StickerSetNameCell(this.context, false, true, this.resourcesProvider);
        } else if (i == 3) {
            FeaturedStickerSetInfoCell featuredStickerSetInfoCell = new FeaturedStickerSetInfoCell(this.context, 17, true, true, this.resourcesProvider);
            featuredStickerSetInfoCell.setAddOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$StickersSearchAdapter$9B0xbHOgoUROG57mLveihRoQMc0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreateViewHolder$0$StickersSearchAdapter(view);
                }
            });
            emptyCell = featuredStickerSetInfoCell;
        } else if (i == 4) {
            emptyCell = new View(this.context);
        } else if (i != 5) {
            emptyCell = null;
        } else {
            ?? linearLayout = new LinearLayout(this.context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            ImageView imageView = new ImageView(this.context);
            this.emptyImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.emptyImageView.setImageResource(R.drawable.stickers_empty);
            this.emptyImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelEmptyText"), PorterDuff.Mode.MULTIPLY));
            linearLayout.addView(this.emptyImageView, LayoutHelper.createLinear(-2, -2));
            linearLayout.addView(new Space(this.context), LayoutHelper.createLinear(-1, 15));
            TextView textView = new TextView(this.context);
            this.emptyTextView = textView;
            textView.setText(LocaleController.getString("NoStickersFound", R.string.NoStickersFound));
            this.emptyTextView.setTextSize(1, 16.0f);
            this.emptyTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.emptyTextView.setTextColor(getThemedColor("chat_emojiPanelEmptyText"));
            linearLayout.addView(this.emptyTextView, LayoutHelper.createLinear(-2, -2));
            linearLayout.setMinimumHeight(AndroidUtilities.dp(112.0f));
            linearLayout.setLayoutParams(LayoutHelper.createFrame(-1, -1.0f));
            emptyCell = linearLayout;
        }
        return new RecyclerListView.Holder(emptyCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
            ((StickerEmojiCell) holder.itemView).setSticker((TLRPC$Document) this.cache.get(position), null, this.cacheParent.get(position), this.positionToEmoji.get(position), false);
            return;
        }
        if (itemViewType == 1) {
            ((EmptyCell) holder.itemView).setHeight(0);
            return;
        }
        if (itemViewType != 2) {
            if (itemViewType != 3) {
                return;
            }
            bindFeaturedStickerSetInfoCell((FeaturedStickerSetInfoCell) holder.itemView, position, false);
            return;
        }
        StickerSetNameCell stickerSetNameCell = (StickerSetNameCell) holder.itemView;
        Object obj = this.cache.get(position);
        if (obj instanceof TLRPC$TL_messages_stickerSet) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) obj;
            if (!TextUtils.isEmpty(this.searchQuery) && this.localPacksByShortName.containsKey(tLRPC$TL_messages_stickerSet)) {
                TLRPC$StickerSet tLRPC$StickerSet = tLRPC$TL_messages_stickerSet.set;
                if (tLRPC$StickerSet != null) {
                    stickerSetNameCell.setText(tLRPC$StickerSet.title, 0);
                }
                stickerSetNameCell.setUrl(tLRPC$TL_messages_stickerSet.set.short_name, this.searchQuery.length());
                return;
            }
            Integer num = this.localPacksByName.get(tLRPC$TL_messages_stickerSet);
            TLRPC$StickerSet tLRPC$StickerSet2 = tLRPC$TL_messages_stickerSet.set;
            if (tLRPC$StickerSet2 != null && num != null) {
                stickerSetNameCell.setText(tLRPC$StickerSet2.title, 0, num.intValue(), !TextUtils.isEmpty(this.searchQuery) ? this.searchQuery.length() : 0);
            }
            stickerSetNameCell.setUrl(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        if (payloads.contains(0) && holder.getItemViewType() == 3) {
            bindFeaturedStickerSetInfoCell((FeaturedStickerSetInfoCell) holder.itemView, position, true);
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    public void installStickerSet(TLRPC$InputStickerSet inputSet) {
        for (int i = 0; i < this.serverPacks.size(); i++) {
            TLRPC$StickerSetCovered tLRPC$StickerSetCovered = this.serverPacks.get(i);
            if (tLRPC$StickerSetCovered.set.id == inputSet.id) {
                installStickerSet(tLRPC$StickerSetCovered, null);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r2 = r7.primaryInstallingStickerSets;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r1 >= r2.length) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r2[r1] != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r2[r1] = r8;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r1 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        if (r9 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        r9.setAddDrawProgress(true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        r7.installingStickerSets.put(r8.set.id, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        if (r9 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        r7.delegate.onStickerSetAdd(r9.getStickerSet(), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        r9 = r7.positionsToSets.size();
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r1 >= r9) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        r2 = r7.positionsToSets.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        if (r2 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
    
        if (r2.set.id != r8.set.id) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
    
        notifyItemChanged(r1, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void installStickerSet(ir.eitaa.tgnet.TLRPC$StickerSetCovered r8, ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            ir.eitaa.tgnet.TLRPC$StickerSetCovered[] r2 = r7.primaryInstallingStickerSets
            int r3 = r2.length
            if (r1 >= r3) goto L3f
            r2 = r2[r1]
            if (r2 == 0) goto L3c
            int r2 = r7.currentAccount
            ir.eitaa.messenger.MediaDataController r2 = ir.eitaa.messenger.MediaDataController.getInstance(r2)
            ir.eitaa.tgnet.TLRPC$StickerSetCovered[] r3 = r7.primaryInstallingStickerSets
            r3 = r3[r1]
            ir.eitaa.tgnet.TLRPC$StickerSet r3 = r3.set
            long r3 = r3.id
            ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet r2 = r2.getStickerSetById(r3)
            if (r2 == 0) goto L2b
            ir.eitaa.tgnet.TLRPC$StickerSet r2 = r2.set
            boolean r2 = r2.archived
            if (r2 != 0) goto L2b
            ir.eitaa.tgnet.TLRPC$StickerSetCovered[] r2 = r7.primaryInstallingStickerSets
            r3 = 0
            r2[r1] = r3
            goto L3f
        L2b:
            ir.eitaa.tgnet.TLRPC$StickerSetCovered[] r2 = r7.primaryInstallingStickerSets
            r2 = r2[r1]
            ir.eitaa.tgnet.TLRPC$StickerSet r2 = r2.set
            long r2 = r2.id
            ir.eitaa.tgnet.TLRPC$StickerSet r4 = r8.set
            long r4 = r4.id
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L3c
            return
        L3c:
            int r1 = r1 + 1
            goto L2
        L3f:
            r1 = 0
        L40:
            ir.eitaa.tgnet.TLRPC$StickerSetCovered[] r2 = r7.primaryInstallingStickerSets
            int r3 = r2.length
            r4 = 1
            if (r1 >= r3) goto L51
            r3 = r2[r1]
            if (r3 != 0) goto L4e
            r2[r1] = r8
            r1 = 1
            goto L52
        L4e:
            int r1 = r1 + 1
            goto L40
        L51:
            r1 = 0
        L52:
            if (r1 != 0) goto L59
            if (r9 == 0) goto L59
            r9.setAddDrawProgress(r4, r4)
        L59:
            android.util.LongSparseArray<ir.eitaa.tgnet.TLRPC$StickerSetCovered> r2 = r7.installingStickerSets
            ir.eitaa.tgnet.TLRPC$StickerSet r3 = r8.set
            long r3 = r3.id
            r2.put(r3, r8)
            if (r9 == 0) goto L6e
            ir.eitaa.ui.Adapters.StickersSearchAdapter$Delegate r8 = r7.delegate
            ir.eitaa.tgnet.TLRPC$StickerSetCovered r9 = r9.getStickerSet()
            r8.onStickerSetAdd(r9, r1)
            goto L98
        L6e:
            android.util.SparseArray<ir.eitaa.tgnet.TLRPC$StickerSetCovered> r9 = r7.positionsToSets
            int r9 = r9.size()
            r1 = 0
        L75:
            if (r1 >= r9) goto L98
            android.util.SparseArray<ir.eitaa.tgnet.TLRPC$StickerSetCovered> r2 = r7.positionsToSets
            java.lang.Object r2 = r2.get(r1)
            ir.eitaa.tgnet.TLRPC$StickerSetCovered r2 = (ir.eitaa.tgnet.TLRPC$StickerSetCovered) r2
            if (r2 == 0) goto L95
            ir.eitaa.tgnet.TLRPC$StickerSet r2 = r2.set
            long r2 = r2.id
            ir.eitaa.tgnet.TLRPC$StickerSet r4 = r8.set
            long r4 = r4.id
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L95
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r7.notifyItemChanged(r1, r8)
            goto L98
        L95:
            int r1 = r1 + 1
            goto L75
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.StickersSearchAdapter.installStickerSet(ir.eitaa.tgnet.TLRPC$StickerSetCovered, ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell):void");
    }

    private void bindFeaturedStickerSetInfoCell(FeaturedStickerSetInfoCell cell, int position, boolean animated) {
        boolean z;
        boolean z2;
        boolean z3;
        MediaDataController mediaDataController = MediaDataController.getInstance(this.currentAccount);
        ArrayList<Long> unreadStickerSets = mediaDataController.getUnreadStickerSets();
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) this.cache.get(position);
        boolean z4 = unreadStickerSets != null && unreadStickerSets.contains(Long.valueOf(tLRPC$StickerSetCovered.set.id));
        int i = 0;
        while (true) {
            TLRPC$StickerSetCovered[] tLRPC$StickerSetCoveredArr = this.primaryInstallingStickerSets;
            if (i >= tLRPC$StickerSetCoveredArr.length) {
                z = false;
                break;
            }
            if (tLRPC$StickerSetCoveredArr[i] != null) {
                TLRPC$TL_messages_stickerSet stickerSetById = MediaDataController.getInstance(this.currentAccount).getStickerSetById(this.primaryInstallingStickerSets[i].set.id);
                if (stickerSetById != null && !stickerSetById.set.archived) {
                    this.primaryInstallingStickerSets[i] = null;
                } else if (this.primaryInstallingStickerSets[i].set.id == tLRPC$StickerSetCovered.set.id) {
                    z = true;
                    break;
                }
            }
            i++;
        }
        int iIndexOfIgnoreCase = TextUtils.isEmpty(this.searchQuery) ? -1 : AndroidUtilities.indexOfIgnoreCase(tLRPC$StickerSetCovered.set.title, this.searchQuery);
        if (iIndexOfIgnoreCase >= 0) {
            cell.setStickerSet(tLRPC$StickerSetCovered, z4, animated, iIndexOfIgnoreCase, this.searchQuery.length(), z);
        } else {
            cell.setStickerSet(tLRPC$StickerSetCovered, z4, animated, 0, 0, z);
            if (!TextUtils.isEmpty(this.searchQuery) && AndroidUtilities.indexOfIgnoreCase(tLRPC$StickerSetCovered.set.short_name, this.searchQuery) == 0) {
                cell.setUrl(tLRPC$StickerSetCovered.set.short_name, this.searchQuery.length());
            }
        }
        if (z4) {
            mediaDataController.markFaturedStickersByIdAsRead(tLRPC$StickerSetCovered.set.id);
        }
        boolean z5 = this.installingStickerSets.indexOfKey(tLRPC$StickerSetCovered.set.id) >= 0;
        boolean z6 = this.removingStickerSets.indexOfKey(tLRPC$StickerSetCovered.set.id) >= 0;
        if (z5 || z6) {
            if (z5 && cell.isInstalled()) {
                this.installingStickerSets.remove(tLRPC$StickerSetCovered.set.id);
                z5 = false;
            } else if (z6 && !cell.isInstalled()) {
                this.removingStickerSets.remove(tLRPC$StickerSetCovered.set.id);
            }
        }
        if (z || !z5) {
            z2 = animated;
            z3 = false;
        } else {
            z2 = animated;
            z3 = true;
        }
        cell.setAddDrawProgress(z3, z2);
        mediaDataController.preloadStickerSetThumb(tLRPC$StickerSetCovered);
        cell.setNeedDivider(position > 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void notifyDataSetChanged() {
        int i;
        ArrayList<TLRPC$Document> arrayList;
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered;
        this.rowStartPack.clear();
        this.positionToRow.clear();
        this.cache.clear();
        this.positionsToSets.clear();
        this.positionToEmoji.clear();
        this.totalItems = 0;
        int size = this.serverPacks.size();
        int size2 = this.localPacks.size();
        int i2 = !this.emojiArrays.isEmpty() ? 1 : 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < size + size2 + i2) {
            if (i3 < size2) {
                TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.localPacks.get(i3);
                arrayList = tLRPC$TL_messages_stickerSet.documents;
                i = size;
                tLRPC$StickerSetCovered = tLRPC$TL_messages_stickerSet;
            } else {
                int i5 = i3 - size2;
                if (i5 < i2) {
                    int size3 = this.emojiArrays.size();
                    String str = "";
                    int i6 = 0;
                    for (int i7 = 0; i7 < size3; i7++) {
                        ArrayList<TLRPC$Document> arrayList2 = this.emojiArrays.get(i7);
                        String str2 = this.emojiStickers.get(arrayList2);
                        if (str2 != null && !str.equals(str2)) {
                            this.positionToEmoji.put(this.totalItems + i6, str2);
                            str = str2;
                        }
                        int size4 = arrayList2.size();
                        int i8 = 0;
                        while (i8 < size4) {
                            int i9 = this.totalItems + i6;
                            int stickersPerRow = (i6 / this.delegate.getStickersPerRow()) + i4;
                            TLRPC$Document tLRPC$Document = arrayList2.get(i8);
                            int i10 = size;
                            this.cache.put(i9, tLRPC$Document);
                            int i11 = size3;
                            String str3 = str;
                            TLRPC$TL_messages_stickerSet stickerSetById = MediaDataController.getInstance(this.currentAccount).getStickerSetById(MediaDataController.getStickerSetId(tLRPC$Document));
                            if (stickerSetById != null) {
                                this.cacheParent.put(i9, stickerSetById);
                            }
                            this.positionToRow.put(i9, stickersPerRow);
                            i6++;
                            i8++;
                            size = i10;
                            size3 = i11;
                            str = str3;
                        }
                    }
                    i = size;
                    int iCeil = (int) Math.ceil(i6 / this.delegate.getStickersPerRow());
                    for (int i12 = 0; i12 < iCeil; i12++) {
                        this.rowStartPack.put(i4 + i12, Integer.valueOf(i6));
                    }
                    this.totalItems += this.delegate.getStickersPerRow() * iCeil;
                    i4 += iCeil;
                    i3++;
                    size = i;
                } else {
                    i = size;
                    TLRPC$StickerSetCovered tLRPC$StickerSetCovered2 = this.serverPacks.get(i5 - i2);
                    arrayList = tLRPC$StickerSetCovered2.covers;
                    tLRPC$StickerSetCovered = tLRPC$StickerSetCovered2;
                }
            }
            if (!arrayList.isEmpty()) {
                int iCeil2 = (int) Math.ceil(arrayList.size() / this.delegate.getStickersPerRow());
                this.cache.put(this.totalItems, tLRPC$StickerSetCovered);
                if (i3 >= size2 && (tLRPC$StickerSetCovered instanceof TLRPC$StickerSetCovered)) {
                    this.positionsToSets.put(this.totalItems, tLRPC$StickerSetCovered);
                }
                this.positionToRow.put(this.totalItems, i4);
                int size5 = arrayList.size();
                int i13 = 0;
                while (i13 < size5) {
                    int i14 = i13 + 1;
                    int i15 = this.totalItems + i14;
                    int stickersPerRow2 = i4 + 1 + (i13 / this.delegate.getStickersPerRow());
                    this.cache.put(i15, arrayList.get(i13));
                    this.cacheParent.put(i15, tLRPC$StickerSetCovered);
                    this.positionToRow.put(i15, stickersPerRow2);
                    if (i3 >= size2 && (tLRPC$StickerSetCovered instanceof TLRPC$StickerSetCovered)) {
                        this.positionsToSets.put(i15, tLRPC$StickerSetCovered);
                    }
                    i13 = i14;
                }
                int i16 = iCeil2 + 1;
                for (int i17 = 0; i17 < i16; i17++) {
                    this.rowStartPack.put(i4 + i17, tLRPC$StickerSetCovered);
                }
                this.totalItems += (iCeil2 * this.delegate.getStickersPerRow()) + 1;
                i4 += i16;
            }
            i3++;
            size = i;
        }
        super.notifyDataSetChanged();
    }

    public int getSpanSize(int position) {
        if (position == this.totalItems || !(this.cache.get(position) == null || (this.cache.get(position) instanceof TLRPC$Document))) {
            return this.delegate.getStickersPerRow();
        }
        return 1;
    }

    public TLRPC$StickerSetCovered getSetForPosition(int position) {
        return this.positionsToSets.get(position);
    }

    public void updateColors(RecyclerListView listView) {
        int childCount = listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = listView.getChildAt(i);
            if (childAt instanceof FeaturedStickerSetInfoCell) {
                ((FeaturedStickerSetInfoCell) childAt).updateColors();
            } else if (childAt instanceof StickerSetNameCell) {
                ((StickerSetNameCell) childAt).updateColors();
            }
        }
    }

    public void getThemeDescriptions(List<ThemeDescription> descriptions, RecyclerListView listView, ThemeDescription.ThemeDescriptionDelegate delegate) {
        FeaturedStickerSetInfoCell.createThemeDescriptions(descriptions, listView, delegate);
        StickerSetNameCell.createThemeDescriptions(descriptions, listView, delegate);
        descriptions.add(new ThemeDescription(this.emptyImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chat_emojiPanelEmptyText"));
        descriptions.add(new ThemeDescription(this.emptyTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_emojiPanelEmptyText"));
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
