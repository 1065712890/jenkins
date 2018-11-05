package util;

public class Result {
    private int code;
    private Object res;

    public Result(){

    }

    public Result(int code, Object res) {
        this.code = code;
        this.res = res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }

}
