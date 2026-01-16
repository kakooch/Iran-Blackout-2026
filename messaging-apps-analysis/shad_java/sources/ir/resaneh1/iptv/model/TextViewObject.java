package ir.resaneh1.iptv.model;

import android.graphics.Typeface;

/* loaded from: classes3.dex */
public class TextViewObject extends SimpleViewObject {
    public ColorObject color;
    public float dynamic_height_bottom_space;
    public float font;
    private float fontSizePx;
    public ViewGravityEnum h_align;
    public boolean has_placeholder;
    public HeightTypeEnum height_type;
    public ColorObject hint_color;
    public boolean is_editable;
    public KeyboardTypeEnum keyboard_type;
    public int max_line;
    public String placeholder_text;
    public String text;
    public int text_edit_max_char;
    public StyleEnum text_edit_style;
    public ColorObject text_edit_style_color;
    public FontTypeEnum type;
    public Typeface typeface;
    public ViewGravityEnum v_align;

    public enum FontTypeEnum {
        Bold,
        Regular
    }

    public enum HeightTypeEnum {
        Fix,
        DynamicTextView,
        DynamicView
    }

    public enum KeyboardTypeEnum {
        Number,
        Text
    }

    public enum StyleEnum {
        Normal,
        Line
    }

    public enum ViewGravityEnum {
        Left,
        Right,
        Middle,
        Top,
        Bottom
    }
}
