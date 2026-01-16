package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.MiniFunctionModels;

/* loaded from: classes3.dex */
public class MiniFunctionObject {
    public MiniFunctionModels.ButtonAlert button_alert;
    public MiniFunctionModels.ButtonCalendar button_calendar;
    public MiniFunctionModels.ButtonCall button_call;
    public Link button_link;
    public MiniFunctionModels.ButtonLocation button_location;
    public MiniFunctionModels.ButtonNumberPicker button_number_picker;
    public MiniFunctionModels.ButtonPayment button_payment;
    public MiniFunctionModels.ButtonSelection button_selection;
    public MiniFunctionModels.ButtonSMS button_sms;
    public MiniFunctionModels.ButtonStringPicker button_string_picker;
    public MiniFunctionModels.ButtonEditText button_textbox;
    public FileUploadProperties file_upload_properties;
    public MiniFunctionModels.ButtonType type = MiniFunctionModels.ButtonType.Simple;
    private Boolean isOpenExternalPage = null;

    public String getTitle() {
        return BuildConfig.FLAVOR;
    }

    public boolean isButtonSwitchInline() {
        return false;
    }

    public String getTitleForDialogPicker() {
        MiniFunctionModels.ButtonLocation buttonLocation;
        String str;
        MiniFunctionModels.ButtonEditText buttonEditText;
        String str2;
        MiniFunctionModels.ButtonStringPicker buttonStringPicker;
        String str3;
        MiniFunctionModels.ButtonNumberPicker buttonNumberPicker;
        String str4;
        MiniFunctionModels.ButtonCalendar buttonCalendar;
        String str5;
        MiniFunctionModels.ButtonSelection buttonSelection;
        String str6;
        if (this.type == MiniFunctionModels.ButtonType.Selection && (buttonSelection = this.button_selection) != null && (str6 = buttonSelection.title) != null && !str6.isEmpty()) {
            return this.button_selection.title;
        }
        if (this.type == MiniFunctionModels.ButtonType.Calendar && (buttonCalendar = this.button_calendar) != null && (str5 = buttonCalendar.title) != null && !str5.isEmpty()) {
            return this.button_calendar.title;
        }
        if (this.type == MiniFunctionModels.ButtonType.NumberPicker && (buttonNumberPicker = this.button_number_picker) != null && (str4 = buttonNumberPicker.title) != null && !str4.isEmpty()) {
            return this.button_number_picker.title;
        }
        if (this.type == MiniFunctionModels.ButtonType.StringPicker && (buttonStringPicker = this.button_string_picker) != null && (str3 = buttonStringPicker.title) != null && !str3.isEmpty()) {
            return this.button_string_picker.title;
        }
        if (this.type == MiniFunctionModels.ButtonType.Textbox && (buttonEditText = this.button_textbox) != null && (str2 = buttonEditText.title) != null && !str2.isEmpty()) {
            return this.button_textbox.title;
        }
        if (this.type == MiniFunctionModels.ButtonType.Location && (buttonLocation = this.button_location) != null && (str = buttonLocation.title) != null && !str.isEmpty()) {
            return this.button_location.title;
        }
        return getTitle();
    }
}
