package ir.resaneh1.iptv.fragment.home;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import ir.resaneh1.iptv.fragment.home.sectionInfo.BottomInfoCell;
import ir.resaneh1.iptv.fragment.home.sectionInfo.DummyIndicator;
import ir.resaneh1.iptv.fragment.home.sectionInfo.HeaderInfoCell;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.CardViewObject;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: HomeCell.kt */
/* loaded from: classes3.dex */
public abstract class HomeCell extends CardView {
    private final Lazy bottomInfoCell$delegate;
    private final Lazy bottomInfoCellTransparent$delegate;
    private final Lazy dummyIndicator$delegate;
    private final Lazy frameLayout$delegate;
    private final Lazy headerInfoCell$delegate;
    private final Lazy linearLayout$delegate;

    /* compiled from: HomeCell.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[HomePageModels.SectionTypeEnum.values().length];
            iArr[HomePageModels.SectionTypeEnum.Live.ordinal()] = 1;
            iArr[HomePageModels.SectionTypeEnum.Prediction.ordinal()] = 2;
            iArr[HomePageModels.SectionTypeEnum.Container.ordinal()] = 3;
            iArr[HomePageModels.SectionTypeEnum.Banner.ordinal()] = 4;
            iArr[HomePageModels.SectionTypeEnum.Feed.ordinal()] = 5;
            iArr[HomePageModels.SectionTypeEnum.Parallax.ordinal()] = 6;
            iArr[HomePageModels.SectionTypeEnum.Music.ordinal()] = 7;
            iArr[HomePageModels.SectionTypeEnum.AllServices.ordinal()] = 8;
            iArr[HomePageModels.SectionTypeEnum.UserFavoriteServices.ordinal()] = 9;
            iArr[HomePageModels.SectionTypeEnum.ViewTag.ordinal()] = 10;
            iArr[HomePageModels.SectionTypeEnum.TextBox.ordinal()] = 11;
            iArr[HomePageModels.SectionTypeEnum.Ad.ordinal()] = 12;
            iArr[HomePageModels.SectionTypeEnum.Collection.ordinal()] = 13;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HomePageModels.BorderInfoType.values().length];
            iArr2[HomePageModels.BorderInfoType.CardBorder.ordinal()] = 1;
            iArr2[HomePageModels.BorderInfoType.NoBorder.ordinal()] = 2;
            iArr2[HomePageModels.BorderInfoType.Flat.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[CardViewObject.ShadowTypeEnum.values().length];
            iArr3[CardViewObject.ShadowTypeEnum.None.ordinal()] = 1;
            iArr3[CardViewObject.ShadowTypeEnum.Small.ordinal()] = 2;
            iArr3[CardViewObject.ShadowTypeEnum.Medium.ordinal()] = 3;
            iArr3[CardViewObject.ShadowTypeEnum.Big.ordinal()] = 4;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private final void setIndicators(HomePageModels.IndicatorInfoObject indicatorInfoObject) {
    }

    public abstract View createMainView(Context context);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeCell(final Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.headerInfoCell$delegate = LazyKt__LazyJVMKt.lazy(new Function0<HeaderInfoCell>() { // from class: ir.resaneh1.iptv.fragment.home.HomeCell$headerInfoCell$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HeaderInfoCell invoke() {
                return new HeaderInfoCell(context);
            }
        });
        this.linearLayout$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: ir.resaneh1.iptv.fragment.home.HomeCell$linearLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return new LinearLayout(context);
            }
        });
        this.frameLayout$delegate = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: ir.resaneh1.iptv.fragment.home.HomeCell$frameLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return new FrameLayout(context);
            }
        });
        this.bottomInfoCell$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BottomInfoCell>() { // from class: ir.resaneh1.iptv.fragment.home.HomeCell$bottomInfoCell$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomInfoCell invoke() {
                return new BottomInfoCell(context);
            }
        });
        this.bottomInfoCellTransparent$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BottomInfoCell>() { // from class: ir.resaneh1.iptv.fragment.home.HomeCell$bottomInfoCellTransparent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomInfoCell invoke() {
                return new BottomInfoCell(context);
            }
        });
        this.dummyIndicator$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DummyIndicator>() { // from class: ir.resaneh1.iptv.fragment.home.HomeCell$dummyIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DummyIndicator invoke() {
                return new DummyIndicator(context);
            }
        });
        setRadius(AndroidUtilities.dp(8.0f));
        setCardBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        getLinearLayout().setOrientation(1);
        getLinearLayout().addView(getHeaderInfoCell(), LayoutHelper.createLinear(-1, -2, 8.0f, 4.0f, 8.0f, 4.0f));
        getLinearLayout().addView(createMainView(context));
        getLinearLayout().addView(getBottomInfoCell(), LayoutHelper.createLinear(-1, -2, 16.0f, 8.0f, 16.0f, 8.0f));
        getLinearLayout().addView(getDummyIndicator(), LayoutHelper.createLinear(-2, -2, 17));
        getDummyIndicator().setVisibility(8);
        getFrameLayout().addView(getLinearLayout(), LayoutHelper.createFrame(-1, -2, 17));
        getFrameLayout().addView(getBottomInfoCellTransparent(), LayoutHelper.createFrame(-1, -2.0f, 80, 16.0f, 16.0f, 16.0f, 16.0f));
        addView(getFrameLayout());
    }

    public final HeaderInfoCell getHeaderInfoCell() {
        return (HeaderInfoCell) this.headerInfoCell$delegate.getValue();
    }

    private final LinearLayout getLinearLayout() {
        return (LinearLayout) this.linearLayout$delegate.getValue();
    }

    protected final FrameLayout getFrameLayout() {
        return (FrameLayout) this.frameLayout$delegate.getValue();
    }

    public final BottomInfoCell getBottomInfoCell() {
        return (BottomInfoCell) this.bottomInfoCell$delegate.getValue();
    }

    private final BottomInfoCell getBottomInfoCellTransparent() {
        return (BottomInfoCell) this.bottomInfoCellTransparent$delegate.getValue();
    }

    public final DummyIndicator getDummyIndicator() {
        return (DummyIndicator) this.dummyIndicator$delegate.getValue();
    }

    public final void setSectionInfoData(HomePageModels.CommonSectionDataObject commonSectionDataObject, HomePageModels.SectionTypeEnum sectionTypeEnum) {
        Unit unit;
        HomePageModels.IndicatorInfoObject indicatorInfoObject;
        Unit unit2;
        VisibilityHelper.showViews(this);
        if (commonSectionDataObject == null) {
            unit = null;
        } else {
            if (needBottomData(sectionTypeEnum)) {
                setBottomData(commonSectionDataObject.bottom_info, sectionTypeEnum);
            } else {
                VisibilityHelper.hideViews(getBottomInfoCell(), getBottomInfoCellTransparent());
            }
            if (needHeaderData(sectionTypeEnum)) {
                setHeaderData(commonSectionDataObject.header_info);
            } else {
                VisibilityHelper.hideViews(getHeaderInfoCell());
            }
            if (needBorderData(sectionTypeEnum)) {
                setBorders(commonSectionDataObject.border_info);
            } else {
                setDefaultBorders(sectionTypeEnum);
            }
            HomePageModels.MarginInfoObject marginInfoObject = commonSectionDataObject.margin_info;
            if (marginInfoObject != null) {
                setMargin(marginInfoObject, sectionTypeEnum);
            } else {
                setDefaultMargins(sectionTypeEnum);
            }
            if (needIndicatorInfoData(sectionTypeEnum) && (indicatorInfoObject = commonSectionDataObject.indicator_info) != null) {
                setIndicators(indicatorInfoObject);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            if (sectionTypeEnum == null) {
                unit2 = null;
            } else {
                HomePageModels.SectionTypeEnum sectionTypeEnum2 = HomePageModels.SectionTypeEnum.Slider;
                if (sectionTypeEnum == sectionTypeEnum2) {
                    setDefaultBorders(sectionTypeEnum2);
                } else {
                    setDefaultBorders(null);
                }
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                setDefaultBorders(null);
            }
            setDefaultMargins(sectionTypeEnum);
        }
    }

    private final boolean needBorderData(HomePageModels.SectionTypeEnum sectionTypeEnum) {
        if (sectionTypeEnum == null) {
            return false;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[sectionTypeEnum.ordinal()]) {
        }
        return false;
    }

    private final boolean needHeaderData(HomePageModels.SectionTypeEnum sectionTypeEnum) {
        if (sectionTypeEnum == null) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[sectionTypeEnum.ordinal()];
        if (i != 1 && i != 3 && i != 6) {
            switch (i) {
            }
            return false;
        }
        return true;
    }

    private final boolean needBottomData(HomePageModels.SectionTypeEnum sectionTypeEnum) {
        if (sectionTypeEnum == null) {
            return false;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[sectionTypeEnum.ordinal()]) {
        }
        return false;
    }

    private final boolean needIndicatorInfoData(HomePageModels.SectionTypeEnum sectionTypeEnum) {
        if (sectionTypeEnum == null) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[sectionTypeEnum.ordinal()];
        return i == 9 || i == 12;
    }

    private final void setBorders(HomePageModels.BorderInfoObject borderInfoObject) {
        Unit unit;
        if (borderInfoObject == null) {
            unit = null;
        } else {
            HomePageModels.BorderInfoType borderInfoType = borderInfoObject.type;
            int i = borderInfoType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[borderInfoType.ordinal()];
            if (i == 1) {
                setRadius(AndroidUtilities.dp(borderInfoObject.radius * 100));
                setCustomElevation(borderInfoObject);
            } else if (i == 2) {
                setRadius(0.0f);
                setCustomElevation(borderInfoObject);
            } else if (i == 3) {
                setRadius(0.0f);
                setCardElevation(0.0f);
            } else {
                setDefaultBorders(null);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setDefaultBorders(null);
        }
    }

    private final void setDefaultBorders(HomePageModels.SectionTypeEnum sectionTypeEnum) {
        Unit unit;
        if (sectionTypeEnum == null) {
            unit = null;
        } else {
            if (sectionTypeEnum == HomePageModels.SectionTypeEnum.Slider || sectionTypeEnum == HomePageModels.SectionTypeEnum.Collection) {
                setRadius(0.0f);
                setCardElevation(AndroidUtilities.dp(0.0f));
            } else {
                setRadius(AndroidUtilities.dp(8.0f));
                setCardElevation(AndroidUtilities.dp(8.0f));
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setRadius(AndroidUtilities.dp(8.0f));
            setCardElevation(AndroidUtilities.dp(8.0f));
        }
    }

    private final void setCustomElevation(HomePageModels.BorderInfoObject borderInfoObject) {
        float f;
        int iDp;
        CardViewObject.ShadowTypeEnum shadowTypeEnum = borderInfoObject.shadow.type;
        int i = shadowTypeEnum == null ? -1 : WhenMappings.$EnumSwitchMapping$2[shadowTypeEnum.ordinal()];
        if (i != 1) {
            if (i == 2) {
                iDp = AndroidUtilities.dp(2.0f);
            } else if (i != 3 && i == 4) {
                iDp = AndroidUtilities.dp(8.0f);
            } else {
                iDp = AndroidUtilities.dp(4.0f);
            }
            f = iDp;
        } else {
            f = 0.0f;
        }
        setCardElevation(f);
    }

    private final void setDefaultMargins(HomePageModels.SectionTypeEnum sectionTypeEnum) {
        Unit unit;
        if (sectionTypeEnum == null) {
            unit = null;
        } else {
            if (sectionTypeEnum == HomePageModels.SectionTypeEnum.Ad) {
                setMargins(0.0f, 6.0f, 0.0f, 6.0f);
            } else if (sectionTypeEnum != HomePageModels.SectionTypeEnum.Collection) {
                setMargins(8.0f, 6.0f, 8.0f, 6.0f);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setMargins(8.0f, 6.0f, 8.0f, 6.0f);
        }
    }

    private final void setMargin(HomePageModels.MarginInfoObject marginInfoObject, HomePageModels.SectionTypeEnum sectionTypeEnum) {
        Unit unit = null;
        if (marginInfoObject != null) {
            if (sectionTypeEnum != null) {
                if (sectionTypeEnum == HomePageModels.SectionTypeEnum.Ad) {
                    float f = 100;
                    setMargins(0.0f, marginInfoObject.top * f, 0.0f, marginInfoObject.bottom * f);
                } else if (sectionTypeEnum != HomePageModels.SectionTypeEnum.Collection) {
                    float f2 = 100;
                    setMargins(marginInfoObject.left * f2, marginInfoObject.top * f2, marginInfoObject.right * f2, marginInfoObject.bottom * f2);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                float f3 = 100;
                setMargins(marginInfoObject.left * f3, marginInfoObject.top * f3, marginInfoObject.right * f3, marginInfoObject.bottom * f3);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setDefaultMargins(sectionTypeEnum);
        }
    }

    private final void setHeaderData(HomePageModels.HeaderInfoObject headerInfoObject) {
        getHeaderInfoCell().setData(headerInfoObject);
    }

    private final boolean canSetTransparentBottomInfo(HomePageModels.SectionTypeEnum sectionTypeEnum) {
        int i;
        return (sectionTypeEnum == null || (i = WhenMappings.$EnumSwitchMapping$0[sectionTypeEnum.ordinal()]) == 2 || i == 3 || i == 13) ? false : true;
    }

    private final void setBottomData(HomePageModels.BottomInfoObject bottomInfoObject, HomePageModels.SectionTypeEnum sectionTypeEnum) {
        Unit unit;
        if (bottomInfoObject == null) {
            unit = null;
        } else {
            if (bottomInfoObject.is_transparent) {
                if (canSetTransparentBottomInfo(sectionTypeEnum)) {
                    VisibilityHelper.showViews(getBottomInfoCellTransparent());
                    VisibilityHelper.hideViews(getBottomInfoCell());
                    getBottomInfoCellTransparent().setData(bottomInfoObject);
                } else {
                    VisibilityHelper.hideViews(getBottomInfoCellTransparent());
                    VisibilityHelper.hideViews(getBottomInfoCell());
                }
            } else {
                VisibilityHelper.showViews(getBottomInfoCell());
                VisibilityHelper.hideViews(getBottomInfoCell());
                getBottomInfoCell().setData(bottomInfoObject);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            VisibilityHelper.hideViews(getBottomInfoCell(), getBottomInfoCellTransparent());
        }
    }

    public final void setCollectionInfo(HomePageModels.CommonSectionDataObject commonSectionDataObject, boolean z, boolean z2) {
        HomePageModels.MarginInfoObject marginInfoObject;
        Unit unit = null;
        if (z) {
            VisibilityHelper.showViews(getHeaderInfoCell());
            setHeaderData(commonSectionDataObject == null ? null : commonSectionDataObject.header_info);
        } else {
            VisibilityHelper.hideViews(getHeaderInfoCell());
        }
        if (z2) {
            setBottomData(commonSectionDataObject == null ? null : commonSectionDataObject.bottom_info, HomePageModels.SectionTypeEnum.Collection);
        } else {
            VisibilityHelper.hideViews(getBottomInfoCell(), getBottomInfoCellTransparent());
        }
        if (commonSectionDataObject != null && (marginInfoObject = commonSectionDataObject.margin_info) != null) {
            setCollectionMargins(marginInfoObject, z, z2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            setDefaultMargins(HomePageModels.SectionTypeEnum.Collection);
        }
    }

    private final void setCollectionMargins(HomePageModels.MarginInfoObject marginInfoObject, boolean z, boolean z2) {
        if (z && z2) {
            float f = 100;
            setMargins(marginInfoObject.left * f, marginInfoObject.top * f, marginInfoObject.right * f, marginInfoObject.bottom * f);
        } else if (z) {
            float f2 = 100;
            setMargins(marginInfoObject.left * f2, marginInfoObject.top * f2, marginInfoObject.right * f2, 0.0f);
        } else if (z2) {
            float f3 = 100;
            setMargins(marginInfoObject.left * f3, 0.0f, marginInfoObject.right * f3, marginInfoObject.bottom * f3);
        } else {
            float f4 = 100;
            setMargins(marginInfoObject.left * f4, 0.0f, marginInfoObject.right * f4, 0.0f);
        }
    }

    public final void setServiceInfo(HomePageModels.CommonSectionDataObject commonSectionDataObject, HomePageModels.SectionTypeEnum typeEnum, boolean z) {
        Intrinsics.checkNotNullParameter(typeEnum, "typeEnum");
        setSectionInfoData(commonSectionDataObject, typeEnum);
        if (!z) {
            VisibilityHelper.hideViews(getHeaderInfoCell());
        } else if (getHeaderInfoCell().getVisibility() != 0) {
            VisibilityHelper.showViews(getHeaderInfoCell());
            getHeaderInfoCell().setServiceButtonImageView();
        }
    }

    private final void setMargins(float f, float f2, float f3, float f4) {
        ir.appp.common.utils.LayoutHelper.setMargins(this, AndroidUtilities.dp(f), AndroidUtilities.dp(f2), AndroidUtilities.dp(f3), AndroidUtilities.dp(f4));
    }
}
