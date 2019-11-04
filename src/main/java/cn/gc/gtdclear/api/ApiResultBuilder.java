package cn.gc.gtdclear.api;

/**
 * Created by 宫成 on 2019/1/25.
 */
public class ApiResultBuilder {
    private static ApiResultBuilder instance;

    public static ApiResultBuilder getInstance() {
        if (instance == null) {
            instance = new ApiResultBuilder();
        }
        return instance;
    }

    private ApiResultBuilder() {
    }

    public ApiResult ok(Object resultMessage) {
        ApiResult api = new ApiResult();
        api.setRs(1);
        api.setResultMessage(resultMessage);
        return api;
    }

    public ApiResult ok(String rsdesp) {
        ApiResult api = new ApiResult();
        api.setRs(1);
        api.setRsdesp(rsdesp);
        return api;
    } public ApiResult ok(String rsdesp,Object resultMessage) {
        ApiResult api = new ApiResult();
        api.setRs(1);
        api.setRsdesp(rsdesp);
        api.setResultMessage(resultMessage);
        return api;
    }

    public ApiResult failed(String rsdesp) {
        ApiResult api = new ApiResult();
        api.setRs(0);
        api.setRsdesp(rsdesp);
        return api;
    }
}
