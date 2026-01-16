package ir.eitaa.ui.Adapters;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$TL_channelLocation;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LocationCell;
import ir.eitaa.ui.Cells.LocationDirectionCell;
import ir.eitaa.ui.Cells.LocationPoweredCell;
import ir.eitaa.ui.Cells.SendLocationCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.SharingLiveLocationCell;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.Locale;

/* loaded from: classes3.dex */
public class LocationActivityAdapter extends BaseLocationAdapter implements LocationController.LocationFetchCallback {
    private String addressName;
    private TLRPC$TL_channelLocation chatLocation;
    private MessageObject currentMessageObject;
    private Location customLocation;
    private long dialogId;
    private boolean fetchingLocation;
    private Location gpsLocation;
    private int locationType;
    private Context mContext;
    private boolean needEmptyView;
    private int overScrollHeight;
    private Location previousFetchedLocation;
    private final Theme.ResourcesProvider resourcesProvider;
    private SendLocationCell sendLocationCell;
    private Runnable updateRunnable;
    private int currentAccount = UserConfig.selectedAccount;
    private int shareLiveLocationPotistion = -1;

    protected void onDirectionClick() {
        throw null;
    }

    public LocationActivityAdapter(Context context, int type, long did, boolean emptyView, Theme.ResourcesProvider resourcesProvider) {
        this.mContext = context;
        this.locationType = type;
        this.dialogId = did;
        this.needEmptyView = emptyView;
        this.resourcesProvider = resourcesProvider;
    }

    public void setOverScrollHeight(int value) {
        this.overScrollHeight = value;
    }

    public void setUpdateRunnable(Runnable runnable) {
        this.updateRunnable = runnable;
    }

    public void setGpsLocation(Location location) {
        int i;
        boolean z = this.gpsLocation == null;
        this.gpsLocation = location;
        if (z && (i = this.shareLiveLocationPotistion) > 0) {
            notifyItemChanged(i);
        }
        if (this.currentMessageObject != null) {
            notifyItemChanged(1, new Object());
        } else if (this.locationType != 2) {
            updateCell();
        }
    }

    public void setMessageObject(MessageObject messageObject) {
        this.currentMessageObject = messageObject;
        notifyDataSetChanged();
    }

    private void updateCell() {
        String string;
        SendLocationCell sendLocationCell = this.sendLocationCell;
        if (sendLocationCell != null) {
            if (this.locationType == 4 || this.customLocation != null) {
                if (!TextUtils.isEmpty(this.addressName)) {
                    string = this.addressName;
                } else {
                    Location location = this.customLocation;
                    if ((location == null && this.gpsLocation == null) || this.fetchingLocation) {
                        string = LocaleController.getString("Loading", R.string.Loading);
                    } else if (location != null) {
                        string = String.format(Locale.US, "(%f,%f)", Double.valueOf(location.getLatitude()), Double.valueOf(this.customLocation.getLongitude()));
                    } else {
                        Location location2 = this.gpsLocation;
                        if (location2 != null) {
                            string = String.format(Locale.US, "(%f,%f)", Double.valueOf(location2.getLatitude()), Double.valueOf(this.gpsLocation.getLongitude()));
                        } else {
                            string = LocaleController.getString("Loading", R.string.Loading);
                        }
                    }
                }
                if (this.locationType == 4) {
                    this.sendLocationCell.setText(LocaleController.getString("ChatSetThisLocation", R.string.ChatSetThisLocation), string);
                    return;
                } else {
                    this.sendLocationCell.setText(LocaleController.getString("SendSelectedLocation", R.string.SendSelectedLocation), string);
                    return;
                }
            }
            if (this.gpsLocation != null) {
                sendLocationCell.setText(LocaleController.getString("SendLocation", R.string.SendLocation), LocaleController.formatString("AccurateTo", R.string.AccurateTo, LocaleController.formatPluralString("Meters", (int) this.gpsLocation.getAccuracy())));
            } else {
                sendLocationCell.setText(LocaleController.getString("SendLocation", R.string.SendLocation), LocaleController.getString("Loading", R.string.Loading));
            }
        }
    }

    @Override // ir.eitaa.messenger.LocationController.LocationFetchCallback
    public void onLocationAddressAvailable(String address, String displayAddress, Location location) {
        this.fetchingLocation = false;
        this.previousFetchedLocation = location;
        this.addressName = address;
        updateCell();
    }

