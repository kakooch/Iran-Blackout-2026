package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import okhttp3.internal.http.StatusLine;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Hf0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C4939Hf0 {
    private static final int[][] b;
    private final C4705Gf0 a;

    static {
        int[] iArr = new int[30];
        // fill-array-data instruction
        iArr[0] = 419;
        iArr[1] = 418;
        iArr[2] = 425;
        iArr[3] = 424;
        iArr[4] = 431;
        iArr[5] = 430;
        iArr[6] = 107;
        iArr[7] = 106;
        iArr[8] = 59;
        iArr[9] = 58;
        iArr[10] = -3;
        iArr[11] = -3;
        iArr[12] = -3;
        iArr[13] = -3;
        iArr[14] = -3;
        iArr[15] = -3;
        iArr[16] = -3;
        iArr[17] = -3;
        iArr[18] = -3;
        iArr[19] = 23;
        iArr[20] = 89;
        iArr[21] = 88;
        iArr[22] = 437;
        iArr[23] = 436;
        iArr[24] = 443;
        iArr[25] = 442;
        iArr[26] = 449;
        iArr[27] = 448;
        iArr[28] = 836;
        iArr[29] = 835;
        b = new int[][]{new int[]{WKSRecord.Service.ERPC, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 127, 126, WKSRecord.Service.STATSRV, WKSRecord.Service.CISCO_SYS, WKSRecord.Service.NETBIOS_SSN, WKSRecord.Service.NETBIOS_DGM, SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, 151, 150, SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, 156, SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER, 168, 175, 174, SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER, 186, SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, WKSRecord.Service.EMFIS_CNTL, WKSRecord.Service.EMFIS_DATA, 147, SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER, 152, 159, 158, 165, SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER, 171, 170, SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER, 176, 183, 182, SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, WKSRecord.Service.BL_IDM, 149, 148, 155, 154, SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER, 160, 167, 166, 173, 172, SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER, 185, 184, SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, Type.DOA, Type.AVC, 253, 252, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER, SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER, 241, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER, SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER, 223, 222, 217, 216, 211, 210, SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, Type.AMTRELAY, 255, 254, 249, 248, WKSRecord.Service.SUR_MEAS, 242, 237, 236, 231, SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER, 225, 224, 219, 218, 213, 212, 207, SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, Type.CAA, 256, Type.IXFR, Type.TSIG, 245, SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER, SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER, 232, SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER, 226, 221, SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER, 215, SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, StatusLine.HTTP_TEMP_REDIRECT, 306, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, StatusLine.HTTP_PERM_REDIRECT, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, Type.EUI48, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, WKSRecord.Service.SUNRPC, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, StatusLine.HTTP_MISDIRECTED_REQUEST, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, iArr, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, SetRpcStruct$ComposedRpc.REMOVE_PIN_FIELD_NUMBER, SetRpcStruct$ComposedRpc.PIN_MESSAGE_FIELD_NUMBER, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, SIPTransactionStack.BASE_TIMER_INTERVAL, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, WKSRecord.Service.UUCP_PATH, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, SetRpcStruct$ComposedRpc.RESPONSE_GET_JWT_TOKEN_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, SetRpcStruct$ComposedRpc.GET_CAN_SEE_MESSAGES_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.GROUP_MESSAGE_PINNED_FIELD_NUMBER, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{SetRpcStruct$ComposedRpc.FETCH_GROUP_ADMINS_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SET_RESTRICTION_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.GROUP_RESTRICTION_CHANGED_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.GROUP_PIN_REMOVED_FIELD_NUMBER, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, SetRpcStruct$ComposedRpc.RESPONSE_FETCH_GROUP_ADMINS_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_CAN_SEE_MESSAGES_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SET_CAN_SEE_MESSAGES_FIELD_NUMBER, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    }

    C4939Hf0(C4705Gf0 c4705Gf0) {
        this.a = c4705Gf0;
    }

    byte[] a() {
        byte[] bArr = new byte[SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER];
        int i = this.a.i();
        int iM = this.a.m();
        for (int i2 = 0; i2 < i; i2++) {
            int[] iArr = b[i2];
            for (int i3 = 0; i3 < iM; i3++) {
                int i4 = iArr[i3];
                if (i4 >= 0 && this.a.e(i3, i2)) {
                    int i5 = i4 / 6;
                    bArr[i5] = (byte) (((byte) (1 << (5 - (i4 % 6)))) | bArr[i5]);
                }
            }
        }
        return bArr;
    }
}
