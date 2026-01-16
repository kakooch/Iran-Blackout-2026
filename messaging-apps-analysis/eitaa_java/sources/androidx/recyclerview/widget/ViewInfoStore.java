package androidx.recyclerview.widget;

import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.FileLog;

/* loaded from: classes.dex */
class ViewInfoStore {
    final ArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new ArrayMap<>();
    final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray<>();

    interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo preInfo, RecyclerView.ItemAnimator.ItemHolderInfo postInfo);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo preInfo, RecyclerView.ItemAnimator.ItemHolderInfo postInfo);

        void processPersistent(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo preInfo, RecyclerView.ItemAnimator.ItemHolderInfo postInfo);

        void unused(RecyclerView.ViewHolder holder);
    }

    ViewInfoStore() {
    }

    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    void addToPreLayout(RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(holder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(holder, infoRecordObtain);
        }
        infoRecordObtain.preInfo = info;
        infoRecordObtain.flags |= 4;
    }

    boolean isDisappearing(RecyclerView.ViewHolder holder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(holder);
        return (infoRecord == null || (infoRecord.flags & 1) == 0) ? false : true;
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder vh) {
        return popFromLayoutStep(vh, 4);
    }

    RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder vh) {
        return popFromLayoutStep(vh, 8);
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder vh, int flag) {
        InfoRecord infoRecordValueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int iIndexOfKey = this.mLayoutHolderMap.indexOfKey(vh);
        if (iIndexOfKey >= 0 && (infoRecordValueAt = this.mLayoutHolderMap.valueAt(iIndexOfKey)) != null) {
            int i = infoRecordValueAt.flags;
            if ((i & flag) != 0) {
                int i2 = (flag ^ (-1)) & i;
                infoRecordValueAt.flags = i2;
                if (flag == 4) {
                    itemHolderInfo = infoRecordValueAt.preInfo;
                } else if (flag == 8) {
                    itemHolderInfo = infoRecordValueAt.postInfo;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i2 & 12) == 0) {
                    this.mLayoutHolderMap.removeAt(iIndexOfKey);
                    InfoRecord.recycle(infoRecordValueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    void addToOldChangeHolders(long key, RecyclerView.ViewHolder holder) {
        this.mOldChangedHolders.put(key, holder);
    }

    void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(holder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(holder, infoRecordObtain);
        }
        infoRecordObtain.flags |= 2;
        infoRecordObtain.preInfo = info;
    }

    boolean isInPreLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return (infoRecord == null || (infoRecord.flags & 4) == 0) ? false : true;
    }

    RecyclerView.ViewHolder getFromOldChangeHolders(long key) {
        return this.mOldChangedHolders.get(key);
    }

    void addToPostLayout(RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(holder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(holder, infoRecordObtain);
        }
        infoRecordObtain.postInfo = info;
        infoRecordObtain.flags |= 8;
    }

    void addToDisappearedInLayout(RecyclerView.ViewHolder holder) {
        InfoRecord infoRecordObtain = this.mLayoutHolderMap.get(holder);
        if (infoRecordObtain == null) {
            infoRecordObtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(holder, infoRecordObtain);
        }
        infoRecordObtain.flags |= 1;
    }

    void removeFromDisappearedInLayout(RecyclerView.ViewHolder holder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(holder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.flags &= -2;
    }

    void process(ProcessCallback callback) {
        InfoRecord infoRecordRemoveAt;
        for (int size = this.mLayoutHolderMap.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder viewHolderKeyAt = this.mLayoutHolderMap.keyAt(size);
            try {
                infoRecordRemoveAt = this.mLayoutHolderMap.removeAt(size);
            } catch (Exception e) {
                FileLog.e(e);
                infoRecordRemoveAt = null;
            }
            if (infoRecordRemoveAt != null) {
                int i = infoRecordRemoveAt.flags;
                if ((i & 3) == 3) {
                    callback.unused(viewHolderKeyAt);
                } else if ((i & 1) != 0) {
                    RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = infoRecordRemoveAt.preInfo;
                    if (itemHolderInfo == null) {
                        callback.unused(viewHolderKeyAt);
                    } else {
                        callback.processDisappeared(viewHolderKeyAt, itemHolderInfo, infoRecordRemoveAt.postInfo);
                    }
                } else if ((i & 14) == 14) {
                    callback.processAppeared(viewHolderKeyAt, infoRecordRemoveAt.preInfo, infoRecordRemoveAt.postInfo);
                } else if ((i & 12) == 12) {
                    callback.processPersistent(viewHolderKeyAt, infoRecordRemoveAt.preInfo, infoRecordRemoveAt.postInfo);
                } else if ((i & 4) != 0) {
                    callback.processDisappeared(viewHolderKeyAt, infoRecordRemoveAt.preInfo, null);
                } else if ((i & 8) != 0) {
                    callback.processAppeared(viewHolderKeyAt, infoRecordRemoveAt.preInfo, infoRecordRemoveAt.postInfo);
                }
                InfoRecord.recycle(infoRecordRemoveAt);
            }
        }
    }

    void removeViewHolder(RecyclerView.ViewHolder holder) {
        int size = this.mOldChangedHolders.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (holder == this.mOldChangedHolders.valueAt(size)) {
                this.mOldChangedHolders.removeAt(size);
                break;
            }
            size--;
        }
        InfoRecord infoRecord = this.mLayoutHolderMap.get(holder);
        if (infoRecord != null) {
            this.mLayoutHolderMap.remove(holder);
            InfoRecord.recycle(infoRecord);
        }
    }

    void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        removeFromDisappearedInLayout(viewHolder);
    }

    static class InfoRecord {
        static Pools$Pool<InfoRecord> sPool = new Pools$SimplePool(20);
        int flags;
        RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        private InfoRecord() {
        }

        static InfoRecord obtain() {
            InfoRecord infoRecordAcquire = sPool.acquire();
            return infoRecordAcquire == null ? new InfoRecord() : infoRecordAcquire;
        }

        static void recycle(InfoRecord record) {
            record.flags = 0;
            record.preInfo = null;
            record.postInfo = null;
            sPool.release(record);
        }

        static void drainCache() {
            while (sPool.acquire() != null) {
            }
        }
    }
}
