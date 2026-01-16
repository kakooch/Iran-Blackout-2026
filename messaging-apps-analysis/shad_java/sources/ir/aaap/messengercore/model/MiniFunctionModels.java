package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.BotButtonObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MiniFunctionModels {

    public static class ButtonAlert {
        public String message;
    }

    public static class ButtonCalendar {
        public String default_value;
        public String title;
        public Type type;
        public int min_year = 0;
        public int max_year = 0;

        public enum Type {
            DatePersian,
            DateGregorian
        }
    }

    public static class ButtonCall {
        public String phone_number;
    }

    public static class ButtonEditText {
        public String default_value;
        public String place_holder;
        public String title;
        public TypeKeypad type_keypad;
        public TypeLine type_line;

        public enum TypeKeypad {
            String,
            Number
        }

        public enum TypeLine {
            SingleLine,
            MultiLine
        }
    }

    public static class ButtonLocation {
        public LocationObject default_map_location;
        public LocationObject default_pointer_location;
        public String location_image_url;
        public String title;
        public Type type;

        public enum Type {
            Picker,
            View
        }
    }

    public static class ButtonNumberPicker {
        public Integer default_value;
        public String title;
        public int min_value = 0;
        public int max_value = 100;
    }

    public static class ButtonPayment {
        public String button_payment_token;
        public boolean is_paid = false;
        public transient boolean isPaying = false;
    }

    public static class ButtonSMS {
        public String message;
        public String to_number;
    }

    public static class ButtonSelection {
        public String api_url;
        public int columns_count = 1;
        public BotButtonObject.BotButtonSelection.GetType get_type;
        public boolean is_multi_selection;
        public ArrayList<BotButtonObject.BotButtonSimpleObject> items;
        public BotButtonObject.BotButtonSelection.SearchType search_type;
        public String selection_id;
        public String title;

        public enum GetType {
            Local,
            Api
        }

        public enum SearchType {
            None,
            Local,
            Api
        }
    }

    public static class ButtonStringPicker {
        public String default_value;
        public String[] items;
        public String title;
    }

    public enum ButtonType {
        Simple,
        Selection,
        Calendar,
        NumberPicker,
        StringPicker,
        Payment,
        CameraImage,
        CameraVideo,
        GalleryImage,
        GalleryVideo,
        File,
        Audio,
        MyPhoneNumber,
        MyUsername,
        Alert,
        Textbox,
        Call,
        SMS,
        Link,
        Barcode,
        LocationPicker,
        Location,
        MyLocation,
        AskMyPhoneNumber,
        AskMyLocation,
        RecordAudio
    }
}
