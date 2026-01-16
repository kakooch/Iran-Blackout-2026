package ir.nasim.features.bank.mybank.model;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000f2\u00020\u0001:\b\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\b\u0082\u0001\u0007\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "", "", "type", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "getSectionID", "()I", "sectionID", "getTitle", "title", "Companion", "Wallet", "Shortcut", "CustomServices", "Banner", "BotsVitrine", "ServiceItemsExtra", "BotsVitrineExtra", "a", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$Banner;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$BotsVitrine;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$BotsVitrineExtra;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$CustomServices;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$ServiceItemsExtra;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$Shortcut;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$Wallet;", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public abstract class ServicesPageSectionEntity {
    public static final int $stable = 0;
    public static final String BANNERS_SECTION_TITLE = "banners";
    public static final String BOTS_VITRINE_SECTION_TITLE = "botsVitrine";
    public static final String CUSTOM_SERVICES_SECTION_TITLE = "customServices";
    public static final String SHORTCUTS_SECTION_TITLE = "shortcuts";
    public static final String WALLET_SECTION_TITLE = "wallet";
    private final String type;

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H×\u0003J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$Banner;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "sectionID", "", "title", "", "<init>", "(ILjava/lang/String;)V", "getSectionID", "()I", "getTitle", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class Banner extends ServicesPageSectionEntity {
        public static final int $stable = 0;
        private final int sectionID;
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public Banner(int i, String str) {
            AbstractC13042fc3.i(str, "title");
            String name = Banner.class.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            super(name, null);
            this.sectionID = i;
            this.title = str;
        }

        public static /* synthetic */ Banner copy$default(Banner banner, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = banner.sectionID;
            }
            if ((i2 & 2) != 0) {
                str = banner.title;
            }
            return banner.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSectionID() {
            return this.sectionID;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final Banner copy(int sectionID, String title) {
            AbstractC13042fc3.i(title, "title");
            return new Banner(sectionID, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Banner)) {
                return false;
            }
            Banner banner = (Banner) other;
            return this.sectionID == banner.sectionID && AbstractC13042fc3.d(this.title, banner.title);
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public int getSectionID() {
            return this.sectionID;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (Integer.hashCode(this.sectionID) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "Banner(title=" + getTitle() + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H×\u0003J\t\u0010\u0019\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$BotsVitrine;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "sectionID", "", "title", "", "botsIDs", "", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getSectionID", "()I", "getTitle", "()Ljava/lang/String;", "getBotsIDs", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class BotsVitrine extends ServicesPageSectionEntity {
        public static final int $stable = 8;
        private final List<Integer> botsIDs;
        private final int sectionID;
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public BotsVitrine(int i, String str, List<Integer> list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(list, "botsIDs");
            String name = BotsVitrine.class.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            super(name, null);
            this.sectionID = i;
            this.title = str;
            this.botsIDs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BotsVitrine copy$default(BotsVitrine botsVitrine, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = botsVitrine.sectionID;
            }
            if ((i2 & 2) != 0) {
                str = botsVitrine.title;
            }
            if ((i2 & 4) != 0) {
                list = botsVitrine.botsIDs;
            }
            return botsVitrine.copy(i, str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSectionID() {
            return this.sectionID;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<Integer> component3() {
            return this.botsIDs;
        }

        public final BotsVitrine copy(int sectionID, String title, List<Integer> botsIDs) {
            AbstractC13042fc3.i(title, "title");
            AbstractC13042fc3.i(botsIDs, "botsIDs");
            return new BotsVitrine(sectionID, title, botsIDs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BotsVitrine)) {
                return false;
            }
            BotsVitrine botsVitrine = (BotsVitrine) other;
            return this.sectionID == botsVitrine.sectionID && AbstractC13042fc3.d(this.title, botsVitrine.title) && AbstractC13042fc3.d(this.botsIDs, botsVitrine.botsIDs);
        }

        public final List<Integer> getBotsIDs() {
            return this.botsIDs;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public int getSectionID() {
            return this.sectionID;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.sectionID) * 31) + this.title.hashCode()) * 31) + this.botsIDs.hashCode();
        }

        public String toString() {
            return "BotsVitrine(title=" + getTitle() + ", botsIDs=" + this.botsIDs + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u0005H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J_\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÇ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H×\u0003J\t\u0010(\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$BotsVitrineExtra;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "sectionID", "", "title", "", "badgeType", "serviceCategoryID", "buttonNavigationType", "buttonNavigationDestinationUrl", "buttonText", "botsIDs", "", "<init>", "(ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getSectionID", "()I", "getTitle", "()Ljava/lang/String;", "getBadgeType", "getServiceCategoryID", "getButtonNavigationType", "getButtonNavigationDestinationUrl", "getButtonText", "getBotsIDs", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class BotsVitrineExtra extends ServicesPageSectionEntity {
        public static final int $stable = 8;
        private final int badgeType;
        private final List<Integer> botsIDs;
        private final String buttonNavigationDestinationUrl;
        private final int buttonNavigationType;
        private final String buttonText;
        private final int sectionID;
        private final int serviceCategoryID;
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public BotsVitrineExtra(int i, String str, int i2, int i3, int i4, String str2, String str3, List<Integer> list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "buttonNavigationDestinationUrl");
            AbstractC13042fc3.i(str3, "buttonText");
            AbstractC13042fc3.i(list, "botsIDs");
            String name = BotsVitrineExtra.class.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            super(name, null);
            this.sectionID = i;
            this.title = str;
            this.badgeType = i2;
            this.serviceCategoryID = i3;
            this.buttonNavigationType = i4;
            this.buttonNavigationDestinationUrl = str2;
            this.buttonText = str3;
            this.botsIDs = list;
        }

        /* renamed from: component1, reason: from getter */
        public final int getSectionID() {
            return this.sectionID;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final int getBadgeType() {
            return this.badgeType;
        }

        /* renamed from: component4, reason: from getter */
        public final int getServiceCategoryID() {
            return this.serviceCategoryID;
        }

        /* renamed from: component5, reason: from getter */
        public final int getButtonNavigationType() {
            return this.buttonNavigationType;
        }

        /* renamed from: component6, reason: from getter */
        public final String getButtonNavigationDestinationUrl() {
            return this.buttonNavigationDestinationUrl;
        }

        /* renamed from: component7, reason: from getter */
        public final String getButtonText() {
            return this.buttonText;
        }

        public final List<Integer> component8() {
            return this.botsIDs;
        }

        public final BotsVitrineExtra copy(int sectionID, String title, int badgeType, int serviceCategoryID, int buttonNavigationType, String buttonNavigationDestinationUrl, String buttonText, List<Integer> botsIDs) {
            AbstractC13042fc3.i(title, "title");
            AbstractC13042fc3.i(buttonNavigationDestinationUrl, "buttonNavigationDestinationUrl");
            AbstractC13042fc3.i(buttonText, "buttonText");
            AbstractC13042fc3.i(botsIDs, "botsIDs");
            return new BotsVitrineExtra(sectionID, title, badgeType, serviceCategoryID, buttonNavigationType, buttonNavigationDestinationUrl, buttonText, botsIDs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BotsVitrineExtra)) {
                return false;
            }
            BotsVitrineExtra botsVitrineExtra = (BotsVitrineExtra) other;
            return this.sectionID == botsVitrineExtra.sectionID && AbstractC13042fc3.d(this.title, botsVitrineExtra.title) && this.badgeType == botsVitrineExtra.badgeType && this.serviceCategoryID == botsVitrineExtra.serviceCategoryID && this.buttonNavigationType == botsVitrineExtra.buttonNavigationType && AbstractC13042fc3.d(this.buttonNavigationDestinationUrl, botsVitrineExtra.buttonNavigationDestinationUrl) && AbstractC13042fc3.d(this.buttonText, botsVitrineExtra.buttonText) && AbstractC13042fc3.d(this.botsIDs, botsVitrineExtra.botsIDs);
        }

        public final int getBadgeType() {
            return this.badgeType;
        }

        public final List<Integer> getBotsIDs() {
            return this.botsIDs;
        }

        public final String getButtonNavigationDestinationUrl() {
            return this.buttonNavigationDestinationUrl;
        }

        public final int getButtonNavigationType() {
            return this.buttonNavigationType;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public int getSectionID() {
            return this.sectionID;
        }

        public final int getServiceCategoryID() {
            return this.serviceCategoryID;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((((((((((Integer.hashCode(this.sectionID) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.badgeType)) * 31) + Integer.hashCode(this.serviceCategoryID)) * 31) + Integer.hashCode(this.buttonNavigationType)) * 31) + this.buttonNavigationDestinationUrl.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.botsIDs.hashCode();
        }

        public String toString() {
            return "BotsVitrineExtra(title=" + getTitle() + ", botsIDs=" + this.botsIDs + ", badgeType=" + this.badgeType + ", serviceCategoryID=" + this.serviceCategoryID + ", buttonNavigationType=" + this.buttonNavigationType + ", buttonText=" + this.buttonText + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H×\u0003J\t\u0010\u0019\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$CustomServices;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "sectionID", "", "title", "", "servicesIDs", "", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getSectionID", "()I", "getTitle", "()Ljava/lang/String;", "getServicesIDs", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class CustomServices extends ServicesPageSectionEntity {
        public static final int $stable = 8;
        private final int sectionID;
        private final List<Integer> servicesIDs;
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public CustomServices(int i, String str, List<Integer> list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(list, "servicesIDs");
            String name = CustomServices.class.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            super(name, null);
            this.sectionID = i;
            this.title = str;
            this.servicesIDs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomServices copy$default(CustomServices customServices, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = customServices.sectionID;
            }
            if ((i2 & 2) != 0) {
                str = customServices.title;
            }
            if ((i2 & 4) != 0) {
                list = customServices.servicesIDs;
            }
            return customServices.copy(i, str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSectionID() {
            return this.sectionID;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<Integer> component3() {
            return this.servicesIDs;
        }

        public final CustomServices copy(int sectionID, String title, List<Integer> servicesIDs) {
            AbstractC13042fc3.i(title, "title");
            AbstractC13042fc3.i(servicesIDs, "servicesIDs");
            return new CustomServices(sectionID, title, servicesIDs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomServices)) {
                return false;
            }
            CustomServices customServices = (CustomServices) other;
            return this.sectionID == customServices.sectionID && AbstractC13042fc3.d(this.title, customServices.title) && AbstractC13042fc3.d(this.servicesIDs, customServices.servicesIDs);
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public int getSectionID() {
            return this.sectionID;
        }

        public final List<Integer> getServicesIDs() {
            return this.servicesIDs;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.sectionID) * 31) + this.title.hashCode()) * 31) + this.servicesIDs.hashCode();
        }

        public String toString() {
            return "CustomServices(title=" + getTitle() + ", servicesIDs=" + this.servicesIDs + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\u0005H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÇ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H×\u0003J\t\u0010%\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$ServiceItemsExtra;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "sectionID", "", "title", "", "badgeType", "serviceCategoryID", "buttonNavigationType", "buttonText", "servicesIDs", "", "<init>", "(ILjava/lang/String;IIILjava/lang/String;Ljava/util/List;)V", "getSectionID", "()I", "getTitle", "()Ljava/lang/String;", "getBadgeType", "getServiceCategoryID", "getButtonNavigationType", "getButtonText", "getServicesIDs", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class ServiceItemsExtra extends ServicesPageSectionEntity {
        public static final int $stable = 8;
        private final int badgeType;
        private final int buttonNavigationType;
        private final String buttonText;
        private final int sectionID;
        private final int serviceCategoryID;
        private final List<Integer> servicesIDs;
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public ServiceItemsExtra(int i, String str, int i2, int i3, int i4, String str2, List<Integer> list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "buttonText");
            AbstractC13042fc3.i(list, "servicesIDs");
            String name = ServiceItemsExtra.class.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            super(name, null);
            this.sectionID = i;
            this.title = str;
            this.badgeType = i2;
            this.serviceCategoryID = i3;
            this.buttonNavigationType = i4;
            this.buttonText = str2;
            this.servicesIDs = list;
        }

        public static /* synthetic */ ServiceItemsExtra copy$default(ServiceItemsExtra serviceItemsExtra, int i, String str, int i2, int i3, int i4, String str2, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = serviceItemsExtra.sectionID;
            }
            if ((i5 & 2) != 0) {
                str = serviceItemsExtra.title;
            }
            String str3 = str;
            if ((i5 & 4) != 0) {
                i2 = serviceItemsExtra.badgeType;
            }
            int i6 = i2;
            if ((i5 & 8) != 0) {
                i3 = serviceItemsExtra.serviceCategoryID;
            }
            int i7 = i3;
            if ((i5 & 16) != 0) {
                i4 = serviceItemsExtra.buttonNavigationType;
            }
            int i8 = i4;
            if ((i5 & 32) != 0) {
                str2 = serviceItemsExtra.buttonText;
            }
            String str4 = str2;
            if ((i5 & 64) != 0) {
                list = serviceItemsExtra.servicesIDs;
            }
            return serviceItemsExtra.copy(i, str3, i6, i7, i8, str4, list);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSectionID() {
            return this.sectionID;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final int getBadgeType() {
            return this.badgeType;
        }

        /* renamed from: component4, reason: from getter */
        public final int getServiceCategoryID() {
            return this.serviceCategoryID;
        }

        /* renamed from: component5, reason: from getter */
        public final int getButtonNavigationType() {
            return this.buttonNavigationType;
        }

        /* renamed from: component6, reason: from getter */
        public final String getButtonText() {
            return this.buttonText;
        }

        public final List<Integer> component7() {
            return this.servicesIDs;
        }

        public final ServiceItemsExtra copy(int sectionID, String title, int badgeType, int serviceCategoryID, int buttonNavigationType, String buttonText, List<Integer> servicesIDs) {
            AbstractC13042fc3.i(title, "title");
            AbstractC13042fc3.i(buttonText, "buttonText");
            AbstractC13042fc3.i(servicesIDs, "servicesIDs");
            return new ServiceItemsExtra(sectionID, title, badgeType, serviceCategoryID, buttonNavigationType, buttonText, servicesIDs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServiceItemsExtra)) {
                return false;
            }
            ServiceItemsExtra serviceItemsExtra = (ServiceItemsExtra) other;
            return this.sectionID == serviceItemsExtra.sectionID && AbstractC13042fc3.d(this.title, serviceItemsExtra.title) && this.badgeType == serviceItemsExtra.badgeType && this.serviceCategoryID == serviceItemsExtra.serviceCategoryID && this.buttonNavigationType == serviceItemsExtra.buttonNavigationType && AbstractC13042fc3.d(this.buttonText, serviceItemsExtra.buttonText) && AbstractC13042fc3.d(this.servicesIDs, serviceItemsExtra.servicesIDs);
        }

        public final int getBadgeType() {
            return this.badgeType;
        }

        public final int getButtonNavigationType() {
            return this.buttonNavigationType;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public int getSectionID() {
            return this.sectionID;
        }

        public final int getServiceCategoryID() {
            return this.serviceCategoryID;
        }

        public final List<Integer> getServicesIDs() {
            return this.servicesIDs;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((((((((((Integer.hashCode(this.sectionID) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.badgeType)) * 31) + Integer.hashCode(this.serviceCategoryID)) * 31) + Integer.hashCode(this.buttonNavigationType)) * 31) + this.buttonText.hashCode()) * 31) + this.servicesIDs.hashCode();
        }

        public String toString() {
            return "ServiceItemsExtra(title=" + getTitle() + ", servicesIDs=" + this.servicesIDs + ", badgeType=" + this.badgeType + ", serviceCategoryID=" + this.serviceCategoryID + ", buttonNavigationType=" + this.buttonNavigationType + ", buttonText=" + this.buttonText + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H×\u0003J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$Shortcut;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "sectionID", "", "title", "", "<init>", "(ILjava/lang/String;)V", "getSectionID", "()I", "getTitle", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class Shortcut extends ServicesPageSectionEntity {
        public static final int $stable = 0;
        private final int sectionID;
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public Shortcut(int i, String str) {
            AbstractC13042fc3.i(str, "title");
            String name = Shortcut.class.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            super(name, null);
            this.sectionID = i;
            this.title = str;
        }

        public static /* synthetic */ Shortcut copy$default(Shortcut shortcut, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = shortcut.sectionID;
            }
            if ((i2 & 2) != 0) {
                str = shortcut.title;
            }
            return shortcut.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSectionID() {
            return this.sectionID;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final Shortcut copy(int sectionID, String title) {
            AbstractC13042fc3.i(title, "title");
            return new Shortcut(sectionID, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Shortcut)) {
                return false;
            }
            Shortcut shortcut = (Shortcut) other;
            return this.sectionID == shortcut.sectionID && AbstractC13042fc3.d(this.title, shortcut.title);
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public int getSectionID() {
            return this.sectionID;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (Integer.hashCode(this.sectionID) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "Shortcut(title=" + getTitle() + Separators.RPAREN;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H×\u0003J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity$Wallet;", "Lir/nasim/features/bank/mybank/model/ServicesPageSectionEntity;", "sectionID", "", "title", "", "<init>", "(ILjava/lang/String;)V", "getSectionID", "()I", "getTitle", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KeepName
    public static final /* data */ class Wallet extends ServicesPageSectionEntity {
        public static final int $stable = 0;
        private final int sectionID;
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public Wallet(int i, String str) {
            AbstractC13042fc3.i(str, "title");
            String name = Wallet.class.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            super(name, null);
            this.sectionID = i;
            this.title = str;
        }

        public static /* synthetic */ Wallet copy$default(Wallet wallet, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = wallet.sectionID;
            }
            if ((i2 & 2) != 0) {
                str = wallet.title;
            }
            return wallet.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSectionID() {
            return this.sectionID;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final Wallet copy(int sectionID, String title) {
            AbstractC13042fc3.i(title, "title");
            return new Wallet(sectionID, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Wallet)) {
                return false;
            }
            Wallet wallet = (Wallet) other;
            return this.sectionID == wallet.sectionID && AbstractC13042fc3.d(this.title, wallet.title);
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public int getSectionID() {
            return this.sectionID;
        }

        @Override // ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (Integer.hashCode(this.sectionID) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "Wallet(title=" + getTitle() + Separators.RPAREN;
        }
    }

    public /* synthetic */ ServicesPageSectionEntity(String str, ED1 ed1) {
        this(str);
    }

    public abstract int getSectionID();

    public abstract String getTitle();

    public final String getType() {
        return this.type;
    }

    private ServicesPageSectionEntity(String str) {
        this.type = str;
    }
}
