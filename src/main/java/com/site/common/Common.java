package com.site.common;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@Log4j2
public class Common {

    public static ThreadPoolExecutor executor;
    public static Map<String, String> countryDialCodeMap = new HashMap<>();

    static {
        countryDialCodeMap.put("AF", "+ 93");
        countryDialCodeMap.put("AX", "+ 358");
        countryDialCodeMap.put("AL", "+ 355");
        countryDialCodeMap.put("DZ", "+ 213");
        countryDialCodeMap.put("AS", "+ 1684");
        countryDialCodeMap.put("AD", "+ 376");
        countryDialCodeMap.put("AO", "+ 244");
        countryDialCodeMap.put("AI", "+ 1264");
        countryDialCodeMap.put("AQ", "+ 672");
        countryDialCodeMap.put("AG", "+ 1268");
        countryDialCodeMap.put("AR", "+ 54");
        countryDialCodeMap.put("AM", "+ 374");
        countryDialCodeMap.put("AW", "+ 297");
        countryDialCodeMap.put("AU", "+ 61");
        countryDialCodeMap.put("AT", "+ 43");
        countryDialCodeMap.put("AZ", "+ 994");
        countryDialCodeMap.put("BS", "+ 1242");
        countryDialCodeMap.put("BH", "+ 973");
        countryDialCodeMap.put("BD", "+ 880");
        countryDialCodeMap.put("BB", "+ 1246");
        countryDialCodeMap.put("BY", "+ 375");
        countryDialCodeMap.put("BE", "+ 32");
        countryDialCodeMap.put("BZ", "+ 501");
        countryDialCodeMap.put("BJ", "+ 229");
        countryDialCodeMap.put("BM", "+ 1441");
        countryDialCodeMap.put("BT", "+ 975");
        countryDialCodeMap.put("BO", "+ 591");
        countryDialCodeMap.put("BA", "+ 387");
        countryDialCodeMap.put("BW", "+ 267");
        countryDialCodeMap.put("BR", "+ 55");
        countryDialCodeMap.put("IO", "+ 246");
        countryDialCodeMap.put("BN", "+ 673");
        countryDialCodeMap.put("BG", "+ 359");
        countryDialCodeMap.put("BF", "+ 226");
        countryDialCodeMap.put("BI", "+ 257");
        countryDialCodeMap.put("KH", "+ 855");
        countryDialCodeMap.put("CM", "+ 237");
        countryDialCodeMap.put("CA", "+ 1");
        countryDialCodeMap.put("CV", "+ 238");
        countryDialCodeMap.put("KY", "+  345");
        countryDialCodeMap.put("CF", "+ 236");
        countryDialCodeMap.put("TD", "+ 235");
        countryDialCodeMap.put("CL", "+ 56");
        countryDialCodeMap.put("CN", "+ 86");
        countryDialCodeMap.put("CX", "+ 61");
        countryDialCodeMap.put("CC", "+ 61");
        countryDialCodeMap.put("CO", "+ 57");
        countryDialCodeMap.put("KM", "+ 269");
        countryDialCodeMap.put("CG", "+ 242");
        countryDialCodeMap.put("CD", "+ 243");
        countryDialCodeMap.put("CK", "+ 682");
        countryDialCodeMap.put("CR", "+ 506");
        countryDialCodeMap.put("CI", "+ 225");
        countryDialCodeMap.put("HR", "+ 385");
        countryDialCodeMap.put("CU", "+ 53");
        countryDialCodeMap.put("CY", "+ 357");
        countryDialCodeMap.put("CZ", "+ 420");
        countryDialCodeMap.put("DK", "+ 45");
        countryDialCodeMap.put("DJ", "+ 253");
        countryDialCodeMap.put("DM", "+ 1767");
        countryDialCodeMap.put("DO", "+ 1849");
        countryDialCodeMap.put("EC", "+ 593");
        countryDialCodeMap.put("EG", "+ 20");
        countryDialCodeMap.put("SV", "+ 503");
        countryDialCodeMap.put("GQ", "+ 240");
        countryDialCodeMap.put("ER", "+ 291");
        countryDialCodeMap.put("EE", "+ 372");
        countryDialCodeMap.put("ET", "+ 251");
        countryDialCodeMap.put("FK", "+ 500");
        countryDialCodeMap.put("FO", "+ 298");
        countryDialCodeMap.put("FJ", "+ 679");
        countryDialCodeMap.put("FI", "+ 358");
        countryDialCodeMap.put("FR", "+ 33");
        countryDialCodeMap.put("GF", "+ 594");
        countryDialCodeMap.put("PF", "+ 689");
        countryDialCodeMap.put("GA", "+ 241");
        countryDialCodeMap.put("GM", "+ 220");
        countryDialCodeMap.put("GE", "+ 995");
        countryDialCodeMap.put("DE", "+ 49");
        countryDialCodeMap.put("GH", "+ 233");
        countryDialCodeMap.put("GI", "+ 350");
        countryDialCodeMap.put("GR", "+ 30");
        countryDialCodeMap.put("GL", "+ 299");
        countryDialCodeMap.put("GD", "+ 1473");
        countryDialCodeMap.put("GP", "+ 590");
        countryDialCodeMap.put("GU", "+ 1671");
        countryDialCodeMap.put("GT", "+ 502");
        countryDialCodeMap.put("GG", "+ 44");
        countryDialCodeMap.put("GN", "+ 224");
        countryDialCodeMap.put("GW", "+ 245");
        countryDialCodeMap.put("GY", "+ 595");
        countryDialCodeMap.put("HT", "+ 509");
        countryDialCodeMap.put("VA", "+ 379");
        countryDialCodeMap.put("HN", "+ 504");
        countryDialCodeMap.put("HK", "+ 852");
        countryDialCodeMap.put("HU", "+ 36");
        countryDialCodeMap.put("IS", "+ 354");
        countryDialCodeMap.put("IN", "+ 91");
        countryDialCodeMap.put("ID", "+ 62");
        countryDialCodeMap.put("IR", "+ 98");
        countryDialCodeMap.put("IQ", "+ 964");
        countryDialCodeMap.put("IE", "+ 353");
        countryDialCodeMap.put("IM", "+ 44");
        countryDialCodeMap.put("IL", "+ 972");
        countryDialCodeMap.put("IT", "+ 39");
        countryDialCodeMap.put("JM", "+ 1876");
        countryDialCodeMap.put("JP", "+ 81");
        countryDialCodeMap.put("JE", "+ 44");
        countryDialCodeMap.put("JO", "+ 962");
        countryDialCodeMap.put("KZ", "+ 77");
        countryDialCodeMap.put("KE", "+ 254");
        countryDialCodeMap.put("KI", "+ 686");
        countryDialCodeMap.put("KP", "+ 850");
        countryDialCodeMap.put("KR", "+ 82");
        countryDialCodeMap.put("KW", "+ 965");
        countryDialCodeMap.put("KG", "+ 996");
        countryDialCodeMap.put("LA", "+ 856");
        countryDialCodeMap.put("LV", "+ 371");
        countryDialCodeMap.put("LB", "+ 961");
        countryDialCodeMap.put("LS", "+ 266");
        countryDialCodeMap.put("LR", "+ 231");
        countryDialCodeMap.put("LY", "+ 218");
        countryDialCodeMap.put("LI", "+ 423");
        countryDialCodeMap.put("LT", "+ 370");
        countryDialCodeMap.put("LU", "+ 352");
        countryDialCodeMap.put("MO", "+ 853");
        countryDialCodeMap.put("MK", "+ 389");
        countryDialCodeMap.put("MG", "+ 261");
        countryDialCodeMap.put("MW", "+ 265");
        countryDialCodeMap.put("MY", "+ 60");
        countryDialCodeMap.put("MV", "+ 960");
        countryDialCodeMap.put("ML", "+ 223");
        countryDialCodeMap.put("MT", "+ 356");
        countryDialCodeMap.put("MH", "+ 692");
        countryDialCodeMap.put("MQ", "+ 596");
        countryDialCodeMap.put("MR", "+ 222");
        countryDialCodeMap.put("MU", "+ 230");
        countryDialCodeMap.put("YT", "+ 262");
        countryDialCodeMap.put("MX", "+ 52");
        countryDialCodeMap.put("FM", "+ 691");
        countryDialCodeMap.put("MD", "+ 373");
        countryDialCodeMap.put("MC", "+ 377");
        countryDialCodeMap.put("MN", "+ 976");
        countryDialCodeMap.put("ME", "+ 382");
        countryDialCodeMap.put("MS", "+ 1664");
        countryDialCodeMap.put("MA", "+ 212");
        countryDialCodeMap.put("MZ", "+ 258");
        countryDialCodeMap.put("MM", "+ 95");
        countryDialCodeMap.put("NA", "+ 264");
        countryDialCodeMap.put("NR", "+ 674");
        countryDialCodeMap.put("NP", "+ 977");
        countryDialCodeMap.put("NL", "+ 31");
        countryDialCodeMap.put("AN", "+ 599");
        countryDialCodeMap.put("NC", "+ 687");
        countryDialCodeMap.put("NZ", "+ 64");
        countryDialCodeMap.put("NI", "+ 505");
        countryDialCodeMap.put("NE", "+ 227");
        countryDialCodeMap.put("NG", "+ 234");
        countryDialCodeMap.put("NU", "+ 683");
        countryDialCodeMap.put("NF", "+ 672");
        countryDialCodeMap.put("MP", "+ 1670");
        countryDialCodeMap.put("NO", "+ 47");
        countryDialCodeMap.put("OM", "+ 968");
        countryDialCodeMap.put("PK", "+ 92");
        countryDialCodeMap.put("PW", "+ 680");
        countryDialCodeMap.put("PS", "+ 970");
        countryDialCodeMap.put("PA", "+ 507");
        countryDialCodeMap.put("PG", "+ 675");
        countryDialCodeMap.put("PY", "+ 595");
        countryDialCodeMap.put("PE", "+ 51");
        countryDialCodeMap.put("PH", "+ 63");
        countryDialCodeMap.put("PN", "+ 872");
        countryDialCodeMap.put("PL", "+ 48");
        countryDialCodeMap.put("PT", "+ 351");
        countryDialCodeMap.put("PR", "+ 1939");
        countryDialCodeMap.put("QA", "+ 974");
        countryDialCodeMap.put("RO", "+ 40");
        countryDialCodeMap.put("RU", "+ 7");
        countryDialCodeMap.put("RW", "+ 250");
        countryDialCodeMap.put("RE", "+ 262");
        countryDialCodeMap.put("BL", "+ 590");
        countryDialCodeMap.put("SH", "+ 290");
        countryDialCodeMap.put("KN", "+ 1869");
        countryDialCodeMap.put("LC", "+ 1758");
        countryDialCodeMap.put("MF", "+ 590");
        countryDialCodeMap.put("PM", "+ 508");
        countryDialCodeMap.put("VC", "+ 1784");
        countryDialCodeMap.put("WS", "+ 685");
        countryDialCodeMap.put("SM", "+ 378");
        countryDialCodeMap.put("ST", "+ 239");
        countryDialCodeMap.put("SA", "+ 966");
        countryDialCodeMap.put("SN", "+ 221");
        countryDialCodeMap.put("RS", "+ 381");
        countryDialCodeMap.put("SC", "+ 248");
        countryDialCodeMap.put("SL", "+ 232");
        countryDialCodeMap.put("SG", "+ 65");
        countryDialCodeMap.put("SK", "+ 421");
        countryDialCodeMap.put("SI", "+ 386");
        countryDialCodeMap.put("SB", "+ 677");
        countryDialCodeMap.put("SO", "+ 252");
        countryDialCodeMap.put("ZA", "+ 27");
        countryDialCodeMap.put("SS", "+ 211");
        countryDialCodeMap.put("GS", "+ 500");
        countryDialCodeMap.put("ES", "+ 34");
        countryDialCodeMap.put("LK", "+ 94");
        countryDialCodeMap.put("SD", "+ 249");
        countryDialCodeMap.put("SR", "+ 597");
        countryDialCodeMap.put("SJ", "+ 47");
        countryDialCodeMap.put("SZ", "+ 268");
        countryDialCodeMap.put("SE", "+ 46");
        countryDialCodeMap.put("CH", "+ 41");
        countryDialCodeMap.put("SY", "+ 963");
        countryDialCodeMap.put("TW", "+ 886");
        countryDialCodeMap.put("TJ", "+ 992");
        countryDialCodeMap.put("TZ", "+ 255");
        countryDialCodeMap.put("TH", "+ 66");
        countryDialCodeMap.put("TL", "+ 670");
        countryDialCodeMap.put("TG", "+ 228");
        countryDialCodeMap.put("TK", "+ 690");
        countryDialCodeMap.put("TO", "+ 676");
        countryDialCodeMap.put("TT", "+ 1868");
        countryDialCodeMap.put("TN", "+ 216");
        countryDialCodeMap.put("TR", "+ 90");
        countryDialCodeMap.put("TM", "+ 993");
        countryDialCodeMap.put("TC", "+ 1649");
        countryDialCodeMap.put("TV", "+ 688");
        countryDialCodeMap.put("UG", "+ 256");
        countryDialCodeMap.put("UA", "+ 380");
        countryDialCodeMap.put("AE", "+ 971");
        countryDialCodeMap.put("GB", "+ 44");
        countryDialCodeMap.put("US", "+ 1");
        countryDialCodeMap.put("UY", "+ 598");
        countryDialCodeMap.put("UZ", "+ 998");
        countryDialCodeMap.put("VU", "+ 678");
        countryDialCodeMap.put("VE", "+ 58");
        countryDialCodeMap.put("VN", "+ 84");
        countryDialCodeMap.put("VG", "+ 1284");
        countryDialCodeMap.put("VI", "+ 1340");
        countryDialCodeMap.put("WF", "+ 681");
        countryDialCodeMap.put("YE", "+ 967");
        countryDialCodeMap.put("ZM", "+ 260");
        countryDialCodeMap.put("ZW", "+ 263");
    }
}
