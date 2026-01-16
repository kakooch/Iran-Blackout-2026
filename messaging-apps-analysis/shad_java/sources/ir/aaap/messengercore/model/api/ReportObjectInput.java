package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class ReportObjectInput {
    public String live_id;
    public String message_id;
    public String object_guid;
    public String report_description;
    public int report_type;
    public ReportType report_type_object;

    public enum ReportType {
        Object,
        Message,
        Live
    }

    public enum ReportTypeEnum {
        Other(100),
        Violence(101),
        Spam(102),
        Porn(103),
        ChildAbuse(104),
        Copyright(105),
        Fraud(106);

        public int value;

        ReportTypeEnum(int i) {
            this.value = i;
        }

        public static ReportTypeEnum getType(int i) {
            ReportTypeEnum reportTypeEnum = Other;
            if (i == reportTypeEnum.value) {
                return reportTypeEnum;
            }
            ReportTypeEnum reportTypeEnum2 = Violence;
            if (i == reportTypeEnum2.value) {
                return reportTypeEnum2;
            }
            ReportTypeEnum reportTypeEnum3 = Spam;
            if (i == reportTypeEnum3.value) {
                return reportTypeEnum3;
            }
            ReportTypeEnum reportTypeEnum4 = Porn;
            if (i == reportTypeEnum4.value) {
                return reportTypeEnum4;
            }
            ReportTypeEnum reportTypeEnum5 = ChildAbuse;
            if (i == reportTypeEnum5.value) {
                return reportTypeEnum5;
            }
            ReportTypeEnum reportTypeEnum6 = Copyright;
            if (i == reportTypeEnum6.value) {
                return reportTypeEnum6;
            }
            ReportTypeEnum reportTypeEnum7 = Fraud;
            if (i == reportTypeEnum7.value) {
                return reportTypeEnum7;
            }
            return null;
        }
    }
}