    public void fetchLocationAddress() {
        if (this.locationType == 4) {
            Location location = this.customLocation;
            if (location == null && (location = this.gpsLocation) == null) {
                return;
            }
            Location location2 = this.previousFetchedLocation;
            if (location2 == null || location2.distanceTo(location) > 100.0f) {
                this.addressName = null;
            }
            this.fetchingLocation = true;
            updateCell();
            LocationController.fetchLocationAddress(location, this);
            return;
        }
        Location location3 = this.customLocation;
        if (location3 != null) {
            Location location4 = this.previousFetchedLocation;
            if (location4 == null || location4.distanceTo(location3) > 20.0f) {
                this.addressName = null;
            }
            this.fetchingLocation = true;
            updateCell();
            LocationController.fetchLocationAddress(location3, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = this.locationType;
        return (i == 6 || i == 5 || i == 4) ? 2 : 3;
    }

    /* renamed from: ir.eitaa.ui.Adapters.LocationActivityAdapter$1, reason: invalid class name */
    class AnonymousClass1 extends EmptyCell {
        AnonymousClass1(Context context) {
            super(context);
        }

        @Override // android.view.View
        public ViewPropertyAnimator animate() {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = super.animate();
            if (Build.VERSION.SDK_INT >= 19) {
                viewPropertyAnimatorAnimate.setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$LocationActivityAdapter$1$MD9ayDV81dhP5VAMwRJpB09X254
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$animate$0$LocationActivityAdapter$1(valueAnimator);
                    }
                });
            }
            return viewPropertyAnimatorAnimate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$animate$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$animate$0$LocationActivityAdapter$1(ValueAnimator valueAnimator) {
            if (LocationActivityAdapter.this.updateRunnable != null) {
                LocationActivityAdapter.this.updateRunnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreateViewHolder$0$LocationActivityAdapter(View view) {
        onDirectionClick();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View anonymousClass1;
        View sendLocationCell;
        if (i != 0) {
            if (i == 1) {
                sendLocationCell = new SendLocationCell(this.mContext, false, this.resourcesProvider);
            } else if (i == 2) {
                anonymousClass1 = new HeaderCell(this.mContext, this.resourcesProvider);
            } else if (i == 3) {
                sendLocationCell = new LocationCell(this.mContext, false, this.resourcesProvider);
            } else if (i == 5) {
                anonymousClass1 = new LocationPoweredCell(this.mContext, this.resourcesProvider);
            } else if (i == 7) {
                Context context = this.mContext;
                int i2 = this.locationType;
                sendLocationCell = new SharingLiveLocationCell(context, true, (i2 == 4 || i2 == 5) ? 16 : 54, this.resourcesProvider);
            } else if (i == 8) {
                LocationDirectionCell locationDirectionCell = new LocationDirectionCell(this.mContext, this.resourcesProvider);
                locationDirectionCell.setOnButtonClick(new View.OnClickListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$LocationActivityAdapter$0BNJid0BbxCClI8aSOQnyYOpFjI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0$LocationActivityAdapter(view);
                    }
                });
                anonymousClass1 = locationDirectionCell;
            } else if (i == 9) {
                View shadowSectionCell = new ShadowSectionCell(this.mContext);
                CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(getThemedColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                combinedDrawable.setFullsize(true);
                shadowSectionCell.setBackgroundDrawable(combinedDrawable);
                anonymousClass1 = shadowSectionCell;
            } else {
                anonymousClass1 = new View(this.mContext);
            }
            anonymousClass1 = sendLocationCell;
        } else {
            anonymousClass1 = new AnonymousClass1(this.mContext);
        }
        return new RecyclerListView.Holder(anonymousClass1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException {
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
            ((EmptyCell) holder.itemView).setHeight(this.overScrollHeight);
            return;
        }
        if (itemViewType == 1) {
            this.sendLocationCell = (SendLocationCell) holder.itemView;
            updateCell();
            return;
        }
        if (itemViewType == 3) {
            LocationCell locationCell = (LocationCell) holder.itemView;
            int i = this.locationType == 0 ? position - 4 : position - 5;
            locationCell.setLocation(this.places.get(i), this.iconUrls.get(i), i, true);
            return;
        }
        if (itemViewType != 7) {
            return;
        }
        SharingLiveLocationCell sharingLiveLocationCell = (SharingLiveLocationCell) holder.itemView;
        if (this.locationType == 6) {
            sharingLiveLocationCell.setDialog(this.currentMessageObject, this.gpsLocation);
            return;
        }
        TLRPC$TL_channelLocation tLRPC$TL_channelLocation = this.chatLocation;
        if (tLRPC$TL_channelLocation != null) {
            sharingLiveLocationCell.setDialog(this.dialogId, tLRPC$TL_channelLocation);
            return;
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || position != 1) {
            return;
        }
        sharingLiveLocationCell.setDialog(messageObject, this.gpsLocation);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (this.currentMessageObject != null) {
            return position == 2 ? 8 : 7;
        }
        int i = this.locationType;
        if (i == 2) {
            if (position != 1) {
                return 7;
            }
            this.shareLiveLocationPotistion = position;
            return 6;
        }
        if (i == 1) {
            if (position == 1) {
                return 1;
            }
            if (position == 2) {
                this.shareLiveLocationPotistion = position;
                return 6;
            }
            if (position == 3) {
                return 9;
            }
            if (position == 4) {
                return 2;
            }
            if (this.searching || this.places.isEmpty()) {
                return 4;
            }
            if (position == this.places.size() + 5) {
                return 5;
            }
        } else {
            if (position == 1) {
                return 1;
            }
            if (position == 2) {
                return 9;
            }
            if (position == 3) {
                return 2;
            }
            if (this.searching || this.places.isEmpty()) {
                return 4;
            }
            if (position == this.places.size() + 4) {
                return 5;
            }
        }
        return 3;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        int itemViewType = holder.getItemViewType();
        return itemViewType == 6 ? (LocationController.getInstance(this.currentAccount).getSharingLocationInfo(this.dialogId) == null && this.gpsLocation == null) ? false : true : itemViewType == 1 || itemViewType == 3 || itemViewType == 7;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
