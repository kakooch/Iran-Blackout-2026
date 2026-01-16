package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.TextViewObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ViewObjectAttr {
    public DynamicPageButtonObject button;
    public ClickTypeEnum click_type;
    public boolean disable_in_progress;
    public boolean isInProgress = false;
    public boolean isLoading = false;
    public boolean is_hide;
    public String itemName;
    public LoadingTypeEnum loading_type;
    public ArrayList<DynamicPageCommandObject> local_click_commands;
    public ArrayList<MenuOptionObject> menu;
    public ColorObject text_color;
    public long text_edit_change_delay;
    public String text_edit_hint;
    public ColorObject text_edit_hint_color;
    public TextViewObject.KeyboardTypeEnum text_edit_keyboard_type;
    public int text_edit_max_char;
    public boolean text_edit_read_only;
    public TextViewObject.StyleEnum text_edit_style;
    public ColorObject text_edit_style_color;
    public float text_font;
    public TextViewObject.ViewGravityEnum text_h_align;
    public int text_max_line;
    public TextViewObject.FontTypeEnum text_type;
    public TextViewObject.ViewGravityEnum text_v_align;
    public String track_id;
    public ApiCallTypeEnum type_api_call;

    public enum ApiCallTypeEnum {
        Later,
        NowAlone,
        AllQueue
    }

    public enum ClickTypeEnum {
        None,
        ApiClick,
        LocalClick,
        Menu,
        Button
    }

    public enum LoadingTypeEnum {
        None,
        Inline,
        Center
    }

    public void editYourSelf(ViewObjectAttr viewObjectAttr) {
        ClickTypeEnum clickTypeEnum = viewObjectAttr.click_type;
        if (clickTypeEnum != null) {
            this.click_type = clickTypeEnum;
        }
        String str = viewObjectAttr.track_id;
        if (str != null) {
            this.track_id = str;
        }
        this.is_hide = viewObjectAttr.is_hide;
        ArrayList<MenuOptionObject> arrayList = viewObjectAttr.menu;
        if (arrayList != null) {
            this.menu = arrayList;
        }
        LoadingTypeEnum loadingTypeEnum = viewObjectAttr.loading_type;
        if (loadingTypeEnum != null) {
            this.loading_type = loadingTypeEnum;
        }
        this.disable_in_progress = viewObjectAttr.disable_in_progress;
        DynamicPageButtonObject dynamicPageButtonObject = viewObjectAttr.button;
        if (dynamicPageButtonObject != null) {
            this.button = dynamicPageButtonObject;
        }
        ArrayList<DynamicPageCommandObject> arrayList2 = viewObjectAttr.local_click_commands;
        if (arrayList2 != null) {
            this.local_click_commands = arrayList2;
        }
        String str2 = viewObjectAttr.text_edit_hint;
        if (str2 != null) {
            this.text_edit_hint = str2;
        }
        this.text_edit_change_delay = viewObjectAttr.text_edit_change_delay;
        this.text_edit_read_only = viewObjectAttr.text_edit_read_only;
        ApiCallTypeEnum apiCallTypeEnum = viewObjectAttr.type_api_call;
        if (apiCallTypeEnum != null) {
            this.type_api_call = apiCallTypeEnum;
        }
        this.text_font = viewObjectAttr.text_font;
        ColorObject colorObject = viewObjectAttr.text_color;
        if (colorObject != null) {
            this.text_color = colorObject;
        }
        TextViewObject.ViewGravityEnum viewGravityEnum = viewObjectAttr.text_h_align;
        if (viewGravityEnum != null) {
            this.text_h_align = viewGravityEnum;
        }
        TextViewObject.ViewGravityEnum viewGravityEnum2 = viewObjectAttr.text_v_align;
        if (viewGravityEnum2 != null) {
            this.text_v_align = viewGravityEnum2;
        }
        this.text_max_line = viewObjectAttr.text_max_line;
        TextViewObject.FontTypeEnum fontTypeEnum = viewObjectAttr.text_type;
        if (fontTypeEnum != null) {
            this.text_type = fontTypeEnum;
        }
        ColorObject colorObject2 = viewObjectAttr.text_edit_hint_color;
        if (colorObject2 != null) {
            this.text_edit_hint_color = colorObject2;
        }
        TextViewObject.KeyboardTypeEnum keyboardTypeEnum = viewObjectAttr.text_edit_keyboard_type;
        if (keyboardTypeEnum != null) {
            this.text_edit_keyboard_type = keyboardTypeEnum;
        }
        this.text_edit_max_char = viewObjectAttr.text_edit_max_char;
    }
}
