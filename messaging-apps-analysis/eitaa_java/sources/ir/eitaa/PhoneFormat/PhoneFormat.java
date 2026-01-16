package ir.eitaa.PhoneFormat;

import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class PhoneFormat {
    private static volatile PhoneFormat Instance;
    public ByteBuffer buffer;
    public HashMap<String, ArrayList<String>> callingCodeCountries;
    public HashMap<String, CallingCodeInfo> callingCodeData;
    public HashMap<String, Integer> callingCodeOffsets;
    public HashMap<String, String> countryCallingCode;
    public byte[] data;
    public String defaultCallingCode;
    public String defaultCountry;
    private boolean initialzed = false;

    public static PhoneFormat getInstance() {
        PhoneFormat phoneFormat = Instance;
        if (phoneFormat == null) {
            synchronized (PhoneFormat.class) {
                phoneFormat = Instance;
                if (phoneFormat == null) {
                    phoneFormat = new PhoneFormat();
                    Instance = phoneFormat;
                }
            }
        }
        return phoneFormat;
    }

    public static String strip(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int length = sb.length() - 1; length >= 0; length--) {
            if (!"0123456789+*#".contains(sb.substring(length, length + 1))) {
                sb.deleteCharAt(length);
            }
        }
        return sb.toString();
    }

    public static String stripExceptNumbers(String str, boolean includePlus) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        String str2 = includePlus ? "0123456789+" : "0123456789";
        for (int length = sb.length() - 1; length >= 0; length--) {
            if (!str2.contains(sb.substring(length, length + 1))) {
                sb.deleteCharAt(length);
            }
        }
        return sb.toString();
    }

    public static String stripExceptNumbers(String str) {
        return stripExceptNumbers(str, false);
    }

    public PhoneFormat() throws Throwable {
        init(null);
    }

    public void init(String countryCode) throws Throwable {
        InputStream inputStreamOpen;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStreamOpen = ApplicationLoader.applicationContext.getAssets().open("PhoneFormats.dat");
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpen = null;
        }
        try {
            byte[] bArr = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
            while (true) {
                int i = inputStreamOpen.read(bArr, 0, Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV);
                if (i == -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.data = byteArray;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArray);
            this.buffer = byteBufferWrap;
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            try {
                byteArrayOutputStream.close();
            } catch (Exception e3) {
                FileLog.e(e3);
            }
            try {
                inputStreamOpen.close();
            } catch (Exception e4) {
                FileLog.e(e4);
            }
            if (countryCode != null && countryCode.length() != 0) {
                this.defaultCountry = countryCode;
            } else {
                this.defaultCountry = Locale.getDefault().getCountry().toLowerCase();
            }
            this.callingCodeOffsets = new HashMap<>(255);
            this.callingCodeCountries = new HashMap<>(255);
            this.callingCodeData = new HashMap<>(10);
            this.countryCallingCode = new HashMap<>(255);
            parseDataHeader();
            this.initialzed = true;
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream2 = byteArrayOutputStream;
            e.printStackTrace();
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception e6) {
                    FileLog.e(e6);
                }
            }
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Exception e7) {
                    FileLog.e(e7);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception e8) {
                    FileLog.e(e8);
                }
            }
            if (inputStreamOpen == null) {
                throw th;
            }
            try {
                inputStreamOpen.close();
                throw th;
            } catch (Exception e9) {
                FileLog.e(e9);
                throw th;
            }
        }
    }

    public CallingCodeInfo findCallingCodeInfo(String str) {
        CallingCodeInfo callingCodeInfo = null;
        int i = 0;
        while (i < 3 && i < str.length()) {
            i++;
            callingCodeInfo = callingCodeInfo(str.substring(0, i));
            if (callingCodeInfo != null) {
                break;
            }
        }
        return callingCodeInfo;
    }

    public String format(String orig) {
        if (!this.initialzed) {
            return orig;
        }
        try {
            String strStrip = strip(orig);
            if (strStrip.startsWith("+")) {
                String strSubstring = strStrip.substring(1);
                CallingCodeInfo callingCodeInfoFindCallingCodeInfo = findCallingCodeInfo(strSubstring);
                if (callingCodeInfoFindCallingCodeInfo == null) {
                    return orig;
                }
                return "+" + callingCodeInfoFindCallingCodeInfo.format(strSubstring);
            }
            CallingCodeInfo callingCodeInfo = callingCodeInfo(this.defaultCallingCode);
            if (callingCodeInfo == null) {
                return orig;
            }
            String strMatchingAccessCode = callingCodeInfo.matchingAccessCode(strStrip);
            if (strMatchingAccessCode != null) {
                String strSubstring2 = strStrip.substring(strMatchingAccessCode.length());
                CallingCodeInfo callingCodeInfoFindCallingCodeInfo2 = findCallingCodeInfo(strSubstring2);
                if (callingCodeInfoFindCallingCodeInfo2 != null) {
                    strSubstring2 = callingCodeInfoFindCallingCodeInfo2.format(strSubstring2);
                }
                return strSubstring2.length() == 0 ? strMatchingAccessCode : String.format("%s %s", strMatchingAccessCode, strSubstring2);
            }
            return callingCodeInfo.format(strStrip);
        } catch (Exception e) {
            FileLog.e(e);
            return orig;
        }
    }

    int value32(int offset) {
        if (offset + 4 > this.data.length) {
            return 0;
        }
        this.buffer.position(offset);
        return this.buffer.getInt();
    }

    short value16(int offset) {
        if (offset + 2 > this.data.length) {
            return (short) 0;
        }
        this.buffer.position(offset);
        return this.buffer.getShort();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        return new java.lang.String(r4.data, r5, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
    
        r1 = r1 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
    
        if (r5 != r1) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
    
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String valueString(int r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r1 = r5
        L3:
            byte[] r2 = r4.data     // Catch: java.lang.Exception -> L1c
            int r3 = r2.length     // Catch: java.lang.Exception -> L1c
            if (r1 >= r3) goto L1b
            r2 = r2[r1]     // Catch: java.lang.Exception -> L1c
            if (r2 != 0) goto L18
            int r1 = r1 - r5
            if (r5 != r1) goto L10
            return r0
        L10:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> L1c
            byte[] r3 = r4.data     // Catch: java.lang.Exception -> L1c
            r2.<init>(r3, r5, r1)     // Catch: java.lang.Exception -> L1c
            return r2
        L18:
            int r1 = r1 + 1
            goto L3
        L1b:
            return r0
        L1c:
            r5 = move-exception
            r5.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.PhoneFormat.PhoneFormat.valueString(int):java.lang.String");
    }

    public CallingCodeInfo callingCodeInfo(String callingCode) {
        Integer num;
        byte[] bArr;
        int i;
        boolean z;
        PhoneFormat phoneFormat = this;
        CallingCodeInfo callingCodeInfo = phoneFormat.callingCodeData.get(callingCode);
        if (callingCodeInfo != null || (num = phoneFormat.callingCodeOffsets.get(callingCode)) == null) {
            return callingCodeInfo;
        }
        byte[] bArr2 = phoneFormat.data;
        int iIntValue = num.intValue();
        CallingCodeInfo callingCodeInfo2 = new CallingCodeInfo();
        callingCodeInfo2.callingCode = callingCode;
        callingCodeInfo2.countries = phoneFormat.callingCodeCountries.get(callingCode);
        phoneFormat.callingCodeData.put(callingCode, callingCodeInfo2);
        short sValue16 = phoneFormat.value16(iIntValue);
        int i2 = 2;
        int i3 = iIntValue + 2 + 2;
        short sValue162 = phoneFormat.value16(i3);
        int i4 = i3 + 2 + 2;
        short sValue163 = phoneFormat.value16(i4);
        int length = i4 + 2 + 2;
        ArrayList<String> arrayList = new ArrayList<>(5);
        while (true) {
            String strValueString = phoneFormat.valueString(length);
            if (strValueString.length() == 0) {
                break;
            }
            arrayList.add(strValueString);
            length += strValueString.length() + 1;
        }
        callingCodeInfo2.trunkPrefixes = arrayList;
        int length2 = length + 1;
        ArrayList<String> arrayList2 = new ArrayList<>(5);
        while (true) {
            String strValueString2 = phoneFormat.valueString(length2);
            if (strValueString2.length() == 0) {
                break;
            }
            arrayList2.add(strValueString2);
            length2 += strValueString2.length() + 1;
        }
        callingCodeInfo2.intlPrefixes = arrayList2;
        ArrayList<RuleSet> arrayList3 = new ArrayList<>(sValue163);
        int i5 = iIntValue + sValue16;
        int i6 = i5;
        int i7 = 0;
        while (i7 < sValue163) {
            RuleSet ruleSet = new RuleSet();
            ruleSet.matchLen = phoneFormat.value16(i6);
            int i8 = i6 + i2;
            short sValue164 = phoneFormat.value16(i8);
            i6 = i8 + i2;
            ArrayList<PhoneRule> arrayList4 = new ArrayList<>(sValue164);
            int i9 = 0;
            while (i9 < sValue164) {
                PhoneRule phoneRule = new PhoneRule();
                phoneRule.minVal = phoneFormat.value32(i6);
                int i10 = i6 + 4;
                phoneRule.maxVal = phoneFormat.value32(i10);
                int i11 = i10 + 4;
                int i12 = i11 + 1;
                phoneRule.byte8 = bArr2[i11];
                int i13 = i12 + 1;
                phoneRule.maxLen = bArr2[i12];
                int i14 = i13 + 1;
                phoneRule.otherFlag = bArr2[i13];
                int i15 = i14 + 1;
                phoneRule.prefixLen = bArr2[i14];
                int i16 = i15 + 1;
                phoneRule.flag12 = bArr2[i15];
                int i17 = i16 + 1;
                phoneRule.flag13 = bArr2[i16];
                short sValue165 = phoneFormat.value16(i17);
                i6 = i17 + i2;
                String strValueString3 = phoneFormat.valueString(i5 + sValue162 + sValue165);
                phoneRule.format = strValueString3;
                int iIndexOf = strValueString3.indexOf("[[");
                if (iIndexOf != -1) {
                    bArr = bArr2;
                    i = i5;
                    i2 = 2;
                    z = true;
                    phoneRule.format = String.format("%s%s", phoneRule.format.substring(0, iIndexOf), phoneRule.format.substring(phoneRule.format.indexOf("]]") + 2));
                } else {
                    bArr = bArr2;
                    i = i5;
                    z = true;
                    i2 = 2;
                }
                arrayList4.add(phoneRule);
                if (phoneRule.hasIntlPrefix) {
                    ruleSet.hasRuleWithIntlPrefix = z;
                }
                if (phoneRule.hasTrunkPrefix) {
                    ruleSet.hasRuleWithTrunkPrefix = z;
                }
                i9++;
                phoneFormat = this;
                bArr2 = bArr;
                i5 = i;
            }
            ruleSet.rules = arrayList4;
            arrayList3.add(ruleSet);
            i7++;
            phoneFormat = this;
            i5 = i5;
        }
        callingCodeInfo2.ruleSets = arrayList3;
        return callingCodeInfo2;
    }

    public void parseDataHeader() {
        int iValue32 = value32(0);
        int i = (iValue32 * 12) + 4;
        int i2 = 4;
        for (int i3 = 0; i3 < iValue32; i3++) {
            String strValueString = valueString(i2);
            int i4 = i2 + 4;
            String strValueString2 = valueString(i4);
            int i5 = i4 + 4;
            int iValue322 = value32(i5) + i;
            i2 = i5 + 4;
            if (strValueString2.equals(this.defaultCountry)) {
                this.defaultCallingCode = strValueString;
            }
            this.countryCallingCode.put(strValueString2, strValueString);
            this.callingCodeOffsets.put(strValueString, Integer.valueOf(iValue322));
            ArrayList<String> arrayList = this.callingCodeCountries.get(strValueString);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.callingCodeCountries.put(strValueString, arrayList);
            }
            arrayList.add(strValueString2);
        }
        String str = this.defaultCallingCode;
        if (str != null) {
            callingCodeInfo(str);
        }
    }
}
