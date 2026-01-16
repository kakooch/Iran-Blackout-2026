package ir.resaneh1.iptv.fragment.home.textBox;

import android.content.Context;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidMessenger.helper.GlideHelper;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.barcode.BarcodeHelper;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.Link;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: TextBoxCell.kt */
/* loaded from: classes3.dex */
public final class TextBoxCell extends HomeCell {
    private HomePageModels.TextBoxSectionObject cachedTextBox;
    private EditText editText;
    private Runnable linkRunnable;
    private final int placeHolderRes;
    private ImageView rightImageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextBoxCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.placeHolderRes = R.drawable.transparent;
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initViews(context);
        FrameLayout frameLayout = new FrameLayout(context);
        EditText editText = this.editText;
        ImageView imageView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        frameLayout.addView(editText, LayoutHelper.createFrame(-1, -2.0f, 19, 8.0f, 0.0f, 16 + 40.0f, 0.0f));
        ImageView imageView2 = this.rightImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightImageView");
        } else {
            imageView = imageView2;
        }
        frameLayout.addView(imageView, LayoutHelper.createFrame((int) 40.0f, 40.0f, 21, 0.0f, 8.0f, 8.0f, 8.0f));
        return frameLayout;
    }

    private final void initViews(Context context) {
        ImageView imageView = new ImageView(context);
        this.rightImageView = imageView;
        imageView.setPadding(8, 8, 8, 8);
        EditText editText = new EditText(context);
        this.editText = editText;
        ImageView imageView2 = null;
        editText.setBackground(null);
        EditText editText2 = this.editText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText2 = null;
        }
        editText2.setSingleLine(true);
        EditText editText3 = this.editText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText3 = null;
        }
        editText3.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        EditText editText4 = this.editText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText4 = null;
        }
        editText4.setPadding(0, 0, 0, 0);
        EditText editText5 = this.editText;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText5 = null;
        }
        editText5.setTextSize(15.0f);
        EditText editText6 = this.editText;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText6 = null;
        }
        editText6.setTypeface(Theme.getHomePageTypeFaceRegular());
        EditText editText7 = this.editText;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText7 = null;
        }
        editText7.setFocusable(true);
        EditText editText8 = this.editText;
        if (editText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText8 = null;
        }
        editText8.setGravity(5);
        EditText editText9 = this.editText;
        if (editText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText9 = null;
        }
        editText9.setOnKeyListener(new View.OnKeyListener() { // from class: ir.resaneh1.iptv.fragment.home.textBox.TextBoxCell.initViews.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (!(keyEvent != null && keyEvent.getAction() == 0) || i != 66) {
                    return false;
                }
                TextBoxCell.this.onClick();
                return true;
            }
        });
        ImageView imageView3 = this.rightImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightImageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.textBox.TextBoxCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextBoxCell.m471initViews$lambda0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initViews$lambda-0, reason: not valid java name */
    public static final void m471initViews$lambda0(TextBoxCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onClick();
    }

    public final Runnable getLinkRunnable() {
        return this.linkRunnable;
    }

    public final void setLinkRunnable(Runnable runnable) {
        this.linkRunnable = runnable;
    }

    public final void onClick() {
        Link link;
        HomePageModels.TextBoxSectionObject textBoxSectionObject = this.cachedTextBox;
        if (((textBoxSectionObject == null || (link = textBoxSectionObject.action_link) == null) ? null : link.type) == Link.LinkTypeEnum.barcodescan) {
            onBarcodeClick(textBoxSectionObject != null ? textBoxSectionObject.action_link : null);
        } else {
            HomePageActivityNew.onLinkClick(textBoxSectionObject != null ? textBoxSectionObject.action_link : null);
        }
    }

    public final void onBarcodeClick(Link link) {
        if (link == null) {
            return;
        }
        if (this.linkRunnable != null) {
            Utilities.stageQueue.cancelRunnable(this.linkRunnable);
        }
        this.linkRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.textBox.TextBoxCell$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TextBoxCell.m472onBarcodeClick$lambda1(this.f$0);
            }
        };
        Utilities.stageQueue.postRunnable(this.linkRunnable, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBarcodeClick$lambda-1, reason: not valid java name */
    public static final void m472onBarcodeClick$lambda1(TextBoxCell this$0) {
        Link link;
        Link.BarcodescanData barcodescanData;
        Link link2;
        Link.BarcodescanData barcodescanData2;
        Link link3;
        Link.BarcodescanData barcodescanData3;
        Link link4;
        Link.BarcodescanData barcodescanData4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = UserConfig.selectedAccount;
        HomePageModels.TextBoxSectionObject textBoxSectionObject = this$0.cachedTextBox;
        String str = ((textBoxSectionObject == null || (link = textBoxSectionObject.action_link) == null || (barcodescanData = link.barcodescan_data) == null) ? null : barcodescanData.type);
        HomePageModels.TextBoxSectionObject textBoxSectionObject2 = this$0.cachedTextBox;
        String str2 = (textBoxSectionObject2 == null || (link2 = textBoxSectionObject2.action_link) == null || (barcodescanData2 = link2.barcodescan_data) == null) ? null : barcodescanData2.barcode;
        EditText editText = this$0.editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText = null;
        }
        String string = editText.getText().toString();
        HomePageModels.TextBoxSectionObject textBoxSectionObject3 = this$0.cachedTextBox;
        BarcodeHelper.requestBarcodeAction(i, str, str2, string, null, (textBoxSectionObject3 == null || (link3 = textBoxSectionObject3.action_link) == null || (barcodescanData3 = link3.barcodescan_data) == null) ? null : barcodescanData3.success_payment_return_link, (textBoxSectionObject3 == null || (link4 = textBoxSectionObject3.action_link) == null || (barcodescanData4 = link4.barcodescan_data) == null) ? null : barcodescanData4.success_payment_return_text);
    }

    public final void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.TextBoxSectionObject textBoxSectionObject;
        resetData();
        if (homePageSectionObject == null || (textBoxSectionObject = homePageSectionObject.text_box_section) == null) {
            return;
        }
        this.cachedTextBox = textBoxSectionObject;
        String str = textBoxSectionObject.icon_url;
        EditText editText = null;
        if (!(str == null || str.length() == 0)) {
            Context context = getContext();
            ImageView imageView = this.rightImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightImageView");
                imageView = null;
            }
            GlideHelper.load(context, imageView, textBoxSectionObject.icon_url, this.placeHolderRes);
        }
        String str2 = textBoxSectionObject.place_holder;
        if (!(str2 == null || str2.length() == 0)) {
            EditText editText2 = this.editText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                editText2 = null;
            }
            editText2.setHint(textBoxSectionObject.place_holder);
        }
        String str3 = textBoxSectionObject.place_holder_color_code;
        if (!(str3 == null || str3.length() == 0)) {
            EditText editText3 = this.editText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
            } else {
                editText = editText3;
            }
            editText.setHintTextColor(Color.parseColor(textBoxSectionObject.place_holder_color_code));
        }
        setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
    }

    private final void resetData() {
        EditText editText = null;
        this.cachedTextBox = null;
        ImageView imageView = this.rightImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightImageView");
            imageView = null;
        }
        imageView.setImageDrawable(null);
        EditText editText2 = this.editText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText2 = null;
        }
        editText2.getText().clear();
        EditText editText3 = this.editText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            editText = editText3;
        }
        editText.setHint(BuildConfig.FLAVOR);
    }
}
