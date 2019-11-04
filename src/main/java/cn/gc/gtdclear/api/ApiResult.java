package cn.gc.gtdclear.api;

/**
 * Created by 宫成 on 2019/1/25.
 */
public class ApiResult {
    private Integer rs;
    private String rsdesp;
    private Object resultMessage;

    public Integer getRs() {
        return rs;
    }

    public void setRs(Integer rs) {
        this.rs = rs;
    }

    public String getRsdesp() {
        return rsdesp;
    }

    public void setRsdesp(String rsdesp) {
        this.rsdesp = rsdesp;
    }

    public Object getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(Object resultMessage) {
        this.resultMessage = resultMessage;
    }
}
