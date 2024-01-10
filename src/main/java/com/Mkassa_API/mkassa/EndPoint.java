package com.Mkassa_API.mkassa;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class EndPoint {
    public static final String API = "api";
    public static final String USERS = "users";
    public static final String SEND_CODE = "send_code/";
    public static final String CHECK_CODE = "check_code/";
    public static final String LOGIN = "login/";
    public static final String ME = "me/";
    public static final String START_WORK = "start_work/";
    public static final String END_WORK = "end_work/";
    public static final String QR_PAYMENTS = "qr_payments";
    public static final String INIT_PAYMENT = "init_payment/";
    public static final String STATIC = "static/";
    public static final String KKM_START_WORK = "kkm_start_work/";
    public static final String KKM_END_WORK = "kkm_end_work/";
    public static final String KKM = "kkm";
    public static final String SHIFTS = "shifts/";
    public static final String ARM = "arm";
    public static final String V1 = "v1";
    public static final String TRANSACTIONS = "transactions/";
    public static final String TRANSACTION = "transaction";
    public static final String MAIN_PAGE = "main_page/";
    public static final String CASHIERS = "cashiers/";
    public static final String LOCALITY = "locality/";
    public static final String COMPANY_BRANCH = "companyBranch";
    public static final String BRANCHES = "branches/";
    public static final String WITHDRAW = "withdraw";
    public static final String LAST_WITHDRAW = "last_withdraw/";
    public static final String V2_STATEMENT = "v2_statement";
    public static final String RKO_ACCOUNT_INFO = "RkoAccountInfo";
    public static final String SUPERVISORS  = "supervisors/";
    public static final String SHIFT_BRANCHES = "shift_branches/";
    public static final String MY_BRANCHES = "my_branches";
    public static final String CHECK_WORK = "check_work/";
    public static final String COMPANIES = "companies";
    public static final String GET_OPERATIONS_SETTINGS = "get_operations_settings/";
    public static final String FCM_TOKENS = "fcm-tokens/";

    public static Map<String, String> BASE_HEADERS = new HashMap<>(){{
        put("accept", "application/json");
        put("Content-Type", "application/json");
        put("Connection", "keep-alive");
    }};
}
