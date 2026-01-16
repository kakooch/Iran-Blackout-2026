package com.google.android.exoplayer2.metadata.id3;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C2020b0;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();
    public final String b;
    public final String c;
    public final AbstractC12710f43 d;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame[] newArray(int i) {
            return new TextInformationFrame[i];
        }
    }

    /* synthetic */ TextInformationFrame(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static List a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void R0(C2020b0.b bVar) throws NumberFormatException {
        String str = this.a;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c = 11;
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c = '\f';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c = '\r';
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c = 14;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c = 15;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 16;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = 17;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = 18;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c = 19;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = 20;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 21;
                    break;
                }
                break;
        }
        try {
            switch (c) {
                case 0:
                case '\n':
                    bVar.N((CharSequence) this.d.get(0));
                    break;
                case 1:
                case 11:
                    bVar.S((CharSequence) this.d.get(0));
                    break;
                case 2:
                case '\f':
                    String str2 = (String) this.d.get(0);
                    bVar.f0(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).e0(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    bVar.O((CharSequence) this.d.get(0));
                    break;
                case 4:
                case 18:
                    bVar.M((CharSequence) this.d.get(0));
                    break;
                case 5:
                case 19:
                    bVar.T((CharSequence) this.d.get(0));
                    break;
                case 6:
                case 20:
                    String[] strArrR0 = AbstractC9683aN7.R0((String) this.d.get(0), Separators.SLASH);
                    bVar.p0(Integer.valueOf(Integer.parseInt(strArrR0[0]))).o0(strArrR0.length > 1 ? Integer.valueOf(Integer.parseInt(strArrR0[1])) : null);
                    break;
                case 7:
                case 16:
                    bVar.m0((CharSequence) this.d.get(0));
                    break;
                case '\b':
                case 15:
                    bVar.r0((CharSequence) this.d.get(0));
                    break;
                case '\t':
                case 21:
                    bVar.g0(Integer.valueOf(Integer.parseInt((String) this.d.get(0))));
                    break;
                case '\r':
                    List listA = a((String) this.d.get(0));
                    int size = listA.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.e0((Integer) listA.get(2));
                            }
                        }
                        bVar.f0((Integer) listA.get(1));
                    }
                    bVar.g0((Integer) listA.get(0));
                    break;
                case 14:
                    List listA2 = a((String) this.d.get(0));
                    int size2 = listA2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.h0((Integer) listA2.get(2));
                            }
                        }
                        bVar.i0((Integer) listA2.get(1));
                    }
                    bVar.j0((Integer) listA2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return AbstractC9683aN7.c(this.a, textInformationFrame.a) && AbstractC9683aN7.c(this.b, textInformationFrame.b) && this.d.equals(textInformationFrame.d);
    }

    public int hashCode() {
        int iHashCode = (527 + this.a.hashCode()) * 31;
        String str = this.b;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.d.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.a + ": description=" + this.b + ": values=" + this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeStringArray((String[]) this.d.toArray(new String[0]));
    }

    public TextInformationFrame(String str, String str2, List list) {
        super(str);
        AbstractC20011rK.a(!list.isEmpty());
        this.b = str2;
        AbstractC12710f43 abstractC12710f43O = AbstractC12710f43.O(list);
        this.d = abstractC12710f43O;
        this.c = (String) abstractC12710f43O.get(0);
    }

    private TextInformationFrame(Parcel parcel) {
        this((String) AbstractC20011rK.e(parcel.readString()), parcel.readString(), AbstractC12710f43.P((String[]) AbstractC20011rK.e(parcel.createStringArray())));
    }
}
