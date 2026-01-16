package org.rbmain.ui.Adapters;

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
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Locale;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$TL_channelLocation;
import org.rbmain.tgnet.TLRPC$TL_geoPoint;
import org.rbmain.tgnet.TLRPC$TL_messageMediaVenue;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.EmptyCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.LocationCell;
import org.rbmain.ui.Cells.LocationDirectionCell;
import org.rbmain.ui.Cells.LocationLoadingCell;
import org.rbmain.ui.Cells.LocationPoweredCell;
import org.rbmain.ui.Cells.SendLocationCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.SharingLiveLocationCell;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.LocationActivity;

/* loaded from: classes4.dex */
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
    private SendLocationCell sendLocationCell;
    private Runnable updateRunnable;
    private int currentAccount = UserConfig.selectedAccount;
    private int shareLiveLocationPotistion = -1;
    public ArrayList<LocationActivity.LiveLocation> currentLiveLocations = new ArrayList<>();

    protected void onDirectionClick() {
    }

    public LocationActivityAdapter(Context context, int i, long j, boolean z) {
        this.mContext = context;
        this.locationType = i;
        this.dialogId = j;
        this.needEmptyView = z;
    }

    public void setOverScrollHeight(int i) {
        this.overScrollHeight = i;
    }

    public void setUpdateRunnable(Runnable runnable) {
        this.updateRunnable = runnable;
    }

    public void setGpsLocation(Location location) {
        int i;
        boolean z = this.gpsLocation == null;
        this.gpsLocation = location;
        if (this.customLocation == null) {
            fetchLocationAddress();
        }
        if (z && (i = this.shareLiveLocationPotistion) > 0) {
            notifyItemChanged(i);
        }
        if (this.currentMessageObject != null) {
            notifyItemChanged(1, new Object());
            updateLiveLocations();
        } else if (this.locationType != 2) {
            updateCell();
        } else {
            updateLiveLocations();
        }
    }

    public void updateLiveLocationCell() {
        int i = this.shareLiveLocationPotistion;
        if (i > 0) {
            notifyItemChanged(i);
        }
    }

    public void updateLiveLocations() {
        if (this.currentLiveLocations.isEmpty()) {
            return;
        }
        notifyItemRangeChanged(2, this.currentLiveLocations.size(), new Object());
    }

    public void setCustomLocation(Location location) {
        this.customLocation = location;
        fetchLocationAddress();
        updateCell();
    }

    public void setLiveLocations(ArrayList<LocationActivity.LiveLocation> arrayList) {
        this.currentLiveLocations = new ArrayList<>(arrayList);
        int clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
        for (int i = 0; i < this.currentLiveLocations.size(); i++) {
            if (this.currentLiveLocations.get(i).id == clientUserId || this.currentLiveLocations.get(i).object.out) {
                this.currentLiveLocations.remove(i);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void setMessageObject(MessageObject messageObject) {
        this.currentMessageObject = messageObject;
        notifyDataSetChanged();
    }

    public void setChatLocation(TLRPC$TL_channelLocation tLRPC$TL_channelLocation) {
        this.chatLocation = tLRPC$TL_channelLocation;
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

    @Override // org.rbmain.messenger.LocationController.LocationFetchCallback
    public void onLocationAddressAvailable(String str, String str2, Location location) {
        this.fetchingLocation = false;
        this.previousFetchedLocation = location;
        this.addressName = str;
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
        if (i == 6 || i == 5 || i == 4) {
            return 2;
        }
        if (this.currentMessageObject != null) {
            return (this.currentLiveLocations.isEmpty() ? 1 : this.currentLiveLocations.size() + 3) + 2;
        }
        if (i == 2) {
            return this.currentLiveLocations.size() + 2;
        }
        if (this.searching || this.places.isEmpty()) {
            return 3 + (this.needEmptyView ? 1 : 0);
        }
        if (this.locationType == 1) {
            return this.places.size() + 3 + (this.needEmptyView ? 1 : 0);
        }
        return this.places.size() + 5 + (this.needEmptyView ? 1 : 0);
    }

    /* renamed from: org.rbmain.ui.Adapters.LocationActivityAdapter$1, reason: invalid class name */
    class AnonymousClass1 extends EmptyCell {
        AnonymousClass1(Context context) {
            super(context);
        }

        @Override // android.view.View
        public ViewPropertyAnimator animate() {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = super.animate();
            if (Build.VERSION.SDK_INT >= 19) {
                viewPropertyAnimatorAnimate.setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Adapters.LocationActivityAdapter$1$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$animate$0(valueAnimator);
                    }
                });
            }
            return viewPropertyAnimatorAnimate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$animate$0(ValueAnimator valueAnimator) {
            if (LocationActivityAdapter.this.updateRunnable != null) {
                LocationActivityAdapter.this.updateRunnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
        onDirectionClick();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View sendLocationCell;
        View anonymousClass1;
        switch (i) {
            case 0:
                anonymousClass1 = new AnonymousClass1(this.mContext);
                break;
            case 1:
                sendLocationCell = new SendLocationCell(this.mContext, false);
                anonymousClass1 = sendLocationCell;
                break;
            case 2:
                anonymousClass1 = new HeaderCell(this.mContext);
                break;
            case 3:
                sendLocationCell = new LocationCell(this.mContext, false);
                anonymousClass1 = sendLocationCell;
                break;
            case 4:
                anonymousClass1 = new LocationLoadingCell(this.mContext);
                break;
            case 5:
                anonymousClass1 = new LocationPoweredCell(this.mContext);
                break;
            case 6:
                SendLocationCell sendLocationCell2 = new SendLocationCell(this.mContext, true);
                sendLocationCell2.setDialogId(this.dialogId);
                anonymousClass1 = sendLocationCell2;
                break;
            case 7:
                Context context = this.mContext;
                int i2 = this.locationType;
                anonymousClass1 = new SharingLiveLocationCell(context, true, (i2 == 4 || i2 == 5) ? 16 : 54);
                break;
            case 8:
                LocationDirectionCell locationDirectionCell = new LocationDirectionCell(this.mContext);
                locationDirectionCell.setOnButtonClick(new View.OnClickListener() { // from class: org.rbmain.ui.Adapters.LocationActivityAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0(view);
                    }
                });
                anonymousClass1 = locationDirectionCell;
                break;
            case 9:
                View shadowSectionCell = new ShadowSectionCell(this.mContext);
                CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray)), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                combinedDrawable.setFullsize(true);
                shadowSectionCell.setBackgroundDrawable(combinedDrawable);
                anonymousClass1 = shadowSectionCell;
                break;
            default:
                anonymousClass1 = new View(this.mContext);
                break;
        }
        return new RecyclerListView.Holder(anonymousClass1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 0) {
            ((EmptyCell) viewHolder.itemView).setHeight(this.overScrollHeight);
            return;
        }
        if (itemViewType == 1) {
            this.sendLocationCell = (SendLocationCell) viewHolder.itemView;
            updateCell();
            return;
        }
        if (itemViewType == 2) {
            HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
            if (this.currentMessageObject != null) {
                headerCell.setText(LocaleController.getString("LiveLocations", R.string.LiveLocations));
                return;
            } else {
                headerCell.setText(LocaleController.getString("NearbyVenue", R.string.NearbyVenue));
                return;
            }
        }
        if (itemViewType == 3) {
            LocationCell locationCell = (LocationCell) viewHolder.itemView;
            int i2 = this.locationType == 0 ? i - 4 : i - 5;
            locationCell.setLocation(this.places.get(i2), this.iconUrls.get(i2), i2, true);
            return;
        }
        if (itemViewType == 4) {
            ((LocationLoadingCell) viewHolder.itemView).setLoading(this.searching);
            return;
        }
        if (itemViewType == 6) {
            ((SendLocationCell) viewHolder.itemView).setHasLocation(this.gpsLocation != null);
            return;
        }
        if (itemViewType != 7) {
            return;
        }
        SharingLiveLocationCell sharingLiveLocationCell = (SharingLiveLocationCell) viewHolder.itemView;
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
        if (messageObject == null || i != 1) {
            sharingLiveLocationCell.setDialog(this.currentLiveLocations.get(i - (messageObject != null ? 5 : 2)), this.gpsLocation);
        } else {
            sharingLiveLocationCell.setDialog(messageObject, this.gpsLocation);
        }
    }

    public Object getItem(int i) {
        int i2 = this.locationType;
        if (i2 == 4) {
            if (this.addressName == null) {
                return null;
            }
            TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue = new TLRPC$TL_messageMediaVenue();
            tLRPC$TL_messageMediaVenue.address = this.addressName;
            TLRPC$TL_geoPoint tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint();
            tLRPC$TL_messageMediaVenue.geo = tLRPC$TL_geoPoint;
            Location location = this.customLocation;
            if (location != null) {
                tLRPC$TL_geoPoint.lat = location.getLatitude();
                tLRPC$TL_messageMediaVenue.geo._long = this.customLocation.getLongitude();
            } else {
                Location location2 = this.gpsLocation;
                if (location2 != null) {
                    tLRPC$TL_geoPoint.lat = location2.getLatitude();
                    tLRPC$TL_messageMediaVenue.geo._long = this.gpsLocation.getLongitude();
                }
            }
            return tLRPC$TL_messageMediaVenue;
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null) {
            if (i == 1) {
                return messageObject;
            }
            if (i > 4 && i < this.places.size() + 4) {
                return this.currentLiveLocations.get(i - 5);
            }
        } else {
            if (i2 == 2) {
                if (i >= 2) {
                    return this.currentLiveLocations.get(i - 2);
                }
                return null;
            }
            if (i2 == 1) {
                if (i > 4 && i < this.places.size() + 5) {
                    return this.places.get(i - 5);
                }
            } else if (i > 3 && i < this.places.size() + 4) {
                return this.places.get(i - 4);
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (this.locationType == 6) {
            return 7;
        }
        if (this.needEmptyView && i == getItemCount() - 1) {
            return 10;
        }
        int i2 = this.locationType;
        if (i2 == 5) {
            return 7;
        }
        if (i2 == 4) {
            return 1;
        }
        if (this.currentMessageObject != null) {
            if (this.currentLiveLocations.isEmpty()) {
                if (i == 2) {
                    return 8;
                }
            } else {
                if (i == 2) {
                    return 9;
                }
                if (i == 3) {
                    return 2;
                }
                if (i == 4) {
                    this.shareLiveLocationPotistion = i;
                    return 6;
                }
            }
            return 7;
        }
        if (i2 == 2) {
            if (i != 1) {
                return 7;
            }
            this.shareLiveLocationPotistion = i;
            return 6;
        }
        if (i2 == 1) {
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                this.shareLiveLocationPotistion = i;
                return 6;
            }
            if (i == 3) {
                return 9;
            }
            if (i == 4) {
                return 2;
            }
            if (this.searching || this.places.isEmpty()) {
                return 4;
            }
            if (i == this.places.size() + 5) {
                return 5;
            }
        } else {
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 9;
            }
            if (i == 3) {
                return 2;
            }
            if (this.searching || this.places.isEmpty()) {
                return 4;
            }
            if (i == this.places.size() + 4) {
                return 5;
            }
        }
        return 3;
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 6 ? (LocationController.getInstance(this.currentAccount).getSharingLocationInfo(this.dialogId) == null && this.gpsLocation == null) ? false : true : itemViewType == 1 || itemViewType == 3 || itemViewType == 7;
    }
}
